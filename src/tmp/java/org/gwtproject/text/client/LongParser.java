package org.gwtproject.text.client;

import org.gwtproject.i18n.client.NumberFormat;
import org.gwtproject.text.shared.Parser;

import java.text.ParseException;

public class LongParser implements Parser<Long> {
    private static LongParser INSTANCE;

    public static Parser<Long> instance() {
        if (INSTANCE == null) {
            INSTANCE = new LongParser();
        }

        return INSTANCE;
    }

    protected LongParser() {
    }

    public Long parse(CharSequence object) throws ParseException {
        if ("".equals(object.toString())) {
            return null;
        } else {
            try {
                return (long) NumberFormat.getDecimalFormat().parse(object.toString());
            } catch (NumberFormatException var3) {
                throw new ParseException(var3.getMessage(), 0);
            }
        }
    }
}
