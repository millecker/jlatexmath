package org.scilab.forge.jlatexmath.platform.font;

import org.scilab.forge.jlatexmath.exception.ResourceParseException;

public interface FontLoader {

  public static final float PIXELS_PER_POINT = 1.0f;

  Font loadFont(Object fontInt, String name) throws ResourceParseException;
}
