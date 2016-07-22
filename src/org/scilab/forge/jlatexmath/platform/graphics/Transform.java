package org.scilab.forge.jlatexmath.platform.graphics;

public interface Transform {

  double getTranslateX();

  double getTranslateY();

  double getScaleX();

  double getScaleY();

  double getShearX();

  double getShearY();

  Transform createClone();

  void scale(double sx, double sy);

  void translate(double tx, double ty);

  void shear(double sx, double sy);

}
