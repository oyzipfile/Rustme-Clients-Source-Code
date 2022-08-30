/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils;

import ru.internali.utils.EventCancellable;

public class EventPlayerState
extends EventCancellable {
    private /* synthetic */ float yaw;
    private /* synthetic */ boolean onGround;
    private /* synthetic */ float pitch;
    private /* synthetic */ double x;
    private final /* synthetic */ boolean isPre;
    private /* synthetic */ double y;
    private /* synthetic */ double z;

    public void setOnGround(boolean lllllIIlIIlIllI) {
        lllllIIlIIllIIl.onGround = lllllIIlIIlIllI;
    }

    public EventPlayerState(double lllllIIllIllIlI, double lllllIIlllIIIII, double lllllIIllIllIII, float lllllIIllIllllI, float lllllIIllIlllIl, boolean lllllIIllIlllII) {
        EventPlayerState lllllIIllIllIll;
        lllllIIllIllIll.y = lllllIIlllIIIII;
        lllllIIllIllIll.x = lllllIIllIllIlI;
        lllllIIllIllIll.z = lllllIIllIllIII;
        lllllIIllIllIll.isPre = true;
        lllllIIllIllIll.yaw = lllllIIllIllllI;
        lllllIIllIllIll.pitch = lllllIIllIlllIl;
        lllllIIllIllIll.onGround = lllllIIllIlllII;
    }

    public boolean isPre() {
        EventPlayerState lllllIIllIIllll;
        return lllllIIllIIllll.isPre;
    }

    public double getX() {
        EventPlayerState lllllIIlIlllIII;
        return lllllIIlIlllIII.x;
    }

    public EventPlayerState() {
        EventPlayerState lllllIIllIlIIll;
        lllllIIllIlIIll.isPre = false;
    }

    public void setZ(double lllllIIlIIlllll) {
        lllllIIlIlIIIlI.z = lllllIIlIIlllll;
    }

    public double getZ() {
        EventPlayerState lllllIIlIlIIllI;
        return lllllIIlIlIIllI.z;
    }

    public void setYaw(float lllllIIllIIIIll) {
        lllllIIllIIIllI.yaw = lllllIIllIIIIll;
    }

    public double getY() {
        EventPlayerState lllllIIlIlIlllI;
        return lllllIIlIlIlllI.y;
    }

    public float getPitch() {
        EventPlayerState lllllIIllIIIIIl;
        return lllllIIllIIIIIl.pitch;
    }

    public void setY(double lllllIIlIlIlIlI) {
        lllllIIlIlIlIIl.y = lllllIIlIlIlIlI;
    }

    public void setPitch(float lllllIIlIlllIlI) {
        lllllIIlIlllIll.pitch = lllllIIlIlllIlI;
    }

    public float getYaw() {
        EventPlayerState lllllIIllIIlIlI;
        return lllllIIllIIlIlI.yaw;
    }

    public void setX(double lllllIIlIllIIIl) {
        lllllIIlIllIIlI.x = lllllIIlIllIIIl;
    }

    public boolean isPost() {
        EventPlayerState lllllIIllIIllIl;
        return !lllllIIllIIllIl.isPre;
    }

    @Override
    public boolean cancel() {
        return false;
    }

    public boolean isOnGround() {
        EventPlayerState lllllIIlIIlllII;
        return lllllIIlIIlllII.onGround;
    }
}

