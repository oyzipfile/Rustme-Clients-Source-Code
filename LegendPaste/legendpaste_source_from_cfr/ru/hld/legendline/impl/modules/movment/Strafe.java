/*
 * Decompiled with CFR 0.150.
 */
package ru.hld.legendline.impl.modules.movment;

import ru.hld.legendline.Client;
import ru.hld.legendline.api.event.EventTarget;
import ru.hld.legendline.api.event.events.EventUpdate;
import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.api.setting.settings.FloatSetting;
import ru.hld.legendline.api.utils.MoveUtils;

public class Strafe
extends Module {
    /* synthetic */ FloatSetting speed;

    public Strafe() {
        super("Strafe", "allow you always run", Category.Movement);
        Strafe llllllllllllllIlIlllllIIlIlllIll;
        llllllllllllllIlIlllllIIlIlllIll.speed = new FloatSetting("Speed", "Speed val", llllllllllllllIlIlllllIIlIlllIll, 1.0f, 35.0f, 23.0f, 1.0f);
        Client.settingManager.add(llllllllllllllIlIlllllIIlIlllIll.speed);
    }

    @EventTarget
    public void onUpdate(EventUpdate llllllllllllllIlIlllllIIlIlllIII) {
        Strafe llllllllllllllIlIlllllIIlIlllIIl;
        if (llllllllllllllIlIlllllIIlIlllIIl.mc.player.isSneaking()) {
            return;
        }
        if (llllllllllllllIlIlllllIIlIlllIIl.mc.player.onGround) {
            MoveUtils.setSpeed((double)(llllllllllllllIlIlllllIIlIlllIIl.speed.getVal() / 100.0f) - 0.05);
        } else {
            MoveUtils.setSpeed(llllllllllllllIlIlllllIIlIlllIIl.speed.getVal() / 100.0f);
        }
    }
}

