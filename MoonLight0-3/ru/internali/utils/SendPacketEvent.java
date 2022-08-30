/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 *  net.minecraftforge.fml.common.eventhandler.Event
 */
package ru.internali.utils;

import net.minecraft.network.Packet;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

@Cancelable
public class SendPacketEvent
extends Event {
    private /* synthetic */ Packet<?> packet;

    public Packet<?> getPacket() {
        SendPacketEvent lllIlllIlIlIIIl;
        return lllIlllIlIlIIIl.packet;
    }

    public void setPacket(Packet<?> lllIlllIlIIlIlI) {
        lllIlllIlIIllIl.packet = lllIlllIlIIlIlI;
    }

    public SendPacketEvent(Packet<?> lllIlllIlIlIlIl) {
        SendPacketEvent lllIlllIlIlIllI;
        lllIlllIlIlIllI.packet = lllIlllIlIlIlIl;
    }
}

