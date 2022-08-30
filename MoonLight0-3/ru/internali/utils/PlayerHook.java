/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils;

public class PlayerHook {
    /* synthetic */ float yaw;
    /* synthetic */ float pitch;
    /* synthetic */ double y;
    /* synthetic */ boolean onGround;
    /* synthetic */ double z;
    /* synthetic */ double x;

    public void setX(double lIlIlllIIllIIIl) {
        lIlIlllIIllIIlI.x = lIlIlllIIllIIIl;
    }

    public static void setYaw(float lIlIlllIIIllllI) {
    }

    public static void setPitch(float lIlIlllIIlIIIII) {
    }

    public float getYaw() {
        PlayerHook lIlIlllIIIIlIIl;
        return lIlIlllIIIIlIIl.yaw;
    }

    public void setY(double lIlIlllIIlIlIll) {
        lIlIlllIIlIllII.y = lIlIlllIIlIlIll;
    }

    public double getY() {
        PlayerHook lIlIlllIIIlIIIl;
        return lIlIlllIIIlIIIl.y;
    }

    public float getPitch() {
        PlayerHook lIlIlllIIIIlIll;
        return lIlIlllIIIIlIll.pitch;
    }

    public double getX() {
        PlayerHook lIlIlllIIIlIlII;
        return lIlIlllIIIlIlII.x;
    }

    public double getZ() {
        PlayerHook lIlIlllIIIIllll;
        return lIlIlllIIIIllll.z;
    }

    public void setZ(double lIlIlllIIIlIlll) {
        lIlIlllIIIllIlI.z = lIlIlllIIIlIlll;
    }

    public void setOnGround(boolean lIlIlllIIlIIlIl) {
        lIlIlllIIlIIlII.onGround = lIlIlllIIlIIlIl;
    }

    public boolean isOnGround() {
        PlayerHook lIlIlllIIIIIlIl;
        return lIlIlllIIIIIlIl.onGround;
    }

    public PlayerHook(double lIlIlllIlIIIIIl, double lIlIlllIIlllIIl, double lIlIlllIIllllll, float lIlIlllIIlllllI, float lIlIlllIIllllIl, boolean lIlIlllIIllllII) {
        PlayerHook lIlIlllIlIIIIlI;
        lIlIlllIlIIIIlI.x = lIlIlllIlIIIIIl;
        lIlIlllIlIIIIlI.y = lIlIlllIIlllIIl;
        lIlIlllIlIIIIlI.z = lIlIlllIIllllll;
        lIlIlllIlIIIIlI.yaw = lIlIlllIIlllllI;
        lIlIlllIlIIIIlI.pitch = lIlIlllIIllllIl;
        lIlIlllIlIIIIlI.onGround = lIlIlllIIllllII;
    }
}

