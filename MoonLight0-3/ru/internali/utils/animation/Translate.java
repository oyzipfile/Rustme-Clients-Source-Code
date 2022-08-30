/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils.animation;

import ru.internali.utils.animation.AnimationUtil;

public final class Translate {
    private /* synthetic */ double x;
    private /* synthetic */ double y;

    public Translate(float llllIIlIlIllllI, float llllIIlIlIlllIl) {
        Translate llllIIlIlIlllII;
        llllIIlIlIlllII.x = llllIIlIlIllllI;
        llllIIlIlIlllII.y = llllIIlIlIlllIl;
    }

    public void animate(double llllIIlIlIIIllI, double llllIIlIlIIlIII) {
        Translate llllIIlIlIIlIlI;
        llllIIlIlIIlIlI.x = AnimationUtil.animate(llllIIlIlIIlIlI.x, llllIIlIlIIIllI, 1.0);
        llllIIlIlIIlIlI.y = AnimationUtil.animate(llllIIlIlIIlIlI.y, llllIIlIlIIlIII, 1.0);
    }

    public void setX(double llllIIlIIlllllI) {
        llllIIlIIllllIl.x = llllIIlIIlllllI;
    }

    public final void interpolate(double llllIIlIlIlIIII, double llllIIlIlIIllll, double llllIIlIlIlIIlI) {
        Translate llllIIlIlIlIIIl;
        llllIIlIlIlIIIl.x = AnimationUtil.animate(llllIIlIlIlIIII, llllIIlIlIlIIIl.x, llllIIlIlIlIIlI);
        llllIIlIlIlIIIl.y = AnimationUtil.animate(llllIIlIlIIllll, llllIIlIlIlIIIl.y, llllIIlIlIlIIlI);
    }

    public double getX() {
        Translate llllIIlIlIIIIlI;
        return llllIIlIlIIIIlI.x;
    }

    public void setY(double llllIIlIIllIIll) {
        llllIIlIIllIlII.y = llllIIlIIllIIll;
    }

    public double getY() {
        Translate llllIIlIIlllIlI;
        return llllIIlIIlllIlI.y;
    }
}

