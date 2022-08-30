/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils;

import ru.internali.utils.Event;

public class EventPreMotionUpdate
extends Event {
    private /* synthetic */ float pitch;
    private /* synthetic */ float yaw;
    public /* synthetic */ double z;
    private /* synthetic */ boolean ground;
    public /* synthetic */ double y;
    public /* synthetic */ double x;

    public float getYaw() {
        EventPreMotionUpdate lIIlIIllllllIl;
        return lIIlIIllllllIl.yaw;
    }

    public void setPitch(float lIIlIIlllIllll) {
        lIIlIIlllIlllI.pitch = lIIlIIlllIllll;
    }

    public boolean onGround() {
        EventPreMotionUpdate lIIlIIlllIlIll;
        return lIIlIIlllIlIll.ground;
    }

    public void setYaw(float lIIlIIlllllIII) {
        lIIlIIlllllIIl.yaw = lIIlIIlllllIII;
    }

    public EventPreMotionUpdate(float lIIlIlIIIIIlII, float lIIlIlIIIIlIlI, boolean lIIlIlIIIIlIIl, double lIIlIlIIIIlIII, double lIIlIlIIIIIIII, double lIIlIIllllllll) {
        EventPreMotionUpdate lIIlIlIIIIIlIl;
        lIIlIlIIIIIlIl.yaw = lIIlIlIIIIIlII;
        lIIlIlIIIIIlIl.pitch = lIIlIlIIIIlIlI;
        lIIlIlIIIIIlIl.ground = lIIlIlIIIIlIIl;
        lIIlIlIIIIIlIl.x = lIIlIlIIIIlIII;
        lIIlIlIIIIIlIl.y = lIIlIlIIIIIIII;
        lIIlIlIIIIIlIl.z = lIIlIIllllllll;
    }

    public float getPitch() {
        EventPreMotionUpdate lIIlIIllllIIll;
        return lIIlIIllllIIll.pitch;
    }

    public void setGround(boolean lIIlIIlllIIlII) {
        lIIlIIlllIIlll.ground = lIIlIIlllIIlII;
    }
}

