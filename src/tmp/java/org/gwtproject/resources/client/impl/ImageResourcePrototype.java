package org.gwtproject.resources.client.impl;

import org.gwtproject.resources.client.ImageResource;
import org.gwtproject.safehtml.shared.SafeUri;

public class ImageResourcePrototype implements ImageResource {

  public static class Bundle extends com.google.gwt.resources.client.impl.ImageResourcePrototype {
    public Bundle(String name, com.google.gwt.safehtml.shared.SafeUri url, int left, int top, int width, int height,
                  boolean animated, boolean lossy) {
      super(name, url, left, top, width, height, animated, lossy);
    }
  }

  @Override
  public SafeUri getSafeUri() {
    return null;
  }

  @Override
  public int getLeft() {
    return 0;
  }

  @Override
  public int getTop() {
    return 0;
  }

  @Override
  public int getWidth() {
    return 0;
  }

  @Override
  public int getHeight() {
    return 0;
  }
}
