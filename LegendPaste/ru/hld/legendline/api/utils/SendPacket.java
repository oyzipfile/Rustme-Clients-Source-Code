/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 */
package ru.hld.legendline.api.utils;

import net.minecraft.network.Packet;

public class SendPacket {
    /* synthetic */ boolean cancelled;
    /* synthetic */ Packet packet;

    public boolean isCancelled() {
        SendPacket llllllllllllllIIIlIIllllIlIlIlII;
        return llllllllllllllIIIlIIllllIlIlIlII.cancelled;
    }

    public SendPacket(Packet llllllllllllllIIIlIIllllIllIIIlI) {
        SendPacket llllllllllllllIIIlIIllllIllIIIll;
        llllllllllllllIIIlIIllllIllIIIll.cancelled = false;
        llllllllllllllIIIlIIllllIllIIIll.packet = llllllllllllllIIIlIIllllIllIIIlI;
    }

    public void setCancelled(boolean llllllllllllllIIIlIIllllIlIIlllI) {
        llllllllllllllIIIlIIllllIlIlIIIl.cancelled = llllllllllllllIIIlIIllllIlIIlllI;
    }

    public void setPacket(Packet llllllllllllllIIIlIIllllIlIlIlll) {
        llllllllllllllIIIlIIllllIlIllIlI.packet = llllllllllllllIIIlIIllllIlIlIlll;
    }

    public Packet getPacket() {
        SendPacket llllllllllllllIIIlIIllllIlIlllIl;
        return llllllllllllllIIIlIIllllIlIlllIl.packet;
    }
}

