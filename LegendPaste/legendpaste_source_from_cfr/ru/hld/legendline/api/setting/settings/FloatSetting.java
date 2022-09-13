/*
 * Decompiled with CFR 0.150.
 */
package ru.hld.legendline.api.setting.settings;

import java.util.function.Supplier;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.api.setting.Setting;

public class FloatSetting
extends Setting {
    /* synthetic */ float increment;
    /* synthetic */ float val;
    /* synthetic */ float max;
    /* synthetic */ float min;

    public float getMax() {
        FloatSetting llllllllllllllIlIlllllIIIIIIIllI;
        return llllllllllllllIlIlllllIIIIIIIllI.max;
    }

    public FloatSetting(String llllllllllllllIlIlllllIIIIllIIII, String llllllllllllllIlIlllllIIIIlIllll, Module llllllllllllllIlIlllllIIIIlIlllI, float llllllllllllllIlIlllllIIIIllIllI, float llllllllllllllIlIlllllIIIIlIllII, float llllllllllllllIlIlllllIIIIlIlIll, float llllllllllllllIlIlllllIIIIlIlIlI, Supplier llllllllllllllIlIlllllIIIIllIIlI) {
        super(llllllllllllllIlIlllllIIIIllIIII, llllllllllllllIlIlllllIIIIlIllll, llllllllllllllIlIlllllIIIIlIlllI, llllllllllllllIlIlllllIIIIllIIlI);
        FloatSetting llllllllllllllIlIlllllIIIIllIIIl;
        llllllllllllllIlIlllllIIIIllIIIl.increment = llllllllllllllIlIlllllIIIIlIlIlI;
        llllllllllllllIlIlllllIIIIllIIIl.max = llllllllllllllIlIlllllIIIIlIllII;
        llllllllllllllIlIlllllIIIIllIIIl.min = llllllllllllllIlIlllllIIIIllIllI;
        llllllllllllllIlIlllllIIIIllIIIl.val = llllllllllllllIlIlllllIIIIlIlIll;
    }

    public float getMin() {
        FloatSetting llllllllllllllIlIlllllIIIIIIlIIl;
        return llllllllllllllIlIlllllIIIIIIlIIl.min;
    }

    public FloatSetting(String llllllllllllllIlIlllllIIIIIlIlll, String llllllllllllllIlIlllllIIIIIllllI, Module llllllllllllllIlIlllllIIIIIlllIl, float llllllllllllllIlIlllllIIIIIlIlII, float llllllllllllllIlIlllllIIIIIlIIll, float llllllllllllllIlIlllllIIIIIlIIlI, float llllllllllllllIlIlllllIIIIIllIIl) {
        super(llllllllllllllIlIlllllIIIIIlIlll, llllllllllllllIlIlllllIIIIIllllI, llllllllllllllIlIlllllIIIIIlllIl);
        FloatSetting llllllllllllllIlIlllllIIIIlIIIII;
        llllllllllllllIlIlllllIIIIlIIIII.increment = llllllllllllllIlIlllllIIIIIllIIl;
        llllllllllllllIlIlllllIIIIlIIIII.max = llllllllllllllIlIlllllIIIIIlIIll;
        llllllllllllllIlIlllllIIIIlIIIII.min = llllllllllllllIlIlllllIIIIIlIlII;
        llllllllllllllIlIlllllIIIIlIIIII.val = llllllllllllllIlIlllllIIIIIlIIlI;
    }

    public float getIncrement() {
        FloatSetting llllllllllllllIlIlllllIIIIIIllll;
        return llllllllllllllIlIlllllIIIIIIllll.increment;
    }

    public void setVal(float llllllllllllllIlIllllIllllllllll) {
        llllllllllllllIlIlllllIIIIIIIIII.val = llllllllllllllIlIllllIllllllllll;
    }

    public float getVal() {
        FloatSetting llllllllllllllIlIlllllIIIIIIllII;
        return llllllllllllllIlIlllllIIIIIIllII.val;
    }
}

