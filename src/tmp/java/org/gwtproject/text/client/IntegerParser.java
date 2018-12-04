package org.gwtproject.text.client;

import org.gwtproject.i18n.client.NumberFormat;
import org.gwtproject.text.shared.Parser;

import java.text.ParseException;

public class IntegerParser implements Parser<Integer> {
    private static IntegerParser INSTANCE;

    public static Parser<Integer> instance() {
        if (INSTANCE == null) {
            INSTANCE = new IntegerParser();
        }

        return INSTANCE;
    }

    protected IntegerParser() {
    }

    public Integer parse(CharSequence object) throws ParseException {
        if ("".equals(object.toString())) {
            return null;
        } else {
            try {
                return (int)Math.rint(NumberFormat.getDecimalFormat().parse(object.toString()));
            } catch (NumberFormatException var3) {
                throw new ParseException(var3.getMessage(), 0);
            }
        }
    }
}
