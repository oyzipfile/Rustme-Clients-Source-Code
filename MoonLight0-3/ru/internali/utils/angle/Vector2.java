/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils.angle;

import ru.internali.utils.angle.Vector;
import ru.internali.utils.angle.Vector3;

public class Vector2<T extends Number>
extends Vector<Number> {
    public Vector2(T lIllIlIlllllIIl, T lIllIlIlllllIll) {
        super(lIllIlIlllllIIl, lIllIlIlllllIll, 0);
        Vector2 lIllIlIlllllIlI;
    }

    public Vector3<T> toVector3() {
        Vector2 lIllIlIllllIllI;
        return new Vector3(lIllIlIllllIllI.getX(), lIllIlIllllIllI.getY(), lIllIlIllllIllI.getZ());
    }
}

