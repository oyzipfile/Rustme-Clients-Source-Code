/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketSteerBoat
 */
package ru.hld.legendline.impl.modules.movment;

import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketSteerBoat;
import ru.hld.legendline.Client;
import ru.hld.legendline.api.event.EventTarget;
import ru.hld.legendline.api.event.events.EventUpdate;
import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.api.setting.settings.FloatSetting;

public class WaterUp
extends Module {
    /* synthetic */ FloatSetting speed;

    @EventTarget
    public void onUpdate(EventUpdate lllllllllllllllllllIllIlIIIIIIlI) {
        WaterUp lllllllllllllllllllIllIlIIIIIIll;
        if (lllllllllllllllllllIllIlIIIIIIll.mc.player.isInWater()) {
            if (lllllllllllllllllllIllIlIIIIIIll.mc.gameSettings.keyBindJump.isKeyDown()) {
                lllllllllllllllllllIllIlIIIIIIll.mc.getConnection().sendPacket((Packet)new CPacketSteerBoat());
                lllllllllllllllllllIllIlIIIIIIll.mc.player.motionY = lllllllllllllllllllIllIlIIIIIIll.speed.getVal() / 100.0f;
            }
            if (lllllllllllllllllllIllIlIIIIIIll.mc.gameSettings.keyBindSneak.isKeyDown()) {
                lllllllllllllllllllIllIlIIIIIIll.mc.getConnection().sendPacket((Packet)new CPacketSteerBoat());
                lllllllllllllllllllIllIlIIIIIIll.mc.player.motionY = -lllllllllllllllllllIllIlIIIIIIll.speed.getVal() / 100.0f;
            }
        }
    }

    public WaterUp() {
        super("WaterUp", "Fast Swim Up And Down", Category.Movement);
        WaterUp lllllllllllllllllllIllIlIIIIIllI;
        lllllllllllllllllllIllIlIIIIIllI.speed = new FloatSetting("Speed", "speed of swim", lllllllllllllllllllIllIlIIIIIllI, 1.0f, 35.0f, 30.0f, 0.1f);
        Client.settingManager.add(lllllllllllllllllllIllIlIIIIIllI.speed);
    }
}

