package at.illecker.jlatexmath.platform.test;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.scilab.forge.jlatexmath.platform.graphics.Image;

public final class ImageUtils {

  public static byte[] getImageBytes(Image image) {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    try {
      ImageIO.write((BufferedImage) image, "png", os);
    } catch (IOException ex) {
    }
    return os.toByteArray();
  }

  public static BufferedImage createImageFromBytes(byte[] imageData) {
    ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
    try {
      return ImageIO.read(bais);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void writeImage(Image image, String name) {
    try {
      String filePath = PlatformBasicTest.class
          .getResource("PlatformBasicTest.class").getPath();
      filePath = new File(filePath).getParent() + "/" + name;
      ImageIO.write((BufferedImage) image, "png", new File(filePath));
    } catch (IOException e) {
      e.printStackTrace();
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
