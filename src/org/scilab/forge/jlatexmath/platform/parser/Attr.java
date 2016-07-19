package org.scilab.forge.jlatexmath.platform.parser;

public interface Attr extends Node {
  String getName();

  boolean isSpecified();

  String getValue();
}
