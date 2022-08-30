/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils;

import ru.internali.utils.EventCancellable;

public class EventMove
extends EventCancellable {
    private /* synthetic */ double z;
    private /* synthetic */ double x;
    private /* synthetic */ double y;

    public void setZ(double lIIIlIIlllIlIIl) {
        lIIIlIIlllIlIlI.z = lIIIlIIlllIlIIl;
    }

    public void setY(double lIIIlIIllllIIlI) {
        lIIIlIIllllIIll.y = lIIIlIIllllIIlI;
    }

    public double getX() {
        EventMove lIIIlIlIIIIIIlI;
        return lIIIlIlIIIIIIlI.x;
    }

    public void setX(double lIIIlIIlllllIll) {
        lIIIlIIlllllllI.x = lIIIlIIlllllIll;
    }

    public double getZ() {
        EventMove lIIIlIIlllIllll;
        return lIIIlIIlllIllll.z;
    }

    @Override
    public boolean cancel() {
        return false;
    }

    public double getY() {
        EventMove lIIIlIIlllllIII;
        return lIIIlIIlllllIII.y;
    }

    public EventMove(double lIIIlIlIIIIlIlI, double lIIIlIlIIIIlIIl, double lIIIlIlIIIIlIII) {
        EventMove lIIIlIlIIIIIlll;
        lIIIlIlIIIIIlll.x = lIIIlIlIIIIlIlI;
        lIIIlIlIIIIIlll.y = lIIIlIlIIIIlIIl;
        lIIIlIlIIIIIlll.z = lIIIlIlIIIIlIII;
    }
}

