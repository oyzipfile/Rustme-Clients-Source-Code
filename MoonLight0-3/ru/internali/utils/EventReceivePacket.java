/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 */
package ru.internali.utils;

import net.minecraft.network.Packet;
import ru.internali.utils.EventCancellable;

public class EventReceivePacket
extends EventCancellable {
    private static /* synthetic */ Packet<?> packet;

    @Override
    public boolean cancel() {
        return false;
    }

    public void setPacket(Packet<?> lIIIlIIllIIllII) {
        packet = lIIIlIIllIIllII;
    }

    public EventReceivePacket(Packet<?> lIIIlIIllIlIIlI) {
        EventReceivePacket lIIIlIIllIlIIll;
        packet = lIIIlIIllIlIIlI;
    }

    public static Packet<?> getPacket() {
        return packet;
    }
}

