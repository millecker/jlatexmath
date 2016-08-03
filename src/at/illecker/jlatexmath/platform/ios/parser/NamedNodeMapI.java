package at.illecker.jlatexmath.platform.ios.parser;

import org.scilab.forge.jlatexmath.platform.parser.NamedNodeMap;
import org.scilab.forge.jlatexmath.platform.parser.Node;

public class NamedNodeMapI implements NamedNodeMap {
  private org.w3c.dom.NamedNodeMap impl;

  public NamedNodeMapI(org.w3c.dom.NamedNodeMap impl) {
    this.impl = impl;
  }

  @Override
  public int getLength() {
    return impl.getLength();
  }

  @Override
  public Node item(int index) {
    return new NodeI(impl.item(index));
  }

}
