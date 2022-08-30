/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils;

import ru.internali.utils.TimerUtil;

public class AnimationUtils {
    private static /* synthetic */ float defaultSpeed;
    private /* synthetic */ TimerUtil timerUtil;

    public float moveUD(float llIllIllllIIlI, float llIllIllllIIIl, float llIllIlllIlIlI, float llIllIlllIllll) {
        AnimationUtils llIllIllllIIll;
        float llIllIlllIlllI = 0.0f;
        if (llIllIllllIIll.timerUtil.delay(20.0f)) {
            llIllIlllIlllI = (llIllIllllIIIl - llIllIllllIIlI) * llIllIlllIlIlI;
            if (llIllIlllIlllI > 0.0f) {
                llIllIlllIlllI = Math.max(llIllIlllIllll, llIllIlllIlllI);
                llIllIlllIlllI = Math.min(llIllIllllIIIl - llIllIllllIIlI, llIllIlllIlllI);
            } else if (llIllIlllIlllI < 0.0f) {
                llIllIlllIlllI = Math.min(-llIllIlllIllll, llIllIlllIlllI);
                llIllIlllIlllI = Math.max(llIllIllllIIIl - llIllIllllIIlI, llIllIlllIlllI);
            }
            llIllIllllIIll.timerUtil.reset();
        }
        return llIllIllllIIlI + llIllIlllIlllI;
    }

    static {
        defaultSpeed = 0.125f;
    }

    public static float calculateCompensation(float llIlllIlIIIIII, float llIlllIIlllIlI, long llIlllIIlllllI, double llIlllIIlllIII) {
        float llIlllIIllllII = llIlllIIlllIlI - llIlllIlIIIIII;
        if (llIlllIIlllllI < 1L) {
            llIlllIIlllllI = 1L;
        }
        if (llIlllIIlllllI > 1000L) {
            llIlllIIlllllI = 16L;
        }
        if ((double)llIlllIIllllII > llIlllIIlllIII) {
            float f;
            double llIlllIlIIIIlI = llIlllIIlllIII * (double)llIlllIIlllllI / 16.0 < 0.5 ? 0.5 : llIlllIIlllIII * (double)llIlllIIlllllI / 16.0;
            llIlllIIlllIlI = (float)((double)llIlllIIlllIlI - llIlllIlIIIIlI);
            if (f < llIlllIlIIIIII) {
                llIlllIIlllIlI = llIlllIlIIIIII;
            }
        } else if ((double)llIlllIIllllII < -llIlllIIlllIII) {
            float f;
            double llIlllIlIIIIIl = llIlllIIlllIII * (double)llIlllIIlllllI / 16.0 < 0.5 ? 0.5 : llIlllIIlllIII * (double)llIlllIIlllllI / 16.0;
            llIlllIIlllIlI = (float)((double)llIlllIIlllIlI + llIlllIlIIIIIl);
            if (f > llIlllIlIIIIII) {
                llIlllIIlllIlI = llIlllIlIIIIII;
            }
        } else {
            llIlllIIlllIlI = llIlllIlIIIIII;
        }
        return llIlllIIlllIlI;
    }

    public AnimationUtils() {
        AnimationUtils llIlllIlIIlIIl;
        llIlllIlIIlIIl.timerUtil = new TimerUtil();
    }

    public float animate(float llIlllIIIIIIII, float llIllIllllllll, float llIllIlllllllI) {
        AnimationUtils llIlllIIIIIIIl;
        if (llIlllIIIIIIIl.timerUtil.delay(4.0f)) {
            boolean llIlllIIIIlIIl = llIlllIIIIIIII > llIllIllllllll;
            boolean llIlllIIIIlIII = llIlllIIIIlIIl;
            if (llIllIlllllllI < 0.0f) {
                llIllIlllllllI = 0.0f;
            } else if ((double)llIllIlllllllI > 1.0) {
                llIllIlllllllI = 1.0f;
            }
            float llIlllIIIIIlll = Math.max(llIlllIIIIIIII, llIllIllllllll) - Math.min(llIlllIIIIIIII, llIllIllllllll);
            float llIlllIIIIIllI = llIlllIIIIIlll * llIllIlllllllI;
            if (llIlllIIIIIllI < 0.1f) {
                llIlllIIIIIllI = 0.1f;
            }
            llIllIllllllll = llIlllIIIIlIIl ? (llIllIllllllll = llIllIllllllll + llIlllIIIIIllI) : (llIllIllllllll = llIllIllllllll - llIlllIIIIIllI);
            llIlllIIIIIIIl.timerUtil.reset();
        }
        if ((double)Math.abs(llIllIllllllll - llIlllIIIIIIII) < 0.2) {
            return llIlllIIIIIIII;
        }
        return llIllIllllllll;
    }

    public float mvoeUD(float llIlllIIllIIII, float llIlllIIlIllll, float llIlllIIlIlIlI) {
        AnimationUtils llIlllIIllIIIl;
        return llIlllIIllIIIl.moveUD(llIlllIIllIIII, llIlllIIlIllll, defaultSpeed, llIlllIIlIlIlI);
    }

    public double animate(double llIlllIIIlllII, double llIlllIIIlIlll, double llIlllIIIllIlI) {
        AnimationUtils llIlllIIIlllIl;
        if (llIlllIIIlllIl.timerUtil.delay(4.0f)) {
            boolean llIlllIIlIIIIl = llIlllIIIlllII > llIlllIIIlIlll;
            boolean llIlllIIlIIIII = llIlllIIlIIIIl;
            if (llIlllIIIllIlI < 0.0) {
                llIlllIIIllIlI = 0.0;
            } else if (llIlllIIIllIlI > 1.0) {
                llIlllIIIllIlI = 1.0;
            }
            double llIlllIIIlllll = Math.max(llIlllIIIlllII, llIlllIIIlIlll) - Math.min(llIlllIIIlllII, llIlllIIIlIlll);
            double llIlllIIIllllI = llIlllIIIlllll * llIlllIIIllIlI;
            if (llIlllIIIllllI < 0.1) {
                llIlllIIIllllI = 0.1;
            }
            llIlllIIIlIlll = llIlllIIlIIIIl ? (llIlllIIIlIlll = llIlllIIIlIlll + llIlllIIIllllI) : (llIlllIIIlIlll = llIlllIIIlIlll - llIlllIIIllllI);
            llIlllIIIlllIl.timerUtil.reset();
        }
        return llIlllIIIlIlll;
    }
}

