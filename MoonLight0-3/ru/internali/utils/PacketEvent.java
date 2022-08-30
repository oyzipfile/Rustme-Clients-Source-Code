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
public class PacketEvent
extends Event {
    private static /* synthetic */ Packet<?> packet;

    public static Packet<?> getPacket() {
        return packet;
    }

    public PacketEvent(Packet<?> lIlIlIIlIlllllI) {
        PacketEvent lIlIlIIlIllllll;
        packet = lIlIlIIlIlllllI;
    }

    public void setPacket(Packet<?> lIlIlIIlIllIllI) {
        packet = lIlIlIIlIllIllI;
    }
}

