package org.gwtproject.resources.client;

import java.lang.annotation.*;

public interface CssResource {
  boolean ensureInjected();

  String getName();

  String getText();

  @Documented
  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  public @interface ImportedWithPrefix {
    String value();
  }
}
