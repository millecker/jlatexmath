package org.scilab.forge.jlatexmath;

public class BitSet {
  public int bitSet = 0;

  public BitSet() {

  }

  public void setBit(int bitIndex) {
    bitSet |= (1 << bitIndex);
  }

  public boolean getBit(int bitIndex) {
    return ((bitSet >> bitIndex) & 1) == 1;
  }

}
