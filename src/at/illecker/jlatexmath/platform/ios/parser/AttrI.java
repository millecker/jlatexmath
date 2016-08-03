package at.illecker.jlatexmath.platform.ios.parser;

import org.scilab.forge.jlatexmath.platform.parser.Attr;

public class AttrI extends NodeI implements Attr {
  public org.w3c.dom.Attr impl_AttrI;

  public AttrI(org.w3c.dom.Attr impl) {
    super(impl);
    impl_AttrI = impl;
  }

  @Override
  public String getName() {
    return impl_AttrI.getName();
  }

  @Override
  public boolean isSpecified() {
    return impl_AttrI.getSpecified();
  }

  @Override
  public String getValue() {
    return impl_AttrI.getValue();
  }

}
