/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 */
package ru.internali.utils;

import net.minecraft.client.Minecraft;

public interface MinecraftHelper {
    public static final /* synthetic */ Minecraft mc;

    static {
        mc = Minecraft.getMinecraft();
    }
}

