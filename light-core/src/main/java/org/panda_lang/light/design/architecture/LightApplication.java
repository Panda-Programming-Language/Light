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

package org.panda_lang.light.design.architecture;

import org.panda_lang.light.LightCore;
import org.panda_lang.panda.framework.design.architecture.Application;
import org.panda_lang.panda.framework.design.architecture.Script;

import java.util.List;

public class LightApplication implements Application {

    @Override
    public void launch() {
        LightCore.getLogger().info("Launching Light application");

        LightCore.getLogger().info("Process finished with exit code 0");
    }

    @Override
    public void setApplicationArguments(String... arguments) {

    }

    @Override
    public List<Script> getScripts() {
        return null;
    }

    @Override
    public String getWorkingDirectory() {
        return null;
    }

}