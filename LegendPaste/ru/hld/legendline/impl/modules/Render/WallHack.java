/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 */
package ru.hld.legendline.impl.modules.Render;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import ru.hld.legendline.Client;
import ru.hld.legendline.api.event.EventTarget;
import ru.hld.legendline.api.event.events.EventRender3D;
import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.api.setting.settings.BooleanSetting;
import ru.hld.legendline.api.shit.FriendManager;

public class WallHack
extends Module {
    /* synthetic */ BooleanSetting friends;

    void render(Entity llllllllllllllIlllIIIIllIIIlIlII, float llllllllllllllIlllIIIIllIIIlIllI) {
        try {
            WallHack llllllllllllllIlllIIIIllIIIlIlIl;
            if (llllllllllllllIlllIIIIllIIIlIlII == null || llllllllllllllIlllIIIIllIIIlIlII == llllllllllllllIlllIIIIllIIIlIlIl.mc.player) {
                return;
            }
            if (llllllllllllllIlllIIIIllIIIlIlII == llllllllllllllIlllIIIIllIIIlIlIl.mc.getRenderViewEntity() && llllllllllllllIlllIIIIllIIIlIlIl.mc.gameSettings.thirdPersonView == 0) {
                return;
            }
            llllllllllllllIlllIIIIllIIIlIlIl.mc.entityRenderer.disableLightmap();
            llllllllllllllIlllIIIIllIIIlIlIl.mc.getRenderManager().renderEntityStatic(llllllllllllllIlllIIIIllIIIlIlII, llllllllllllllIlllIIIIllIIIlIllI, false);
            llllllllllllllIlllIIIIllIIIlIlIl.mc.entityRenderer.enableLightmap();
        }
        catch (Exception llllllllllllllIlllIIIIllIIIllIIl) {
            llllllllllllllIlllIIIIllIIIllIIl.printStackTrace();
        }
    }

    @EventTarget
    public void onRender3D(EventRender3D llllllllllllllIlllIIIIllIIIIllII) {
        WallHack llllllllllllllIlllIIIIllIIIIllIl;
        GlStateManager.clear((int)256);
        RenderHelper.enableStandardItemLighting();
        for (Entity llllllllllllllIlllIIIIllIIIIlllI : llllllllllllllIlllIIIIllIIIIllIl.mc.world.loadedEntityList) {
            if (!(llllllllllllllIlllIIIIllIIIIlllI instanceof EntityPlayer) || llllllllllllllIlllIIIIllIIIIlllI == llllllllllllllIlllIIIIllIIIIllIl.mc.getRenderViewEntity()) continue;
            if (FriendManager.isFriend(llllllllllllllIlllIIIIllIIIIlllI.getName()) && llllllllllllllIlllIIIIllIIIIllIl.friends.getVal()) {
                llllllllllllllIlllIIIIllIIIIllIl.render(llllllllllllllIlllIIIIllIIIIlllI, llllllllllllllIlllIIIIllIIIIllIl.mc.getRenderPartialTicks());
                continue;
            }
            llllllllllllllIlllIIIIllIIIIllIl.render(llllllllllllllIlllIIIIllIIIIlllI, llllllllllllllIlllIIIIllIIIIllIl.mc.getRenderPartialTicks());
        }
    }

    public WallHack() {
        super("WallHack", "show player", Category.Render);
        WallHack llllllllllllllIlllIIIIllIIIlllll;
        llllllllllllllIlllIIIIllIIIlllll.friends = new BooleanSetting("Friends", "show friends", (Module)llllllllllllllIlllIIIIllIIIlllll, true);
        Client.settingManager.add(llllllllllllllIlllIIIIllIIIlllll.friends);
    }
}

