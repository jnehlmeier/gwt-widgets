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

package org.gwtproject.user.client;

import org.gwtproject.event.dom.client.*;
import com.google.gwt.junit.client.GWTTestCase;
import org.gwtproject.user.client.ui.*;

/**
 * Test Case for sinking of gesture events.
 */
public class GestureEventSinkTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.gwtproject.user.Widgets";
  }

  public void testFocusPanelGestureEventSinkByAddingHandler() {
    verifyGestureStartEventSinkOnAddHandler(new FocusPanel(), false);
    verifyGestureEndEventSinkOnAddHandler(new FocusPanel(), false);
    verifyGestureChangeEventSinkOnAddHandler(new FocusPanel(), false);
  }

  public void testFocusWidgetGestureEventSinkByAddingHandler() {
    verifyGestureStartEventSinkOnAddHandler(new Anchor(), false);
    verifyGestureEndEventSinkOnAddHandler(new Anchor(), false);
    verifyGestureChangeEventSinkOnAddHandler(new Anchor(), false);

    verifyGestureStartEventSinkOnAddHandler(new Button(), false);
    verifyGestureEndEventSinkOnAddHandler(new Button(), false);
    verifyGestureChangeEventSinkOnAddHandler(new Button(), false);

    CheckBox checkBox1 = new CheckBox();
    // Get the inputElem on which events are sunk
    org.gwtproject.user.client.Element e1 = (Element) checkBox1.getElement().getFirstChildElement();
    verifyGestureStartEventSinkOnAddHandler(checkBox1, e1, false);

    CheckBox checkBox2 = new CheckBox();
    // Get the inputElem on which events are sunk
    org.gwtproject.user.client.Element e2 = (org.gwtproject.user.client.Element) checkBox2.getElement().getFirstChildElement();
    verifyGestureChangeEventSinkOnAddHandler(checkBox2, e2, false);

    CheckBox checkBox3 = new CheckBox();
    // Get the inputElem on which events are sunk
    org.gwtproject.user.client.Element e3 = (org.gwtproject.user.client.Element) checkBox3.getElement().getFirstChildElement();
    verifyGestureEndEventSinkOnAddHandler(checkBox3, e3, false);

    verifyGestureStartEventSinkOnAddHandler(new ToggleButton(), false);
    verifyGestureEndEventSinkOnAddHandler(new ToggleButton(), false);
    verifyGestureChangeEventSinkOnAddHandler(new ToggleButton(), false);

    verifyGestureStartEventSinkOnAddHandler(new ListBox(), false);
    verifyGestureEndEventSinkOnAddHandler(new ListBox(), false);
    verifyGestureChangeEventSinkOnAddHandler(new ListBox(), false);

    verifyGestureStartEventSinkOnAddHandler(new RichTextArea(), false);
    verifyGestureEndEventSinkOnAddHandler(new RichTextArea(), false);
    verifyGestureChangeEventSinkOnAddHandler(new RichTextArea(), false);

    verifyGestureStartEventSinkOnAddHandler(new TextArea(), false);
    verifyGestureEndEventSinkOnAddHandler(new TextArea(), false);
    verifyGestureChangeEventSinkOnAddHandler(new TextArea(), false);

    verifyGestureStartEventSinkOnAddHandler(new PasswordTextBox(), false);
    verifyGestureEndEventSinkOnAddHandler(new PasswordTextBox(), false);
    verifyGestureChangeEventSinkOnAddHandler(new PasswordTextBox(), false);

    verifyGestureStartEventSinkOnAddHandler(new TextBox(), false);
    verifyGestureEndEventSinkOnAddHandler(new TextBox(), false);
    verifyGestureChangeEventSinkOnAddHandler(new TextBox(), false);

    verifyGestureStartEventSinkOnAddHandler(
        new SimpleRadioButton("foo"), false);
    verifyGestureEndEventSinkOnAddHandler(new SimpleRadioButton("foo"), false);
    verifyGestureChangeEventSinkOnAddHandler(
        new SimpleRadioButton("foo"), false);
  }

  public void testGestureEventBitFieldsNotTriviallyZero() {
    assertNotSame(0, org.gwtproject.user.client.Event.ONGESTURESTART);
    assertNotSame(0, org.gwtproject.user.client.Event.ONGESTURECHANGE);
    assertNotSame(0, org.gwtproject.user.client.Event.ONGESTUREEND);
  }

  public void testImageGestureEventSinkByAddingHandler() {
    /*
     * The Image widget currently sinks events too early, before handlers are
     * attached. We verify that (broken) behavior in this test. TODO(fredsa)
     * Once Image has been fixed to lazily sink events, update this test and
     * remove verifyEventSinkOnAddHandler's second parameter.
     */
    verifyGestureStartEventSinkOnAddHandler(new Image(), true);
    verifyGestureEndEventSinkOnAddHandler(new Image(), true);
    verifyGestureChangeEventSinkOnAddHandler(new Image(), true);
  }

  public void testLabelGestureEventSinkByAddingHandler() {
    verifyGestureStartEventSinkOnAddHandler(new Label(), false);
    verifyGestureEndEventSinkOnAddHandler(new Label(), false);
    verifyGestureChangeEventSinkOnAddHandler(new Label(), false);
  }

  @Override
  protected void gwtTearDown() throws Exception {
    // clean up after ourselves
    RootPanel.get().clear();
    super.gwtTearDown();
  }

  private <W extends Widget & HasAllGestureHandlers>
      void assertNotSunkAfterAttach(W w, String eventName, boolean isSunk) {
    assertFalse(
        "Event should not be sunk on " + w.getClass().getName() + " until a "
            + eventName + " handler has been added", isSunk);
  }

  private <W extends Widget & HasAllGestureHandlers>
      void assertSunkAfterAddHandler(W w, String eventName, boolean isSunk) {
    assertTrue("Event should have been sunk on " + w.getClass().getName()
        + " once the widget has been attached and a " + eventName
        + " handler has been added", isSunk);
  }

  private <W extends Widget & HasAllGestureHandlers> void assertSunkAfterAttach(
      W w, String eventName, boolean isSunk) {
    assertTrue("Event should have been sunk on " + w.getClass().getName()
        + " once the widget has been attached", isSunk);
  }

  private boolean isGestureChangeEventSunk(org.gwtproject.user.client.Element e) {
    return (org.gwtproject.user.client.DOM.getEventsSunk(e) & org.gwtproject.user.client.Event.ONGESTURECHANGE) != 0;
  }

  private boolean isGestureEndEventSunk(org.gwtproject.user.client.Element e) {
    return (DOM.getEventsSunk(e) & org.gwtproject.user.client.Event.ONGESTUREEND) != 0;
  }

  private boolean isGestureStartEventSunk(org.gwtproject.user.client.Element e) {
    return (org.gwtproject.user.client.DOM.getEventsSunk(e) & Event.ONGESTURESTART) != 0;
  }

  private <W extends Widget & HasAllGestureHandlers>
      void verifyGestureChangeEventSinkOnAddHandler(
          W w, boolean allowEarlySink) {
    verifyGestureChangeEventSinkOnAddHandler(w, w.getElement(), allowEarlySink);
  }

  private <W extends Widget & HasAllGestureHandlers>
      void verifyGestureChangeEventSinkOnAddHandler(
      W w, org.gwtproject.user.client.Element e, boolean widgetSinksEventsOnAttach) {
    RootPanel.get().add(w);

    if (widgetSinksEventsOnAttach) {
      assertSunkAfterAttach(w, GestureChangeEvent.getType().getName(),
          isGestureChangeEventSunk(e));
    } else {
      assertNotSunkAfterAttach(w, GestureChangeEvent.getType().getName(),
          isGestureChangeEventSunk(e));
    }

    w.addGestureChangeHandler(new GestureChangeHandler() {
      @Override
      public void onGestureChange(GestureChangeEvent event) {
      }
    });

    assertSunkAfterAddHandler(
        w, GestureChangeEvent.getType().getName(), isGestureChangeEventSunk(e));
  }

  private <W extends Widget & HasAllGestureHandlers>
      void verifyGestureEndEventSinkOnAddHandler(W w, boolean allowEarlySink) {
    verifyGestureEndEventSinkOnAddHandler(w, w.getElement(), allowEarlySink);
  }

  private <W extends Widget & HasAllGestureHandlers>
      void verifyGestureEndEventSinkOnAddHandler(
      W w, org.gwtproject.user.client.Element e, boolean widgetSinksEventsOnAttach) {
    RootPanel.get().add(w);

    if (widgetSinksEventsOnAttach) {
      assertSunkAfterAttach(
          w, GestureEndEvent.getType().getName(), isGestureEndEventSunk(e));
    } else {
      assertNotSunkAfterAttach(
          w, GestureEndEvent.getType().getName(), isGestureEndEventSunk(e));
    }

    w.addGestureEndHandler(new GestureEndHandler() {
      @Override
      public void onGestureEnd(GestureEndEvent event) {
      }
    });

    assertSunkAfterAddHandler(
        w, GestureEndEvent.getType().getName(), isGestureEndEventSunk(e));
  }

  private <W extends Widget & HasAllGestureHandlers>
      void verifyGestureStartEventSinkOnAddHandler(
          W w, boolean allowEarlySink) {
    verifyGestureStartEventSinkOnAddHandler(w, w.getElement(), allowEarlySink);
  }

  private <W extends Widget & HasAllGestureHandlers>
      void verifyGestureStartEventSinkOnAddHandler(
      W w, org.gwtproject.user.client.Element e, boolean widgetSinksEventsOnAttach) {
    RootPanel.get().add(w);

    if (widgetSinksEventsOnAttach) {
      assertSunkAfterAttach(
          w, GestureStartEvent.getType().getName(), isGestureStartEventSunk(e));
    } else {
      assertNotSunkAfterAttach(
          w, GestureStartEvent.getType().getName(), isGestureStartEventSunk(e));
    }

    w.addGestureStartHandler(new GestureStartHandler() {
      @Override
      public void onGestureStart(GestureStartEvent event) {
      }
    });

    assertSunkAfterAddHandler(
        w, GestureStartEvent.getType().getName(), isGestureStartEventSunk(e));
  }
}