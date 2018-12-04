package org.gwtproject.i18n.shared;

import org.gwtproject.i18n.client.HasDirection;
import org.gwtproject.i18n.client.HasDirection.Direction;
import org.gwtproject.safehtml.shared.SafeHtml;

public abstract class DirectionEstimator {
    public DirectionEstimator() {
    }

    public abstract Direction estimateDirection(String var1);

    public Direction estimateDirection(String str, boolean isHtml) {
        return null;
    }

    public Direction estimateDirection(SafeHtml html) {
        return null;
    }
}
