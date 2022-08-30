/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 */
package ru.internali.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;

public class CheckUtil {
    private static /* synthetic */ Minecraft mc;
    private static /* synthetic */ double z;
    private static /* synthetic */ double x;
    private static /* synthetic */ double y;

    public CheckUtil() {
        CheckUtil lIlllllIIIIllIl;
    }

    static {
        mc = Minecraft.getMinecraft();
    }

    public static void loadcord() {
        CheckUtil.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Position(x, y, z, false));
        CheckUtil.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Position(x, y, z, true));
        CheckUtil.mc.player.func_70634_a(x, y, z);
        CheckUtil.mc.player.func_70107_b(x, y, z);
    }

    public static void savecord() {
        x = CheckUtil.mc.player.field_70165_t;
        y = CheckUtil.mc.player.field_70163_u;
        z = CheckUtil.mc.player.field_70161_v;
    }
}

