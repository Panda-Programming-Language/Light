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

package org.panda_lang.light.framework.design.interpreter.pattern.linguistic;

import org.jetbrains.annotations.Nullable;

public class LinguisticCandidate<T> {

    private final boolean matched;
    private final T matchedPhraseme;
    private final LinguisticPatternResult<T> linguisticResult;
    private final LinguisticCandidate<T> previousCandidate;
    private boolean definite;

    public LinguisticCandidate(boolean matched, boolean definite, T matchedElement, LinguisticPatternResult<T> linguisticResult, LinguisticCandidate<T> previousCandidate) {
        this.matched = matched;
        this.definite = definite;
        this.matchedPhraseme = matchedElement;
        this.linguisticResult = linguisticResult;
        this.previousCandidate = previousCandidate;
    }

    public LinguisticCandidate(T matchedElement, LinguisticPatternResult<T> linguisticResult, @Nullable LinguisticCandidate<T> previousCandidate) {
        this(true, true, matchedElement, linguisticResult, previousCandidate);
    }

    public LinguisticCandidate(T matchedElement, LinguisticPatternResult<T> linguisticResult) {
        this(matchedElement, linguisticResult, null);
    }

    public LinguisticCandidate(boolean matched) {
        this(matched, true, null, null, null);
    }

    public boolean isDefinite() {
        return definite;
    }

    public boolean isMatched() {
        return matched;
    }

    public LinguisticCandidate<T> getPreviousCandidate() {
        return previousCandidate;
    }

    public LinguisticPatternResult<T> getLinguisticResult() {
        return linguisticResult;
    }

    public T getMatchedElement() {
        return matchedPhraseme;
    }

}
