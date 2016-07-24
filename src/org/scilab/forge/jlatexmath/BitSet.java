package org.scilab.forge.jlatexmath;

import java.util.Arrays;

public class BitSet {
  private final static int ADDRESS_BITS_PER_WORD = 6;
  private final static int BITS_PER_WORD = 1 << ADDRESS_BITS_PER_WORD;

  private long[] words;
  private transient int wordsInUse = 0;
  private transient boolean sizeIsSticky = false;

  private static int wordIndex(int bitIndex) {
    return bitIndex >> ADDRESS_BITS_PER_WORD;
  }

  private void checkInvariants() {
    assert (wordsInUse == 0 || words[wordsInUse - 1] != 0);
    assert (wordsInUse >= 0 && wordsInUse <= words.length);
    assert (wordsInUse == words.length || words[wordsInUse] == 0);
  }

  public BitSet() {
    initWords(BITS_PER_WORD);
    sizeIsSticky = false;
  }

  public BitSet(int nbits) {
    // nbits can't be negative; size 0 is OK
    if (nbits < 0)
      throw new NegativeArraySizeException("nbits < 0: " + nbits);

    initWords(nbits);
    sizeIsSticky = true;
  }

  private void initWords(int nbits) {
    words = new long[wordIndex(nbits - 1) + 1];
  }

  private void ensureCapacity(int wordsRequired) {
    if (words.length < wordsRequired) {
      // Allocate larger of doubled size or required size
      int request = Math.max(2 * words.length, wordsRequired);
      words = Arrays.copyOf(words, request);
      sizeIsSticky = false;
    }
  }

  private void expandTo(int wordIndex) {
    int wordsRequired = wordIndex + 1;
    if (wordsInUse < wordsRequired) {
      ensureCapacity(wordsRequired);
      wordsInUse = wordsRequired;
    }
  }

  public void set(int bitIndex) {
    if (bitIndex < 0)
      throw new IndexOutOfBoundsException("bitIndex < 0: " + bitIndex);

    int wordIndex = wordIndex(bitIndex);
    expandTo(wordIndex);

    words[wordIndex] |= (1L << bitIndex); // Restores invariants

    checkInvariants();
  }

  public boolean get(int bitIndex) {
    if (bitIndex < 0)
      throw new IndexOutOfBoundsException("bitIndex < 0: " + bitIndex);

    checkInvariants();

    int wordIndex = wordIndex(bitIndex);
    return (wordIndex < wordsInUse)
        && ((words[wordIndex] & (1L << bitIndex)) != 0);
  }

}
