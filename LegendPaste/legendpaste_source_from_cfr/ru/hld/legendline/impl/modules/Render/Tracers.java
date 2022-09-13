/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.Vec3d
 *  org.lwjgl.opengl.GL11
 */
package ru.hld.legendline.impl.modules.Render;

import java.awt.Color;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;
import ru.hld.legendline.Client;
import ru.hld.legendline.antiNative.RenderUtils;
import ru.hld.legendline.api.event.EventTarget;
import ru.hld.legendline.api.event.events.EventRender3D;
import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.api.shit.FriendManager;

public class Tracers
extends Module {
    @EventTarget
    public void onRender3D(EventRender3D lllllllllllllllIlIIlIlIlllIlIlll) {
        Tracers lllllllllllllllIlIIlIlIlllIllIII;
        lllllllllllllllIlIIlIlIlllIllIII.mc.gameSettings.viewBobbing = false;
        lllllllllllllllIlIIlIlIlllIllIII.mc.entityRenderer.setupCameraTransform(lllllllllllllllIlIIlIlIlllIlIlll.getPartialTicks(), 2);
        GL11.glPushMatrix();
        GL11.glEnable((int)2848);
        GL11.glDisable((int)2929);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2896);
        GL11.glDepthMask((boolean)false);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GL11.glEnable((int)3042);
        GL11.glLineWidth((float)1.0E-6f);
        for (Entity lllllllllllllllIlIIlIlIlllIllIll : lllllllllllllllIlIIlIlIlllIllIII.mc.world.loadedEntityList) {
            if (lllllllllllllllIlIIlIlIlllIllIll == lllllllllllllllIlIIlIlIlllIllIII.mc.player || !(lllllllllllllllIlIIlIlIlllIllIll instanceof EntityPlayer)) continue;
            assert (lllllllllllllllIlIIlIlIlllIllIII.mc.getRenderViewEntity() != null);
            lllllllllllllllIlIIlIlIlllIllIII.mc.player.getDistanceToEntity(lllllllllllllllIlIIlIlIlllIllIll);
            double lllllllllllllllIlIIlIlIllllIIIII = lllllllllllllllIlIIlIlIlllIllIll.lastTickPosX + (lllllllllllllllIlIIlIlIlllIllIll.posX - lllllllllllllllIlIIlIlIlllIllIll.lastTickPosX) - lllllllllllllllIlIIlIlIlllIllIII.mc.getRenderManager().viewerPosX;
            double lllllllllllllllIlIIlIlIlllIlllll = lllllllllllllllIlIIlIlIlllIllIll.lastTickPosY + (lllllllllllllllIlIIlIlIlllIllIll.posY - lllllllllllllllIlIIlIlIlllIllIll.lastTickPosY) - lllllllllllllllIlIIlIlIlllIllIII.mc.getRenderManager().viewerPosY;
            double lllllllllllllllIlIIlIlIlllIllllI = lllllllllllllllIlIIlIlIlllIllIll.lastTickPosZ + (lllllllllllllllIlIIlIlIlllIllIll.posZ - lllllllllllllllIlIIlIlIlllIllIll.lastTickPosZ) - lllllllllllllllIlIIlIlIlllIllIII.mc.getRenderManager().viewerPosZ;
            Vec3d lllllllllllllllIlIIlIlIlllIlllIl = new Vec3d(0.0, 0.0, 1.0);
            lllllllllllllllIlIIlIlIlllIlllIl = lllllllllllllllIlIIlIlIlllIlllIl.rotatePitch(-((float)Math.toRadians(lllllllllllllllIlIIlIlIlllIllIII.mc.player.rotationPitch)));
            Vec3d lllllllllllllllIlIIlIlIlllIlllII = lllllllllllllllIlIIlIlIlllIlllIl.rotateYaw(-((float)Math.toRadians(lllllllllllllllIlIIlIlIlllIllIII.mc.player.rotationYaw)));
            GL11.glBegin((int)2);
            if (FriendManager.isFriend(lllllllllllllllIlIIlIlIlllIllIll.getName())) {
                RenderUtils.glColor(Client.getColor());
            } else {
                RenderUtils.glColor(Color.white.getRGB());
            }
            GL11.glVertex3d((double)lllllllllllllllIlIIlIlIlllIlllII.xCoord, (double)((double)lllllllllllllllIlIIlIlIlllIllIII.mc.player.getEyeHeight() + lllllllllllllllIlIIlIlIlllIlllII.yCoord), (double)lllllllllllllllIlIIlIlIlllIlllII.zCoord);
            GL11.glVertex3d((double)lllllllllllllllIlIIlIlIllllIIIII, (double)(lllllllllllllllIlIIlIlIlllIlllll + 1.1), (double)lllllllllllllllIlIIlIlIlllIllllI);
            GL11.glEnd();
        }
        GL11.glDisable((int)3042);
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)2848);
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2929);
        GL11.glDisable((int)2848);
        GL11.glPopMatrix();
    }

    public Tracers() {
        super("Tracers", "render lines from your crosshair to players", Category.Render);
        Tracers lllllllllllllllIlIIlIlIllllIlIlI;
    }
}

