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

import org.gwtproject.dom.client.Element;
import org.gwtproject.event.dom.client.BlurEvent;
import org.gwtproject.event.dom.client.BlurHandler;
import org.gwtproject.event.dom.client.ClickEvent;
import org.gwtproject.event.dom.client.ClickHandler;
import org.gwtproject.event.dom.client.DoubleClickEvent;
import org.gwtproject.event.dom.client.DoubleClickHandler;
import org.gwtproject.event.dom.client.DragEndEvent;
import org.gwtproject.event.dom.client.DragEndHandler;
import org.gwtproject.event.dom.client.DragEnterEvent;
import org.gwtproject.event.dom.client.DragEnterHandler;
import org.gwtproject.event.dom.client.DragEvent;
import org.gwtproject.event.dom.client.DragHandler;
import org.gwtproject.event.dom.client.DragLeaveEvent;
import org.gwtproject.event.dom.client.DragLeaveHandler;
import org.gwtproject.event.dom.client.DragOverEvent;
import org.gwtproject.event.dom.client.DragOverHandler;
import org.gwtproject.event.dom.client.DragStartEvent;
import org.gwtproject.event.dom.client.DragStartHandler;
import org.gwtproject.event.dom.client.DropEvent;
import org.gwtproject.event.dom.client.DropHandler;
import org.gwtproject.event.dom.client.FocusEvent;
import org.gwtproject.event.dom.client.FocusHandler;
import org.gwtproject.event.dom.client.GestureChangeEvent;
import org.gwtproject.event.dom.client.GestureChangeHandler;
import org.gwtproject.event.dom.client.GestureEndEvent;
import org.gwtproject.event.dom.client.GestureEndHandler;
import org.gwtproject.event.dom.client.GestureStartEvent;
import org.gwtproject.event.dom.client.GestureStartHandler;
import org.gwtproject.event.dom.client.HasAllDragAndDropHandlers;
import org.gwtproject.event.dom.client.HasAllFocusHandlers;
import org.gwtproject.event.dom.client.HasAllGestureHandlers;
import org.gwtproject.event.dom.client.HasAllKeyHandlers;
import org.gwtproject.event.dom.client.HasAllMouseHandlers;
import org.gwtproject.event.dom.client.HasAllTouchHandlers;
import org.gwtproject.event.dom.client.HasClickHandlers;
import org.gwtproject.event.dom.client.HasDoubleClickHandlers;
import org.gwtproject.event.dom.client.KeyDownEvent;
import org.gwtproject.event.dom.client.KeyDownHandler;
import org.gwtproject.event.dom.client.KeyPressEvent;
import org.gwtproject.event.dom.client.KeyPressHandler;
import org.gwtproject.event.dom.client.KeyUpEvent;
import org.gwtproject.event.dom.client.KeyUpHandler;
import org.gwtproject.event.dom.client.MouseDownEvent;
import org.gwtproject.event.dom.client.MouseDownHandler;
import org.gwtproject.event.dom.client.MouseMoveEvent;
import org.gwtproject.event.dom.client.MouseMoveHandler;
import org.gwtproject.event.dom.client.MouseOutEvent;
import org.gwtproject.event.dom.client.MouseOutHandler;
import org.gwtproject.event.dom.client.MouseOverEvent;
import org.gwtproject.event.dom.client.MouseOverHandler;
import org.gwtproject.event.dom.client.MouseUpEvent;
import org.gwtproject.event.dom.client.MouseUpHandler;
import org.gwtproject.event.dom.client.MouseWheelEvent;
import org.gwtproject.event.dom.client.MouseWheelHandler;
import org.gwtproject.event.dom.client.TouchCancelEvent;
import org.gwtproject.event.dom.client.TouchCancelHandler;
import org.gwtproject.event.dom.client.TouchEndEvent;
import org.gwtproject.event.dom.client.TouchEndHandler;
import org.gwtproject.event.dom.client.TouchMoveEvent;
import org.gwtproject.event.dom.client.TouchMoveHandler;
import org.gwtproject.event.dom.client.TouchStartEvent;
import org.gwtproject.event.dom.client.TouchStartHandler;
import org.gwtproject.event.shared.HandlerRegistration;
import org.gwtproject.user.client.ui.impl.FocusImpl;

/**
 * Abstract base class for most widgets that can receive keyboard focus.
 */
public abstract class FocusWidget extends Widget implements
    HasClickHandlers, HasDoubleClickHandlers, HasFocus, HasEnabled,
    HasAllDragAndDropHandlers, HasAllFocusHandlers, HasAllGestureHandlers,
    HasAllKeyHandlers, HasAllMouseHandlers, HasAllTouchHandlers {

  private static final FocusImpl impl = FocusImpl.getFocusImplForWidget();

  /**
   * Gets the FocusImpl instance.
   *
   * @return impl
   */
  protected static FocusImpl getFocusImpl() {
    return impl;
  }

  /**
   * Creates a new focus widget with no element. {@link #setElement(Element)}
   * must be called before any other methods.
   */
  protected FocusWidget() {
  }

  /**
   * Creates a new focus widget that wraps the specified browser element.
   *
   * @param elem the element to be wrapped
   */
  protected FocusWidget(Element elem) {
    setElement(elem);
  }

  public HandlerRegistration addBlurHandler(BlurHandler handler) {
    return addDomHandler(handler, BlurEvent.getType());
  }

  public HandlerRegistration addClickHandler(ClickHandler handler) {
    return addDomHandler(handler, ClickEvent.getType());
  }

  public HandlerRegistration addDoubleClickHandler(DoubleClickHandler handler) {
    return addDomHandler(handler, DoubleClickEvent.getType());
  }

  public HandlerRegistration addDragEndHandler(DragEndHandler handler) {
    return addBitlessDomHandler(handler, DragEndEvent.getType());
  }

  public HandlerRegistration addDragEnterHandler(DragEnterHandler handler) {
    return addBitlessDomHandler(handler, DragEnterEvent.getType());
  }

  public HandlerRegistration addDragHandler(DragHandler handler) {
    return addBitlessDomHandler(handler, DragEvent.getType());
  }

  public HandlerRegistration addDragLeaveHandler(DragLeaveHandler handler) {
    return addBitlessDomHandler(handler, DragLeaveEvent.getType());
  }

  public HandlerRegistration addDragOverHandler(DragOverHandler handler) {
    return addBitlessDomHandler(handler, DragOverEvent.getType());
  }

  public HandlerRegistration addDragStartHandler(DragStartHandler handler) {
    return addBitlessDomHandler(handler, DragStartEvent.getType());
  }

  public HandlerRegistration addDropHandler(DropHandler handler) {
    return addBitlessDomHandler(handler, DropEvent.getType());
  }

  public HandlerRegistration addFocusHandler(FocusHandler handler) {
    return addDomHandler(handler, FocusEvent.getType());
  }

  public HandlerRegistration addGestureChangeHandler(GestureChangeHandler handler) {
    return addDomHandler(handler, GestureChangeEvent.getType());
  }

  public HandlerRegistration addGestureEndHandler(GestureEndHandler handler) {
    return addDomHandler(handler, GestureEndEvent.getType());
  }

  public HandlerRegistration addGestureStartHandler(GestureStartHandler handler) {
    return addDomHandler(handler, GestureStartEvent.getType());
  }

  public HandlerRegistration addKeyDownHandler(KeyDownHandler handler) {
    return addDomHandler(handler, KeyDownEvent.getType());
  }

  public HandlerRegistration addKeyPressHandler(KeyPressHandler handler) {
    return addDomHandler(handler, KeyPressEvent.getType());
  }

  public HandlerRegistration addKeyUpHandler(KeyUpHandler handler) {
    return addDomHandler(handler, KeyUpEvent.getType());
  }

  public HandlerRegistration addMouseDownHandler(MouseDownHandler handler) {
    return addDomHandler(handler, MouseDownEvent.getType());
  }

  public HandlerRegistration addMouseMoveHandler(MouseMoveHandler handler) {
    return addDomHandler(handler, MouseMoveEvent.getType());
  }

  public HandlerRegistration addMouseOutHandler(MouseOutHandler handler) {
    return addDomHandler(handler, MouseOutEvent.getType());
  }

  public HandlerRegistration addMouseOverHandler(MouseOverHandler handler) {
    return addDomHandler(handler, MouseOverEvent.getType());
  }

  public HandlerRegistration addMouseUpHandler(MouseUpHandler handler) {
    return addDomHandler(handler, MouseUpEvent.getType());
  }

  public HandlerRegistration addMouseWheelHandler(MouseWheelHandler handler) {
    return addDomHandler(handler, MouseWheelEvent.getType());
  }

  public HandlerRegistration addTouchCancelHandler(TouchCancelHandler handler) {
    return addDomHandler(handler, TouchCancelEvent.getType());
  }

  public HandlerRegistration addTouchEndHandler(TouchEndHandler handler) {
    return addDomHandler(handler, TouchEndEvent.getType());
  }

  public HandlerRegistration addTouchMoveHandler(TouchMoveHandler handler) {
    return addDomHandler(handler, TouchMoveEvent.getType());
  }

  public HandlerRegistration addTouchStartHandler(TouchStartHandler handler) {
    return addDomHandler(handler, TouchStartEvent.getType());
  }

  /**
   * Gets the tab index.
   *
   * @return the tab index
   */
  public int getTabIndex() {
    return impl.getTabIndex(getElement());
  }

  /**
   * Gets whether this widget is enabled.
   *
   * @return <code>true</code> if the widget is enabled
   */
  public boolean isEnabled() {
    return !getElement().getPropertyBoolean("disabled");
  }

  public void setAccessKey(char key) {
    getElement().setPropertyString("accessKey", "" + key);
  }

  /**
   * Sets whether this widget is enabled.
   *
   * @param enabled <code>true</code> to enable the widget, <code>false</code>
   *          to disable it
   */
  public void setEnabled(boolean enabled) {
    getElement().setPropertyBoolean("disabled", !enabled);
  }

  public void setFocus(boolean focused) {
    if (focused) {
      impl.focus(getElement());
    } else {
      impl.blur(getElement());
    }
  }

  public void setTabIndex(int index) {
    impl.setTabIndex(getElement(), index);
  }

  @Override
  protected void onAttach() {
    super.onAttach();

    // Accessibility: setting tab index to be 0 by default, ensuring element
    // appears in tab sequence. We must ensure that the element doesn't already
    // have a tabIndex set. This is not a problem for normal widgets, but when
    // a widget is used to wrap an existing static element, it can already have
    // a tabIndex.
    int tabIndex = getTabIndex();
    if (-1 == tabIndex) {
      setTabIndex(0);
    }
  }
}
