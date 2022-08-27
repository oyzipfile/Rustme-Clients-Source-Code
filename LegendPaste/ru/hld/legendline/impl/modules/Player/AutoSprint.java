/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.text.TextFormatting
 */
package ru.hld.legendline.impl.modules.Player;

import java.util.ArrayList;
import net.minecraft.util.text.TextFormatting;
import ru.hld.legendline.Client;
import ru.hld.legendline.api.event.EventTarget;
import ru.hld.legendline.api.event.events.EventUpdate;
import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.api.setting.settings.ModeSetting;
import ru.hld.legendline.api.utils.MoveUtils;

public class AutoSprint
extends Module {
    /* synthetic */ ModeSetting mode;

    @EventTarget
    public void onUpdate(EventUpdate llllllllllllllIIlIIIIIIlllllllIl) {
        AutoSprint llllllllllllllIIlIIIIIIlllllllII;
        llllllllllllllIIlIIIIIIlllllllII.setDisplayname(String.valueOf(new StringBuilder().append(llllllllllllllIIlIIIIIIlllllllII.getName()).append(" ").append((Object)TextFormatting.WHITE).append(llllllllllllllIIlIIIIIIlllllllII.mode.getVal())));
        switch (llllllllllllllIIlIIIIIIlllllllII.mode.getVal()) {
            case "Legit": {
                llllllllllllllIIlIIIIIIlllllllII.mc.gameSettings.keyBindSprint.pressed = true;
                break;
            }
            case "setSprinting()": {
                if (!llllllllllllllIIlIIIIIIlllllllII.mc.player.onGround) break;
                llllllllllllllIIlIIIIIIlllllllII.mc.player.motionY = 0.15f;
                if (!(llllllllllllllIIlIIIIIIlllllllII.mc.player.fallDistance < 0.01f)) break;
                MoveUtils.setSpeed(35.0);
            }
        }
    }

    public AutoSprint() {
        super("AutoSprint", "autoPress CTRL", Category.Player);
        AutoSprint llllllllllllllIIlIIIIIlIIIIIIlIl;
        ArrayList<String> llllllllllllllIIlIIIIIlIIIIIIlII = new ArrayList<String>();
        llllllllllllllIIlIIIIIlIIIIIIlII.add("Legit");
        llllllllllllllIIlIIIIIlIIIIIIlII.add("setSprinting()");
        llllllllllllllIIlIIIIIlIIIIIIlIl.mode = new ModeSetting("Mode", "modes of Sprint", llllllllllllllIIlIIIIIlIIIIIIlIl, llllllllllllllIIlIIIIIlIIIIIIlII, "Legit");
        Client.settingManager.add(llllllllllllllIIlIIIIIlIIIIIIlIl.mode);
    }
}

