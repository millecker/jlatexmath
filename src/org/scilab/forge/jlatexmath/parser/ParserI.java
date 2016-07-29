package org.scilab.forge.jlatexmath.parser;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;

import org.scilab.forge.jlatexmath.exception.ResourceParseException;
import org.scilab.forge.jlatexmath.platform.parser.Document;
import org.scilab.forge.jlatexmath.platform.parser.Parser;

public class ParserI implements Parser {
  private DocumentBuilderFactory factory;

  public ParserI() {
    factory = DocumentBuilderFactory.newInstance();
  }

  @Override
  public Document parse(Object input) throws ResourceParseException {
    InputStream is = (InputStream) input;
    org.w3c.dom.Document document = tryParse(is);
    return new DocumentI(document);
  }

  private org.w3c.dom.Document tryParse(InputStream is)
      throws ResourceParseException {
    try {
      return factory.newDocumentBuilder().parse(is);
    } catch (Exception ex) {
      ResourceParseException rpe = new ResourceParseException(
          "Could not parse resource", ex);
      throw rpe;
    }
  }

  @Override
  public void setIgnoringElementContentWhitespace(boolean whitespace) {
    factory.setIgnoringElementContentWhitespace(whitespace);
  }

  @Override
  public void setIgnoringComments(boolean ignoreComments) {
    factory.setIgnoringComments(ignoreComments);
  }

}
