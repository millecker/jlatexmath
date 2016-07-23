package org.scilab.forge.jlatexmath.platform.graphics;

public interface Icon {

  void paintIcon(HasForegroundColor c, Graphics2DInterface g, int x, int y);

  int getIconWidth();

  int getIconHeight();

}
