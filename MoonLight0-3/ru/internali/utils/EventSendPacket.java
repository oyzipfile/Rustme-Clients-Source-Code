/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 */
package ru.internali.utils;

import net.minecraft.network.Packet;
import ru.internali.utils.EventCancellable;

public class EventSendPacket
extends EventCancellable {
    private final /* synthetic */ Packet<?> packet;

    @Override
    public boolean cancel() {
        return false;
    }

    public EventSendPacket(Packet lllIllIIIlIII) {
        EventSendPacket lllIllIIIlIIl;
        lllIllIIIlIIl.packet = lllIllIIIlIII;
    }

    public Packet getPacket() {
        EventSendPacket lllIllIIIIIll;
        return lllIllIIIIIll.packet;
    }
}

