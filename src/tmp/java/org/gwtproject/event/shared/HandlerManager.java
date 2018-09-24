package org.gwtproject.event.shared;

import org.gwtproject.event.dom.client.DomEvent;
import org.gwtproject.event.legacy.shared.EventHandler;
import org.gwtproject.event.legacy.shared.GwtEvent;
import org.gwtproject.user.client.Event;

public class HandlerManager {
  public <C> HandlerManager(HasHandlers hasHandlers) {

  }

  public HandlerManager(HasHandlers o, boolean b) {

  }

  public <H extends EventHandler> HandlerRegistration addHandler(GwtEvent.Type<H> type, H handler) {
    return null;
  }

  public void fireEvent(org.gwtproject.event.shared.Event<?> event) {

  }

  public boolean isEventHandled(GwtEvent.Type<Event.NativePreviewHandler> type) {
    return false;
  }

  public int getHandlerCount(GwtEvent.Type<?> type) {
    return 0;
  }

  public <H extends EventHandler> HandlerRegistration addHandler(DomEvent.Type<H> type, H handler) {
    return null;
  }

  public <H extends EventHandler> HandlerRegistration addHandler(org.gwtproject.event.shared.Event.Type<H> type, H handler) {
    return null;
  }
}
