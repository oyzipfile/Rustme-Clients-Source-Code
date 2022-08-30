/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package ru.internali.module.movement;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import ru.internali.module.Category;
import ru.internali.module.Module;

public class Sprint
extends Module {
    public static /* synthetic */ Sprint instance;

    @Override
    public void onDisable() {
        Sprint lllIIIllIIIllll;
        super.onDisable();
        KeyBinding.setKeyBindState((int)Sprint.mc.gameSettings.keyBindSprint.getKeyCode(), (boolean)false);
    }

    public Sprint() {
        super("Sprint", "i like sprinting", Category.MOVEMENT);
        Sprint lllIIIllIIlIlII;
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent lllIIIllIIlIIlI) {
        KeyBinding.setKeyBindState((int)Sprint.mc.gameSettings.keyBindSprint.getKeyCode(), (boolean)true);
    }
}

