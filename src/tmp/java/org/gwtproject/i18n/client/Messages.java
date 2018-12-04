package org.gwtproject.i18n.client;

import java.lang.annotation.*;

public interface Messages extends LocalizableResource {
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD})
    @Documented
    public @interface DefaultMessage {
        String value();
    }
}
