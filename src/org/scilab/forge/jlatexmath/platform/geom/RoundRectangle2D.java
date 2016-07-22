package org.scilab.forge.jlatexmath.platform.geom;

public interface RoundRectangle2D {

  public interface Float extends RoundRectangle2D {

  }

  double getArcW();

  double getArcH();

  double getX();

  double getY();

  double getWidth();

  double getHeight();

  void setRoundRectangle(double x, double y, double w, double h, double arcw,
      double arch);

}
