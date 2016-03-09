package org.panda_lang.light.core.parser;

import org.panda_lang.light.Light;
import org.panda_lang.light.LightScript;
import org.panda_lang.light.core.Ray;
import org.panda_lang.light.core.element.expression.*;
import org.panda_lang.panda.core.parser.Atom;
import org.panda_lang.panda.core.parser.Parser;
import org.panda_lang.panda.core.parser.essential.EssenceParser;
import org.panda_lang.panda.core.parser.essential.RuntimeParser;
import org.panda_lang.panda.core.parser.util.match.hollow.HollowPattern;
import org.panda_lang.panda.core.syntax.Essence;
import org.panda_lang.panda.core.syntax.Factor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ExpressionParser implements Parser {

    public final Light light;

    public ExpressionParser(Light light) {
        this.light = light;
    }

    @Override
    public ExpressionRuntime parse(Atom atom) {
        String expressionSource = atom.getSourceCode().trim();
        ExpressionCenter expressionCenter = light.getLightCore().getExpressionCenter();

        for (final ExpressionRepresentation expressionRepresentation : expressionCenter.getElements()) {
            for (HollowPattern pattern : expressionRepresentation.getPatterns()) {
                if (pattern.match(expressionSource)) {
                    final Collection<String> hollows = new ArrayList<>(pattern.getHollows());
                    final List<ExpressionRuntime> expressions = parse(atom, hollows);
                    final Factor[] factors = ExpressionUtils.toFactors(expressions);

                    final Expression expression = expressionRepresentation.getExpression();
                    final Ray ray = new Ray()
                            .lightScript((LightScript) atom.getPandaScript())
                            .pattern(pattern)
                            .expressionRuntimes(expressions)
                            .factors(factors);

                    return new ExpressionRuntime(expression, ray);
                }
            }
        }

        for (ExpressionRepresentation expressionRepresentation : expressionCenter.getInitializables()) {
            ExpressionInitializer initializer = expressionRepresentation.getExpressionInitializer();
            if (initializer.match(expressionSource)) {
                return initializer.initialize(atom);
            }
        }

        TypeParser typeParser = new TypeParser();
        Factor factor = typeParser.parse(atom, expressionSource);

        if (factor != null) {
            return new ExpressionRuntime(factor);
        }

        EssenceParser essenceParser = new EssenceParser();
        Essence essence = essenceParser.parse(atom);

        if (essence != null) {
            factor = new Factor(essence);
            return new ExpressionRuntime(factor);
        }

        RuntimeParser runtimeParser = new RuntimeParser();
        factor = runtimeParser.parse(atom);

        // todo: argument

        return new ExpressionRuntime(factor);
    }

    public ExpressionRuntime parse(Atom atom, String expression) {
        atom.setSourceCode(expression);
        return parse(atom);
    }

    public List<ExpressionRuntime> parse(Atom atom, Collection<String> expressions) {
        List<ExpressionRuntime> executables = new ArrayList<>(expressions.size());
        for (String expression : expressions) {
            ExpressionRuntime namedExecutable = parse(atom, expression);
            executables.add(namedExecutable);
        }
        return executables;
    }


}
