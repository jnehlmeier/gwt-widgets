package org.gwtproject.text.shared;

import org.gwtproject.safehtml.shared.SafeHtml;
import org.gwtproject.safehtml.shared.SafeHtmlBuilder;

public abstract class AbstractSafeHtmlRenderer<T> implements SafeHtmlRenderer<T> {
  @Override
  public SafeHtml render(T object) {
    return null;
  }

  @Override
  public void render(T object, SafeHtmlBuilder builder) {

  }
}
