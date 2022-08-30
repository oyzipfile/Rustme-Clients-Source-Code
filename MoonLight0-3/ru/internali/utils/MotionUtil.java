/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.potion.Potion
 */
package ru.internali.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;

public class MotionUtil {
    private static final /* synthetic */ Minecraft mc;

    public static boolean isMoving() {
        return MotionUtil.mc.player.field_70159_w > 0.0 || MotionUtil.mc.player.field_70159_w < -0.0 || MotionUtil.mc.player.field_70179_y > 0.0 || MotionUtil.mc.player.field_70179_y < -0.0;
    }

    static {
        mc = Minecraft.getMinecraft();
    }

    public static double getBaseMoveSpeed() {
        double lIlIIlIlIllIlI = 0.2873;
        if (MotionUtil.mc.player != null && MotionUtil.mc.player.func_70644_a(Potion.getPotionById((int)1))) {
            int lIlIIlIlIllIll = MotionUtil.mc.player.func_70660_b(Potion.getPotionById((int)1)).getAmplifier();
            lIlIIlIlIllIlI *= 1.0 + 0.2 * (double)(lIlIIlIlIllIll + 1);
        }
        return lIlIIlIlIllIlI;
    }

    public MotionUtil() {
        MotionUtil lIlIIlIllIlIll;
    }

    public static boolean isMoving(EntityLivingBase lIlIIlIllIIlll) {
        return lIlIIlIllIIlll.moveForward != 0.0f || lIlIIlIllIIlll.moveStrafing != 0.0f;
    }

    public static double[] forward(double lIlIIlIlIIIlII) {
        float lIlIIlIlIIlIll = MotionUtil.mc.player.movementInput.moveForward;
        float lIlIIlIlIIlIlI = MotionUtil.mc.player.movementInput.moveStrafe;
        float lIlIIlIlIIlIIl = MotionUtil.mc.player.field_70126_B + (MotionUtil.mc.player.field_70177_z - MotionUtil.mc.player.field_70126_B) * mc.getRenderPartialTicks();
        if (lIlIIlIlIIlIll != 0.0f) {
            if (lIlIIlIlIIlIlI > 0.0f) {
                lIlIIlIlIIlIIl += (float)(lIlIIlIlIIlIll > 0.0f ? -45 : 45);
            } else if (lIlIIlIlIIlIlI < 0.0f) {
                lIlIIlIlIIlIIl += (float)(lIlIIlIlIIlIll > 0.0f ? 45 : -45);
            }
            lIlIIlIlIIlIlI = 0.0f;
            if (lIlIIlIlIIlIll > 0.0f) {
                lIlIIlIlIIlIll = 1.0f;
            } else if (lIlIIlIlIIlIll < 0.0f) {
                lIlIIlIlIIlIll = -1.0f;
            }
        }
        double lIlIIlIlIIlIII = Math.sin(Math.toRadians(lIlIIlIlIIlIIl + 90.0f));
        double lIlIIlIlIIIlll = Math.cos(Math.toRadians(lIlIIlIlIIlIIl + 90.0f));
        double lIlIIlIlIIIllI = (double)lIlIIlIlIIlIll * lIlIIlIlIIIlII * lIlIIlIlIIIlll + (double)lIlIIlIlIIlIlI * lIlIIlIlIIIlII * lIlIIlIlIIlIII;
        double lIlIIlIlIIIlIl = (double)lIlIIlIlIIlIll * lIlIIlIlIIIlII * lIlIIlIlIIlIII - (double)lIlIIlIlIIlIlI * lIlIIlIlIIIlII * lIlIIlIlIIIlll;
        return new double[]{lIlIIlIlIIIllI, lIlIIlIlIIIlIl};
    }

    public static void setSpeed(EntityLivingBase lIlIIlIllIIIll, double lIlIIlIllIIIlI) {
        double[] lIlIIlIllIIIIl = MotionUtil.forward(lIlIIlIllIIIlI);
        lIlIIlIllIIIll.field_70159_w = lIlIIlIllIIIIl[0];
        lIlIIlIllIIIll.field_70179_y = lIlIIlIllIIIIl[1];
    }

    public static double getSpeed(EntityLivingBase lIlIIlIlIlIlIl) {
        return Math.sqrt(lIlIIlIlIlIlIl.field_70159_w * lIlIIlIlIlIlIl.field_70159_w + lIlIIlIlIlIlIl.field_70179_y * lIlIIlIlIlIlIl.field_70179_y);
    }
}

