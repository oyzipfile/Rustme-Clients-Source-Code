/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraftforge.client.event.RenderGameOverlayEvent
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$ElementType
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$Text
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package ru.internali.module.render;

import java.awt.Color;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;
import ru.internali.utils.Colors;
import ru.internali.utils.RenderUtil;

public class Crosshair
extends Module {
    @SubscribeEvent
    public void onUpdate(RenderGameOverlayEvent lIlIIIIlIIIllll) {
        if (lIlIIIIlIIIllll.getType() == RenderGameOverlayEvent.ElementType.CROSSHAIRS) {
            lIlIIIIlIIIllll.setCanceled(true);
        }
    }

    public boolean isMoving() {
        Crosshair lIlIIIIIlIllIll;
        boolean lIlIIIIIlIllIlI = CatClient.instance.settingsManager.getSettingByName(lIlIIIIIlIllIll, "DYNAMIC").getValBoolean();
        return Boolean.valueOf(lIlIIIIIlIllIlI) != false && !Crosshair.mc.player.field_70123_F && !Crosshair.mc.player.isSneaking() && (Crosshair.mc.player.movementInput.moveForward != 0.0f || Crosshair.mc.player.movementInput.moveStrafe != 0.0f);
    }

    @SubscribeEvent
    public void Crosshair(RenderGameOverlayEvent.Text lIlIIIIIllIlllI) {
        if (lIlIIIIIllIlllI.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            Crosshair lIlIIIIIllIllIl;
            float lIlIIIIIlllllIl = (float)CatClient.instance.settingsManager.getSettingByName(lIlIIIIIllIllIl, "red").getValDouble();
            float lIlIIIIIlllllII = (float)CatClient.instance.settingsManager.getSettingByName(lIlIIIIIllIllIl, "green").getValDouble();
            float lIlIIIIIllllIll = (float)CatClient.instance.settingsManager.getSettingByName(lIlIIIIIllIllIl, "blue").getValDouble();
            float lIlIIIIIllllIlI = (float)CatClient.instance.settingsManager.getSettingByName(lIlIIIIIllIllIl, "GAP").getValDouble();
            float lIlIIIIIllllIIl = (float)CatClient.instance.settingsManager.getSettingByName(lIlIIIIIllIllIl, "WIDTH").getValDouble();
            float lIlIIIIIllllIII = (float)CatClient.instance.settingsManager.getSettingByName(lIlIIIIIllIllIl, "SIZE").getValDouble();
            int lIlIIIIIlllIlll = (int)lIlIIIIIlllllIl;
            int lIlIIIIIlllIllI = (int)lIlIIIIIlllllII;
            int lIlIIIIIlllIlIl = (int)lIlIIIIIllllIll;
            int lIlIIIIIlllIlII = 255;
            double lIlIIIIIlllIIll = lIlIIIIIllllIlI;
            double lIlIIIIIlllIIlI = lIlIIIIIllllIIl;
            double lIlIIIIIlllIIIl = lIlIIIIIllllIII;
            ScaledResolution lIlIIIIIlllIIII = new ScaledResolution(mc);
            RenderUtil.rectangleBordered((double)(lIlIIIIIlllIIII.getScaledWidth() / 2) - lIlIIIIIlllIIlI, (double)(lIlIIIIIlllIIII.getScaledHeight() / 2) - lIlIIIIIlllIIll - lIlIIIIIlllIIIl - (double)(lIlIIIIIllIllIl.isMoving() ? 2 : 0), (double)((float)(lIlIIIIIlllIIII.getScaledWidth() / 2) + 1.0f) + lIlIIIIIlllIIlI, (double)(lIlIIIIIlllIIII.getScaledHeight() / 2) - lIlIIIIIlllIIll - (double)(lIlIIIIIllIllIl.isMoving() ? 2 : 0), 0.5, Colors.getColor(lIlIIIIIlllIlll, lIlIIIIIlllIllI, lIlIIIIIlllIlIl, lIlIIIIIlllIlII), new Color(0, 0, 0, lIlIIIIIlllIlII).getRGB());
            RenderUtil.rectangleBordered((double)(lIlIIIIIlllIIII.getScaledWidth() / 2) - lIlIIIIIlllIIlI, (double)(lIlIIIIIlllIIII.getScaledHeight() / 2) + lIlIIIIIlllIIll + 1.0 + (double)(lIlIIIIIllIllIl.isMoving() ? 2 : 0) - 0.15, (double)((float)(lIlIIIIIlllIIII.getScaledWidth() / 2) + 1.0f) + lIlIIIIIlllIIlI, (double)(lIlIIIIIlllIIII.getScaledHeight() / 2 + 1) + lIlIIIIIlllIIll + lIlIIIIIlllIIIl + (double)(lIlIIIIIllIllIl.isMoving() ? 2 : 0) - 0.15, 0.5, Colors.getColor(lIlIIIIIlllIlll, lIlIIIIIlllIllI, lIlIIIIIlllIlIl, lIlIIIIIlllIlII), new Color(0, 0, 0, lIlIIIIIlllIlII).getRGB());
            RenderUtil.rectangleBordered((double)(lIlIIIIIlllIIII.getScaledWidth() / 2) - lIlIIIIIlllIIll - lIlIIIIIlllIIIl - (double)(lIlIIIIIllIllIl.isMoving() ? 2 : 0) + 0.15, (double)(lIlIIIIIlllIIII.getScaledHeight() / 2) - lIlIIIIIlllIIlI, (double)(lIlIIIIIlllIIII.getScaledWidth() / 2) - lIlIIIIIlllIIll - (double)(lIlIIIIIllIllIl.isMoving() ? 2 : 0) + 0.15, (double)((float)(lIlIIIIIlllIIII.getScaledHeight() / 2) + 1.0f) + lIlIIIIIlllIIlI, 0.5, Colors.getColor(lIlIIIIIlllIlll, lIlIIIIIlllIllI, lIlIIIIIlllIlIl, lIlIIIIIlllIlII), new Color(0, 0, 0, lIlIIIIIlllIlII).getRGB());
            RenderUtil.rectangleBordered((double)(lIlIIIIIlllIIII.getScaledWidth() / 2 + 1) + lIlIIIIIlllIIll + (double)(lIlIIIIIllIllIl.isMoving() ? 2 : 0), (double)(lIlIIIIIlllIIII.getScaledHeight() / 2) - lIlIIIIIlllIIlI, (double)(lIlIIIIIlllIIII.getScaledWidth() / 2) + lIlIIIIIlllIIIl + lIlIIIIIlllIIll + 1.0 + (double)(lIlIIIIIllIllIl.isMoving() ? 2 : 0), (double)((float)(lIlIIIIIlllIIII.getScaledHeight() / 2) + 1.0f) + lIlIIIIIlllIIlI, 0.5, Colors.getColor(lIlIIIIIlllIlll, lIlIIIIIlllIllI, lIlIIIIIlllIlIl, lIlIIIIIlllIlII), new Color(0, 0, 0, lIlIIIIIlllIlII).getRGB());
        }
    }

    public Crosshair() {
        super("Crosshair", "Crosshair", Category.RENDER);
        Crosshair lIlIIIIlIIlIIll;
        CatClient.instance.settingsManager.rSetting(new Setting("red", lIlIIIIlIIlIIll, 255.0, 1.0, 255.0, true));
        CatClient.instance.settingsManager.rSetting(new Setting("green", lIlIIIIlIIlIIll, 255.0, 1.0, 255.0, true));
        CatClient.instance.settingsManager.rSetting(new Setting("blue", lIlIIIIlIIlIIll, 255.0, 1.0, 255.0, true));
        CatClient.instance.settingsManager.rSetting(new Setting("DYNAMIC", lIlIIIIlIIlIIll, false));
        CatClient.instance.settingsManager.rSetting(new Setting("GAP", lIlIIIIlIIlIIll, 0.25, 0.0, 15.0, false));
        CatClient.instance.settingsManager.rSetting(new Setting("WIDTH", lIlIIIIlIIlIIll, 0.25, 0.0, 10.0, false));
        CatClient.instance.settingsManager.rSetting(new Setting("SIZE", lIlIIIIlIIlIIll, 1.0, 0.0, 15.0, false));
    }
}

