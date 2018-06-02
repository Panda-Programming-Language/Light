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

package org.panda_lang.light.flexible;

import org.junit.jupiter.api.*;
import org.panda_lang.light.design.interpreter.token.*;
import org.panda_lang.light.design.interpreter.token.flexible.*;
import org.panda_lang.light.design.interpreter.token.flexible.tree.*;
import org.panda_lang.panda.framework.design.architecture.dynamic.*;

public class FlexibleModelTest {

    // send [message] %string% to (terminal|console)

    @Test
    public void testModel() {
        FlexibleModel model = FlexibleModel.builder()
                .compose()
                    .basic("send ")
                    .optional()
                        .basic("message ")
                        .apply()
                    .expression(String.class)
                    .basic(" to ")
                    .variant()
                        .option()
                            .basic("terminal")
                            .apply()
                        .basic("console")
                        .apply()
                    .finish()
                .createModel();

        FlexibleTree tree = new FlexibleTree();
        tree.merge(model);

        Phrase phrase = new Phrase("send 'Flexible Model Test' to console");
        Executable statement = tree.find(phrase);
    }

}
