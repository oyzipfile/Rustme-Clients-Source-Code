/*
 * Decompiled with CFR 0.150.
 */
package ru.hld.legendline.api.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class MathUtils {
    private static final /* synthetic */ Random random;

    public static float getRandomInRange(float lllllllllllllllIllIIIlIIllIIllll, float lllllllllllllllIllIIIlIIllIIlllI) {
        return (float)((double)lllllllllllllllIllIIIlIIllIIlllI + (double)(lllllllllllllllIllIIIlIIllIIllll - lllllllllllllllIllIIIlIIllIIlllI) * random.nextDouble());
    }

    static {
        random = new Random();
    }

    public static float clamp(float lllllllllllllllIllIIIlIIllIIIlIl, float lllllllllllllllIllIIIlIIllIIIlII, float lllllllllllllllIllIIIlIIllIIIIll) {
        if (lllllllllllllllIllIIIlIIllIIIlIl <= lllllllllllllllIllIIIlIIllIIIlII) {
            lllllllllllllllIllIIIlIIllIIIlIl = lllllllllllllllIllIIIlIIllIIIlII;
        }
        if (lllllllllllllllIllIIIlIIllIIIlIl >= lllllllllllllllIllIIIlIIllIIIIll) {
            lllllllllllllllIllIIIlIIllIIIlIl = lllllllllllllllIllIIIlIIllIIIIll;
        }
        return lllllllllllllllIllIIIlIIllIIIlIl;
    }

    public static float lerp(float lllllllllllllllIllIIIlIIllIlIlII, float lllllllllllllllIllIIIlIIllIlIllI, float lllllllllllllllIllIIIlIIllIlIlIl) {
        return lllllllllllllllIllIIIlIIllIlIlII + lllllllllllllllIllIIIlIIllIlIlIl * (lllllllllllllllIllIIIlIIllIlIllI - lllllllllllllllIllIIIlIIllIlIlII);
    }

    public static double round(float lllllllllllllllIllIIIlIIlIlllllI, double lllllllllllllllIllIIIlIIlIlllIIl) {
        double lllllllllllllllIllIIIlIIlIllllII = (double)Math.round((double)lllllllllllllllIllIIIlIIlIlllllI / lllllllllllllllIllIIIlIIlIlllIIl) * lllllllllllllllIllIIIlIIlIlllIIl;
        BigDecimal lllllllllllllllIllIIIlIIlIlllIll = new BigDecimal(lllllllllllllllIllIIIlIIlIllllII);
        lllllllllllllllIllIIIlIIlIlllIll = lllllllllllllllIllIIIlIIlIlllIll.setScale(2, RoundingMode.HALF_UP);
        return lllllllllllllllIllIIIlIIlIlllIll.doubleValue();
    }

    public MathUtils() {
        MathUtils lllllllllllllllIllIIIlIIllIlllII;
    }
}

