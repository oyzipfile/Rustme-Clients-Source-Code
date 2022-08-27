/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 */
package ru.hld.legendline.api.event.events;

import net.minecraft.network.Packet;
import ru.hld.legendline.api.event.Event;

public class EventPacketReceive
extends Event {
    /* synthetic */ Packet packet;

    public EventPacketReceive(Packet llllllllllllllIlIIIIIlllllIllIII) {
        EventPacketReceive llllllllllllllIlIIIIIlllllIllIIl;
        llllllllllllllIlIIIIIlllllIllIIl.packet = llllllllllllllIlIIIIIlllllIllIII;
    }

    public void setPacket(Packet llllllllllllllIlIIIIIlllllIIllll) {
        llllllllllllllIlIIIIIlllllIlIIII.packet = llllllllllllllIlIIIIIlllllIIllll;
    }

    public Packet getPacket() {
        EventPacketReceive llllllllllllllIlIIIIIlllllIlIlII;
        return llllllllllllllIlIIIIIlllllIlIlII.packet;
    }
}

