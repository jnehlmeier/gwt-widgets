/*
 * Copyright 2014 Google Inc.
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
package org.gwtproject.debug;

import org.gwtproject.debug.client.DebugInfoDisabledTest;
import org.gwtproject.debug.client.DebugInfoTest;
import com.google.gwt.junit.tools.GWTTestSuite;

import junit.framework.Test;

/**
 * Tests of the debug package.
 */
public class DebugSuite {
  public static Test suite() {
    GWTTestSuite suite = new GWTTestSuite("Test suite for org.gwtproject.debug");

    suite.addTestSuite(DebugInfoTest.class);
    suite.addTestSuite(DebugInfoDisabledTest.class);

    return suite;
  }
}
