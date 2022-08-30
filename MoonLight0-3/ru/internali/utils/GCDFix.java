/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 */
package ru.internali.utils;

import net.minecraft.client.Minecraft;

public class GCDFix {
    private /* synthetic */ float pitch;
    private /* synthetic */ float yaw;
    static /* synthetic */ Minecraft mc;

    public final float getPitch() {
        GCDFix lllIIlIIlIIllIl;
        return lllIIlIIlIIllIl.pitch;
    }

    public int hashCode() {
        GCDFix lllIIlIIlIIIIII;
        return Float.hashCode(lllIIlIIlIIIIII.yaw) * 31 + Float.hashCode(lllIIlIIlIIIIII.pitch);
    }

    static {
        mc = Minecraft.getMinecraft();
    }

    public static float getFixedRotation(float lllIIlIIlIlllll) {
        return GCDFix.getDeltaMouse(lllIIlIIlIlllll) * GCDFix.getGCDValue();
    }

    public final float getYaw() {
        GCDFix lllIIlIIlIlIlIl;
        return lllIIlIIlIlIlIl.yaw;
    }

    public static float getGCDValue() {
        return (float)((double)GCDFix.getGCD() * 0.15);
    }

    public final void setYaw(float lllIIlIIlIIllll) {
        lllIIlIIlIlIIlI.yaw = lllIIlIIlIIllll;
    }

    public GCDFix(float lllIIlIIllIIIlI, float lllIIlIIllIIIIl) {
        GCDFix lllIIlIIllIIIll;
        lllIIlIIllIIIll.yaw = lllIIlIIllIIIlI;
        lllIIlIIllIIIll.pitch = lllIIlIIllIIIIl;
    }

    public static float getDeltaMouse(float lllIIlIIlIllIII) {
        return Math.round(lllIIlIIlIllIII / GCDFix.getGCDValue());
    }

    public static float getGCD() {
        float lllIIlIIlIlllII = (float)((double)GCDFix.mc.gameSettings.mouseSensitivity * 0.6 + 0.2);
        return lllIIlIIlIlllII * lllIIlIIlIlllII * lllIIlIIlIlllII * 8.0f;
    }

    public final void setPitch(float lllIIlIIlIIlIII) {
        lllIIlIIlIIlIIl.pitch = lllIIlIIlIIlIII;
    }

    public boolean equals(Object lllIIlIIIlllIII) {
        GCDFix lllIIlIIIlllIIl;
        if (lllIIlIIIlllIIl != lllIIlIIIlllIII) {
            if (!(lllIIlIIIlllIII instanceof GCDFix)) {
                return false;
            }
            GCDFix lllIIlIIIllllII = (GCDFix)lllIIlIIIlllIII;
            return Float.compare(lllIIlIIIlllIIl.yaw, lllIIlIIIllllII.yaw) == 0 && Float.compare(lllIIlIIIlllIIl.pitch, lllIIlIIIllllII.pitch) == 0;
        }
        return true;
    }

    public String toString() {
        GCDFix lllIIlIIlIIIIll;
        return String.valueOf(new StringBuilder().append("Rotation(yaw=").append(lllIIlIIlIIIIll.yaw).append(", pitch=").append(lllIIlIIlIIIIll.pitch).append(")"));
    }
}

