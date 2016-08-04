package org.scilab.forge.jlatexmath.platform.font;

import java.util.Map;

public interface Font {

  public static final int PLAIN = 0;
  public static final int BOLD = 1;
  public static final int ITALIC = 2;

  Font deriveFont(Map<TextAttribute, Object> map);

  Font deriveFont(int type);

  boolean isEqual(Font f);
}
