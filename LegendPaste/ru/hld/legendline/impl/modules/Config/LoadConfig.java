/*
 * Decompiled with CFR 0.150.
 */
package ru.hld.legendline.impl.modules.Config;

import ru.hld.legendline.api.event.EventTarget;
import ru.hld.legendline.api.event.events.EventUpdate;
import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.api.shit.cfg;

public class LoadConfig
extends Module {
    public LoadConfig() {
        super("LoadConfig", "LoadConfig", Category.Config);
        LoadConfig lllllllllllllIlllIIIlllIllllIlII;
    }

    @Override
    public void onEnable() {
        LoadConfig lllllllllllllIlllIIIlllIlllIlIll;
        lllllllllllllIlllIIIlllIlllIlIll.toggle();
        cfg.load();
    }

    @EventTarget
    public void onUpdate(EventUpdate lllllllllllllIlllIIIlllIlllIllIl) {
    }
}

