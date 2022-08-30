/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  org.lwjgl.opengl.GL11
 */
package ru.internali.utils;

import java.awt.Color;
import java.text.NumberFormat;
import java.util.Random;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.opengl.GL11;
import ru.internali.utils.MathUtils;

public class ColorUtils {
    public static int getAlpha(int llIIlIllllIlll) {
        return new Color(llIIlIllllIlll).getAlpha();
    }

    public static Color astolfoColorsToColorObj(int llIIllIIlIIIIl, int llIIllIIlIIIII, int llIIllIIIllIll) {
        int llIIllIIIllllI = ColorUtils.astolfoColors(llIIllIIlIIIIl, llIIllIIlIIIII);
        return new Color(ColorUtils.getRed(llIIllIIIllllI), ColorUtils.getGreen(llIIllIIIllllI), ColorUtils.getBlue(llIIllIIIllllI), llIIllIIIllIll);
    }

    public static int Yellowastolfo(int llIIlllIlIlIlI, float llIIlllIlIlIIl) {
        float f;
        float llIIlllIlIllII;
        float llIIlllIlIlIll = 2900.0f;
        for (llIIlllIlIllII = (float)(System.currentTimeMillis() % (long)((int)llIIlllIlIlIll)) + ((float)(-llIIlllIlIlIlI) - llIIlllIlIlIIl) * 9.0f; llIIlllIlIllII > llIIlllIlIlIll; llIIlllIlIllII -= llIIlllIlIlIll) {
        }
        llIIlllIlIllII /= llIIlllIlIlIll;
        if ((double)f > 0.6) {
            llIIlllIlIllII = 0.6f - (llIIlllIlIllII - 0.6f);
        }
        return Color.HSBtoRGB(llIIlllIlIllII += 0.6f, 0.5f, 1.0f);
    }

    public static void setColor(int llIlIIlIlIIlIl) {
        GlStateManager.color((float)((float)(llIlIIlIlIIlIl >> 16 & 0xFF) / 255.0f), (float)((float)(llIlIIlIlIIlIl >> 8 & 0xFF) / 255.0f), (float)((float)(llIlIIlIlIIlIl & 0xFF) / 255.0f), (float)((float)(llIlIIlIlIIlIl >> 24 & 0xFF) / 255.0f));
    }

    public static Color rainbowRGB(int llIIlIlllIllll, float llIIlIllllIIIl, float llIIlIllllIIII) {
        return new Color(ColorUtils.getRed(Color.HSBtoRGB((float)((System.currentTimeMillis() + (long)llIIlIlllIllll) % 11520L) / 11520.0f, llIIlIllllIIIl, llIIlIllllIIII)), ColorUtils.getGreen(Color.HSBtoRGB((float)((System.currentTimeMillis() + (long)llIIlIlllIllll) % 11520L) / 11520.0f, llIIlIllllIIIl, llIIlIllllIIII)), ColorUtils.getBlue(Color.HSBtoRGB((float)((System.currentTimeMillis() + (long)llIIlIlllIllll) % 11520L) / 11520.0f, llIIlIllllIIIl, llIIlIllllIIII)));
    }

    public static int getAstolfoRainbow(int llIIllIIllIlII) {
        float llIIllIIllIlIl;
        float llIIllIIllIllI = 2900.0f;
        for (llIIllIIllIlIl = (float)(System.currentTimeMillis() % (long)((int)llIIllIIllIllI)) + (float)((1000 - llIIllIIllIlII) * 9); llIIllIIllIlIl > llIIllIIllIllI; llIIllIIllIlIl -= llIIllIIllIllI) {
        }
        if ((double)(llIIllIIllIlIl /= llIIllIIllIllI) > 0.5) {
            llIIllIIllIlIl = 0.5f - (llIIllIIllIlIl - 0.5f);
        }
        return Color.HSBtoRGB(llIIllIIllIlIl += 0.5f, 0.65f, 1.0f);
    }

    public static int rainbow(int llIlIIlIIlIIIl, long llIlIIlIIlIIII) {
        double llIlIIlIIIllll = Math.ceil(System.currentTimeMillis() + llIlIIlIIlIIII + (long)llIlIIlIIlIIIl) / 15.0;
        return Color.getHSBColor((float)((llIlIIlIIIllll %= 360.0) / 360.0), 0.4f, 1.0f).getRGB();
    }

    public static int getRed(int llIIllIIIIIIII) {
        return new Color(llIIllIIIIIIII).getRed();
    }

    public static int rainbowLT(int llIIllIIIIllIl, long llIIllIIIIllll) {
        double llIIllIIIIlllI = Math.ceil(System.currentTimeMillis() + llIIllIIIIllll + (long)llIIllIIIIllIl) / 3.0;
        return Color.getHSBColor((float)((llIIllIIIIlllI %= 248.0) / 248.0), 0.5f, 0.6f).getRGB();
    }

    public static Color getGradientOffset(Color llIlIIIlIllIII, Color llIlIIIlIlIIII, double llIlIIIlIIllll) {
        if (llIlIIIlIIllll > 1.0) {
            double llIlIIIlIllIlI = llIlIIIlIIllll % 1.0;
            int llIlIIIlIllIIl = (int)llIlIIIlIIllll;
            llIlIIIlIIllll = llIlIIIlIllIIl % 2 == 0 ? llIlIIIlIllIlI : 1.0 - llIlIIIlIllIlI;
        }
        double llIlIIIlIlIlIl = 1.0 - llIlIIIlIIllll;
        int llIlIIIlIlIlII = (int)((double)llIlIIIlIllIII.getRed() * llIlIIIlIlIlIl + (double)llIlIIIlIlIIII.getRed() * llIlIIIlIIllll);
        int llIlIIIlIlIIll = (int)((double)llIlIIIlIllIII.getGreen() * llIlIIIlIlIlIl + (double)llIlIIIlIlIIII.getGreen() * llIlIIIlIIllll);
        int llIlIIIlIlIIlI = (int)((double)llIlIIIlIllIII.getBlue() * llIlIIIlIlIlIl + (double)llIlIIIlIlIIII.getBlue() * llIlIIIlIIllll);
        return new Color(llIlIIIlIlIlII, llIlIIIlIlIIll, llIlIIIlIlIIlI);
    }

    public static int astolfo(int llIIlllIlllIlI, float llIIlllIllIlIl) {
        float f;
        float llIIlllIlllIII;
        float llIIlllIllIlll = 3000.0f;
        for (llIIlllIlllIII = Math.abs((float)(System.currentTimeMillis() % (long)llIIlllIlllIlI) + -llIIlllIllIlIl / 21.0f * 2.0f); llIIlllIlllIII > llIIlllIllIlll; llIIlllIlllIII -= llIIlllIllIlll) {
        }
        llIIlllIlllIII /= llIIlllIllIlll;
        if ((double)f > 0.5) {
            llIIlllIlllIII = 0.5f - (llIIlllIlllIII - 0.5f);
        }
        return Color.HSBtoRGB(llIIlllIlllIII += 0.5f, 0.5f, 1.0f);
    }

    public static int reAlpha(int llIlIIIllIllIl, float llIlIIIllIllII) {
        Color llIlIIIllIlIll = new Color(llIlIIIllIllIl);
        float llIlIIIllIlIlI = 0.003921569f * (float)llIlIIIllIlIll.getRed();
        float llIlIIIllIlIIl = 0.003921569f * (float)llIlIIIllIlIll.getGreen();
        float llIlIIIllIlIII = 0.003921569f * (float)llIlIIIllIlIll.getBlue();
        return new Color(llIlIIIllIlIlI, llIlIIIllIlIIl, llIlIIIllIlIII, llIlIIIllIllII).getRGB();
    }

    public static int getColor(int llIlIIIlIIIIIl, int llIlIIIlIIIIll, int llIlIIIIllllll) {
        return ColorUtils.getColor(llIlIIIlIIIIIl, llIlIIIlIIIIll, llIlIIIIllllll, 255);
    }

    public ColorUtils() {
        ColorUtils llIlIIlIllllll;
    }

    public static void setColor(float llIlIIlIlIllIl, float llIlIIlIllIIII, float llIlIIlIlIllll, float llIlIIlIlIlllI) {
        GlStateManager.color((float)llIlIIlIlIllIl, (float)llIlIIlIllIIII, (float)llIlIIlIlIllll, (float)llIlIIlIlIlllI);
    }

    public static Color TwoColoreffect(Color llIIlllIIlIIII, Color llIIlllIIlIlII, double llIIlllIIIlllI) {
        double llIIlllIIlIIlI = llIIlllIIIlllI / 4.0 % 1.0;
        float llIIlllIIlIIIl = MathUtils.clamp((float)Math.sin(Math.PI * 6 * llIIlllIIlIIlI) / 2.0f + 0.5f, 0.0f, 1.0f);
        return new Color(MathUtils.lerp((float)llIIlllIIlIIII.getRed() / 255.0f, (float)llIIlllIIlIlII.getRed() / 255.0f, llIIlllIIlIIIl), MathUtils.lerp((float)llIIlllIIlIIII.getGreen() / 255.0f, (float)llIIlllIIlIlII.getGreen() / 255.0f, llIIlllIIlIIIl), MathUtils.lerp((float)llIIlllIIlIIII.getBlue() / 255.0f, (float)llIIlllIIlIlII.getBlue() / 255.0f, llIIlllIIlIIIl));
    }

    public static void setColor(Color llIlIIlIlIIlll) {
        GlStateManager.color((float)((float)llIlIIlIlIIlll.getRed() / 255.0f), (float)((float)llIlIIlIlIIlll.getGreen() / 255.0f), (float)((float)llIlIIlIlIIlll.getBlue() / 255.0f), (float)((float)llIlIIlIlIIlll.getAlpha() / 255.0f));
    }

    public static int[] getFractionIndicies(float[] llIIlllllIllII, float llIIlllllIlIll) {
        int llIIlllllIlIlI;
        int[] llIIlllllIlIIl = new int[2];
        for (llIIlllllIlIlI = 0; llIIlllllIlIlI < llIIlllllIllII.length && llIIlllllIllII[llIIlllllIlIlI] <= llIIlllllIlIll; ++llIIlllllIlIlI) {
        }
        if (llIIlllllIlIlI >= llIIlllllIllII.length) {
            llIIlllllIlIlI = llIIlllllIllII.length - 1;
        }
        llIIlllllIlIIl[0] = llIIlllllIlIlI - 1;
        llIIlllllIlIIl[1] = llIIlllllIlIlI;
        return llIIlllllIlIIl;
    }

    public static Color fade(Color llIlIIIIIlllll, int llIlIIIIIllllI, int llIlIIIIIlllIl) {
        float[] llIlIIIIlIIIIl = new float[3];
        Color.RGBtoHSB(llIlIIIIIlllll.getRed(), llIlIIIIIlllll.getGreen(), llIlIIIIIlllll.getBlue(), llIlIIIIlIIIIl);
        float llIlIIIIlIIIII = Math.abs(((float)(System.currentTimeMillis() % 2000L) / 1000.0f + (float)llIlIIIIIllllI / (float)llIlIIIIIlllIl * 2.0f) % 2.0f - 1.0f);
        llIlIIIIlIIIII = 0.5f + 0.5f * llIlIIIIlIIIII;
        llIlIIIIlIIIIl[2] = llIlIIIIlIIIII % 2.0f;
        return new Color(Color.HSBtoRGB(llIlIIIIlIIIIl[0], llIlIIIIlIIIIl[1], llIlIIIIlIIIIl[2]));
    }

    public static int color(int llIlIIlIIIIlII, int llIlIIIlllllll, int llIlIIlIIIIIlI, int llIlIIIlllllIl) {
        llIlIIIlllllIl = 255;
        return new Color(llIlIIlIIIIlII, llIlIIIlllllll, llIlIIlIIIIIlI, llIlIIIlllllIl).getRGB();
    }

    public static Color injectAlpha(int llIIlIlllIIIIl, int llIIlIlllIIIII) {
        return new Color(ColorUtils.getRed(llIIlIlllIIIIl), ColorUtils.getGreen(llIIlIlllIIIIl), ColorUtils.getBlue(llIIlIlllIIIIl), llIIlIlllIIIII);
    }

    public static Color astolfoColorsToColorObj(int llIIllIIIlIlIl, int llIIllIIIlIlII) {
        return ColorUtils.astolfoColorsToColorObj(llIIllIIIlIlIl, llIIllIIIlIlII, 255);
    }

    public static int getGreen(int llIIlIllllllII) {
        return new Color(llIIlIllllllII).getGreen();
    }

    public static void glColor(int llIlIIlIIllllI, int llIlIIlIIlllIl) {
        float llIlIIlIIlllII = (float)(llIlIIlIIllllI >> 16 & 0xFF) / 255.0f;
        float llIlIIlIIllIll = (float)(llIlIIlIIllllI >> 8 & 0xFF) / 255.0f;
        float llIlIIlIIllIlI = (float)(llIlIIlIIllllI & 0xFF) / 255.0f;
        GlStateManager.color((float)llIlIIlIIlllII, (float)llIlIIlIIllIll, (float)llIlIIlIIllIlI, (float)((float)llIlIIlIIlllIl / 255.0f));
    }

    public static void glColor(Color llIIlIllIlllII) {
        GL11.glColor4f((float)((float)llIIlIllIlllII.getRed() / 255.0f), (float)((float)llIIlIllIlllII.getGreen() / 255.0f), (float)((float)llIIlIllIlllII.getBlue() / 255.0f), (float)((float)llIIlIllIlllII.getAlpha() / 255.0f));
    }

    public static Color blend(Color llIIllllIlIllI, Color llIIllllIIlIlI, double llIIllllIIlIIl) {
        float llIIllllIlIIll = (float)llIIllllIIlIIl;
        float llIIllllIlIIlI = 1.0f - llIIllllIlIIll;
        float[] llIIllllIlIIIl = new float[3];
        float[] llIIllllIlIIII = new float[3];
        llIIllllIlIllI.getColorComponents(llIIllllIlIIIl);
        llIIllllIIlIlI.getColorComponents(llIIllllIlIIII);
        float llIIllllIIllll = llIIllllIlIIIl[0] * llIIllllIlIIll + llIIllllIlIIII[0] * llIIllllIlIIlI;
        float llIIllllIIlllI = llIIllllIlIIIl[1] * llIIllllIlIIll + llIIllllIlIIII[1] * llIIllllIlIIlI;
        float llIIllllIIllIl = llIIllllIlIIIl[2] * llIIllllIlIIll + llIIllllIlIIII[2] * llIIllllIlIIlI;
        if (llIIllllIIllll < 0.0f) {
            llIIllllIIllll = 0.0f;
        } else if (llIIllllIIllll > 255.0f) {
            llIIllllIIllll = 255.0f;
        }
        if (llIIllllIIlllI < 0.0f) {
            llIIllllIIlllI = 0.0f;
        } else if (llIIllllIIlllI > 255.0f) {
            llIIllllIIlllI = 255.0f;
        }
        if (llIIllllIIllIl < 0.0f) {
            llIIllllIIllIl = 0.0f;
        } else if (llIIllllIIllIl > 255.0f) {
            llIIllllIIllIl = 255.0f;
        }
        Color llIIllllIIllII = null;
        try {
            llIIllllIIllII = new Color(llIIllllIIllll, llIIllllIIlllI, llIIllllIIllIl);
        }
        catch (IllegalArgumentException llIIllllIlIlll) {
            NumberFormat llIIlllIllllll = NumberFormat.getNumberInstance();
        }
        return llIIllllIIllII;
    }

    public static int getColor(int llIlIIIIlllIIl, int llIlIIIIllIIll, int llIlIIIIllIlll, int llIlIIIIllIllI) {
        int llIlIIIIllIlIl = 0;
        llIlIIIIllIlIl |= llIlIIIIllIllI << 24;
        llIlIIIIllIlIl |= llIlIIIIlllIIl << 16;
        llIlIIIIllIlIl |= llIlIIIIllIIll << 8;
        return llIlIIIIllIlIl |= llIlIIIIllIlll;
    }

    public static int getColor1(int llIlIIIlIIlIII) {
        return ColorUtils.getColor(llIlIIIlIIlIII, llIlIIIlIIlIII, llIlIIIlIIlIII, 255);
    }

    public static int getRandomColor() {
        char[] llIlIIIllllIII = "012345678".toCharArray();
        String llIlIIIlllIlll = "0x";
        for (int llIlIIIllllIIl = 0; llIlIIIllllIIl < 6; ++llIlIIIllllIIl) {
            llIlIIIlllIlll = String.valueOf(new StringBuilder().append(llIlIIIlllIlll).append(llIlIIIllllIII[new Random().nextInt(llIlIIIllllIII.length)]));
        }
        return Integer.decode(llIlIIIlllIlll);
    }

    public static Color rainbow() {
        long llIIllIIlIllIl = 999999999999L;
        float llIIllIIlIllII = (float)(System.nanoTime() + llIIllIIlIllIl) / 1.0E10f % 1.0f;
        long llIIllIIlIlIll = Long.parseLong(Integer.toHexString(Color.HSBtoRGB(llIIllIIlIllII, 1.0f, 1.0f)), 16);
        Color llIIllIIlIlIlI = new Color((int)llIIllIIlIlIll);
        return new Color((float)llIIllIIlIlIlI.getRed() / 255.0f, (float)llIIllIIlIlIlI.getGreen() / 255.0f, (float)llIIllIIlIlIlI.getBlue() / 255.0f, (float)llIIllIIlIlIlI.getAlpha() / 255.0f);
    }

    public static Color blendColors(float[] llIIlllllllIIl, Color[] llIlIIIIIIIIIl, float llIIllllllIlll) {
        if (llIIlllllllIIl == null) {
            throw new IllegalArgumentException("Fractions can't be null");
        }
        if (llIlIIIIIIIIIl == null) {
            throw new IllegalArgumentException("Colours can't be null");
        }
        if (llIIlllllllIIl.length != llIlIIIIIIIIIl.length) {
            throw new IllegalArgumentException("Fractions and colours must have equal number of elements");
        }
        int[] llIIllllllllll = ColorUtils.getFractionIndicies(llIIlllllllIIl, llIIllllllIlll);
        float[] llIIlllllllllI = new float[]{llIIlllllllIIl[llIIllllllllll[0]], llIIlllllllIIl[llIIllllllllll[1]]};
        Color[] llIIllllllllIl = new Color[]{llIlIIIIIIIIIl[llIIllllllllll[0]], llIlIIIIIIIIIl[llIIllllllllll[1]]};
        float llIIllllllllII = llIIlllllllllI[1] - llIIlllllllllI[0];
        float llIIlllllllIll = llIIllllllIlll - llIIlllllllllI[0];
        float llIIlllllllIlI = llIIlllllllIll / llIIllllllllII;
        return ColorUtils.blend(llIIllllllllIl[0], llIIllllllllIl[1], 1.0f - llIIlllllllIlI);
    }

    public static int rainbowNew(int llIIllIlIlllIl, float llIIllIlIlllII, float llIIllIlIllIll) {
        double llIIllIlIllIlI = Math.ceil((System.currentTimeMillis() + (long)llIIllIlIlllIl) / 16L);
        return Color.getHSBColor((float)((llIIllIlIllIlI %= 360.0) / 360.0), llIIllIlIlllII, llIIllIlIllIll).getRGB();
    }

    public static int getColor(int llIIlIlllIlIlI) {
        return ColorUtils.getColor(llIIlIlllIlIlI, llIIlIlllIlIlI, llIIlIlllIlIlI, 255);
    }

    public static Color astolfoColors1(int llIIllIlllIlIl, int llIIllIlllIIII) {
        float f;
        float llIIllIlllIIll;
        float llIIllIlllIIlI = 2900.0f;
        for (llIIllIlllIIll = (float)(System.currentTimeMillis() % (long)((int)llIIllIlllIIlI)) + (float)((llIIllIlllIIII - llIIllIlllIlIl) * 9); llIIllIlllIIll > llIIllIlllIIlI; llIIllIlllIIll -= llIIllIlllIIlI) {
        }
        llIIllIlllIIll /= llIIllIlllIIlI;
        if ((double)f > 0.5) {
            llIIllIlllIIll = 0.5f - (llIIllIlllIIll - 0.5f);
        }
        return new Color(llIIllIlllIIll += 0.5f, 0.5f, 1.0f);
    }

    public static Color getColorWithOpacity(Color llIlIIlIlllIIl, int llIlIIlIllIllI) {
        return new Color(llIlIIlIlllIIl.getRed(), llIlIIlIlllIIl.getGreen(), llIlIIlIlllIIl.getBlue(), llIlIIlIllIllI);
    }

    public static int getColor(Color llIlIIlIllllII) {
        return ColorUtils.getColor(llIlIIlIllllII.getRed(), llIlIIlIllllII.getGreen(), llIlIIlIllllII.getBlue(), llIlIIlIllllII.getAlpha());
    }

    public static Color rainbowCol(int llIIllIllIlIIl, float llIIllIllIIlII, float llIIllIllIIIll) {
        double llIIllIllIIllI = Math.ceil((System.currentTimeMillis() + (long)llIIllIllIlIIl) / 16L);
        return Color.getHSBColor((float)((llIIllIllIIllI %= 360.0) / 360.0), llIIllIllIIlII, llIIllIllIIIll);
    }

    public static int astolfoColors(int llIIlllIIIIIll, int llIIlllIIIIllI) {
        float f;
        float llIIlllIIIIlIl;
        float llIIlllIIIIlII = 2900.0f;
        for (llIIlllIIIIlIl = (float)(System.currentTimeMillis() % (long)((int)llIIlllIIIIlII)) + (float)((llIIlllIIIIllI - llIIlllIIIIIll) * 9); llIIlllIIIIlIl > llIIlllIIIIlII; llIIlllIIIIlIl -= llIIlllIIIIlII) {
        }
        llIIlllIIIIlIl /= llIIlllIIIIlII;
        if ((double)f > 0.5) {
            llIIlllIIIIlIl = 0.5f - (llIIlllIIIIlIl - 0.5f);
        }
        return Color.HSBtoRGB(llIIlllIIIIlIl += 0.5f, 0.5f, 1.0f);
    }

    public static int getColor(int llIlIIIIlIlIll, int llIlIIIIlIllII) {
        return ColorUtils.getColor(llIlIIIIlIlIll, llIlIIIIlIlIll, llIlIIIIlIlIll, llIlIIIIlIllII);
    }

    public static int TwoColoreffect(int llIIllIlIIIIll, int llIIllIlIIlIll, int llIIllIlIIIIIl, int llIIllIlIIIIII, int llIIllIlIIlIII, int llIIllIIlllllI, double llIIllIlIIIllI) {
        double llIIllIlIIIlIl = llIIllIlIIIllI / 4.0 % 1.0;
        float llIIllIlIIIlII = MathUtils.clamp((float)Math.sin(Math.PI * 6 * llIIllIlIIIlIl) / 2.0f + 0.5f, 0.0f, 1.0f);
        return ColorUtils.getColor((int)MathUtils.lerp(llIIllIlIIIIll, llIIllIlIIIIII, llIIllIlIIIlII), (int)MathUtils.lerp(llIIllIlIIlIll, llIIllIlIIlIII, llIIllIlIIIlII), (int)MathUtils.lerp(llIIllIlIIIIIl, llIIllIIlllllI, llIIllIlIIIlII));
    }

    public static Color getHealthColor(EntityLivingBase llIlIIIIIlIIII) {
        float llIlIIIIIlIlII = llIlIIIIIlIIII.getHealth();
        float[] llIlIIIIIlIIll = new float[]{0.0f, 0.15f, 0.55f, 0.7f, 0.9f};
        Color[] llIlIIIIIlIIlI = new Color[]{new Color(133, 0, 0), Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN};
        float llIlIIIIIlIIIl = llIlIIIIIlIlII / llIlIIIIIlIIII.getMaxHealth();
        return llIlIIIIIlIlII >= 0.0f ? ColorUtils.blendColors(llIlIIIIIlIIll, llIlIIIIIlIIlI, llIlIIIIIlIIIl).brighter() : llIlIIIIIlIIlI[0];
    }

    public static Color fade(Color llIlIIlIIIlIlI) {
        return ColorUtils.fade(llIlIIlIIIlIlI, 2, 100);
    }

    public static Color Yellowastolfo1(int llIIlllIlIIIlI, float llIIlllIlIIIIl) {
        float f;
        float llIIlllIlIIIII;
        float llIIlllIIlllll = 2900.0f;
        for (llIIlllIlIIIII = (float)(System.currentTimeMillis() % (long)((int)llIIlllIIlllll)) + ((float)llIIlllIlIIIlI - llIIlllIlIIIIl) * 9.0f; llIIlllIlIIIII > llIIlllIIlllll; llIIlllIlIIIII -= llIIlllIIlllll) {
        }
        llIIlllIlIIIII /= llIIlllIIlllll;
        if ((double)f > 0.6) {
            llIIlllIlIIIII = 0.6f - (llIIlllIlIIIII - 0.6f);
        }
        return new Color(llIIlllIlIIIII += 0.6f, 0.5f, 1.0f);
    }

    public static Color injectAlpha(Color llIIlIlllIIlll, int llIIlIlllIIllI) {
        return new Color(llIIlIlllIIlll.getRed(), llIIlIlllIIlll.getGreen(), llIIlIlllIIlll.getBlue(), llIIlIlllIIllI);
    }

    public static Color rainbow(int llIIllIIIIIlII, float llIIllIIIIIIll, float llIIllIIIIIlIl) {
        return Color.getHSBColor((float)((System.currentTimeMillis() + (long)llIIllIIIIIlII) % 11520L) / 11520.0f, llIIllIIIIIIll, llIIllIIIIIlIl);
    }

    public static int getBlue(int llIIlIlllllIIl) {
        return new Color(llIIlIlllllIIl).getBlue();
    }

    public static int getTeamColor(Entity llIIllIllllIll) {
        int llIIllIlllllII = -1;
        llIIllIlllllII = llIIllIllllIll.getDisplayName().getUnformattedText().equalsIgnoreCase(String.valueOf(new StringBuilder().append("\u043f\u0457\u0405f[\u043f\u0457\u0405cR\u043f\u0457\u0405f]\u043f\u0457\u0405c").append(llIIllIllllIll.getName()))) ? ColorUtils.getColor(new Color(255, 60, 60)) : (llIIllIllllIll.getDisplayName().getUnformattedText().equalsIgnoreCase(String.valueOf(new StringBuilder().append("\u043f\u0457\u0405f[\u043f\u0457\u04059B\u043f\u0457\u0405f]\u043f\u0457\u04059").append(llIIllIllllIll.getName()))) ? ColorUtils.getColor(new Color(60, 60, 255)) : (llIIllIllllIll.getDisplayName().getUnformattedText().equalsIgnoreCase(String.valueOf(new StringBuilder().append("\u043f\u0457\u0405f[\u043f\u0457\u0405eY\u043f\u0457\u0405f]\u043f\u0457\u0405e").append(llIIllIllllIll.getName()))) ? ColorUtils.getColor(new Color(255, 255, 60)) : (llIIllIllllIll.getDisplayName().getUnformattedText().equalsIgnoreCase(String.valueOf(new StringBuilder().append("\u043f\u0457\u0405f[\u043f\u0457\u0405aG\u043f\u0457\u0405f]\u043f\u0457\u0405a").append(llIIllIllllIll.getName()))) ? ColorUtils.getColor(new Color(60, 255, 60)) : ColorUtils.getColor(new Color(255, 255, 255)))));
        return llIIllIlllllII;
    }
}

