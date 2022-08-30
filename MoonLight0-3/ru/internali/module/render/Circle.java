/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.Vec3d
 */
package ru.internali.module.render;

import net.minecraft.util.math.Vec3d;

class Circle {
    private final /* synthetic */ Vec3d vec;
    private final /* synthetic */ Vec3d color;
    /* synthetic */ byte existed;

    Vec3d position() {
        Circle llllIlllIIIII;
        return llllIlllIIIII.vec;
    }

    Circle(Vec3d llllIlllIIllI, Vec3d llllIlllIIlIl) {
        Circle llllIlllIIlII;
        llllIlllIIlII.vec = llllIlllIIllI;
        llllIlllIIlII.color = llllIlllIIlIl;
    }

    Vec3d color() {
        Circle llllIllIlllII;
        return llllIllIlllII.color;
    }

    boolean update() {
        Circle llllIllIllIIl;
        byte llllIllIllIII;
        llllIllIllIIl.existed = llllIllIllIII = (byte)(llllIllIllIIl.existed + 1);
        return llllIllIllIII > 20;
    }
}

