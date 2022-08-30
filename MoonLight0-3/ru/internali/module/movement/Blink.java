/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package ru.internali.module.movement;

import java.util.LinkedList;
import java.util.Queue;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.utils.PacketEvent;

public class Blink
extends Module {
    /* synthetic */ Queue<CPacketPlayer> packets;
    /* synthetic */ int delay;

    public Blink() {
        super("Blink", "Blink", Category.MOVEMENT);
        Blink lIlIllIIlIIIll;
        lIlIllIIlIIIll.delay = 0;
        lIlIllIIlIIIll.packets = new LinkedList<CPacketPlayer>();
    }

    @SubscribeEvent
    public void onPlayerTick(PacketEvent lIlIllIIIllllI) {
        Blink lIlIllIIIlllll;
        if (PacketEvent.getPacket() instanceof CPacketPlayer && lIlIllIIIlllll.delay <= 20) {
            lIlIllIIIllllI.setCanceled(true);
            lIlIllIIIlllll.packets.add((CPacketPlayer)PacketEvent.getPacket());
        }
    }

    @Override
    public void onDisable() {
        Blink lIlIllIIIllIIl;
        while (!lIlIllIIIllIIl.packets.isEmpty()) {
            Blink.mc.player.connection.sendPacket((Packet)lIlIllIIIllIIl.packets.poll());
        }
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent lIlIllIIIlIllI) {
        Blink lIlIllIIIlIlIl;
        ++lIlIllIIIlIlIl.delay;
        if (lIlIllIIIlIlIl.delay > 20) {
            while (!lIlIllIIIlIlIl.packets.isEmpty()) {
                Blink.mc.player.connection.sendPacket((Packet)lIlIllIIIlIlIl.packets.poll());
                lIlIllIIIlIlIl.packets.clear();
                lIlIllIIIlIlIl.delay = 0;
            }
        }
    }
}

