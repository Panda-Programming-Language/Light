/*
 * Copyright (c) 2015-2018 Dzikoysk
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

package org.panda_lang.light.language.interpreter.tokens;

import org.panda_lang.panda.framework.design.interpreter.lexer.Syntax;
import org.panda_lang.panda.framework.design.interpreter.token.defaults.*;

import java.util.List;

public class LightSyntax implements Syntax {

    @Override
    public char[] getSpecialCharacters() {
        return new char[0];
    }

    @Override
    public List<Sequence> getSequences() {
        return null;
    }

    @Override
    public List<Operator> getOperators() {
        return null;
    }

    @Override
    public List<Separator> getSeparators() {
        return null;
    }

    @Override
    public List<Literal> getLiterals() {
        return null;
    }

    @Override
    public List<Keyword> getKeywords() {
        return null;
    }

}
