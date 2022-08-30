/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.init.Items
 *  net.minecraft.item.EnumDyeColor
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraft.util.EnumHand
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package ru.internali.module.combat;

import java.util.ArrayList;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;

public class AutoHeal
extends Module {
    public AutoHeal() {
        super("AutoHeal", "AutoHeal", Category.COMBAT);
        AutoHeal llIlllIIIlIlI;
        ArrayList<String> llIlllIIIlIll = new ArrayList<String>();
        llIlllIIIlIll.add("Bandage");
        llIlllIIIlIll.add("Syringe");
        llIlllIIIlIll.add("Fish");
        llIlllIIIlIll.add("Steak");
        CatClient.instance.settingsManager.rSetting(new Setting("HealItem", llIlllIIIlIlI, "Bandage", llIlllIIIlIll));
        CatClient.instance.settingsManager.rSetting(new Setting("Health", llIlllIIIlIlI, 10.0, 1.0, 20.0, true));
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent llIlllIIIIIII) {
        float llIllIlllllll = (float)CatClient.instance.settingsManager.getSettingByName("Health").getValDouble();
        for (int llIlllIIIIIlI = 0; llIlllIIIIIlI < 9; ++llIlllIIIIIlI) {
            ItemStack llIlllIIIIlII;
            EnumDyeColor llIlllIIIIIll = EnumDyeColor.byDyeDamage((int)AutoHeal.mc.player.field_71071_by.getStackInSlot(llIlllIIIIIlI).getMetadata());
            if (CatClient.instance.settingsManager.getSettingByName("HealItem").getValString().equalsIgnoreCase("Bandage") && EnumDyeColor.GREEN == llIlllIIIIIll && AutoHeal.mc.player.func_110143_aJ() < llIllIlllllll) {
                AutoHeal.mc.player.connection.sendPacket((Packet)new CPacketHeldItemChange(llIlllIIIIIlI));
                AutoHeal.mc.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
                AutoHeal.mc.player.connection.sendPacket((Packet)new CPacketHeldItemChange(AutoHeal.mc.player.field_71071_by.currentItem));
            }
            if (CatClient.instance.settingsManager.getSettingByName("HealItem").getValString().equalsIgnoreCase("Syringe") && EnumDyeColor.GRAY == llIlllIIIIIll && AutoHeal.mc.player.func_110143_aJ() < llIllIlllllll) {
                AutoHeal.mc.player.connection.sendPacket((Packet)new CPacketHeldItemChange(llIlllIIIIIlI));
                AutoHeal.mc.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
                AutoHeal.mc.player.connection.sendPacket((Packet)new CPacketHeldItemChange(AutoHeal.mc.player.field_71071_by.currentItem));
            }
            if (CatClient.instance.settingsManager.getSettingByName("HealItem").getValString().equalsIgnoreCase("Steak") && EnumDyeColor.MAGENTA == llIlllIIIIIll && AutoHeal.mc.player.func_110143_aJ() < llIllIlllllll) {
                AutoHeal.mc.player.connection.sendPacket((Packet)new CPacketHeldItemChange(llIlllIIIIIlI));
                AutoHeal.mc.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
                AutoHeal.mc.player.connection.sendPacket((Packet)new CPacketHeldItemChange(AutoHeal.mc.player.field_71071_by.currentItem));
            }
            if (!CatClient.instance.settingsManager.getSettingByName("HealItem").getValString().equalsIgnoreCase("Fish") || (llIlllIIIIlII = AutoHeal.mc.player.field_71071_by.getStackInSlot(llIlllIIIIIlI)).getItem() != Items.GOLD_NUGGET || !(AutoHeal.mc.player.func_110143_aJ() < llIllIlllllll)) continue;
            AutoHeal.mc.player.connection.sendPacket((Packet)new CPacketHeldItemChange(llIlllIIIIIlI));
            AutoHeal.mc.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
            AutoHeal.mc.player.connection.sendPacket((Packet)new CPacketHeldItemChange(AutoHeal.mc.player.field_71071_by.currentItem));
        }
    }
}

