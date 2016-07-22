package org.scilab.forge.jlatexmath.platform.font;

import org.scilab.forge.jlatexmath.platform.geom.Rectangle2D;
import org.scilab.forge.jlatexmath.platform.graphics.Graphics2DInterface;

public interface TextLayout {
  Rectangle2D getBounds();

  draw(Graphics2DInterface graphics, int x, int y);
}
