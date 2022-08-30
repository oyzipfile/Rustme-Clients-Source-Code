/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils.angle;

import ru.internali.utils.angle.Vector;
import ru.internali.utils.angle.Vector2;

public class Vector3<T extends Number>
extends Vector<Number> {
    public Vector3(T lIlIIIlIIllIllI, T lIlIIIlIIllIlIl, T lIlIIIlIIllIIII) {
        super(lIlIIIlIIllIllI, lIlIIIlIIllIlIl, lIlIIIlIIllIIII);
        Vector3 lIlIIIlIIllIlll;
    }

    public Vector2<T> toVector2() {
        Vector3 lIlIIIlIIlIlllI;
        return new Vector2(lIlIIIlIIlIlllI.getX(), lIlIIIlIIlIlllI.getY());
    }
}

