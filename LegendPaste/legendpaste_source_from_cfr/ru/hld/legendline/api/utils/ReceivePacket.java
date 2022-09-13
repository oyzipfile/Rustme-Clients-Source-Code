/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelHandlerContext
 *  net.minecraft.network.Packet
 */
package ru.hld.legendline.api.utils;

import io.netty.channel.ChannelHandlerContext;
import net.minecraft.network.Packet;

public class ReceivePacket {
    /* synthetic */ boolean cancelled;
    /* synthetic */ ChannelHandlerContext p_channelRead01;
    /* synthetic */ Packet<?> p_channelRead02;

    public ChannelHandlerContext getP_channelRead01() {
        ReceivePacket llllllllllllllIIIlllIIIlIIllllIl;
        return llllllllllllllIIIlllIIIlIIllllIl.p_channelRead01;
    }

    public void setP_channelRead01(ChannelHandlerContext llllllllllllllIIIlllIIIlIIllIlIl) {
        llllllllllllllIIIlllIIIlIIllIllI.p_channelRead01 = llllllllllllllIIIlllIIIlIIllIlIl;
    }

    public void setCancelled(boolean llllllllllllllIIIlllIIIlIlIIIIIl) {
        llllllllllllllIIIlllIIIlIlIIIIII.cancelled = llllllllllllllIIIlllIIIlIlIIIIIl;
    }

    public ReceivePacket(ChannelHandlerContext llllllllllllllIIIlllIIIlIlIIllII, Packet<?> llllllllllllllIIIlllIIIlIlIIlIll) {
        ReceivePacket llllllllllllllIIIlllIIIlIlIIlIlI;
        llllllllllllllIIIlllIIIlIlIIlIlI.p_channelRead01 = llllllllllllllIIIlllIIIlIlIIllII;
        llllllllllllllIIIlllIIIlIlIIlIlI.p_channelRead02 = llllllllllllllIIIlllIIIlIlIIlIll;
        llllllllllllllIIIlllIIIlIlIIlIlI.cancelled = false;
    }

    public void setP_channelRead02(Packet<?> llllllllllllllIIIlllIIIlIIlIllll) {
        llllllllllllllIIIlllIIIlIIlIlllI.p_channelRead02 = llllllllllllllIIIlllIIIlIIlIllll;
    }

    public Packet<?> getP_channelRead02() {
        ReceivePacket llllllllllllllIIIlllIIIlIIlllIlI;
        return llllllllllllllIIIlllIIIlIIlllIlI.p_channelRead02;
    }

    public boolean isCancelled() {
        ReceivePacket llllllllllllllIIIlllIIIlIlIIIllI;
        return llllllllllllllIIIlllIIIlIlIIIllI.cancelled;
    }
}

