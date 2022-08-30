/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.module.combat;

import ru.internali.utils.Event;

public class Slient
extends Event {
    private /* synthetic */ boolean onground;
    private /* synthetic */ double y;
    private static /* synthetic */ float pitch;
    private static /* synthetic */ float yaw;
    private /* synthetic */ boolean isPre;

    public float getYaw() {
        return yaw;
    }

    public void setGround(boolean lllllIlIllIII) {
        lllllIlIlIlll.onground = lllllIlIllIII;
    }

    public boolean isPre() {
        Slient lllllIlllIlll;
        return lllllIlllIlll.isPre;
    }

    public boolean isPost() {
        Slient lllllIlllIlIl;
        return !lllllIlllIlIl.isPre;
    }

    public static void setYaw(float lllllIllIIllI) {
        yaw = lllllIllIIllI;
    }

    public double getY() {
        Slient lllllIllIlIll;
        return lllllIllIlIll.y;
    }

    public void setY(double lllllIlIllllI) {
        lllllIlIlllll.y = lllllIlIllllI;
    }

    public boolean isOnground() {
        Slient lllllIllIlIIl;
        return lllllIllIlIIl.onground;
    }

    public Slient(double llllllIIIIlIl, float lllllIlllllll, float llllllIIIIIll, boolean llllllIIIIIlI) {
        Slient llllllIIIIIIl;
        llllllIIIIIIl.isPre = true;
        yaw = lllllIlllllll;
        pitch = llllllIIIIIll;
        llllllIIIIIIl.y = llllllIIIIlIl;
        llllllIIIIIIl.onground = llllllIIIIIlI;
    }

    public Slient() {
        Slient lllllIllllIll;
        lllllIllllIll.isPre = false;
    }

    public static void setPitch(float lllllIllIIIlI) {
        pitch = lllllIllIIIlI;
    }

    public float getPitch() {
        return pitch;
    }
}

