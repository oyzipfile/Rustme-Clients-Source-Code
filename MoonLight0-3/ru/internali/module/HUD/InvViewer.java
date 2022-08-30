/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.item.ItemStack
 *  net.minecraftforge.client.event.RenderGameOverlayEvent
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$ElementType
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package ru.internali.module.HUD;

import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;
import ru.internali.utils.RenderUtils;

public class InvViewer
extends Module {
    @SubscribeEvent
    public void onOverlayRender(RenderGameOverlayEvent llIllIIlIIllI) {
        ScaledResolution llIllIIlIlIII = new ScaledResolution(mc);
        if (llIllIIlIIllI.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            InvViewer llIllIIlIlIlI;
            float llIllIIlIllII = (float)CatClient.instance.settingsManager.getSettingByName(llIllIIlIlIlI, "Horizontal").getValDouble();
            float llIllIIlIlIll = (float)CatClient.instance.settingsManager.getSettingByName(llIllIIlIlIlI, "Vertical").getValDouble();
            GlStateManager.pushMatrix();
            RenderHelper.enableGUIStandardItemLighting();
            RenderUtils.drawShadowRect(llIllIIlIllII, llIllIIlIlIll, llIllIIlIllII + 145.0f, llIllIIlIlIll + 48.0f, 2);
            GlStateManager.resetColor();
            for (int llIllIIlIllIl = 0; llIllIIlIllIl < 27; ++llIllIIlIllIl) {
                ItemStack llIllIIllIIII = (ItemStack)InvViewer.mc.player.field_71071_by.mainInventory.get(llIllIIlIllIl + 9);
                float llIllIIlIllll = llIllIIlIllII + (float)(llIllIIlIllIl % 9 * 16);
                float llIllIIlIlllI = llIllIIlIlIll + (float)(llIllIIlIllIl / 9 * 16);
                mc.getRenderItem().renderItemAndEffectIntoGUI(llIllIIllIIII, (int)llIllIIlIllll, (int)llIllIIlIlllI);
                mc.getRenderItem().renderItemOverlayIntoGUI(InvViewer.mc.fontRenderer, llIllIIllIIII, (int)llIllIIlIllll, (int)llIllIIlIlllI, null);
            }
            RenderHelper.disableStandardItemLighting();
            InvViewer.mc.getRenderItem().zLevel = 0.0f;
            GlStateManager.popMatrix();
        }
    }

    public InvViewer() {
        super("InvViewer", "InvViewer", Category.HUD);
        InvViewer llIllIIlllIll;
        CatClient.instance.settingsManager.rSetting(new Setting("Horizontal", llIllIIlllIll, 30.0, 0.0, 810.0, true));
        CatClient.instance.settingsManager.rSetting(new Setting("Vertical", llIllIIlllIll, 60.0, 0.0, 490.0, true));
    }
}

