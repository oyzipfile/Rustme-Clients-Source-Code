/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils;

public class Timerr {
    private /* synthetic */ long prevMS;

    public long getTime() {
        return System.nanoTime() / 1000000L;
    }

    public void setDifference(long lIIlIlIIIllIlII) {
        Timerr lIIlIlIIIllIIll;
        lIIlIlIIIllIIll.prevMS = lIIlIlIIIllIIll.getTime() - lIIlIlIIIllIlII;
    }

    public void reset() {
        Timerr lIIlIlIIIllllII;
        lIIlIlIIIllllII.prevMS = lIIlIlIIIllllII.getTime();
    }

    public Timerr() {
        Timerr lIIlIlIIlIIIllI;
        lIIlIlIIlIIIllI.prevMS = 0L;
    }

    public long getDifference() {
        Timerr lIIlIlIIIlllIIl;
        return lIIlIlIIIlllIIl.getTime() - lIIlIlIIIlllIIl.prevMS;
    }

    public boolean delay(float lIIlIlIIIllllll) {
        Timerr lIIlIlIIlIIIIII;
        return (float)(lIIlIlIIlIIIIII.getTime() - lIIlIlIIlIIIIII.prevMS) >= lIIlIlIIIllllll;
    }
}

