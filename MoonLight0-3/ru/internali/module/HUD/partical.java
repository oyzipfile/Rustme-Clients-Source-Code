/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.module.HUD;

import ru.internali.CatClient;
import ru.internali.utils.RenderUtil;

public class partical {
    public /* synthetic */ int height;
    /* synthetic */ float y;
    /* synthetic */ float speed;
    /* synthetic */ float x;

    public void setX(float lIlllllIIIlllI) {
        lIlllllIIIllIl.x = lIlllllIIIlllI;
    }

    public void setY(float lIlllllIIIIllI) {
        lIlllllIIIIlll.y = lIlllllIIIIllI;
    }

    public void render() {
        partical lIlllllIIIIIll;
        RenderUtil.drawCircle(lIlllllIIIIIll.x, lIlllllIIIIIll.y, lIlllllIIIIIll.y / (float)lIlllllIIIIIll.height * 3.0f, CatClient.getClientColor().getRGB());
    }

    public float getY() {
        partical lIlllllIIlIIlI;
        return lIlllllIIlIIlI.y;
    }

    public partical(float lIlllllIIllllI, float lIlllllIIlllIl, float lIlllllIIllIII) {
        partical lIlllllIIllIll;
        lIlllllIIllIll.x = lIlllllIIllllI;
        lIlllllIIllIll.y = lIlllllIIlllIl;
        lIlllllIIllIll.speed = lIlllllIIllIII;
    }

    public float getX() {
        partical lIlllllIIlIllI;
        return lIlllllIIlIllI.x;
    }
}

