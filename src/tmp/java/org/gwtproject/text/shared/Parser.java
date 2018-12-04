package org.gwtproject.text.shared;

import java.text.ParseException;

public interface Parser<T> {
    T parse(CharSequence var1) throws ParseException;
}
