/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 */
package new_gui.util;

import net.minecraft.client.Minecraft;

public class AnimationHelper {
    public static /* synthetic */ int deltaTime;
    private /* synthetic */ State currentState;
    private /* synthetic */ long currentStateStart;
    private /* synthetic */ int time;
    private /* synthetic */ boolean initialState;
    private /* synthetic */ State previousState;
    public static /* synthetic */ float speedTarget;

    public static float calculateCompensation(float lIIIIlllIlIIlIl, float lIIIIlllIlIIlII, long lIIIIlllIlIIIll, double lIIIIlllIIlllIl) {
        float lIIIIlllIlIIIIl = lIIIIlllIlIIlII - lIIIIlllIlIIlIl;
        if (lIIIIlllIlIIIll < 1L) {
            lIIIIlllIlIIIll = 1L;
        }
        if (lIIIIlllIlIIIll > 1000L) {
            lIIIIlllIlIIIll = 16L;
        }
        if ((double)lIIIIlllIlIIIIl > lIIIIlllIIlllIl) {
            double lIIIIlllIlIIlll = lIIIIlllIIlllIl * (double)lIIIIlllIlIIIll / 16.0 < 0.5 ? 0.5 : lIIIIlllIIlllIl * (double)lIIIIlllIlIIIll / 16.0;
            if ((lIIIIlllIlIIlII = (float)((double)lIIIIlllIlIIlII - lIIIIlllIlIIlll)) < lIIIIlllIlIIlIl) {
                lIIIIlllIlIIlII = lIIIIlllIlIIlIl;
            }
        } else if ((double)lIIIIlllIlIIIIl < -lIIIIlllIIlllIl) {
            double lIIIIlllIlIIllI = lIIIIlllIIlllIl * (double)lIIIIlllIlIIIll / 16.0 < 0.5 ? 0.5 : lIIIIlllIIlllIl * (double)lIIIIlllIlIIIll / 16.0;
            if ((lIIIIlllIlIIlII = (float)((double)lIIIIlllIlIIlII + lIIIIlllIlIIllI)) > lIIIIlllIlIIlIl) {
                lIIIIlllIlIIlII = lIIIIlllIlIIlIl;
            }
        } else {
            lIIIIlllIlIIlII = lIIIIlllIlIIlIl;
        }
        return lIIIIlllIlIIlII;
    }

    public static double animate(double lIIIIlllIllIIll, double lIIIIlllIlllIII, double lIIIIlllIllIIIl) {
        boolean lIIIIlllIllIllI;
        boolean bl = lIIIIlllIllIllI = lIIIIlllIllIIll > lIIIIlllIlllIII;
        if (lIIIIlllIllIIIl < 0.0) {
            lIIIIlllIllIIIl = 0.0;
        } else if (lIIIIlllIllIIIl > 1.0) {
            lIIIIlllIllIIIl = 1.0;
        }
        double lIIIIlllIllIlIl = Math.max(lIIIIlllIllIIll, lIIIIlllIlllIII) - Math.min(lIIIIlllIllIIll, lIIIIlllIlllIII);
        double lIIIIlllIllIlII = lIIIIlllIllIlIl * lIIIIlllIllIIIl;
        if (lIIIIlllIllIlII < 0.1) {
            lIIIIlllIllIlII = 0.1;
        }
        lIIIIlllIlllIII = lIIIIlllIllIllI ? (lIIIIlllIlllIII = lIIIIlllIlllIII + lIIIIlllIllIlII) : (lIIIIlllIlllIII = lIIIIlllIlllIII - lIIIIlllIllIlII);
        return lIIIIlllIlllIII;
    }

    public double getAnimationFactor() {
        AnimationHelper lIIIIllllIIIIIl;
        if (lIIIIllllIIIIIl.currentState == State.EXPANDING) {
            return (double)(System.currentTimeMillis() - lIIIIllllIIIIIl.currentStateStart) / (double)lIIIIllllIIIIIl.time;
        }
        if (lIIIIllllIIIIIl.currentState == State.RETRACTING) {
            return (double)((long)lIIIIllllIIIIIl.time - (System.currentTimeMillis() - lIIIIllllIIIIIl.currentStateStart)) / (double)lIIIIllllIIIIIl.time;
        }
        return lIIIIllllIIIIIl.previousState == State.EXPANDING ? 1.0 : 0.0;
    }

    public AnimationHelper(int lIIIIllllIlIIll, boolean lIIIIllllIIllll) {
        AnimationHelper lIIIIllllIlIlII;
        lIIIIllllIlIlII.previousState = State.STATIC;
        lIIIIllllIlIlII.currentState = State.STATIC;
        lIIIIllllIlIlII.currentStateStart = 0L;
        lIIIIllllIlIlII.time = lIIIIllllIlIIll;
        lIIIIllllIlIlII.initialState = lIIIIllllIIllll;
        if (lIIIIllllIIllll) {
            lIIIIllllIlIlII.previousState = State.EXPANDING;
        }
    }

    public static float animation(float lIIIIllllIIlIlI, float lIIIIllllIIlIIl, float lIIIIllllIIIlII) {
        float lIIIIllllIIIlll = (lIIIIllllIIlIIl - lIIIIllllIIlIlI) / (float)Minecraft.getDebugFPS() * 15.0f;
        if (lIIIIllllIIIlll > 0.0f) {
            lIIIIllllIIIlll = Math.max(lIIIIllllIIIlII, lIIIIllllIIIlll);
            lIIIIllllIIIlll = Math.min(lIIIIllllIIlIIl - lIIIIllllIIlIlI, lIIIIllllIIIlll);
        } else if (lIIIIllllIIIlll < 0.0f) {
            lIIIIllllIIIlll = Math.min(-lIIIIllllIIIlII, lIIIIllllIIIlll);
            lIIIIllllIIIlll = Math.max(lIIIIllllIIlIIl - lIIIIllllIIlIlI, lIIIIllllIIIlll);
        }
        return lIIIIllllIIlIlI + lIIIIllllIIIlll;
    }

    static {
        speedTarget = 0.125f;
    }

    public static enum State {
        EXPANDING,
        RETRACTING,
        STATIC;


        private State() {
            State lIlllIllIlIlIl;
        }
    }
}

