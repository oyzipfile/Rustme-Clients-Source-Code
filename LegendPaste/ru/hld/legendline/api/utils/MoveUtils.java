/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.MovementInput
 */
package ru.hld.legendline.api.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.util.MovementInput;

public class MoveUtils {
    public static /* synthetic */ Minecraft mc;
    static /* synthetic */ double speedchlen;

    public MoveUtils() {
        MoveUtils llllllllllllllIIlIlllIlIlllllIll;
    }

    public static double getSpeed() {
        speedchlen = Math.sqrt(MoveUtils.mc.player.motionX * MoveUtils.mc.player.motionX + MoveUtils.mc.player.motionZ * MoveUtils.mc.player.motionZ + MoveUtils.mc.player.motionY * MoveUtils.mc.player.motionY) * 10.0;
        return speedchlen;
    }

    public static void setSpeed(double llllllllllllllIIlIlllIlIllllIIIl) {
        double llllllllllllllIIlIlllIlIllllIlII = MovementInput.field_192832_b;
        double llllllllllllllIIlIlllIlIllllIIll = MovementInput.moveStrafe;
        float llllllllllllllIIlIlllIlIllllIIlI = MoveUtils.mc.player.rotationYaw;
        if (llllllllllllllIIlIlllIlIllllIlII == 0.0 && llllllllllllllIIlIlllIlIllllIIll == 0.0) {
            MoveUtils.mc.player.motionX = 0.0;
            MoveUtils.mc.player.motionZ = 0.0;
        } else {
            if (llllllllllllllIIlIlllIlIllllIlII != 0.0) {
                if (llllllllllllllIIlIlllIlIllllIIll > 0.0) {
                    llllllllllllllIIlIlllIlIllllIIlI += (float)(llllllllllllllIIlIlllIlIllllIlII > 0.0 ? -45 : 45);
                } else if (llllllllllllllIIlIlllIlIllllIIll < 0.0) {
                    llllllllllllllIIlIlllIlIllllIIlI += (float)(llllllllllllllIIlIlllIlIllllIlII > 0.0 ? 45 : -45);
                }
                llllllllllllllIIlIlllIlIllllIIll = 0.0;
                if (llllllllllllllIIlIlllIlIllllIlII > 0.0) {
                    llllllllllllllIIlIlllIlIllllIlII = 1.0;
                } else if (llllllllllllllIIlIlllIlIllllIlII < 0.0) {
                    llllllllllllllIIlIlllIlIllllIlII = -1.0;
                }
            }
            MoveUtils.mc.player.motionX = llllllllllllllIIlIlllIlIllllIlII * llllllllllllllIIlIlllIlIllllIIIl * Math.cos(Math.toRadians(llllllllllllllIIlIlllIlIllllIIlI + 90.0f)) + llllllllllllllIIlIlllIlIllllIIll * llllllllllllllIIlIlllIlIllllIIIl * Math.sin(Math.toRadians(llllllllllllllIIlIlllIlIllllIIlI + 90.0f));
            MoveUtils.mc.player.motionZ = llllllllllllllIIlIlllIlIllllIlII * llllllllllllllIIlIlllIlIllllIIIl * Math.sin(Math.toRadians(llllllllllllllIIlIlllIlIllllIIlI + 90.0f)) - llllllllllllllIIlIlllIlIllllIIll * llllllllllllllIIlIlllIlIllllIIIl * Math.cos(Math.toRadians(llllllllllllllIIlIlllIlIllllIIlI + 90.0f));
        }
    }

    static {
        mc = Minecraft.getMinecraft();
    }
}

