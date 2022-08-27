/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.texture.DynamicTexture
 *  org.lwjgl.opengl.GL11
 */
package ru.hld.legendline.api.utils;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.DynamicTexture;
import org.lwjgl.opengl.GL11;
import ru.hld.legendline.api.utils.CFont;
import ru.hld.legendline.api.utils.ColorUtils;

public class CFontRenderer
extends CFont {
    protected /* synthetic */ CFont.CharData[] boldChars;
    protected /* synthetic */ CFont.CharData[] italicChars;
    protected /* synthetic */ DynamicTexture texItalic;
    private /* synthetic */ float[] charWidthFloat;
    protected /* synthetic */ CFont.CharData[] boldItalicChars;
    protected /* synthetic */ DynamicTexture texItalicBold;
    private final /* synthetic */ byte[] glyphWidth;
    private final /* synthetic */ int[] colorCode;
    protected /* synthetic */ DynamicTexture texBold;
    private final /* synthetic */ int[] charWidth;
    private final /* synthetic */ String colorcodeIdentifiers = "0123456789abcdefklmnor";

    public String trimStringToWidth(String llllllllllllllIIlIlIIllIlIIIllII, int llllllllllllllIIlIlIIllIlIIIIIIl, boolean llllllllllllllIIlIlIIllIlIIIIIII) {
        StringBuilder llllllllllllllIIlIlIIllIlIIIlIIl = new StringBuilder();
        float llllllllllllllIIlIlIIllIlIIIlIII = 0.0f;
        int llllllllllllllIIlIlIIllIlIIIIlll = llllllllllllllIIlIlIIllIlIIIIIII ? llllllllllllllIIlIlIIllIlIIIllII.length() - 1 : 0;
        int llllllllllllllIIlIlIIllIlIIIIllI = llllllllllllllIIlIlIIllIlIIIIIII ? -1 : 1;
        boolean llllllllllllllIIlIlIIllIlIIIIlIl = false;
        boolean llllllllllllllIIlIlIIllIlIIIIlII = false;
        for (int llllllllllllllIIlIlIIllIlIIIlllI = llllllllllllllIIlIlIIllIlIIIIlll; llllllllllllllIIlIlIIllIlIIIlllI >= 0 && llllllllllllllIIlIlIIllIlIIIlllI < llllllllllllllIIlIlIIllIlIIIllII.length() && llllllllllllllIIlIlIIllIlIIIlIII < (float)llllllllllllllIIlIlIIllIlIIIIIIl; llllllllllllllIIlIlIIllIlIIIlllI += llllllllllllllIIlIlIIllIlIIIIllI) {
            CFontRenderer llllllllllllllIIlIlIIllIlIIIIIll;
            char llllllllllllllIIlIlIIllIlIIlIIII = llllllllllllllIIlIlIIllIlIIIllII.charAt(llllllllllllllIIlIlIIllIlIIIlllI);
            float llllllllllllllIIlIlIIllIlIIIllll = llllllllllllllIIlIlIIllIlIIIIIll.getCharWidthFloat(llllllllllllllIIlIlIIllIlIIlIIII);
            if (llllllllllllllIIlIlIIllIlIIIIlIl) {
                llllllllllllllIIlIlIIllIlIIIIlIl = false;
                if (llllllllllllllIIlIlIIllIlIIlIIII != 'l' && llllllllllllllIIlIlIIllIlIIlIIII != 'L') {
                    if (llllllllllllllIIlIlIIllIlIIlIIII == 'r' || llllllllllllllIIlIlIIllIlIIlIIII == 'R') {
                        llllllllllllllIIlIlIIllIlIIIIlII = false;
                    }
                } else {
                    llllllllllllllIIlIlIIllIlIIIIlII = true;
                }
            } else if (llllllllllllllIIlIlIIllIlIIIllll < 0.0f) {
                llllllllllllllIIlIlIIllIlIIIIlIl = true;
            } else {
                llllllllllllllIIlIlIIllIlIIIlIII += llllllllllllllIIlIlIIllIlIIIllll;
                if (llllllllllllllIIlIlIIllIlIIIIlII) {
                    llllllllllllllIIlIlIIllIlIIIlIII += 1.0f;
                }
            }
            if (llllllllllllllIIlIlIIllIlIIIlIII > (float)llllllllllllllIIlIlIIllIlIIIIIIl) break;
            if (llllllllllllllIIlIlIIllIlIIIIIII) {
                llllllllllllllIIlIlIIllIlIIIlIIl.insert(0, llllllllllllllIIlIlIIllIlIIlIIII);
                continue;
            }
            llllllllllllllIIlIlIIllIlIIIlIIl.append(llllllllllllllIIlIlIIllIlIIlIIII);
        }
        return String.valueOf(llllllllllllllIIlIlIIllIlIIIlIIl);
    }

    private void setupBoldItalicIDs() {
        CFontRenderer llllllllllllllIIlIlIIlllIlIIlIII;
        llllllllllllllIIlIlIIlllIlIIlIII.texBold = llllllllllllllIIlIlIIlllIlIIlIII.setupTexture(llllllllllllllIIlIlIIlllIlIIlIII.font.deriveFont(1), llllllllllllllIIlIlIIlllIlIIlIII.antiAlias, llllllllllllllIIlIlIIlllIlIIlIII.fractionalMetrics, llllllllllllllIIlIlIIlllIlIIlIII.boldChars);
        llllllllllllllIIlIlIIlllIlIIlIII.texItalic = llllllllllllllIIlIlIIlllIlIIlIII.setupTexture(llllllllllllllIIlIlIIlllIlIIlIII.font.deriveFont(2), llllllllllllllIIlIlIIlllIlIIlIII.antiAlias, llllllllllllllIIlIlIIlllIlIIlIII.fractionalMetrics, llllllllllllllIIlIlIIlllIlIIlIII.italicChars);
    }

    public void drawTotalCenteredString(String llllllllllllllIIlIlIIlllllIIIlII, double llllllllllllllIIlIlIIlllllIIlIII, double llllllllllllllIIlIlIIlllllIIIlll, int llllllllllllllIIlIlIIlllllIIIIIl) {
        CFontRenderer llllllllllllllIIlIlIIlllllIIlIlI;
        llllllllllllllIIlIlIIlllllIIlIlI.drawString(llllllllllllllIIlIlIIlllllIIIlII, llllllllllllllIIlIlIIlllllIIlIII - (double)((float)llllllllllllllIIlIlIIlllllIIlIlI.getStringWidth(llllllllllllllIIlIlIIlllllIIIlII) / 2.0f), llllllllllllllIIlIlIIlllllIIIlll - (double)((float)llllllllllllllIIlIlIIlllllIIlIlI.getStringHeight(llllllllllllllIIlIlIIlllllIIIlII) / 2.0f), llllllllllllllIIlIlIIlllllIIIIIl);
    }

    public float drawCenteredString(String llllllllllllllIIlIlIIlllllllIllI, double llllllllllllllIIlIlIIlllllllIIII, double llllllllllllllIIlIlIIllllllIllll, int llllllllllllllIIlIlIIllllllIlllI) {
        CFontRenderer llllllllllllllIIlIlIIlllllllIIlI;
        return llllllllllllllIIlIlIIlllllllIIlI.drawString(llllllllllllllIIlIlIIlllllllIllI, llllllllllllllIIlIlIIlllllllIIII - (double)(llllllllllllllIIlIlIIlllllllIIlI.getStringWidth(llllllllllllllIIlIlIIlllllllIllI) / 2), llllllllllllllIIlIlIIllllllIllll, llllllllllllllIIlIlIIllllllIlllI);
    }

    @Override
    public void setAntiAlias(boolean llllllllllllllIIlIlIIlllIlIlIIIl) {
        CFontRenderer llllllllllllllIIlIlIIlllIlIlIlII;
        super.setAntiAlias(llllllllllllllIIlIlIIlllIlIlIIIl);
        llllllllllllllIIlIlIIlllIlIlIlII.setupBoldItalicIDs();
    }

    public List<String> formatString(String llllllllllllllIIlIlIIlllIIIIIIll, double llllllllllllllIIlIlIIllIlllllIll) {
        ArrayList<String> llllllllllllllIIlIlIIlllIIIIIIIl = new ArrayList<String>();
        String llllllllllllllIIlIlIIlllIIIIIIII = "";
        int llllllllllllllIIlIlIIllIllllllll = 65535;
        char[] llllllllllllllIIlIlIIllIlllllllI = llllllllllllllIIlIlIIlllIIIIIIll.toCharArray();
        for (int llllllllllllllIIlIlIIlllIIIIIlIl = 0; llllllllllllllIIlIlIIlllIIIIIlIl < llllllllllllllIIlIlIIllIlllllllI.length; ++llllllllllllllIIlIlIIlllIIIIIlIl) {
            CFontRenderer llllllllllllllIIlIlIIlllIIIIIlII;
            char llllllllllllllIIlIlIIlllIIIIIllI = llllllllllllllIIlIlIIllIlllllllI[llllllllllllllIIlIlIIlllIIIIIlIl];
            if (llllllllllllllIIlIlIIlllIIIIIllI == '\u00a7' && llllllllllllllIIlIlIIlllIIIIIlIl < llllllllllllllIIlIlIIllIlllllllI.length - 1) {
                llllllllllllllIIlIlIIllIllllllll = llllllllllllllIIlIlIIllIlllllllI[llllllllllllllIIlIlIIlllIIIIIlIl + 1];
            }
            StringBuilder stringBuilder = new StringBuilder();
            if ((double)llllllllllllllIIlIlIIlllIIIIIlII.getStringWidth(String.valueOf(stringBuilder.append(llllllllllllllIIlIlIIlllIIIIIIII).append(llllllllllllllIIlIlIIlllIIIIIllI))) < llllllllllllllIIlIlIIllIlllllIll) {
                llllllllllllllIIlIlIIlllIIIIIIII = String.valueOf(new StringBuilder().append(llllllllllllllIIlIlIIlllIIIIIIII).append(llllllllllllllIIlIlIIlllIIIIIllI));
                continue;
            }
            llllllllllllllIIlIlIIlllIIIIIIIl.add(llllllllllllllIIlIlIIlllIIIIIIII);
            llllllllllllllIIlIlIIlllIIIIIIII = String.valueOf(new StringBuilder().append(167 + llllllllllllllIIlIlIIllIllllllll).append(String.valueOf(llllllllllllllIIlIlIIlllIIIIIllI)));
        }
        if (llllllllllllllIIlIlIIlllIIIIIIII.length() > 0) {
            llllllllllllllIIlIlIIlllIIIIIIIl.add(llllllllllllllIIlIlIIlllIIIIIIII);
        }
        return llllllllllllllIIlIlIIlllIIIIIIIl;
    }

    public void drawTotalCenteredStringWithShadow(String llllllllllllllIIlIlIIllllllIIIlI, double llllllllllllllIIlIlIIllllllIIIIl, double llllllllllllllIIlIlIIllllllIIlIl, int llllllllllllllIIlIlIIlllllIlllll) {
        CFontRenderer llllllllllllllIIlIlIIllllllIlIII;
        llllllllllllllIIlIlIIllllllIlIII.drawStringWithShadow(llllllllllllllIIlIlIIllllllIIIlI, llllllllllllllIIlIlIIllllllIIIIl - (double)((float)llllllllllllllIIlIlIIllllllIlIII.getStringWidth(llllllllllllllIIlIlIIllllllIIIlI) / 2.0f), llllllllllllllIIlIlIIllllllIIlIl - (double)((float)llllllllllllllIIlIlIIllllllIlIII.getStringHeight(llllllllllllllIIlIlIIllllllIIIlI) / 2.0f), llllllllllllllIIlIlIIlllllIlllll);
    }

    @Override
    public int getStringWidth(String llllllllllllllIIlIlIIlllIllIllII) {
        CFontRenderer llllllllllllllIIlIlIIlllIllIllIl;
        if (llllllllllllllIIlIlIIlllIllIllII == null) {
            return 0;
        }
        int llllllllllllllIIlIlIIlllIllIlIll = 0;
        CFont.CharData[] llllllllllllllIIlIlIIlllIllIlIlI = llllllllllllllIIlIlIIlllIllIllIl.charData;
        boolean llllllllllllllIIlIlIIlllIllIlIIl = false;
        boolean llllllllllllllIIlIlIIlllIllIlIII = false;
        int llllllllllllllIIlIlIIlllIllIIlll = llllllllllllllIIlIlIIlllIllIllII.length();
        for (int llllllllllllllIIlIlIIlllIllIlllI = 0; llllllllllllllIIlIlIIlllIllIlllI < llllllllllllllIIlIlIIlllIllIIlll; ++llllllllllllllIIlIlIIlllIllIlllI) {
            char llllllllllllllIIlIlIIlllIllIllll = llllllllllllllIIlIlIIlllIllIllII.charAt(llllllllllllllIIlIlIIlllIllIlllI);
            if (llllllllllllllIIlIlIIlllIllIllll == '\u00a7' && llllllllllllllIIlIlIIlllIllIlllI < llllllllllllllIIlIlIIlllIllIIlll) {
                int llllllllllllllIIlIlIIlllIlllIIII = "0123456789abcdefklmnor".indexOf(llllllllllllllIIlIlIIlllIllIllll);
                if (llllllllllllllIIlIlIIlllIlllIIII < 16) {
                    llllllllllllllIIlIlIIlllIllIlIIl = false;
                    llllllllllllllIIlIlIIlllIllIlIII = false;
                } else if (llllllllllllllIIlIlIIlllIlllIIII == 17) {
                    llllllllllllllIIlIlIIlllIllIlIIl = true;
                    llllllllllllllIIlIlIIlllIllIlIlI = llllllllllllllIIlIlIIlllIllIlIII ? llllllllllllllIIlIlIIlllIllIllIl.boldItalicChars : llllllllllllllIIlIlIIlllIllIllIl.boldChars;
                } else if (llllllllllllllIIlIlIIlllIlllIIII == 20) {
                    llllllllllllllIIlIlIIlllIllIlIII = true;
                    llllllllllllllIIlIlIIlllIllIlIlI = llllllllllllllIIlIlIIlllIllIlIIl ? llllllllllllllIIlIlIIlllIllIllIl.boldItalicChars : llllllllllllllIIlIlIIlllIllIllIl.italicChars;
                } else if (llllllllllllllIIlIlIIlllIlllIIII == 21) {
                    llllllllllllllIIlIlIIlllIllIlIIl = false;
                    llllllllllllllIIlIlIIlllIllIlIII = false;
                    llllllllllllllIIlIlIIlllIllIlIlI = llllllllllllllIIlIlIIlllIllIllIl.charData;
                }
                ++llllllllllllllIIlIlIIlllIllIlllI;
                continue;
            }
            if (llllllllllllllIIlIlIIlllIllIllll >= llllllllllllllIIlIlIIlllIllIlIlI.length || llllllllllllllIIlIlIIlllIllIllll < '\u0000') continue;
            llllllllllllllIIlIlIIlllIllIlIll += llllllllllllllIIlIlIIlllIllIlIlI[llllllllllllllIIlIlIIlllIllIllll].width - 8 + llllllllllllllIIlIlIIlllIllIllIl.charOffset;
        }
        return llllllllllllllIIlIlIIlllIllIlIll / 2;
    }

    public CFontRenderer(Font llllllllllllllIIlIlIlIIIIlIIIlIl, boolean llllllllllllllIIlIlIlIIIIlIIlIII, boolean llllllllllllllIIlIlIlIIIIlIIIIll) {
        super(llllllllllllllIIlIlIlIIIIlIIIlIl, llllllllllllllIIlIlIlIIIIlIIlIII, llllllllllllllIIlIlIlIIIIlIIIIll);
        CFontRenderer llllllllllllllIIlIlIlIIIIlIIlIlI;
        llllllllllllllIIlIlIlIIIIlIIlIlI.boldChars = new CFont.CharData[167];
        llllllllllllllIIlIlIlIIIIlIIlIlI.italicChars = new CFont.CharData[167];
        llllllllllllllIIlIlIlIIIIlIIlIlI.boldItalicChars = new CFont.CharData[167];
        llllllllllllllIIlIlIlIIIIlIIlIlI.charWidthFloat = new float[256];
        llllllllllllllIIlIlIlIIIIlIIlIlI.glyphWidth = new byte[65536];
        llllllllllllllIIlIlIlIIIIlIIlIlI.charWidth = new int[256];
        llllllllllllllIIlIlIlIIIIlIIlIlI.colorCode = new int[32];
        llllllllllllllIIlIlIlIIIIlIIlIlI.colorcodeIdentifiers = "0123456789abcdefklmnor";
        llllllllllllllIIlIlIlIIIIlIIlIlI.setupMinecraftColorcodes();
        llllllllllllllIIlIlIlIIIIlIIlIlI.setupBoldItalicIDs();
    }

    public List<String> wrapWords(String llllllllllllllIIlIlIIlllIIIllIll, double llllllllllllllIIlIlIIlllIIIllllI) {
        CFontRenderer llllllllllllllIIlIlIIlllIIlIIIII;
        ArrayList<String> llllllllllllllIIlIlIIlllIIIlllIl = new ArrayList<String>();
        if ((double)llllllllllllllIIlIlIIlllIIlIIIII.getStringWidth(llllllllllllllIIlIlIIlllIIIllIll) > llllllllllllllIIlIlIIlllIIIllllI) {
            String[] llllllllllllllIIlIlIIlllIIlIIlIl = llllllllllllllIIlIlIIlllIIIllIll.split(" ");
            String llllllllllllllIIlIlIIlllIIlIIlII = "";
            int llllllllllllllIIlIlIIlllIIlIIIll = 65535;
            String[] llllllllllllllIIlIlIIlllIIlIIIlI = llllllllllllllIIlIlIIlllIIlIIlIl;
            int llllllllllllllIIlIlIIlllIIlIIIIl = llllllllllllllIIlIlIIlllIIlIIlIl.length;
            for (int llllllllllllllIIlIlIIlllIIlIIlll = 0; llllllllllllllIIlIlIIlllIIlIIlll < llllllllllllllIIlIlIIlllIIlIIIIl; ++llllllllllllllIIlIlIIlllIIlIIlll) {
                String llllllllllllllIIlIlIIlllIIlIlIII = llllllllllllllIIlIlIIlllIIlIIIlI[llllllllllllllIIlIlIIlllIIlIIlll];
                boolean llllllllllllllIIlIlIIlllIIlIlIIl = false;
                while (llllllllllllllIIlIlIIlllIIlIIlll < llllllllllllllIIlIlIIlllIIlIlIII.toCharArray().length) {
                    char llllllllllllllIIlIlIIlllIIlIlIlI = llllllllllllllIIlIlIIlllIIlIlIII.toCharArray()[llllllllllllllIIlIlIIlllIIlIIlll];
                    if (llllllllllllllIIlIlIIlllIIlIlIlI == '\u00a7' && llllllllllllllIIlIlIIlllIIlIIlll < llllllllllllllIIlIlIIlllIIlIlIII.toCharArray().length - 1) {
                        llllllllllllllIIlIlIIlllIIlIIIll = llllllllllllllIIlIlIIlllIIlIlIII.toCharArray()[llllllllllllllIIlIlIIlllIIlIIlll + 1];
                    }
                    ++llllllllllllllIIlIlIIlllIIlIIlll;
                }
                StringBuilder stringBuilder = new StringBuilder();
                if ((double)llllllllllllllIIlIlIIlllIIlIIIII.getStringWidth(String.valueOf(stringBuilder.append(llllllllllllllIIlIlIIlllIIlIIlII).append(llllllllllllllIIlIlIIlllIIlIlIII).append(" "))) < llllllllllllllIIlIlIIlllIIIllllI) {
                    llllllllllllllIIlIlIIlllIIlIIlII = String.valueOf(new StringBuilder().append(llllllllllllllIIlIlIIlllIIlIIlII).append(llllllllllllllIIlIlIIlllIIlIlIII).append(" "));
                    continue;
                }
                llllllllllllllIIlIlIIlllIIIlllIl.add(llllllllllllllIIlIlIIlllIIlIIlII);
                llllllllllllllIIlIlIIlllIIlIIlII = String.valueOf(new StringBuilder().append(167 + llllllllllllllIIlIlIIlllIIlIIIll).append(llllllllllllllIIlIlIIlllIIlIlIII).append(" "));
            }
            if (llllllllllllllIIlIlIIlllIIlIIlII.length() > 0) {
                if ((double)llllllllllllllIIlIlIIlllIIlIIIII.getStringWidth(llllllllllllllIIlIlIIlllIIlIIlII) < llllllllllllllIIlIlIIlllIIIllllI) {
                    llllllllllllllIIlIlIIlllIIIlllIl.add(String.valueOf(new StringBuilder().append(167 + llllllllllllllIIlIlIIlllIIlIIIll).append(llllllllllllllIIlIlIIlllIIlIIlII).append(" ")));
                    llllllllllllllIIlIlIIlllIIlIIlII = "";
                } else {
                    for (String llllllllllllllIIlIlIIlllIIlIIllI : llllllllllllllIIlIlIIlllIIlIIIII.formatString(llllllllllllllIIlIlIIlllIIlIIlII, llllllllllllllIIlIlIIlllIIIllllI)) {
                        llllllllllllllIIlIlIIlllIIIlllIl.add(llllllllllllllIIlIlIIlllIIlIIllI);
                    }
                }
            }
        } else {
            llllllllllllllIIlIlIIlllIIIlllIl.add(llllllllllllllIIlIlIIlllIIIllIll);
        }
        return llllllllllllllIIlIlIIlllIIIlllIl;
    }

    @Override
    public void setFont(Font llllllllllllllIIlIlIIlllIlIllIIl) {
        CFontRenderer llllllllllllllIIlIlIIlllIlIllIII;
        super.setFont(llllllllllllllIIlIlIIlllIlIllIIl);
        llllllllllllllIIlIlIIlllIlIllIII.setupBoldItalicIDs();
    }

    private static boolean isFormatColor(char llllllllllllllIIlIlIIllIIlllIIlI) {
        return llllllllllllllIIlIlIIllIIlllIIlI >= '0' && llllllllllllllIIlIlIIllIIlllIIlI <= '9' || llllllllllllllIIlIlIIllIIlllIIlI >= 'a' && llllllllllllllIIlIlIIllIIlllIIlI <= 'f' || llllllllllllllIIlIlIIllIIlllIIlI >= 'A' && llllllllllllllIIlIlIIllIIlllIIlI <= 'F';
    }

    public String trimStringToWidth(String llllllllllllllIIlIlIIllllIllIIll, int llllllllllllllIIlIlIIllllIllIIlI) {
        CFontRenderer llllllllllllllIIlIlIIllllIllIIIl;
        return llllllllllllllIIlIlIIllllIllIIIl.trimStringToWidth(llllllllllllllIIlIlIIllllIllIIll, llllllllllllllIIlIlIIllllIllIIlI, false);
    }

    private static boolean isFormatSpecial(char llllllllllllllIIlIlIIllIIlllIlII) {
        return llllllllllllllIIlIlIIllIIlllIlII >= 'k' && llllllllllllllIIlIlIIllIIlllIlII <= 'o' || llllllllllllllIIlIlIIllIIlllIlII >= 'K' && llllllllllllllIIlIlIIllIIlllIlII <= 'O' || llllllllllllllIIlIlIIllIIlllIlII == 'r' || llllllllllllllIIlIlIIllIIlllIlII == 'R';
    }

    public float drawCenteredStringWithShadow(String llllllllllllllIIlIlIIlllllIllIII, double llllllllllllllIIlIlIIlllllIlIIlI, double llllllllllllllIIlIlIIlllllIlIllI, int llllllllllllllIIlIlIIlllllIlIIII) {
        CFontRenderer llllllllllllllIIlIlIIlllllIlIlII;
        return llllllllllllllIIlIlIIlllllIlIlII.drawStringWithShadow(llllllllllllllIIlIlIIlllllIllIII, llllllllllllllIIlIlIIlllllIlIIlI - (double)((float)llllllllllllllIIlIlIIlllllIlIlII.getStringWidth(llllllllllllllIIlIlIIlllllIllIII) / 2.0f), llllllllllllllIIlIlIIlllllIlIllI, llllllllllllllIIlIlIIlllllIlIIII);
    }

    public List<String> listFormattedStringToWidth(String llllllllllllllIIlIlIIllllIlllIIl, int llllllllllllllIIlIlIIllllIlllIII) {
        CFontRenderer llllllllllllllIIlIlIIllllIllllIl;
        return Arrays.asList(llllllllllllllIIlIlIIllllIllllIl.wrapFormattedStringToWidth(llllllllllllllIIlIlIIllllIlllIIl, llllllllllllllIIlIlIIllllIlllIII).split("\n"));
    }

    public float drawString(String llllllllllllllIIlIlIIllllIIlIlll, double llllllllllllllIIlIlIIllllIIlIllI, double llllllllllllllIIlIlIIllllIIlIlIl, int llllllllllllllIIlIlIIllllIIIIlll, boolean llllllllllllllIIlIlIIllllIIIIllI) {
        CFontRenderer llllllllllllllIIlIlIIllllIIIlIll;
        llllllllllllllIIlIlIIllllIIlIllI -= 1.0;
        if (llllllllllllllIIlIlIIllllIIlIlll == null) {
            return 0.0f;
        }
        if (llllllllllllllIIlIlIIllllIIIIlll == 0x20FFFFFF) {
            llllllllllllllIIlIlIIllllIIIIlll = 0xFFFFFF;
        }
        if ((llllllllllllllIIlIlIIllllIIIIlll & 0xFC000000) == 0) {
            llllllllllllllIIlIlIIllllIIIIlll |= 0xFF000000;
        }
        if (llllllllllllllIIlIlIIllllIIIIllI) {
            llllllllllllllIIlIlIIllllIIIIlll = (llllllllllllllIIlIlIIllllIIIIlll & 0xFCFCFC) >> 2 | llllllllllllllIIlIlIIllllIIIIlll & new Color(20, 20, 20, 200).getRGB();
        }
        CFont.CharData[] llllllllllllllIIlIlIIllllIIlIIlI = llllllllllllllIIlIlIIllllIIIlIll.charData;
        float llllllllllllllIIlIlIIllllIIlIIIl = (float)(llllllllllllllIIlIlIIllllIIIIlll >> 24 & 0xFF) / 255.0f;
        boolean llllllllllllllIIlIlIIllllIIlIIII = false;
        boolean llllllllllllllIIlIlIIllllIIIllll = false;
        boolean llllllllllllllIIlIlIIllllIIIlllI = false;
        boolean llllllllllllllIIlIlIIllllIIIllIl = false;
        llllllllllllllIIlIlIIllllIIlIllI *= 2.0;
        llllllllllllllIIlIlIIllllIIlIlIl = (llllllllllllllIIlIlIIllllIIlIlIl - 3.0) * 2.0;
        GL11.glPushMatrix();
        GlStateManager.scale((double)0.5, (double)0.5, (double)0.5);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc((int)770, (int)771);
        GlStateManager.color((float)((float)(llllllllllllllIIlIlIIllllIIIIlll >> 16 & 0xFF) / 255.0f), (float)((float)(llllllllllllllIIlIlIIllllIIIIlll >> 8 & 0xFF) / 255.0f), (float)((float)(llllllllllllllIIlIlIIllllIIIIlll & 0xFF) / 255.0f), (float)llllllllllllllIIlIlIIllllIIlIIIl);
        int llllllllllllllIIlIlIIllllIIIllII = llllllllllllllIIlIlIIllllIIlIlll.length();
        GlStateManager.enableTexture2D();
        GlStateManager.bindTexture((int)llllllllllllllIIlIlIIllllIIIlIll.tex.getGlTextureId());
        GL11.glBindTexture((int)3553, (int)llllllllllllllIIlIlIIllllIIIlIll.tex.getGlTextureId());
        for (int llllllllllllllIIlIlIIllllIIllIIl = 0; llllllllllllllIIlIlIIllllIIllIIl < llllllllllllllIIlIlIIllllIIIllII; ++llllllllllllllIIlIlIIllllIIllIIl) {
            char llllllllllllllIIlIlIIllllIIllIlI = llllllllllllllIIlIlIIllllIIlIlll.charAt(llllllllllllllIIlIlIIllllIIllIIl);
            if (String.valueOf(llllllllllllllIIlIlIIllllIIllIlI).equals("\u00a7")) {
                int llllllllllllllIIlIlIIllllIIllIll = 21;
                try {
                    llllllllllllllIIlIlIIllllIIllIll = "0123456789abcdefklmnor".indexOf(llllllllllllllIIlIlIIllllIIlIlll.charAt(llllllllllllllIIlIlIIllllIIllIIl + 1));
                }
                catch (Exception llllllllllllllIIlIlIIllllIIlllIl) {
                    llllllllllllllIIlIlIIllllIIlllIl.printStackTrace();
                }
                if (llllllllllllllIIlIlIIllllIIllIll < 16) {
                    llllllllllllllIIlIlIIllllIIlIIII = false;
                    llllllllllllllIIlIlIIllllIIIllll = false;
                    llllllllllllllIIlIlIIllllIIIllIl = false;
                    llllllllllllllIIlIlIIllllIIIlllI = false;
                    GlStateManager.bindTexture((int)llllllllllllllIIlIlIIllllIIIlIll.tex.getGlTextureId());
                    llllllllllllllIIlIlIIllllIIlIIlI = llllllllllllllIIlIlIIllllIIIlIll.charData;
                    if (llllllllllllllIIlIlIIllllIIllIll < 0) {
                        llllllllllllllIIlIlIIllllIIllIll = 15;
                    }
                    if (llllllllllllllIIlIlIIllllIIIIllI) {
                        llllllllllllllIIlIlIIllllIIllIll += 16;
                    }
                    int llllllllllllllIIlIlIIllllIIlllII = llllllllllllllIIlIlIIllllIIIlIll.colorCode[llllllllllllllIIlIlIIllllIIllIll];
                    GlStateManager.color((float)((float)(llllllllllllllIIlIlIIllllIIlllII >> 16 & 0xFF) / 255.0f), (float)((float)(llllllllllllllIIlIlIIllllIIlllII >> 8 & 0xFF) / 255.0f), (float)((float)(llllllllllllllIIlIlIIllllIIlllII & 0xFF) / 255.0f), (float)llllllllllllllIIlIlIIllllIIlIIIl);
                } else if (llllllllllllllIIlIlIIllllIIllIll == 17) {
                    llllllllllllllIIlIlIIllllIIlIIII = true;
                    if (llllllllllllllIIlIlIIllllIIIllll) {
                        GlStateManager.bindTexture((int)llllllllllllllIIlIlIIllllIIIlIll.texItalicBold.getGlTextureId());
                        llllllllllllllIIlIlIIllllIIlIIlI = llllllllllllllIIlIlIIllllIIIlIll.boldItalicChars;
                    } else {
                        GlStateManager.bindTexture((int)llllllllllllllIIlIlIIllllIIIlIll.texBold.getGlTextureId());
                        llllllllllllllIIlIlIIllllIIlIIlI = llllllllllllllIIlIlIIllllIIIlIll.boldChars;
                    }
                } else if (llllllllllllllIIlIlIIllllIIllIll == 18) {
                    llllllllllllllIIlIlIIllllIIIlllI = true;
                } else if (llllllllllllllIIlIlIIllllIIllIll == 19) {
                    llllllllllllllIIlIlIIllllIIIllIl = true;
                } else if (llllllllllllllIIlIlIIllllIIllIll == 20) {
                    llllllllllllllIIlIlIIllllIIIllll = true;
                    if (llllllllllllllIIlIlIIllllIIlIIII) {
                        GlStateManager.bindTexture((int)llllllllllllllIIlIlIIllllIIIlIll.texItalicBold.getGlTextureId());
                        llllllllllllllIIlIlIIllllIIlIIlI = llllllllllllllIIlIlIIllllIIIlIll.boldItalicChars;
                    } else {
                        GlStateManager.bindTexture((int)llllllllllllllIIlIlIIllllIIIlIll.texItalic.getGlTextureId());
                        llllllllllllllIIlIlIIllllIIlIIlI = llllllllllllllIIlIlIIllllIIIlIll.italicChars;
                    }
                } else if (llllllllllllllIIlIlIIllllIIllIll == 21) {
                    llllllllllllllIIlIlIIllllIIlIIII = false;
                    llllllllllllllIIlIlIIllllIIIllll = false;
                    llllllllllllllIIlIlIIllllIIIllIl = false;
                    llllllllllllllIIlIlIIllllIIIlllI = false;
                    GlStateManager.color((float)((float)(llllllllllllllIIlIlIIllllIIIIlll >> 16 & 0xFF) / 255.0f), (float)((float)(llllllllllllllIIlIlIIllllIIIIlll >> 8 & 0xFF) / 255.0f), (float)((float)(llllllllllllllIIlIlIIllllIIIIlll & 0xFF) / 255.0f), (float)llllllllllllllIIlIlIIllllIIlIIIl);
                    GlStateManager.bindTexture((int)llllllllllllllIIlIlIIllllIIIlIll.tex.getGlTextureId());
                    llllllllllllllIIlIlIIllllIIlIIlI = llllllllllllllIIlIlIIllllIIIlIll.charData;
                }
                ++llllllllllllllIIlIlIIllllIIllIIl;
                continue;
            }
            if (llllllllllllllIIlIlIIllllIIllIlI >= llllllllllllllIIlIlIIllllIIlIIlI.length) continue;
            GL11.glBegin((int)4);
            llllllllllllllIIlIlIIllllIIIlIll.drawChar(llllllllllllllIIlIlIIllllIIlIIlI, llllllllllllllIIlIlIIllllIIllIlI, (float)llllllllllllllIIlIlIIllllIIlIllI, (float)llllllllllllllIIlIlIIllllIIlIlIl);
            GL11.glEnd();
            if (llllllllllllllIIlIlIIllllIIIlllI) {
                llllllllllllllIIlIlIIllllIIIlIll.drawLine(llllllllllllllIIlIlIIllllIIlIllI, llllllllllllllIIlIlIIllllIIlIlIl + (double)((float)llllllllllllllIIlIlIIllllIIlIIlI[llllllllllllllIIlIlIIllllIIllIlI].height / 2.0f), llllllllllllllIIlIlIIllllIIlIllI + (double)llllllllllllllIIlIlIIllllIIlIIlI[llllllllllllllIIlIlIIllllIIllIlI].width - 8.0, llllllllllllllIIlIlIIllllIIlIlIl + (double)((float)llllllllllllllIIlIlIIllllIIlIIlI[llllllllllllllIIlIlIIllllIIllIlI].height / 2.0f), 1.0f);
            }
            if (llllllllllllllIIlIlIIllllIIIllIl) {
                llllllllllllllIIlIlIIllllIIIlIll.drawLine(llllllllllllllIIlIlIIllllIIlIllI, llllllllllllllIIlIlIIllllIIlIlIl + (double)llllllllllllllIIlIlIIllllIIlIIlI[llllllllllllllIIlIlIIllllIIllIlI].height - 2.0, llllllllllllllIIlIlIIllllIIlIllI + (double)llllllllllllllIIlIlIIllllIIlIIlI[llllllllllllllIIlIlIIllllIIllIlI].width - 8.0, llllllllllllllIIlIlIIllllIIlIlIl + (double)llllllllllllllIIlIlIIllllIIlIIlI[llllllllllllllIIlIlIIllllIIllIlI].height - 2.0, 1.0f);
            }
            llllllllllllllIIlIlIIllllIIlIllI += (double)(llllllllllllllIIlIlIIllllIIlIIlI[llllllllllllllIIlIlIIllllIIllIlI].width - 8 + llllllllllllllIIlIlIIllllIIIlIll.charOffset);
        }
        GL11.glPopMatrix();
        return (float)llllllllllllllIIlIlIIllllIIlIllI / 2.0f;
    }

    public static String getFormatFromString(String llllllllllllllIIlIlIIllIllIlIllI) {
        String llllllllllllllIIlIlIIllIllIlIlIl = "";
        int llllllllllllllIIlIlIIllIllIlIlII = -1;
        int llllllllllllllIIlIlIIllIllIlIIll = llllllllllllllIIlIlIIllIllIlIllI.length();
        while ((llllllllllllllIIlIlIIllIllIlIlII = llllllllllllllIIlIlIIllIllIlIllI.indexOf(167, llllllllllllllIIlIlIIllIllIlIlII + 1)) != -1) {
            if (llllllllllllllIIlIlIIllIllIlIlII >= llllllllllllllIIlIlIIllIllIlIIll - 1) continue;
            char llllllllllllllIIlIlIIllIllIlIlll = llllllllllllllIIlIlIIllIllIlIllI.charAt(llllllllllllllIIlIlIIllIllIlIlII + 1);
            if (CFontRenderer.isFormatColor(llllllllllllllIIlIlIIllIllIlIlll)) {
                llllllllllllllIIlIlIIllIllIlIlIl = String.valueOf(new StringBuilder().append("\u00a7").append(llllllllllllllIIlIlIIllIllIlIlll));
                continue;
            }
            if (!CFontRenderer.isFormatSpecial(llllllllllllllIIlIlIIllIllIlIlll)) continue;
            llllllllllllllIIlIlIIllIllIlIlIl = String.valueOf(new StringBuilder().append(llllllllllllllIIlIlIIllIllIlIlIl).append("\u00a7").append(llllllllllllllIIlIlIIllIllIlIlll));
        }
        return llllllllllllllIIlIlIIllIllIlIlIl;
    }

    private float getCharWidthFloat(char llllllllllllllIIlIlIIllIlIlIIIlI) {
        CFontRenderer llllllllllllllIIlIlIIllIlIlIIlIl;
        if (llllllllllllllIIlIlIIllIlIlIIIlI == '\u00a7') {
            return -1.0f;
        }
        if (llllllllllllllIIlIlIIllIlIlIIIlI != ' ' && llllllllllllllIIlIlIIllIlIlIIIlI != '\u00a0') {
            int llllllllllllllIIlIlIIllIlIlIIllI = "\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8\u00a3\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1\u00aa\u00ba\u00bf\u00ae\u00ac\u00bd\u00bc\u00a1\u00ab\u00bb\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261\u00b1\u2265\u2264\u2320\u2321\u00f7\u2248\u00b0\u2219\u00b7\u221a\u207f\u00b2\u25a0\u0000".indexOf(llllllllllllllIIlIlIIllIlIlIIIlI);
            if (llllllllllllllIIlIlIIllIlIlIIIlI > '\u0000' && llllllllllllllIIlIlIIllIlIlIIllI != -1) {
                return llllllllllllllIIlIlIIllIlIlIIlIl.charWidthFloat[llllllllllllllIIlIlIIllIlIlIIllI];
            }
            if (llllllllllllllIIlIlIIllIlIlIIlIl.glyphWidth[llllllllllllllIIlIlIIllIlIlIIIlI] != 0) {
                int llllllllllllllIIlIlIIllIlIlIlIIl = llllllllllllllIIlIlIIllIlIlIIlIl.glyphWidth[llllllllllllllIIlIlIIllIlIlIIIlI] & 0xFF;
                int llllllllllllllIIlIlIIllIlIlIlIII = llllllllllllllIIlIlIIllIlIlIlIIl >>> 4;
                int llllllllllllllIIlIlIIllIlIlIIlll = llllllllllllllIIlIlIIllIlIlIlIIl & 0xF;
                return (++llllllllllllllIIlIlIIllIlIlIIlll - llllllllllllllIIlIlIIllIlIlIlIII) / 2 + 1;
            }
            return 0.0f;
        }
        return llllllllllllllIIlIlIIllIlIlIIlIl.charWidthFloat[32];
    }

    public int drawPassword(String llllllllllllllIIlIlIlIIIIIllIIIl, double llllllllllllllIIlIlIlIIIIIllIIII, float llllllllllllllIIlIlIlIIIIIlIllll, int llllllllllllllIIlIlIlIIIIIlIlllI) {
        llllllllllllllIIlIlIlIIIIIllIIIl = llllllllllllllIIlIlIlIIIIIllIIIl.replaceAll("\u00c3\u201a", "");
        return 0;
    }

    String wrapFormattedStringToWidth(String llllllllllllllIIlIlIIllIlllIIllI, int llllllllllllllIIlIlIIllIlllIIIlI) {
        CFontRenderer llllllllllllllIIlIlIIllIlllIIlII;
        if (llllllllllllllIIlIlIIllIlllIIllI.length() <= 1) {
            return llllllllllllllIIlIlIIllIlllIIllI;
        }
        int llllllllllllllIIlIlIIllIlllIlIII = llllllllllllllIIlIlIIllIlllIIlII.sizeStringToWidth(llllllllllllllIIlIlIIllIlllIIllI, llllllllllllllIIlIlIIllIlllIIIlI);
        if (llllllllllllllIIlIlIIllIlllIIllI.length() <= llllllllllllllIIlIlIIllIlllIlIII) {
            return llllllllllllllIIlIlIIllIlllIIllI;
        }
        String llllllllllllllIIlIlIIllIlllIllII = llllllllllllllIIlIlIIllIlllIIllI.substring(0, llllllllllllllIIlIlIIllIlllIlIII);
        char llllllllllllllIIlIlIIllIlllIlIll = llllllllllllllIIlIlIIllIlllIIllI.charAt(llllllllllllllIIlIlIIllIlllIlIII);
        boolean llllllllllllllIIlIlIIllIlllIlIlI = llllllllllllllIIlIlIIllIlllIlIll == ' ' || llllllllllllllIIlIlIIllIlllIlIll == '\n';
        String llllllllllllllIIlIlIIllIlllIlIIl = String.valueOf(new StringBuilder().append(CFontRenderer.getFormatFromString(llllllllllllllIIlIlIIllIlllIllII)).append(llllllllllllllIIlIlIIllIlllIIllI.substring(llllllllllllllIIlIlIIllIlllIlIII + (llllllllllllllIIlIlIIllIlllIlIlI ? 1 : 0))));
        return String.valueOf(new StringBuilder().append(llllllllllllllIIlIlIIllIlllIllII).append("\n").append(llllllllllllllIIlIlIIllIlllIIlII.wrapFormattedStringToWidth(llllllllllllllIIlIlIIllIlllIlIIl, llllllllllllllIIlIlIIllIlllIIIlI)));
    }

    private int sizeStringToWidth(String llllllllllllllIIlIlIIllIlIlllIII, int llllllllllllllIIlIlIIllIlIlllllI) {
        int llllllllllllllIIlIlIIllIlIlllIll;
        int llllllllllllllIIlIlIIllIlIllllIl = llllllllllllllIIlIlIIllIlIlllIII.length();
        float llllllllllllllIIlIlIIllIlIllllII = 0.0f;
        int llllllllllllllIIlIlIIllIlIlllIlI = -1;
        boolean llllllllllllllIIlIlIIllIllIIIIIl = false;
        for (llllllllllllllIIlIlIIllIlIlllIll = 0; llllllllllllllIIlIlIIllIlIlllIll < llllllllllllllIIlIlIIllIlIllllIl; ++llllllllllllllIIlIlIIllIlIlllIll) {
            char llllllllllllllIIlIlIIllIllIIIIlI = llllllllllllllIIlIlIIllIlIlllIII.charAt(llllllllllllllIIlIlIIllIlIlllIll);
            switch (llllllllllllllIIlIlIIllIllIIIIlI) {
                case '\n': {
                    --llllllllllllllIIlIlIIllIlIlllIll;
                    break;
                }
                case ' ': {
                    llllllllllllllIIlIlIIllIlIlllIlI = llllllllllllllIIlIlIIllIlIlllIll;
                }
                default: {
                    CFontRenderer llllllllllllllIIlIlIIllIllIIIIII;
                    llllllllllllllIIlIlIIllIlIllllII += llllllllllllllIIlIlIIllIllIIIIII.getCharWidthFloat(llllllllllllllIIlIlIIllIllIIIIlI);
                    if (!llllllllllllllIIlIlIIllIllIIIIIl) break;
                    llllllllllllllIIlIlIIllIlIllllII += 1.0f;
                    break;
                }
                case '\u00a7': {
                    char llllllllllllllIIlIlIIllIllIIIIll;
                    if (llllllllllllllIIlIlIIllIlIlllIll >= llllllllllllllIIlIlIIllIlIllllIl - 1) break;
                    if ((llllllllllllllIIlIlIIllIllIIIIll = llllllllllllllIIlIlIIllIlIlllIII.charAt(++llllllllllllllIIlIlIIllIlIlllIll)) != 'l' && llllllllllllllIIlIlIIllIllIIIIll != 'L') {
                        if (llllllllllllllIIlIlIIllIllIIIIll != 'r' && llllllllllllllIIlIlIIllIllIIIIll != 'R' && !CFontRenderer.isFormatColor(llllllllllllllIIlIlIIllIllIIIIll)) break;
                        llllllllllllllIIlIlIIllIllIIIIIl = false;
                        break;
                    }
                    llllllllllllllIIlIlIIllIllIIIIIl = true;
                }
            }
            if (llllllllllllllIIlIlIIllIllIIIIlI == '\n') {
                llllllllllllllIIlIlIIllIlIlllIlI = ++llllllllllllllIIlIlIIllIlIlllIll;
                break;
            }
            if (Math.round(llllllllllllllIIlIlIIllIlIllllII) > llllllllllllllIIlIlIIllIlIlllllI) break;
        }
        return llllllllllllllIIlIlIIllIlIlllIll != llllllllllllllIIlIlIIllIlIllllIl && llllllllllllllIIlIlIIllIlIlllIlI != -1 && llllllllllllllIIlIlIIllIlIlllIlI < llllllllllllllIIlIlIIllIlIlllIll ? llllllllllllllIIlIlIIllIlIlllIlI : llllllllllllllIIlIlIIllIlIlllIll;
    }

    private void drawLine(double llllllllllllllIIlIlIIlllIlIIIIIl, double llllllllllllllIIlIlIIlllIlIIIIII, double llllllllllllllIIlIlIIlllIIlllIlI, double llllllllllllllIIlIlIIlllIIlllIIl, float llllllllllllllIIlIlIIlllIIlllIII) {
        GL11.glDisable((int)3553);
        GL11.glLineWidth((float)llllllllllllllIIlIlIIlllIIlllIII);
        GL11.glBegin((int)1);
        GL11.glVertex2d((double)llllllllllllllIIlIlIIlllIlIIIIIl, (double)llllllllllllllIIlIlIIlllIlIIIIII);
        GL11.glVertex2d((double)llllllllllllllIIlIlIIlllIIlllIlI, (double)llllllllllllllIIlIlIIlllIIlllIIl);
        GL11.glEnd();
        GL11.glEnable((int)3553);
    }

    public float drawNoBSString(String llllllllllllllIIlIlIlIIIIIllIlll, double llllllllllllllIIlIlIlIIIIIlllIll, float llllllllllllllIIlIlIlIIIIIlllIlI, int llllllllllllllIIlIlIlIIIIIllIlII) {
        CFontRenderer llllllllllllllIIlIlIlIIIIIllllIl;
        llllllllllllllIIlIlIlIIIIIllIlll = llllllllllllllIIlIlIlIIIIIllIlll.replaceAll("\u00c3\u201a", "");
        return llllllllllllllIIlIlIlIIIIIllllIl.drawString(llllllllllllllIIlIlIlIIIIIllIlll, llllllllllllllIIlIlIlIIIIIlllIll, llllllllllllllIIlIlIlIIIIIlllIlI, llllllllllllllIIlIlIlIIIIIllIlII, false);
    }

    public float drawStringWithShadow(String llllllllllllllIIlIlIlIIIIIIlllll, double llllllllllllllIIlIlIlIIIIIlIIlII, double llllllllllllllIIlIlIlIIIIIlIIIll, int llllllllllllllIIlIlIlIIIIIIlllII) {
        CFontRenderer llllllllllllllIIlIlIlIIIIIlIIIII;
        float llllllllllllllIIlIlIlIIIIIlIIIIl = llllllllllllllIIlIlIlIIIIIlIIIII.drawString(llllllllllllllIIlIlIlIIIIIIlllll, llllllllllllllIIlIlIlIIIIIlIIlII + 0.6, llllllllllllllIIlIlIlIIIIIlIIIll + 0.6, llllllllllllllIIlIlIlIIIIIIlllII, true);
        return Math.max(llllllllllllllIIlIlIlIIIIIlIIIIl, llllllllllllllIIlIlIlIIIIIlIIIII.drawString(llllllllllllllIIlIlIlIIIIIIlllll, llllllllllllllIIlIlIlIIIIIlIIlII, llllllllllllllIIlIlIlIIIIIlIIIll, llllllllllllllIIlIlIlIIIIIIlllII, false));
    }

    public float drawString(String llllllllllllllIIlIlIlIIIIIIlIlII, double llllllllllllllIIlIlIlIIIIIIlIIll, double llllllllllllllIIlIlIlIIIIIIlIIlI, int llllllllllllllIIlIlIlIIIIIIIllII) {
        CFontRenderer llllllllllllllIIlIlIlIIIIIIlIIII;
        return llllllllllllllIIlIlIlIIIIIIlIIII.drawString(llllllllllllllIIlIlIlIIIIIIlIlII, llllllllllllllIIlIlIlIIIIIIlIIll, llllllllllllllIIlIlIlIIIIIIlIIlI, llllllllllllllIIlIlIlIIIIIIIllII, false);
    }

    private void setupMinecraftColorcodes() {
        for (int llllllllllllllIIlIlIIllIIllIIllI = 0; llllllllllllllIIlIlIIllIIllIIllI < 32; ++llllllllllllllIIlIlIIllIIllIIllI) {
            int llllllllllllllIIlIlIIllIIllIlIlI = (llllllllllllllIIlIlIIllIIllIIllI >> 3 & 1) * 85;
            int llllllllllllllIIlIlIIllIIllIlIIl = (llllllllllllllIIlIlIIllIIllIIllI >> 2 & 1) * 170 + llllllllllllllIIlIlIIllIIllIlIlI;
            int llllllllllllllIIlIlIIllIIllIlIII = (llllllllllllllIIlIlIIllIIllIIllI >> 1 & 1) * 170 + llllllllllllllIIlIlIIllIIllIlIlI;
            int llllllllllllllIIlIlIIllIIllIIlll = (llllllllllllllIIlIlIIllIIllIIllI >> 0 & 1) * 170 + llllllllllllllIIlIlIIllIIllIlIlI;
            if (llllllllllllllIIlIlIIllIIllIIllI == 6) {
                llllllllllllllIIlIlIIllIIllIlIIl += 85;
            }
            if (llllllllllllllIIlIlIIllIIllIIllI >= 16) {
                llllllllllllllIIlIlIIllIIllIlIIl /= 4;
                llllllllllllllIIlIlIIllIIllIlIII /= 4;
                llllllllllllllIIlIlIIllIIllIIlll /= 4;
            }
            llllllllllllllIIlIlIIllIIllIIlII.colorCode[llllllllllllllIIlIlIIllIIllIIllI] = (llllllllllllllIIlIlIIllIIllIlIIl & 0xFF) << 16 | (llllllllllllllIIlIlIIllIIllIlIII & 0xFF) << 8 | llllllllllllllIIlIlIIllIIllIIlll & 0xFF;
        }
    }

    @Override
    public void setFractionalMetrics(boolean llllllllllllllIIlIlIIlllIlIIllIl) {
        CFontRenderer llllllllllllllIIlIlIIlllIlIIlllI;
        super.setFractionalMetrics(llllllllllllllIIlIlIIlllIlIIllIl);
        llllllllllllllIIlIlIIlllIlIIlllI.setupBoldItalicIDs();
    }

    public void drawStringWithOutline(String llllllllllllllIIlIlIlIIIIIIIIIII, double llllllllllllllIIlIlIlIIIIIIIIlII, double llllllllllllllIIlIlIlIIIIIIIIIll, int llllllllllllllIIlIlIlIIIIIIIIIlI) {
        CFontRenderer llllllllllllllIIlIlIlIIIIIIIIllI;
        llllllllllllllIIlIlIlIIIIIIIIllI.drawString(llllllllllllllIIlIlIlIIIIIIIIIII, llllllllllllllIIlIlIlIIIIIIIIlII - 0.5, llllllllllllllIIlIlIlIIIIIIIIIll - 0.5, ColorUtils.getColor(0, 0, 0), false);
        llllllllllllllIIlIlIlIIIIIIIIllI.drawString(llllllllllllllIIlIlIlIIIIIIIIIII, llllllllllllllIIlIlIlIIIIIIIIlII + 0.5, llllllllllllllIIlIlIlIIIIIIIIIll + 0.5, ColorUtils.getColor(0, 0, 0), false);
        llllllllllllllIIlIlIlIIIIIIIIllI.drawString(llllllllllllllIIlIlIlIIIIIIIIIII, llllllllllllllIIlIlIlIIIIIIIIlII + 0.5, llllllllllllllIIlIlIlIIIIIIIIIll, ColorUtils.getColor(0, 0, 0), false);
        llllllllllllllIIlIlIlIIIIIIIIllI.drawString(llllllllllllllIIlIlIlIIIIIIIIIII, llllllllllllllIIlIlIlIIIIIIIIlII, llllllllllllllIIlIlIlIIIIIIIIIll + 0.5, ColorUtils.getColor(0, 0, 0), false);
        llllllllllllllIIlIlIlIIIIIIIIllI.drawString(llllllllllllllIIlIlIlIIIIIIIIIII, llllllllllllllIIlIlIlIIIIIIIIlII - 0.5, llllllllllllllIIlIlIlIIIIIIIIIll, ColorUtils.getColor(0, 0, 0), false);
        llllllllllllllIIlIlIlIIIIIIIIllI.drawString(llllllllllllllIIlIlIlIIIIIIIIIII, llllllllllllllIIlIlIlIIIIIIIIlII, llllllllllllllIIlIlIlIIIIIIIIIll - 0.5, ColorUtils.getColor(0, 0, 0), false);
        llllllllllllllIIlIlIlIIIIIIIIllI.drawString(llllllllllllllIIlIlIlIIIIIIIIIII, llllllllllllllIIlIlIlIIIIIIIIlII, llllllllllllllIIlIlIlIIIIIIIIIll, llllllllllllllIIlIlIlIIIIIIIIIlI, false);
    }
}

