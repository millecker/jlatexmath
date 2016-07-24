package org.scilab.forge.jlatexmath.character;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class Character {

  public static final int MIN_RADIX = 2;

  public static final int MAX_RADIX = 36;

  public static final char MIN_VALUE = '\u0000';

  public static final char MAX_VALUE = '\uFFFF';

  public static final byte UNASSIGNED = 0;

  public static final byte UPPERCASE_LETTER = 1;

  public static final byte LOWERCASE_LETTER = 2;

  public static final byte TITLECASE_LETTER = 3;

  public static final byte MODIFIER_LETTER = 4;

  public static final byte OTHER_LETTER = 5;

  public static final byte NON_SPACING_MARK = 6;

  public static final byte ENCLOSING_MARK = 7;

  public static final byte COMBINING_SPACING_MARK = 8;

  public static final byte DECIMAL_DIGIT_NUMBER = 9;

  public static final byte LETTER_NUMBER = 10;

  public static final byte OTHER_NUMBER = 11;

  public static final byte SPACE_SEPARATOR = 12;

  public static final byte LINE_SEPARATOR = 13;

  public static final byte PARAGRAPH_SEPARATOR = 14;

  public static final byte CONTROL = 15;

  public static final byte FORMAT = 16;

  public static final byte PRIVATE_USE = 18;

  public static final byte SURROGATE = 19;

  public static final byte DASH_PUNCTUATION = 20;

  public static final byte START_PUNCTUATION = 21;

  public static final byte END_PUNCTUATION = 22;

  public static final byte CONNECTOR_PUNCTUATION = 23;

  public static final byte OTHER_PUNCTUATION = 24;

  public static final byte MATH_SYMBOL = 25;

  public static final byte CURRENCY_SYMBOL = 26;

  public static final byte MODIFIER_SYMBOL = 27;

  public static final byte OTHER_SYMBOL = 28;

  public static final byte INITIAL_QUOTE_PUNCTUATION = 29;

  public static final byte FINAL_QUOTE_PUNCTUATION = 30;

  static final int ERROR = 0xFFFFFFFF;

  public static final byte DIRECTIONALITY_UNDEFINED = -1;

  public static final byte DIRECTIONALITY_LEFT_TO_RIGHT = 0;

  public static final byte DIRECTIONALITY_RIGHT_TO_LEFT = 1;

  public static final byte DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC = 2;

  public static final byte DIRECTIONALITY_EUROPEAN_NUMBER = 3;

  public static final byte DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR = 4;

  public static final byte DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR = 5;

  public static final byte DIRECTIONALITY_ARABIC_NUMBER = 6;

  public static final byte DIRECTIONALITY_COMMON_NUMBER_SEPARATOR = 7;

  public static final byte DIRECTIONALITY_NONSPACING_MARK = 8;

  public static final byte DIRECTIONALITY_BOUNDARY_NEUTRAL = 9;

  public static final byte DIRECTIONALITY_PARAGRAPH_SEPARATOR = 10;

  public static final byte DIRECTIONALITY_SEGMENT_SEPARATOR = 11;

  public static final byte DIRECTIONALITY_WHITESPACE = 12;

  public static final byte DIRECTIONALITY_OTHER_NEUTRALS = 13;

  public static final byte DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING = 14;

  public static final byte DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE = 15;

  public static final byte DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING = 16;

  public static final byte DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE = 17;

  public static final byte DIRECTIONALITY_POP_DIRECTIONAL_FORMAT = 18;

  public static final char MIN_HIGH_SURROGATE = '\uD800';

  public static final char MAX_HIGH_SURROGATE = '\uDBFF';

  public static final char MIN_LOW_SURROGATE = '\uDC00';

  public static final char MAX_LOW_SURROGATE = '\uDFFF';

  public static final char MIN_SURROGATE = MIN_HIGH_SURROGATE;

  public static final char MAX_SURROGATE = MAX_LOW_SURROGATE;

  public static final int MIN_SUPPLEMENTARY_CODE_POINT = 0x010000;

  public static final int MIN_CODE_POINT = 0x000000;

  public static final int MAX_CODE_POINT = 0X10FFFF;

  public static class Subset {

    private String name;

    protected Subset(String name) {
      if (name == null) {
        throw new NullPointerException("name");
      }
      this.name = name;
    }

    public final boolean equals(Object obj) {
      return (this == obj);
    }

    public final int hashCode() {
      return super.hashCode();
    }

    public final String toString() {
      return name;
    }
  }

  // See http://www.unicode.org/Public/UNIDATA/Blocks.txt
  // for the latest specification of Unicode Blocks.
  public static final class UnicodeBlock extends Subset {

    private static Map<String, UnicodeBlock> map = new HashMap<>(256);

    private UnicodeBlock(String idName) {
      super(idName);
      map.put(idName, this);
    }

    private UnicodeBlock(String idName, String alias) {
      this(idName);
      map.put(alias, this);
    }

    private UnicodeBlock(String idName, String... aliases) {
      this(idName);
      for (String alias : aliases)
        map.put(alias, this);
    }

    public static final UnicodeBlock BASIC_LATIN = new UnicodeBlock(
        "BASIC_LATIN", "BASIC LATIN", "BASICLATIN");

    public static final UnicodeBlock LATIN_1_SUPPLEMENT = new UnicodeBlock(
        "LATIN_1_SUPPLEMENT", "LATIN-1 SUPPLEMENT", "LATIN-1SUPPLEMENT");

    public static final UnicodeBlock LATIN_EXTENDED_A = new UnicodeBlock(
        "LATIN_EXTENDED_A", "LATIN EXTENDED-A", "LATINEXTENDED-A");

    public static final UnicodeBlock LATIN_EXTENDED_B = new UnicodeBlock(
        "LATIN_EXTENDED_B", "LATIN EXTENDED-B", "LATINEXTENDED-B");

    public static final UnicodeBlock IPA_EXTENSIONS = new UnicodeBlock(
        "IPA_EXTENSIONS", "IPA EXTENSIONS", "IPAEXTENSIONS");

    public static final UnicodeBlock SPACING_MODIFIER_LETTERS = new UnicodeBlock(
        "SPACING_MODIFIER_LETTERS", "SPACING MODIFIER LETTERS",
        "SPACINGMODIFIERLETTERS");

    public static final UnicodeBlock COMBINING_DIACRITICAL_MARKS = new UnicodeBlock(
        "COMBINING_DIACRITICAL_MARKS", "COMBINING DIACRITICAL MARKS",
        "COMBININGDIACRITICALMARKS");

    public static final UnicodeBlock GREEK = new UnicodeBlock("GREEK",
        "GREEK AND COPTIC", "GREEKANDCOPTIC");

    public static final UnicodeBlock CYRILLIC = new UnicodeBlock("CYRILLIC");

    public static final UnicodeBlock ARMENIAN = new UnicodeBlock("ARMENIAN");

    public static final UnicodeBlock HEBREW = new UnicodeBlock("HEBREW");

    public static final UnicodeBlock ARABIC = new UnicodeBlock("ARABIC");

    public static final UnicodeBlock DEVANAGARI = new UnicodeBlock(
        "DEVANAGARI");

    public static final UnicodeBlock BENGALI = new UnicodeBlock("BENGALI");

    public static final UnicodeBlock GURMUKHI = new UnicodeBlock("GURMUKHI");

    public static final UnicodeBlock GUJARATI = new UnicodeBlock("GUJARATI");

    public static final UnicodeBlock ORIYA = new UnicodeBlock("ORIYA");

    public static final UnicodeBlock TAMIL = new UnicodeBlock("TAMIL");

    public static final UnicodeBlock TELUGU = new UnicodeBlock("TELUGU");

    public static final UnicodeBlock KANNADA = new UnicodeBlock("KANNADA");

    public static final UnicodeBlock MALAYALAM = new UnicodeBlock("MALAYALAM");

    public static final UnicodeBlock THAI = new UnicodeBlock("THAI");

    public static final UnicodeBlock LAO = new UnicodeBlock("LAO");

    public static final UnicodeBlock TIBETAN = new UnicodeBlock("TIBETAN");

    public static final UnicodeBlock GEORGIAN = new UnicodeBlock("GEORGIAN");

    public static final UnicodeBlock HANGUL_JAMO = new UnicodeBlock(
        "HANGUL_JAMO", "HANGUL JAMO", "HANGULJAMO");

    public static final UnicodeBlock LATIN_EXTENDED_ADDITIONAL = new UnicodeBlock(
        "LATIN_EXTENDED_ADDITIONAL", "LATIN EXTENDED ADDITIONAL",
        "LATINEXTENDEDADDITIONAL");

    public static final UnicodeBlock GREEK_EXTENDED = new UnicodeBlock(
        "GREEK_EXTENDED", "GREEK EXTENDED", "GREEKEXTENDED");

    public static final UnicodeBlock GENERAL_PUNCTUATION = new UnicodeBlock(
        "GENERAL_PUNCTUATION", "GENERAL PUNCTUATION", "GENERALPUNCTUATION");

    public static final UnicodeBlock SUPERSCRIPTS_AND_SUBSCRIPTS = new UnicodeBlock(
        "SUPERSCRIPTS_AND_SUBSCRIPTS", "SUPERSCRIPTS AND SUBSCRIPTS",
        "SUPERSCRIPTSANDSUBSCRIPTS");

    public static final UnicodeBlock CURRENCY_SYMBOLS = new UnicodeBlock(
        "CURRENCY_SYMBOLS", "CURRENCY SYMBOLS", "CURRENCYSYMBOLS");

    public static final UnicodeBlock COMBINING_MARKS_FOR_SYMBOLS = new UnicodeBlock(
        "COMBINING_MARKS_FOR_SYMBOLS",
        "COMBINING DIACRITICAL MARKS FOR SYMBOLS",
        "COMBININGDIACRITICALMARKSFORSYMBOLS", "COMBINING MARKS FOR SYMBOLS",
        "COMBININGMARKSFORSYMBOLS");

    public static final UnicodeBlock LETTERLIKE_SYMBOLS = new UnicodeBlock(
        "LETTERLIKE_SYMBOLS", "LETTERLIKE SYMBOLS", "LETTERLIKESYMBOLS");

    public static final UnicodeBlock NUMBER_FORMS = new UnicodeBlock(
        "NUMBER_FORMS", "NUMBER FORMS", "NUMBERFORMS");

    public static final UnicodeBlock ARROWS = new UnicodeBlock("ARROWS");

    public static final UnicodeBlock MATHEMATICAL_OPERATORS = new UnicodeBlock(
        "MATHEMATICAL_OPERATORS", "MATHEMATICAL OPERATORS",
        "MATHEMATICALOPERATORS");

    public static final UnicodeBlock MISCELLANEOUS_TECHNICAL = new UnicodeBlock(
        "MISCELLANEOUS_TECHNICAL", "MISCELLANEOUS TECHNICAL",
        "MISCELLANEOUSTECHNICAL");

    public static final UnicodeBlock CONTROL_PICTURES = new UnicodeBlock(
        "CONTROL_PICTURES", "CONTROL PICTURES", "CONTROLPICTURES");

    public static final UnicodeBlock OPTICAL_CHARACTER_RECOGNITION = new UnicodeBlock(
        "OPTICAL_CHARACTER_RECOGNITION", "OPTICAL CHARACTER RECOGNITION",
        "OPTICALCHARACTERRECOGNITION");

    public static final UnicodeBlock ENCLOSED_ALPHANUMERICS = new UnicodeBlock(
        "ENCLOSED_ALPHANUMERICS", "ENCLOSED ALPHANUMERICS",
        "ENCLOSEDALPHANUMERICS");

    public static final UnicodeBlock BOX_DRAWING = new UnicodeBlock(
        "BOX_DRAWING", "BOX DRAWING", "BOXDRAWING");

    public static final UnicodeBlock BLOCK_ELEMENTS = new UnicodeBlock(
        "BLOCK_ELEMENTS", "BLOCK ELEMENTS", "BLOCKELEMENTS");

    public static final UnicodeBlock GEOMETRIC_SHAPES = new UnicodeBlock(
        "GEOMETRIC_SHAPES", "GEOMETRIC SHAPES", "GEOMETRICSHAPES");

    public static final UnicodeBlock MISCELLANEOUS_SYMBOLS = new UnicodeBlock(
        "MISCELLANEOUS_SYMBOLS", "MISCELLANEOUS SYMBOLS",
        "MISCELLANEOUSSYMBOLS");

    public static final UnicodeBlock DINGBATS = new UnicodeBlock("DINGBATS");

    public static final UnicodeBlock CJK_SYMBOLS_AND_PUNCTUATION = new UnicodeBlock(
        "CJK_SYMBOLS_AND_PUNCTUATION", "CJK SYMBOLS AND PUNCTUATION",
        "CJKSYMBOLSANDPUNCTUATION");

    public static final UnicodeBlock HIRAGANA = new UnicodeBlock("HIRAGANA");

    public static final UnicodeBlock KATAKANA = new UnicodeBlock("KATAKANA");

    public static final UnicodeBlock BOPOMOFO = new UnicodeBlock("BOPOMOFO");

    public static final UnicodeBlock HANGUL_COMPATIBILITY_JAMO = new UnicodeBlock(
        "HANGUL_COMPATIBILITY_JAMO", "HANGUL COMPATIBILITY JAMO",
        "HANGULCOMPATIBILITYJAMO");

    public static final UnicodeBlock KANBUN = new UnicodeBlock("KANBUN");

    public static final UnicodeBlock ENCLOSED_CJK_LETTERS_AND_MONTHS = new UnicodeBlock(
        "ENCLOSED_CJK_LETTERS_AND_MONTHS", "ENCLOSED CJK LETTERS AND MONTHS",
        "ENCLOSEDCJKLETTERSANDMONTHS");

    public static final UnicodeBlock CJK_COMPATIBILITY = new UnicodeBlock(
        "CJK_COMPATIBILITY", "CJK COMPATIBILITY", "CJKCOMPATIBILITY");

    public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS = new UnicodeBlock(
        "CJK_UNIFIED_IDEOGRAPHS", "CJK UNIFIED IDEOGRAPHS",
        "CJKUNIFIEDIDEOGRAPHS");

    public static final UnicodeBlock HANGUL_SYLLABLES = new UnicodeBlock(
        "HANGUL_SYLLABLES", "HANGUL SYLLABLES", "HANGULSYLLABLES");

    public static final UnicodeBlock PRIVATE_USE_AREA = new UnicodeBlock(
        "PRIVATE_USE_AREA", "PRIVATE USE AREA", "PRIVATEUSEAREA");

    public static final UnicodeBlock CJK_COMPATIBILITY_IDEOGRAPHS = new UnicodeBlock(
        "CJK_COMPATIBILITY_IDEOGRAPHS", "CJK COMPATIBILITY IDEOGRAPHS",
        "CJKCOMPATIBILITYIDEOGRAPHS");

    public static final UnicodeBlock ALPHABETIC_PRESENTATION_FORMS = new UnicodeBlock(
        "ALPHABETIC_PRESENTATION_FORMS", "ALPHABETIC PRESENTATION FORMS",
        "ALPHABETICPRESENTATIONFORMS");

    public static final UnicodeBlock ARABIC_PRESENTATION_FORMS_A = new UnicodeBlock(
        "ARABIC_PRESENTATION_FORMS_A", "ARABIC PRESENTATION FORMS-A",
        "ARABICPRESENTATIONFORMS-A");

    public static final UnicodeBlock COMBINING_HALF_MARKS = new UnicodeBlock(
        "COMBINING_HALF_MARKS", "COMBINING HALF MARKS", "COMBININGHALFMARKS");

    public static final UnicodeBlock CJK_COMPATIBILITY_FORMS = new UnicodeBlock(
        "CJK_COMPATIBILITY_FORMS", "CJK COMPATIBILITY FORMS",
        "CJKCOMPATIBILITYFORMS");

    public static final UnicodeBlock SMALL_FORM_VARIANTS = new UnicodeBlock(
        "SMALL_FORM_VARIANTS", "SMALL FORM VARIANTS", "SMALLFORMVARIANTS");

    public static final UnicodeBlock ARABIC_PRESENTATION_FORMS_B = new UnicodeBlock(
        "ARABIC_PRESENTATION_FORMS_B", "ARABIC PRESENTATION FORMS-B",
        "ARABICPRESENTATIONFORMS-B");

    public static final UnicodeBlock HALFWIDTH_AND_FULLWIDTH_FORMS = new UnicodeBlock(
        "HALFWIDTH_AND_FULLWIDTH_FORMS", "HALFWIDTH AND FULLWIDTH FORMS",
        "HALFWIDTHANDFULLWIDTHFORMS");

    public static final UnicodeBlock SPECIALS = new UnicodeBlock("SPECIALS");

    @Deprecated
    public static final UnicodeBlock SURROGATES_AREA = new UnicodeBlock(
        "SURROGATES_AREA");

    public static final UnicodeBlock SYRIAC = new UnicodeBlock("SYRIAC");

    public static final UnicodeBlock THAANA = new UnicodeBlock("THAANA");

    public static final UnicodeBlock SINHALA = new UnicodeBlock("SINHALA");

    public static final UnicodeBlock MYANMAR = new UnicodeBlock("MYANMAR");

    public static final UnicodeBlock ETHIOPIC = new UnicodeBlock("ETHIOPIC");

    public static final UnicodeBlock CHEROKEE = new UnicodeBlock("CHEROKEE");

    public static final UnicodeBlock UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS = new UnicodeBlock(
        "UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS",
        "UNIFIED CANADIAN ABORIGINAL SYLLABICS",
        "UNIFIEDCANADIANABORIGINALSYLLABICS");

    public static final UnicodeBlock OGHAM = new UnicodeBlock("OGHAM");

    public static final UnicodeBlock RUNIC = new UnicodeBlock("RUNIC");

    public static final UnicodeBlock KHMER = new UnicodeBlock("KHMER");

    public static final UnicodeBlock MONGOLIAN = new UnicodeBlock("MONGOLIAN");

    public static final UnicodeBlock BRAILLE_PATTERNS = new UnicodeBlock(
        "BRAILLE_PATTERNS", "BRAILLE PATTERNS", "BRAILLEPATTERNS");

    public static final UnicodeBlock CJK_RADICALS_SUPPLEMENT = new UnicodeBlock(
        "CJK_RADICALS_SUPPLEMENT", "CJK RADICALS SUPPLEMENT",
        "CJKRADICALSSUPPLEMENT");

    public static final UnicodeBlock KANGXI_RADICALS = new UnicodeBlock(
        "KANGXI_RADICALS", "KANGXI RADICALS", "KANGXIRADICALS");

    public static final UnicodeBlock IDEOGRAPHIC_DESCRIPTION_CHARACTERS = new UnicodeBlock(
        "IDEOGRAPHIC_DESCRIPTION_CHARACTERS",
        "IDEOGRAPHIC DESCRIPTION CHARACTERS",
        "IDEOGRAPHICDESCRIPTIONCHARACTERS");

    public static final UnicodeBlock BOPOMOFO_EXTENDED = new UnicodeBlock(
        "BOPOMOFO_EXTENDED", "BOPOMOFO EXTENDED", "BOPOMOFOEXTENDED");

    public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A = new UnicodeBlock(
        "CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A",
        "CJK UNIFIED IDEOGRAPHS EXTENSION A", "CJKUNIFIEDIDEOGRAPHSEXTENSIONA");

    public static final UnicodeBlock YI_SYLLABLES = new UnicodeBlock(
        "YI_SYLLABLES", "YI SYLLABLES", "YISYLLABLES");

    public static final UnicodeBlock YI_RADICALS = new UnicodeBlock(
        "YI_RADICALS", "YI RADICALS", "YIRADICALS");

    public static final UnicodeBlock CYRILLIC_SUPPLEMENTARY = new UnicodeBlock(
        "CYRILLIC_SUPPLEMENTARY", "CYRILLIC SUPPLEMENTARY",
        "CYRILLICSUPPLEMENTARY", "CYRILLIC SUPPLEMENT", "CYRILLICSUPPLEMENT");

    public static final UnicodeBlock TAGALOG = new UnicodeBlock("TAGALOG");

    public static final UnicodeBlock HANUNOO = new UnicodeBlock("HANUNOO");

    public static final UnicodeBlock BUHID = new UnicodeBlock("BUHID");

    public static final UnicodeBlock TAGBANWA = new UnicodeBlock("TAGBANWA");

    public static final UnicodeBlock LIMBU = new UnicodeBlock("LIMBU");

    public static final UnicodeBlock TAI_LE = new UnicodeBlock("TAI_LE",
        "TAI LE", "TAILE");

    public static final UnicodeBlock KHMER_SYMBOLS = new UnicodeBlock(
        "KHMER_SYMBOLS", "KHMER SYMBOLS", "KHMERSYMBOLS");

    public static final UnicodeBlock PHONETIC_EXTENSIONS = new UnicodeBlock(
        "PHONETIC_EXTENSIONS", "PHONETIC EXTENSIONS", "PHONETICEXTENSIONS");

    public static final UnicodeBlock MISCELLANEOUS_MATHEMATICAL_SYMBOLS_A = new UnicodeBlock(
        "MISCELLANEOUS_MATHEMATICAL_SYMBOLS_A",
        "MISCELLANEOUS MATHEMATICAL SYMBOLS-A",
        "MISCELLANEOUSMATHEMATICALSYMBOLS-A");

    public static final UnicodeBlock SUPPLEMENTAL_ARROWS_A = new UnicodeBlock(
        "SUPPLEMENTAL_ARROWS_A", "SUPPLEMENTAL ARROWS-A",
        "SUPPLEMENTALARROWS-A");

    public static final UnicodeBlock SUPPLEMENTAL_ARROWS_B = new UnicodeBlock(
        "SUPPLEMENTAL_ARROWS_B", "SUPPLEMENTAL ARROWS-B",
        "SUPPLEMENTALARROWS-B");

    public static final UnicodeBlock MISCELLANEOUS_MATHEMATICAL_SYMBOLS_B = new UnicodeBlock(
        "MISCELLANEOUS_MATHEMATICAL_SYMBOLS_B",
        "MISCELLANEOUS MATHEMATICAL SYMBOLS-B",
        "MISCELLANEOUSMATHEMATICALSYMBOLS-B");

    public static final UnicodeBlock SUPPLEMENTAL_MATHEMATICAL_OPERATORS = new UnicodeBlock(
        "SUPPLEMENTAL_MATHEMATICAL_OPERATORS",
        "SUPPLEMENTAL MATHEMATICAL OPERATORS",
        "SUPPLEMENTALMATHEMATICALOPERATORS");

    public static final UnicodeBlock MISCELLANEOUS_SYMBOLS_AND_ARROWS = new UnicodeBlock(
        "MISCELLANEOUS_SYMBOLS_AND_ARROWS", "MISCELLANEOUS SYMBOLS AND ARROWS",
        "MISCELLANEOUSSYMBOLSANDARROWS");

    public static final UnicodeBlock KATAKANA_PHONETIC_EXTENSIONS = new UnicodeBlock(
        "KATAKANA_PHONETIC_EXTENSIONS", "KATAKANA PHONETIC EXTENSIONS",
        "KATAKANAPHONETICEXTENSIONS");

    public static final UnicodeBlock YIJING_HEXAGRAM_SYMBOLS = new UnicodeBlock(
        "YIJING_HEXAGRAM_SYMBOLS", "YIJING HEXAGRAM SYMBOLS",
        "YIJINGHEXAGRAMSYMBOLS");

    public static final UnicodeBlock VARIATION_SELECTORS = new UnicodeBlock(
        "VARIATION_SELECTORS", "VARIATION SELECTORS", "VARIATIONSELECTORS");

    public static final UnicodeBlock LINEAR_B_SYLLABARY = new UnicodeBlock(
        "LINEAR_B_SYLLABARY", "LINEAR B SYLLABARY", "LINEARBSYLLABARY");

    public static final UnicodeBlock LINEAR_B_IDEOGRAMS = new UnicodeBlock(
        "LINEAR_B_IDEOGRAMS", "LINEAR B IDEOGRAMS", "LINEARBIDEOGRAMS");

    public static final UnicodeBlock AEGEAN_NUMBERS = new UnicodeBlock(
        "AEGEAN_NUMBERS", "AEGEAN NUMBERS", "AEGEANNUMBERS");

    public static final UnicodeBlock OLD_ITALIC = new UnicodeBlock("OLD_ITALIC",
        "OLD ITALIC", "OLDITALIC");

    public static final UnicodeBlock GOTHIC = new UnicodeBlock("GOTHIC");

    public static final UnicodeBlock UGARITIC = new UnicodeBlock("UGARITIC");

    public static final UnicodeBlock DESERET = new UnicodeBlock("DESERET");

    public static final UnicodeBlock SHAVIAN = new UnicodeBlock("SHAVIAN");

    public static final UnicodeBlock OSMANYA = new UnicodeBlock("OSMANYA");

    public static final UnicodeBlock CYPRIOT_SYLLABARY = new UnicodeBlock(
        "CYPRIOT_SYLLABARY", "CYPRIOT SYLLABARY", "CYPRIOTSYLLABARY");

    public static final UnicodeBlock BYZANTINE_MUSICAL_SYMBOLS = new UnicodeBlock(
        "BYZANTINE_MUSICAL_SYMBOLS", "BYZANTINE MUSICAL SYMBOLS",
        "BYZANTINEMUSICALSYMBOLS");

    public static final UnicodeBlock MUSICAL_SYMBOLS = new UnicodeBlock(
        "MUSICAL_SYMBOLS", "MUSICAL SYMBOLS", "MUSICALSYMBOLS");

    public static final UnicodeBlock TAI_XUAN_JING_SYMBOLS = new UnicodeBlock(
        "TAI_XUAN_JING_SYMBOLS", "TAI XUAN JING SYMBOLS", "TAIXUANJINGSYMBOLS");

    public static final UnicodeBlock MATHEMATICAL_ALPHANUMERIC_SYMBOLS = new UnicodeBlock(
        "MATHEMATICAL_ALPHANUMERIC_SYMBOLS",
        "MATHEMATICAL ALPHANUMERIC SYMBOLS", "MATHEMATICALALPHANUMERICSYMBOLS");

    public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B = new UnicodeBlock(
        "CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B",
        "CJK UNIFIED IDEOGRAPHS EXTENSION B", "CJKUNIFIEDIDEOGRAPHSEXTENSIONB");

    public static final UnicodeBlock CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT = new UnicodeBlock(
        "CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT",
        "CJK COMPATIBILITY IDEOGRAPHS SUPPLEMENT",
        "CJKCOMPATIBILITYIDEOGRAPHSSUPPLEMENT");

    public static final UnicodeBlock TAGS = new UnicodeBlock("TAGS");

    public static final UnicodeBlock VARIATION_SELECTORS_SUPPLEMENT = new UnicodeBlock(
        "VARIATION_SELECTORS_SUPPLEMENT", "VARIATION SELECTORS SUPPLEMENT",
        "VARIATIONSELECTORSSUPPLEMENT");

    public static final UnicodeBlock SUPPLEMENTARY_PRIVATE_USE_AREA_A = new UnicodeBlock(
        "SUPPLEMENTARY_PRIVATE_USE_AREA_A", "SUPPLEMENTARY PRIVATE USE AREA-A",
        "SUPPLEMENTARYPRIVATEUSEAREA-A");

    public static final UnicodeBlock SUPPLEMENTARY_PRIVATE_USE_AREA_B = new UnicodeBlock(
        "SUPPLEMENTARY_PRIVATE_USE_AREA_B", "SUPPLEMENTARY PRIVATE USE AREA-B",
        "SUPPLEMENTARYPRIVATEUSEAREA-B");

    public static final UnicodeBlock HIGH_SURROGATES = new UnicodeBlock(
        "HIGH_SURROGATES", "HIGH SURROGATES", "HIGHSURROGATES");

    public static final UnicodeBlock HIGH_PRIVATE_USE_SURROGATES = new UnicodeBlock(
        "HIGH_PRIVATE_USE_SURROGATES", "HIGH PRIVATE USE SURROGATES",
        "HIGHPRIVATEUSESURROGATES");

    public static final UnicodeBlock LOW_SURROGATES = new UnicodeBlock(
        "LOW_SURROGATES", "LOW SURROGATES", "LOWSURROGATES");

    public static final UnicodeBlock ARABIC_SUPPLEMENT = new UnicodeBlock(
        "ARABIC_SUPPLEMENT", "ARABIC SUPPLEMENT", "ARABICSUPPLEMENT");

    public static final UnicodeBlock NKO = new UnicodeBlock("NKO");

    public static final UnicodeBlock SAMARITAN = new UnicodeBlock("SAMARITAN");

    public static final UnicodeBlock MANDAIC = new UnicodeBlock("MANDAIC");

    public static final UnicodeBlock ETHIOPIC_SUPPLEMENT = new UnicodeBlock(
        "ETHIOPIC_SUPPLEMENT", "ETHIOPIC SUPPLEMENT", "ETHIOPICSUPPLEMENT");

    public static final UnicodeBlock UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS_EXTENDED = new UnicodeBlock(
        "UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS_EXTENDED",
        "UNIFIED CANADIAN ABORIGINAL SYLLABICS EXTENDED",
        "UNIFIEDCANADIANABORIGINALSYLLABICSEXTENDED");

    public static final UnicodeBlock NEW_TAI_LUE = new UnicodeBlock(
        "NEW_TAI_LUE", "NEW TAI LUE", "NEWTAILUE");

    public static final UnicodeBlock BUGINESE = new UnicodeBlock("BUGINESE");

    public static final UnicodeBlock TAI_THAM = new UnicodeBlock("TAI_THAM",
        "TAI THAM", "TAITHAM");

    public static final UnicodeBlock BALINESE = new UnicodeBlock("BALINESE");

    public static final UnicodeBlock SUNDANESE = new UnicodeBlock("SUNDANESE");

    public static final UnicodeBlock BATAK = new UnicodeBlock("BATAK");

    public static final UnicodeBlock LEPCHA = new UnicodeBlock("LEPCHA");

    public static final UnicodeBlock OL_CHIKI = new UnicodeBlock("OL_CHIKI",
        "OL CHIKI", "OLCHIKI");

    public static final UnicodeBlock VEDIC_EXTENSIONS = new UnicodeBlock(
        "VEDIC_EXTENSIONS", "VEDIC EXTENSIONS", "VEDICEXTENSIONS");

    public static final UnicodeBlock PHONETIC_EXTENSIONS_SUPPLEMENT = new UnicodeBlock(
        "PHONETIC_EXTENSIONS_SUPPLEMENT", "PHONETIC EXTENSIONS SUPPLEMENT",
        "PHONETICEXTENSIONSSUPPLEMENT");

    public static final UnicodeBlock COMBINING_DIACRITICAL_MARKS_SUPPLEMENT = new UnicodeBlock(
        "COMBINING_DIACRITICAL_MARKS_SUPPLEMENT",
        "COMBINING DIACRITICAL MARKS SUPPLEMENT",
        "COMBININGDIACRITICALMARKSSUPPLEMENT");

    public static final UnicodeBlock GLAGOLITIC = new UnicodeBlock(
        "GLAGOLITIC");

    public static final UnicodeBlock LATIN_EXTENDED_C = new UnicodeBlock(
        "LATIN_EXTENDED_C", "LATIN EXTENDED-C", "LATINEXTENDED-C");

    public static final UnicodeBlock COPTIC = new UnicodeBlock("COPTIC");

    public static final UnicodeBlock GEORGIAN_SUPPLEMENT = new UnicodeBlock(
        "GEORGIAN_SUPPLEMENT", "GEORGIAN SUPPLEMENT", "GEORGIANSUPPLEMENT");

    public static final UnicodeBlock TIFINAGH = new UnicodeBlock("TIFINAGH");

    public static final UnicodeBlock ETHIOPIC_EXTENDED = new UnicodeBlock(
        "ETHIOPIC_EXTENDED", "ETHIOPIC EXTENDED", "ETHIOPICEXTENDED");

    public static final UnicodeBlock CYRILLIC_EXTENDED_A = new UnicodeBlock(
        "CYRILLIC_EXTENDED_A", "CYRILLIC EXTENDED-A", "CYRILLICEXTENDED-A");

    public static final UnicodeBlock SUPPLEMENTAL_PUNCTUATION = new UnicodeBlock(
        "SUPPLEMENTAL_PUNCTUATION", "SUPPLEMENTAL PUNCTUATION",
        "SUPPLEMENTALPUNCTUATION");

    public static final UnicodeBlock CJK_STROKES = new UnicodeBlock(
        "CJK_STROKES", "CJK STROKES", "CJKSTROKES");

    public static final UnicodeBlock LISU = new UnicodeBlock("LISU");

    public static final UnicodeBlock VAI = new UnicodeBlock("VAI");

    public static final UnicodeBlock CYRILLIC_EXTENDED_B = new UnicodeBlock(
        "CYRILLIC_EXTENDED_B", "CYRILLIC EXTENDED-B", "CYRILLICEXTENDED-B");

    public static final UnicodeBlock BAMUM = new UnicodeBlock("BAMUM");

    public static final UnicodeBlock MODIFIER_TONE_LETTERS = new UnicodeBlock(
        "MODIFIER_TONE_LETTERS", "MODIFIER TONE LETTERS",
        "MODIFIERTONELETTERS");

    public static final UnicodeBlock LATIN_EXTENDED_D = new UnicodeBlock(
        "LATIN_EXTENDED_D", "LATIN EXTENDED-D", "LATINEXTENDED-D");

    public static final UnicodeBlock SYLOTI_NAGRI = new UnicodeBlock(
        "SYLOTI_NAGRI", "SYLOTI NAGRI", "SYLOTINAGRI");

    public static final UnicodeBlock COMMON_INDIC_NUMBER_FORMS = new UnicodeBlock(
        "COMMON_INDIC_NUMBER_FORMS", "COMMON INDIC NUMBER FORMS",
        "COMMONINDICNUMBERFORMS");

    public static final UnicodeBlock PHAGS_PA = new UnicodeBlock("PHAGS_PA",
        "PHAGS-PA");

    public static final UnicodeBlock SAURASHTRA = new UnicodeBlock(
        "SAURASHTRA");

    public static final UnicodeBlock DEVANAGARI_EXTENDED = new UnicodeBlock(
        "DEVANAGARI_EXTENDED", "DEVANAGARI EXTENDED", "DEVANAGARIEXTENDED");

    public static final UnicodeBlock KAYAH_LI = new UnicodeBlock("KAYAH_LI",
        "KAYAH LI", "KAYAHLI");

    public static final UnicodeBlock REJANG = new UnicodeBlock("REJANG");

    public static final UnicodeBlock HANGUL_JAMO_EXTENDED_A = new UnicodeBlock(
        "HANGUL_JAMO_EXTENDED_A", "HANGUL JAMO EXTENDED-A",
        "HANGULJAMOEXTENDED-A");

    public static final UnicodeBlock JAVANESE = new UnicodeBlock("JAVANESE");

    public static final UnicodeBlock CHAM = new UnicodeBlock("CHAM");

    public static final UnicodeBlock MYANMAR_EXTENDED_A = new UnicodeBlock(
        "MYANMAR_EXTENDED_A", "MYANMAR EXTENDED-A", "MYANMAREXTENDED-A");

    public static final UnicodeBlock TAI_VIET = new UnicodeBlock("TAI_VIET",
        "TAI VIET", "TAIVIET");

    public static final UnicodeBlock ETHIOPIC_EXTENDED_A = new UnicodeBlock(
        "ETHIOPIC_EXTENDED_A", "ETHIOPIC EXTENDED-A", "ETHIOPICEXTENDED-A");

    public static final UnicodeBlock MEETEI_MAYEK = new UnicodeBlock(
        "MEETEI_MAYEK", "MEETEI MAYEK", "MEETEIMAYEK");

    public static final UnicodeBlock HANGUL_JAMO_EXTENDED_B = new UnicodeBlock(
        "HANGUL_JAMO_EXTENDED_B", "HANGUL JAMO EXTENDED-B",
        "HANGULJAMOEXTENDED-B");

    public static final UnicodeBlock VERTICAL_FORMS = new UnicodeBlock(
        "VERTICAL_FORMS", "VERTICAL FORMS", "VERTICALFORMS");

    public static final UnicodeBlock ANCIENT_GREEK_NUMBERS = new UnicodeBlock(
        "ANCIENT_GREEK_NUMBERS", "ANCIENT GREEK NUMBERS",
        "ANCIENTGREEKNUMBERS");

    public static final UnicodeBlock ANCIENT_SYMBOLS = new UnicodeBlock(
        "ANCIENT_SYMBOLS", "ANCIENT SYMBOLS", "ANCIENTSYMBOLS");

    public static final UnicodeBlock PHAISTOS_DISC = new UnicodeBlock(
        "PHAISTOS_DISC", "PHAISTOS DISC", "PHAISTOSDISC");

    public static final UnicodeBlock LYCIAN = new UnicodeBlock("LYCIAN");

    public static final UnicodeBlock CARIAN = new UnicodeBlock("CARIAN");

    public static final UnicodeBlock OLD_PERSIAN = new UnicodeBlock(
        "OLD_PERSIAN", "OLD PERSIAN", "OLDPERSIAN");

    public static final UnicodeBlock IMPERIAL_ARAMAIC = new UnicodeBlock(
        "IMPERIAL_ARAMAIC", "IMPERIAL ARAMAIC", "IMPERIALARAMAIC");

    public static final UnicodeBlock PHOENICIAN = new UnicodeBlock(
        "PHOENICIAN");

    public static final UnicodeBlock LYDIAN = new UnicodeBlock("LYDIAN");

    public static final UnicodeBlock KHAROSHTHI = new UnicodeBlock(
        "KHAROSHTHI");

    public static final UnicodeBlock OLD_SOUTH_ARABIAN = new UnicodeBlock(
        "OLD_SOUTH_ARABIAN", "OLD SOUTH ARABIAN", "OLDSOUTHARABIAN");

    public static final UnicodeBlock AVESTAN = new UnicodeBlock("AVESTAN");

    public static final UnicodeBlock INSCRIPTIONAL_PARTHIAN = new UnicodeBlock(
        "INSCRIPTIONAL_PARTHIAN", "INSCRIPTIONAL PARTHIAN",
        "INSCRIPTIONALPARTHIAN");

    public static final UnicodeBlock INSCRIPTIONAL_PAHLAVI = new UnicodeBlock(
        "INSCRIPTIONAL_PAHLAVI", "INSCRIPTIONAL PAHLAVI",
        "INSCRIPTIONALPAHLAVI");

    public static final UnicodeBlock OLD_TURKIC = new UnicodeBlock("OLD_TURKIC",
        "OLD TURKIC", "OLDTURKIC");

    public static final UnicodeBlock RUMI_NUMERAL_SYMBOLS = new UnicodeBlock(
        "RUMI_NUMERAL_SYMBOLS", "RUMI NUMERAL SYMBOLS", "RUMINUMERALSYMBOLS");

    public static final UnicodeBlock BRAHMI = new UnicodeBlock("BRAHMI");

    public static final UnicodeBlock KAITHI = new UnicodeBlock("KAITHI");

    public static final UnicodeBlock CUNEIFORM = new UnicodeBlock("CUNEIFORM");

    public static final UnicodeBlock CUNEIFORM_NUMBERS_AND_PUNCTUATION = new UnicodeBlock(
        "CUNEIFORM_NUMBERS_AND_PUNCTUATION",
        "CUNEIFORM NUMBERS AND PUNCTUATION", "CUNEIFORMNUMBERSANDPUNCTUATION");

    public static final UnicodeBlock EGYPTIAN_HIEROGLYPHS = new UnicodeBlock(
        "EGYPTIAN_HIEROGLYPHS", "EGYPTIAN HIEROGLYPHS", "EGYPTIANHIEROGLYPHS");

    public static final UnicodeBlock BAMUM_SUPPLEMENT = new UnicodeBlock(
        "BAMUM_SUPPLEMENT", "BAMUM SUPPLEMENT", "BAMUMSUPPLEMENT");

    public static final UnicodeBlock KANA_SUPPLEMENT = new UnicodeBlock(
        "KANA_SUPPLEMENT", "KANA SUPPLEMENT", "KANASUPPLEMENT");

    public static final UnicodeBlock ANCIENT_GREEK_MUSICAL_NOTATION = new UnicodeBlock(
        "ANCIENT_GREEK_MUSICAL_NOTATION", "ANCIENT GREEK MUSICAL NOTATION",
        "ANCIENTGREEKMUSICALNOTATION");

    public static final UnicodeBlock COUNTING_ROD_NUMERALS = new UnicodeBlock(
        "COUNTING_ROD_NUMERALS", "COUNTING ROD NUMERALS",
        "COUNTINGRODNUMERALS");

    public static final UnicodeBlock MAHJONG_TILES = new UnicodeBlock(
        "MAHJONG_TILES", "MAHJONG TILES", "MAHJONGTILES");

    public static final UnicodeBlock DOMINO_TILES = new UnicodeBlock(
        "DOMINO_TILES", "DOMINO TILES", "DOMINOTILES");

    public static final UnicodeBlock PLAYING_CARDS = new UnicodeBlock(
        "PLAYING_CARDS", "PLAYING CARDS", "PLAYINGCARDS");

    public static final UnicodeBlock ENCLOSED_ALPHANUMERIC_SUPPLEMENT = new UnicodeBlock(
        "ENCLOSED_ALPHANUMERIC_SUPPLEMENT", "ENCLOSED ALPHANUMERIC SUPPLEMENT",
        "ENCLOSEDALPHANUMERICSUPPLEMENT");

    public static final UnicodeBlock ENCLOSED_IDEOGRAPHIC_SUPPLEMENT = new UnicodeBlock(
        "ENCLOSED_IDEOGRAPHIC_SUPPLEMENT", "ENCLOSED IDEOGRAPHIC SUPPLEMENT",
        "ENCLOSEDIDEOGRAPHICSUPPLEMENT");

    public static final UnicodeBlock MISCELLANEOUS_SYMBOLS_AND_PICTOGRAPHS = new UnicodeBlock(
        "MISCELLANEOUS_SYMBOLS_AND_PICTOGRAPHS",
        "MISCELLANEOUS SYMBOLS AND PICTOGRAPHS",
        "MISCELLANEOUSSYMBOLSANDPICTOGRAPHS");

    public static final UnicodeBlock EMOTICONS = new UnicodeBlock("EMOTICONS");

    public static final UnicodeBlock TRANSPORT_AND_MAP_SYMBOLS = new UnicodeBlock(
        "TRANSPORT_AND_MAP_SYMBOLS", "TRANSPORT AND MAP SYMBOLS",
        "TRANSPORTANDMAPSYMBOLS");

    public static final UnicodeBlock ALCHEMICAL_SYMBOLS = new UnicodeBlock(
        "ALCHEMICAL_SYMBOLS", "ALCHEMICAL SYMBOLS", "ALCHEMICALSYMBOLS");

    public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS_EXTENSION_C = new UnicodeBlock(
        "CJK_UNIFIED_IDEOGRAPHS_EXTENSION_C",
        "CJK UNIFIED IDEOGRAPHS EXTENSION C", "CJKUNIFIEDIDEOGRAPHSEXTENSIONC");

    public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS_EXTENSION_D = new UnicodeBlock(
        "CJK_UNIFIED_IDEOGRAPHS_EXTENSION_D",
        "CJK UNIFIED IDEOGRAPHS EXTENSION D", "CJKUNIFIEDIDEOGRAPHSEXTENSIOND");

    private static final int blockStarts[] = { 0x0000, // 0000..007F; Basic
                                                       // Latin
        0x0080, // 0080..00FF; Latin-1 Supplement
        0x0100, // 0100..017F; Latin Extended-A
        0x0180, // 0180..024F; Latin Extended-B
        0x0250, // 0250..02AF; IPA Extensions
        0x02B0, // 02B0..02FF; Spacing Modifier Letters
        0x0300, // 0300..036F; Combining Diacritical Marks
        0x0370, // 0370..03FF; Greek and Coptic
        0x0400, // 0400..04FF; Cyrillic
        0x0500, // 0500..052F; Cyrillic Supplement
        0x0530, // 0530..058F; Armenian
        0x0590, // 0590..05FF; Hebrew
        0x0600, // 0600..06FF; Arabic
        0x0700, // 0700..074F; Syriac
        0x0750, // 0750..077F; Arabic Supplement
        0x0780, // 0780..07BF; Thaana
        0x07C0, // 07C0..07FF; NKo
        0x0800, // 0800..083F; Samaritan
        0x0840, // 0840..085F; Mandaic
        0x0860, // unassigned
        0x0900, // 0900..097F; Devanagari
        0x0980, // 0980..09FF; Bengali
        0x0A00, // 0A00..0A7F; Gurmukhi
        0x0A80, // 0A80..0AFF; Gujarati
        0x0B00, // 0B00..0B7F; Oriya
        0x0B80, // 0B80..0BFF; Tamil
        0x0C00, // 0C00..0C7F; Telugu
        0x0C80, // 0C80..0CFF; Kannada
        0x0D00, // 0D00..0D7F; Malayalam
        0x0D80, // 0D80..0DFF; Sinhala
        0x0E00, // 0E00..0E7F; Thai
        0x0E80, // 0E80..0EFF; Lao
        0x0F00, // 0F00..0FFF; Tibetan
        0x1000, // 1000..109F; Myanmar
        0x10A0, // 10A0..10FF; Georgian
        0x1100, // 1100..11FF; Hangul Jamo
        0x1200, // 1200..137F; Ethiopic
        0x1380, // 1380..139F; Ethiopic Supplement
        0x13A0, // 13A0..13FF; Cherokee
        0x1400, // 1400..167F; Unified Canadian Aboriginal Syllabics
        0x1680, // 1680..169F; Ogham
        0x16A0, // 16A0..16FF; Runic
        0x1700, // 1700..171F; Tagalog
        0x1720, // 1720..173F; Hanunoo
        0x1740, // 1740..175F; Buhid
        0x1760, // 1760..177F; Tagbanwa
        0x1780, // 1780..17FF; Khmer
        0x1800, // 1800..18AF; Mongolian
        0x18B0, // 18B0..18FF; Unified Canadian Aboriginal Syllabics Extended
        0x1900, // 1900..194F; Limbu
        0x1950, // 1950..197F; Tai Le
        0x1980, // 1980..19DF; New Tai Lue
        0x19E0, // 19E0..19FF; Khmer Symbols
        0x1A00, // 1A00..1A1F; Buginese
        0x1A20, // 1A20..1AAF; Tai Tham
        0x1AB0, // unassigned
        0x1B00, // 1B00..1B7F; Balinese
        0x1B80, // 1B80..1BBF; Sundanese
        0x1BC0, // 1BC0..1BFF; Batak
        0x1C00, // 1C00..1C4F; Lepcha
        0x1C50, // 1C50..1C7F; Ol Chiki
        0x1C80, // unassigned
        0x1CD0, // 1CD0..1CFF; Vedic Extensions
        0x1D00, // 1D00..1D7F; Phonetic Extensions
        0x1D80, // 1D80..1DBF; Phonetic Extensions Supplement
        0x1DC0, // 1DC0..1DFF; Combining Diacritical Marks Supplement
        0x1E00, // 1E00..1EFF; Latin Extended Additional
        0x1F00, // 1F00..1FFF; Greek Extended
        0x2000, // 2000..206F; General Punctuation
        0x2070, // 2070..209F; Superscripts and Subscripts
        0x20A0, // 20A0..20CF; Currency Symbols
        0x20D0, // 20D0..20FF; Combining Diacritical Marks for Symbols
        0x2100, // 2100..214F; Letterlike Symbols
        0x2150, // 2150..218F; Number Forms
        0x2190, // 2190..21FF; Arrows
        0x2200, // 2200..22FF; Mathematical Operators
        0x2300, // 2300..23FF; Miscellaneous Technical
        0x2400, // 2400..243F; Control Pictures
        0x2440, // 2440..245F; Optical Character Recognition
        0x2460, // 2460..24FF; Enclosed Alphanumerics
        0x2500, // 2500..257F; Box Drawing
        0x2580, // 2580..259F; Block Elements
        0x25A0, // 25A0..25FF; Geometric Shapes
        0x2600, // 2600..26FF; Miscellaneous Symbols
        0x2700, // 2700..27BF; Dingbats
        0x27C0, // 27C0..27EF; Miscellaneous Mathematical Symbols-A
        0x27F0, // 27F0..27FF; Supplemental Arrows-A
        0x2800, // 2800..28FF; Braille Patterns
        0x2900, // 2900..297F; Supplemental Arrows-B
        0x2980, // 2980..29FF; Miscellaneous Mathematical Symbols-B
        0x2A00, // 2A00..2AFF; Supplemental Mathematical Operators
        0x2B00, // 2B00..2BFF; Miscellaneous Symbols and Arrows
        0x2C00, // 2C00..2C5F; Glagolitic
        0x2C60, // 2C60..2C7F; Latin Extended-C
        0x2C80, // 2C80..2CFF; Coptic
        0x2D00, // 2D00..2D2F; Georgian Supplement
        0x2D30, // 2D30..2D7F; Tifinagh
        0x2D80, // 2D80..2DDF; Ethiopic Extended
        0x2DE0, // 2DE0..2DFF; Cyrillic Extended-A
        0x2E00, // 2E00..2E7F; Supplemental Punctuation
        0x2E80, // 2E80..2EFF; CJK Radicals Supplement
        0x2F00, // 2F00..2FDF; Kangxi Radicals
        0x2FE0, // unassigned
        0x2FF0, // 2FF0..2FFF; Ideographic Description Characters
        0x3000, // 3000..303F; CJK Symbols and Punctuation
        0x3040, // 3040..309F; Hiragana
        0x30A0, // 30A0..30FF; Katakana
        0x3100, // 3100..312F; Bopomofo
        0x3130, // 3130..318F; Hangul Compatibility Jamo
        0x3190, // 3190..319F; Kanbun
        0x31A0, // 31A0..31BF; Bopomofo Extended
        0x31C0, // 31C0..31EF; CJK Strokes
        0x31F0, // 31F0..31FF; Katakana Phonetic Extensions
        0x3200, // 3200..32FF; Enclosed CJK Letters and Months
        0x3300, // 3300..33FF; CJK Compatibility
        0x3400, // 3400..4DBF; CJK Unified Ideographs Extension A
        0x4DC0, // 4DC0..4DFF; Yijing Hexagram Symbols
        0x4E00, // 4E00..9FFF; CJK Unified Ideographs
        0xA000, // A000..A48F; Yi Syllables
        0xA490, // A490..A4CF; Yi Radicals
        0xA4D0, // A4D0..A4FF; Lisu
        0xA500, // A500..A63F; Vai
        0xA640, // A640..A69F; Cyrillic Extended-B
        0xA6A0, // A6A0..A6FF; Bamum
        0xA700, // A700..A71F; Modifier Tone Letters
        0xA720, // A720..A7FF; Latin Extended-D
        0xA800, // A800..A82F; Syloti Nagri
        0xA830, // A830..A83F; Common Indic Number Forms
        0xA840, // A840..A87F; Phags-pa
        0xA880, // A880..A8DF; Saurashtra
        0xA8E0, // A8E0..A8FF; Devanagari Extended
        0xA900, // A900..A92F; Kayah Li
        0xA930, // A930..A95F; Rejang
        0xA960, // A960..A97F; Hangul Jamo Extended-A
        0xA980, // A980..A9DF; Javanese
        0xA9E0, // unassigned
        0xAA00, // AA00..AA5F; Cham
        0xAA60, // AA60..AA7F; Myanmar Extended-A
        0xAA80, // AA80..AADF; Tai Viet
        0xAAE0, // unassigned
        0xAB00, // AB00..AB2F; Ethiopic Extended-A
        0xAB30, // unassigned
        0xABC0, // ABC0..ABFF; Meetei Mayek
        0xAC00, // AC00..D7AF; Hangul Syllables
        0xD7B0, // D7B0..D7FF; Hangul Jamo Extended-B
        0xD800, // D800..DB7F; High Surrogates
        0xDB80, // DB80..DBFF; High Private Use Surrogates
        0xDC00, // DC00..DFFF; Low Surrogates
        0xE000, // E000..F8FF; Private Use Area
        0xF900, // F900..FAFF; CJK Compatibility Ideographs
        0xFB00, // FB00..FB4F; Alphabetic Presentation Forms
        0xFB50, // FB50..FDFF; Arabic Presentation Forms-A
        0xFE00, // FE00..FE0F; Variation Selectors
        0xFE10, // FE10..FE1F; Vertical Forms
        0xFE20, // FE20..FE2F; Combining Half Marks
        0xFE30, // FE30..FE4F; CJK Compatibility Forms
        0xFE50, // FE50..FE6F; Small Form Variants
        0xFE70, // FE70..FEFF; Arabic Presentation Forms-B
        0xFF00, // FF00..FFEF; Halfwidth and Fullwidth Forms
        0xFFF0, // FFF0..FFFF; Specials
        0x10000, // 10000..1007F; Linear B Syllabary
        0x10080, // 10080..100FF; Linear B Ideograms
        0x10100, // 10100..1013F; Aegean Numbers
        0x10140, // 10140..1018F; Ancient Greek Numbers
        0x10190, // 10190..101CF; Ancient Symbols
        0x101D0, // 101D0..101FF; Phaistos Disc
        0x10200, // unassigned
        0x10280, // 10280..1029F; Lycian
        0x102A0, // 102A0..102DF; Carian
        0x102E0, // unassigned
        0x10300, // 10300..1032F; Old Italic
        0x10330, // 10330..1034F; Gothic
        0x10350, // unassigned
        0x10380, // 10380..1039F; Ugaritic
        0x103A0, // 103A0..103DF; Old Persian
        0x103E0, // unassigned
        0x10400, // 10400..1044F; Deseret
        0x10450, // 10450..1047F; Shavian
        0x10480, // 10480..104AF; Osmanya
        0x104B0, // unassigned
        0x10800, // 10800..1083F; Cypriot Syllabary
        0x10840, // 10840..1085F; Imperial Aramaic
        0x10860, // unassigned
        0x10900, // 10900..1091F; Phoenician
        0x10920, // 10920..1093F; Lydian
        0x10940, // unassigned
        0x10A00, // 10A00..10A5F; Kharoshthi
        0x10A60, // 10A60..10A7F; Old South Arabian
        0x10A80, // unassigned
        0x10B00, // 10B00..10B3F; Avestan
        0x10B40, // 10B40..10B5F; Inscriptional Parthian
        0x10B60, // 10B60..10B7F; Inscriptional Pahlavi
        0x10B80, // unassigned
        0x10C00, // 10C00..10C4F; Old Turkic
        0x10C50, // unassigned
        0x10E60, // 10E60..10E7F; Rumi Numeral Symbols
        0x10E80, // unassigned
        0x11000, // 11000..1107F; Brahmi
        0x11080, // 11080..110CF; Kaithi
        0x110D0, // unassigned
        0x12000, // 12000..123FF; Cuneiform
        0x12400, // 12400..1247F; Cuneiform Numbers and Punctuation
        0x12480, // unassigned
        0x13000, // 13000..1342F; Egyptian Hieroglyphs
        0x13430, // unassigned
        0x16800, // 16800..16A3F; Bamum Supplement
        0x16A40, // unassigned
        0x1B000, // 1B000..1B0FF; Kana Supplement
        0x1B100, // unassigned
        0x1D000, // 1D000..1D0FF; Byzantine Musical Symbols
        0x1D100, // 1D100..1D1FF; Musical Symbols
        0x1D200, // 1D200..1D24F; Ancient Greek Musical Notation
        0x1D250, // unassigned
        0x1D300, // 1D300..1D35F; Tai Xuan Jing Symbols
        0x1D360, // 1D360..1D37F; Counting Rod Numerals
        0x1D380, // unassigned
        0x1D400, // 1D400..1D7FF; Mathematical Alphanumeric Symbols
        0x1D800, // unassigned
        0x1F000, // 1F000..1F02F; Mahjong Tiles
        0x1F030, // 1F030..1F09F; Domino Tiles
        0x1F0A0, // 1F0A0..1F0FF; Playing Cards
        0x1F100, // 1F100..1F1FF; Enclosed Alphanumeric Supplement
        0x1F200, // 1F200..1F2FF; Enclosed Ideographic Supplement
        0x1F300, // 1F300..1F5FF; Miscellaneous Symbols And Pictographs
        0x1F600, // 1F600..1F64F; Emoticons
        0x1F650, // unassigned
        0x1F680, // 1F680..1F6FF; Transport And Map Symbols
        0x1F700, // 1F700..1F77F; Alchemical Symbols
        0x1F780, // unassigned
        0x20000, // 20000..2A6DF; CJK Unified Ideographs Extension B
        0x2A6E0, // unassigned
        0x2A700, // 2A700..2B73F; CJK Unified Ideographs Extension C
        0x2B740, // 2B740..2B81F; CJK Unified Ideographs Extension D
        0x2B820, // unassigned
        0x2F800, // 2F800..2FA1F; CJK Compatibility Ideographs Supplement
        0x2FA20, // unassigned
        0xE0000, // E0000..E007F; Tags
        0xE0080, // unassigned
        0xE0100, // E0100..E01EF; Variation Selectors Supplement
        0xE01F0, // unassigned
        0xF0000, // F0000..FFFFF; Supplementary Private Use Area-A
        0x100000 // 100000..10FFFF; Supplementary Private Use Area-B
    };

    private static final UnicodeBlock[] blocks = { BASIC_LATIN,
        LATIN_1_SUPPLEMENT, LATIN_EXTENDED_A, LATIN_EXTENDED_B, IPA_EXTENSIONS,
        SPACING_MODIFIER_LETTERS, COMBINING_DIACRITICAL_MARKS, GREEK, CYRILLIC,
        CYRILLIC_SUPPLEMENTARY, ARMENIAN, HEBREW, ARABIC, SYRIAC,
        ARABIC_SUPPLEMENT, THAANA, NKO, SAMARITAN, MANDAIC, null, DEVANAGARI,
        BENGALI, GURMUKHI, GUJARATI, ORIYA, TAMIL, TELUGU, KANNADA, MALAYALAM,
        SINHALA, THAI, LAO, TIBETAN, MYANMAR, GEORGIAN, HANGUL_JAMO, ETHIOPIC,
        ETHIOPIC_SUPPLEMENT, CHEROKEE, UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS,
        OGHAM, RUNIC, TAGALOG, HANUNOO, BUHID, TAGBANWA, KHMER, MONGOLIAN,
        UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS_EXTENDED, LIMBU, TAI_LE,
        NEW_TAI_LUE, KHMER_SYMBOLS, BUGINESE, TAI_THAM, null, BALINESE,
        SUNDANESE, BATAK, LEPCHA, OL_CHIKI, null, VEDIC_EXTENSIONS,
        PHONETIC_EXTENSIONS, PHONETIC_EXTENSIONS_SUPPLEMENT,
        COMBINING_DIACRITICAL_MARKS_SUPPLEMENT, LATIN_EXTENDED_ADDITIONAL,
        GREEK_EXTENDED, GENERAL_PUNCTUATION, SUPERSCRIPTS_AND_SUBSCRIPTS,
        CURRENCY_SYMBOLS, COMBINING_MARKS_FOR_SYMBOLS, LETTERLIKE_SYMBOLS,
        NUMBER_FORMS, ARROWS, MATHEMATICAL_OPERATORS, MISCELLANEOUS_TECHNICAL,
        CONTROL_PICTURES, OPTICAL_CHARACTER_RECOGNITION, ENCLOSED_ALPHANUMERICS,
        BOX_DRAWING, BLOCK_ELEMENTS, GEOMETRIC_SHAPES, MISCELLANEOUS_SYMBOLS,
        DINGBATS, MISCELLANEOUS_MATHEMATICAL_SYMBOLS_A, SUPPLEMENTAL_ARROWS_A,
        BRAILLE_PATTERNS, SUPPLEMENTAL_ARROWS_B,
        MISCELLANEOUS_MATHEMATICAL_SYMBOLS_B,
        SUPPLEMENTAL_MATHEMATICAL_OPERATORS, MISCELLANEOUS_SYMBOLS_AND_ARROWS,
        GLAGOLITIC, LATIN_EXTENDED_C, COPTIC, GEORGIAN_SUPPLEMENT, TIFINAGH,
        ETHIOPIC_EXTENDED, CYRILLIC_EXTENDED_A, SUPPLEMENTAL_PUNCTUATION,
        CJK_RADICALS_SUPPLEMENT, KANGXI_RADICALS, null,
        IDEOGRAPHIC_DESCRIPTION_CHARACTERS, CJK_SYMBOLS_AND_PUNCTUATION,
        HIRAGANA, KATAKANA, BOPOMOFO, HANGUL_COMPATIBILITY_JAMO, KANBUN,
        BOPOMOFO_EXTENDED, CJK_STROKES, KATAKANA_PHONETIC_EXTENSIONS,
        ENCLOSED_CJK_LETTERS_AND_MONTHS, CJK_COMPATIBILITY,
        CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A, YIJING_HEXAGRAM_SYMBOLS,
        CJK_UNIFIED_IDEOGRAPHS, YI_SYLLABLES, YI_RADICALS, LISU, VAI,
        CYRILLIC_EXTENDED_B, BAMUM, MODIFIER_TONE_LETTERS, LATIN_EXTENDED_D,
        SYLOTI_NAGRI, COMMON_INDIC_NUMBER_FORMS, PHAGS_PA, SAURASHTRA,
        DEVANAGARI_EXTENDED, KAYAH_LI, REJANG, HANGUL_JAMO_EXTENDED_A, JAVANESE,
        null, CHAM, MYANMAR_EXTENDED_A, TAI_VIET, null, ETHIOPIC_EXTENDED_A,
        null, MEETEI_MAYEK, HANGUL_SYLLABLES, HANGUL_JAMO_EXTENDED_B,
        HIGH_SURROGATES, HIGH_PRIVATE_USE_SURROGATES, LOW_SURROGATES,
        PRIVATE_USE_AREA, CJK_COMPATIBILITY_IDEOGRAPHS,
        ALPHABETIC_PRESENTATION_FORMS, ARABIC_PRESENTATION_FORMS_A,
        VARIATION_SELECTORS, VERTICAL_FORMS, COMBINING_HALF_MARKS,
        CJK_COMPATIBILITY_FORMS, SMALL_FORM_VARIANTS,
        ARABIC_PRESENTATION_FORMS_B, HALFWIDTH_AND_FULLWIDTH_FORMS, SPECIALS,
        LINEAR_B_SYLLABARY, LINEAR_B_IDEOGRAMS, AEGEAN_NUMBERS,
        ANCIENT_GREEK_NUMBERS, ANCIENT_SYMBOLS, PHAISTOS_DISC, null, LYCIAN,
        CARIAN, null, OLD_ITALIC, GOTHIC, null, UGARITIC, OLD_PERSIAN, null,
        DESERET, SHAVIAN, OSMANYA, null, CYPRIOT_SYLLABARY, IMPERIAL_ARAMAIC,
        null, PHOENICIAN, LYDIAN, null, KHAROSHTHI, OLD_SOUTH_ARABIAN, null,
        AVESTAN, INSCRIPTIONAL_PARTHIAN, INSCRIPTIONAL_PAHLAVI, null,
        OLD_TURKIC, null, RUMI_NUMERAL_SYMBOLS, null, BRAHMI, KAITHI, null,
        CUNEIFORM, CUNEIFORM_NUMBERS_AND_PUNCTUATION, null,
        EGYPTIAN_HIEROGLYPHS, null, BAMUM_SUPPLEMENT, null, KANA_SUPPLEMENT,
        null, BYZANTINE_MUSICAL_SYMBOLS, MUSICAL_SYMBOLS,
        ANCIENT_GREEK_MUSICAL_NOTATION, null, TAI_XUAN_JING_SYMBOLS,
        COUNTING_ROD_NUMERALS, null, MATHEMATICAL_ALPHANUMERIC_SYMBOLS, null,
        MAHJONG_TILES, DOMINO_TILES, PLAYING_CARDS,
        ENCLOSED_ALPHANUMERIC_SUPPLEMENT, ENCLOSED_IDEOGRAPHIC_SUPPLEMENT,
        MISCELLANEOUS_SYMBOLS_AND_PICTOGRAPHS, EMOTICONS, null,
        TRANSPORT_AND_MAP_SYMBOLS, ALCHEMICAL_SYMBOLS, null,
        CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B, null,
        CJK_UNIFIED_IDEOGRAPHS_EXTENSION_C, CJK_UNIFIED_IDEOGRAPHS_EXTENSION_D,
        null, CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT, null, TAGS, null,
        VARIATION_SELECTORS_SUPPLEMENT, null, SUPPLEMENTARY_PRIVATE_USE_AREA_A,
        SUPPLEMENTARY_PRIVATE_USE_AREA_B };

    public static UnicodeBlock of(char c) {
      return of((int) c);
    }

    public static UnicodeBlock of(int codePoint) {
      if (!isValidCodePoint(codePoint)) {
        throw new IllegalArgumentException();
      }

      int top, bottom, current;
      bottom = 0;
      top = blockStarts.length;
      current = top / 2;

      // invariant: top > current >= bottom && codePoint >=
      // unicodeBlockStarts[bottom]
      while (top - bottom > 1) {
        if (codePoint >= blockStarts[current]) {
          bottom = current;
        } else {
          top = current;
        }
        current = (top + bottom) / 2;
      }
      return blocks[current];
    }

    public static final UnicodeBlock forName(String blockName) {
      UnicodeBlock block = map.get(blockName.toUpperCase(Locale.US));
      if (block == null) {
        throw new IllegalArgumentException();
      }
      return block;
    }
  }

  private final char value;

  private static final long serialVersionUID = 3786198910865385080L;

  public Character(char value) {
    this.value = value;
  }

  private static class CharacterCache {
    private CharacterCache() {
    }

    static final Character cache[] = new Character[127 + 1];

    static {
      for (int i = 0; i < cache.length; i++)
        cache[i] = new Character((char) i);
    }
  }

  public static Character valueOf(char c) {
    if (c <= 127) { // must cache
      return CharacterCache.cache[(int) c];
    }
    return new Character(c);
  }

  public char charValue() {
    return value;
  }

  public int hashCode() {
    return (int) value;
  }

  public boolean equals(Object obj) {
    if (obj instanceof Character) {
      return value == ((Character) obj).charValue();
    }
    return false;
  }

  public String toString() {
    char buf[] = { value };
    return String.valueOf(buf);
  }

  public static String toString(char c) {
    return String.valueOf(c);
  }

  public static boolean isValidCodePoint(int codePoint) {
    // Optimized form of:
    // codePoint >= MIN_CODE_POINT && codePoint <= MAX_CODE_POINT
    int plane = codePoint >>> 16;
    return plane < ((MAX_CODE_POINT + 1) >>> 16);
  }

  public static boolean isBmpCodePoint(int codePoint) {
    return codePoint >>> 16 == 0;
    // Optimized form of:
    // codePoint >= MIN_VALUE && codePoint <= MAX_VALUE
    // We consistently use logical shift (>>>) to facilitate
    // additional runtime optimizations.
  }

  public static boolean isSupplementaryCodePoint(int codePoint) {
    return codePoint >= MIN_SUPPLEMENTARY_CODE_POINT
        && codePoint < MAX_CODE_POINT + 1;
  }

  public static boolean isHighSurrogate(char ch) {
    // Help VM constant-fold; MAX_HIGH_SURROGATE + 1 == MIN_LOW_SURROGATE
    return ch >= MIN_HIGH_SURROGATE && ch < (MAX_HIGH_SURROGATE + 1);
  }

  public static boolean isLowSurrogate(char ch) {
    return ch >= MIN_LOW_SURROGATE && ch < (MAX_LOW_SURROGATE + 1);
  }

  public static boolean isSurrogate(char ch) {
    return ch >= MIN_SURROGATE && ch < (MAX_SURROGATE + 1);
  }

  public static boolean isSurrogatePair(char high, char low) {
    return isHighSurrogate(high) && isLowSurrogate(low);
  }

  public static int charCount(int codePoint) {
    return codePoint >= MIN_SUPPLEMENTARY_CODE_POINT ? 2 : 1;
  }

  public static int toCodePoint(char high, char low) {
    // Optimized form of:
    // return ((high - MIN_HIGH_SURROGATE) << 10)
    // + (low - MIN_LOW_SURROGATE)
    // + MIN_SUPPLEMENTARY_CODE_POINT;
    return ((high << 10) + low) + (MIN_SUPPLEMENTARY_CODE_POINT
        - (MIN_HIGH_SURROGATE << 10) - MIN_LOW_SURROGATE);
  }

  public static int codePointAt(CharSequence seq, int index) {
    char c1 = seq.charAt(index++);
    if (isHighSurrogate(c1)) {
      if (index < seq.length()) {
        char c2 = seq.charAt(index);
        if (isLowSurrogate(c2)) {
          return toCodePoint(c1, c2);
        }
      }
    }
    return c1;
  }

  public static int codePointAt(char[] a, int index) {
    return codePointAtImpl(a, index, a.length);
  }

  public static int codePointAt(char[] a, int index, int limit) {
    if (index >= limit || limit < 0 || limit > a.length) {
      throw new IndexOutOfBoundsException();
    }
    return codePointAtImpl(a, index, limit);
  }

  // throws ArrayIndexOutofBoundsException if index out of bounds
  static int codePointAtImpl(char[] a, int index, int limit) {
    char c1 = a[index++];
    if (isHighSurrogate(c1)) {
      if (index < limit) {
        char c2 = a[index];
        if (isLowSurrogate(c2)) {
          return toCodePoint(c1, c2);
        }
      }
    }
    return c1;
  }

  public static int codePointBefore(CharSequence seq, int index) {
    char c2 = seq.charAt(--index);
    if (isLowSurrogate(c2)) {
      if (index > 0) {
        char c1 = seq.charAt(--index);
        if (isHighSurrogate(c1)) {
          return toCodePoint(c1, c2);
        }
      }
    }
    return c2;
  }

  public static int codePointBefore(char[] a, int index) {
    return codePointBeforeImpl(a, index, 0);
  }

  public static int codePointBefore(char[] a, int index, int start) {
    if (index <= start || start < 0 || start >= a.length) {
      throw new IndexOutOfBoundsException();
    }
    return codePointBeforeImpl(a, index, start);
  }

  // throws ArrayIndexOutofBoundsException if index-1 out of bounds
  static int codePointBeforeImpl(char[] a, int index, int start) {
    char c2 = a[--index];
    if (isLowSurrogate(c2)) {
      if (index > start) {
        char c1 = a[--index];
        if (isHighSurrogate(c1)) {
          return toCodePoint(c1, c2);
        }
      }
    }
    return c2;
  }

  public static char highSurrogate(int codePoint) {
    return (char) ((codePoint >>> 10)
        + (MIN_HIGH_SURROGATE - (MIN_SUPPLEMENTARY_CODE_POINT >>> 10)));
  }

  public static char lowSurrogate(int codePoint) {
    return (char) ((codePoint & 0x3ff) + MIN_LOW_SURROGATE);
  }

  public static int toChars(int codePoint, char[] dst, int dstIndex) {
    if (isBmpCodePoint(codePoint)) {
      dst[dstIndex] = (char) codePoint;
      return 1;
    } else if (isValidCodePoint(codePoint)) {
      toSurrogates(codePoint, dst, dstIndex);
      return 2;
    } else {
      throw new IllegalArgumentException();
    }
  }

  public static char[] toChars(int codePoint) {
    if (isBmpCodePoint(codePoint)) {
      return new char[] { (char) codePoint };
    } else if (isValidCodePoint(codePoint)) {
      char[] result = new char[2];
      toSurrogates(codePoint, result, 0);
      return result;
    } else {
      throw new IllegalArgumentException();
    }
  }

  static void toSurrogates(int codePoint, char[] dst, int index) {
    // We write elements "backwards" to guarantee all-or-nothing
    dst[index + 1] = lowSurrogate(codePoint);
    dst[index] = highSurrogate(codePoint);
  }

  public static int codePointCount(CharSequence seq, int beginIndex,
      int endIndex) {
    int length = seq.length();
    if (beginIndex < 0 || endIndex > length || beginIndex > endIndex) {
      throw new IndexOutOfBoundsException();
    }
    int n = endIndex - beginIndex;
    for (int i = beginIndex; i < endIndex;) {
      if (isHighSurrogate(seq.charAt(i++)) && i < endIndex
          && isLowSurrogate(seq.charAt(i))) {
        n--;
        i++;
      }
    }
    return n;
  }

  public static int codePointCount(char[] a, int offset, int count) {
    if (count > a.length - offset || offset < 0 || count < 0) {
      throw new IndexOutOfBoundsException();
    }
    return codePointCountImpl(a, offset, count);
  }

  static int codePointCountImpl(char[] a, int offset, int count) {
    int endIndex = offset + count;
    int n = count;
    for (int i = offset; i < endIndex;) {
      if (isHighSurrogate(a[i++]) && i < endIndex && isLowSurrogate(a[i])) {
        n--;
        i++;
      }
    }
    return n;
  }

  public static int offsetByCodePoints(CharSequence seq, int index,
      int codePointOffset) {
    int length = seq.length();
    if (index < 0 || index > length) {
      throw new IndexOutOfBoundsException();
    }

    int x = index;
    if (codePointOffset >= 0) {
      int i;
      for (i = 0; x < length && i < codePointOffset; i++) {
        if (isHighSurrogate(seq.charAt(x++)) && x < length
            && isLowSurrogate(seq.charAt(x))) {
          x++;
        }
      }
      if (i < codePointOffset) {
        throw new IndexOutOfBoundsException();
      }
    } else {
      int i;
      for (i = codePointOffset; x > 0 && i < 0; i++) {
        if (isLowSurrogate(seq.charAt(--x)) && x > 0
            && isHighSurrogate(seq.charAt(x - 1))) {
          x--;
        }
      }
      if (i < 0) {
        throw new IndexOutOfBoundsException();
      }
    }
    return x;
  }

  public static int offsetByCodePoints(char[] a, int start, int count,
      int index, int codePointOffset) {
    if (count > a.length - start || start < 0 || count < 0 || index < start
        || index > start + count) {
      throw new IndexOutOfBoundsException();
    }
    return offsetByCodePointsImpl(a, start, count, index, codePointOffset);
  }

  static int offsetByCodePointsImpl(char[] a, int start, int count, int index,
      int codePointOffset) {
    int x = index;
    if (codePointOffset >= 0) {
      int limit = start + count;
      int i;
      for (i = 0; x < limit && i < codePointOffset; i++) {
        if (isHighSurrogate(a[x++]) && x < limit && isLowSurrogate(a[x])) {
          x++;
        }
      }
      if (i < codePointOffset) {
        throw new IndexOutOfBoundsException();
      }
    } else {
      int i;
      for (i = codePointOffset; x > start && i < 0; i++) {
        if (isLowSurrogate(a[--x]) && x > start && isHighSurrogate(a[x - 1])) {
          x--;
        }
      }
      if (i < 0) {
        throw new IndexOutOfBoundsException();
      }
    }
    return x;
  }

}
