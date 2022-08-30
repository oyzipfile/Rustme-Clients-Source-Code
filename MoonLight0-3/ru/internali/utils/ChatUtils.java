/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentTranslation
 *  net.minecraft.util.text.TextFormatting
 */
package ru.internali.utils;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import ru.internali.CatClient;
import ru.internali.module.Module;
import ru.internali.utils.Wrapper;

public class ChatUtils {
    public static void simpleMessage(Object llllIIIlIlIIII) {
        ChatUtils.component((ITextComponent)new TextComponentTranslation((String)llllIIIlIlIIII, new Object[0]));
    }

    public ChatUtils() {
        ChatUtils llllIIIlIlIllI;
    }

    public static void component(ITextComponent llllIIIlIlIIlI) {
        if (Wrapper.INSTANCE.player() == null || Wrapper.INSTANCE.mc().ingameGUI.getChatGUI() == null) {
            return;
        }
        Wrapper.INSTANCE.mc().ingameGUI.getChatGUI().printChatMessage(new TextComponentTranslation(String.valueOf(new StringBuilder().append((Object)TextFormatting.WHITE).append("")), new Object[0]).func_150257_a(llllIIIlIlIIlI));
    }

    public static void complete(Object llllIIIlIIIIIl) {
        for (Module llllIIIlIIIIll : CatClient.instance.moduleManager.getModuleList()) {
            ChatUtils.component((ITextComponent)new TextComponentTranslation(String.valueOf(new StringBuilder().append((Object)TextFormatting.GRAY).append("[").append((Object)TextFormatting.LIGHT_PURPLE).append(llllIIIlIIIIll.getName()).append((Object)TextFormatting.GRAY).append("] ").append(llllIIIlIIIIIl)), new Object[0]));
        }
    }

    public static void message(Object llllIIIlIIlIIl) {
        for (Module llllIIIlIIlIll : CatClient.instance.moduleManager.getModuleList()) {
            ChatUtils.component((ITextComponent)new TextComponentTranslation(String.valueOf(new StringBuilder().append((Object)TextFormatting.GRAY).append("[").append((Object)TextFormatting.WHITE).append(llllIIIlIIlIll.getName()).append((Object)TextFormatting.GRAY).append("] ").append(llllIIIlIIlIIl)), new Object[0]));
        }
    }

    public static void error(Object llllIIIIllIIIl) {
        for (Module llllIIIIllIIll : CatClient.instance.moduleManager.getModuleList()) {
            ChatUtils.component((ITextComponent)new TextComponentTranslation(String.valueOf(new StringBuilder().append((Object)TextFormatting.GRAY).append("[").append((Object)TextFormatting.RED).append(llllIIIIllIIll.getName()).append((Object)TextFormatting.GRAY).append("] ").append(llllIIIIllIIIl)), new Object[0]));
        }
    }

    public static void warning(Object llllIIIIlllIlI) {
        for (Module llllIIIIlllIll : CatClient.instance.moduleManager.getModuleList()) {
            ChatUtils.component((ITextComponent)new TextComponentTranslation(String.valueOf(new StringBuilder().append((Object)TextFormatting.GRAY).append("[").append((Object)TextFormatting.GOLD).append(llllIIIIlllIll.getName()).append((Object)TextFormatting.GRAY).append("] ").append(llllIIIIlllIlI)), new Object[0]));
        }
    }
}

