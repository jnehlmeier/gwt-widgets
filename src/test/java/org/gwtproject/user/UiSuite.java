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
import org.gwtproject.user.client.ui.DOMRtlTest;
import org.gwtproject.user.client.ui.DOMTest;
import org.gwtproject.user.client.ui.AbsolutePanelTest;
import org.gwtproject.user.client.ui.AnchorTest;
import org.gwtproject.user.client.ui.ButtonTest;
import org.gwtproject.user.client.ui.CaptionPanelTest;
import org.gwtproject.user.client.ui.CheckBoxTest;
import org.gwtproject.user.client.ui.CompositeTest;
import org.gwtproject.user.client.ui.CreateEventTest;
import org.gwtproject.user.client.ui.CustomButtonTest;
import org.gwtproject.user.client.ui.CustomScrollPanelTest;
//import org.gwtproject.user.client.ui.DOMRtlTest;
//import org.gwtproject.user.client.ui.DOMTest;
import org.gwtproject.user.client.ui.DateBoxTest;
import org.gwtproject.user.client.ui.DatePickerTest;
import org.gwtproject.user.client.ui.DeckLayoutPanelTest;
import org.gwtproject.user.client.ui.DeckPanelTest;
import org.gwtproject.user.client.ui.DecoratedPopupTest;
import org.gwtproject.user.client.ui.DecoratedStackPanelTest;
import org.gwtproject.user.client.ui.DecoratedTabBarTest;
import org.gwtproject.user.client.ui.DecoratedTabPanelTest;
import org.gwtproject.user.client.ui.DecoratorPanelTest;
import org.gwtproject.user.client.ui.DefaultSuggestionDisplayTest;
import org.gwtproject.user.client.ui.DelegatingKeyboardListenerCollectionTest;
import org.gwtproject.user.client.ui.DialogBoxTest;
import org.gwtproject.user.client.ui.DirectionalTextHelperTest;
import org.gwtproject.user.client.ui.DisclosurePanelTest;
import org.gwtproject.user.client.ui.DockLayoutPanelRtlTest;
import org.gwtproject.user.client.ui.DockLayoutPanelTest;
import org.gwtproject.user.client.ui.DockPanelTest;
import org.gwtproject.user.client.ui.ElementWrappingTest;
import org.gwtproject.user.client.ui.FileUploadTest;
import org.gwtproject.user.client.ui.FiniteWidgetIteratorTest;
import org.gwtproject.user.client.ui.FlexTableTest;
import org.gwtproject.user.client.ui.FlowPanelTest;
import org.gwtproject.user.client.ui.FocusPanelTest;
import org.gwtproject.user.client.ui.FormPanelTest;
import org.gwtproject.user.client.ui.GridTest;
import org.gwtproject.user.client.ui.HTMLPanelTest;
import org.gwtproject.user.client.ui.HTMLTest;
import org.gwtproject.user.client.ui.HeaderPanelTest;
import org.gwtproject.user.client.ui.HiddenTest;
import org.gwtproject.user.client.ui.HistoryTest;
import org.gwtproject.user.client.ui.HistoryTestNoopTokenEncoder;
import org.gwtproject.user.client.ui.HorizontalPanelTest;
import org.gwtproject.user.client.ui.HorizontalSplitPanelTest;
import org.gwtproject.user.client.ui.HyperlinkTest;
import org.gwtproject.user.client.ui.ImageTest;
import org.gwtproject.user.client.ui.InlineHTMLTest;
import org.gwtproject.user.client.ui.InlineHyperlinkTest;
import org.gwtproject.user.client.ui.IsWidgetTest;
import org.gwtproject.user.client.ui.LabelTest;
import org.gwtproject.user.client.ui.LazyPanelTest;
import org.gwtproject.user.client.ui.LinearPanelTest;
import org.gwtproject.user.client.ui.ListBoxTest;
import org.gwtproject.user.client.ui.MenuBarTest;
import org.gwtproject.user.client.ui.MenuItemTest;
import org.gwtproject.user.client.ui.NamedFrameTest;
import org.gwtproject.user.client.ui.NativeHorizontalScrollbarTest;
import org.gwtproject.user.client.ui.NativeVerticalScrollbarTest;
import org.gwtproject.user.client.ui.PopupTest;
import org.gwtproject.user.client.ui.PrefixTreeTest;
import org.gwtproject.user.client.ui.RadioButtonTest;
import org.gwtproject.user.client.ui.ResetButtonTest;
import org.gwtproject.user.client.ui.ResizeLayoutPanelTest;
import org.gwtproject.user.client.ui.RichTextAreaTest;
import org.gwtproject.user.client.ui.RootPanelTest;
import org.gwtproject.user.client.ui.ScrollPanelTest;
import org.gwtproject.user.client.ui.SimpleCheckBoxTest;
import org.gwtproject.user.client.ui.SimpleLayoutPanelTest;
import org.gwtproject.user.client.ui.SimplePanelTest;
import org.gwtproject.user.client.ui.SimpleRadioButtonTest;
import org.gwtproject.user.client.ui.SplitLayoutPanelTest;
import org.gwtproject.user.client.ui.StackLayoutPanelTest;
import org.gwtproject.user.client.ui.StackPanelTest;
import org.gwtproject.user.client.ui.SubmitButtonTest;
import org.gwtproject.user.client.ui.SuggestBoxTest;
import org.gwtproject.user.client.ui.TabBarTest;
import org.gwtproject.user.client.ui.TabLayoutPanelTest;
import org.gwtproject.user.client.ui.TabPanelTest;
import org.gwtproject.user.client.ui.TextAreaTest;
import org.gwtproject.user.client.ui.TreeItemTest;
import org.gwtproject.user.client.ui.TreeTest;
import org.gwtproject.user.client.ui.UIObjectTest;
import org.gwtproject.user.client.ui.ValueBoxBaseTest;
import org.gwtproject.user.client.ui.ValueListBoxTest;
import org.gwtproject.user.client.ui.VerticalPanelTest;
import org.gwtproject.user.client.ui.VerticalSplitPanelTest;
import org.gwtproject.user.client.ui.WidgetCollectionTest;
import org.gwtproject.user.client.ui.WidgetIteratorsTest;
import org.gwtproject.user.client.ui.WidgetOnLoadTest;
import org.gwtproject.user.client.ui.WidgetSubclassingTest;
import org.gwtproject.user.client.ui.WidgetTest;
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
    suite.addTestSuite(DelegatingKeyboardListenerCollectionTest.class);
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
    suite.addTestSuite(GestureEventSinkTest.class);
    suite.addTestSuite(GridTest.class);
    suite.addTestSuite(HeaderPanelTest.class);
    suite.addTestSuite(HiddenTest.class);
    suite.addTestSuite(HistoryTest.class);
    suite.addTestSuite(HistoryTestNoopTokenEncoder.class);
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
