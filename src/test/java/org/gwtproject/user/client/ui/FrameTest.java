package org.gwtproject.user.client.ui;

import org.gwtproject.event.dom.client.LoadEvent;
import org.gwtproject.event.dom.client.LoadHandler;
import com.google.gwt.junit.client.GWTTestCase;
import org.gwtproject.user.client.Event;
import org.gwtproject.user.client.ui.Frame;
import org.gwtproject.user.client.ui.RootPanel;

public class FrameTest extends GWTTestCase {

  private static final int FRAME_LOAD_DELAY = 3000;

  @Override
  public String getModuleName() {
    return "org.gwtproject.user.UserTest";
  }

  public void testOnLoadEventFiresWithBrowerEvent() {
    delayTestFinish(FRAME_LOAD_DELAY);

    org.gwtproject.user.client.ui.Frame frame = new org.gwtproject.user.client.ui.Frame() {
      @Override
      public void onBrowserEvent(Event event) {
        if (event.getTypeInt() == Event.ONLOAD) {
          finishTest();
        }
        super.onBrowserEvent(event);
      }
    };

    frame.sinkEvents(Event.ONLOAD);
    org.gwtproject.user.client.ui.RootPanel.get().add(frame);
    frame.setUrl("iframetest.html");
  }

  public void testOnLoadEventFiresWithLoadHandler() {
    delayTestFinish(FRAME_LOAD_DELAY);

    org.gwtproject.user.client.ui.Frame frame = new org.gwtproject.user.client.ui.Frame();
    frame.addLoadHandler(new LoadHandler() {
      @Override
      public void onLoad(LoadEvent event) {
        finishTest();
      }
    });

    org.gwtproject.user.client.ui.RootPanel.get().add(frame);
    frame.setUrl("iframetest.html");
  }

  public void testOnLoadEventFiresWithDomLoadHandler() {
    delayTestFinish(FRAME_LOAD_DELAY);

    org.gwtproject.user.client.ui.Frame frame = new Frame() {
      {
        addDomHandler(new LoadHandler() {
          @Override
          public void onLoad(LoadEvent event) {
            finishTest();
          }
        }, LoadEvent.getType());
      }
    };

    RootPanel.get().add(frame);
    frame.setUrl("iframetest.html");
  }
}
