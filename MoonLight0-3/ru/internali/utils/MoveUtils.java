/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 */
package ru.internali.utils;

import net.minecraft.client.Minecraft;

public class MoveUtils {
    public static void setSpeed(double llllllIIIIllIIl) {
        double llllllIIIIllIII = Minecraft.getMinecraft().player.movementInput.moveForward;
        double llllllIIIIlIlll = Minecraft.getMinecraft().player.movementInput.moveStrafe;
        float llllllIIIIlIllI = Minecraft.getMinecraft().player.field_70177_z;
        if (llllllIIIIllIII == 0.0 && llllllIIIIlIlll == 0.0) {
            Minecraft.getMinecraft().player.field_70159_w = 0.0;
            Minecraft.getMinecraft().player.field_70179_y = 0.0;
        } else {
            if (llllllIIIIllIII != 0.0) {
                if (llllllIIIIlIlll > 0.0) {
                    llllllIIIIlIllI += (float)(llllllIIIIllIII > 0.0 ? -45 : 45);
                } else if (llllllIIIIlIlll < 0.0) {
                    llllllIIIIlIllI += (float)(llllllIIIIllIII > 0.0 ? 45 : -45);
                }
                llllllIIIIlIlll = 0.0;
                if (llllllIIIIllIII > 0.0) {
                    llllllIIIIllIII = 1.0;
                } else if (llllllIIIIllIII < 0.0) {
                    llllllIIIIllIII = -1.0;
                }
            }
            Minecraft.getMinecraft().player.field_70159_w = llllllIIIIllIII * llllllIIIIllIIl * Math.cos(Math.toRadians(llllllIIIIlIllI + 90.0f)) + llllllIIIIlIlll * llllllIIIIllIIl * Math.sin(Math.toRadians(llllllIIIIlIllI + 90.0f));
            Minecraft.getMinecraft().player.field_70179_y = llllllIIIIllIII * llllllIIIIllIIl * Math.sin(Math.toRadians(llllllIIIIlIllI + 90.0f)) - llllllIIIIlIlll * llllllIIIIllIIl * Math.cos(Math.toRadians(llllllIIIIlIllI + 90.0f));
        }
    }

    public static void unsafeSetSpeed(double llllllIIIIIIlll) {
        double llllllIIIIIIlIl = Minecraft.getMinecraft().player.movementInput.moveStrafe;
        float llllllIIIIIIlII = Minecraft.getMinecraft().player.field_70177_z;
        if (llllllIIIIIIlIl == 0.0) {
            Minecraft.getMinecraft().player.field_70159_w = 0.0;
            Minecraft.getMinecraft().player.field_70179_y = 0.0;
        }
        Minecraft.getMinecraft().player.field_70159_w = llllllIIIIIIlll * Math.cos(Math.toRadians(llllllIIIIIIlII + 90.0f)) + llllllIIIIIIlIl * llllllIIIIIIlll * Math.sin(Math.toRadians(llllllIIIIIIlII + 90.0f));
        Minecraft.getMinecraft().player.field_70179_y = llllllIIIIIIlll * Math.sin(Math.toRadians(llllllIIIIIIlII + 90.0f)) - llllllIIIIIIlIl * llllllIIIIIIlll * Math.cos(Math.toRadians(llllllIIIIIIlII + 90.0f));
    }

    public MoveUtils() {
        MoveUtils llllllIIIlIIIIl;
    }
}

