package at.illecker.jlatexmath.platform.test;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.scilab.forge.jlatexmath.ColorUtil;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;
import org.scilab.forge.jlatexmath.platform.FactoryProvider;
import org.scilab.forge.jlatexmath.platform.graphics.Graphics2DInterface;
import org.scilab.forge.jlatexmath.platform.graphics.Image;
import org.scilab.forge.jlatexmath.platform.graphics.Insets;

import at.illecker.jlatexmath.platform.desktop.FactoryProviderDesktop;
import at.illecker.jlatexmath.platform.desktop.graphics.ImageD;

public class PlatformTest {

  @BeforeClass
  public static void setFactory() {
    FactoryProvider.INSTANCE = new FactoryProviderDesktop();
  }

  @Test
  public void basicExample1() {
    String latex = "\\begin{array}{lr}\\mbox{\\textcolor{Blue}{Russian}}&\\mbox{\\textcolor{Melon}{Greek}}\\\\";
    latex += "\\mbox{" + "привет мир".toUpperCase() + "}&\\mbox{"
        + "γειά κόσμο".toUpperCase() + "}\\\\";
    latex += "\\mbox{привет мир}&\\mbox{γειά κόσμο}\\\\";
    latex += "\\mathbf{\\mbox{привет мир}}&\\mathbf{\\mbox{γειά κόσμο}}\\\\";
    latex += "\\mathit{\\mbox{привет мир}}&\\mathit{\\mbox{γειά κόσμο}}\\\\";
    latex += "\\mathsf{\\mbox{привет мир}}&\\mathsf{\\mbox{γειά κόσμο}}\\\\";
    latex += "\\mathtt{\\mbox{привет мир}}&\\mathtt{\\mbox{γειά κόσμο}}\\\\";
    latex += "\\mathbf{\\mathit{\\mbox{привет мир}}}&\\mathbf{\\mathit{\\mbox{γειά κόσμο}}}\\\\";
    latex += "\\mathbf{\\mathsf{\\mbox{привет мир}}}&\\mathbf{\\mathsf{\\mbox{γειά κόσμο}}}\\\\";
    latex += "\\mathsf{\\mathit{\\mbox{привет мир}}}&\\mathsf{\\mathit{\\mbox{γειά κόσμο}}}\\\\";
    latex += "&\\\\";
    latex += "\\mbox{\\textcolor{Salmon}{Bulgarian}}&\\mbox{\\textcolor{Tan}{Serbian}}\\\\";
    latex += "\\mbox{здравей свят}&\\mbox{Хелло уорлд}\\\\";
    latex += "&\\\\";
    latex += "\\mbox{\\textcolor{Turquoise}{Bielorussian}}&\\mbox{\\textcolor{LimeGreen}{Ukrainian}}\\\\";
    latex += "\\mbox{прывітаньне Свет}&\\mbox{привіт світ}\\\\";
    latex += "\\end{array}";
    doTest(latex, "Example1");
  }

  @Test
  public void basicExample2() {
    String latex = "\\begin{array}{l}";
    latex += "\\forall\\varepsilon\\in\\mathbb{R}_+^*\\ \\exists\\eta>0\\ |x-x_0|\\leq\\eta\\Longrightarrow|f(x)-f(x_0)|\\leq\\varepsilon\\\\";
    latex += "\\det\\begin{bmatrix}a_{11}&a_{12}&\\cdots&a_{1n}\\\\a_{21}&\\ddots&&\\vdots\\\\\\vdots&&\\ddots&\\vdots\\\\a_{n1}&\\cdots&\\cdots&a_{nn}\\end{bmatrix}\\overset{\\mathrm{def}}{=}\\sum_{\\sigma\\in\\mathfrak{S}_n}\\varepsilon(\\sigma)\\prod_{k=1}^n a_{k\\sigma(k)}\\\\";
    latex += "\\sideset{_\\alpha^\\beta}{_\\gamma^\\delta}{\\begin{pmatrix}a&b\\\\c&d\\end{pmatrix}}\\\\";
    latex += "\\int_0^\\infty{x^{2n} e^{-a x^2}\\,dx} = \\frac{2n-1}{2a} \\int_0^\\infty{x^{2(n-1)} e^{-a x^2}\\,dx} = \\frac{(2n-1)!!}{2^{n+1}} \\sqrt{\\frac{\\pi}{a^{2n+1}}}\\\\";
    latex += "\\int_a^b{f(x)\\,dx} = (b - a) \\sum\\limits_{n = 1}^\\infty  {\\sum\\limits_{m = 1}^{2^n  - 1} {\\left( { - 1} \\right)^{m + 1} } } 2^{ - n} f(a + m\\left( {b - a} \\right)2^{-n} )\\\\";
    latex += "\\int_{-\\pi}^{\\pi} \\sin(\\alpha x) \\sin^n(\\beta x) dx = \\textstyle{\\left \\{ \\begin{array}{cc} (-1)^{(n+1)/2} (-1)^m \\frac{2 \\pi}{2^n} \\binom{n}{m} & n \\mbox{ odd},\\ \\alpha = \\beta (2m-n) \\\\ 0 & \\mbox{otherwise} \\\\ \\end{array} \\right .}\\\\";
    latex += "L = \\int_a^b \\sqrt{ \\left|\\sum_{i,j=1}^ng_{ij}(\\gamma(t))\\left(\\frac{d}{dt}x^i\\circ\\gamma(t)\\right)\\left(\\frac{d}{dt}x^j\\circ\\gamma(t)\\right)\\right|}\\,dt\\\\";
    latex += "\\begin{array}{rl} s &= \\int_a^b\\left\\|\\frac{d}{dt}\\vec{r}\\,(u(t),v(t))\\right\\|\\,dt \\\\ &= \\int_a^b \\sqrt{u'(t)^2\\,\\vec{r}_u\\cdot\\vec{r}_u + 2u'(t)v'(t)\\, \\vec{r}_u\\cdot\\vec{r}_v+ v'(t)^2\\,\\vec{r}_v\\cdot\\vec{r}_v}\\,\\,\\, dt. \\end{array}\\\\";
    latex += "\\end{array}";

    doTest(latex, "Example2");
  }

  private void doTest(String latex, String exampleName) {
    TeXIcon icon = createTeXIcon(latex);
    Image image = createImage(icon);
    // writeImage(image, "BasicTest.png"); // testing
    byte[] imageBytes = getImageBytes(image);
    byte[] expectedBytes = loadResourceFile(exampleName + ".png");
    BufferedImage expectedImage = createImageFromBytes(expectedBytes);
    boolean compare = compareImages(expectedImage, (BufferedImage) image);
    Assert.assertTrue(compare);
    Assert.assertArrayEquals(expectedBytes, imageBytes);
  }

  private TeXIcon createTeXIcon(String latex) {
    TeXFormula formula = null;
    try {
      formula = new TeXFormula(latex);
    } catch (Throwable e) {
      e.printStackTrace();
    }
    TeXIcon icon = formula.new TeXIconBuilder()
        .setStyle(TeXConstants.STYLE_DISPLAY).setSize(20).build();

    icon.setInsets(new Insets(5, 5, 5, 5));
    return icon;
  }

  private Image createImage(TeXIcon icon) {
    Image image = new ImageD(icon.getIconWidth(), icon.getIconHeight(),
        Image.TYPE_INT_ARGB);
    Graphics2DInterface g2 = image.createGraphics2D();
    g2.setColor(ColorUtil.WHITE);
    g2.fillRect(0, 0, icon.getIconWidth(), icon.getIconHeight());
    icon.paintIcon(null, g2, 0, 0);
    return image;
  }

  private byte[] getImageBytes(Image image) {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    try {
      ImageIO.write((BufferedImage) image, "png", os);
    } catch (IOException ex) {
    }
    return os.toByteArray();
  }

  private byte[] loadResourceFile(String name) {
    String path = ClassLoader.getSystemResource(name).getFile();
    try {
      return Files.readAllBytes(Paths.get(path));
    } catch (IOException e) {
      return new byte[1];
    }
  }

  private void writeImage(Image image, String filePath) {
    try {
      ImageIO.write((BufferedImage) image, "png", new File(filePath));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private BufferedImage createImageFromBytes(byte[] imageData) {
    ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
    try {
      return ImageIO.read(bais);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Compares two images pixel by pixel.
   *
   * @param imgA the first image.
   * @param imgB the second image.
   * @return whether the images are both the same or not.
   */
  public static boolean compareImages(BufferedImage imgA, BufferedImage imgB) {
    // The images must be the same size.
    if (imgA.getWidth() == imgB.getWidth()
        && imgA.getHeight() == imgB.getHeight()) {
      int width = imgA.getWidth();
      int height = imgA.getHeight();

      // Loop over every pixel.
      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          // Compare the pixels for equality.
          if (imgA.getRGB(x, y) != imgB.getRGB(x, y)) {
            return false;
          }
        }
      }
    } else {
      return false;
    }

    return true;
  }
}
