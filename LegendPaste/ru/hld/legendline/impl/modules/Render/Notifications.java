/*
 * Decompiled with CFR 0.150.
 */
package ru.hld.legendline.impl.modules.Render;

import ru.hld.legendline.Client;
import ru.hld.legendline.api.event.EventTarget;
import ru.hld.legendline.api.event.events.EventRender2D;
import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.api.setting.settings.BooleanSetting;

public class Notifications
extends Module {
    public static /* synthetic */ BooleanSetting colored;

    @EventTarget
    public void onRender2D(EventRender2D llllllllllllllIllIIIlIllIlllIlll) {
        Client.notificationsManager.render();
    }

    public Notifications() {
        super("Notifications", "show info about toggeling modules", Category.Render);
        Notifications llllllllllllllIllIIIlIllIllllIIl;
        colored = new BooleanSetting("Colored", "mega design in notifications", (Module)llllllllllllllIllIIIlIllIllllIIl, false);
        Client.settingManager.add(colored);
    }
}

