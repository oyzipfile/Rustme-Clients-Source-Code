/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 */
package ru.internali.module.movement;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public abstract class Command {
    public static /* synthetic */ String prefix;
    public static final /* synthetic */ Minecraft mc;

    public abstract void onClientCommand(String var1, String[] var2) throws Exception;

    public Command() {
        Command lIlIIIlIIlIlIll;
    }

    public static void sendClientSideMessage(String lIlIIIlIIlIIlll) {
        if (Command.mc.player == null || Command.mc.world == null) {
            return;
        }
        Command.mc.player.sendMessage((ITextComponent)new TextComponentString(String.valueOf(new StringBuilder().append((Object)ChatFormatting.DARK_RED).append("[MoonLight] ").append((Object)ChatFormatting.WHITE).append(lIlIIIlIIlIIlll))));
    }

    public static String getClientPrefix() {
        return prefix;
    }

    public static void setClientPrefix(String lIlIIIlIIlIIlIl) {
        prefix = lIlIIIlIIlIIlIl;
    }

    public abstract String getClientSyntax();

    static {
        mc = Minecraft.getMinecraft();
        prefix = ".";
    }

    public abstract String[] getClientAlias();
}

