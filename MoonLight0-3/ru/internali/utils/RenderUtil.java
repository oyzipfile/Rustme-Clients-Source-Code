/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.model.ModelBiped
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.RenderGlobal
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.client.renderer.RenderItem
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.culling.Frustum
 *  net.minecraft.client.renderer.culling.ICamera
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.opengl.GL11
 */
package ru.internali.utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import ru.internali.settings.RGBSetting;
import ru.internali.utils.ColorUtils;
import ru.internali.utils.EntityUtil;
import ru.internali.utils.MathUtils;
import ru.internali.utils.MinecraftHelper;
import ru.internali.utils.Vec3dSimple;
import ru.internali.utils.friend.FriendManager;

public class RenderUtil
implements MinecraftHelper {
    private static /* synthetic */ boolean bind;
    private static /* synthetic */ boolean texture;
    public static /* synthetic */ RenderItem itemRender;
    private static final /* synthetic */ FloatBuffer modelView;
    private static /* synthetic */ boolean override;
    private static final /* synthetic */ FloatBuffer projection;
    private static final /* synthetic */ IntBuffer viewport;
    private static /* synthetic */ HashMap<Integer, Integer> shadowCache;
    private static final /* synthetic */ FloatBuffer screenCoords;
    private static /* synthetic */ boolean depth;
    private static final /* synthetic */ double DOUBLE_PI = Math.PI * 2;
    private static final /* synthetic */ AxisAlignedBB DEFAULT_AABB;
    private static final /* synthetic */ Frustum frustrum;
    public static /* synthetic */ ICamera camera;
    private static /* synthetic */ boolean clean;

    public static void drawSolidBox() {
        RenderUtil.drawSolidBox(DEFAULT_AABB);
    }

    public static boolean isInViewFrustrum(Entity llIllIIIlIIIlll) {
        return RenderUtil.isInViewFrustrum(llIllIIIlIIIlll.getEntityBoundingBox()) || llIllIIIlIIIlll.ignoreFrustumCheck;
    }

    public static void drawImage(ResourceLocation llIllIllllllllI, int llIllIllllllIII, int llIllIlllllllII, int llIllIlllllIllI, int llIllIllllllIlI) {
        GL11.glEnable((int)2848);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glPushMatrix();
        Minecraft.getMinecraft().getTextureManager().bindTexture(llIllIllllllllI);
        Gui.drawModalRectWithCustomSizedTexture((int)llIllIllllllIII, (int)llIllIlllllllII, (float)0.0f, (float)0.0f, (int)llIllIlllllIllI, (int)llIllIllllllIlI, (float)llIllIlllllIllI, (float)llIllIllllllIlI);
        RenderUtil.disableGL2D();
        GL11.glPopMatrix();
    }

    public static void drawOctagon(float llIlllIlIlIlIII, float llIlllIlIlIIlll, float llIlllIlIllIIIl, float llIlllIlIllIIII, float llIlllIlIlIIIll, float llIlllIlIlIIIlI, int llIlllIlIlIIIIl) {
        float llIlllIlIlIllII = RenderUtil.convertColor(24, llIlllIlIlIIIIl);
        float llIlllIlIlIlIll = RenderUtil.convertColor(16, llIlllIlIlIIIIl);
        float llIlllIlIlIlIlI = RenderUtil.convertColor(8, llIlllIlIlIIIIl);
        float llIlllIlIlIlIIl = RenderUtil.convertColor(0, llIlllIlIlIIIIl);
        RenderUtil.glRenderStart();
        GL11.glColor4f((float)llIlllIlIlIlIll, (float)llIlllIlIlIlIlI, (float)llIlllIlIlIlIIl, (float)llIlllIlIlIllII);
        GL11.glBegin((int)9);
        GL11.glVertex2d((double)(llIlllIlIlIlIII + llIlllIlIlIIIll), (double)llIlllIlIlIIlll);
        GL11.glVertex2d((double)(llIlllIlIlIlIII + llIlllIlIllIIIl - llIlllIlIlIIIll), (double)llIlllIlIlIIlll);
        GL11.glVertex2d((double)(llIlllIlIlIlIII + llIlllIlIllIIIl - llIlllIlIlIIIll), (double)llIlllIlIlIIlll);
        GL11.glVertex2d((double)(llIlllIlIlIlIII + llIlllIlIllIIIl), (double)(llIlllIlIlIIlll + llIlllIlIllIIII / 2.0f - llIlllIlIlIIIlI));
        GL11.glVertex2d((double)(llIlllIlIlIlIII + llIlllIlIllIIIl), (double)(llIlllIlIlIIlll + llIlllIlIllIIII / 2.0f - llIlllIlIlIIIlI));
        GL11.glVertex2d((double)(llIlllIlIlIlIII + llIlllIlIllIIIl), (double)(llIlllIlIlIIlll + llIlllIlIllIIII / 2.0f + llIlllIlIlIIIlI));
        GL11.glVertex2d((double)(llIlllIlIlIlIII + llIlllIlIllIIIl), (double)(llIlllIlIlIIlll + llIlllIlIllIIII / 2.0f + llIlllIlIlIIIlI));
        GL11.glVertex2d((double)(llIlllIlIlIlIII + llIlllIlIllIIIl - llIlllIlIlIIIll), (double)(llIlllIlIlIIlll + llIlllIlIllIIII));
        GL11.glVertex2d((double)(llIlllIlIlIlIII + llIlllIlIllIIIl - llIlllIlIlIIIll), (double)(llIlllIlIlIIlll + llIlllIlIllIIII));
        GL11.glVertex2d((double)(llIlllIlIlIlIII + llIlllIlIlIIIll), (double)(llIlllIlIlIIlll + llIlllIlIllIIII));
        GL11.glVertex2d((double)(llIlllIlIlIlIII + llIlllIlIlIIIll), (double)(llIlllIlIlIIlll + llIlllIlIllIIII));
        GL11.glVertex2d((double)llIlllIlIlIlIII, (double)(llIlllIlIlIIlll + llIlllIlIllIIII / 2.0f + llIlllIlIlIIIlI));
        GL11.glVertex2d((double)llIlllIlIlIlIII, (double)(llIlllIlIlIIlll + llIlllIlIllIIII / 2.0f + llIlllIlIlIIIlI));
        GL11.glVertex2d((double)llIlllIlIlIlIII, (double)(llIlllIlIlIIlll + llIlllIlIllIIII / 2.0f - llIlllIlIlIIIlI));
        GL11.glVertex2d((double)llIlllIlIlIlIII, (double)(llIlllIlIlIIlll + llIlllIlIllIIII / 2.0f - llIlllIlIlIIIlI));
        GL11.glVertex2d((double)(llIlllIlIlIlIII + llIlllIlIlIIIll), (double)llIlllIlIlIIlll);
        GL11.glEnd();
        RenderUtil.glRenderStop();
    }

    public static void drawSelectionBoundingBox(AxisAlignedBB llIlIllllIIllIl) {
        Tessellator llIlIllllIIllII = Tessellator.getInstance();
        BufferBuilder llIlIllllIIlIll = llIlIllllIIllII.getBuffer();
        llIlIllllIIlIll.begin(3, DefaultVertexFormats.POSITION);
        llIlIllllIIlIll.pos(llIlIllllIIllIl.minX, llIlIllllIIllIl.minY, llIlIllllIIllIl.minZ).endVertex();
        llIlIllllIIlIll.pos(llIlIllllIIllIl.maxX, llIlIllllIIllIl.minY, llIlIllllIIllIl.minZ).endVertex();
        llIlIllllIIlIll.pos(llIlIllllIIllIl.maxX, llIlIllllIIllIl.minY, llIlIllllIIllIl.maxZ).endVertex();
        llIlIllllIIlIll.pos(llIlIllllIIllIl.minX, llIlIllllIIllIl.minY, llIlIllllIIllIl.maxZ).endVertex();
        llIlIllllIIlIll.pos(llIlIllllIIllIl.minX, llIlIllllIIllIl.minY, llIlIllllIIllIl.minZ).endVertex();
        llIlIllllIIllII.draw();
        llIlIllllIIlIll.begin(3, DefaultVertexFormats.POSITION);
        llIlIllllIIlIll.pos(llIlIllllIIllIl.minX, llIlIllllIIllIl.maxY, llIlIllllIIllIl.minZ).endVertex();
        llIlIllllIIlIll.pos(llIlIllllIIllIl.maxX, llIlIllllIIllIl.maxY, llIlIllllIIllIl.minZ).endVertex();
        llIlIllllIIlIll.pos(llIlIllllIIllIl.maxX, llIlIllllIIllIl.maxY, llIlIllllIIllIl.maxZ).endVertex();
        llIlIllllIIlIll.pos(llIlIllllIIllIl.minX, llIlIllllIIllIl.maxY, llIlIllllIIllIl.maxZ).endVertex();
        llIlIllllIIlIll.pos(llIlIllllIIllIl.minX, llIlIllllIIllIl.maxY, llIlIllllIIllIl.minZ).endVertex();
        llIlIllllIIllII.draw();
        llIlIllllIIlIll.begin(1, DefaultVertexFormats.POSITION);
        llIlIllllIIlIll.pos(llIlIllllIIllIl.minX, llIlIllllIIllIl.minY, llIlIllllIIllIl.minZ).endVertex();
        llIlIllllIIlIll.pos(llIlIllllIIllIl.minX, llIlIllllIIllIl.maxY, llIlIllllIIllIl.minZ).endVertex();
        llIlIllllIIlIll.pos(llIlIllllIIllIl.maxX, llIlIllllIIllIl.minY, llIlIllllIIllIl.minZ).endVertex();
        llIlIllllIIlIll.pos(llIlIllllIIllIl.maxX, llIlIllllIIllIl.maxY, llIlIllllIIllIl.minZ).endVertex();
        llIlIllllIIlIll.pos(llIlIllllIIllIl.maxX, llIlIllllIIllIl.minY, llIlIllllIIllIl.maxZ).endVertex();
        llIlIllllIIlIll.pos(llIlIllllIIllIl.maxX, llIlIllllIIllIl.maxY, llIlIllllIIllIl.maxZ).endVertex();
        llIlIllllIIlIll.pos(llIlIllllIIllIl.minX, llIlIllllIIllIl.minY, llIlIllllIIllIl.maxZ).endVertex();
        llIlIllllIIlIll.pos(llIlIllllIIllIl.minX, llIlIllllIIllIl.maxY, llIlIllllIIllIl.maxZ).endVertex();
        llIlIllllIIllII.draw();
    }

    public static void drawBorderedRect(float llIllllIlIllIII, float llIllllIlIIllII, float llIllllIlIlIllI, float llIllllIlIlIlIl, float llIllllIlIIlIIl, int llIllllIlIlIIll, int llIllllIlIIIlll) {
        RenderUtil.drawRect(llIllllIlIllIII, llIllllIlIIllII, llIllllIlIlIllI, llIllllIlIlIlIl, llIllllIlIIIlll);
        float llIllllIlIlIIIl = (float)(llIllllIlIlIIll >> 24 & 0xFF) / 255.0f;
        float llIllllIlIlIIII = (float)(llIllllIlIlIIll >> 16 & 0xFF) / 255.0f;
        float llIllllIlIIllll = (float)(llIllllIlIlIIll >> 8 & 0xFF) / 255.0f;
        float llIllllIlIIlllI = (float)(llIllllIlIlIIll & 0xFF) / 255.0f;
        RenderUtil.glRenderStart();
        GL11.glColor4f((float)llIllllIlIlIIII, (float)llIllllIlIIllll, (float)llIllllIlIIlllI, (float)llIllllIlIlIIIl);
        GL11.glLineWidth((float)llIllllIlIIlIIl);
        GL11.glEnable((int)2848);
        GL11.glBegin((int)1);
        GL11.glVertex2d((double)llIllllIlIllIII, (double)llIllllIlIIllII);
        GL11.glVertex2d((double)llIllllIlIlIllI, (double)llIllllIlIIllII);
        GL11.glVertex2d((double)llIllllIlIlIllI, (double)llIllllIlIIllII);
        GL11.glVertex2d((double)llIllllIlIlIllI, (double)llIllllIlIlIlIl);
        GL11.glVertex2d((double)llIllllIlIlIllI, (double)llIllllIlIlIlIl);
        GL11.glVertex2d((double)llIllllIlIllIII, (double)llIllllIlIlIlIl);
        GL11.glVertex2d((double)llIllllIlIllIII, (double)llIllllIlIlIlIl);
        GL11.glVertex2d((double)llIllllIlIllIII, (double)llIllllIlIIllII);
        GL11.glEnd();
        RenderUtil.glRenderStop();
    }

    public static void drawCircle228(float llIllllIllIllll, float llIllllIllIlllI, float llIllllIllIIllI, int llIllllIllIllII, int llIllllIllIlIll, int llIllllIllIIlIl, int llIllllIllIIlII) {
        RenderUtil.drawCircle228(llIllllIllIllll, llIllllIllIlllI, llIllllIllIIllI, llIllllIllIIlIl, llIllllIllIIlII);
    }

    public static void draw2DTriangleDown(double llIlIllIlIlIlll, double llIlIllIlIIllII, double llIlIllIlIlIlIl, double llIlIllIlIlIlII, float llIlIllIlIIlIIl, float llIlIllIlIIlIII, float llIlIllIlIlIIIl, float llIlIllIlIlIIII) {
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        Tessellator llIlIllIlIIllll = Tessellator.getInstance();
        BufferBuilder llIlIllIlIIlllI = llIlIllIlIIllll.getBuffer();
        GlStateManager.color((float)llIlIllIlIIlIIl, (float)llIlIllIlIIlIII, (float)llIlIllIlIlIIIl, (float)llIlIllIlIlIIII);
        llIlIllIlIIlllI.begin(4, DefaultVertexFormats.POSITION);
        llIlIllIlIIlllI.pos(llIlIllIlIlIlll, llIlIllIlIIllII, 0.0).endVertex();
        llIlIllIlIIlllI.pos(llIlIllIlIlIlll + llIlIllIlIlIlIl / 2.0, llIlIllIlIIllII + llIlIllIlIlIlII, 0.0).endVertex();
        llIlIllIlIIlllI.pos(llIlIllIlIlIlll + llIlIllIlIlIlIl, llIlIllIlIIllII, 0.0).endVertex();
        llIlIllIlIIllll.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void drawCircle222(float lllIIIIIIlIIIII, float lllIIIIIIlIlIll, float lllIIIIIIIllllI, int lllIIIIIIlIlIIl, int lllIIIIIIIlllII) {
        float lllIIIIIIlIIlll = (float)(lllIIIIIIlIlIIl >> 24 & 0xFF) / 255.0f;
        float lllIIIIIIlIIllI = (float)(lllIIIIIIlIlIIl >> 16 & 0xFF) / 255.0f;
        float lllIIIIIIlIIlIl = (float)(lllIIIIIIlIlIIl >> 8 & 0xFF) / 255.0f;
        float lllIIIIIIlIIlII = (float)(lllIIIIIIlIlIIl & 0xFF) / 255.0f;
        boolean lllIIIIIIlIIIll = GL11.glIsEnabled((int)3042);
        boolean lllIIIIIIlIIIlI = GL11.glIsEnabled((int)2848);
        boolean lllIIIIIIlIIIIl = GL11.glIsEnabled((int)3553);
        if (!lllIIIIIIlIIIll) {
            GL11.glEnable((int)3042);
        }
        if (!lllIIIIIIlIIIlI) {
            GL11.glEnable((int)2848);
        }
        if (lllIIIIIIlIIIIl) {
            GL11.glDisable((int)3553);
        }
        GL11.glEnable((int)2848);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glColor4f((float)lllIIIIIIlIIllI, (float)lllIIIIIIlIIlIl, (float)lllIIIIIIlIIlII, (float)lllIIIIIIlIIlll);
        GL11.glLineWidth((float)2.5f);
        GL11.glBegin((int)3);
        for (int lllIIIIIIlIllIl = 0; lllIIIIIIlIllIl <= lllIIIIIIIlllII; ++lllIIIIIIlIllIl) {
            GL11.glVertex2d((double)((double)lllIIIIIIlIIIII + Math.sin((double)lllIIIIIIlIllIl * Math.PI / 180.0) * (double)lllIIIIIIIllllI), (double)((double)lllIIIIIIlIlIll + Math.cos((double)lllIIIIIIlIllIl * Math.PI / 180.0) * (double)lllIIIIIIIllllI));
        }
        GL11.glEnd();
        GL11.glDisable((int)2848);
        if (lllIIIIIIlIIIIl) {
            GL11.glEnable((int)3553);
        }
        if (!lllIIIIIIlIIIlI) {
            GL11.glDisable((int)2848);
        }
        if (!lllIIIIIIlIIIll) {
            GL11.glDisable((int)3042);
        }
    }

    public static double interpolate(double lllIIIlIlIlIIlI, double lllIIIlIlIlIIIl, double lllIIIlIlIIllIl) {
        return lllIIIlIlIlIIIl + (lllIIIlIlIlIIlI - lllIIIlIlIlIIIl) * lllIIIlIlIIllIl;
    }

    public static void color228(int llIllIIIIlIIIlI) {
        GL11.glColor4ub((byte)((byte)(llIllIIIIlIIIlI >> 16 & 0xFF)), (byte)((byte)(llIllIIIIlIIIlI >> 8 & 0xFF)), (byte)((byte)(llIllIIIIlIIIlI & 0xFF)), (byte)((byte)(llIllIIIIlIIIlI >> 24 & 0xFF)));
    }

    public static void drawPolygonPart(double llIllIlIIlllllI, double llIllIlIlIIlllI, int llIllIlIIllllII, int llIllIlIlIIllII, int llIllIlIIlllIlI, int llIllIlIlIIlIlI) {
        float llIllIlIlIIlIIl = (float)(llIllIlIIlllIlI >> 24 & 0xFF) / 255.0f;
        float llIllIlIlIIlIII = (float)(llIllIlIIlllIlI >> 16 & 0xFF) / 255.0f;
        float llIllIlIlIIIlll = (float)(llIllIlIIlllIlI >> 8 & 0xFF) / 255.0f;
        float llIllIlIlIIIllI = (float)(llIllIlIIlllIlI & 0xFF) / 255.0f;
        float llIllIlIlIIIlIl = (float)(llIllIlIlIIlIlI >> 24 & 0xFF) / 255.0f;
        float llIllIlIlIIIlII = (float)(llIllIlIlIIlIlI >> 16 & 0xFF) / 255.0f;
        float llIllIlIlIIIIll = (float)(llIllIlIlIIlIlI >> 8 & 0xFF) / 255.0f;
        float llIllIlIlIIIIlI = (float)(llIllIlIlIIlIlI & 0xFF) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int)7425);
        Tessellator llIllIlIlIIIIIl = Tessellator.getInstance();
        BufferBuilder llIllIlIlIIIIII = llIllIlIlIIIIIl.getBuffer();
        llIllIlIlIIIIII.begin(6, DefaultVertexFormats.POSITION_COLOR);
        llIllIlIlIIIIII.pos(llIllIlIIlllllI, llIllIlIlIIlllI, 0.0).color(llIllIlIlIIlIII, llIllIlIlIIIlll, llIllIlIlIIIllI, llIllIlIlIIlIIl).endVertex();
        double llIllIlIIllllll = Math.PI * 2;
        for (int llIllIlIlIlIIII = llIllIlIlIIllII * 90; llIllIlIlIlIIII <= llIllIlIlIIllII * 90 + 90; ++llIllIlIlIlIIII) {
            double llIllIlIlIlIIIl = Math.PI * 2 * (double)llIllIlIlIlIIII / 360.0 + Math.toRadians(180.0);
            llIllIlIlIIIIII.pos(llIllIlIIlllllI + Math.sin(llIllIlIlIlIIIl) * (double)llIllIlIIllllII, llIllIlIlIIlllI + Math.cos(llIllIlIlIlIIIl) * (double)llIllIlIIllllII, 0.0).color(llIllIlIlIIIlII, llIllIlIlIIIIll, llIllIlIlIIIIlI, llIllIlIlIIIlIl).endVertex();
        }
        llIllIlIlIIIIIl.draw();
        GlStateManager.shadeModel((int)7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    public static float convertColor(int llIlllIlllIIlll, int llIlllIlllIIlII) {
        return (float)(llIlllIlllIIlII >> llIlllIlllIIlll & 0xFF) / 255.0f;
    }

    static {
        itemRender = mc.getRenderItem();
        camera = new Frustum();
        DEFAULT_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
        depth = GL11.glIsEnabled((int)2896);
        texture = GL11.glIsEnabled((int)3042);
        clean = GL11.glIsEnabled((int)3553);
        bind = GL11.glIsEnabled((int)2929);
        override = GL11.glIsEnabled((int)2848);
        screenCoords = BufferUtils.createFloatBuffer((int)3);
        viewport = BufferUtils.createIntBuffer((int)16);
        modelView = BufferUtils.createFloatBuffer((int)16);
        projection = BufferUtils.createFloatBuffer((int)16);
        frustrum = new Frustum();
        shadowCache = new HashMap();
    }

    public static void drawFilledCircle(EntityPlayerSP llIlIllIIlIIlIl, float llIlIllIIlIIlII, float llIlIllIIlIIIll, int llIlIllIIlIIIlI, float llIlIllIIlIIIIl, int llIlIllIIlIIIII) {
    }

    public static void drawRect(double llIllIIlIIIllIl, double llIllIIlIIlIlll, double llIllIIlIIIlIll, double llIllIIlIIlIlIl, int llIllIIlIIlIlII) {
        if (llIllIIlIIIllIl < llIllIIlIIIlIll) {
            double llIllIIlIIllIlI = llIllIIlIIIllIl;
            llIllIIlIIIllIl = llIllIIlIIIlIll;
            llIllIIlIIIlIll = llIllIIlIIllIlI;
        }
        if (llIllIIlIIlIlll < llIllIIlIIlIlIl) {
            double llIllIIlIIllIIl = llIllIIlIIlIlll;
            llIllIIlIIlIlll = llIllIIlIIlIlIl;
            llIllIIlIIlIlIl = llIllIIlIIllIIl;
        }
        float llIllIIlIIlIIll = (float)(llIllIIlIIlIlII >> 24 & 0xFF) / 255.0f;
        float llIllIIlIIlIIlI = (float)(llIllIIlIIlIlII >> 16 & 0xFF) / 255.0f;
        float llIllIIlIIlIIIl = (float)(llIllIIlIIlIlII >> 8 & 0xFF) / 255.0f;
        float llIllIIlIIlIIII = (float)(llIllIIlIIlIlII & 0xFF) / 255.0f;
        Tessellator llIllIIlIIIllll = Tessellator.getInstance();
        BufferBuilder llIllIIlIIIlllI = llIllIIlIIIllll.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        GlStateManager.color((float)llIllIIlIIlIIlI, (float)llIllIIlIIlIIIl, (float)llIllIIlIIlIIII, (float)llIllIIlIIlIIll);
        llIllIIlIIIlllI.begin(7, DefaultVertexFormats.POSITION);
        llIllIIlIIIlllI.pos(llIllIIlIIIllIl, llIllIIlIIlIlIl, 0.0).endVertex();
        llIllIIlIIIlllI.pos(llIllIIlIIIlIll, llIllIIlIIlIlIl, 0.0).endVertex();
        llIllIIlIIIlllI.pos(llIllIIlIIIlIll, llIllIIlIIlIlll, 0.0).endVertex();
        llIllIIlIIIlllI.pos(llIllIIlIIIllIl, llIllIIlIIlIlll, 0.0).endVertex();
        llIllIIlIIIllll.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void drawFadeESP(Entity lllIIIlIIlIIIll, ColorUtils lllIIIlIIlIIIlI, ColorUtils lllIIIlIIIllllI) {
        GL11.glPushMatrix();
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2929);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glBegin((int)3);
        for (int lllIIIlIIlIIlII = 0; lllIIIlIIlIIlII <= 360; ++lllIIIlIIlIIlII) {
            ColorUtils.glColor(Color.green);
            GL11.glVertex3d((double)lllIIIlIIlIIIll.posX, (double)lllIIIlIIlIIIll.posY, (double)lllIIIlIIlIIIll.posZ);
            ColorUtils.getColor(Color.darkGray);
            GL11.glVertex3d((double)(lllIIIlIIlIIIll.posX - Math.sin(Math.toRadians(lllIIIlIIlIIlII))), (double)lllIIIlIIlIIIll.posY, (double)(lllIIIlIIlIIIll.posZ + Math.cos(Math.toRadians(lllIIIlIIlIIlII))));
        }
        GL11.glEnd();
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2929);
        GL11.glDisable((int)3042);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glPopMatrix();
    }

    public static void renderEntityBoundingBox(Entity lllIIIIIIIIlIll, float lllIIIIIIIIlIlI, float lllIIIIIIIIlIIl, float lllIIIIIIIIIIII, float llIllllllllllll) {
        RenderManager lllIIIIIIIIIllI = Minecraft.getMinecraft().getRenderManager();
        Vec3d lllIIIIIIIIIlIl = MathUtils.interpolateEntity(lllIIIIIIIIlIll);
        AxisAlignedBB lllIIIIIIIIIlII = new AxisAlignedBB(lllIIIIIIIIIlIl.x - (double)(lllIIIIIIIIlIll.width / 2.0f), lllIIIIIIIIIlIl.y, lllIIIIIIIIIlIl.z - (double)(lllIIIIIIIIlIll.width / 2.0f), lllIIIIIIIIIlIl.x + (double)(lllIIIIIIIIlIll.width / 2.0f), lllIIIIIIIIIlIl.y + (double)lllIIIIIIIIlIll.height, lllIIIIIIIIIlIl.z + (double)(lllIIIIIIIIlIll.width / 2.0f)).offset(-lllIIIIIIIIIllI.viewerPosX, -lllIIIIIIIIIllI.viewerPosY, -lllIIIIIIIIIllI.viewerPosZ);
        RenderGlobal.drawSelectionBoundingBox((AxisAlignedBB)lllIIIIIIIIIlII, (float)lllIIIIIIIIlIlI, (float)lllIIIIIIIIlIIl, (float)lllIIIIIIIIIIII, (float)llIllllllllllll);
    }

    public static void draw2DRect(double llIlIlllIIIlIIl, double llIlIlllIIlIIlI, double llIlIlllIIlIIIl, double llIlIlllIIlIIII, float llIlIlllIIIIlIl, float llIlIlllIIIIlII, float llIlIlllIIIllIl, float llIlIlllIIIllII) {
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        Tessellator llIlIlllIIIlIll = Tessellator.getInstance();
        BufferBuilder llIlIlllIIIlIlI = llIlIlllIIIlIll.getBuffer();
        GlStateManager.color((float)llIlIlllIIIIlIl, (float)llIlIlllIIIIlII, (float)llIlIlllIIIllIl, (float)llIlIlllIIIllII);
        llIlIlllIIIlIlI.begin(5, DefaultVertexFormats.POSITION);
        llIlIlllIIIlIlI.pos(llIlIlllIIIlIIl, llIlIlllIIlIIlI, 0.0).endVertex();
        llIlIlllIIIlIlI.pos(llIlIlllIIIlIIl, llIlIlllIIlIIlI + llIlIlllIIlIIII, 0.0).endVertex();
        llIlIlllIIIlIlI.pos(llIlIlllIIIlIIl + llIlIlllIIlIIIl, llIlIlllIIlIIlI, 0.0).endVertex();
        llIlIlllIIIlIlI.pos(llIlIlllIIIlIIl + llIlIlllIIlIIIl, llIlIlllIIlIIlI + llIlIlllIIlIIII, 0.0).endVertex();
        llIlIlllIIIlIll.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void renderBlurredShadow(double lllIIIIlIlIIIIl, double lllIIIIlIlIlIlI, double lllIIIIlIIlllll, double lllIIIIlIIllllI, int lllIIIIlIlIIlll, Color lllIIIIlIlIIllI) {
        GlStateManager.alphaFunc((int)516, (float)0.01f);
        float lllIIIIlIlIIlIl = (float)((lllIIIIlIlIIIIl -= (double)lllIIIIlIlIIlll) - 0.25);
        float lllIIIIlIlIIlII = (float)((lllIIIIlIlIlIlI -= (double)lllIIIIlIlIIlll) + 0.25);
        int lllIIIIlIlIIIll = (int)((lllIIIIlIIlllll += (double)(lllIIIIlIlIIlll * 2)) * (lllIIIIlIIllllI += (double)(lllIIIIlIlIIlll * 2)) + lllIIIIlIIlllll + (double)(lllIIIIlIlIIllI.hashCode() * lllIIIIlIlIIlll) + (double)lllIIIIlIlIIlll);
        GL11.glEnable((int)3553);
        GL11.glDisable((int)2884);
        GL11.glEnable((int)3008);
        GL11.glEnable((int)3042);
        int lllIIIIlIlIIIlI = -1;
        if (shadowCache.containsKey(lllIIIIlIlIIIll)) {
            lllIIIIlIlIIIlI = shadowCache.get(lllIIIIlIlIIIll);
            GlStateManager.bindTexture((int)lllIIIIlIlIIIlI);
        } else {
            lllIIIIlIIlllll = MathHelper.clamp((double)lllIIIIlIIlllll, (double)0.01, (double)lllIIIIlIIlllll);
            lllIIIIlIIllllI = MathHelper.clamp((double)lllIIIIlIIllllI, (double)0.01, (double)lllIIIIlIIllllI);
            BufferedImage lllIIIIlIlIllIl = new BufferedImage((int)lllIIIIlIIlllll, (int)lllIIIIlIIllllI, 2);
            Graphics lllIIIIlIlIllII = lllIIIIlIlIllIl.getGraphics();
            lllIIIIlIlIllII.setColor(lllIIIIlIlIIllI);
            lllIIIIlIlIllII.fillRect(lllIIIIlIlIIlll, lllIIIIlIlIIlll, (int)lllIIIIlIIlllll - lllIIIIlIlIIlll * 2, (int)lllIIIIlIIllllI - lllIIIIlIlIIlll * 2);
            lllIIIIlIlIllII.dispose();
            shadowCache.put(lllIIIIlIlIIIll, lllIIIIlIlIIIlI);
        }
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glBegin((int)7);
        GL11.glTexCoord2f((float)0.0f, (float)0.0f);
        GL11.glVertex2f((float)lllIIIIlIlIIlIl, (float)lllIIIIlIlIIlII);
        GL11.glTexCoord2f((float)0.0f, (float)1.0f);
        GL11.glVertex2f((float)lllIIIIlIlIIlIl, (float)(lllIIIIlIlIIlII + (float)((int)lllIIIIlIIllllI)));
        GL11.glTexCoord2f((float)1.0f, (float)1.0f);
        GL11.glVertex2f((float)(lllIIIIlIlIIlIl + (float)((int)lllIIIIlIIlllll)), (float)(lllIIIIlIlIIlII + (float)((int)lllIIIIlIIllllI)));
        GL11.glTexCoord2f((float)1.0f, (float)0.0f);
        GL11.glVertex2f((float)(lllIIIIlIlIIlIl + (float)((int)lllIIIIlIIlllll)), (float)lllIIIIlIlIIlII);
        GL11.glEnd();
        GL11.glDisable((int)3553);
    }

    public static Color injectAlpha(Color llIllIIlllllIIl, int llIllIIlllllIII) {
        return new Color(llIllIIlllllIIl.getRed(), llIllIIlllllIIl.getGreen(), llIllIIlllllIIl.getBlue(), llIllIIlllllIII);
    }

    public static void glRenderStart() {
        GL11.glPushMatrix();
        GL11.glPushAttrib((int)1048575);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)2884);
        GL11.glDisable((int)3553);
    }

    public static void drawRoundedRect(int llIlllIIIlllllI, int llIlllIIIllllIl, int llIlllIIIllllII, int llIlllIIIllIlII, int llIlllIIIllIIll) {
        int llIlllIIIlllIIl = llIlllIIIlllllI + llIlllIIIllllII;
        int llIlllIIIlllIII = llIlllIIIllllIl + llIlllIIIllIlII;
        RenderUtil.drawRect(llIlllIIIlllllI + 1, llIlllIIIllllIl, llIlllIIIlllIIl - 1, llIlllIIIlllIII, llIlllIIIllIIll);
        RenderUtil.drawRect(llIlllIIIlllllI, llIlllIIIllllIl + 1, llIlllIIIlllIIl, llIlllIIIlllIII - 1, llIlllIIIllIIll);
    }

    public static void drawSolidBox(AxisAlignedBB lllIIIIllllIIII) {
        GL11.glBegin((int)7);
        GL11.glVertex3d((double)lllIIIIllllIIII.minX, (double)lllIIIIllllIIII.minY, (double)lllIIIIllllIIII.minZ);
        GL11.glVertex3d((double)lllIIIIllllIIII.maxX, (double)lllIIIIllllIIII.minY, (double)lllIIIIllllIIII.minZ);
        GL11.glVertex3d((double)lllIIIIllllIIII.maxX, (double)lllIIIIllllIIII.minY, (double)lllIIIIllllIIII.maxZ);
        GL11.glVertex3d((double)lllIIIIllllIIII.minX, (double)lllIIIIllllIIII.minY, (double)lllIIIIllllIIII.maxZ);
        GL11.glVertex3d((double)lllIIIIllllIIII.minX, (double)lllIIIIllllIIII.maxY, (double)lllIIIIllllIIII.minZ);
        GL11.glVertex3d((double)lllIIIIllllIIII.minX, (double)lllIIIIllllIIII.maxY, (double)lllIIIIllllIIII.maxZ);
        GL11.glVertex3d((double)lllIIIIllllIIII.maxX, (double)lllIIIIllllIIII.maxY, (double)lllIIIIllllIIII.maxZ);
        GL11.glVertex3d((double)lllIIIIllllIIII.maxX, (double)lllIIIIllllIIII.maxY, (double)lllIIIIllllIIII.minZ);
        GL11.glVertex3d((double)lllIIIIllllIIII.minX, (double)lllIIIIllllIIII.minY, (double)lllIIIIllllIIII.minZ);
        GL11.glVertex3d((double)lllIIIIllllIIII.minX, (double)lllIIIIllllIIII.maxY, (double)lllIIIIllllIIII.minZ);
        GL11.glVertex3d((double)lllIIIIllllIIII.maxX, (double)lllIIIIllllIIII.maxY, (double)lllIIIIllllIIII.minZ);
        GL11.glVertex3d((double)lllIIIIllllIIII.maxX, (double)lllIIIIllllIIII.minY, (double)lllIIIIllllIIII.minZ);
        GL11.glVertex3d((double)lllIIIIllllIIII.maxX, (double)lllIIIIllllIIII.minY, (double)lllIIIIllllIIII.minZ);
        GL11.glVertex3d((double)lllIIIIllllIIII.maxX, (double)lllIIIIllllIIII.maxY, (double)lllIIIIllllIIII.minZ);
        GL11.glVertex3d((double)lllIIIIllllIIII.maxX, (double)lllIIIIllllIIII.maxY, (double)lllIIIIllllIIII.maxZ);
        GL11.glVertex3d((double)lllIIIIllllIIII.maxX, (double)lllIIIIllllIIII.minY, (double)lllIIIIllllIIII.maxZ);
        GL11.glVertex3d((double)lllIIIIllllIIII.minX, (double)lllIIIIllllIIII.minY, (double)lllIIIIllllIIII.maxZ);
        GL11.glVertex3d((double)lllIIIIllllIIII.maxX, (double)lllIIIIllllIIII.minY, (double)lllIIIIllllIIII.maxZ);
        GL11.glVertex3d((double)lllIIIIllllIIII.maxX, (double)lllIIIIllllIIII.maxY, (double)lllIIIIllllIIII.maxZ);
        GL11.glVertex3d((double)lllIIIIllllIIII.minX, (double)lllIIIIllllIIII.maxY, (double)lllIIIIllllIIII.maxZ);
        GL11.glVertex3d((double)lllIIIIllllIIII.minX, (double)lllIIIIllllIIII.minY, (double)lllIIIIllllIIII.minZ);
        GL11.glVertex3d((double)lllIIIIllllIIII.minX, (double)lllIIIIllllIIII.minY, (double)lllIIIIllllIIII.maxZ);
        GL11.glVertex3d((double)lllIIIIllllIIII.minX, (double)lllIIIIllllIIII.maxY, (double)lllIIIIllllIIII.maxZ);
        GL11.glVertex3d((double)lllIIIIllllIIII.minX, (double)lllIIIIllllIIII.maxY, (double)lllIIIIllllIIII.minZ);
        GL11.glEnd();
    }

    public static void drawBlockESP(Vec3dSimple lllIIIIlllllIIl, float lllIIIIllllllll, float lllIIIIllllIlll, float lllIIIIllllIllI) {
        GL11.glPushMatrix();
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GL11.glLineWidth((float)1.0f);
        GL11.glDisable((int)3553);
        GL11.glEnable((int)2884);
        GL11.glDisable((int)2929);
        GL11.glDisable((int)2896);
        double lllIIIIllllllII = Minecraft.getMinecraft().getRenderManager().viewerPosX;
        double lllIIIIlllllIll = Minecraft.getMinecraft().getRenderManager().viewerPosY;
        double lllIIIIlllllIlI = Minecraft.getMinecraft().getRenderManager().viewerPosZ;
        GL11.glTranslated((double)(-lllIIIIllllllII), (double)(-lllIIIIlllllIll), (double)(-lllIIIIlllllIlI));
        GL11.glTranslated((double)lllIIIIlllllIIl.x, (double)lllIIIIlllllIIl.y, (double)lllIIIIlllllIIl.z);
        GL11.glColor4f((float)lllIIIIllllllll, (float)lllIIIIllllIlll, (float)lllIIIIllllIllI, (float)0.3f);
        RenderUtil.drawSolidBox();
        GL11.glColor4f((float)lllIIIIllllllll, (float)lllIIIIllllIlll, (float)lllIIIIllllIllI, (float)0.7f);
        RenderUtil.drawOutlinedBox();
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glEnable((int)2896);
        GL11.glEnable((int)2929);
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glDisable((int)2848);
        GL11.glPopMatrix();
    }

    public static void drawLinesAroundPlayer(Entity llIlllIIlllllll, double llIlllIIlllllIl, float llIlllIlIIIlIII, int llIlllIIllllIll, double llIlllIlIIIIllI, int llIlllIIllllIIl, float llIlllIIllllIII) {
        GL11.glPushMatrix();
        RenderUtil.enableGL2D3();
        GL11.glDisable((int)3553);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glDisable((int)2929);
        GL11.glLineWidth((float)((float)llIlllIlIIIIllI));
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDisable((int)2929);
        GL11.glBegin((int)3);
        RenderManager llIlllIlIIIIIll = Minecraft.getMinecraft().getRenderManager();
        double llIlllIlIIIIIlI = llIlllIIlllllll.lastTickPosX + (llIlllIIlllllll.posX - llIlllIIlllllll.lastTickPosX) * (double)llIlllIlIIIlIII - llIlllIlIIIIIll.viewerPosX;
        double llIlllIlIIIIIIl = llIlllIIlllllll.lastTickPosY + (llIlllIIlllllll.posY - llIlllIIlllllll.lastTickPosY) * (double)llIlllIlIIIlIII - llIlllIlIIIIIll.viewerPosY + (double)llIlllIIllllIII;
        double llIlllIlIIIIIII = llIlllIIlllllll.lastTickPosZ + (llIlllIIlllllll.posZ - llIlllIIlllllll.lastTickPosZ) * (double)llIlllIlIIIlIII - llIlllIlIIIIIll.viewerPosZ;
        RenderUtil.color228(llIlllIIllllIIl);
        for (int llIlllIlIIIlIll = 0; llIlllIlIIIlIll <= llIlllIIllllIll; ++llIlllIlIIIlIll) {
            GL11.glVertex3d((double)(llIlllIlIIIIIlI + llIlllIIlllllIl * Math.cos((double)llIlllIlIIIlIll * (Math.PI * 2) / (double)llIlllIIllllIll)), (double)llIlllIlIIIIIIl, (double)(llIlllIlIIIIIII + llIlllIIlllllIl * Math.sin((double)llIlllIlIIIlIll * (Math.PI * 2) / (double)llIlllIIllllIll)));
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

    public static void glColor(int llIllIIIIIlIIIl) {
        float llIllIIIIIlIlIl = (float)(llIllIIIIIlIIIl >> 24 & 0xFF) / 255.0f;
        float llIllIIIIIlIlII = (float)(llIllIIIIIlIIIl >> 16 & 0xFF) / 255.0f;
        float llIllIIIIIlIIll = (float)(llIllIIIIIlIIIl >> 8 & 0xFF) / 255.0f;
        float llIllIIIIIlIIlI = (float)(llIllIIIIIlIIIl & 0xFF) / 255.0f;
        GL11.glColor4f((float)llIllIIIIIlIlII, (float)llIllIIIIIlIIll, (float)llIllIIIIIlIIlI, (float)llIllIIIIIlIlIl);
    }

    public static void relativeRect(float llIllIIllIlIIll, float llIllIIllIIIlll, float llIllIIllIlIIIl, float llIllIIllIlIIII, int llIllIIllIIIlII) {
        if (llIllIIllIlIIll < llIllIIllIlIIIl) {
            float llIllIIllIlIlIl = llIllIIllIlIIll;
            llIllIIllIlIIll = llIllIIllIlIIIl;
            llIllIIllIlIIIl = llIllIIllIlIlIl;
        }
        if (llIllIIllIIIlll < llIllIIllIlIIII) {
            float llIllIIllIlIlII = llIllIIllIIIlll;
            llIllIIllIIIlll = llIllIIllIlIIII;
            llIllIIllIlIIII = llIllIIllIlIlII;
        }
        float llIllIIllIIlllI = (float)(llIllIIllIIIlII >> 24 & 0xFF) / 255.0f;
        float llIllIIllIIllIl = (float)(llIllIIllIIIlII >> 16 & 0xFF) / 255.0f;
        float llIllIIllIIllII = (float)(llIllIIllIIIlII >> 8 & 0xFF) / 255.0f;
        float llIllIIllIIlIll = (float)(llIllIIllIIIlII & 0xFF) / 255.0f;
        Tessellator llIllIIllIIlIlI = Tessellator.getInstance();
        BufferBuilder llIllIIllIIlIIl = llIllIIllIIlIlI.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        GlStateManager.color((float)llIllIIllIIllIl, (float)llIllIIllIIllII, (float)llIllIIllIIlIll, (float)llIllIIllIIlllI);
        llIllIIllIIlIIl.begin(7, DefaultVertexFormats.POSITION);
        llIllIIllIIlIIl.pos((double)llIllIIllIlIIll, (double)llIllIIllIlIIII, 0.0).endVertex();
        llIllIIllIIlIIl.pos((double)llIllIIllIlIIIl, (double)llIllIIllIlIIII, 0.0).endVertex();
        llIllIIllIIlIIl.pos((double)llIllIIllIlIIIl, (double)llIllIIllIIIlll, 0.0).endVertex();
        llIllIIllIIlIIl.pos((double)llIllIIllIlIIll, (double)llIllIIllIIIlll, 0.0).endVertex();
        llIllIIllIIlIlI.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void drawCircle(float llIllIlllIllIll, double llIllIlllIllIlI, float llIllIlllIIlIlI, int llIllIlllIllIII, int llIllIlllIlIlll) {
        GL11.glPushMatrix();
        llIllIlllIllIll *= 2.0f;
        llIllIlllIllIlI *= 2.0;
        GlStateManager.glLineWidth((float)6.0f);
        float llIllIlllIlIllI = (float)(llIllIlllIlIlll >> 24 & 0xFF) / 255.0f;
        float llIllIlllIlIlIl = (float)(llIllIlllIlIlll >> 16 & 0xFF) / 255.0f;
        float llIllIlllIlIlII = (float)(llIllIlllIlIlll >> 8 & 0xFF) / 255.0f;
        float llIllIlllIlIIll = (float)(llIllIlllIlIlll & 0xFF) / 255.0f;
        float llIllIlllIlIIlI = (float)Math.PI / 180;
        float llIllIlllIlIIIl = (float)Math.cos(llIllIlllIlIIlI);
        float llIllIlllIlIIII = (float)Math.sin(llIllIlllIlIIlI);
        float llIllIlllIIllll = llIllIlllIIlIlI *= 2.0f;
        float llIllIlllIIlllI = 0.0f;
        GL11.glEnable((int)2848);
        RenderUtil.enableGL2D();
        GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
        GL11.glColor4f((float)llIllIlllIlIlIl, (float)llIllIlllIlIlII, (float)llIllIlllIlIIll, (float)llIllIlllIlIllI);
        GL11.glPointSize((float)6.0f);
        GL11.glBegin((int)3);
        int[] llIllIlllIIllIl = new int[]{1};
        for (int llIllIlllIlllII = 0; llIllIlllIlllII < 360 - llIllIlllIllIII; ++llIllIlllIlllII) {
            llIllIlllIlIlll = RenderUtil.raindbow(llIllIlllIIllIl[0] * 10);
            llIllIlllIlIllI = (float)(llIllIlllIlIlll >> 24 & 0xFF) / 255.0f;
            llIllIlllIlIlIl = (float)(llIllIlllIlIlll >> 16 & 0xFF) / 255.0f;
            llIllIlllIlIlII = (float)(llIllIlllIlIlll >> 8 & 0xFF) / 255.0f;
            llIllIlllIlIIll = (float)(llIllIlllIlIlll & 0xFF) / 255.0f;
            GL11.glColor4f((float)llIllIlllIlIlIl, (float)llIllIlllIlIlII, (float)llIllIlllIlIIll, (float)llIllIlllIlIllI);
            GL11.glVertex2f((float)(llIllIlllIIllll + llIllIlllIllIll), (float)((float)((double)llIllIlllIIlllI + llIllIlllIllIlI)));
            float llIllIlllIlllIl = llIllIlllIIllll;
            llIllIlllIIllll = llIllIlllIlIIIl * llIllIlllIIllll - llIllIlllIlIIII * llIllIlllIIlllI;
            llIllIlllIIlllI = llIllIlllIlIIII * llIllIlllIlllIl + llIllIlllIlIIIl * llIllIlllIIlllI;
            llIllIlllIIllIl[0] = llIllIlllIIllIl[0] + 1;
        }
        GL11.glEnd();
        GL11.glScalef((float)2.0f, (float)2.0f, (float)2.0f);
        RenderUtil.disableGL2D();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.glLineWidth((float)1.0f);
        GL11.glPopMatrix();
    }

    public static void GLPre(float lllIIIIlllIllIl) {
        depth = GL11.glIsEnabled((int)2896);
        texture = GL11.glIsEnabled((int)3042);
        clean = GL11.glIsEnabled((int)3553);
        bind = GL11.glIsEnabled((int)2929);
        override = GL11.glIsEnabled((int)2848);
        RenderUtil.GLPre(depth, texture, clean, bind, override, lllIIIIlllIllIl);
    }

    public static void drawGradientSideways(double llIllIllIIIllIl, double llIllIllIIllIlI, double llIllIllIIIlIll, double llIllIllIIIlIlI, int llIllIllIIlIlll, int llIllIllIIlIllI) {
        float llIllIllIIlIlIl = (float)(llIllIllIIlIlll >> 24 & 0xFF) / 255.0f;
        float llIllIllIIlIlII = (float)(llIllIllIIlIlll >> 16 & 0xFF) / 255.0f;
        float llIllIllIIlIIll = (float)(llIllIllIIlIlll >> 8 & 0xFF) / 255.0f;
        float llIllIllIIlIIlI = (float)(llIllIllIIlIlll & 0xFF) / 255.0f;
        float llIllIllIIlIIIl = (float)(llIllIllIIlIllI >> 24 & 0xFF) / 255.0f;
        float llIllIllIIlIIII = (float)(llIllIllIIlIllI >> 16 & 0xFF) / 255.0f;
        float llIllIllIIIllll = (float)(llIllIllIIlIllI >> 8 & 0xFF) / 255.0f;
        float llIllIllIIIlllI = (float)(llIllIllIIlIllI & 0xFF) / 255.0f;
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GL11.glShadeModel((int)7425);
        GL11.glPushMatrix();
        GL11.glBegin((int)7);
        GL11.glColor4f((float)llIllIllIIlIlII, (float)llIllIllIIlIIll, (float)llIllIllIIlIIlI, (float)llIllIllIIlIlIl);
        GL11.glVertex2d((double)llIllIllIIIllIl, (double)llIllIllIIllIlI);
        GL11.glVertex2d((double)llIllIllIIIllIl, (double)llIllIllIIIlIlI);
        GL11.glColor4f((float)llIllIllIIlIIII, (float)llIllIllIIIllll, (float)llIllIllIIIlllI, (float)llIllIllIIlIIIl);
        GL11.glVertex2d((double)llIllIllIIIlIll, (double)llIllIllIIIlIlI);
        GL11.glVertex2d((double)llIllIllIIIlIll, (double)llIllIllIIllIlI);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
    }

    public static void renderEntityBoundingBox(Entity llIllllllllIlIl, RGBSetting llIllllllllIlII, float llIllllllllIllI) {
        RenderUtil.renderEntityBoundingBox(llIllllllllIlIl, (float)llIllllllllIlII.getRed() / 255.0f, (float)llIllllllllIlII.getGreen() / 255.0f, (float)llIllllllllIlII.getBlue() / 255.0f, llIllllllllIllI);
    }

    public static void drawColorBox(AxisAlignedBB llIlIllllIIIIII, float llIlIlllIlllIII, float llIlIlllIlllllI, float llIlIlllIllIllI, float llIlIlllIllllII) {
        Tessellator llIlIlllIlllIll = Tessellator.getInstance();
        BufferBuilder llIlIlllIlllIlI = llIlIlllIlllIll.getBuffer();
        llIlIlllIlllIlI.begin(7, DefaultVertexFormats.POSITION_TEX);
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.minX, llIlIllllIIIIII.minY, llIlIllllIIIIII.minZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.minX, llIlIllllIIIIII.maxY, llIlIllllIIIIII.minZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.maxX, llIlIllllIIIIII.minY, llIlIllllIIIIII.minZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.maxX, llIlIllllIIIIII.maxY, llIlIllllIIIIII.minZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.maxX, llIlIllllIIIIII.minY, llIlIllllIIIIII.maxZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.maxX, llIlIllllIIIIII.maxY, llIlIllllIIIIII.maxZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.minX, llIlIllllIIIIII.minY, llIlIllllIIIIII.maxZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.minX, llIlIllllIIIIII.maxY, llIlIllllIIIIII.maxZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIll.draw();
        llIlIlllIlllIlI.begin(7, DefaultVertexFormats.POSITION_TEX);
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.maxX, llIlIllllIIIIII.maxY, llIlIllllIIIIII.minZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.maxX, llIlIllllIIIIII.minY, llIlIllllIIIIII.minZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.minX, llIlIllllIIIIII.maxY, llIlIllllIIIIII.minZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.minX, llIlIllllIIIIII.minY, llIlIllllIIIIII.minZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.minX, llIlIllllIIIIII.maxY, llIlIllllIIIIII.maxZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.minX, llIlIllllIIIIII.minY, llIlIllllIIIIII.maxZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.maxX, llIlIllllIIIIII.maxY, llIlIllllIIIIII.maxZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.maxX, llIlIllllIIIIII.minY, llIlIllllIIIIII.maxZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIll.draw();
        llIlIlllIlllIlI.begin(7, DefaultVertexFormats.POSITION_TEX);
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.minX, llIlIllllIIIIII.maxY, llIlIllllIIIIII.minZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.maxX, llIlIllllIIIIII.maxY, llIlIllllIIIIII.minZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.maxX, llIlIllllIIIIII.maxY, llIlIllllIIIIII.maxZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.minX, llIlIllllIIIIII.maxY, llIlIllllIIIIII.maxZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.minX, llIlIllllIIIIII.maxY, llIlIllllIIIIII.minZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.minX, llIlIllllIIIIII.maxY, llIlIllllIIIIII.maxZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.maxX, llIlIllllIIIIII.maxY, llIlIllllIIIIII.maxZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.maxX, llIlIllllIIIIII.maxY, llIlIllllIIIIII.minZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIll.draw();
        llIlIlllIlllIlI.begin(7, DefaultVertexFormats.POSITION_TEX);
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.minX, llIlIllllIIIIII.minY, llIlIllllIIIIII.minZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.maxX, llIlIllllIIIIII.minY, llIlIllllIIIIII.minZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.maxX, llIlIllllIIIIII.minY, llIlIllllIIIIII.maxZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.minX, llIlIllllIIIIII.minY, llIlIllllIIIIII.maxZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.minX, llIlIllllIIIIII.minY, llIlIllllIIIIII.minZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.minX, llIlIllllIIIIII.minY, llIlIllllIIIIII.maxZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.maxX, llIlIllllIIIIII.minY, llIlIllllIIIIII.maxZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.maxX, llIlIllllIIIIII.minY, llIlIllllIIIIII.minZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIll.draw();
        llIlIlllIlllIlI.begin(7, DefaultVertexFormats.POSITION_TEX);
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.minX, llIlIllllIIIIII.minY, llIlIllllIIIIII.minZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.minX, llIlIllllIIIIII.maxY, llIlIllllIIIIII.minZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.minX, llIlIllllIIIIII.minY, llIlIllllIIIIII.maxZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.minX, llIlIllllIIIIII.maxY, llIlIllllIIIIII.maxZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.maxX, llIlIllllIIIIII.minY, llIlIllllIIIIII.maxZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.maxX, llIlIllllIIIIII.maxY, llIlIllllIIIIII.maxZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.maxX, llIlIllllIIIIII.minY, llIlIllllIIIIII.minZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.maxX, llIlIllllIIIIII.maxY, llIlIllllIIIIII.minZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIll.draw();
        llIlIlllIlllIlI.begin(7, DefaultVertexFormats.POSITION_TEX);
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.minX, llIlIllllIIIIII.maxY, llIlIllllIIIIII.maxZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.minX, llIlIllllIIIIII.minY, llIlIllllIIIIII.maxZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.minX, llIlIllllIIIIII.maxY, llIlIllllIIIIII.minZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.minX, llIlIllllIIIIII.minY, llIlIllllIIIIII.minZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.maxX, llIlIllllIIIIII.maxY, llIlIllllIIIIII.minZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.maxX, llIlIllllIIIIII.minY, llIlIllllIIIIII.minZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.maxX, llIlIllllIIIIII.maxY, llIlIllllIIIIII.maxZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIlI.pos(llIlIllllIIIIII.maxX, llIlIllllIIIIII.minY, llIlIllllIIIIII.maxZ).color(llIlIlllIlllIII, llIlIlllIlllllI, llIlIlllIllIllI, llIlIlllIllllII).endVertex();
        llIlIlllIlllIll.draw();
    }

    public static void blockESP(BlockPos llIlIllIIIlIlll) {
        GL11.glPushMatrix();
        double llIlIllIIIllIlI = (double)llIlIllIIIlIlll.func_177958_n() - Minecraft.getMinecraft().getRenderManager().viewerPosX;
        double llIlIllIIIllIIl = (double)llIlIllIIIlIlll.func_177956_o() - Minecraft.getMinecraft().getRenderManager().viewerPosY;
        double llIlIllIIIllIII = (double)llIlIllIIIlIlll.func_177952_p() - Minecraft.getMinecraft().getRenderManager().viewerPosZ;
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        RenderGlobal.renderFilledBox((AxisAlignedBB)new AxisAlignedBB(llIlIllIIIllIlI, llIlIllIIIllIIl, llIlIllIIIllIII, llIlIllIIIllIlI + 1.0, llIlIllIIIllIIl + 1.0, llIlIllIIIllIII + 1.0), (float)0.0f, (float)1.0f, (float)0.0f, (float)0.5f);
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2929);
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)3042);
        GL11.glPopMatrix();
    }

    public static void blockEspFrame(BlockPos llIlIlllllIIlII, double llIlIlllllIIIll, double llIlIlllllIIIlI, double llIlIllllIlIllI) {
        double llIlIlllllIIIII = llIlIlllllIIlII.func_177958_n();
        double llIlIllllIlllll = llIlIlllllIIIII - RenderUtil.mc.getRenderManager().viewerPosX;
        double llIlIllllIllllI = llIlIlllllIIlII.func_177956_o();
        Minecraft.getMinecraft().getRenderManager();
        double llIlIllllIlllIl = llIlIllllIllllI - RenderUtil.mc.getRenderManager().viewerPosY;
        double llIlIllllIlllII = llIlIlllllIIlII.func_177952_p();
        Minecraft.getMinecraft().getRenderManager();
        double llIlIllllIllIll = llIlIllllIlllII - RenderUtil.mc.getRenderManager().viewerPosZ;
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)3042);
        GL11.glLineWidth((float)1.0f);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        GL11.glColor4d((double)llIlIlllllIIIll, (double)llIlIlllllIIIlI, (double)llIlIllllIlIllI, (double)0.5);
        RenderUtil.drawSelectionBoundingBox(new AxisAlignedBB(llIlIllllIlllll, llIlIllllIlllIl, llIlIllllIllIll, llIlIllllIlllll + 1.0, llIlIllllIlllIl + 1.0, llIlIllllIllIll + 1.0));
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2929);
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)3042);
    }

    public static void renderEntityFilledBoundingBox(Entity llIllllllIIIlIl, RGBSetting llIllllllIIIlll, float llIllllllIIIIll) {
        RenderUtil.renderEntityFilledBoundingBox(llIllllllIIIlIl, (float)llIllllllIIIlll.getRed() / 255.0f, (float)llIllllllIIIlll.getGreen() / 255.0f, (float)llIllllllIIIlll.getBlue() / 255.0f, llIllllllIIIIll);
    }

    public static void drawNewRect(double llIllIIIlIllllI, double llIllIIIlIlIIlI, double llIllIIIlIlllII, double llIllIIIlIlIIII, int llIllIIIlIllIlI) {
        if (llIllIIIlIllllI < llIllIIIlIlllII) {
            double llIllIIIllIIIII = llIllIIIlIllllI;
            llIllIIIlIllllI = llIllIIIlIlllII;
            llIllIIIlIlllII = llIllIIIllIIIII;
        }
        if (llIllIIIlIlIIlI < llIllIIIlIlIIII) {
            double llIllIIIlIlllll = llIllIIIlIlIIlI;
            llIllIIIlIlIIlI = llIllIIIlIlIIII;
            llIllIIIlIlIIII = llIllIIIlIlllll;
        }
        float llIllIIIlIllIIl = (float)(llIllIIIlIllIlI >> 24 & 0xFF) / 255.0f;
        float llIllIIIlIllIII = (float)(llIllIIIlIllIlI >> 16 & 0xFF) / 255.0f;
        float llIllIIIlIlIlll = (float)(llIllIIIlIllIlI >> 8 & 0xFF) / 255.0f;
        float llIllIIIlIlIllI = (float)(llIllIIIlIllIlI & 0xFF) / 255.0f;
        Tessellator llIllIIIlIlIlIl = Tessellator.getInstance();
        BufferBuilder llIllIIIlIlIlII = llIllIIIlIlIlIl.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.color((float)llIllIIIlIllIII, (float)llIllIIIlIlIlll, (float)llIllIIIlIlIllI, (float)llIllIIIlIllIIl);
        llIllIIIlIlIlII.begin(7, DefaultVertexFormats.POSITION);
        llIllIIIlIlIlII.pos(llIllIIIlIllllI, llIllIIIlIlIIII, 0.0).endVertex();
        llIllIIIlIlIlII.pos(llIllIIIlIlllII, llIllIIIlIlIIII, 0.0).endVertex();
        llIllIIIlIlIlII.pos(llIllIIIlIlllII, llIllIIIlIlIIlI, 0.0).endVertex();
        llIllIIIlIlIlII.pos(llIllIIIlIllllI, llIllIIIlIlIIlI, 0.0).endVertex();
        llIllIIIlIlIlIl.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void drawBorderedRect(double llIllIIlIlIllIl, double llIllIIlIllIlII, double llIllIIlIlIlIll, double llIllIIlIlIlIlI, double llIllIIlIlIlIIl, int llIllIIlIllIIII, int llIllIIlIlIllll, boolean llIllIIlIlIIllI) {
        RenderUtil.drawRect(llIllIIlIlIllIl - (!llIllIIlIlIIllI ? llIllIIlIlIlIIl : 0.0), llIllIIlIllIlII - (!llIllIIlIlIIllI ? llIllIIlIlIlIIl : 0.0), llIllIIlIlIlIll + (!llIllIIlIlIIllI ? llIllIIlIlIlIIl : 0.0), llIllIIlIlIlIlI + (!llIllIIlIlIIllI ? llIllIIlIlIlIIl : 0.0), llIllIIlIlIllll);
        RenderUtil.drawRect(llIllIIlIlIllIl + (llIllIIlIlIIllI ? llIllIIlIlIlIIl : 0.0), llIllIIlIllIlII + (llIllIIlIlIIllI ? llIllIIlIlIlIIl : 0.0), llIllIIlIlIlIll - (llIllIIlIlIIllI ? llIllIIlIlIlIIl : 0.0), llIllIIlIlIlIlI - (llIllIIlIlIIllI ? llIllIIlIlIlIIl : 0.0), llIllIIlIllIIII);
    }

    public static void rectangleBordered(double llIlIlllIlIIlII, double llIlIlllIlIlIlI, double llIlIlllIlIIIlI, double llIlIlllIlIIIIl, double llIlIlllIlIIIII, int llIlIlllIlIIllI, int llIlIlllIlIIlIl) {
        RenderUtil.drawRect(llIlIlllIlIIlII + llIlIlllIlIIIII, llIlIlllIlIlIlI + llIlIlllIlIIIII, llIlIlllIlIIIlI - llIlIlllIlIIIII, llIlIlllIlIIIIl - llIlIlllIlIIIII, llIlIlllIlIIllI);
        RenderUtil.drawRect(llIlIlllIlIIlII + llIlIlllIlIIIII, llIlIlllIlIlIlI, llIlIlllIlIIIlI - llIlIlllIlIIIII, llIlIlllIlIlIlI + llIlIlllIlIIIII, llIlIlllIlIIlIl);
        RenderUtil.drawRect(llIlIlllIlIIlII, llIlIlllIlIlIlI, llIlIlllIlIIlII + llIlIlllIlIIIII, llIlIlllIlIIIIl, llIlIlllIlIIlIl);
        RenderUtil.drawRect(llIlIlllIlIIIlI - llIlIlllIlIIIII, llIlIlllIlIlIlI, llIlIlllIlIIIlI, llIlIlllIlIIIIl, llIlIlllIlIIlIl);
        RenderUtil.drawRect(llIlIlllIlIIlII + llIlIlllIlIIIII, llIlIlllIlIIIIl - llIlIlllIlIIIII, llIlIlllIlIIIlI - llIlIlllIlIIIII, llIlIlllIlIIIIl, llIlIlllIlIIlIl);
    }

    private static void GLPost(boolean lllIIIIllIlIlIl, boolean lllIIIIllIlIlII, boolean lllIIIIllIIlllI, boolean lllIIIIllIlIIlI, boolean lllIIIIllIIllII) {
        GlStateManager.depthMask((boolean)true);
        if (!lllIIIIllIIllII) {
            GL11.glDisable((int)2848);
        }
        if (lllIIIIllIlIIlI) {
            GL11.glEnable((int)2929);
        }
        if (lllIIIIllIIlllI) {
            GL11.glEnable((int)3553);
        }
        if (!lllIIIIllIlIlII) {
            GL11.glDisable((int)3042);
        }
        if (lllIIIIllIlIlIl) {
            GL11.glEnable((int)2896);
        }
    }

    public static void blockEsp(BlockPos llIllIIIIIIIIlI, Color llIllIIIIIIIIIl, double llIllIIIIIIIIII, double llIlIllllllllll) {
        double llIlIlllllllllI = llIllIIIIIIIIlI.func_177958_n();
        double llIlIllllllllIl = llIlIlllllllllI - RenderUtil.mc.getRenderManager().viewerPosX;
        double llIlIllllllllII = llIllIIIIIIIIlI.func_177956_o();
        Minecraft.getMinecraft().getRenderManager();
        double llIlIlllllllIll = llIlIllllllllII - RenderUtil.mc.getRenderManager().viewerPosY;
        double llIlIlllllllIlI = llIllIIIIIIIIlI.func_177952_p();
        Minecraft.getMinecraft().getRenderManager();
        double llIlIlllllllIIl = llIlIlllllllIlI - RenderUtil.mc.getRenderManager().viewerPosZ;
        GL11.glPushMatrix();
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)3042);
        GL11.glLineWidth((float)2.0f);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        GL11.glColor4d((double)((float)llIllIIIIIIIIIl.getRed() / 255.0f), (double)((float)llIllIIIIIIIIIl.getGreen() / 255.0f), (double)((float)llIllIIIIIIIIIl.getBlue() / 255.0f), (double)0.15);
        RenderUtil.drawColorBox(new AxisAlignedBB(llIlIllllllllIl, llIlIlllllllIll, llIlIlllllllIIl, llIlIllllllllIl + llIlIllllllllll, llIlIlllllllIll + 1.0, llIlIlllllllIIl + llIllIIIIIIIIII), 0.0f, 0.0f, 0.0f, 0.0f);
        GL11.glColor4d((double)0.0, (double)0.0, (double)0.0, (double)0.5);
        RenderUtil.drawSelectionBoundingBox(new AxisAlignedBB(llIlIllllllllIl, llIlIlllllllIll, llIlIlllllllIIl, llIlIllllllllIl + llIlIllllllllll, llIlIlllllllIll + 1.0, llIlIlllllllIIl + llIllIIIIIIIIII));
        GL11.glLineWidth((float)2.0f);
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2929);
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)3042);
        GL11.glPopMatrix();
    }

    public static void drawESPBoxes(List<Entity> lllIIIIIlIIIIIl, int lllIIIIIlIIIIII, float lllIIIIIlIIIIlI) {
        GL11.glLineWidth((float)2.0f);
        for (Entity lllIIIIIlIIIlIl : lllIIIIIlIIIIIl) {
            GL11.glPushMatrix();
            Vec3d lllIIIIIlIIIllI = EntityUtil.getInterpolatedPos(lllIIIIIlIIIlIl, lllIIIIIlIIIIlI);
            GL11.glTranslated((double)lllIIIIIlIIIllI.x, (double)lllIIIIIlIIIllI.y, (double)lllIIIIIlIIIllI.z);
            GL11.glScaled((double)((double)lllIIIIIlIIIlIl.width + 0.1), (double)((double)lllIIIIIlIIIlIl.height + 0.1), (double)((double)lllIIIIIlIIIlIl.width + 0.1));
            if (lllIIIIIlIIIlIl instanceof EntityPlayer && FriendManager.isFriend(lllIIIIIlIIIlIl.getName())) {
                GL11.glColor4f((float)0.9f, (float)0.2f, (float)1.0f, (float)0.5f);
            } else if (lllIIIIIlIIIlIl instanceof EntityItem) {
                GL11.glColor4f((float)0.5f, (float)0.5f, (float)1.0f, (float)0.5f);
            } else {
                float lllIIIIIlIIIlll = Minecraft.getMinecraft().player.func_70032_d(lllIIIIIlIIIlIl) / 20.0f;
                GL11.glColor4f((float)(2.0f - lllIIIIIlIIIlll), (float)lllIIIIIlIIIlll, (float)0.0f, (float)0.5f);
            }
            GL11.glCallList((int)lllIIIIIlIIIIII);
            GL11.glPopMatrix();
        }
    }

    public static void drawUnfilledCircle(float llIllllIIIlIIIl, float llIllllIIIlIIII, float llIllllIIIllIII, float llIllllIIIlIlll, int llIllllIIIlIllI) {
        float llIllllIIIlIlIl = (float)(llIllllIIIlIllI >> 16 & 0xFF) / 255.0f;
        float llIllllIIIlIlII = (float)(llIllllIIIlIllI >> 8 & 0xFF) / 255.0f;
        float llIllllIIIlIIll = (float)(llIllllIIIlIllI & 0xFF) / 255.0f;
        float llIllllIIIlIIlI = (float)(llIllllIIIlIllI >> 24 & 0xFF) / 255.0f;
        GL11.glEnable((int)2848);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDepthMask((boolean)true);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glHint((int)3155, (int)4354);
        GlStateManager.enableBlend();
        GL11.glColor4f((float)llIllllIIIlIlIl, (float)llIllllIIIlIlII, (float)llIllllIIIlIIll, (float)llIllllIIIlIIlI);
        GL11.glLineWidth((float)llIllllIIIlIlll);
        GL11.glBegin((int)2);
        for (int llIllllIIIllIll = 0; llIllllIIIllIll <= 360; ++llIllllIIIllIll) {
            GL11.glVertex2d((double)((double)llIllllIIIlIIIl + Math.sin((double)llIllllIIIllIll * Math.PI / 180.0) * (double)llIllllIIIllIII), (double)((double)llIllllIIIlIIII + Math.cos((double)llIllllIIIllIll * Math.PI / 180.0) * (double)llIllllIIIllIII));
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

    public static void drawRectWithEdge(double llIlllIIllIIIll, double llIlllIIlIllIll, double llIlllIIlIllIlI, double llIlllIIlIllIIl, Color llIlllIIlIlllll, Color llIlllIIlIlIlll) {
        RenderUtil.drawRect(llIlllIIllIIIll, llIlllIIlIllIll, llIlllIIllIIIll + llIlllIIlIllIlI, llIlllIIlIllIll + llIlllIIlIllIIl, llIlllIIlIlllll.getRGB());
        int llIlllIIlIlllIl = llIlllIIlIlIlll.getRGB();
        RenderUtil.drawRect(llIlllIIllIIIll - 1.0, llIlllIIlIllIll, llIlllIIllIIIll, llIlllIIlIllIll + llIlllIIlIllIIl, llIlllIIlIlllIl);
        RenderUtil.drawRect(llIlllIIllIIIll + llIlllIIlIllIlI, llIlllIIlIllIll, llIlllIIllIIIll + llIlllIIlIllIlI + 1.0, llIlllIIlIllIll + llIlllIIlIllIIl, llIlllIIlIlllIl);
        RenderUtil.drawRect(llIlllIIllIIIll - 1.0, llIlllIIlIllIll - 1.0, llIlllIIllIIIll + llIlllIIlIllIlI + 1.0, llIlllIIlIllIll, llIlllIIlIlllIl);
        RenderUtil.drawRect(llIlllIIllIIIll - 1.0, llIlllIIlIllIll + llIlllIIlIllIIl, llIlllIIllIIIll + llIlllIIlIllIlI + 1.0, llIlllIIlIllIll + llIlllIIlIllIIl + 1.0, llIlllIIlIlllIl);
    }

    public static void drawRoundedRect(double llIlllIIlIIlIlI, double llIlllIIlIIllll, double llIlllIIlIIlllI, double llIlllIIlIIllIl, int llIlllIIlIIllII, int llIlllIIlIIlIll) {
        RenderUtil.drawRect(llIlllIIlIIlIlI + 0.5, llIlllIIlIIllll, llIlllIIlIIlllI - 0.5, llIlllIIlIIllll + 0.5, llIlllIIlIIlIll);
        RenderUtil.drawRect(llIlllIIlIIlIlI + 0.5, llIlllIIlIIllIl - 0.5, llIlllIIlIIlllI - 0.5, llIlllIIlIIllIl, llIlllIIlIIlIll);
        RenderUtil.drawRect(llIlllIIlIIlIlI, llIlllIIlIIllll + 0.5, llIlllIIlIIlllI, llIlllIIlIIllIl - 0.5, llIlllIIlIIlIll);
    }

    public static void drawOutlinedBox() {
        RenderUtil.drawOutlinedBox();
    }

    public static float[][] getBipedRotations(ModelBiped lllIIIlIlIlllII) {
        float[][] lllIIIlIllIIIlI = new float[5][];
        float[] lllIIIlIllIIIIl = new float[]{lllIIIlIlIlllII.bipedHead.rotateAngleX, lllIIIlIlIlllII.bipedHead.rotateAngleY, lllIIIlIlIlllII.bipedHead.rotateAngleZ};
        lllIIIlIllIIIlI[0] = lllIIIlIllIIIIl;
        float[] lllIIIlIllIIIII = new float[]{lllIIIlIlIlllII.bipedRightArm.rotateAngleX, lllIIIlIlIlllII.bipedRightArm.rotateAngleY, lllIIIlIlIlllII.bipedRightArm.rotateAngleZ};
        lllIIIlIllIIIlI[1] = lllIIIlIllIIIII;
        float[] lllIIIlIlIlllll = new float[]{lllIIIlIlIlllII.bipedLeftArm.rotateAngleX, lllIIIlIlIlllII.bipedLeftArm.rotateAngleY, lllIIIlIlIlllII.bipedLeftArm.rotateAngleZ};
        lllIIIlIllIIIlI[2] = lllIIIlIlIlllll;
        float[] lllIIIlIlIllllI = new float[]{lllIIIlIlIlllII.bipedRightLeg.rotateAngleX, lllIIIlIlIlllII.bipedRightLeg.rotateAngleY, lllIIIlIlIlllII.bipedRightLeg.rotateAngleZ};
        lllIIIlIllIIIlI[3] = lllIIIlIlIllllI;
        float[] lllIIIlIlIlllIl = new float[]{lllIIIlIlIlllII.bipedLeftLeg.rotateAngleX, lllIIIlIlIlllII.bipedLeftLeg.rotateAngleY, lllIIIlIlIlllII.bipedLeftLeg.rotateAngleZ};
        lllIIIlIllIIIlI[4] = lllIIIlIlIlllIl;
        return lllIIIlIllIIIlI;
    }

    public static void drawGradientSidewaysRGB(double llIllIlIlllIllI, double llIllIlIllIllII, double llIllIlIlllIlII, double llIllIlIlllIIll, int llIllIlIllIlIIl) {
        float llIllIlIlllIIIl = (float)(llIllIlIllIlIIl >> 24 & 0xFF) / 255.0f;
        float llIllIlIlllIIII = (float)(llIllIlIllIlIIl >> 16 & 0xFF) / 255.0f;
        float llIllIlIllIllll = (float)(llIllIlIllIlIIl >> 8 & 0xFF) / 255.0f;
        float llIllIlIllIlllI = (float)(llIllIlIllIlIIl & 0xFF) / 255.0f;
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GL11.glShadeModel((int)7425);
        GL11.glPushMatrix();
        GL11.glBegin((int)7);
        GL11.glColor4f((float)llIllIlIlllIIII, (float)llIllIlIllIllll, (float)llIllIlIllIlllI, (float)llIllIlIlllIIIl);
        GL11.glVertex2d((double)llIllIlIlllIllI, (double)llIllIlIllIllII);
        GL11.glVertex2d((double)llIllIlIlllIllI, (double)llIllIlIlllIIll);
        GL11.glVertex2d((double)llIllIlIlllIlII, (double)llIllIlIlllIIll);
        GL11.glVertex2d((double)llIllIlIlllIlII, (double)llIllIlIllIllII);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
    }

    public static void draw2DTriangleRight(double llIlIllIIlllIIl, double llIlIllIIlIlllI, double llIlIllIIlIllIl, double llIlIllIIllIllI, float llIlIllIIllIlIl, float llIlIllIIllIlII, float llIlIllIIllIIll, float llIlIllIIllIIlI) {
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        Tessellator llIlIllIIllIIIl = Tessellator.getInstance();
        BufferBuilder llIlIllIIllIIII = llIlIllIIllIIIl.getBuffer();
        GlStateManager.color((float)llIlIllIIllIlIl, (float)llIlIllIIllIlII, (float)llIlIllIIllIIll, (float)llIlIllIIllIIlI);
        llIlIllIIllIIII.begin(4, DefaultVertexFormats.POSITION);
        llIlIllIIllIIII.pos(llIlIllIIlllIIl, llIlIllIIlIlllI, 0.0).endVertex();
        llIlIllIIllIIII.pos(llIlIllIIlllIIl, llIlIllIIlIlllI + llIlIllIIllIllI, 0.0).endVertex();
        llIlIllIIllIIII.pos(llIlIllIIlllIIl + llIlIllIIlIllIl, llIlIllIIlIlllI + llIlIllIIllIllI / 2.0, 0.0).endVertex();
        llIlIllIIllIIIl.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void drawOutlinedBox(AxisAlignedBB llIllllllIIIIIl) {
        GL11.glBegin((int)1);
        GL11.glVertex3d((double)llIllllllIIIIIl.minX, (double)llIllllllIIIIIl.maxY, (double)llIllllllIIIIIl.minZ);
        GL11.glVertex3d((double)llIllllllIIIIIl.maxX, (double)llIllllllIIIIIl.maxY, (double)llIllllllIIIIIl.minZ);
        GL11.glVertex3d((double)llIllllllIIIIIl.maxX, (double)llIllllllIIIIIl.maxY, (double)llIllllllIIIIIl.minZ);
        GL11.glVertex3d((double)llIllllllIIIIIl.maxX, (double)llIllllllIIIIIl.maxY, (double)llIllllllIIIIIl.maxZ);
        GL11.glVertex3d((double)llIllllllIIIIIl.maxX, (double)llIllllllIIIIIl.maxY, (double)llIllllllIIIIIl.maxZ);
        GL11.glVertex3d((double)llIllllllIIIIIl.minX, (double)llIllllllIIIIIl.maxY, (double)llIllllllIIIIIl.maxZ);
        GL11.glVertex3d((double)llIllllllIIIIIl.minX, (double)llIllllllIIIIIl.maxY, (double)llIllllllIIIIIl.maxZ);
        GL11.glVertex3d((double)llIllllllIIIIIl.minX, (double)llIllllllIIIIIl.maxY, (double)llIllllllIIIIIl.minZ);
        GL11.glVertex3d((double)llIllllllIIIIIl.minX, (double)llIllllllIIIIIl.minY, (double)llIllllllIIIIIl.minZ);
        GL11.glVertex3d((double)llIllllllIIIIIl.maxX, (double)llIllllllIIIIIl.minY, (double)llIllllllIIIIIl.minZ);
        GL11.glVertex3d((double)llIllllllIIIIIl.maxX, (double)llIllllllIIIIIl.minY, (double)llIllllllIIIIIl.minZ);
        GL11.glVertex3d((double)llIllllllIIIIIl.maxX, (double)llIllllllIIIIIl.minY, (double)llIllllllIIIIIl.maxZ);
        GL11.glVertex3d((double)llIllllllIIIIIl.maxX, (double)llIllllllIIIIIl.minY, (double)llIllllllIIIIIl.maxZ);
        GL11.glVertex3d((double)llIllllllIIIIIl.minX, (double)llIllllllIIIIIl.minY, (double)llIllllllIIIIIl.maxZ);
        GL11.glVertex3d((double)llIllllllIIIIIl.minX, (double)llIllllllIIIIIl.minY, (double)llIllllllIIIIIl.maxZ);
        GL11.glVertex3d((double)llIllllllIIIIIl.minX, (double)llIllllllIIIIIl.minY, (double)llIllllllIIIIIl.minZ);
        GL11.glVertex3d((double)llIllllllIIIIIl.minX, (double)llIllllllIIIIIl.minY, (double)llIllllllIIIIIl.minZ);
        GL11.glVertex3d((double)llIllllllIIIIIl.minX, (double)llIllllllIIIIIl.maxY, (double)llIllllllIIIIIl.minZ);
        GL11.glVertex3d((double)llIllllllIIIIIl.maxX, (double)llIllllllIIIIIl.minY, (double)llIllllllIIIIIl.minZ);
        GL11.glVertex3d((double)llIllllllIIIIIl.maxX, (double)llIllllllIIIIIl.maxY, (double)llIllllllIIIIIl.minZ);
        GL11.glVertex3d((double)llIllllllIIIIIl.maxX, (double)llIllllllIIIIIl.minY, (double)llIllllllIIIIIl.maxZ);
        GL11.glVertex3d((double)llIllllllIIIIIl.maxX, (double)llIllllllIIIIIl.maxY, (double)llIllllllIIIIIl.maxZ);
        GL11.glVertex3d((double)llIllllllIIIIIl.minX, (double)llIllllllIIIIIl.minY, (double)llIllllllIIIIIl.maxZ);
        GL11.glVertex3d((double)llIllllllIIIIIl.minX, (double)llIllllllIIIIIl.maxY, (double)llIllllllIIIIIl.maxZ);
        GL11.glEnd();
    }

    public static final void drawSmoothRect(float llIlllIIIIIlIII, float llIlllIIIIIIlll, float llIlllIIIIIlIll, float llIlllIIIIIlIlI, int llIlllIIIIIlIIl) {
        GL11.glEnable((int)3042);
        GL11.glEnable((int)2848);
        RenderUtil.drawRect(llIlllIIIIIlIII, llIlllIIIIIIlll, llIlllIIIIIlIll, llIlllIIIIIlIlI, llIlllIIIIIlIIl);
        GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
        RenderUtil.drawRect(llIlllIIIIIlIII * 2.0f - 1.0f, llIlllIIIIIIlll * 2.0f, llIlllIIIIIlIII * 2.0f, llIlllIIIIIlIlI * 2.0f - 1.0f, llIlllIIIIIlIIl);
        RenderUtil.drawRect(llIlllIIIIIlIII * 2.0f, llIlllIIIIIIlll * 2.0f - 1.0f, llIlllIIIIIlIll * 2.0f, llIlllIIIIIIlll * 2.0f, llIlllIIIIIlIIl);
        RenderUtil.drawRect(llIlllIIIIIlIll * 2.0f, llIlllIIIIIIlll * 2.0f, llIlllIIIIIlIll * 2.0f + 1.0f, llIlllIIIIIlIlI * 2.0f - 1.0f, llIlllIIIIIlIIl);
        RenderUtil.drawRect(llIlllIIIIIlIII * 2.0f, llIlllIIIIIlIlI * 2.0f - 1.0f, llIlllIIIIIlIll * 2.0f, llIlllIIIIIlIlI * 2.0f, llIlllIIIIIlIIl);
        GL11.glDisable((int)3042);
        GL11.glScalef((float)2.0f, (float)2.0f, (float)2.0f);
    }

    public static void renderItem(ItemStack llIlllIIllIllIl, int llIlllIIllIllll, int llIlllIIllIlllI) {
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        GlStateManager.enableDepth();
        RenderHelper.enableGUIStandardItemLighting();
        mc.getRenderItem().renderItemAndEffectIntoGUI(llIlllIIllIllIl, llIlllIIllIllll, llIlllIIllIlllI);
        mc.getRenderItem().renderItemOverlays(RenderUtil.mc.fontRenderer, llIlllIIllIllIl, llIlllIIllIllll, llIlllIIllIlllI);
        RenderHelper.disableStandardItemLighting();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.disableDepth();
    }

    public static void drawOutline(AxisAlignedBB lllIIIIIllIlIIl, float lllIIIIIllIlIII, Color lllIIIIIllIIlll) {
        GL11.glPushMatrix();
        GL11.glLineWidth((float)lllIIIIIllIlIII);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2929);
        Tessellator lllIIIIIllIIllI = Tessellator.getInstance();
        BufferBuilder lllIIIIIllIIlIl = lllIIIIIllIIllI.getBuffer();
        lllIIIIIllIIlIl.begin(3, DefaultVertexFormats.POSITION_COLOR);
        lllIIIIIllIIlIl.pos(lllIIIIIllIlIIl.minX, lllIIIIIllIlIIl.minY, lllIIIIIllIlIIl.minZ).color(lllIIIIIllIIlll.getRed(), lllIIIIIllIIlll.getGreen(), lllIIIIIllIIlll.getBlue(), 100).endVertex();
        lllIIIIIllIIlIl.pos(lllIIIIIllIlIIl.minX, lllIIIIIllIlIIl.minY, lllIIIIIllIlIIl.maxZ).color(lllIIIIIllIIlll.getRed(), lllIIIIIllIIlll.getGreen(), lllIIIIIllIIlll.getBlue(), 100).endVertex();
        lllIIIIIllIIlIl.pos(lllIIIIIllIlIIl.maxX, lllIIIIIllIlIIl.minY, lllIIIIIllIlIIl.maxZ).color(lllIIIIIllIIlll.getRed(), lllIIIIIllIIlll.getGreen(), lllIIIIIllIIlll.getBlue(), 100).endVertex();
        lllIIIIIllIIlIl.pos(lllIIIIIllIlIIl.maxX, lllIIIIIllIlIIl.minY, lllIIIIIllIlIIl.minZ).color(lllIIIIIllIIlll.getRed(), lllIIIIIllIIlll.getGreen(), lllIIIIIllIIlll.getBlue(), 100).endVertex();
        lllIIIIIllIIlIl.pos(lllIIIIIllIlIIl.minX, lllIIIIIllIlIIl.minY, lllIIIIIllIlIIl.minZ).color(lllIIIIIllIIlll.getRed(), lllIIIIIllIIlll.getGreen(), lllIIIIIllIIlll.getBlue(), 100).endVertex();
        lllIIIIIllIIlIl.pos(lllIIIIIllIlIIl.minX, lllIIIIIllIlIIl.maxY, lllIIIIIllIlIIl.minZ).color(lllIIIIIllIIlll.getRed(), lllIIIIIllIIlll.getGreen(), lllIIIIIllIIlll.getBlue(), 100).endVertex();
        lllIIIIIllIIlIl.pos(lllIIIIIllIlIIl.minX, lllIIIIIllIlIIl.maxY, lllIIIIIllIlIIl.maxZ).color(lllIIIIIllIIlll.getRed(), lllIIIIIllIIlll.getGreen(), lllIIIIIllIIlll.getBlue(), 100).endVertex();
        lllIIIIIllIIlIl.pos(lllIIIIIllIlIIl.minX, lllIIIIIllIlIIl.minY, lllIIIIIllIlIIl.maxZ).color(lllIIIIIllIIlll.getRed(), lllIIIIIllIIlll.getGreen(), lllIIIIIllIIlll.getBlue(), 100).endVertex();
        lllIIIIIllIIlIl.pos(lllIIIIIllIlIIl.maxX, lllIIIIIllIlIIl.minY, lllIIIIIllIlIIl.maxZ).color(lllIIIIIllIIlll.getRed(), lllIIIIIllIIlll.getGreen(), lllIIIIIllIIlll.getBlue(), 100).endVertex();
        lllIIIIIllIIlIl.pos(lllIIIIIllIlIIl.maxX, lllIIIIIllIlIIl.maxY, lllIIIIIllIlIIl.maxZ).color(lllIIIIIllIIlll.getRed(), lllIIIIIllIIlll.getGreen(), lllIIIIIllIIlll.getBlue(), 100).endVertex();
        lllIIIIIllIIlIl.pos(lllIIIIIllIlIIl.minX, lllIIIIIllIlIIl.maxY, lllIIIIIllIlIIl.maxZ).color(lllIIIIIllIIlll.getRed(), lllIIIIIllIIlll.getGreen(), lllIIIIIllIIlll.getBlue(), 100).endVertex();
        lllIIIIIllIIlIl.pos(lllIIIIIllIlIIl.maxX, lllIIIIIllIlIIl.maxY, lllIIIIIllIlIIl.maxZ).color(lllIIIIIllIIlll.getRed(), lllIIIIIllIIlll.getGreen(), lllIIIIIllIIlll.getBlue(), 100).endVertex();
        lllIIIIIllIIlIl.pos(lllIIIIIllIlIIl.maxX, lllIIIIIllIlIIl.maxY, lllIIIIIllIlIIl.minZ).color(lllIIIIIllIIlll.getRed(), lllIIIIIllIIlll.getGreen(), lllIIIIIllIIlll.getBlue(), 100).endVertex();
        lllIIIIIllIIlIl.pos(lllIIIIIllIlIIl.maxX, lllIIIIIllIlIIl.minY, lllIIIIIllIlIIl.minZ).color(lllIIIIIllIIlll.getRed(), lllIIIIIllIIlll.getGreen(), lllIIIIIllIIlll.getBlue(), 100).endVertex();
        lllIIIIIllIIlIl.pos(lllIIIIIllIlIIl.maxX, lllIIIIIllIlIIl.maxY, lllIIIIIllIlIIl.minZ).color(lllIIIIIllIIlll.getRed(), lllIIIIIllIIlll.getGreen(), lllIIIIIllIIlll.getBlue(), 100).endVertex();
        lllIIIIIllIIlIl.pos(lllIIIIIllIlIIl.minX, lllIIIIIllIlIIl.maxY, lllIIIIIllIlIIl.minZ).color(lllIIIIIllIIlll.getRed(), lllIIIIIllIIlll.getGreen(), lllIIIIIllIIlll.getBlue(), 100).endVertex();
        lllIIIIIllIIllI.draw();
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2929);
        GL11.glPopMatrix();
    }

    public static void drawFilledCircle(int llIlllIIIIllIll, int llIlllIIIlIIIII, float llIlllIIIIllIIl, Color llIlllIIIIllllI) {
        int llIlllIIIIlllIl = 6;
        double llIlllIIIIlllII = Math.PI * 2 / (double)llIlllIIIIlllIl;
        GL11.glPushAttrib((int)8192);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GL11.glBegin((int)6);
        for (int llIlllIIIlIIIlI = 0; llIlllIIIlIIIlI < llIlllIIIIlllIl; ++llIlllIIIlIIIlI) {
            float llIlllIIIlIIlII = (float)((double)llIlllIIIIllIIl * Math.sin((double)llIlllIIIlIIIlI * llIlllIIIIlllII));
            float llIlllIIIlIIIll = (float)((double)llIlllIIIIllIIl * Math.cos((double)llIlllIIIlIIIlI * llIlllIIIIlllII));
            GL11.glColor4f((float)((float)llIlllIIIIllllI.getRed() / 255.0f), (float)((float)llIlllIIIIllllI.getGreen() / 255.0f), (float)((float)llIlllIIIIllllI.getBlue() / 255.0f), (float)((float)llIlllIIIIllllI.getAlpha() / 255.0f));
            GL11.glVertex2f((float)((float)llIlllIIIIllIll + llIlllIIIlIIlII), (float)((float)llIlllIIIlIIIII + llIlllIIIlIIIll));
        }
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glEnd();
        GL11.glPopAttrib();
    }

    public static void disableGL2D3() {
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glEnable((int)2929);
        GL11.glDisable((int)2848);
        GL11.glHint((int)3154, (int)4352);
        GL11.glHint((int)3155, (int)4352);
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

    public static void drawCircle228(float llIlllllIIIIIIl, float llIlllllIIIIIII, float llIllllIlllllll, int llIllllIllllllI, int llIllllIlllllIl) {
        float llIlllllIIIlIII = (float)(llIllllIllllllI >> 24 & 0xFF) / 255.0f;
        float llIlllllIIIIlll = (float)(llIllllIllllllI >> 16 & 0xFF) / 255.0f;
        float llIlllllIIIIllI = (float)(llIllllIllllllI >> 8 & 0xFF) / 255.0f;
        float llIlllllIIIIlIl = (float)(llIllllIllllllI & 0xFF) / 255.0f;
        boolean llIlllllIIIIlII = GL11.glIsEnabled((int)3042);
        boolean llIlllllIIIIIll = GL11.glIsEnabled((int)2848);
        boolean llIlllllIIIIIlI = GL11.glIsEnabled((int)3553);
        if (!llIlllllIIIIlII) {
            GL11.glEnable((int)3042);
        }
        if (!llIlllllIIIIIll) {
            GL11.glEnable((int)2848);
        }
        if (llIlllllIIIIIlI) {
            GL11.glDisable((int)3553);
        }
        GL11.glEnable((int)2848);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glColor4f((float)llIlllllIIIIlll, (float)llIlllllIIIIllI, (float)llIlllllIIIIlIl, (float)llIlllllIIIlIII);
        GL11.glLineWidth((float)2.5f);
        GL11.glBegin((int)3);
        for (int llIlllllIIIlllI = 0; llIlllllIIIlllI <= llIllllIlllllIl; ++llIlllllIIIlllI) {
            GL11.glVertex2d((double)((double)llIlllllIIIIIIl + Math.sin((double)llIlllllIIIlllI * Math.PI / 180.0) * (double)llIllllIlllllll), (double)((double)llIlllllIIIIIII + Math.cos((double)llIlllllIIIlllI * Math.PI / 180.0) * (double)llIllllIlllllll));
        }
        GL11.glEnd();
        GL11.glDisable((int)2848);
        if (llIlllllIIIIIlI) {
            GL11.glEnable((int)3553);
        }
        if (!llIlllllIIIIIll) {
            GL11.glDisable((int)2848);
        }
        if (!llIlllllIIIIlII) {
            GL11.glDisable((int)3042);
        }
    }

    public static void drawGlow(double llIllIIlllIlllI, double llIllIIlllIIllI, double llIllIIlllIllII, double llIllIIlllIlIll, int llIllIIlllIlIlI, double llIllIIlllIlIIl) {
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int)7425);
        RenderUtil.drawVGradientRect((int)llIllIIlllIlllI, (int)llIllIIlllIIllI, (int)llIllIIlllIllII, (int)(llIllIIlllIIllI + (llIllIIlllIlIll - llIllIIlllIIllI) / 2.0), RenderUtil.injectAlpha(new Color(llIllIIlllIlIlI), 0).getRGB(), RenderUtil.injectAlpha(new Color(llIllIIlllIlIlI), (int)llIllIIlllIlIIl).getRGB());
        RenderUtil.drawVGradientRect((int)llIllIIlllIlllI, (int)(llIllIIlllIIllI + (llIllIIlllIlIll - llIllIIlllIIllI) / 2.0), (int)llIllIIlllIllII, (int)llIllIIlllIlIll, RenderUtil.injectAlpha(new Color(llIllIIlllIlIlI), (int)llIllIIlllIlIIl).getRGB(), RenderUtil.injectAlpha(new Color(llIllIIlllIlIlI), 0).getRGB());
        int llIllIIlllIlIII = (int)((llIllIIlllIlIll - llIllIIlllIIllI) / 2.0);
        RenderUtil.drawPolygonPart(llIllIIlllIlllI, llIllIIlllIIllI + (llIllIIlllIlIll - llIllIIlllIIllI) / 2.0, llIllIIlllIlIII, 0, RenderUtil.injectAlpha(new Color(llIllIIlllIlIlI), (int)llIllIIlllIlIIl).getRGB(), RenderUtil.injectAlpha(new Color(llIllIIlllIlIlI), 0).getRGB());
        RenderUtil.drawPolygonPart(llIllIIlllIlllI, llIllIIlllIIllI + (llIllIIlllIlIll - llIllIIlllIIllI) / 2.0, llIllIIlllIlIII, 1, RenderUtil.injectAlpha(new Color(llIllIIlllIlIlI), (int)llIllIIlllIlIIl).getRGB(), RenderUtil.injectAlpha(new Color(llIllIIlllIlIlI), 0).getRGB());
        RenderUtil.drawPolygonPart(llIllIIlllIllII, llIllIIlllIIllI + (llIllIIlllIlIll - llIllIIlllIIllI) / 2.0, llIllIIlllIlIII, 2, RenderUtil.injectAlpha(new Color(llIllIIlllIlIlI), (int)llIllIIlllIlIIl).getRGB(), RenderUtil.injectAlpha(new Color(llIllIIlllIlIlI), 0).getRGB());
        RenderUtil.drawPolygonPart(llIllIIlllIllII, llIllIIlllIIllI + (llIllIIlllIlIll - llIllIIlllIIllI) / 2.0, llIllIIlllIlIII, 3, RenderUtil.injectAlpha(new Color(llIllIIlllIlIlI), (int)llIllIIlllIlIIl).getRGB(), RenderUtil.injectAlpha(new Color(llIllIIlllIlIlI), 0).getRGB());
        GlStateManager.shadeModel((int)7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    public static void renderEntityFilledBoundingBox(Entity llIllllllIllIll, float llIllllllIlIIlI, float llIllllllIlIIIl, float llIllllllIllIII, float llIllllllIIllll) {
        RenderManager llIllllllIlIllI = Minecraft.getMinecraft().getRenderManager();
        Vec3d llIllllllIlIlIl = MathUtils.interpolateEntity(llIllllllIllIll);
        AxisAlignedBB llIllllllIlIlII = new AxisAlignedBB(llIllllllIlIlIl.x - (double)(llIllllllIllIll.width / 2.0f), llIllllllIlIlIl.y, llIllllllIlIlIl.z - (double)(llIllllllIllIll.width / 2.0f), llIllllllIlIlIl.x + (double)(llIllllllIllIll.width / 2.0f), llIllllllIlIlIl.y + (double)llIllllllIllIll.height, llIllllllIlIlIl.z + (double)(llIllllllIllIll.width / 2.0f)).offset(-llIllllllIlIllI.viewerPosX, -llIllllllIlIllI.viewerPosY, -llIllllllIlIllI.viewerPosZ);
        RenderGlobal.renderFilledBox((AxisAlignedBB)llIllllllIlIlII, (float)llIllllllIlIIlI, (float)llIllllllIlIIIl, (float)llIllllllIllIII, (float)llIllllllIIllll);
    }

    public static void drawBoundingBox(AxisAlignedBB llIlllIIIlIllll) {
        GL11.glBegin((int)7);
        GL11.glVertex3d((double)llIlllIIIlIllll.minX, (double)llIlllIIIlIllll.minY, (double)llIlllIIIlIllll.minZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.minX, (double)llIlllIIIlIllll.maxY, (double)llIlllIIIlIllll.minZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.maxX, (double)llIlllIIIlIllll.minY, (double)llIlllIIIlIllll.minZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.maxX, (double)llIlllIIIlIllll.maxY, (double)llIlllIIIlIllll.minZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.maxX, (double)llIlllIIIlIllll.minY, (double)llIlllIIIlIllll.maxZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.maxX, (double)llIlllIIIlIllll.maxY, (double)llIlllIIIlIllll.maxZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.minX, (double)llIlllIIIlIllll.minY, (double)llIlllIIIlIllll.maxZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.minX, (double)llIlllIIIlIllll.maxY, (double)llIlllIIIlIllll.maxZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.maxX, (double)llIlllIIIlIllll.maxY, (double)llIlllIIIlIllll.minZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.maxX, (double)llIlllIIIlIllll.minY, (double)llIlllIIIlIllll.minZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.minX, (double)llIlllIIIlIllll.maxY, (double)llIlllIIIlIllll.minZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.minX, (double)llIlllIIIlIllll.minY, (double)llIlllIIIlIllll.minZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.minX, (double)llIlllIIIlIllll.maxY, (double)llIlllIIIlIllll.maxZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.minX, (double)llIlllIIIlIllll.minY, (double)llIlllIIIlIllll.maxZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.maxX, (double)llIlllIIIlIllll.maxY, (double)llIlllIIIlIllll.maxZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.maxX, (double)llIlllIIIlIllll.minY, (double)llIlllIIIlIllll.maxZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.minX, (double)llIlllIIIlIllll.maxY, (double)llIlllIIIlIllll.minZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.maxX, (double)llIlllIIIlIllll.maxY, (double)llIlllIIIlIllll.minZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.maxX, (double)llIlllIIIlIllll.maxY, (double)llIlllIIIlIllll.maxZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.minX, (double)llIlllIIIlIllll.maxY, (double)llIlllIIIlIllll.maxZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.minX, (double)llIlllIIIlIllll.maxY, (double)llIlllIIIlIllll.minZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.minX, (double)llIlllIIIlIllll.maxY, (double)llIlllIIIlIllll.maxZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.maxX, (double)llIlllIIIlIllll.maxY, (double)llIlllIIIlIllll.maxZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.maxX, (double)llIlllIIIlIllll.maxY, (double)llIlllIIIlIllll.minZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.minX, (double)llIlllIIIlIllll.minY, (double)llIlllIIIlIllll.minZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.maxX, (double)llIlllIIIlIllll.minY, (double)llIlllIIIlIllll.minZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.maxX, (double)llIlllIIIlIllll.minY, (double)llIlllIIIlIllll.maxZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.minX, (double)llIlllIIIlIllll.minY, (double)llIlllIIIlIllll.maxZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.minX, (double)llIlllIIIlIllll.minY, (double)llIlllIIIlIllll.minZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.minX, (double)llIlllIIIlIllll.minY, (double)llIlllIIIlIllll.maxZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.maxX, (double)llIlllIIIlIllll.minY, (double)llIlllIIIlIllll.maxZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.maxX, (double)llIlllIIIlIllll.minY, (double)llIlllIIIlIllll.minZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.minX, (double)llIlllIIIlIllll.minY, (double)llIlllIIIlIllll.minZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.minX, (double)llIlllIIIlIllll.maxY, (double)llIlllIIIlIllll.minZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.minX, (double)llIlllIIIlIllll.minY, (double)llIlllIIIlIllll.maxZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.minX, (double)llIlllIIIlIllll.maxY, (double)llIlllIIIlIllll.maxZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.maxX, (double)llIlllIIIlIllll.minY, (double)llIlllIIIlIllll.maxZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.maxX, (double)llIlllIIIlIllll.maxY, (double)llIlllIIIlIllll.maxZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.maxX, (double)llIlllIIIlIllll.minY, (double)llIlllIIIlIllll.minZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.maxX, (double)llIlllIIIlIllll.maxY, (double)llIlllIIIlIllll.minZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.minX, (double)llIlllIIIlIllll.maxY, (double)llIlllIIIlIllll.maxZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.minX, (double)llIlllIIIlIllll.minY, (double)llIlllIIIlIllll.maxZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.minX, (double)llIlllIIIlIllll.maxY, (double)llIlllIIIlIllll.minZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.minX, (double)llIlllIIIlIllll.minY, (double)llIlllIIIlIllll.minZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.maxX, (double)llIlllIIIlIllll.maxY, (double)llIlllIIIlIllll.minZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.maxX, (double)llIlllIIIlIllll.minY, (double)llIlllIIIlIllll.minZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.maxX, (double)llIlllIIIlIllll.maxY, (double)llIlllIIIlIllll.maxZ);
        GL11.glVertex3d((double)llIlllIIIlIllll.maxX, (double)llIlllIIIlIllll.minY, (double)llIlllIIIlIllll.maxZ);
        GL11.glEnd();
    }

    public static void customScaledObject2D(float llIlllllllIllIl, float llIlllllllIIlll, float llIlllllllIIllI, float llIlllllllIlIlI, float llIlllllllIlIIl) {
        GL11.glTranslated((double)(llIlllllllIIllI / 2.0f), (double)(llIlllllllIlIlI / 2.0f), (double)1.0);
        GL11.glTranslated((double)(-llIlllllllIllIl * llIlllllllIlIIl + llIlllllllIllIl + llIlllllllIIllI / 2.0f * -llIlllllllIlIIl), (double)(-llIlllllllIIlll * llIlllllllIlIIl + llIlllllllIIlll + llIlllllllIlIlI / 2.0f * -llIlllllllIlIIl), (double)1.0);
        GL11.glScaled((double)llIlllllllIlIIl, (double)llIlllllllIlIIl, (double)0.0);
    }

    public static void glRenderStop() {
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2884);
        GL11.glDisable((int)3042);
        GL11.glPopAttrib();
        GL11.glPopMatrix();
    }

    private static boolean isInViewFrustrum(AxisAlignedBB llIllIIIIIlllll) {
        Entity llIllIIIIIllllI = mc.getRenderViewEntity();
        frustrum.setPosition(llIllIIIIIllllI.posX, llIllIIIIIllllI.posY, llIllIIIIIllllI.posZ);
        return frustrum.isBoundingBoxInFrustum(llIllIIIIIlllll);
    }

    public static void drawCircle(float llIlllllIllIIlI, float llIlllllIllIIIl, float llIlllllIllIIII, int llIlllllIlIIlII) {
        float llIlllllIlIlllI = (float)(llIlllllIlIIlII >> 24 & 0xFF) / 255.0f;
        float llIlllllIlIllIl = (float)(llIlllllIlIIlII >> 16 & 0xFF) / 255.0f;
        float llIlllllIlIllII = (float)(llIlllllIlIIlII >> 8 & 0xFF) / 255.0f;
        float llIlllllIlIlIll = (float)(llIlllllIlIIlII & 0xFF) / 255.0f;
        boolean llIlllllIlIlIlI = GL11.glIsEnabled((int)3042);
        boolean llIlllllIlIlIIl = GL11.glIsEnabled((int)2848);
        boolean llIlllllIlIlIII = GL11.glIsEnabled((int)3553);
        if (!llIlllllIlIlIlI) {
            GL11.glEnable((int)3042);
        }
        if (!llIlllllIlIlIIl) {
            GL11.glEnable((int)2848);
        }
        if (llIlllllIlIlIII) {
            GL11.glDisable((int)3553);
        }
        GL11.glEnable((int)2848);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glColor4f((float)llIlllllIlIllIl, (float)llIlllllIlIllII, (float)llIlllllIlIlIll, (float)llIlllllIlIlllI);
        GL11.glBegin((int)9);
        for (int llIlllllIllIIll = 0; llIlllllIllIIll <= 360; ++llIlllllIllIIll) {
            GL11.glVertex2d((double)((double)llIlllllIllIIlI + Math.sin((double)llIlllllIllIIll * Math.PI / 180.0) * (double)llIlllllIllIIII), (double)((double)llIlllllIllIIIl + Math.cos((double)llIlllllIllIIll * Math.PI / 180.0) * (double)llIlllllIllIIII));
        }
        GL11.glEnd();
        GL11.glDisable((int)2848);
        if (llIlllllIlIlIII) {
            GL11.glEnable((int)3553);
        }
        if (!llIlllllIlIlIIl) {
            GL11.glDisable((int)2848);
        }
        if (!llIlllllIlIlIlI) {
            GL11.glDisable((int)3042);
        }
    }

    public static void drawFilledCircleNoGL(int lllIIIlIIllIlII, int lllIIIlIIllIIll, double lllIIIlIIllIIlI, int lllIIIlIIlllIlI, int lllIIIlIIlllIIl) {
        float lllIIIlIIlllIII = (float)(lllIIIlIIlllIlI >> 24 & 0xFF) / 255.0f;
        float lllIIIlIIllIlll = (float)(lllIIIlIIlllIlI >> 16 & 0xFF) / 255.0f;
        float lllIIIlIIllIllI = (float)(lllIIIlIIlllIlI >> 8 & 0xFF) / 255.0f;
        float lllIIIlIIllIlIl = (float)(lllIIIlIIlllIlI & 0xFF) / 255.0f;
        GL11.glColor4f((float)lllIIIlIIllIlll, (float)lllIIIlIIllIllI, (float)lllIIIlIIllIlIl, (float)lllIIIlIIlllIII);
        GL11.glBegin((int)6);
        for (int lllIIIlIIlllllI = 0; lllIIIlIIlllllI <= 360 / lllIIIlIIlllIIl; ++lllIIIlIIlllllI) {
            double lllIIIlIlIIIIII = Math.sin((double)(lllIIIlIIlllllI * lllIIIlIIlllIIl) * Math.PI / 180.0) * lllIIIlIIllIIlI;
            double lllIIIlIIllllll = Math.cos((double)(lllIIIlIIlllllI * lllIIIlIIlllIIl) * Math.PI / 180.0) * lllIIIlIIllIIlI;
            GL11.glVertex2d((double)((double)lllIIIlIIllIlII + lllIIIlIlIIIIII), (double)((double)lllIIIlIIllIIll + lllIIIlIIllllll));
        }
        GL11.glEnd();
    }

    public static void drawESPTracers(List<Entity> lllIIIIIlIlIlII) {
        Vec3d lllIIIIIlIlIlIl = new Vec3d(Minecraft.getMinecraft().getRenderManager().viewerPosX, Minecraft.getMinecraft().getRenderManager().viewerPosY + (double)Minecraft.getMinecraft().player.func_70047_e(), Minecraft.getMinecraft().getRenderManager().viewerPosZ).add(Minecraft.getMinecraft().player.func_70040_Z());
        GL11.glLineWidth((float)2.0f);
        GL11.glBegin((int)1);
        for (Entity lllIIIIIlIlIlll : lllIIIIIlIlIlII) {
            Vec3d lllIIIIIlIllIII = lllIIIIIlIlIlll.getEntityBoundingBox().getCenter();
            if (lllIIIIIlIlIlll instanceof EntityPlayer && FriendManager.isFriend(lllIIIIIlIlIlll.getName())) {
                GL11.glColor4f((float)0.9f, (float)0.2f, (float)1.0f, (float)0.5f);
            } else if (lllIIIIIlIlIlll instanceof EntityItem) {
                GL11.glColor4f((float)0.5f, (float)0.5f, (float)1.0f, (float)0.5f);
            } else {
                float lllIIIIIlIllIIl = Minecraft.getMinecraft().player.func_70032_d(lllIIIIIlIlIlll) / 20.0f;
                GL11.glColor4f((float)(2.0f - lllIIIIIlIllIIl), (float)lllIIIIIlIllIIl, (float)0.0f, (float)0.5f);
            }
            GL11.glVertex3d((double)lllIIIIIlIlIlIl.x, (double)lllIIIIIlIlIlIl.y, (double)lllIIIIIlIlIlIl.z);
            GL11.glVertex3d((double)lllIIIIIlIllIII.x, (double)lllIIIIIlIllIII.y, (double)lllIIIIIlIllIII.z);
        }
        GL11.glEnd();
    }

    public static void renderBlurredShadow(Color lllIIIIlIllllll, double lllIIIIlIlllllI, double lllIIIIllIIIIll, double lllIIIIlIllllII, double lllIIIIllIIIIIl, int lllIIIIllIIIIII) {
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2884);
        RenderUtil.renderBlurredShadow(lllIIIIlIlllllI, lllIIIIllIIIIll, lllIIIIlIllllII, lllIIIIllIIIIIl, lllIIIIllIIIIII, lllIIIIlIllllll);
        GL11.glDisable((int)3042);
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2884);
        GL11.glEnable((int)3008);
        GL11.glEnable((int)3553);
        GL11.glEnable((int)3042);
    }

    public static void disableGL2D() {
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glEnable((int)2929);
        GL11.glDisable((int)2848);
        GL11.glHint((int)3154, (int)4352);
        GL11.glHint((int)3155, (int)4352);
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

    public static void ShulkerESP(BlockPos llIlIllIIIIlIll) {
        GL11.glPushMatrix();
        double llIlIllIIIIlllI = (double)llIlIllIIIIlIll.func_177958_n() - Minecraft.getMinecraft().getRenderManager().viewerPosX;
        double llIlIllIIIIllIl = (double)llIlIllIIIIlIll.func_177956_o() - Minecraft.getMinecraft().getRenderManager().viewerPosY;
        double llIlIllIIIIllII = (double)llIlIllIIIIlIll.func_177952_p() - Minecraft.getMinecraft().getRenderManager().viewerPosZ;
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        RenderGlobal.renderFilledBox((AxisAlignedBB)new AxisAlignedBB(llIlIllIIIIlllI, llIlIllIIIIllIl, llIlIllIIIIllII, llIlIllIIIIlllI + 1.0, llIlIllIIIIllIl + 1.0, llIlIllIIIIllII + 1.0), (float)0.0f, (float)0.0f, (float)1.0f, (float)0.5f);
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2929);
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)3042);
        GL11.glPopMatrix();
    }

    private static void GLPre(boolean lllIIIIlllIIllI, boolean lllIIIIllIlllll, boolean lllIIIIlllIIlII, boolean lllIIIIlllIIIll, boolean lllIIIIlllIIIlI, float lllIIIIlllIIIIl) {
        if (lllIIIIlllIIllI) {
            GL11.glDisable((int)2896);
        }
        if (!lllIIIIllIlllll) {
            GL11.glEnable((int)3042);
        }
        GL11.glLineWidth((float)lllIIIIlllIIIIl);
        if (lllIIIIlllIIlII) {
            GL11.glDisable((int)3553);
        }
        if (lllIIIIlllIIIll) {
            GL11.glDisable((int)2929);
        }
        if (!lllIIIIlllIIIlI) {
            GL11.glEnable((int)2848);
        }
        GlStateManager.blendFunc((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GL11.glHint((int)3154, (int)4354);
        GlStateManager.depthMask((boolean)false);
    }

    public RenderUtil() {
        RenderUtil lllIIIlIllIlIll;
    }

    public static void GlPost() {
        RenderUtil.GLPost(depth, texture, clean, bind, override);
    }

    public static void draw2DRectLines(double llIlIllIllIlIll, double llIlIllIlllIlII, double llIlIllIllIlIIl, double llIlIllIlllIIlI, float llIlIllIllIIlll, float llIlIllIlllIIII, float llIlIllIllIIlIl, float llIlIllIllIlllI) {
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        Tessellator llIlIllIllIllIl = Tessellator.getInstance();
        BufferBuilder llIlIllIllIllII = llIlIllIllIllIl.getBuffer();
        GlStateManager.color((float)llIlIllIllIIlll, (float)llIlIllIlllIIII, (float)llIlIllIllIIlIl, (float)llIlIllIllIlllI);
        llIlIllIllIllII.begin(2, DefaultVertexFormats.POSITION);
        llIlIllIllIllII.pos(llIlIllIllIlIll, llIlIllIlllIlII, 0.0).endVertex();
        llIlIllIllIllII.pos(llIlIllIllIlIll, llIlIllIlllIlII + llIlIllIlllIIlI, 0.0).endVertex();
        llIlIllIllIllII.pos(llIlIllIllIlIll + llIlIllIllIlIIl, llIlIllIlllIlII + llIlIllIlllIIlI, 0.0).endVertex();
        llIlIllIllIllII.pos(llIlIllIllIlIll + llIlIllIllIlIIl, llIlIllIlllIlII, 0.0).endVertex();
        llIlIllIllIllIl.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void drawBorderedCircle(float llIllllIIIIIIIl, float llIllllIIIIIIII, float llIlllIllllllll, int llIlllIllllIlIl, int llIlllIllllIlII, int llIlllIlllllIll) {
        RenderUtil.drawCircle(llIllllIIIIIIIl, llIllllIIIIIIII, llIlllIllllllll, llIlllIlllllIll);
        RenderUtil.drawUnfilledCircle(llIllllIIIIIIIl, llIllllIIIIIIII, llIlllIllllllll, llIlllIllllIlIl, llIlllIllllIlII);
    }

    public static void drawBlockESP(BlockPos lllIIIlIIIIlllI, float lllIIIlIIIlIlII, float lllIIIlIIIIllII, float lllIIIlIIIlIIlI) {
        GL11.glPushMatrix();
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GL11.glLineWidth((float)1.0f);
        GL11.glDisable((int)3553);
        GL11.glEnable((int)2884);
        GL11.glDisable((int)2929);
        GL11.glDisable((int)2896);
        double lllIIIlIIIlIIIl = Minecraft.getMinecraft().getRenderManager().viewerPosX;
        double lllIIIlIIIlIIII = Minecraft.getMinecraft().getRenderManager().viewerPosY;
        double lllIIIlIIIIllll = Minecraft.getMinecraft().getRenderManager().viewerPosZ;
        GL11.glTranslated((double)(-lllIIIlIIIlIIIl), (double)(-lllIIIlIIIlIIII), (double)(-lllIIIlIIIIllll));
        GL11.glTranslated((double)lllIIIlIIIIlllI.func_177958_n(), (double)lllIIIlIIIIlllI.func_177956_o(), (double)lllIIIlIIIIlllI.func_177952_p());
        GL11.glColor4f((float)lllIIIlIIIlIlII, (float)lllIIIlIIIIllII, (float)lllIIIlIIIlIIlI, (float)0.3f);
        RenderUtil.drawSolidBox();
        GL11.glColor4f((float)lllIIIlIIIlIlII, (float)lllIIIlIIIIllII, (float)lllIIIlIIIlIIlI, (float)0.7f);
        RenderUtil.drawOutlinedBox();
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glEnable((int)2896);
        GL11.glEnable((int)2929);
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glDisable((int)2848);
        GL11.glPopMatrix();
    }

    public static void drawRectOpacity(double llIllIIIllllIIl, double llIllIIIllllIII, double llIllIIIlllIIII, double llIllIIIlllIllI, float llIllIIIllIlllI) {
        if (llIllIIIllllIIl < llIllIIIlllIIII) {
            double llIllIIIllllIll = llIllIIIllllIIl;
            llIllIIIllllIIl = llIllIIIlllIIII;
            llIllIIIlllIIII = llIllIIIllllIll;
        }
        if (llIllIIIllllIII < llIllIIIlllIllI) {
            double llIllIIIllllIlI = llIllIIIllllIII;
            llIllIIIllllIII = llIllIIIlllIllI;
            llIllIIIlllIllI = llIllIIIllllIlI;
        }
        Tessellator llIllIIIlllIlII = Tessellator.getInstance();
        BufferBuilder llIllIIIlllIIll = llIllIIIlllIlII.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        GlStateManager.color((float)0.1f, (float)0.1f, (float)0.1f, (float)llIllIIIllIlllI);
        llIllIIIlllIIll.begin(7, DefaultVertexFormats.POSITION);
        llIllIIIlllIIll.pos(llIllIIIllllIIl, llIllIIIlllIllI, 0.0).endVertex();
        llIllIIIlllIIll.pos(llIllIIIlllIIII, llIllIIIlllIllI, 0.0).endVertex();
        llIllIIIlllIIll.pos(llIllIIIlllIIII, llIllIIIllllIII, 0.0).endVertex();
        llIllIIIlllIIll.pos(llIllIIIllllIIl, llIllIIIllllIII, 0.0).endVertex();
        llIllIIIlllIlII.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void setColor(Color llIllllIIllllll) {
        GL11.glColor4d((double)((float)llIllllIIllllll.getRed() / 255.0f), (double)((float)llIllllIIllllll.getGreen() / 255.0f), (double)((float)llIllllIIllllll.getBlue() / 255.0f), (double)((float)llIllllIIllllll.getAlpha() / 255.0f));
    }

    public static void prepareScissorBox(float llIllIllIllIlIl, float llIllIllIllIlII, float llIllIllIlIllIl, float llIllIllIlIllII) {
        ScaledResolution llIllIllIllIIIl = new ScaledResolution(Minecraft.getMinecraft());
        int llIllIllIllIIII = llIllIllIllIIIl.getScaleFactor();
        GL11.glScissor((int)((int)(llIllIllIllIlIl * (float)llIllIllIllIIII)), (int)((int)(((float)llIllIllIllIIIl.getScaledHeight() - llIllIllIlIllII) * (float)llIllIllIllIIII)), (int)((int)((llIllIllIlIllIl - llIllIllIllIlIl) * (float)llIllIllIllIIII)), (int)((int)((llIllIllIlIllII - llIllIllIllIlII) * (float)llIllIllIllIIII)));
    }

    public static void drawLinesAroundPlayer(Entity llIllIIIIlIllll, double llIllIIIIlIlllI, float llIllIIIIllIlll, int llIllIIIIllIllI, float llIllIIIIllIlIl, int llIllIIIIllIlII) {
        GL11.glPushMatrix();
        RenderUtil.enableGL2D3();
        GL11.glDisable((int)3553);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glDisable((int)2929);
        GL11.glLineWidth((float)llIllIIIIllIlIl);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDisable((int)2929);
        GL11.glBegin((int)3);
        RenderManager llIllIIIIllIIll = Minecraft.getMinecraft().getRenderManager();
        double llIllIIIIllIIlI = llIllIIIIlIllll.lastTickPosX + (llIllIIIIlIllll.posX - llIllIIIIlIllll.lastTickPosX) * (double)llIllIIIIllIlll - llIllIIIIllIIll.viewerPosX;
        double llIllIIIIllIIIl = llIllIIIIlIllll.lastTickPosY + (llIllIIIIlIllll.posY - llIllIIIIlIllll.lastTickPosY) * (double)llIllIIIIllIlll - llIllIIIIllIIll.viewerPosY;
        double llIllIIIIllIIII = llIllIIIIlIllll.lastTickPosZ + (llIllIIIIlIllll.posZ - llIllIIIIlIllll.lastTickPosZ) * (double)llIllIIIIllIlll - llIllIIIIllIIll.viewerPosZ;
        RenderUtil.color228(llIllIIIIllIlII);
        for (int llIllIIIIlllIlI = 0; llIllIIIIlllIlI <= llIllIIIIllIllI; ++llIllIIIIlllIlI) {
            GL11.glVertex3d((double)(llIllIIIIllIIlI + llIllIIIIlIlllI * Math.cos((double)llIllIIIIlllIlI * (Math.PI * 2) / (double)llIllIIIIllIllI)), (double)llIllIIIIllIIIl, (double)(llIllIIIIllIIII + llIllIIIIlIlllI * Math.sin((double)llIllIIIIlllIlI * (Math.PI * 2) / (double)llIllIIIIllIllI)));
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

    public static void drawShadowRect(int llIlIllIIIIIlll, int llIlIllIIIIIllI, int llIlIllIIIIIlIl, int llIlIllIIIIIlII, int llIlIllIIIIIIll) {
    }

    public static int raindbow(int llIllIlllllIIlI) {
        double llIllIlllllIIIl = Math.ceil((System.currentTimeMillis() + (long)llIllIlllllIIlI) / 20L);
        return Color.getHSBColor((float)((llIllIlllllIIIl %= 360.0) / 360.0), 0.5f, 1.0f).getRGB();
    }

    public static void drawVGradientRect(float llIllIlIIIllIll, float llIllIlIIIIlIlI, float llIllIlIIIIlIIl, float llIllIlIIIIlIII, int llIllIlIIIIIlll, int llIllIlIIIlIllI) {
        float llIllIlIIIlIlIl = (float)(llIllIlIIIIIlll >> 24 & 0xFF) / 255.0f;
        float llIllIlIIIlIlII = (float)(llIllIlIIIIIlll >> 16 & 0xFF) / 255.0f;
        float llIllIlIIIlIIll = (float)(llIllIlIIIIIlll >> 8 & 0xFF) / 255.0f;
        float llIllIlIIIlIIlI = (float)(llIllIlIIIIIlll & 0xFF) / 255.0f;
        float llIllIlIIIlIIIl = (float)(llIllIlIIIlIllI >> 24 & 0xFF) / 255.0f;
        float llIllIlIIIlIIII = (float)(llIllIlIIIlIllI >> 16 & 0xFF) / 255.0f;
        float llIllIlIIIIllll = (float)(llIllIlIIIlIllI >> 8 & 0xFF) / 255.0f;
        float llIllIlIIIIlllI = (float)(llIllIlIIIlIllI & 0xFF) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int)7425);
        Tessellator llIllIlIIIIllIl = Tessellator.getInstance();
        BufferBuilder llIllIlIIIIllII = llIllIlIIIIllIl.getBuffer();
        llIllIlIIIIllII.begin(7, DefaultVertexFormats.POSITION_COLOR);
        llIllIlIIIIllII.pos((double)llIllIlIIIIlIIl, (double)llIllIlIIIIlIlI, 0.0).color(llIllIlIIIlIlII, llIllIlIIIlIIll, llIllIlIIIlIIlI, llIllIlIIIlIlIl).endVertex();
        llIllIlIIIIllII.pos((double)llIllIlIIIllIll, (double)llIllIlIIIIlIlI, 0.0).color(llIllIlIIIlIlII, llIllIlIIIlIIll, llIllIlIIIlIIlI, llIllIlIIIlIlIl).endVertex();
        llIllIlIIIIllII.pos((double)llIllIlIIIllIll, (double)llIllIlIIIIlIII, 0.0).color(llIllIlIIIlIIII, llIllIlIIIIllll, llIllIlIIIIlllI, llIllIlIIIlIIIl).endVertex();
        llIllIlIIIIllII.pos((double)llIllIlIIIIlIIl, (double)llIllIlIIIIlIII, 0.0).color(llIllIlIIIlIIII, llIllIlIIIIllll, llIllIlIIIIlllI, llIllIlIIIlIIIl).endVertex();
        llIllIlIIIIllIl.draw();
        GlStateManager.shadeModel((int)7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    public static void drawTracer(Entity lllIIIIlIIIlIII, float lllIIIIIllllIlI, float lllIIIIlIIIIllI, float lllIIIIIllllIII, float lllIIIIlIIIIlII, float lllIIIIIlllIllI) {
        double lllIIIIlIIIIIlI = Minecraft.getMinecraft().getRenderManager().viewerPosX;
        double lllIIIIlIIIIIIl = Minecraft.getMinecraft().getRenderManager().viewerPosY;
        double lllIIIIlIIIIIII = Minecraft.getMinecraft().getRenderManager().viewerPosZ;
        double lllIIIIIlllllll = lllIIIIlIIIlIII.lastTickPosX + (lllIIIIlIIIlIII.posX - lllIIIIlIIIlIII.lastTickPosX) * (double)lllIIIIIlllIllI - lllIIIIlIIIIIlI;
        double lllIIIIIllllllI = lllIIIIlIIIlIII.lastTickPosY + (lllIIIIlIIIlIII.posY - lllIIIIlIIIlIII.lastTickPosY) * (double)lllIIIIIlllIllI + (double)(lllIIIIlIIIlIII.height / 2.0f) - lllIIIIlIIIIIIl;
        double lllIIIIIlllllIl = lllIIIIlIIIlIII.lastTickPosZ + (lllIIIIlIIIlIII.posZ - lllIIIIlIIIlIII.lastTickPosZ) * (double)lllIIIIIlllIllI - lllIIIIlIIIIIII;
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)3042);
        GL11.glEnable((int)2848);
        GL11.glDisable((int)2896);
        GL11.glLineWidth((float)1.0f);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        GL11.glColor4f((float)lllIIIIIllllIlI, (float)lllIIIIlIIIIllI, (float)lllIIIIIllllIII, (float)lllIIIIlIIIIlII);
        Object lllIIIIIlllllII = null;
        GL11.glBegin((int)1);
        GL11.glVertex3d((double)lllIIIIIlllllII.x, (double)((double)Minecraft.getMinecraft().player.func_70047_e() + lllIIIIIlllllII.y), (double)lllIIIIIlllllII.z);
        GL11.glVertex3d((double)lllIIIIIlllllll, (double)lllIIIIIllllllI, (double)lllIIIIIlllllIl);
        GL11.glEnd();
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2929);
        GL11.glEnable((int)2896);
        GL11.glDepthMask((boolean)true);
    }
}

