/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 */
package ru.internali.module.CHAT;

import net.minecraft.network.Packet;
import ru.internali.utils.EventCancellable;

public class PacketEvents
extends EventCancellable {
    private final /* synthetic */ Packet packet;

    public Packet getPacket() {
        PacketEvents lIlIIIlIIIIlIlI;
        return lIlIIIlIIIIlIlI.packet;
    }

    @Override
    public boolean cancel() {
        return false;
    }

    public PacketEvents(Packet lIlIIIlIIIIllll) {
        PacketEvents lIlIIIlIIIIlllI;
        lIlIIIlIIIIlllI.packet = lIlIIIlIIIIllll;
    }

    public static class Send
    extends PacketEvents {
        public Send(Packet llllIIllIllIIlI) {
            super(llllIIllIllIIlI);
            Send llllIIllIllIIll;
        }
    }

    public static class Receive
    extends PacketEvents {
        public Receive(Packet llIlIIIIlllllll) {
            super(llIlIIIIlllllll);
            Receive llIlIIIlIIIIIII;
        }
    }
}

