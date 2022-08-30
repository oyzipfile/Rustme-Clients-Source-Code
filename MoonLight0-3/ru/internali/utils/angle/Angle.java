/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils.angle;

import ru.internali.utils.angle.Vector2;

public class Angle
extends Vector2<Float> {
    public Angle constrantAngle() {
        Angle lIlllIlIIIllII;
        lIlllIlIIIllII.setYaw(Float.valueOf(lIlllIlIIIllII.getYaw().floatValue() % 360.0f));
        lIlllIlIIIllII.setPitch(Float.valueOf(lIlllIlIIIllII.getPitch().floatValue() % 360.0f));
        while (lIlllIlIIIllII.getYaw().floatValue() <= -180.0f) {
            lIlllIlIIIllII.setYaw(Float.valueOf(lIlllIlIIIllII.getYaw().floatValue() + 360.0f));
        }
        while (lIlllIlIIIllII.getPitch().floatValue() <= -180.0f) {
            lIlllIlIIIllII.setPitch(Float.valueOf(lIlllIlIIIllII.getPitch().floatValue() + 360.0f));
        }
        while (lIlllIlIIIllII.getYaw().floatValue() > 180.0f) {
            lIlllIlIIIllII.setYaw(Float.valueOf(lIlllIlIIIllII.getYaw().floatValue() - 360.0f));
        }
        while (lIlllIlIIIllII.getPitch().floatValue() > 180.0f) {
            lIlllIlIIIllII.setPitch(Float.valueOf(lIlllIlIIIllII.getPitch().floatValue() - 360.0f));
        }
        return lIlllIlIIIllII;
    }

    public Float getPitch() {
        Angle lIlllIlIIlIllI;
        return Float.valueOf(((Number)lIlllIlIIlIllI.getY()).floatValue());
    }

    public Angle setPitch(Float lIlllIlIIlIIIl) {
        Angle lIlllIlIIlIIII;
        lIlllIlIIlIIII.setY(lIlllIlIIlIIIl);
        return lIlllIlIIlIIII;
    }

    public Angle setYaw(Float lIlllIlIIllIII) {
        Angle lIlllIlIIllIll;
        lIlllIlIIllIll.setX(lIlllIlIIllIII);
        return lIlllIlIIllIll;
    }

    public Float getYaw() {
        Angle lIlllIlIIlllll;
        return Float.valueOf(((Number)lIlllIlIIlllll.getX()).floatValue());
    }

    public Angle(Float lIlllIlIlIIlIl, Float lIlllIlIlIIIIl) {
        super(lIlllIlIlIIlIl, lIlllIlIlIIIIl);
        Angle lIlllIlIlIIllI;
    }
}

