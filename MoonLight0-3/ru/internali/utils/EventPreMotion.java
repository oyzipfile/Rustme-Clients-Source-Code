/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils;

import ru.internali.utils.Event;

public class EventPreMotion
extends Event {
    private /* synthetic */ boolean onGround;
    private /* synthetic */ double posY;
    private /* synthetic */ float yaw;
    private /* synthetic */ double posZ;
    private /* synthetic */ float pitch;
    private /* synthetic */ double posX;

    public double getPosZ() {
        EventPreMotion lIIIllllllllIlI;
        return lIIIllllllllIlI.posZ;
    }

    public void setOnGround(boolean lIIIllllllIlIll) {
        lIIIllllllIllII.onGround = lIIIllllllIlIll;
    }

    public void setPosZ(double lIIIlllllllIlII) {
        lIIIlllllllIlll.posZ = lIIIlllllllIlII;
    }

    public float getYaw() {
        EventPreMotion lIIlIIIIIIllIll;
        return lIIlIIIIIIllIll.yaw;
    }

    public void setPosY(double lIIIlllllllllIl) {
        lIIlIIIIIIIIIII.posY = lIIIlllllllllIl;
    }

    public double getPosY() {
        EventPreMotion lIIlIIIIIIIIlII;
        return lIIlIIIIIIIIlII.posY;
    }

    public float getPitch() {
        EventPreMotion lIIlIIIIIIlIllI;
        return lIIlIIIIIIlIllI.pitch;
    }

    public void setPosX(double lIIlIIIIIIIlIII) {
        lIIlIIIIIIIlIIl.posX = lIIlIIIIIIIlIII;
    }

    public double getPosX() {
        EventPreMotion lIIlIIIIIIIllII;
        return lIIlIIIIIIIllII.posX;
    }

    public boolean isOnGround() {
        EventPreMotion lIIIlllllllIIlI;
        return lIIIlllllllIIlI.onGround;
    }

    public EventPreMotion(float lIIlIIIIIlIIIll, float lIIlIIIIIlIIIlI, double lIIlIIIIIlIlIII, double lIIlIIIIIlIIlll, double lIIlIIIIIlIIllI, boolean lIIlIIIIIIllllI) {
        EventPreMotion lIIlIIIIIlIlIll;
        lIIlIIIIIlIlIll.yaw = lIIlIIIIIlIIIll;
        lIIlIIIIIlIlIll.pitch = lIIlIIIIIlIIIlI;
        lIIlIIIIIlIlIll.posX = lIIlIIIIIlIlIII;
        lIIlIIIIIlIlIll.posY = lIIlIIIIIlIIlll;
        lIIlIIIIIlIlIll.posZ = lIIlIIIIIlIIllI;
        lIIlIIIIIlIlIll.onGround = lIIlIIIIIIllllI;
    }

    public void setPitch(float lIIlIIIIIIIllll) {
        lIIlIIIIIIlIIII.pitch = lIIlIIIIIIIllll;
    }

    public static void setYaw(float lIIlIIIIIIllIII) {
    }
}

