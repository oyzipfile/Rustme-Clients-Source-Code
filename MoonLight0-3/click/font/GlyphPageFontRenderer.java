/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  org.lwjgl.opengl.GL11
 */
package click.font;

import click.font.GlyphPage;
import java.util.Locale;
import java.util.Random;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.opengl.GL11;

public class GlyphPageFontRenderer {
    private /* synthetic */ float blue;
    private /* synthetic */ float alpha;
    private /* synthetic */ boolean underlineStyle;
    private /* synthetic */ int textColor;
    private /* synthetic */ GlyphPage boldItalicGlyphPage;
    private /* synthetic */ int[] colorCode;
    private /* synthetic */ float posY;
    private /* synthetic */ boolean italicStyle;
    private /* synthetic */ boolean randomStyle;
    private /* synthetic */ float posX;
    private /* synthetic */ float green;
    private /* synthetic */ GlyphPage italicGlyphPage;
    private /* synthetic */ boolean strikethroughStyle;
    public /* synthetic */ Random fontRandom;
    private /* synthetic */ boolean boldStyle;
    private /* synthetic */ GlyphPage boldGlyphPage;
    private /* synthetic */ float red;
    private /* synthetic */ GlyphPage regularGlyphPage;

    private GlyphPage getCurrentGlyphPage() {
        GlyphPageFontRenderer lIlIllIlIlIllI;
        if (lIlIllIlIlIllI.boldStyle && lIlIllIlIlIllI.italicStyle) {
            return lIlIllIlIlIllI.boldItalicGlyphPage;
        }
        if (lIlIllIlIlIllI.boldStyle) {
            return lIlIllIlIlIllI.boldGlyphPage;
        }
        if (lIlIllIlIlIllI.italicStyle) {
            return lIlIllIlIlIllI.italicGlyphPage;
        }
        return lIlIllIlIlIllI.regularGlyphPage;
    }

    public String trimStringToWidth(String lIlIlllIlIllll, int lIlIlllIlIlllI, boolean lIlIlllIlllIII) {
        boolean lIlIlllIllIlll = false;
        StringBuilder lIlIlllIllIllI = new StringBuilder();
        boolean lIlIlllIllIlIl = false;
        int lIlIlllIllIlII = 0;
        int lIlIlllIllIIll = 1;
        int lIlIlllIllIIlI = 0;
        for (int lIlIlllIllIIIl = lIlIlllIllIlII; lIlIlllIllIIIl < lIlIlllIlIllll.length() && lIlIlllIllIIIl < lIlIlllIlIlllI; lIlIlllIllIIIl += lIlIlllIllIIll) {
            GlyphPageFontRenderer lIlIlllIlllIll;
            char lIlIlllIllllIl = lIlIlllIlIllll.charAt(lIlIlllIllIIIl);
            lIlIlllIllllIl = lIlIlllIlIllll.charAt(lIlIlllIllIIIl);
            GlyphPage lIlIlllIllllII = lIlIlllIlllIll.getCurrentGlyphPage();
            if (lIlIlllIllIIIl > (lIlIlllIllIIlI = (int)((float)lIlIlllIllIIlI + ((float)lIlIlllIllllII.getWidth() - 8.0f) / 2.0f))) break;
            lIlIlllIllIllI.append(lIlIlllIllllIl);
        }
        return String.valueOf(lIlIlllIllIllI);
    }

    public static GlyphPageFontRenderer create(String lIllIIIIIlllll, int lIllIIIIIllllI, boolean lIllIIIIIlllIl, boolean lIllIIIIIlllII, boolean lIllIIIIIllIll) {
        char[] lIllIIIIIllIlI = new char[256];
        int lIllIIIIIllIIl = 0;
        while (true) {
            int lIllIIIIlIIIII = lIllIIIIIllIlI.length;
            lIllIIIIIllIlI[lIllIIIIIllIIl] = (char)lIllIIIIIllIIl;
            ++lIllIIIIIllIIl;
        }
    }

    private void renderStringAtPos(String lIlIllIlllIIII, boolean lIlIllIlllIIll) {
        GlyphPageFontRenderer lIlIllIlllIlIl;
        GlyphPage lIlIllIlllIIlI = lIlIllIlllIlIl.getCurrentGlyphPage();
        GL11.glPushMatrix();
        GL11.glScaled((double)0.5, (double)0.5, (double)0.5);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc((int)770, (int)771);
        GlStateManager.enableTexture2D();
        GL11.glTexParameteri((int)3553, (int)10240, (int)9729);
        for (int lIlIllIlllIllI = 0; lIlIllIlllIllI < lIlIllIlllIIII.length(); ++lIlIllIlllIllI) {
            char lIlIllIlllIlll = lIlIllIlllIIII.charAt(lIlIllIlllIllI);
            if (lIlIllIlllIlll == '\u00a7' && lIlIllIlllIllI + 1 < lIlIllIlllIIII.length()) {
                int lIlIllIllllIII = "0123456789abcdefklmnor".indexOf(lIlIllIlllIIII.toLowerCase(Locale.ENGLISH).charAt(lIlIllIlllIllI + 1));
                if (lIlIllIllllIII < 16) {
                    int lIlIllIllllIIl;
                    lIlIllIlllIlIl.randomStyle = false;
                    lIlIllIlllIlIl.boldStyle = false;
                    lIlIllIlllIlIl.strikethroughStyle = false;
                    lIlIllIlllIlIl.underlineStyle = false;
                    lIlIllIlllIlIl.italicStyle = false;
                    if (lIlIllIllllIII < 0) {
                        lIlIllIllllIII = 15;
                    }
                    if (lIlIllIlllIIll) {
                        lIlIllIllllIII += 16;
                    }
                    lIlIllIlllIlIl.textColor = lIlIllIllllIIl = lIlIllIlllIlIl.colorCode[lIlIllIllllIII];
                    GlStateManager.color((float)((float)(lIlIllIllllIIl >> 16) / 255.0f), (float)((float)(lIlIllIllllIIl >> 8 & 0xFF) / 255.0f), (float)((float)(lIlIllIllllIIl & 0xFF) / 255.0f), (float)lIlIllIlllIlIl.alpha);
                } else if (lIlIllIllllIII == 16) {
                    lIlIllIlllIlIl.randomStyle = true;
                } else if (lIlIllIllllIII == 17) {
                    lIlIllIlllIlIl.boldStyle = true;
                } else if (lIlIllIllllIII == 18) {
                    lIlIllIlllIlIl.strikethroughStyle = true;
                } else if (lIlIllIllllIII == 19) {
                    lIlIllIlllIlIl.underlineStyle = true;
                } else if (lIlIllIllllIII == 20) {
                    lIlIllIlllIlIl.italicStyle = true;
                } else {
                    lIlIllIlllIlIl.randomStyle = false;
                    lIlIllIlllIlIl.boldStyle = false;
                    lIlIllIlllIlIl.strikethroughStyle = false;
                    lIlIllIlllIlIl.underlineStyle = false;
                    lIlIllIlllIlIl.italicStyle = false;
                    GlStateManager.color((float)lIlIllIlllIlIl.red, (float)lIlIllIlllIlIl.blue, (float)lIlIllIlllIlIl.green, (float)lIlIllIlllIlIl.alpha);
                }
                ++lIlIllIlllIllI;
                continue;
            }
            lIlIllIlllIIlI = lIlIllIlllIlIl.getCurrentGlyphPage();
        }
        GL11.glPopMatrix();
    }

    public GlyphPageFontRenderer(GlyphPage lIlIllllIllIII, GlyphPage lIlIllllIlIIIl, GlyphPage lIlIllllIlIIII, GlyphPage lIlIllllIIllll) {
        GlyphPageFontRenderer lIlIllllIllIIl;
        lIlIllllIllIIl.fontRandom = new Random();
        lIlIllllIllIIl.colorCode = new int[32];
        lIlIllllIllIIl.regularGlyphPage = lIlIllllIllIII;
        lIlIllllIllIIl.boldGlyphPage = lIlIllllIlIIIl;
        lIlIllllIllIIl.italicGlyphPage = lIlIllllIlIIII;
        lIlIllllIllIIl.boldItalicGlyphPage = lIlIllllIIllll;
        int lIlIllllIlIlII = 0;
        while (true) {
            int lIlIllllIlllIl = (lIlIllllIlIlII >> 3 & 1) * 85;
            int lIlIllllIlllII = (lIlIllllIlIlII >> 2 & 1) * 170 + lIlIllllIlllIl;
            int lIlIllllIllIll = (lIlIllllIlIlII >> 1 & 1) * 170 + lIlIllllIlllIl;
            int lIlIllllIllIlI = (lIlIllllIlIlII & 1) * 170 + lIlIllllIlllIl;
            lIlIllllIllIIl.colorCode[lIlIllllIlIlII] = (lIlIllllIlllII & 0xFF) << 16 | (lIlIllllIllIll & 0xFF) << 8 | lIlIllllIllIlI & 0xFF;
            ++lIlIllllIlIlII;
        }
    }

    public int getStringWidth(String lIllIIIIIIIlII) {
        if (lIllIIIIIIIlII == null) {
            return 0;
        }
        int lIllIIIIIIlIII = 0;
        int lIllIIIIIIIlll = lIllIIIIIIIlII.length();
        boolean lIllIIIIIIIllI = false;
        for (int lIllIIIIIIlIll = 0; lIllIIIIIIlIll < lIllIIIIIIIlll; ++lIllIIIIIIlIll) {
            GlyphPageFontRenderer lIllIIIIIIIlIl;
            char lIllIIIIIIllIl = lIllIIIIIIIlII.charAt(lIllIIIIIIlIll);
            lIllIIIIIIllIl = lIllIIIIIIIlII.charAt(lIllIIIIIIlIll);
            GlyphPage lIllIIIIIIllII = lIllIIIIIIIlIl.getCurrentGlyphPage();
            lIllIIIIIIlIII = (int)((float)lIllIIIIIIlIII + ((float)lIllIIIIIIllII.getWidth() - 8.0f));
        }
        return lIllIIIIIIlIII / 2;
    }

    public int drawString(String lIlIlllllIllIl, float lIlIllllllIIll, float lIlIlllllIlIll, int lIlIllllllIIIl, boolean lIlIllllllIIII) {
        int lIlIlllllIllll;
        GlyphPageFontRenderer lIlIlllllIlllI;
        GlStateManager.enableAlpha();
        lIlIlllllIlllI.resetStyles();
        if (lIlIllllllIIII) {
            int lIlIllllllIllI = lIlIlllllIlllI.renderString(lIlIlllllIllIl, lIlIllllllIIll + 1.0f, lIlIlllllIlIll + 1.0f, lIlIllllllIIIl, true);
            lIlIllllllIllI = Math.max(lIlIllllllIllI, lIlIlllllIlllI.renderString(lIlIlllllIllIl, lIlIllllllIIll, lIlIlllllIlIll, lIlIllllllIIIl, false));
        } else {
            lIlIlllllIllll = lIlIlllllIlllI.renderString(lIlIlllllIllIl, lIlIllllllIIll, lIlIlllllIlIll, lIlIllllllIIIl, false);
        }
        return lIlIlllllIllll;
    }

    private int renderString(String lIlIllIllIIIlI, float lIlIllIlIllIll, float lIlIllIllIIIII, int lIlIllIlIllIIl, boolean lIlIllIlIllllI) {
        GlyphPageFontRenderer lIlIllIlIlllIl;
        if (lIlIllIllIIIlI == null) {
            return 0;
        }
        if ((lIlIllIlIllIIl & 0xFC000000) == 0) {
            lIlIllIlIllIIl |= 0xFF000000;
        }
        if (lIlIllIlIllllI) {
            lIlIllIlIllIIl = (lIlIllIlIllIIl & 0xFCFCFC) >> 2 | lIlIllIlIllIIl & 0xFF000000;
        }
        lIlIllIlIlllIl.red = (float)(lIlIllIlIllIIl >> 16 & 0xFF) / 255.0f;
        lIlIllIlIlllIl.blue = (float)(lIlIllIlIllIIl >> 8 & 0xFF) / 255.0f;
        lIlIllIlIlllIl.green = (float)(lIlIllIlIllIIl & 0xFF) / 255.0f;
        lIlIllIlIlllIl.alpha = (float)(lIlIllIlIllIIl >> 24 & 0xFF) / 255.0f;
        GlStateManager.color((float)lIlIllIlIlllIl.red, (float)lIlIllIlIlllIl.blue, (float)lIlIllIlIlllIl.green, (float)lIlIllIlIlllIl.alpha);
        lIlIllIlIlllIl.posX = lIlIllIlIllIll * 2.0f;
        lIlIllIlIlllIl.posY = lIlIllIllIIIII * 2.0f;
        lIlIllIlIlllIl.renderStringAtPos(lIlIllIllIIIlI, lIlIllIlIllllI);
        return (int)(lIlIllIlIlllIl.posX / 4.0f);
    }

    public String trimStringToWidth(String lIlIlllIIIlIIl, int lIlIlllIIIlIII) {
        GlyphPageFontRenderer lIlIlllIIIIlll;
        return lIlIlllIIIIlll.trimStringToWidth(lIlIlllIIIlIIl, lIlIlllIIIlIII, false);
    }

    public int getFontHeight() {
        GlyphPageFontRenderer lIlIlllIlIIIlI;
        return lIlIlllIlIIIlI.regularGlyphPage.getHeight() / 2;
    }

    private void resetStyles() {
        lIlIlllIIIIIlI.randomStyle = false;
        lIlIlllIIIIIlI.boldStyle = false;
        lIlIlllIIIIIlI.italicStyle = false;
        lIlIlllIIIIIlI.underlineStyle = false;
        lIlIlllIIIIIlI.strikethroughStyle = false;
    }

    private void doDraw(float lIlIlllIIlIlIl, GlyphPage lIlIlllIIlIlII) {
        GlyphPageFontRenderer lIlIlllIIlIllI;
        if (lIlIlllIIlIllI.strikethroughStyle) {
            Tessellator lIlIlllIIllIlI = Tessellator.getInstance();
            BufferBuilder lIlIlllIIllIll = lIlIlllIIllIlI.getBuffer();
            GlStateManager.disableTexture2D();
            lIlIlllIIllIll.begin(7, DefaultVertexFormats.POSITION);
            lIlIlllIIllIll.pos((double)lIlIlllIIlIllI.posX, (double)(lIlIlllIIlIllI.posY + (float)(lIlIlllIIlIlII.getHeight() / 2)), 0.0).endVertex();
            lIlIlllIIllIll.pos((double)(lIlIlllIIlIllI.posX + lIlIlllIIlIlIl), (double)(lIlIlllIIlIllI.posY + (float)(lIlIlllIIlIlII.getHeight() / 2)), 0.0).endVertex();
            lIlIlllIIllIll.pos((double)(lIlIlllIIlIllI.posX + lIlIlllIIlIlIl), (double)(lIlIlllIIlIllI.posY + (float)(lIlIlllIIlIlII.getHeight() / 2) - 1.0f), 0.0).endVertex();
            lIlIlllIIllIll.pos((double)lIlIlllIIlIllI.posX, (double)(lIlIlllIIlIllI.posY + (float)(lIlIlllIIlIlII.getHeight() / 2) - 1.0f), 0.0).endVertex();
            lIlIlllIIllIlI.draw();
            GlStateManager.enableTexture2D();
        }
        if (lIlIlllIIlIllI.underlineStyle) {
            Tessellator lIlIlllIIlIlll = Tessellator.getInstance();
            BufferBuilder lIlIlllIIllIII = lIlIlllIIlIlll.getBuffer();
            GlStateManager.disableTexture2D();
            lIlIlllIIllIII.begin(7, DefaultVertexFormats.POSITION);
            int lIlIlllIIllIIl = lIlIlllIIlIllI.underlineStyle ? -1 : 0;
            lIlIlllIIllIII.pos((double)(lIlIlllIIlIllI.posX + (float)lIlIlllIIllIIl), (double)(lIlIlllIIlIllI.posY + (float)lIlIlllIIlIlII.getHeight()), 0.0).endVertex();
            lIlIlllIIllIII.pos((double)(lIlIlllIIlIllI.posX + lIlIlllIIlIlIl), (double)(lIlIlllIIlIllI.posY + (float)lIlIlllIIlIlII.getHeight()), 0.0).endVertex();
            lIlIlllIIllIII.pos((double)(lIlIlllIIlIllI.posX + lIlIlllIIlIlIl), (double)(lIlIlllIIlIllI.posY + (float)lIlIlllIIlIlII.getHeight() - 1.0f), 0.0).endVertex();
            lIlIlllIIllIII.pos((double)(lIlIlllIIlIllI.posX + (float)lIlIlllIIllIIl), (double)(lIlIlllIIlIllI.posY + (float)lIlIlllIIlIlII.getHeight() - 1.0f), 0.0).endVertex();
            lIlIlllIIlIlll.draw();
            GlStateManager.enableTexture2D();
        }
        lIlIlllIIlIllI.posX += lIlIlllIIlIlIl;
    }
}

