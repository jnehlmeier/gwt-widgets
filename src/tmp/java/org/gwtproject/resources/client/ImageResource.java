package org.gwtproject.resources.client;

import com.google.gwt.resources.client.CssResource;
import org.gwtproject.safehtml.shared.SafeUri;

import java.lang.annotation.*;

public interface ImageResource extends ResourcePrototype {

  @Documented
  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.METHOD)
  public @interface ImageOptions {

    boolean flipRtl() default false;

    int height() default -1;

    boolean preventInlining() default false;

    RepeatStyle repeatStyle() default RepeatStyle.None;

    int width() default -1;
  }

  public enum RepeatStyle {
    None,
    Horizontal,
    Vertical,
    Both
  }



  SafeUri getSafeUri();

  int getLeft();

  int getTop();

  int getWidth();

  int getHeight();
}
