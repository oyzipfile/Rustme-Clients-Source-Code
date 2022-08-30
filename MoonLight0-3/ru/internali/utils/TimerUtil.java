/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils;

public class TimerUtil {
    public /* synthetic */ long lastMS;
    private /* synthetic */ long previousMS;

    public void reset() {
        TimerUtil llIllllIIIlllI;
        llIllllIIIlllI.previousMS = llIllllIIIlllI.getTime();
    }

    public TimerUtil() {
        TimerUtil llIllllIIlIIIl;
        llIllllIIlIIIl.previousMS = 0L;
    }

    public boolean hasReached(double llIllllIIIIlll) {
        TimerUtil llIllllIIIlIlI;
        return (double)(llIllllIIIlIlI.getTime() - llIllllIIIlIlI.previousMS) >= llIllllIIIIlll;
    }

    public long getTime() {
        return System.nanoTime() / 1000000L;
    }

    public boolean delay(float llIllllIIIIIlI) {
        TimerUtil llIllllIIIIIll;
        return (float)(llIllllIIIIIll.getTime() - llIllllIIIIIll.lastMS) >= llIllllIIIIIlI;
    }
}

