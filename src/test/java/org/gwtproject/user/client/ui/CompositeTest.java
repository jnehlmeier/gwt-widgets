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

import org.gwtproject.core.client.Scheduler;
import org.gwtproject.event.dom.client.BlurEvent;
import org.gwtproject.event.dom.client.BlurHandler;
import org.gwtproject.event.dom.client.FocusEvent;
import org.gwtproject.event.dom.client.FocusHandler;
import org.gwtproject.event.logical.shared.AttachEvent;
import com.google.gwt.junit.client.GWTTestCase;
import org.gwtproject.user.client.Command;
import org.gwtproject.user.client.DOM;
import org.gwtproject.user.client.Event;

/**
 * Tests for {@link Composite}.
 */
public class CompositeTest extends GWTTestCase {

  static int orderIndex;

  @Override
  public String getModuleName() {
    return "org.gwtproject.user.Widgets";
  }

  private static class EventTestComposite extends Composite {
    TextBox tb = new TextBox();
    boolean widgetFocusHandlerFired;
    boolean widgetBlurHandlerFired;
    boolean domFocusFired;
    boolean domBlurFired;


    public EventTestComposite() {
      initWidget(tb);
      sinkEvents(Event.FOCUSEVENTS);

      tb.addFocusHandler(new FocusHandler() {
        @Override
        public void onFocus(FocusEvent event) {
          widgetFocusHandlerFired = true;
        }
      });
      tb.addBlurHandler(new BlurHandler() {
        @Override
        public void onBlur(BlurEvent event) {
          widgetBlurHandlerFired = true;
        }
      });
    }

    @Override
    public void onBrowserEvent(Event event) {
      switch (DOM.eventGetType(event)) {
        case Event.ONFOCUS:
          domFocusFired = true;
          // Eat the focus event.
          return;

        case Event.ONBLUR:
          domBlurFired = true;
          // *Don't* eat the blur event.
          break;
      }

      super.onBrowserEvent(event);
    }
  }

  public void disabledTestBrowserEvents() {
    // TODO: re-enable this test when we figure out why the focus events aren't
    // firing on some browsers.
    final EventTestComposite c = new EventTestComposite();
    RootPanel.get().add(c);

    this.delayTestFinish(1000);

    // Focus, then blur, the composite's text box. This has to be done in
    // deferred commands, because focus events usually require the event loop
    // to be pumped in order to fire.
    Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
      @Override
      public void execute() {
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
          @Override
          public void execute() {
            // Ensure all events fired as expected.
            assertTrue(c.domFocusFired);
            assertTrue(c.domBlurFired);
            assertTrue(c.widgetBlurHandlerFired);

            // Ensure that the widget's focus event was eaten by the
            // composite's implementation of onBrowserEvent().
            assertFalse(c.widgetFocusHandlerFired);
            finishTest();
          }
        });

        c.tb.setFocus(false);
      }
    });

    c.tb.setFocus(true);
  }

  /**
   * This test is here to prevent a "No tests found" warning in Junit.
   * 
   * TODO: Remove this when testBrowserEvents is enabled
   */
  public void testNothing() {
  }

  public void testAttachAndDetachOrder() {
    class TestAttachHandler implements AttachEvent.Handler {
      int delegateAttachOrder;
      int delegateDetachOrder;

      @Override
      public void onAttachOrDetach(AttachEvent event) {
        if (event.isAttached()) {
          delegateAttachOrder = ++orderIndex;
        } else {
          delegateDetachOrder = ++orderIndex;
        }
      }
    }

    class TestComposite extends Composite {
      TextBox tb = new TextBox();

      public TestComposite() {
        initWidget(tb);
      }
    }

    TestComposite c = new TestComposite();
    TestAttachHandler ca = new TestAttachHandler();
    TestAttachHandler wa = new TestAttachHandler();

    c.addAttachHandler(ca);
    c.tb.addAttachHandler(wa);

    RootPanel.get().add(c);
    RootPanel.get().remove(c);

    assertTrue(ca.delegateAttachOrder > 0);
    assertTrue(ca.delegateDetachOrder > 0);
    assertTrue(ca.delegateAttachOrder > wa.delegateAttachOrder);
    assertTrue(ca.delegateDetachOrder < wa.delegateDetachOrder);
  }

  public void testChildrenAttachDetach() {
    class TestComposite extends Composite {
      int doAttachChildrenCount = 0;
      int doDetachChildrenCount = 0;
      TextBox tb = new TextBox();

      public TestComposite() {
        initWidget(tb);
      }

      @Override
      protected void doAttachChildren() {
        doAttachChildrenCount++;
      }

      @Override
      protected void doDetachChildren() {
        doDetachChildrenCount++;
      }
    }

    TestComposite c = new TestComposite();
    RootPanel.get().add(c);
    RootPanel.get().remove(c);
    RootPanel.get().add(c);
    RootPanel.get().remove(c);

    assertEquals(2, c.doAttachChildrenCount);
    assertEquals(2, c.doDetachChildrenCount);
  }
}
