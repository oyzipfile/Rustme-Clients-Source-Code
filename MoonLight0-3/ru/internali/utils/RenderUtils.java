/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.gui.inventory.GuiInventory
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.renderer.RenderGlobal
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.culling.Frustum
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  org.lwjgl.opengl.GL11
 */
package ru.internali.utils;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;
import ru.internali.utils.MinecraftHelper;
import ru.internali.utils.RenderUtil;
import ru.internali.utils.Wrapper;

public class RenderUtils {
    private static final /* synthetic */ Frustum frustrum;
    public static /* synthetic */ boolean click;
    private /* synthetic */ float spin;
    private /* synthetic */ float cumSize;
    private static final /* synthetic */ int GL_BLEND;
    private static final /* synthetic */ int GL_DEPTH_TEST;

    public static ResourceLocation drawPic(double llllIlIIlIlIIII, double llllIlIIlIIllll, double llllIlIIlIIlllI, double llllIlIIlIIllIl, ResourceLocation llllIlIIlIIIlIl) {
        GlStateManager.enableAlpha();
        GlStateManager.disableLighting();
        GlStateManager.disableFog();
        Tessellator llllIlIIlIIlIll = Tessellator.getInstance();
        BufferBuilder llllIlIIlIIlIlI = llllIlIIlIIlIll.getBuffer();
        Minecraft.getMinecraft().getTextureManager().bindTexture(llllIlIIlIIIlIl);
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        llllIlIIlIIlIlI.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        llllIlIIlIIlIlI.pos(llllIlIIlIlIIII, llllIlIIlIIllll + llllIlIIlIIllIl, 0.0).tex(0.0, 1.0).color(255, 255, 255, 255).endVertex();
        llllIlIIlIIlIlI.pos(llllIlIIlIlIIII + llllIlIIlIIlllI, llllIlIIlIIllll + llllIlIIlIIllIl, 0.0).tex(1.0, 1.0).color(255, 255, 255, 255).endVertex();
        llllIlIIlIIlIlI.pos(llllIlIIlIlIIII + llllIlIIlIIlllI, llllIlIIlIIllll, 0.0).tex(1.0, 0.0).color(255, 255, 255, 255).endVertex();
        llllIlIIlIIlIlI.pos(llllIlIIlIlIIII, llllIlIIlIIllll, 0.0).tex(0.0, 0.0).color(255, 255, 255, 255).endVertex();
        llllIlIIlIIlIll.draw();
        GlStateManager.disableAlpha();
        return llllIlIIlIIIlIl;
    }

    public static void drawCircle228(float llllIllIIIIllll, float llllIllIIIIIIlI, float llllIllIIIIIIIl, int llllIllIIIIllII, int llllIlIllllllll) {
        float llllIllIIIIlIlI = (float)(llllIllIIIIllII >> 24 & 0xFF) / 255.0f;
        float llllIllIIIIlIIl = (float)(llllIllIIIIllII >> 16 & 0xFF) / 255.0f;
        float llllIllIIIIlIII = (float)(llllIllIIIIllII >> 8 & 0xFF) / 255.0f;
        float llllIllIIIIIlll = (float)(llllIllIIIIllII & 0xFF) / 255.0f;
        boolean llllIllIIIIIllI = GL11.glIsEnabled((int)3042);
        boolean llllIllIIIIIlIl = GL11.glIsEnabled((int)2848);
        boolean llllIllIIIIIlII = GL11.glIsEnabled((int)3553);
        if (!llllIllIIIIIllI) {
            GL11.glEnable((int)3042);
        }
        if (!llllIllIIIIIlIl) {
            GL11.glEnable((int)2848);
        }
        if (llllIllIIIIIlII) {
            GL11.glDisable((int)3553);
        }
        GL11.glEnable((int)2848);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glColor4f((float)llllIllIIIIlIIl, (float)llllIllIIIIlIII, (float)llllIllIIIIIlll, (float)llllIllIIIIlIlI);
        GL11.glLineWidth((float)2.5f);
        GL11.glBegin((int)3);
        for (int llllIllIIIlIIII = 0; llllIllIIIlIIII <= llllIlIllllllll; ++llllIllIIIlIIII) {
            GL11.glVertex2d((double)((double)llllIllIIIIllll + Math.sin((double)llllIllIIIlIIII * Math.PI / 180.0) * (double)llllIllIIIIIIIl), (double)((double)llllIllIIIIIIlI + Math.cos((double)llllIllIIIlIIII * Math.PI / 180.0) * (double)llllIllIIIIIIIl));
        }
        GL11.glEnd();
        GL11.glDisable((int)2848);
        if (llllIllIIIIIlII) {
            GL11.glEnable((int)3553);
        }
        if (!llllIllIIIIIlIl) {
            GL11.glDisable((int)2848);
        }
        if (!llllIllIIIIIllI) {
            GL11.glDisable((int)3042);
        }
    }

    public static void drawRectStatic(int llllIlllIIlIIIl, int llllIlllIIlIlIl, int llllIlllIIIllll, int llllIlllIIlIIll, Color llllIlllIIlIIlI) {
        Gui.drawRect((int)llllIlllIIlIIIl, (int)llllIlllIIlIlIl, (int)llllIlllIIIllll, (int)llllIlllIIlIIll, (int)llllIlllIIlIIlI.getRGB());
    }

    public static void drawSector2(double llllIlIlIllIIII, double llllIlIlIlIlIlI, int llllIlIlIlIlllI, int llllIlIlIlIllIl, int llllIlIlIlIllII) {
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int)7425);
        GL11.glBegin((int)6);
        RenderUtils.glColor(new Color(0, 0, 0, 100).getRGB());
        GL11.glVertex2d((double)llllIlIlIllIIII, (double)llllIlIlIlIlIlI);
        RenderUtils.glColor(new Color(0, 0, 0, 0).getRGB());
        for (int llllIlIlIllIIIl = llllIlIlIlIlllI; llllIlIlIllIIIl <= llllIlIlIlIllIl; ++llllIlIlIllIIIl) {
            GL11.glVertex2d((double)(llllIlIlIllIIII + Math.sin((double)llllIlIlIllIIIl * Math.PI / 180.0) * (double)llllIlIlIlIllII), (double)(llllIlIlIlIlIlI + Math.cos((double)llllIlIlIllIIIl * Math.PI / 180.0) * (double)llllIlIlIlIllII));
        }
        GL11.glEnd();
        GlStateManager.disableBlend();
        GlStateManager.enableTexture2D();
        GlStateManager.enableAlpha();
        GlStateManager.shadeModel((int)7424);
    }

    public static void drawESP(Entity lllllIIIIIIllIl, float lllllIIIIIIllII, float lllllIIIIIIlIll, float lllllIIIIIlIIII, float lllllIIIIIIlIIl, float lllllIIIIIIlIII) {
        try {
            double lllllIIIIIlllIl = Wrapper.INSTANCE.mc().getRenderManager().viewerPosX;
            double lllllIIIIIlllII = Wrapper.INSTANCE.mc().getRenderManager().viewerPosY;
            double lllllIIIIIllIll = Wrapper.INSTANCE.mc().getRenderManager().viewerPosZ;
            double lllllIIIIIllIlI = lllllIIIIIIllIl.lastTickPosX + (lllllIIIIIIllIl.posX - lllllIIIIIIllIl.lastTickPosX) * (double)lllllIIIIIIlIII - lllllIIIIIlllIl;
            double lllllIIIIIllIIl = lllllIIIIIIllIl.lastTickPosY + (lllllIIIIIIllIl.posY - lllllIIIIIIllIl.lastTickPosY) * (double)lllllIIIIIIlIII + (double)(lllllIIIIIIllIl.height / 2.0f) - lllllIIIIIlllII;
            double lllllIIIIIllIII = lllllIIIIIIllIl.lastTickPosZ + (lllllIIIIIIllIl.posZ - lllllIIIIIIllIl.lastTickPosZ) * (double)lllllIIIIIIlIII - lllllIIIIIllIll;
            float lllllIIIIIlIlll = Wrapper.INSTANCE.mc().getRenderManager().playerViewY;
            float lllllIIIIIlIllI = Wrapper.INSTANCE.mc().getRenderManager().playerViewX;
            boolean lllllIIIIIlIlIl = Wrapper.INSTANCE.mc().getRenderManager().options.thirdPersonView == 2;
            GL11.glPushMatrix();
            GlStateManager.translate((double)lllllIIIIIllIlI, (double)lllllIIIIIllIIl, (double)lllllIIIIIllIII);
            GlStateManager.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
            GlStateManager.rotate((float)(-lllllIIIIIlIlll), (float)0.0f, (float)1.0f, (float)0.0f);
            GlStateManager.rotate((float)((float)(lllllIIIIIlIlIl ? -1 : 1) * lllllIIIIIlIllI), (float)1.0f, (float)0.0f, (float)0.0f);
            GL11.glEnable((int)3042);
            GL11.glDisable((int)3553);
            GL11.glDisable((int)2896);
            GL11.glDisable((int)2929);
            GL11.glDepthMask((boolean)false);
            GL11.glLineWidth((float)1.0f);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glEnable((int)2848);
            GL11.glColor4f((float)lllllIIIIIIllII, (float)lllllIIIIIIlIll, (float)lllllIIIIIlIIII, (float)lllllIIIIIIlIIl);
            GL11.glBegin((int)1);
            GL11.glVertex3d((double)0.0, (double)1.0, (double)0.0);
            GL11.glVertex3d((double)-0.5, (double)0.5, (double)0.0);
            GL11.glVertex3d((double)0.0, (double)1.0, (double)0.0);
            GL11.glVertex3d((double)0.5, (double)0.5, (double)0.0);
            GL11.glVertex3d((double)0.0, (double)0.0, (double)0.0);
            GL11.glVertex3d((double)-0.5, (double)0.5, (double)0.0);
            GL11.glVertex3d((double)0.0, (double)0.0, (double)0.0);
            GL11.glVertex3d((double)0.5, (double)0.5, (double)0.0);
            GL11.glEnd();
            GL11.glDepthMask((boolean)true);
            GL11.glEnable((int)2929);
            GL11.glEnable((int)3553);
            GL11.glEnable((int)2896);
            GL11.glDisable((int)2848);
            GL11.glDisable((int)3042);
            GL11.glPopMatrix();
        }
        catch (Exception lllllIIIIIlIlII) {
            lllllIIIIIlIlII.printStackTrace();
        }
    }

    public static void setColor(Color llllIlIlllIlIll) {
        GL11.glColor4d((double)((float)llllIlIlllIlIll.getRed() / 255.0f), (double)((float)llllIlIlllIlIll.getGreen() / 255.0f), (double)((float)llllIlIlllIlIll.getBlue() / 255.0f), (double)((float)llllIlIlllIlIll.getAlpha() / 255.0f));
    }

    public static void drawRect(double llllIlIIIllIlIl, double llllIlIIIlIlIIl, double llllIlIIIlIlIII, double llllIlIIIllIIlI, int llllIlIIIllIIIl) {
        if (llllIlIIIllIlIl < llllIlIIIlIlIII) {
            double llllIlIIIllIlll = llllIlIIIllIlIl;
            llllIlIIIllIlIl = llllIlIIIlIlIII;
            llllIlIIIlIlIII = llllIlIIIllIlll;
        }
        if (llllIlIIIlIlIIl < llllIlIIIllIIlI) {
            double llllIlIIIllIllI = llllIlIIIlIlIIl;
            llllIlIIIlIlIIl = llllIlIIIllIIlI;
            llllIlIIIllIIlI = llllIlIIIllIllI;
        }
        float llllIlIIIllIIII = (float)(llllIlIIIllIIIl >> 24 & 0xFF) / 255.0f;
        float llllIlIIIlIllll = (float)(llllIlIIIllIIIl >> 16 & 0xFF) / 255.0f;
        float llllIlIIIlIlllI = (float)(llllIlIIIllIIIl >> 8 & 0xFF) / 255.0f;
        float llllIlIIIlIllIl = (float)(llllIlIIIllIIIl & 0xFF) / 255.0f;
        Tessellator llllIlIIIlIllII = Tessellator.getInstance();
        BufferBuilder llllIlIIIlIlIll = llllIlIIIlIllII.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.color((float)llllIlIIIlIllll, (float)llllIlIIIlIlllI, (float)llllIlIIIlIllIl, (float)llllIlIIIllIIII);
        llllIlIIIlIlIll.begin(7, DefaultVertexFormats.POSITION);
        llllIlIIIlIlIll.pos(llllIlIIIllIlIl, llllIlIIIllIIlI, 0.0).endVertex();
        llllIlIIIlIlIll.pos(llllIlIIIlIlIII, llllIlIIIllIIlI, 0.0).endVertex();
        llllIlIIIlIlIll.pos(llllIlIIIlIlIII, llllIlIIIlIlIIl, 0.0).endVertex();
        llllIlIIIlIlIll.pos(llllIlIIIllIlIl, llllIlIIIlIlIIl, 0.0).endVertex();
        llllIlIIIlIllII.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void customScaledObject2D(float llllIlIIIIllIlI, float llllIlIIIIllIIl, float llllIlIIIIlIIlI, float llllIlIIIIlIlll, float llllIlIIIIlIIII, float llllIlIIIIlIlIl) {
        GL11.glTranslated((double)(llllIlIIIIlIIlI / 2.0f), (double)(llllIlIIIIlIlll / 2.0f), (double)1.0);
        GL11.glTranslated((double)(-llllIlIIIIllIlI * llllIlIIIIlIIII + llllIlIIIIllIlI + llllIlIIIIlIIlI / 2.0f * -llllIlIIIIlIIII), (double)(-llllIlIIIIllIIl * llllIlIIIIlIIII + llllIlIIIIllIIl + llllIlIIIIlIlll / 2.0f * -llllIlIIIIlIIII), (double)1.0);
        GL11.glScaled((double)llllIlIIIIlIIII, (double)llllIlIIIIlIIII, (double)0.0);
    }

    public static void drawDownShadow(float llllIIlllllllll, float llllIIllllllIlI, float llllIIllllllIIl, float llllIIllllllIII) {
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int)7425);
        GL11.glBegin((int)7);
        RenderUtils.glColor(new Color(0, 0, 0, 100).getRGB());
        GL11.glVertex2d((double)llllIIllllllIIl, (double)llllIIllllllIII);
        RenderUtils.glColor(new Color(0, 0, 0, 0).getRGB());
        GL11.glVertex2d((double)llllIIllllllIIl, (double)llllIIllllllIlI);
        GL11.glVertex2d((double)llllIIlllllllll, (double)llllIIllllllIlI);
        RenderUtils.glColor(new Color(0, 0, 0, 100).getRGB());
        GL11.glVertex2d((double)llllIIlllllllll, (double)llllIIllllllIII);
        GL11.glEnd();
        GlStateManager.disableBlend();
        GlStateManager.enableTexture2D();
        GlStateManager.enableAlpha();
        GlStateManager.shadeModel((int)7424);
    }

    public static void drawShadowRect(double llllIlIllIIIIIl, double llllIlIlIlllIll, double llllIlIlIllllll, double llllIlIlIlllllI, int llllIlIlIllllIl) {
        RenderUtils.drawGradientRect(llllIlIllIIIIIl, llllIlIlIlllIll - (double)llllIlIlIllllIl, llllIlIlIllllll, llllIlIlIlllIll, false, true, new Color(0, 0, 0, 100).getRGB(), new Color(0, 0, 0, 0).getRGB());
        RenderUtils.drawGradientRect(llllIlIllIIIIIl, llllIlIlIlllllI, llllIlIlIllllll, llllIlIlIlllllI + (double)llllIlIlIllllIl, false, false, new Color(0, 0, 0, 100).getRGB(), new Color(0, 0, 0, 0).getRGB());
        RenderUtils.drawSector2(llllIlIlIllllll, llllIlIlIlllllI, 0, 90, llllIlIlIllllIl);
        RenderUtils.drawSector2(llllIlIlIllllll, llllIlIlIlllIll, 90, 180, llllIlIlIllllIl);
        RenderUtils.drawSector2(llllIlIllIIIIIl, llllIlIlIlllIll, 180, 270, llllIlIlIllllIl);
        RenderUtils.drawSector2(llllIlIllIIIIIl, llllIlIlIlllllI, 270, 360, llllIlIlIllllIl);
        RenderUtils.drawGradientRect(llllIlIllIIIIIl - (double)llllIlIlIllllIl, llllIlIlIlllIll, llllIlIllIIIIIl, llllIlIlIlllllI, true, true, new Color(0, 0, 0, 100).getRGB(), new Color(0, 0, 0, 0).getRGB());
        RenderUtils.drawGradientRect(llllIlIlIllllll, llllIlIlIlllIll, llllIlIlIllllll + (double)llllIlIlIllllIl, llllIlIlIlllllI, true, false, new Color(0, 0, 0, 100).getRGB(), new Color(0, 0, 0, 0).getRGB());
    }

    public static void enableGL2D() {
        GL11.glDisable((int)2929);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDepthMask((boolean)true);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glHint((int)3155, (int)4354);
    }

    public static void drawGradientRect(double llllIlIlIIllllI, double llllIlIlIIlIllI, double llllIlIlIIlIlIl, double llllIlIlIIllIll, boolean llllIlIlIIlIIll, int llllIlIlIIllIIl, int llllIlIlIIllIII) {
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        GlStateManager.shadeModel((int)7425);
        RenderUtils.glColor(llllIlIlIIllIIl);
        GL11.glBegin((int)7);
        if (llllIlIlIIlIIll) {
            GL11.glVertex2d((double)llllIlIlIIllllI, (double)llllIlIlIIlIllI);
            GL11.glVertex2d((double)llllIlIlIIllllI, (double)llllIlIlIIllIll);
            RenderUtils.glColor(llllIlIlIIllIII);
            GL11.glVertex2d((double)llllIlIlIIlIlIl, (double)llllIlIlIIllIll);
            GL11.glVertex2d((double)llllIlIlIIlIlIl, (double)llllIlIlIIlIllI);
        } else {
            GL11.glVertex2d((double)llllIlIlIIllllI, (double)llllIlIlIIlIllI);
            RenderUtils.glColor(llllIlIlIIllIII);
            GL11.glVertex2d((double)llllIlIlIIllllI, (double)llllIlIlIIllIll);
            GL11.glVertex2d((double)llllIlIlIIlIlIl, (double)llllIlIlIIllIll);
            RenderUtils.glColor(llllIlIlIIllIIl);
            GL11.glVertex2d((double)llllIlIlIIlIlIl, (double)llllIlIlIIlIllI);
        }
        GL11.glEnd();
        GlStateManager.disableBlend();
        GlStateManager.enableTexture2D();
        GlStateManager.enableAlpha();
        GlStateManager.shadeModel((int)7424);
    }

    public static void renderItem(ItemStack llllIllIIlIIIII, int llllIllIIlIIIlI, int llllIllIIlIIIIl) {
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        GlStateManager.enableDepth();
        RenderHelper.enableGUIStandardItemLighting();
        MinecraftHelper.mc.getRenderItem().zLevel = -100.0f;
        MinecraftHelper.mc.getRenderItem().renderItemAndEffectIntoGUI(llllIllIIlIIIII, llllIllIIlIIIlI, llllIllIIlIIIIl);
        MinecraftHelper.mc.getRenderItem().renderItemOverlays(MinecraftHelper.mc.fontRenderer, llllIllIIlIIIII, llllIllIIlIIIlI, llllIllIIlIIIIl);
        MinecraftHelper.mc.getRenderItem().zLevel = 0.0f;
        RenderHelper.disableStandardItemLighting();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.disableDepth();
    }

    public static void drawRectSized(float llllIlllllIIIIl, float llllIlllllIIIII, float llllIllllIllIlI, float llllIllllIllllI, int llllIllllIllIII) {
        RenderUtils.drawRect(llllIlllllIIIIl, llllIlllllIIIII, llllIlllllIIIIl + llllIllllIllIlI, llllIlllllIIIII + llllIllllIllllI, llllIllllIllIII);
    }

    public static double lerp(double llllIlllllllIII, double llllIllllllIlll, double llllIllllllIllI) {
        return (1.0 - llllIllllllIllI) * llllIlllllllIII + llllIllllllIllI * llllIllllllIlll;
    }

    static {
        GL_BLEND = 0;
        GL_DEPTH_TEST = 0;
        frustrum = new Frustum();
    }

    public static void draw2DRect(int llllIlllIllIlll, int llllIlllIllllIl, int llllIlllIllIlIl, int llllIlllIlllIll, int llllIlllIlllIlI) {
        Tessellator llllIlllIlllIIl = Tessellator.getInstance();
        BufferBuilder llllIlllIlllIII = llllIlllIlllIIl.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        llllIlllIlllIII.begin(7, DefaultVertexFormats.POSITION);
        llllIlllIlllIII.pos((double)llllIlllIllIlll, (double)(llllIlllIllllIl + llllIlllIlllIll), (double)llllIlllIlllIlI).endVertex();
        llllIlllIlllIII.pos((double)(llllIlllIllIlll + llllIlllIllIlIl), (double)(llllIlllIllllIl + llllIlllIlllIll), (double)llllIlllIlllIlI).endVertex();
        llllIlllIlllIII.pos((double)(llllIlllIllIlll + llllIlllIllIlIl), (double)llllIlllIllllIl, (double)llllIlllIlllIlI).endVertex();
        llllIlllIlllIII.pos((double)llllIlllIllIlll, (double)llllIlllIllllIl, (double)llllIlllIlllIlI).endVertex();
        llllIlllIlllIIl.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void setupColor(Color llllIllIllIIllI, int llllIllIllIIlIl) {
        GL11.glColor4d((double)((float)llllIllIllIIllI.getRed() / 255.0f), (double)((float)llllIllIllIIllI.getGreen() / 255.0f), (double)((float)llllIllIllIIllI.getBlue() / 255.0f), (double)((float)llllIllIllIIlIl / 255.0f));
    }

    public static void drawImage(ResourceLocation llllIllllIIlIll, int llllIllllIIlIlI, int llllIllllIIlIIl, int llllIllllIIlllI, int llllIllllIIllIl, int llllIllllIIIllI) {
        GlStateManager.disableDepth();
        GlStateManager.enableBlend();
        OpenGlHelper.glBlendFunc((int)770, (int)771, (int)1, (int)0);
        RenderUtils.glColor(llllIllllIIIllI);
        MinecraftHelper.mc.getTextureManager().bindTexture(llllIllllIIlIll);
        Gui.drawModalRectWithCustomSizedTexture((int)llllIllllIIlIlI, (int)llllIllllIIlIIl, (float)0.0f, (float)0.0f, (int)llllIllllIIlllI, (int)llllIllllIIllIl, (float)llllIllllIIlllI, (float)llllIllllIIllIl);
        GlStateManager.disableBlend();
        GlStateManager.enableDepth();
    }

    public static void disableSmoothLine() {
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2929);
        GL11.glDisable((int)3042);
        GL11.glEnable((int)3008);
        GL11.glDepthMask((boolean)true);
        GL11.glCullFace((int)1029);
        GL11.glDisable((int)2848);
        GL11.glHint((int)3154, (int)4352);
        GL11.glHint((int)3155, (int)4352);
    }

    public static void drawGradient(double llllIllIlIlIlII, double llllIllIlIlIIll, double llllIllIlIlIIlI, double llllIllIlIlIIIl, int llllIllIlIIIIlI, int llllIllIlIIIIIl) {
        float llllIllIlIIlllI = (float)(llllIllIlIIIIlI >> 24 & 0xFF) / 255.0f;
        float llllIllIlIIllIl = (float)(llllIllIlIIIIlI >> 16 & 0xFF) / 255.0f;
        float llllIllIlIIllII = (float)(llllIllIlIIIIlI >> 8 & 0xFF) / 255.0f;
        float llllIllIlIIlIll = (float)(llllIllIlIIIIlI & 0xFF) / 255.0f;
        float llllIllIlIIlIlI = (float)(llllIllIlIIIIIl >> 24 & 0xFF) / 255.0f;
        float llllIllIlIIlIIl = (float)(llllIllIlIIIIIl >> 16 & 0xFF) / 255.0f;
        float llllIllIlIIlIII = (float)(llllIllIlIIIIIl >> 8 & 0xFF) / 255.0f;
        float llllIllIlIIIlll = (float)(llllIllIlIIIIIl & 0xFF) / 255.0f;
        RenderUtil.glRenderStart();
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GL11.glShadeModel((int)7425);
        GL11.glPushMatrix();
        GL11.glBegin((int)7);
        GL11.glColor4f((float)llllIllIlIIllIl, (float)llllIllIlIIllII, (float)llllIllIlIIlIll, (float)llllIllIlIIlllI);
        GL11.glVertex2d((double)llllIllIlIlIIlI, (double)llllIllIlIlIIll);
        GL11.glVertex2d((double)llllIllIlIlIlII, (double)llllIllIlIlIIll);
        GL11.glColor4f((float)llllIllIlIIlIIl, (float)llllIllIlIIlIII, (float)llllIllIlIIIlll, (float)llllIllIlIIlIlI);
        GL11.glVertex2d((double)llllIllIlIlIlII, (double)llllIllIlIlIIIl);
        GL11.glVertex2d((double)llllIllIlIlIIlI, (double)llllIllIlIlIIIl);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glDisable((int)2848);
        GL11.glShadeModel((int)7424);
        GL11.glColor4d((double)1.0, (double)1.0, (double)1.0, (double)1.0);
        RenderUtil.glRenderStop();
    }

    public static void drawGradientRect(double llllIlIlIIIlIII, double llllIlIIlllllll, double llllIlIIllllllI, double llllIlIlIIIIlIl, boolean llllIlIIlllllII, boolean llllIlIlIIIIIll, int llllIlIlIIIIIlI, int llllIlIIllllIIl) {
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int)7425);
        GL11.glBegin((int)7);
        RenderUtils.glColor(llllIlIlIIIIIlI);
        if (llllIlIIlllllII) {
            if (llllIlIlIIIIIll) {
                GL11.glVertex2d((double)llllIlIIllllllI, (double)llllIlIlIIIIlIl);
                GL11.glVertex2d((double)llllIlIIllllllI, (double)llllIlIIlllllll);
                RenderUtils.glColor(llllIlIIllllIIl);
                GL11.glVertex2d((double)llllIlIlIIIlIII, (double)llllIlIIlllllll);
                GL11.glVertex2d((double)llllIlIlIIIlIII, (double)llllIlIlIIIIlIl);
            } else {
                GL11.glVertex2d((double)llllIlIlIIIlIII, (double)llllIlIIlllllll);
                GL11.glVertex2d((double)llllIlIlIIIlIII, (double)llllIlIlIIIIlIl);
                RenderUtils.glColor(llllIlIIllllIIl);
                GL11.glVertex2d((double)llllIlIIllllllI, (double)llllIlIlIIIIlIl);
                GL11.glVertex2d((double)llllIlIIllllllI, (double)llllIlIIlllllll);
            }
        } else if (llllIlIlIIIIIll) {
            GL11.glVertex2d((double)llllIlIIllllllI, (double)llllIlIlIIIIlIl);
            RenderUtils.glColor(llllIlIIllllIIl);
            GL11.glVertex2d((double)llllIlIIllllllI, (double)llllIlIIlllllll);
            GL11.glVertex2d((double)llllIlIlIIIlIII, (double)llllIlIIlllllll);
            RenderUtils.glColor(llllIlIlIIIIIlI);
            GL11.glVertex2d((double)llllIlIlIIIlIII, (double)llllIlIlIIIIlIl);
        } else {
            GL11.glVertex2d((double)llllIlIlIIIlIII, (double)llllIlIIlllllll);
            RenderUtils.glColor(llllIlIIllllIIl);
            GL11.glVertex2d((double)llllIlIlIIIlIII, (double)llllIlIlIIIIlIl);
            GL11.glVertex2d((double)llllIlIIllllllI, (double)llllIlIlIIIIlIl);
            RenderUtils.glColor(llllIlIlIIIIIlI);
            GL11.glVertex2d((double)llllIlIIllllllI, (double)llllIlIIlllllll);
        }
        GL11.glEnd();
        GlStateManager.disableBlend();
        GlStateManager.enableTexture2D();
        GlStateManager.enableAlpha();
        GlStateManager.shadeModel((int)7424);
    }

    public static void blockEspFrame(BlockPos lllllIIIllllIIl, float lllllIIIllllIII, float lllllIIIlllIlll, float lllllIIIllIllll) {
        double lllllIIIlllIlIl = (double)lllllIIIllllIIl.func_177958_n() - MinecraftHelper.mc.getRenderManager().viewerPosX;
        double lllllIIIlllIlII = (double)lllllIIIllllIIl.func_177956_o() - MinecraftHelper.mc.getRenderManager().viewerPosY;
        double lllllIIIlllIIll = (double)lllllIIIllllIIl.func_177952_p() - MinecraftHelper.mc.getRenderManager().viewerPosZ;
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)3042);
        GL11.glLineWidth((float)2.0f);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        GlStateManager.color((float)lllllIIIllllIII, (float)lllllIIIlllIlll, (float)lllllIIIllIllll, (float)1.0f);
        RenderUtil.drawSelectionBoundingBox(new AxisAlignedBB(lllllIIIlllIlIl, lllllIIIlllIlII, lllllIIIlllIIll, lllllIIIlllIlIl + 1.0, lllllIIIlllIlII + 1.0, lllllIIIlllIIll + 1.0));
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2929);
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)3042);
    }

    public static void blockEspBox(BlockPos llllIlllIlIIIlI, double llllIlllIlIIIIl, double llllIlllIlIIlll, double llllIlllIIlllll) {
        double llllIlllIlIIlIl = (double)llllIlllIlIIIlI.func_177958_n() - Minecraft.getMinecraft().getRenderManager().viewerPosX;
        double llllIlllIlIIlII = (double)llllIlllIlIIIlI.func_177956_o() - Minecraft.getMinecraft().getRenderManager().viewerPosY;
        double llllIlllIlIIIll = (double)llllIlllIlIIIlI.func_177952_p() - Minecraft.getMinecraft().getRenderManager().viewerPosZ;
        GL11.glPushMatrix();
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)0);
        GL11.glLineWidth((float)2.0f);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)0);
        GL11.glDisable((int)2896);
        GL11.glDepthMask((boolean)false);
        GL11.glColor4d((double)llllIlllIlIIIIl, (double)llllIlllIlIIlll, (double)llllIlllIIlllll, (double)0.15f);
        RenderUtil.drawColorBox(new AxisAlignedBB(llllIlllIlIIlIl, llllIlllIlIIlII, llllIlllIlIIIll, llllIlllIlIIlIl + 1.0, llllIlllIlIIlII + 1.0, llllIlllIlIIIll + 1.0), 0.0f, 0.0f, 0.0f, 0.0f);
        GL11.glDepthMask((boolean)false);
        GL11.glColor4d((double)llllIlllIlIIIIl, (double)llllIlllIlIIlll, (double)llllIlllIIlllll, (double)0.15f);
        RenderUtil.drawColorBox(new AxisAlignedBB(llllIlllIlIIlIl, llllIlllIlIIlII, llllIlllIlIIIll, llllIlllIlIIlIl + 1.0, llllIlllIlIIlII + 1.0, llllIlllIlIIIll + 1.0), 0.0f, 0.0f, 0.0f, 0.0f);
        GL11.glEnable((int)3553);
        GL11.glEnable((int)0);
        GL11.glEnable((int)2896);
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)0);
        GL11.glPopMatrix();
    }

    public static void trace(Minecraft llllIllIlllIlIl, Entity llllIllIlllIIII, float llllIllIllIllll, int llllIllIlllIIlI) {
        if (llllIllIlllIlIl.getRenderManager().renderViewEntity != null) {
            GL11.glDisable((int)2929);
            GL11.glDisable((int)2896);
            GL11.glLineWidth((float)2.0f);
            GL11.glPushMatrix();
            GL11.glDepthMask((boolean)false);
            GL11.glColor4d((double)0.0, (double)(llllIllIlllIIlI == 1 ? 1.0 : 0.0), (double)0.0, (double)1.0);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glDisable((int)3553);
            GL11.glBegin((int)1);
            RenderManager llllIllIllllIlI = llllIllIlllIlIl.getRenderManager();
            Vec3d llllIllIllllIIl = new Vec3d(0.0, 0.0, 1.0).rotatePitch(-((float)Math.toRadians(llllIllIlllIlIl.player.field_70125_A))).rotateYaw(-((float)Math.toRadians(llllIllIlllIlIl.player.field_70177_z)));
            GL11.glVertex3d((double)llllIllIllllIIl.x, (double)((double)llllIllIlllIlIl.player.func_70047_e() + llllIllIllllIIl.y), (double)llllIllIllllIIl.z);
            double llllIllIllllIII = llllIllIlllIIII.lastTickPosX + (llllIllIlllIIII.posX - llllIllIlllIIII.lastTickPosX) * (double)llllIllIllIllll;
            double llllIllIlllIlll = llllIllIlllIIII.lastTickPosY + (llllIllIlllIIII.posY - llllIllIlllIIII.lastTickPosY) * (double)llllIllIllIllll;
            double llllIllIlllIllI = llllIllIlllIIII.lastTickPosZ + (llllIllIlllIIII.posZ - llllIllIlllIIII.lastTickPosZ) * (double)llllIllIllIllll;
            GL11.glVertex3d((double)(llllIllIllllIII - llllIllIllllIlI.viewerPosX), (double)(llllIllIlllIlll - llllIllIllllIlI.viewerPosY + 0.25), (double)(llllIllIlllIllI - llllIllIllllIlI.viewerPosZ));
            GL11.glEnd();
            GL11.glDepthMask((boolean)true);
            GL11.glEnable((int)2929);
            GL11.glEnable((int)3553);
            GL11.glPopMatrix();
        }
    }

    public static void glColor(int llllIIllllIlIlI) {
        float llllIIllllIlllI = (float)(llllIIllllIlIlI >> 24 & 0xFF) / 255.0f;
        float llllIIllllIllIl = (float)(llllIIllllIlIlI >> 16 & 0xFF) / 255.0f;
        float llllIIllllIllII = (float)(llllIIllllIlIlI >> 8 & 0xFF) / 255.0f;
        float llllIIllllIlIll = (float)(llllIIllllIlIlI & 0xFF) / 255.0f;
        GlStateManager.color((float)llllIIllllIllIl, (float)llllIIllllIllII, (float)llllIIllllIlIll, (float)llllIIllllIlllI);
    }

    public static void drawBorderedRect(double llllIlIIllIllIl, double llllIlIIllIIIIl, double llllIlIIllIlIll, double llllIlIIlIlllll, float llllIlIIlIllllI, int llllIlIIllIlIII, int llllIlIIlIlllII) {
        RenderUtils.drawRect((float)llllIlIIllIllIl, (float)llllIlIIllIIIIl, (float)llllIlIIllIlIll, (float)llllIlIIlIlllll, llllIlIIlIlllII);
        float llllIlIIllIIllI = (float)(llllIlIIllIlIII >> 24 & 0xFF) / 255.0f;
        float llllIlIIllIIlIl = (float)(llllIlIIllIlIII >> 16 & 0xFF) / 255.0f;
        float llllIlIIllIIlII = (float)(llllIlIIllIlIII >> 8 & 0xFF) / 255.0f;
        float llllIlIIllIIIll = (float)(llllIlIIllIlIII & 0xFF) / 255.0f;
        GL11.glPushMatrix();
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GL11.glColor4f((float)llllIlIIllIIlIl, (float)llllIlIIllIIlII, (float)llllIlIIllIIIll, (float)llllIlIIllIIllI);
        GL11.glLineWidth((float)llllIlIIlIllllI);
        GL11.glBegin((int)1);
        GL11.glVertex2d((double)llllIlIIllIllIl, (double)llllIlIIllIIIIl);
        GL11.glVertex2d((double)llllIlIIllIllIl, (double)llllIlIIlIlllll);
        GL11.glVertex2d((double)llllIlIIllIlIll, (double)llllIlIIlIlllll);
        GL11.glVertex2d((double)llllIlIIllIlIll, (double)llllIlIIllIIIIl);
        GL11.glVertex2d((double)llllIlIIllIllIl, (double)llllIlIIllIIIIl);
        GL11.glVertex2d((double)llllIlIIllIlIll, (double)llllIlIIllIIIIl);
        GL11.glVertex2d((double)llllIlIIllIllIl, (double)llllIlIIlIlllll);
        GL11.glVertex2d((double)llllIlIIllIlIll, (double)llllIlIIlIlllll);
        GL11.glEnd();
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glDisable((int)2848);
        GL11.glPopMatrix();
    }

    public static void drawEntityOnScreen(float lllllIIlIIIIlIl, float lllllIIlIIIlIIl, float lllllIIlIIIlIII, EntityLivingBase lllllIIlIIIIlll) {
        GlStateManager.pushMatrix();
        GlStateManager.enableDepth();
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableColorMaterial();
        GlStateManager.translate((float)lllllIIlIIIIlIl, (float)lllllIIlIIIlIIl, (float)50.0f);
        GlStateManager.scale((float)(-lllllIIlIIIlIII), (float)lllllIIlIIIlIII, (float)lllllIIlIIIlIII);
        GlStateManager.rotate((float)180.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        GlStateManager.rotate((float)135.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate((float)-135.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.rotate((float)(-((float)Math.atan(lllllIIlIIIIlll.field_70125_A / 40.0f)) * 20.0f), (float)1.0f, (float)0.0f, (float)0.0f);
        GlStateManager.translate((float)0.0f, (float)0.0f, (float)0.0f);
        RenderManager lllllIIlIIIIllI = Minecraft.getMinecraft().getRenderManager();
        lllllIIlIIIIllI.setPlayerViewY(180.0f);
        lllllIIlIIIIllI.setRenderShadow(false);
        lllllIIlIIIIllI.renderEntity((Entity)lllllIIlIIIIlll, 0.0, 0.0, 0.0, lllllIIlIIIIlll.field_70177_z, 1.0f, false);
        lllllIIlIIIIllI.setRenderShadow(true);
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture((int)OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GlStateManager.disableDepth();
        GlStateManager.setActiveTexture((int)OpenGlHelper.defaultTexUnit);
        GlStateManager.popMatrix();
    }

    public static void putVertex3d(Vec3d llllIlIlllIlIII) {
        GL11.glVertex3d((double)llllIlIlllIlIII.x, (double)llllIlIlllIlIII.y, (double)llllIlIlllIlIII.z);
    }

    public static void drawRect(float lllllIIIlIllIIl, float lllllIIIllIIIIl, float lllllIIIllIIIII, float lllllIIIlIlIllI, int lllllIIIlIlIlIl) {
        float lllllIIIlIlllIl = (float)(lllllIIIlIlIlIl >> 24 & 0xFF) / 255.0f;
        float lllllIIIlIlllII = (float)(lllllIIIlIlIlIl >> 16 & 0xFF) / 255.0f;
        float lllllIIIlIllIll = (float)(lllllIIIlIlIlIl >> 8 & 0xFF) / 255.0f;
        float lllllIIIlIllIlI = (float)(lllllIIIlIlIlIl & 0xFF) / 255.0f;
        GL11.glPushMatrix();
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GL11.glColor4f((float)lllllIIIlIlllII, (float)lllllIIIlIllIll, (float)lllllIIIlIllIlI, (float)lllllIIIlIlllIl);
        GL11.glBegin((int)7);
        GL11.glVertex2d((double)lllllIIIllIIIII, (double)lllllIIIllIIIIl);
        GL11.glVertex2d((double)lllllIIIlIllIIl, (double)lllllIIIllIIIIl);
        GL11.glVertex2d((double)lllllIIIlIllIIl, (double)lllllIIIlIlIllI);
        GL11.glVertex2d((double)lllllIIIllIIIII, (double)lllllIIIlIlIllI);
        GL11.glEnd();
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glDisable((int)2848);
        GL11.glPopMatrix();
    }

    public static void drawUpShadow(float llllIlIIIIIlIll, float llllIlIIIIIlIlI, float llllIlIIIIIIlIl, float llllIlIIIIIIlII) {
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int)7425);
        GL11.glBegin((int)7);
        RenderUtils.glColor(new Color(0, 0, 0, 100).getRGB());
        GL11.glVertex2d((double)llllIlIIIIIlIll, (double)llllIlIIIIIlIlI);
        RenderUtils.glColor(new Color(0, 0, 0, 0).getRGB());
        GL11.glVertex2d((double)llllIlIIIIIlIll, (double)llllIlIIIIIIlII);
        GL11.glVertex2d((double)llllIlIIIIIIlIl, (double)llllIlIIIIIIlII);
        RenderUtils.glColor(new Color(0, 0, 0, 100).getRGB());
        GL11.glVertex2d((double)llllIlIIIIIIlIl, (double)llllIlIIIIIlIlI);
        GL11.glEnd();
        GlStateManager.disableBlend();
        GlStateManager.enableTexture2D();
        GlStateManager.enableAlpha();
        GlStateManager.shadeModel((int)7424);
    }

    public static void enableSmoothLine(float llllIIlllllIlIl) {
        GL11.glDisable((int)3008);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        GL11.glEnable((int)2884);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glHint((int)3155, (int)4354);
        GL11.glLineWidth((float)llllIIlllllIlIl);
    }

    public static void FillLine(Entity llllIlIllIIlIll, AxisAlignedBB llllIlIllIIlIIl) {
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)3042);
        GL11.glLineWidth((float)2.0f);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        RenderGlobal.renderFilledBox((AxisAlignedBB)llllIlIllIIlIIl, (float)0.0f, (float)1.0f, (float)0.0f, (float)0.3f);
        RenderGlobal.drawSelectionBoundingBox((AxisAlignedBB)llllIlIllIIlIIl, (float)0.0f, (float)1.0f, (float)0.0f, (float)0.8f);
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2929);
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)3042);
    }

    public static void glColor(Color llllIIlllIIllII, float llllIIlllIlIIII) {
        float llllIIlllIIllll = (float)llllIIlllIIllII.getRed() / 255.0f;
        float llllIIlllIIlllI = (float)llllIIlllIIllII.getGreen() / 255.0f;
        float llllIIlllIIllIl = (float)llllIIlllIIllII.getBlue() / 255.0f;
        GlStateManager.color((float)llllIIlllIIllll, (float)llllIIlllIIlllI, (float)llllIIlllIIllIl, (float)llllIIlllIlIIII);
    }

    public static void scissorRect(float llllIllIIllIIlI, float llllIllIIllIIIl, float llllIllIIlIlIlI, double llllIllIIlIlIIl) {
        ScaledResolution llllIllIIlIlllI = new ScaledResolution(Minecraft.getMinecraft());
        int llllIllIIlIllIl = llllIllIIlIlllI.getScaleFactor();
        GL11.glScissor((int)((int)(llllIllIIllIIlI * (float)llllIllIIlIllIl)), (int)((int)(((double)llllIllIIlIlllI.getScaledHeight() - llllIllIIlIlIIl) * (double)llllIllIIlIllIl)), (int)((int)((llllIllIIlIlIlI - llllIllIIllIIlI) * (float)llllIllIIlIllIl)), (int)((int)((llllIllIIlIlIIl - (double)llllIllIIllIIIl) * (double)llllIllIIlIllIl)));
    }

    public static Vec3d getRenderPos(double llllIlIllllIIll, double llllIlIlllIllll, double llllIlIlllIlllI) {
        return new Vec3d(llllIlIllllIIll -= MinecraftHelper.mc.getRenderManager().viewerPosX, llllIlIlllIllll -= MinecraftHelper.mc.getRenderManager().viewerPosY, llllIlIlllIlllI -= MinecraftHelper.mc.getRenderManager().viewerPosZ);
    }

    public RenderUtils() {
        RenderUtils lllllIIlIIlIIII;
    }

    public static void renderEntity(EntityLivingBase llllIlIllIlIIII, int llllIlIllIlIIll, int llllIlIllIlIIlI, int llllIlIllIIllIl) {
        GlStateManager.enableTexture2D();
        GlStateManager.depthMask((boolean)true);
        GL11.glPushAttrib((int)524288);
        GL11.glDisable((int)3089);
        GlStateManager.clear((int)256);
        GL11.glPopAttrib();
        GlStateManager.enableDepth();
        GlStateManager.disableAlpha();
        GlStateManager.pushMatrix();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GuiInventory.drawEntityOnScreen((int)llllIlIllIlIIlI, (int)llllIlIllIIllIl, (int)llllIlIllIlIIll, (float)1.0f, (float)1.0f, (EntityLivingBase)llllIlIllIlIIII);
        GlStateManager.popMatrix();
        GlStateManager.disableDepth();
        GlStateManager.depthMask((boolean)false);
    }

    public static void drawEntityESP(Entity llllIlllIIIIllI, Color llllIlllIIIlIII) {
        GL11.glPushMatrix();
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)0);
        GL11.glLineWidth((float)1.0f);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)0);
        GL11.glDepthMask((boolean)false);
        GL11.glColor4d((double)((float)llllIlllIIIlIII.getRed() / 255.0f), (double)((float)llllIlllIIIlIII.getGreen() / 255.0f), (double)((float)llllIlllIIIlIII.getBlue() / 255.0f), (double)0.15f);
        RenderManager llllIlllIIIIlll = Minecraft.getMinecraft().getRenderManager();
        RenderUtil.drawColorBox(new AxisAlignedBB(-0.05 - llllIlllIIIIllI.posX + (llllIlllIIIIllI.posX - llllIlllIIIIlll.viewerPosX), -llllIlllIIIIllI.posY + (llllIlllIIIIllI.posY - llllIlllIIIIlll.viewerPosY), -0.05 - llllIlllIIIIllI.posZ + (llllIlllIIIIllI.posZ - llllIlllIIIIlll.viewerPosZ), 0.05 - llllIlllIIIIllI.posX + (llllIlllIIIIllI.posX - llllIlllIIIIlll.viewerPosX), 0.1 - llllIlllIIIIllI.posY + (llllIlllIIIIllI.posY - llllIlllIIIIlll.viewerPosY), 0.05 - llllIlllIIIIllI.posZ + (llllIlllIIIIllI.posZ - llllIlllIIIIlll.viewerPosZ)), 0.0f, 0.0f, 0.0f, 0.0f);
        GL11.glColor4d((double)0.0, (double)0.0, (double)0.0, (double)0.5);
        RenderUtil.drawSelectionBoundingBox(new AxisAlignedBB(-0.05 - llllIlllIIIIllI.posX + (llllIlllIIIIllI.posX - llllIlllIIIIlll.viewerPosX), -llllIlllIIIIllI.posY + (llllIlllIIIIllI.posY - llllIlllIIIIlll.viewerPosY), -0.05 - llllIlllIIIIllI.posZ + (llllIlllIIIIllI.posZ - llllIlllIIIIlll.viewerPosZ), 0.05 - llllIlllIIIIllI.posX + (llllIlllIIIIllI.posX - llllIlllIIIIlll.viewerPosX), 0.1 - llllIlllIIIIllI.posY + (llllIlllIIIIllI.posY - llllIlllIIIIlll.viewerPosY), 0.05 - llllIlllIIIIllI.posZ + (llllIlllIIIIllI.posZ - llllIlllIIIIlll.viewerPosZ)));
        GL11.glLineWidth((float)2.0f);
        GL11.glEnable((int)3553);
        GL11.glEnable((int)0);
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)0);
        GL11.glPopMatrix();
    }

    public static void drawboxESP5(BlockPos lllllIIIlIIIlII, Color lllllIIIIllIlIl) {
        double lllllIIIlIIIIlI = lllllIIIlIIIlII.func_177958_n();
        double lllllIIIlIIIIIl = Wrapper.INSTANCE.mc().getRenderManager().viewerPosX;
        double lllllIIIlIIIIII = Wrapper.INSTANCE.mc().getRenderManager().viewerPosY;
        double lllllIIIIllllll = Wrapper.INSTANCE.mc().getRenderManager().viewerPosZ;
        Minecraft.getMinecraft().getRenderManager();
        double lllllIIIIlllllI = lllllIIIlIIIIlI - lllllIIIlIIIIIl;
        lllllIIIlIIIIlI = lllllIIIlIIIlII.func_177956_o();
        Minecraft.getMinecraft().getRenderManager();
        double lllllIIIIllllIl = lllllIIIlIIIIlI - lllllIIIlIIIIII;
        lllllIIIlIIIIlI = lllllIIIlIIIlII.func_177952_p();
        Minecraft.getMinecraft().getRenderManager();
        double lllllIIIIllllII = lllllIIIlIIIIlI - lllllIIIIllllll;
        GL11.glBlendFunc((int)770, (int)771);
        Tessellator lllllIIIIlllIll = Tessellator.getInstance();
        BufferBuilder lllllIIIIlllIlI = lllllIIIIlllIll.getBuffer();
        GL11.glPushMatrix();
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)3042);
        GL11.glLineWidth((float)1.0f);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2896);
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)true);
        GL11.glColor4d((double)((float)lllllIIIIllIlIl.getRed() / 255.0f), (double)((float)lllllIIIIllIlIl.getGreen() / 255.0f), (double)((float)lllllIIIIllIlIl.getBlue() / 255.0f), (double)0.25);
        RenderManager lllllIIIIlllIIl = Minecraft.getMinecraft().getRenderManager();
        RenderUtil.drawColorBox(new AxisAlignedBB(lllllIIIIlllllI, lllllIIIIllllIl, lllllIIIIllllII, lllllIIIIlllllI + 1.0, lllllIIIIllllIl + 1.0, lllllIIIIllllII + 1.0), 0.0f, 0.0f, 0.0f, 0.0f);
        GL11.glColor4d((double)0.4f, (double)0.6f, (double)1.0, (double)1.0);
        GL11.glLineWidth((float)2.0f);
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2896);
        GL11.glEnable((int)2929);
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)3042);
        GL11.glPopMatrix();
    }

    public static void customScaledObject2D(float llllIlIlllIIIlI, float llllIlIllIlllII, float llllIlIlllIIIII, float llllIlIllIlllll, float llllIlIllIllIIl) {
        GL11.glTranslated((double)(llllIlIlllIIIII / 2.0f), (double)(llllIlIllIlllll / 2.0f), (double)1.0);
        GL11.glTranslated((double)(-llllIlIlllIIIlI * llllIlIllIllIIl + llllIlIlllIIIlI + llllIlIlllIIIII / 2.0f * -llllIlIllIllIIl), (double)(-llllIlIllIlllII * llllIlIllIllIIl + llllIlIllIlllII + llllIlIllIlllll / 2.0f * -llllIlIllIllIIl), (double)1.0);
        GL11.glScaled((double)llllIlIllIllIIl, (double)llllIlIllIllIIl, (double)0.0);
    }

    public static void drawImage(ResourceLocation llllIllllllIIII, int llllIlllllIllll, int llllIlllllIlllI, int llllIlllllIllIl, int llllIlllllIllII) {
        GL11.glEnable((int)2848);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glPushMatrix();
        Minecraft.getMinecraft().getTextureManager().bindTexture(llllIllllllIIII);
        Gui.drawModalRectWithCustomSizedTexture((int)llllIlllllIllll, (int)llllIlllllIlllI, (float)0.0f, (float)0.0f, (int)llllIlllllIllIl, (int)llllIlllllIllII, (float)llllIlllllIllIl, (float)llllIlllllIllII);
        GL11.glPopMatrix();
    }

    public static void disableGL2D() {
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glEnable((int)2929);
        GL11.glDisable((int)2848);
        GL11.glHint((int)3154, (int)4352);
        GL11.glHint((int)3155, (int)4352);
    }

    public static void glColor(Color llllIIllllIIIII) {
        float llllIIlllIlllll = (float)llllIIllllIIIII.getRed() / 255.0f;
        float llllIIlllIllllI = (float)llllIIllllIIIII.getGreen() / 255.0f;
        float llllIIlllIlllIl = (float)llllIIllllIIIII.getBlue() / 255.0f;
        float llllIIlllIlllII = (float)llllIIllllIIIII.getAlpha() / 255.0f;
        GlStateManager.color((float)llllIIlllIlllll, (float)llllIIlllIllllI, (float)llllIIlllIlllIl, (float)llllIIlllIlllII);
    }
}

