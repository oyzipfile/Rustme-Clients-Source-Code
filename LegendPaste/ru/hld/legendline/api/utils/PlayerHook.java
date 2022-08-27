/*
 * Decompiled with CFR 0.150.
 */
package ru.hld.legendline.api.utils;

public class PlayerHook {
    /* synthetic */ boolean onGround;
    /* synthetic */ double y;
    /* synthetic */ double x;
    /* synthetic */ double z;
    /* synthetic */ float pitch;
    /* synthetic */ float yaw;

    public float getPitch() {
        PlayerHook llllllllllllllIlIlIlIIIIlIlIlIII;
        return llllllllllllllIlIlIlIIIIlIlIlIII.pitch;
    }

    public PlayerHook(double llllllllllllllIlIlIlIIIIllIlllII, double llllllllllllllIlIlIlIIIIlllIIIlI, double llllllllllllllIlIlIlIIIIllIllIlI, float llllllllllllllIlIlIlIIIIlllIIIII, float llllllllllllllIlIlIlIIIIllIlllll, boolean llllllllllllllIlIlIlIIIIllIlIlll) {
        PlayerHook llllllllllllllIlIlIlIIIIllIlllIl;
        llllllllllllllIlIlIlIIIIllIlllIl.x = llllllllllllllIlIlIlIIIIllIlllII;
        llllllllllllllIlIlIlIIIIllIlllIl.y = llllllllllllllIlIlIlIIIIlllIIIlI;
        llllllllllllllIlIlIlIIIIllIlllIl.z = llllllllllllllIlIlIlIIIIllIllIlI;
        llllllllllllllIlIlIlIIIIllIlllIl.yaw = llllllllllllllIlIlIlIIIIlllIIIII;
        llllllllllllllIlIlIlIIIIllIlllIl.pitch = llllllllllllllIlIlIlIIIIllIlllll;
        llllllllllllllIlIlIlIIIIllIlllIl.onGround = llllllllllllllIlIlIlIIIIllIlIlll;
    }

    public double getX() {
        PlayerHook llllllllllllllIlIlIlIIIIlIllIIII;
        return llllllllllllllIlIlIlIIIIlIllIIII.x;
    }

    public void setPitch(float llllllllllllllIlIlIlIIIIllIIIIIl) {
        llllllllllllllIlIlIlIIIIllIIIIII.pitch = llllllllllllllIlIlIlIIIIllIIIIIl;
    }

    public double getY() {
        PlayerHook llllllllllllllIlIlIlIIIIlIlIllIl;
        return llllllllllllllIlIlIlIIIIlIlIllIl.y;
    }

    public double getZ() {
        PlayerHook llllllllllllllIlIlIlIIIIlIlIlIll;
        return llllllllllllllIlIlIlIIIIlIlIlIll.z;
    }

    public void setOnGround(boolean llllllllllllllIlIlIlIIIIllIIIlIl) {
        llllllllllllllIlIlIlIIIIllIIIllI.onGround = llllllllllllllIlIlIlIIIIllIIIlIl;
    }

    public void setZ(double llllllllllllllIlIlIlIIIIlIllIlIl) {
        llllllllllllllIlIlIlIIIIlIllIllI.z = llllllllllllllIlIlIlIIIIlIllIlIl;
    }

    public void setY(double llllllllllllllIlIlIlIIIIllIIlIll) {
        llllllllllllllIlIlIlIIIIllIIllII.y = llllllllllllllIlIlIlIIIIllIIlIll;
    }

    public void setX(double llllllllllllllIlIlIlIIIIllIlIIll) {
        llllllllllllllIlIlIlIIIIllIlIlII.x = llllllllllllllIlIlIlIIIIllIlIIll;
    }

    public float getYaw() {
        PlayerHook llllllllllllllIlIlIlIIIIlIlIIlII;
        return llllllllllllllIlIlIlIIIIlIlIIlII.yaw;
    }

    public void setYaw(float llllllllllllllIlIlIlIIIIlIlllIIl) {
        llllllllllllllIlIlIlIIIIlIllllII.yaw = llllllllllllllIlIlIlIIIIlIlllIIl;
    }

    public boolean isOnGround() {
        PlayerHook llllllllllllllIlIlIlIIIIlIlIIIlI;
        return llllllllllllllIlIlIlIIIIlIlIIIlI.onGround;
    }
}

