package org.scilab.forge.jlatexmath.platform.resources;

import org.scilab.forge.jlatexmath.ResourceParseException;

public interface ResourceLoader {

  Object loadResource(Object base, String path) throws ResourceParseException;

}
