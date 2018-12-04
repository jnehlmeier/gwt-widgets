package org.gwtproject.text.shared.testing;

import org.gwtproject.text.shared.Parser;

public class PassthroughParser implements Parser<String> {
    private static PassthroughParser INSTANCE;

    public static Parser<String> instance() {
        if (INSTANCE == null) {
            INSTANCE = new PassthroughParser();
        }

        return INSTANCE;
    }

    protected PassthroughParser() {
    }

    public String parse(CharSequence object) {
        return object.toString();
    }
}
