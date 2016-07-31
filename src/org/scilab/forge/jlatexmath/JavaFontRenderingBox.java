/* ScaleBox.java
 * =========================================================================
 * This file is part of the JLaTeXMath Library - http://forge.scilab.org/jlatexmath
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

package org.scilab.forge.jlatexmath;

import java.util.HashMap;
import java.util.Map;

import org.scilab.forge.jlatexmath.platform.FontAdapter;
import org.scilab.forge.jlatexmath.platform.Graphics;
import org.scilab.forge.jlatexmath.platform.font.Font;
import org.scilab.forge.jlatexmath.platform.font.TextAttribute;
import org.scilab.forge.jlatexmath.platform.font.TextLayout;
import org.scilab.forge.jlatexmath.platform.geom.Rectangle2D;
import org.scilab.forge.jlatexmath.platform.graphics.Graphics2DInterface;
import org.scilab.forge.jlatexmath.platform.graphics.Image;

/**
 * A box representing a scaled box.
 */
public class JavaFontRenderingBox extends Box {

    private static final Graphics2DInterface TEMPGRAPHIC;
    private static final FontAdapter fontAdapter;
    private static Font font;
    
    private String str;
    private TextLayout text;
    private float size;
    private static TextAttribute KERNING;
    private static Integer KERNING_ON;
    private static TextAttribute LIGATURES;
    private static Integer LIGATURES_ON;

    static {
        TEMPGRAPHIC = new Graphics().createImage(1, 1).createGraphics2D();
        fontAdapter = new FontAdapter();
        font = fontAdapter.createFont("Serif", Font.PLAIN, 10);
        try { // to avoid problems with Java 1.5
            KERNING = fontAdapter.getTextAttribute("KERNING");
            KERNING_ON = fontAdapter.getTextAttributeValue("KERNING_ON");
            LIGATURES = fontAdapter.getTextAttribute("LIGATURES");
            LIGATURES_ON = fontAdapter.getTextAttributeValue("LIGATURES_ON");
        } catch (Exception e) { }
    }

    public JavaFontRenderingBox(String str, int type, float size, Font f, boolean kerning) {
        this.str = str;
        this.size = size;

        if (kerning && KERNING != null) {
            Map<TextAttribute, Object> map = new HashMap<TextAttribute, Object>();
            map.put(KERNING, KERNING_ON);
            map.put(LIGATURES, LIGATURES_ON);
            f = f.deriveFont(map);
        }

        this.text = fontAdapter.createTextLayout(str, f.deriveFont(type), TEMPGRAPHIC.getFontRenderContext());
        Rectangle2D rect = text.getBounds();
        this.height = (float) (-rect.getY() * size / 10);
        this.depth = (float) (rect.getHeight() * size / 10) - this.height;
        this.width = (float) ((rect.getWidth() + rect.getX() + 0.4f) * size / 10);
    }

    public JavaFontRenderingBox(String str, int type, float size) {
        this(str, type, size, font, true);
    }

    public static void setFont(String name) {
        font = fontAdapter.createFont(name, Font.PLAIN, 10);
    }

    public void draw(Graphics2DInterface g2, float x, float y) {
        drawDebug(g2, x, y);
        g2.translate(x, y);
        g2.scale(0.1 * size, 0.1 * size);
        text.draw(g2, 0, 0);
        g2.scale(10 / size, 10 / size);
        g2.translate(-x, -y);
    }

    public int getLastFontId() {
        return 0;
    }
}
