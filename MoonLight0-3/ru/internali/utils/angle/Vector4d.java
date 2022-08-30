/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  javax.vecmath.Tuple3d
 *  javax.vecmath.Tuple4d
 *  javax.vecmath.Tuple4f
 */
package ru.internali.utils.angle;

import java.io.Serializable;
import javax.vecmath.Tuple3d;
import javax.vecmath.Tuple4d;
import javax.vecmath.Tuple4f;
import ru.internali.utils.angle.Vector4f;

public class Vector4d
extends Tuple4d
implements Serializable {
    static final /* synthetic */ long serialVersionUID = 3938123424117448700L;

    public final double lengthSquared() {
        Vector4d lllIllIllllIlI;
        return lllIllIllllIlI.x * lllIllIllllIlI.x + lllIllIllllIlI.y * lllIllIllllIlI.y + lllIllIllllIlI.z * lllIllIllllIlI.z + lllIllIllllIlI.w * lllIllIllllIlI.w;
    }

    public Vector4d(Tuple4d lllIlllIIIllll) {
        super(lllIlllIIIllll);
        Vector4d lllIlllIIlIIII;
    }

    public final void set(Tuple3d lllIlllIIIIIII) {
        lllIlllIIIIIIl.x = lllIlllIIIIIII.x;
        lllIlllIIIIIIl.y = lllIlllIIIIIII.y;
        lllIlllIIIIIIl.z = lllIlllIIIIIII.z;
        lllIlllIIIIIIl.w = 0.0;
    }

    public Vector4d(Vector4f lllIlllIIlllIl) {
        super((Tuple4f)lllIlllIIlllIl);
        Vector4d lllIlllIIlllII;
    }

    public final double dot(Vector4d lllIllIlllIlII) {
        Vector4d lllIllIlllIlll;
        return lllIllIlllIlll.x * lllIllIlllIlII.x + lllIllIlllIlll.y * lllIllIlllIlII.y + lllIllIlllIlll.z * lllIllIlllIlII.z + lllIllIlllIlll.w * lllIllIlllIlII.w;
    }

    public final double angle(Vector4d lllIllIllIIIII) {
        Vector4d lllIllIlIllllI;
        double lllIllIlIlllll = lllIllIlIllllI.dot(lllIllIllIIIII) / (lllIllIlIllllI.length() * lllIllIllIIIII.length());
        if (lllIllIlIlllll < -1.0) {
            lllIllIlIlllll = -1.0;
        }
        if (lllIllIlIlllll > 1.0) {
            lllIllIlIlllll = 1.0;
        }
        return Math.acos(lllIllIlIlllll);
    }

    public Vector4d(Tuple4f lllIlllIIlIlIl) {
        super(lllIlllIIlIlIl);
        Vector4d lllIlllIIllIII;
    }

    public Vector4d(Vector4d lllIlllIlIIIIl) {
        super((Tuple4d)lllIlllIlIIIIl);
        Vector4d lllIlllIlIIIlI;
    }

    public Vector4d() {
        Vector4d lllIlllIIIIlll;
    }

    public final void normalize() {
        Vector4d lllIllIllIlIII;
        double lllIllIllIIlll = 1.0 / Math.sqrt(lllIllIllIlIII.x * lllIllIllIlIII.x + lllIllIllIlIII.y * lllIllIllIlIII.y + lllIllIllIlIII.z * lllIllIllIlIII.z + lllIllIllIlIII.w * lllIllIllIlIII.w);
        lllIllIllIlIII.x *= lllIllIllIIlll;
        lllIllIllIlIII.y *= lllIllIllIIlll;
        lllIllIllIlIII.z *= lllIllIllIIlll;
        lllIllIllIlIII.w *= lllIllIllIIlll;
    }

    public Vector4d(Tuple3d lllIlllIIIlIIl) {
        super(lllIlllIIIlIIl.x, lllIlllIIIlIIl.y, lllIlllIIIlIIl.z, 0.0);
        Vector4d lllIlllIIIllII;
    }

    public final double length() {
        Vector4d lllIllIllllllI;
        return Math.sqrt(lllIllIllllllI.x * lllIllIllllllI.x + lllIllIllllllI.y * lllIllIllllllI.y + lllIllIllllllI.z * lllIllIllllllI.z + lllIllIllllllI.w * lllIllIllllllI.w);
    }

    public Vector4d(double[] lllIlllIlIlIIl) {
        super(lllIlllIlIlIIl);
        Vector4d lllIlllIlIlIII;
    }

    public Vector4d(double lllIlllIllIlIl, double lllIlllIlIllll, double lllIlllIllIIll, double lllIlllIlIllIl) {
        super(lllIlllIllIlIl, lllIlllIlIllll, lllIlllIllIIll, lllIlllIlIllIl);
        Vector4d lllIlllIllIllI;
    }

    public final void normalize(Vector4d lllIllIllIllll) {
        double lllIllIllIlllI = 1.0 / Math.sqrt(lllIllIllIllll.x * lllIllIllIllll.x + lllIllIllIllll.y * lllIllIllIllll.y + lllIllIllIllll.z * lllIllIllIllll.z + lllIllIllIllll.w * lllIllIllIllll.w);
        lllIllIllIllIl.x = lllIllIllIllll.x * lllIllIllIlllI;
        lllIllIllIllIl.y = lllIllIllIllll.y * lllIllIllIlllI;
        lllIllIllIllIl.z = lllIllIllIllll.z * lllIllIllIlllI;
        lllIllIllIllIl.w = lllIllIllIllll.w * lllIllIllIlllI;
    }
}

