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
package org.gwtproject.view;

import com.google.gwt.junit.tools.GWTTestSuite;
import org.gwtproject.view.client.AbstractDataProviderTest;
import org.gwtproject.view.client.AbstractSelectionModelTest;
import org.gwtproject.view.client.AsyncDataProviderTest;
import org.gwtproject.view.client.DefaultNodeInfoTest;
import org.gwtproject.view.client.DefaultSelectionEventManagerTest;
import org.gwtproject.view.client.DefaultSelectionModelTest;
import org.gwtproject.view.client.ListDataProviderTest;
import org.gwtproject.view.client.MultiSelectionModelTest;
import org.gwtproject.view.client.NoSelectionModelTest;
import org.gwtproject.view.client.OrderedMultiSelectionModelTest;
import org.gwtproject.view.client.RangeTest;
import org.gwtproject.view.client.SingleSelectionModelTest;

import junit.framework.Test;

/**
 * Tests of the view package.
 */
public class ViewSuite {
  public static Test suite() {
    GWTTestSuite suite = new GWTTestSuite("Test suite for all view classes");

    suite.addTestSuite(AbstractDataProviderTest.class);
    suite.addTestSuite(AbstractSelectionModelTest.class);
    suite.addTestSuite(AsyncDataProviderTest.class);
    suite.addTestSuite(DefaultNodeInfoTest.class);
    suite.addTestSuite(DefaultSelectionEventManagerTest.class);
    suite.addTestSuite(DefaultSelectionModelTest.class);
    suite.addTestSuite(ListDataProviderTest.class);
    suite.addTestSuite(MultiSelectionModelTest.class);
    suite.addTestSuite(NoSelectionModelTest.class);
    suite.addTestSuite(OrderedMultiSelectionModelTest.class);
    suite.addTestSuite(RangeTest.class);
    suite.addTestSuite(SingleSelectionModelTest.class);
    return suite;
  }
}
