package org.gwtproject.text.client;

import org.gwtproject.i18n.client.NumberFormat;
import org.gwtproject.text.shared.Parser;

import java.text.ParseException;

public class DoubleParser implements Parser<Double> {
    private static DoubleParser INSTANCE;

    public static Parser<Double> instance() {
        if (INSTANCE == null) {
            INSTANCE = new DoubleParser();
        }

        return INSTANCE;
    }

    protected DoubleParser() {
    }

    public Double parse(CharSequence object) throws ParseException {
        if ("".equals(object.toString())) {
            return null;
        } else {
            try {
                return NumberFormat.getDecimalFormat().parse(object.toString());
            } catch (NumberFormatException var3) {
                throw new ParseException(var3.getMessage(), 0);
            }
        }
    }
}
