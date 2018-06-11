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
  - `MediaEventsSinkTest` (also not part of [gwt-media](https://github.com/vegegoku/gwt-media))
  - `TouchEventSinkTest`

### Blockers - Cyclic dependencies

- `ValuePicker` in `gwt-widgets` uses `CellList` in `gwt-cell-widgets` which in turn depends on `Composite` in 
in `gwt-widgets`. 
  - Solution: `ValuePicker` needs to go into `gwt-cell-widgets` as it is technically a cell widget.
  - see https://github.com/jnehlmeier/gwt-widgets/commit/d184387
- `com.google.gwt.user.client.TakesValue` needs to exist somewhere.
  - When included in `gwt-widgets` we end up with: `ValueBoxBase` in `gwt-widgets` depends on `ValueBoxEditor` 
  in `gwt-editor` project which in turn depends on `TakesValue` in `gwt-widgets`.
- `ScrollPanel` in `gwt-widgets` depends on `TouchScroller` in an imaginary `gwt-touch` project which in turn depends 
on `HasScrolling` in `gwt-widgets`.
  - `com.google.gwt.touch.*` included in `gwt-widgets`. `HasScrolling` extends `IsWidget` which makes it tougher
  to create a separate project `gwt-touch` without circular dependency to `gwt-widgets`.
- `Label` in `gwt-widgets` depends on `HasTextEditor` in `gwt-editor` project which in turn depends on `HasText` 
in `gwt-widgets`.

Probable solution for last three cyclic dependencies is to create `gwt-widgets-behaviors` which contains all 
the `Has*` interfaces.