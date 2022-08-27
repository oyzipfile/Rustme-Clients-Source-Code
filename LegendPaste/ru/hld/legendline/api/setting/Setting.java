/*
 * Decompiled with CFR 0.150.
 */
package ru.hld.legendline.api.setting;

import java.util.function.Supplier;
import ru.hld.legendline.api.module.Module;

public class Setting {
    /* synthetic */ Supplier<Boolean> visible;
    /* synthetic */ String name;
    /* synthetic */ String descriptions;
    /* synthetic */ int color;
    /* synthetic */ Module module;

    public boolean isVisible() {
        Setting lllllllllllllIllllIIllIllIIIlIlI;
        return lllllllllllllIllllIIllIllIIIlIlI.visible.get();
    }

    public Module getModule() {
        Setting lllllllllllllIllllIIllIllIIlllll;
        return lllllllllllllIllllIIllIllIIlllll.module;
    }

    public Setting(String lllllllllllllIllllIIlllIIIlIlIIl, String lllllllllllllIllllIIlllIIIIllIlI, Module lllllllllllllIllllIIlllIIIIllIII) {
        Setting lllllllllllllIllllIIlllIIIIllllI;
        lllllllllllllIllllIIlllIIIIllllI.name = lllllllllllllIllllIIlllIIIlIlIIl;
        lllllllllllllIllllIIlllIIIIllllI.descriptions = lllllllllllllIllllIIlllIIIIllIlI;
        lllllllllllllIllllIIlllIIIIllllI.visible = () -> true;
        lllllllllllllIllllIIlllIIIIllllI.module = lllllllllllllIllllIIlllIIIIllIII;
    }

    public Supplier<Boolean> getVisible() {
        Setting lllllllllllllIllllIIllIllIIIlllI;
        return lllllllllllllIllllIIllIllIIIlllI.visible;
    }

    public Setting(String lllllllllllllIllllIIllIllllllIIl, String lllllllllllllIllllIIlllIIIIIIlII, Module lllllllllllllIllllIIlllIIIIIIIIl, Supplier lllllllllllllIllllIIllIlllllllll) {
        Setting lllllllllllllIllllIIllIlllllllII;
        lllllllllllllIllllIIllIlllllllII.name = lllllllllllllIllllIIllIllllllIIl;
        lllllllllllllIllllIIllIlllllllII.descriptions = lllllllllllllIllllIIlllIIIIIIlII;
        lllllllllllllIllllIIllIlllllllII.visible = lllllllllllllIllllIIllIlllllllll;
        lllllllllllllIllllIIllIlllllllII.module = lllllllllllllIllllIIlllIIIIIIIIl;
    }

    public Setting(String lllllllllllllIllllIIllIllIllllIl, int lllllllllllllIllllIIllIllIllIIlI, String lllllllllllllIllllIIllIllIlllIlI, Module lllllllllllllIllllIIllIllIlIlIIl, Supplier lllllllllllllIllllIIllIllIlIIllI) {
        Setting lllllllllllllIllllIIllIllIllllll;
        lllllllllllllIllllIIllIllIllllll.name = lllllllllllllIllllIIllIllIllllIl;
        lllllllllllllIllllIIllIllIllllll.descriptions = lllllllllllllIllllIIllIllIlllIlI;
        lllllllllllllIllllIIllIllIllllll.visible = lllllllllllllIllllIIllIllIlIIllI;
        lllllllllllllIllllIIllIllIllllll.module = lllllllllllllIllllIIllIllIlIlIIl;
        lllllllllllllIllllIIllIllIllllll.color = lllllllllllllIllllIIllIllIllIIlI;
    }

    public String getDescriptions() {
        Setting lllllllllllllIllllIIllIllIIlIIIl;
        return lllllllllllllIllllIIllIllIIlIIIl.descriptions;
    }

    public String getName() {
        Setting lllllllllllllIllllIIllIllIIllIlI;
        return lllllllllllllIllllIIllIllIIllIlI.name;
    }
}

