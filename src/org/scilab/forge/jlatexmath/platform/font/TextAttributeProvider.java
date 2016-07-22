package org.scilab.forge.jlatexmath.platform.font;

public interface TextAttributeProvider {

  TextAttribute getTextAttribute(String name);

  Integer getTextAttributeValue(String name);

}
