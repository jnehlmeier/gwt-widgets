package org.gwtproject.text.client;

import org.gwtproject.i18n.client.NumberFormat;
import org.gwtproject.text.shared.AbstractRenderer;
import org.gwtproject.text.shared.Renderer;

public class IntegerRenderer extends AbstractRenderer<Integer> {
    private static IntegerRenderer INSTANCE;

    public static Renderer<Integer> instance() {
        if (INSTANCE == null) {
            INSTANCE = new IntegerRenderer();
        }

        return INSTANCE;
    }

    protected IntegerRenderer() {
    }

    public String render(Integer object) {
        return null == object ? "" : NumberFormat.getDecimalFormat().format(object);
    }
}
