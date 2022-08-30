/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityArmorStand
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package ru.internali.module.render;

import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;

public class ShkafRender
extends Module {
    /* synthetic */ ArrayList<EntityArmorStand> armorStands;

    public ShkafRender() {
        super("ShkafRender", "ShkafRender", Category.RENDER);
        ShkafRender lIIlIlIlllllIl;
        lIIlIlIlllllIl.armorStands = new ArrayList();
        CatClient.instance.settingsManager.rSetting(new Setting("Wallhack", lIIlIlIlllllIl, true));
        CatClient.instance.settingsManager.rSetting(new Setting("Glowing", lIIlIlIlllllIl, false));
    }

    @Override
    public void onDisable() {
        ShkafRender lIIlIlIlllIlll;
        super.onDisable();
        for (Entity lIIlIlIllllIIl : ShkafRender.mc.world.field_72996_f) {
            if (!(lIIlIlIllllIIl instanceof EntityArmorStand) || !lIIlIlIllllIIl.isGlowing()) continue;
            lIIlIlIllllIIl.setGlowing(false);
        }
    }

    void render(Entity lIIlIlIllIlIll, float lIIlIlIllIllIl) {
        try {
            block8: {
                block7: {
                    if (lIIlIlIllIlIll == null) break block7;
                    if (lIIlIlIllIlIll != ShkafRender.mc.player) break block8;
                }
                return;
            }
            if (lIIlIlIllIlIll == mc.getRenderViewEntity()) {
                if (ShkafRender.mc.gameSettings.thirdPersonView == 0) {
                    return;
                }
            }
            ShkafRender.mc.entityRenderer.disableLightmap();
            mc.getRenderManager().renderEntityStatic(lIIlIlIllIlIll, lIIlIlIllIllIl, false);
            ShkafRender.mc.entityRenderer.enableLightmap();
        }
        catch (Exception lIIlIlIlllIIII) {
            lIIlIlIlllIIII.printStackTrace();
        }
    }

    @SubscribeEvent
    public void ShkafRender(RenderWorldLastEvent lIIlIlIlIlllII) {
        ShkafRender lIIlIlIllIIIIl;
        GlStateManager.clear((int)256);
        RenderHelper.enableStandardItemLighting();
        boolean lIIlIlIlIlllll = CatClient.instance.settingsManager.getSettingByName(lIIlIlIllIIIIl, "Wallhack").getValBoolean();
        boolean lIIlIlIlIllllI = CatClient.instance.settingsManager.getSettingByName(lIIlIlIllIIIIl, "Glowing").getValBoolean();
        for (Entity lIIlIlIllIIIlI : Minecraft.getMinecraft().world.field_72996_f) {
            if (!(lIIlIlIllIIIlI instanceof EntityArmorStand) || lIIlIlIllIIIlI == Minecraft.getMinecraft().getRenderViewEntity()) continue;
            if (lIIlIlIlIlllll) {
                lIIlIlIllIIIIl.render(lIIlIlIllIIIlI, lIIlIlIlIlllII.getPartialTicks());
            }
            if (!lIIlIlIlIllllI || lIIlIlIllIIIlI.isGlowing()) continue;
            lIIlIlIllIIIlI.setGlowing(true);
        }
    }
}

