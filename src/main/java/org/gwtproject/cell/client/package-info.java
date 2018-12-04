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

/**
 * <p>Standard {@link org.gwtproject.cell.client.Cell} subclasses used by the
 * {@link org.gwtproject.user.cellview.client cellview} widgets.  The available
 * cell types are:
 * <ul>
 * <li>{@link org.gwtproject.cell.client.AbstractCell AbstractCell} - a convenience implementation for subclassing</li>
 * <li>{@link org.gwtproject.cell.client.ActionCell ActionCell} - a Button that responds to mouse clicks via a
 * {@link org.gwtproject.cell.client.ActionCell.Delegate Delegate} interface</li>
 * <li>{@link org.gwtproject.cell.client.ButtonCell ButtonCell} -  a cell that displays a button with custom text</li>
 * <li>{@link org.gwtproject.cell.client.Cell Cell} - the main interface<li>
 * <li>{@link org.gwtproject.cell.client.CheckboxCell CheckboxCell} -  a cell that display sa checkbox</li>
 * <li>{@link org.gwtproject.cell.client.ClickableTextCell ClickableTextCell} - HTML text that responds to mouse clicks</li>
 * <li>{@link org.gwtproject.cell.client.CompositeCell CompositeCell} - a cell that wraps other cells</li>
 * <li>{@link org.gwtproject.cell.client.DateCell DateCell} - a cell displays a date (NOTE: does not currently perform
 * any localization)</li>
 * <li>{@link org.gwtproject.cell.client.DatePickerCell DatePickerCell} - a cell that displays a date and allows editing
 * using a {@link org.gwtproject.user.datepicker.client.DatePicker DatePicker}
 * widget</li>
 * <li>{@link org.gwtproject.cell.client.EditTextCell EditTextCell} - a cell that displays editable text</li>
 * <li>{@link org.gwtproject.cell.client.IconCellDecorator IconCellDecorator} - a cell that adds an icon to another cell</li>
 * <li>{@link org.gwtproject.cell.client.NumberCell CurrencyCell} - a cell that displays a formatted number</li>
 * <li>{@link org.gwtproject.cell.client.SelectionCell SelectionCell} - a cell that displays a drop-down list</li>
 * <li>{@link org.gwtproject.cell.client.TextCell TextCell} - a cell that displays HTML text</li>
 * <li>{@link org.gwtproject.cell.client.TextInputCell TextInputCell} - a cell that provides text input</li>
 * </ul>
 * </p>
 * 
 * <p>In addition to cells, this package provides the following interfaces:
 * <ul>
 * <li>{@link org.gwtproject.cell.client.HasCell HasCell}</li>
 * <li>{@link org.gwtproject.cell.client.ValueUpdater ValueUpdater}</li>
 * <li>{@link org.gwtproject.cell.client.FieldUpdater FieldUpdater}</li>
 * </ul>
 * </p>
 * 
 * @since GWT 2.1
 */
package org.gwtproject.cell.client;
