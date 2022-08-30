/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils;

public class TimerHelper {
    private /* synthetic */ long previousTime;
    private /* synthetic */ long ms;

    public long getCurrentMS() {
        return System.currentTimeMillis();
    }

    public TimerHelper() {
        TimerHelper lllIllIlIIIIIll;
        lllIllIlIIIIIll.previousTime = -1L;
        lllIllIlIIIIIll.ms = lllIllIlIIIIIll.getCurrentMS();
    }

    public long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public short convert(float lllIllIIllIllll) {
        return (short)(1000.0f / lllIllIIllIllll);
    }

    public boolean check(float lllIllIIlllllIl) {
        TimerHelper lllIllIIllllllI;
        return (float)(lllIllIIllllllI.getCurrentTime() - lllIllIIllllllI.previousTime) >= lllIllIIlllllIl;
    }

    public boolean hasReached(float lllIllIIlllIIll) {
        TimerHelper lllIllIIlllIlII;
        return (float)(lllIllIIlllIlII.getCurrentMS() - lllIllIIlllIlII.ms) > lllIllIIlllIIll;
    }

    public void reset() {
        TimerHelper lllIllIIllllIlI;
        lllIllIIllllIlI.previousTime = lllIllIIllllIlI.getCurrentTime();
    }

    public long getTime() {
        TimerHelper lllIllIIllIlIII;
        return System.currentTimeMillis() - lllIllIIllIlIII.previousTime;
    }

    public long get() {
        TimerHelper lllIllIIllIllIl;
        return lllIllIIllIllIl.previousTime;
    }
}

