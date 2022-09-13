/*
 * Decompiled with CFR 0.150.
 */
package ru.hld.legendline.api.utils;

import java.awt.Color;
import ru.hld.legendline.api.utils.MathUtils;

public class ColorUtils {
    public static int getColor(int llllllllllllllIlIIIIlIIIlIIIIIII, int llllllllllllllIlIIIIlIIIIlllllll, int llllllllllllllIlIIIIlIIIIllllIIl, int llllllllllllllIlIIIIlIIIIllllIII) {
        int llllllllllllllIlIIIIlIIIIlllllII = 0;
        llllllllllllllIlIIIIlIIIIlllllII |= llllllllllllllIlIIIIlIIIIllllIII << 24;
        llllllllllllllIlIIIIlIIIIlllllII |= llllllllllllllIlIIIIlIIIlIIIIIII << 16;
        llllllllllllllIlIIIIlIIIIlllllII |= llllllllllllllIlIIIIlIIIIlllllll << 8;
        return llllllllllllllIlIIIIlIIIIlllllII |= llllllllllllllIlIIIIlIIIIllllIIl;
    }

    public static int astolfoColorsCool(int llllllllllllllIlIIIIlIIIIIlIlIIl, int llllllllllllllIlIIIIlIIIIIlIlIII) {
        float f;
        float llllllllllllllIlIIIIlIIIIIlIlIll;
        float llllllllllllllIlIIIIlIIIIIlIlIlI = 1450.0f;
        for (llllllllllllllIlIIIIlIIIIIlIlIll = (float)(System.currentTimeMillis() % (long)((int)llllllllllllllIlIIIIlIIIIIlIlIlI)) + (float)((llllllllllllllIlIIIIlIIIIIlIlIII - llllllllllllllIlIIIIlIIIIIlIlIIl) * 9); llllllllllllllIlIIIIlIIIIIlIlIll > llllllllllllllIlIIIIlIIIIIlIlIlI; llllllllllllllIlIIIIlIIIIIlIlIll -= llllllllllllllIlIIIIlIIIIIlIlIlI) {
        }
        llllllllllllllIlIIIIlIIIIIlIlIll /= llllllllllllllIlIIIIlIIIIIlIlIlI;
        if ((double)f > 0.5) {
            llllllllllllllIlIIIIlIIIIIlIlIll = 0.5f - (llllllllllllllIlIIIIlIIIIIlIlIll - 0.5f);
        }
        return Color.HSBtoRGB(llllllllllllllIlIIIIlIIIIIlIlIll += 0.5f, 0.67f, 1.0f);
    }

    public static int getColor(int llllllllllllllIlIIIIlIIIlIIIlIll, int llllllllllllllIlIIIIlIIIlIIIIlll, int llllllllllllllIlIIIIlIIIlIIIIllI) {
        return ColorUtils.getColor(llllllllllllllIlIIIIlIIIlIIIlIll, llllllllllllllIlIIIIlIIIlIIIIlll, llllllllllllllIlIIIIlIIIlIIIIllI, 255);
    }

    public static int TwoColoreffect(int llllllllllllllIlIIIIlIIIIlIIIlll, int llllllllllllllIlIIIIlIIIIIlllIll, int llllllllllllllIlIIIIlIIIIlIIIlIl, int llllllllllllllIlIIIIlIIIIIlllIIl, int llllllllllllllIlIIIIlIIIIIlllIII, int llllllllllllllIlIIIIlIIIIlIIIIlI, int llllllllllllllIlIIIIlIIIIlIIIIIl, int llllllllllllllIlIIIIlIIIIlIIIIII, double llllllllllllllIlIIIIlIIIIIllllll) {
        double llllllllllllllIlIIIIlIIIIIlllllI = llllllllllllllIlIIIIlIIIIIllllll / 4.0 % 1.0;
        float llllllllllllllIlIIIIlIIIIIllllIl = MathUtils.clamp((float)Math.sin(Math.PI * 6 * llllllllllllllIlIIIIlIIIIIlllllI) / 2.0f + 0.5f, 0.0f, 1.0f);
        return ColorUtils.getColor((int)MathUtils.lerp(llllllllllllllIlIIIIlIIIIlIIIlll, llllllllllllllIlIIIIlIIIIIlllIII, llllllllllllllIlIIIIlIIIIIllllIl), (int)MathUtils.lerp(llllllllllllllIlIIIIlIIIIIlllIll, llllllllllllllIlIIIIlIIIIlIIIIlI, llllllllllllllIlIIIIlIIIIIllllIl), (int)MathUtils.lerp(llllllllllllllIlIIIIlIIIIlIIIlIl, llllllllllllllIlIIIIlIIIIlIIIIIl, llllllllllllllIlIIIIlIIIIIllllIl), (int)MathUtils.lerp(llllllllllllllIlIIIIlIIIIIlllIIl, llllllllllllllIlIIIIlIIIIlIIIIII, llllllllllllllIlIIIIlIIIIIllllIl));
    }

    public ColorUtils() {
        ColorUtils llllllllllllllIlIIIIlIIIlIIlllll;
    }

    public static Color TwoColoreffect(Color llllllllllllllIlIIIIlIIIlIIlIIll, Color llllllllllllllIlIIIIlIIIlIIlIIlI, double llllllllllllllIlIIIIlIIIlIIlIllI) {
        double llllllllllllllIlIIIIlIIIlIIlIlIl = llllllllllllllIlIIIIlIIIlIIlIllI / 4.0 % 1.0;
        float llllllllllllllIlIIIIlIIIlIIlIlII = MathUtils.clamp((float)Math.sin(Math.PI * 6 * llllllllllllllIlIIIIlIIIlIIlIlIl) / 2.0f + 0.5f, 0.0f, 1.0f);
        return new Color(MathUtils.lerp((float)llllllllllllllIlIIIIlIIIlIIlIIll.getRed() / 255.0f, (float)llllllllllllllIlIIIIlIIIlIIlIIlI.getRed() / 255.0f, llllllllllllllIlIIIIlIIIlIIlIlII), MathUtils.lerp((float)llllllllllllllIlIIIIlIIIlIIlIIll.getGreen() / 255.0f, (float)llllllllllllllIlIIIIlIIIlIIlIIlI.getGreen() / 255.0f, llllllllllllllIlIIIIlIIIlIIlIlII), MathUtils.lerp((float)llllllllllllllIlIIIIlIIIlIIlIIll.getBlue() / 255.0f, (float)llllllllllllllIlIIIIlIIIlIIlIIlI.getBlue() / 255.0f, llllllllllllllIlIIIIlIIIlIIlIlII), MathUtils.lerp((float)llllllllllllllIlIIIIlIIIlIIlIIll.getAlpha() / 255.0f, (float)llllllllllllllIlIIIIlIIIlIIlIIlI.getAlpha() / 255.0f, llllllllllllllIlIIIIlIIIlIIlIlII));
    }

    public static int swapAlpha(int llllllllllllllIlIIIIlIIIIIIllIll, float llllllllllllllIlIIIIlIIIIIIllIlI) {
        int llllllllllllllIlIIIIlIIIIIIllllI = llllllllllllllIlIIIIlIIIIIIllIll >> 16 & 0xFF;
        int llllllllllllllIlIIIIlIIIIIIlllIl = llllllllllllllIlIIIIlIIIIIIllIll >> 8 & 0xFF;
        int llllllllllllllIlIIIIlIIIIIIlllII = llllllllllllllIlIIIIlIIIIIIllIll & 0xFF;
        return ColorUtils.getColor(llllllllllllllIlIIIIlIIIIIIllllI, llllllllllllllIlIIIIlIIIIIIlllIl, llllllllllllllIlIIIIlIIIIIIlllII, (int)llllllllllllllIlIIIIlIIIIIIllIlI);
    }

    public static int fadeColor(int llllllllllllllIlIIIIlIIIIlIllllI, int llllllllllllllIlIIIIlIIIIlIlllIl, float llllllllllllllIlIIIIlIIIIlIlllII, int llllllllllllllIlIIIIlIIIIllIIlll) {
        float llllllllllllllIlIIIIlIIIIllIIllI = llllllllllllllIlIIIIlIIIIlIllllI >> 16 & 0xFF;
        float llllllllllllllIlIIIIlIIIIllIIlIl = llllllllllllllIlIIIIlIIIIlIllllI >> 8 & 0xFF;
        float llllllllllllllIlIIIIlIIIIllIIlII = llllllllllllllIlIIIIlIIIIlIllllI & 0xFF;
        float llllllllllllllIlIIIIlIIIIllIIIll = llllllllllllllIlIIIIlIIIIlIllllI >> 24 & 0xFF;
        float llllllllllllllIlIIIIlIIIIllIIIlI = llllllllllllllIlIIIIlIIIIlIlllIl >> 16 & 0xFF;
        float llllllllllllllIlIIIIlIIIIllIIIIl = llllllllllllllIlIIIIlIIIIlIlllIl >> 8 & 0xFF;
        float llllllllllllllIlIIIIlIIIIllIIIII = llllllllllllllIlIIIIlIIIIlIlllIl & 0xFF;
        float llllllllllllllIlIIIIlIIIIlIlllll = llllllllllllllIlIIIIlIIIIlIlllIl >> 24 & 0xFF;
        return ColorUtils.TwoColoreffect((int)llllllllllllllIlIIIIlIIIIllIIllI, (int)llllllllllllllIlIIIIlIIIIllIIlIl, (int)llllllllllllllIlIIIIlIIIIllIIlII, (int)llllllllllllllIlIIIIlIIIIllIIIll, (int)llllllllllllllIlIIIIlIIIIllIIIlI, (int)llllllllllllllIlIIIIlIIIIllIIIIl, (int)llllllllllllllIlIIIIlIIIIllIIIII, (int)llllllllllllllIlIIIIlIIIIlIlllll, (double)Math.abs(System.currentTimeMillis() / 4L + (long)llllllllllllllIlIIIIlIIIIllIIlll) / 100.1275 * (double)llllllllllllllIlIIIIlIIIIlIlllII);
    }
}

