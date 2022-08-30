/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils;

import ru.internali.utils.animation.AnimationUtil;

public final class Translate {
    private /* synthetic */ double y;
    private /* synthetic */ double x;

    public final void interpolate(double llIlIIlIlIlIIlI, double llIlIIlIlIlIIIl, double llIlIIlIlIlIlII) {
        Translate llIlIIlIlIlIlll;
        llIlIIlIlIlIlll.x = AnimationUtil.animate(llIlIIlIlIlIIlI, llIlIIlIlIlIlll.x, llIlIIlIlIlIlII);
        llIlIIlIlIlIlll.y = AnimationUtil.animate(llIlIIlIlIlIIIl, llIlIIlIlIlIlll.y, llIlIIlIlIlIlII);
    }

    public void animate(double llIlIIlIlIIlIII, double llIlIIlIlIIlIlI) {
        Translate llIlIIlIlIIllII;
        llIlIIlIlIIllII.x = AnimationUtil.animate(llIlIIlIlIIllII.x, llIlIIlIlIIlIII, 1.0);
        llIlIIlIlIIllII.y = AnimationUtil.animate(llIlIIlIlIIllII.y, llIlIIlIlIIlIlI, 1.0);
    }

    public void setX(double llIlIIlIlIIIIII) {
        llIlIIlIlIIIIIl.x = llIlIIlIlIIIIII;
    }

    public double getY() {
        Translate llIlIIlIIllllII;
        return llIlIIlIIllllII.y;
    }

    public double getX() {
        Translate llIlIIlIlIIIlII;
        return llIlIIlIlIIIlII.x;
    }

    public void setY(double llIlIIlIIllIlll) {
        llIlIIlIIlllIII.y = llIlIIlIIllIlll;
    }

    public Translate(float llIlIIlIllIIIII, float llIlIIlIlIlllll) {
        Translate llIlIIlIllIIIIl;
        llIlIIlIllIIIIl.x = llIlIIlIllIIIII;
        llIlIIlIllIIIIl.y = llIlIIlIlIlllll;
    }
}

