/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils.angle;

import java.io.Serializable;
import javax.vecmath.Tuple2d;
import javax.vecmath.Tuple2f;
import ru.internali.utils.angle.Vector2d;

public class Vector2f
extends Tuple2f
implements Serializable {
    static final /* synthetic */ long serialVersionUID = -2168194326883512320L;

    public Vector2f(float[] lllllllllllIIIl) {
        super(lllllllllllIIIl);
        Vector2f lllllllllllIIlI;
    }

    public final float dot(Vector2f lllllllllIlIIII) {
        Vector2f lllllllllIlIIIl;
        return lllllllllIlIIIl.x * lllllllllIlIIII.x + lllllllllIlIIIl.y * lllllllllIlIIII.y;
    }

    public final float lengthSquared() {
        Vector2f lllllllllIIlIlI;
        return lllllllllIIlIlI.x * lllllllllIIlIlI.x + lllllllllIIlIlI.y * lllllllllIIlIlI.y;
    }

    public final float angle(Vector2f llllllllIllIllI) {
        Vector2f llllllllIllIlll;
        double llllllllIllIlIl = llllllllIllIlll.dot(llllllllIllIllI) / (llllllllIllIlll.length() * llllllllIllIllI.length());
        if (llllllllIllIlIl < -1.0) {
            llllllllIllIlIl = -1.0;
        }
        if (llllllllIllIlIl > 1.0) {
            llllllllIllIlIl = 1.0;
        }
        return (float)Math.acos(llllllllIllIlIl);
    }

    public final void normalize(Vector2f lllllllllIIIlIl) {
        float lllllllllIIIlII = (float)(1.0 / Math.sqrt(lllllllllIIIlIl.x * lllllllllIIIlIl.x + lllllllllIIIlIl.y * lllllllllIIIlIl.y));
        lllllllllIIIIll.x = lllllllllIIIlIl.x * lllllllllIIIlII;
        lllllllllIIIIll.y = lllllllllIIIlIl.y * lllllllllIIIlII;
    }

    public final float length() {
        Vector2f lllllllllIIlllI;
        return (float)Math.sqrt(lllllllllIIlllI.x * lllllllllIIlllI.x + lllllllllIIlllI.y * lllllllllIIlllI.y);
    }

    public Vector2f(Vector2d llllllllllIIlIl) {
        super(llllllllllIIlIl);
        Vector2f llllllllllIlIII;
    }

    public Vector2f(Tuple2f lllllllllIlllll) {
        super(lllllllllIlllll);
        Vector2f llllllllllIIIII;
    }

    public Vector2f(float llllllllllllIII, float llllllllllllIlI) {
        super(llllllllllllIII, llllllllllllIlI);
        Vector2f lllllllllllllII;
    }

    public Vector2f() {
        Vector2f lllllllllIlIllI;
    }

    public Vector2f(Vector2f llllllllllIllIl) {
        super(llllllllllIllIl);
        Vector2f llllllllllIllII;
    }

    public Vector2f(Tuple2d lllllllllIllIIl) {
        super(lllllllllIllIIl);
        Vector2f lllllllllIlllII;
    }

    public final void normalize() {
        Vector2f llllllllIlllllI;
        float llllllllIllllIl = (float)(1.0 / Math.sqrt(llllllllIlllllI.x * llllllllIlllllI.x + llllllllIlllllI.y * llllllllIlllllI.y));
        llllllllIlllllI.x *= llllllllIllllIl;
        llllllllIlllllI.y *= llllllllIllllIl;
    }
}

