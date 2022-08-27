/*
 * Decompiled with CFR 0.150.
 */
package ru.hld.legendline.api.event;

public class PlayerHook {
    /* synthetic */ double z;
    /* synthetic */ float yaw;
    /* synthetic */ double x;
    /* synthetic */ boolean onGround;
    /* synthetic */ double y;
    /* synthetic */ float pitch;

    public void setY(double lllllllllllllllIIllllIlIIIllIIIl) {
        lllllllllllllllIIllllIlIIIllIIlI.y = lllllllllllllllIIllllIlIIIllIIIl;
    }

    public void setX(double lllllllllllllllIIllllIlIIIllIlll) {
        lllllllllllllllIIllllIlIIIlllIII.x = lllllllllllllllIIllllIlIIIllIlll;
    }

    public void setOnGround(boolean lllllllllllllllIIllllIlIIIlIlIIl) {
        lllllllllllllllIIllllIlIIIlIlIlI.onGround = lllllllllllllllIIllllIlIIIlIlIIl;
    }

    public float getYaw() {
        PlayerHook lllllllllllllllIIllllIlIIIIIlIIl;
        return lllllllllllllllIIllllIlIIIIIlIIl.yaw;
    }

    public void setZ(double lllllllllllllllIIllllIlIIIIllIIl) {
        lllllllllllllllIIllllIlIIIIllIlI.z = lllllllllllllllIIllllIlIIIIllIIl;
    }

    public PlayerHook(double lllllllllllllllIIllllIlIIlIIIIII, double lllllllllllllllIIllllIlIIlIIIllI, double lllllllllllllllIIllllIlIIlIIIlIl, float lllllllllllllllIIllllIlIIlIIIlII, float lllllllllllllllIIllllIlIIIllllII, boolean lllllllllllllllIIllllIlIIlIIIIlI) {
        PlayerHook lllllllllllllllIIllllIlIIlIIIIIl;
        lllllllllllllllIIllllIlIIlIIIIIl.x = lllllllllllllllIIllllIlIIlIIIIII;
        lllllllllllllllIIllllIlIIlIIIIIl.y = lllllllllllllllIIllllIlIIlIIIllI;
        lllllllllllllllIIllllIlIIlIIIIIl.z = lllllllllllllllIIllllIlIIlIIIlIl;
        lllllllllllllllIIllllIlIIlIIIIIl.yaw = lllllllllllllllIIllllIlIIlIIIlII;
        lllllllllllllllIIllllIlIIlIIIIIl.pitch = lllllllllllllllIIllllIlIIIllllII;
        lllllllllllllllIIllllIlIIlIIIIIl.onGround = lllllllllllllllIIllllIlIIlIIIIlI;
    }

    public void setYaw(float lllllllllllllllIIllllIlIIIIlllll) {
        lllllllllllllllIIllllIlIIIlIIIII.yaw = lllllllllllllllIIllllIlIIIIlllll;
    }

    public double getX() {
        PlayerHook lllllllllllllllIIllllIlIIIIlIlIl;
        return lllllllllllllllIIllllIlIIIIlIlIl.x;
    }

    public double getZ() {
        PlayerHook lllllllllllllllIIllllIlIIIIIllll;
        return lllllllllllllllIIllllIlIIIIIllll.z;
    }

    public double getY() {
        PlayerHook lllllllllllllllIIllllIlIIIIlIIlI;
        return lllllllllllllllIIllllIlIIIIlIIlI.y;
    }

    public void setPitch(float lllllllllllllllIIllllIlIIIlIIlIl) {
        lllllllllllllllIIllllIlIIIlIIllI.pitch = lllllllllllllllIIllllIlIIIlIIlIl;
    }

    public float getPitch() {
        PlayerHook lllllllllllllllIIllllIlIIIIIlIll;
        return lllllllllllllllIIllllIlIIIIIlIll.pitch;
    }

    public boolean isOnGround() {
        PlayerHook lllllllllllllllIIllllIlIIIIIIlIl;
        return lllllllllllllllIIllllIlIIIIIIlIl.onGround;
    }
}

