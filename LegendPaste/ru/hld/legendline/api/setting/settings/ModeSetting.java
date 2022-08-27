/*
 * Decompiled with CFR 0.150.
 */
package ru.hld.legendline.api.setting.settings;

import java.util.ArrayList;
import java.util.function.Supplier;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.api.setting.Setting;

public class ModeSetting
extends Setting {
    /* synthetic */ String val;
    /* synthetic */ ArrayList<String> modes;

    public ModeSetting(String llllllllllllllllIIIIIlllllIIlIII, String llllllllllllllllIIIIIlllllIIIlll, Module llllllllllllllllIIIIIlllllIIIllI, ArrayList<String> llllllllllllllllIIIIIlllllIIIlIl, String llllllllllllllllIIIIIllllIllllIl, Supplier llllllllllllllllIIIIIllllIllllII) {
        super(llllllllllllllllIIIIIlllllIIlIII, llllllllllllllllIIIIIlllllIIIlll, llllllllllllllllIIIIIlllllIIIllI, llllllllllllllllIIIIIllllIllllII);
        ModeSetting llllllllllllllllIIIIIlllllIIlIIl;
        llllllllllllllllIIIIIlllllIIlIIl.modes = new ArrayList();
        llllllllllllllllIIIIIlllllIIlIIl.modes = llllllllllllllllIIIIIlllllIIIlIl;
        llllllllllllllllIIIIIlllllIIlIIl.val = llllllllllllllllIIIIIllllIllllIl;
    }

    public void setVal(String llllllllllllllllIIIIIllllIIllllI) {
        llllllllllllllllIIIIIllllIlIIIIl.val = llllllllllllllllIIIIIllllIIllllI;
    }

    public ArrayList<String> getModes() {
        ModeSetting llllllllllllllllIIIIIllllIlIIlIl;
        return llllllllllllllllIIIIIllllIlIIlIl.modes;
    }

    public String getVal() {
        ModeSetting llllllllllllllllIIIIIllllIlIlIII;
        return llllllllllllllllIIIIIllllIlIlIII.val;
    }

    public ModeSetting(String llllllllllllllllIIIIIllllIlIlllI, String llllllllllllllllIIIIIllllIlIllIl, Module llllllllllllllllIIIIIllllIlIllII, ArrayList<String> llllllllllllllllIIIIIllllIllIIIl, String llllllllllllllllIIIIIllllIlIlIlI) {
        super(llllllllllllllllIIIIIllllIlIlllI, llllllllllllllllIIIIIllllIlIllIl, llllllllllllllllIIIIIllllIlIllII);
        ModeSetting llllllllllllllllIIIIIllllIllIlIl;
        llllllllllllllllIIIIIllllIllIlIl.modes = new ArrayList();
        llllllllllllllllIIIIIllllIllIlIl.modes = llllllllllllllllIIIIIllllIllIIIl;
        llllllllllllllllIIIIIllllIllIlIl.val = llllllllllllllllIIIIIllllIlIlIlI;
    }
}

