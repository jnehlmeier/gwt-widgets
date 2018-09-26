package org.gwtproject.i18n.client;

import com.google.gwt.i18n.client.HasDirection;
import com.google.gwt.i18n.shared.DirectionEstimator;
import org.gwtproject.event.dom.client.HasKeyUpHandlers;
import org.gwtproject.user.client.ui.ValueBoxBase;

public class AutoDirectionHandler {

  public interface Target extends HasDirection, HasKeyUpHandlers {
    String getText();
    void setText(String text);
  }

  public static <T> AutoDirectionHandler addTo(Target target, boolean bidiEnabled) {
    return null;
  }

  public DirectionEstimator getDirectionEstimator() {
    return null;
  }

  public void setDirectionEstimator(DirectionEstimator directionEstimator) {

  }

  public void refreshDirection() {

  }

  public void setDirectionEstimator(boolean enabled) {

  }
}
