package org.scilab.forge.jlatexmath.platform.geom;

public interface Point2D {

  public interface Float extends Point2D {

  }

  double getX();

  double getY();

  void setX(double x);

  void setY(double y);

}
