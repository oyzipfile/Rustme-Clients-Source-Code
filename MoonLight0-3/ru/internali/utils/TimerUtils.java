/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils;

public class TimerUtils {
    private /* synthetic */ long lastMS;
    private /* synthetic */ long prevMS;
    /* synthetic */ long MC;

    public long getCurrentMS() {
        return System.nanoTime() / 1000000L;
    }

    public boolean isDelay(long lllIIllIlIlIIIl) {
        TimerUtils lllIIllIlIlIIII;
        return System.currentTimeMillis() - lllIIllIlIlIIII.lastMS >= lllIIllIlIlIIIl;
    }

    public long getTime() {
        return System.nanoTime() / 1000000L;
    }

    public int convertToMS(int lllIIllIIlllIll) {
        return 1000 / lllIIllIIlllIll;
    }

    public boolean hasReached(float lllIIllIIllIlll) {
        TimerUtils lllIIllIIlllIII;
        return (float)(lllIIllIIlllIII.getCurrentMS() - lllIIllIIlllIII.lastMS) >= lllIIllIIllIlll;
    }

    public void setLastMS(long lllIIllIlIIIlII) {
        lllIIllIlIIIlIl.lastMS = lllIIllIlIIIlII;
    }

    public void setLastMS() {
        lllIIllIIllllll.lastMS = System.currentTimeMillis();
    }

    public TimerUtils() {
        TimerUtils lllIIllIlIlIllI;
        lllIIllIlIlIllI.lastMS = 0L;
        lllIIllIlIlIllI.MC = System.currentTimeMillis();
        lllIIllIlIlIllI.prevMS = 0L;
    }

    public void reset() {
        TimerUtils lllIIllIIllIIlI;
        lllIIllIIllIIlI.lastMS = lllIIllIIllIIlI.getCurrentMS();
    }

    public boolean delay(float lllIIllIIlIlllI) {
        TimerUtils lllIIllIIlIllll;
        return (float)(lllIIllIIlIllll.getTime() - lllIIllIIlIllll.prevMS) >= lllIIllIIlIlllI;
    }

    public boolean isDeley(long lllIIllIlIIlIll) {
        TimerUtils lllIIllIlIIllII;
        return System.currentTimeMillis() - lllIIllIlIIllII.MC >= lllIIllIlIIlIll;
    }
}

