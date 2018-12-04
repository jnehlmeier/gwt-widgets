package org.gwtproject.i18n.shared;

import org.gwtproject.i18n.shared.TimeZone;

import java.util.Date;

public class DateTimeFormat {

    public static DateTimeFormat getFormat(PredefinedFormat format) {
        return null;
    }

    public String getPattern() {
        return null;
    }

    public String format(Date date) {
        return null;
    }

    public String format(Date date, TimeZone timeZone) {
        return null;
    }

    public Date parse(String dateText) {
        return null;
    }

    public static enum PredefinedFormat {
        DATE_SHORT, DATE_FULL

    }
}
