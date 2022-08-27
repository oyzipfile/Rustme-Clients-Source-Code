/*
 * Decompiled with CFR 0.150.
 */
package ru.hld.legendline.api.setting.settings;

import java.util.function.Supplier;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.api.setting.Setting;

public class BooleanSetting
extends Setting {
    /* synthetic */ boolean val;

    public BooleanSetting(String llllllllllllllIIIIllIllIIIIlllIl, String llllllllllllllIIIIllIllIIIIlllII, Module llllllllllllllIIIIllIllIIIIlIllI, boolean llllllllllllllIIIIllIllIIIIllIlI) {
        super(llllllllllllllIIIIllIllIIIIlllIl, llllllllllllllIIIIllIllIIIIlllII, llllllllllllllIIIIllIllIIIIlIllI);
        BooleanSetting llllllllllllllIIIIllIllIIIIllIIl;
        llllllllllllllIIIIllIllIIIIllIIl.val = llllllllllllllIIIIllIllIIIIllIlI;
    }

    public boolean getVal() {
        BooleanSetting llllllllllllllIIIIllIllIIIIIllIl;
        return llllllllllllllIIIIllIllIIIIIllIl.val;
    }

    public void setVal(boolean llllllllllllllIIIIllIllIIIIIllll) {
        llllllllllllllIIIIllIllIIIIlIIlI.val = llllllllllllllIIIIllIllIIIIIllll;
    }

    public BooleanSetting(String llllllllllllllIIIIllIllIIIlIlllI, String llllllllllllllIIIIllIllIIIlIllIl, Module llllllllllllllIIIIllIllIIIlIllII, boolean llllllllllllllIIIIllIllIIIlIIlIl, Supplier llllllllllllllIIIIllIllIIIlIlIlI) {
        super(llllllllllllllIIIIllIllIIIlIlllI, llllllllllllllIIIIllIllIIIlIllIl, llllllllllllllIIIIllIllIIIlIllII, llllllllllllllIIIIllIllIIIlIlIlI);
        BooleanSetting llllllllllllllIIIIllIllIIIlIlIIl;
        llllllllllllllIIIIllIllIIIlIlIIl.val = llllllllllllllIIIIllIllIIIlIIlIl;
    }
}

