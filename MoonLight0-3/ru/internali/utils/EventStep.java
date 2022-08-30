/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils;

import ru.internali.utils.Event;

public class EventStep
extends Event {
    private /* synthetic */ double realHeight;
    private /* synthetic */ double stepHeight;
    private /* synthetic */ boolean pre;
    private /* synthetic */ boolean active;

    public EventStep() {
        EventStep lllllIIllllII;
    }

    public void setActive(boolean lllllIIlIIlll) {
        lllllIIlIlIlI.active = lllllIIlIIlll;
    }

    public boolean isActive() {
        EventStep lllllIIllIIll;
        return lllllIIllIIll.active;
    }

    public boolean isPre() {
        EventStep lllllIIlllIIl;
        return lllllIIlllIIl.pre;
    }

    public double getStepHeight() {
        EventStep lllllIIllIlll;
        return lllllIIllIlll.stepHeight;
    }

    public EventStep(boolean lllllIlIIIIll, double lllllIlIIIIlI) {
        EventStep lllllIlIIIIIl;
        lllllIlIIIIIl.pre = lllllIlIIIIll;
        lllllIlIIIIIl.realHeight = lllllIlIIIIlI;
        lllllIlIIIIIl.stepHeight = lllllIlIIIIlI;
    }

    public void setStepHeight(double lllllIIlIllll) {
        lllllIIlIlllI.stepHeight = lllllIIlIllll;
    }

    public void setRealHeight(double lllllIIlIIIII) {
        lllllIIIlllll.realHeight = lllllIIlIIIII;
    }

    public double getRealHeight() {
        EventStep lllllIIlIIlIl;
        return lllllIIlIIlIl.realHeight;
    }

    public EventStep(boolean lllllIlIIlIlI, double lllllIlIIllIl, double lllllIlIIllII) {
        EventStep lllllIlIIllll;
        lllllIlIIllll.pre = lllllIlIIlIlI;
        lllllIlIIllll.stepHeight = lllllIlIIllIl;
        lllllIlIIllll.realHeight = lllllIlIIllII;
    }
}

