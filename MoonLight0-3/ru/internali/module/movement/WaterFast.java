/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.util.math.BlockPos
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package ru.internali.module.movement;

import java.util.ArrayList;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;

public class WaterFast
extends Module {
    public WaterFast() {
        super("WaterFast", "WaterFast", Category.MOVEMENT);
        WaterFast lIIlIlIIIIIlllI;
        ArrayList<String> lIIlIlIIIIIllll = new ArrayList<String>();
        lIIlIlIIIIIllll.add("Up");
        lIIlIlIIIIIllll.add("Down");
        CatClient.instance.settingsManager.rSetting(new Setting("WaterMode", lIIlIlIIIIIlllI, "Up", lIIlIlIIIIIllll));
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent lIIlIlIIIIIlIIl) {
        BlockPos lIIlIlIIIIIlIII = new BlockPos(WaterFast.mc.player.field_70165_t, WaterFast.mc.player.field_70163_u + 0.2, WaterFast.mc.player.field_70161_v);
        Block lIIlIlIIIIIIlll = WaterFast.mc.world.func_180495_p(lIIlIlIIIIIlIII).getBlock();
        if (WaterFast.mc.player.func_70090_H() && Block.getIdFromBlock((Block)lIIlIlIIIIIIlll) != 0) {
            WaterFast.mc.player.field_70122_E = false;
            WaterFast.mc.player.func_70664_aZ();
            WaterFast.mc.player.field_70122_E = false;
            if (CatClient.instance.settingsManager.getSettingByName("WaterMode").getValString().equalsIgnoreCase("Up")) {
                WaterFast.mc.player.field_70181_x = 0.4;
            }
            if (CatClient.instance.settingsManager.getSettingByName("WaterMode").getValString().equalsIgnoreCase("Down")) {
                WaterFast.mc.player.field_70181_x = -0.4;
            }
        }
        WaterFast.mc.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)WaterFast.mc.player, CPacketEntityAction.Action.START_FALL_FLYING));
    }
}

