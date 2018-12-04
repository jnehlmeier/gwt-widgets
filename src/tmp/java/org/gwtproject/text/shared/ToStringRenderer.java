package org.gwtproject.text.shared;

public class ToStringRenderer extends AbstractRenderer<Object> {
    private static ToStringRenderer instance;
    private final String textForNull;

    public static ToStringRenderer instance() {
        if (instance == null) {
            instance = new ToStringRenderer("");
        }

        return instance;
    }

    public ToStringRenderer(String textForNull) {
        this.textForNull = textForNull;
    }

    public String render(Object object) {
        return object == null ? this.textForNull : object.toString();
    }
}
