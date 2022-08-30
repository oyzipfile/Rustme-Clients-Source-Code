/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.module.render;

import ru.internali.utils.Event;

public class EventFogColor
extends Event {
    public /* synthetic */ float red;
    public /* synthetic */ int alpha;
    public /* synthetic */ float blue;
    public /* synthetic */ float green;

    public void setAlpha(int lIlIIIlIIIlllI) {
        lIlIIIlIIIllIl.alpha = lIlIIIlIIIlllI;
    }

    public int getAlpha() {
        EventFogColor lIlIIIlIIlIIlI;
        return lIlIIIlIIlIIlI.alpha;
    }

    public float getBlue() {
        EventFogColor lIlIIIlIIllIII;
        return lIlIIIlIIllIII.blue;
    }

    public float getGreen() {
        EventFogColor lIlIIIlIIlllll;
        return lIlIIIlIIlllll.green;
    }

    public static void setGreen(float lIlIIIlIIlllII) {
    }

    public static void setRed(float lIlIIIlIlIIIIl) {
    }

    public float getRed() {
        EventFogColor lIlIIIlIlIIlIl;
        return lIlIIIlIlIIlIl.red;
    }

    public static void setBlue(float lIlIIIlIIlIlIl) {
    }

    public EventFogColor(float lIlIIIlIlIllll, float lIlIIIlIlIlllI, float lIlIIIlIlIlIII, int lIlIIIlIlIllII) {
        EventFogColor lIlIIIlIllIIII;
        lIlIIIlIllIIII.red = lIlIIIlIlIllll;
        lIlIIIlIllIIII.green = lIlIIIlIlIlllI;
        lIlIIIlIllIIII.blue = lIlIIIlIlIlIII;
        lIlIIIlIllIIII.alpha = lIlIIIlIlIllII;
    }
}

