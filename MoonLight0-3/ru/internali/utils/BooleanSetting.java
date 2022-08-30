/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils;

import ru.internali.settings.Setting;

public class BooleanSetting
extends Setting {
    private /* synthetic */ boolean value;

    public void setValue(boolean lIIlllIlIlllIlI) {
        lIIlllIlIlllIIl.value = lIIlllIlIlllIlI;
    }

    public void toggle() {
        BooleanSetting lIIlllIlIllIlIl;
        lIIlllIlIllIlIl.setValue(!lIIlllIlIllIlIl.value);
    }

    public boolean getValue() {
        BooleanSetting lIIlllIlIlllllI;
        return lIIlllIlIlllllI.value;
    }

    public BooleanSetting(String lIIlllIllIIIIll, String lIIlllIllIIIIlI, boolean lIIlllIllIIIlIl) {
        super(lIIlllIllIIIIll, lIIlllIllIIIIlI);
        BooleanSetting lIIlllIllIIIlII;
        lIIlllIllIIIlII.value = lIIlllIllIIIlIl;
    }
}

