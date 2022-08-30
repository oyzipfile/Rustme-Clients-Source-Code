/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils;

import ru.internali.utils.EventCancellable;

public class EventStrafe
extends EventCancellable {
    private /* synthetic */ float yaw;
    private /* synthetic */ float forward;
    private /* synthetic */ float strafe;
    private /* synthetic */ float friction;

    public float getForward() {
        EventStrafe lIIIIllIlllIllI;
        return lIIIIllIlllIllI.forward;
    }

    public float getYaw() {
        EventStrafe lIIIIllIllIIlIl;
        return lIIIIllIllIIlIl.yaw;
    }

    public void setStrafe(float lIIIIllIllllIIl) {
        lIIIIllIllllIlI.strafe = lIIIIllIllllIIl;
    }

    public void setYaw(float lIIIIllIllIIIII) {
        lIIIIllIllIIIIl.yaw = lIIIIllIllIIIII;
    }

    public void setFriction(float lIIIIllIllIlIIl) {
        lIIIIllIllIlIII.friction = lIIIIllIllIlIIl;
    }

    public float getFriction() {
        EventStrafe lIIIIllIllIlllI;
        return lIIIIllIllIlllI.friction;
    }

    public void setForward(float lIIIIllIlllIIlI) {
        lIIIIllIlllIIll.forward = lIIIIllIlllIIlI;
    }

    @Override
    public boolean cancel() {
        return false;
    }

    public EventStrafe(float lIIIIlllIIIlIlI, float lIIIIlllIIIIlII, float lIIIIlllIIIlIII, float lIIIIlllIIIIIlI) {
        EventStrafe lIIIIlllIIIlIll;
        lIIIIlllIIIlIll.yaw = lIIIIlllIIIlIlI;
        lIIIIlllIIIlIll.strafe = lIIIIlllIIIIlII;
        lIIIIlllIIIlIll.forward = lIIIIlllIIIlIII;
        lIIIIlllIIIlIll.friction = lIIIIlllIIIIIlI;
    }

    public float getStrafe() {
        EventStrafe lIIIIllIlllllll;
        return lIIIIllIlllllll.strafe;
    }
}

