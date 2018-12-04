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

import org.gwtproject.dom.client.Document;
import org.gwtproject.dom.client.Element;
import org.gwtproject.editor.client.IsEditor;
import org.gwtproject.editor.client.LeafValueEditor;
import org.gwtproject.editor.ui.client.adapters.HasTextEditor;
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
import org.gwtproject.event.dom.client.GestureChangeEvent;
import org.gwtproject.event.dom.client.GestureChangeHandler;
import org.gwtproject.event.dom.client.GestureEndEvent;
import org.gwtproject.event.dom.client.GestureEndHandler;
import org.gwtproject.event.dom.client.GestureStartEvent;
import org.gwtproject.event.dom.client.GestureStartHandler;
import org.gwtproject.event.dom.client.HasAllDragAndDropHandlers;
import org.gwtproject.event.dom.client.HasAllGestureHandlers;
import org.gwtproject.event.dom.client.HasAllMouseHandlers;
import org.gwtproject.event.dom.client.HasAllTouchHandlers;
import org.gwtproject.event.dom.client.HasClickHandlers;
import org.gwtproject.event.dom.client.HasDoubleClickHandlers;
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
import org.gwtproject.i18n.client.BidiUtils;
import org.gwtproject.i18n.client.HasDirection;
import org.gwtproject.i18n.shared.DirectionEstimator;

/**
 * A widget that contains arbitrary text, <i>not</i> interpreted as HTML.
 *
 * This widget uses a &lt;div&gt; element, causing it to be displayed with block
 * layout.
 *
 * <p>
 * <h3>Built-in Bidi Text Support</h3>
 * This widget is capable of automatically adjusting its direction according to
 * its content. This feature is controlled by {@link #setDirectionEstimator} or
 * passing a DirectionEstimator parameter to the constructor, and is off by
 * default.
 * </p>
 *
 * <h3>CSS Style Rules</h3>
 * <ul class='css'>
 * <li>.gwt-Label { }</li>
 * </ul>
 *
 * <p>
 * <h3>Example</h3>
 * {@example com.google.gwt.examples.HTMLExample}
 * </p>
 */
public class Label extends LabelBase<String> implements HasDirectionalText,
    HasDirection, HasClickHandlers, HasDoubleClickHandlers,
    HasAllDragAndDropHandlers, HasAllGestureHandlers,
    HasAllMouseHandlers, HasAllTouchHandlers,
    IsEditor<LeafValueEditor<String>> {

  public static final DirectionEstimator DEFAULT_DIRECTION_ESTIMATOR =
      DirectionalTextHelper.DEFAULT_DIRECTION_ESTIMATOR;

  /**
   * Creates a Label widget that wraps an existing &lt;div&gt; or &lt;span&gt;
   * element.
   *
   * This element must already be attached to the document. If the element is
   * removed from the document, you must call
   * {@link RootPanel#detachNow(Widget)}.
   *
   * @param element the element to be wrapped
   */
  public static Label wrap(Element element) {
    // Assert that the element is attached.
    assert Document.get().getBody().isOrHasChild(element);

    Label label = new Label(element);

    // Mark it attached and remember it for cleanup.
    label.onAttach();
    RootPanel.detachOnWindowClose(label);

    return label;
  }

  private LeafValueEditor<String> editor;

  /**
   * Creates an empty label.
   */
  public Label() {
    super(false);
    setStyleName("gwt-Label");
  }

  /**
   * Creates a label with the specified text.
   *
   * @param text the new label's text
   */
  public Label(String text) {
    this();
    setText(text);
  }

  /**
   * Creates a label with the specified text and direction.
   *
   * @param text the new label's text
   * @param dir the text's direction. Note that {@code DEFAULT} means direction
   *          should be inherited from the widget's parent element.
   */
  public Label(String text, Direction dir) {
    this();
    setText(text, dir);
  }

  /**
   * Creates a label with the specified text and a default direction estimator.
   *
   * @param text the new label's text
   * @param directionEstimator A DirectionEstimator object used for automatic
   *          direction adjustment. For convenience,
   *          {@link #DEFAULT_DIRECTION_ESTIMATOR} can be used.
   */
  public Label(String text, DirectionEstimator directionEstimator) {
    this();
    setDirectionEstimator(directionEstimator);
    setText(text);
  }

  /**
   * Creates a label with the specified text.
   *
   * @param text the new label's text
   * @param wordWrap <code>false</code> to disable word wrapping
   */
  public Label(String text, boolean wordWrap) {
    this(text);
    setWordWrap(wordWrap);
  }

  /**
   * This constructor may be used by subclasses to explicitly use an existing
   * element. This element must be either a &lt;div&gt; or &lt;span&gt; element.
   *
   * @param element the element to be used
   */
  protected Label(Element element) {
    super(element);
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

  public HandlerRegistration addGestureChangeHandler(GestureChangeHandler handler) {
    return addDomHandler(handler, GestureChangeEvent.getType());
  }

  public HandlerRegistration addGestureEndHandler(GestureEndHandler handler) {
    return addDomHandler(handler, GestureEndEvent.getType());
  }

  public HandlerRegistration addGestureStartHandler(GestureStartHandler handler) {
    return addDomHandler(handler, GestureStartEvent.getType());
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

  public LeafValueEditor<String> asEditor() {
    if (editor == null) {
      editor = HasTextEditor.of(this);
    }
    return editor;
  }

  /**
   * Gets the widget element's direction.
   * @deprecated Use {@link #getTextDirection} instead
   */
  @Deprecated
  public Direction getDirection() {
    return BidiUtils.getDirectionOnElement(getElement());
  }

  public String getText() {
    return directionalTextHelper.getText();
  }

  public Direction getTextDirection() {
    return directionalTextHelper.getTextDirection();
  }

  /**
   * Sets the widget element's direction.
   * @deprecated Use {@link #setDirectionEstimator} and / or pass explicit
   * direction to {@link #setText} instead
   */
  @Deprecated
  public void setDirection(Direction direction) {
    directionalTextHelper.setDirection(direction);
    updateHorizontalAlignment();
  }

  /**
   * Sets the label's content to the given text.
   * <p>
   * Doesn't change the widget's direction or horizontal alignment if {@code
   * directionEstimator} is null. Otherwise, the widget's direction is set using
   * the estimator, and its alignment may therefore change as described in
   * {@link #setText(String, Direction) setText(String, Direction)}.
   *
   * @param text the widget's new text
   */
  public void setText(String text) {
    directionalTextHelper.setText(text);
    updateHorizontalAlignment();
  }

  /**
   * Sets the label's content to the given text, applying the given direction.
   * <p>
   * This will have the following effect on the horizontal alignment:
   * <ul>
   * <li> If the automatic alignment setting is ALIGN_CONTENT_START or
   * ALIGN_CONTENT_END, the horizontal alignment will be set to match the start
   * or end edge, respectively, of the new direction (the {@code dir}
   * parameter). If that is DEFAULT, the locale direction is used.
   * <li> Otherwise, the horizontal alignment value is not changed, but the
   * effective alignment may nevertheless change according to the usual HTML
   * rules, i.e. it will match the start edge of the new direction if the widget
   * element is a &lt;div&gt; and has no explicit alignment value even by
   * inheritance.
   * </ul>
   *
   * @param text the widget's new text
   * @param dir the text's direction. Note: {@code Direction.DEFAULT} means
   *        direction should be inherited from the widget's parent element.
   */
  public void setText(String text, Direction dir) {
    directionalTextHelper.setText(text, dir);
    updateHorizontalAlignment();
  }
}
