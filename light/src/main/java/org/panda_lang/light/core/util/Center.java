package org.panda_lang.light.core.util;

import java.util.ArrayList;
import java.util.Collection;

public class Center<T> {

    protected final Collection<T> elements;

    public Center() {
        this.elements = new ArrayList<>();
    }

    public void registerElement(T element) {
        elements.add(element);
    }

    public Collection<T> getElements() {
        return elements;
    }

}