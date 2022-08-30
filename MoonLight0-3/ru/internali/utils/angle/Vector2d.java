/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils.angle;

import java.io.Serializable;
import javax.vecmath.Tuple2d;
import javax.vecmath.Tuple2f;
import ru.internali.utils.angle.Vector2f;

public class Vector2d
extends Tuple2d
implements Serializable {
    static final /* synthetic */ long serialVersionUID = 8572646365302599857L;

    public Vector2d(Vector2f lIIIllIlIllIIl) {
        super(lIIIllIlIllIIl);
        Vector2d lIIIllIlIllIlI;
    }

    public Vector2d(Vector2d lIIIllIlIlllll) {
        super(lIIIllIlIlllll);
        Vector2d lIIIllIllIIIII;
    }

    public Vector2d() {
        Vector2d lIIIllIlIIlIIl;
    }

    public Vector2d(double lIIIllIllIllIl, double lIIIllIllIllII) {
        super(lIIIllIllIllIl, lIIIllIllIllII);
        Vector2d lIIIllIllIlllI;
    }

    public final double lengthSquared() {
        Vector2d lIIIllIIllllII;
        return lIIIllIIllllII.x * lIIIllIIllllII.x + lIIIllIIllllII.y * lIIIllIIllllII.y;
    }

    public final double length() {
        Vector2d lIIIllIlIIIIII;
        return Math.sqrt(lIIIllIlIIIIII.x * lIIIllIlIIIIII.x + lIIIllIlIIIIII.y * lIIIllIlIIIIII.y);
    }

    public Vector2d(double[] lIIIllIllIIIll) {
        super(lIIIllIllIIIll);
        Vector2d lIIIllIllIIlII;
    }

    public final void normalize() {
        Vector2d lIIIllIIlIlllI;
        double lIIIllIIlIllll = 1.0 / Math.sqrt(lIIIllIIlIlllI.x * lIIIllIIlIlllI.x + lIIIllIIlIlllI.y * lIIIllIIlIlllI.y);
        lIIIllIIlIlllI.x *= lIIIllIIlIllll;
        lIIIllIIlIlllI.y *= lIIIllIIlIllll;
    }

    public final void normalize(Vector2d lIIIllIIllIlll) {
        double lIIIllIIllIllI = 1.0 / Math.sqrt(lIIIllIIllIlll.x * lIIIllIIllIlll.x + lIIIllIIllIlll.y * lIIIllIIllIlll.y);
        lIIIllIIlllIII.x = lIIIllIIllIlll.x * lIIIllIIllIllI;
        lIIIllIIlllIII.y = lIIIllIIllIlll.y * lIIIllIIllIllI;
    }

    public Vector2d(Tuple2d lIIIllIlIlIIIl) {
        super(lIIIllIlIlIIIl);
        Vector2d lIIIllIlIlIIlI;
    }

    public Vector2d(Tuple2f lIIIllIlIIlIll) {
        super(lIIIllIlIIlIll);
        Vector2d lIIIllIlIIllII;
    }

    public final double angle(Vector2d lIIIllIIlIlIII) {
        Vector2d lIIIllIIlIIllI;
        double lIIIllIIlIIlll = lIIIllIIlIIllI.dot(lIIIllIIlIlIII) / (lIIIllIIlIIllI.length() * lIIIllIIlIlIII.length());
        if (lIIIllIIlIIlll < -1.0) {
            lIIIllIIlIIlll = -1.0;
        }
        if (lIIIllIIlIIlll > 1.0) {
            lIIIllIIlIIlll = 1.0;
        }
        return Math.acos(lIIIllIIlIIlll);
    }

    public final double dot(Vector2d lIIIllIlIIIIlI) {
        Vector2d lIIIllIlIIIIll;
        return lIIIllIlIIIIll.x * lIIIllIlIIIIlI.x + lIIIllIlIIIIll.y * lIIIllIlIIIIlI.y;
    }
}

