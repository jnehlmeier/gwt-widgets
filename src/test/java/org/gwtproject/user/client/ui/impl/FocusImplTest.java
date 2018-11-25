/*
 * Copyright 2013 Google Inc.
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
package org.gwtproject.user.client.ui.impl;

import com.google.gwt.junit.client.GWTTestCase;
import org.gwtproject.dom.style.shared.Display;
import org.gwtproject.user.client.ui.FocusPanel;
import org.gwtproject.user.client.ui.RootPanel;

/**
 * Test FocusImpl.
 */
public class FocusImplTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.gwtproject.user.Widgets";
  }

  // https://code.google.com/p/google-web-toolkit/issues/detail?id=897
  public void testSetFocus_NotThrowingException() {
    FocusPanel focusPanel = new FocusPanel();
    RootPanel.get().add(focusPanel);
    focusPanel.getElement().getStyle().setDisplay(Display.NONE);
    focusPanel.setFocus(true);
  }
}
