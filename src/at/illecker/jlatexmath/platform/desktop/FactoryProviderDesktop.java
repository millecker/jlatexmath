/**
 * This file is part of the ReTeX library - https://github.com/himamis/ReTeX
 *
 * Copyright (C) 2015 Balazs Bencze
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or (at
 * your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * A copy of the GNU General Public License can be found in the file
 * LICENSE.txt provided with the source distribution of this program (see
 * the META-INF directory in the source jar). This license can also be
 * found on the GNU website at http://www.gnu.org/licenses/gpl.html.
 *
 * If you did not receive a copy of the GNU General Public License along
 * with this program, contact the lead developer, or write to the Free
 * Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 *
 * Linking this library statically or dynamically with other modules 
 * is making a combined work based on this library. Thus, the terms 
 * and conditions of the GNU General Public License cover the whole 
 * combination.
 * 
 * As a special exception, the copyright holders of this library give you 
 * permission to link this library with independent modules to produce 
 * an executable, regardless of the license terms of these independent 
 * modules, and to copy and distribute the resulting executable under terms 
 * of your choice, provided that you also meet, for each linked independent 
 * module, the terms and conditions of the license of that module. 
 * An independent module is a module which is not derived from or based 
 * on this library. If you modify this library, you may extend this exception 
 * to your version of the library, but you are not obliged to do so. 
 * If you do not wish to do so, delete this exception statement from your 
 * version.
 * 
 */
package at.illecker.jlatexmath.platform.desktop;

import org.scilab.forge.jlatexmath.platform.FactoryProvider;
import org.scilab.forge.jlatexmath.platform.font.FontFactory;
import org.scilab.forge.jlatexmath.platform.geom.GeomFactory;
import org.scilab.forge.jlatexmath.platform.graphics.GraphicsFactory;
import org.scilab.forge.jlatexmath.platform.parser.ParserFactory;
import org.scilab.forge.jlatexmath.platform.resources.ResourceLoaderFactory;

import at.illecker.jlatexmath.platform.desktop.font.FontFactoryDesktop;
import at.illecker.jlatexmath.platform.desktop.geom.GeomFactoryDesktop;
import at.illecker.jlatexmath.platform.desktop.graphics.GraphicsFactoryDesktop;
import at.illecker.jlatexmath.platform.desktop.parser.ParserFactoryDesktop;
import at.illecker.jlatexmath.platform.desktop.resources.ResourceLoaderFactoryDesktop;

public class FactoryProviderDesktop extends FactoryProvider {

  @Override
  protected FontFactory createFontFactory() {
    return new FontFactoryDesktop();
  }

  @Override
  protected GeomFactory createGeomFactory() {
    return new GeomFactoryDesktop();
  }

  @Override
  protected GraphicsFactory createGraphicsFactory() {
    return new GraphicsFactoryDesktop();
  }

  @Override
  protected ParserFactory createParserFactory() {
    return new ParserFactoryDesktop();
  }

  @Override
  protected ResourceLoaderFactory createResourceLoaderFactory() {
    return new ResourceLoaderFactoryDesktop();
  }
}
