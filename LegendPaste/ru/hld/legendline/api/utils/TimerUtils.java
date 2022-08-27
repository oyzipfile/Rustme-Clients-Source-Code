/*
 * Decompiled with CFR 0.150.
 */
package ru.hld.legendline.api.utils;

public class TimerUtils {
    /* synthetic */ long mc;

    public long getMc() {
        TimerUtils lllllllllllllllIIIlIIIlllIlllIII;
        return System.currentTimeMillis() - lllllllllllllllIIIlIIIlllIlllIII.mc;
    }

    public TimerUtils() {
        TimerUtils lllllllllllllllIIIlIIIlllIlllllI;
        lllllllllllllllIIIlIIIlllIlllllI.mc = System.currentTimeMillis();
    }

    public void reset() {
        lllllllllllllllIIIlIIIlllIlllIll.mc = System.currentTimeMillis();
    }

    public boolean hasReached(long lllllllllllllllIIIlIIIlllIllIIlI) {
        TimerUtils lllllllllllllllIIIlIIIlllIllIlIl;
        return System.currentTimeMillis() - lllllllllllllllIIIlIIIlllIllIlIl.mc > lllllllllllllllIIIlIIIlllIllIIlI;
    }
}

