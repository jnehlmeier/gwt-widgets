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
package org.gwtproject.user.client.ui;

import org.gwtproject.dom.client.ButtonElement;
import org.gwtproject.event.logical.shared.ValueChangeEvent;
import org.gwtproject.event.logical.shared.ValueChangeHandler;
import com.google.gwt.junit.client.GWTTestCase;

/**
 * Tests for {@link SimpleCheckBox}.
 */
public class SimpleCheckBoxTest extends GWTTestCase {

  private static class Handler implements ValueChangeHandler<Boolean> {
    Boolean received = null;

    @Override
    public void onValueChange(ValueChangeEvent<Boolean> event) {
      received = event.getValue();
    }
  }

  @Override
  public String getModuleName() {
    return "org.gwtproject.user.UserTest";
  }


  public void testProperties() {
    SimpleCheckBox checkbox = new SimpleCheckBox();

    checkbox.setName("myName");
    assertEquals("myName", checkbox.getName());

    checkbox.setTabIndex(42);
    assertEquals(42, checkbox.getTabIndex());

    checkbox.setEnabled(false);
    assertEquals(false, checkbox.isEnabled());

    // Test the 'checked' state across attachment and detachment
    // (this value has a tendency to get lost on some browsers).
    checkbox.setChecked(true);
    assertEquals(true, checkbox.isChecked());

    RootPanel.get().add(checkbox);
    assertEquals(true, checkbox.isChecked());

    RootPanel.get().remove(checkbox);
    assertEquals(true, checkbox.isChecked());
  }


  public void testValueChangeEvent() {
    SimpleCheckBox cb = new SimpleCheckBox();
    Handler h = new Handler();
    cb.addValueChangeHandler(h);
    RootPanel.get().add(cb);

    cb.setChecked(false);
    assertNull(h.received);
    cb.setChecked(true);
    assertNull(h.received);

    cb.setValue(false);
    assertNull(h.received);
    cb.setValue(true);
    assertNull(h.received);

    cb.setValue(true, true);
    assertNull(h.received);

    cb.setValue(false, true);
    assertFalse(h.received);

    cb.setValue(true, true);
    assertTrue(h.received);

    cb.getElement().<ButtonElement> cast().click();
    assertFalse(h.received);
  }
}
