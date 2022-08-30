/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.MoverType
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package ru.internali.module.movement;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.MoverType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.module.misc.MovementUtil;

public class Speed
extends Module {
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent lIlIlllllIlIIIl) {
        if (MovementUtil.isMoving() && Speed.mc.player.field_70122_E) {
            Speed.mc.player.move(MoverType.PLAYER, 0.0, 0.16, 0.0);
            EntityPlayerSP lIlIlllllIlIIll = Speed.mc.player;
            lIlIlllllIlIIll.field_70159_w *= 1.04;
            lIlIlllllIlIIll = Speed.mc.player;
            lIlIlllllIlIIll.field_70179_y *= 1.04;
        }
    }

    public Speed() {
        super("Speed", "Speed", Category.MOVEMENT);
        Speed lIlIlllllIlIlIl;
    }
}

