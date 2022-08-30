/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.multiplayer.PlayerControllerMP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.settings.GameSettings
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.network.Packet
 */
package ru.internali.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.network.Packet;

public class Wrapper {
    public static volatile /* synthetic */ Wrapper INSTANCE;

    public Wrapper() {
        Wrapper lIllllIIIllllll;
    }

    public Minecraft getMinecraft() {
        return Minecraft.getMinecraft();
    }

    public InventoryPlayer inventory() {
        Wrapper lIllllIIIlIllII;
        return lIllllIIIlIllII.player().field_71071_by;
    }

    static {
        INSTANCE = new Wrapper();
    }

    public GameSettings mcSettings() {
        return Wrapper.INSTANCE.mc().gameSettings;
    }

    public void sendPacket(Packet lIllllIIIlIllll) {
        Wrapper lIllllIIIllIIII;
        lIllllIIIllIIII.player().connection.sendPacket(lIllllIIIlIllll);
    }

    public EntityPlayerSP getLocalPlayer() {
        return Wrapper.INSTANCE.getMinecraft().player;
    }

    public GameSettings getGameSettings() {
        return Wrapper.INSTANCE.getMinecraft().gameSettings;
    }

    public PlayerControllerMP controller() {
        return Wrapper.INSTANCE.mc().playerController;
    }

    public Minecraft mc() {
        return Minecraft.getMinecraft();
    }

    public FontRenderer fontRenderer() {
        return Wrapper.INSTANCE.mc().fontRenderer;
    }

    public FontRenderer getFontRenderer() {
        return Wrapper.INSTANCE.getMinecraft().fontRenderer;
    }

    public WorldClient getWorld() {
        return Wrapper.INSTANCE.getMinecraft().world;
    }

    public WorldClient world() {
        return Wrapper.INSTANCE.mc().world;
    }

    public EntityPlayerSP player() {
        return Wrapper.INSTANCE.mc().player;
    }
}

