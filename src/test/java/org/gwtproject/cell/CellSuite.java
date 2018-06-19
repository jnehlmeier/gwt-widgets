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
package org.gwtproject.cell;

import org.gwtproject.cell.client.AbstractCellTest;
import org.gwtproject.cell.client.ActionCellTest;
import org.gwtproject.cell.client.ButtonCellTest;
import org.gwtproject.cell.client.CheckboxCellTest;
import org.gwtproject.cell.client.ClickableTextCellTest;
import org.gwtproject.cell.client.CompositeCellTest;
import org.gwtproject.cell.client.DateCellTest;
import org.gwtproject.cell.client.DatePickerCellTest;
import org.gwtproject.cell.client.EditTextCellTest;
import org.gwtproject.cell.client.IconCellDecoratorTest;
import org.gwtproject.cell.client.ImageCellTest;
import org.gwtproject.cell.client.ImageLoadingCellTest;
import org.gwtproject.cell.client.ImageResourceCellTest;
import org.gwtproject.cell.client.NumberCellTest;
import org.gwtproject.cell.client.SelectionCellTest;
import org.gwtproject.cell.client.TextButtonCellTest;
import org.gwtproject.cell.client.TextCellTest;
import org.gwtproject.cell.client.TextInputCellTest;
import com.google.gwt.junit.tools.GWTTestSuite;

import junit.framework.Test;

/**
 * Tests of the cell package.
 */
public class CellSuite {
  public static Test suite() {
    GWTTestSuite suite = new GWTTestSuite("Test suite for all cell classes");

    suite.addTestSuite(AbstractCellTest.class);
    suite.addTestSuite(ActionCellTest.class);
    suite.addTestSuite(ButtonCellTest.class);
    suite.addTestSuite(CheckboxCellTest.class);
    suite.addTestSuite(ClickableTextCellTest.class);
    suite.addTestSuite(CompositeCellTest.class);
    suite.addTestSuite(DateCellTest.class);
    suite.addTestSuite(DatePickerCellTest.class);
    suite.addTestSuite(EditTextCellTest.class);
    suite.addTestSuite(IconCellDecoratorTest.class);
    suite.addTestSuite(ImageCellTest.class);
    suite.addTestSuite(ImageLoadingCellTest.class);
    suite.addTestSuite(ImageResourceCellTest.class);
    suite.addTestSuite(NumberCellTest.class);
    suite.addTestSuite(SelectionCellTest.class);
    suite.addTestSuite(TextButtonCellTest.class);
    suite.addTestSuite(TextCellTest.class);
    suite.addTestSuite(TextInputCellTest.class);
    return suite;
  }
}
