/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityBoat
 *  net.minecraft.init.Items
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketConfirmTeleport
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.network.play.client.CPacketSteerBoat
 *  net.minecraft.network.play.server.SPacketEntityTeleport
 *  net.minecraft.network.play.server.SPacketEntityVelocity
 *  net.minecraft.network.play.server.SPacketMaps
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.world.storage.MapData
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package ru.internali.module.CHAT;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.init.Items;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketConfirmTeleport;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.network.play.client.CPacketSteerBoat;
import net.minecraft.network.play.server.SPacketEntityTeleport;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketMaps;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.world.storage.MapData;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.module.movement.Command;
import ru.internali.settings.Setting;
import ru.internali.utils.PacketEvent;

public class PlayerFinder
extends Module {
    public static /* synthetic */ int deley;

    public PlayerFinder() {
        super("PlayerFinder", "PlayerFinder", Category.CHAT);
        PlayerFinder lIlIlIIIIllIllI;
        CatClient.instance.settingsManager.rSetting(new Setting("amountPerTick", lIlIlIIIIllIllI, 2.0, 0.0, 5.0, true));
        CatClient.instance.settingsManager.rSetting(new Setting("DeleySpam", lIlIlIIIIllIllI, 50.0, 1.0, 200.0, true));
    }

    @SubscribeEvent
    public void onPlayerTick(PacketEvent lIlIlIIIIlIIIlI) {
        if (PacketEvent.getPacket() instanceof SPacketMaps) {
            ((SPacketMaps)PacketEvent.getPacket()).setMapdataTo(new MapData("haha i get ur coords"));
        }
        if (PacketEvent.getPacket() instanceof SPacketEntityVelocity || PacketEvent.getPacket() instanceof SPacketEntityTeleport) {
            lIlIlIIIIlIIIlI.setCanceled(true);
        }
        if (PacketEvent.getPacket() instanceof CPacketConfirmTeleport || PacketEvent.getPacket() instanceof CPacketPlayerTryUseItem) {
            lIlIlIIIIlIIIlI.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent lIlIlIIIIlIllIl) {
        PlayerFinder lIlIlIIIIlIlIlI;
        float lIlIlIIIIlIllII = (float)CatClient.instance.settingsManager.getSettingByName(lIlIlIIIIlIlIlI, "DeleySpam").getValDouble();
        boolean lIlIlIIIIlIlIll = CatClient.instance.settingsManager.getSettingByName(lIlIlIIIIlIlIlI, "amountPerTick").getValBoolean();
        if (PlayerFinder.mc.player.func_184187_bx() instanceof EntityBoat) {
            if (PlayerFinder.mc.player.field_71071_by.getCurrentItem().getItem().equals((Object)Items.MAP)) {
                PlayerFinder.mc.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock(PlayerFinder.mc.player.getPosition(), EnumFacing.UP, EnumHand.MAIN_HAND, 0.0f, -1337.77f, 0.0f));
            }
            int lIlIlIIIIllIIII = 0;
            while (lIlIlIIIIlIlIll) {
                PlayerFinder.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Position(PlayerFinder.mc.player.field_70165_t, -1337.77, PlayerFinder.mc.player.field_70161_v, false));
                PlayerFinder.mc.player.connection.sendPacket((Packet)new CPacketSteerBoat(false, true));
                ++lIlIlIIIIllIIII;
            }
        }
        for (Entity lIlIlIIIIlIllll : PlayerFinder.mc.world.field_73010_i) {
            if (++deley == 0 && !lIlIlIIIIlIllll.getName().equalsIgnoreCase(PlayerFinder.mc.player.func_70005_c_())) {
                Command.sendClientSideMessage(String.valueOf(new StringBuilder().append("Found A Player ").append(lIlIlIIIIlIllll.getName()).append(" ").append((Object)lIlIlIIIIlIllll.getPosition())));
            }
            if (!((float)deley >= lIlIlIIIIlIllII)) continue;
            deley = -1;
        }
    }
}

