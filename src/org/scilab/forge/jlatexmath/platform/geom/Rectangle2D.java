package org.scilab.forge.jlatexmath.platform.geom;

public interface Rectangle2D {

  public interface Float extends Rectangle2D {

  }

  double getX();

  double getY();

  double getWidth();

  double getHeight();

  void setRectangle(double x, double y, double width, double height);

}
