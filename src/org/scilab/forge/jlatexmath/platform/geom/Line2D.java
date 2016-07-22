package org.scilab.forge.jlatexmath.platform.geom;

public interface Line2D {

  public interface Float extends Line2D {

  }

  double getX1();

  double getY1();

  double getX2();

  double getY2();

  void setLine(double x1, double y1, double x2, double y2);
}
