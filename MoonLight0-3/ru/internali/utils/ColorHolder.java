/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package ru.internali.utils;

import java.awt.Color;
import org.lwjgl.opengl.GL11;

public class ColorHolder {
    /* synthetic */ int r;
    /* synthetic */ int g;
    /* synthetic */ int b;
    /* synthetic */ int a;

    public int getG() {
        ColorHolder lllIIllllIIIlIl;
        return lllIIllllIIIlIl.g;
    }

    public ColorHolder brighter() {
        ColorHolder lllIIlllllllIII;
        return new ColorHolder(Math.min(lllIIlllllllIII.r + 10, 255), Math.min(lllIIlllllllIII.g + 10, 255), Math.min(lllIIlllllllIII.b + 10, 255), lllIIlllllllIII.getA());
    }

    public void becomeGLColour() {
    }

    public ColorHolder setA(int lllIIlllIlIlIII) {
        ColorHolder lllIIlllIlIIlll;
        lllIIlllIlIIlll.a = lllIIlllIlIlIII;
        return lllIIlllIlIIlll;
    }

    public static int toHex(int lllIIllllIIllll, int lllIIllllIIlllI, int lllIIllllIIllIl) {
        return 0xFF000000 | (lllIIllllIIllll & 0xFF) << 16 | (lllIIllllIIlllI & 0xFF) << 8 | lllIIllllIIllIl & 0xFF;
    }

    public int toHex() {
        ColorHolder lllIIllllIIlIlI;
        return ColorHolder.toHex(lllIIllllIIlIlI.r, lllIIllllIIlIlI.g, lllIIllllIIlIlI.b);
    }

    public void setGLColour() {
        ColorHolder lllIIllllllIIlI;
        lllIIllllllIIlI.setGLColour(-1, -1, -1, -1);
    }

    public int getB() {
        ColorHolder lllIIllllIIIlll;
        return lllIIllllIIIlll.b;
    }

    public Color toJavaColour() {
        ColorHolder lllIIlllIlIIIII;
        return new Color(lllIIlllIlIIIII.r, lllIIlllIlIIIII.g, lllIIlllIlIIIII.b, lllIIlllIlIIIII.a);
    }

    public int getA() {
        ColorHolder lllIIlllIlllllI;
        return lllIIlllIlllllI.a;
    }

    public void becomeHex(int lllIIllllIllllI) {
        ColorHolder lllIIllllIlllIl;
        lllIIllllIlllIl.setR((lllIIllllIllllI & 0xFF0000) >> 16);
        lllIIllllIlllIl.setG((lllIIllllIllllI & 0xFF00) >> 8);
        lllIIllllIlllIl.setB(lllIIllllIllllI & 0xFF);
        lllIIllllIlllIl.setA(255);
    }

    public ColorHolder(int lllIlIIIIIlIIII, int lllIlIIIIIIllll, int lllIlIIIIIIlIlI) {
        ColorHolder lllIlIIIIIlIIIl;
        lllIlIIIIIlIIIl.r = lllIlIIIIIlIIII;
        lllIlIIIIIlIIIl.g = lllIlIIIIIIllll;
        lllIlIIIIIlIIIl.b = lllIlIIIIIIlIlI;
        lllIlIIIIIlIIIl.a = 255;
    }

    public ColorHolder setB(int lllIIlllIllIIlI) {
        ColorHolder lllIIlllIllIIll;
        lllIIlllIllIIll.b = lllIIlllIllIIlI;
        return lllIIlllIllIIll;
    }

    public ColorHolder setR(int lllIIlllIlllIlI) {
        ColorHolder lllIIlllIlllIll;
        lllIIlllIlllIll.r = lllIIlllIlllIlI;
        return lllIIlllIlllIll;
    }

    public int getR() {
        ColorHolder lllIIllllIIIIlI;
        return lllIIllllIIIIlI.r;
    }

    public ColorHolder setG(int lllIIlllIlIlllI) {
        ColorHolder lllIIlllIlIllll;
        lllIIlllIlIllll.g = lllIIlllIlIlllI;
        return lllIIlllIlIllll;
    }

    public ColorHolder clone() {
        ColorHolder lllIIlllIlIIlII;
        return new ColorHolder(lllIIlllIlIIlII.r, lllIIlllIlIIlII.g, lllIIlllIlIIlII.b, lllIIlllIlIIlII.a);
    }

    public void setGLColour(int lllIIlllllIlIll, int lllIIlllllIlIlI, int lllIIlllllIIlII, int lllIIlllllIIIll) {
        ColorHolder lllIIlllllIIlll;
        GL11.glColor4f((float)((float)(lllIIlllllIlIll == -1 ? lllIIlllllIIlll.r : lllIIlllllIlIll) / 255.0f), (float)((float)(lllIIlllllIlIlI == -1 ? lllIIlllllIIlll.g : lllIIlllllIlIlI) / 255.0f), (float)((float)(lllIIlllllIIlII == -1 ? lllIIlllllIIlll.b : lllIIlllllIIlII) / 255.0f), (float)((float)(lllIIlllllIIIll == -1 ? lllIIlllllIIlll.a : lllIIlllllIIIll) / 255.0f));
    }

    public static ColorHolder fromHex(int lllIIllllIlIlll) {
        ColorHolder lllIIllllIllIII = new ColorHolder(0, 0, 0);
        lllIIllllIllIII.becomeHex(lllIIllllIlIlll);
        return lllIIllllIllIII;
    }

    public ColorHolder darker() {
        ColorHolder lllIIllllllIlIl;
        return new ColorHolder(Math.max(lllIIllllllIlIl.r - 10, 0), Math.max(lllIIllllllIlIl.g - 10, 0), Math.max(lllIIllllllIlIl.b - 10, 0), lllIIllllllIlIl.getA());
    }

    public ColorHolder(int lllIIlllllllllI, int lllIlIIIIIIIIlI, int lllIlIIIIIIIIIl, int lllIIlllllllIll) {
        ColorHolder lllIlIIIIIIIlII;
        lllIlIIIIIIIlII.r = lllIIlllllllllI;
        lllIlIIIIIIIlII.g = lllIlIIIIIIIIlI;
        lllIlIIIIIIIlII.b = lllIlIIIIIIIIIl;
        lllIlIIIIIIIlII.a = lllIIlllllllIll;
    }
}

