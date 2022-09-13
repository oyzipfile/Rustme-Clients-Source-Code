/*
 * Decompiled with CFR 0.150.
 */
package ru.hld.legendline.api.clickgui;

import java.io.IOException;
import ru.hld.legendline.api.clickgui.Comp;
import ru.hld.legendline.api.setting.Setting;

public class Set
extends Comp {
    public /* synthetic */ float anim;
    /* synthetic */ Setting setting;

    public Set(Setting lllllllllllllIllllIllIlIlIIIllll) {
        Set lllllllllllllIllllIllIlIlIIIlllI;
        lllllllllllllIllllIllIlIlIIIlllI.anim = 0.0f;
        lllllllllllllIllllIllIlIlIIIlllI.setting = lllllllllllllIllllIllIlIlIIIllll;
    }

    @Override
    public void reset() {
        Set lllllllllllllIllllIllIlIIllIIIll;
        super.reset();
    }

    @Override
    public float getHeight() {
        Set lllllllllllllIllllIllIlIIllIIIII;
        return super.getHeight();
    }

    public Setting getSetting() {
        Set lllllllllllllIllllIllIlIlIIIlIlI;
        return lllllllllllllIllllIllIlIlIIIlIlI.setting;
    }

    @Override
    public void drawScreen(int lllllllllllllIllllIllIlIlIIIIIlI, int lllllllllllllIllllIllIlIIllllIll, int lllllllllllllIllllIllIlIlIIIIIII, int lllllllllllllIllllIllIlIIllllIIl, float lllllllllllllIllllIllIlIIllllIII) {
        Set lllllllllllllIllllIllIlIlIIIIIll;
        super.drawScreen(lllllllllllllIllllIllIlIlIIIIIlI, lllllllllllllIllllIllIlIIllllIll, lllllllllllllIllllIllIlIlIIIIIII, lllllllllllllIllllIllIlIIllllIIl, lllllllllllllIllllIllIlIIllllIII);
    }

    @Override
    public void mouseClicked(int lllllllllllllIllllIllIlIIlllIIII, int lllllllllllllIllllIllIlIIllIlIIl, int lllllllllllllIllllIllIlIIllIlIII, int lllllllllllllIllllIllIlIIllIIlll, int lllllllllllllIllllIllIlIIllIllII) throws IOException {
        Set lllllllllllllIllllIllIlIIlllIIIl;
        super.mouseClicked(lllllllllllllIllllIllIlIIlllIIII, lllllllllllllIllllIllIlIIllIlIIl, lllllllllllllIllllIllIlIIllIlIII, lllllllllllllIllllIllIlIIllIIlll, lllllllllllllIllllIllIlIIllIllII);
    }
}

