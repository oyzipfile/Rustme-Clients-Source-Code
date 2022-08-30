/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  javax.vecmath.Tuple3f
 *  javax.vecmath.Tuple4d
 *  javax.vecmath.Tuple4f
 */
package ru.internali.utils.angle;

import java.io.Serializable;
import javax.vecmath.Tuple3f;
import javax.vecmath.Tuple4d;
import javax.vecmath.Tuple4f;
import ru.internali.utils.angle.Vector4d;

public class Vector4f
extends Tuple4f
implements Serializable {
    static final /* synthetic */ long serialVersionUID = 8749319902347760659L;

    public final void normalize() {
        Vector4f lllllIlIlIlIIIl;
        float lllllIlIlIlIIlI = (float)(1.0 / Math.sqrt(lllllIlIlIlIIIl.x * lllllIlIlIlIIIl.x + lllllIlIlIlIIIl.y * lllllIlIlIlIIIl.y + lllllIlIlIlIIIl.z * lllllIlIlIlIIIl.z + lllllIlIlIlIIIl.w * lllllIlIlIlIIIl.w));
        lllllIlIlIlIIIl.x *= lllllIlIlIlIIlI;
        lllllIlIlIlIIIl.y *= lllllIlIlIlIIlI;
        lllllIlIlIlIIIl.z *= lllllIlIlIlIIlI;
        lllllIlIlIlIIIl.w *= lllllIlIlIlIIlI;
    }

    public final float angle(Vector4f lllllIlIlIIlIll) {
        Vector4f lllllIlIlIIlIIl;
        double lllllIlIlIIlIlI = lllllIlIlIIlIIl.dot(lllllIlIlIIlIll) / (lllllIlIlIIlIIl.length() * lllllIlIlIIlIll.length());
        if (lllllIlIlIIlIlI < -1.0) {
            lllllIlIlIIlIlI = -1.0;
        }
        if (lllllIlIlIIlIlI > 1.0) {
            lllllIlIlIIlIlI = 1.0;
        }
        return (float)Math.acos(lllllIlIlIIlIlI);
    }

    public final void set(Tuple3f lllllIlIllIllIl) {
        lllllIlIllIlllI.x = lllllIlIllIllIl.x;
        lllllIlIllIlllI.y = lllllIlIllIllIl.y;
        lllllIlIllIlllI.z = lllllIlIllIllIl.z;
        lllllIlIllIlllI.w = 0.0f;
    }

    public Vector4f(float[] lllllIllIIlIlII) {
        super(lllllIllIIlIlII);
        Vector4f lllllIllIIlIlIl;
    }

    public Vector4f(Vector4d lllllIllIIIIllI) {
        super((Tuple4d)lllllIllIIIIllI);
        Vector4f lllllIllIIIIlll;
    }

    public Vector4f(Tuple3f lllllIlIlllIllI) {
        super(lllllIlIlllIllI.x, lllllIlIlllIllI.y, lllllIlIlllIllI.z, 0.0f);
        Vector4f lllllIlIlllIlIl;
    }

    public final void normalize(Vector4f lllllIlIlIlIlll) {
        float lllllIlIlIllIIl = (float)(1.0 / Math.sqrt(lllllIlIlIlIlll.x * lllllIlIlIlIlll.x + lllllIlIlIlIlll.y * lllllIlIlIlIlll.y + lllllIlIlIlIlll.z * lllllIlIlIlIlll.z + lllllIlIlIlIlll.w * lllllIlIlIlIlll.w));
        lllllIlIlIllIll.x = lllllIlIlIlIlll.x * lllllIlIlIllIIl;
        lllllIlIlIllIll.y = lllllIlIlIlIlll.y * lllllIlIlIllIIl;
        lllllIlIlIllIll.z = lllllIlIlIlIlll.z * lllllIlIlIllIIl;
        lllllIlIlIllIll.w = lllllIlIlIlIlll.w * lllllIlIlIllIIl;
    }

    public Vector4f() {
        Vector4f lllllIlIlllIIIl;
    }

    public Vector4f(Vector4f lllllIllIIIllII) {
        super((Tuple4f)lllllIllIIIllII);
        Vector4f lllllIllIIIllIl;
    }

    public Vector4f(Tuple4f lllllIllIIIIIlI) {
        super(lllllIllIIIIIlI);
        Vector4f lllllIllIIIIIIl;
    }

    public Vector4f(float lllllIllIIllIll, float lllllIllIIllIlI, float lllllIllIIllllI, float lllllIllIIllIII) {
        super(lllllIllIIllIll, lllllIllIIllIlI, lllllIllIIllllI, lllllIllIIllIII);
        Vector4f lllllIllIlIIIIl;
    }

    public Vector4f(Tuple4d lllllIlIllllIlI) {
        super(lllllIlIllllIlI);
        Vector4f lllllIlIlllllIl;
    }

    public final float dot(Vector4f lllllIlIllIIIIl) {
        Vector4f lllllIlIllIIIlI;
        return lllllIlIllIIIlI.x * lllllIlIllIIIIl.x + lllllIlIllIIIlI.y * lllllIlIllIIIIl.y + lllllIlIllIIIlI.z * lllllIlIllIIIIl.z + lllllIlIllIIIlI.w * lllllIlIllIIIIl.w;
    }

    public final float lengthSquared() {
        Vector4f lllllIlIllIIllI;
        return lllllIlIllIIllI.x * lllllIlIllIIllI.x + lllllIlIllIIllI.y * lllllIlIllIIllI.y + lllllIlIllIIllI.z * lllllIlIllIIllI.z + lllllIlIllIIllI.w * lllllIlIllIIllI.w;
    }

    public final float length() {
        Vector4f lllllIlIllIlIIl;
        return (float)Math.sqrt(lllllIlIllIlIIl.x * lllllIlIllIlIIl.x + lllllIlIllIlIIl.y * lllllIlIllIlIIl.y + lllllIlIllIlIIl.z * lllllIlIllIlIIl.z + lllllIlIllIlIIl.w * lllllIlIllIlIIl.w);
    }
}

