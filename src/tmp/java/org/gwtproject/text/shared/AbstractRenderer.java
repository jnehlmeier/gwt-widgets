package org.gwtproject.text.shared;

import org.gwtproject.text.shared.Renderer;

import java.io.IOException;

public abstract class AbstractRenderer<T> implements Renderer<T> {
    public AbstractRenderer() {
    }

    public void render(T object, Appendable appendable) throws IOException {
        appendable.append(this.render(object));
    }
}
