package org.gwtproject.text.client;

import org.gwtproject.i18n.client.NumberFormat;
import org.gwtproject.text.shared.AbstractRenderer;
import org.gwtproject.text.shared.Renderer;

public class DoubleRenderer extends AbstractRenderer<Double> {
    private static DoubleRenderer INSTANCE;

    public static Renderer<Double> instance() {
        if (INSTANCE == null) {
            INSTANCE = new DoubleRenderer();
        }

        return INSTANCE;
    }

    protected DoubleRenderer() {
    }

    public String render(Double object) {
        return object == null ? "" : NumberFormat.getDecimalFormat().format(object);
    }
}