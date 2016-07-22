package org.scilab.forge.jlatexmath.platform.font;

public abstract class FontFactory {

  public abstract Font createFont(String name, int style, int size);
  
  public abstract TextLayout createTextLayout(String string, Font font,
      FontRenderContext fontRenderContext);

  public abstract TextAttributeProvider createTextAttributeProvider();

  public abstract FontLoader createFontLoader();

}
