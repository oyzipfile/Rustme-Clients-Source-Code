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
import ru.internali.utils.angle.Vector3d;

public class Vector3f
extends Tuple3f
implements Serializable {
    static final /* synthetic */ long serialVersionUID = -7031930069184524614L;

    public Vector3f(Vector3f lIIlIIllIIIlIlI) {
        super((Tuple3f)lIIlIIllIIIlIlI);
        Vector3f lIIlIIllIIIlIll;
    }

    public Vector3f(float[] lIIlIIllIIIlllI) {
        super(lIIlIIllIIIlllI);
        Vector3f lIIlIIllIIIllll;
    }

    public Vector3f(Tuple3d lIIlIIlIlllIllI) {
        super(lIIlIIlIlllIllI);
        Vector3f lIIlIIlIlllIlll;
    }

    public final void cross(Vector3f lIIlIIlIllIIllI, Vector3f lIIlIIlIllIIIII) {
        float lIIlIIlIllIIlII = lIIlIIlIllIIllI.y * lIIlIIlIllIIIII.z - lIIlIIlIllIIllI.z * lIIlIIlIllIIIII.y;
        float lIIlIIlIllIIIll = lIIlIIlIllIIIII.x * lIIlIIlIllIIllI.z - lIIlIIlIllIIIII.z * lIIlIIlIllIIllI.x;
        lIIlIIlIllIIIlI.z = lIIlIIlIllIIllI.x * lIIlIIlIllIIIII.y - lIIlIIlIllIIllI.y * lIIlIIlIllIIIII.x;
        lIIlIIlIllIIIlI.x = lIIlIIlIllIIlII;
        lIIlIIlIllIIIlI.y = lIIlIIlIllIIIll;
    }

    public Vector3f(Tuple3f lIIlIIlIlllllII) {
        super(lIIlIIlIlllllII);
        Vector3f lIIlIIlIlllllll;
    }

    public final float length() {
        Vector3f lIIlIIlIllIlllI;
        return (float)Math.sqrt(lIIlIIlIllIlllI.x * lIIlIIlIllIlllI.x + lIIlIIlIllIlllI.y * lIIlIIlIllIlllI.y + lIIlIIlIllIlllI.z * lIIlIIlIllIlllI.z);
    }

    public final float lengthSquared() {
        Vector3f lIIlIIlIlllIIII;
        return lIIlIIlIlllIIII.x * lIIlIIlIlllIIII.x + lIIlIIlIlllIIII.y * lIIlIIlIlllIIII.y + lIIlIIlIlllIIII.z * lIIlIIlIlllIIII.z;
    }

    public Vector3f(Vector3d lIIlIIllIIIIlII) {
        super((Tuple3d)lIIlIIllIIIIlII);
        Vector3f lIIlIIllIIIIlIl;
    }

    public final float dot(Vector3f lIIlIIlIlIllIlI) {
        Vector3f lIIlIIlIlIllIIl;
        return lIIlIIlIlIllIIl.x * lIIlIIlIlIllIlI.x + lIIlIIlIlIllIIl.y * lIIlIIlIlIllIlI.y + lIIlIIlIlIllIIl.z * lIIlIIlIlIllIlI.z;
    }

    public final void normalize() {
        Vector3f lIIlIIlIlIIlIlI;
        float lIIlIIlIlIIlIll = (float)(1.0 / Math.sqrt(lIIlIIlIlIIlIlI.x * lIIlIIlIlIIlIlI.x + lIIlIIlIlIIlIlI.y * lIIlIIlIlIIlIlI.y + lIIlIIlIlIIlIlI.z * lIIlIIlIlIIlIlI.z));
        lIIlIIlIlIIlIlI.x *= lIIlIIlIlIIlIll;
        lIIlIIlIlIIlIlI.y *= lIIlIIlIlIIlIll;
        lIIlIIlIlIIlIlI.z *= lIIlIIlIlIIlIll;
    }

    public Vector3f() {
        Vector3f lIIlIIlIlllIlII;
    }

    public final float angle(Vector3f lIIlIIlIlIIIIIl) {
        Vector3f lIIlIIlIlIIIlIl;
        double lIIlIIlIlIIIIll = lIIlIIlIlIIIlIl.dot(lIIlIIlIlIIIIIl) / (lIIlIIlIlIIIlIl.length() * lIIlIIlIlIIIIIl.length());
        if (lIIlIIlIlIIIIll < -1.0) {
            lIIlIIlIlIIIIll = -1.0;
        }
        if (lIIlIIlIlIIIIll > 1.0) {
            lIIlIIlIlIIIIll = 1.0;
        }
        return (float)Math.acos(lIIlIIlIlIIIIll);
    }

    public final void normalize(Vector3f lIIlIIlIlIlIIll) {
        float lIIlIIlIlIlIIlI = (float)(1.0 / Math.sqrt(lIIlIIlIlIlIIll.x * lIIlIIlIlIlIIll.x + lIIlIIlIlIlIIll.y * lIIlIIlIlIlIIll.y + lIIlIIlIlIlIIll.z * lIIlIIlIlIlIIll.z));
        lIIlIIlIlIlIlII.x = lIIlIIlIlIlIIll.x * lIIlIIlIlIlIIlI;
        lIIlIIlIlIlIlII.y = lIIlIIlIlIlIIll.y * lIIlIIlIlIlIIlI;
        lIIlIIlIlIlIlII.z = lIIlIIlIlIlIIll.z * lIIlIIlIlIlIIlI;
    }

    public Vector3f(float lIIlIIllIIllIlI, float lIIlIIllIIllIIl, float lIIlIIllIIllIII) {
        super(lIIlIIllIIllIlI, lIIlIIllIIllIIl, lIIlIIllIIllIII);
        Vector3f lIIlIIllIIlIlll;
    }
}

