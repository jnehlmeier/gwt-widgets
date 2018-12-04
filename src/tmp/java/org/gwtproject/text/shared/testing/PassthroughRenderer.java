package org.gwtproject.text.shared.testing;

import org.gwtproject.text.shared.AbstractRenderer;
import org.gwtproject.text.shared.Renderer;

public class PassthroughRenderer extends AbstractRenderer<String> {
    private static PassthroughRenderer INSTANCE;

    public static Renderer<String> instance() {
        if (INSTANCE == null) {
            INSTANCE = new PassthroughRenderer();
        }

        return INSTANCE;
    }

    protected PassthroughRenderer() {
    }

    public String render(String object) {
        return object;
    }
}