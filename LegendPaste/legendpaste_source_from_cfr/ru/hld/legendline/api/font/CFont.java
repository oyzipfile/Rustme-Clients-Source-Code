/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.texture.DynamicTexture
 *  org.lwjgl.opengl.GL11
 */
package ru.hld.legendline.api.font;

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
    protected /* synthetic */ boolean fractionalMetrics;
    protected /* synthetic */ int charOffset;
    private /* synthetic */ float imgSize;
    protected /* synthetic */ Font font;
    protected /* synthetic */ CharData[] charData;
    protected /* synthetic */ int fontHeight;
    protected /* synthetic */ boolean antiAlias;
    protected /* synthetic */ DynamicTexture tex;

    public DynamicTexture setupTexture(Font llllllllllllllllIIIlllIlllIIIlII, boolean llllllllllllllllIIIlllIllIllllIl, boolean llllllllllllllllIIIlllIllIllllII, CharData[] llllllllllllllllIIIlllIlllIIIIIl) {
        CFont llllllllllllllllIIIlllIllIllllll;
        BufferedImage llllllllllllllllIIIlllIlllIIIIII = llllllllllllllllIIIlllIllIllllll.generateFontImage(llllllllllllllllIIIlllIlllIIIlII, llllllllllllllllIIIlllIllIllllIl, llllllllllllllllIIIlllIllIllllII, llllllllllllllllIIIlllIlllIIIIIl);
        try {
            return new DynamicTexture(llllllllllllllllIIIlllIlllIIIIII);
        }
        catch (Exception llllllllllllllllIIIlllIlllIIIllI) {
            llllllllllllllllIIIlllIlllIIIllI.printStackTrace();
            return null;
        }
    }

    public void setFont(Font llllllllllllllllIIIlllIlIIIllIll) {
        CFont llllllllllllllllIIIlllIlIIIllIlI;
        llllllllllllllllIIIlllIlIIIllIlI.font = llllllllllllllllIIIlllIlIIIllIll;
        llllllllllllllllIIIlllIlIIIllIlI.tex = llllllllllllllllIIIlllIlIIIllIlI.setupTexture(llllllllllllllllIIIlllIlIIIllIll, llllllllllllllllIIIlllIlIIIllIlI.antiAlias, llllllllllllllllIIIlllIlIIIllIlI.fractionalMetrics, llllllllllllllllIIIlllIlIIIllIlI.charData);
    }

    public int getStringWidth(String llllllllllllllllIIIlllIlIIlllllI) {
        int llllllllllllllllIIIlllIlIIllllIl = 0;
        for (char llllllllllllllllIIIlllIlIlIIIIIl : llllllllllllllllIIIlllIlIIlllllI.toCharArray()) {
            CFont llllllllllllllllIIIlllIlIIllllll;
            if (llllllllllllllllIIIlllIlIlIIIIIl >= llllllllllllllllIIIlllIlIIllllll.charData.length || llllllllllllllllIIIlllIlIlIIIIIl < '\u0000') continue;
            llllllllllllllllIIIlllIlIIllllIl += llllllllllllllllIIIlllIlIIllllll.charData[llllllllllllllllIIIlllIlIlIIIIIl].width - 8 + llllllllllllllllIIIlllIlIIllllll.charOffset;
        }
        return llllllllllllllllIIIlllIlIIllllIl / 2;
    }

    public boolean isFractionalMetrics() {
        CFont llllllllllllllllIIIlllIlIIlIlIII;
        return llllllllllllllllIIIlllIlIIlIlIII.fractionalMetrics;
    }

    protected void drawQuad(float llllllllllllllllIIIlllIlIlIllIll, float llllllllllllllllIIIlllIlIlIllIlI, float llllllllllllllllIIIlllIlIlIllIIl, float llllllllllllllllIIIlllIlIlIllIII, float llllllllllllllllIIIlllIlIllIIlII, float llllllllllllllllIIIlllIlIllIIIll, float llllllllllllllllIIIlllIlIlIlIlIl, float llllllllllllllllIIIlllIlIlIlIlII) {
        CFont llllllllllllllllIIIlllIlIlIlllII;
        float llllllllllllllllIIIlllIlIllIIIII = llllllllllllllllIIIlllIlIllIIlII / llllllllllllllllIIIlllIlIlIlllII.imgSize;
        float llllllllllllllllIIIlllIlIlIlllll = llllllllllllllllIIIlllIlIllIIIll / llllllllllllllllIIIlllIlIlIlllII.imgSize;
        float llllllllllllllllIIIlllIlIlIllllI = llllllllllllllllIIIlllIlIlIlIlIl / llllllllllllllllIIIlllIlIlIlllII.imgSize;
        float llllllllllllllllIIIlllIlIlIlllIl = llllllllllllllllIIIlllIlIlIlIlII / llllllllllllllllIIIlllIlIlIlllII.imgSize;
        GL11.glTexCoord2f((float)(llllllllllllllllIIIlllIlIllIIIII + llllllllllllllllIIIlllIlIlIllllI), (float)llllllllllllllllIIIlllIlIlIlllll);
        GL11.glVertex2d((double)(llllllllllllllllIIIlllIlIlIllIll + llllllllllllllllIIIlllIlIlIllIIl), (double)llllllllllllllllIIIlllIlIlIllIlI);
        GL11.glTexCoord2f((float)llllllllllllllllIIIlllIlIllIIIII, (float)llllllllllllllllIIIlllIlIlIlllll);
        GL11.glVertex2d((double)llllllllllllllllIIIlllIlIlIllIll, (double)llllllllllllllllIIIlllIlIlIllIlI);
        GL11.glTexCoord2f((float)llllllllllllllllIIIlllIlIllIIIII, (float)(llllllllllllllllIIIlllIlIlIlllll + llllllllllllllllIIIlllIlIlIlllIl));
        GL11.glVertex2d((double)llllllllllllllllIIIlllIlIlIllIll, (double)(llllllllllllllllIIIlllIlIlIllIlI + llllllllllllllllIIIlllIlIlIllIII));
        GL11.glTexCoord2f((float)llllllllllllllllIIIlllIlIllIIIII, (float)(llllllllllllllllIIIlllIlIlIlllll + llllllllllllllllIIIlllIlIlIlllIl));
        GL11.glVertex2d((double)llllllllllllllllIIIlllIlIlIllIll, (double)(llllllllllllllllIIIlllIlIlIllIlI + llllllllllllllllIIIlllIlIlIllIII));
        GL11.glTexCoord2f((float)(llllllllllllllllIIIlllIlIllIIIII + llllllllllllllllIIIlllIlIlIllllI), (float)(llllllllllllllllIIIlllIlIlIlllll + llllllllllllllllIIIlllIlIlIlllIl));
        GL11.glVertex2d((double)(llllllllllllllllIIIlllIlIlIllIll + llllllllllllllllIIIlllIlIlIllIIl), (double)(llllllllllllllllIIIlllIlIlIllIlI + llllllllllllllllIIIlllIlIlIllIII));
        GL11.glTexCoord2f((float)(llllllllllllllllIIIlllIlIllIIIII + llllllllllllllllIIIlllIlIlIllllI), (float)llllllllllllllllIIIlllIlIlIlllll);
        GL11.glVertex2d((double)(llllllllllllllllIIIlllIlIlIllIll + llllllllllllllllIIIlllIlIlIllIIl), (double)llllllllllllllllIIIlllIlIlIllIlI);
    }

    public boolean isAntiAlias() {
        CFont llllllllllllllllIIIlllIlIIllIIIl;
        return llllllllllllllllIIIlllIlIIllIIIl.antiAlias;
    }

    public void drawChar(CharData[] llllllllllllllllIIIlllIllIIIIIII, char llllllllllllllllIIIlllIlIllllIlI, float llllllllllllllllIIIlllIlIllllIIl, float llllllllllllllllIIIlllIlIlllllIl) throws ArrayIndexOutOfBoundsException {
        try {
            CFont llllllllllllllllIIIlllIlIlllllII;
            llllllllllllllllIIIlllIlIlllllII.drawQuad(llllllllllllllllIIIlllIlIllllIIl, llllllllllllllllIIIlllIlIlllllIl, llllllllllllllllIIIlllIllIIIIIII[llllllllllllllllIIIlllIlIllllIlI].width, llllllllllllllllIIIlllIllIIIIIII[llllllllllllllllIIIlllIlIllllIlI].height, llllllllllllllllIIIlllIllIIIIIII[llllllllllllllllIIIlllIlIllllIlI].storedX, llllllllllllllllIIIlllIllIIIIIII[llllllllllllllllIIIlllIlIllllIlI].storedY, llllllllllllllllIIIlllIllIIIIIII[llllllllllllllllIIIlllIlIllllIlI].width, llllllllllllllllIIIlllIllIIIIIII[llllllllllllllllIIIlllIlIllllIlI].height);
        }
        catch (Exception llllllllllllllllIIIlllIllIIIIIlI) {
            llllllllllllllllIIIlllIllIIIIIlI.printStackTrace();
        }
    }

    public void setFractionalMetrics(boolean llllllllllllllllIIIlllIlIIlIIIlI) {
        CFont llllllllllllllllIIIlllIlIIlIIlIl;
        if (llllllllllllllllIIIlllIlIIlIIlIl.fractionalMetrics != llllllllllllllllIIIlllIlIIlIIIlI) {
            llllllllllllllllIIIlllIlIIlIIlIl.fractionalMetrics = llllllllllllllllIIIlllIlIIlIIIlI;
            llllllllllllllllIIIlllIlIIlIIlIl.tex = llllllllllllllllIIIlllIlIIlIIlIl.setupTexture(llllllllllllllllIIIlllIlIIlIIlIl.font, llllllllllllllllIIIlllIlIIlIIlIl.antiAlias, llllllllllllllllIIIlllIlIIlIIIlI, llllllllllllllllIIIlllIlIIlIIlIl.charData);
        }
    }

    public int getHeight() {
        CFont llllllllllllllllIIIlllIlIlIIlIIl;
        return (llllllllllllllllIIIlllIlIlIIlIIl.fontHeight - 8) / 2;
    }

    public void setAntiAlias(boolean llllllllllllllllIIIlllIlIIlIlIll) {
        CFont llllllllllllllllIIIlllIlIIlIllII;
        if (llllllllllllllllIIIlllIlIIlIllII.antiAlias != llllllllllllllllIIIlllIlIIlIlIll) {
            llllllllllllllllIIIlllIlIIlIllII.antiAlias = llllllllllllllllIIIlllIlIIlIlIll;
            llllllllllllllllIIIlllIlIIlIllII.tex = llllllllllllllllIIIlllIlIIlIllII.setupTexture(llllllllllllllllIIIlllIlIIlIllII.font, llllllllllllllllIIIlllIlIIlIlIll, llllllllllllllllIIIlllIlIIlIllII.fractionalMetrics, llllllllllllllllIIIlllIlIIlIllII.charData);
        }
    }

    public int getStringHeight(String llllllllllllllllIIIlllIlIlIIllIl) {
        CFont llllllllllllllllIIIlllIlIlIIlllI;
        return llllllllllllllllIIIlllIlIlIIlllI.getHeight();
    }

    public Font getFont() {
        CFont llllllllllllllllIIIlllIlIIIlllll;
        return llllllllllllllllIIIlllIlIIIlllll.font;
    }

    public CFont(Font llllllllllllllllIIIlllIlllIlIIII, boolean llllllllllllllllIIIlllIlllIlIIll, boolean llllllllllllllllIIIlllIlllIIlllI) {
        CFont llllllllllllllllIIIlllIlllIlIIIl;
        llllllllllllllllIIIlllIlllIlIIIl.charData = new CharData[256];
        llllllllllllllllIIIlllIlllIlIIIl.fontHeight = -1;
        llllllllllllllllIIIlllIlllIlIIIl.charOffset = 0;
        llllllllllllllllIIIlllIlllIlIIIl.imgSize = 512.0f;
        llllllllllllllllIIIlllIlllIlIIIl.font = llllllllllllllllIIIlllIlllIlIIII;
        llllllllllllllllIIIlllIlllIlIIIl.antiAlias = llllllllllllllllIIIlllIlllIlIIll;
        llllllllllllllllIIIlllIlllIlIIIl.fractionalMetrics = llllllllllllllllIIIlllIlllIIlllI;
        llllllllllllllllIIIlllIlllIlIIIl.tex = llllllllllllllllIIIlllIlllIlIIIl.setupTexture(llllllllllllllllIIIlllIlllIlIIII, llllllllllllllllIIIlllIlllIlIIll, llllllllllllllllIIIlllIlllIIlllI, llllllllllllllllIIIlllIlllIlIIIl.charData);
    }

    protected BufferedImage generateFontImage(Font llllllllllllllllIIIlllIllIlIIIll, boolean llllllllllllllllIIIlllIllIlIIIlI, boolean llllllllllllllllIIIlllIllIlIIIIl, CharData[] llllllllllllllllIIIlllIllIIlIlII) {
        CFont llllllllllllllllIIIlllIllIlIIlII;
        int llllllllllllllllIIIlllIllIIlllll = (int)llllllllllllllllIIIlllIllIlIIlII.imgSize;
        BufferedImage llllllllllllllllIIIlllIllIIllllI = new BufferedImage(llllllllllllllllIIIlllIllIIlllll, llllllllllllllllIIIlllIllIIlllll, 2);
        Graphics2D llllllllllllllllIIIlllIllIIlllIl = (Graphics2D)llllllllllllllllIIIlllIllIIllllI.getGraphics();
        llllllllllllllllIIIlllIllIIlllIl.setFont(llllllllllllllllIIIlllIllIlIIIll);
        llllllllllllllllIIIlllIllIIlllIl.setColor(new Color(255, 255, 255, 0));
        llllllllllllllllIIIlllIllIIlllIl.fillRect(0, 0, llllllllllllllllIIIlllIllIIlllll, llllllllllllllllIIIlllIllIIlllll);
        llllllllllllllllIIIlllIllIIlllIl.setColor(Color.WHITE);
        llllllllllllllllIIIlllIllIIlllIl.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, llllllllllllllllIIIlllIllIlIIIIl ? RenderingHints.VALUE_FRACTIONALMETRICS_ON : RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
        llllllllllllllllIIIlllIllIIlllIl.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, llllllllllllllllIIIlllIllIlIIIlI ? RenderingHints.VALUE_TEXT_ANTIALIAS_ON : RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        llllllllllllllllIIIlllIllIIlllIl.setRenderingHint(RenderingHints.KEY_ANTIALIASING, llllllllllllllllIIIlllIllIlIIIlI ? RenderingHints.VALUE_ANTIALIAS_ON : RenderingHints.VALUE_ANTIALIAS_OFF);
        FontMetrics llllllllllllllllIIIlllIllIIlllII = llllllllllllllllIIIlllIllIIlllIl.getFontMetrics();
        int llllllllllllllllIIIlllIllIIllIll = 0;
        int llllllllllllllllIIIlllIllIIllIlI = 0;
        int llllllllllllllllIIIlllIllIIllIIl = 1;
        for (int llllllllllllllllIIIlllIllIlIIlIl = 0; llllllllllllllllIIIlllIllIlIIlIl < llllllllllllllllIIIlllIllIIlIlII.length; ++llllllllllllllllIIIlllIllIlIIlIl) {
            char llllllllllllllllIIIlllIllIlIlIII = (char)llllllllllllllllIIIlllIllIlIIlIl;
            CharData llllllllllllllllIIIlllIllIlIIlll = llllllllllllllllIIIlllIllIlIIlII.new CharData();
            Rectangle2D llllllllllllllllIIIlllIllIlIIllI = llllllllllllllllIIIlllIllIIlllII.getStringBounds(String.valueOf(llllllllllllllllIIIlllIllIlIlIII), llllllllllllllllIIIlllIllIIlllIl);
            llllllllllllllllIIIlllIllIlIIlll.width = llllllllllllllllIIIlllIllIlIIllI.getBounds().width + 8;
            llllllllllllllllIIIlllIllIlIIlll.height = llllllllllllllllIIIlllIllIlIIllI.getBounds().height;
            if (llllllllllllllllIIIlllIllIIllIlI + llllllllllllllllIIIlllIllIlIIlll.width >= llllllllllllllllIIIlllIllIIlllll) {
                llllllllllllllllIIIlllIllIIllIlI = 0;
                llllllllllllllllIIIlllIllIIllIIl += llllllllllllllllIIIlllIllIIllIll;
                llllllllllllllllIIIlllIllIIllIll = 0;
            }
            if (llllllllllllllllIIIlllIllIlIIlll.height > llllllllllllllllIIIlllIllIIllIll) {
                llllllllllllllllIIIlllIllIIllIll = llllllllllllllllIIIlllIllIlIIlll.height;
            }
            llllllllllllllllIIIlllIllIlIIlll.storedX = llllllllllllllllIIIlllIllIIllIlI;
            llllllllllllllllIIIlllIllIlIIlll.storedY = llllllllllllllllIIIlllIllIIllIIl;
            if (llllllllllllllllIIIlllIllIlIIlll.height > llllllllllllllllIIIlllIllIlIIlII.fontHeight) {
                llllllllllllllllIIIlllIllIlIIlII.fontHeight = llllllllllllllllIIIlllIllIlIIlll.height;
            }
            llllllllllllllllIIIlllIllIIlIlII[llllllllllllllllIIIlllIllIlIIlIl] = llllllllllllllllIIIlllIllIlIIlll;
            llllllllllllllllIIIlllIllIIlllIl.drawString(String.valueOf(llllllllllllllllIIIlllIllIlIlIII), llllllllllllllllIIIlllIllIIllIlI + 2, llllllllllllllllIIIlllIllIIllIIl + llllllllllllllllIIIlllIllIIlllII.getAscent());
            llllllllllllllllIIIlllIllIIllIlI += llllllllllllllllIIIlllIllIlIIlll.width;
        }
        return llllllllllllllllIIIlllIllIIllllI;
    }

    protected class CharData {
        public /* synthetic */ int storedX;
        public /* synthetic */ int height;
        public /* synthetic */ int storedY;
        public /* synthetic */ int width;

        protected CharData() {
            CharData llllllllllllllIIlIIIlllIIlIIIIII;
        }
    }
}

