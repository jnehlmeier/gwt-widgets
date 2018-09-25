package org.gwtproject.text.shared;

import org.gwtproject.safehtml.shared.SafeHtml;
import org.gwtproject.safehtml.shared.SafeHtmlBuilder;

public interface SafeHtmlRenderer<T> {
  SafeHtml render(T object);
  void render(T object, SafeHtmlBuilder builder);
}
