/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraftforge.client.event.RenderGameOverlayEvent
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$ElementType
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package ru.internali.module.player;

import java.awt.Color;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.HUD.HUD;
import ru.internali.module.Module;
import ru.internali.settings.Setting;
import ru.internali.utils.ReflectionUtils;
import ru.internali.utils.RenderUtil;

public class Timer
extends Module {
    @SubscribeEvent
    public void onOverlayRender(RenderGameOverlayEvent llIlllllIlllI) {
        Timer llIlllllIllll;
        int llIllllllIlII = (int)CatClient.instance.settingsManager.getSettingByName(llIlllllIllll, "TimerSpeed").getValDouble();
        float llIllllllIIll = (float)CatClient.instance.settingsManager.getSettingByName(llIlllllIllll, "radius").getValDouble();
        float llIllllllIIlI = (float)CatClient.instance.settingsManager.getSettingByName(llIlllllIllll, "IndGetX").getValDouble();
        float llIllllllIIIl = (float)CatClient.instance.settingsManager.getSettingByName(llIlllllIllll, "IndGetY").getValDouble();
        float llIllllllIIII = (float)CatClient.instance.settingsManager.getSettingByName(llIlllllIllll, "radiusFilled").getValDouble();
        if (llIlllllIlllI.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            ScaledResolution llIlllllllIlI = new ScaledResolution(mc);
            RenderUtil.drawCircle222(llIllllllIIlI, llIllllllIIIl, 20.0f, HUD.getRainbowChams(6000, -17), llIllllllIlII * 36);
            RenderUtil.drawCircle222(llIllllllIIlI, llIllllllIIIl, llIllllllIIll, Color.white.getRGB(), 360);
            double llIlllllllIII = Math.ceil(System.currentTimeMillis() + 300L + 300L) / 15.0;
            RenderUtil.drawFilledCircle((int)llIllllllIIlI, (int)llIllllllIIIl, llIllllllIIII, Color.getHSBColor((float)((llIlllllllIII %= 360.0) / 360.0), 0.4f, 1.0f));
        }
    }

    public Timer() {
        super("Timer", "NoPush", Category.PLAYER);
        Timer lllIIIIlIIIll;
        CatClient.instance.settingsManager.rSetting(new Setting("TimerSpeed", lllIIIIlIIIll, 1.0, 0.0, 10.0, false));
        CatClient.instance.settingsManager.rSetting(new Setting("radius", lllIIIIlIIIll, 18.0, 1.0, 60.0, false));
        CatClient.instance.settingsManager.rSetting(new Setting("IndGetX", lllIIIIlIIIll, 400.0, 0.0, 910.0, true));
        CatClient.instance.settingsManager.rSetting(new Setting("IndGetY", lllIIIIlIIIll, 500.0, 0.0, 500.0, true));
        CatClient.instance.settingsManager.rSetting(new Setting("radiusFilled", lllIIIIlIIIll, 14.8, 1.0, 60.0, false));
    }

    @SubscribeEvent
    public void onClientTickEvent(TickEvent.ClientTickEvent lllIIIIIllIll) {
        Timer lllIIIIIllIIl;
        float lllIIIIIllIlI = (float)CatClient.instance.settingsManager.getSettingByName(lllIIIIIllIIl, "TimerSpeed").getValDouble();
        ReflectionUtils.setTimerSpeedD(lllIIIIIllIlI);
    }

    @Override
    public void onDisable() {
        Timer lllIIIIlIIIII;
        ReflectionUtils.setTimerSpeedD(1.0);
        super.onDisable();
    }
}

