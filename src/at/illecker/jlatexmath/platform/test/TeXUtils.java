package at.illecker.jlatexmath.platform.test;

import org.scilab.forge.jlatexmath.ColorUtil;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;
import org.scilab.forge.jlatexmath.platform.FactoryProvider;
import org.scilab.forge.jlatexmath.platform.graphics.Color;
import org.scilab.forge.jlatexmath.platform.graphics.Graphics2DInterface;
import org.scilab.forge.jlatexmath.platform.graphics.GraphicsFactory;
import org.scilab.forge.jlatexmath.platform.graphics.Image;
import org.scilab.forge.jlatexmath.platform.graphics.Insets;

public final class TeXUtils {

  public static TeXFormula createTeXFormula(String latex) {
    try {
      return new TeXFormula(latex);
    } catch (Throwable e) {
      e.printStackTrace();
    }
    return null;
  }

  public static TeXIcon createTeXIcon(TeXFormula formula, int style, float size,
      int insets) {
    TeXIcon icon = formula.new TeXIconBuilder().setStyle(style).setSize(size)
        .build();

    icon.setInsets(new Insets(insets, insets, insets, insets));
    return icon;
  }

  public static Image createImage(String latex) {
    TeXFormula formula = createTeXFormula(latex);
    TeXIcon icon = createTeXIcon(formula, TeXConstants.STYLE_DISPLAY, 20, 5);
    return createImage(icon);
  }

  public static Image createImage(TeXIcon icon) {
    return createImage(icon, ColorUtil.WHITE, ColorUtil.BLACK, false, 0);
  }

  public static Image createImage(TeXIcon icon, Color bg, Color fg,
      boolean transparency, int imageType) {

    int width = icon.getIconWidth();
    int height = icon.getIconHeight();

    if (imageType <= 0) {
      imageType = transparency ? Image.TYPE_INT_ARGB : Image.TYPE_INT_RGB;
    }

    GraphicsFactory graphics = FactoryProvider.INSTANCE.getGraphicsFactory();
    Image image = graphics.createImage(width, height, imageType);

    Graphics2DInterface g2 = image.createGraphics2D();

    if (bg != null && !transparency) {
      g2.setColor(bg);
      g2.fillRect(0, 0, width, height);
    }

    icon.setForeground(fg);
    icon.paintIcon(null, g2, 0, 0);

    g2.dispose();

    return image;
  }

}
