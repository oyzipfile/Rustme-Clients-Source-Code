/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.texture.DynamicTexture
 *  org.lwjgl.opengl.GL11
 */
package ru.internali.module.render;

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
    protected /* synthetic */ boolean antiAlias;
    protected /* synthetic */ CharData[] charData;
    protected /* synthetic */ int fontHeight;
    protected /* synthetic */ int charOffset;
    protected /* synthetic */ DynamicTexture tex;
    private final /* synthetic */ float imgSize = 512.0f;
    protected /* synthetic */ Font font;

    public void setFractionalMetrics(boolean llIIlIIlIllIllI) {
        CFont llIIlIIlIllIlIl;
        if (llIIlIIlIllIlIl.fractionalMetrics != llIIlIIlIllIllI) {
            llIIlIIlIllIlIl.fractionalMetrics = llIIlIIlIllIllI;
            llIIlIIlIllIlIl.tex = llIIlIIlIllIlIl.setupTexture(llIIlIIlIllIlIl.font, llIIlIIlIllIlIl.antiAlias, llIIlIIlIllIllI, llIIlIIlIllIlIl.charData);
        }
    }

    public int getStringHeight(String llIIlIIllIlllII) {
        CFont llIIlIIllIllIll;
        return llIIlIIllIllIll.getHeight();
    }

    public CFont(Font llIIlIlIlIlllll, boolean llIIlIlIllIIIlI, boolean llIIlIlIllIIIIl) {
        CFont llIIlIlIllIIIII;
        llIIlIlIllIIIII.imgSize = 512.0f;
        llIIlIlIllIIIII.charData = new CharData[256];
        llIIlIlIllIIIII.fontHeight = -1;
        llIIlIlIllIIIII.charOffset = 0;
        llIIlIlIllIIIII.font = llIIlIlIlIlllll;
        llIIlIlIllIIIII.antiAlias = llIIlIlIllIIIlI;
        llIIlIlIllIIIII.fractionalMetrics = llIIlIlIllIIIIl;
        llIIlIlIllIIIII.tex = llIIlIlIllIIIII.setupTexture(llIIlIlIlIlllll, llIIlIlIllIIIlI, llIIlIlIllIIIIl, llIIlIlIllIIIII.charData);
    }

    protected BufferedImage generateFontImage(Font llIIlIlIIlIIllI, boolean llIIlIlIIlIIlIl, boolean llIIlIlIIllIIII, CharData[] llIIlIlIIlIllll) {
        CFont llIIlIlIIllIIll;
        llIIlIlIIllIIll.getClass();
        int llIIlIlIIlIlllI = 512;
        BufferedImage llIIlIlIIlIllIl = new BufferedImage(512, 512, 2);
        Graphics2D llIIlIlIIlIllII = (Graphics2D)llIIlIlIIlIllIl.getGraphics();
        llIIlIlIIlIllII.setFont(llIIlIlIIlIIllI);
        llIIlIlIIlIllII.setColor(new Color(255, 255, 255, 0));
        llIIlIlIIlIllII.fillRect(0, 0, 512, 512);
        llIIlIlIIlIllII.setColor(Color.WHITE);
        llIIlIlIIlIllII.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, llIIlIlIIllIIII ? RenderingHints.VALUE_FRACTIONALMETRICS_ON : RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
        llIIlIlIIlIllII.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, llIIlIlIIlIIlIl ? RenderingHints.VALUE_TEXT_ANTIALIAS_ON : RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        llIIlIlIIlIllII.setRenderingHint(RenderingHints.KEY_ANTIALIASING, llIIlIlIIlIIlIl ? RenderingHints.VALUE_ANTIALIAS_ON : RenderingHints.VALUE_ANTIALIAS_OFF);
        FontMetrics llIIlIlIIlIlIll = llIIlIlIIlIllII.getFontMetrics();
        int llIIlIlIIlIlIlI = 0;
        int llIIlIlIIlIlIIl = 0;
        int llIIlIlIIlIlIII = 1;
        for (int llIIlIlIIllIlII = 0; llIIlIlIIllIlII < llIIlIlIIlIllll.length; ++llIIlIlIIllIlII) {
            char llIIlIlIIllIlll = (char)llIIlIlIIllIlII;
            CharData llIIlIlIIllIllI = llIIlIlIIllIIll.new CharData();
            Rectangle2D llIIlIlIIllIlIl = llIIlIlIIlIlIll.getStringBounds(String.valueOf(llIIlIlIIllIlll), llIIlIlIIlIllII);
            llIIlIlIIllIllI.width = llIIlIlIIllIlIl.getBounds().width + 8;
            llIIlIlIIllIllI.height = llIIlIlIIllIlIl.getBounds().height;
            if (llIIlIlIIlIlIIl + llIIlIlIIllIllI.width >= 512) {
                llIIlIlIIlIlIIl = 0;
                llIIlIlIIlIlIII += llIIlIlIIlIlIlI;
                llIIlIlIIlIlIlI = 0;
            }
            if (llIIlIlIIllIllI.height > llIIlIlIIlIlIlI) {
                llIIlIlIIlIlIlI = llIIlIlIIllIllI.height;
            }
            llIIlIlIIllIllI.storedX = llIIlIlIIlIlIIl;
            llIIlIlIIllIllI.storedY = llIIlIlIIlIlIII;
            if (llIIlIlIIllIllI.height > llIIlIlIIllIIll.fontHeight) {
                llIIlIlIIllIIll.fontHeight = llIIlIlIIllIllI.height;
            }
            llIIlIlIIlIllll[llIIlIlIIllIlII] = llIIlIlIIllIllI;
            llIIlIlIIlIllII.drawString(String.valueOf(llIIlIlIIllIlll), llIIlIlIIlIlIIl + 2, llIIlIlIIlIlIII + llIIlIlIIlIlIll.getAscent());
            llIIlIlIIlIlIIl += llIIlIlIIllIllI.width;
        }
        return llIIlIlIIlIllIl;
    }

    public DynamicTexture setupTexture(Font llIIlIlIlIIllIl, boolean llIIlIlIlIIllII, boolean llIIlIlIlIIlIll, CharData[] llIIlIlIlIIlIlI) {
        CFont llIIlIlIlIIlllI;
        BufferedImage llIIlIlIlIIllll = llIIlIlIlIIlllI.generateFontImage(llIIlIlIlIIllIl, llIIlIlIlIIllII, llIIlIlIlIIlIll, llIIlIlIlIIlIlI);
        try {
            return new DynamicTexture(llIIlIlIlIIllll);
        }
        catch (Exception llIIlIlIlIlIlIl) {
            llIIlIlIlIlIlIl.printStackTrace();
            return null;
        }
    }

    public Font getFont() {
        CFont llIIlIIlIllIIlI;
        return llIIlIIlIllIIlI.font;
    }

    public boolean isFractionalMetrics() {
        CFont llIIlIIlIlllIll;
        return llIIlIIlIlllIll.fractionalMetrics;
    }

    public void drawChar(CharData[] llIIlIlIIIIllll, char llIIlIlIIIIlIIl, float llIIlIlIIIIlIII, float llIIlIlIIIIllII) throws ArrayIndexOutOfBoundsException {
        try {
            CFont llIIlIlIIIIlIll;
            llIIlIlIIIIlIll.drawQuad(llIIlIlIIIIlIII, llIIlIlIIIIllII, llIIlIlIIIIllll[llIIlIlIIIIlIIl].width, llIIlIlIIIIllll[llIIlIlIIIIlIIl].height, llIIlIlIIIIllll[llIIlIlIIIIlIIl].storedX, llIIlIlIIIIllll[llIIlIlIIIIlIIl].storedY, llIIlIlIIIIllll[llIIlIlIIIIlIIl].width, llIIlIlIIIIllll[llIIlIlIIIIlIIl].height);
        }
        catch (Exception llIIlIlIIIlIIIl) {
            llIIlIlIIIlIIIl.printStackTrace();
        }
    }

    protected void drawQuad(float llIIlIIlllIlIlI, float llIIlIIlllIlIIl, float llIIlIIllllIlIl, float llIIlIIllllIlII, float llIIlIIllllIIll, float llIIlIIlllIIlIl, float llIIlIIllllIIIl, float llIIlIIllllIIII) {
        CFont llIIlIIlllllIII;
        llIIlIIlllllIII.getClass();
        float llIIlIIlllIllll = llIIlIIllllIIll / 512.0f;
        llIIlIIlllllIII.getClass();
        float llIIlIIlllIlllI = llIIlIIlllIIlIl / 512.0f;
        llIIlIIlllllIII.getClass();
        float llIIlIIlllIllIl = llIIlIIllllIIIl / 512.0f;
        llIIlIIlllllIII.getClass();
        float llIIlIIlllIllII = llIIlIIllllIIII / 512.0f;
        GL11.glTexCoord2f((float)(llIIlIIlllIllll + llIIlIIlllIllIl), (float)llIIlIIlllIlllI);
        GL11.glVertex2d((double)(llIIlIIlllIlIlI + llIIlIIllllIlIl), (double)llIIlIIlllIlIIl);
        GL11.glTexCoord2f((float)llIIlIIlllIllll, (float)llIIlIIlllIlllI);
        GL11.glVertex2d((double)llIIlIIlllIlIlI, (double)llIIlIIlllIlIIl);
        GL11.glTexCoord2f((float)llIIlIIlllIllll, (float)(llIIlIIlllIlllI + llIIlIIlllIllII));
        GL11.glVertex2d((double)llIIlIIlllIlIlI, (double)(llIIlIIlllIlIIl + llIIlIIllllIlII));
        GL11.glTexCoord2f((float)llIIlIIlllIllll, (float)(llIIlIIlllIlllI + llIIlIIlllIllII));
        GL11.glVertex2d((double)llIIlIIlllIlIlI, (double)(llIIlIIlllIlIIl + llIIlIIllllIlII));
        GL11.glTexCoord2f((float)(llIIlIIlllIllll + llIIlIIlllIllIl), (float)(llIIlIIlllIlllI + llIIlIIlllIllII));
        GL11.glVertex2d((double)(llIIlIIlllIlIlI + llIIlIIllllIlIl), (double)(llIIlIIlllIlIIl + llIIlIIllllIlII));
        GL11.glTexCoord2f((float)(llIIlIIlllIllll + llIIlIIlllIllIl), (float)llIIlIIlllIlllI);
        GL11.glVertex2d((double)(llIIlIIlllIlIlI + llIIlIIllllIlIl), (double)llIIlIIlllIlIIl);
    }

    public void setFont(Font llIIlIIlIlIlIll) {
        CFont llIIlIIlIlIlllI;
        llIIlIIlIlIlllI.font = llIIlIIlIlIlIll;
        llIIlIIlIlIlllI.tex = llIIlIIlIlIlllI.setupTexture(llIIlIIlIlIlIll, llIIlIIlIlIlllI.antiAlias, llIIlIIlIlIlllI.fractionalMetrics, llIIlIIlIlIlllI.charData);
    }

    public int getStringWidth(String llIIlIIllIIlllI) {
        int llIIlIIllIIllIl = 0;
        for (char llIIlIIllIlIIII : llIIlIIllIIlllI.toCharArray()) {
            CFont llIIlIIllIIllII;
            if (llIIlIIllIlIIII >= llIIlIIllIIllII.charData.length || llIIlIIllIlIIII < '\u0000') continue;
            llIIlIIllIIllIl += llIIlIIllIIllII.charData[llIIlIIllIlIIII].width - 8 + llIIlIIllIIllII.charOffset;
        }
        return llIIlIIllIIllIl / 2;
    }

    public void setAntiAlias(boolean llIIlIIlIllllll) {
        CFont llIIlIIlIlllllI;
        if (llIIlIIlIlllllI.antiAlias != llIIlIIlIllllll) {
            llIIlIIlIlllllI.antiAlias = llIIlIIlIllllll;
            llIIlIIlIlllllI.tex = llIIlIIlIlllllI.setupTexture(llIIlIIlIlllllI.font, llIIlIIlIllllll, llIIlIIlIlllllI.fractionalMetrics, llIIlIIlIlllllI.charData);
        }
    }

    public int getHeight() {
        CFont llIIlIIllIllIIl;
        return (llIIlIIllIllIIl.fontHeight - 8) / 2;
    }

    public boolean isAntiAlias() {
        CFont llIIlIIllIIIlII;
        return llIIlIIllIIIlII.antiAlias;
    }

    public class CharData {
        public /* synthetic */ int height;
        public /* synthetic */ int storedX;
        public /* synthetic */ int width;
        public /* synthetic */ int storedY;

        public CharData() {
            CharData lIIlIIlllIIIIl;
        }
    }
}

