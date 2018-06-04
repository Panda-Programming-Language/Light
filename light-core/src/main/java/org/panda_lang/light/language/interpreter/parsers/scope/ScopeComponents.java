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

package org.panda_lang.light.language.interpreter.parsers.scope;

import org.panda_lang.panda.framework.design.architecture.statement.*;
import org.panda_lang.panda.framework.design.interpreter.parser.component.*;
import org.panda_lang.panda.framework.design.interpreter.token.*;

public class ScopeComponents {

    public static final Component<TokenizedSource> DECLARATION = Component.of("light-scope-declaration", TokenizedSource.class);

    public static final Component<TokenizedSource> CONTENT = Component.of("light-scope-content", TokenizedSource.class);

    public static final Component<Scope> SCOPE = Component.of("light-scope", Scope.class);

}