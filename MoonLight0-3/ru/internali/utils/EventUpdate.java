/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils;

import ru.internali.utils.Event;

public class EventUpdate
extends Event {
    /* synthetic */ double posZ;
    private static /* synthetic */ float pitch;
    /* synthetic */ double posX;
    /* synthetic */ float rotationYaw;
    private static /* synthetic */ float yaw;
    /* synthetic */ double posY;
    /* synthetic */ float rotationPitch;
    /* synthetic */ boolean onGround;

    public EventUpdate(double lIIlIIIlllllIlI, double lIIlIIIlllllIIl, double lIIlIIIlllIllll, float lIIlIIIlllIlllI, float lIIlIIIllllIllI, boolean lIIlIIIlllIllII, float lIIlIIIllllIlII, float lIIlIIIlllIlIlI) {
        EventUpdate lIIlIIIllllIIlI;
        lIIlIIIllllIIlI.posX = lIIlIIIlllllIlI;
        lIIlIIIllllIIlI.posY = lIIlIIIlllllIIl;
        lIIlIIIllllIIlI.posZ = lIIlIIIlllIllll;
        lIIlIIIllllIIlI.rotationYaw = lIIlIIIlllIlllI;
        lIIlIIIllllIIlI.rotationPitch = lIIlIIIllllIllI;
        lIIlIIIllllIIlI.onGround = lIIlIIIlllIllII;
        yaw = lIIlIIIllllIlII;
        pitch = lIIlIIIlllIlIlI;
    }

    public float getRotationPitch() {
        EventUpdate lIIlIIIllIlllll;
        return lIIlIIIllIlllll.rotationPitch;
    }

    public static void setYaw(float lIIlIIlIIIIlIIl) {
        yaw = lIIlIIlIIIIlIIl;
    }

    public double getPosX() {
        EventUpdate lIIlIIIlllIIlII;
        return lIIlIIIlllIIlII.posX;
    }

    public double getPosY() {
        EventUpdate lIIlIIIlllIIlll;
        return lIIlIIIlllIIlll.posY;
    }

    public boolean isOnGround() {
        EventUpdate lIIlIIIllIllIIl;
        return lIIlIIIllIllIIl.onGround;
    }

    public float getRotationYaw() {
        EventUpdate lIIlIIIllIlllII;
        return lIIlIIIllIlllII.rotationYaw;
    }

    public void setPosX(double lIIlIIIllIIlllI) {
        lIIlIIIllIIllIl.posX = lIIlIIIllIIlllI;
    }

    public static void setPitch(float lIIlIIlIIIIIlIl) {
        pitch = lIIlIIlIIIIIlIl;
    }

    public void setPosY(double lIIlIIIllIlIlII) {
        lIIlIIIllIlIlIl.posY = lIIlIIIllIlIlII;
    }

    public static void setOnGround(boolean lIIlIIIllIIlIll) {
    }

    public static void setRotationYaw(float lIIlIIIllIIIIII) {
    }

    public void setPosZ(double lIIlIIIllIIIlll) {
        lIIlIIIllIIlIII.posZ = lIIlIIIllIIIlll;
    }

    public double getPosZ() {
        EventUpdate lIIlIIIlllIIIIl;
        return lIIlIIIlllIIIIl.posZ;
    }

    public static void setRotationPitch(float lIIlIIIllIIIIll) {
    }
}

