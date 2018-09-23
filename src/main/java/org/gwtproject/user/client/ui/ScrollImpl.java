/*
 * Copyright 2011 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.gwtproject.user.client.ui;

import org.gwtproject.core.client.GWT;
import org.gwtproject.core.client.JavaScriptObject;
import org.gwtproject.dom.client.Document;
import org.gwtproject.dom.client.Element;

/**
 * Implementation of scrolling behavior.
 */
class ScrollImpl {

  private static ScrollImpl impl;

  /**
   * Get the singleton instance of {@link ScrollImpl}.
   */
  static ScrollImpl get() {
    if (impl == null) {
      impl = GWT.create(ScrollImpl.class);
    }
    return impl;
  }

  /**
   * Get the maximum horizontal scroll position.
   * 
   * @param scrollable the scrollable element
   * @return the maximum scroll position
   */
  public int getMaximumHorizontalScrollPosition(Element scrollable) {
    return isRtl(scrollable) ? 0 : scrollable.getScrollWidth() - scrollable.getClientWidth();
  }

  /**
   * Get the minimum horizontal scroll position.
   * 
   * @param scrollable the scrollable element
   * @return the minimum scroll position
   */
  public int getMinimumHorizontalScrollPosition(Element scrollable) {
    return isRtl(scrollable) ? scrollable.getClientWidth() - scrollable.getScrollWidth() : 0;
  }

  /**
   * Initialize a scrollable element.
   * 
   * @param scrollable the scrollable element
   * @param container the container
   */
  public void initialize(Element scrollable, Element container) {
    // Overridden by ScrollImplTrident.
  }

  /**
   * Check if the specified element has an RTL direction. We can't base this on
   * the current locale because the user can modify the direction at the DOM
   * level.
   * 
   * @param scrollable the scrollable element
   * @return true if the direction is RTL, false if LTR
   */
  public native boolean isRtl(Element scrollable) /*-{
    var computedStyle = $doc.defaultView.getComputedStyle(scrollable, null);
    return computedStyle.getPropertyValue('direction') == 'rtl';
  }-*/;
}
