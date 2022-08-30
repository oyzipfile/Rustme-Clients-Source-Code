/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils.animation;

public final class Stopwatch {
    private /* synthetic */ long ms;

    public final long getElapsedTime() {
        Stopwatch lIIllIIIlIIIII;
        return lIIllIIIlIIIII.getCurrentMS() - lIIllIIIlIIIII.ms;
    }

    public final boolean elapsed(long lIIllIIIIllIlI) {
        Stopwatch lIIllIIIIllIll;
        return lIIllIIIIllIll.getCurrentMS() - lIIllIIIIllIll.ms > lIIllIIIIllIlI;
    }

    public Stopwatch() {
        Stopwatch lIIllIIIlIIlII;
        lIIllIIIlIIlII.ms = lIIllIIIlIIlII.getCurrentMS();
    }

    public final void reset() {
        Stopwatch lIIllIIIIllIII;
        lIIllIIIIllIII.ms = lIIllIIIIllIII.getCurrentMS();
    }

    private long getCurrentMS() {
        return System.currentTimeMillis();
    }
}

