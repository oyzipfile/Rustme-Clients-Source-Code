/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.settings;

import ru.internali.settings.Setting;

public class RGBSetting
extends Setting {
    private /* synthetic */ int blue;
    private /* synthetic */ int red;
    private /* synthetic */ int green;

    public int getBlue() {
        RGBSetting lllIlIlIlllII;
        return lllIlIlIlllII.blue;
    }

    public void setGreen(int lllIlIlIllllI) {
        lllIlIllIIIIl.green = lllIlIlIllllI;
    }

    public int getRed() {
        RGBSetting lllIlIllIlllI;
        return lllIlIllIlllI.red;
    }

    public void setBlue(int lllIlIlIlIlIl) {
        lllIlIlIlIllI.blue = lllIlIlIlIlIl;
    }

    public int getGreen() {
        RGBSetting lllIlIllIIlIl;
        return lllIlIllIIlIl.green;
    }

    public RGBSetting(String lllIlIllllIlI, String lllIlIlllIIll, int lllIlIlllIIlI, int lllIlIlllIlll, int lllIlIlllIllI) {
        super(lllIlIllllIlI, lllIlIlllIIll);
        RGBSetting lllIlIlllIlIl;
        lllIlIlllIlIl.red = lllIlIlllIIlI;
        lllIlIlllIlIl.green = lllIlIlllIlll;
        lllIlIlllIlIl.blue = lllIlIlllIllI;
    }

    public void setRed(int lllIlIllIIlll) {
        lllIlIllIlIII.red = lllIlIllIIlll;
    }
}

