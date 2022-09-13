/*
 * Decompiled with CFR 0.150.
 */
package ru.hld.legendline.impl.modules.Render;

import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.module.Module;

public class FullBright
extends Module {
    /* synthetic */ float old;

    @Override
    public void onEnable() {
        FullBright lllllllllllllllIIllIIIIlllIlIlII;
        super.onEnable();
        lllllllllllllllIIllIIIIlllIlIlII.old = lllllllllllllllIIllIIIIlllIlIlII.mc.gameSettings.gammaSetting;
        lllllllllllllllIIllIIIIlllIlIlII.mc.gameSettings.gammaSetting = 1000.0f;
    }

    public FullBright() {
        super("FullBright", "enable max light", Category.Render);
        FullBright lllllllllllllllIIllIIIIlllIllIII;
    }

    @Override
    public void onDisable() {
        FullBright lllllllllllllllIIllIIIIlllIlIIlI;
        super.onDisable();
        lllllllllllllllIIllIIIIlllIlIIlI.mc.gameSettings.gammaSetting = lllllllllllllllIIllIIIIlllIlIIlI.old;
    }
}

