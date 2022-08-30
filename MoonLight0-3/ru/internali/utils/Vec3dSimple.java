/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils;

public class Vec3dSimple {
    public /* synthetic */ double z;
    public /* synthetic */ double x;
    public /* synthetic */ double y;

    public Vec3dSimple(double lIIllIIIlllIIl, double lIIllIIIlllIII, double lIIllIIIlllIll) {
        Vec3dSimple lIIllIIIlllIlI;
        lIIllIIIlllIlI.x = lIIllIIIlllIIl;
        lIIllIIIlllIlI.y = lIIllIIIlllIII;
        lIIllIIIlllIlI.z = lIIllIIIlllIll;
    }

    public boolean equals(Object lIIllIIIlIllll) {
        if (lIIllIIIlIllll instanceof Vec3dSimple) {
            Vec3dSimple lIIllIIIllIIlI;
            Vec3dSimple lIIllIIIllIIll = (Vec3dSimple)lIIllIIIlIllll;
            return lIIllIIIllIIll.x == lIIllIIIllIIlI.x && lIIllIIIllIIll.y == lIIllIIIllIIlI.y && lIIllIIIllIIll.z == lIIllIIIllIIlI.z;
        }
        return false;
    }

    public void round() {
        Vec3dSimple lIIllIIIlIllII;
        lIIllIIIlIllII.x = Math.round(lIIllIIIlIllII.x);
        lIIllIIIlIllII.y = Math.round(lIIllIIIlIllII.y);
        lIIllIIIlIllII.z = Math.round(lIIllIIIlIllII.z);
    }
}

