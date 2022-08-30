/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.util.glu.Cylinder
 *  org.lwjgl.util.glu.Sphere
 */
package ru.internali.module.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Cylinder;
import org.lwjgl.util.glu.Sphere;
import ru.internali.module.Category;
import ru.internali.module.Module;

public class PenisESP
extends Module {
    public void esp(EntityPlayer lIIlllIIIlIlIIl, double lIIlllIIIlIIIII, double lIIlllIIIlIIlll, double lIIlllIIIlIIllI) {
        GL11.glDisable((int)2896);
        GL11.glDisable((int)3553);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDisable((int)2929);
        GL11.glEnable((int)2848);
        GL11.glDepthMask((boolean)true);
        GL11.glLineWidth((float)1.0f);
        GL11.glTranslated((double)lIIlllIIIlIIIII, (double)lIIlllIIIlIIlll, (double)lIIlllIIIlIIllI);
        GL11.glRotatef((float)(-lIIlllIIIlIlIIl.field_70177_z), (float)0.0f, (float)lIIlllIIIlIlIIl.field_70131_O, (float)0.0f);
        GL11.glTranslated((double)(-lIIlllIIIlIIIII), (double)(-lIIlllIIIlIIlll), (double)(-lIIlllIIIlIIllI));
        GL11.glTranslated((double)lIIlllIIIlIIIII, (double)(lIIlllIIIlIIlll + (double)(lIIlllIIIlIlIIl.field_70131_O / 2.0f) - (double)0.225f), (double)lIIlllIIIlIIllI);
        GL11.glColor4f((float)1.38f, (float)0.55f, (float)2.38f, (float)1.0f);
        GL11.glTranslated((double)0.0, (double)0.0, (double)0.075f);
        Cylinder lIIlllIIIlIIlIl = new Cylinder();
        lIIlllIIIlIIlIl.setDrawStyle(100013);
        lIIlllIIIlIIlIl.draw(0.1f, 0.11f, 0.4f, 25, 20);
        GL11.glColor4f((float)1.38f, (float)0.85f, (float)1.38f, (float)1.0f);
        GL11.glTranslated((double)0.0, (double)0.0, (double)-0.12500000298023223);
        GL11.glTranslated((double)-0.09000000074505805, (double)0.0, (double)0.0);
        Sphere lIIlllIIIlIIlII = new Sphere();
        lIIlllIIIlIIlII.setDrawStyle(100013);
        lIIlllIIIlIIlII.draw(0.14f, 10, 20);
        GL11.glTranslated((double)0.16000000149011612, (double)0.0, (double)0.0);
        Sphere lIIlllIIIlIIIll = new Sphere();
        lIIlllIIIlIIIll.setDrawStyle(100013);
        lIIlllIIIlIIIll.draw(0.14f, 10, 20);
        GL11.glColor4f((float)1.35f, (float)0.0f, (float)0.0f, (float)1.0f);
        GL11.glTranslated((double)-0.07000000074505806, (double)0.0, (double)0.589999952316284);
        Sphere lIIlllIIIlIIIlI = new Sphere();
        lIIlllIIIlIIIlI.setDrawStyle(100013);
        lIIlllIIIlIIIlI.draw(0.13f, 15, 20);
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)2848);
        GL11.glEnable((int)2929);
        GL11.glDisable((int)3042);
        GL11.glEnable((int)2896);
        GL11.glEnable((int)3553);
    }

    @Override
    public void onEnable() {
        PenisESP lIIlllIIlIlIlII;
        super.onEnable();
    }

    public PenisESP() {
        super("PenisESP", "PenisESP", Category.RENDER);
        PenisESP lIIlllIIlIlIlll;
    }

    @Override
    public void onDisable() {
        PenisESP lIIlllIIlIlIIIl;
        super.onDisable();
    }

    @SubscribeEvent
    public void onWorldRender(RenderWorldLastEvent lIIlllIIIllllIl) {
        for (Object lIIlllIIIllllll : PenisESP.mc.world.field_72996_f) {
            PenisESP lIIlllIIIlllllI;
            if (!(lIIlllIIIllllll instanceof EntityPlayer)) continue;
            EntityPlayer lIIlllIIlIIIllI = (EntityPlayer)lIIlllIIIllllll;
            double lIIlllIIlIIIlIl = lIIlllIIlIIIllI.field_70142_S + (lIIlllIIlIIIllI.field_70165_t - lIIlllIIlIIIllI.field_70142_S);
            mc.getRenderManager();
            double lIIlllIIlIIIlII = lIIlllIIlIIIlIl - Minecraft.getMinecraft().getRenderManager().viewerPosX;
            double lIIlllIIlIIIIll = lIIlllIIlIIIllI.field_70137_T + (lIIlllIIlIIIllI.field_70163_u - lIIlllIIlIIIllI.field_70137_T);
            mc.getRenderManager();
            double lIIlllIIlIIIIlI = lIIlllIIlIIIIll - Minecraft.getMinecraft().getRenderManager().viewerPosY;
            double lIIlllIIlIIIIIl = lIIlllIIlIIIllI.field_70136_U + (lIIlllIIlIIIllI.field_70161_v - lIIlllIIlIIIllI.field_70136_U);
            mc.getRenderManager();
            double lIIlllIIlIIIIII = lIIlllIIlIIIIIl - Minecraft.getMinecraft().getRenderManager().viewerPosZ;
            GL11.glPushMatrix();
            RenderHelper.disableStandardItemLighting();
            lIIlllIIIlllllI.esp(lIIlllIIlIIIllI, lIIlllIIlIIIlII, lIIlllIIlIIIIlI, lIIlllIIlIIIIII);
            RenderHelper.enableStandardItemLighting();
            GL11.glPopMatrix();
        }
    }
}

