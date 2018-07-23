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

package org.panda_lang.light.language.interpreter.pattern.lexical.extractor;

import org.jetbrains.annotations.*;
import org.panda_lang.light.language.interpreter.pattern.lexical.extractor.processed.ProcessedValue;

import java.util.*;

public class LexicalExtractorResult<T> {

    private final boolean matched;
    private final List<String> wildcards;
    private final List<String> identifiers;
    private final List<ProcessedValue<T>> processedValues;

    public LexicalExtractorResult(boolean matched) {
        this.matched = matched;
        this.identifiers = matched ? new ArrayList<>() : null;
        this.wildcards = matched ? new ArrayList<>() : null;
        this.processedValues = matched ? new ArrayList<>() : null;
    }

    public LexicalExtractorResult<T> addWildcard(String wildcardContent) {
        this.wildcards.add(wildcardContent);
        return this;
    }

    public void merge(LexicalExtractorResult<T> result) {
        if (!result.isMatched()) {
            throw new RuntimeException("Cannot merge unmatched result");
        }

        this.identifiers.addAll(result.identifiers);
        this.wildcards.addAll(result.wildcards);
    }

    public boolean isMatched() {
        return matched;
    }

    public List<ProcessedValue<T>> getProcessedValues() {
        return processedValues;
    }

    public @Nullable List<String> getIdentifiers() {
        return identifiers;
    }

    public @Nullable List<String> getWildcards() {
        return wildcards;
    }

}
