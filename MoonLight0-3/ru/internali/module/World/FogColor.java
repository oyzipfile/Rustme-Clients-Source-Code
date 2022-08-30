/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.client.event.EntityViewRenderEvent$FogColors
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package ru.internali.module.World;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;

public class FogColor
extends Module {
    public static /* synthetic */ List<String> Modes;
    private /* synthetic */ long spin;

    public FogColor() {
        super("FogColor", "FogColor", Category.WORLD);
        FogColor llIIlllIlllll;
        llIIlllIlllll.spin = 0L;
        Modes.add("Spin");
        Modes.add("Day");
        Modes.add("Night");
        Modes.add("Morning");
        Modes.add("Sunset");
        CatClient.instance.settingsManager.rSetting(new Setting("Mode", llIIlllIlllll, "Day", (ArrayList)Modes));
        CatClient.instance.settingsManager.rSetting(new Setting("TimeSpin Speed", llIIlllIlllll, 2.0, 1.0, 10.0, false));
    }

    @SubscribeEvent
    public void onUpdate(EntityViewRenderEvent.FogColors llIIlllIIllII) {
        FogColor llIIlllIIlIIl;
        String llIIlllIIlIll = CatClient.instance.settingsManager.getSettingByName(llIIlllIIlIIl, "Mode").getValString();
        float llIIlllIIlIlI = (float)CatClient.instance.settingsManager.getSettingByName(llIIlllIIlIIl, "TimeSpin Speed").getValDouble();
        if (llIIlllIIlIll.equalsIgnoreCase("Spin")) {
            FogColor.mc.world.setWorldTime(llIIlllIIlIIl.spin);
            llIIlllIIlIIl.spin = (long)((float)llIIlllIIlIIl.spin + llIIlllIIlIlI * 100.0f);
        } else if (llIIlllIIlIll.equalsIgnoreCase("Day")) {
            FogColor.mc.world.setWorldTime(5000L);
        } else if (llIIlllIIlIll.equalsIgnoreCase("Night")) {
            FogColor.mc.world.setWorldTime(17000L);
        } else if (llIIlllIIlIll.equalsIgnoreCase("Morning")) {
            FogColor.mc.world.setWorldTime(0L);
        } else if (llIIlllIIlIll.equalsIgnoreCase("Sunset")) {
            FogColor.mc.world.setWorldTime(13000L);
        }
    }

    static {
        Modes = new ArrayList<String>();
    }

    @SubscribeEvent
    public void onFogColorRender(EntityViewRenderEvent.FogColors llIIlllIlIllI) {
        double llIIlllIlIlIl = Math.ceil(System.currentTimeMillis() + 300L + 300L) / 15.0;
        Color llIIlllIlIlII = Color.getHSBColor((float)((llIIlllIlIlIl %= 360.0) / 360.0), 0.4f, 1.0f);
        llIIlllIlIllI.setRed((float)llIIlllIlIlII.getRed() / 255.0f);
        llIIlllIlIllI.setGreen((float)llIIlllIlIlII.getGreen() / 255.0f);
        llIIlllIlIllI.setBlue((float)llIIlllIlIlII.getBlue() / 255.0f);
    }
}

