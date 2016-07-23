package org.scilab.forge.jlatexmath.platform;

import org.scilab.forge.jlatexmath.ResourceParseException;
import org.scilab.forge.jlatexmath.platform.resources.ResourceLoader;

public class Resource {
  public ResourceLoader resourceLoader = null;

  public Resource() {
    resourceLoader = FactoryProvider.INSTANCE.getResourceLoaderFactory()
        .createResourceLoader();
  }

  public Object loadResource(String path) throws ResourceParseException {
    return resourceLoader.loadResource(null, path);
  }

  public Object loadResource(Object base, String path)
      throws ResourceParseException {
    return resourceLoader.loadResource(base, path);
  }

}
