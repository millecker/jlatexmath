package org.scilab.forge.jlatexmath.platform.parser;

import org.scilab.forge.jlatexmath.exception.ResourceParseException;

public interface Parser {
  Document parse(Object input) throws ResourceParseException;

  void setIgnoringElementContentWhitespace(boolean whitespace);

  void setIgnoringComments(boolean ignoreComments);
}
