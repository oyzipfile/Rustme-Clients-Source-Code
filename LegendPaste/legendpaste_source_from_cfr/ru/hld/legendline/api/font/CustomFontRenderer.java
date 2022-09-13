/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.texture.DynamicTexture
 *  org.lwjgl.opengl.GL11
 */
package ru.hld.legendline.api.font;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.DynamicTexture;
import org.lwjgl.opengl.GL11;
import ru.hld.legendline.api.font.CFont;

public final class CustomFontRenderer
extends CFont {
    private /* synthetic */ DynamicTexture texItalicBold;
    private /* synthetic */ CFont.CharData[] boldItalicChars;
    private /* synthetic */ CFont.CharData[] boldChars;
    private /* synthetic */ DynamicTexture texBold;
    private /* synthetic */ DynamicTexture texItalic;
    private final /* synthetic */ int[] colorCode;
    private /* synthetic */ CFont.CharData[] italicChars;

    public List formatString(String lllllllllllllllIIlllIlIlllIllIlI, double lllllllllllllllIIlllIlIlllIllIIl) {
        ArrayList<String> lllllllllllllllIIlllIlIlllIlllll = new ArrayList<String>();
        String lllllllllllllllIIlllIlIlllIllllI = "";
        char lllllllllllllllIIlllIlIlllIlllIl = '\uffff';
        char[] lllllllllllllllIIlllIlIlllIlllII = lllllllllllllllIIlllIlIlllIllIlI.toCharArray();
        for (int lllllllllllllllIIlllIlIllllIIIll = 0; lllllllllllllllIIlllIlIllllIIIll < lllllllllllllllIIlllIlIlllIlllII.length; ++lllllllllllllllIIlllIlIllllIIIll) {
            CustomFontRenderer lllllllllllllllIIlllIlIlllIllIll;
            char lllllllllllllllIIlllIlIllllIIlII = lllllllllllllllIIlllIlIlllIlllII[lllllllllllllllIIlllIlIllllIIIll];
            if (String.valueOf(lllllllllllllllIIlllIlIllllIIlII).equals("\u00a7") && lllllllllllllllIIlllIlIllllIIIll < lllllllllllllllIIlllIlIlllIlllII.length - 1) {
                lllllllllllllllIIlllIlIlllIlllIl = lllllllllllllllIIlllIlIlllIlllII[lllllllllllllllIIlllIlIllllIIIll + 1];
            }
            StringBuilder stringBuilder = new StringBuilder();
            if ((double)lllllllllllllllIIlllIlIlllIllIll.getStringWidth(String.valueOf(stringBuilder.append(lllllllllllllllIIlllIlIlllIllllI).append(lllllllllllllllIIlllIlIllllIIlII))) < lllllllllllllllIIlllIlIlllIllIIl) {
                lllllllllllllllIIlllIlIlllIllllI = String.valueOf(new StringBuilder().append(lllllllllllllllIIlllIlIlllIllllI).append(lllllllllllllllIIlllIlIllllIIlII));
                continue;
            }
            lllllllllllllllIIlllIlIlllIlllll.add(lllllllllllllllIIlllIlIlllIllllI);
            lllllllllllllllIIlllIlIlllIllllI = String.valueOf(new StringBuilder().append("").append(lllllllllllllllIIlllIlIlllIlllIl).append(lllllllllllllllIIlllIlIllllIIlII));
        }
        if (lllllllllllllllIIlllIlIlllIllllI.length() > 0) {
            lllllllllllllllIIlllIlIlllIlllll.add(lllllllllllllllIIlllIlIlllIllllI);
        }
        return lllllllllllllllIIlllIlIlllIlllll;
    }

    public float drawCenteredStringWithShadow(String lllllllllllllllIIlllIllIllIlIIlI, double lllllllllllllllIIlllIllIllIIllII, double lllllllllllllllIIlllIllIllIIlIll, int lllllllllllllllIIlllIllIllIIllll) {
        CustomFontRenderer lllllllllllllllIIlllIllIllIlIIll;
        lllllllllllllllIIlllIllIllIlIIll.drawString(lllllllllllllllIIlllIllIllIlIIlI, lllllllllllllllIIlllIllIllIIllII - (double)((float)lllllllllllllllIIlllIllIllIlIIll.getStringWidth(lllllllllllllllIIlllIllIllIlIIlI) / 2.0f) + 0.45, lllllllllllllllIIlllIllIllIIlIll + 0.5, lllllllllllllllIIlllIllIllIIllll, true);
        return lllllllllllllllIIlllIllIllIlIIll.drawString(lllllllllllllllIIlllIllIllIlIIlI, lllllllllllllllIIlllIllIllIIllII - (double)((float)lllllllllllllllIIlllIllIllIlIIll.getStringWidth(lllllllllllllllIIlllIllIllIlIIlI) / 2.0f), lllllllllllllllIIlllIllIllIIlIll, lllllllllllllllIIlllIllIllIIllll);
    }

    private void setupMinecraftColorcodes() {
        for (int lllllllllllllllIIlllIlIlllIIlIII = 0; lllllllllllllllIIlllIlIlllIIlIII < 32; ++lllllllllllllllIIlllIlIlllIIlIII) {
            int lllllllllllllllIIlllIlIlllIIllII = (lllllllllllllllIIlllIlIlllIIlIII >> 3 & 1) * 85;
            int lllllllllllllllIIlllIlIlllIIlIll = (lllllllllllllllIIlllIlIlllIIlIII >> 2 & 1) * 170 + lllllllllllllllIIlllIlIlllIIllII;
            int lllllllllllllllIIlllIlIlllIIlIlI = (lllllllllllllllIIlllIlIlllIIlIII >> 1 & 1) * 170 + lllllllllllllllIIlllIlIlllIIllII;
            int lllllllllllllllIIlllIlIlllIIlIIl = (lllllllllllllllIIlllIlIlllIIlIII & 1) * 170 + lllllllllllllllIIlllIlIlllIIllII;
            if (lllllllllllllllIIlllIlIlllIIlIII == 6) {
                lllllllllllllllIIlllIlIlllIIlIll += 85;
            }
            if (lllllllllllllllIIlllIlIlllIIlIII >= 16) {
                lllllllllllllllIIlllIlIlllIIlIll /= 4;
                lllllllllllllllIIlllIlIlllIIlIlI /= 4;
                lllllllllllllllIIlllIlIlllIIlIIl /= 4;
            }
            lllllllllllllllIIlllIlIlllIIIlll.colorCode[lllllllllllllllIIlllIlIlllIIlIII] = (lllllllllllllllIIlllIlIlllIIlIll & 0xFF) << 16 | (lllllllllllllllIIlllIlIlllIIlIlI & 0xFF) << 8 | lllllllllllllllIIlllIlIlllIIlIIl & 0xFF;
        }
    }

    public float drawString(String lllllllllllllllIIlllIlllIlIlllll, float lllllllllllllllIIlllIlllIlIllllI, float lllllllllllllllIIlllIlllIlIlllIl, int lllllllllllllllIIlllIlllIlIlllII) {
        CustomFontRenderer lllllllllllllllIIlllIlllIlIllIll;
        return lllllllllllllllIIlllIlllIlIllIll.drawString(lllllllllllllllIIlllIlllIlIlllll, lllllllllllllllIIlllIlllIlIllllI, lllllllllllllllIIlllIlllIlIlllIl, lllllllllllllllIIlllIlllIlIlllII, false);
    }

    public int getStringWidthCust(String lllllllllllllllIIlllIllIIllIIlII) {
        CustomFontRenderer lllllllllllllllIIlllIllIIllIIIll;
        if (lllllllllllllllIIlllIllIIllIIlII == null) {
            return 0;
        }
        int lllllllllllllllIIlllIllIIllIlIlI = 0;
        CFont.CharData[] lllllllllllllllIIlllIllIIllIlIIl = lllllllllllllllIIlllIllIIllIIIll.charData;
        boolean lllllllllllllllIIlllIllIIllIlIII = false;
        boolean lllllllllllllllIIlllIllIIllIIlll = false;
        int lllllllllllllllIIlllIllIIllIIllI = lllllllllllllllIIlllIllIIllIIlII.length();
        for (int lllllllllllllllIIlllIllIIllIlIll = 0; lllllllllllllllIIlllIllIIllIlIll < lllllllllllllllIIlllIllIIllIIllI; ++lllllllllllllllIIlllIllIIllIlIll) {
            char lllllllllllllllIIlllIllIIllIllII = lllllllllllllllIIlllIllIIllIIlII.charAt(lllllllllllllllIIlllIllIIllIlIll);
            if (String.valueOf(lllllllllllllllIIlllIllIIllIllII).equals("\u00a7") && lllllllllllllllIIlllIllIIllIlIll < lllllllllllllllIIlllIllIIllIIllI) {
                int lllllllllllllllIIlllIllIIllIllIl = "0123456789abcdefklmnor".indexOf(lllllllllllllllIIlllIllIIllIllII);
                if (lllllllllllllllIIlllIllIIllIllIl < 16) {
                    lllllllllllllllIIlllIllIIllIlIII = false;
                    lllllllllllllllIIlllIllIIllIIlll = false;
                } else if (lllllllllllllllIIlllIllIIllIllIl == 17) {
                    lllllllllllllllIIlllIllIIllIlIII = true;
                    lllllllllllllllIIlllIllIIllIlIIl = lllllllllllllllIIlllIllIIllIIlll ? lllllllllllllllIIlllIllIIllIIIll.boldItalicChars : lllllllllllllllIIlllIllIIllIIIll.boldChars;
                } else if (lllllllllllllllIIlllIllIIllIllIl == 20) {
                    lllllllllllllllIIlllIllIIllIIlll = true;
                    lllllllllllllllIIlllIllIIllIlIIl = lllllllllllllllIIlllIllIIllIlIII ? lllllllllllllllIIlllIllIIllIIIll.boldItalicChars : lllllllllllllllIIlllIllIIllIIIll.italicChars;
                } else if (lllllllllllllllIIlllIllIIllIllIl == 21) {
                    lllllllllllllllIIlllIllIIllIlIII = false;
                    lllllllllllllllIIlllIllIIllIIlll = false;
                    lllllllllllllllIIlllIllIIllIlIIl = lllllllllllllllIIlllIllIIllIIIll.charData;
                }
                ++lllllllllllllllIIlllIllIIllIlIll;
                continue;
            }
            if (lllllllllllllllIIlllIllIIllIllII >= lllllllllllllllIIlllIllIIllIlIIl.length || lllllllllllllllIIlllIllIIllIllII < '\u0000') continue;
            lllllllllllllllIIlllIllIIllIlIlI += lllllllllllllllIIlllIllIIllIlIIl[lllllllllllllllIIlllIllIIllIllII].width - 8 + lllllllllllllllIIlllIllIIllIIIll.charOffset;
        }
        return (lllllllllllllllIIlllIllIIllIlIlI - lllllllllllllllIIlllIllIIllIIIll.charOffset) / 2;
    }

    public CustomFontRenderer(Font lllllllllllllllIIlllIlllIllIllII, boolean lllllllllllllllIIlllIlllIllIlIll, boolean lllllllllllllllIIlllIlllIllIlIlI) {
        super(lllllllllllllllIIlllIlllIllIllII, lllllllllllllllIIlllIlllIllIlIll, lllllllllllllllIIlllIlllIllIlIlI);
        CustomFontRenderer lllllllllllllllIIlllIlllIllIllIl;
        lllllllllllllllIIlllIlllIllIllIl.colorCode = new int[32];
        lllllllllllllllIIlllIlllIllIllIl.boldChars = new CFont.CharData[256];
        lllllllllllllllIIlllIlllIllIllIl.italicChars = new CFont.CharData[256];
        lllllllllllllllIIlllIlllIllIllIl.boldItalicChars = new CFont.CharData[256];
        lllllllllllllllIIlllIlllIllIllIl.setupMinecraftColorcodes();
        lllllllllllllllIIlllIlllIllIllIl.setupBoldItalicIDs();
    }

    public float drawString(String lllllllllllllllIIlllIllIlIlIlIll, double lllllllllllllllIIlllIllIlIlIlIlI, double lllllllllllllllIIlllIllIlIlIlIIl, int lllllllllllllllIIlllIllIlIlIlIII, boolean lllllllllllllllIIlllIllIlIlIIlll) {
        CustomFontRenderer lllllllllllllllIIlllIllIlIlIIllI;
        lllllllllllllllIIlllIllIlIlIlIlI -= 1.0;
        if (lllllllllllllllIIlllIllIlIlIlIll == null) {
            return 0.0f;
        }
        if (lllllllllllllllIIlllIllIlIlIlIII == 0x20FFFFFF) {
            lllllllllllllllIIlllIllIlIlIlIII = 0xFFFFFF;
        }
        if ((lllllllllllllllIIlllIllIlIlIlIII & 0xFC000000) == 0) {
            lllllllllllllllIIlllIllIlIlIlIII |= 0xFF000000;
        }
        if (lllllllllllllllIIlllIllIlIlIIlll) {
            lllllllllllllllIIlllIllIlIlIlIII = (lllllllllllllllIIlllIllIlIlIlIII & 0xFCFCFC) >> 2 | lllllllllllllllIIlllIllIlIlIlIII & new Color(20, 20, 20, 200).getRGB();
        }
        CFont.CharData[] lllllllllllllllIIlllIllIlIllIIll = lllllllllllllllIIlllIllIlIlIIllI.charData;
        float lllllllllllllllIIlllIllIlIllIIlI = (float)(lllllllllllllllIIlllIllIlIlIlIII >> 24 & 0xFF) / 255.0f;
        boolean lllllllllllllllIIlllIllIlIllIIIl = false;
        boolean lllllllllllllllIIlllIllIlIllIIII = false;
        boolean lllllllllllllllIIlllIllIlIlIllll = false;
        boolean lllllllllllllllIIlllIllIlIlIlllI = false;
        lllllllllllllllIIlllIllIlIlIlIlI *= 2.0;
        lllllllllllllllIIlllIllIlIlIlIIl = (lllllllllllllllIIlllIllIlIlIlIIl - 3.0) * 2.0;
        GL11.glPushMatrix();
        GlStateManager.scale((double)0.5, (double)0.5, (double)0.5);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc((int)770, (int)771);
        GlStateManager.color((float)((float)(lllllllllllllllIIlllIllIlIlIlIII >> 16 & 0xFF) / 255.0f), (float)((float)(lllllllllllllllIIlllIllIlIlIlIII >> 8 & 0xFF) / 255.0f), (float)((float)(lllllllllllllllIIlllIllIlIlIlIII & 0xFF) / 255.0f), (float)lllllllllllllllIIlllIllIlIllIIlI);
        int lllllllllllllllIIlllIllIlIlIllIl = lllllllllllllllIIlllIllIlIlIlIll.length();
        GlStateManager.enableTexture2D();
        GlStateManager.bindTexture((int)lllllllllllllllIIlllIllIlIlIIllI.tex.getGlTextureId());
        GL11.glBindTexture((int)3553, (int)lllllllllllllllIIlllIllIlIlIIllI.tex.getGlTextureId());
        for (int lllllllllllllllIIlllIllIlIllIlII = 0; lllllllllllllllIIlllIllIlIllIlII < lllllllllllllllIIlllIllIlIlIllIl; ++lllllllllllllllIIlllIllIlIllIlII) {
            char lllllllllllllllIIlllIllIlIllIlIl = lllllllllllllllIIlllIllIlIlIlIll.charAt(lllllllllllllllIIlllIllIlIllIlII);
            if (String.valueOf(lllllllllllllllIIlllIllIlIllIlIl).equals("\u00a7")) {
                int lllllllllllllllIIlllIllIlIllIllI = 21;
                try {
                    lllllllllllllllIIlllIllIlIllIllI = "0123456789abcdefklmnor".indexOf(lllllllllllllllIIlllIllIlIlIlIll.charAt(lllllllllllllllIIlllIllIlIllIlII + 1));
                }
                catch (Exception lllllllllllllllIIlllIllIlIlllIII) {
                    lllllllllllllllIIlllIllIlIlllIII.printStackTrace();
                }
                if (lllllllllllllllIIlllIllIlIllIllI < 16) {
                    lllllllllllllllIIlllIllIlIllIIIl = false;
                    lllllllllllllllIIlllIllIlIllIIII = false;
                    lllllllllllllllIIlllIllIlIlIlllI = false;
                    lllllllllllllllIIlllIllIlIlIllll = false;
                    GlStateManager.bindTexture((int)lllllllllllllllIIlllIllIlIlIIllI.tex.getGlTextureId());
                    lllllllllllllllIIlllIllIlIllIIll = lllllllllllllllIIlllIllIlIlIIllI.charData;
                    if (lllllllllllllllIIlllIllIlIllIllI < 0) {
                        lllllllllllllllIIlllIllIlIllIllI = 15;
                    }
                    if (lllllllllllllllIIlllIllIlIlIIlll) {
                        lllllllllllllllIIlllIllIlIllIllI += 16;
                    }
                    int lllllllllllllllIIlllIllIlIllIlll = lllllllllllllllIIlllIllIlIlIIllI.colorCode[lllllllllllllllIIlllIllIlIllIllI];
                    GlStateManager.color((float)((float)(lllllllllllllllIIlllIllIlIllIlll >> 16 & 0xFF) / 255.0f), (float)((float)(lllllllllllllllIIlllIllIlIllIlll >> 8 & 0xFF) / 255.0f), (float)((float)(lllllllllllllllIIlllIllIlIllIlll & 0xFF) / 255.0f), (float)lllllllllllllllIIlllIllIlIllIIlI);
                } else if (lllllllllllllllIIlllIllIlIllIllI == 17) {
                    lllllllllllllllIIlllIllIlIllIIIl = true;
                    if (lllllllllllllllIIlllIllIlIllIIII) {
                        GlStateManager.bindTexture((int)lllllllllllllllIIlllIllIlIlIIllI.texItalicBold.getGlTextureId());
                        lllllllllllllllIIlllIllIlIllIIll = lllllllllllllllIIlllIllIlIlIIllI.boldItalicChars;
                    } else {
                        GlStateManager.bindTexture((int)lllllllllllllllIIlllIllIlIlIIllI.texBold.getGlTextureId());
                        lllllllllllllllIIlllIllIlIllIIll = lllllllllllllllIIlllIllIlIlIIllI.boldChars;
                    }
                } else if (lllllllllllllllIIlllIllIlIllIllI == 18) {
                    lllllllllllllllIIlllIllIlIlIllll = true;
                } else if (lllllllllllllllIIlllIllIlIllIllI == 19) {
                    lllllllllllllllIIlllIllIlIlIlllI = true;
                } else if (lllllllllllllllIIlllIllIlIllIllI == 20) {
                    lllllllllllllllIIlllIllIlIllIIII = true;
                    if (lllllllllllllllIIlllIllIlIllIIIl) {
                        GlStateManager.bindTexture((int)lllllllllllllllIIlllIllIlIlIIllI.texItalicBold.getGlTextureId());
                        lllllllllllllllIIlllIllIlIllIIll = lllllllllllllllIIlllIllIlIlIIllI.boldItalicChars;
                    } else {
                        GlStateManager.bindTexture((int)lllllllllllllllIIlllIllIlIlIIllI.texItalic.getGlTextureId());
                        lllllllllllllllIIlllIllIlIllIIll = lllllllllllllllIIlllIllIlIlIIllI.italicChars;
                    }
                } else if (lllllllllllllllIIlllIllIlIllIllI == 21) {
                    lllllllllllllllIIlllIllIlIllIIIl = false;
                    lllllllllllllllIIlllIllIlIllIIII = false;
                    lllllllllllllllIIlllIllIlIlIlllI = false;
                    lllllllllllllllIIlllIllIlIlIllll = false;
                    GlStateManager.color((float)((float)(lllllllllllllllIIlllIllIlIlIlIII >> 16 & 0xFF) / 255.0f), (float)((float)(lllllllllllllllIIlllIllIlIlIlIII >> 8 & 0xFF) / 255.0f), (float)((float)(lllllllllllllllIIlllIllIlIlIlIII & 0xFF) / 255.0f), (float)lllllllllllllllIIlllIllIlIllIIlI);
                    GlStateManager.bindTexture((int)lllllllllllllllIIlllIllIlIlIIllI.tex.getGlTextureId());
                    lllllllllllllllIIlllIllIlIllIIll = lllllllllllllllIIlllIllIlIlIIllI.charData;
                }
                ++lllllllllllllllIIlllIllIlIllIlII;
                continue;
            }
            if (lllllllllllllllIIlllIllIlIllIlIl >= lllllllllllllllIIlllIllIlIllIIll.length) continue;
            GL11.glBegin((int)4);
            lllllllllllllllIIlllIllIlIlIIllI.drawChar(lllllllllllllllIIlllIllIlIllIIll, lllllllllllllllIIlllIllIlIllIlIl, (float)lllllllllllllllIIlllIllIlIlIlIlI, (float)lllllllllllllllIIlllIllIlIlIlIIl);
            GL11.glEnd();
            if (lllllllllllllllIIlllIllIlIlIllll) {
                lllllllllllllllIIlllIllIlIlIIllI.drawLine(lllllllllllllllIIlllIllIlIlIlIlI, lllllllllllllllIIlllIllIlIlIlIIl + (double)((float)lllllllllllllllIIlllIllIlIllIIll[lllllllllllllllIIlllIllIlIllIlIl].height / 2.0f), lllllllllllllllIIlllIllIlIlIlIlI + (double)lllllllllllllllIIlllIllIlIllIIll[lllllllllllllllIIlllIllIlIllIlIl].width - 8.0, lllllllllllllllIIlllIllIlIlIlIIl + (double)((float)lllllllllllllllIIlllIllIlIllIIll[lllllllllllllllIIlllIllIlIllIlIl].height / 2.0f), 1.0f);
            }
            if (lllllllllllllllIIlllIllIlIlIlllI) {
                lllllllllllllllIIlllIllIlIlIIllI.drawLine(lllllllllllllllIIlllIllIlIlIlIlI, lllllllllllllllIIlllIllIlIlIlIIl + (double)lllllllllllllllIIlllIllIlIllIIll[lllllllllllllllIIlllIllIlIllIlIl].height - 2.0, lllllllllllllllIIlllIllIlIlIlIlI + (double)lllllllllllllllIIlllIllIlIllIIll[lllllllllllllllIIlllIllIlIllIlIl].width - 8.0, lllllllllllllllIIlllIllIlIlIlIIl + (double)lllllllllllllllIIlllIllIlIllIIll[lllllllllllllllIIlllIllIlIllIlIl].height - 2.0, 1.0f);
            }
            lllllllllllllllIIlllIllIlIlIlIlI += (double)(lllllllllllllllIIlllIllIlIllIIll[lllllllllllllllIIlllIllIlIllIlIl].width - 8 + lllllllllllllllIIlllIllIlIlIIllI.charOffset);
        }
        GL11.glPopMatrix();
        return (float)lllllllllllllllIIlllIllIlIlIlIlI / 2.0f;
    }

    public float drawStringWithShadow(String lllllllllllllllIIlllIlllIIlIlllI, double lllllllllllllllIIlllIlllIIlIIlll, double lllllllllllllllIIlllIlllIIlIIllI, int lllllllllllllllIIlllIlllIIlIIlIl) {
        CustomFontRenderer lllllllllllllllIIlllIlllIIlIllll;
        float lllllllllllllllIIlllIlllIIlIlIlI = lllllllllllllllIIlllIlllIIlIllll.drawString(lllllllllllllllIIlllIlllIIlIlllI, lllllllllllllllIIlllIlllIIlIIlll + 0.5, lllllllllllllllIIlllIlllIIlIIllI + 0.5, lllllllllllllllIIlllIlllIIlIIlIl, true);
        return Math.max(lllllllllllllllIIlllIlllIIlIlIlI, lllllllllllllllIIlllIlllIIlIllll.drawString(lllllllllllllllIIlllIlllIIlIlllI, lllllllllllllllIIlllIlllIIlIIlll, lllllllllllllllIIlllIlllIIlIIllI, lllllllllllllllIIlllIlllIIlIIlIl, false));
    }

    @Override
    public void setAntiAlias(boolean lllllllllllllllIIlllIllIIIllIIII) {
        CustomFontRenderer lllllllllllllllIIlllIllIIIllIIll;
        super.setAntiAlias(lllllllllllllllIIlllIllIIIllIIII);
        lllllllllllllllIIlllIllIIIllIIll.setupBoldItalicIDs();
    }

    @Override
    public int getStringWidth(String lllllllllllllllIIlllIllIlIIIIIlI) {
        CustomFontRenderer lllllllllllllllIIlllIllIlIIIIIll;
        if (lllllllllllllllIIlllIllIlIIIIIlI == null) {
            return 0;
        }
        int lllllllllllllllIIlllIllIlIIIlIII = 0;
        CFont.CharData[] lllllllllllllllIIlllIllIlIIIIlll = lllllllllllllllIIlllIllIlIIIIIll.charData;
        boolean lllllllllllllllIIlllIllIlIIIIllI = false;
        boolean lllllllllllllllIIlllIllIlIIIIlIl = false;
        int lllllllllllllllIIlllIllIlIIIIlII = lllllllllllllllIIlllIllIlIIIIIlI.length();
        for (int lllllllllllllllIIlllIllIlIIIlIIl = 0; lllllllllllllllIIlllIllIlIIIlIIl < lllllllllllllllIIlllIllIlIIIIlII; ++lllllllllllllllIIlllIllIlIIIlIIl) {
            char lllllllllllllllIIlllIllIlIIIlIlI = lllllllllllllllIIlllIllIlIIIIIlI.charAt(lllllllllllllllIIlllIllIlIIIlIIl);
            if (String.valueOf(lllllllllllllllIIlllIllIlIIIlIlI).equals("\u00a7")) {
                int lllllllllllllllIIlllIllIlIIIlIll = "0123456789abcdefklmnor".indexOf(lllllllllllllllIIlllIllIlIIIlIlI);
                if (lllllllllllllllIIlllIllIlIIIlIll < 16) {
                    lllllllllllllllIIlllIllIlIIIIllI = false;
                    lllllllllllllllIIlllIllIlIIIIlIl = false;
                } else if (lllllllllllllllIIlllIllIlIIIlIll == 17) {
                    lllllllllllllllIIlllIllIlIIIIllI = true;
                    lllllllllllllllIIlllIllIlIIIIlll = lllllllllllllllIIlllIllIlIIIIlIl ? lllllllllllllllIIlllIllIlIIIIIll.boldItalicChars : lllllllllllllllIIlllIllIlIIIIIll.boldChars;
                } else if (lllllllllllllllIIlllIllIlIIIlIll == 20) {
                    lllllllllllllllIIlllIllIlIIIIlIl = true;
                    lllllllllllllllIIlllIllIlIIIIlll = lllllllllllllllIIlllIllIlIIIIllI ? lllllllllllllllIIlllIllIlIIIIIll.boldItalicChars : lllllllllllllllIIlllIllIlIIIIIll.italicChars;
                } else if (lllllllllllllllIIlllIllIlIIIlIll == 21) {
                    lllllllllllllllIIlllIllIlIIIIllI = false;
                    lllllllllllllllIIlllIllIlIIIIlIl = false;
                    lllllllllllllllIIlllIllIlIIIIlll = lllllllllllllllIIlllIllIlIIIIIll.charData;
                }
                ++lllllllllllllllIIlllIllIlIIIlIIl;
                continue;
            }
            if (lllllllllllllllIIlllIllIlIIIlIlI >= lllllllllllllllIIlllIllIlIIIIlll.length) continue;
            lllllllllllllllIIlllIllIlIIIlIII += lllllllllllllllIIlllIllIlIIIIlll[lllllllllllllllIIlllIllIlIIIlIlI].width - 8 + lllllllllllllllIIlllIllIlIIIIIll.charOffset;
        }
        return lllllllllllllllIIlllIllIlIIIlIII / 2;
    }

    @Override
    public void setFractionalMetrics(boolean lllllllllllllllIIlllIllIIIlIlIlI) {
        CustomFontRenderer lllllllllllllllIIlllIllIIIlIllIl;
        super.setFractionalMetrics(lllllllllllllllIIlllIllIIIlIlIlI);
        lllllllllllllllIIlllIllIIIlIllIl.setupBoldItalicIDs();
    }

    public float drawStringWithShadow(String lllllllllllllllIIlllIlllIlIIIIII, float lllllllllllllllIIlllIlllIIlllIIl, float lllllllllllllllIIlllIlllIIlllIII, int lllllllllllllllIIlllIlllIIllllIl) {
        CustomFontRenderer lllllllllllllllIIlllIlllIIlllIll;
        float lllllllllllllllIIlllIlllIIllllII = lllllllllllllllIIlllIlllIIlllIll.drawString(lllllllllllllllIIlllIlllIlIIIIII, (double)lllllllllllllllIIlllIlllIIlllIIl + 1.0, (double)lllllllllllllllIIlllIlllIIlllIII + 1.0, lllllllllllllllIIlllIlllIIllllIl, true);
        return Math.max(lllllllllllllllIIlllIlllIIllllII, lllllllllllllllIIlllIlllIIlllIll.drawString(lllllllllllllllIIlllIlllIlIIIIII, lllllllllllllllIIlllIlllIIlllIIl, lllllllllllllllIIlllIlllIIlllIII, lllllllllllllllIIlllIlllIIllllIl, false));
    }

    public float drawString(String lllllllllllllllIIlllIlllIlIlIIII, double lllllllllllllllIIlllIlllIlIIllll, double lllllllllllllllIIlllIlllIlIIlllI, int lllllllllllllllIIlllIlllIlIIlIII) {
        CustomFontRenderer lllllllllllllllIIlllIlllIlIlIIIl;
        return lllllllllllllllIIlllIlllIlIlIIIl.drawString(lllllllllllllllIIlllIlllIlIlIIII, lllllllllllllllIIlllIlllIlIIllll, lllllllllllllllIIlllIlllIlIIlllI, lllllllllllllllIIlllIlllIlIIlIII, false);
    }

    public void drawTotalCenteredStringWithShadow(String lllllllllllllllIIlllIllIIlIIIlII, double lllllllllllllllIIlllIllIIIlllllI, double lllllllllllllllIIlllIllIIlIIIIlI, int lllllllllllllllIIlllIllIIlIIIIIl) {
        CustomFontRenderer lllllllllllllllIIlllIllIIlIIIIII;
        lllllllllllllllIIlllIllIIlIIIIII.drawStringWithShadow(lllllllllllllllIIlllIllIIlIIIlII, lllllllllllllllIIlllIllIIIlllllI - (double)(lllllllllllllllIIlllIllIIlIIIIII.getStringWidth(lllllllllllllllIIlllIllIIlIIIlII) / 2), lllllllllllllllIIlllIllIIlIIIIlI - (double)((float)lllllllllllllllIIlllIllIIlIIIIII.getHeight() / 2.0f), lllllllllllllllIIlllIllIIlIIIIIl);
    }

    public float drawCenteredString(String lllllllllllllllIIlllIlllIIIlllIl, float lllllllllllllllIIlllIlllIIIlIlll, float lllllllllllllllIIlllIlllIIIllIll, int lllllllllllllllIIlllIlllIIIllIlI) {
        CustomFontRenderer lllllllllllllllIIlllIlllIIIllIIl;
        return lllllllllllllllIIlllIlllIIIllIIl.drawString(lllllllllllllllIIlllIlllIIIlllIl, lllllllllllllllIIlllIlllIIIlIlll - (float)lllllllllllllllIIlllIlllIIIllIIl.getStringWidth(lllllllllllllllIIlllIlllIIIlllIl) / 2.0f, lllllllllllllllIIlllIlllIIIllIll, lllllllllllllllIIlllIlllIIIllIlI);
    }

    private void drawLine(double lllllllllllllllIIlllIllIIIlIIIII, double lllllllllllllllIIlllIllIIIIlllll, double lllllllllllllllIIlllIllIIIIllllI, double lllllllllllllllIIlllIllIIIIllIII, float lllllllllllllllIIlllIllIIIIlllII) {
        GL11.glDisable((int)3553);
        GL11.glLineWidth((float)lllllllllllllllIIlllIllIIIIlllII);
        GL11.glBegin((int)1);
        GL11.glVertex2d((double)lllllllllllllllIIlllIllIIIlIIIII, (double)lllllllllllllllIIlllIllIIIIlllll);
        GL11.glVertex2d((double)lllllllllllllllIIlllIllIIIIllllI, (double)lllllllllllllllIIlllIllIIIIllIII);
        GL11.glEnd();
        GL11.glEnable((int)3553);
    }

    public void drawTotalCenteredString(String lllllllllllllllIIlllIllIIlIlIIll, double lllllllllllllllIIlllIllIIlIlIIlI, double lllllllllllllllIIlllIllIIlIlIIIl, int lllllllllllllllIIlllIllIIlIlIIII) {
        CustomFontRenderer lllllllllllllllIIlllIllIIlIIllll;
        lllllllllllllllIIlllIllIIlIIllll.drawString(lllllllllllllllIIlllIllIIlIlIIll, lllllllllllllllIIlllIllIIlIlIIlI - (double)(lllllllllllllllIIlllIllIIlIIllll.getStringWidth(lllllllllllllllIIlllIllIIlIlIIll) / 2), lllllllllllllllIIlllIllIIlIlIIIl - (double)(lllllllllllllllIIlllIllIIlIIllll.getHeight() / 2), lllllllllllllllIIlllIllIIlIlIIII);
    }

    public List wrapWords(String lllllllllllllllIIlllIlIllllllIIl, double lllllllllllllllIIlllIlIllllllIII) {
        CustomFontRenderer lllllllllllllllIIlllIlIllllllllI;
        ArrayList<String> lllllllllllllllIIlllIlIllllllIll = new ArrayList<String>();
        if ((double)lllllllllllllllIIlllIlIllllllllI.getStringWidth(lllllllllllllllIIlllIlIllllllIIl) > lllllllllllllllIIlllIlIllllllIII) {
            String[] lllllllllllllllIIlllIllIIIIIIIll = lllllllllllllllIIlllIlIllllllIIl.split(" ");
            String lllllllllllllllIIlllIllIIIIIIIlI = "";
            char lllllllllllllllIIlllIllIIIIIIIIl = '\uffff';
            String[] lllllllllllllllIIlllIllIIIIIIIII = lllllllllllllllIIlllIllIIIIIIIll;
            int lllllllllllllllIIlllIlIlllllllll = lllllllllllllllIIlllIllIIIIIIIll.length;
            for (int lllllllllllllllIIlllIllIIIIIIllI = 0; lllllllllllllllIIlllIllIIIIIIllI < lllllllllllllllIIlllIlIlllllllll; ++lllllllllllllllIIlllIllIIIIIIllI) {
                String lllllllllllllllIIlllIllIIIIIIlll = lllllllllllllllIIlllIllIIIIIIIII[lllllllllllllllIIlllIllIIIIIIllI];
                for (int lllllllllllllllIIlllIllIIIIIlIII = 0; lllllllllllllllIIlllIllIIIIIlIII < lllllllllllllllIIlllIllIIIIIIlll.toCharArray().length; ++lllllllllllllllIIlllIllIIIIIlIII) {
                    char lllllllllllllllIIlllIllIIIIIlIIl = lllllllllllllllIIlllIllIIIIIIlll.toCharArray()[lllllllllllllllIIlllIllIIIIIlIII];
                    if (!String.valueOf(lllllllllllllllIIlllIllIIIIIlIIl).equals("\u00a7") || lllllllllllllllIIlllIllIIIIIlIII >= lllllllllllllllIIlllIllIIIIIIlll.toCharArray().length - 1) continue;
                    lllllllllllllllIIlllIllIIIIIIIIl = lllllllllllllllIIlllIllIIIIIIlll.toCharArray()[lllllllllllllllIIlllIllIIIIIlIII + 1];
                }
                StringBuilder stringBuilder = new StringBuilder();
                if ((double)lllllllllllllllIIlllIlIllllllllI.getStringWidth(String.valueOf(stringBuilder.append(lllllllllllllllIIlllIllIIIIIIIlI).append(lllllllllllllllIIlllIllIIIIIIlll).append(" "))) < lllllllllllllllIIlllIlIllllllIII) {
                    lllllllllllllllIIlllIllIIIIIIIlI = String.valueOf(new StringBuilder().append(lllllllllllllllIIlllIllIIIIIIIlI).append(lllllllllllllllIIlllIllIIIIIIlll).append(" "));
                    continue;
                }
                lllllllllllllllIIlllIlIllllllIll.add(lllllllllllllllIIlllIllIIIIIIIlI);
                lllllllllllllllIIlllIllIIIIIIIlI = String.valueOf(new StringBuilder().append("").append(lllllllllllllllIIlllIllIIIIIIIIl).append(lllllllllllllllIIlllIllIIIIIIlll).append(" "));
            }
            if (lllllllllllllllIIlllIllIIIIIIIlI.length() > 0) {
                if ((double)lllllllllllllllIIlllIlIllllllllI.getStringWidth(lllllllllllllllIIlllIllIIIIIIIlI) < lllllllllllllllIIlllIlIllllllIII) {
                    lllllllllllllllIIlllIlIllllllIll.add(String.valueOf(new StringBuilder().append("").append(lllllllllllllllIIlllIllIIIIIIIIl).append(lllllllllllllllIIlllIllIIIIIIIlI).append(" ")));
                    lllllllllllllllIIlllIllIIIIIIIlI = "";
                } else {
                    for (String lllllllllllllllIIlllIllIIIIIIlIl : lllllllllllllllIIlllIlIllllllllI.formatString(lllllllllllllllIIlllIllIIIIIIIlI, lllllllllllllllIIlllIlIllllllIII)) {
                        lllllllllllllllIIlllIlIllllllIll.add(lllllllllllllllIIlllIllIIIIIIlIl);
                    }
                }
            }
        } else {
            lllllllllllllllIIlllIlIllllllIll.add(lllllllllllllllIIlllIlIllllllIIl);
        }
        return lllllllllllllllIIlllIlIllllllIll;
    }

    public float drawCenteredStringWithShadow(String lllllllllllllllIIlllIllIllllllll, float lllllllllllllllIIlllIllIlllllIIl, float lllllllllllllllIIlllIllIlllllIII, int lllllllllllllllIIlllIllIllllllII) {
        CustomFontRenderer lllllllllllllllIIlllIlllIIIIIIII;
        lllllllllllllllIIlllIlllIIIIIIII.drawString(lllllllllllllllIIlllIllIllllllll, (double)(lllllllllllllllIIlllIllIlllllIIl - (float)lllllllllllllllIIlllIlllIIIIIIII.getStringWidth(lllllllllllllllIIlllIllIllllllll) / 2.0f) + 0.45, (double)lllllllllllllllIIlllIllIlllllIII + 0.5, lllllllllllllllIIlllIllIllllllII, true);
        return lllllllllllllllIIlllIlllIIIIIIII.drawString(lllllllllllllllIIlllIllIllllllll, lllllllllllllllIIlllIllIlllllIIl - (float)lllllllllllllllIIlllIlllIIIIIIII.getStringWidth(lllllllllllllllIIlllIllIllllllll) / 2.0f, lllllllllllllllIIlllIllIlllllIII, lllllllllllllllIIlllIllIllllllII);
    }

    public void drawCenteredStringWithOutline(String lllllllllllllllIIlllIllIllIlllII, double lllllllllllllllIIlllIllIllIllIll, double lllllllllllllllIIlllIllIllIllIlI, int lllllllllllllllIIlllIllIllIllllI) {
        CustomFontRenderer lllllllllllllllIIlllIllIllIlllIl;
        lllllllllllllllIIlllIllIllIlllIl.drawCenteredString(lllllllllllllllIIlllIllIllIlllII, lllllllllllllllIIlllIllIllIllIll - 0.5, lllllllllllllllIIlllIllIllIllIlI, 0);
        lllllllllllllllIIlllIllIllIlllIl.drawCenteredString(lllllllllllllllIIlllIllIllIlllII, lllllllllllllllIIlllIllIllIllIll + 0.5, lllllllllllllllIIlllIllIllIllIlI, 0);
        lllllllllllllllIIlllIllIllIlllIl.drawCenteredString(lllllllllllllllIIlllIllIllIlllII, lllllllllllllllIIlllIllIllIllIll, lllllllllllllllIIlllIllIllIllIlI - 0.5, 0);
        lllllllllllllllIIlllIllIllIlllIl.drawCenteredString(lllllllllllllllIIlllIllIllIlllII, lllllllllllllllIIlllIllIllIllIll, lllllllllllllllIIlllIllIllIllIlI + 0.5, 0);
        lllllllllllllllIIlllIllIllIlllIl.drawCenteredString(lllllllllllllllIIlllIllIllIlllII, lllllllllllllllIIlllIllIllIllIll, lllllllllllllllIIlllIllIllIllIlI, lllllllllllllllIIlllIllIllIllllI);
    }

    public float drawCenteredString(String lllllllllllllllIIlllIlllIIIIlllI, double lllllllllllllllIIlllIlllIIIIlIII, double lllllllllllllllIIlllIlllIIIIllII, int lllllllllllllllIIlllIlllIIIIlIll) {
        CustomFontRenderer lllllllllllllllIIlllIlllIIIIlIlI;
        return lllllllllllllllIIlllIlllIIIIlIlI.drawString(lllllllllllllllIIlllIlllIIIIlllI, lllllllllllllllIIlllIlllIIIIlIII - (double)((float)lllllllllllllllIIlllIlllIIIIlIlI.getStringWidth(lllllllllllllllIIlllIlllIIIIlllI) / 2.0f), lllllllllllllllIIlllIlllIIIIllII, lllllllllllllllIIlllIlllIIIIlIll);
    }

    public void drawStringWithOutline(String lllllllllllllllIIlllIllIllllIIII, double lllllllllllllllIIlllIllIlllIlIlI, double lllllllllllllllIIlllIllIlllIlllI, int lllllllllllllllIIlllIllIlllIlIII) {
        CustomFontRenderer lllllllllllllllIIlllIllIlllIllII;
        lllllllllllllllIIlllIllIlllIllII.drawString(lllllllllllllllIIlllIllIllllIIII, lllllllllllllllIIlllIllIlllIlIlI - 0.5, lllllllllllllllIIlllIllIlllIlllI, 0);
        lllllllllllllllIIlllIllIlllIllII.drawString(lllllllllllllllIIlllIllIllllIIII, lllllllllllllllIIlllIllIlllIlIlI + 0.5, lllllllllllllllIIlllIllIlllIlllI, 0);
        lllllllllllllllIIlllIllIlllIllII.drawString(lllllllllllllllIIlllIllIllllIIII, lllllllllllllllIIlllIllIlllIlIlI, lllllllllllllllIIlllIllIlllIlllI - 0.5, 0);
        lllllllllllllllIIlllIllIlllIllII.drawString(lllllllllllllllIIlllIllIllllIIII, lllllllllllllllIIlllIllIlllIlIlI, lllllllllllllllIIlllIllIlllIlllI + 0.5, 0);
        lllllllllllllllIIlllIllIlllIllII.drawString(lllllllllllllllIIlllIllIllllIIII, lllllllllllllllIIlllIllIlllIlIlI, lllllllllllllllIIlllIllIlllIlllI, lllllllllllllllIIlllIllIlllIlIII);
    }

    @Override
    public void setFont(Font lllllllllllllllIIlllIllIIIlllIII) {
        CustomFontRenderer lllllllllllllllIIlllIllIIIlllIIl;
        super.setFont(lllllllllllllllIIlllIllIIIlllIII);
        lllllllllllllllIIlllIllIIIlllIIl.setupBoldItalicIDs();
    }

    private void setupBoldItalicIDs() {
        CustomFontRenderer lllllllllllllllIIlllIllIIIlIIlll;
        lllllllllllllllIIlllIllIIIlIIlll.texBold = lllllllllllllllIIlllIllIIIlIIlll.setupTexture(lllllllllllllllIIlllIllIIIlIIlll.font.deriveFont(1), lllllllllllllllIIlllIllIIIlIIlll.antiAlias, lllllllllllllllIIlllIllIIIlIIlll.fractionalMetrics, lllllllllllllllIIlllIllIIIlIIlll.boldChars);
        lllllllllllllllIIlllIllIIIlIIlll.texItalic = lllllllllllllllIIlllIllIIIlIIlll.setupTexture(lllllllllllllllIIlllIllIIIlIIlll.font.deriveFont(2), lllllllllllllllIIlllIllIIIlIIlll.antiAlias, lllllllllllllllIIlllIllIIIlIIlll.fractionalMetrics, lllllllllllllllIIlllIllIIIlIIlll.italicChars);
        lllllllllllllllIIlllIllIIIlIIlll.texItalicBold = lllllllllllllllIIlllIllIIIlIIlll.setupTexture(lllllllllllllllIIlllIllIIIlIIlll.font.deriveFont(3), lllllllllllllllIIlllIllIIIlIIlll.antiAlias, lllllllllllllllIIlllIllIIIlIIlll.fractionalMetrics, lllllllllllllllIIlllIllIIIlIIlll.boldItalicChars);
    }
}

