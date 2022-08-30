/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 */
package ru.internali.utils;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import net.minecraft.client.Minecraft;
import ru.internali.utils.Helper;

public class PaletteHelper
implements Helper {
    public static int fade(int lIlIIIlIlIlIlIl, int lIlIIIlIlIlllII, float lIlIIIlIlIllIll) {
        float lIlIIIlIlIllIlI = 1.0f - lIlIIIlIlIllIll;
        int lIlIIIlIlIllIIl = (int)((float)(lIlIIIlIlIlIlIl >> 16 & 0xFF) * lIlIIIlIlIllIlI + (float)(lIlIIIlIlIlllII >> 16 & 0xFF) * lIlIIIlIlIllIll);
        int lIlIIIlIlIllIII = (int)((float)(lIlIIIlIlIlIlIl >> 8 & 0xFF) * lIlIIIlIlIllIlI + (float)(lIlIIIlIlIlllII >> 8 & 0xFF) * lIlIIIlIlIllIll);
        int lIlIIIlIlIlIlll = (int)((float)(lIlIIIlIlIlIlIl & 0xFF) * lIlIIIlIlIllIlI + (float)(lIlIIIlIlIlllII & 0xFF) * lIlIIIlIlIllIll);
        int lIlIIIlIlIlIllI = (int)((float)(lIlIIIlIlIlIlIl >> 24 & 0xFF) * lIlIIIlIlIllIlI + (float)(lIlIIIlIlIlllII >> 24 & 0xFF) * lIlIIIlIlIllIll);
        return (lIlIIIlIlIlIllI & 0xFF) << 24 | (lIlIIIlIlIllIIl & 0xFF) << 16 | (lIlIIIlIlIllIII & 0xFF) << 8 | lIlIIIlIlIlIlll & 0xFF;
    }

    public static int getColor(Color lIlIIIllIlIlIll) {
        return PaletteHelper.getColor(lIlIIIllIlIlIll.getRed(), lIlIIIllIlIlIll.getGreen(), lIlIIIllIlIlIll.getBlue(), lIlIIIllIlIlIll.getAlpha());
    }

    public static int getColor(int lIlIIIllIIIIlIl, int lIlIIIllIIIIlII, int lIlIIIllIIIIIll, int lIlIIIllIIIIlll) {
        int lIlIIIllIIIIllI = 0;
        lIlIIIllIIIIllI |= lIlIIIllIIIIlll << 24;
        lIlIIIllIIIIllI |= lIlIIIllIIIIlIl << 16;
        lIlIIIllIIIIllI |= lIlIIIllIIIIlII << 8;
        return lIlIIIllIIIIllI |= lIlIIIllIIIIIll;
    }

    public PaletteHelper() {
        PaletteHelper lIlIIIllIllIlIl;
    }

    public static int getColor(int lIlIIIlIlllllII, int lIlIIIlIllllIll) {
        return PaletteHelper.getColor(lIlIIIlIlllllII, lIlIIIlIlllllII, lIlIIIlIlllllII, lIlIIIlIllllIll);
    }

    public static int getHealthColor(float lIlIIIllIlIllll, float lIlIIIllIllIIII) {
        return Color.HSBtoRGB(Math.max(0.0f, Math.min(lIlIIIllIlIllll, lIlIIIllIllIIII) / lIlIIIllIllIIII) / 3.0f, 1.0f, 0.8f) | 0xFF000000;
    }

    @Override
    public Minecraft mc() {
        return null;
    }

    public static Color rainbow(int lIlIIIlIlllIllI, float lIlIIIlIlllIIIl, float lIlIIIlIlllIlII) {
        double lIlIIIlIlllIIll = Math.ceil((System.currentTimeMillis() + (long)lIlIIIlIlllIllI) / 16L);
        return Color.getHSBColor((float)((lIlIIIlIlllIIll %= 360.0) / 360.0), lIlIIIlIlllIIIl, lIlIIIlIlllIlII);
    }

    public static Color astolfo(boolean lIlIIIllIIlIlll, int lIlIIIllIIlIllI) {
        float f;
        float lIlIIIllIIllIIl;
        String lIlIIIllIIllIlI = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        float lIlIIIllIIllIII = lIlIIIllIIlIlll ? 2000.0f : 100.0f;
        for (lIlIIIllIIllIIl = (float)(System.currentTimeMillis() % (long)((int)lIlIIIllIIllIII) + (long)lIlIIIllIIlIllI); lIlIIIllIIllIIl > lIlIIIllIIllIII; lIlIIIllIIllIIl -= lIlIIIllIIllIII) {
        }
        lIlIIIllIIllIIl /= lIlIIIllIIllIII;
        if ((double)f > 0.5) {
            lIlIIIllIIllIIl = 0.5f - (lIlIIIllIIllIIl - 0.5f);
        }
        return Color.getHSBColor(lIlIIIllIIllIIl += 0.5f, 0.4f, 1.0f);
    }

    public static Color astolfo(float lIlIIIllIlIIlII, int lIlIIIllIlIIllI) {
        float f;
        float lIlIIIllIlIIlIl;
        for (lIlIIIllIlIIlIl = (float)(System.currentTimeMillis() % (long)((int)lIlIIIllIlIIlII) + (long)lIlIIIllIlIIllI); lIlIIIllIlIIlIl > lIlIIIllIlIIlII; lIlIIIllIlIIlIl -= lIlIIIllIlIIlII) {
        }
        lIlIIIllIlIIlIl /= lIlIIIllIlIIlII;
        if ((double)f > 0.5) {
            lIlIIIllIlIIlIl = 0.5f - (lIlIIIllIlIIlIl - 0.5f);
        }
        return Color.getHSBColor(lIlIIIllIlIIlIl += 0.5f, 0.4f, 1.0f);
    }

    public static int getColor(int lIlIIIllIIlIIII) {
        return PaletteHelper.getColor(lIlIIIllIIlIIII, lIlIIIllIIlIIII, lIlIIIllIIlIIII, 255);
    }

    public static int fadeColor(int lIlIIIlIllIlIII, int lIlIIIlIllIlIlI, float lIlIIIlIllIlIIl) {
        if (lIlIIIlIllIlIIl > 1.0f) {
            lIlIIIlIllIlIIl = 1.0f - lIlIIIlIllIlIIl % 1.0f;
        }
        return PaletteHelper.fade(lIlIIIlIllIlIII, lIlIIIlIllIlIlI, lIlIIIlIllIlIIl);
    }
}

