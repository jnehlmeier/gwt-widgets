# Work in Progress

This repository tries to make GWT SDK 2.x Widget API compatible to GWT 3 by removing old Browser support, GWT.create() and JSNI.

Commits can be rewritten at any time.

### Notes

- duplicated `test/com.google.gwt.layout.client.LayerFriend` because there is no `gwt-layout-tests.jar` but 
`LayoutPanelTest` currently wants to look at package private information.

### Breaking changes
  - To avoid dependency to GWT-RPC, `SuggestOracle.Request/Response` and `MultiWordSuggestion` do not 
  implement `IsSerializable` anymore. Instead they implement `Serializable`.


### Embedded stuff because of cyclic dependencies

- `com.google.gwt.canvas`: Canvas Widget
- `com.google.gwt.media`: Audio/Video Widget
- `com.google.gwt.touch`: TouchScroller included
- `com.google.gwt.user.datepicker`: DatePicker Widget
- `com.google.gwt.[cell,view,user.cellview]`: Cell Widgets included
- `com.google.gwt.editor.ui.client`: Editor Adapters for HasText / ValueBoxBase, as well as ValueBoxEditorDecorator
- `com.google.gwt.user.DOM.gwt.xml`: DOM and Event related classes included
- `com.google.gwt.user.client.TakesValue`: needs to exist in some project and is mostly used by widgets
- `com.google.gwt.editor.client.adapters.TakesValueEditor`: needs to exist in some project and is mostly used by widgets
