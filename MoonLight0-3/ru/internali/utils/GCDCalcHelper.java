/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 */
package ru.internali.utils;

import net.minecraft.client.Minecraft;
import ru.internali.utils.Helper;
import ru.internali.utils.MinecraftHelper;

public class GCDCalcHelper
implements Helper {
    public static float getGCDValue() {
        return (float)((double)GCDCalcHelper.getGCD() * 0.15);
    }

    public static float getFixedRotation(float lIIlllllIlIllI) {
        return GCDCalcHelper.getDeltaMouse(lIIlllllIlIllI) * GCDCalcHelper.getGCDValue();
    }

    public static float getGCD() {
        float lIIlllllIlIIll = (float)((double)MinecraftHelper.mc.gameSettings.mouseSensitivity * 0.6 + 0.2);
        return lIIlllllIlIIll * lIIlllllIlIIll * lIIlllllIlIIll * 8.0f;
    }

    public static float getDeltaMouse(float lIIlllllIIllll) {
        return Math.round(lIIlllllIIllll / GCDCalcHelper.getGCDValue());
    }

    @Override
    public Minecraft mc() {
        return null;
    }

    public GCDCalcHelper() {
        GCDCalcHelper lIIlllllIllIIl;
    }
}

