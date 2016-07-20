package org.scilab.forge.jlatexmath.parser;

import org.scilab.forge.jlatexmath.platform.parser.Element;
import org.scilab.forge.jlatexmath.platform.parser.NamedNodeMap;
import org.scilab.forge.jlatexmath.platform.parser.NodeList;

public class ElementI extends NodeI implements Element {
  private org.w3c.dom.Element impl_ElementI;

  public ElementI(org.w3c.dom.Element impl) {
    super(impl);
    impl_ElementI = impl;
  }

  @Override
  public NodeList getElementsByTagName(String name) {
    return new NodeListI(impl_ElementI.getElementsByTagName(name));
  }

  @Override
  public String getAttribute(String name) {
    return impl_ElementI.getAttribute(name);
  }

  @Override
  public String getTagName() {
    return impl_ElementI.getTagName();
  }

  @Override
  public NodeList getChildNodes() {
    return new NodeListI(impl_ElementI.getChildNodes());
  }

  @Override
  public NamedNodeMap getAttributes() {
    return new NamedNodeMapI(impl_ElementI.getAttributes());
  }

  @Override
  public boolean isNull() {
    return impl_ElementI == null;
  }

}
