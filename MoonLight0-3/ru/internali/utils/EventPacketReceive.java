/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 */
package ru.internali.utils;

import net.minecraft.network.Packet;
import ru.internali.utils.Event;

public class EventPacketReceive
extends Event {
    /* synthetic */ Packet packet;

    public Packet getPacket() {
        EventPacketReceive llllllIlllIIlll;
        return llllllIlllIIlll.packet;
    }

    public void setPacket(Packet llllllIlllIIIll) {
        llllllIlllIIIlI.packet = llllllIlllIIIll;
    }

    public EventPacketReceive(Packet llllllIlllIllII) {
        EventPacketReceive llllllIlllIlIll;
        llllllIlllIlIll.packet = llllllIlllIllII;
    }
}

