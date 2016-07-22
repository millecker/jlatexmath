package org.scilab.forge.jlatexmath.platform.graphics;

import org.scilab.forge.jlatexmath.platform.font.Font;
import org.scilab.forge.jlatexmath.platform.font.FontRenderContext;
import org.scilab.forge.jlatexmath.platform.geom.Line2D;
import org.scilab.forge.jlatexmath.platform.geom.Rectangle2D;
import org.scilab.forge.jlatexmath.platform.geom.RoundRectangle2D;

public interface Graphics2DInterface {

  void setStroke(Stroke stroke);

  Stroke getStroke();

  void setColor(Color color);

  Color getColor();

  Transform getTransform();

  void saveTransformation();

  void restoreTransformation();

  Font getFont();

  void setFont(Font font);

  void fillRect(int x, int y, int width, int height);

  void fill(Rectangle2D rectangle);

  void draw(Rectangle2D rectangle);

  void draw(RoundRectangle2D rectangle);

  void draw(Line2D line);

  void drawChars(char[] data, int offset, int length, int x, int y);

  void drawArc(int x, int y, int width, int height, int startAngle,
      int arcAngle);

  void fillArc(int x, int y, int width, int height, int startAngle,
      int arcAngle);

  void translate(double x, double y);

  void scale(double x, double y);

  void rotate(double theta, double x, double y);

  void rotate(double theta);

  void drawImage(Image image, int x, int y);

  void drawImage(Image image, Transform transform);

  FontRenderContext getFontRenderContext();

  void setRenderingHint(int key, int value);

  int getRenderingHint(int key);

  void dispose();

}
