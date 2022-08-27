/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.texture.DynamicTexture
 *  org.lwjgl.opengl.GL11
 */
package ru.hld.legendline.api.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import net.minecraft.client.renderer.texture.DynamicTexture;
import org.lwjgl.opengl.GL11;

public class CFont {
    protected /* synthetic */ boolean antiAlias;
    private final /* synthetic */ float imgSize = 512.0f;
    protected /* synthetic */ DynamicTexture tex;
    protected /* synthetic */ boolean fractionalMetrics;
    protected /* synthetic */ Font font;
    protected /* synthetic */ int fontHeight;
    protected /* synthetic */ CharData[] charData;
    protected /* synthetic */ int charOffset;

    public Font getFont() {
        CFont lllllllllllllIlllIIIIlIIIIlllllI;
        return lllllllllllllIlllIIIIlIIIIlllllI.font;
    }

    public boolean isAntiAlias() {
        CFont lllllllllllllIlllIIIIlIIIlIlIIII;
        return lllllllllllllIlllIIIIlIIIlIlIIII.antiAlias;
    }

    public CFont(Font lllllllllllllIlllIIIIlIlIIlIlIIl, boolean lllllllllllllIlllIIIIlIlIIlIlIII, boolean lllllllllllllIlllIIIIlIlIIlIIlll) {
        CFont lllllllllllllIlllIIIIlIlIIlIlIlI;
        lllllllllllllIlllIIIIlIlIIlIlIlI.imgSize = 512.0f;
        lllllllllllllIlllIIIIlIlIIlIlIlI.charData = new CharData[1110];
        lllllllllllllIlllIIIIlIlIIlIlIlI.fontHeight = -1;
        lllllllllllllIlllIIIIlIlIIlIlIlI.charOffset = 0;
        lllllllllllllIlllIIIIlIlIIlIlIlI.font = lllllllllllllIlllIIIIlIlIIlIlIIl;
        lllllllllllllIlllIIIIlIlIIlIlIlI.antiAlias = lllllllllllllIlllIIIIlIlIIlIlIII;
        lllllllllllllIlllIIIIlIlIIlIlIlI.fractionalMetrics = lllllllllllllIlllIIIIlIlIIlIIlll;
        lllllllllllllIlllIIIIlIlIIlIlIlI.tex = lllllllllllllIlllIIIIlIlIIlIlIlI.setupTexture(lllllllllllllIlllIIIIlIlIIlIlIIl, lllllllllllllIlllIIIIlIlIIlIlIII, lllllllllllllIlllIIIIlIlIIlIIlll, lllllllllllllIlllIIIIlIlIIlIlIlI.charData);
    }

    public boolean isFractionalMetrics() {
        CFont lllllllllllllIlllIIIIlIIIlIIlIII;
        return lllllllllllllIlllIIIIlIIIlIIlIII.fractionalMetrics;
    }

    protected DynamicTexture setupTexture(Font lllllllllllllIlllIIIIlIlIIIlIIll, boolean lllllllllllllIlllIIIIlIlIIIIlIlI, boolean lllllllllllllIlllIIIIlIlIIIIlIII, CharData[] lllllllllllllIlllIIIIlIlIIIlIIII) {
        CFont lllllllllllllIlllIIIIlIlIIIIllII;
        BufferedImage lllllllllllllIlllIIIIlIlIIIIllIl = lllllllllllllIlllIIIIlIlIIIIllII.generateFontImage(lllllllllllllIlllIIIIlIlIIIlIIll, lllllllllllllIlllIIIIlIlIIIIlIlI, lllllllllllllIlllIIIIlIlIIIIlIII, lllllllllllllIlllIIIIlIlIIIlIIII);
        try {
            return new DynamicTexture(lllllllllllllIlllIIIIlIlIIIIllIl);
        }
        catch (Exception lllllllllllllIlllIIIIlIlIIIlIllI) {
            lllllllllllllIlllIIIIlIlIIIlIllI.printStackTrace();
            return null;
        }
    }

    public int getStringHeight(String lllllllllllllIlllIIIIlIIIllIllII) {
        CFont lllllllllllllIlllIIIIlIIIllIlIll;
        return lllllllllllllIlllIIIIlIIIllIlIll.getHeight();
    }

    public void setFont(Font lllllllllllllIlllIIIIlIIIIlllIII) {
        CFont lllllllllllllIlllIIIIlIIIIlllIll;
        lllllllllllllIlllIIIIlIIIIlllIll.font = lllllllllllllIlllIIIIlIIIIlllIII;
        lllllllllllllIlllIIIIlIIIIlllIll.tex = lllllllllllllIlllIIIIlIIIIlllIll.setupTexture(lllllllllllllIlllIIIIlIIIIlllIII, lllllllllllllIlllIIIIlIIIIlllIll.antiAlias, lllllllllllllIlllIIIIlIIIIlllIll.fractionalMetrics, lllllllllllllIlllIIIIlIIIIlllIll.charData);
    }

    public void setFractionalMetrics(boolean lllllllllllllIlllIIIIlIIIlIIIIll) {
        CFont lllllllllllllIlllIIIIlIIIlIIIIlI;
        if (lllllllllllllIlllIIIIlIIIlIIIIlI.fractionalMetrics != lllllllllllllIlllIIIIlIIIlIIIIll) {
            lllllllllllllIlllIIIIlIIIlIIIIlI.fractionalMetrics = lllllllllllllIlllIIIIlIIIlIIIIll;
            lllllllllllllIlllIIIIlIIIlIIIIlI.tex = lllllllllllllIlllIIIIlIIIlIIIIlI.setupTexture(lllllllllllllIlllIIIIlIIIlIIIIlI.font, lllllllllllllIlllIIIIlIIIlIIIIlI.antiAlias, lllllllllllllIlllIIIIlIIIlIIIIll, lllllllllllllIlllIIIIlIIIlIIIIlI.charData);
        }
    }

    public void setAntiAlias(boolean lllllllllllllIlllIIIIlIIIlIIlIlI) {
        CFont lllllllllllllIlllIIIIlIIIlIIlIll;
        if (lllllllllllllIlllIIIIlIIIlIIlIll.antiAlias != lllllllllllllIlllIIIIlIIIlIIlIlI) {
            lllllllllllllIlllIIIIlIIIlIIlIll.antiAlias = lllllllllllllIlllIIIIlIIIlIIlIlI;
            lllllllllllllIlllIIIIlIIIlIIlIll.tex = lllllllllllllIlllIIIIlIIIlIIlIll.setupTexture(lllllllllllllIlllIIIIlIIIlIIlIll.font, lllllllllllllIlllIIIIlIIIlIIlIlI, lllllllllllllIlllIIIIlIIIlIIlIll.fractionalMetrics, lllllllllllllIlllIIIIlIIIlIIlIll.charData);
        }
    }

    protected BufferedImage generateFontImage(Font lllllllllllllIlllIIIIlIIllIlIIlI, boolean lllllllllllllIlllIIIIlIIllIlIIIl, boolean lllllllllllllIlllIIIIlIIllIlIIII, CharData[] lllllllllllllIlllIIIIlIIlIlllIII) {
        CFont lllllllllllllIlllIIIIlIIllIlIllI;
        lllllllllllllIlllIIIIlIIllIlIllI.getClass();
        int lllllllllllllIlllIIIIlIIllIIllII = 512;
        BufferedImage lllllllllllllIlllIIIIlIIllIIlIlI = new BufferedImage(lllllllllllllIlllIIIIlIIllIIllII, lllllllllllllIlllIIIIlIIllIIllII, 2);
        Graphics2D lllllllllllllIlllIIIIlIIllIIlIIl = (Graphics2D)lllllllllllllIlllIIIIlIIllIIlIlI.getGraphics();
        lllllllllllllIlllIIIIlIIllIIlIIl.setFont(lllllllllllllIlllIIIIlIIllIlIIlI);
        lllllllllllllIlllIIIIlIIllIIlIIl.setColor(new Color(255, 255, 255, 0));
        lllllllllllllIlllIIIIlIIllIIlIIl.fillRect(0, 0, lllllllllllllIlllIIIIlIIllIIllII, lllllllllllllIlllIIIIlIIllIIllII);
        lllllllllllllIlllIIIIlIIllIIlIIl.setColor(Color.WHITE);
        lllllllllllllIlllIIIIlIIllIIlIIl.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, lllllllllllllIlllIIIIlIIllIlIIII ? RenderingHints.VALUE_FRACTIONALMETRICS_ON : RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
        lllllllllllllIlllIIIIlIIllIIlIIl.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, lllllllllllllIlllIIIIlIIllIlIIIl ? RenderingHints.VALUE_TEXT_ANTIALIAS_ON : RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        lllllllllllllIlllIIIIlIIllIIlIIl.setRenderingHint(RenderingHints.KEY_ANTIALIASING, lllllllllllllIlllIIIIlIIllIlIIIl ? RenderingHints.VALUE_ANTIALIAS_ON : RenderingHints.VALUE_ANTIALIAS_OFF);
        FontMetrics lllllllllllllIlllIIIIlIIllIIlIII = lllllllllllllIlllIIIIlIIllIIlIIl.getFontMetrics();
        int lllllllllllllIlllIIIIlIIllIIIlll = 0;
        int lllllllllllllIlllIIIIlIIllIIIllI = 0;
        int lllllllllllllIlllIIIIlIIllIIIlIl = 1;
        for (int lllllllllllllIlllIIIIlIIllIllIII = 0; lllllllllllllIlllIIIIlIIllIllIII < lllllllllllllIlllIIIIlIIlIlllIII.length; ++lllllllllllllIlllIIIIlIIllIllIII) {
            char lllllllllllllIlllIIIIlIIllIllIlI = (char)lllllllllllllIlllIIIIlIIllIllIII;
            if (lllllllllllllIlllIIIIlIIllIllIlI > '\u040e' || lllllllllllllIlllIIIIlIIllIllIlI < '\u0100') {
                CharData lllllllllllllIlllIIIIlIIllIlllIl = lllllllllllllIlllIIIIlIIllIlIllI.new CharData();
                Rectangle2D lllllllllllllIlllIIIIlIIllIlllII = lllllllllllllIlllIIIIlIIllIIlIII.getStringBounds(String.valueOf(lllllllllllllIlllIIIIlIIllIllIlI), lllllllllllllIlllIIIIlIIllIIlIIl);
                lllllllllllllIlllIIIIlIIllIlllIl.width = lllllllllllllIlllIIIIlIIllIlllII.getBounds().width + 8;
                lllllllllllllIlllIIIIlIIllIlllIl.height = lllllllllllllIlllIIIIlIIllIlllII.getBounds().height;
                if (lllllllllllllIlllIIIIlIIllIIIllI + lllllllllllllIlllIIIIlIIllIlllIl.width >= lllllllllllllIlllIIIIlIIllIIllII) {
                    lllllllllllllIlllIIIIlIIllIIIllI = 0;
                    lllllllllllllIlllIIIIlIIllIIIlIl += lllllllllllllIlllIIIIlIIllIIIlll;
                    lllllllllllllIlllIIIIlIIllIIIlll = 0;
                }
                if (lllllllllllllIlllIIIIlIIllIlllIl.height > lllllllllllllIlllIIIIlIIllIIIlll) {
                    lllllllllllllIlllIIIIlIIllIIIlll = lllllllllllllIlllIIIIlIIllIlllIl.height;
                }
                lllllllllllllIlllIIIIlIIllIlllIl.storedX = lllllllllllllIlllIIIIlIIllIIIllI;
                lllllllllllllIlllIIIIlIIllIlllIl.storedY = lllllllllllllIlllIIIIlIIllIIIlIl;
                if (lllllllllllllIlllIIIIlIIllIlllIl.height > lllllllllllllIlllIIIIlIIllIlIllI.fontHeight) {
                    lllllllllllllIlllIIIIlIIllIlIllI.fontHeight = lllllllllllllIlllIIIIlIIllIlllIl.height;
                }
                lllllllllllllIlllIIIIlIIlIlllIII[lllllllllllllIlllIIIIlIIllIllIII] = lllllllllllllIlllIIIIlIIllIlllIl;
                lllllllllllllIlllIIIIlIIllIIlIIl.drawString(String.valueOf(lllllllllllllIlllIIIIlIIllIllIlI), lllllllllllllIlllIIIIlIIllIIIllI + 2, lllllllllllllIlllIIIIlIIllIIIlIl + lllllllllllllIlllIIIIlIIllIIlIII.getAscent());
                lllllllllllllIlllIIIIlIIllIIIllI += lllllllllllllIlllIIIIlIIllIlllIl.width;
                continue;
            }
            lllllllllllllIlllIIIIlIIlIlllIII[lllllllllllllIlllIIIIlIIllIllIII] = null;
        }
        return lllllllllllllIlllIIIIlIIllIIlIlI;
    }

    public int getStringWidth(String lllllllllllllIlllIIIIlIIIlIlllIl) {
        int lllllllllllllIlllIIIIlIIIlIlllII = 0;
        for (char lllllllllllllIlllIIIIlIIIllIIIII : lllllllllllllIlllIIIIlIIIlIlllIl.toCharArray()) {
            CFont lllllllllllllIlllIIIIlIIIlIllIIl;
            if (lllllllllllllIlllIIIIlIIIllIIIII >= lllllllllllllIlllIIIIlIIIlIllIIl.charData.length || lllllllllllllIlllIIIIlIIIllIIIII < '\u0000') continue;
            lllllllllllllIlllIIIIlIIIlIlllII += lllllllllllllIlllIIIIlIIIlIllIIl.charData[lllllllllllllIlllIIIIlIIIllIIIII].width - 8 + lllllllllllllIlllIIIIlIIIlIllIIl.charOffset;
        }
        return lllllllllllllIlllIIIIlIIIlIlllII / 2;
    }

    public void drawChar(CharData[] lllllllllllllIlllIIIIlIIlIIlllIl, char lllllllllllllIlllIIIIlIIlIIlIlll, float lllllllllllllIlllIIIIlIIlIIlIllI, float lllllllllllllIlllIIIIlIIlIIlIlIl) throws ArrayIndexOutOfBoundsException {
        try {
            CFont lllllllllllllIlllIIIIlIIlIIllIIl;
            lllllllllllllIlllIIIIlIIlIIllIIl.drawQuad(lllllllllllllIlllIIIIlIIlIIlIllI, lllllllllllllIlllIIIIlIIlIIlIlIl, lllllllllllllIlllIIIIlIIlIIlllIl[lllllllllllllIlllIIIIlIIlIIlIlll].width, lllllllllllllIlllIIIIlIIlIIlllIl[lllllllllllllIlllIIIIlIIlIIlIlll].height, lllllllllllllIlllIIIIlIIlIIlllIl[lllllllllllllIlllIIIIlIIlIIlIlll].storedX, lllllllllllllIlllIIIIlIIlIIlllIl[lllllllllllllIlllIIIIlIIlIIlIlll].storedY, lllllllllllllIlllIIIIlIIlIIlllIl[lllllllllllllIlllIIIIlIIlIIlIlll].width, lllllllllllllIlllIIIIlIIlIIlllIl[lllllllllllllIlllIIIIlIIlIIlIlll].height);
        }
        catch (Exception lllllllllllllIlllIIIIlIIlIIlllll) {
            lllllllllllllIlllIIIIlIIlIIlllll.printStackTrace();
        }
    }

    protected void drawQuad(float lllllllllllllIlllIIIIlIIIllllIlI, float lllllllllllllIlllIIIIlIIlIIIIlIl, float lllllllllllllIlllIIIIlIIlIIIIlII, float lllllllllllllIlllIIIIlIIIlllIlll, float lllllllllllllIlllIIIIlIIIlllIllI, float lllllllllllllIlllIIIIlIIlIIIIIIl, float lllllllllllllIlllIIIIlIIlIIIIIII, float lllllllllllllIlllIIIIlIIIlllIIll) {
        float lllllllllllllIlllIIIIlIIIllllllI = lllllllllllllIlllIIIIlIIIlllIllI / 512.0f;
        float lllllllllllllIlllIIIIlIIIlllllIl = lllllllllllllIlllIIIIlIIlIIIIIIl / 512.0f;
        float lllllllllllllIlllIIIIlIIIlllllII = lllllllllllllIlllIIIIlIIlIIIIIII / 512.0f;
        float lllllllllllllIlllIIIIlIIIllllIll = lllllllllllllIlllIIIIlIIIlllIIll / 512.0f;
        GL11.glTexCoord2f((float)(lllllllllllllIlllIIIIlIIIllllllI + lllllllllllllIlllIIIIlIIIlllllII), (float)lllllllllllllIlllIIIIlIIIlllllIl);
        GL11.glVertex2d((double)(lllllllllllllIlllIIIIlIIIllllIlI + lllllllllllllIlllIIIIlIIlIIIIlII), (double)lllllllllllllIlllIIIIlIIlIIIIlIl);
        GL11.glTexCoord2f((float)lllllllllllllIlllIIIIlIIIllllllI, (float)lllllllllllllIlllIIIIlIIIlllllIl);
        GL11.glVertex2d((double)lllllllllllllIlllIIIIlIIIllllIlI, (double)lllllllllllllIlllIIIIlIIlIIIIlIl);
        GL11.glTexCoord2f((float)lllllllllllllIlllIIIIlIIIllllllI, (float)(lllllllllllllIlllIIIIlIIIlllllIl + lllllllllllllIlllIIIIlIIIllllIll));
        GL11.glVertex2d((double)lllllllllllllIlllIIIIlIIIllllIlI, (double)(lllllllllllllIlllIIIIlIIlIIIIlIl + lllllllllllllIlllIIIIlIIIlllIlll));
        GL11.glTexCoord2f((float)lllllllllllllIlllIIIIlIIIllllllI, (float)(lllllllllllllIlllIIIIlIIIlllllIl + lllllllllllllIlllIIIIlIIIllllIll));
        GL11.glVertex2d((double)lllllllllllllIlllIIIIlIIIllllIlI, (double)(lllllllllllllIlllIIIIlIIlIIIIlIl + lllllllllllllIlllIIIIlIIIlllIlll));
        GL11.glTexCoord2f((float)(lllllllllllllIlllIIIIlIIIllllllI + lllllllllllllIlllIIIIlIIIlllllII), (float)(lllllllllllllIlllIIIIlIIIlllllIl + lllllllllllllIlllIIIIlIIIllllIll));
        GL11.glVertex2d((double)(lllllllllllllIlllIIIIlIIIllllIlI + lllllllllllllIlllIIIIlIIlIIIIlII), (double)(lllllllllllllIlllIIIIlIIlIIIIlIl + lllllllllllllIlllIIIIlIIIlllIlll));
        GL11.glTexCoord2f((float)(lllllllllllllIlllIIIIlIIIllllllI + lllllllllllllIlllIIIIlIIIlllllII), (float)lllllllllllllIlllIIIIlIIIlllllIl);
        GL11.glVertex2d((double)(lllllllllllllIlllIIIIlIIIllllIlI + lllllllllllllIlllIIIIlIIlIIIIlII), (double)lllllllllllllIlllIIIIlIIlIIIIlIl);
    }

    public int getHeight() {
        CFont lllllllllllllIlllIIIIlIIIllIlIII;
        return (lllllllllllllIlllIIIIlIIIllIlIII.fontHeight - 8) / 2;
    }

    protected class CharData {
        public /* synthetic */ int width;
        public /* synthetic */ int storedY;
        public /* synthetic */ int height;
        public /* synthetic */ int storedX;

        protected CharData() {
            CharData lllllllllllllIlllIIlllIIlIlIIlII;
        }
    }
}

