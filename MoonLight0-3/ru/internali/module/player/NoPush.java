/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package ru.internali.module.player;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import ru.internali.module.Category;
import ru.internali.module.Module;

public class NoPush
extends Module {
    public NoPush() {
        super("NoPush", "NoPush", Category.PLAYER);
        NoPush lllIlIlIlIIlI;
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent lllIlIlIIllll) {
        NoPush.mc.player.field_70144_Y = 1.0f;
    }
}

