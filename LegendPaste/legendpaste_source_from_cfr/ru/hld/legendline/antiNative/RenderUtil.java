/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.culling.Frustum
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  org.lwjgl.opengl.GL11
 */
package ru.hld.legendline.antiNative;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

public class RenderUtil {
    public static /* synthetic */ Minecraft mc;
    private static final /* synthetic */ Frustum frustrum;
    private static final /* synthetic */ double DOUBLE_PI = Math.PI * 2;

    public static void drawSelectionBoundingBox(AxisAlignedBB llllllllllllllllIIlIIIlIllllllll) {
        Tessellator llllllllllllllllIIlIIIlIlllllllI = Tessellator.getInstance();
        BufferBuilder llllllllllllllllIIlIIIlIllllllIl = llllllllllllllllIIlIIIlIlllllllI.getBuffer();
        llllllllllllllllIIlIIIlIllllllIl.begin(3, DefaultVertexFormats.POSITION);
        llllllllllllllllIIlIIIlIllllllIl.pos(llllllllllllllllIIlIIIlIllllllll.minX, llllllllllllllllIIlIIIlIllllllll.minY, llllllllllllllllIIlIIIlIllllllll.minZ).endVertex();
        llllllllllllllllIIlIIIlIllllllIl.pos(llllllllllllllllIIlIIIlIllllllll.maxX, llllllllllllllllIIlIIIlIllllllll.minY, llllllllllllllllIIlIIIlIllllllll.minZ).endVertex();
        llllllllllllllllIIlIIIlIllllllIl.pos(llllllllllllllllIIlIIIlIllllllll.maxX, llllllllllllllllIIlIIIlIllllllll.minY, llllllllllllllllIIlIIIlIllllllll.maxZ).endVertex();
        llllllllllllllllIIlIIIlIllllllIl.pos(llllllllllllllllIIlIIIlIllllllll.minX, llllllllllllllllIIlIIIlIllllllll.minY, llllllllllllllllIIlIIIlIllllllll.maxZ).endVertex();
        llllllllllllllllIIlIIIlIllllllIl.pos(llllllllllllllllIIlIIIlIllllllll.minX, llllllllllllllllIIlIIIlIllllllll.minY, llllllllllllllllIIlIIIlIllllllll.minZ).endVertex();
        llllllllllllllllIIlIIIlIlllllllI.draw();
        llllllllllllllllIIlIIIlIllllllIl.begin(3, DefaultVertexFormats.POSITION);
        llllllllllllllllIIlIIIlIllllllIl.pos(llllllllllllllllIIlIIIlIllllllll.minX, llllllllllllllllIIlIIIlIllllllll.maxY, llllllllllllllllIIlIIIlIllllllll.minZ).endVertex();
        llllllllllllllllIIlIIIlIllllllIl.pos(llllllllllllllllIIlIIIlIllllllll.maxX, llllllllllllllllIIlIIIlIllllllll.maxY, llllllllllllllllIIlIIIlIllllllll.minZ).endVertex();
        llllllllllllllllIIlIIIlIllllllIl.pos(llllllllllllllllIIlIIIlIllllllll.maxX, llllllllllllllllIIlIIIlIllllllll.maxY, llllllllllllllllIIlIIIlIllllllll.maxZ).endVertex();
        llllllllllllllllIIlIIIlIllllllIl.pos(llllllllllllllllIIlIIIlIllllllll.minX, llllllllllllllllIIlIIIlIllllllll.maxY, llllllllllllllllIIlIIIlIllllllll.maxZ).endVertex();
        llllllllllllllllIIlIIIlIllllllIl.pos(llllllllllllllllIIlIIIlIllllllll.minX, llllllllllllllllIIlIIIlIllllllll.maxY, llllllllllllllllIIlIIIlIllllllll.minZ).endVertex();
        llllllllllllllllIIlIIIlIlllllllI.draw();
        llllllllllllllllIIlIIIlIllllllIl.begin(1, DefaultVertexFormats.POSITION);
        llllllllllllllllIIlIIIlIllllllIl.pos(llllllllllllllllIIlIIIlIllllllll.minX, llllllllllllllllIIlIIIlIllllllll.minY, llllllllllllllllIIlIIIlIllllllll.minZ).endVertex();
        llllllllllllllllIIlIIIlIllllllIl.pos(llllllllllllllllIIlIIIlIllllllll.minX, llllllllllllllllIIlIIIlIllllllll.maxY, llllllllllllllllIIlIIIlIllllllll.minZ).endVertex();
        llllllllllllllllIIlIIIlIllllllIl.pos(llllllllllllllllIIlIIIlIllllllll.maxX, llllllllllllllllIIlIIIlIllllllll.minY, llllllllllllllllIIlIIIlIllllllll.minZ).endVertex();
        llllllllllllllllIIlIIIlIllllllIl.pos(llllllllllllllllIIlIIIlIllllllll.maxX, llllllllllllllllIIlIIIlIllllllll.maxY, llllllllllllllllIIlIIIlIllllllll.minZ).endVertex();
        llllllllllllllllIIlIIIlIllllllIl.pos(llllllllllllllllIIlIIIlIllllllll.maxX, llllllllllllllllIIlIIIlIllllllll.minY, llllllllllllllllIIlIIIlIllllllll.maxZ).endVertex();
        llllllllllllllllIIlIIIlIllllllIl.pos(llllllllllllllllIIlIIIlIllllllll.maxX, llllllllllllllllIIlIIIlIllllllll.maxY, llllllllllllllllIIlIIIlIllllllll.maxZ).endVertex();
        llllllllllllllllIIlIIIlIllllllIl.pos(llllllllllllllllIIlIIIlIllllllll.minX, llllllllllllllllIIlIIIlIllllllll.minY, llllllllllllllllIIlIIIlIllllllll.maxZ).endVertex();
        llllllllllllllllIIlIIIlIllllllIl.pos(llllllllllllllllIIlIIIlIllllllll.minX, llllllllllllllllIIlIIIlIllllllll.maxY, llllllllllllllllIIlIIIlIllllllll.maxZ).endVertex();
        llllllllllllllllIIlIIIlIlllllllI.draw();
    }

    public static void drawColorBox(AxisAlignedBB llllllllllllllllIIlIIIlIllllIIlI, float llllllllllllllllIIlIIIlIlllIlIlI, float llllllllllllllllIIlIIIlIllllIIII, float llllllllllllllllIIlIIIlIlllIllll, float llllllllllllllllIIlIIIlIlllIlllI) {
        Tessellator llllllllllllllllIIlIIIlIlllIllIl = Tessellator.getInstance();
        BufferBuilder llllllllllllllllIIlIIIlIlllIllII = llllllllllllllllIIlIIIlIlllIllIl.getBuffer();
        llllllllllllllllIIlIIIlIlllIllII.begin(7, DefaultVertexFormats.POSITION_TEX);
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.minX, llllllllllllllllIIlIIIlIllllIIlI.minY, llllllllllllllllIIlIIIlIllllIIlI.minZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.minX, llllllllllllllllIIlIIIlIllllIIlI.maxY, llllllllllllllllIIlIIIlIllllIIlI.minZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.maxX, llllllllllllllllIIlIIIlIllllIIlI.minY, llllllllllllllllIIlIIIlIllllIIlI.minZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.maxX, llllllllllllllllIIlIIIlIllllIIlI.maxY, llllllllllllllllIIlIIIlIllllIIlI.minZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.maxX, llllllllllllllllIIlIIIlIllllIIlI.minY, llllllllllllllllIIlIIIlIllllIIlI.maxZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.maxX, llllllllllllllllIIlIIIlIllllIIlI.maxY, llllllllllllllllIIlIIIlIllllIIlI.maxZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.minX, llllllllllllllllIIlIIIlIllllIIlI.minY, llllllllllllllllIIlIIIlIllllIIlI.maxZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.minX, llllllllllllllllIIlIIIlIllllIIlI.maxY, llllllllllllllllIIlIIIlIllllIIlI.maxZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllIl.draw();
        llllllllllllllllIIlIIIlIlllIllII.begin(7, DefaultVertexFormats.POSITION_TEX);
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.maxX, llllllllllllllllIIlIIIlIllllIIlI.maxY, llllllllllllllllIIlIIIlIllllIIlI.minZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.maxX, llllllllllllllllIIlIIIlIllllIIlI.minY, llllllllllllllllIIlIIIlIllllIIlI.minZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.minX, llllllllllllllllIIlIIIlIllllIIlI.maxY, llllllllllllllllIIlIIIlIllllIIlI.minZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.minX, llllllllllllllllIIlIIIlIllllIIlI.minY, llllllllllllllllIIlIIIlIllllIIlI.minZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.minX, llllllllllllllllIIlIIIlIllllIIlI.maxY, llllllllllllllllIIlIIIlIllllIIlI.maxZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.minX, llllllllllllllllIIlIIIlIllllIIlI.minY, llllllllllllllllIIlIIIlIllllIIlI.maxZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.maxX, llllllllllllllllIIlIIIlIllllIIlI.maxY, llllllllllllllllIIlIIIlIllllIIlI.maxZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.maxX, llllllllllllllllIIlIIIlIllllIIlI.minY, llllllllllllllllIIlIIIlIllllIIlI.maxZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllIl.draw();
        llllllllllllllllIIlIIIlIlllIllII.begin(7, DefaultVertexFormats.POSITION_TEX);
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.minX, llllllllllllllllIIlIIIlIllllIIlI.maxY, llllllllllllllllIIlIIIlIllllIIlI.minZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.maxX, llllllllllllllllIIlIIIlIllllIIlI.maxY, llllllllllllllllIIlIIIlIllllIIlI.minZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.maxX, llllllllllllllllIIlIIIlIllllIIlI.maxY, llllllllllllllllIIlIIIlIllllIIlI.maxZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.minX, llllllllllllllllIIlIIIlIllllIIlI.maxY, llllllllllllllllIIlIIIlIllllIIlI.maxZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.minX, llllllllllllllllIIlIIIlIllllIIlI.maxY, llllllllllllllllIIlIIIlIllllIIlI.minZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.minX, llllllllllllllllIIlIIIlIllllIIlI.maxY, llllllllllllllllIIlIIIlIllllIIlI.maxZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.maxX, llllllllllllllllIIlIIIlIllllIIlI.maxY, llllllllllllllllIIlIIIlIllllIIlI.maxZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.maxX, llllllllllllllllIIlIIIlIllllIIlI.maxY, llllllllllllllllIIlIIIlIllllIIlI.minZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllIl.draw();
        llllllllllllllllIIlIIIlIlllIllII.begin(7, DefaultVertexFormats.POSITION_TEX);
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.minX, llllllllllllllllIIlIIIlIllllIIlI.minY, llllllllllllllllIIlIIIlIllllIIlI.minZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.maxX, llllllllllllllllIIlIIIlIllllIIlI.minY, llllllllllllllllIIlIIIlIllllIIlI.minZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.maxX, llllllllllllllllIIlIIIlIllllIIlI.minY, llllllllllllllllIIlIIIlIllllIIlI.maxZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.minX, llllllllllllllllIIlIIIlIllllIIlI.minY, llllllllllllllllIIlIIIlIllllIIlI.maxZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.minX, llllllllllllllllIIlIIIlIllllIIlI.minY, llllllllllllllllIIlIIIlIllllIIlI.minZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.minX, llllllllllllllllIIlIIIlIllllIIlI.minY, llllllllllllllllIIlIIIlIllllIIlI.maxZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.maxX, llllllllllllllllIIlIIIlIllllIIlI.minY, llllllllllllllllIIlIIIlIllllIIlI.maxZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.maxX, llllllllllllllllIIlIIIlIllllIIlI.minY, llllllllllllllllIIlIIIlIllllIIlI.minZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllIl.draw();
        llllllllllllllllIIlIIIlIlllIllII.begin(7, DefaultVertexFormats.POSITION_TEX);
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.minX, llllllllllllllllIIlIIIlIllllIIlI.minY, llllllllllllllllIIlIIIlIllllIIlI.minZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.minX, llllllllllllllllIIlIIIlIllllIIlI.maxY, llllllllllllllllIIlIIIlIllllIIlI.minZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.minX, llllllllllllllllIIlIIIlIllllIIlI.minY, llllllllllllllllIIlIIIlIllllIIlI.maxZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.minX, llllllllllllllllIIlIIIlIllllIIlI.maxY, llllllllllllllllIIlIIIlIllllIIlI.maxZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.maxX, llllllllllllllllIIlIIIlIllllIIlI.minY, llllllllllllllllIIlIIIlIllllIIlI.maxZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.maxX, llllllllllllllllIIlIIIlIllllIIlI.maxY, llllllllllllllllIIlIIIlIllllIIlI.maxZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.maxX, llllllllllllllllIIlIIIlIllllIIlI.minY, llllllllllllllllIIlIIIlIllllIIlI.minZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.maxX, llllllllllllllllIIlIIIlIllllIIlI.maxY, llllllllllllllllIIlIIIlIllllIIlI.minZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllIl.draw();
        llllllllllllllllIIlIIIlIlllIllII.begin(7, DefaultVertexFormats.POSITION_TEX);
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.minX, llllllllllllllllIIlIIIlIllllIIlI.maxY, llllllllllllllllIIlIIIlIllllIIlI.maxZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.minX, llllllllllllllllIIlIIIlIllllIIlI.minY, llllllllllllllllIIlIIIlIllllIIlI.maxZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.minX, llllllllllllllllIIlIIIlIllllIIlI.maxY, llllllllllllllllIIlIIIlIllllIIlI.minZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.minX, llllllllllllllllIIlIIIlIllllIIlI.minY, llllllllllllllllIIlIIIlIllllIIlI.minZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.maxX, llllllllllllllllIIlIIIlIllllIIlI.maxY, llllllllllllllllIIlIIIlIllllIIlI.minZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.maxX, llllllllllllllllIIlIIIlIllllIIlI.minY, llllllllllllllllIIlIIIlIllllIIlI.minZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.maxX, llllllllllllllllIIlIIIlIllllIIlI.maxY, llllllllllllllllIIlIIIlIllllIIlI.maxZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllII.pos(llllllllllllllllIIlIIIlIllllIIlI.maxX, llllllllllllllllIIlIIIlIllllIIlI.minY, llllllllllllllllIIlIIIlIllllIIlI.maxZ).color(llllllllllllllllIIlIIIlIlllIlIlI, llllllllllllllllIIlIIIlIllllIIII, llllllllllllllllIIlIIIlIlllIllll, llllllllllllllllIIlIIIlIlllIlllI).endVertex();
        llllllllllllllllIIlIIIlIlllIllIl.draw();
    }

    public static void drawRoundedRect(int llllllllllllllllIIlIIlIlIlIIlllI, int llllllllllllllllIIlIIlIlIlIlIlII, int llllllllllllllllIIlIIlIlIlIIllII, int llllllllllllllllIIlIIlIlIlIIlIll, int llllllllllllllllIIlIIlIlIlIIlIlI) {
        int llllllllllllllllIIlIIlIlIlIlIIII = llllllllllllllllIIlIIlIlIlIIlllI + llllllllllllllllIIlIIlIlIlIIllII;
        int llllllllllllllllIIlIIlIlIlIIllll = llllllllllllllllIIlIIlIlIlIlIlII + llllllllllllllllIIlIIlIlIlIIlIll;
        RenderUtil.drawRect(llllllllllllllllIIlIIlIlIlIIlllI + 1, llllllllllllllllIIlIIlIlIlIlIlII, llllllllllllllllIIlIIlIlIlIlIIII - 1, llllllllllllllllIIlIIlIlIlIIllll, llllllllllllllllIIlIIlIlIlIIlIlI);
        RenderUtil.drawRect(llllllllllllllllIIlIIlIlIlIIlllI, llllllllllllllllIIlIIlIlIlIlIlII + 1, llllllllllllllllIIlIIlIlIlIlIIII, llllllllllllllllIIlIIlIlIlIIllll - 1, llllllllllllllllIIlIIlIlIlIIlIlI);
    }

    static {
        mc = Minecraft.getMinecraft();
        frustrum = new Frustum();
    }

    public static Color injectAlpha(Color llllllllllllllllIIlIIlIIIIlIlIll, int llllllllllllllllIIlIIlIIIIlIlIlI) {
        return new Color(llllllllllllllllIIlIIlIIIIlIlIll.getRed(), llllllllllllllllIIlIIlIIIIlIlIll.getGreen(), llllllllllllllllIIlIIlIIIIlIlIll.getBlue(), llllllllllllllllIIlIIlIIIIlIlIlI);
    }

    public static void drawUnfilledCircle(float llllllllllllllllIIlIIlIlllllIIIl, float llllllllllllllllIIlIIlIllllIIlll, float llllllllllllllllIIlIIlIllllIllll, float llllllllllllllllIIlIIlIllllIIlIl, int llllllllllllllllIIlIIlIllllIllIl) {
        float llllllllllllllllIIlIIlIllllIllII = (float)(llllllllllllllllIIlIIlIllllIllIl >> 16 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIlIllllIlIll = (float)(llllllllllllllllIIlIIlIllllIllIl >> 8 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIlIllllIlIlI = (float)(llllllllllllllllIIlIIlIllllIllIl & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIlIllllIlIIl = (float)(llllllllllllllllIIlIIlIllllIllIl >> 24 & 0xFF) / 255.0f;
        GL11.glEnable((int)2848);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDepthMask((boolean)true);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glHint((int)3155, (int)4354);
        GlStateManager.enableBlend();
        GL11.glColor4f((float)llllllllllllllllIIlIIlIllllIllII, (float)llllllllllllllllIIlIIlIllllIlIll, (float)llllllllllllllllIIlIIlIllllIlIlI, (float)llllllllllllllllIIlIIlIllllIlIIl);
        GL11.glLineWidth((float)llllllllllllllllIIlIIlIllllIIlIl);
        GL11.glBegin((int)2);
        for (int llllllllllllllllIIlIIlIlllllIIlI = 0; llllllllllllllllIIlIIlIlllllIIlI <= 360; ++llllllllllllllllIIlIIlIlllllIIlI) {
            GL11.glVertex2d((double)((double)llllllllllllllllIIlIIlIlllllIIIl + Math.sin((double)llllllllllllllllIIlIIlIlllllIIlI * Math.PI / 180.0) * (double)llllllllllllllllIIlIIlIllllIllll), (double)((double)llllllllllllllllIIlIIlIllllIIlll + Math.cos((double)llllllllllllllllIIlIIlIlllllIIlI * Math.PI / 180.0) * (double)llllllllllllllllIIlIIlIllllIllll));
        }
        GL11.glEnd();
        GL11.glScalef((float)2.0f, (float)2.0f, (float)2.0f);
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glDisable((int)2848);
        GL11.glHint((int)3154, (int)4352);
        GL11.glHint((int)3155, (int)4352);
        GlStateManager.disableBlend();
    }

    public static void drawOctagon(float llllllllllllllllIIlIIlIllIlllIll, float llllllllllllllllIIlIIlIllIlllIlI, float llllllllllllllllIIlIIlIllIlllIIl, float llllllllllllllllIIlIIlIllIlllIII, float llllllllllllllllIIlIIlIllIllIlll, float llllllllllllllllIIlIIlIllIlIlIll, int llllllllllllllllIIlIIlIllIllIlIl) {
        float llllllllllllllllIIlIIlIllIllIlII = RenderUtil.convertColor(24, llllllllllllllllIIlIIlIllIllIlIl);
        float llllllllllllllllIIlIIlIllIllIIll = RenderUtil.convertColor(16, llllllllllllllllIIlIIlIllIllIlIl);
        float llllllllllllllllIIlIIlIllIllIIlI = RenderUtil.convertColor(8, llllllllllllllllIIlIIlIllIllIlIl);
        float llllllllllllllllIIlIIlIllIllIIIl = RenderUtil.convertColor(0, llllllllllllllllIIlIIlIllIllIlIl);
        RenderUtil.glRenderStart();
        GL11.glColor4f((float)llllllllllllllllIIlIIlIllIllIIll, (float)llllllllllllllllIIlIIlIllIllIIlI, (float)llllllllllllllllIIlIIlIllIllIIIl, (float)llllllllllllllllIIlIIlIllIllIlII);
        GL11.glBegin((int)9);
        GL11.glVertex2d((double)(llllllllllllllllIIlIIlIllIlllIll + llllllllllllllllIIlIIlIllIllIlll), (double)llllllllllllllllIIlIIlIllIlllIlI);
        GL11.glVertex2d((double)(llllllllllllllllIIlIIlIllIlllIll + llllllllllllllllIIlIIlIllIlllIIl - llllllllllllllllIIlIIlIllIllIlll), (double)llllllllllllllllIIlIIlIllIlllIlI);
        GL11.glVertex2d((double)(llllllllllllllllIIlIIlIllIlllIll + llllllllllllllllIIlIIlIllIlllIIl - llllllllllllllllIIlIIlIllIllIlll), (double)llllllllllllllllIIlIIlIllIlllIlI);
        GL11.glVertex2d((double)(llllllllllllllllIIlIIlIllIlllIll + llllllllllllllllIIlIIlIllIlllIIl), (double)(llllllllllllllllIIlIIlIllIlllIlI + llllllllllllllllIIlIIlIllIlllIII / 2.0f - llllllllllllllllIIlIIlIllIlIlIll));
        GL11.glVertex2d((double)(llllllllllllllllIIlIIlIllIlllIll + llllllllllllllllIIlIIlIllIlllIIl), (double)(llllllllllllllllIIlIIlIllIlllIlI + llllllllllllllllIIlIIlIllIlllIII / 2.0f - llllllllllllllllIIlIIlIllIlIlIll));
        GL11.glVertex2d((double)(llllllllllllllllIIlIIlIllIlllIll + llllllllllllllllIIlIIlIllIlllIIl), (double)(llllllllllllllllIIlIIlIllIlllIlI + llllllllllllllllIIlIIlIllIlllIII / 2.0f + llllllllllllllllIIlIIlIllIlIlIll));
        GL11.glVertex2d((double)(llllllllllllllllIIlIIlIllIlllIll + llllllllllllllllIIlIIlIllIlllIIl), (double)(llllllllllllllllIIlIIlIllIlllIlI + llllllllllllllllIIlIIlIllIlllIII / 2.0f + llllllllllllllllIIlIIlIllIlIlIll));
        GL11.glVertex2d((double)(llllllllllllllllIIlIIlIllIlllIll + llllllllllllllllIIlIIlIllIlllIIl - llllllllllllllllIIlIIlIllIllIlll), (double)(llllllllllllllllIIlIIlIllIlllIlI + llllllllllllllllIIlIIlIllIlllIII));
        GL11.glVertex2d((double)(llllllllllllllllIIlIIlIllIlllIll + llllllllllllllllIIlIIlIllIlllIIl - llllllllllllllllIIlIIlIllIllIlll), (double)(llllllllllllllllIIlIIlIllIlllIlI + llllllllllllllllIIlIIlIllIlllIII));
        GL11.glVertex2d((double)(llllllllllllllllIIlIIlIllIlllIll + llllllllllllllllIIlIIlIllIllIlll), (double)(llllllllllllllllIIlIIlIllIlllIlI + llllllllllllllllIIlIIlIllIlllIII));
        GL11.glVertex2d((double)(llllllllllllllllIIlIIlIllIlllIll + llllllllllllllllIIlIIlIllIllIlll), (double)(llllllllllllllllIIlIIlIllIlllIlI + llllllllllllllllIIlIIlIllIlllIII));
        GL11.glVertex2d((double)llllllllllllllllIIlIIlIllIlllIll, (double)(llllllllllllllllIIlIIlIllIlllIlI + llllllllllllllllIIlIIlIllIlllIII / 2.0f + llllllllllllllllIIlIIlIllIlIlIll));
        GL11.glVertex2d((double)llllllllllllllllIIlIIlIllIlllIll, (double)(llllllllllllllllIIlIIlIllIlllIlI + llllllllllllllllIIlIIlIllIlllIII / 2.0f + llllllllllllllllIIlIIlIllIlIlIll));
        GL11.glVertex2d((double)llllllllllllllllIIlIIlIllIlllIll, (double)(llllllllllllllllIIlIIlIllIlllIlI + llllllllllllllllIIlIIlIllIlllIII / 2.0f - llllllllllllllllIIlIIlIllIlIlIll));
        GL11.glVertex2d((double)llllllllllllllllIIlIIlIllIlllIll, (double)(llllllllllllllllIIlIIlIllIlllIlI + llllllllllllllllIIlIIlIllIlllIII / 2.0f - llllllllllllllllIIlIIlIllIlIlIll));
        GL11.glVertex2d((double)(llllllllllllllllIIlIIlIllIlllIll + llllllllllllllllIIlIIlIllIllIlll), (double)llllllllllllllllIIlIIlIllIlllIlI);
        GL11.glEnd();
        RenderUtil.glRenderStop();
    }

    public static boolean isInViewFrustrum(Entity llllllllllllllllIIlIIIllIllllIIl) {
        return RenderUtil.isInViewFrustrum(llllllllllllllllIIlIIIllIllllIIl.getEntityBoundingBox()) || llllllllllllllllIIlIIIllIllllIIl.ignoreFrustumCheck;
    }

    public static void drawGradientSideways(double llllllllllllllllIIlIIlIIlIllIIlI, double llllllllllllllllIIlIIlIIlIllIIIl, double llllllllllllllllIIlIIlIIlIlIIIlI, double llllllllllllllllIIlIIlIIlIlIIIIl, int llllllllllllllllIIlIIlIIlIlIlllI, int llllllllllllllllIIlIIlIIlIIlllll) {
        float llllllllllllllllIIlIIlIIlIlIllII = (float)(llllllllllllllllIIlIIlIIlIlIlllI >> 24 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIlIIlIlIlIll = (float)(llllllllllllllllIIlIIlIIlIlIlllI >> 16 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIlIIlIlIlIlI = (float)(llllllllllllllllIIlIIlIIlIlIlllI >> 8 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIlIIlIlIlIIl = (float)(llllllllllllllllIIlIIlIIlIlIlllI & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIlIIlIlIlIII = (float)(llllllllllllllllIIlIIlIIlIIlllll >> 24 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIlIIlIlIIlll = (float)(llllllllllllllllIIlIIlIIlIIlllll >> 16 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIlIIlIlIIllI = (float)(llllllllllllllllIIlIIlIIlIIlllll >> 8 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIlIIlIlIIlIl = (float)(llllllllllllllllIIlIIlIIlIIlllll & 0xFF) / 255.0f;
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GL11.glShadeModel((int)7425);
        GL11.glPushMatrix();
        GL11.glBegin((int)7);
        GL11.glColor4f((float)llllllllllllllllIIlIIlIIlIlIlIll, (float)llllllllllllllllIIlIIlIIlIlIlIlI, (float)llllllllllllllllIIlIIlIIlIlIlIIl, (float)llllllllllllllllIIlIIlIIlIlIllII);
        GL11.glVertex2d((double)llllllllllllllllIIlIIlIIlIllIIlI, (double)llllllllllllllllIIlIIlIIlIllIIIl);
        GL11.glVertex2d((double)llllllllllllllllIIlIIlIIlIllIIlI, (double)llllllllllllllllIIlIIlIIlIlIIIIl);
        GL11.glColor4f((float)llllllllllllllllIIlIIlIIlIlIIlll, (float)llllllllllllllllIIlIIlIIlIlIIllI, (float)llllllllllllllllIIlIIlIIlIlIIlIl, (float)llllllllllllllllIIlIIlIIlIlIlIII);
        GL11.glVertex2d((double)llllllllllllllllIIlIIlIIlIlIIIlI, (double)llllllllllllllllIIlIIlIIlIlIIIIl);
        GL11.glVertex2d((double)llllllllllllllllIIlIIlIIlIlIIIlI, (double)llllllllllllllllIIlIIlIIlIllIIIl);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
    }

    public static double interpolate(double llllllllllllllllIIlIIllIlIIlIlll, double llllllllllllllllIIlIIllIlIIlIllI, double llllllllllllllllIIlIIllIlIIlIlIl) {
        return llllllllllllllllIIlIIllIlIIlIllI + (llllllllllllllllIIlIIllIlIIlIlll - llllllllllllllllIIlIIllIlIIlIllI) * llllllllllllllllIIlIIllIlIIlIlIl;
    }

    public static void relativeRect(float llllllllllllllllIIlIIlIIIIIIIlIl, float llllllllllllllllIIlIIlIIIIIIIlII, float llllllllllllllllIIlIIlIIIIIIIIll, float llllllllllllllllIIlIIIllllllIlll, int llllllllllllllllIIlIIlIIIIIIIIIl) {
        if (llllllllllllllllIIlIIlIIIIIIIlIl < llllllllllllllllIIlIIlIIIIIIIIll) {
            float llllllllllllllllIIlIIlIIIIIIIlll = llllllllllllllllIIlIIlIIIIIIIlIl;
            llllllllllllllllIIlIIlIIIIIIIlIl = llllllllllllllllIIlIIlIIIIIIIIll;
            llllllllllllllllIIlIIlIIIIIIIIll = llllllllllllllllIIlIIlIIIIIIIlll;
        }
        if (llllllllllllllllIIlIIlIIIIIIIlII < llllllllllllllllIIlIIIllllllIlll) {
            float llllllllllllllllIIlIIlIIIIIIIllI = llllllllllllllllIIlIIlIIIIIIIlII;
            llllllllllllllllIIlIIlIIIIIIIlII = llllllllllllllllIIlIIIllllllIlll;
            llllllllllllllllIIlIIIllllllIlll = llllllllllllllllIIlIIlIIIIIIIllI;
        }
        float llllllllllllllllIIlIIlIIIIIIIIII = (float)(llllllllllllllllIIlIIlIIIIIIIIIl >> 24 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIIllllllllll = (float)(llllllllllllllllIIlIIlIIIIIIIIIl >> 16 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIIlllllllllI = (float)(llllllllllllllllIIlIIlIIIIIIIIIl >> 8 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIIllllllllIl = (float)(llllllllllllllllIIlIIlIIIIIIIIIl & 0xFF) / 255.0f;
        Tessellator llllllllllllllllIIlIIIllllllllII = Tessellator.getInstance();
        BufferBuilder llllllllllllllllIIlIIIlllllllIll = llllllllllllllllIIlIIIllllllllII.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        GlStateManager.color((float)llllllllllllllllIIlIIIllllllllll, (float)llllllllllllllllIIlIIIlllllllllI, (float)llllllllllllllllIIlIIIllllllllIl, (float)llllllllllllllllIIlIIlIIIIIIIIII);
        llllllllllllllllIIlIIIlllllllIll.begin(7, DefaultVertexFormats.POSITION);
        llllllllllllllllIIlIIIlllllllIll.pos((double)llllllllllllllllIIlIIlIIIIIIIlIl, (double)llllllllllllllllIIlIIIllllllIlll, 0.0).endVertex();
        llllllllllllllllIIlIIIlllllllIll.pos((double)llllllllllllllllIIlIIlIIIIIIIIll, (double)llllllllllllllllIIlIIIllllllIlll, 0.0).endVertex();
        llllllllllllllllIIlIIIlllllllIll.pos((double)llllllllllllllllIIlIIlIIIIIIIIll, (double)llllllllllllllllIIlIIlIIIIIIIlII, 0.0).endVertex();
        llllllllllllllllIIlIIIlllllllIll.pos((double)llllllllllllllllIIlIIlIIIIIIIlIl, (double)llllllllllllllllIIlIIlIIIIIIIlII, 0.0).endVertex();
        llllllllllllllllIIlIIIllllllllII.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void drawCircle(float llllllllllllllllIIlIIlIIlllIIIll, double llllllllllllllllIIlIIlIIllllIIIl, float llllllllllllllllIIlIIlIIllllIIII, int llllllllllllllllIIlIIlIIlllIllll, int llllllllllllllllIIlIIlIIlllIlllI) {
        GL11.glPushMatrix();
        llllllllllllllllIIlIIlIIlllIIIll *= 2.0f;
        llllllllllllllllIIlIIlIIllllIIIl *= 2.0;
        GlStateManager.glLineWidth((float)6.0f);
        float llllllllllllllllIIlIIlIIlllIllIl = (float)(llllllllllllllllIIlIIlIIlllIlllI >> 24 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIlIIlllIllII = (float)(llllllllllllllllIIlIIlIIlllIlllI >> 16 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIlIIlllIlIll = (float)(llllllllllllllllIIlIIlIIlllIlllI >> 8 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIlIIlllIlIlI = (float)(llllllllllllllllIIlIIlIIlllIlllI & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIlIIlllIlIIl = (float)Math.PI / 180;
        float llllllllllllllllIIlIIlIIlllIlIII = (float)Math.cos(llllllllllllllllIIlIIlIIlllIlIIl);
        float llllllllllllllllIIlIIlIIlllIIlll = (float)Math.sin(llllllllllllllllIIlIIlIIlllIlIIl);
        float llllllllllllllllIIlIIlIIlllIIllI = llllllllllllllllIIlIIlIIllllIIII *= 2.0f;
        float llllllllllllllllIIlIIlIIlllIIlIl = 0.0f;
        GL11.glEnable((int)2848);
        RenderUtil.enableGL2D();
        GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
        GL11.glColor4f((float)llllllllllllllllIIlIIlIIlllIllII, (float)llllllllllllllllIIlIIlIIlllIlIll, (float)llllllllllllllllIIlIIlIIlllIlIlI, (float)llllllllllllllllIIlIIlIIlllIllIl);
        GL11.glPointSize((float)6.0f);
        GL11.glBegin((int)3);
        int[] llllllllllllllllIIlIIlIIlllIIlII = new int[]{1};
        for (int llllllllllllllllIIlIIlIIllllIIll = 0; llllllllllllllllIIlIIlIIllllIIll < 360 - llllllllllllllllIIlIIlIIlllIllll; ++llllllllllllllllIIlIIlIIllllIIll) {
            llllllllllllllllIIlIIlIIlllIlllI = RenderUtil.raindbow(llllllllllllllllIIlIIlIIlllIIlII[0] * 10);
            llllllllllllllllIIlIIlIIlllIllIl = (float)(llllllllllllllllIIlIIlIIlllIlllI >> 24 & 0xFF) / 255.0f;
            llllllllllllllllIIlIIlIIlllIllII = (float)(llllllllllllllllIIlIIlIIlllIlllI >> 16 & 0xFF) / 255.0f;
            llllllllllllllllIIlIIlIIlllIlIll = (float)(llllllllllllllllIIlIIlIIlllIlllI >> 8 & 0xFF) / 255.0f;
            llllllllllllllllIIlIIlIIlllIlIlI = (float)(llllllllllllllllIIlIIlIIlllIlllI & 0xFF) / 255.0f;
            GL11.glColor4f((float)llllllllllllllllIIlIIlIIlllIllII, (float)llllllllllllllllIIlIIlIIlllIlIll, (float)llllllllllllllllIIlIIlIIlllIlIlI, (float)llllllllllllllllIIlIIlIIlllIllIl);
            GL11.glVertex2f((float)(llllllllllllllllIIlIIlIIlllIIllI + llllllllllllllllIIlIIlIIlllIIIll), (float)((float)((double)llllllllllllllllIIlIIlIIlllIIlIl + llllllllllllllllIIlIIlIIllllIIIl)));
            float llllllllllllllllIIlIIlIIllllIlII = llllllllllllllllIIlIIlIIlllIIllI;
            llllllllllllllllIIlIIlIIlllIIllI = llllllllllllllllIIlIIlIIlllIlIII * llllllllllllllllIIlIIlIIlllIIllI - llllllllllllllllIIlIIlIIlllIIlll * llllllllllllllllIIlIIlIIlllIIlIl;
            llllllllllllllllIIlIIlIIlllIIlIl = llllllllllllllllIIlIIlIIlllIIlll * llllllllllllllllIIlIIlIIllllIlII + llllllllllllllllIIlIIlIIlllIlIII * llllllllllllllllIIlIIlIIlllIIlIl;
            llllllllllllllllIIlIIlIIlllIIlII[0] = llllllllllllllllIIlIIlIIlllIIlII[0] + 1;
        }
        GL11.glEnd();
        GL11.glScalef((float)2.0f, (float)2.0f, (float)2.0f);
        RenderUtil.disableGL2D();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.glLineWidth((float)1.0f);
        GL11.glPopMatrix();
    }

    public static int raindbow(int llllllllllllllllIIlIIlIlIIIIIlll) {
        double llllllllllllllllIIlIIlIlIIIIlIII = Math.ceil((System.currentTimeMillis() + (long)llllllllllllllllIIlIIlIlIIIIIlll) / 20L);
        return Color.getHSBColor((float)((llllllllllllllllIIlIIlIlIIIIlIII %= 360.0) / 360.0), 0.5f, 1.0f).getRGB();
    }

    public static void drawPolygonPart(double llllllllllllllllIIlIIlIIIlllIIII, double llllllllllllllllIIlIIlIIIllIllll, int llllllllllllllllIIlIIlIIIllIlllI, int llllllllllllllllIIlIIlIIIllllllI, int llllllllllllllllIIlIIlIIIlllllIl, int llllllllllllllllIIlIIlIIIlllllII) {
        float llllllllllllllllIIlIIlIIIllllIll = (float)(llllllllllllllllIIlIIlIIIlllllIl >> 24 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIlIIIllllIlI = (float)(llllllllllllllllIIlIIlIIIlllllIl >> 16 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIlIIIllllIIl = (float)(llllllllllllllllIIlIIlIIIlllllIl >> 8 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIlIIIllllIII = (float)(llllllllllllllllIIlIIlIIIlllllIl & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIlIIIlllIlll = (float)(llllllllllllllllIIlIIlIIIlllllII >> 24 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIlIIIlllIllI = (float)(llllllllllllllllIIlIIlIIIlllllII >> 16 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIlIIIlllIlIl = (float)(llllllllllllllllIIlIIlIIIlllllII >> 8 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIlIIIlllIlII = (float)(llllllllllllllllIIlIIlIIIlllllII & 0xFF) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int)7425);
        Tessellator llllllllllllllllIIlIIlIIIlllIIll = Tessellator.getInstance();
        BufferBuilder llllllllllllllllIIlIIlIIIlllIIlI = llllllllllllllllIIlIIlIIIlllIIll.getBuffer();
        llllllllllllllllIIlIIlIIIlllIIlI.begin(6, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllllllIIlIIlIIIlllIIlI.pos(llllllllllllllllIIlIIlIIIlllIIII, llllllllllllllllIIlIIlIIIllIllll, 0.0).color(llllllllllllllllIIlIIlIIIllllIlI, llllllllllllllllIIlIIlIIIllllIIl, llllllllllllllllIIlIIlIIIllllIII, llllllllllllllllIIlIIlIIIllllIll).endVertex();
        double llllllllllllllllIIlIIlIIIlllIIIl = Math.PI * 2;
        for (int llllllllllllllllIIlIIlIIlIIIIIlI = llllllllllllllllIIlIIlIIIllllllI * 90; llllllllllllllllIIlIIlIIlIIIIIlI <= llllllllllllllllIIlIIlIIIllllllI * 90 + 90; ++llllllllllllllllIIlIIlIIlIIIIIlI) {
            double llllllllllllllllIIlIIlIIlIIIIIll = Math.PI * 2 * (double)llllllllllllllllIIlIIlIIlIIIIIlI / 360.0 + Math.toRadians(180.0);
            llllllllllllllllIIlIIlIIIlllIIlI.pos(llllllllllllllllIIlIIlIIIlllIIII + Math.sin(llllllllllllllllIIlIIlIIlIIIIIll) * (double)llllllllllllllllIIlIIlIIIllIlllI, llllllllllllllllIIlIIlIIIllIllll + Math.cos(llllllllllllllllIIlIIlIIlIIIIIll) * (double)llllllllllllllllIIlIIlIIIllIlllI, 0.0).color(llllllllllllllllIIlIIlIIIlllIllI, llllllllllllllllIIlIIlIIIlllIlIl, llllllllllllllllIIlIIlIIIlllIlII, llllllllllllllllIIlIIlIIIlllIlll).endVertex();
        }
        llllllllllllllllIIlIIlIIIlllIIll.draw();
        GlStateManager.shadeModel((int)7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    public static void drawRectOpacity(double llllllllllllllllIIlIIIlllIlIIlII, double llllllllllllllllIIlIIIlllIlIlIlI, double llllllllllllllllIIlIIIlllIlIIIlI, double llllllllllllllllIIlIIIlllIlIIIIl, float llllllllllllllllIIlIIIlllIlIIIII) {
        if (llllllllllllllllIIlIIIlllIlIIlII < llllllllllllllllIIlIIIlllIlIIIlI) {
            double llllllllllllllllIIlIIIlllIlIllIl = llllllllllllllllIIlIIIlllIlIIlII;
            llllllllllllllllIIlIIIlllIlIIlII = llllllllllllllllIIlIIIlllIlIIIlI;
            llllllllllllllllIIlIIIlllIlIIIlI = llllllllllllllllIIlIIIlllIlIllIl;
        }
        if (llllllllllllllllIIlIIIlllIlIlIlI < llllllllllllllllIIlIIIlllIlIIIIl) {
            double llllllllllllllllIIlIIIlllIlIllII = llllllllllllllllIIlIIIlllIlIlIlI;
            llllllllllllllllIIlIIIlllIlIlIlI = llllllllllllllllIIlIIIlllIlIIIIl;
            llllllllllllllllIIlIIIlllIlIIIIl = llllllllllllllllIIlIIIlllIlIllII;
        }
        Tessellator llllllllllllllllIIlIIIlllIlIIllI = Tessellator.getInstance();
        BufferBuilder llllllllllllllllIIlIIIlllIlIIlIl = llllllllllllllllIIlIIIlllIlIIllI.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        GlStateManager.color((float)0.1f, (float)0.1f, (float)0.1f, (float)llllllllllllllllIIlIIIlllIlIIIII);
        llllllllllllllllIIlIIIlllIlIIlIl.begin(7, DefaultVertexFormats.POSITION);
        llllllllllllllllIIlIIIlllIlIIlIl.pos(llllllllllllllllIIlIIIlllIlIIlII, llllllllllllllllIIlIIIlllIlIIIIl, 0.0).endVertex();
        llllllllllllllllIIlIIIlllIlIIlIl.pos(llllllllllllllllIIlIIIlllIlIIIlI, llllllllllllllllIIlIIIlllIlIIIIl, 0.0).endVertex();
        llllllllllllllllIIlIIIlllIlIIlIl.pos(llllllllllllllllIIlIIIlllIlIIIlI, llllllllllllllllIIlIIIlllIlIlIlI, 0.0).endVertex();
        llllllllllllllllIIlIIIlllIlIIlIl.pos(llllllllllllllllIIlIIIlllIlIIlII, llllllllllllllllIIlIIIlllIlIlIlI, 0.0).endVertex();
        llllllllllllllllIIlIIIlllIlIIllI.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void disableGL2D() {
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glEnable((int)2929);
        GL11.glDisable((int)2848);
        GL11.glHint((int)3154, (int)4352);
        GL11.glHint((int)3155, (int)4352);
    }

    public static Vec3d getRenderPos(double llllllllllllllllIIlIIllIlIIlIIIl, double llllllllllllllllIIlIIllIlIIlIIII, double llllllllllllllllIIlIIllIlIIIllll) {
        return new Vec3d(llllllllllllllllIIlIIllIlIIlIIIl -= RenderUtil.mc.getRenderManager().viewerPosX, llllllllllllllllIIlIIllIlIIlIIII -= RenderUtil.mc.getRenderManager().viewerPosY, llllllllllllllllIIlIIllIlIIIllll -= RenderUtil.mc.getRenderManager().viewerPosZ);
    }

    public static void drawCircle1337(float llllllllllllllllIIlIIllIIIlIllII, float llllllllllllllllIIlIIllIIIlIIlII, float llllllllllllllllIIlIIllIIIlIlIlI, int llllllllllllllllIIlIIllIIIlIlIIl, int llllllllllllllllIIlIIllIIIlIlIII, int llllllllllllllllIIlIIllIIIlIIlll, int llllllllllllllllIIlIIllIIIlIIIIl) {
        RenderUtil.drawCircle228(llllllllllllllllIIlIIllIIIlIllII, llllllllllllllllIIlIIllIIIlIIlII, llllllllllllllllIIlIIllIIIlIlIlI, llllllllllllllllIIlIIllIIIlIIlll, llllllllllllllllIIlIIllIIIlIIIIl);
    }

    public static void drawBorderedRect(float llllllllllllllllIIlIIllIIIIlIlIl, float llllllllllllllllIIlIIllIIIIIlIIl, float llllllllllllllllIIlIIllIIIIlIIll, float llllllllllllllllIIlIIllIIIIIIlll, float llllllllllllllllIIlIIllIIIIlIIIl, int llllllllllllllllIIlIIllIIIIlIIII, int llllllllllllllllIIlIIllIIIIIIlII) {
        RenderUtil.drawRect(llllllllllllllllIIlIIllIIIIlIlIl, llllllllllllllllIIlIIllIIIIIlIIl, llllllllllllllllIIlIIllIIIIlIIll, llllllllllllllllIIlIIllIIIIIIlll, llllllllllllllllIIlIIllIIIIIIlII);
        float llllllllllllllllIIlIIllIIIIIlllI = (float)(llllllllllllllllIIlIIllIIIIlIIII >> 24 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIllIIIIIllIl = (float)(llllllllllllllllIIlIIllIIIIlIIII >> 16 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIllIIIIIllII = (float)(llllllllllllllllIIlIIllIIIIlIIII >> 8 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIllIIIIIlIll = (float)(llllllllllllllllIIlIIllIIIIlIIII & 0xFF) / 255.0f;
        RenderUtil.glRenderStart();
        GL11.glColor4f((float)llllllllllllllllIIlIIllIIIIIllIl, (float)llllllllllllllllIIlIIllIIIIIllII, (float)llllllllllllllllIIlIIllIIIIIlIll, (float)llllllllllllllllIIlIIllIIIIIlllI);
        GL11.glLineWidth((float)llllllllllllllllIIlIIllIIIIlIIIl);
        GL11.glEnable((int)2848);
        GL11.glBegin((int)1);
        GL11.glVertex2d((double)llllllllllllllllIIlIIllIIIIlIlIl, (double)llllllllllllllllIIlIIllIIIIIlIIl);
        GL11.glVertex2d((double)llllllllllllllllIIlIIllIIIIlIIll, (double)llllllllllllllllIIlIIllIIIIIlIIl);
        GL11.glVertex2d((double)llllllllllllllllIIlIIllIIIIlIIll, (double)llllllllllllllllIIlIIllIIIIIlIIl);
        GL11.glVertex2d((double)llllllllllllllllIIlIIllIIIIlIIll, (double)llllllllllllllllIIlIIllIIIIIIlll);
        GL11.glVertex2d((double)llllllllllllllllIIlIIllIIIIlIIll, (double)llllllllllllllllIIlIIllIIIIIIlll);
        GL11.glVertex2d((double)llllllllllllllllIIlIIllIIIIlIlIl, (double)llllllllllllllllIIlIIllIIIIIIlll);
        GL11.glVertex2d((double)llllllllllllllllIIlIIllIIIIlIlIl, (double)llllllllllllllllIIlIIllIIIIIIlll);
        GL11.glVertex2d((double)llllllllllllllllIIlIIllIIIIlIlIl, (double)llllllllllllllllIIlIIllIIIIIlIIl);
        GL11.glEnd();
        RenderUtil.glRenderStop();
    }

    public static void blockEsp(BlockPos llllllllllllllllIIlIIIllIIllIlII, Color llllllllllllllllIIlIIIllIIllIIll, double llllllllllllllllIIlIIIllIIllIIlI, double llllllllllllllllIIlIIIllIIlIIllI) {
        double llllllllllllllllIIlIIIllIIllIIII = llllllllllllllllIIlIIIllIIllIlII.getX();
        double llllllllllllllllIIlIIIllIIlIllll = llllllllllllllllIIlIIIllIIllIIII - RenderUtil.mc.getRenderManager().viewerPosX;
        double llllllllllllllllIIlIIIllIIlIlllI = llllllllllllllllIIlIIIllIIllIlII.getY();
        Minecraft.getMinecraft().getRenderManager();
        double llllllllllllllllIIlIIIllIIlIllIl = llllllllllllllllIIlIIIllIIlIlllI - RenderUtil.mc.getRenderManager().viewerPosY;
        double llllllllllllllllIIlIIIllIIlIllII = llllllllllllllllIIlIIIllIIllIlII.getZ();
        Minecraft.getMinecraft().getRenderManager();
        double llllllllllllllllIIlIIIllIIlIlIll = llllllllllllllllIIlIIIllIIlIllII - RenderUtil.mc.getRenderManager().viewerPosZ;
        GL11.glPushMatrix();
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)3042);
        GL11.glLineWidth((float)2.0f);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        GL11.glColor4d((double)((float)llllllllllllllllIIlIIIllIIllIIll.getRed() / 255.0f), (double)((float)llllllllllllllllIIlIIIllIIllIIll.getGreen() / 255.0f), (double)((float)llllllllllllllllIIlIIIllIIllIIll.getBlue() / 255.0f), (double)0.15);
        RenderUtil.drawColorBox(new AxisAlignedBB(llllllllllllllllIIlIIIllIIlIllll, llllllllllllllllIIlIIIllIIlIllIl, llllllllllllllllIIlIIIllIIlIlIll, llllllllllllllllIIlIIIllIIlIllll + llllllllllllllllIIlIIIllIIlIIllI, llllllllllllllllIIlIIIllIIlIllIl + 1.0, llllllllllllllllIIlIIIllIIlIlIll + llllllllllllllllIIlIIIllIIllIIlI), 0.0f, 0.0f, 0.0f, 0.0f);
        GL11.glColor4d((double)0.0, (double)0.0, (double)0.0, (double)0.5);
        RenderUtil.drawSelectionBoundingBox(new AxisAlignedBB(llllllllllllllllIIlIIIllIIlIllll, llllllllllllllllIIlIIIllIIlIllIl, llllllllllllllllIIlIIIllIIlIlIll, llllllllllllllllIIlIIIllIIlIllll + llllllllllllllllIIlIIIllIIlIIllI, llllllllllllllllIIlIIIllIIlIllIl + 1.0, llllllllllllllllIIlIIIllIIlIlIll + llllllllllllllllIIlIIIllIIllIIlI));
        GL11.glLineWidth((float)2.0f);
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2929);
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)3042);
        GL11.glPopMatrix();
    }

    public static float convertColor(int llllllllllllllllIIlIIlIlllIIlIII, int llllllllllllllllIIlIIlIlllIIIlll) {
        return (float)(llllllllllllllllIIlIIlIlllIIIlll >> llllllllllllllllIIlIIlIlllIIlIII & 0xFF) / 255.0f;
    }

    public static void glRenderStop() {
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2884);
        GL11.glDisable((int)3042);
        GL11.glPopAttrib();
        GL11.glPopMatrix();
    }

    public static void prepareScissorBox(float llllllllllllllllIIlIIlIIllIIIllI, float llllllllllllllllIIlIIlIIllIIlIll, float llllllllllllllllIIlIIlIIllIIIlII, float llllllllllllllllIIlIIlIIllIIIIll) {
        ScaledResolution llllllllllllllllIIlIIlIIllIIlIII = new ScaledResolution(Minecraft.getMinecraft());
        int llllllllllllllllIIlIIlIIllIIIlll = llllllllllllllllIIlIIlIIllIIlIII.getScaleFactor();
        GL11.glScissor((int)((int)(llllllllllllllllIIlIIlIIllIIIllI * (float)llllllllllllllllIIlIIlIIllIIIlll)), (int)((int)(((float)llllllllllllllllIIlIIlIIllIIlIII.getScaledHeight() - llllllllllllllllIIlIIlIIllIIIIll) * (float)llllllllllllllllIIlIIlIIllIIIlll)), (int)((int)((llllllllllllllllIIlIIlIIllIIIlII - llllllllllllllllIIlIIlIIllIIIllI) * (float)llllllllllllllllIIlIIlIIllIIIlll)), (int)((int)((llllllllllllllllIIlIIlIIllIIIIll - llllllllllllllllIIlIIlIIllIIlIll) * (float)llllllllllllllllIIlIIlIIllIIIlll)));
    }

    public static void setColor(Color llllllllllllllllIIlIIlIllllllllI) {
        GL11.glColor4d((double)((float)llllllllllllllllIIlIIlIllllllllI.getRed() / 255.0f), (double)((float)llllllllllllllllIIlIIlIllllllllI.getGreen() / 255.0f), (double)((float)llllllllllllllllIIlIIlIllllllllI.getBlue() / 255.0f), (double)((float)llllllllllllllllIIlIIlIllllllllI.getAlpha() / 255.0f));
    }

    public static void drawHead(ResourceLocation llllllllllllllllIIlIIllIIllIIIlI, int llllllllllllllllIIlIIllIIllIIIIl, int llllllllllllllllIIlIIllIIlIllIll, int llllllllllllllllIIlIIllIIlIlllll, int llllllllllllllllIIlIIllIIlIllllI) {
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        mc.getTextureManager().bindTexture(llllllllllllllllIIlIIllIIllIIIlI);
        Gui.drawScaledCustomSizeModalRect((int)llllllllllllllllIIlIIllIIllIIIIl, (int)llllllllllllllllIIlIIllIIlIllIll, (float)8.0f, (float)8.0f, (int)8, (int)8, (int)llllllllllllllllIIlIIllIIlIlllll, (int)llllllllllllllllIIlIIllIIlIllllI, (float)64.0f, (float)64.0f);
    }

    public static void drawRoundedRect(double llllllllllllllllIIlIIlIlIllIIIIl, double llllllllllllllllIIlIIlIlIllIIIII, double llllllllllllllllIIlIIlIlIllIIlIl, double llllllllllllllllIIlIIlIlIllIIlII, int llllllllllllllllIIlIIlIlIllIIIll, int llllllllllllllllIIlIIlIlIllIIIlI) {
        RenderUtil.drawRect(llllllllllllllllIIlIIlIlIllIIIIl + 0.5, llllllllllllllllIIlIIlIlIllIIIII, llllllllllllllllIIlIIlIlIllIIlIl - 0.5, llllllllllllllllIIlIIlIlIllIIIII + 0.5, llllllllllllllllIIlIIlIlIllIIIlI);
        RenderUtil.drawRect(llllllllllllllllIIlIIlIlIllIIIIl + 0.5, llllllllllllllllIIlIIlIlIllIIlII - 0.5, llllllllllllllllIIlIIlIlIllIIlIl - 0.5, llllllllllllllllIIlIIlIlIllIIlII, llllllllllllllllIIlIIlIlIllIIIlI);
        RenderUtil.drawRect(llllllllllllllllIIlIIlIlIllIIIIl, llllllllllllllllIIlIIlIlIllIIIII + 0.5, llllllllllllllllIIlIIlIlIllIIlIl, llllllllllllllllIIlIIlIlIllIIlII - 0.5, llllllllllllllllIIlIIlIlIllIIIlI);
    }

    public static void glColor(int llllllllllllllllIIlIIIllIlIIlIII) {
        float llllllllllllllllIIlIIIllIlIIIlll = (float)(llllllllllllllllIIlIIIllIlIIlIII >> 24 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIIllIlIIIllI = (float)(llllllllllllllllIIlIIIllIlIIlIII >> 16 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIIllIlIIIlIl = (float)(llllllllllllllllIIlIIIllIlIIlIII >> 8 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIIllIlIIIlII = (float)(llllllllllllllllIIlIIIllIlIIlIII & 0xFF) / 255.0f;
        GL11.glColor4f((float)llllllllllllllllIIlIIIllIlIIIllI, (float)llllllllllllllllIIlIIIllIlIIIlIl, (float)llllllllllllllllIIlIIIllIlIIIlII, (float)llllllllllllllllIIlIIIllIlIIIlll);
    }

    public static void glRenderStart() {
        GL11.glPushMatrix();
        GL11.glPushAttrib((int)1048575);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)2884);
        GL11.glDisable((int)3553);
    }

    private static boolean isInViewFrustrum(AxisAlignedBB llllllllllllllllIIlIIIllIlIIllll) {
        Entity llllllllllllllllIIlIIIllIlIlIIII = mc.getRenderViewEntity();
        frustrum.setPosition(llllllllllllllllIIlIIIllIlIlIIII.posX, llllllllllllllllIIlIIIllIlIlIIII.posY, llllllllllllllllIIlIIIllIlIlIIII.posZ);
        return frustrum.isBoundingBoxInFrustum(llllllllllllllllIIlIIIllIlIIllll);
    }

    public static void color228(int llllllllllllllllIIlIIIllIlIlIlIl) {
        GL11.glColor4ub((byte)((byte)(llllllllllllllllIIlIIIllIlIlIlIl >> 16 & 0xFF)), (byte)((byte)(llllllllllllllllIIlIIIllIlIlIlIl >> 8 & 0xFF)), (byte)((byte)(llllllllllllllllIIlIIIllIlIlIlIl & 0xFF)), (byte)((byte)(llllllllllllllllIIlIIIllIlIlIlIl >> 24 & 0xFF)));
    }

    public static void drawImage(ResourceLocation llllllllllllllllIIlIIlIlIIIlIlIl, int llllllllllllllllIIlIIlIlIIIIllll, int llllllllllllllllIIlIIlIlIIIlIIll, int llllllllllllllllIIlIIlIlIIIlIIlI, int llllllllllllllllIIlIIlIlIIIlIIIl) {
        GL11.glEnable((int)2848);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glPushMatrix();
        Minecraft.getMinecraft().getTextureManager().bindTexture(llllllllllllllllIIlIIlIlIIIlIlIl);
        Gui.drawModalRectWithCustomSizedTexture((int)llllllllllllllllIIlIIlIlIIIIllll, (int)llllllllllllllllIIlIIlIlIIIlIIll, (float)0.0f, (float)0.0f, (int)llllllllllllllllIIlIIlIlIIIlIIlI, (int)llllllllllllllllIIlIIlIlIIIlIIIl, (float)llllllllllllllllIIlIIlIlIIIlIIlI, (float)llllllllllllllllIIlIIlIlIIIlIIIl);
        RenderUtil.disableGL2D();
        GL11.glPopMatrix();
    }

    public static void drawRectWithEdge(double llllllllllllllllIIlIIlIlIllllIlI, double llllllllllllllllIIlIIlIlIllllIIl, double llllllllllllllllIIlIIlIlIllllIII, double llllllllllllllllIIlIIlIlIlllIlll, Color llllllllllllllllIIlIIlIlIlllIllI, Color llllllllllllllllIIlIIlIlIlllIlIl) {
        RenderUtil.drawRect(llllllllllllllllIIlIIlIlIllllIlI, llllllllllllllllIIlIIlIlIllllIIl, llllllllllllllllIIlIIlIlIllllIlI + llllllllllllllllIIlIIlIlIllllIII, llllllllllllllllIIlIIlIlIllllIIl + llllllllllllllllIIlIIlIlIlllIlll, llllllllllllllllIIlIIlIlIlllIllI.getRGB());
        int llllllllllllllllIIlIIlIlIlllIlII = llllllllllllllllIIlIIlIlIlllIlIl.getRGB();
        RenderUtil.drawRect(llllllllllllllllIIlIIlIlIllllIlI - 1.0, llllllllllllllllIIlIIlIlIllllIIl, llllllllllllllllIIlIIlIlIllllIlI, llllllllllllllllIIlIIlIlIllllIIl + llllllllllllllllIIlIIlIlIlllIlll, llllllllllllllllIIlIIlIlIlllIlII);
        RenderUtil.drawRect(llllllllllllllllIIlIIlIlIllllIlI + llllllllllllllllIIlIIlIlIllllIII, llllllllllllllllIIlIIlIlIllllIIl, llllllllllllllllIIlIIlIlIllllIlI + llllllllllllllllIIlIIlIlIllllIII + 1.0, llllllllllllllllIIlIIlIlIllllIIl + llllllllllllllllIIlIIlIlIlllIlll, llllllllllllllllIIlIIlIlIlllIlII);
        RenderUtil.drawRect(llllllllllllllllIIlIIlIlIllllIlI - 1.0, llllllllllllllllIIlIIlIlIllllIIl - 1.0, llllllllllllllllIIlIIlIlIllllIlI + llllllllllllllllIIlIIlIlIllllIII + 1.0, llllllllllllllllIIlIIlIlIllllIIl, llllllllllllllllIIlIIlIlIlllIlII);
        RenderUtil.drawRect(llllllllllllllllIIlIIlIlIllllIlI - 1.0, llllllllllllllllIIlIIlIlIllllIIl + llllllllllllllllIIlIIlIlIlllIlll, llllllllllllllllIIlIIlIlIllllIlI + llllllllllllllllIIlIIlIlIllllIII + 1.0, llllllllllllllllIIlIIlIlIllllIIl + llllllllllllllllIIlIIlIlIlllIlll + 1.0, llllllllllllllllIIlIIlIlIlllIlII);
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

    public static final void drawSmoothRect(float llllllllllllllllIIlIIlIlIIlIIlII, float llllllllllllllllIIlIIlIlIIlIIIll, float llllllllllllllllIIlIIlIlIIlIIIlI, float llllllllllllllllIIlIIlIlIIlIIIIl, int llllllllllllllllIIlIIlIlIIIllIll) {
        GL11.glEnable((int)3042);
        GL11.glEnable((int)2848);
        RenderUtil.drawRect(llllllllllllllllIIlIIlIlIIlIIlII, llllllllllllllllIIlIIlIlIIlIIIll, llllllllllllllllIIlIIlIlIIlIIIlI, llllllllllllllllIIlIIlIlIIlIIIIl, llllllllllllllllIIlIIlIlIIIllIll);
        GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
        RenderUtil.drawRect(llllllllllllllllIIlIIlIlIIlIIlII * 2.0f - 1.0f, llllllllllllllllIIlIIlIlIIlIIIll * 2.0f, llllllllllllllllIIlIIlIlIIlIIlII * 2.0f, llllllllllllllllIIlIIlIlIIlIIIIl * 2.0f - 1.0f, llllllllllllllllIIlIIlIlIIIllIll);
        RenderUtil.drawRect(llllllllllllllllIIlIIlIlIIlIIlII * 2.0f, llllllllllllllllIIlIIlIlIIlIIIll * 2.0f - 1.0f, llllllllllllllllIIlIIlIlIIlIIIlI * 2.0f, llllllllllllllllIIlIIlIlIIlIIIll * 2.0f, llllllllllllllllIIlIIlIlIIIllIll);
        RenderUtil.drawRect(llllllllllllllllIIlIIlIlIIlIIIlI * 2.0f, llllllllllllllllIIlIIlIlIIlIIIll * 2.0f, llllllllllllllllIIlIIlIlIIlIIIlI * 2.0f + 1.0f, llllllllllllllllIIlIIlIlIIlIIIIl * 2.0f - 1.0f, llllllllllllllllIIlIIlIlIIIllIll);
        GL11.glDisable((int)3042);
        GL11.glScalef((float)2.0f, (float)2.0f, (float)2.0f);
    }

    public RenderUtil() {
        RenderUtil llllllllllllllllIIlIIllIlIIllllI;
    }

    public static void drawBorderedRect(double llllllllllllllllIIlIIIlllllIIlll, double llllllllllllllllIIlIIIlllllIIllI, double llllllllllllllllIIlIIIlllllIIlIl, double llllllllllllllllIIlIIIlllllIIlII, double llllllllllllllllIIlIIIllllIllIll, int llllllllllllllllIIlIIIllllIllIlI, int llllllllllllllllIIlIIIlllllIIIIl, boolean llllllllllllllllIIlIIIlllllIIIII) {
        RenderUtil.drawRect(llllllllllllllllIIlIIIlllllIIlll - (!llllllllllllllllIIlIIIlllllIIIII ? llllllllllllllllIIlIIIllllIllIll : 0.0), llllllllllllllllIIlIIIlllllIIllI - (!llllllllllllllllIIlIIIlllllIIIII ? llllllllllllllllIIlIIIllllIllIll : 0.0), llllllllllllllllIIlIIIlllllIIlIl + (!llllllllllllllllIIlIIIlllllIIIII ? llllllllllllllllIIlIIIllllIllIll : 0.0), llllllllllllllllIIlIIIlllllIIlII + (!llllllllllllllllIIlIIIlllllIIIII ? llllllllllllllllIIlIIIllllIllIll : 0.0), llllllllllllllllIIlIIIlllllIIIIl);
        RenderUtil.drawRect(llllllllllllllllIIlIIIlllllIIlll + (llllllllllllllllIIlIIIlllllIIIII ? llllllllllllllllIIlIIIllllIllIll : 0.0), llllllllllllllllIIlIIIlllllIIllI + (llllllllllllllllIIlIIIlllllIIIII ? llllllllllllllllIIlIIIllllIllIll : 0.0), llllllllllllllllIIlIIIlllllIIlIl - (llllllllllllllllIIlIIIlllllIIIII ? llllllllllllllllIIlIIIllllIllIll : 0.0), llllllllllllllllIIlIIIlllllIIlII - (llllllllllllllllIIlIIIlllllIIIII ? llllllllllllllllIIlIIIllllIllIll : 0.0), llllllllllllllllIIlIIIllllIllIlI);
    }

    public static void drawCircle228(float llllllllllllllllIIlIIllIIlIIlIlI, float llllllllllllllllIIlIIllIIlIIlIIl, float llllllllllllllllIIlIIllIIIllllII, int llllllllllllllllIIlIIllIIIlllIll, int llllllllllllllllIIlIIllIIlIIIllI) {
        float llllllllllllllllIIlIIllIIlIIIlIl = (float)(llllllllllllllllIIlIIllIIIlllIll >> 24 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIllIIlIIIlII = (float)(llllllllllllllllIIlIIllIIIlllIll >> 16 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIllIIlIIIIll = (float)(llllllllllllllllIIlIIllIIIlllIll >> 8 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIllIIlIIIIlI = (float)(llllllllllllllllIIlIIllIIIlllIll & 0xFF) / 255.0f;
        boolean llllllllllllllllIIlIIllIIlIIIIIl = GL11.glIsEnabled((int)3042);
        boolean llllllllllllllllIIlIIllIIlIIIIII = GL11.glIsEnabled((int)2848);
        boolean llllllllllllllllIIlIIllIIIllllll = GL11.glIsEnabled((int)3553);
        if (!llllllllllllllllIIlIIllIIlIIIIIl) {
            GL11.glEnable((int)3042);
        }
        if (!llllllllllllllllIIlIIllIIlIIIIII) {
            GL11.glEnable((int)2848);
        }
        if (llllllllllllllllIIlIIllIIIllllll) {
            GL11.glDisable((int)3553);
        }
        GL11.glEnable((int)2848);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glColor4f((float)llllllllllllllllIIlIIllIIlIIIlII, (float)llllllllllllllllIIlIIllIIlIIIIll, (float)llllllllllllllllIIlIIllIIlIIIIlI, (float)llllllllllllllllIIlIIllIIlIIIlIl);
        GL11.glLineWidth((float)2.5f);
        GL11.glBegin((int)3);
        for (int llllllllllllllllIIlIIllIIlIIlIll = 0; llllllllllllllllIIlIIllIIlIIlIll <= llllllllllllllllIIlIIllIIlIIIllI; ++llllllllllllllllIIlIIllIIlIIlIll) {
            GL11.glVertex2d((double)((double)llllllllllllllllIIlIIllIIlIIlIlI + Math.sin((double)llllllllllllllllIIlIIllIIlIIlIll * Math.PI / 180.0) * (double)llllllllllllllllIIlIIllIIIllllII), (double)((double)llllllllllllllllIIlIIllIIlIIlIIl + Math.cos((double)llllllllllllllllIIlIIllIIlIIlIll * Math.PI / 180.0) * (double)llllllllllllllllIIlIIllIIIllllII));
        }
        GL11.glEnd();
        GL11.glDisable((int)2848);
        if (llllllllllllllllIIlIIllIIIllllll) {
            GL11.glEnable((int)3553);
        }
        if (!llllllllllllllllIIlIIllIIlIIIIII) {
            GL11.glDisable((int)2848);
        }
        if (!llllllllllllllllIIlIIllIIlIIIIIl) {
            GL11.glDisable((int)3042);
        }
    }

    public static void drawLinesAroundPlayer(Entity llllllllllllllllIIlIIIllIllIIIIl, double llllllllllllllllIIlIIIllIllIlIlI, float llllllllllllllllIIlIIIllIllIlIIl, int llllllllllllllllIIlIIIllIllIlIII, float llllllllllllllllIIlIIIllIlIlllIl, int llllllllllllllllIIlIIIllIlIlllII) {
        GL11.glPushMatrix();
        RenderUtil.enableGL2D3();
        GL11.glDisable((int)3553);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glDisable((int)2929);
        GL11.glLineWidth((float)llllllllllllllllIIlIIIllIlIlllIl);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDisable((int)2929);
        GL11.glBegin((int)3);
        RenderManager llllllllllllllllIIlIIIllIllIIlIl = Minecraft.getMinecraft().getRenderManager();
        double llllllllllllllllIIlIIIllIllIIlII = llllllllllllllllIIlIIIllIllIIIIl.lastTickPosX + (llllllllllllllllIIlIIIllIllIIIIl.posX - llllllllllllllllIIlIIIllIllIIIIl.lastTickPosX) * (double)llllllllllllllllIIlIIIllIllIlIIl - llllllllllllllllIIlIIIllIllIIlIl.viewerPosX;
        double llllllllllllllllIIlIIIllIllIIIll = llllllllllllllllIIlIIIllIllIIIIl.lastTickPosY + (llllllllllllllllIIlIIIllIllIIIIl.posY - llllllllllllllllIIlIIIllIllIIIIl.lastTickPosY) * (double)llllllllllllllllIIlIIIllIllIlIIl - llllllllllllllllIIlIIIllIllIIlIl.viewerPosY;
        double llllllllllllllllIIlIIIllIllIIIlI = llllllllllllllllIIlIIIllIllIIIIl.lastTickPosZ + (llllllllllllllllIIlIIIllIllIIIIl.posZ - llllllllllllllllIIlIIIllIllIIIIl.lastTickPosZ) * (double)llllllllllllllllIIlIIIllIllIlIIl - llllllllllllllllIIlIIIllIllIIlIl.viewerPosZ;
        RenderUtil.color228(llllllllllllllllIIlIIIllIlIlllII);
        for (int llllllllllllllllIIlIIIllIllIllII = 0; llllllllllllllllIIlIIIllIllIllII <= llllllllllllllllIIlIIIllIllIlIII; ++llllllllllllllllIIlIIIllIllIllII) {
            GL11.glVertex3d((double)(llllllllllllllllIIlIIIllIllIIlII + llllllllllllllllIIlIIIllIllIlIlI * Math.cos((double)llllllllllllllllIIlIIIllIllIllII * (Math.PI * 2) / (double)llllllllllllllllIIlIIIllIllIlIII)), (double)llllllllllllllllIIlIIIllIllIIIll, (double)(llllllllllllllllIIlIIIllIllIIIlI + llllllllllllllllIIlIIIllIllIlIlI * Math.sin((double)llllllllllllllllIIlIIIllIllIllII * (Math.PI * 2) / (double)llllllllllllllllIIlIIIllIllIlIII)));
        }
        GL11.glEnd();
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)3042);
        GL11.glEnable((int)2929);
        GL11.glDisable((int)2848);
        GL11.glEnable((int)2929);
        GL11.glEnable((int)3553);
        RenderUtil.disableGL2D3();
        GL11.glPopMatrix();
    }

    public static void drawCircle(float llllllllllllllllIIlIIllIIllllllI, float llllllllllllllllIIlIIllIIlllIIlI, float llllllllllllllllIIlIIllIIlllIIIl, int llllllllllllllllIIlIIllIIllllIll) {
        float llllllllllllllllIIlIIllIIllllIlI = (float)(llllllllllllllllIIlIIllIIllllIll >> 24 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIllIIllllIIl = (float)(llllllllllllllllIIlIIllIIllllIll >> 16 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIllIIllllIII = (float)(llllllllllllllllIIlIIllIIllllIll >> 8 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIllIIlllIlll = (float)(llllllllllllllllIIlIIllIIllllIll & 0xFF) / 255.0f;
        boolean llllllllllllllllIIlIIllIIlllIllI = GL11.glIsEnabled((int)3042);
        boolean llllllllllllllllIIlIIllIIlllIlIl = GL11.glIsEnabled((int)2848);
        boolean llllllllllllllllIIlIIllIIlllIlII = GL11.glIsEnabled((int)3553);
        if (!llllllllllllllllIIlIIllIIlllIllI) {
            GL11.glEnable((int)3042);
        }
        if (!llllllllllllllllIIlIIllIIlllIlIl) {
            GL11.glEnable((int)2848);
        }
        if (llllllllllllllllIIlIIllIIlllIlII) {
            GL11.glDisable((int)3553);
        }
        GL11.glEnable((int)2848);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glColor4f((float)llllllllllllllllIIlIIllIIllllIIl, (float)llllllllllllllllIIlIIllIIllllIII, (float)llllllllllllllllIIlIIllIIlllIlll, (float)llllllllllllllllIIlIIllIIllllIlI);
        GL11.glBegin((int)9);
        for (int llllllllllllllllIIlIIllIIlllllll = 0; llllllllllllllllIIlIIllIIlllllll <= 360; ++llllllllllllllllIIlIIllIIlllllll) {
            GL11.glVertex2d((double)((double)llllllllllllllllIIlIIllIIllllllI + Math.sin((double)llllllllllllllllIIlIIllIIlllllll * Math.PI / 180.0) * (double)llllllllllllllllIIlIIllIIlllIIIl), (double)((double)llllllllllllllllIIlIIllIIlllIIlI + Math.cos((double)llllllllllllllllIIlIIllIIlllllll * Math.PI / 180.0) * (double)llllllllllllllllIIlIIllIIlllIIIl));
        }
        GL11.glEnd();
        GL11.glDisable((int)2848);
        if (llllllllllllllllIIlIIllIIlllIlII) {
            GL11.glEnable((int)3553);
        }
        if (!llllllllllllllllIIlIIllIIlllIlIl) {
            GL11.glDisable((int)2848);
        }
        if (!llllllllllllllllIIlIIllIIlllIllI) {
            GL11.glDisable((int)3042);
        }
    }

    public static void drawVGradientRect(float llllllllllllllllIIlIIlIIIIllllIl, float llllllllllllllllIIlIIlIIIIllllII, float llllllllllllllllIIlIIlIIIlIIlIll, float llllllllllllllllIIlIIlIIIIlllIlI, int llllllllllllllllIIlIIlIIIlIIlIIl, int llllllllllllllllIIlIIlIIIlIIlIII) {
        float llllllllllllllllIIlIIlIIIlIIIlll = (float)(llllllllllllllllIIlIIlIIIlIIlIIl >> 24 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIlIIIlIIIllI = (float)(llllllllllllllllIIlIIlIIIlIIlIIl >> 16 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIlIIIlIIIlIl = (float)(llllllllllllllllIIlIIlIIIlIIlIIl >> 8 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIlIIIlIIIlII = (float)(llllllllllllllllIIlIIlIIIlIIlIIl & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIlIIIlIIIIll = (float)(llllllllllllllllIIlIIlIIIlIIlIII >> 24 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIlIIIlIIIIlI = (float)(llllllllllllllllIIlIIlIIIlIIlIII >> 16 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIlIIIlIIIIIl = (float)(llllllllllllllllIIlIIlIIIlIIlIII >> 8 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIlIIIlIIIIII = (float)(llllllllllllllllIIlIIlIIIlIIlIII & 0xFF) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int)7425);
        Tessellator llllllllllllllllIIlIIlIIIIllllll = Tessellator.getInstance();
        BufferBuilder llllllllllllllllIIlIIlIIIIlllllI = llllllllllllllllIIlIIlIIIIllllll.getBuffer();
        llllllllllllllllIIlIIlIIIIlllllI.begin(7, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllllllIIlIIlIIIIlllllI.pos((double)llllllllllllllllIIlIIlIIIlIIlIll, (double)llllllllllllllllIIlIIlIIIIllllII, 0.0).color(llllllllllllllllIIlIIlIIIlIIIllI, llllllllllllllllIIlIIlIIIlIIIlIl, llllllllllllllllIIlIIlIIIlIIIlII, llllllllllllllllIIlIIlIIIlIIIlll).endVertex();
        llllllllllllllllIIlIIlIIIIlllllI.pos((double)llllllllllllllllIIlIIlIIIIllllIl, (double)llllllllllllllllIIlIIlIIIIllllII, 0.0).color(llllllllllllllllIIlIIlIIIlIIIllI, llllllllllllllllIIlIIlIIIlIIIlIl, llllllllllllllllIIlIIlIIIlIIIlII, llllllllllllllllIIlIIlIIIlIIIlll).endVertex();
        llllllllllllllllIIlIIlIIIIlllllI.pos((double)llllllllllllllllIIlIIlIIIIllllIl, (double)llllllllllllllllIIlIIlIIIIlllIlI, 0.0).color(llllllllllllllllIIlIIlIIIlIIIIlI, llllllllllllllllIIlIIlIIIlIIIIIl, llllllllllllllllIIlIIlIIIlIIIIII, llllllllllllllllIIlIIlIIIlIIIIll).endVertex();
        llllllllllllllllIIlIIlIIIIlllllI.pos((double)llllllllllllllllIIlIIlIIIlIIlIll, (double)llllllllllllllllIIlIIlIIIIlllIlI, 0.0).color(llllllllllllllllIIlIIlIIIlIIIIlI, llllllllllllllllIIlIIlIIIlIIIIIl, llllllllllllllllIIlIIlIIIlIIIIII, llllllllllllllllIIlIIlIIIlIIIIll).endVertex();
        llllllllllllllllIIlIIlIIIIllllll.draw();
        GlStateManager.shadeModel((int)7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    public static void drawNewRect(double llllllllllllllllIIlIIIlllIIlIIII, double llllllllllllllllIIlIIIlllIIIllll, double llllllllllllllllIIlIIIlllIIIIIll, double llllllllllllllllIIlIIIlllIIIllIl, int llllllllllllllllIIlIIIlllIIIIIIl) {
        if (llllllllllllllllIIlIIIlllIIlIIII < llllllllllllllllIIlIIIlllIIIIIll) {
            double llllllllllllllllIIlIIIlllIIlIIlI = llllllllllllllllIIlIIIlllIIlIIII;
            llllllllllllllllIIlIIIlllIIlIIII = llllllllllllllllIIlIIIlllIIIIIll;
            llllllllllllllllIIlIIIlllIIIIIll = llllllllllllllllIIlIIIlllIIlIIlI;
        }
        if (llllllllllllllllIIlIIIlllIIIllll < llllllllllllllllIIlIIIlllIIIllIl) {
            double llllllllllllllllIIlIIIlllIIlIIIl = llllllllllllllllIIlIIIlllIIIllll;
            llllllllllllllllIIlIIIlllIIIllll = llllllllllllllllIIlIIIlllIIIllIl;
            llllllllllllllllIIlIIIlllIIIllIl = llllllllllllllllIIlIIIlllIIlIIIl;
        }
        float llllllllllllllllIIlIIIlllIIIlIll = (float)(llllllllllllllllIIlIIIlllIIIIIIl >> 24 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIIlllIIIlIlI = (float)(llllllllllllllllIIlIIIlllIIIIIIl >> 16 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIIlllIIIlIIl = (float)(llllllllllllllllIIlIIIlllIIIIIIl >> 8 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIIlllIIIlIII = (float)(llllllllllllllllIIlIIIlllIIIIIIl & 0xFF) / 255.0f;
        Tessellator llllllllllllllllIIlIIIlllIIIIlll = Tessellator.getInstance();
        BufferBuilder llllllllllllllllIIlIIIlllIIIIllI = llllllllllllllllIIlIIIlllIIIIlll.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.color((float)llllllllllllllllIIlIIIlllIIIlIlI, (float)llllllllllllllllIIlIIIlllIIIlIIl, (float)llllllllllllllllIIlIIIlllIIIlIII, (float)llllllllllllllllIIlIIIlllIIIlIll);
        llllllllllllllllIIlIIIlllIIIIllI.begin(7, DefaultVertexFormats.POSITION);
        llllllllllllllllIIlIIIlllIIIIllI.pos(llllllllllllllllIIlIIIlllIIlIIII, llllllllllllllllIIlIIIlllIIIllIl, 0.0).endVertex();
        llllllllllllllllIIlIIIlllIIIIllI.pos(llllllllllllllllIIlIIIlllIIIIIll, llllllllllllllllIIlIIIlllIIIllIl, 0.0).endVertex();
        llllllllllllllllIIlIIIlllIIIIllI.pos(llllllllllllllllIIlIIIlllIIIIIll, llllllllllllllllIIlIIIlllIIIllll, 0.0).endVertex();
        llllllllllllllllIIlIIIlllIIIIllI.pos(llllllllllllllllIIlIIIlllIIlIIII, llllllllllllllllIIlIIIlllIIIllll, 0.0).endVertex();
        llllllllllllllllIIlIIIlllIIIIlll.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void drawGlow(double llllllllllllllllIIlIIlIIIIIllIIl, double llllllllllllllllIIlIIlIIIIIlllll, double llllllllllllllllIIlIIlIIIIIllllI, double llllllllllllllllIIlIIlIIIIIlIllI, int llllllllllllllllIIlIIlIIIIIlllII, double llllllllllllllllIIlIIlIIIIIllIll) {
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int)7425);
        RenderUtil.drawVGradientRect((int)llllllllllllllllIIlIIlIIIIIllIIl, (int)llllllllllllllllIIlIIlIIIIIlllll, (int)llllllllllllllllIIlIIlIIIIIllllI, (int)(llllllllllllllllIIlIIlIIIIIlllll + (llllllllllllllllIIlIIlIIIIIlIllI - llllllllllllllllIIlIIlIIIIIlllll) / 2.0), RenderUtil.injectAlpha(new Color(llllllllllllllllIIlIIlIIIIIlllII), 0).getRGB(), RenderUtil.injectAlpha(new Color(llllllllllllllllIIlIIlIIIIIlllII), (int)llllllllllllllllIIlIIlIIIIIllIll).getRGB());
        RenderUtil.drawVGradientRect((int)llllllllllllllllIIlIIlIIIIIllIIl, (int)(llllllllllllllllIIlIIlIIIIIlllll + (llllllllllllllllIIlIIlIIIIIlIllI - llllllllllllllllIIlIIlIIIIIlllll) / 2.0), (int)llllllllllllllllIIlIIlIIIIIllllI, (int)llllllllllllllllIIlIIlIIIIIlIllI, RenderUtil.injectAlpha(new Color(llllllllllllllllIIlIIlIIIIIlllII), (int)llllllllllllllllIIlIIlIIIIIllIll).getRGB(), RenderUtil.injectAlpha(new Color(llllllllllllllllIIlIIlIIIIIlllII), 0).getRGB());
        int llllllllllllllllIIlIIlIIIIIllIlI = (int)((llllllllllllllllIIlIIlIIIIIlIllI - llllllllllllllllIIlIIlIIIIIlllll) / 2.0);
        RenderUtil.drawPolygonPart(llllllllllllllllIIlIIlIIIIIllIIl, llllllllllllllllIIlIIlIIIIIlllll + (llllllllllllllllIIlIIlIIIIIlIllI - llllllllllllllllIIlIIlIIIIIlllll) / 2.0, llllllllllllllllIIlIIlIIIIIllIlI, 0, RenderUtil.injectAlpha(new Color(llllllllllllllllIIlIIlIIIIIlllII), (int)llllllllllllllllIIlIIlIIIIIllIll).getRGB(), RenderUtil.injectAlpha(new Color(llllllllllllllllIIlIIlIIIIIlllII), 0).getRGB());
        RenderUtil.drawPolygonPart(llllllllllllllllIIlIIlIIIIIllIIl, llllllllllllllllIIlIIlIIIIIlllll + (llllllllllllllllIIlIIlIIIIIlIllI - llllllllllllllllIIlIIlIIIIIlllll) / 2.0, llllllllllllllllIIlIIlIIIIIllIlI, 1, RenderUtil.injectAlpha(new Color(llllllllllllllllIIlIIlIIIIIlllII), (int)llllllllllllllllIIlIIlIIIIIllIll).getRGB(), RenderUtil.injectAlpha(new Color(llllllllllllllllIIlIIlIIIIIlllII), 0).getRGB());
        RenderUtil.drawPolygonPart(llllllllllllllllIIlIIlIIIIIllllI, llllllllllllllllIIlIIlIIIIIlllll + (llllllllllllllllIIlIIlIIIIIlIllI - llllllllllllllllIIlIIlIIIIIlllll) / 2.0, llllllllllllllllIIlIIlIIIIIllIlI, 2, RenderUtil.injectAlpha(new Color(llllllllllllllllIIlIIlIIIIIlllII), (int)llllllllllllllllIIlIIlIIIIIllIll).getRGB(), RenderUtil.injectAlpha(new Color(llllllllllllllllIIlIIlIIIIIlllII), 0).getRGB());
        RenderUtil.drawPolygonPart(llllllllllllllllIIlIIlIIIIIllllI, llllllllllllllllIIlIIlIIIIIlllll + (llllllllllllllllIIlIIlIIIIIlIllI - llllllllllllllllIIlIIlIIIIIlllll) / 2.0, llllllllllllllllIIlIIlIIIIIllIlI, 3, RenderUtil.injectAlpha(new Color(llllllllllllllllIIlIIlIIIIIlllII), (int)llllllllllllllllIIlIIlIIIIIllIll).getRGB(), RenderUtil.injectAlpha(new Color(llllllllllllllllIIlIIlIIIIIlllII), 0).getRGB());
        GlStateManager.shadeModel((int)7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    public static void drawFilledCircle(int llllllllllllllllIIlIIlIlIIlllIII, int llllllllllllllllIIlIIlIlIIllIIIl, float llllllllllllllllIIlIIlIlIIllIIII, Color llllllllllllllllIIlIIlIlIIllIlIl) {
        int llllllllllllllllIIlIIlIlIIllIlII = 6;
        double llllllllllllllllIIlIIlIlIIllIIll = Math.PI * 2 / (double)llllllllllllllllIIlIIlIlIIllIlII;
        GL11.glPushAttrib((int)8192);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GL11.glBegin((int)6);
        for (int llllllllllllllllIIlIIlIlIIlllIIl = 0; llllllllllllllllIIlIIlIlIIlllIIl < llllllllllllllllIIlIIlIlIIllIlII; ++llllllllllllllllIIlIIlIlIIlllIIl) {
            float llllllllllllllllIIlIIlIlIIlllIll = (float)((double)llllllllllllllllIIlIIlIlIIllIIII * Math.sin((double)llllllllllllllllIIlIIlIlIIlllIIl * llllllllllllllllIIlIIlIlIIllIIll));
            float llllllllllllllllIIlIIlIlIIlllIlI = (float)((double)llllllllllllllllIIlIIlIlIIllIIII * Math.cos((double)llllllllllllllllIIlIIlIlIIlllIIl * llllllllllllllllIIlIIlIlIIllIIll));
            GL11.glColor4f((float)((float)llllllllllllllllIIlIIlIlIIllIlIl.getRed() / 255.0f), (float)((float)llllllllllllllllIIlIIlIlIIllIlIl.getGreen() / 255.0f), (float)((float)llllllllllllllllIIlIIlIlIIllIlIl.getBlue() / 255.0f), (float)((float)llllllllllllllllIIlIIlIlIIllIlIl.getAlpha() / 255.0f));
            GL11.glVertex2f((float)((float)llllllllllllllllIIlIIlIlIIlllIII + llllllllllllllllIIlIIlIlIIlllIll), (float)((float)llllllllllllllllIIlIIlIlIIllIIIl + llllllllllllllllIIlIIlIlIIlllIlI));
        }
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glEnd();
        GL11.glPopAttrib();
    }

    public static void rectangleBordered(double llllllllllllllllIIlIIIlIllIlllIl, double llllllllllllllllIIlIIIlIllIlllII, double llllllllllllllllIIlIIIlIllIlIlII, double llllllllllllllllIIlIIIlIllIlIIll, double llllllllllllllllIIlIIIlIllIlIIlI, int llllllllllllllllIIlIIIlIllIlIIIl, int llllllllllllllllIIlIIIlIllIlIIII) {
        RenderUtil.drawRect(llllllllllllllllIIlIIIlIllIlllIl + llllllllllllllllIIlIIIlIllIlIIlI, llllllllllllllllIIlIIIlIllIlllII + llllllllllllllllIIlIIIlIllIlIIlI, llllllllllllllllIIlIIIlIllIlIlII - llllllllllllllllIIlIIIlIllIlIIlI, llllllllllllllllIIlIIIlIllIlIIll - llllllllllllllllIIlIIIlIllIlIIlI, llllllllllllllllIIlIIIlIllIlIIIl);
        RenderUtil.drawRect(llllllllllllllllIIlIIIlIllIlllIl + llllllllllllllllIIlIIIlIllIlIIlI, llllllllllllllllIIlIIIlIllIlllII, llllllllllllllllIIlIIIlIllIlIlII - llllllllllllllllIIlIIIlIllIlIIlI, llllllllllllllllIIlIIIlIllIlllII + llllllllllllllllIIlIIIlIllIlIIlI, llllllllllllllllIIlIIIlIllIlIIII);
        RenderUtil.drawRect(llllllllllllllllIIlIIIlIllIlllIl, llllllllllllllllIIlIIIlIllIlllII, llllllllllllllllIIlIIIlIllIlllIl + llllllllllllllllIIlIIIlIllIlIIlI, llllllllllllllllIIlIIIlIllIlIIll, llllllllllllllllIIlIIIlIllIlIIII);
        RenderUtil.drawRect(llllllllllllllllIIlIIIlIllIlIlII - llllllllllllllllIIlIIIlIllIlIIlI, llllllllllllllllIIlIIIlIllIlllII, llllllllllllllllIIlIIIlIllIlIlII, llllllllllllllllIIlIIIlIllIlIIll, llllllllllllllllIIlIIIlIllIlIIII);
        RenderUtil.drawRect(llllllllllllllllIIlIIIlIllIlllIl + llllllllllllllllIIlIIIlIllIlIIlI, llllllllllllllllIIlIIIlIllIlIIll - llllllllllllllllIIlIIIlIllIlIIlI, llllllllllllllllIIlIIIlIllIlIlII - llllllllllllllllIIlIIIlIllIlIIlI, llllllllllllllllIIlIIIlIllIlIIll, llllllllllllllllIIlIIIlIllIlIIII);
    }

    public static void blockEspFrame(BlockPos llllllllllllllllIIlIIIllIIIlIllI, double llllllllllllllllIIlIIIllIIIlIlIl, double llllllllllllllllIIlIIIllIIIIlIIl, double llllllllllllllllIIlIIIllIIIIlIII) {
        double llllllllllllllllIIlIIIllIIIlIIlI = llllllllllllllllIIlIIIllIIIlIllI.getX();
        double llllllllllllllllIIlIIIllIIIlIIIl = llllllllllllllllIIlIIIllIIIlIIlI - RenderUtil.mc.getRenderManager().viewerPosX;
        double llllllllllllllllIIlIIIllIIIlIIII = llllllllllllllllIIlIIIllIIIlIllI.getY();
        Minecraft.getMinecraft().getRenderManager();
        double llllllllllllllllIIlIIIllIIIIllll = llllllllllllllllIIlIIIllIIIlIIII - RenderUtil.mc.getRenderManager().viewerPosY;
        double llllllllllllllllIIlIIIllIIIIlllI = llllllllllllllllIIlIIIllIIIlIllI.getZ();
        Minecraft.getMinecraft().getRenderManager();
        double llllllllllllllllIIlIIIllIIIIllIl = llllllllllllllllIIlIIIllIIIIlllI - RenderUtil.mc.getRenderManager().viewerPosZ;
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)3042);
        GL11.glLineWidth((float)1.0f);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        GL11.glColor4d((double)llllllllllllllllIIlIIIllIIIlIlIl, (double)llllllllllllllllIIlIIIllIIIIlIIl, (double)llllllllllllllllIIlIIIllIIIIlIII, (double)0.5);
        RenderUtil.drawSelectionBoundingBox(new AxisAlignedBB(llllllllllllllllIIlIIIllIIIlIIIl, llllllllllllllllIIlIIIllIIIIllll, llllllllllllllllIIlIIIllIIIIllIl, llllllllllllllllIIlIIIllIIIlIIIl + 1.0, llllllllllllllllIIlIIIllIIIIllll + 1.0, llllllllllllllllIIlIIIllIIIIllIl + 1.0));
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2929);
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)3042);
    }

    public static void disableGL2D3() {
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glEnable((int)2929);
        GL11.glDisable((int)2848);
        GL11.glHint((int)3154, (int)4352);
        GL11.glHint((int)3155, (int)4352);
    }

    public static void drawRect(double llllllllllllllllIIlIIIlllIllllll, double llllllllllllllllIIlIIIllllIIlIIl, double llllllllllllllllIIlIIIllllIIlIII, double llllllllllllllllIIlIIIllllIIIlll, int llllllllllllllllIIlIIIllllIIIllI) {
        if (llllllllllllllllIIlIIIlllIllllll < llllllllllllllllIIlIIIllllIIlIII) {
            double llllllllllllllllIIlIIIllllIIllII = llllllllllllllllIIlIIIlllIllllll;
            llllllllllllllllIIlIIIlllIllllll = llllllllllllllllIIlIIIllllIIlIII;
            llllllllllllllllIIlIIIllllIIlIII = llllllllllllllllIIlIIIllllIIllII;
        }
        if (llllllllllllllllIIlIIIllllIIlIIl < llllllllllllllllIIlIIIllllIIIlll) {
            double llllllllllllllllIIlIIIllllIIlIll = llllllllllllllllIIlIIIllllIIlIIl;
            llllllllllllllllIIlIIIllllIIlIIl = llllllllllllllllIIlIIIllllIIIlll;
            llllllllllllllllIIlIIIllllIIIlll = llllllllllllllllIIlIIIllllIIlIll;
        }
        float llllllllllllllllIIlIIIllllIIIlIl = (float)(llllllllllllllllIIlIIIllllIIIllI >> 24 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIIllllIIIlII = (float)(llllllllllllllllIIlIIIllllIIIllI >> 16 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIIllllIIIIll = (float)(llllllllllllllllIIlIIIllllIIIllI >> 8 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIIIllllIIIIlI = (float)(llllllllllllllllIIlIIIllllIIIllI & 0xFF) / 255.0f;
        Tessellator llllllllllllllllIIlIIIllllIIIIIl = Tessellator.getInstance();
        BufferBuilder llllllllllllllllIIlIIIllllIIIIII = llllllllllllllllIIlIIIllllIIIIIl.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        GlStateManager.color((float)llllllllllllllllIIlIIIllllIIIlII, (float)llllllllllllllllIIlIIIllllIIIIll, (float)llllllllllllllllIIlIIIllllIIIIlI, (float)llllllllllllllllIIlIIIllllIIIlIl);
        llllllllllllllllIIlIIIllllIIIIII.begin(7, DefaultVertexFormats.POSITION);
        llllllllllllllllIIlIIIllllIIIIII.pos(llllllllllllllllIIlIIIlllIllllll, llllllllllllllllIIlIIIllllIIIlll, 0.0).endVertex();
        llllllllllllllllIIlIIIllllIIIIII.pos(llllllllllllllllIIlIIIllllIIlIII, llllllllllllllllIIlIIIllllIIIlll, 0.0).endVertex();
        llllllllllllllllIIlIIIllllIIIIII.pos(llllllllllllllllIIlIIIllllIIlIII, llllllllllllllllIIlIIIllllIIlIIl, 0.0).endVertex();
        llllllllllllllllIIlIIIllllIIIIII.pos(llllllllllllllllIIlIIIlllIllllll, llllllllllllllllIIlIIIllllIIlIIl, 0.0).endVertex();
        llllllllllllllllIIlIIIllllIIIIIl.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void enableGL2D3() {
        GL11.glDisable((int)2929);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDepthMask((boolean)true);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glHint((int)3155, (int)4354);
    }

    public static void drawLinesAroundPlayer(Entity llllllllllllllllIIlIIlIllIIllIII, double llllllllllllllllIIlIIlIllIIlIlll, float llllllllllllllllIIlIIlIllIIIlIlI, int llllllllllllllllIIlIIlIllIIIlIIl, double llllllllllllllllIIlIIlIllIIlIlII, int llllllllllllllllIIlIIlIllIIIIlll, float llllllllllllllllIIlIIlIllIIIIllI) {
        GL11.glPushMatrix();
        RenderUtil.enableGL2D3();
        GL11.glDisable((int)3553);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glDisable((int)2929);
        GL11.glLineWidth((float)((float)llllllllllllllllIIlIIlIllIIlIlII));
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDisable((int)2929);
        GL11.glBegin((int)3);
        RenderManager llllllllllllllllIIlIIlIllIIlIIIl = Minecraft.getMinecraft().getRenderManager();
        double llllllllllllllllIIlIIlIllIIlIIII = llllllllllllllllIIlIIlIllIIllIII.lastTickPosX + (llllllllllllllllIIlIIlIllIIllIII.posX - llllllllllllllllIIlIIlIllIIllIII.lastTickPosX) * (double)llllllllllllllllIIlIIlIllIIIlIlI - llllllllllllllllIIlIIlIllIIlIIIl.viewerPosX;
        double llllllllllllllllIIlIIlIllIIIllll = llllllllllllllllIIlIIlIllIIllIII.lastTickPosY + (llllllllllllllllIIlIIlIllIIllIII.posY - llllllllllllllllIIlIIlIllIIllIII.lastTickPosY) * (double)llllllllllllllllIIlIIlIllIIIlIlI - llllllllllllllllIIlIIlIllIIlIIIl.viewerPosY + (double)llllllllllllllllIIlIIlIllIIIIllI;
        double llllllllllllllllIIlIIlIllIIIlllI = llllllllllllllllIIlIIlIllIIllIII.lastTickPosZ + (llllllllllllllllIIlIIlIllIIllIII.posZ - llllllllllllllllIIlIIlIllIIllIII.lastTickPosZ) * (double)llllllllllllllllIIlIIlIllIIIlIlI - llllllllllllllllIIlIIlIllIIlIIIl.viewerPosZ;
        RenderUtil.color228(llllllllllllllllIIlIIlIllIIIIlll);
        for (int llllllllllllllllIIlIIlIllIIllIIl = 0; llllllllllllllllIIlIIlIllIIllIIl <= llllllllllllllllIIlIIlIllIIIlIIl; ++llllllllllllllllIIlIIlIllIIllIIl) {
            GL11.glVertex3d((double)(llllllllllllllllIIlIIlIllIIlIIII + llllllllllllllllIIlIIlIllIIlIlll * Math.cos((double)llllllllllllllllIIlIIlIllIIllIIl * (Math.PI * 2) / (double)llllllllllllllllIIlIIlIllIIIlIIl)), (double)llllllllllllllllIIlIIlIllIIIllll, (double)(llllllllllllllllIIlIIlIllIIIlllI + llllllllllllllllIIlIIlIllIIlIlll * Math.sin((double)llllllllllllllllIIlIIlIllIIllIIl * (Math.PI * 2) / (double)llllllllllllllllIIlIIlIllIIIlIIl)));
        }
        GL11.glEnd();
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)3042);
        GL11.glEnable((int)2929);
        GL11.glDisable((int)2848);
        GL11.glEnable((int)2929);
        GL11.glEnable((int)3553);
        RenderUtil.disableGL2D3();
        GL11.glPopMatrix();
    }

    public static void drawBorderedCircle(float llllllllllllllllIIlIIlIlllIlIIlI, float llllllllllllllllIIlIIlIlllIlIIIl, float llllllllllllllllIIlIIlIlllIlIllI, int llllllllllllllllIIlIIlIlllIIllll, int llllllllllllllllIIlIIlIlllIlIlII, int llllllllllllllllIIlIIlIlllIlIIll) {
        RenderUtil.drawCircle(llllllllllllllllIIlIIlIlllIlIIlI, llllllllllllllllIIlIIlIlllIlIIIl, llllllllllllllllIIlIIlIlllIlIllI, llllllllllllllllIIlIIlIlllIlIIll);
        RenderUtil.drawUnfilledCircle(llllllllllllllllIIlIIlIlllIlIIlI, llllllllllllllllIIlIIlIlllIlIIIl, llllllllllllllllIIlIIlIlllIlIllI, llllllllllllllllIIlIIlIlllIIllll, llllllllllllllllIIlIIlIlllIlIlII);
    }

    public static void drawBoundingBox(AxisAlignedBB llllllllllllllllIIlIIlIlIlIIIlIl) {
        GL11.glBegin((int)7);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.minX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.minX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.maxX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.maxX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.maxX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.maxX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.minX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.minX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.maxX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.maxX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.minX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.minX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.minX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.minX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.maxX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.maxX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.minX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.maxX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.maxX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.minX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.minX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.minX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.maxX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.maxX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.minX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.maxX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.maxX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.minX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.minX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.minX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.maxX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.maxX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.minX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.minX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.minX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.minX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.maxX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.maxX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.maxX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.maxX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.minX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.minX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.minX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.minX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.maxX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.maxX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.maxX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxZ);
        GL11.glVertex3d((double)llllllllllllllllIIlIIlIlIlIIIlIl.maxX, (double)llllllllllllllllIIlIIlIlIlIIIlIl.minY, (double)llllllllllllllllIIlIIlIlIlIIIlIl.maxZ);
        GL11.glEnd();
    }
}

