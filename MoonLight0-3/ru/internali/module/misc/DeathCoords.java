/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package ru.internali.module.misc;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.module.movement.Command;

public class DeathCoords
extends Module {
    public static /* synthetic */ int deley;

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent llIIlIIlIIlIIlI) {
        if (DeathCoords.mc.player.func_110143_aJ() < 0.0f || DeathCoords.mc.player.field_70128_L || !DeathCoords.mc.player.func_70089_S()) {
            if (++deley == 0) {
                Command.sendClientSideMessage(String.valueOf(new StringBuilder().append(" DeathCoords! X:").append((int)DeathCoords.mc.player.field_70165_t).append(" Y:").append((int)DeathCoords.mc.player.field_70163_u).append(" Z:").append((int)DeathCoords.mc.player.field_70161_v)));
            }
            if (deley >= 10) {
                deley = -1;
            }
        }
    }

    public DeathCoords() {
        super("DeathCoords", "DeathCoords", Category.OUTHER);
        DeathCoords llIIlIIlIIlIlIl;
    }

    @Override
    public void onDisable() {
        DeathCoords llIIlIIlIIlIIII;
        super.onDisable();
    }
}

