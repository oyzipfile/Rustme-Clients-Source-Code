/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package ru.internali.module.player;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import ru.internali.module.Category;
import ru.internali.module.Module;

public class AntiAFK
extends Module {
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent lIIllIlIlIIIIIl) {
        AntiAFK lIIllIlIlIIIIII;
        if (lIIllIlIlIIIIII.isToggled() && AntiAFK.mc.player.field_70122_E) {
            AntiAFK.mc.player.func_70664_aZ();
            KeyBinding.setKeyBindState((int)AntiAFK.mc.gameSettings.keyBindSneak.getKeyCode(), (boolean)true);
            KeyBinding.setKeyBindState((int)AntiAFK.mc.gameSettings.keyBindSneak.getKeyCode(), (boolean)false);
        }
    }

    public AntiAFK() {
        super("AntiAFK", "AntiAFK", Category.PLAYER);
        AntiAFK lIIllIlIlIIIlII;
    }
}

