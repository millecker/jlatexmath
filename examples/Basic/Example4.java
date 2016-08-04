/* Example4.java
 * =========================================================================
 * This file is part of the JLaTeXMath Library - http://jlatexmath.sourceforge.net
 * 
 * Copyright (C) 2009 DENIZET Calixte
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

import org.scilab.forge.jlatexmath.ColorUtil;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;
import org.scilab.forge.jlatexmath.platform.FactoryProvider;
import org.scilab.forge.jlatexmath.platform.Graphics;
import org.scilab.forge.jlatexmath.platform.graphics.Graphics2DInterface;
import org.scilab.forge.jlatexmath.platform.graphics.Image;
import org.scilab.forge.jlatexmath.platform.graphics.Insets;

import at.illecker.jlatexmath.platform.desktop.FactoryProviderDesktop;

/**
 * A class to test LaTeX rendering.
 **/
public class Example4 {
    public static void main(String[] args) {
	
        FactoryProvider.INSTANCE = new FactoryProviderDesktop();
      
	String latex = "\\begin{array}{|c|c|c|c|}\n";
	latex += "\\multicolumn{4}{c}{\\shadowbox{\\text{\\Huge An image from the \\LaTeX3 project}}}\\cr\n";
	latex += "\\hline\n";
	latex += "\\text{Left}\\includegraphics{lion.png}\\text{Right} & \\text{Left}\\includegraphics[width=3cm,interpolation=bicubic]{lion.png}\\text{Right} & \\text{Left}\\includegraphics[angle=45,width=3cm]{lion.png}\\text{Right} & \\text{Left}\\includegraphics[angle=160]{lion.png}\\text{Right} \\cr\n";
	latex += "\\hline\n";
	latex += "\\text{\\backslash includegraphics\\{lion.png\\}} & \\text{\\backslash includegraphics[width=3cm,interpolation=bicubic]\\{lion.png\\}} & \\text{\\backslash includegraphics[angle=45,width=3cm]\\{lion.png\\}} & \\text{\\backslash includegraphics[angle=160]\\{lion.png\\}}\\cr\n";
	latex += "\\hline\n";
	latex += "\\end{array}\n";

	TeXFormula formula = new TeXFormula(latex);
	// Note: Old interface for creating icons:
	//TeXIcon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 10);
	// Note: New interface using builder pattern (inner class):
	TeXIcon icon = formula.new TeXIconBuilder().setStyle(TeXConstants.STYLE_DISPLAY).setSize(10).build();

	icon.setInsets(new Insets(5, 5, 5, 5));
	
	Graphics graphics = new Graphics();
	Image image = graphics.createImage(icon.getIconWidth(), icon.getIconHeight(), Image.TYPE_INT_ARGB);
	Graphics2DInterface g2 = image.createGraphics2D();
	g2.setColor(ColorUtil.WHITE);
	g2.fillRect(0,0,icon.getIconWidth(),icon.getIconHeight());
	icon.paintIcon(null, g2, 0, 0);
        graphics.writeImage(image, "png", "Example4.png");
    }    
}
