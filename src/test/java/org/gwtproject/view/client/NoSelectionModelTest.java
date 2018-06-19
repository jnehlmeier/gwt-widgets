/*
 * Copyright 2010 Google Inc.
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
package org.gwtproject.view.client;

import java.util.Locale;

/**
 * Tests for {@link org.gwtproject.view.client.NoSelectionModel}.
 */
public class NoSelectionModelTest extends AbstractSelectionModelTest {

  public void testGetLastSelectedObject() {
    org.gwtproject.view.client.NoSelectionModel<String> model = createSelectionModel(null);
    assertNull(model.getLastSelectedObject());

    model.setSelected("test", true);
    assertEquals("test", model.getLastSelectedObject());

    model.setSelected("test", false);
    assertNull(model.getLastSelectedObject());
  }

  public void testSelectedChangeEvent() {
    org.gwtproject.view.client.NoSelectionModel<String> model = createSelectionModel(null);
    org.gwtproject.view.client.SelectionChangeEvent.Handler handler = new org.gwtproject.view.client.SelectionChangeEvent.Handler() {
      @Override
      public void onSelectionChange(SelectionChangeEvent event) {
        finishTest();
      }
    };
    model.addSelectionChangeHandler(handler);

    delayTestFinish(2000);
    model.setSelected("test", true);
  }

  public void testSetSelected() {
    org.gwtproject.view.client.NoSelectionModel<String> model = createSelectionModel(null);
    assertFalse(model.isSelected("test0"));

    model.setSelected("test0", true);
    assertFalse(model.isSelected("test0"));

    model.setSelected("test1", true);
    assertFalse(model.isSelected("test1"));
  }

  public void testSetSelectedWithKeyProvider() {
    org.gwtproject.view.client.ProvidesKey<String> keyProvider = new org.gwtproject.view.client.ProvidesKey<String>() {
      @Override
      public Object getKey(String item) {
        return item.toUpperCase(Locale.ROOT);
      }
    };
    org.gwtproject.view.client.NoSelectionModel<String> model = createSelectionModel(keyProvider);
    assertFalse(model.isSelected("test0"));

    model.setSelected("test0", true);
    assertEquals("test0", model.getLastSelectedObject());
    assertFalse(model.isSelected("test0"));
    assertFalse(model.isSelected("TEST0"));

    model.setSelected("test1", true);
    assertEquals("test1", model.getLastSelectedObject());
    assertFalse(model.isSelected("test1"));
    assertFalse(model.isSelected("TEST1"));
    assertFalse(model.isSelected("test0"));
  }

  @Override
  protected org.gwtproject.view.client.NoSelectionModel<String> createSelectionModel(ProvidesKey<String> keyProvider) {
    return new NoSelectionModel<String>(keyProvider);
  }
}
