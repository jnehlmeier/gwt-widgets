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
package org.gwtproject.user;

import com.google.gwt.junit.tools.GWTTestSuite;
import org.gwtproject.user.client.*;
import org.gwtproject.user.client.CustomEventsTest;
import org.gwtproject.user.client.ui.*;
//import org.gwtproject.user.client.ui.DOMRtlTest;
//import org.gwtproject.user.client.ui.DOMTest;
import org.gwtproject.user.client.ui.impl.ClippedImagePrototypeTest;
import org.gwtproject.user.client.ui.impl.FocusImplTest;

import org.gwtproject.user.datepicker.client.CalendarUtilTest;
import org.gwtproject.user.datepicker.client.DateChangeEventTest;
import junit.framework.Test;

/**
 * Tests in the user.client.ui package.
 */
public class UiSuite {
  public static Test suite() {
    GWTTestSuite suite = new GWTTestSuite("Test for suite for all user widgets");

    suite.addTestSuite(AbsolutePanelTest.class);
    suite.addTestSuite(AnchorTest.class);
    suite.addTestSuite(ButtonTest.class);
    suite.addTestSuite(CalendarUtilTest.class);
    suite.addTestSuite(CaptionPanelTest.class);
    suite.addTestSuite(CheckBoxTest.class);
    suite.addTestSuite(ClassInitTest.class);
    suite.addTestSuite(ClippedImagePrototypeTest.class);
    suite.addTestSuite(CompositeTest.class);
    suite.addTestSuite(CreateEventTest.class);
    suite.addTestSuite(CustomButtonTest.class);
    suite.addTestSuite(CustomEventsTest.class);
    suite.addTestSuite(CustomScrollPanelTest.class);
    suite.addTestSuite(DateBoxTest.class);
    suite.addTestSuite(DateChangeEventTest.class);
    suite.addTestSuite(DatePickerTest.class);
    suite.addTestSuite(DeckLayoutPanelTest.class);
    suite.addTestSuite(DeckPanelTest.class);
    suite.addTestSuite(DecoratedPopupTest.class);
    suite.addTestSuite(DecoratedStackPanelTest.class);
    suite.addTestSuite(DecoratedTabBarTest.class);
    suite.addTestSuite(DecoratedTabPanelTest.class);
    suite.addTestSuite(DecoratorPanelTest.class);
    suite.addTestSuite(DefaultSuggestionDisplayTest.class);
    suite.addTestSuite(DialogBoxTest.class);
    suite.addTestSuite(DirectionalTextHelperTest.class);
    suite.addTestSuite(DisclosurePanelTest.class);
    suite.addTestSuite(DockLayoutPanelRtlTest.class);
    suite.addTestSuite(DockLayoutPanelTest.class);
    suite.addTestSuite(DockPanelTest.class);
    suite.addTestSuite(DOMTest.class);
    suite.addTestSuite(DOMRtlTest.class);
    suite.addTestSuite(DoubleClickEventSinkTest.class);
    suite.addTestSuite(DragAndDropEventsSinkTest.class);
    suite.addTestSuite(ElementWrappingTest.class);
    suite.addTestSuite(EventTest.class);
    suite.addTestSuite(FileUploadTest.class);
    suite.addTestSuite(FiniteWidgetIteratorTest.class);
    suite.addTestSuite(FlexTableTest.class);
    suite.addTestSuite(FlowPanelTest.class);
    suite.addTestSuite(FocusImplTest.class);
    suite.addTestSuite(FocusPanelTest.class);
    suite.addTestSuite(FormPanelTest.class);
    suite.addTestSuite(FrameTest.class);
    suite.addTestSuite(GestureEventSinkTest.class);
    suite.addTestSuite(GridTest.class);
    suite.addTestSuite(HeaderPanelTest.class);
    suite.addTestSuite(HiddenTest.class);
    suite.addTestSuite(HorizontalPanelTest.class);
    suite.addTestSuite(HorizontalSplitPanelTest.class);
    suite.addTestSuite(HTMLPanelTest.class);
    suite.addTestSuite(HTMLTest.class);
    suite.addTestSuite(HyperlinkTest.class);
    suite.addTestSuite(ImageTest.class);
    suite.addTestSuite(InlineHTMLTest.class);
    suite.addTestSuite(InlineHyperlinkTest.class);
    suite.addTestSuite(IsWidgetTest.class);
    suite.addTestSuite(LabelTest.class);
    suite.addTestSuite(LazyPanelTest.class);
    suite.addTestSuite(LinearPanelTest.class);
    suite.addTestSuite(ListBoxTest.class);
    suite.addTestSuite(MenuBarTest.class);
    suite.addTestSuite(MenuItemTest.class);
    suite.addTestSuite(NamedFrameTest.class);
    suite.addTestSuite(NativeHorizontalScrollbarTest.class);
    suite.addTestSuite(NativeVerticalScrollbarTest.class);
    suite.addTestSuite(PopupTest.class);
    suite.addTestSuite(PrefixTreeTest.class);
    suite.addTestSuite(RadioButtonTest.class);
    suite.addTestSuite(ResetButtonTest.class);
    suite.addTestSuite(ResizeLayoutPanelTest.class);
    suite.addTestSuite(RichTextAreaTest.class);
    suite.addTestSuite(RootPanelTest.class);
    suite.addTestSuite(ScrollPanelTest.class);
    suite.addTestSuite(SimpleCheckBoxTest.class);
    suite.addTestSuite(SimpleRadioButtonTest.class);
    suite.addTestSuite(SimplePanelTest.class);
    suite.addTestSuite(SimpleLayoutPanelTest.class);
    suite.addTestSuite(SplitLayoutPanelTest.class);
    suite.addTestSuite(StackLayoutPanelTest.class);
    suite.addTestSuite(StackPanelTest.class);
    suite.addTestSuite(SubmitButtonTest.class);
    suite.addTestSuite(SuggestBoxTest.class);
    suite.addTestSuite(TabBarTest.class);
    suite.addTestSuite(TabLayoutPanelTest.class);
    suite.addTestSuite(TabPanelTest.class);
    suite.addTestSuite(TextAreaTest.class);
    suite.addTestSuite(TouchEventSinkTest.class);
    suite.addTestSuite(TreeTest.class);
    suite.addTestSuite(TreeItemTest.class);
    suite.addTestSuite(UIObjectTest.class);
    suite.addTestSuite(ValueBoxBaseTest.class);
    suite.addTestSuite(ValueListBoxTest.class);
    suite.addTestSuite(ValuePickerTest.class);
    suite.addTestSuite(VerticalPanelTest.class);
    suite.addTestSuite(VerticalSplitPanelTest.class);
    suite.addTestSuite(WidgetCollectionTest.class);
    suite.addTestSuite(WidgetIteratorsTest.class);
    suite.addTestSuite(WidgetOnLoadTest.class);
    suite.addTestSuite(WidgetSubclassingTest.class);
    suite.addTestSuite(WidgetTest.class);

    return suite;
  }
}
