package org.gwtproject.i18n.client;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface LocalizableResource extends Localizable {
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE})
    public @interface DefaultLocale {
        String DEFAULT_LOCALE = "en";

        String value() default "en";
    }
}
