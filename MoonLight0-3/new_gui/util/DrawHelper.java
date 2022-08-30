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
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.culling.Frustum
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.MathHelper
 *  org.lwjgl.opengl.GL11
 */
package new_gui.util;

import java.awt.Color;
import java.text.NumberFormat;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;

public class DrawHelper {
    private static /* synthetic */ int test;
    protected static /* synthetic */ float zLevel;
    private static /* synthetic */ int time;
    private static /* synthetic */ boolean anim;
    private static /* synthetic */ float alpheble;
    private static /* synthetic */ float animtest;
    private static final /* synthetic */ Frustum frustrum;
    private static /* synthetic */ Minecraft mc;

    private static boolean isInViewFrustrum(AxisAlignedBB llIIIIlIllIIllI) {
        Entity llIIIIlIllIIlll = Minecraft.getMinecraft().getRenderViewEntity();
        frustrum.setPosition(llIIIIlIllIIlll.posX, llIIIIlIllIIlll.posY, llIIIIlIllIIlll.posZ);
        return frustrum.isBoundingBoxInFrustum(llIIIIlIllIIllI);
    }

    public static int toRGBA(float llIIIIIlIIIIIlI, float llIIIIIlIIIIIIl, float llIIIIIlIIIIIII, float llIIIIIIlllllll) {
        return DrawHelper.toRGBA((int)(llIIIIIlIIIIIlI * 255.0f), (int)(llIIIIIlIIIIIIl * 255.0f), (int)(llIIIIIlIIIIIII * 255.0f), (int)(llIIIIIIlllllll * 255.0f));
    }

    public static int reAlpha(int llIIIIIlIllIlIl, float llIIIIIlIlIlllI) {
        Color llIIIIIlIllIIll = new Color(llIIIIIlIllIlIl);
        float llIIIIIlIllIIlI = 0.003921569f * (float)llIIIIIlIllIIll.getRed();
        float llIIIIIlIllIIIl = 0.003921569f * (float)llIIIIIlIllIIll.getGreen();
        float llIIIIIlIllIIII = 0.003921569f * (float)llIIIIIlIllIIll.getBlue();
        return new Color(llIIIIIlIllIIlI, llIIIIIlIllIIIl, llIIIIIlIllIIII, llIIIIIlIlIlllI).getRGB();
    }

    public static void enableSmoothLine(float llIIIlIlIIIIlIl) {
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
        GL11.glLineWidth((float)llIIIlIlIIIIlIl);
    }

    public static void startSmooth() {
        GL11.glEnable((int)2848);
        GL11.glEnable((int)2881);
        GL11.glEnable((int)2832);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glHint((int)3154, (int)4354);
        GL11.glHint((int)3155, (int)4354);
        GL11.glHint((int)3153, (int)4354);
    }

    public static void enableGL2D() {
        GL11.glDisable((int)2929);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDepthMask((boolean)true);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glHint((int)3155, (int)4354);
    }

    public static Color getGradientOffset(Color llIIIIIlIIllIIl, Color llIIIIIlIIlllll, double llIIIIIlIIlIlll) {
        if (llIIIIIlIIlIlll > 1.0) {
            double llIIIIIlIlIIIlI = llIIIIIlIIlIlll % 1.0;
            int llIIIIIlIlIIIIl = (int)llIIIIIlIIlIlll;
            llIIIIIlIIlIlll = llIIIIIlIlIIIIl % 2 == 0 ? llIIIIIlIlIIIlI : 1.0 - llIIIIIlIlIIIlI;
        }
        double llIIIIIlIIlllIl = 1.0 - llIIIIIlIIlIlll;
        int llIIIIIlIIlllII = (int)((double)llIIIIIlIIllIIl.getRed() * llIIIIIlIIlllIl + (double)llIIIIIlIIlllll.getRed() * llIIIIIlIIlIlll);
        int llIIIIIlIIllIll = (int)((double)llIIIIIlIIllIIl.getGreen() * llIIIIIlIIlllIl + (double)llIIIIIlIIlllll.getGreen() * llIIIIIlIIlIlll);
        int llIIIIIlIIllIlI = (int)((double)llIIIIIlIIllIIl.getBlue() * llIIIIIlIIlllIl + (double)llIIIIIlIIlllll.getBlue() * llIIIIIlIIlIlll);
        return new Color(llIIIIIlIIlllII, llIIIIIlIIllIll, llIIIIIlIIllIlI);
    }

    public static int getColor(int llIIIIIIlllIlll, int llIIIIIIlllIIll, int llIIIIIIlllIIlI) {
        return DrawHelper.getColor(llIIIIIIlllIlll, llIIIIIIlllIIll, llIIIIIIlllIIlI, 255);
    }

    public DrawHelper() {
        DrawHelper llIIIlIllIIlllI;
    }

    public static int getColor(int llIIIIIIlIlllIl, int llIIIIIIlIllIlI) {
        return DrawHelper.getColor(llIIIIIIlIlllIl, llIIIIIIlIlllIl, llIIIIIIlIlllIl, llIIIIIIlIllIlI);
    }

    public static void drawRect2(double llIIIIlIlIlIIII, double llIIIIlIlIIllll, double llIIIIlIlIIlllI, double llIIIIlIlIIllIl, int llIIIIlIlIIllII) {
        DrawHelper.drawRect(llIIIIlIlIlIIII, llIIIIlIlIIllll, llIIIIlIlIlIIII + llIIIIlIlIIlllI, llIIIIlIlIIllll + llIIIIlIlIIllIl, llIIIIlIlIIllII);
    }

    public static double interpolate(double llIIIIlIlllIIII, double llIIIIlIllIllll, double llIIIIlIlllIIIl) {
        return llIIIIlIllIllll + (llIIIIlIlllIIII - llIIIIlIllIllll) * llIIIIlIlllIIIl;
    }

    public static int getTeamColor(Entity lIllllllIIllllI) {
        int lIllllllIIlllIl = -1;
        lIllllllIIlllIl = lIllllllIIllllI.getDisplayName().getUnformattedText().equalsIgnoreCase(String.valueOf(new StringBuilder().append("\u043f\u0457\u0405f[\u043f\u0457\u0405cR\u043f\u0457\u0405f]\u043f\u0457\u0405c").append(lIllllllIIllllI.getName()))) ? DrawHelper.getColor(new Color(255, 60, 60).getRGB()) : (lIllllllIIllllI.getDisplayName().getUnformattedText().equalsIgnoreCase(String.valueOf(new StringBuilder().append("\u043f\u0457\u0405f[\u043f\u0457\u04059B\u043f\u0457\u0405f]\u043f\u0457\u04059").append(lIllllllIIllllI.getName()))) ? DrawHelper.getColor(new Color(60, 60, 255).getRGB()) : (lIllllllIIllllI.getDisplayName().getUnformattedText().equalsIgnoreCase(String.valueOf(new StringBuilder().append("\u043f\u0457\u0405f[\u043f\u0457\u0405eY\u043f\u0457\u0405f]\u043f\u0457\u0405e").append(lIllllllIIllllI.getName()))) ? DrawHelper.getColor(new Color(255, 255, 60).getRGB()) : (lIllllllIIllllI.getDisplayName().getUnformattedText().equalsIgnoreCase(String.valueOf(new StringBuilder().append("\u043f\u0457\u0405f[\u043f\u0457\u0405aG\u043f\u0457\u0405f]\u043f\u0457\u0405a").append(lIllllllIIllllI.getName()))) ? DrawHelper.getColor(new Color(60, 255, 60).getRGB()) : DrawHelper.getColor(new Color(255, 255, 255).getRGB()))));
        return lIllllllIIlllIl;
    }

    public static void drawRect(double llIIIIlIIIlIllI, double llIIIIlIIIlIlIl, double llIIIIlIIIlIlII, double llIIIIlIIIlIIll, int llIIIIlIIIIIlll) {
        if (llIIIIlIIIlIllI < llIIIIlIIIlIlII) {
            double llIIIIlIIIllIII = llIIIIlIIIlIllI;
            llIIIIlIIIlIllI = llIIIIlIIIlIlII;
            llIIIIlIIIlIlII = llIIIIlIIIllIII;
        }
        if (llIIIIlIIIlIlIl < llIIIIlIIIlIIll) {
            double llIIIIlIIIlIlll = llIIIIlIIIlIlIl;
            llIIIIlIIIlIlIl = llIIIIlIIIlIIll;
            llIIIIlIIIlIIll = llIIIIlIIIlIlll;
        }
        float llIIIIlIIIlIIIl = (float)(llIIIIlIIIIIlll >> 24 & 0xFF) / 255.0f;
        float llIIIIlIIIlIIII = (float)(llIIIIlIIIIIlll >> 16 & 0xFF) / 255.0f;
        float llIIIIlIIIIllll = (float)(llIIIIlIIIIIlll >> 8 & 0xFF) / 255.0f;
        float llIIIIlIIIIlllI = (float)(llIIIIlIIIIIlll & 0xFF) / 255.0f;
        Tessellator llIIIIlIIIIllIl = Tessellator.getInstance();
        BufferBuilder llIIIIlIIIIllII = llIIIIlIIIIllIl.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        GlStateManager.color((float)llIIIIlIIIlIIII, (float)llIIIIlIIIIllll, (float)llIIIIlIIIIlllI, (float)llIIIIlIIIlIIIl);
        llIIIIlIIIIllII.begin(7, DefaultVertexFormats.POSITION);
        llIIIIlIIIIllII.pos(llIIIIlIIIlIllI, llIIIIlIIIlIIll, 0.0).endVertex();
        llIIIIlIIIIllII.pos(llIIIIlIIIlIlII, llIIIIlIIIlIIll, 0.0).endVertex();
        llIIIIlIIIIllII.pos(llIIIIlIIIlIlII, llIIIIlIIIlIlIl, 0.0).endVertex();
        llIIIIlIIIIllII.pos(llIIIIlIIIlIllI, llIIIIlIIIlIlIl, 0.0).endVertex();
        llIIIIlIIIIllIl.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static int getRandomColor() {
        char[] llIIIIIllIIIIII = "012345678".toCharArray();
        String llIIIIIlIllllll = "0x";
        for (int llIIIIIllIIIIIl = 0; llIIIIIllIIIIIl < 6; ++llIIIIIllIIIIIl) {
            llIIIIIlIllllll = String.valueOf(new StringBuilder().append(llIIIIIlIllllll).append(llIIIIIllIIIIII[new Random().nextInt(llIIIIIllIIIIII.length)]));
        }
        return Integer.decode(llIIIIIlIllllll);
    }

    public static void drawSelectionBoundingBox(AxisAlignedBB llIIIlIlIlIlIll) {
        Tessellator llIIIlIlIlIlIlI = Tessellator.getInstance();
        BufferBuilder llIIIlIlIlIlIIl = llIIIlIlIlIlIlI.getBuffer();
        llIIIlIlIlIlIIl.begin(3, DefaultVertexFormats.POSITION);
        llIIIlIlIlIlIIl.pos(llIIIlIlIlIlIll.minX, llIIIlIlIlIlIll.minY, llIIIlIlIlIlIll.minZ).endVertex();
        llIIIlIlIlIlIIl.pos(llIIIlIlIlIlIll.minX, llIIIlIlIlIlIll.minY, llIIIlIlIlIlIll.maxZ).endVertex();
        llIIIlIlIlIlIIl.pos(llIIIlIlIlIlIll.maxX, llIIIlIlIlIlIll.minY, llIIIlIlIlIlIll.maxZ).endVertex();
        llIIIlIlIlIlIIl.pos(llIIIlIlIlIlIll.maxX, llIIIlIlIlIlIll.minY, llIIIlIlIlIlIll.minZ).endVertex();
        llIIIlIlIlIlIIl.pos(llIIIlIlIlIlIll.minX, llIIIlIlIlIlIll.minY, llIIIlIlIlIlIll.minZ).endVertex();
        llIIIlIlIlIlIIl.pos(llIIIlIlIlIlIll.minX, llIIIlIlIlIlIll.maxY, llIIIlIlIlIlIll.minZ).endVertex();
        llIIIlIlIlIlIIl.pos(llIIIlIlIlIlIll.minX, llIIIlIlIlIlIll.maxY, llIIIlIlIlIlIll.maxZ).endVertex();
        llIIIlIlIlIlIIl.pos(llIIIlIlIlIlIll.maxX, llIIIlIlIlIlIll.maxY, llIIIlIlIlIlIll.maxZ).endVertex();
        llIIIlIlIlIlIIl.pos(llIIIlIlIlIlIll.maxX, llIIIlIlIlIlIll.maxY, llIIIlIlIlIlIll.minZ).endVertex();
        llIIIlIlIlIlIIl.pos(llIIIlIlIlIlIll.minX, llIIIlIlIlIlIll.maxY, llIIIlIlIlIlIll.minZ).endVertex();
        llIIIlIlIlIlIIl.pos(llIIIlIlIlIlIll.minX, llIIIlIlIlIlIll.maxY, llIIIlIlIlIlIll.maxZ).endVertex();
        llIIIlIlIlIlIIl.pos(llIIIlIlIlIlIll.minX, llIIIlIlIlIlIll.minY, llIIIlIlIlIlIll.maxZ).endVertex();
        llIIIlIlIlIlIIl.pos(llIIIlIlIlIlIll.maxX, llIIIlIlIlIlIll.minY, llIIIlIlIlIlIll.maxZ).endVertex();
        llIIIlIlIlIlIIl.pos(llIIIlIlIlIlIll.maxX, llIIIlIlIlIlIll.maxY, llIIIlIlIlIlIll.maxZ).endVertex();
        llIIIlIlIlIlIIl.pos(llIIIlIlIlIlIll.maxX, llIIIlIlIlIlIll.maxY, llIIIlIlIlIlIll.minZ).endVertex();
        llIIIlIlIlIlIIl.pos(llIIIlIlIlIlIll.maxX, llIIIlIlIlIlIll.minY, llIIIlIlIlIlIll.minZ).endVertex();
        llIIIlIlIlIlIlI.draw();
    }

    public static int astolfoColors5(float lIlllllIlllllll, float lIllllllIIIIlII, float lIlllllIlllllIl, float lIllllllIIIIIlI) {
        float lIllllllIIIIIII;
        float lIllllllIIIIIIl = 1800.0f;
        for (lIllllllIIIIIII = (float)(System.currentTimeMillis() % (long)((int)lIllllllIIIIIIl)) + (lIllllllIIIIlII - lIlllllIlllllll) * lIllllllIIIIIlI; lIllllllIIIIIII > lIllllllIIIIIIl; lIllllllIIIIIII -= lIllllllIIIIIIl) {
        }
        if ((double)(lIllllllIIIIIII /= lIllllllIIIIIIl) > 0.5) {
            lIllllllIIIIIII = 0.5f - (lIllllllIIIIIII - 0.5f);
        }
        return Color.HSBtoRGB(lIllllllIIIIIII += 0.5f, lIlllllIlllllIl, 1.0f);
    }

    public static Color TwoColoreffect(Color lIllllllllIIlll, Color lIllllllllIlIll, double lIllllllllIlIlI) {
        double lIllllllllIlIIl = lIllllllllIlIlI / 4.0 % 1.0;
        float lIllllllllIlIII = MathHelper.clamp((float)((float)Math.sin(Math.PI * 6 * lIllllllllIlIIl) / 2.0f + 0.5f), (float)0.0f, (float)1.0f);
        return new Color(DrawHelper.lerp((float)lIllllllllIIlll.getRed() / 255.0f, (float)lIllllllllIlIll.getRed() / 255.0f, lIllllllllIlIII), DrawHelper.lerp((float)lIllllllllIIlll.getGreen() / 255.0f, (float)lIllllllllIlIll.getGreen() / 255.0f, lIllllllllIlIII), DrawHelper.lerp((float)lIllllllllIIlll.getBlue() / 255.0f, (float)lIllllllllIlIll.getBlue() / 255.0f, lIllllllllIlIII));
    }

    public static int[] getFractionIndicies(float[] llIIIIIIIlIlIll, float llIIIIIIIlIIllI) {
        int llIIIIIIIlIlIIl;
        int[] llIIIIIIIlIlIII = new int[2];
        for (llIIIIIIIlIlIIl = 0; llIIIIIIIlIlIIl < llIIIIIIIlIlIll.length && llIIIIIIIlIlIll[llIIIIIIIlIlIIl] <= llIIIIIIIlIIllI; ++llIIIIIIIlIlIIl) {
        }
        if (llIIIIIIIlIlIIl >= llIIIIIIIlIlIll.length) {
            llIIIIIIIlIlIIl = llIIIIIIIlIlIll.length - 1;
        }
        llIIIIIIIlIlIII[0] = llIIIIIIIlIlIIl - 1;
        llIIIIIIIlIlIII[1] = llIIIIIIIlIlIIl;
        return llIIIIIIIlIlIII;
    }

    public static Color rainbow2(int llIIIIIllIllIll, float llIIIIIllIllIlI, float llIIIIIllIlIlIl) {
        double llIIIIIllIllIII = Math.ceil((System.currentTimeMillis() + (long)llIIIIIllIllIll) / 16L);
        return Color.getHSBColor((float)((llIIIIIllIllIII %= 360.0) / 360.0), llIIIIIllIllIlI, llIIIIIllIlIlIl);
    }

    public static void drawImage(ResourceLocation llIIIlIIllllIII, int llIIIlIIlllIlll, int llIIIlIIlllllII, int llIIIlIIlllIlIl, int llIIIlIIllllIlI, int llIIIlIIlllIIll) {
        GL11.glPushMatrix();
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        OpenGlHelper.glBlendFunc((int)770, (int)771, (int)1, (int)0);
        DrawHelper.setColor(llIIIlIIlllIIll);
        mc.getTextureManager().bindTexture(llIIIlIIllllIII);
        GL11.glTexParameteri((int)3553, (int)10240, (int)9729);
        GL11.glTexParameteri((int)3553, (int)10241, (int)9729);
        Gui.drawModalRectWithCustomSizedTexture((int)llIIIlIIlllIlll, (int)llIIIlIIlllllII, (float)0.0f, (float)0.0f, (int)llIIIlIIlllIlIl, (int)llIIIlIIllllIlI, (float)llIIIlIIlllIlIl, (float)llIIIlIIllllIlI);
        GL11.glDepthMask((boolean)true);
        GL11.glEnable((int)2929);
        GL11.glPopMatrix();
    }

    public static void prepareScissorBox(float llIIIIllIlIllII, float llIIIIllIlIlIll, float llIIIIllIlIlIlI, float llIIIIllIlIllll) {
        ScaledResolution llIIIIllIlIlllI = new ScaledResolution(Minecraft.getMinecraft());
        int llIIIIllIlIllIl = llIIIIllIlIlllI.getScaleFactor();
        GL11.glScissor((int)((int)(llIIIIllIlIllII * (float)llIIIIllIlIllIl)), (int)((int)(((float)llIIIIllIlIlllI.getScaledHeight() - llIIIIllIlIllll) * (float)llIIIIllIlIllIl)), (int)((int)((llIIIIllIlIlIlI - llIIIIllIlIllII) * (float)llIIIIllIlIllIl)), (int)((int)((llIIIIllIlIllll - llIIIIllIlIlIll) * (float)llIIIIllIlIllIl)));
    }

    public static Color astolfoColor(int lIlllllllIlIIlI, int lIlllllllIIllIl) {
        float lIlllllllIIllll;
        float lIlllllllIlIIII = 2900.0f;
        for (lIlllllllIIllll = (float)(System.currentTimeMillis() % (long)((int)lIlllllllIlIIII)) + (float)((lIlllllllIIllIl - lIlllllllIlIIlI) * 9); lIlllllllIIllll > lIlllllllIlIIII; lIlllllllIIllll -= lIlllllllIlIIII) {
        }
        if ((double)(lIlllllllIIllll /= lIlllllllIlIIII) > 0.5) {
            lIlllllllIIllll = 0.5f - (lIlllllllIIllll - 0.5f);
        }
        return new Color(lIlllllllIIllll += 0.5f, 0.5f, 1.0f);
    }

    static {
        mc = Minecraft.getMinecraft();
        frustrum = new Frustum();
    }

    public static void drawFilledBox(AxisAlignedBB llIIIlIlIIlllll) {
        Tessellator llIIIlIlIlIIIIl = Tessellator.getInstance();
        BufferBuilder llIIIlIlIlIIIII = llIIIlIlIlIIIIl.getBuffer();
        llIIIlIlIlIIIII.begin(7, DefaultVertexFormats.POSITION);
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.minX, llIIIlIlIIlllll.minY, llIIIlIlIIlllll.minZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.minX, llIIIlIlIIlllll.maxY, llIIIlIlIIlllll.minZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.maxX, llIIIlIlIIlllll.minY, llIIIlIlIIlllll.minZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.maxX, llIIIlIlIIlllll.maxY, llIIIlIlIIlllll.minZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.maxX, llIIIlIlIIlllll.minY, llIIIlIlIIlllll.maxZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.maxX, llIIIlIlIIlllll.maxY, llIIIlIlIIlllll.maxZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.minX, llIIIlIlIIlllll.minY, llIIIlIlIIlllll.maxZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.minX, llIIIlIlIIlllll.maxY, llIIIlIlIIlllll.maxZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.maxX, llIIIlIlIIlllll.maxY, llIIIlIlIIlllll.minZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.maxX, llIIIlIlIIlllll.minY, llIIIlIlIIlllll.minZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.minX, llIIIlIlIIlllll.maxY, llIIIlIlIIlllll.minZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.minX, llIIIlIlIIlllll.minY, llIIIlIlIIlllll.minZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.minX, llIIIlIlIIlllll.maxY, llIIIlIlIIlllll.maxZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.minX, llIIIlIlIIlllll.minY, llIIIlIlIIlllll.maxZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.maxX, llIIIlIlIIlllll.maxY, llIIIlIlIIlllll.maxZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.maxX, llIIIlIlIIlllll.minY, llIIIlIlIIlllll.maxZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.minX, llIIIlIlIIlllll.maxY, llIIIlIlIIlllll.minZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.maxX, llIIIlIlIIlllll.maxY, llIIIlIlIIlllll.minZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.maxX, llIIIlIlIIlllll.maxY, llIIIlIlIIlllll.maxZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.minX, llIIIlIlIIlllll.maxY, llIIIlIlIIlllll.maxZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.minX, llIIIlIlIIlllll.maxY, llIIIlIlIIlllll.minZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.minX, llIIIlIlIIlllll.maxY, llIIIlIlIIlllll.maxZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.maxX, llIIIlIlIIlllll.maxY, llIIIlIlIIlllll.maxZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.maxX, llIIIlIlIIlllll.maxY, llIIIlIlIIlllll.minZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.minX, llIIIlIlIIlllll.minY, llIIIlIlIIlllll.minZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.maxX, llIIIlIlIIlllll.minY, llIIIlIlIIlllll.minZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.maxX, llIIIlIlIIlllll.minY, llIIIlIlIIlllll.maxZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.minX, llIIIlIlIIlllll.minY, llIIIlIlIIlllll.maxZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.minX, llIIIlIlIIlllll.minY, llIIIlIlIIlllll.minZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.minX, llIIIlIlIIlllll.minY, llIIIlIlIIlllll.maxZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.maxX, llIIIlIlIIlllll.minY, llIIIlIlIIlllll.maxZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.maxX, llIIIlIlIIlllll.minY, llIIIlIlIIlllll.minZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.minX, llIIIlIlIIlllll.minY, llIIIlIlIIlllll.minZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.minX, llIIIlIlIIlllll.maxY, llIIIlIlIIlllll.minZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.minX, llIIIlIlIIlllll.minY, llIIIlIlIIlllll.maxZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.minX, llIIIlIlIIlllll.maxY, llIIIlIlIIlllll.maxZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.maxX, llIIIlIlIIlllll.minY, llIIIlIlIIlllll.maxZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.maxX, llIIIlIlIIlllll.maxY, llIIIlIlIIlllll.maxZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.maxX, llIIIlIlIIlllll.minY, llIIIlIlIIlllll.minZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.maxX, llIIIlIlIIlllll.maxY, llIIIlIlIIlllll.minZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.minX, llIIIlIlIIlllll.maxY, llIIIlIlIIlllll.maxZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.minX, llIIIlIlIIlllll.minY, llIIIlIlIIlllll.maxZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.minX, llIIIlIlIIlllll.maxY, llIIIlIlIIlllll.minZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.minX, llIIIlIlIIlllll.minY, llIIIlIlIIlllll.minZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.maxX, llIIIlIlIIlllll.maxY, llIIIlIlIIlllll.minZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.maxX, llIIIlIlIIlllll.minY, llIIIlIlIIlllll.minZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.maxX, llIIIlIlIIlllll.maxY, llIIIlIlIIlllll.maxZ).endVertex();
        llIIIlIlIlIIIII.pos(llIIIlIlIIlllll.maxX, llIIIlIlIIlllll.minY, llIIIlIlIIlllll.maxZ).endVertex();
        llIIIlIlIlIIIIl.draw();
    }

    public static void drawOutline(AxisAlignedBB llIIIlIllIIIlll, float llIIIlIllIIIIIl, Color llIIIlIllIIIlIl) {
        GL11.glPushMatrix();
        GL11.glLineWidth((float)llIIIlIllIIIIIl);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2929);
        Tessellator llIIIlIllIIIlII = Tessellator.getInstance();
        BufferBuilder llIIIlIllIIIIll = llIIIlIllIIIlII.getBuffer();
        llIIIlIllIIIIll.begin(3, DefaultVertexFormats.POSITION_COLOR);
        llIIIlIllIIIIll.pos(llIIIlIllIIIlll.minX, llIIIlIllIIIlll.minY, llIIIlIllIIIlll.minZ).color(llIIIlIllIIIlIl.getRed(), llIIIlIllIIIlIl.getGreen(), llIIIlIllIIIlIl.getBlue(), 100).endVertex();
        llIIIlIllIIIIll.pos(llIIIlIllIIIlll.minX, llIIIlIllIIIlll.minY, llIIIlIllIIIlll.maxZ).color(llIIIlIllIIIlIl.getRed(), llIIIlIllIIIlIl.getGreen(), llIIIlIllIIIlIl.getBlue(), 100).endVertex();
        llIIIlIllIIIIll.pos(llIIIlIllIIIlll.maxX, llIIIlIllIIIlll.minY, llIIIlIllIIIlll.maxZ).color(llIIIlIllIIIlIl.getRed(), llIIIlIllIIIlIl.getGreen(), llIIIlIllIIIlIl.getBlue(), 100).endVertex();
        llIIIlIllIIIIll.pos(llIIIlIllIIIlll.maxX, llIIIlIllIIIlll.minY, llIIIlIllIIIlll.minZ).color(llIIIlIllIIIlIl.getRed(), llIIIlIllIIIlIl.getGreen(), llIIIlIllIIIlIl.getBlue(), 100).endVertex();
        llIIIlIllIIIIll.pos(llIIIlIllIIIlll.minX, llIIIlIllIIIlll.minY, llIIIlIllIIIlll.minZ).color(llIIIlIllIIIlIl.getRed(), llIIIlIllIIIlIl.getGreen(), llIIIlIllIIIlIl.getBlue(), 100).endVertex();
        llIIIlIllIIIIll.pos(llIIIlIllIIIlll.minX, llIIIlIllIIIlll.maxY, llIIIlIllIIIlll.minZ).color(llIIIlIllIIIlIl.getRed(), llIIIlIllIIIlIl.getGreen(), llIIIlIllIIIlIl.getBlue(), 100).endVertex();
        llIIIlIllIIIIll.pos(llIIIlIllIIIlll.minX, llIIIlIllIIIlll.maxY, llIIIlIllIIIlll.maxZ).color(llIIIlIllIIIlIl.getRed(), llIIIlIllIIIlIl.getGreen(), llIIIlIllIIIlIl.getBlue(), 100).endVertex();
        llIIIlIllIIIIll.pos(llIIIlIllIIIlll.minX, llIIIlIllIIIlll.minY, llIIIlIllIIIlll.maxZ).color(llIIIlIllIIIlIl.getRed(), llIIIlIllIIIlIl.getGreen(), llIIIlIllIIIlIl.getBlue(), 100).endVertex();
        llIIIlIllIIIIll.pos(llIIIlIllIIIlll.maxX, llIIIlIllIIIlll.minY, llIIIlIllIIIlll.maxZ).color(llIIIlIllIIIlIl.getRed(), llIIIlIllIIIlIl.getGreen(), llIIIlIllIIIlIl.getBlue(), 100).endVertex();
        llIIIlIllIIIIll.pos(llIIIlIllIIIlll.maxX, llIIIlIllIIIlll.maxY, llIIIlIllIIIlll.maxZ).color(llIIIlIllIIIlIl.getRed(), llIIIlIllIIIlIl.getGreen(), llIIIlIllIIIlIl.getBlue(), 100).endVertex();
        llIIIlIllIIIIll.pos(llIIIlIllIIIlll.minX, llIIIlIllIIIlll.maxY, llIIIlIllIIIlll.maxZ).color(llIIIlIllIIIlIl.getRed(), llIIIlIllIIIlIl.getGreen(), llIIIlIllIIIlIl.getBlue(), 100).endVertex();
        llIIIlIllIIIIll.pos(llIIIlIllIIIlll.maxX, llIIIlIllIIIlll.maxY, llIIIlIllIIIlll.maxZ).color(llIIIlIllIIIlIl.getRed(), llIIIlIllIIIlIl.getGreen(), llIIIlIllIIIlIl.getBlue(), 100).endVertex();
        llIIIlIllIIIIll.pos(llIIIlIllIIIlll.maxX, llIIIlIllIIIlll.maxY, llIIIlIllIIIlll.minZ).color(llIIIlIllIIIlIl.getRed(), llIIIlIllIIIlIl.getGreen(), llIIIlIllIIIlIl.getBlue(), 100).endVertex();
        llIIIlIllIIIIll.pos(llIIIlIllIIIlll.maxX, llIIIlIllIIIlll.minY, llIIIlIllIIIlll.minZ).color(llIIIlIllIIIlIl.getRed(), llIIIlIllIIIlIl.getGreen(), llIIIlIllIIIlIl.getBlue(), 100).endVertex();
        llIIIlIllIIIIll.pos(llIIIlIllIIIlll.maxX, llIIIlIllIIIlll.maxY, llIIIlIllIIIlll.minZ).color(llIIIlIllIIIlIl.getRed(), llIIIlIllIIIlIl.getGreen(), llIIIlIllIIIlIl.getBlue(), 100).endVertex();
        llIIIlIllIIIIll.pos(llIIIlIllIIIlll.minX, llIIIlIllIIIlll.maxY, llIIIlIllIIIlll.minZ).color(llIIIlIllIIIlIl.getRed(), llIIIlIllIIIlIl.getGreen(), llIIIlIllIIIlIl.getBlue(), 100).endVertex();
        llIIIlIllIIIlII.draw();
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2929);
        GL11.glPopMatrix();
    }

    public static int getColor(int llIIIIIIllIllII, int llIIIIIIllIIllI, int llIIIIIIllIlIlI, int llIIIIIIllIIlII) {
        int llIIIIIIllIlIII = 0;
        llIIIIIIllIlIII |= llIIIIIIllIIlII << 24;
        llIIIIIIllIlIII |= llIIIIIIllIllII << 16;
        llIIIIIIllIlIII |= llIIIIIIllIIllI << 8;
        return llIIIIIIllIlIII |= llIIIIIIllIlIlI;
    }

    public static int rainbow(int llIIIIIllllIIII, float llIIIIIlllIlIll, float llIIIIIlllIlIlI) {
        double llIIIIIlllIllIl = Math.ceil((System.currentTimeMillis() + (long)llIIIIIllllIIII) / 16L);
        return Color.getHSBColor((float)((llIIIIIlllIllIl %= 360.0) / 360.0), llIIIIIlllIlIll, llIIIIIlllIlIlI).getRGB();
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

    public static Color getRainbow(int llIIIIIlllIIlIl, int llIIIIIlllIIlII) {
        float llIIIIIlllIIIll = (System.currentTimeMillis() + (long)llIIIIIlllIIlIl) % (long)llIIIIIlllIIlII;
        return Color.getHSBColor(llIIIIIlllIIIll /= (float)llIIIIIlllIIlII, 0.7f, 1.0f);
    }

    public static float lerp(float lIlllllIllIIIIl, float lIlllllIllIIIll, float lIlllllIllIIIlI) {
        return lIlllllIllIIIIl + lIlllllIllIIIlI * (lIlllllIllIIIll - lIlllllIllIIIIl);
    }

    public static void glColor(Color llIIIlIlIIIlIll, int llIIIlIlIIIlIlI) {
        DrawHelper.glColor(llIIIlIlIIIlIll, (float)llIIIlIlIIIlIlI / 255.0f);
    }

    public static void endSmooth() {
        GL11.glDisable((int)2848);
        GL11.glDisable((int)2881);
        GL11.glEnable((int)2832);
    }

    public static void drawGradientSideways(double lIllllllIllllII, double lIllllllIlIllIl, double lIllllllIlIllII, double lIllllllIlIlIll, int lIllllllIlllIII, int lIllllllIlIlIIl) {
        float lIllllllIllIllI = (float)(lIllllllIlllIII >> 24 & 0xFF) / 255.0f;
        float lIllllllIllIlIl = (float)(lIllllllIlllIII >> 16 & 0xFF) / 255.0f;
        float lIllllllIllIlII = (float)(lIllllllIlllIII >> 8 & 0xFF) / 255.0f;
        float lIllllllIllIIll = (float)(lIllllllIlllIII & 0xFF) / 255.0f;
        float lIllllllIllIIlI = (float)(lIllllllIlIlIIl >> 24 & 0xFF) / 255.0f;
        float lIllllllIllIIIl = (float)(lIllllllIlIlIIl >> 16 & 0xFF) / 255.0f;
        float lIllllllIllIIII = (float)(lIllllllIlIlIIl >> 8 & 0xFF) / 255.0f;
        float lIllllllIlIllll = (float)(lIllllllIlIlIIl & 0xFF) / 255.0f;
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GL11.glShadeModel((int)7425);
        GL11.glPushMatrix();
        GL11.glBegin((int)7);
        GL11.glColor4f((float)lIllllllIllIlIl, (float)lIllllllIllIlII, (float)lIllllllIllIIll, (float)lIllllllIllIllI);
        GL11.glVertex2d((double)lIllllllIllllII, (double)lIllllllIlIllIl);
        GL11.glVertex2d((double)lIllllllIllllII, (double)lIllllllIlIlIll);
        GL11.glColor4f((float)lIllllllIllIIIl, (float)lIllllllIllIIII, (float)lIllllllIlIllll, (float)lIllllllIllIIlI);
        GL11.glVertex2d((double)lIllllllIlIllII, (double)lIllllllIlIlIll);
        GL11.glVertex2d((double)lIllllllIlIllII, (double)lIllllllIlIllIl);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
    }

    public static void disableGL2D() {
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2929);
        GL11.glDisable((int)2848);
        GL11.glHint((int)3154, (int)4352);
        GL11.glHint((int)3155, (int)4352);
    }

    public static void drawVGradientRect(float llIIIIllllllIII, float llIIIIlllllIlll, float llIIIlIIIIIIllI, float llIIIIlllllIlIl, int llIIIIlllllIlII, int llIIIIlllllIIll) {
        float llIIIlIIIIIIIlI = (float)(llIIIIlllllIlII >> 24 & 0xFF) / 255.0f;
        float llIIIlIIIIIIIIl = (float)(llIIIIlllllIlII >> 16 & 0xFF) / 255.0f;
        float llIIIlIIIIIIIII = (float)(llIIIIlllllIlII >> 8 & 0xFF) / 255.0f;
        float llIIIIlllllllll = (float)(llIIIIlllllIlII & 0xFF) / 255.0f;
        float llIIIIllllllllI = (float)(llIIIIlllllIIll >> 24 & 0xFF) / 255.0f;
        float llIIIIlllllllIl = (float)(llIIIIlllllIIll >> 16 & 0xFF) / 255.0f;
        float llIIIIlllllllII = (float)(llIIIIlllllIIll >> 8 & 0xFF) / 255.0f;
        float llIIIIllllllIll = (float)(llIIIIlllllIIll & 0xFF) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int)7425);
        Tessellator llIIIIllllllIlI = Tessellator.getInstance();
        BufferBuilder llIIIIllllllIIl = llIIIIllllllIlI.getBuffer();
        llIIIIllllllIIl.begin(7, DefaultVertexFormats.POSITION_COLOR);
        llIIIIllllllIIl.pos((double)llIIIlIIIIIIllI, (double)llIIIIlllllIlll, 0.0).color(llIIIlIIIIIIIIl, llIIIlIIIIIIIII, llIIIIlllllllll, llIIIlIIIIIIIlI).endVertex();
        llIIIIllllllIIl.pos((double)llIIIIllllllIII, (double)llIIIIlllllIlll, 0.0).color(llIIIlIIIIIIIIl, llIIIlIIIIIIIII, llIIIIlllllllll, llIIIlIIIIIIIlI).endVertex();
        llIIIIllllllIIl.pos((double)llIIIIllllllIII, (double)llIIIIlllllIlIl, 0.0).color(llIIIIlllllllIl, llIIIIlllllllII, llIIIIllllllIll, llIIIIllllllllI).endVertex();
        llIIIIllllllIIl.pos((double)llIIIlIIIIIIllI, (double)llIIIIlllllIlIl, 0.0).color(llIIIIlllllllIl, llIIIIlllllllII, llIIIIllllllIll, llIIIIllllllllI).endVertex();
        llIIIIllllllIlI.draw();
        GlStateManager.shadeModel((int)7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    public static int getColor(int llIIIIIIllIIIII) {
        return DrawHelper.getColor(llIIIIIIllIIIII, llIIIIIIllIIIII, llIIIIIIllIIIII, 255);
    }

    public static Color blend(Color llIIIIIIIIIlIlI, Color llIIIIIIIIIlIIl, double llIIIIIIIIIlIII) {
        float llIIIIIIIIlIIlI = (float)llIIIIIIIIIlIII;
        float llIIIIIIIIlIIIl = 1.0f - llIIIIIIIIlIIlI;
        float[] llIIIIIIIIlIIII = new float[3];
        float[] llIIIIIIIIIllll = new float[3];
        llIIIIIIIIIlIlI.getColorComponents(llIIIIIIIIlIIII);
        llIIIIIIIIIlIIl.getColorComponents(llIIIIIIIIIllll);
        float llIIIIIIIIIlllI = llIIIIIIIIlIIII[0] * llIIIIIIIIlIIlI + llIIIIIIIIIllll[0] * llIIIIIIIIlIIIl;
        float llIIIIIIIIIllIl = llIIIIIIIIlIIII[1] * llIIIIIIIIlIIlI + llIIIIIIIIIllll[1] * llIIIIIIIIlIIIl;
        float llIIIIIIIIIllII = llIIIIIIIIlIIII[2] * llIIIIIIIIlIIlI + llIIIIIIIIIllll[2] * llIIIIIIIIlIIIl;
        if (llIIIIIIIIIlllI < 0.0f) {
            llIIIIIIIIIlllI = 0.0f;
        } else if (llIIIIIIIIIlllI > 255.0f) {
            llIIIIIIIIIlllI = 255.0f;
        }
        if (llIIIIIIIIIllIl < 0.0f) {
            llIIIIIIIIIllIl = 0.0f;
        } else if (llIIIIIIIIIllIl > 255.0f) {
            llIIIIIIIIIllIl = 255.0f;
        }
        if (llIIIIIIIIIllII < 0.0f) {
            llIIIIIIIIIllII = 0.0f;
        } else if (llIIIIIIIIIllII > 255.0f) {
            llIIIIIIIIIllII = 255.0f;
        }
        Color llIIIIIIIIIlIll = null;
        try {
            llIIIIIIIIIlIll = new Color(llIIIIIIIIIlllI, llIIIIIIIIIllIl, llIIIIIIIIIllII);
        }
        catch (IllegalArgumentException llIIIIIIIIlIllI) {
            NumberFormat lIllllllllllllI = NumberFormat.getNumberInstance();
        }
        return llIIIIIIIIIlIll;
    }

    public static void drawNewRect(double llIIIIlIIlllIIl, double llIIIIlIIlIllIl, double llIIIIlIIllIlll, double llIIIIlIIllIllI, int llIIIIlIIlIlIlI) {
        if (llIIIIlIIlllIIl < llIIIIlIIllIlll) {
            double llIIIIlIIlllIll = llIIIIlIIlllIIl;
            llIIIIlIIlllIIl = llIIIIlIIllIlll;
            llIIIIlIIllIlll = llIIIIlIIlllIll;
        }
        if (llIIIIlIIlIllIl < llIIIIlIIllIllI) {
            double llIIIIlIIlllIlI = llIIIIlIIlIllIl;
            llIIIIlIIlIllIl = llIIIIlIIllIllI;
            llIIIIlIIllIllI = llIIIIlIIlllIlI;
        }
        float llIIIIlIIllIlII = (float)(llIIIIlIIlIlIlI >> 24 & 0xFF) / 255.0f;
        float llIIIIlIIllIIll = (float)(llIIIIlIIlIlIlI >> 16 & 0xFF) / 255.0f;
        float llIIIIlIIllIIlI = (float)(llIIIIlIIlIlIlI >> 8 & 0xFF) / 255.0f;
        float llIIIIlIIllIIIl = (float)(llIIIIlIIlIlIlI & 0xFF) / 255.0f;
        Tessellator llIIIIlIIllIIII = Tessellator.getInstance();
        BufferBuilder llIIIIlIIlIllll = llIIIIlIIllIIII.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.color((float)llIIIIlIIllIIll, (float)llIIIIlIIllIIlI, (float)llIIIIlIIllIIIl, (float)llIIIIlIIllIlII);
        llIIIIlIIlIllll.begin(7, DefaultVertexFormats.POSITION);
        llIIIIlIIlIllll.pos(llIIIIlIIlllIIl, llIIIIlIIllIllI, 0.0).endVertex();
        llIIIIlIIlIllll.pos(llIIIIlIIllIlll, llIIIIlIIllIllI, 0.0).endVertex();
        llIIIIlIIlIllll.pos(llIIIIlIIllIlll, llIIIIlIIlIllIl, 0.0).endVertex();
        llIIIIlIIlIllll.pos(llIIIIlIIlllIIl, llIIIIlIIlIllIl, 0.0).endVertex();
        llIIIIlIIllIIII.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void glColor(Color llIIIlIlIIlIlll, float llIIIlIlIIlIIIl) {
        float llIIIlIlIIlIlIl = (float)llIIIlIlIIlIlll.getRed() / 255.0f;
        float llIIIlIlIIlIlII = (float)llIIIlIlIIlIlll.getGreen() / 255.0f;
        float llIIIlIlIIlIIll = (float)llIIIlIlIIlIlll.getBlue() / 255.0f;
        GlStateManager.color((float)llIIIlIlIIlIlIl, (float)llIIIlIlIIlIlII, (float)llIIIlIlIIlIIll, (float)llIIIlIlIIlIIIl);
    }

    public static Color fade(Color llIIIIIIlIIllll, int llIIIIIIlIIlllI, int llIIIIIIlIIllIl) {
        float[] llIIIIIIlIlIIIl = new float[3];
        Color.RGBtoHSB(llIIIIIIlIIllll.getRed(), llIIIIIIlIIllll.getGreen(), llIIIIIIlIIllll.getBlue(), llIIIIIIlIlIIIl);
        float llIIIIIIlIlIIII = Math.abs(((float)(System.currentTimeMillis() % 2000L) / 1000.0f + (float)llIIIIIIlIIlllI / (float)llIIIIIIlIIllIl * 2.0f) % 2.0f - 1.0f);
        llIIIIIIlIlIIII = 0.5f + 0.5f * llIIIIIIlIlIIII;
        llIIIIIIlIlIIIl[2] = llIIIIIIlIlIIII % 2.0f;
        return new Color(Color.HSBtoRGB(llIIIIIIlIlIIIl[0], llIIIIIIlIlIIIl[1], llIIIIIIlIlIIIl[2]));
    }

    public static int setColor(int llIIIlIIllIllIl) {
        float llIIIlIIllIllII = (float)(llIIIlIIllIllIl >> 24 & 0xFF) / 255.0f;
        float llIIIlIIllIlIll = (float)(llIIIlIIllIllIl >> 16 & 0xFF) / 255.0f;
        float llIIIlIIllIlIlI = (float)(llIIIlIIllIllIl >> 8 & 0xFF) / 255.0f;
        float llIIIlIIllIlIIl = (float)(llIIIlIIllIllIl & 0xFF) / 255.0f;
        GL11.glColor4f((float)llIIIlIIllIlIll, (float)llIIIlIIllIlIlI, (float)llIIIlIIllIlIIl, (float)(llIIIlIIllIllII == 0.0f ? 1.0f : llIIIlIIllIllII));
        return llIIIlIIllIllIl;
    }

    public static Color getHealthColor(EntityLivingBase llIIIIIllIIlllI) {
        float llIIIIIllIIllIl = llIIIIIllIIlllI.getHealth();
        float[] llIIIIIllIIllII = new float[]{0.0f, 0.15f, 0.55f, 0.7f, 0.9f};
        Color[] llIIIIIllIIlIll = new Color[]{new Color(133, 0, 0), Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN};
        float llIIIIIllIIlIlI = llIIIIIllIIllIl / llIIIIIllIIlllI.getMaxHealth();
        return llIIIIIllIIllIl >= 0.0f ? DrawHelper.blendColors(llIIIIIllIIllII, llIIIIIllIIlIll, llIIIIIllIIlIlI).brighter() : llIIIIIllIIlIll[0];
    }

    public static void drawHead(ResourceLocation llIIIIlIlIllIlI, int llIIIIlIlIllllI, int llIIIIlIlIlllIl, int llIIIIlIlIlIlll, int llIIIIlIlIlIllI) {
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        mc.getTextureManager().bindTexture(llIIIIlIlIllIlI);
        Gui.drawScaledCustomSizeModalRect((int)llIIIIlIlIllllI, (int)llIIIIlIlIlllIl, (float)8.0f, (float)8.0f, (int)8, (int)8, (int)llIIIIlIlIlIlll, (int)llIIIIlIlIlIllI, (float)64.0f, (float)64.0f);
    }

    public static void drawFilledCircle(int llIIIIlllIIIlll, int llIIIIlllIIllII, float llIIIIlllIIIlIl, Color llIIIIlllIIlIlI) {
        int llIIIIlllIIlIIl = 50;
        double llIIIIlllIIlIII = Math.PI * 2 / (double)llIIIIlllIIlIIl;
        GL11.glPushAttrib((int)8192);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GL11.glBegin((int)6);
        for (int llIIIIlllIIlllI = 0; llIIIIlllIIlllI < llIIIIlllIIlIIl; ++llIIIIlllIIlllI) {
            float llIIIIlllIlIIII = (float)((double)llIIIIlllIIIlIl * Math.sin((double)llIIIIlllIIlllI * llIIIIlllIIlIII));
            float llIIIIlllIIllll = (float)((double)llIIIIlllIIIlIl * Math.cos((double)llIIIIlllIIlllI * llIIIIlllIIlIII));
            GL11.glColor4f((float)((float)llIIIIlllIIlIlI.getRed() / 255.0f), (float)((float)llIIIIlllIIlIlI.getGreen() / 255.0f), (float)((float)llIIIIlllIIlIlI.getBlue() / 255.0f), (float)((float)llIIIIlllIIlIlI.getAlpha() / 255.0f));
            GL11.glVertex2f((float)((float)llIIIIlllIIIlll + llIIIIlllIlIIII), (float)((float)llIIIIlllIIllII + llIIIIlllIIllll));
        }
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glEnd();
        GL11.glPopAttrib();
    }

    public static void drawGradientRect(double llIIIIllIIIIllI, double llIIIIllIIlIlIl, double llIIIIllIIlIlII, double llIIIIllIIlIIll, int llIIIIllIIIIIlI, int llIIIIllIIlIIIl) {
        float llIIIIllIIlIIII = (float)(llIIIIllIIIIIlI >> 24 & 0xFF) / 255.0f;
        float llIIIIllIIIllll = (float)(llIIIIllIIIIIlI >> 16 & 0xFF) / 255.0f;
        float llIIIIllIIIlllI = (float)(llIIIIllIIIIIlI >> 8 & 0xFF) / 255.0f;
        float llIIIIllIIIllIl = (float)(llIIIIllIIIIIlI & 0xFF) / 255.0f;
        float llIIIIllIIIllII = (float)(llIIIIllIIlIIIl >> 24 & 0xFF) / 255.0f;
        float llIIIIllIIIlIll = (float)(llIIIIllIIlIIIl >> 16 & 0xFF) / 255.0f;
        float llIIIIllIIIlIlI = (float)(llIIIIllIIlIIIl >> 8 & 0xFF) / 255.0f;
        float llIIIIllIIIlIIl = (float)(llIIIIllIIlIIIl & 0xFF) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int)7425);
        Tessellator llIIIIllIIIlIII = Tessellator.getInstance();
        BufferBuilder llIIIIllIIIIlll = llIIIIllIIIlIII.getBuffer();
        llIIIIllIIIIlll.begin(7, DefaultVertexFormats.POSITION_COLOR);
        llIIIIllIIIIlll.pos(llIIIIllIIlIlII, llIIIIllIIlIlIl, (double)zLevel).color(llIIIIllIIIllll, llIIIIllIIIlllI, llIIIIllIIIllIl, llIIIIllIIlIIII).endVertex();
        llIIIIllIIIIlll.pos(llIIIIllIIIIllI, llIIIIllIIlIlIl, (double)zLevel).color(llIIIIllIIIllll, llIIIIllIIIlllI, llIIIIllIIIllIl, llIIIIllIIlIIII).endVertex();
        llIIIIllIIIIlll.pos(llIIIIllIIIIllI, llIIIIllIIlIIll, (double)zLevel).color(llIIIIllIIIlIll, llIIIIllIIIlIlI, llIIIIllIIIlIIl, llIIIIllIIIllII).endVertex();
        llIIIIllIIIIlll.pos(llIIIIllIIlIlII, llIIIIllIIlIIll, (double)zLevel).color(llIIIIllIIIlIll, llIIIIllIIIlIlI, llIIIIllIIIlIIl, llIIIIllIIIllII).endVertex();
        llIIIIllIIIlIII.draw();
        GlStateManager.shadeModel((int)7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    public static int astolfoColors4(float lIllllllIIlIlIl, float lIllllllIIIllll, float lIllllllIIlIIll) {
        float lIllllllIIlIIIl;
        float lIllllllIIlIIlI = 1800.0f;
        for (lIllllllIIlIIIl = (float)(System.currentTimeMillis() % (long)((int)lIllllllIIlIIlI)) + (lIllllllIIIllll - lIllllllIIlIlIl) * 12.0f; lIllllllIIlIIIl > lIllllllIIlIIlI; lIllllllIIlIIIl -= lIllllllIIlIIlI) {
        }
        if ((double)(lIllllllIIlIIIl /= lIllllllIIlIIlI) > 0.5) {
            lIllllllIIlIIIl = 0.5f - (lIllllllIIlIIIl - 0.5f);
        }
        return Color.HSBtoRGB(lIllllllIIlIIIl += 0.5f, lIllllllIIlIIll, 1.0f);
    }

    public static Color setAlpha(Color llIIIIllIlllIlI, int llIIIIllIlllIIl) {
        llIIIIllIlllIIl = MathHelper.clamp((int)llIIIIllIlllIIl, (int)0, (int)255);
        return new Color(llIIIIllIlllIlI.getRed(), llIIIIllIlllIlI.getGreen(), llIIIIllIlllIlI.getBlue(), llIIIIllIlllIIl);
    }

    public static void drawPolygonPart(double llIIIlIIIlIlIll, double llIIIlIIIlIlIlI, int llIIIlIIIlllIlI, int llIIIlIIIlllIIl, int llIIIlIIIlIIlll, int llIIIlIIIllIlll) {
        float llIIIlIIIllIllI = (float)(llIIIlIIIlIIlll >> 24 & 0xFF) / 255.0f;
        float llIIIlIIIllIlIl = (float)(llIIIlIIIlIIlll >> 16 & 0xFF) / 255.0f;
        float llIIIlIIIllIlII = (float)(llIIIlIIIlIIlll >> 8 & 0xFF) / 255.0f;
        float llIIIlIIIllIIll = (float)(llIIIlIIIlIIlll & 0xFF) / 255.0f;
        float llIIIlIIIllIIlI = (float)(llIIIlIIIllIlll >> 24 & 0xFF) / 255.0f;
        float llIIIlIIIllIIIl = (float)(llIIIlIIIllIlll >> 16 & 0xFF) / 255.0f;
        float llIIIlIIIllIIII = (float)(llIIIlIIIllIlll >> 8 & 0xFF) / 255.0f;
        float llIIIlIIIlIllll = (float)(llIIIlIIIllIlll & 0xFF) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int)7425);
        Tessellator llIIIlIIIlIlllI = Tessellator.getInstance();
        BufferBuilder llIIIlIIIlIllIl = llIIIlIIIlIlllI.getBuffer();
        llIIIlIIIlIllIl.begin(6, DefaultVertexFormats.POSITION_COLOR);
        llIIIlIIIlIllIl.pos(llIIIlIIIlIlIll, llIIIlIIIlIlIlI, 0.0).color(llIIIlIIIllIlIl, llIIIlIIIllIlII, llIIIlIIIllIIll, llIIIlIIIllIllI).endVertex();
        double llIIIlIIIlIllII = Math.PI * 2;
        for (int llIIIlIIIllllIl = llIIIlIIIlllIIl * 90; llIIIlIIIllllIl <= llIIIlIIIlllIIl * 90 + 90; ++llIIIlIIIllllIl) {
            double llIIIlIIIlllllI = Math.PI * 2 * (double)llIIIlIIIllllIl / 360.0 + Math.toRadians(180.0);
            llIIIlIIIlIllIl.pos(llIIIlIIIlIlIll + Math.sin(llIIIlIIIlllllI) * (double)llIIIlIIIlllIlI, llIIIlIIIlIlIlI + Math.cos(llIIIlIIIlllllI) * (double)llIIIlIIIlllIlI, 0.0).color(llIIIlIIIllIIIl, llIIIlIIIllIIII, llIIIlIIIlIllll, llIIIlIIIllIIlI).endVertex();
        }
        llIIIlIIIlIlllI.draw();
        GlStateManager.shadeModel((int)7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    public static boolean isInViewFrustrum(Entity llIIIIlIllIlIll) {
        return DrawHelper.isInViewFrustrum(llIIIIlIllIlIll.getEntityBoundingBox()) || llIIIIlIllIlIll.ignoreFrustumCheck;
    }

    public static Color blendColors(float[] llIIIIIIlIIIIIl, Color[] llIIIIIIlIIIIII, float llIIIIIIIllllll) {
        if (llIIIIIIlIIIIIl == null) {
            throw new IllegalArgumentException("Fractions can't be null");
        }
        if (llIIIIIIlIIIIII == null) {
            throw new IllegalArgumentException("Colours can't be null");
        }
        if (llIIIIIIlIIIIIl.length != llIIIIIIlIIIIII.length) {
            throw new IllegalArgumentException("Fractions and colours must have equal number of elements");
        }
        int[] llIIIIIIIlllllI = DrawHelper.getFractionIndicies(llIIIIIIlIIIIIl, llIIIIIIIllllll);
        float[] llIIIIIIIllllIl = new float[]{llIIIIIIlIIIIIl[llIIIIIIIlllllI[0]], llIIIIIIlIIIIIl[llIIIIIIIlllllI[1]]};
        Color[] llIIIIIIIllllII = new Color[]{llIIIIIIlIIIIII[llIIIIIIIlllllI[0]], llIIIIIIlIIIIII[llIIIIIIIlllllI[1]]};
        float llIIIIIIIlllIll = llIIIIIIIllllIl[1] - llIIIIIIIllllIl[0];
        float llIIIIIIIlllIlI = llIIIIIIIllllll - llIIIIIIIllllIl[0];
        float llIIIIIIIlllIIl = llIIIIIIIlllIlI / llIIIIIIIlllIll;
        return DrawHelper.blend(llIIIIIIIllllII[0], llIIIIIIIllllII[1], 1.0f - llIIIIIIIlllIIl);
    }

    public static int astolfoColors(int lIlllllllIllIlI, int lIlllllllIllIIl) {
        float f;
        float lIlllllllIlllII;
        float lIlllllllIllIll = 2900.0f;
        for (lIlllllllIlllII = (float)(System.currentTimeMillis() % (long)((int)lIlllllllIllIll)) + (float)((lIlllllllIllIIl - lIlllllllIllIlI) * 9); lIlllllllIlllII > lIlllllllIllIll; lIlllllllIlllII -= lIlllllllIllIll) {
        }
        lIlllllllIlllII /= lIlllllllIllIll;
        if ((double)f > 0.5) {
            lIlllllllIlllII = 0.5f - (lIlllllllIlllII - 0.5f);
        }
        return Color.HSBtoRGB(lIlllllllIlllII += 0.5f, 0.5f, 1.0f);
    }

    public static final void drawSmoothRect(float llIIIlIlIlllIII, float llIIIlIlIllIIlI, float llIIIlIlIllIllI, float llIIIlIlIllIlIl, int llIIIlIlIlIllll) {
        GL11.glEnable((int)3042);
        GL11.glEnable((int)2848);
        DrawHelper.drawRect(llIIIlIlIlllIII, llIIIlIlIllIIlI, llIIIlIlIllIllI, llIIIlIlIllIlIl, llIIIlIlIlIllll);
        GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
        DrawHelper.drawRect(llIIIlIlIlllIII * 2.0f - 1.0f, llIIIlIlIllIIlI * 2.0f, llIIIlIlIlllIII * 2.0f, llIIIlIlIllIlIl * 2.0f - 1.0f, llIIIlIlIlIllll);
        DrawHelper.drawRect(llIIIlIlIlllIII * 2.0f, llIIIlIlIllIIlI * 2.0f - 1.0f, llIIIlIlIllIllI * 2.0f, llIIIlIlIllIIlI * 2.0f, llIIIlIlIlIllll);
        DrawHelper.drawRect(llIIIlIlIllIllI * 2.0f, llIIIlIlIllIIlI * 2.0f, llIIIlIlIllIllI * 2.0f + 1.0f, llIIIlIlIllIlIl * 2.0f - 1.0f, llIIIlIlIlIllll);
        DrawHelper.drawRect(llIIIlIlIlllIII * 2.0f, llIIIlIlIllIlIl * 2.0f - 1.0f, llIIIlIlIllIllI * 2.0f, llIIIlIlIllIlIl * 2.0f, llIIIlIlIlIllll);
        GL11.glDisable((int)3042);
        GL11.glScalef((float)2.0f, (float)2.0f, (float)2.0f);
    }

    public static Color astolfoColors45(float lIlllllIlllIIll, float lIlllllIlllIIlI, float lIlllllIlllIIIl, float lIlllllIllIlIlI) {
        float lIlllllIllIlllI;
        float lIlllllIllIllll = 1800.0f;
        for (lIlllllIllIlllI = (float)(System.currentTimeMillis() % (long)((int)lIlllllIllIllll)) + (lIlllllIlllIIlI - lIlllllIlllIIll) * lIlllllIllIlIlI; lIlllllIllIlllI > lIlllllIllIllll; lIlllllIllIlllI -= lIlllllIllIllll) {
        }
        if ((double)(lIlllllIllIlllI /= lIlllllIllIllll) > 0.5) {
            lIlllllIllIlllI = 0.5f - (lIlllllIllIlllI - 0.5f);
        }
        return Color.getHSBColor(lIlllllIllIlllI += 0.5f, lIlllllIlllIIIl, 1.0f);
    }

    public static int toRGBA(int llIIIIIlIIIlIlI, int llIIIIIlIIIlIIl, int llIIIIIlIIIllII, int llIIIIIlIIIlIll) {
        return (llIIIIIlIIIlIlI << 16) + (llIIIIIlIIIlIIl << 8) + (llIIIIIlIIIllII << 0) + (llIIIIIlIIIlIll << 24);
    }

    public static final void color(double llIIIIlllIlllIl, double llIIIIlllIlllII, double llIIIIlllIllIll, double llIIIIlllIllllI) {
        GL11.glColor4d((double)llIIIIlllIlllIl, (double)llIIIIlllIlllII, (double)llIIIIlllIllIll, (double)llIIIIlllIllllI);
    }

    public static int color(int llIIIIIlllllIII, int llIIIIIlllllIll, int llIIIIIllllIllI, int llIIIIIlllllIIl) {
        llIIIIIlllllIIl = 255;
        return new Color(llIIIIIlllllIII, llIIIIIlllllIll, llIIIIIllllIllI, llIIIIIlllllIIl).getRGB();
    }

    public static final void color(Color llIIIIllllIIllI) {
        if (llIIIIllllIIllI == null) {
            llIIIIllllIIllI = Color.white;
        }
        DrawHelper.color((float)llIIIIllllIIllI.getRed() / 255.0f, (float)llIIIIllllIIllI.getGreen() / 255.0f, (float)llIIIIllllIIllI.getBlue() / 255.0f, (float)llIIIIllllIIllI.getAlpha() / 255.0f);
    }

    public static void drawGlow(double llIIIlIIlIlllIl, double llIIIlIIlIlllII, double llIIIlIIlIllIll, double llIIIlIIlIllIlI, int llIIIlIIlIllIIl) {
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int)7425);
        DrawHelper.drawVGradientRect((int)llIIIlIIlIlllIl, (int)llIIIlIIlIlllII, (int)llIIIlIIlIllIll, (int)(llIIIlIIlIlllII + (llIIIlIIlIllIlI - llIIIlIIlIlllII) / 2.0), DrawHelper.setAlpha(new Color(llIIIlIIlIllIIl), 0).getRGB(), llIIIlIIlIllIIl);
        DrawHelper.drawVGradientRect((int)llIIIlIIlIlllIl, (int)(llIIIlIIlIlllII + (llIIIlIIlIllIlI - llIIIlIIlIlllII) / 2.0), (int)llIIIlIIlIllIll, (int)llIIIlIIlIllIlI, llIIIlIIlIllIIl, DrawHelper.setAlpha(new Color(llIIIlIIlIllIIl), 0).getRGB());
        int llIIIlIIlIllIII = (int)((llIIIlIIlIllIlI - llIIIlIIlIlllII) / 2.0);
        DrawHelper.drawPolygonPart(llIIIlIIlIlllIl, llIIIlIIlIlllII + (llIIIlIIlIllIlI - llIIIlIIlIlllII) / 2.0, llIIIlIIlIllIII, 0, llIIIlIIlIllIIl, DrawHelper.setAlpha(new Color(llIIIlIIlIllIIl), 0).getRGB());
        DrawHelper.drawPolygonPart(llIIIlIIlIlllIl, llIIIlIIlIlllII + (llIIIlIIlIllIlI - llIIIlIIlIlllII) / 2.0, llIIIlIIlIllIII, 1, llIIIlIIlIllIIl, DrawHelper.setAlpha(new Color(llIIIlIIlIllIIl), 0).getRGB());
        DrawHelper.drawPolygonPart(llIIIlIIlIllIll, llIIIlIIlIlllII + (llIIIlIIlIllIlI - llIIIlIIlIlllII) / 2.0, llIIIlIIlIllIII, 2, llIIIlIIlIllIIl, DrawHelper.setAlpha(new Color(llIIIlIIlIllIIl), 0).getRGB());
        DrawHelper.drawPolygonPart(llIIIlIIlIllIll, llIIIlIIlIlllII + (llIIIlIIlIllIlI - llIIIlIIlIlllII) / 2.0, llIIIlIIlIllIII, 3, llIIIlIIlIllIIl, DrawHelper.setAlpha(new Color(llIIIlIIlIllIIl), 0).getRGB());
        GlStateManager.shadeModel((int)7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    public static int astolfo(int lIlllllllllIlIl, float lIlllllllllIlII) {
        float f;
        float lIlllllllllIlll;
        float lIlllllllllIllI = 3000.0f;
        for (lIlllllllllIlll = Math.abs((float)(System.currentTimeMillis() % (long)lIlllllllllIlIl) + -lIlllllllllIlII / 21.0f * 2.0f); lIlllllllllIlll > lIlllllllllIllI; lIlllllllllIlll -= lIlllllllllIllI) {
        }
        lIlllllllllIlll /= lIlllllllllIllI;
        if ((double)f > 0.5) {
            lIlllllllllIlll = 0.5f - (lIlllllllllIlll - 0.5f);
        }
        return Color.HSBtoRGB(lIlllllllllIlll += 0.5f, 0.5f, 1.0f);
    }

    public static class Colors {
        public static final /* synthetic */ int RED;
        public static final /* synthetic */ int BLUE;
        public static final /* synthetic */ int BLACK;
        public static final /* synthetic */ int GRAY;
        public static final /* synthetic */ int DARK_RED;
        public static final /* synthetic */ int PURPLE;
        public static final /* synthetic */ int ORANGE;
        public static final /* synthetic */ int RAINBOW;
        public static final /* synthetic */ int WHITE;
        public static final /* synthetic */ int YELLOW;
        public static final /* synthetic */ int GREEN;

        public Colors() {
            Colors llIlIIIIlIlllIl;
        }

        static {
            RAINBOW = Integer.MIN_VALUE;
            WHITE = DrawHelper.toRGBA(255, 255, 255, 255);
            BLACK = DrawHelper.toRGBA(0, 0, 0, 255);
            RED = DrawHelper.toRGBA(255, 0, 0, 255);
            GREEN = DrawHelper.toRGBA(0, 255, 0, 255);
            BLUE = DrawHelper.toRGBA(0, 0, 255, 255);
            ORANGE = DrawHelper.toRGBA(255, 128, 0, 255);
            PURPLE = DrawHelper.toRGBA(163, 73, 163, 255);
            GRAY = DrawHelper.toRGBA(127, 127, 127, 255);
            DARK_RED = DrawHelper.toRGBA(64, 0, 0, 255);
            YELLOW = DrawHelper.toRGBA(255, 255, 0, 255);
        }
    }
}

