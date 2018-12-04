package org.gwtproject.i18n.client;

import java.lang.annotation.*;

public interface Constants extends LocalizableResource {
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD})
    @Documented
    public @interface DefaultStringValue {
        String value();
    }
}
