/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.math.MathHelper
 */
package ru.internali.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.MathHelper;
import ru.internali.utils.Helper;

public class MathematicHelper
implements Helper {
    public static double round(double lIIIIIIlllIIll, double lIIIIIIllIlllI) {
        double lIIIIIIlllIIIl = (double)Math.round(lIIIIIIlllIIll / lIIIIIIllIlllI) * lIIIIIIllIlllI;
        BigDecimal lIIIIIIlllIIII = new BigDecimal(lIIIIIIlllIIIl);
        lIIIIIIlllIIII = lIIIIIIlllIIII.setScale(2, RoundingMode.HALF_UP);
        return lIIIIIIlllIIII.doubleValue();
    }

    public static float clamp(float lIIIIIIlIlllII, float lIIIIIIlIllIII, float lIIIIIIlIllIlI) {
        if (lIIIIIIlIlllII <= lIIIIIIlIllIII) {
            lIIIIIIlIlllII = lIIIIIIlIllIII;
        }
        if (lIIIIIIlIlllII >= lIIIIIIlIllIlI) {
            lIIIIIIlIlllII = lIIIIIIlIllIlI;
        }
        return lIIIIIIlIlllII;
    }

    public static BigDecimal round(float lIIIIIlIIIIIll, int lIIIIIlIIIIIlI) {
        BigDecimal lIIIIIlIIIIIIl = new BigDecimal(Float.toString(lIIIIIlIIIIIll));
        lIIIIIlIIIIIIl = lIIIIIlIIIIIIl.setScale(lIIIIIlIIIIIlI, RoundingMode.HALF_UP);
        return lIIIIIlIIIIIIl;
    }

    public static float checkAngle(float lIIIIIIllIIlll, float lIIIIIIllIIIlI, float lIIIIIIllIIIIl) {
        float lIIIIIIllIIlII = MathHelper.wrapDegrees((float)(lIIIIIIllIIlll - lIIIIIIllIIIlI));
        if (lIIIIIIllIIlII < -lIIIIIIllIIIIl) {
            lIIIIIIllIIlII = -lIIIIIIllIIIIl;
        }
        if (lIIIIIIllIIlII >= lIIIIIIllIIIIl) {
            lIIIIIIllIIlII = lIIIIIIllIIIIl;
        }
        return lIIIIIIllIIlll - lIIIIIIllIIlII;
    }

    @Override
    public Minecraft mc() {
        return null;
    }

    public MathematicHelper() {
        MathematicHelper lIIIIIlIIIIlll;
    }

    public static int getMiddle(int lIIIIIIllllIll, int lIIIIIIllllIII) {
        return (lIIIIIIllllIll + lIIIIIIllllIII) / 2;
    }

    public static float randomizeFloat(float lIIIIIIlIlIIlI, float lIIIIIIlIlIIIl) {
        return (float)((double)lIIIIIIlIlIIlI + (double)(lIIIIIIlIlIIIl - lIIIIIIlIlIIlI) * Math.random());
    }
}

