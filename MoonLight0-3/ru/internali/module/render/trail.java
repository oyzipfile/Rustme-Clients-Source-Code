/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.module.render;

import ru.internali.utils.TimerUtils;

public class trail {
    /* synthetic */ double x;
    /* synthetic */ double y;
    /* synthetic */ TimerUtils timer;
    /* synthetic */ double z;

    public double getX() {
        trail lllIIIllllIlIl;
        return lllIIIllllIlIl.x;
    }

    public TimerUtils getTimer() {
        trail lllIIIlllllllI;
        return lllIIIlllllllI.timer;
    }

    public trail(double lllIIlIIIIIllI, double lllIIlIIIIIlIl, double lllIIlIIIIIIII) {
        trail lllIIlIIIIIlll;
        lllIIlIIIIIlll.x = lllIIlIIIIIllI;
        lllIIlIIIIIlll.y = lllIIlIIIIIlIl;
        lllIIlIIIIIlll.z = lllIIlIIIIIIII;
        lllIIlIIIIIlll.timer = new TimerUtils();
    }

    public double getZ() {
        trail lllIIIlllllIll;
        return lllIIIlllllIll.z;
    }

    public double getY() {
        trail lllIIIllllIlll;
        return lllIIIllllIlll.y;
    }
}

