package at.illecker.jlatexmath.platform.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class IOUtils {

  public static byte[] loadResourceFile(String name) {
    try {
      InputStream in = loadResourceFile(null, name);
      if (in != null) {
        return readFully(in);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static InputStream loadResourceFile(Class<?> clazz, String name) {
    if (clazz != null) {
      return clazz.getResourceAsStream(name);
    } else {
      return PlatformBasicTest.class.getResourceAsStream(name);
    }
  }

  public static byte[] readFully(InputStream input) throws IOException {
    byte[] buffer = new byte[8192];
    int bytesRead;
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    while ((bytesRead = input.read(buffer)) != -1) {
      output.write(buffer, 0, bytesRead);
    }
    return output.toByteArray();
  }

}
