/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Vec3d
 */
package ru.internali.utils;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;

public class InterpolationUtil {
    public static boolean isNearlyEqual(double llllllIIlIIllIl, double llllllIIlIIIlll, double llllllIIlIIIllI) {
        double llllllIIlIIlIlI = llllllIIlIIllIl + llllllIIlIIIllI;
        double llllllIIlIIlIIl = llllllIIlIIllIl - llllllIIlIIIllI;
        return !(llllllIIlIIIlll > llllllIIlIIlIlI) && !(llllllIIlIIIlll < llllllIIlIIlIIl);
    }

    public static Vec3d getInterpolatedAmount(Entity llllllIIllIlIII, double llllllIIllIIlll) {
        return InterpolationUtil.getInterpolatedAmount(llllllIIllIlIII, llllllIIllIIlll, llllllIIllIIlll, llllllIIllIIlll);
    }

    public InterpolationUtil() {
        InterpolationUtil llllllIIlllIIIl;
    }

    public static Vec3d getInterpolatedAmount(Entity llllllIIlIlllII, double llllllIIlIlllll, double llllllIIlIllIlI, double llllllIIlIllIIl) {
        return new Vec3d((llllllIIlIlllII.posX - llllllIIlIlllII.lastTickPosX) * llllllIIlIlllll, (llllllIIlIlllII.posY - llllllIIlIlllII.lastTickPosY) * llllllIIlIllIlI, (llllllIIlIlllII.posZ - llllllIIlIlllII.lastTickPosZ) * llllllIIlIllIIl);
    }

    public static Vec3d interpolateEntityTime(Entity llllllIIlIlIllI, float llllllIIlIlIIll) {
        return new Vec3d(llllllIIlIlIllI.lastTickPosX + (llllllIIlIlIllI.posX - llllllIIlIlIllI.lastTickPosX) * (double)llllllIIlIlIIll, llllllIIlIlIllI.lastTickPosY + (llllllIIlIlIllI.posY - llllllIIlIlIllI.lastTickPosY) * (double)llllllIIlIlIIll, llllllIIlIlIllI.lastTickPosZ + (llllllIIlIlIllI.posZ - llllllIIlIlIllI.lastTickPosZ) * (double)llllllIIlIlIIll);
    }

    public static Vec3d getInterpolatedPos(Entity llllllIIllIllII, float llllllIIllIlIll) {
        return new Vec3d(llllllIIllIllII.lastTickPosX, llllllIIllIllII.lastTickPosY, llllllIIllIllII.lastTickPosZ).add(InterpolationUtil.getInterpolatedAmount(llllllIIllIllII, llllllIIllIlIll));
    }
}

