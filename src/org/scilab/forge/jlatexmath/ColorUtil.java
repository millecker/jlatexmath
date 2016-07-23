package org.scilab.forge.jlatexmath;

import java.util.HashMap;
import java.util.Map;

import org.scilab.forge.jlatexmath.platform.FactoryProvider;
import org.scilab.forge.jlatexmath.platform.graphics.Color;
import org.scilab.forge.jlatexmath.platform.graphics.GraphicsFactory;

public class ColorUtil {

  public static final GraphicsFactory GRAPHICS_FACTORY;
  public static final Color RED;
  public static final Color BLACK;
  public static final Color WHITE;
  public static final Color BLUE;
  public static final Color GREEN;
  public static final Color CYAN;
  public static final Color MAGENTA;
  public static final Color YELLOW;
  public static final Map<String, Color> COLOR_CONSTANTS;
  private static StringBuilder sb;

  static {
    GRAPHICS_FACTORY = FactoryProvider.INSTANCE.getGraphicsFactory();
    RED = GRAPHICS_FACTORY.createColor(255, 0, 0);
    BLACK = GRAPHICS_FACTORY.createColor(0, 0, 0);
    WHITE = GRAPHICS_FACTORY.createColor(255, 255, 255);
    BLUE = GRAPHICS_FACTORY.createColor(0, 0, 255);
    GREEN = GRAPHICS_FACTORY.createColor(0, 255, 0);
    CYAN = GRAPHICS_FACTORY.createColor(0, 255, 255);
    MAGENTA = GRAPHICS_FACTORY.createColor(255, 0, 255);
    YELLOW = GRAPHICS_FACTORY.createColor(255, 255, 0);
    COLOR_CONSTANTS = new HashMap<String, Color>() {
      {
        put("RED", RED);
        put("BLACK", BLACK);
        put("WHITE", WHITE);
        put("BLUE", BLUE);
        put("GREEN", GREEN);
        put("CYAN", CYAN);
        put("MAGENTA", MAGENTA);
        put("YELLOW", YELLOW);
      }
    };
    sb = new StringBuilder("#");
  }

  public static Color decode(String string) throws NumberFormatException {
    Integer intval = Integer.decode(string);
    int i = intval.intValue();
    return GRAPHICS_FACTORY.createColor((i >> 16) & 0xFF, (i >> 8) & 0xFF,
        i & 0xFF);
  }

  public static String encode(Color color) {
    int colorInt = color.getColor();
    int r = (colorInt & 0xFF000000) >> 24;
    int g = (colorInt & 0x00FF0000) >> 16;
    int b = (colorInt & 0x0000FF00) >> 8;
    sb.setLength(1);
    sb.append('#');
    sb.append(pad(Integer.toHexString(r)));
    sb.append(pad(Integer.toHexString(g)));
    sb.append(pad(Integer.toHexString(b)));
    return sb.toString();
  }

  private static String pad(String hex) {
    if (hex.length() == 0) {
      return "00";
    } else if (hex.length() == 1) {
      return "0" + hex;
    }
    return hex;
  }
}
