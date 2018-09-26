//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.gwtproject.core.client;

import elemental2.dom.DomGlobal;
import elemental2.dom.DomGlobal.SetTimeoutCallbackFn;
import jsinterop.annotations.JsMethod;

public final class GWT {

  public interface UncaughtExceptionHandler {
    void onUncaughtException(Throwable e);
  }

  public GWT() {
  }


  public static void setUncaughtExceptionHandler(UncaughtExceptionHandler handler) {

  }

  /** @deprecated */
  @Deprecated
  public static <T> T create(Class<?> clazz) {
    return null;
  }

  /** @deprecated */
  @Deprecated
  public static boolean isProdMode() {
    return !"on".equals(System.getProperty("superdevmode"));
  }

  /** @deprecated */
  @Deprecated
  public static String getModuleName() {
    return null;
  }

  /** @deprecated */
  @Deprecated
  public static String getModuleBaseURL() {
    return null;
  }

  /** @deprecated */
  @Deprecated
  public static void log(String msg) {

  }

  /** @deprecated */
  @Deprecated
  public static void log(String msg, Exception e) {

  }

  /** @deprecated */
  @Deprecated
  public static void reportUncaughtException(Throwable e) {
    DomGlobal.setTimeout((ignore) -> {
      throw_(e);
    }, 0.0D, new Object[0]);
  }

  @JsMethod(
      namespace = "<window>",
      name = "throw"
  )
  private static native void throw_(Object var0);

  public static boolean isScript() {
    return true;
  }
}
