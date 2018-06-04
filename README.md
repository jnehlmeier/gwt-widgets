# Work in Progress

This repository tries to make GWT SDK 2.x Widget API compatible to GWT 3 by removing old Browser support, GWT.create() and JSNI.

Commits can be rewritten at any time.

### Notes

- duplicated `test/com.google.gwt.layout.client.LayerFriend` because there is no `gwt-layout-tests.jar` but 
`LayoutPanelTest` currently wants to look at package private information.
- Some Tests in `UiSuite` commented and not imported in this project for now.
  - `DOMTest` (there might be a `gwt-user-dom` project)
  - `DOMRtlTest` (there might be a `gwt-user-dom` project)
- Date picker tests added to `UiSuite`
  - `CalendarUtilTest` (originally part of `MiscSuite`)
  - `DateChangeEventTest` (originally part of `MiscSuite`)
- `MiscSuite` contains some tests about certain events that might go into this project in the future
  - `DoubleClickEventSinkTest`
  - `DragAndDropEventsSinkTest`
  - `GestureEventSinkTest`
  - `MediaEventsSinkTest` (also not part of [gwt-media](https://github.com/vegegoku/gwt-media)
  - `TouchEventSinkTest`
