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
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  org.lwjgl.opengl.GL11
 */
package ru.internali.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

public class NordTessellator
extends Tessellator {
    public static /* synthetic */ NordTessellator INSTANCE;

    public static void drawBox(double lIIIIIllIIllllI, double lIIIIIllIIlIlII, double lIIIIIllIIlllII, int lIIIIIllIIllIll, int lIIIIIllIIlIIIl) {
        int lIIIIIllIIllIIl = lIIIIIllIIllIll >>> 24 & 0xFF;
        int lIIIIIllIIllIII = lIIIIIllIIllIll >>> 16 & 0xFF;
        int lIIIIIllIIlIlll = lIIIIIllIIllIll >>> 8 & 0xFF;
        int lIIIIIllIIlIllI = lIIIIIllIIllIll & 0xFF;
        NordTessellator.drawBox(INSTANCE.getBuffer(), lIIIIIllIIllllI, lIIIIIllIIlIlII, lIIIIIllIIlllII, 1.0f, 1.0f, 1.0f, lIIIIIllIIllIII, lIIIIIllIIlIlll, lIIIIIllIIlIllI, lIIIIIllIIllIIl, lIIIIIllIIlIIIl);
    }

    public static Vec3d getInterpolatedAmount(Entity lllllIIllIIllI, double lllllIIllIIlIl, double lllllIIllIIIII, double lllllIIlIlllll) {
        return new Vec3d((lllllIIllIIllI.posX - lllllIIllIIllI.lastTickPosX) * lllllIIllIIlIl, (lllllIIllIIllI.posY - lllllIIllIIllI.lastTickPosY) * lllllIIllIIIII, (lllllIIllIIllI.posZ - lllllIIllIIllI.lastTickPosZ) * lllllIIlIlllll);
    }

    public static void drawRectangle(float lIIIIIlIIIIllII, float lIIIIIlIIIIlIll, float lIIIIIIllllllll, float lIIIIIIlllllllI, int lIIIIIIllllllIl) {
        float lIIIIIlIIIIIlll = (float)(lIIIIIIllllllIl >> 16 & 0xFF) / 255.0f;
        float lIIIIIlIIIIIllI = (float)(lIIIIIIllllllIl >> 8 & 0xFF) / 255.0f;
        float lIIIIIlIIIIIlIl = (float)(lIIIIIIllllllIl & 0xFF) / 255.0f;
        float lIIIIIlIIIIIlII = (float)(lIIIIIIllllllIl >> 24 & 0xFF) / 255.0f;
        Tessellator lIIIIIlIIIIIIll = Tessellator.getInstance();
        BufferBuilder lIIIIIlIIIIIIlI = lIIIIIlIIIIIIll.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        lIIIIIlIIIIIIlI.begin(7, DefaultVertexFormats.POSITION_COLOR);
        lIIIIIlIIIIIIlI.pos((double)lIIIIIlIIIIllII, (double)lIIIIIIlllllllI, 0.0).color(lIIIIIlIIIIIlll, lIIIIIlIIIIIllI, lIIIIIlIIIIIlIl, lIIIIIlIIIIIlII).endVertex();
        lIIIIIlIIIIIIlI.pos((double)lIIIIIIllllllll, (double)lIIIIIIlllllllI, 0.0).color(lIIIIIlIIIIIlll, lIIIIIlIIIIIllI, lIIIIIlIIIIIlIl, lIIIIIlIIIIIlII).endVertex();
        lIIIIIlIIIIIIlI.pos((double)lIIIIIIllllllll, (double)lIIIIIlIIIIlIll, 0.0).color(lIIIIIlIIIIIlll, lIIIIIlIIIIIllI, lIIIIIlIIIIIlIl, lIIIIIlIIIIIlII).endVertex();
        lIIIIIlIIIIIIlI.pos((double)lIIIIIlIIIIllII, (double)lIIIIIlIIIIlIll, 0.0).color(lIIIIIlIIIIIlll, lIIIIIlIIIIIllI, lIIIIIlIIIIIlIl, lIIIIIlIIIIIlII).endVertex();
        lIIIIIlIIIIIIll.draw();
        GlStateManager.disableBlend();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void drawBoundingBoxFace(AxisAlignedBB llllllIIIIllII, float llllllIIIlIIll, int llllllIIIIlIlI, int llllllIIIlIIIl, int llllllIIIIlIII, int llllllIIIIIlll) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glLineWidth((float)llllllIIIlIIll);
        Tessellator llllllIIIIlllI = Tessellator.getInstance();
        BufferBuilder llllllIIIIllIl = llllllIIIIlllI.getBuffer();
        llllllIIIIllIl.begin(3, DefaultVertexFormats.POSITION_COLOR);
        llllllIIIIllIl.pos(llllllIIIIllII.minX, llllllIIIIllII.minY, llllllIIIIllII.minZ).color(llllllIIIIlIlI, llllllIIIlIIIl, llllllIIIIlIII, llllllIIIIIlll).endVertex();
        llllllIIIIllIl.pos(llllllIIIIllII.minX, llllllIIIIllII.minY, llllllIIIIllII.maxZ).color(llllllIIIIlIlI, llllllIIIlIIIl, llllllIIIIlIII, llllllIIIIIlll).endVertex();
        llllllIIIIllIl.pos(llllllIIIIllII.maxX, llllllIIIIllII.minY, llllllIIIIllII.maxZ).color(llllllIIIIlIlI, llllllIIIlIIIl, llllllIIIIlIII, llllllIIIIIlll).endVertex();
        llllllIIIIllIl.pos(llllllIIIIllII.maxX, llllllIIIIllII.minY, llllllIIIIllII.minZ).color(llllllIIIIlIlI, llllllIIIlIIIl, llllllIIIIlIII, llllllIIIIIlll).endVertex();
        llllllIIIIllIl.pos(llllllIIIIllII.minX, llllllIIIIllII.minY, llllllIIIIllII.minZ).color(llllllIIIIlIlI, llllllIIIlIIIl, llllllIIIIlIII, llllllIIIIIlll).endVertex();
        llllllIIIIlllI.draw();
        GL11.glDisable((int)2848);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void drawBorderedRect(double lllllIIlIlIlll, double lllllIIlIlIllI, double lllllIIlIIlllI, double lllllIIlIlIlII, double lllllIIlIlIIll, int lllllIIlIlIIlI, int lllllIIlIIlIlI) {
        NordTessellator.enableGL2D();
        NordTessellator.fakeGuiRect(lllllIIlIlIlll + lllllIIlIlIIll, lllllIIlIlIllI + lllllIIlIlIIll, lllllIIlIIlllI - lllllIIlIlIIll, lllllIIlIlIlII - lllllIIlIlIIll, lllllIIlIlIIlI);
        NordTessellator.fakeGuiRect(lllllIIlIlIlll + lllllIIlIlIIll, lllllIIlIlIllI, lllllIIlIIlllI - lllllIIlIlIIll, lllllIIlIlIllI + lllllIIlIlIIll, lllllIIlIIlIlI);
        NordTessellator.fakeGuiRect(lllllIIlIlIlll, lllllIIlIlIllI, lllllIIlIlIlll + lllllIIlIlIIll, lllllIIlIlIlII, lllllIIlIIlIlI);
        NordTessellator.fakeGuiRect(lllllIIlIIlllI - lllllIIlIlIIll, lllllIIlIlIllI, lllllIIlIIlllI, lllllIIlIlIlII, lllllIIlIIlIlI);
        NordTessellator.fakeGuiRect(lllllIIlIlIlll + lllllIIlIlIIll, lllllIIlIlIlII - lllllIIlIlIIll, lllllIIlIIlllI - lllllIIlIlIIll, lllllIIlIlIlII, lllllIIlIIlIlI);
        NordTessellator.disableGL2D();
    }

    public static void drawBoundingBoxBlockPosHalf(BlockPos lllllllIllIIIl, float lllllllIllIIII, int lllllllIlIllll, int lllllllIlIIIIl, int lllllllIlIIIII, int lllllllIIlllll) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glLineWidth((float)lllllllIllIIII);
        Minecraft lllllllIlIlIll = Minecraft.getMinecraft();
        double lllllllIlIlIlI = (double)lllllllIllIIIl.func_177958_n() - lllllllIlIlIll.getRenderManager().viewerPosX;
        double lllllllIlIlIIl = (double)lllllllIllIIIl.func_177956_o() - lllllllIlIlIll.getRenderManager().viewerPosY;
        double lllllllIlIlIII = (double)lllllllIllIIIl.func_177952_p() - lllllllIlIlIll.getRenderManager().viewerPosZ;
        AxisAlignedBB lllllllIlIIlll = new AxisAlignedBB(lllllllIlIlIlI, lllllllIlIlIIl, lllllllIlIlIII, lllllllIlIlIlI + 1.0, lllllllIlIlIIl + 0.5, lllllllIlIlIII + 1.0);
        Tessellator lllllllIlIIllI = Tessellator.getInstance();
        BufferBuilder lllllllIlIIlIl = lllllllIlIIllI.getBuffer();
        lllllllIlIIlIl.begin(3, DefaultVertexFormats.POSITION_COLOR);
        lllllllIlIIlIl.pos(lllllllIlIIlll.minX, lllllllIlIIlll.minY, lllllllIlIIlll.minZ).color(lllllllIlIllll, lllllllIlIIIIl, lllllllIlIIIII, lllllllIIlllll).endVertex();
        lllllllIlIIlIl.pos(lllllllIlIIlll.maxX, lllllllIlIIlll.minY, lllllllIlIIlll.minZ).color(lllllllIlIllll, lllllllIlIIIIl, lllllllIlIIIII, lllllllIIlllll).endVertex();
        lllllllIlIIlIl.pos(lllllllIlIIlll.maxX, lllllllIlIIlll.minY, lllllllIlIIlll.maxZ).color(lllllllIlIllll, lllllllIlIIIIl, lllllllIlIIIII, lllllllIIlllll).endVertex();
        lllllllIlIIlIl.pos(lllllllIlIIlll.minX, lllllllIlIIlll.minY, lllllllIlIIlll.maxZ).color(lllllllIlIllll, lllllllIlIIIIl, lllllllIlIIIII, lllllllIIlllll).endVertex();
        lllllllIlIIlIl.pos(lllllllIlIIlll.minX, lllllllIlIIlll.minY, lllllllIlIIlll.minZ).color(lllllllIlIllll, lllllllIlIIIIl, lllllllIlIIIII, lllllllIIlllll).endVertex();
        lllllllIlIIllI.draw();
        lllllllIlIIlIl.begin(3, DefaultVertexFormats.POSITION_COLOR);
        lllllllIlIIlIl.pos(lllllllIlIIlll.minX, lllllllIlIIlll.maxY, lllllllIlIIlll.minZ).color(lllllllIlIllll, lllllllIlIIIIl, lllllllIlIIIII, lllllllIIlllll).endVertex();
        lllllllIlIIlIl.pos(lllllllIlIIlll.maxX, lllllllIlIIlll.maxY, lllllllIlIIlll.minZ).color(lllllllIlIllll, lllllllIlIIIIl, lllllllIlIIIII, lllllllIIlllll).endVertex();
        lllllllIlIIlIl.pos(lllllllIlIIlll.maxX, lllllllIlIIlll.maxY, lllllllIlIIlll.maxZ).color(lllllllIlIllll, lllllllIlIIIIl, lllllllIlIIIII, lllllllIIlllll).endVertex();
        lllllllIlIIlIl.pos(lllllllIlIIlll.minX, lllllllIlIIlll.maxY, lllllllIlIIlll.maxZ).color(lllllllIlIllll, lllllllIlIIIIl, lllllllIlIIIII, lllllllIIlllll).endVertex();
        lllllllIlIIlIl.pos(lllllllIlIIlll.minX, lllllllIlIIlll.maxY, lllllllIlIIlll.minZ).color(lllllllIlIllll, lllllllIlIIIIl, lllllllIlIIIII, lllllllIIlllll).endVertex();
        lllllllIlIIllI.draw();
        lllllllIlIIlIl.begin(1, DefaultVertexFormats.POSITION_COLOR);
        lllllllIlIIlIl.pos(lllllllIlIIlll.minX, lllllllIlIIlll.minY, lllllllIlIIlll.minZ).color(lllllllIlIllll, lllllllIlIIIIl, lllllllIlIIIII, lllllllIIlllll).endVertex();
        lllllllIlIIlIl.pos(lllllllIlIIlll.minX, lllllllIlIIlll.maxY, lllllllIlIIlll.minZ).color(lllllllIlIllll, lllllllIlIIIIl, lllllllIlIIIII, lllllllIIlllll).endVertex();
        lllllllIlIIlIl.pos(lllllllIlIIlll.maxX, lllllllIlIIlll.minY, lllllllIlIIlll.minZ).color(lllllllIlIllll, lllllllIlIIIIl, lllllllIlIIIII, lllllllIIlllll).endVertex();
        lllllllIlIIlIl.pos(lllllllIlIIlll.maxX, lllllllIlIIlll.maxY, lllllllIlIIlll.minZ).color(lllllllIlIllll, lllllllIlIIIIl, lllllllIlIIIII, lllllllIIlllll).endVertex();
        lllllllIlIIlIl.pos(lllllllIlIIlll.maxX, lllllllIlIIlll.minY, lllllllIlIIlll.maxZ).color(lllllllIlIllll, lllllllIlIIIIl, lllllllIlIIIII, lllllllIIlllll).endVertex();
        lllllllIlIIlIl.pos(lllllllIlIIlll.maxX, lllllllIlIIlll.maxY, lllllllIlIIlll.maxZ).color(lllllllIlIllll, lllllllIlIIIIl, lllllllIlIIIII, lllllllIIlllll).endVertex();
        lllllllIlIIlIl.pos(lllllllIlIIlll.minX, lllllllIlIIlll.minY, lllllllIlIIlll.maxZ).color(lllllllIlIllll, lllllllIlIIIIl, lllllllIlIIIII, lllllllIIlllll).endVertex();
        lllllllIlIIlIl.pos(lllllllIlIIlll.minX, lllllllIlIIlll.maxY, lllllllIlIIlll.maxZ).color(lllllllIlIllll, lllllllIlIIIIl, lllllllIlIIIII, lllllllIIlllll).endVertex();
        lllllllIlIIllI.draw();
        GL11.glDisable((int)2848);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void drawBoxBottom(BlockPos lllllIlIlIllll, int lllllIlIlIlllI, int lllllIlIlIllIl, int lllllIlIllIIIl, int lllllIlIlIlIll) {
        NordTessellator.prepare(7);
        NordTessellator.drawBoxBottom(INSTANCE.getBuffer(), lllllIlIlIllll.func_177958_n(), lllllIlIlIllll.func_177956_o(), lllllIlIlIllll.func_177952_p(), 1.0f, 1.0f, lllllIlIlIlllI, lllllIlIlIllIl, lllllIlIllIIIl, lllllIlIlIlIll);
        NordTessellator.release();
    }

    public static void fakeGuiRect(double lllllIIIllIIIl, double lllllIIIlllIll, double lllllIIIlllIlI, double lllllIIIlllIIl, int lllllIIIlllIII) {
        if (lllllIIIllIIIl < lllllIIIlllIlI) {
            double lllllIIIlllllI = lllllIIIllIIIl;
            lllllIIIllIIIl = lllllIIIlllIlI;
            lllllIIIlllIlI = lllllIIIlllllI;
        }
        if (lllllIIIlllIll < lllllIIIlllIIl) {
            double lllllIIIllllIl = lllllIIIlllIll;
            lllllIIIlllIll = lllllIIIlllIIl;
            lllllIIIlllIIl = lllllIIIllllIl;
        }
        float lllllIIIllIlll = (float)(lllllIIIlllIII >> 24 & 0xFF) / 255.0f;
        float lllllIIIllIllI = (float)(lllllIIIlllIII >> 16 & 0xFF) / 255.0f;
        float lllllIIIllIlIl = (float)(lllllIIIlllIII >> 8 & 0xFF) / 255.0f;
        float lllllIIIllIlII = (float)(lllllIIIlllIII & 0xFF) / 255.0f;
        Tessellator lllllIIIllIIll = Tessellator.getInstance();
        BufferBuilder lllllIIIllIIlI = lllllIIIllIIll.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.color((float)lllllIIIllIllI, (float)lllllIIIllIlIl, (float)lllllIIIllIlII, (float)lllllIIIllIlll);
        lllllIIIllIIlI.begin(7, DefaultVertexFormats.POSITION);
        lllllIIIllIIlI.pos(lllllIIIllIIIl, lllllIIIlllIIl, 0.0).endVertex();
        lllllIIIllIIlI.pos(lllllIIIlllIlI, lllllIIIlllIIl, 0.0).endVertex();
        lllllIIIllIIlI.pos(lllllIIIlllIlI, lllllIIIlllIll, 0.0).endVertex();
        lllllIIIllIIlI.pos(lllllIIIllIIIl, lllllIIIlllIll, 0.0).endVertex();
        lllllIIIllIIll.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void drawBoundingBoxBlockPos(BlockPos lIIIIIIlllIlIIl, float lIIIIIIllIllIll, int lIIIIIIllIllIlI, int lIIIIIIlllIIllI, int lIIIIIIlllIIlIl, int lIIIIIIllIlIlll) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glLineWidth((float)lIIIIIIllIllIll);
        Minecraft lIIIIIIlllIIIll = Minecraft.getMinecraft();
        double lIIIIIIlllIIIlI = (double)lIIIIIIlllIlIIl.func_177958_n() - lIIIIIIlllIIIll.getRenderManager().viewerPosX;
        double lIIIIIIlllIIIIl = (double)lIIIIIIlllIlIIl.func_177956_o() - lIIIIIIlllIIIll.getRenderManager().viewerPosY;
        double lIIIIIIlllIIIII = (double)lIIIIIIlllIlIIl.func_177952_p() - lIIIIIIlllIIIll.getRenderManager().viewerPosZ;
        AxisAlignedBB lIIIIIIllIlllll = new AxisAlignedBB(lIIIIIIlllIIIlI, lIIIIIIlllIIIIl, lIIIIIIlllIIIII, lIIIIIIlllIIIlI + 1.0, lIIIIIIlllIIIIl + 1.0, lIIIIIIlllIIIII + 1.0);
        Tessellator lIIIIIIllIllllI = Tessellator.getInstance();
        BufferBuilder lIIIIIIllIlllIl = lIIIIIIllIllllI.getBuffer();
        lIIIIIIllIlllIl.begin(3, DefaultVertexFormats.POSITION_COLOR);
        lIIIIIIllIlllIl.pos(lIIIIIIllIlllll.minX, lIIIIIIllIlllll.minY, lIIIIIIllIlllll.minZ).color(lIIIIIIllIllIlI, lIIIIIIlllIIllI, lIIIIIIlllIIlIl, lIIIIIIllIlIlll).endVertex();
        lIIIIIIllIlllIl.pos(lIIIIIIllIlllll.maxX, lIIIIIIllIlllll.minY, lIIIIIIllIlllll.minZ).color(lIIIIIIllIllIlI, lIIIIIIlllIIllI, lIIIIIIlllIIlIl, lIIIIIIllIlIlll).endVertex();
        lIIIIIIllIlllIl.pos(lIIIIIIllIlllll.maxX, lIIIIIIllIlllll.minY, lIIIIIIllIlllll.maxZ).color(lIIIIIIllIllIlI, lIIIIIIlllIIllI, lIIIIIIlllIIlIl, lIIIIIIllIlIlll).endVertex();
        lIIIIIIllIlllIl.pos(lIIIIIIllIlllll.minX, lIIIIIIllIlllll.minY, lIIIIIIllIlllll.maxZ).color(lIIIIIIllIllIlI, lIIIIIIlllIIllI, lIIIIIIlllIIlIl, lIIIIIIllIlIlll).endVertex();
        lIIIIIIllIlllIl.pos(lIIIIIIllIlllll.minX, lIIIIIIllIlllll.minY, lIIIIIIllIlllll.minZ).color(lIIIIIIllIllIlI, lIIIIIIlllIIllI, lIIIIIIlllIIlIl, lIIIIIIllIlIlll).endVertex();
        lIIIIIIllIllllI.draw();
        lIIIIIIllIlllIl.begin(3, DefaultVertexFormats.POSITION_COLOR);
        lIIIIIIllIlllIl.pos(lIIIIIIllIlllll.minX, lIIIIIIllIlllll.maxY, lIIIIIIllIlllll.minZ).color(lIIIIIIllIllIlI, lIIIIIIlllIIllI, lIIIIIIlllIIlIl, lIIIIIIllIlIlll).endVertex();
        lIIIIIIllIlllIl.pos(lIIIIIIllIlllll.maxX, lIIIIIIllIlllll.maxY, lIIIIIIllIlllll.minZ).color(lIIIIIIllIllIlI, lIIIIIIlllIIllI, lIIIIIIlllIIlIl, lIIIIIIllIlIlll).endVertex();
        lIIIIIIllIlllIl.pos(lIIIIIIllIlllll.maxX, lIIIIIIllIlllll.maxY, lIIIIIIllIlllll.maxZ).color(lIIIIIIllIllIlI, lIIIIIIlllIIllI, lIIIIIIlllIIlIl, lIIIIIIllIlIlll).endVertex();
        lIIIIIIllIlllIl.pos(lIIIIIIllIlllll.minX, lIIIIIIllIlllll.maxY, lIIIIIIllIlllll.maxZ).color(lIIIIIIllIllIlI, lIIIIIIlllIIllI, lIIIIIIlllIIlIl, lIIIIIIllIlIlll).endVertex();
        lIIIIIIllIlllIl.pos(lIIIIIIllIlllll.minX, lIIIIIIllIlllll.maxY, lIIIIIIllIlllll.minZ).color(lIIIIIIllIllIlI, lIIIIIIlllIIllI, lIIIIIIlllIIlIl, lIIIIIIllIlIlll).endVertex();
        lIIIIIIllIllllI.draw();
        lIIIIIIllIlllIl.begin(1, DefaultVertexFormats.POSITION_COLOR);
        lIIIIIIllIlllIl.pos(lIIIIIIllIlllll.minX, lIIIIIIllIlllll.minY, lIIIIIIllIlllll.minZ).color(lIIIIIIllIllIlI, lIIIIIIlllIIllI, lIIIIIIlllIIlIl, lIIIIIIllIlIlll).endVertex();
        lIIIIIIllIlllIl.pos(lIIIIIIllIlllll.minX, lIIIIIIllIlllll.maxY, lIIIIIIllIlllll.minZ).color(lIIIIIIllIllIlI, lIIIIIIlllIIllI, lIIIIIIlllIIlIl, lIIIIIIllIlIlll).endVertex();
        lIIIIIIllIlllIl.pos(lIIIIIIllIlllll.maxX, lIIIIIIllIlllll.minY, lIIIIIIllIlllll.minZ).color(lIIIIIIllIllIlI, lIIIIIIlllIIllI, lIIIIIIlllIIlIl, lIIIIIIllIlIlll).endVertex();
        lIIIIIIllIlllIl.pos(lIIIIIIllIlllll.maxX, lIIIIIIllIlllll.maxY, lIIIIIIllIlllll.minZ).color(lIIIIIIllIllIlI, lIIIIIIlllIIllI, lIIIIIIlllIIlIl, lIIIIIIllIlIlll).endVertex();
        lIIIIIIllIlllIl.pos(lIIIIIIllIlllll.maxX, lIIIIIIllIlllll.minY, lIIIIIIllIlllll.maxZ).color(lIIIIIIllIllIlI, lIIIIIIlllIIllI, lIIIIIIlllIIlIl, lIIIIIIllIlIlll).endVertex();
        lIIIIIIllIlllIl.pos(lIIIIIIllIlllll.maxX, lIIIIIIllIlllll.maxY, lIIIIIIllIlllll.maxZ).color(lIIIIIIllIllIlI, lIIIIIIlllIIllI, lIIIIIIlllIIlIl, lIIIIIIllIlIlll).endVertex();
        lIIIIIIllIlllIl.pos(lIIIIIIllIlllll.minX, lIIIIIIllIlllll.minY, lIIIIIIllIlllll.maxZ).color(lIIIIIIllIllIlI, lIIIIIIlllIIllI, lIIIIIIlllIIlIl, lIIIIIIllIlIlll).endVertex();
        lIIIIIIllIlllIl.pos(lIIIIIIllIlllll.minX, lIIIIIIllIlllll.maxY, lIIIIIIllIlllll.maxZ).color(lIIIIIIllIllIlI, lIIIIIIlllIIllI, lIIIIIIlllIIlIl, lIIIIIIllIlIlll).endVertex();
        lIIIIIIllIllllI.draw();
        GL11.glDisable((int)2848);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void drawBoxBottom(BufferBuilder lllllIllIIIIll, float lllllIllIIIIlI, float lllllIllIIIIIl, float lllllIllIIIIII, float lllllIllIIlIIl, float lllllIllIIlIII, int lllllIllIIIlll, int lllllIlIllllII, int lllllIllIIIlIl, int lllllIlIlllIlI) {
        lllllIllIIIIll.pos((double)(lllllIllIIIIlI + lllllIllIIlIIl), (double)lllllIllIIIIIl, (double)lllllIllIIIIII).color(lllllIllIIIlll, lllllIlIllllII, lllllIllIIIlIl, lllllIlIlllIlI).endVertex();
        lllllIllIIIIll.pos((double)(lllllIllIIIIlI + lllllIllIIlIIl), (double)lllllIllIIIIIl, (double)(lllllIllIIIIII + lllllIllIIlIII)).color(lllllIllIIIlll, lllllIlIllllII, lllllIllIIIlIl, lllllIlIlllIlI).endVertex();
        lllllIllIIIIll.pos((double)lllllIllIIIIlI, (double)lllllIllIIIIIl, (double)(lllllIllIIIIII + lllllIllIIlIII)).color(lllllIllIIIlll, lllllIlIllllII, lllllIllIIIlIl, lllllIlIlllIlI).endVertex();
        lllllIllIIIIll.pos((double)lllllIllIIIIlI, (double)lllllIllIIIIIl, (double)lllllIllIIIIII).color(lllllIllIIIlll, lllllIlIllllII, lllllIllIIIlIl, lllllIlIlllIlI).endVertex();
    }

    public static void drawFace(BlockPos lllllIlIlIIlII, int lllllIlIIlllIl, int lllllIlIIlllII, int lllllIlIIllIll, int lllllIlIIllIlI, int lllllIlIIlllll) {
        NordTessellator.drawFace(INSTANCE.getBuffer(), lllllIlIlIIlII.func_177958_n(), lllllIlIlIIlII.func_177956_o(), lllllIlIlIIlII.func_177952_p(), 1.0f, 1.0f, 1.0f, lllllIlIIlllIl, lllllIlIIlllII, lllllIlIIllIll, lllllIlIIllIlI, lllllIlIIlllll);
    }

    public static void drawBoundingBottomBoxBlockPos(BlockPos lllllllIIIlIlI, float lllllllIIIlIIl, int llllllIllllIll, int llllllIllllIlI, int lllllllIIIIllI, int llllllIllllIII) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glLineWidth((float)lllllllIIIlIIl);
        Minecraft lllllllIIIIlII = Minecraft.getMinecraft();
        double lllllllIIIIIll = (double)lllllllIIIlIlI.func_177958_n() - lllllllIIIIlII.getRenderManager().viewerPosX;
        double lllllllIIIIIlI = (double)lllllllIIIlIlI.func_177956_o() - lllllllIIIIlII.getRenderManager().viewerPosY;
        double lllllllIIIIIIl = (double)lllllllIIIlIlI.func_177952_p() - lllllllIIIIlII.getRenderManager().viewerPosZ;
        AxisAlignedBB lllllllIIIIIII = new AxisAlignedBB(lllllllIIIIIll, lllllllIIIIIlI, lllllllIIIIIIl, lllllllIIIIIll + 1.0, lllllllIIIIIlI + 0.0, lllllllIIIIIIl + 1.0);
        Tessellator llllllIlllllll = Tessellator.getInstance();
        BufferBuilder llllllIllllllI = llllllIlllllll.getBuffer();
        llllllIllllllI.begin(3, DefaultVertexFormats.POSITION_COLOR);
        llllllIllllllI.pos(lllllllIIIIIII.minX, lllllllIIIIIII.minY, lllllllIIIIIII.minZ).color(llllllIllllIll, llllllIllllIlI, lllllllIIIIllI, llllllIllllIII).endVertex();
        llllllIllllllI.pos(lllllllIIIIIII.maxX, lllllllIIIIIII.minY, lllllllIIIIIII.minZ).color(llllllIllllIll, llllllIllllIlI, lllllllIIIIllI, llllllIllllIII).endVertex();
        llllllIllllllI.pos(lllllllIIIIIII.maxX, lllllllIIIIIII.minY, lllllllIIIIIII.maxZ).color(llllllIllllIll, llllllIllllIlI, lllllllIIIIllI, llllllIllllIII).endVertex();
        llllllIllllllI.pos(lllllllIIIIIII.minX, lllllllIIIIIII.minY, lllllllIIIIIII.maxZ).color(llllllIllllIll, llllllIllllIlI, lllllllIIIIllI, llllllIllllIII).endVertex();
        llllllIllllllI.pos(lllllllIIIIIII.minX, lllllllIIIIIII.minY, lllllllIIIIIII.minZ).color(llllllIllllIll, llllllIllllIlI, lllllllIIIIllI, llllllIllllIII).endVertex();
        llllllIlllllll.draw();
        llllllIllllllI.begin(3, DefaultVertexFormats.POSITION_COLOR);
        llllllIllllllI.pos(lllllllIIIIIII.minX, lllllllIIIIIII.maxY, lllllllIIIIIII.minZ).color(llllllIllllIll, llllllIllllIlI, lllllllIIIIllI, llllllIllllIII).endVertex();
        llllllIllllllI.pos(lllllllIIIIIII.maxX, lllllllIIIIIII.maxY, lllllllIIIIIII.minZ).color(llllllIllllIll, llllllIllllIlI, lllllllIIIIllI, llllllIllllIII).endVertex();
        llllllIllllllI.pos(lllllllIIIIIII.maxX, lllllllIIIIIII.maxY, lllllllIIIIIII.maxZ).color(llllllIllllIll, llllllIllllIlI, lllllllIIIIllI, llllllIllllIII).endVertex();
        llllllIllllllI.pos(lllllllIIIIIII.minX, lllllllIIIIIII.maxY, lllllllIIIIIII.maxZ).color(llllllIllllIll, llllllIllllIlI, lllllllIIIIllI, llllllIllllIII).endVertex();
        llllllIllllllI.pos(lllllllIIIIIII.minX, lllllllIIIIIII.maxY, lllllllIIIIIII.minZ).color(llllllIllllIll, llllllIllllIlI, lllllllIIIIllI, llllllIllllIII).endVertex();
        llllllIlllllll.draw();
        llllllIllllllI.begin(1, DefaultVertexFormats.POSITION_COLOR);
        llllllIllllllI.pos(lllllllIIIIIII.minX, lllllllIIIIIII.minY, lllllllIIIIIII.minZ).color(llllllIllllIll, llllllIllllIlI, lllllllIIIIllI, llllllIllllIII).endVertex();
        llllllIllllllI.pos(lllllllIIIIIII.minX, lllllllIIIIIII.maxY, lllllllIIIIIII.minZ).color(llllllIllllIll, llllllIllllIlI, lllllllIIIIllI, llllllIllllIII).endVertex();
        llllllIllllllI.pos(lllllllIIIIIII.maxX, lllllllIIIIIII.minY, lllllllIIIIIII.minZ).color(llllllIllllIll, llllllIllllIlI, lllllllIIIIllI, llllllIllllIII).endVertex();
        llllllIllllllI.pos(lllllllIIIIIII.maxX, lllllllIIIIIII.maxY, lllllllIIIIIII.minZ).color(llllllIllllIll, llllllIllllIlI, lllllllIIIIllI, llllllIllllIII).endVertex();
        llllllIllllllI.pos(lllllllIIIIIII.maxX, lllllllIIIIIII.minY, lllllllIIIIIII.maxZ).color(llllllIllllIll, llllllIllllIlI, lllllllIIIIllI, llllllIllllIII).endVertex();
        llllllIllllllI.pos(lllllllIIIIIII.maxX, lllllllIIIIIII.maxY, lllllllIIIIIII.maxZ).color(llllllIllllIll, llllllIllllIlI, lllllllIIIIllI, llllllIllllIII).endVertex();
        llllllIllllllI.pos(lllllllIIIIIII.minX, lllllllIIIIIII.minY, lllllllIIIIIII.maxZ).color(llllllIllllIll, llllllIllllIlI, lllllllIIIIllI, llllllIllllIII).endVertex();
        llllllIllllllI.pos(lllllllIIIIIII.minX, lllllllIIIIIII.maxY, lllllllIIIIIII.maxZ).color(llllllIllllIll, llllllIllllIlI, lllllllIIIIllI, llllllIllllIII).endVertex();
        llllllIlllllll.draw();
        GL11.glDisable((int)2848);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void drawBoundingBoxBottomBlockPosSouth(BlockPos lIIIIIIIlIIllIl, float lIIIIIIIlIIllII, int lIIIIIIIIlllllI, int lIIIIIIIlIIlIlI, int lIIIIIIIIllllII, int lIIIIIIIlIIlIII) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glLineWidth((float)lIIIIIIIlIIllII);
        Minecraft lIIIIIIIlIIIlll = Minecraft.getMinecraft();
        double lIIIIIIIlIIIllI = (double)lIIIIIIIlIIllIl.func_177958_n() - lIIIIIIIlIIIlll.getRenderManager().viewerPosX;
        double lIIIIIIIlIIIlIl = (double)lIIIIIIIlIIllIl.func_177956_o() - lIIIIIIIlIIIlll.getRenderManager().viewerPosY;
        double lIIIIIIIlIIIlII = (double)lIIIIIIIlIIllIl.func_177952_p() - lIIIIIIIlIIIlll.getRenderManager().viewerPosZ;
        AxisAlignedBB lIIIIIIIlIIIIll = new AxisAlignedBB(lIIIIIIIlIIIllI, lIIIIIIIlIIIlIl, lIIIIIIIlIIIlII, lIIIIIIIlIIIllI + 1.0, lIIIIIIIlIIIlIl + 1.0, lIIIIIIIlIIIlII + 1.0);
        Tessellator lIIIIIIIlIIIIlI = Tessellator.getInstance();
        BufferBuilder lIIIIIIIlIIIIIl = lIIIIIIIlIIIIlI.getBuffer();
        lIIIIIIIlIIIIIl.begin(3, DefaultVertexFormats.POSITION_COLOR);
        lIIIIIIIlIIIIIl.pos(lIIIIIIIlIIIIll.maxX, lIIIIIIIlIIIIll.minY, lIIIIIIIlIIIIll.minZ).color(lIIIIIIIIlllllI, lIIIIIIIlIIlIlI, lIIIIIIIIllllII, lIIIIIIIlIIlIII).endVertex();
        lIIIIIIIlIIIIIl.pos(lIIIIIIIlIIIIll.maxX, lIIIIIIIlIIIIll.minY, lIIIIIIIlIIIIll.maxZ).color(lIIIIIIIIlllllI, lIIIIIIIlIIlIlI, lIIIIIIIIllllII, lIIIIIIIlIIlIII).endVertex();
        lIIIIIIIlIIIIIl.pos(lIIIIIIIlIIIIll.minX, lIIIIIIIlIIIIll.minY, lIIIIIIIlIIIIll.maxZ).color(lIIIIIIIIlllllI, lIIIIIIIlIIlIlI, lIIIIIIIIllllII, lIIIIIIIlIIlIII).endVertex();
        lIIIIIIIlIIIIIl.pos(lIIIIIIIlIIIIll.minX, lIIIIIIIlIIIIll.minY, lIIIIIIIlIIIIll.minZ).color(lIIIIIIIIlllllI, lIIIIIIIlIIlIlI, lIIIIIIIIllllII, lIIIIIIIlIIlIII).endVertex();
        lIIIIIIIlIIIIlI.draw();
        GL11.glDisable((int)2848);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void drawBoundingBoxItem(double llllllIIlllIlI, double llllllIIlllIIl, double llllllIIlIlIIl, float llllllIIllIlll, int llllllIIlIIlll, int llllllIIllIlIl, int llllllIIlIIlIl, int llllllIIlIIlII) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glLineWidth((float)llllllIIllIlll);
        Minecraft llllllIIllIIlI = Minecraft.getMinecraft();
        double llllllIIllIIIl = llllllIIlllIlI - 0.2 - llllllIIllIIlI.getRenderManager().viewerPosX;
        double llllllIIllIIII = llllllIIlllIIl - llllllIIllIIlI.getRenderManager().viewerPosY;
        double llllllIIlIllll = llllllIIlIlIIl - 0.2 - llllllIIllIIlI.getRenderManager().viewerPosZ;
        AxisAlignedBB llllllIIlIlllI = new AxisAlignedBB(llllllIIllIIIl, llllllIIllIIII, llllllIIlIllll, llllllIIllIIIl + 0.4, llllllIIllIIII + 0.4, llllllIIlIllll + 0.4);
        Tessellator llllllIIlIllIl = Tessellator.getInstance();
        BufferBuilder llllllIIlIllII = llllllIIlIllIl.getBuffer();
        llllllIIlIllII.begin(3, DefaultVertexFormats.POSITION_COLOR);
        llllllIIlIllII.pos(llllllIIlIlllI.minX, llllllIIlIlllI.minY, llllllIIlIlllI.minZ).color(llllllIIlIIlll, llllllIIllIlIl, llllllIIlIIlIl, llllllIIlIIlII).endVertex();
        llllllIIlIllII.pos(llllllIIlIlllI.maxX, llllllIIlIlllI.minY, llllllIIlIlllI.minZ).color(llllllIIlIIlll, llllllIIllIlIl, llllllIIlIIlIl, llllllIIlIIlII).endVertex();
        llllllIIlIllII.pos(llllllIIlIlllI.maxX, llllllIIlIlllI.minY, llllllIIlIlllI.maxZ).color(llllllIIlIIlll, llllllIIllIlIl, llllllIIlIIlIl, llllllIIlIIlII).endVertex();
        llllllIIlIllII.pos(llllllIIlIlllI.minX, llllllIIlIlllI.minY, llllllIIlIlllI.maxZ).color(llllllIIlIIlll, llllllIIllIlIl, llllllIIlIIlIl, llllllIIlIIlII).endVertex();
        llllllIIlIllII.pos(llllllIIlIlllI.minX, llllllIIlIlllI.minY, llllllIIlIlllI.minZ).color(llllllIIlIIlll, llllllIIllIlIl, llllllIIlIIlIl, llllllIIlIIlII).endVertex();
        llllllIIlIllIl.draw();
        llllllIIlIllII.begin(3, DefaultVertexFormats.POSITION_COLOR);
        llllllIIlIllII.pos(llllllIIlIlllI.minX, llllllIIlIlllI.maxY, llllllIIlIlllI.minZ).color(llllllIIlIIlll, llllllIIllIlIl, llllllIIlIIlIl, llllllIIlIIlII).endVertex();
        llllllIIlIllII.pos(llllllIIlIlllI.maxX, llllllIIlIlllI.maxY, llllllIIlIlllI.minZ).color(llllllIIlIIlll, llllllIIllIlIl, llllllIIlIIlIl, llllllIIlIIlII).endVertex();
        llllllIIlIllII.pos(llllllIIlIlllI.maxX, llllllIIlIlllI.maxY, llllllIIlIlllI.maxZ).color(llllllIIlIIlll, llllllIIllIlIl, llllllIIlIIlIl, llllllIIlIIlII).endVertex();
        llllllIIlIllII.pos(llllllIIlIlllI.minX, llllllIIlIlllI.maxY, llllllIIlIlllI.maxZ).color(llllllIIlIIlll, llllllIIllIlIl, llllllIIlIIlIl, llllllIIlIIlII).endVertex();
        llllllIIlIllII.pos(llllllIIlIlllI.minX, llllllIIlIlllI.maxY, llllllIIlIlllI.minZ).color(llllllIIlIIlll, llllllIIllIlIl, llllllIIlIIlIl, llllllIIlIIlII).endVertex();
        llllllIIlIllIl.draw();
        llllllIIlIllII.begin(1, DefaultVertexFormats.POSITION_COLOR);
        llllllIIlIllII.pos(llllllIIlIlllI.minX, llllllIIlIlllI.minY, llllllIIlIlllI.minZ).color(llllllIIlIIlll, llllllIIllIlIl, llllllIIlIIlIl, llllllIIlIIlII).endVertex();
        llllllIIlIllII.pos(llllllIIlIlllI.minX, llllllIIlIlllI.maxY, llllllIIlIlllI.minZ).color(llllllIIlIIlll, llllllIIllIlIl, llllllIIlIIlIl, llllllIIlIIlII).endVertex();
        llllllIIlIllII.pos(llllllIIlIlllI.maxX, llllllIIlIlllI.minY, llllllIIlIlllI.minZ).color(llllllIIlIIlll, llllllIIllIlIl, llllllIIlIIlIl, llllllIIlIIlII).endVertex();
        llllllIIlIllII.pos(llllllIIlIlllI.maxX, llllllIIlIlllI.maxY, llllllIIlIlllI.minZ).color(llllllIIlIIlll, llllllIIllIlIl, llllllIIlIIlIl, llllllIIlIIlII).endVertex();
        llllllIIlIllII.pos(llllllIIlIlllI.maxX, llllllIIlIlllI.minY, llllllIIlIlllI.maxZ).color(llllllIIlIIlll, llllllIIllIlIl, llllllIIlIIlIl, llllllIIlIIlII).endVertex();
        llllllIIlIllII.pos(llllllIIlIlllI.maxX, llllllIIlIlllI.maxY, llllllIIlIlllI.maxZ).color(llllllIIlIIlll, llllllIIllIlIl, llllllIIlIIlIl, llllllIIlIIlII).endVertex();
        llllllIIlIllII.pos(llllllIIlIlllI.minX, llllllIIlIlllI.minY, llllllIIlIlllI.maxZ).color(llllllIIlIIlll, llllllIIllIlIl, llllllIIlIIlIl, llllllIIlIIlII).endVertex();
        llllllIIlIllII.pos(llllllIIlIlllI.minX, llllllIIlIlllI.maxY, llllllIIlIlllI.maxZ).color(llllllIIlIIlll, llllllIIllIlIl, llllllIIlIIlIl, llllllIIlIIlII).endVertex();
        llllllIIlIllIl.draw();
        GL11.glDisable((int)2848);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void render() {
        INSTANCE.draw();
    }

    public static void drawBox(BufferBuilder lIIIIIlIlIIIlll, double lIIIIIlIlIlIIlI, double lIIIIIlIlIlIIIl, double lIIIIIlIlIlIIII, float lIIIIIlIlIIIIll, float lIIIIIlIlIIIIlI, float lIIIIIlIlIIIIIl, int lIIIIIlIlIIllII, int lIIIIIlIIllllll, int lIIIIIlIlIIlIlI, int lIIIIIlIlIIlIIl, int lIIIIIlIIllllII) {
        if ((lIIIIIlIIllllII & 1) != 0) {
            lIIIIIlIlIIIlll.pos(lIIIIIlIlIlIIlI + (double)lIIIIIlIlIIIIll, lIIIIIlIlIlIIIl, lIIIIIlIlIlIIII).color(lIIIIIlIlIIllII, lIIIIIlIIllllll, lIIIIIlIlIIlIlI, lIIIIIlIlIIlIIl).endVertex();
            lIIIIIlIlIIIlll.pos(lIIIIIlIlIlIIlI + (double)lIIIIIlIlIIIIll, lIIIIIlIlIlIIIl, lIIIIIlIlIlIIII + (double)lIIIIIlIlIIIIIl).color(lIIIIIlIlIIllII, lIIIIIlIIllllll, lIIIIIlIlIIlIlI, lIIIIIlIlIIlIIl).endVertex();
            lIIIIIlIlIIIlll.pos(lIIIIIlIlIlIIlI, lIIIIIlIlIlIIIl, lIIIIIlIlIlIIII + (double)lIIIIIlIlIIIIIl).color(lIIIIIlIlIIllII, lIIIIIlIIllllll, lIIIIIlIlIIlIlI, lIIIIIlIlIIlIIl).endVertex();
            lIIIIIlIlIIIlll.pos(lIIIIIlIlIlIIlI, lIIIIIlIlIlIIIl, lIIIIIlIlIlIIII).color(lIIIIIlIlIIllII, lIIIIIlIIllllll, lIIIIIlIlIIlIlI, lIIIIIlIlIIlIIl).endVertex();
        }
        if ((lIIIIIlIIllllII & 2) != 0) {
            lIIIIIlIlIIIlll.pos(lIIIIIlIlIlIIlI + (double)lIIIIIlIlIIIIll, lIIIIIlIlIlIIIl + (double)lIIIIIlIlIIIIlI, lIIIIIlIlIlIIII).color(lIIIIIlIlIIllII, lIIIIIlIIllllll, lIIIIIlIlIIlIlI, lIIIIIlIlIIlIIl).endVertex();
            lIIIIIlIlIIIlll.pos(lIIIIIlIlIlIIlI, lIIIIIlIlIlIIIl + (double)lIIIIIlIlIIIIlI, lIIIIIlIlIlIIII).color(lIIIIIlIlIIllII, lIIIIIlIIllllll, lIIIIIlIlIIlIlI, lIIIIIlIlIIlIIl).endVertex();
            lIIIIIlIlIIIlll.pos(lIIIIIlIlIlIIlI, lIIIIIlIlIlIIIl + (double)lIIIIIlIlIIIIlI, lIIIIIlIlIlIIII + (double)lIIIIIlIlIIIIIl).color(lIIIIIlIlIIllII, lIIIIIlIIllllll, lIIIIIlIlIIlIlI, lIIIIIlIlIIlIIl).endVertex();
            lIIIIIlIlIIIlll.pos(lIIIIIlIlIlIIlI + (double)lIIIIIlIlIIIIll, lIIIIIlIlIlIIIl + (double)lIIIIIlIlIIIIlI, lIIIIIlIlIlIIII + (double)lIIIIIlIlIIIIIl).color(lIIIIIlIlIIllII, lIIIIIlIIllllll, lIIIIIlIlIIlIlI, lIIIIIlIlIIlIIl).endVertex();
        }
        if ((lIIIIIlIIllllII & 4) != 0) {
            lIIIIIlIlIIIlll.pos(lIIIIIlIlIlIIlI + (double)lIIIIIlIlIIIIll, lIIIIIlIlIlIIIl, lIIIIIlIlIlIIII).color(lIIIIIlIlIIllII, lIIIIIlIIllllll, lIIIIIlIlIIlIlI, lIIIIIlIlIIlIIl).endVertex();
            lIIIIIlIlIIIlll.pos(lIIIIIlIlIlIIlI, lIIIIIlIlIlIIIl, lIIIIIlIlIlIIII).color(lIIIIIlIlIIllII, lIIIIIlIIllllll, lIIIIIlIlIIlIlI, lIIIIIlIlIIlIIl).endVertex();
            lIIIIIlIlIIIlll.pos(lIIIIIlIlIlIIlI, lIIIIIlIlIlIIIl + (double)lIIIIIlIlIIIIlI, lIIIIIlIlIlIIII).color(lIIIIIlIlIIllII, lIIIIIlIIllllll, lIIIIIlIlIIlIlI, lIIIIIlIlIIlIIl).endVertex();
            lIIIIIlIlIIIlll.pos(lIIIIIlIlIlIIlI + (double)lIIIIIlIlIIIIll, lIIIIIlIlIlIIIl + (double)lIIIIIlIlIIIIlI, lIIIIIlIlIlIIII).color(lIIIIIlIlIIllII, lIIIIIlIIllllll, lIIIIIlIlIIlIlI, lIIIIIlIlIIlIIl).endVertex();
        }
        if ((lIIIIIlIIllllII & 8) != 0) {
            lIIIIIlIlIIIlll.pos(lIIIIIlIlIlIIlI, lIIIIIlIlIlIIIl, lIIIIIlIlIlIIII + (double)lIIIIIlIlIIIIIl).color(lIIIIIlIlIIllII, lIIIIIlIIllllll, lIIIIIlIlIIlIlI, lIIIIIlIlIIlIIl).endVertex();
            lIIIIIlIlIIIlll.pos(lIIIIIlIlIlIIlI + (double)lIIIIIlIlIIIIll, lIIIIIlIlIlIIIl, lIIIIIlIlIlIIII + (double)lIIIIIlIlIIIIIl).color(lIIIIIlIlIIllII, lIIIIIlIIllllll, lIIIIIlIlIIlIlI, lIIIIIlIlIIlIIl).endVertex();
            lIIIIIlIlIIIlll.pos(lIIIIIlIlIlIIlI + (double)lIIIIIlIlIIIIll, lIIIIIlIlIlIIIl + (double)lIIIIIlIlIIIIlI, lIIIIIlIlIlIIII + (double)lIIIIIlIlIIIIIl).color(lIIIIIlIlIIllII, lIIIIIlIIllllll, lIIIIIlIlIIlIlI, lIIIIIlIlIIlIIl).endVertex();
            lIIIIIlIlIIIlll.pos(lIIIIIlIlIlIIlI, lIIIIIlIlIlIIIl + (double)lIIIIIlIlIIIIlI, lIIIIIlIlIlIIII + (double)lIIIIIlIlIIIIIl).color(lIIIIIlIlIIllII, lIIIIIlIIllllll, lIIIIIlIlIIlIlI, lIIIIIlIlIIlIIl).endVertex();
        }
        if ((lIIIIIlIIllllII & 0x10) != 0) {
            lIIIIIlIlIIIlll.pos(lIIIIIlIlIlIIlI, lIIIIIlIlIlIIIl, lIIIIIlIlIlIIII).color(lIIIIIlIlIIllII, lIIIIIlIIllllll, lIIIIIlIlIIlIlI, lIIIIIlIlIIlIIl).endVertex();
            lIIIIIlIlIIIlll.pos(lIIIIIlIlIlIIlI, lIIIIIlIlIlIIIl, lIIIIIlIlIlIIII + (double)lIIIIIlIlIIIIIl).color(lIIIIIlIlIIllII, lIIIIIlIIllllll, lIIIIIlIlIIlIlI, lIIIIIlIlIIlIIl).endVertex();
            lIIIIIlIlIIIlll.pos(lIIIIIlIlIlIIlI, lIIIIIlIlIlIIIl + (double)lIIIIIlIlIIIIlI, lIIIIIlIlIlIIII + (double)lIIIIIlIlIIIIIl).color(lIIIIIlIlIIllII, lIIIIIlIIllllll, lIIIIIlIlIIlIlI, lIIIIIlIlIIlIIl).endVertex();
            lIIIIIlIlIIIlll.pos(lIIIIIlIlIlIIlI, lIIIIIlIlIlIIIl + (double)lIIIIIlIlIIIIlI, lIIIIIlIlIlIIII).color(lIIIIIlIlIIllII, lIIIIIlIIllllll, lIIIIIlIlIIlIlI, lIIIIIlIlIIlIIl).endVertex();
        }
        if ((lIIIIIlIIllllII & 0x20) != 0) {
            lIIIIIlIlIIIlll.pos(lIIIIIlIlIlIIlI + (double)lIIIIIlIlIIIIll, lIIIIIlIlIlIIIl, lIIIIIlIlIlIIII + (double)lIIIIIlIlIIIIIl).color(lIIIIIlIlIIllII, lIIIIIlIIllllll, lIIIIIlIlIIlIlI, lIIIIIlIlIIlIIl).endVertex();
            lIIIIIlIlIIIlll.pos(lIIIIIlIlIlIIlI + (double)lIIIIIlIlIIIIll, lIIIIIlIlIlIIIl, lIIIIIlIlIlIIII).color(lIIIIIlIlIIllII, lIIIIIlIIllllll, lIIIIIlIlIIlIlI, lIIIIIlIlIIlIIl).endVertex();
            lIIIIIlIlIIIlll.pos(lIIIIIlIlIlIIlI + (double)lIIIIIlIlIIIIll, lIIIIIlIlIlIIIl + (double)lIIIIIlIlIIIIlI, lIIIIIlIlIlIIII).color(lIIIIIlIlIIllII, lIIIIIlIIllllll, lIIIIIlIlIIlIlI, lIIIIIlIlIIlIIl).endVertex();
            lIIIIIlIlIIIlll.pos(lIIIIIlIlIlIIlI + (double)lIIIIIlIlIIIIll, lIIIIIlIlIlIIIl + (double)lIIIIIlIlIIIIlI, lIIIIIlIlIlIIII + (double)lIIIIIlIlIIIIIl).color(lIIIIIlIlIIllII, lIIIIIlIIllllll, lIIIIIlIlIIlIlI, lIIIIIlIlIIlIIl).endVertex();
        }
    }

    public static Vec3d getInterpolatedAmount(Entity lllllIIllIlllI, double lllllIIllIllIl) {
        return NordTessellator.getInterpolatedAmount(lllllIIllIlllI, lllllIIllIllIl, lllllIIllIllIl, lllllIIllIllIl);
    }

    public static void release() {
        NordTessellator.render();
        NordTessellator.releaseGL();
    }

    public static Vec3d getInterpolatedPos(Entity lllllIIlllIIlI, float lllllIIlllIIll) {
        return new Vec3d(lllllIIlllIIlI.lastTickPosX, lllllIIlllIIlI.lastTickPosY, lllllIIlllIIlI.lastTickPosZ).add(NordTessellator.getInterpolatedAmount(lllllIIlllIIlI, lllllIIlllIIll));
    }

    public static void drawBoundingBoxBottomBlockPosNorth(BlockPos lIIIIIIIIlIIllI, float lIIIIIIIIIllIII, int lIIIIIIIIlIIlII, int lIIIIIIIIIlIllI, int lIIIIIIIIIlIlIl, int lIIIIIIIIIlIlII) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glLineWidth((float)lIIIIIIIIIllIII);
        Minecraft lIIIIIIIIlIIIII = Minecraft.getMinecraft();
        double lIIIIIIIIIlllll = (double)lIIIIIIIIlIIllI.func_177958_n() - lIIIIIIIIlIIIII.getRenderManager().viewerPosX;
        double lIIIIIIIIIllllI = (double)lIIIIIIIIlIIllI.func_177956_o() - lIIIIIIIIlIIIII.getRenderManager().viewerPosY;
        double lIIIIIIIIIlllIl = (double)lIIIIIIIIlIIllI.func_177952_p() - lIIIIIIIIlIIIII.getRenderManager().viewerPosZ;
        AxisAlignedBB lIIIIIIIIIlllII = new AxisAlignedBB(lIIIIIIIIIlllll, lIIIIIIIIIllllI, lIIIIIIIIIlllIl, lIIIIIIIIIlllll + 1.0, lIIIIIIIIIllllI + 1.0, lIIIIIIIIIlllIl + 1.0);
        Tessellator lIIIIIIIIIllIll = Tessellator.getInstance();
        BufferBuilder lIIIIIIIIIllIlI = lIIIIIIIIIllIll.getBuffer();
        lIIIIIIIIIllIlI.begin(3, DefaultVertexFormats.POSITION_COLOR);
        lIIIIIIIIIllIlI.pos(lIIIIIIIIIlllII.minX, lIIIIIIIIIlllII.minY, lIIIIIIIIIlllII.minZ).color(lIIIIIIIIlIIlII, lIIIIIIIIIlIllI, lIIIIIIIIIlIlIl, lIIIIIIIIIlIlII / 2).endVertex();
        lIIIIIIIIIllIlI.pos(lIIIIIIIIIlllII.maxX, lIIIIIIIIIlllII.minY, lIIIIIIIIIlllII.minZ).color(lIIIIIIIIlIIlII, lIIIIIIIIIlIllI, lIIIIIIIIIlIlIl, lIIIIIIIIIlIlII / 2).endVertex();
        lIIIIIIIIIllIlI.pos(lIIIIIIIIIlllII.maxX, lIIIIIIIIIlllII.minY, lIIIIIIIIIlllII.maxZ).color(lIIIIIIIIlIIlII, lIIIIIIIIIlIllI, lIIIIIIIIIlIlIl, lIIIIIIIIIlIlII / 2).endVertex();
        lIIIIIIIIIllIlI.pos(lIIIIIIIIIlllII.maxX, lIIIIIIIIIlllII.minY, lIIIIIIIIIlllII.minZ).color(lIIIIIIIIlIIlII, lIIIIIIIIIlIllI, lIIIIIIIIIlIlIl, lIIIIIIIIIlIlII / 2).endVertex();
        lIIIIIIIIIllIlI.pos(lIIIIIIIIIlllII.minX, lIIIIIIIIIlllII.minY, lIIIIIIIIIlllII.minZ).color(lIIIIIIIIlIIlII, lIIIIIIIIIlIllI, lIIIIIIIIIlIlIl, lIIIIIIIIIlIlII / 2).endVertex();
        lIIIIIIIIIllIlI.pos(lIIIIIIIIIlllII.minX, lIIIIIIIIIlllII.minY, lIIIIIIIIIlllII.maxZ).color(lIIIIIIIIlIIlII, lIIIIIIIIIlIllI, lIIIIIIIIIlIlIl, lIIIIIIIIIlIlII).endVertex();
        lIIIIIIIIIllIll.draw();
        GL11.glDisable((int)2848);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void prepare(int lIIIIIlllIIIIII) {
        NordTessellator.prepareGL();
        NordTessellator.begin(lIIIIIlllIIIIII);
    }

    public static void drawBoundingBoxBottomBlockPosXInMiddle(BlockPos lIIIIIIlIIIlllI, float lIIIIIIlIIllIlI, int lIIIIIIlIIllIIl, int lIIIIIIlIIIlIll, int lIIIIIIlIIlIlll, int lIIIIIIlIIlIllI) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glLineWidth((float)lIIIIIIlIIllIlI);
        Minecraft lIIIIIIlIIlIlIl = Minecraft.getMinecraft();
        double lIIIIIIlIIlIlII = (double)lIIIIIIlIIIlllI.func_177958_n() - lIIIIIIlIIlIlIl.getRenderManager().viewerPosX;
        double lIIIIIIlIIlIIll = (double)lIIIIIIlIIIlllI.func_177956_o() - lIIIIIIlIIlIlIl.getRenderManager().viewerPosY;
        double lIIIIIIlIIlIIlI = (double)lIIIIIIlIIIlllI.func_177952_p() - lIIIIIIlIIlIlIl.getRenderManager().viewerPosZ;
        AxisAlignedBB lIIIIIIlIIlIIIl = new AxisAlignedBB(lIIIIIIlIIlIlII, lIIIIIIlIIlIIll, lIIIIIIlIIlIIlI, lIIIIIIlIIlIlII + 1.0, lIIIIIIlIIlIIll + 1.0, lIIIIIIlIIlIIlI + 1.0);
        Tessellator lIIIIIIlIIlIIII = Tessellator.getInstance();
        BufferBuilder lIIIIIIlIIIllll = lIIIIIIlIIlIIII.getBuffer();
        lIIIIIIlIIIllll.begin(3, DefaultVertexFormats.POSITION_COLOR);
        lIIIIIIlIIIllll.pos(lIIIIIIlIIlIIIl.minX, lIIIIIIlIIlIIIl.minY, lIIIIIIlIIlIIIl.minZ).color(lIIIIIIlIIllIIl, lIIIIIIlIIIlIll, lIIIIIIlIIlIlll, lIIIIIIlIIlIllI).endVertex();
        lIIIIIIlIIIllll.pos(lIIIIIIlIIlIIIl.maxX, lIIIIIIlIIlIIIl.minY, lIIIIIIlIIlIIIl.maxZ).color(lIIIIIIlIIllIIl, lIIIIIIlIIIlIll, lIIIIIIlIIlIlll, lIIIIIIlIIlIllI).endVertex();
        lIIIIIIlIIlIIII.draw();
        GL11.glDisable((int)2848);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void drawBox(BlockPos lIIIIIllIlIlllI, int lIIIIIllIllIlII, int lIIIIIllIlIllII) {
        int lIIIIIllIllIIlI = lIIIIIllIllIlII >>> 24 & 0xFF;
        int lIIIIIllIllIIIl = lIIIIIllIllIlII >>> 16 & 0xFF;
        int lIIIIIllIllIIII = lIIIIIllIllIlII >>> 8 & 0xFF;
        int lIIIIIllIlIllll = lIIIIIllIllIlII & 0xFF;
        NordTessellator.drawBox(lIIIIIllIlIlllI, lIIIIIllIllIIIl, lIIIIIllIllIIII, lIIIIIllIlIllll, lIIIIIllIllIIlI, lIIIIIllIlIllII);
    }

    public static void drawBoundingBoxBottomBlockPosEast(BlockPos llllllllllllll, float lllllllllllllI, int llllllllllIIII, int lllllllllIllll, int lllllllllIlllI, int lllllllllIllIl) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glLineWidth((float)lllllllllllllI);
        Minecraft lllllllllllIIl = Minecraft.getMinecraft();
        double lllllllllllIII = (double)llllllllllllll.func_177958_n() - lllllllllllIIl.getRenderManager().viewerPosX;
        double llllllllllIlll = (double)llllllllllllll.func_177956_o() - lllllllllllIIl.getRenderManager().viewerPosY;
        double llllllllllIllI = (double)llllllllllllll.func_177952_p() - lllllllllllIIl.getRenderManager().viewerPosZ;
        AxisAlignedBB llllllllllIlIl = new AxisAlignedBB(lllllllllllIII, llllllllllIlll, llllllllllIllI, lllllllllllIII + 1.0, llllllllllIlll + 1.0, llllllllllIllI + 1.0);
        Tessellator llllllllllIlII = Tessellator.getInstance();
        BufferBuilder llllllllllIIll = llllllllllIlII.getBuffer();
        llllllllllIIll.begin(3, DefaultVertexFormats.POSITION_COLOR);
        llllllllllIIll.pos(llllllllllIlIl.minX, llllllllllIlIl.minY, llllllllllIlIl.minZ).color(llllllllllIIII, lllllllllIllll, lllllllllIlllI, lllllllllIllIl).endVertex();
        llllllllllIIll.pos(llllllllllIlIl.maxX, llllllllllIlIl.minY, llllllllllIlIl.minZ).color(llllllllllIIII, lllllllllIllll, lllllllllIlllI, lllllllllIllIl).endVertex();
        llllllllllIIll.pos(llllllllllIlIl.maxX, llllllllllIlIl.minY, llllllllllIlIl.maxZ).color(llllllllllIIII, lllllllllIllll, lllllllllIlllI, lllllllllIllIl).endVertex();
        llllllllllIIll.pos(llllllllllIlIl.minX, llllllllllIlIl.minY, llllllllllIlIl.maxZ).color(llllllllllIIII, lllllllllIllll, lllllllllIlllI, lllllllllIllIl).endVertex();
        llllllllllIlII.draw();
        GL11.glDisable((int)2848);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    static {
        INSTANCE = new NordTessellator();
    }

    public static void drawBoundingBoxBottomBlockPos(BlockPos lIIIIIIlIllIlIl, float lIIIIIIlIllIlII, int lIIIIIIlIllIIll, int lIIIIIIlIllIIlI, int lIIIIIIlIllIIIl, int lIIIIIIlIllIIII) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glLineWidth((float)lIIIIIIlIllIlII);
        Minecraft lIIIIIIlIllllII = Minecraft.getMinecraft();
        double lIIIIIIlIlllIll = (double)lIIIIIIlIllIlIl.func_177958_n() - lIIIIIIlIllllII.getRenderManager().viewerPosX;
        double lIIIIIIlIlllIlI = (double)lIIIIIIlIllIlIl.func_177956_o() - lIIIIIIlIllllII.getRenderManager().viewerPosY;
        double lIIIIIIlIlllIIl = (double)lIIIIIIlIllIlIl.func_177952_p() - lIIIIIIlIllllII.getRenderManager().viewerPosZ;
        AxisAlignedBB lIIIIIIlIlllIII = new AxisAlignedBB(lIIIIIIlIlllIll, lIIIIIIlIlllIlI, lIIIIIIlIlllIIl, lIIIIIIlIlllIll + 1.0, lIIIIIIlIlllIlI + 1.0, lIIIIIIlIlllIIl + 1.0);
        Tessellator lIIIIIIlIllIlll = Tessellator.getInstance();
        BufferBuilder lIIIIIIlIllIllI = lIIIIIIlIllIlll.getBuffer();
        lIIIIIIlIllIllI.begin(3, DefaultVertexFormats.POSITION_COLOR);
        lIIIIIIlIllIllI.pos(lIIIIIIlIlllIII.minX, lIIIIIIlIlllIII.minY, lIIIIIIlIlllIII.minZ).color(lIIIIIIlIllIIll, lIIIIIIlIllIIlI, lIIIIIIlIllIIIl, lIIIIIIlIllIIII).endVertex();
        lIIIIIIlIllIllI.pos(lIIIIIIlIlllIII.maxX, lIIIIIIlIlllIII.minY, lIIIIIIlIlllIII.minZ).color(lIIIIIIlIllIIll, lIIIIIIlIllIIlI, lIIIIIIlIllIIIl, lIIIIIIlIllIIII).endVertex();
        lIIIIIIlIllIllI.pos(lIIIIIIlIlllIII.maxX, lIIIIIIlIlllIII.minY, lIIIIIIlIlllIII.maxZ).color(lIIIIIIlIllIIll, lIIIIIIlIllIIlI, lIIIIIIlIllIIIl, lIIIIIIlIllIIII).endVertex();
        lIIIIIIlIllIllI.pos(lIIIIIIlIlllIII.minX, lIIIIIIlIlllIII.minY, lIIIIIIlIlllIII.maxZ).color(lIIIIIIlIllIIll, lIIIIIIlIllIIlI, lIIIIIIlIllIIIl, lIIIIIIlIllIIII).endVertex();
        lIIIIIIlIllIllI.pos(lIIIIIIlIlllIII.minX, lIIIIIIlIlllIII.minY, lIIIIIIlIlllIII.minZ).color(lIIIIIIlIllIIll, lIIIIIIlIllIIlI, lIIIIIIlIllIIIl, lIIIIIIlIllIIII).endVertex();
        lIIIIIIlIllIlll.draw();
        GL11.glDisable((int)2848);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void releaseGL() {
        GlStateManager.enableCull();
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.enableDepth();
    }

    public static void begin(int lIIIIIllIllllIl) {
        INSTANCE.getBuffer().begin(lIIIIIllIllllIl, DefaultVertexFormats.POSITION_COLOR);
    }

    public static BufferBuilder getBufferBuilder() {
        return INSTANCE.getBuffer();
    }

    public static void drawFullFace(AxisAlignedBB lllllIllllIlII, BlockPos lllllIllllIIll, float lllllIllllIIlI, int lllllIllllIIIl, int lllllIlllllIII, int lllllIllllIlll, int lllllIlllIlllI, int lllllIllllIlIl) {
        NordTessellator.prepare(7);
        NordTessellator.drawFace(lllllIllllIIll, lllllIllllIIIl, lllllIlllllIII, lllllIllllIlll, lllllIlllIlllI, 63);
        NordTessellator.release();
        NordTessellator.drawBoundingBoxFace(lllllIllllIlII, lllllIllllIIlI, lllllIllllIIIl, lllllIlllllIII, lllllIllllIlll, lllllIllllIlIl);
    }

    public static void drawFace(BlockPos lllllIllIllllI, int lllllIlllIIlII, int lllllIllIlllII) {
        int lllllIlllIIIlI = lllllIlllIIlII >>> 24 & 0xFF;
        int lllllIlllIIIIl = lllllIlllIIlII >>> 16 & 0xFF;
        int lllllIlllIIIII = lllllIlllIIlII >>> 8 & 0xFF;
        int lllllIllIlllll = lllllIlllIIlII & 0xFF;
        NordTessellator.drawFace(lllllIllIllllI, lllllIlllIIIIl, lllllIlllIIIII, lllllIllIlllll, lllllIlllIIIlI, lllllIllIlllII);
    }

    public static void drawBoundingBoxBottomBlockPosWest(BlockPos llllllllIllIII, float llllllllIlIlll, int llllllllIIlIIl, int llllllllIIlIII, int llllllllIIIlll, int llllllllIlIIll) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glLineWidth((float)llllllllIlIlll);
        Minecraft llllllllIlIIlI = Minecraft.getMinecraft();
        double llllllllIlIIIl = (double)llllllllIllIII.func_177958_n() - llllllllIlIIlI.getRenderManager().viewerPosX;
        double llllllllIlIIII = (double)llllllllIllIII.func_177956_o() - llllllllIlIIlI.getRenderManager().viewerPosY;
        double llllllllIIllll = (double)llllllllIllIII.func_177952_p() - llllllllIlIIlI.getRenderManager().viewerPosZ;
        AxisAlignedBB llllllllIIlllI = new AxisAlignedBB(llllllllIlIIIl, llllllllIlIIII, llllllllIIllll, llllllllIlIIIl + 1.0, llllllllIlIIII + 1.0, llllllllIIllll + 1.0);
        Tessellator llllllllIIllIl = Tessellator.getInstance();
        BufferBuilder llllllllIIllII = llllllllIIllIl.getBuffer();
        llllllllIIllII.begin(3, DefaultVertexFormats.POSITION_COLOR);
        llllllllIIllII.pos(llllllllIIlllI.minX, llllllllIIlllI.minY, llllllllIIlllI.minZ).color(llllllllIIlIIl, llllllllIIlIII, llllllllIIIlll, llllllllIlIIll / 2).endVertex();
        llllllllIIllII.pos(llllllllIIlllI.maxX, llllllllIIlllI.minY, llllllllIIlllI.minZ).color(llllllllIIlIIl, llllllllIIlIII, llllllllIIIlll, llllllllIlIIll / 2).endVertex();
        llllllllIIllII.pos(llllllllIIlllI.minX, llllllllIIlllI.minY, llllllllIIlllI.minZ).color(llllllllIIlIIl, llllllllIIlIII, llllllllIIIlll, llllllllIlIIll).endVertex();
        llllllllIIllII.pos(llllllllIIlllI.minX, llllllllIIlllI.minY, llllllllIIlllI.maxZ).color(llllllllIIlIIl, llllllllIIlIII, llllllllIIIlll, llllllllIlIIll).endVertex();
        llllllllIIllII.pos(llllllllIIlllI.maxX, llllllllIIlllI.minY, llllllllIIlllI.maxZ).color(llllllllIIlIIl, llllllllIIlIII, llllllllIIIlll, llllllllIlIIll).endVertex();
        llllllllIIllIl.draw();
        GL11.glDisable((int)2848);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void drawBoundingBoxBottomBlockPosXInMiddle2(BlockPos lIIIIIIIllIIlll, float lIIIIIIIllIIllI, int lIIIIIIIlllIIlI, int lIIIIIIIllIIlII, int lIIIIIIIlllIIII, int lIIIIIIIllIIIlI) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glLineWidth((float)lIIIIIIIllIIllI);
        Minecraft lIIIIIIIllIlllI = Minecraft.getMinecraft();
        double lIIIIIIIllIllIl = (double)lIIIIIIIllIIlll.func_177958_n() - lIIIIIIIllIlllI.getRenderManager().viewerPosX;
        double lIIIIIIIllIllII = (double)lIIIIIIIllIIlll.func_177956_o() - lIIIIIIIllIlllI.getRenderManager().viewerPosY;
        double lIIIIIIIllIlIll = (double)lIIIIIIIllIIlll.func_177952_p() - lIIIIIIIllIlllI.getRenderManager().viewerPosZ;
        AxisAlignedBB lIIIIIIIllIlIlI = new AxisAlignedBB(lIIIIIIIllIllIl, lIIIIIIIllIllII, lIIIIIIIllIlIll, lIIIIIIIllIllIl + 1.0, lIIIIIIIllIllII + 1.0, lIIIIIIIllIlIll + 1.0);
        Tessellator lIIIIIIIllIlIIl = Tessellator.getInstance();
        BufferBuilder lIIIIIIIllIlIII = lIIIIIIIllIlIIl.getBuffer();
        lIIIIIIIllIlIII.begin(3, DefaultVertexFormats.POSITION_COLOR);
        lIIIIIIIllIlIII.pos(lIIIIIIIllIlIlI.minX, lIIIIIIIllIlIlI.minY, lIIIIIIIllIlIlI.maxZ).color(lIIIIIIIlllIIlI, lIIIIIIIllIIlII, lIIIIIIIlllIIII, lIIIIIIIllIIIlI).endVertex();
        lIIIIIIIllIlIII.pos(lIIIIIIIllIlIlI.maxX, lIIIIIIIllIlIlI.minY, lIIIIIIIllIlIlI.minZ).color(lIIIIIIIlllIIlI, lIIIIIIIllIIlII, lIIIIIIIlllIIII, lIIIIIIIllIIIlI).endVertex();
        lIIIIIIIllIlIIl.draw();
        GL11.glDisable((int)2848);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void prepareGL() {
        GL11.glBlendFunc((int)770, (int)771);
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.glLineWidth((float)1.5f);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.disableLighting();
        GlStateManager.disableCull();
        GlStateManager.enableAlpha();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f);
    }

    public static void drawLines(BufferBuilder lIIIIIlIIlIIIll, float lIIIIIlIIlIlllI, float lIIIIIlIIlIIIIl, float lIIIIIlIIlIllII, float lIIIIIlIIIlllll, float lIIIIIlIIlIlIlI, float lIIIIIlIIlIlIIl, int lIIIIIlIIIlllII, int lIIIIIlIIIllIll, int lIIIIIlIIlIIllI, int lIIIIIlIIlIIlIl, int lIIIIIlIIlIIlII) {
        if ((lIIIIIlIIlIIlII & 0x11) != 0) {
            lIIIIIlIIlIIIll.pos((double)lIIIIIlIIlIlllI, (double)lIIIIIlIIlIIIIl, (double)lIIIIIlIIlIllII).color(lIIIIIlIIIlllII, lIIIIIlIIIllIll, lIIIIIlIIlIIllI, lIIIIIlIIlIIlIl).endVertex();
            lIIIIIlIIlIIIll.pos((double)lIIIIIlIIlIlllI, (double)lIIIIIlIIlIIIIl, (double)(lIIIIIlIIlIllII + lIIIIIlIIlIlIIl)).color(lIIIIIlIIIlllII, lIIIIIlIIIllIll, lIIIIIlIIlIIllI, lIIIIIlIIlIIlIl).endVertex();
        }
        if ((lIIIIIlIIlIIlII & 0x12) != 0) {
            lIIIIIlIIlIIIll.pos((double)lIIIIIlIIlIlllI, (double)(lIIIIIlIIlIIIIl + lIIIIIlIIlIlIlI), (double)lIIIIIlIIlIllII).color(lIIIIIlIIIlllII, lIIIIIlIIIllIll, lIIIIIlIIlIIllI, lIIIIIlIIlIIlIl).endVertex();
            lIIIIIlIIlIIIll.pos((double)lIIIIIlIIlIlllI, (double)(lIIIIIlIIlIIIIl + lIIIIIlIIlIlIlI), (double)(lIIIIIlIIlIllII + lIIIIIlIIlIlIIl)).color(lIIIIIlIIIlllII, lIIIIIlIIIllIll, lIIIIIlIIlIIllI, lIIIIIlIIlIIlIl).endVertex();
        }
        if ((lIIIIIlIIlIIlII & 0x21) != 0) {
            lIIIIIlIIlIIIll.pos((double)(lIIIIIlIIlIlllI + lIIIIIlIIIlllll), (double)lIIIIIlIIlIIIIl, (double)lIIIIIlIIlIllII).color(lIIIIIlIIIlllII, lIIIIIlIIIllIll, lIIIIIlIIlIIllI, lIIIIIlIIlIIlIl).endVertex();
            lIIIIIlIIlIIIll.pos((double)(lIIIIIlIIlIlllI + lIIIIIlIIIlllll), (double)lIIIIIlIIlIIIIl, (double)(lIIIIIlIIlIllII + lIIIIIlIIlIlIIl)).color(lIIIIIlIIIlllII, lIIIIIlIIIllIll, lIIIIIlIIlIIllI, lIIIIIlIIlIIlIl).endVertex();
        }
        if ((lIIIIIlIIlIIlII & 0x22) != 0) {
            lIIIIIlIIlIIIll.pos((double)(lIIIIIlIIlIlllI + lIIIIIlIIIlllll), (double)(lIIIIIlIIlIIIIl + lIIIIIlIIlIlIlI), (double)lIIIIIlIIlIllII).color(lIIIIIlIIIlllII, lIIIIIlIIIllIll, lIIIIIlIIlIIllI, lIIIIIlIIlIIlIl).endVertex();
            lIIIIIlIIlIIIll.pos((double)(lIIIIIlIIlIlllI + lIIIIIlIIIlllll), (double)(lIIIIIlIIlIIIIl + lIIIIIlIIlIlIlI), (double)(lIIIIIlIIlIllII + lIIIIIlIIlIlIIl)).color(lIIIIIlIIIlllII, lIIIIIlIIIllIll, lIIIIIlIIlIIllI, lIIIIIlIIlIIlIl).endVertex();
        }
        if ((lIIIIIlIIlIIlII & 5) != 0) {
            lIIIIIlIIlIIIll.pos((double)lIIIIIlIIlIlllI, (double)lIIIIIlIIlIIIIl, (double)lIIIIIlIIlIllII).color(lIIIIIlIIIlllII, lIIIIIlIIIllIll, lIIIIIlIIlIIllI, lIIIIIlIIlIIlIl).endVertex();
            lIIIIIlIIlIIIll.pos((double)(lIIIIIlIIlIlllI + lIIIIIlIIIlllll), (double)lIIIIIlIIlIIIIl, (double)lIIIIIlIIlIllII).color(lIIIIIlIIIlllII, lIIIIIlIIIllIll, lIIIIIlIIlIIllI, lIIIIIlIIlIIlIl).endVertex();
        }
        if ((lIIIIIlIIlIIlII & 6) != 0) {
            lIIIIIlIIlIIIll.pos((double)lIIIIIlIIlIlllI, (double)(lIIIIIlIIlIIIIl + lIIIIIlIIlIlIlI), (double)lIIIIIlIIlIllII).color(lIIIIIlIIIlllII, lIIIIIlIIIllIll, lIIIIIlIIlIIllI, lIIIIIlIIlIIlIl).endVertex();
            lIIIIIlIIlIIIll.pos((double)(lIIIIIlIIlIlllI + lIIIIIlIIIlllll), (double)(lIIIIIlIIlIIIIl + lIIIIIlIIlIlIlI), (double)lIIIIIlIIlIllII).color(lIIIIIlIIIlllII, lIIIIIlIIIllIll, lIIIIIlIIlIIllI, lIIIIIlIIlIIlIl).endVertex();
        }
        if ((lIIIIIlIIlIIlII & 9) != 0) {
            lIIIIIlIIlIIIll.pos((double)lIIIIIlIIlIlllI, (double)lIIIIIlIIlIIIIl, (double)(lIIIIIlIIlIllII + lIIIIIlIIlIlIIl)).color(lIIIIIlIIIlllII, lIIIIIlIIIllIll, lIIIIIlIIlIIllI, lIIIIIlIIlIIlIl).endVertex();
            lIIIIIlIIlIIIll.pos((double)(lIIIIIlIIlIlllI + lIIIIIlIIIlllll), (double)lIIIIIlIIlIIIIl, (double)(lIIIIIlIIlIllII + lIIIIIlIIlIlIIl)).color(lIIIIIlIIIlllII, lIIIIIlIIIllIll, lIIIIIlIIlIIllI, lIIIIIlIIlIIlIl).endVertex();
        }
        if ((lIIIIIlIIlIIlII & 0xA) != 0) {
            lIIIIIlIIlIIIll.pos((double)lIIIIIlIIlIlllI, (double)(lIIIIIlIIlIIIIl + lIIIIIlIIlIlIlI), (double)(lIIIIIlIIlIllII + lIIIIIlIIlIlIIl)).color(lIIIIIlIIIlllII, lIIIIIlIIIllIll, lIIIIIlIIlIIllI, lIIIIIlIIlIIlIl).endVertex();
            lIIIIIlIIlIIIll.pos((double)(lIIIIIlIIlIlllI + lIIIIIlIIIlllll), (double)(lIIIIIlIIlIIIIl + lIIIIIlIIlIlIlI), (double)(lIIIIIlIIlIllII + lIIIIIlIIlIlIIl)).color(lIIIIIlIIIlllII, lIIIIIlIIIllIll, lIIIIIlIIlIIllI, lIIIIIlIIlIIlIl).endVertex();
        }
        if ((lIIIIIlIIlIIlII & 0x14) != 0) {
            lIIIIIlIIlIIIll.pos((double)lIIIIIlIIlIlllI, (double)lIIIIIlIIlIIIIl, (double)lIIIIIlIIlIllII).color(lIIIIIlIIIlllII, lIIIIIlIIIllIll, lIIIIIlIIlIIllI, lIIIIIlIIlIIlIl).endVertex();
            lIIIIIlIIlIIIll.pos((double)lIIIIIlIIlIlllI, (double)(lIIIIIlIIlIIIIl + lIIIIIlIIlIlIlI), (double)lIIIIIlIIlIllII).color(lIIIIIlIIIlllII, lIIIIIlIIIllIll, lIIIIIlIIlIIllI, lIIIIIlIIlIIlIl).endVertex();
        }
        if ((lIIIIIlIIlIIlII & 0x24) != 0) {
            lIIIIIlIIlIIIll.pos((double)(lIIIIIlIIlIlllI + lIIIIIlIIIlllll), (double)lIIIIIlIIlIIIIl, (double)lIIIIIlIIlIllII).color(lIIIIIlIIIlllII, lIIIIIlIIIllIll, lIIIIIlIIlIIllI, lIIIIIlIIlIIlIl).endVertex();
            lIIIIIlIIlIIIll.pos((double)(lIIIIIlIIlIlllI + lIIIIIlIIIlllll), (double)(lIIIIIlIIlIIIIl + lIIIIIlIIlIlIlI), (double)lIIIIIlIIlIllII).color(lIIIIIlIIIlllII, lIIIIIlIIIllIll, lIIIIIlIIlIIllI, lIIIIIlIIlIIlIl).endVertex();
        }
        if ((lIIIIIlIIlIIlII & 0x18) != 0) {
            lIIIIIlIIlIIIll.pos((double)lIIIIIlIIlIlllI, (double)lIIIIIlIIlIIIIl, (double)(lIIIIIlIIlIllII + lIIIIIlIIlIlIIl)).color(lIIIIIlIIIlllII, lIIIIIlIIIllIll, lIIIIIlIIlIIllI, lIIIIIlIIlIIlIl).endVertex();
            lIIIIIlIIlIIIll.pos((double)lIIIIIlIIlIlllI, (double)(lIIIIIlIIlIIIIl + lIIIIIlIIlIlIlI), (double)(lIIIIIlIIlIllII + lIIIIIlIIlIlIIl)).color(lIIIIIlIIIlllII, lIIIIIlIIIllIll, lIIIIIlIIlIIllI, lIIIIIlIIlIIlIl).endVertex();
        }
        if ((lIIIIIlIIlIIlII & 0x28) != 0) {
            lIIIIIlIIlIIIll.pos((double)(lIIIIIlIIlIlllI + lIIIIIlIIIlllll), (double)lIIIIIlIIlIIIIl, (double)(lIIIIIlIIlIllII + lIIIIIlIIlIlIIl)).color(lIIIIIlIIIlllII, lIIIIIlIIIllIll, lIIIIIlIIlIIllI, lIIIIIlIIlIIlIl).endVertex();
            lIIIIIlIIlIIIll.pos((double)(lIIIIIlIIlIlllI + lIIIIIlIIIlllll), (double)(lIIIIIlIIlIIIIl + lIIIIIlIIlIlIlI), (double)(lIIIIIlIIlIllII + lIIIIIlIIlIlIIl)).color(lIIIIIlIIIlllII, lIIIIIlIIIllIll, lIIIIIlIIlIIllI, lIIIIIlIIlIIlIl).endVertex();
        }
    }

    public static void drawBoxSmall(double lIIIIIlIllllIlI, double lIIIIIlIllllIIl, double lIIIIIlIllllIII, int lIIIIIllIIIIIII, int lIIIIIlIlllllll) {
        int lIIIIIlIllllllI = lIIIIIllIIIIIII >>> 24 & 0xFF;
        int lIIIIIlIlllllIl = lIIIIIllIIIIIII >>> 16 & 0xFF;
        int lIIIIIlIlllllII = lIIIIIllIIIIIII >>> 8 & 0xFF;
        int lIIIIIlIllllIll = lIIIIIllIIIIIII & 0xFF;
        NordTessellator.drawBox(INSTANCE.getBuffer(), lIIIIIlIllllIlI, lIIIIIlIllllIIl, lIIIIIlIllllIII, 0.25f, 0.25f, 0.25f, lIIIIIlIlllllIl, lIIIIIlIlllllII, lIIIIIlIllllIll, lIIIIIlIllllllI, lIIIIIlIlllllll);
    }

    public static void drawBoundingBoxChestBlockPos(BlockPos llllllIllIIIll, float llllllIllIIIlI, int llllllIllIIIIl, int llllllIllIIIII, int llllllIlIlIIlI, int llllllIlIlIIIl) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glLineWidth((float)llllllIllIIIlI);
        Minecraft llllllIlIlllIl = Minecraft.getMinecraft();
        double llllllIlIlllII = (double)llllllIllIIIll.func_177958_n() + 0.06 - llllllIlIlllIl.getRenderManager().viewerPosX;
        double llllllIlIllIll = (double)llllllIllIIIll.func_177956_o() - llllllIlIlllIl.getRenderManager().viewerPosY;
        double llllllIlIllIlI = (double)llllllIllIIIll.func_177952_p() + 0.06 - llllllIlIlllIl.getRenderManager().viewerPosZ;
        AxisAlignedBB llllllIlIllIIl = new AxisAlignedBB(llllllIlIlllII, llllllIlIllIll, llllllIlIllIlI, llllllIlIlllII + 0.881, llllllIlIllIll + 0.875, llllllIlIllIlI + 0.881);
        Tessellator llllllIlIllIII = Tessellator.getInstance();
        BufferBuilder llllllIlIlIlll = llllllIlIllIII.getBuffer();
        llllllIlIlIlll.begin(3, DefaultVertexFormats.POSITION_COLOR);
        llllllIlIlIlll.pos(llllllIlIllIIl.minX, llllllIlIllIIl.minY, llllllIlIllIIl.minZ).color(llllllIllIIIIl, llllllIllIIIII, llllllIlIlIIlI, llllllIlIlIIIl).endVertex();
        llllllIlIlIlll.pos(llllllIlIllIIl.maxX, llllllIlIllIIl.minY, llllllIlIllIIl.minZ).color(llllllIllIIIIl, llllllIllIIIII, llllllIlIlIIlI, llllllIlIlIIIl).endVertex();
        llllllIlIlIlll.pos(llllllIlIllIIl.maxX, llllllIlIllIIl.minY, llllllIlIllIIl.maxZ).color(llllllIllIIIIl, llllllIllIIIII, llllllIlIlIIlI, llllllIlIlIIIl).endVertex();
        llllllIlIlIlll.pos(llllllIlIllIIl.minX, llllllIlIllIIl.minY, llllllIlIllIIl.maxZ).color(llllllIllIIIIl, llllllIllIIIII, llllllIlIlIIlI, llllllIlIlIIIl).endVertex();
        llllllIlIlIlll.pos(llllllIlIllIIl.minX, llllllIlIllIIl.minY, llllllIlIllIIl.minZ).color(llllllIllIIIIl, llllllIllIIIII, llllllIlIlIIlI, llllllIlIlIIIl).endVertex();
        llllllIlIllIII.draw();
        llllllIlIlIlll.begin(3, DefaultVertexFormats.POSITION_COLOR);
        llllllIlIlIlll.pos(llllllIlIllIIl.minX, llllllIlIllIIl.maxY, llllllIlIllIIl.minZ).color(llllllIllIIIIl, llllllIllIIIII, llllllIlIlIIlI, llllllIlIlIIIl).endVertex();
        llllllIlIlIlll.pos(llllllIlIllIIl.maxX, llllllIlIllIIl.maxY, llllllIlIllIIl.minZ).color(llllllIllIIIIl, llllllIllIIIII, llllllIlIlIIlI, llllllIlIlIIIl).endVertex();
        llllllIlIlIlll.pos(llllllIlIllIIl.maxX, llllllIlIllIIl.maxY, llllllIlIllIIl.maxZ).color(llllllIllIIIIl, llllllIllIIIII, llllllIlIlIIlI, llllllIlIlIIIl).endVertex();
        llllllIlIlIlll.pos(llllllIlIllIIl.minX, llllllIlIllIIl.maxY, llllllIlIllIIl.maxZ).color(llllllIllIIIIl, llllllIllIIIII, llllllIlIlIIlI, llllllIlIlIIIl).endVertex();
        llllllIlIlIlll.pos(llllllIlIllIIl.minX, llllllIlIllIIl.maxY, llllllIlIllIIl.minZ).color(llllllIllIIIIl, llllllIllIIIII, llllllIlIlIIlI, llllllIlIlIIIl).endVertex();
        llllllIlIllIII.draw();
        llllllIlIlIlll.begin(1, DefaultVertexFormats.POSITION_COLOR);
        llllllIlIlIlll.pos(llllllIlIllIIl.minX, llllllIlIllIIl.minY, llllllIlIllIIl.minZ).color(llllllIllIIIIl, llllllIllIIIII, llllllIlIlIIlI, llllllIlIlIIIl).endVertex();
        llllllIlIlIlll.pos(llllllIlIllIIl.minX, llllllIlIllIIl.maxY, llllllIlIllIIl.minZ).color(llllllIllIIIIl, llllllIllIIIII, llllllIlIlIIlI, llllllIlIlIIIl).endVertex();
        llllllIlIlIlll.pos(llllllIlIllIIl.maxX, llllllIlIllIIl.minY, llllllIlIllIIl.minZ).color(llllllIllIIIIl, llllllIllIIIII, llllllIlIlIIlI, llllllIlIlIIIl).endVertex();
        llllllIlIlIlll.pos(llllllIlIllIIl.maxX, llllllIlIllIIl.maxY, llllllIlIllIIl.minZ).color(llllllIllIIIIl, llllllIllIIIII, llllllIlIlIIlI, llllllIlIlIIIl).endVertex();
        llllllIlIlIlll.pos(llllllIlIllIIl.maxX, llllllIlIllIIl.minY, llllllIlIllIIl.maxZ).color(llllllIllIIIIl, llllllIllIIIII, llllllIlIlIIlI, llllllIlIlIIIl).endVertex();
        llllllIlIlIlll.pos(llllllIlIllIIl.maxX, llllllIlIllIIl.maxY, llllllIlIllIIl.maxZ).color(llllllIllIIIIl, llllllIllIIIII, llllllIlIlIIlI, llllllIlIlIIIl).endVertex();
        llllllIlIlIlll.pos(llllllIlIllIIl.minX, llllllIlIllIIl.minY, llllllIlIllIIl.maxZ).color(llllllIllIIIIl, llllllIllIIIII, llllllIlIlIIlI, llllllIlIlIIIl).endVertex();
        llllllIlIlIlll.pos(llllllIlIllIIl.minX, llllllIlIllIIl.maxY, llllllIlIllIIl.maxZ).color(llllllIllIIIIl, llllllIllIIIII, llllllIlIlIIlI, llllllIlIlIIIl).endVertex();
        llllllIlIllIII.draw();
        GL11.glDisable((int)2848);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void drawBox(BlockPos lIIIIIlIllIIlIl, int lIIIIIlIllIIlII, int lIIIIIlIllIlIIl, int lIIIIIlIllIlIII, int lIIIIIlIllIIIIl, int lIIIIIlIllIIllI) {
        NordTessellator.drawBox(INSTANCE.getBuffer(), lIIIIIlIllIIlIl.func_177958_n(), lIIIIIlIllIIlIl.func_177956_o(), lIIIIIlIllIIlIl.func_177952_p(), 1.0f, 1.0f, 1.0f, lIIIIIlIllIIlII, lIIIIIlIllIlIIl, lIIIIIlIllIlIII, lIIIIIlIllIIIIl, lIIIIIlIllIIllI);
    }

    public static void drawFace(BufferBuilder lllllIlIIIIIIl, float lllllIlIIIllII, float lllllIlIIIlIll, float lllllIlIIIlIlI, float lllllIlIIIlIIl, float lllllIlIIIlIII, float lllllIIlllllII, int lllllIlIIIIllI, int lllllIIllllIlI, int lllllIlIIIIlII, int lllllIlIIIIIll, int lllllIIlllIlll) {
        if ((lllllIIlllIlll & 1) != 0) {
            lllllIlIIIIIIl.pos((double)(lllllIlIIIllII + lllllIlIIIlIIl), (double)lllllIlIIIlIll, (double)lllllIlIIIlIlI).color(lllllIlIIIIllI, lllllIIllllIlI, lllllIlIIIIlII, lllllIlIIIIIll).endVertex();
            lllllIlIIIIIIl.pos((double)(lllllIlIIIllII + lllllIlIIIlIIl), (double)lllllIlIIIlIll, (double)(lllllIlIIIlIlI + lllllIIlllllII)).color(lllllIlIIIIllI, lllllIIllllIlI, lllllIlIIIIlII, lllllIlIIIIIll).endVertex();
            lllllIlIIIIIIl.pos((double)lllllIlIIIllII, (double)lllllIlIIIlIll, (double)(lllllIlIIIlIlI + lllllIIlllllII)).color(lllllIlIIIIllI, lllllIIllllIlI, lllllIlIIIIlII, lllllIlIIIIIll).endVertex();
            lllllIlIIIIIIl.pos((double)lllllIlIIIllII, (double)lllllIlIIIlIll, (double)lllllIlIIIlIlI).color(lllllIlIIIIllI, lllllIIllllIlI, lllllIlIIIIlII, lllllIlIIIIIll).endVertex();
        }
    }

    private static void disableGL2D() {
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glDisable((int)2848);
        GL11.glHint((int)3154, (int)4352);
        GL11.glHint((int)3155, (int)4352);
    }

    private static void enableGL2D() {
        GL11.glDisable((int)2929);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDepthMask((boolean)true);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glHint((int)3155, (int)4354);
    }

    public NordTessellator() {
        super(0x200000);
        NordTessellator lIIIIIlllIIIlII;
    }
}

