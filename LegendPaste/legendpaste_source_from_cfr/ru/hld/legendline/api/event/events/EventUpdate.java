/*
 * Decompiled with CFR 0.150.
 */
package ru.hld.legendline.api.event.events;

import ru.hld.legendline.api.event.Event;

public class EventUpdate
extends Event {
    /* synthetic */ double posY;
    /* synthetic */ double posX;
    /* synthetic */ double posZ;
    /* synthetic */ float rotationYaw;
    /* synthetic */ boolean onGround;
    /* synthetic */ float rotationPitch;

    public double getPosX() {
        EventUpdate llllllllllllllIIlIlllIllIIlIllIl;
        return llllllllllllllIIlIlllIllIIlIllIl.posX;
    }

    public double getPosY() {
        EventUpdate llllllllllllllIIlIlllIllIIllIIII;
        return llllllllllllllIIlIlllIllIIllIIII.posY;
    }

    public void setRotationPitch(float llllllllllllllIIlIlllIllIIIIIIll) {
        llllllllllllllIIlIlllIllIIIIIllI.rotationPitch = llllllllllllllIIlIlllIllIIIIIIll;
    }

    public void setOnGround(boolean llllllllllllllIIlIlllIllIIIIllll) {
        llllllllllllllIIlIlllIllIIIlIIlI.onGround = llllllllllllllIIlIlllIllIIIIllll;
    }

    public void setRotationYaw(float llllllllllllllIIlIlllIlIllllllll) {
        llllllllllllllIIlIlllIllIIIIIIII.rotationYaw = llllllllllllllIIlIlllIlIllllllll;
    }

    public float getRotationPitch() {
        EventUpdate llllllllllllllIIlIlllIllIIlIlIII;
        return llllllllllllllIIlIlllIllIIlIlIII.rotationPitch;
    }

    public float getRotationYaw() {
        EventUpdate llllllllllllllIIlIlllIllIIlIIlII;
        return llllllllllllllIIlIlllIllIIlIIlII.rotationYaw;
    }

    public void setPosZ(double llllllllllllllIIlIlllIllIIIIlIll) {
        llllllllllllllIIlIlllIllIIIIlIlI.posZ = llllllllllllllIIlIlllIllIIIIlIll;
    }

    public EventUpdate(double llllllllllllllIIlIlllIllIIlllIII, double llllllllllllllIIlIlllIllIIlllllI, double llllllllllllllIIlIlllIllIIllIllI, float llllllllllllllIIlIlllIllIIllIlIl, float llllllllllllllIIlIlllIllIIlllIll, boolean llllllllllllllIIlIlllIllIIlllIlI) {
        EventUpdate llllllllllllllIIlIlllIllIlIIIIII;
        llllllllllllllIIlIlllIllIlIIIIII.posX = llllllllllllllIIlIlllIllIIlllIII;
        llllllllllllllIIlIlllIllIlIIIIII.posY = llllllllllllllIIlIlllIllIIlllllI;
        llllllllllllllIIlIlllIllIlIIIIII.posZ = llllllllllllllIIlIlllIllIIllIllI;
        llllllllllllllIIlIlllIllIlIIIIII.rotationYaw = llllllllllllllIIlIlllIllIIllIlIl;
        llllllllllllllIIlIlllIllIlIIIIII.rotationPitch = llllllllllllllIIlIlllIllIIlllIll;
        llllllllllllllIIlIlllIllIlIIIIII.onGround = llllllllllllllIIlIlllIllIIlllIlI;
    }

    public void setPosY(double llllllllllllllIIlIlllIllIIIlllIl) {
        llllllllllllllIIlIlllIllIIIlllII.posY = llllllllllllllIIlIlllIllIIIlllIl;
    }

    public double getPosZ() {
        EventUpdate llllllllllllllIIlIlllIllIIlIlIlI;
        return llllllllllllllIIlIlllIllIIlIlIlI.posZ;
    }

    public boolean isOnGround() {
        EventUpdate llllllllllllllIIlIlllIllIIlIIIlI;
        return llllllllllllllIIlIlllIllIIlIIIlI.onGround;
    }

    public void setPosX(double llllllllllllllIIlIlllIllIIIlIlIl) {
        llllllllllllllIIlIlllIllIIIlIllI.posX = llllllllllllllIIlIlllIllIIIlIlIl;
    }
}

