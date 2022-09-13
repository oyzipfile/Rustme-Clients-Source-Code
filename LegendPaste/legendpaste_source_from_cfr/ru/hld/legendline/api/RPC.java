/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  club.minnced.discord.rpc.DiscordEventHandlers
 *  club.minnced.discord.rpc.DiscordRPC
 *  club.minnced.discord.rpc.DiscordRichPresence
 */
package ru.hld.legendline.api;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;

public class RPC {
    private static final /* synthetic */ DiscordRPC discordRPC;
    private static final /* synthetic */ DiscordRichPresence discordRichPresence;

    static {
        discordRichPresence = new DiscordRichPresence();
        discordRPC = DiscordRPC.INSTANCE;
    }

    public static void stopRPC() {
        discordRPC.Discord_Shutdown();
        discordRPC.Discord_ClearPresence();
    }

    public RPC() {
        RPC llllllllllllllllIIIllIIlIIIlIlII;
    }

    public static void startRPC() {
        DiscordEventHandlers llllllllllllllllIIIllIIlIIIlIIIl = new DiscordEventHandlers();
        llllllllllllllllIIIllIIlIIIlIIIl.disconnected = (llllllllllllllllIIIllIIlIIIIlIIl, llllllllllllllllIIIllIIlIIIIlIlI) -> System.out.println(String.valueOf(new StringBuilder().append("Discord RPC disconnected, var1: ").append(llllllllllllllllIIIllIIlIIIIlIIl).append(", var2: ").append(llllllllllllllllIIIllIIlIIIIlIlI)));
        String llllllllllllllllIIIllIIlIIIlIIII = "1000441368818241556";
        discordRPC.Discord_Initialize(llllllllllllllllIIIllIIlIIIlIIII, llllllllllllllllIIIllIIlIIIlIIIl, true, null);
        RPC.discordRichPresence.startTimestamp = System.currentTimeMillis() / 1000L;
        RPC.discordRichPresence.details = "admin version";
        RPC.discordRichPresence.largeImageKey = "_";
        RPC.discordRichPresence.largeImageText = "SUS?";
        RPC.discordRichPresence.joinSecret = "MTI4NzM0OjFpMmhuZToxMjMxMjM= ";
        RPC.discordRichPresence.state = null;
        discordRPC.Discord_UpdatePresence(discordRichPresence);
    }
}

