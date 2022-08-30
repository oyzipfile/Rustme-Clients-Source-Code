/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package ru.internali.module.player;

import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.utils.TimerUtils;

public class BackTP
extends Module {
    public /* synthetic */ TimerUtils timerHelper;

    @Override
    public void onDisable() {
        BackTP llIIlIllIlIIIlI;
        BackTP.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Position(BackTP.mc.player.field_70165_t, BackTP.mc.player.field_70163_u + 5.0, BackTP.mc.player.field_70161_v, true));
        super.onDisable();
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent llIIlIllIlIIllI) {
        BackTP llIIlIllIlIIlll;
        BackTP.mc.player.field_70122_E = true;
        BackTP.mc.player.setSprinting(false);
        BackTP.mc.player.field_70122_E = false;
        if (!BackTP.mc.player.isSneaking()) {
            return;
        }
        if (BackTP.mc.player.field_70173_aa % 5 == 0) {
            BackTP.mc.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)BackTP.mc.player, CPacketEntityAction.Action.STOP_SNEAKING));
        }
        if (BackTP.mc.player.field_70122_E) {
            BackTP.mc.player.func_70664_aZ();
        }
        if (llIIlIllIlIIlll.timerHelper.hasReached(30.0f)) {
            BackTP.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Position(BackTP.mc.player.field_70165_t, 200.0, BackTP.mc.player.field_70161_v, true));
            llIIlIllIlIIlll.timerHelper.reset();
        }
    }

    @Override
    public void onEnable() {
        BackTP llIIlIllIllIIII;
        int llIIlIllIlIllll = BackTP.mc.player.getPosition().func_177958_n();
        int llIIlIllIlIlllI = BackTP.mc.player.getPosition().func_177956_o();
        int llIIlIllIlIllIl = BackTP.mc.player.getPosition().func_177952_p();
        super.onEnable();
    }

    public BackTP() {
        super("BackTP", "Clip", Category.PLAYER);
        BackTP llIIlIllIllIllI;
    }
}

