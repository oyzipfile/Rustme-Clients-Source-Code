/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.network.Packet
 */
package ru.internali.utils;

import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.network.Packet;
import ru.internali.utils.MinecraftHelper;
import ru.internali.utils.TimerHelper;

public interface Helper {
    public static final /* synthetic */ Gui gui;
    public static final /* synthetic */ Random random;
    public static final /* synthetic */ ScaledResolution sr;
    public static final /* synthetic */ TimerHelper timerHelper;

    public Minecraft mc();

    static {
        gui = new Gui();
        random = new Random();
        timerHelper = new TimerHelper();
        sr = new ScaledResolution(MinecraftHelper.mc);
    }

    default public void sendPacket(Packet<?> llIIlIlIIIllII) {
        MinecraftHelper.mc.player.connection.sendPacket(llIIlIlIIIllII);
    }
}

