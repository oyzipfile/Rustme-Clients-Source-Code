/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.passive.EntityAnimal
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package ru.internali.module.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;

public class WallHack
extends Module {
    void render(Entity lIlIlIllllIIIII, float lIlIlIlllIlllll) {
        try {
            if (lIlIlIllllIIIII == null || lIlIlIllllIIIII == Minecraft.getMinecraft().player) {
                return;
            }
            if (lIlIlIllllIIIII == Minecraft.getMinecraft().getRenderViewEntity() && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0) {
                return;
            }
            Minecraft.getMinecraft().entityRenderer.disableLightmap();
            Minecraft.getMinecraft().getRenderManager().renderEntityStatic(lIlIlIllllIIIII, lIlIlIlllIlllll, false);
            Minecraft.getMinecraft().entityRenderer.enableLightmap();
        }
        catch (Exception lIlIlIllllIIIlI) {
            lIlIlIllllIIIlI.printStackTrace();
        }
    }

    @SubscribeEvent
    public void onRenderWorld(RenderWorldLastEvent lIlIlIlllIIlllI) {
        WallHack lIlIlIlllIIllll;
        boolean lIlIlIlllIlIIIl = CatClient.instance.settingsManager.getSettingByName(lIlIlIlllIIllll, "Mob").getValBoolean();
        boolean lIlIlIlllIlIIII = CatClient.instance.settingsManager.getSettingByName(lIlIlIlllIIllll, "Animal").getValBoolean();
        GlStateManager.clear((int)256);
        RenderHelper.enableStandardItemLighting();
        if (lIlIlIlllIlIIIl) {
            for (Entity lIlIlIlllIlIlIl : Minecraft.getMinecraft().world.field_72996_f) {
                if (!(lIlIlIlllIlIlIl instanceof EntityMob) || lIlIlIlllIlIlIl == Minecraft.getMinecraft().getRenderViewEntity()) continue;
                lIlIlIlllIIllll.render(lIlIlIlllIlIlIl, lIlIlIlllIIlllI.getPartialTicks());
            }
        }
        if (lIlIlIlllIlIIII) {
            for (Entity lIlIlIlllIlIlII : Minecraft.getMinecraft().world.field_72996_f) {
                if (!(lIlIlIlllIlIlII instanceof EntityAnimal) || lIlIlIlllIlIlII == Minecraft.getMinecraft().getRenderViewEntity()) continue;
                lIlIlIlllIIllll.render(lIlIlIlllIlIlII, lIlIlIlllIIlllI.getPartialTicks());
            }
        }
    }

    public WallHack() {
        super("WallHackMob", "WallHack", Category.RENDER);
        WallHack lIlIlIllllIIllI;
        CatClient.instance.settingsManager.rSetting(new Setting("Mob", lIlIlIllllIIllI, true));
        CatClient.instance.settingsManager.rSetting(new Setting("Animal", lIlIlIllllIIllI, false));
    }
}

