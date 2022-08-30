/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  javax.vecmath.Tuple3d
 *  javax.vecmath.Tuple3f
 */
package ru.internali.utils.angle;

import java.io.Serializable;
import javax.vecmath.Tuple3d;
import javax.vecmath.Tuple3f;
import ru.internali.utils.angle.Vector3f;

public class Vector3d
extends Tuple3d
implements Serializable {
    static final /* synthetic */ long serialVersionUID = 3761969948420550442L;

    public final void normalize() {
        Vector3d lIlIlIlIIllIIll;
        double lIlIlIlIIllIlII = 1.0 / Math.sqrt(lIlIlIlIIllIIll.x * lIlIlIlIIllIIll.x + lIlIlIlIIllIIll.y * lIlIlIlIIllIIll.y + lIlIlIlIIllIIll.z * lIlIlIlIIllIIll.z);
        lIlIlIlIIllIIll.x *= lIlIlIlIIllIlII;
        lIlIlIlIIllIIll.y *= lIlIlIlIIllIlII;
        lIlIlIlIIllIIll.z *= lIlIlIlIIllIlII;
    }

    public Vector3d(Vector3d lIlIlIlIllIIlll) {
        super((Tuple3d)lIlIlIlIllIIlll);
        Vector3d lIlIlIlIllIIllI;
    }

    public Vector3d(Tuple3d lIlIlIlIlIlIlIl) {
        super(lIlIlIlIlIlIlIl);
        Vector3d lIlIlIlIlIlIllI;
    }

    public final void cross(Vector3d lIlIlIlIlIIlIIl, Vector3d lIlIlIlIlIIlIII) {
        double lIlIlIlIlIIIlll = lIlIlIlIlIIlIIl.y * lIlIlIlIlIIlIII.z - lIlIlIlIlIIlIIl.z * lIlIlIlIlIIlIII.y;
        double lIlIlIlIlIIIllI = lIlIlIlIlIIlIII.x * lIlIlIlIlIIlIIl.z - lIlIlIlIlIIlIII.z * lIlIlIlIlIIlIIl.x;
        lIlIlIlIlIIlIlI.z = lIlIlIlIlIIlIIl.x * lIlIlIlIlIIlIII.y - lIlIlIlIlIIlIIl.y * lIlIlIlIlIIlIII.x;
        lIlIlIlIlIIlIlI.x = lIlIlIlIlIIIlll;
        lIlIlIlIlIIlIlI.y = lIlIlIlIlIIIllI;
    }

    public Vector3d(Vector3f lIlIlIlIlIlllll) {
        super((Tuple3f)lIlIlIlIlIlllll);
        Vector3d lIlIlIlIllIIIlI;
    }

    public Vector3d(Tuple3f lIlIlIlIlIllIll) {
        super(lIlIlIlIlIllIll);
        Vector3d lIlIlIlIlIlllII;
    }

    public Vector3d(double lIlIlIlIlllIlll, double lIlIlIlIlllIllI, double lIlIlIlIlllIIIl) {
        super(lIlIlIlIlllIlll, lIlIlIlIlllIllI, lIlIlIlIlllIIIl);
        Vector3d lIlIlIlIllllIII;
    }

    public Vector3d(double[] lIlIlIlIllIllIl) {
        super(lIlIlIlIllIllIl);
        Vector3d lIlIlIlIllIlllI;
    }

    public final double dot(Vector3d lIlIlIlIIlIllII) {
        Vector3d lIlIlIlIIlIllll;
        return lIlIlIlIIlIllll.x * lIlIlIlIIlIllII.x + lIlIlIlIIlIllll.y * lIlIlIlIIlIllII.y + lIlIlIlIIlIllll.z * lIlIlIlIIlIllII.z;
    }

    public Vector3d() {
        Vector3d lIlIlIlIlIlIIII;
    }

    public final void normalize(Vector3d lIlIlIlIIllllII) {
        double lIlIlIlIIlllIll = 1.0 / Math.sqrt(lIlIlIlIIllllII.x * lIlIlIlIIllllII.x + lIlIlIlIIllllII.y * lIlIlIlIIllllII.y + lIlIlIlIIllllII.z * lIlIlIlIIllllII.z);
        lIlIlIlIIlllIlI.x = lIlIlIlIIllllII.x * lIlIlIlIIlllIll;
        lIlIlIlIIlllIlI.y = lIlIlIlIIllllII.y * lIlIlIlIIlllIll;
        lIlIlIlIIlllIlI.z = lIlIlIlIIllllII.z * lIlIlIlIIlllIll;
    }

    public final double length() {
        Vector3d lIlIlIlIIlIIllI;
        return Math.sqrt(lIlIlIlIIlIIllI.x * lIlIlIlIIlIIllI.x + lIlIlIlIIlIIllI.y * lIlIlIlIIlIIllI.y + lIlIlIlIIlIIllI.z * lIlIlIlIIlIIllI.z);
    }

    public final double lengthSquared() {
        Vector3d lIlIlIlIIlIlIlI;
        return lIlIlIlIIlIlIlI.x * lIlIlIlIIlIlIlI.x + lIlIlIlIIlIlIlI.y * lIlIlIlIIlIlIlI.y + lIlIlIlIIlIlIlI.z * lIlIlIlIIlIlIlI.z;
    }

    public final double angle(Vector3d lIlIlIlIIlIIIIl) {
        Vector3d lIlIlIlIIlIIIlI;
        double lIlIlIlIIlIIIII = lIlIlIlIIlIIIlI.dot(lIlIlIlIIlIIIIl) / (lIlIlIlIIlIIIlI.length() * lIlIlIlIIlIIIIl.length());
        if (lIlIlIlIIlIIIII < -1.0) {
            lIlIlIlIIlIIIII = -1.0;
        }
        if (lIlIlIlIIlIIIII > 1.0) {
            lIlIlIlIIlIIIII = 1.0;
        }
        return Math.acos(lIlIlIlIIlIIIII);
    }
}

