package org.gwtproject.text.client;

import org.gwtproject.i18n.client.NumberFormat;
import org.gwtproject.text.shared.AbstractRenderer;
import org.gwtproject.text.shared.Renderer;

public class LongRenderer extends AbstractRenderer<Long> {
    private static LongRenderer INSTANCE;

    public static Renderer<Long> instance() {
        if (INSTANCE == null) {
            INSTANCE = new LongRenderer();
        }

        return INSTANCE;
    }

    protected LongRenderer() {
    }

    public String render(Long object) {
        return object == null ? "" : NumberFormat.getDecimalFormat().format(object);
    }
}
