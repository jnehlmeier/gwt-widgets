package org.gwtproject.text.client;

import org.gwtproject.text.shared.AbstractRenderer;
import org.gwtproject.i18n.client.NumberFormat;

public class NumberFormatRenderer extends AbstractRenderer<Number> {
    private final NumberFormat format;

    public NumberFormatRenderer() {
        this(NumberFormat.getDecimalFormat());
    }

    public NumberFormatRenderer(NumberFormat format) {
        this.format = format;
    }

    public String render(Number object) {
        return object == null ? "" : this.format.format(object);
    }
}
