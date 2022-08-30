/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$ElementType
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$Text
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package ru.internali.module.HUD;

import java.awt.Color;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;
import ru.internali.utils.RenderUtils;

public class Keystrokes
extends Module {
    public /* synthetic */ int color;

    public Keystrokes() {
        super("Keystrokes", "Keystrokes", Category.HUD);
        Keystrokes lIIlllIlIllIIIl;
        CatClient.instance.settingsManager.rSetting(new Setting("keyX", lIIlllIlIllIIIl, 1.0, 1.0, 897.0, true));
        CatClient.instance.settingsManager.rSetting(new Setting("keyY", lIIlllIlIllIIIl, 1.0, -105.0, 340.0, true));
        CatClient.instance.settingsManager.rSetting(new Setting("mouseButtons", lIIlllIlIllIIIl, false));
    }

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Text lIIlllIlIlIIIIl) {
        ScaledResolution lIIlllIlIlIIIII = new ScaledResolution(mc);
        if (lIIlllIlIlIIIIl.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            Keystrokes lIIlllIlIlIIIlI;
            float lIIlllIlIlIIlIl = (float)CatClient.instance.settingsManager.getSettingByName(lIIlllIlIlIIIlI, "keyX").getValDouble();
            float lIIlllIlIlIIlII = (float)CatClient.instance.settingsManager.getSettingByName(lIIlllIlIlIIIlI, "keyY").getValDouble();
            boolean lIIlllIlIlIIIll = CatClient.instance.settingsManager.getSettingByName(lIIlllIlIlIIIlI, "mouseButtons").getValBoolean();
            GlStateManager.pushMatrix();
            if (!Keystrokes.mc.gameSettings.showDebugInfo) {
                int lIIlllIlIlIIlll = (int)lIIlllIlIlIIlIl;
                int lIIlllIlIlIIllI = (int)lIIlllIlIlIIlII;
                lIIlllIlIlIIIlI.color = Color.WHITE.getRGB();
                RenderUtils.drawRect(lIIlllIlIlIIlll + 20, lIIlllIlIlIIllI + 111, lIIlllIlIlIIlll + 41, lIIlllIlIlIIllI + 130, -1879048192);
                RenderUtils.drawRect(lIIlllIlIlIIlll + 1, lIIlllIlIlIIllI + 130, lIIlllIlIlIIlll + 61, lIIlllIlIlIIllI + 150, -1879048192);
                if (Keystrokes.mc.gameSettings.keyBindForward.isPressed()) {
                    RenderUtils.drawRect(lIIlllIlIlIIlll + 21, lIIlllIlIlIIllI + 112, lIIlllIlIlIIlll + 40, lIIlllIlIlIIllI + 130, lIIlllIlIlIIIlI.color);
                }
                if (Keystrokes.mc.gameSettings.keyBindBack.isPressed()) {
                    RenderUtils.drawRect(lIIlllIlIlIIlll + 21, lIIlllIlIlIIllI + 131, lIIlllIlIlIIlll + 40, lIIlllIlIlIIllI + 149, lIIlllIlIlIIIlI.color);
                }
                if (Keystrokes.mc.gameSettings.keyBindLeft.isPressed()) {
                    RenderUtils.drawRect(lIIlllIlIlIIlll + 2, lIIlllIlIlIIllI + 131, lIIlllIlIlIIlll + 20, lIIlllIlIlIIllI + 149, lIIlllIlIlIIIlI.color);
                }
                if (Keystrokes.mc.gameSettings.keyBindRight.isPressed()) {
                    RenderUtils.drawRect(lIIlllIlIlIIlll + 41, lIIlllIlIlIIllI + 131, lIIlllIlIlIIlll + 60, lIIlllIlIlIIllI + 149, lIIlllIlIlIIIlI.color);
                }
                if (lIIlllIlIlIIIll) {
                    RenderUtils.drawRect(lIIlllIlIlIIlll + 30, lIIlllIlIlIIllI + 170, lIIlllIlIlIIlll + 61, lIIlllIlIlIIllI + 150, -1879048192);
                    RenderUtils.drawRect(lIIlllIlIlIIlll + 1, lIIlllIlIlIIllI + 170, lIIlllIlIlIIlll + 30, lIIlllIlIlIIllI + 150, -1879048192);
                    if (Keystrokes.mc.gameSettings.keyBindAttack.isPressed()) {
                        RenderUtils.drawRect(lIIlllIlIlIIlll + 2, lIIlllIlIlIIllI + 150, lIIlllIlIlIIlll + 30, lIIlllIlIlIIllI + 169, lIIlllIlIlIIIlI.color);
                    }
                    if (Keystrokes.mc.gameSettings.keyBindUseItem.isPressed()) {
                        RenderUtils.drawRect(lIIlllIlIlIIlll + 60, lIIlllIlIlIIllI + 150, lIIlllIlIlIIlll + 31, lIIlllIlIlIIllI + 169, lIIlllIlIlIIIlI.color);
                    }
                    Keystrokes.mc.fontRenderer.drawStringWithShadow("LMB", (float)(lIIlllIlIlIIlll + 7), (float)(lIIlllIlIlIIllI + 156), -1);
                    Keystrokes.mc.fontRenderer.drawStringWithShadow("RMB", (float)(lIIlllIlIlIIlll + 37), (float)(lIIlllIlIlIIllI + 156), -1);
                }
                Keystrokes.mc.fontRenderer.drawStringWithShadow("W", (float)(lIIlllIlIlIIlll + 28), (float)(lIIlllIlIlIIllI + 117), -1);
                Keystrokes.mc.fontRenderer.drawStringWithShadow("A", (float)(lIIlllIlIlIIlll + 8), (float)(lIIlllIlIlIIllI + 136), -1);
                Keystrokes.mc.fontRenderer.drawStringWithShadow("S", (float)(lIIlllIlIlIIlll + 28), (float)(lIIlllIlIlIIllI + 136), -1);
                Keystrokes.mc.fontRenderer.drawStringWithShadow("D", (float)(lIIlllIlIlIIlll + 48), (float)(lIIlllIlIlIIllI + 136), -1);
            }
            GlStateManager.popMatrix();
        }
    }
}

