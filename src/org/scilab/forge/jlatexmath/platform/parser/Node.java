package org.scilab.forge.jlatexmath.platform.parser;

public interface Node {

  public static final short ELEMENT_NODE = 1;
  public static final short ATTRIBUTE_NODE = 2;
  public static final short TEXT_NODE = 3;
  public static final short CDATA_SECTION_NODE = 4;
  public static final short ENTITY_REFERENCE_NODE = 5;
  public static final short ENTITY_NODE = 6;
  public static final short PROCESSING_INSTRUCTION_NODE = 7;
  public static final short COMMENT_NODE = 8;
  public static final short DOCUMENT_NODE = 9;
  public static final short DOCUMENT_TYPE_NODE = 10;
  public static final short DOCUMENT_FRAGMENT_NODE = 11;
  public static final short NOTATION_NODE = 12;

  short getNodeType();

  Element castToElement();

  Attr castToAttr();
}
