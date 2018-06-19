/*
 * Copyright 2009 Google Inc.
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

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.junit.client.GWTTestCase;
import org.gwtproject.user.client.Event.NativePreviewEvent;
import org.gwtproject.user.client.Event.NativePreviewHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Test Case for {@link org.gwtproject.user.client.Event}.
 */
public class EventTest extends GWTTestCase {
  /**
   * An EventPreview used for testing.
   */
  @SuppressWarnings("deprecation")
  private static class TestEventPreview implements EventPreview {
    private boolean doCancel;
    private boolean isFired = false;

    /**
     * Construct a new {@link TestEventPreview}.
     * 
     * @param doCancel if true, cancel the event
     */
    public TestEventPreview(boolean doCancel) {
      this.doCancel = doCancel;
    }

    @Override
    @Deprecated
    public boolean onEventPreview(org.gwtproject.user.client.Event event) {
      assertFalse(isFired);
      isFired = true;
      return !doCancel;
    }

    public void assertIsFired(boolean expected) {
      assertEquals(expected, isFired);
    }
  }

  /**
   * A NativePreviewHandler used for testing.
   */
  private static class TestNativePreviewHandler implements NativePreviewHandler {
    private boolean doCancel;
    private boolean doPreventCancel;
    private boolean isFired = false;

    /**
     * Construct a new {@link TestNativePreviewHandler}.
     * 
     * @param doCancel if true, cancel the event
     * @param doPreventCancel if true, prevent the event from being canceled
     */
    public TestNativePreviewHandler(boolean doCancel, boolean doPreventCancel) {
      this.doCancel = doCancel;
      this.doPreventCancel = doPreventCancel;
    }

    @Override
    public void onPreviewNativeEvent(NativePreviewEvent event) {
      assertFalse(isFired);
      isFired = true;
      if (doCancel) {
        event.cancel();
      }
      if (doPreventCancel) {
        event.consume();
      }
    }

    public void assertIsFired(boolean expected) {
      assertEquals(expected, isFired);
    }
  }

  /**
   * A custom {@link Label} used for testing.
   */
  private static class TestLabel extends Label implements
      HasDoubleClickHandlers {
    @Override
    public HandlerRegistration addDoubleClickHandler(DoubleClickHandler handler) {
      return addDomHandler(handler, DoubleClickEvent.getType());
    }
  }

  /**
   * Debug information used to test events.
   */
  private static class EventInfo {
    private int fireCount = 0;
  }

  @Override
  public String getModuleName() {
    return "com.google.gwt.user.User";
  }

  /**
   * Test that concurrent removal of a {@link NativePreviewHandler} does not
   * trigger an exception. The handler should not actually be removed until the
   * end of the event loop.
   */
  public void testConcurrentRemovalOfNativePreviewHandler() {
    // Add handler0
    final TestNativePreviewHandler handler0 = new TestNativePreviewHandler(
        false, false);
    final HandlerRegistration reg0 = org.gwtproject.user.client.Event.addNativePreviewHandler(handler0);

    // Add handler 1
    final TestNativePreviewHandler handler1 = new TestNativePreviewHandler(
        false, false) {
      @Override
      public void onPreviewNativeEvent(NativePreviewEvent event) {
        super.onPreviewNativeEvent(event);
        handler0.assertIsFired(false);
        reg0.removeHandler();
      }
    };
    HandlerRegistration reg1 = org.gwtproject.user.client.Event.addNativePreviewHandler(handler1);
    assertTrue(org.gwtproject.user.client.Event.fireNativePreviewEvent(null));

    // Verify both handlers fired even though one was removed
    handler0.assertIsFired(true);
    handler1.assertIsFired(true);
    reg1.removeHandler();
  }

  /**
   * Test that a double click results in exactly one simulated click event in
   * IE. See issue 3392 for more info.
   */  
  public void testDoubleClickEvent() {
    TestLabel label = new TestLabel();
    RootPanel.get().add(label);

    // Add some handlers
    final EventInfo clickInfo = new EventInfo();
    label.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        clickInfo.fireCount++;
      }
    });
    final EventInfo dblclickInfo = new EventInfo();
    label.addDoubleClickHandler(new DoubleClickHandler() {
      @Override
      public void onDoubleClick(DoubleClickEvent event) {
        dblclickInfo.fireCount++;
      }
    });

    // Fire a click event
    NativeEvent clickEvent = Document.get().createClickEvent(0, 0, 0, 0, 0,
        false, false, false, false);
    label.getElement().dispatchEvent(clickEvent);
    NativeEvent dblclickEvent = Document.get().createDblClickEvent(0, 0, 0, 0,
        0, false, false, false, false);
    label.getElement().dispatchEvent(dblclickEvent);

    // Verify the results
    if (isIE8OrOlder()) {
      // IE is expected to simulate exactly 1 click event
      assertEquals(2, clickInfo.fireCount);
    } else {
      // Other browsers should not simulate any events
      assertEquals(1, clickInfo.fireCount);
    }
    assertEquals(1, dblclickInfo.fireCount);
    RootPanel.get().remove(label);
  }

  /**
   * Test that {@link org.gwtproject.user.client.Event#fireNativePreviewEvent(NativeEvent)} returns the
   * correct value if the native event is canceled.
   */
  public void testFireNativePreviewEventCancel() {
    TestNativePreviewHandler handler0 = new TestNativePreviewHandler(true,
        false);
    TestNativePreviewHandler handler1 = new TestNativePreviewHandler(true,
        false);
    HandlerRegistration reg0 = org.gwtproject.user.client.Event.addNativePreviewHandler(handler0);
    HandlerRegistration reg1 = org.gwtproject.user.client.Event.addNativePreviewHandler(handler1);
    assertFalse(org.gwtproject.user.client.Event.fireNativePreviewEvent(null));
    handler0.assertIsFired(true);
    handler1.assertIsFired(true);
    reg0.removeHandler();
    reg1.removeHandler();
  }

  /**
   * Test that {@link org.gwtproject.user.client.Event#fireNativePreviewEvent(NativeEvent)} returns the
   * correct value if the native event is prevented from being canceled, even if
   * another handler cancels the event.
   */
  public void testFireNativePreviewEventPreventCancel() {
    TestNativePreviewHandler handler0 = new TestNativePreviewHandler(false,
        true);
    TestNativePreviewHandler handler1 = new TestNativePreviewHandler(true,
        false);
    HandlerRegistration reg0 = org.gwtproject.user.client.Event.addNativePreviewHandler(handler0);
    HandlerRegistration reg1 = org.gwtproject.user.client.Event.addNativePreviewHandler(handler1);
    assertTrue(org.gwtproject.user.client.Event.fireNativePreviewEvent(null));
    handler0.assertIsFired(true);
    handler1.assertIsFired(true);
    reg0.removeHandler();
    reg1.removeHandler();
  }

  /**
   * Test that {@link org.gwtproject.user.client.Event#fireNativePreviewEvent(NativeEvent)} fires handlers
   * in reverse order, and that the legacy EventPreview fires only if it is at
   * the top of the stack.
   */
  @SuppressWarnings("deprecation")
  public void testFireNativePreviewEventReverseOrder() {
    final TestEventPreview preview0 = new TestEventPreview(false);
    final TestEventPreview preview1 = new TestEventPreview(false);
    final TestNativePreviewHandler handler0 = new TestNativePreviewHandler(
        false, false) {
      @Override
      public void onPreviewNativeEvent(NativePreviewEvent event) {
        super.onPreviewNativeEvent(event);
        preview0.assertIsFired(false);
        preview1.assertIsFired(true);
        assertFalse(event.isFirstHandler());
      }
    };
    final TestNativePreviewHandler handler1 = new TestNativePreviewHandler(
        false, false) {
      @Override
      public void onPreviewNativeEvent(NativePreviewEvent event) {
        super.onPreviewNativeEvent(event);
        handler0.assertIsFired(false);
        preview0.assertIsFired(false);
        preview1.assertIsFired(true);
        assertFalse(event.isFirstHandler());
      }
    };
    final TestNativePreviewHandler handler2 = new TestNativePreviewHandler(
        false, false) {
      @Override
      public void onPreviewNativeEvent(NativePreviewEvent event) {
        super.onPreviewNativeEvent(event);
        handler0.assertIsFired(false);
        handler1.assertIsFired(false);
        preview0.assertIsFired(false);
        preview1.assertIsFired(true);
        assertFalse(event.isFirstHandler());
      }
    };
    final TestNativePreviewHandler handler3 = new TestNativePreviewHandler(
        false, false) {
      @Override
      public void onPreviewNativeEvent(NativePreviewEvent event) {
        super.onPreviewNativeEvent(event);
        handler0.assertIsFired(false);
        handler1.assertIsFired(false);
        handler2.assertIsFired(false);
        preview0.assertIsFired(false);
        preview1.assertIsFired(true);
        assertFalse(event.isFirstHandler());
      }
    };
    org.gwtproject.user.client.DOM.addEventPreview(preview0);
    HandlerRegistration reg0 = org.gwtproject.user.client.Event.addNativePreviewHandler(handler0);
    HandlerRegistration reg1 = org.gwtproject.user.client.Event.addNativePreviewHandler(handler1);
    HandlerRegistration reg2 = org.gwtproject.user.client.Event.addNativePreviewHandler(handler2);
    HandlerRegistration reg3 = org.gwtproject.user.client.Event.addNativePreviewHandler(handler3);
    org.gwtproject.user.client.DOM.addEventPreview(preview1);
    assertTrue(org.gwtproject.user.client.DOM.previewEvent(null));
    handler0.assertIsFired(true);
    handler1.assertIsFired(true);
    handler2.assertIsFired(true);
    handler3.assertIsFired(true);
    preview0.assertIsFired(false);
    preview1.assertIsFired(true);
    reg0.removeHandler();
    reg1.removeHandler();
    reg2.removeHandler();
    reg3.removeHandler();
    org.gwtproject.user.client.DOM.removeEventPreview(preview0);
    org.gwtproject.user.client.DOM.removeEventPreview(preview1);
  }

  /**
   * Test removal of a {@link NativePreviewHandler} works.
   */
  public void testFireNativePreviewEventRemoval() {
    TestNativePreviewHandler handler0 = new TestNativePreviewHandler(false,
        false);
    TestNativePreviewHandler handler1 = new TestNativePreviewHandler(false,
        false);
    HandlerRegistration reg0 = org.gwtproject.user.client.Event.addNativePreviewHandler(handler0);
    HandlerRegistration reg1 = org.gwtproject.user.client.Event.addNativePreviewHandler(handler1);
    reg1.removeHandler();
    assertTrue(org.gwtproject.user.client.Event.fireNativePreviewEvent(null));
    handler0.assertIsFired(true);
    handler1.assertIsFired(false);
    reg0.removeHandler();
  }

  /**
   * Test that {@link org.gwtproject.user.client.Event#fireNativePreviewEvent(NativeEvent)} returns the
   * correct value even if another event is fired while handling the current
   * event.
   */
  public void testFireNativePreviewEventWithInterupt() {
    NativePreviewHandler handler = new NativePreviewHandler() {
      private boolean first = true;

      @Override
      public void onPreviewNativeEvent(NativePreviewEvent event) {
        if (first) {
          event.cancel();
          first = false;
          assertTrue(org.gwtproject.user.client.Event.fireNativePreviewEvent(null));
          assertTrue(event.isCanceled());
        }
      }
    };
    HandlerRegistration reg = org.gwtproject.user.client.Event.addNativePreviewHandler(handler);
    assertFalse(org.gwtproject.user.client.Event.fireNativePreviewEvent(null));
    reg.removeHandler();
  }

  /**
   * Test that {@link org.gwtproject.user.client.Event#fireNativePreviewEvent(NativeEvent)} returns the
   * correct value if the native event is not canceled.
   */
  public void testFireNativePreviewEventWithoutCancel() {
    TestNativePreviewHandler handler0 = new TestNativePreviewHandler(false,
        false);
    TestNativePreviewHandler handler1 = new TestNativePreviewHandler(false,
        false);
    HandlerRegistration reg0 = org.gwtproject.user.client.Event.addNativePreviewHandler(handler0);
    HandlerRegistration reg1 = org.gwtproject.user.client.Event.addNativePreviewHandler(handler1);
    assertTrue(org.gwtproject.user.client.Event.fireNativePreviewEvent(null));
    handler0.assertIsFired(true);
    handler1.assertIsFired(true);
    reg0.removeHandler();
    reg1.removeHandler();
  }

  /**
   * Test that {@link org.gwtproject.user.client.Event#fireNativePreviewEvent(NativeEvent)} returns the
   * correct value if no handlers are present.
   */
  public void testFireNativePreviewEventWithoutHandlers() {
    assertTrue(org.gwtproject.user.client.Event.fireNativePreviewEvent(null));
  }

  public void testGetTypeInt() {
    assertEquals(org.gwtproject.user.client.Event.ONBLUR, org.gwtproject.user.client.Event.getTypeInt("blur"));
    assertEquals(org.gwtproject.user.client.Event.ONCHANGE, org.gwtproject.user.client.Event.getTypeInt("change"));
    assertEquals(org.gwtproject.user.client.Event.ONCLICK, org.gwtproject.user.client.Event.getTypeInt("click"));
    assertEquals(org.gwtproject.user.client.Event.ONERROR, org.gwtproject.user.client.Event.getTypeInt("error"));
    assertEquals(org.gwtproject.user.client.Event.ONFOCUS, org.gwtproject.user.client.Event.getTypeInt("focus"));
    assertEquals(org.gwtproject.user.client.Event.ONKEYDOWN, org.gwtproject.user.client.Event.getTypeInt("keydown"));
    assertEquals(org.gwtproject.user.client.Event.ONKEYPRESS, Event.getTypeInt("keypress"));
    assertEquals(org.gwtproject.user.client.Event.ONKEYUP, org.gwtproject.user.client.Event.getTypeInt("keyup"));
    assertEquals(org.gwtproject.user.client.Event.ONLOAD, org.gwtproject.user.client.Event.getTypeInt("load"));
    assertEquals(org.gwtproject.user.client.Event.ONMOUSEDOWN, org.gwtproject.user.client.Event.getTypeInt("mousedown"));
    assertEquals(org.gwtproject.user.client.Event.ONMOUSEMOVE, org.gwtproject.user.client.Event.getTypeInt("mousemove"));
    assertEquals(org.gwtproject.user.client.Event.ONMOUSEOUT, org.gwtproject.user.client.Event.getTypeInt("mouseout"));
    assertEquals(org.gwtproject.user.client.Event.ONMOUSEOVER, org.gwtproject.user.client.Event.getTypeInt("mouseover"));
    assertEquals(org.gwtproject.user.client.Event.ONMOUSEUP, org.gwtproject.user.client.Event.getTypeInt("mouseup"));
    assertEquals(-1, org.gwtproject.user.client.Event.getTypeInt("undefined"));
  }

  /**
   * Test that legacy EventPreview and NativePreviewHandlers can both cancel the
   * event.
   */
  @Deprecated
  public void testLegacyEventPreviewCancelByBoth() {
    // Add handlers
    TestNativePreviewHandler handler0 = new TestNativePreviewHandler(false,
        false);
    TestNativePreviewHandler handler1 = new TestNativePreviewHandler(true,
        false);
    HandlerRegistration reg0 = org.gwtproject.user.client.Event.addNativePreviewHandler(handler0);
    HandlerRegistration reg1 = org.gwtproject.user.client.Event.addNativePreviewHandler(handler1);

    // Add legacy EventPreview
    TestEventPreview preview = new TestEventPreview(true);
    org.gwtproject.user.client.DOM.addEventPreview(preview);

    // Fire the event
    assertFalse(DOM.previewEvent(null));
    handler0.assertIsFired(true);
    handler1.assertIsFired(true);
    preview.assertIsFired(true);
    reg0.removeHandler();
    reg1.removeHandler();
    org.gwtproject.user.client.DOM.removeEventPreview(preview);
  }

  /**
   * Test that legacy EventPreview can cancel the event.
   */
  @Deprecated
  public void testLegacyEventPreviewCancelByEventPreview() {
    // Add handlers
    TestNativePreviewHandler handler0 = new TestNativePreviewHandler(false,
        false);
    TestNativePreviewHandler handler1 = new TestNativePreviewHandler(false,
        false);
    HandlerRegistration reg0 = org.gwtproject.user.client.Event.addNativePreviewHandler(handler0);
    HandlerRegistration reg1 = org.gwtproject.user.client.Event.addNativePreviewHandler(handler1);

    // Add legacy EventPreview
    TestEventPreview preview = new TestEventPreview(true);
    org.gwtproject.user.client.DOM.addEventPreview(preview);

    // Fire the event
    assertFalse(org.gwtproject.user.client.DOM.previewEvent(null));
    handler0.assertIsFired(true);
    handler1.assertIsFired(true);
    preview.assertIsFired(true);
    reg0.removeHandler();
    reg1.removeHandler();
    org.gwtproject.user.client.DOM.removeEventPreview(preview);
  }

  /**
   * Test that legacy EventPreview still fires after the NativeHandler cancels
   * the event.
   */
  @Deprecated
  public void testLegacyEventPreviewCancelByHandler() {
    // Add handlers
    TestNativePreviewHandler handler0 = new TestNativePreviewHandler(false,
        false);
    TestNativePreviewHandler handler1 = new TestNativePreviewHandler(true,
        false);
    HandlerRegistration reg0 = org.gwtproject.user.client.Event.addNativePreviewHandler(handler0);
    HandlerRegistration reg1 = org.gwtproject.user.client.Event.addNativePreviewHandler(handler1);

    // Add legacy EventPreview
    TestEventPreview preview = new TestEventPreview(false);
    org.gwtproject.user.client.DOM.addEventPreview(preview);

    // Fire the event
    assertFalse(org.gwtproject.user.client.DOM.previewEvent(null));
    handler0.assertIsFired(true);
    handler1.assertIsFired(true);
    preview.assertIsFired(true);
    reg0.removeHandler();
    reg1.removeHandler();
    org.gwtproject.user.client.DOM.removeEventPreview(preview);
  }

  /**
   * Test that legacy EventPreview still fires after the NativeHandlers without
   * canceling the event.
   */
  @Deprecated
  public void testLegacyEventPreviewWithoutCancel() {
    // Add handlers
    TestNativePreviewHandler handler0 = new TestNativePreviewHandler(false,
        false);
    TestNativePreviewHandler handler1 = new TestNativePreviewHandler(false,
        false);
    HandlerRegistration reg0 = org.gwtproject.user.client.Event.addNativePreviewHandler(handler0);
    HandlerRegistration reg1 = org.gwtproject.user.client.Event.addNativePreviewHandler(handler1);

    // Add legacy EventPreview
    TestEventPreview preview = new TestEventPreview(false);
    org.gwtproject.user.client.DOM.addEventPreview(preview);

    // Fire the event
    assertTrue(org.gwtproject.user.client.DOM.previewEvent(null));
    handler0.assertIsFired(true);
    handler1.assertIsFired(true);
    preview.assertIsFired(true);
    reg0.removeHandler();
    reg1.removeHandler();
    org.gwtproject.user.client.DOM.removeEventPreview(preview);
  }

  /**
   * Test the accessors in {@link NativePreviewEvent}.
   */
  public void testNativePreviewEventAccessors() {
    // cancelNativeEvent
    {
      NativePreviewEvent event = new NativePreviewEvent();
      assertFalse(event.isCanceled());
      event.cancel();
      assertTrue(event.isCanceled());
    }

    // preventCancelNativeEvent
    {
      NativePreviewEvent event = new NativePreviewEvent();
      assertFalse(event.isConsumed());
      event.consume();
      assertTrue(event.isConsumed());
    }

    // revive
    {
      NativePreviewEvent event = new NativePreviewEvent();
      event.cancel();
      event.consume();
      assertTrue(event.isCanceled());
      assertTrue(event.isConsumed());
      event.revive();
      assertFalse(event.isCanceled());
      assertFalse(event.isConsumed());
    }
  }

  /**
   * Test that the singleton instance of {@link NativePreviewEvent} is revived
   * correctly.
   */
  public void testReviveNativePreviewEvent() {
    // Fire the event and cancel it
    TestNativePreviewHandler handler0 = new TestNativePreviewHandler(true, true);
    HandlerRegistration reg0 = org.gwtproject.user.client.Event.addNativePreviewHandler(handler0);
    org.gwtproject.user.client.Event.fireNativePreviewEvent(null);
    handler0.assertIsFired(true);
    reg0.removeHandler();

    // Fire the event again, but don't cancel it
    TestNativePreviewHandler handler1 = new TestNativePreviewHandler(false,
        false) {
      @Override
      public void onPreviewNativeEvent(NativePreviewEvent event) {
        assertFalse(event.isCanceled());
        assertFalse(event.isConsumed());
        assertTrue(event.isFirstHandler());
        super.onPreviewNativeEvent(event);
      }
    };
    HandlerRegistration reg1 = org.gwtproject.user.client.Event.addNativePreviewHandler(handler1);
    assertTrue(org.gwtproject.user.client.Event.fireNativePreviewEvent(null));
    handler1.assertIsFired(true);
    reg1.removeHandler();
  }

  private native boolean isIE8OrOlder() /*-{
    // rely on IE9 & 10 behavior being closer to Standard/Chrome/Safari
    return navigator.userAgent.toLowerCase().indexOf("msie") != -1 &&
      document.documentMode < 9;
  }-*/;
}
