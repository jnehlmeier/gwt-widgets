package org.gwtproject.text.shared;

import java.io.IOException;

public interface Renderer<T> {
    String render(T var1);

    void render(T var1, Appendable var2) throws IOException;
}