/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  org.lwjgl.opengl.GL11
 */
package ru.internali.utils;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.opengl.GL11;
import ru.internali.utils.Helper;

public class RectHelper
implements Helper {
    public static /* synthetic */ long delta;

    public static void polygon(double llIlIlIIlllIIII, double llIlIlIIlllIlIl, double llIlIlIIlllIlII, double llIlIlIIllIllIl, boolean llIlIlIIllIllII, Color llIlIlIIlllIIIl) {
        llIlIlIIlllIlII /= 2.0;
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2884);
        GlStateManager.disableAlpha();
        GL11.glColor4f((float)((float)llIlIlIIlllIIIl.getRed() / 255.0f), (float)((float)llIlIlIIlllIIIl.getGreen() / 255.0f), (float)((float)llIlIlIIlllIIIl.getBlue() / 255.0f), (float)((float)llIlIlIIlllIIIl.getAlpha() / 255.0f));
        if (!llIlIlIIllIllII) {
            GL11.glLineWidth((float)1.0f);
        }
        GL11.glEnable((int)2848);
        GL11.glBegin((int)(llIlIlIIllIllII ? 6 : 3));
        for (double llIlIlIIlllIlll = 0.0; llIlIlIIlllIlll <= llIlIlIIllIllIl; llIlIlIIlllIlll += 1.0) {
            double llIlIlIIllllIII = llIlIlIIlllIlll * (Math.PI * 2) / llIlIlIIllIllIl;
            GL11.glVertex2d((double)(llIlIlIIlllIIII + llIlIlIIlllIlII * Math.cos(llIlIlIIllllIII) + llIlIlIIlllIlII), (double)(llIlIlIIlllIlIl + llIlIlIIlllIlII * Math.sin(llIlIlIIllllIII) + llIlIlIIlllIlII));
        }
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glEnd();
        GL11.glDisable((int)2848);
        GlStateManager.enableAlpha();
        GL11.glEnable((int)2884);
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
    }

    static {
        delta = 0L;
    }

    public static void drawSmoothRect(float llIlIIlllllllII, float llIlIIllllllIll, float llIlIIlllllIlIl, float llIlIIllllllIIl, int llIlIIllllllIII) {
        GL11.glEnable((int)3042);
        GL11.glEnable((int)2848);
        RectHelper.drawRect(llIlIIlllllllII, llIlIIllllllIll, llIlIIlllllIlIl, llIlIIllllllIIl, llIlIIllllllIII);
        GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
        RectHelper.drawRect(llIlIIlllllllII * 2.0f - 1.0f, llIlIIllllllIll * 2.0f, llIlIIlllllllII * 2.0f, llIlIIllllllIIl * 2.0f - 1.0f, llIlIIllllllIII);
        RectHelper.drawRect(llIlIIlllllllII * 2.0f, llIlIIllllllIll * 2.0f - 1.0f, llIlIIlllllIlIl * 2.0f, llIlIIllllllIll * 2.0f, llIlIIllllllIII);
        RectHelper.drawRect(llIlIIlllllIlIl * 2.0f, llIlIIllllllIll * 2.0f, llIlIIlllllIlIl * 2.0f + 1.0f, llIlIIllllllIIl * 2.0f - 1.0f, llIlIIllllllIII);
        RectHelper.drawRect(llIlIIlllllllII * 2.0f, llIlIIllllllIIl * 2.0f - 1.0f, llIlIIlllllIlIl * 2.0f, llIlIIllllllIIl * 2.0f, llIlIIllllllIII);
        GL11.glDisable((int)2848);
        GL11.glDisable((int)3042);
        GL11.glScalef((float)2.0f, (float)2.0f, (float)2.0f);
    }

    @Override
    public Minecraft mc() {
        return null;
    }

    public static void drawGradientRectBetter(float llIlIlIIlIlIIll, float llIlIlIIlIIllII, float llIlIlIIlIlIIIl, float llIlIlIIlIlIIII, int llIlIlIIlIIllll, int llIlIlIIlIIlIII) {
        RectHelper.drawGradientRect(llIlIlIIlIlIIll, llIlIlIIlIIllII, llIlIlIIlIlIIll + llIlIlIIlIlIIIl, llIlIlIIlIIllII + llIlIlIIlIlIIII, llIlIlIIlIIllll, llIlIlIIlIIlIII);
    }

    public static void drawMinecraftRect(int llIlIlIlIllIIll, int llIlIlIlIllIIlI, int llIlIlIllIIIIIl, int llIlIlIllIIIIII, int llIlIlIlIllllll, int llIlIlIlIlIlllI) {
        float llIlIlIlIllllIl = (float)(llIlIlIlIllllll >> 24 & 0xFF) / 255.0f;
        float llIlIlIlIllllII = (float)(llIlIlIlIllllll >> 16 & 0xFF) / 255.0f;
        float llIlIlIlIlllIll = (float)(llIlIlIlIllllll >> 8 & 0xFF) / 255.0f;
        float llIlIlIlIlllIlI = (float)(llIlIlIlIllllll & 0xFF) / 255.0f;
        float llIlIlIlIlllIIl = (float)(llIlIlIlIlIlllI >> 24 & 0xFF) / 255.0f;
        float llIlIlIlIlllIII = (float)(llIlIlIlIlIlllI >> 16 & 0xFF) / 255.0f;
        float llIlIlIlIllIlll = (float)(llIlIlIlIlIlllI >> 8 & 0xFF) / 255.0f;
        float llIlIlIlIllIllI = (float)(llIlIlIlIlIlllI & 0xFF) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int)7425);
        Tessellator llIlIlIlIllIlIl = Tessellator.getInstance();
        BufferBuilder llIlIlIlIllIlII = llIlIlIlIllIlIl.getBuffer();
        llIlIlIlIllIlII.begin(7, DefaultVertexFormats.POSITION_COLOR);
        llIlIlIlIllIlII.pos((double)llIlIlIllIIIIIl, (double)llIlIlIlIllIIlI, 300.0).color(llIlIlIlIllllII, llIlIlIlIlllIll, llIlIlIlIlllIlI, llIlIlIlIllllIl).endVertex();
        llIlIlIlIllIlII.pos((double)llIlIlIlIllIIll, (double)llIlIlIlIllIIlI, 300.0).color(llIlIlIlIllllII, llIlIlIlIlllIll, llIlIlIlIlllIlI, llIlIlIlIllllIl).endVertex();
        llIlIlIlIllIlII.pos((double)llIlIlIlIllIIll, (double)llIlIlIllIIIIII, 300.0).color(llIlIlIlIlllIII, llIlIlIlIllIlll, llIlIlIlIllIllI, llIlIlIlIlllIIl).endVertex();
        llIlIlIlIllIlII.pos((double)llIlIlIllIIIIIl, (double)llIlIlIllIIIIII, 300.0).color(llIlIlIlIlllIII, llIlIlIlIllIlll, llIlIlIlIllIllI, llIlIlIlIlllIIl).endVertex();
        llIlIlIlIllIlIl.draw();
        GlStateManager.shadeModel((int)7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    public static void drawRectBetter(double llIlIlIIlIllllI, double llIlIlIIlIlllIl, double llIlIlIIlIlllII, double llIlIlIIllIIIII, int llIlIlIIlIllIlI) {
        RectHelper.drawRect(llIlIlIIlIllllI, llIlIlIIlIlllIl, llIlIlIIlIllllI + llIlIlIIlIlllII, llIlIlIIlIlllIl + llIlIlIIllIIIII, llIlIlIIlIllIlI);
    }

    public RectHelper() {
        RectHelper llIlIlIllllIIlI;
    }

    public static void drawSmoothGradientRect(double llIlIlIIIlllIll, double llIlIlIIlIIIIII, double llIlIlIIIlllIIl, double llIlIlIIIlllllI, int llIlIlIIIllIlll, int llIlIlIIIllIllI) {
        GL11.glEnable((int)3042);
        GL11.glEnable((int)2848);
        RectHelper.drawGradientRect(llIlIlIIIlllIll, llIlIlIIlIIIIII, llIlIlIIIlllIIl, llIlIlIIIlllllI, llIlIlIIIllIlll, llIlIlIIIllIllI);
        GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
        RectHelper.drawGradientRect(llIlIlIIIlllIll * 2.0 - 1.0, llIlIlIIlIIIIII * 2.0, llIlIlIIIlllIll * 2.0, llIlIlIIIlllllI * 2.0 - 1.0, llIlIlIIIllIlll, llIlIlIIIllIllI);
        RectHelper.drawGradientRect(llIlIlIIIlllIll * 2.0, llIlIlIIlIIIIII * 2.0 - 1.0, llIlIlIIIlllIIl * 2.0, llIlIlIIlIIIIII * 2.0, llIlIlIIIllIlll, llIlIlIIIllIllI);
        RectHelper.drawGradientRect(llIlIlIIIlllIIl * 2.0, llIlIlIIlIIIIII * 2.0, llIlIlIIIlllIIl * 2.0 + 1.0, llIlIlIIIlllllI * 2.0 - 1.0, llIlIlIIIllIlll, llIlIlIIIllIllI);
        RectHelper.drawGradientRect(llIlIlIIIlllIll * 2.0, llIlIlIIIlllllI * 2.0 - 1.0, llIlIlIIIlllIIl * 2.0, llIlIlIIIlllllI * 2.0, llIlIlIIIllIlll, llIlIlIIIllIllI);
        GL11.glDisable((int)2848);
        GL11.glDisable((int)3042);
        GL11.glScalef((float)2.0f, (float)2.0f, (float)2.0f);
    }

    public static void drawRoundedRect(double llIlIlIlllIIlll, double llIlIlIlllIIllI, double llIlIlIllIllIll, double llIlIlIllIllIlI, float llIlIlIlllIIIll, Color llIlIlIllIllIII) {
        float llIlIlIlllIIIIl = (float)(llIlIlIlllIIlll + (double)(llIlIlIlllIIIll / 2.0f + 0.5f));
        float llIlIlIlllIIIII = (float)(llIlIlIlllIIllI + (double)(llIlIlIlllIIIll / 2.0f + 0.5f));
        float llIlIlIllIlllll = (float)(llIlIlIllIllIll - (double)(llIlIlIlllIIIll / 2.0f + 0.5f));
        float llIlIlIllIllllI = (float)(llIlIlIllIllIlI - (double)(llIlIlIlllIIIll / 2.0f + 0.5f));
        RectHelper.drawRect(llIlIlIlllIIIIl, llIlIlIlllIIIII, llIlIlIlllIIIIl + llIlIlIllIlllll, llIlIlIlllIIIII + llIlIlIllIllllI, llIlIlIllIllIII.getRGB());
        RectHelper.polygon(llIlIlIlllIIlll, llIlIlIlllIIllI, llIlIlIlllIIIll * 2.0f, 360.0, true, llIlIlIllIllIII);
        RectHelper.polygon(llIlIlIlllIIlll + (double)llIlIlIllIlllll - (double)llIlIlIlllIIIll + 1.2, llIlIlIlllIIllI, llIlIlIlllIIIll * 2.0f, 360.0, true, llIlIlIllIllIII);
        RectHelper.polygon(llIlIlIlllIIlll + (double)llIlIlIllIlllll - (double)llIlIlIlllIIIll + 1.2, llIlIlIlllIIllI + (double)llIlIlIllIllllI - (double)llIlIlIlllIIIll + 1.0, llIlIlIlllIIIll * 2.0f, 360.0, true, llIlIlIllIllIII);
        RectHelper.polygon(llIlIlIlllIIlll, llIlIlIlllIIllI + (double)llIlIlIllIllllI - (double)llIlIlIlllIIIll + 1.0, llIlIlIlllIIIll * 2.0f, 360.0, true, llIlIlIllIllIII);
        GL11.glColor4f((float)((float)llIlIlIllIllIII.getRed() / 255.0f), (float)((float)llIlIlIllIllIII.getGreen() / 255.0f), (float)((float)llIlIlIllIllIII.getBlue() / 255.0f), (float)((float)llIlIlIllIllIII.getAlpha() / 255.0f));
        RectHelper.drawRect(llIlIlIlllIIIIl - llIlIlIlllIIIll / 2.0f - 0.5f, llIlIlIlllIIIII + llIlIlIlllIIIll / 2.0f, llIlIlIlllIIIIl + llIlIlIllIlllll, llIlIlIlllIIIII + llIlIlIllIllllI - llIlIlIlllIIIll / 2.0f, llIlIlIllIllIII.getRGB());
        RectHelper.drawRect(llIlIlIlllIIIIl, llIlIlIlllIIIII + llIlIlIlllIIIll / 2.0f, llIlIlIlllIIIIl + llIlIlIllIlllll + llIlIlIlllIIIll / 2.0f + 0.5f, llIlIlIlllIIIII + llIlIlIllIllllI - llIlIlIlllIIIll / 2.0f, llIlIlIllIllIII.getRGB());
        RectHelper.drawRect(llIlIlIlllIIIIl + llIlIlIlllIIIll / 2.0f, llIlIlIlllIIIII - llIlIlIlllIIIll / 2.0f - 0.5f, llIlIlIlllIIIIl + llIlIlIllIlllll - llIlIlIlllIIIll / 2.0f, llIlIlIlllIIllI + (double)llIlIlIllIllllI - (double)(llIlIlIlllIIIll / 2.0f), llIlIlIllIllIII.getRGB());
        RectHelper.drawRect(llIlIlIlllIIIIl + llIlIlIlllIIIll / 2.0f, llIlIlIlllIIIII, llIlIlIlllIIIIl + llIlIlIllIlllll - llIlIlIlllIIIll / 2.0f, llIlIlIlllIIIII + llIlIlIllIllllI + llIlIlIlllIIIll / 2.0f + 0.5f, llIlIlIllIllIII.getRGB());
    }

    public static void drawRect(double llIlIlIIIIIllIl, double llIlIlIIIIlIlll, double llIlIlIIIIlIllI, double llIlIlIIIIIlIIl, int llIlIlIIIIlIlII) {
        if (llIlIlIIIIIllIl < llIlIlIIIIlIllI) {
            double llIlIlIIIIllIlI = llIlIlIIIIIllIl;
            llIlIlIIIIIllIl = llIlIlIIIIlIllI;
            llIlIlIIIIlIllI = llIlIlIIIIllIlI;
        }
        if (llIlIlIIIIlIlll < llIlIlIIIIIlIIl) {
            double llIlIlIIIIllIIl = llIlIlIIIIlIlll;
            llIlIlIIIIlIlll = llIlIlIIIIIlIIl;
            llIlIlIIIIIlIIl = llIlIlIIIIllIIl;
        }
        float llIlIlIIIIlIIll = (float)(llIlIlIIIIlIlII >> 24 & 0xFF) / 255.0f;
        float llIlIlIIIIlIIlI = (float)(llIlIlIIIIlIlII >> 16 & 0xFF) / 255.0f;
        float llIlIlIIIIlIIIl = (float)(llIlIlIIIIlIlII >> 8 & 0xFF) / 255.0f;
        float llIlIlIIIIlIIII = (float)(llIlIlIIIIlIlII & 0xFF) / 255.0f;
        Tessellator llIlIlIIIIIllll = Tessellator.getInstance();
        BufferBuilder llIlIlIIIIIlllI = llIlIlIIIIIllll.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.color((float)llIlIlIIIIlIIlI, (float)llIlIlIIIIlIIIl, (float)llIlIlIIIIlIIII, (float)llIlIlIIIIlIIll);
        llIlIlIIIIIlllI.begin(7, DefaultVertexFormats.POSITION);
        llIlIlIIIIIlllI.pos(llIlIlIIIIIllIl, llIlIlIIIIIlIIl, 0.0).endVertex();
        llIlIlIIIIIlllI.pos(llIlIlIIIIlIllI, llIlIlIIIIIlIIl, 0.0).endVertex();
        llIlIlIIIIIlllI.pos(llIlIlIIIIlIllI, llIlIlIIIIlIlll, 0.0).endVertex();
        llIlIlIIIIIlllI.pos(llIlIlIIIIIllIl, llIlIlIIIIlIlll, 0.0).endVertex();
        llIlIlIIIIIllll.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void drawBorderedRect(float llIlIIllIlIlIlI, float llIlIIllIlIlIIl, float llIlIIllIlIIIII, float llIlIIllIIlllll, float llIlIIllIlIIllI, int llIlIIllIlIIlIl, int llIlIIllIIlllII, boolean llIlIIllIlIIIll) {
        RectHelper.drawRect(llIlIIllIlIlIlI - (!llIlIIllIlIIIll ? llIlIIllIlIIllI : 0.0f), llIlIIllIlIlIIl - (!llIlIIllIlIIIll ? llIlIIllIlIIllI : 0.0f), llIlIIllIlIIIII + (!llIlIIllIlIIIll ? llIlIIllIlIIllI : 0.0f), llIlIIllIIlllll + (!llIlIIllIlIIIll ? llIlIIllIlIIllI : 0.0f), llIlIIllIIlllII);
        RectHelper.drawRect(llIlIIllIlIlIlI + (llIlIIllIlIIIll ? llIlIIllIlIIllI : 0.0f), llIlIIllIlIlIIl + (llIlIIllIlIIIll ? llIlIIllIlIIllI : 0.0f), llIlIIllIlIIIII - (llIlIIllIlIIIll ? llIlIIllIlIIllI : 0.0f), llIlIIllIIlllll - (llIlIIllIlIIIll ? llIlIIllIlIIllI : 0.0f), llIlIIllIlIIlIl);
    }

    public static void drawGradientRect(double llIlIIllllIIllI, double llIlIIllllIIlIl, double llIlIIllllIIlII, double llIlIIllllIIIll, int llIlIIllllIIIlI, int llIlIIllllIIIIl) {
        float llIlIIllllIIIII = (float)(llIlIIllllIIIlI >> 24 & 0xFF) / 255.0f;
        float llIlIIlllIlllll = (float)(llIlIIllllIIIlI >> 16 & 0xFF) / 255.0f;
        float llIlIIlllIllllI = (float)(llIlIIllllIIIlI >> 8 & 0xFF) / 255.0f;
        float llIlIIlllIlllIl = (float)(llIlIIllllIIIlI & 0xFF) / 255.0f;
        float llIlIIlllIlllII = (float)(llIlIIllllIIIIl >> 24 & 0xFF) / 255.0f;
        float llIlIIlllIllIll = (float)(llIlIIllllIIIIl >> 16 & 0xFF) / 255.0f;
        float llIlIIlllIllIlI = (float)(llIlIIllllIIIIl >> 8 & 0xFF) / 255.0f;
        float llIlIIlllIllIIl = (float)(llIlIIllllIIIIl & 0xFF) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int)7425);
        Tessellator llIlIIlllIllIII = Tessellator.getInstance();
        BufferBuilder llIlIIlllIlIlll = llIlIIlllIllIII.getBuffer();
        llIlIIlllIlIlll.begin(7, DefaultVertexFormats.POSITION_COLOR);
        llIlIIlllIllIII.draw();
        GlStateManager.shadeModel((int)7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    public static void drawSmoothRectBetter(float llIlIlIIIllIIII, float llIlIlIIIlIllll, float llIlIlIIIlIlIIl, float llIlIlIIIlIlIII, int llIlIlIIIlIllII) {
        RectHelper.drawSmoothRect(llIlIlIIIllIIII, llIlIlIIIlIllll, llIlIlIIIllIIII + llIlIlIIIlIlIIl, llIlIlIIIlIllll + llIlIlIIIlIlIII, llIlIlIIIlIllII);
    }

    public static void drawRect2(double llIlIlIlIIIlIll, double llIlIlIlIIIlIlI, double llIlIlIlIIIlIIl, double llIlIlIlIIlIIll, int llIlIlIlIIIIlll) {
        if (llIlIlIlIIIlIll < llIlIlIlIIIlIIl) {
            double llIlIlIlIIllIII = llIlIlIlIIIlIll;
            llIlIlIlIIIlIll = llIlIlIlIIIlIIl;
            llIlIlIlIIIlIIl = llIlIlIlIIllIII;
        }
        if (llIlIlIlIIIlIlI < llIlIlIlIIlIIll) {
            double llIlIlIlIIlIlll = llIlIlIlIIIlIlI;
            llIlIlIlIIIlIlI = llIlIlIlIIlIIll;
            llIlIlIlIIlIIll = llIlIlIlIIlIlll;
        }
        float llIlIlIlIIlIIIl = (float)(llIlIlIlIIIIlll >> 24 & 0xFF) / 255.0f;
        float llIlIlIlIIlIIII = (float)(llIlIlIlIIIIlll >> 16 & 0xFF) / 255.0f;
        float llIlIlIlIIIllll = (float)(llIlIlIlIIIIlll >> 8 & 0xFF) / 255.0f;
        float llIlIlIlIIIlllI = (float)(llIlIlIlIIIIlll & 0xFF) / 255.0f;
        Tessellator llIlIlIlIIIllIl = Tessellator.getInstance();
        BufferBuilder llIlIlIlIIIllII = llIlIlIlIIIllIl.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.color((float)llIlIlIlIIlIIII, (float)llIlIlIlIIIllll, (float)llIlIlIlIIIlllI, (float)llIlIlIlIIlIIIl);
        llIlIlIlIIIllII.begin(7, DefaultVertexFormats.POSITION);
        llIlIlIlIIIllII.pos(llIlIlIlIIIlIll, llIlIlIlIIlIIll, 0.0).endVertex();
        llIlIlIlIIIllII.pos(llIlIlIlIIIlIIl, llIlIlIlIIlIIll, 0.0).endVertex();
        llIlIlIlIIIllII.pos(llIlIlIlIIIlIIl, llIlIlIlIIIlIlI, 0.0).endVertex();
        llIlIlIlIIIllII.pos(llIlIlIlIIIlIll, llIlIlIlIIIlIlI, 0.0).endVertex();
        llIlIlIlIIIllIl.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void drawOutlineRect(float llIlIIlIllllIll, float llIlIIlIlllIIll, float llIlIIlIlllIIlI, float llIlIIlIllllIII, Color llIlIIlIlllIIII, Color llIlIIlIlllIllI) {
        RectHelper.drawRect(llIlIIlIllllIll, llIlIIlIlllIIll, llIlIIlIllllIll + llIlIIlIlllIIlI, llIlIIlIlllIIll + llIlIIlIllllIII, llIlIIlIlllIIII.getRGB());
        int llIlIIlIlllIlIl = llIlIIlIlllIllI.getRGB();
        RectHelper.drawRect(llIlIIlIllllIll - 1.0f, llIlIIlIlllIIll, llIlIIlIllllIll, llIlIIlIlllIIll + llIlIIlIllllIII, llIlIIlIlllIlIl);
        RectHelper.drawRect(llIlIIlIllllIll + llIlIIlIlllIIlI, llIlIIlIlllIIll, llIlIIlIllllIll + llIlIIlIlllIIlI + 1.0f, llIlIIlIlllIIll + llIlIIlIllllIII, llIlIIlIlllIlIl);
        RectHelper.drawRect(llIlIIlIllllIll - 1.0f, llIlIIlIlllIIll - 1.0f, llIlIIlIllllIll + llIlIIlIlllIIlI + 1.0f, llIlIIlIlllIIll, llIlIIlIlllIlIl);
        RectHelper.drawRect(llIlIIlIllllIll - 1.0f, llIlIIlIlllIIll + llIlIIlIllllIII, llIlIIlIllllIll + llIlIIlIlllIIlI + 1.0f, llIlIIlIlllIIll + llIlIIlIllllIII + 1.0f, llIlIIlIlllIlIl);
    }

    public static void drawSkeetRectWithoutBorder(float llIlIIlllIIIIlI, float llIlIIlllIIIlIl, float llIlIIlllIIIlII, float llIlIIllIllllll) {
        RectHelper.drawSmoothRect(llIlIIlllIIIIlI - 41.0f, llIlIIlllIIIlIl - 61.0f, llIlIIlllIIIlII + 41.0f, llIlIIllIllllll + 61.0f, new Color(48, 48, 48, 255).getRGB());
        RectHelper.drawSmoothRect(llIlIIlllIIIIlI - 40.0f, llIlIIlllIIIlIl - 60.0f, llIlIIlllIIIlII + 40.0f, llIlIIllIllllll + 60.0f, new Color(17, 17, 17, 255).getRGB());
    }

    public static void drawBorder(float llIlIIllIIlIIlI, float llIlIIllIIIlIIl, float llIlIIllIIlIIII, float llIlIIllIIIIlll, float llIlIIllIIIIllI, int llIlIIllIIIllIl, int llIlIIllIIIllII, boolean llIlIIllIIIlIll) {
        RectHelper.drawRect(llIlIIllIIlIIlI - (!llIlIIllIIIlIll ? llIlIIllIIIIllI : 0.0f), llIlIIllIIIlIIl - (!llIlIIllIIIlIll ? llIlIIllIIIIllI : 0.0f), llIlIIllIIlIIII + (!llIlIIllIIIlIll ? llIlIIllIIIIllI : 0.0f), llIlIIllIIIIlll + (!llIlIIllIIIlIll ? llIlIIllIIIIllI : 0.0f), llIlIIllIIIllII);
        RectHelper.drawRect(llIlIIllIIlIIlI + (llIlIIllIIIlIll ? llIlIIllIIIIllI : 0.0f), llIlIIllIIIlIIl + (llIlIIllIIIlIll ? llIlIIllIIIIllI : 0.0f), llIlIIllIIlIIII - (llIlIIllIIIlIll ? llIlIIllIIIIllI : 0.0f), llIlIIllIIIIlll - (llIlIIllIIIlIll ? llIlIIllIIIIllI : 0.0f), llIlIIllIIIllIl);
    }

    public static void drawSkeetRect(float llIlIIllIlllIlI, float llIlIIllIlllIIl, float llIlIIllIllIlII, float llIlIIllIllIlll) {
        RectHelper.drawRect(llIlIIllIlllIlI - 46.5f, llIlIIllIlllIIl - 66.5f, llIlIIllIllIlII + 46.5f, llIlIIllIllIlll + 66.5f, new Color(0, 0, 0, 255).getRGB());
        RectHelper.drawRect(llIlIIllIlllIlI - 46.0f, llIlIIllIlllIIl - 66.0f, llIlIIllIllIlII + 46.0f, llIlIIllIllIlll + 66.0f, new Color(48, 48, 48, 255).getRGB());
        RectHelper.drawRect(llIlIIllIlllIlI - 44.5f, llIlIIllIlllIIl - 64.5f, llIlIIllIllIlII + 44.5f, llIlIIllIllIlll + 64.5f, new Color(33, 33, 33, 255).getRGB());
        RectHelper.drawRect(llIlIIllIlllIlI - 43.5f, llIlIIllIlllIIl - 63.5f, llIlIIllIllIlII + 43.5f, llIlIIllIllIlll + 63.5f, new Color(0, 0, 0, 255).getRGB());
        RectHelper.drawRect(llIlIIllIlllIlI - 43.0f, llIlIIllIlllIIl - 63.0f, llIlIIllIllIlII + 43.0f, llIlIIllIllIlll + 63.0f, new Color(9, 9, 9, 255).getRGB());
        RectHelper.drawRect(llIlIIllIlllIlI - 40.5f, llIlIIllIlllIIl - 60.5f, llIlIIllIllIlII + 40.5f, llIlIIllIllIlll + 60.5f, new Color(48, 48, 48, 255).getRGB());
        RectHelper.drawRect(llIlIIllIlllIlI - 40.0f, llIlIIllIlllIIl - 60.0f, llIlIIllIllIlII + 40.0f, llIlIIllIllIlll + 60.0f, new Color(17, 17, 17, 255).getRGB());
    }
}

