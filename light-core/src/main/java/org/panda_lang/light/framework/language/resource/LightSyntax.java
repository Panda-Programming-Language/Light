/*
 * Copyright (c) 2016-2018 Dzikoysk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.panda_lang.light.framework.language.resource;

import org.panda_lang.panda.framework.design.resource.Syntax;
import org.panda_lang.panda.framework.language.resource.syntax.keyword.Keyword;
import org.panda_lang.panda.framework.language.resource.syntax.literal.Literal;
import org.panda_lang.panda.framework.language.resource.syntax.operator.Operator;
import org.panda_lang.panda.framework.language.resource.syntax.separator.Separator;
import org.panda_lang.panda.framework.language.resource.syntax.sequence.Sequence;

import java.util.List;

public class LightSyntax implements Syntax {

    @Override
    public char[] getSpecialCharacters() {
        return new char[0];
    }

    @Override
    public List<Sequence> getSequences() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public List<Operator> getOperators() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public List<Separator> getSeparators() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public List<Literal> getLiterals() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public List<Keyword> getKeywords() {
        throw new RuntimeException("Not implemented");
    }

}
