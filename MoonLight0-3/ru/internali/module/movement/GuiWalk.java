/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiIngameMenu
 *  net.minecraft.client.gui.GuiOptions
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraftforge.client.event.InputUpdateEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.input.Keyboard
 */
package ru.internali.module.movement;

import clickgui.Clickgui;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import new_gui.CSGOGui;
import org.lwjgl.input.Keyboard;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;

public class GuiWalk
extends Module {
    @Override
    public void onDisable() {
        GuiWalk lIllllIIIlIIlIl;
        super.onDisable();
    }

    @Override
    public void onEnable() {
        GuiWalk lIllllIIIlIIIlI;
        super.onEnable();
    }

    @SubscribeEvent
    public void onKeyUpdate(InputUpdateEvent lIllllIIIIllllI) {
        GuiWalk lIllllIIIIlllll;
        boolean lIllllIIIIlllIl = CatClient.instance.settingsManager.getSettingByName(lIllllIIIIlllll, "Sneak").getValBoolean();
        if (GuiWalk.mc.world != null && GuiWalk.mc.player != null && (GuiWalk.mc.currentScreen instanceof GuiContainer || GuiWalk.mc.currentScreen instanceof GuiIngameMenu || GuiWalk.mc.currentScreen instanceof GuiOptions || GuiWalk.mc.currentScreen instanceof CSGOGui || GuiWalk.mc.currentScreen instanceof Clickgui)) {
            if (Keyboard.isKeyDown((int)GuiWalk.mc.gameSettings.keyBindForward.getKeyCode())) {
                GuiWalk.mc.player.movementInput.moveForward += 1.0f;
                GuiWalk.mc.player.movementInput.forwardKeyDown = true;
            }
            if (Keyboard.isKeyDown((int)GuiWalk.mc.gameSettings.keyBindBack.getKeyCode())) {
                GuiWalk.mc.player.movementInput.moveForward -= 1.0f;
                GuiWalk.mc.player.movementInput.backKeyDown = true;
            }
            if (Keyboard.isKeyDown((int)GuiWalk.mc.gameSettings.keyBindRight.getKeyCode())) {
                GuiWalk.mc.player.movementInput.moveStrafe -= 1.0f;
                GuiWalk.mc.player.movementInput.rightKeyDown = true;
            }
            if (Keyboard.isKeyDown((int)GuiWalk.mc.gameSettings.keyBindLeft.getKeyCode())) {
                GuiWalk.mc.player.movementInput.moveStrafe += 1.0f;
                GuiWalk.mc.player.movementInput.rightKeyDown = true;
            }
            GuiWalk.mc.player.movementInput.jump = Keyboard.isKeyDown((int)GuiWalk.mc.gameSettings.keyBindJump.getKeyCode());
            boolean bl = GuiWalk.mc.player.movementInput.sneak = lIllllIIIIlllIl && Keyboard.isKeyDown((int)GuiWalk.mc.gameSettings.keyBindSneak.getKeyCode());
            if (GuiWalk.mc.player.movementInput.sneak) {
                GuiWalk.mc.player.movementInput.moveStrafe = (float)((double)GuiWalk.mc.player.movementInput.moveStrafe * 0.3);
                GuiWalk.mc.player.movementInput.moveForward = (float)((double)GuiWalk.mc.player.movementInput.moveForward * 0.3);
            }
        }
    }

    public GuiWalk() {
        super("GuiWalk", "go", Category.MOVEMENT);
        GuiWalk lIllllIIIlIlIIl;
        CatClient.instance.settingsManager.rSetting(new Setting("Sneak", lIllllIIIlIlIIl, false));
    }
}

