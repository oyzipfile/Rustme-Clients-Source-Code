/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 */
package ru.internali.module.misc;

import net.minecraft.client.Minecraft;

public class Rotation {
    private static /* synthetic */ float Yaw;
    private static /* synthetic */ boolean settingPitch;
    private static /* synthetic */ float Pitch;
    private static /* synthetic */ boolean settingYaw;

    public static void setYaw(float lIIlIIIlIllIIIl) {
        settingPitch = true;
        Yaw = lIIlIIIlIllIIIl;
    }

    public Rotation() {
        Rotation lIIlIIIlIllllII;
    }

    public static void setPitch(float lIIlIIIlIllIlII) {
        settingPitch = true;
        Pitch = lIIlIIIlIllIlII;
    }

    public static float getPitch() {
        float lIIlIIIlIlllIlI = Pitch;
        Pitch = Minecraft.getMinecraft().player.field_70125_A;
        return lIIlIIIlIlllIlI;
    }

    public static float getYaw() {
        float lIIlIIIlIllIlll = Yaw;
        Yaw = Minecraft.getMinecraft().player.field_70177_z;
        return lIIlIIIlIllIlll;
    }
}

