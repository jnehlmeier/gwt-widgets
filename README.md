# Work in Progress

This repository tries to make GWT SDK 2.x Widget API compatible to GWT 3 by removing old Browser support, GWT.create() and JSNI.

Commits can be rewritten at any time.

### Notes

- duplicated `test/com.google.gwt.layout.client.LayerFriend` because there is no `gwt-layout-tests.jar` but 
`LayoutPanelTest` currently wants to look at package private information.

### Breaking changes
  - To avoid dependency to GWT-RPC, `SuggestOracle.Request/Response` and `MultiWordSuggestion` do not 
  implement `IsSerializable` anymore. Instead they implement `Serializable`.

### Deprecations
\--

### Embedded stuff because of cyclic dependencies or because it is only used by widgets

- `com.google.gwt.canvas`: Canvas Widget
- `com.google.gwt.cell`: Cells
- `com.google.gwt.debug`: DebugInfo
- `com.google.gwt.editor.client.adapters`: Editor adapters for HasData, TakesValue
- `com.google.gwt.editor.ui.client.ValueBoxEditorDecorator`: A decorator widget which can show editor errors
- `com.google.gwt.editor.ui.client.adapters`: Editor adapters for HasText, ValueBox
- `com.google.gwt.event.shared.HandlerManager`: Deleted in gwt-event but required by widgets
- `com.google.gwt.media`: Audio/Video Widget
- `com.google.gwt.touch`: Touch support for ScrollPanel
- `com.google.gwt.user.cellview`: Cell based widgets (CellList, ...)
- `com.google.gwt.user.client.TakesValue`: primarly used by widgets so included here instead of own artifact
- `com.google.gwt.user.datepicker`: Date picker widget
- `com.google.gwt.user.theme`: widget themes
- `com.google.gwt.user.view`: support classes for cell based widgets
- `com.google.gwt.user.DOM.gwt.xml`: DOM and Event related classes included

### Required dependencies whose migration is still in progress
- gwt-text (https://github.com/vegegoku/gwt-text)
- gwt-i18n https://github.com/vegegoku/gwt-i18n)
- gwt-resources (https://github.com/treblereel/gwt-resources)