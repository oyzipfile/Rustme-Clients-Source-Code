/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.monster.EntityShulker
 *  net.minecraft.entity.monster.EntityZombieVillager
 *  net.minecraft.entity.passive.EntityDonkey
 *  net.minecraft.entity.passive.EntityHorse
 *  net.minecraft.entity.passive.EntityLlama
 *  net.minecraft.entity.passive.EntityMule
 *  net.minecraft.entity.passive.EntityVillager
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package ru.internali.module.CHAT;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityMule;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.module.movement.Command;
import ru.internali.settings.Setting;

public class DonkeyAlert
extends Module {
    private /* synthetic */ int antiSpam;

    private ChatFormatting colorchoice() {
        DonkeyAlert llIllllllIIlII;
        String llIllllllIIlIl;
        switch (llIllllllIIlIl = CatClient.instance.settingsManager.getSettingByName(llIllllllIIlII, "Mode").getValString()) {
            case "BLACK": {
                return ChatFormatting.BLACK;
            }
            case "RED": {
                return ChatFormatting.RED;
            }
            case "AQUA": {
                return ChatFormatting.AQUA;
            }
            case "BLUE": {
                return ChatFormatting.BLUE;
            }
            case "GOLD": {
                return ChatFormatting.GOLD;
            }
            case "GRAY": {
                return ChatFormatting.GRAY;
            }
            case "WHITE": {
                return ChatFormatting.WHITE;
            }
            case "GREEN": {
                return ChatFormatting.GREEN;
            }
            case "YELLOW": {
                return ChatFormatting.YELLOW;
            }
            case "DARK_RED": {
                return ChatFormatting.DARK_RED;
            }
            case "DARK_AQUA": {
                return ChatFormatting.DARK_AQUA;
            }
            case "DARK_BLUE": {
                return ChatFormatting.DARK_BLUE;
            }
            case "DARK_GRAY": {
                return ChatFormatting.DARK_GRAY;
            }
            case "DARK_GREEN": {
                return ChatFormatting.DARK_GREEN;
            }
            case "DARK_PURPLE": {
                return ChatFormatting.LIGHT_PURPLE;
            }
            case "LIGHT_PURPLE": {
                return ChatFormatting.DARK_PURPLE;
            }
        }
        return ChatFormatting.WHITE;
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent llIlllllllllII) {
        DonkeyAlert llIlllllllllIl;
        boolean llIllllllllIll = CatClient.instance.settingsManager.getSettingByName(llIlllllllllIl, "DonkeyAlert").getValBoolean();
        boolean llIllllllllIlI = CatClient.instance.settingsManager.getSettingByName(llIlllllllllIl, "MuleAlert").getValBoolean();
        boolean llIllllllllIIl = CatClient.instance.settingsManager.getSettingByName(llIlllllllllIl, "LlamaAlert").getValBoolean();
        boolean llIllllllllIII = CatClient.instance.settingsManager.getSettingByName(llIlllllllllIl, "HorseAlert").getValBoolean();
        boolean llIlllllllIlll = CatClient.instance.settingsManager.getSettingByName(llIlllllllllIl, "ShulkerAlert").getValBoolean();
        boolean llIlllllllIllI = CatClient.instance.settingsManager.getSettingByName(llIlllllllllIl, "VillagerAlert").getValBoolean();
        boolean llIlllllllIlIl = CatClient.instance.settingsManager.getSettingByName(llIlllllllllIl, "ZombieVillagerAlert").getValBoolean();
        ++llIlllllllllIl.antiSpam;
        for (Entity llIllllllllllI : Minecraft.getMinecraft().world.field_72996_f) {
            if (llIllllllllllI instanceof EntityDonkey && llIllllllllIll && llIlllllllllIl.antiSpam >= 100) {
                Command.sendClientSideMessage(String.valueOf(new StringBuilder().append((Object)llIlllllllllIl.colorchoice()).append(" Found Donkey! X:").append((int)llIllllllllllI.posX).append(" Z:").append((int)llIllllllllllI.posZ).append(" Y:").append((int)llIllllllllllI.posY)));
                llIlllllllllIl.antiSpam = -600;
            }
            if (llIllllllllllI instanceof EntityMule && llIllllllllIlI && llIlllllllllIl.antiSpam >= 100) {
                Command.sendClientSideMessage(String.valueOf(new StringBuilder().append((Object)llIlllllllllIl.colorchoice()).append(" Found Mule! X:").append((int)llIllllllllllI.posX).append(" Z:").append((int)llIllllllllllI.posZ).append(" Y:").append((int)llIllllllllllI.posY)));
                llIlllllllllIl.antiSpam = -600;
            }
            if (llIllllllllllI instanceof EntityLlama && llIllllllllIIl && llIlllllllllIl.antiSpam >= 100) {
                Command.sendClientSideMessage(String.valueOf(new StringBuilder().append((Object)llIlllllllllIl.colorchoice()).append(" Found Llama! X:").append((int)llIllllllllllI.posX).append(" Z:").append((int)llIllllllllllI.posZ).append(" Y:").append((int)llIllllllllllI.posY)));
                llIlllllllllIl.antiSpam = -600;
            }
            if (llIllllllllllI instanceof EntityHorse && llIllllllllIII && llIlllllllllIl.antiSpam >= 100) {
                Command.sendClientSideMessage(String.valueOf(new StringBuilder().append((Object)llIlllllllllIl.colorchoice()).append(" Found Horse! X:").append((int)llIllllllllllI.posX).append(" Z:").append((int)llIllllllllllI.posZ).append(" Y:").append((int)llIllllllllllI.posY)));
                llIlllllllllIl.antiSpam = -600;
            }
            if (llIllllllllllI instanceof EntityShulker && llIlllllllIlll && llIlllllllllIl.antiSpam >= 100) {
                Command.sendClientSideMessage(String.valueOf(new StringBuilder().append((Object)llIlllllllllIl.colorchoice()).append(" Found Shulker! X:").append((int)llIllllllllllI.posX).append(" Z:").append((int)llIllllllllllI.posZ).append(" Y:").append((int)llIllllllllllI.posY)));
                llIlllllllllIl.antiSpam = -600;
            }
            if (llIllllllllllI instanceof EntityVillager && llIlllllllIllI && llIlllllllllIl.antiSpam >= 100) {
                Command.sendClientSideMessage(String.valueOf(new StringBuilder().append((Object)llIlllllllllIl.colorchoice()).append(" Found Villager! X:").append((int)llIllllllllllI.posX).append(" Z:").append((int)llIllllllllllI.posZ).append(" Y:").append((int)llIllllllllllI.posY)));
                llIlllllllllIl.antiSpam = -600;
            }
            if (!(llIllllllllllI instanceof EntityZombieVillager) || !llIlllllllIlIl || llIlllllllllIl.antiSpam < 100) continue;
            Command.sendClientSideMessage(String.valueOf(new StringBuilder().append((Object)llIlllllllllIl.colorchoice()).append(" Found ZombieVillager! X:").append((int)llIllllllllllI.posX).append(" Z:").append((int)llIllllllllllI.posZ).append(" Y:").append((int)llIllllllllllI.posY)));
            llIlllllllllIl.antiSpam = -600;
        }
    }

    public DonkeyAlert() {
        super("DonkeyAlert", "DonkeyAlert", Category.CHAT);
        DonkeyAlert lllIIIIIIIllII;
        CatClient.instance.settingsManager.rSetting(new Setting("DonkeyAlert", lllIIIIIIIllII, false));
        CatClient.instance.settingsManager.rSetting(new Setting("MuleAlert", lllIIIIIIIllII, false));
        CatClient.instance.settingsManager.rSetting(new Setting("LlamaAlert", lllIIIIIIIllII, false));
        CatClient.instance.settingsManager.rSetting(new Setting("HorseAlert", lllIIIIIIIllII, false));
        CatClient.instance.settingsManager.rSetting(new Setting("ShulkerAlert", lllIIIIIIIllII, false));
        CatClient.instance.settingsManager.rSetting(new Setting("VillagerAlert", lllIIIIIIIllII, false));
        CatClient.instance.settingsManager.rSetting(new Setting("ZombieVillagerAlert", lllIIIIIIIllII, false));
        ArrayList<String> lllIIIIIIIlIll = new ArrayList<String>();
        lllIIIIIIIlIll.add("BLACK");
        lllIIIIIIIlIll.add("RED");
        lllIIIIIIIlIll.add("AQUA");
        lllIIIIIIIlIll.add("BLUE");
        lllIIIIIIIlIll.add("GOLD");
        lllIIIIIIIlIll.add("GRAY");
        lllIIIIIIIlIll.add("WHITE");
        lllIIIIIIIlIll.add("GREEN");
        lllIIIIIIIlIll.add("YELLOW");
        lllIIIIIIIlIll.add("DARK_RED");
        lllIIIIIIIlIll.add("DARK_AQUA");
        lllIIIIIIIlIll.add("DARK_BLUE");
        lllIIIIIIIlIll.add("DARK_GRAY");
        lllIIIIIIIlIll.add("DARK_GREEN");
        lllIIIIIIIlIll.add("DARK_PURPLE");
        lllIIIIIIIlIll.add("LIGHT_PURPLE");
        CatClient.instance.settingsManager.rSetting(new Setting("Mode", lllIIIIIIIllII, "AQUA", lllIIIIIIIlIll));
    }

    private static enum color {
        BLACK,
        DARK_BLUE,
        DARK_GREEN,
        DARK_AQUA,
        DARK_RED,
        DARK_PURPLE,
        GOLD,
        GRAY,
        DARK_GRAY,
        BLUE,
        GREEN,
        AQUA,
        RED,
        LIGHT_PURPLE,
        YELLOW,
        WHITE;


        private color() {
            color lllIlIIIlllllll;
        }
    }
}

