package org.gwtproject.resources.client;

import java.lang.annotation.*;

public interface ClientBundle {
  @Documented
  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.METHOD)
  public @interface Source {
    String[] value();
  }
}
