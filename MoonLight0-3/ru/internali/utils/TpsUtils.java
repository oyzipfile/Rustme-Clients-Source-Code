/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketTimeUpdate
 *  net.minecraft.util.math.MathHelper
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package ru.internali.utils;

import java.util.Arrays;
import net.minecraft.network.play.server.SPacketTimeUpdate;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.internali.utils.PacketEvent;

public class TpsUtils {
    private /* synthetic */ long timeLastTimeUpdate;
    private static final /* synthetic */ float[] tickRates;
    private /* synthetic */ int nextIndex;

    private void onTimeUpdate() {
        TpsUtils lIllllIlIllllIl;
        if (lIllllIlIllllIl.timeLastTimeUpdate != -1L) {
            float lIllllIlIlllllI = (float)(System.currentTimeMillis() - lIllllIlIllllIl.timeLastTimeUpdate) / 1000.0f;
            TpsUtils.tickRates[lIllllIlIllllIl.nextIndex % TpsUtils.tickRates.length] = MathHelper.clamp((float)(20.0f / lIllllIlIlllllI), (float)0.0f, (float)20.0f);
            ++lIllllIlIllllIl.nextIndex;
        }
        lIllllIlIllllIl.timeLastTimeUpdate = System.currentTimeMillis();
    }

    public static float getTickRate() {
        float lIllllIllIIlIII = 0.0f;
        float lIllllIllIIIlll = 0.0f;
        for (float lIllllIllIIlIIl : tickRates) {
            if (!(lIllllIllIIlIIl > 0.0f)) continue;
            lIllllIllIIIlll += lIllllIllIIlIIl;
            lIllllIllIIlIII += 1.0f;
        }
        return MathHelper.clamp((float)(lIllllIllIIIlll / lIllllIllIIlIII), (float)0.0f, (float)20.0f);
    }

    @SubscribeEvent
    public void onUpdate(PacketEvent lIllllIlIllIlll) {
        if (PacketEvent.getPacket() instanceof SPacketTimeUpdate) {
            TpsUtils lIllllIlIlllIII;
            lIllllIlIlllIII.onTimeUpdate();
        }
    }

    public TpsUtils() {
        TpsUtils lIllllIllIlIIII;
        lIllllIllIlIIII.nextIndex = 0;
        lIllllIllIlIIII.nextIndex = 0;
        lIllllIllIlIIII.timeLastTimeUpdate = -1L;
        Arrays.fill(tickRates, 0.0f);
    }

    public void voids() {
    }

    static {
        tickRates = new float[20];
    }
}

