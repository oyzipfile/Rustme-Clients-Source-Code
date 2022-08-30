/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.module.render;

import java.awt.Color;

public class ColorUtil {
    public static int RGBtoHex(int llIIlIIlIIIIl, int llIIlIIIlllIl, int llIIlIIIlllII) {
        return llIIlIIlIIIIl << 16 | llIIlIIIlllIl << 8 | llIIlIIIlllII;
    }

    public static int toRGBA(float[] llIIIllllllll) {
        if (llIIIllllllll.length != 4) {
            throw new IllegalArgumentException("colors[] must have a length of 4!");
        }
        return ColorUtil.toRGBA(llIIIllllllll[0], llIIIllllllll[1], llIIIllllllll[2], llIIIllllllll[3]);
    }

    public static int toARGB(int llIIlIlIIlIIl, int llIIlIlIIllII, int llIIlIlIIIlll, int llIIlIlIIlIlI) {
        return new Color(llIIlIlIIlIIl, llIIlIlIIllII, llIIlIlIIIlll, llIIlIlIIlIlI).getRGB();
    }

    public static int toRGBA(int llIIlIIllllll, int llIIlIlIIIIIl, int llIIlIIllllIl) {
        return ColorUtil.toRGBA(llIIlIIllllll, llIIlIlIIIIIl, llIIlIIllllIl, 255);
    }

    public static int toRGBA(Color llIIIlllllIII) {
        return ColorUtil.toRGBA(llIIIlllllIII.getRed(), llIIIlllllIII.getGreen(), llIIIlllllIII.getBlue(), llIIIlllllIII.getAlpha());
    }

    public static int toRGBA(int llIIlIIllIlII, int llIIlIIllIIll, int llIIlIIllIIlI, int llIIlIIllIIIl) {
        return (llIIlIIllIlII << 16) + (llIIlIIllIIll << 8) + llIIlIIllIIlI + (llIIlIIllIIIl << 24);
    }

    public ColorUtil() {
        ColorUtil llIIlIlIlIIlI;
    }

    public static int[] getRainbow(int llIIlIIIIlIIl, float llIIlIIIlIIIl) {
        int llIIlIIIlIIII = 0;
        int llIIlIIIIllll = 0;
        int llIIlIIIIlllI = 0;
        long llIIlIIIIllIl = (System.currentTimeMillis() - (long)Math.round(llIIlIIIlIIIl * 1000.0f)) % (long)(llIIlIIIIlIIl * 1000);
        float llIIlIIIIllII = 6.0f * (float)llIIlIIIIllIl / (float)(llIIlIIIIlIIl * 1000);
        float llIIlIIIIlIll = llIIlIIIIllII - (float)Math.floor(llIIlIIIIllII);
        int llIIlIIIIlIlI = Math.round(255.0f * llIIlIIIIlIll);
        if (llIIlIIIIllII < 1.0f) {
            llIIlIIIlIIII = 255;
            llIIlIIIIllll = llIIlIIIIlIlI;
        } else if (llIIlIIIIllII < 2.0f) {
            llIIlIIIlIIII = 255 - llIIlIIIIlIlI;
            llIIlIIIIllll = 255;
        } else if (llIIlIIIIllII < 3.0f) {
            llIIlIIIIllll = 255;
            llIIlIIIIlllI = llIIlIIIIlIlI;
        } else if (llIIlIIIIllII < 4.0f) {
            llIIlIIIIllll = 255 - llIIlIIIIlIlI;
            llIIlIIIIlllI = 255;
        } else if (llIIlIIIIllII < 5.0f) {
            llIIlIIIlIIII = llIIlIIIIlIlI;
            llIIlIIIIlllI = 255;
        } else if (llIIlIIIIllII < 6.0f) {
            llIIlIIIlIIII = 255;
            llIIlIIIIlllI = 255 - llIIlIIIIlIlI;
        }
        return new int[]{llIIlIIIlIIII, llIIlIIIIllll, llIIlIIIIlllI};
    }

    public static int toRGBA(double[] llIIIlllllIll) {
        if (llIIIlllllIll.length != 4) {
            throw new IllegalArgumentException("colors[] must have a length of 4!");
        }
        return ColorUtil.toRGBA((float)llIIIlllllIll[0], (float)llIIIlllllIll[1], (float)llIIIlllllIll[2], (float)llIIIlllllIll[3]);
    }

    public static int toRGBA(float llIIlIIlIlIII, float llIIlIIlIIlll, float llIIlIIlIIllI, float llIIlIIlIlIIl) {
        return ColorUtil.toRGBA((int)(llIIlIIlIlIII * 255.0f), (int)(llIIlIIlIIlll * 255.0f), (int)(llIIlIIlIIllI * 255.0f), (int)(llIIlIIlIlIIl * 255.0f));
    }
}

