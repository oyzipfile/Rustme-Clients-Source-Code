/*
 * Decompiled with CFR 0.150.
 */
package ru.hld.legendline.impl.modules.Config;

import ru.hld.legendline.api.event.EventTarget;
import ru.hld.legendline.api.event.events.EventUpdate;
import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.api.shit.cfg;

public class SaveConfig
extends Module {
    @EventTarget
    public void onUpdate(EventUpdate lllIlllIlIlII) {
    }

    @Override
    public void onEnable() {
        SaveConfig lllIlllIlIIIl;
        lllIlllIlIIIl.toggle();
        cfg.save();
    }

    public SaveConfig() {
        super("SaveConfig", "Save you settings", Category.Config);
        SaveConfig lllIlllIlIlll;
    }
}

