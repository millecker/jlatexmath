package org.scilab.forge.jlatexmath.platform.parser;

public interface Element extends Node {
  NodeList getElementsByTagName(String name);

  String getAttribute(String name);

  String getTagName();

  NodeList getChildNodes();

  NamedNodeMap getAttributes();

  boolean isNull();
}
