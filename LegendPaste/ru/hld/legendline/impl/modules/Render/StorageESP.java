/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityArmorStand
 */
package ru.hld.legendline.impl.modules.Render;

import java.util.ArrayList;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import ru.hld.legendline.Client;
import ru.hld.legendline.api.event.EventTarget;
import ru.hld.legendline.api.event.events.EventRender3D;
import ru.hld.legendline.api.event.events.EventUpdate;
import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.api.setting.settings.BooleanSetting;

public class StorageESP
extends Module {
    /* synthetic */ ArrayList<EntityArmorStand> armorStands;
    /* synthetic */ BooleanSetting wallHack;
    /* synthetic */ BooleanSetting glow;

    void render(Entity lllllllllllllllllllIlllIIIIIIlII, float lllllllllllllllllllIlllIIIIIIIll) {
        try {
            StorageESP lllllllllllllllllllIlllIIIIIIlIl;
            if (lllllllllllllllllllIlllIIIIIIlII == null || lllllllllllllllllllIlllIIIIIIlII == lllllllllllllllllllIlllIIIIIIlIl.mc.player) {
                return;
            }
            if (lllllllllllllllllllIlllIIIIIIlII == lllllllllllllllllllIlllIIIIIIlIl.mc.getRenderViewEntity() && lllllllllllllllllllIlllIIIIIIlIl.mc.gameSettings.thirdPersonView == 0) {
                return;
            }
            lllllllllllllllllllIlllIIIIIIlIl.mc.entityRenderer.disableLightmap();
            lllllllllllllllllllIlllIIIIIIlIl.mc.getRenderManager().renderEntityStatic(lllllllllllllllllllIlllIIIIIIlII, lllllllllllllllllllIlllIIIIIIIll, false);
            lllllllllllllllllllIlllIIIIIIlIl.mc.entityRenderer.enableLightmap();
        }
        catch (Exception lllllllllllllllllllIlllIIIIIlIIl) {
            lllllllllllllllllllIlllIIIIIlIIl.printStackTrace();
        }
    }

    @EventTarget
    public void onUpdate(EventUpdate lllllllllllllllllllIllIlllllllII) {
        StorageESP lllllllllllllllllllIllIllllllIll;
        for (Entity lllllllllllllllllllIllIllllllllI : lllllllllllllllllllIllIllllllIll.mc.world.loadedEntityList) {
            if (lllllllllllllllllllIllIllllllllI instanceof EntityArmorStand && lllllllllllllllllllIllIllllllIll.glow.getVal() && !lllllllllllllllllllIllIllllllllI.isGlowing()) {
                lllllllllllllllllllIllIllllllllI.setGlowing(true);
            }
            if (!(lllllllllllllllllllIllIllllllllI instanceof EntityArmorStand) || lllllllllllllllllllIllIllllllIll.glow.getVal() || !lllllllllllllllllllIllIllllllllI.isGlowing()) continue;
            lllllllllllllllllllIllIllllllllI.setGlowing(false);
        }
    }

    @EventTarget
    public void onRender3D(EventRender3D lllllllllllllllllllIllIlllllIIll) {
        StorageESP lllllllllllllllllllIllIlllllIIlI;
        GlStateManager.clear((int)256);
        RenderHelper.enableStandardItemLighting();
        if (lllllllllllllllllllIllIlllllIIlI.wallHack.getVal()) {
            for (Entity lllllllllllllllllllIllIlllllIlIl : lllllllllllllllllllIllIlllllIIlI.mc.world.loadedEntityList) {
                if (!(lllllllllllllllllllIllIlllllIlIl instanceof EntityArmorStand) || lllllllllllllllllllIllIlllllIlIl == lllllllllllllllllllIllIlllllIIlI.mc.getRenderViewEntity()) continue;
                lllllllllllllllllllIllIlllllIIlI.render(lllllllllllllllllllIllIlllllIlIl, lllllllllllllllllllIllIlllllIIlI.mc.getRenderPartialTicks());
            }
        }
    }

    public StorageESP() {
        super("StorageESP", "show storages through walls", Category.Render);
        StorageESP lllllllllllllllllllIlllIIIIIlllI;
        lllllllllllllllllllIlllIIIIIlllI.armorStands = new ArrayList();
        lllllllllllllllllllIlllIIIIIlllI.glow = new BooleanSetting("Glow", "make objects glow", (Module)lllllllllllllllllllIlllIIIIIlllI, false);
        Client.settingManager.add(lllllllllllllllllllIlllIIIIIlllI.glow);
        lllllllllllllllllllIlllIIIIIlllI.wallHack = new BooleanSetting("WallHack", "make objects visabel through walls", (Module)lllllllllllllllllllIlllIIIIIlllI, true);
        Client.settingManager.add(lllllllllllllllllllIlllIIIIIlllI.wallHack);
    }
}

