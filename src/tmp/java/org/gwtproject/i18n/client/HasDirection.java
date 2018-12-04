package org.gwtproject.i18n.client;

public interface HasDirection {
    public enum Direction {RTL, DEFAULT, LTR}
    HasDirection.Direction getDirection();
    void setDirection(HasDirection.Direction var1);
}
