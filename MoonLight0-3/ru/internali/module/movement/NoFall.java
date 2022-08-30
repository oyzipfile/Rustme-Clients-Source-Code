/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package ru.internali.module.movement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;

public class NoFall
extends Module {
    public static /* synthetic */ List<String> Modes;

    static {
        Modes = new ArrayList<String>();
    }

    public NoFall() {
        super("NoFall", "NoFall", Category.MOVEMENT);
        NoFall lIlIlIlIlIlIIl;
        Modes.add("Def");
        Modes.add("Verus");
        Modes.add("Old");
        CatClient.instance.settingsManager.rSetting(new Setting("Mode", lIlIlIlIlIlIIl, "Def", (ArrayList)Modes));
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent lIlIlIlIlIIlIl) {
        NoFall lIlIlIlIlIIIll;
        String lIlIlIlIlIIlII = CatClient.instance.settingsManager.getSettingByName(lIlIlIlIlIIIll, "Mode").getValString();
        if (Objects.equals(lIlIlIlIlIIlII, "Def")) {
            if (NoFall.mc.player.field_70143_R >= 2.2f) {
                NoFall.mc.player.field_70159_w = 0.04f;
                NoFall.mc.player.field_70181_x = -55.0;
                NoFall.mc.player.connection.sendPacket((Packet)new CPacketPlayer(true));
                NoFall.mc.player.connection.sendPacket((Packet)new CPacketPlayer(true));
                NoFall.mc.player.connection.sendPacket((Packet)new CPacketPlayer(true));
            }
        } else if (Objects.equals(lIlIlIlIlIIlII, "Verus")) {
            if (NoFall.mc.player.field_70143_R >= 2.0f) {
                NoFall.mc.player.field_70159_w = 0.01;
                NoFall.mc.player.field_70181_x = -0.0010101001323131;
                NoFall.mc.player.field_70159_w = 0.05;
                NoFall.mc.player.field_70181_x = -0.0010101001323131;
                NoFall.mc.player.field_70159_w = 0.0;
                NoFall.mc.player.field_70181_x = -0.0010101001323131;
                NoFall.mc.player.connection.sendPacket((Packet)new CPacketPlayer(true));
                NoFall.mc.player.connection.sendPacket((Packet)new CPacketPlayer(false));
                NoFall.mc.player.connection.sendPacket((Packet)new CPacketPlayer(true));
                NoFall.mc.player.connection.sendPacket((Packet)new CPacketPlayer(false));
                NoFall.mc.player.connection.sendPacket((Packet)new CPacketPlayer(true));
            }
        } else if (Objects.equals(lIlIlIlIlIIlII, "Old")) {
            if (NoFall.mc.player.field_70143_R > 5.0f) {
                NoFall.mc.player.field_71075_bZ.isFlying = true;
                mc.getConnection().sendPacket((Packet)new CPacketPlayer(true));
            } else {
                NoFall.mc.player.field_71075_bZ.isFlying = false;
            }
        }
    }
}

