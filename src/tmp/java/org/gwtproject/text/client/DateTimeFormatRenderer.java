package org.gwtproject.text.client;

import org.gwtproject.text.shared.AbstractRenderer;
import org.gwtproject.i18n.shared.DateTimeFormat;
import org.gwtproject.i18n.shared.TimeZone;

import java.util.Date;

public class DateTimeFormatRenderer extends AbstractRenderer<Date>  {
    private final DateTimeFormat format;
    private final TimeZone timeZone;

    public DateTimeFormatRenderer() {
        this(DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_SHORT));
    }

    public DateTimeFormatRenderer(DateTimeFormat format) {
        this(format, (TimeZone)null);
    }

    public DateTimeFormatRenderer(DateTimeFormat format, TimeZone timeZone) {
        assert format != null;

        this.format = format;
        this.timeZone = timeZone;
    }

    public String render(Date object) {
        return object == null ? "" : this.format.format(object, this.timeZone);
    }
}
