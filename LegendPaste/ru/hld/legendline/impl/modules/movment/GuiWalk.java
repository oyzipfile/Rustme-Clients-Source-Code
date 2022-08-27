/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiChat
 *  org.lwjgl.input.Keyboard
 */
package ru.hld.legendline.impl.modules.movment;

import net.minecraft.client.gui.GuiChat;
import org.lwjgl.input.Keyboard;
import ru.hld.legendline.Client;
import ru.hld.legendline.api.event.EventTarget;
import ru.hld.legendline.api.event.events.EventUpdate;
import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.api.setting.settings.BooleanSetting;

public class GuiWalk
extends Module {
    /* synthetic */ BooleanSetting sneak;

    @EventTarget
    public void onUpdate(EventUpdate llllllllllllllllIlIIIIIlIlllIIlI) {
        GuiWalk llllllllllllllllIlIIIIIlIlllIIIl;
        if (llllllllllllllllIlIIIIIlIlllIIIl.mc.currentScreen != null && !(llllllllllllllllIlIIIIIlIlllIIIl.mc.currentScreen instanceof GuiChat)) {
            llllllllllllllllIlIIIIIlIlllIIIl.mc.gameSettings.keyBindJump.pressed = Keyboard.isKeyDown((int)llllllllllllllllIlIIIIIlIlllIIIl.mc.gameSettings.keyBindJump.getKeyCode());
            llllllllllllllllIlIIIIIlIlllIIIl.mc.gameSettings.keyBindForward.pressed = Keyboard.isKeyDown((int)llllllllllllllllIlIIIIIlIlllIIIl.mc.gameSettings.keyBindForward.getKeyCode());
            llllllllllllllllIlIIIIIlIlllIIIl.mc.gameSettings.keyBindBack.pressed = Keyboard.isKeyDown((int)llllllllllllllllIlIIIIIlIlllIIIl.mc.gameSettings.keyBindBack.getKeyCode());
            llllllllllllllllIlIIIIIlIlllIIIl.mc.gameSettings.keyBindLeft.pressed = Keyboard.isKeyDown((int)llllllllllllllllIlIIIIIlIlllIIIl.mc.gameSettings.keyBindLeft.getKeyCode());
            llllllllllllllllIlIIIIIlIlllIIIl.mc.gameSettings.keyBindRight.pressed = Keyboard.isKeyDown((int)llllllllllllllllIlIIIIIlIlllIIIl.mc.gameSettings.keyBindRight.getKeyCode());
            if (llllllllllllllllIlIIIIIlIlllIIIl.sneak.getVal()) {
                llllllllllllllllIlIIIIIlIlllIIIl.mc.gameSettings.keyBindSneak.pressed = Keyboard.isKeyDown((int)llllllllllllllllIlIIIIIlIlllIIIl.mc.gameSettings.keyBindSneak.getKeyCode());
            }
            llllllllllllllllIlIIIIIlIlllIIIl.mc.gameSettings.keyBindSprint.pressed = Keyboard.isKeyDown((int)llllllllllllllllIlIIIIIlIlllIIIl.mc.gameSettings.keyBindSprint.getKeyCode());
        }
    }

    public GuiWalk() {
        super("GuiWalk", "you can walk in clickgui", Category.Movement);
        GuiWalk llllllllllllllllIlIIIIIlIllllIIl;
        llllllllllllllllIlIIIIIlIllllIIl.sneak = new BooleanSetting("Sneak", "you can sneak in gui", (Module)llllllllllllllllIlIIIIIlIllllIIl, false);
        Client.settingManager.add(llllllllllllllllIlIIIIIlIllllIIl.sneak);
    }

    @Override
    public void onDisable() {
        GuiWalk llllllllllllllllIlIIIIIlIlllIlIl;
        super.onDisable();
    }
}

