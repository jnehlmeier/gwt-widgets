/*
 * Copyright 2008 Google Inc.
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
package org.gwtproject.debug.client;

/**
 * Provides low-level functionality to support the creation of testing and
 * diagnostic frameworks.
 * 
 * @see org.gwtproject.user.client.ui.UIObject#ensureDebugId(String)
 */
public class DebugInfo {

  public static final String DEFAULT_DEBUG_ID_PREFIX = "gwt-debug-";
  private static final boolean ENABLED =
      "true".equals(System.getProperty("widgets.gwt.enableDebugId"));

  private static String debugIdPrefix = DEFAULT_DEBUG_ID_PREFIX;
  private static String debugIdAttribute = "id";
  private static boolean debugIdAsProperty = true;

  /**
   * Returns the element attribute or property where the debug ID is set.
   * Defaults to the element id property. Use {@link #isDebugIdAsProperty()} to
   * determine if the value is a property or attribute.
   */
  public static String getDebugIdAttribute() {
    return debugIdAttribute;
  }

  /**
   * Returns the prefix string used for debug ids. Defaults to "gwt-debug-".
   */
  public static String getDebugIdPrefix() {
    return debugIdPrefix;
  }

  /**
   * Returns true if the debug ID should be set as a property instead of an
   * attribute.
   */
  public static boolean isDebugIdAsProperty() {
    return debugIdAsProperty;
  }

  /**
   * Returns true if debug IDs are enabled such that calls to
   * {@link org.gwtproject.user.client.ui.UIObject#ensureDebugId(String)} will
   * set DOM IDs on the {@link org.gwtproject.user.client.ui.UIObject} and its
   * important sub elements.
   * 
   * @return true if debug IDs are enabled, false if disabled.
   * @see org.gwtproject.user.client.ui.UIObject#ensureDebugId(String)
   */
  public static boolean isDebugIdEnabled() {
    return ENABLED;
  }

  /**
   * Sets the element attribute to assign the debug ID.
   * 
   * @param attribute an element property
   * @param asProperty true to set the debug ID as a property instead of an
   *          attribute
   */
  public static void setDebugIdAttribute(String attribute, boolean asProperty) {
    debugIdAttribute = attribute;
    debugIdAsProperty = asProperty;
  }

  /**
   * Sets the prefix string used for debug IDs.
   */
  public static void setDebugIdPrefix(String prefix) {
    debugIdPrefix = prefix;
  }
}
