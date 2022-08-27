/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  org.lwjgl.opengl.GL11
 */
package ru.hld.legendline.antiNative;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;
import ru.hld.legendline.api.utils.ColorUtils;

public class RenderUtils {
    public static /* synthetic */ Minecraft mc;

    public static void renderItem(ItemStack lIlIlIllllIIIl, int lIlIlIlllIllIl, int lIlIlIlllIllII) {
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        GlStateManager.enableDepth();
        RenderHelper.enableGUIStandardItemLighting();
        RenderUtils.mc.getRenderItem().zLevel = -100.0f;
        mc.getRenderItem().renderItemAndEffectIntoGUI(lIlIlIllllIIIl, lIlIlIlllIllIl, lIlIlIlllIllII);
        mc.getRenderItem().renderItemOverlays(RenderUtils.mc.fontRendererObj, lIlIlIllllIIIl, lIlIlIlllIllIl, lIlIlIlllIllII);
        RenderUtils.mc.getRenderItem().zLevel = 0.0f;
        RenderHelper.disableStandardItemLighting();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.disableDepth();
    }

    public static void customScaledObject2D(float lIlIlIllIlIlII, float lIlIlIllIIlllI, float lIlIlIllIlIIlI, float lIlIlIllIIllII, float lIlIlIllIIlIll) {
        GL11.glTranslated((double)(lIlIlIllIlIIlI / 2.0f), (double)(lIlIlIllIIllII / 2.0f), (double)1.0);
        GL11.glTranslated((double)(-lIlIlIllIlIlII * lIlIlIllIIlIll + lIlIlIllIlIlII + lIlIlIllIlIIlI / 2.0f * -lIlIlIllIIlIll), (double)(-lIlIlIllIIlllI * lIlIlIllIIlIll + lIlIlIllIIlllI + lIlIlIllIIllII / 2.0f * -lIlIlIllIIlIll), (double)1.0);
        GL11.glScaled((double)lIlIlIllIIlIll, (double)lIlIlIllIIlIll, (double)0.0);
    }

    public static void drawShadow(double lIlIIllllIlIlI, double lIlIIllllIIIll, double lIlIIllllIlIII, double lIlIIllllIIlll, int lIlIIllllIIllI, int lIlIIlllIlllll) {
        RenderUtils.drawGradientRect(lIlIIllllIlIlI, lIlIIllllIIIll - (double)lIlIIllllIIllI, lIlIIllllIlIII, lIlIIllllIIIll, false, true, lIlIIlllIlllll, ColorUtils.swapAlpha(lIlIIlllIlllll, 0.0f));
        RenderUtils.drawGradientRect(lIlIIllllIlIlI, lIlIIllllIIlll, lIlIIllllIlIII, lIlIIllllIIlll + (double)lIlIIllllIIllI, false, false, lIlIIlllIlllll, ColorUtils.swapAlpha(lIlIIlllIlllll, 0.0f));
        RenderUtils.drawSector2(lIlIIllllIlIII, lIlIIllllIIlll, 0, 90, lIlIIllllIIllI, lIlIIlllIlllll);
        RenderUtils.drawSector2(lIlIIllllIlIII, lIlIIllllIIIll, 90, 180, lIlIIllllIIllI, lIlIIlllIlllll);
        RenderUtils.drawSector2(lIlIIllllIlIlI, lIlIIllllIIIll, 180, 270, lIlIIllllIIllI, lIlIIlllIlllll);
        RenderUtils.drawSector2(lIlIIllllIlIlI, lIlIIllllIIlll, 270, 360, lIlIIllllIIllI, lIlIIlllIlllll);
        RenderUtils.drawGradientRect(lIlIIllllIlIlI - (double)lIlIIllllIIllI, lIlIIllllIIIll, lIlIIllllIlIlI, lIlIIllllIIlll, true, true, lIlIIlllIlllll, ColorUtils.swapAlpha(lIlIIlllIlllll, 0.0f));
        RenderUtils.drawGradientRect(lIlIIllllIlIII, lIlIIllllIIIll, lIlIIllllIlIII + (double)lIlIIllllIIllI, lIlIIllllIIlll, true, false, lIlIIlllIlllll, ColorUtils.swapAlpha(lIlIIlllIlllll, 0.0f));
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    public static void drawSuper(double lIlIlIIIlIIIII, double lIlIlIIIlIIlIl, double lIlIlIIIIllllI, double lIlIlIIIIlllIl, int lIlIlIIIlIIIlI, int lIlIlIIIlIIIIl) {
        RenderUtils.glColor(lIlIlIIIlIIIIl);
        RenderUtils.drawRect(lIlIlIIIlIIIII, lIlIlIIIlIIlIl, lIlIlIIIIllllI, lIlIlIIIIlllIl, lIlIlIIIlIIIIl);
        RenderUtils.drawGradientRect(lIlIlIIIlIIIII, lIlIlIIIlIIlIl - (double)lIlIlIIIlIIIlI, lIlIlIIIIllllI, lIlIlIIIlIIlIl, false, true, lIlIlIIIlIIIIl, lIlIlIIIlIIIIl);
        RenderUtils.drawGradientRect(lIlIlIIIlIIIII, lIlIlIIIIlllIl, lIlIlIIIIllllI, lIlIlIIIIlllIl + (double)lIlIlIIIlIIIlI, false, false, lIlIlIIIlIIIIl, lIlIlIIIlIIIIl);
        RenderUtils.drawSector3(lIlIlIIIIllllI, lIlIlIIIIlllIl, 0, 90, lIlIlIIIlIIIlI, lIlIlIIIlIIIIl);
        RenderUtils.drawSector3(lIlIlIIIIllllI, lIlIlIIIlIIlIl, 90, 180, lIlIlIIIlIIIlI, lIlIlIIIlIIIIl);
        RenderUtils.drawSector3(lIlIlIIIlIIIII, lIlIlIIIlIIlIl, 180, 270, lIlIlIIIlIIIlI, lIlIlIIIlIIIIl);
        RenderUtils.drawSector3(lIlIlIIIlIIIII, lIlIlIIIIlllIl, 270, 360, lIlIlIIIlIIIlI, lIlIlIIIlIIIIl);
        RenderUtils.drawGradientRect(lIlIlIIIlIIIII - (double)lIlIlIIIlIIIlI, lIlIlIIIlIIlIl, lIlIlIIIlIIIII, lIlIlIIIIlllIl, true, true, lIlIlIIIlIIIIl, lIlIlIIIlIIIIl);
        RenderUtils.drawGradientRect(lIlIlIIIIllllI, lIlIlIIIlIIlIl, lIlIlIIIIllllI + (double)lIlIlIIIlIIIlI, lIlIlIIIIlllIl, true, false, lIlIlIIIlIIIIl, lIlIlIIIlIIIIl);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    public static void drawSector2(double lIlIIlllIIIlII, double lIlIIllIllllIl, int lIlIIllIllllII, int lIlIIlllIIIIIl, int lIlIIllIlllIlI, int lIlIIllIllllll) {
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int)7425);
        GL11.glBegin((int)6);
        RenderUtils.glColor(lIlIIllIllllll);
        GL11.glVertex2d((double)lIlIIlllIIIlII, (double)lIlIIllIllllIl);
        RenderUtils.glColor(ColorUtils.swapAlpha(lIlIIllIllllll, 0.0f));
        for (int lIlIIlllIIIlIl = lIlIIllIllllII; lIlIIlllIIIlIl <= lIlIIlllIIIIIl; ++lIlIIlllIIIlIl) {
            GL11.glVertex2d((double)(lIlIIlllIIIlII + Math.sin((double)lIlIIlllIIIlIl * Math.PI / 180.0) * (double)lIlIIllIlllIlI), (double)(lIlIIllIllllIl + Math.cos((double)lIlIIlllIIIlIl * Math.PI / 180.0) * (double)lIlIIllIlllIlI));
        }
        GL11.glEnd();
        GlStateManager.disableBlend();
        GlStateManager.enableTexture2D();
        GlStateManager.enableAlpha();
        GlStateManager.shadeModel((int)7424);
    }

    public static void drawDownShadow(float lIlIllIIIIlIII, float lIlIllIIIIIIll, float lIlIllIIIIIllI, float lIlIllIIIIIIIl) {
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int)7425);
        GL11.glBegin((int)7);
        RenderUtils.glColor(new Color(0, 0, 0, 100).getRGB());
        GL11.glVertex2d((double)lIlIllIIIIIllI, (double)lIlIllIIIIIIIl);
        RenderUtils.glColor(new Color(0, 0, 0, 0).getRGB());
        GL11.glVertex2d((double)lIlIllIIIIIllI, (double)lIlIllIIIIIIll);
        GL11.glVertex2d((double)lIlIllIIIIlIII, (double)lIlIllIIIIIIll);
        RenderUtils.glColor(new Color(0, 0, 0, 100).getRGB());
        GL11.glVertex2d((double)lIlIllIIIIlIII, (double)lIlIllIIIIIIIl);
        GL11.glEnd();
        GlStateManager.disableBlend();
        GlStateManager.enableTexture2D();
        GlStateManager.enableAlpha();
        GlStateManager.shadeModel((int)7424);
    }

    public static void drawSector3(double lIlIlIIIIlIIlI, double lIlIlIIIIIlIll, int lIlIlIIIIlIIII, int lIlIlIIIIIlIIl, int lIlIlIIIIIlIII, int lIlIlIIIIIllIl) {
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int)7425);
        GL11.glBegin((int)6);
        RenderUtils.glColor(lIlIlIIIIIllIl);
        GL11.glVertex2d((double)lIlIlIIIIlIIlI, (double)lIlIlIIIIIlIll);
        RenderUtils.glColor(lIlIlIIIIIllIl);
        for (int lIlIlIIIIlIIll = lIlIlIIIIlIIII; lIlIlIIIIlIIll <= lIlIlIIIIIlIIl; ++lIlIlIIIIlIIll) {
            GL11.glVertex2d((double)(lIlIlIIIIlIIlI + Math.sin((double)lIlIlIIIIlIIll * Math.PI / 180.0) * (double)lIlIlIIIIIlIII), (double)(lIlIlIIIIIlIll + Math.cos((double)lIlIlIIIIlIIll * Math.PI / 180.0) * (double)lIlIlIIIIIlIII));
        }
        GL11.glEnd();
        GlStateManager.disableBlend();
        GlStateManager.enableTexture2D();
        GlStateManager.enableAlpha();
        GlStateManager.shadeModel((int)7424);
    }

    public static void drawGradientRect(double lIlIIllIlIIlll, double lIlIIllIlIIllI, double lIlIIllIlIllIl, double lIlIIllIlIIlII, boolean lIlIIllIlIIIll, boolean lIlIIllIlIIIlI, int lIlIIllIlIlIIl, int lIlIIllIlIIIII) {
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int)7425);
        GL11.glBegin((int)7);
        RenderUtils.glColor(lIlIIllIlIlIIl);
        if (lIlIIllIlIIIll) {
            if (lIlIIllIlIIIlI) {
                GL11.glVertex2d((double)lIlIIllIlIllIl, (double)lIlIIllIlIIlII);
                GL11.glVertex2d((double)lIlIIllIlIllIl, (double)lIlIIllIlIIllI);
                RenderUtils.glColor(lIlIIllIlIIIII);
                GL11.glVertex2d((double)lIlIIllIlIIlll, (double)lIlIIllIlIIllI);
                GL11.glVertex2d((double)lIlIIllIlIIlll, (double)lIlIIllIlIIlII);
            } else {
                GL11.glVertex2d((double)lIlIIllIlIIlll, (double)lIlIIllIlIIllI);
                GL11.glVertex2d((double)lIlIIllIlIIlll, (double)lIlIIllIlIIlII);
                RenderUtils.glColor(lIlIIllIlIIIII);
                GL11.glVertex2d((double)lIlIIllIlIllIl, (double)lIlIIllIlIIlII);
                GL11.glVertex2d((double)lIlIIllIlIllIl, (double)lIlIIllIlIIllI);
            }
        } else if (lIlIIllIlIIIlI) {
            GL11.glVertex2d((double)lIlIIllIlIllIl, (double)lIlIIllIlIIlII);
            RenderUtils.glColor(lIlIIllIlIIIII);
            GL11.glVertex2d((double)lIlIIllIlIllIl, (double)lIlIIllIlIIllI);
            GL11.glVertex2d((double)lIlIIllIlIIlll, (double)lIlIIllIlIIllI);
            RenderUtils.glColor(lIlIIllIlIlIIl);
            GL11.glVertex2d((double)lIlIIllIlIIlll, (double)lIlIIllIlIIlII);
        } else {
            GL11.glVertex2d((double)lIlIIllIlIIlll, (double)lIlIIllIlIIllI);
            RenderUtils.glColor(lIlIIllIlIIIII);
            GL11.glVertex2d((double)lIlIIllIlIIlll, (double)lIlIIllIlIIlII);
            GL11.glVertex2d((double)lIlIIllIlIllIl, (double)lIlIIllIlIIlII);
            RenderUtils.glColor(lIlIIllIlIlIIl);
            GL11.glVertex2d((double)lIlIIllIlIllIl, (double)lIlIIllIlIIllI);
        }
        GL11.glEnd();
        GlStateManager.disableBlend();
        GlStateManager.enableTexture2D();
        GlStateManager.enableAlpha();
        GlStateManager.shadeModel((int)7424);
    }

    public static void glColor(int lIlIIllIIllIlI) {
        float lIlIIllIIllIIl = (float)(lIlIIllIIllIlI >> 16 & 0xFF) / 255.0f;
        float lIlIIllIIllIII = (float)(lIlIIllIIllIlI >> 8 & 0xFF) / 255.0f;
        float lIlIIllIIlIlll = (float)(lIlIIllIIllIlI & 0xFF) / 255.0f;
        float lIlIIllIIlIllI = (float)(lIlIIllIIllIlI >> 24 & 0xFF) / 255.0f;
        GlStateManager.color((float)lIlIIllIIllIIl, (float)lIlIIllIIllIII, (float)lIlIIllIIlIlll, (float)lIlIIllIIlIllI);
    }

    public static void putVertex3d(Vec3d lIlIlIllllIlIl) {
        GL11.glVertex3d((double)lIlIlIllllIlIl.xCoord, (double)lIlIlIllllIlIl.yCoord, (double)lIlIlIllllIlIl.zCoord);
    }

    public static void blockEspFrame(BlockPos lIlIllIlIIIIIl, double lIlIllIlIIIIII, double lIlIllIIllIlII, double lIlIllIIlllllI) {
        double lIlIllIIllllIl = lIlIllIlIIIIIl.getX();
        Minecraft.getMinecraft().getRenderManager();
        double lIlIllIIllllII = lIlIllIIllllIl - RenderUtils.mc.getRenderManager().viewerPosX;
        double lIlIllIIlllIll = lIlIllIlIIIIIl.getY();
        Minecraft.getMinecraft().getRenderManager();
        double lIlIllIIlllIlI = lIlIllIIlllIll - RenderUtils.mc.getRenderManager().viewerPosY;
        double lIlIllIIlllIIl = lIlIllIlIIIIIl.getZ();
        Minecraft.getMinecraft().getRenderManager();
        double lIlIllIIlllIII = lIlIllIIlllIIl - RenderUtils.mc.getRenderManager().viewerPosZ;
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)3042);
        GL11.glLineWidth((float)1.0f);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        GL11.glColor4d((double)lIlIllIlIIIIII, (double)lIlIllIIllIlII, (double)lIlIllIIlllllI, (double)1.0);
        RenderUtils.drawSelectionBoundingBox(new AxisAlignedBB(lIlIllIIllllII, lIlIllIIlllIlI, lIlIllIIlllIII, lIlIllIIllllII + 1.0, lIlIllIIlllIlI + 1.0, lIlIllIIlllIII + 1.0));
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2929);
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)3042);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    public static void drawRect(float lIlIlIlIlIllll, float lIlIlIlIlIIlIl, float lIlIlIlIlIllIl, float lIlIlIlIlIllII, int lIlIlIlIlIIIlI) {
        float lIlIlIlIlIlIlI = (float)(lIlIlIlIlIIIlI >> 24 & 0xFF) / 255.0f;
        float lIlIlIlIlIlIIl = (float)(lIlIlIlIlIIIlI >> 16 & 0xFF) / 255.0f;
        float lIlIlIlIlIlIII = (float)(lIlIlIlIlIIIlI >> 8 & 0xFF) / 255.0f;
        float lIlIlIlIlIIlll = (float)(lIlIlIlIlIIIlI & 0xFF) / 255.0f;
        GL11.glPushMatrix();
        GL11.glPushAttrib((int)1048575);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)2884);
        GL11.glDisable((int)3553);
        GL11.glColor4f((float)lIlIlIlIlIlIIl, (float)lIlIlIlIlIlIII, (float)lIlIlIlIlIIlll, (float)lIlIlIlIlIlIlI);
        GL11.glBegin((int)7);
        GL11.glVertex2d((double)lIlIlIlIlIllll, (double)lIlIlIlIlIIlIl);
        GL11.glVertex2d((double)lIlIlIlIlIllIl, (double)lIlIlIlIlIIlIl);
        GL11.glVertex2d((double)lIlIlIlIlIllIl, (double)lIlIlIlIlIllII);
        GL11.glVertex2d((double)lIlIlIlIlIllll, (double)lIlIlIlIlIllII);
        GL11.glEnd();
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2884);
        GL11.glDisable((int)3042);
        GL11.glPopAttrib();
        GL11.glPopMatrix();
    }

    public static void drawShadowRect(double lIlIIlllIllIII, double lIlIIlllIlIIIl, double lIlIIlllIlIIII, double lIlIIlllIlIlIl, int lIlIIlllIIlllI, int lIlIIlllIIllIl) {
        RenderUtils.glColor(lIlIIlllIIllIl);
        RenderUtils.drawRect(lIlIIlllIllIII, lIlIIlllIlIIIl, lIlIIlllIlIIII, lIlIIlllIlIlIl, lIlIIlllIIllIl);
        RenderUtils.drawGradientRect(lIlIIlllIllIII, lIlIIlllIlIIIl - (double)lIlIIlllIIlllI, lIlIIlllIlIIII, lIlIIlllIlIIIl, false, true, lIlIIlllIIllIl, ColorUtils.swapAlpha(lIlIIlllIIllIl, 0.0f));
        RenderUtils.drawGradientRect(lIlIIlllIllIII, lIlIIlllIlIlIl, lIlIIlllIlIIII, lIlIIlllIlIlIl + (double)lIlIIlllIIlllI, false, false, lIlIIlllIIllIl, ColorUtils.swapAlpha(lIlIIlllIIllIl, 0.0f));
        RenderUtils.drawSector2(lIlIIlllIlIIII, lIlIIlllIlIlIl, 0, 90, lIlIIlllIIlllI, lIlIIlllIIllIl);
        RenderUtils.drawSector2(lIlIIlllIlIIII, lIlIIlllIlIIIl, 90, 180, lIlIIlllIIlllI, lIlIIlllIIllIl);
        RenderUtils.drawSector2(lIlIIlllIllIII, lIlIIlllIlIIIl, 180, 270, lIlIIlllIIlllI, lIlIIlllIIllIl);
        RenderUtils.drawSector2(lIlIIlllIllIII, lIlIIlllIlIlIl, 270, 360, lIlIIlllIIlllI, lIlIIlllIIllIl);
        RenderUtils.drawGradientRect(lIlIIlllIllIII - (double)lIlIIlllIIlllI, lIlIIlllIlIIIl, lIlIIlllIllIII, lIlIIlllIlIlIl, true, true, lIlIIlllIIllIl, ColorUtils.swapAlpha(lIlIIlllIIllIl, 0.0f));
        RenderUtils.drawGradientRect(lIlIIlllIlIIII, lIlIIlllIlIIIl, lIlIIlllIlIIII + (double)lIlIIlllIIlllI, lIlIIlllIlIlIl, true, false, lIlIIlllIIllIl, ColorUtils.swapAlpha(lIlIIlllIIllIl, 0.0f));
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    static {
        mc = Minecraft.getMinecraft();
    }

    public static void drawUpShadow(float lIlIllIIIlIIII, float lIlIllIIIIllll, float lIlIllIIIIlllI, float lIlIllIIIlIIIl) {
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int)7425);
        GL11.glBegin((int)7);
        RenderUtils.glColor(new Color(0, 0, 0, 100).getRGB());
        GL11.glVertex2d((double)lIlIllIIIlIIII, (double)lIlIllIIIIllll);
        RenderUtils.glColor(new Color(0, 0, 0, 0).getRGB());
        GL11.glVertex2d((double)lIlIllIIIlIIII, (double)lIlIllIIIlIIIl);
        GL11.glVertex2d((double)lIlIllIIIIlllI, (double)lIlIllIIIlIIIl);
        RenderUtils.glColor(new Color(0, 0, 0, 100).getRGB());
        GL11.glVertex2d((double)lIlIllIIIIlllI, (double)lIlIllIIIIllll);
        GL11.glEnd();
        GlStateManager.disableBlend();
        GlStateManager.enableTexture2D();
        GlStateManager.enableAlpha();
        GlStateManager.shadeModel((int)7424);
    }

    public static void drawRect(double lIlIlIIIllIlIl, double lIlIlIIIllllIl, double lIlIlIIIllIIll, double lIlIlIIIlllIll, int lIlIlIIIllIIIl) {
        float lIlIlIIIlllIIl = (float)(lIlIlIIIllIIIl >> 24 & 0xFF) / 255.0f;
        float lIlIlIIIlllIII = (float)(lIlIlIIIllIIIl >> 16 & 0xFF) / 255.0f;
        float lIlIlIIIllIlll = (float)(lIlIlIIIllIIIl >> 8 & 0xFF) / 255.0f;
        float lIlIlIIIllIllI = (float)(lIlIlIIIllIIIl & 0xFF) / 255.0f;
        GL11.glPushMatrix();
        GL11.glPushAttrib((int)1048575);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)2884);
        GL11.glDisable((int)3553);
        GL11.glColor4f((float)lIlIlIIIlllIII, (float)lIlIlIIIllIlll, (float)lIlIlIIIllIllI, (float)lIlIlIIIlllIIl);
        GL11.glBegin((int)7);
        GL11.glVertex2d((double)lIlIlIIIllIlIl, (double)lIlIlIIIllllIl);
        GL11.glVertex2d((double)lIlIlIIIllIIll, (double)lIlIlIIIllllIl);
        GL11.glVertex2d((double)lIlIlIIIllIIll, (double)lIlIlIIIlllIll);
        GL11.glVertex2d((double)lIlIlIIIllIlIl, (double)lIlIlIIIlllIll);
        GL11.glEnd();
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2884);
        GL11.glDisable((int)3042);
        GL11.glPopAttrib();
        GL11.glPopMatrix();
    }

    public static Vec3d getRenderPos(double lIlIlIllllllIl, double lIlIlIllllllII, double lIlIlIlllllIll) {
        return new Vec3d(lIlIlIllllllIl -= RenderUtils.mc.getRenderManager().viewerPosX, lIlIlIllllllII -= RenderUtils.mc.getRenderManager().viewerPosY, lIlIlIlllllIll -= RenderUtils.mc.getRenderManager().viewerPosZ);
    }

    public static void setupColor(int lIlIIllIIIlIll, float lIlIIllIIIlIlI) {
        float lIlIIllIIIlIIl = (float)(lIlIIllIIIlIll >> 16 & 0xFF) / 255.0f;
        float lIlIIllIIIlIII = (float)(lIlIIllIIIlIll >> 8 & 0xFF) / 255.0f;
        float lIlIIllIIIIlll = (float)(lIlIIllIIIlIll & 0xFF) / 255.0f;
        GL11.glColor4f((float)lIlIIllIIIlIIl, (float)lIlIIllIIIlIII, (float)lIlIIllIIIIlll, (float)(lIlIIllIIIlIlI / 255.0f));
    }

    public static void draw2lines(float lIlIlIlIIIIlll, float lIlIlIlIIIIllI, int lIlIlIlIIlIIII, float lIlIlIlIIIllll) {
        float lIlIlIlIIIlllI = (float)(lIlIlIlIIlIIII >> 24 & 0xFF) / 255.0f;
        float lIlIlIlIIIllIl = (float)(lIlIlIlIIlIIII >> 16 & 0xFF) / 255.0f;
        float lIlIlIlIIIllII = (float)(lIlIlIlIIlIIII >> 8 & 0xFF) / 255.0f;
        float lIlIlIlIIIlIll = (float)(lIlIlIlIIlIIII & 0xFF) / 255.0f;
        boolean lIlIlIlIIIlIlI = GL11.glIsEnabled((int)3042);
        boolean lIlIlIlIIIlIIl = GL11.glIsEnabled((int)2848);
        boolean lIlIlIlIIIlIII = GL11.glIsEnabled((int)3553);
        if (!lIlIlIlIIIlIlI) {
            GL11.glEnable((int)3042);
        }
        if (!lIlIlIlIIIlIIl) {
            GL11.glEnable((int)2848);
        }
        if (lIlIlIlIIIlIII) {
            GL11.glDisable((int)3553);
        }
        GL11.glEnable((int)2848);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glColor4f((float)lIlIlIlIIIllIl, (float)lIlIlIlIIIllII, (float)lIlIlIlIIIlIll, (float)lIlIlIlIIIlllI);
        GL11.glLineWidth((float)2.5f);
        GL11.glBegin((int)9);
        GL11.glVertex2d((double)(lIlIlIlIIIIlll - lIlIlIlIIIllll - 5.0f), (double)(lIlIlIlIIIIllI + 70.0f));
        GL11.glVertex2d((double)(lIlIlIlIIIIlll - lIlIlIlIIIllll), (double)(lIlIlIlIIIIllI + 80.0f));
        GL11.glVertex2d((double)(lIlIlIlIIIIlll - lIlIlIlIIIllll), (double)(lIlIlIlIIIIllI - 67.0f));
        GL11.glVertex2d((double)(lIlIlIlIIIIlll - lIlIlIlIIIllll - 5.0f), (double)(lIlIlIlIIIIllI - 58.0f));
        GL11.glEnd();
        GL11.glBegin((int)9);
        GL11.glVertex2d((double)(lIlIlIlIIIIlll + lIlIlIlIIIllll), (double)(lIlIlIlIIIIllI + 80.0f));
        GL11.glVertex2d((double)(lIlIlIlIIIIlll + lIlIlIlIIIllll + 5.0f), (double)(lIlIlIlIIIIllI + 70.0f));
        GL11.glVertex2d((double)(lIlIlIlIIIIlll + lIlIlIlIIIllll + 5.0f), (double)(lIlIlIlIIIIllI - 58.0f));
        GL11.glVertex2d((double)(lIlIlIlIIIIlll + lIlIlIlIIIllll), (double)(lIlIlIlIIIIllI - 66.0f));
        GL11.glEnd();
        GL11.glDisable((int)2848);
        if (lIlIlIlIIIlIII) {
            GL11.glEnable((int)3553);
        }
        if (!lIlIlIlIIIlIIl) {
            GL11.glDisable((int)2848);
        }
        if (!lIlIlIlIIIlIlI) {
            GL11.glDisable((int)3042);
        }
    }

    public static void outline(double lIlIIlllllIlll, double lIlIIlllllllIl, double lIlIIlllllIlIl, double lIlIIlllllIlII, int lIlIIllllllIlI, int lIlIIllllllIIl, int lIlIIlllllIIIl) {
        RenderUtils.drawGradientRect(lIlIIlllllIlll, lIlIIlllllllIl - (double)lIlIIllllllIlI, lIlIIlllllIlIl, lIlIIlllllllIl, false, true, lIlIIllllllIIl, lIlIIlllllIIIl);
        RenderUtils.drawGradientRect(lIlIIlllllIlll, lIlIIlllllIlII, lIlIIlllllIlIl, lIlIIlllllIlII + (double)lIlIIllllllIlI, false, false, lIlIIllllllIIl, lIlIIlllllIIIl);
        RenderUtils.drawSector2(lIlIIlllllIlIl, lIlIIlllllIlII, 0, 90, lIlIIllllllIlI, lIlIIllllllIIl);
        RenderUtils.drawSector2(lIlIIlllllIlIl, lIlIIlllllllIl, 90, 180, lIlIIllllllIlI, lIlIIllllllIIl);
        RenderUtils.drawSector2(lIlIIlllllIlll, lIlIIlllllllIl, 180, 270, lIlIIllllllIlI, lIlIIllllllIIl);
        RenderUtils.drawSector2(lIlIIlllllIlll, lIlIIlllllIlII, 270, 360, lIlIIllllllIlI, lIlIIllllllIIl);
        RenderUtils.drawGradientRect(lIlIIlllllIlll - (double)lIlIIllllllIlI, lIlIIlllllllIl, lIlIIlllllIlll, lIlIIlllllIlII, true, true, lIlIIllllllIIl, lIlIIlllllIIIl);
        RenderUtils.drawGradientRect(lIlIIlllllIlIl, lIlIIlllllllIl, lIlIIlllllIlIl + (double)lIlIIllllllIlI, lIlIIlllllIlII, true, false, lIlIIllllllIIl, lIlIIlllllIIIl);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    public static void drawRobotgui(float lIlIlIIllIlIII, float lIlIlIIlIlIlll, int lIlIlIIllIIllI, int lIlIlIIllIIlIl, float lIlIlIIllIIlII) {
        float lIlIlIIllIIIll = (float)(lIlIlIIllIIllI >> 24 & 0xFF) / 255.0f;
        float lIlIlIIllIIIlI = (float)(lIlIlIIllIIllI >> 16 & 0xFF) / 255.0f;
        float lIlIlIIllIIIIl = (float)(lIlIlIIllIIllI >> 8 & 0xFF) / 255.0f;
        float lIlIlIIllIIIII = (float)(lIlIlIIllIIllI & 0xFF) / 255.0f;
        float lIlIlIIlIlllll = (float)(lIlIlIIllIIlIl >> 24 & 0xFF) / 255.0f;
        float lIlIlIIlIllllI = (float)(lIlIlIIllIIlIl >> 16 & 0xFF) / 255.0f;
        float lIlIlIIlIlllIl = (float)(lIlIlIIllIIlIl >> 8 & 0xFF) / 255.0f;
        float lIlIlIIlIlllII = (float)(lIlIlIIllIIlIl & 0xFF) / 255.0f;
        boolean lIlIlIIlIllIll = GL11.glIsEnabled((int)3042);
        boolean lIlIlIIlIllIlI = GL11.glIsEnabled((int)2848);
        boolean lIlIlIIlIllIIl = GL11.glIsEnabled((int)3553);
        if (!lIlIlIIlIllIll) {
            GL11.glEnable((int)3042);
        }
        if (!lIlIlIIlIllIlI) {
            GL11.glEnable((int)2848);
        }
        if (lIlIlIIlIllIIl) {
            GL11.glDisable((int)3553);
        }
        GL11.glEnable((int)2848);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glColor4f((float)lIlIlIIllIIIlI, (float)lIlIlIIllIIIIl, (float)lIlIlIIllIIIII, (float)lIlIlIIllIIIll);
        GL11.glLineWidth((float)2.5f);
        GL11.glBegin((int)3);
        for (int lIlIlIIllIlIll = -140; lIlIlIIllIlIll <= -60; ++lIlIlIIllIlIll) {
            GL11.glVertex2d((double)((double)lIlIlIIllIlIII + Math.sin((double)lIlIlIIllIlIll * Math.PI / 180.0) * (double)lIlIlIIllIIlII), (double)((double)lIlIlIIlIlIlll + Math.cos((double)lIlIlIIllIlIll * Math.PI / 180.0) * (double)lIlIlIIllIIlII));
            GL11.glVertex2d((double)((double)lIlIlIIllIlIII - 0.5 + Math.sin((double)lIlIlIIllIlIll * Math.PI / 180.0) * (double)lIlIlIIllIIlII), (double)((double)lIlIlIIlIlIlll - 10.0 + Math.cos((double)lIlIlIIllIlIll * Math.PI / 180.0) * (double)lIlIlIIllIIlII));
        }
        GL11.glEnd();
        GL11.glBegin((int)3);
        for (int lIlIlIIllIlIlI = 100; lIlIlIIllIlIlI <= 180; ++lIlIlIIllIlIlI) {
            GL11.glVertex2d((double)((double)lIlIlIIllIlIII + Math.sin((double)lIlIlIIllIlIlI * Math.PI / 180.0) * (double)lIlIlIIllIIlII), (double)((double)lIlIlIIlIlIlll + Math.cos((double)lIlIlIIllIlIlI * Math.PI / 180.0) * (double)lIlIlIIllIIlII));
            GL11.glVertex2d((double)((double)lIlIlIIllIlIII - 0.5 + Math.sin((double)lIlIlIIllIlIlI * Math.PI / 180.0) * (double)lIlIlIIllIIlII), (double)((double)lIlIlIIlIlIlll - 10.0 + Math.cos((double)lIlIlIIllIlIlI * Math.PI / 180.0) * (double)lIlIlIIllIIlII));
        }
        GL11.glEnd();
        GL11.glBegin((int)3);
        for (int lIlIlIIllIlIIl = -20; lIlIlIIllIlIIl <= 60; ++lIlIlIIllIlIIl) {
            GL11.glVertex2d((double)((double)lIlIlIIllIlIII + Math.sin((double)lIlIlIIllIlIIl * Math.PI / 180.0) * (double)lIlIlIIllIIlII), (double)((double)lIlIlIIlIlIlll + Math.cos((double)lIlIlIIllIlIIl * Math.PI / 180.0) * (double)lIlIlIIllIIlII));
            GL11.glVertex2d((double)((double)lIlIlIIllIlIII - 0.5 + Math.sin((double)lIlIlIIllIlIIl * Math.PI / 180.0) * (double)lIlIlIIllIIlII), (double)((double)lIlIlIIlIlIlll - 10.0 + Math.cos((double)lIlIlIIllIlIIl * Math.PI / 180.0) * (double)lIlIlIIllIIlII));
        }
        GL11.glEnd();
        GL11.glDisable((int)2848);
        if (lIlIlIIlIllIIl) {
            GL11.glEnable((int)3553);
        }
        if (!lIlIlIIlIllIlI) {
            GL11.glDisable((int)2848);
        }
        if (!lIlIlIIlIllIll) {
            GL11.glDisable((int)3042);
        }
    }

    public static void drawGradientRect(double lIlIllIIlIIllI, double lIlIllIIlIIlIl, double lIlIllIIlIIlII, double lIlIllIIIlllII, boolean lIlIllIIlIIIlI, int lIlIllIIlIIIIl, int lIlIllIIIllIIl) {
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        GlStateManager.shadeModel((int)7425);
        RenderUtils.glColor(lIlIllIIlIIIIl);
        GL11.glBegin((int)7);
        if (lIlIllIIlIIIlI) {
            GL11.glVertex2d((double)lIlIllIIlIIllI, (double)lIlIllIIlIIlIl);
            GL11.glVertex2d((double)lIlIllIIlIIllI, (double)lIlIllIIIlllII);
            RenderUtils.glColor(lIlIllIIIllIIl);
            GL11.glVertex2d((double)lIlIllIIlIIlII, (double)lIlIllIIIlllII);
            GL11.glVertex2d((double)lIlIllIIlIIlII, (double)lIlIllIIlIIlIl);
        } else {
            GL11.glVertex2d((double)lIlIllIIlIIllI, (double)lIlIllIIlIIlIl);
            RenderUtils.glColor(lIlIllIIIllIIl);
            GL11.glVertex2d((double)lIlIllIIlIIllI, (double)lIlIllIIIlllII);
            GL11.glVertex2d((double)lIlIllIIlIIlII, (double)lIlIllIIIlllII);
            RenderUtils.glColor(lIlIllIIlIIIIl);
            GL11.glVertex2d((double)lIlIllIIlIIlII, (double)lIlIllIIlIIlIl);
        }
        GL11.glEnd();
        GlStateManager.disableBlend();
        GlStateManager.enableTexture2D();
        GlStateManager.enableAlpha();
        GlStateManager.shadeModel((int)7424);
    }

    public static void customScaledObject2D(float lIlIlIlIlllllI, float lIlIlIllIIIIll, float lIlIlIlIllllII, float lIlIlIlIlllIll, float lIlIlIllIIIIII, float lIlIlIlIllllll) {
        GL11.glTranslated((double)(lIlIlIlIllllII / 2.0f), (double)(lIlIlIlIlllIll / 2.0f), (double)1.0);
        GL11.glTranslated((double)(-lIlIlIlIlllllI * lIlIlIllIIIIII + lIlIlIlIlllllI + lIlIlIlIllllII / 2.0f * -lIlIlIllIIIIII), (double)(-lIlIlIllIIIIll * lIlIlIlIllllll + lIlIlIllIIIIll + lIlIlIlIlllIll / 2.0f * -lIlIlIlIllllll), (double)1.0);
        GL11.glScaled((double)lIlIlIllIIIIII, (double)lIlIlIlIllllll, (double)0.0);
    }

    public RenderUtils() {
        RenderUtils lIlIllIlIlIllI;
    }

    public static void scissorRect(float lIlIlIllIlllll, float lIlIlIlllIIlII, float lIlIlIllIlllIl, double lIlIlIllIlllII) {
        ScaledResolution lIlIlIlllIIIIl = new ScaledResolution(Minecraft.getMinecraft());
        int lIlIlIlllIIIII = lIlIlIlllIIIIl.getScaleFactor();
        GL11.glScissor((int)((int)(lIlIlIllIlllll * (float)lIlIlIlllIIIII)), (int)((int)(((double)lIlIlIlllIIIIl.getScaledHeight() - lIlIlIllIlllII) * (double)lIlIlIlllIIIII)), (int)((int)((lIlIlIllIlllIl - lIlIlIllIlllll) * (float)lIlIlIlllIIIII)), (int)((int)((lIlIlIllIlllII - (double)lIlIlIlllIIlII) * (double)lIlIlIlllIIIII)));
    }

    public static void drawSelectionBoundingBox(AxisAlignedBB lIlIllIlIIlllI) {
        Tessellator lIlIllIlIlIIII = Tessellator.getInstance();
        BufferBuilder lIlIllIlIIllll = lIlIllIlIlIIII.getBuffer();
        lIlIllIlIIllll.begin(3, DefaultVertexFormats.POSITION);
        lIlIllIlIIllll.pos(lIlIllIlIIlllI.minX, lIlIllIlIIlllI.minY, lIlIllIlIIlllI.minZ).endVertex();
        lIlIllIlIIllll.pos(lIlIllIlIIlllI.maxX, lIlIllIlIIlllI.minY, lIlIllIlIIlllI.minZ).endVertex();
        lIlIllIlIIllll.pos(lIlIllIlIIlllI.maxX, lIlIllIlIIlllI.minY, lIlIllIlIIlllI.maxZ).endVertex();
        lIlIllIlIIllll.pos(lIlIllIlIIlllI.minX, lIlIllIlIIlllI.minY, lIlIllIlIIlllI.maxZ).endVertex();
        lIlIllIlIIllll.pos(lIlIllIlIIlllI.minX, lIlIllIlIIlllI.minY, lIlIllIlIIlllI.minZ).endVertex();
        lIlIllIlIlIIII.draw();
        lIlIllIlIIllll.begin(3, DefaultVertexFormats.POSITION);
        lIlIllIlIIllll.pos(lIlIllIlIIlllI.minX, lIlIllIlIIlllI.maxY, lIlIllIlIIlllI.minZ).endVertex();
        lIlIllIlIIllll.pos(lIlIllIlIIlllI.maxX, lIlIllIlIIlllI.maxY, lIlIllIlIIlllI.minZ).endVertex();
        lIlIllIlIIllll.pos(lIlIllIlIIlllI.maxX, lIlIllIlIIlllI.maxY, lIlIllIlIIlllI.maxZ).endVertex();
        lIlIllIlIIllll.pos(lIlIllIlIIlllI.minX, lIlIllIlIIlllI.maxY, lIlIllIlIIlllI.maxZ).endVertex();
        lIlIllIlIIllll.pos(lIlIllIlIIlllI.minX, lIlIllIlIIlllI.maxY, lIlIllIlIIlllI.minZ).endVertex();
        lIlIllIlIlIIII.draw();
        lIlIllIlIIllll.begin(1, DefaultVertexFormats.POSITION);
        lIlIllIlIIllll.pos(lIlIllIlIIlllI.minX, lIlIllIlIIlllI.minY, lIlIllIlIIlllI.minZ).endVertex();
        lIlIllIlIIllll.pos(lIlIllIlIIlllI.minX, lIlIllIlIIlllI.maxY, lIlIllIlIIlllI.minZ).endVertex();
        lIlIllIlIIllll.pos(lIlIllIlIIlllI.maxX, lIlIllIlIIlllI.minY, lIlIllIlIIlllI.minZ).endVertex();
        lIlIllIlIIllll.pos(lIlIllIlIIlllI.maxX, lIlIllIlIIlllI.maxY, lIlIllIlIIlllI.minZ).endVertex();
        lIlIllIlIIllll.pos(lIlIllIlIIlllI.maxX, lIlIllIlIIlllI.minY, lIlIllIlIIlllI.maxZ).endVertex();
        lIlIllIlIIllll.pos(lIlIllIlIIlllI.maxX, lIlIllIlIIlllI.maxY, lIlIllIlIIlllI.maxZ).endVertex();
        lIlIllIlIIllll.pos(lIlIllIlIIlllI.minX, lIlIllIlIIlllI.minY, lIlIllIlIIlllI.maxZ).endVertex();
        lIlIllIlIIllll.pos(lIlIllIlIIlllI.minX, lIlIllIlIIlllI.maxY, lIlIllIlIIlllI.maxZ).endVertex();
        lIlIllIlIlIIII.draw();
    }
}

