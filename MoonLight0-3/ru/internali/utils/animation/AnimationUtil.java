/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 */
package ru.internali.utils.animation;

import net.minecraft.client.Minecraft;

public class AnimationUtil {
    public static /* synthetic */ float speedTarget;

    public static double animate(double lIlIlIlIllllll, double lIlIlIlIllIlll, double lIlIlIlIllIllI) {
        boolean lIlIlIlIllllII = lIlIlIlIllllll > lIlIlIlIllIlll;
        boolean lIlIlIlIlllIll = lIlIlIlIllllII;
        if (lIlIlIlIllIllI < 0.0) {
            lIlIlIlIllIllI = 0.0;
        } else if (lIlIlIlIllIllI > 1.0) {
            lIlIlIlIllIllI = 1.0;
        }
        double lIlIlIlIlllIlI = Math.max(lIlIlIlIllllll, lIlIlIlIllIlll) - Math.min(lIlIlIlIllllll, lIlIlIlIllIlll);
        double lIlIlIlIlllIIl = lIlIlIlIlllIlI * lIlIlIlIllIllI;
        if (lIlIlIlIlllIIl < 0.1) {
            lIlIlIlIlllIIl = 0.1;
        }
        lIlIlIlIllIlll = lIlIlIlIllllII ? (lIlIlIlIllIlll = lIlIlIlIllIlll + lIlIlIlIlllIIl) : (lIlIlIlIllIlll = lIlIlIlIllIlll - lIlIlIlIlllIIl);
        return lIlIlIlIllIlll;
    }

    public AnimationUtil() {
        AnimationUtil lIlIlIllIllllI;
    }

    static {
        speedTarget = 0.125f;
    }

    public static float animation(float lIlIlIllIllIIl, float lIlIlIllIllIII, float lIlIlIllIlIlll) {
        return AnimationUtil.animation(lIlIlIllIllIIl, lIlIlIllIllIII, speedTarget, lIlIlIllIlIlll);
    }

    public static float animation(float lIlIlIllIIllll, float lIlIlIllIIlIIl, float lIlIlIllIIllIl, float lIlIlIllIIlIII) {
        float lIlIlIllIIlIll = (lIlIlIllIIlIIl - lIlIlIllIIllll) / Math.max((float)Minecraft.getDebugFPS(), 5.0f) * 15.0f;
        if (lIlIlIllIIlIll > 0.0f) {
            lIlIlIllIIlIll = Math.max(lIlIlIllIIlIII, lIlIlIllIIlIll);
            lIlIlIllIIlIll = Math.min(lIlIlIllIIlIIl - lIlIlIllIIllll, lIlIlIllIIlIll);
        } else if (lIlIlIllIIlIll < 0.0f) {
            lIlIlIllIIlIll = Math.min(-lIlIlIllIIlIII, lIlIlIllIIlIll);
            lIlIlIllIIlIll = Math.max(lIlIlIllIIlIIl - lIlIlIllIIllll, lIlIlIllIIlIll);
        }
        return lIlIlIllIIllll + lIlIlIllIIlIll;
    }
}

