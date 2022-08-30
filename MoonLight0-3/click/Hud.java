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
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.NonNullList
 *  net.minecraftforge.client.event.RenderGameOverlayEvent
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.opengl.GL11
 */
package click;

import click.font.GlyphPageFontRenderer;
import java.awt.Color;
import java.awt.Point;
import java.text.DecimalFormat;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import ru.internali.utils.TimerUtil;

public class Hud
extends Gui {
    private /* synthetic */ String toAdd;
    public static /* synthetic */ GlyphPageFontRenderer targetRenderer;
    public static /* synthetic */ GlyphPageFontRenderer smallRenderer;
    public /* synthetic */ TimerUtil timerUtil;
    public static /* synthetic */ GlyphPageFontRenderer renderer;
    public static /* synthetic */ GlyphPageFontRenderer myRenderer;
    public /* synthetic */ Random random;
    public /* synthetic */ DecimalFormat df;
    private /* synthetic */ Minecraft mc;
    public static /* synthetic */ GlyphPageFontRenderer fuckrenderer;

    public static void drawBorderedCircle(double lIIllIIllIllIll, double lIIllIIllIllIlI, float lIIllIIllIllIIl, int lIIllIIllIlIIlI, int lIIllIIllIlIlll) {
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GL11.glPushMatrix();
        float lIIllIIllIlIllI = 0.1f;
        GL11.glScalef((float)lIIllIIllIlIllI, (float)lIIllIIllIlIllI, (float)lIIllIIllIlIllI);
        lIIllIIllIllIll = (int)(lIIllIIllIllIll * (double)(1.0f / lIIllIIllIlIllI));
        lIIllIIllIllIlI = (int)(lIIllIIllIllIlI * (double)(1.0f / lIIllIIllIlIllI));
        Hud.drawCircle(lIIllIIllIllIll, lIIllIIllIllIlI, lIIllIIllIllIIl *= 1.0f / lIIllIIllIlIllI, lIIllIIllIlIlll);
        Hud.drawUnfilledCircle(lIIllIIllIllIll, lIIllIIllIllIlI, lIIllIIllIllIIl, 1.0f, lIIllIIllIlIIlI);
        GL11.glScalef((float)(1.0f / lIIllIIllIlIllI), (float)(1.0f / lIIllIIllIlIllI), (float)(1.0f / lIIllIIllIlIllI));
        GL11.glPopMatrix();
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glDisable((int)2848);
    }

    public static void drawCustomRect(float lIIllIIIllIIIll, float lIIllIIIlIlIlll, float lIIllIIIlIlIllI, float lIIllIIIlIlIlIl, int lIIllIIIlIlIlII) {
        if (lIIllIIIllIIIll < lIIllIIIlIlIllI) {
            float lIIllIIIllIIlIl = lIIllIIIllIIIll;
            lIIllIIIllIIIll = lIIllIIIlIlIllI;
            lIIllIIIlIlIllI = lIIllIIIllIIlIl;
        }
        if (lIIllIIIlIlIlll < lIIllIIIlIlIlIl) {
            float lIIllIIIllIIlII = lIIllIIIlIlIlll;
            lIIllIIIlIlIlll = lIIllIIIlIlIlIl;
            lIIllIIIlIlIlIl = lIIllIIIllIIlII;
        }
        float lIIllIIIlIllllI = (float)(lIIllIIIlIlIlII >> 24 & 0xFF) / 255.0f;
        float lIIllIIIlIlllIl = (float)(lIIllIIIlIlIlII >> 16 & 0xFF) / 255.0f;
        float lIIllIIIlIlllII = (float)(lIIllIIIlIlIlII >> 8 & 0xFF) / 255.0f;
        float lIIllIIIlIllIll = (float)(lIIllIIIlIlIlII & 0xFF) / 255.0f;
        Tessellator lIIllIIIlIllIlI = Tessellator.getInstance();
        BufferBuilder lIIllIIIlIllIIl = lIIllIIIlIllIlI.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.color((float)lIIllIIIlIlllIl, (float)lIIllIIIlIlllII, (float)lIIllIIIlIllIll, (float)lIIllIIIlIllllI);
        lIIllIIIlIllIIl.begin(7, DefaultVertexFormats.POSITION);
        lIIllIIIlIllIIl.pos((double)lIIllIIIllIIIll, (double)lIIllIIIlIlIlIl, 0.0).endVertex();
        lIIllIIIlIllIIl.pos((double)lIIllIIIlIlIllI, (double)lIIllIIIlIlIlIl, 0.0).endVertex();
        lIIllIIIlIllIIl.pos((double)lIIllIIIlIlIllI, (double)lIIllIIIlIlIlll, 0.0).endVertex();
        lIIllIIIlIllIIl.pos((double)lIIllIIIllIIIll, (double)lIIllIIIlIlIlll, 0.0).endVertex();
        lIIllIIIlIllIlI.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        Hud.drawRect(lIIllIIIllIIIll - 1.0f, lIIllIIIlIlIlll - 1.0f, lIIllIIIllIIIll, lIIllIIIlIlIlIl, new Color(255, 0, 255, 255).getRGB());
        Hud.drawRect(lIIllIIIllIIIll, lIIllIIIlIlIlll - 1.0f, lIIllIIIlIlIllI, lIIllIIIlIlIlll, new Color(255, 0, 255, 255).getRGB());
        Hud.drawRect(lIIllIIIlIlIllI + 1.0f, lIIllIIIlIlIlIl + 1.0f, lIIllIIIlIlIllI, lIIllIIIlIlIlll, new Color(255, 0, 255, 255).getRGB());
        Hud.drawRect(lIIllIIIlIlIllI, lIIllIIIlIlIlIl + 1.0f, lIIllIIIllIIIll, lIIllIIIlIlIlIl, new Color(255, 0, 255, 255).getRGB());
    }

    public static void renderItem(ItemStack lIIllIlIIIIllII, Point lIIllIlIIIIllIl) {
        GlStateManager.enableTexture2D();
        GL11.glPushAttrib((int)524288);
        GL11.glDisable((int)3089);
        GlStateManager.clear((int)256);
        GL11.glPopAttrib();
        GlStateManager.pushMatrix();
        Minecraft.getMinecraft().getRenderItem().zLevel = -150.0f;
        RenderHelper.enableGUIStandardItemLighting();
        Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(lIIllIlIIIIllII, lIIllIlIIIIllIl.x, lIIllIlIIIIllIl.y);
        Minecraft.getMinecraft().getRenderItem().renderItemOverlays(Minecraft.getMinecraft().fontRenderer, lIIllIlIIIIllII, lIIllIlIIIIllIl.x, lIIllIlIIIIllIl.y);
        RenderHelper.disableStandardItemLighting();
        Minecraft.getMinecraft().getRenderItem().zLevel = 0.0f;
        GlStateManager.popMatrix();
        Hud.begin();
    }

    public static void drawRoundedRect(double lIIllIIIIllIIll, double lIIllIIIIllllll, double lIIllIIIIlllllI, double lIIllIIIIllIIII, double lIIllIIIIllllII, int lIIllIIIIlllIll) {
        double lIIllIIIIlllIlI = lIIllIIIIllIIll + lIIllIIIIlllllI;
        double lIIllIIIIlllIIl = lIIllIIIIllllll + lIIllIIIIllIIII;
        float lIIllIIIIlllIII = (float)(lIIllIIIIlllIll >> 24 & 0xFF) / 255.0f;
        float lIIllIIIIllIlll = (float)(lIIllIIIIlllIll >> 16 & 0xFF) / 255.0f;
        float lIIllIIIIllIllI = (float)(lIIllIIIIlllIll >> 8 & 0xFF) / 255.0f;
        float lIIllIIIIllIlIl = (float)(lIIllIIIIlllIll & 0xFF) / 255.0f;
        GL11.glPushAttrib((int)0);
        GL11.glScaled((double)0.5, (double)0.5, (double)0.5);
        lIIllIIIIlllIlI *= 2.0;
        lIIllIIIIlllIIl *= 2.0;
        Tessellator.getInstance();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.color((float)lIIllIIIIlllIII, (float)lIIllIIIIllIlll, (float)lIIllIIIIllIllI, (float)lIIllIIIIllIlIl);
        GL11.glDisable((int)3553);
        GL11.glColor4f((float)lIIllIIIIllIlll, (float)lIIllIIIIllIllI, (float)lIIllIIIIllIlIl, (float)lIIllIIIIlllIII);
        GL11.glEnable((int)2848);
        GL11.glBegin((int)9);
        int lIIllIIIIllIlII = 0;
        while (true) {
            GL11.glVertex2d((double)((lIIllIIIIllIIll *= 2.0) + lIIllIIIIllllII + Math.sin((double)lIIllIIIIllIlII * Math.PI / 180.0) * (lIIllIIIIllllII * -1.0)), (double)((lIIllIIIIllllll *= 2.0) + lIIllIIIIllllII + Math.cos((double)lIIllIIIIllIlII * Math.PI / 180.0) * (lIIllIIIIllllII * -1.0)));
            lIIllIIIIllIlII += 3;
        }
    }

    public void onRenderArmor(RenderGameOverlayEvent lIIllIIllllllIl) {
        Hud lIIllIIlllllIIl;
        ScaledResolution lIIllIIllllllII = new ScaledResolution(lIIllIIlllllIIl.mc);
        NonNullList lIIllIIlllllIll = Minecraft.getMinecraft().player.field_71071_by.armorInventory;
        int lIIllIIlllllIlI = 3;
        for (int lIIllIIllllllll = 0; lIIllIIllllllll < lIIllIIlllllIll.size(); ++lIIllIIllllllll) {
            Hud.renderItem((ItemStack)lIIllIIlllllIll.get(lIIllIIlllllIlI--), new Point(lIIllIIllllllII.getScaledWidth() / 2 + lIIllIIlllllIlI * 18 + 38, lIIllIIllllllII.getScaledHeight() - 55));
        }
    }

    public void onRenderInventory(RenderGameOverlayEvent lIIllIIlllIllIl) {
        Hud lIIllIIlllIIlll;
        ScaledResolution lIIllIIlllIllII = new ScaledResolution(lIIllIIlllIIlll.mc);
        NonNullList lIIllIIlllIlIll = Minecraft.getMinecraft().player.field_71071_by.mainInventory;
        int lIIllIIlllIlIlI = 27;
        int lIIllIIlllIlIIl = 4;
        int lIIllIIlllIlIII = 0;
        while (true) {
            Hud.drawRoundedRect(lIIllIIlllIllII.getScaledWidth() - 178 + lIIllIIlllIlIII * 20, lIIllIIlllIllII.getScaledHeight() - 100 + lIIllIIlllIlIIl * 20, 16.0, 16.0, 8.0, new Color(0, 0, 0, 100).getRGB());
            Hud.renderItem((ItemStack)lIIllIIlllIlIll.get(lIIllIIlllIlIlI++), new Point(lIIllIIlllIllII.getScaledWidth() - 178 + lIIllIIlllIlIII * 20, lIIllIIlllIllII.getScaledHeight() - 100 + lIIllIIlllIlIIl * 20));
            ++lIIllIIlllIlIII;
        }
    }

    public static void drawRect(float lIIllIIIllllIll, float lIIllIIlIIIIlIl, float lIIllIIlIIIIlII, float lIIllIIIllllIII, int lIIllIIIlllIlll) {
        if (lIIllIIIllllIll < lIIllIIlIIIIlII) {
            float lIIllIIlIIIlIII = lIIllIIIllllIll;
            lIIllIIIllllIll = lIIllIIlIIIIlII;
            lIIllIIlIIIIlII = lIIllIIlIIIlIII;
        }
        if (lIIllIIlIIIIlIl < lIIllIIIllllIII) {
            float lIIllIIlIIIIlll = lIIllIIlIIIIlIl;
            lIIllIIlIIIIlIl = lIIllIIIllllIII;
            lIIllIIIllllIII = lIIllIIlIIIIlll;
        }
        float lIIllIIlIIIIIIl = (float)(lIIllIIIlllIlll >> 24 & 0xFF) / 255.0f;
        float lIIllIIlIIIIIII = (float)(lIIllIIIlllIlll >> 16 & 0xFF) / 255.0f;
        float lIIllIIIlllllll = (float)(lIIllIIIlllIlll >> 8 & 0xFF) / 255.0f;
        float lIIllIIIllllllI = (float)(lIIllIIIlllIlll & 0xFF) / 255.0f;
        Tessellator lIIllIIIlllllIl = Tessellator.getInstance();
        BufferBuilder lIIllIIIlllllII = lIIllIIIlllllIl.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.color((float)lIIllIIlIIIIIII, (float)lIIllIIIlllllll, (float)lIIllIIIllllllI, (float)lIIllIIlIIIIIIl);
        lIIllIIIlllllII.begin(7, DefaultVertexFormats.POSITION);
        lIIllIIIlllllII.pos((double)lIIllIIIllllIll, (double)lIIllIIIllllIII, 0.0).endVertex();
        lIIllIIIlllllII.pos((double)lIIllIIlIIIIlII, (double)lIIllIIIllllIII, 0.0).endVertex();
        lIIllIIIlllllII.pos((double)lIIllIIlIIIIlII, (double)lIIllIIlIIIIlIl, 0.0).endVertex();
        lIIllIIIlllllII.pos((double)lIIllIIIllllIll, (double)lIIllIIlIIIIlIl, 0.0).endVertex();
        lIIllIIIlllllIl.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    static {
        renderer = GlyphPageFontRenderer.create("Arial", 40, true, true, true);
        myRenderer = GlyphPageFontRenderer.create("Times New Roman Baltic", 19, true, true, true);
        fuckrenderer = GlyphPageFontRenderer.create("Courier New", 50, true, true, true);
        smallRenderer = GlyphPageFontRenderer.create("Courier New", 18, true, true, true);
        targetRenderer = GlyphPageFontRenderer.create("Courier New", 16, true, true, true);
    }

    private static void begin() {
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int)7425);
        GlStateManager.glLineWidth((float)2.0f);
    }

    private void onRenderKeyStrokes(RenderGameOverlayEvent lIIllIlIIIlllII) {
        Hud lIIllIlIIIlIllI;
        int[] lIIllIlIIIllIll = new int[]{1};
        int lIIllIlIIIllIlI = Keyboard.isKeyDown((int)lIIllIlIIIlIllI.mc.gameSettings.keyBindForward.getKeyCode()) ? 125 : 50;
        int lIIllIlIIIllIIl = Keyboard.isKeyDown((int)lIIllIlIIIlIllI.mc.gameSettings.keyBindLeft.getKeyCode()) ? 125 : 50;
        int lIIllIlIIIllIII = Keyboard.isKeyDown((int)lIIllIlIIIlIllI.mc.gameSettings.keyBindBack.getKeyCode()) ? 125 : 50;
        int lIIllIlIIIlIlll = Keyboard.isKeyDown((int)lIIllIlIIIlIllI.mc.gameSettings.keyBindRight.getKeyCode()) ? 125 : 50;
        Hud.drawRoundedRect(5.0, 250.0, 30.0, 30.0, 6.0, new Color(0, 0, 0, lIIllIlIIIllIIl).getRGB());
        Hud.drawRoundedRect(38.0, 250.0, 30.0, 30.0, 6.0, new Color(0, 0, 0, lIIllIlIIIllIII).getRGB());
        Hud.drawRoundedRect(71.0, 250.0, 30.0, 30.0, 6.0, new Color(0, 0, 0, lIIllIlIIIlIlll).getRGB());
        Hud.drawRoundedRect(38.0, 217.0, 30.0, 30.0, 6.0, new Color(0, 0, 0, lIIllIlIIIllIlI).getRGB());
        renderer.drawString("W", 42.5f, 219.0f, new Color(255, 0, 0, 255).getRGB(), true);
        renderer.drawString("A", 45.0f, 253.0f, new Color(255, 0, 0, 255).getRGB(), true);
        renderer.drawString("S", 12.0f, 253.0f, new Color(255, 0, 0, 255).getRGB(), true);
        renderer.drawString("D", 78.0f, 253.0f, new Color(255, 0, 0, 255).getRGB(), true);
        lIIllIlIIIllIll[0] = lIIllIlIIIllIll[0] + 1;
    }

    public static void drawUnfilledCircle(double lIIllIIlIlllIII, double lIIllIIlIllIlll, float lIIllIIllIIIIII, float lIIllIIlIllIlIl, int lIIllIIlIlllllI) {
        lIIllIIlIllIlIl = 1.0f;
        float lIIllIIlIllllIl = (float)(lIIllIIlIlllllI >> 24 & 0xFF) / 255.0f;
        float lIIllIIlIllllII = (float)(lIIllIIlIlllllI >> 16 & 0xFF) / 255.0f;
        float lIIllIIlIlllIll = (float)(lIIllIIlIlllllI >> 8 & 0xFF) / 255.0f;
        float lIIllIIlIlllIlI = (float)(lIIllIIlIlllllI & 0xFF) / 255.0f;
        GL11.glColor4f((float)lIIllIIlIllllII, (float)lIIllIIlIlllIll, (float)lIIllIIlIlllIlI, (float)lIIllIIlIllllIl);
        GL11.glLineWidth((float)lIIllIIlIllIlIl);
        GL11.glEnable((int)2848);
        GL11.glBegin((int)2);
        int lIIllIIlIlllIIl = 0;
        while (true) {
            GL11.glVertex2d((double)(lIIllIIlIlllIII + Math.sin((double)lIIllIIlIlllIIl * 3.141526 / 180.0) * (double)lIIllIIllIIIIII), (double)(lIIllIIlIllIlll + Math.cos((double)lIIllIIlIlllIIl * 3.141526 / 180.0) * (double)lIIllIIllIIIIII));
            ++lIIllIIlIlllIIl;
        }
    }

    public static int rainbow(int lIIllIlIIIIlIII) {
        double lIIllIlIIIIIlll = Math.ceil((double)(System.currentTimeMillis() + (long)lIIllIlIIIIlIII) / 10.0);
        return Color.getHSBColor((float)((lIIllIlIIIIIlll %= -360.0) / -360.0), 0.735f, 1.0f).getRGB();
    }

    public Hud() {
        Hud lIIllIIllIIllIl;
        lIIllIIllIIllIl.mc = Minecraft.getMinecraft();
        lIIllIIllIIllIl.df = new DecimalFormat("###.#");
        lIIllIIllIIllIl.random = new Random();
        lIIllIIllIIllIl.timerUtil = new TimerUtil();
    }

    public static void drawCircle(double lIIllIIlIlIIlIl, double lIIllIIlIlIIlII, float lIIllIIlIIllIlI, int lIIllIIlIlIIIlI) {
        float lIIllIIlIlIIIIl = (float)(lIIllIIlIlIIIlI >> 24 & 0xFF) / 255.0f;
        float lIIllIIlIlIIIII = (float)(lIIllIIlIlIIIlI >> 16 & 0xFF) / 255.0f;
        float lIIllIIlIIlllll = (float)(lIIllIIlIlIIIlI >> 8 & 0xFF) / 255.0f;
        float lIIllIIlIIllllI = (float)(lIIllIIlIlIIIlI & 0xFF) / 255.0f;
        GL11.glColor4f((float)lIIllIIlIlIIIII, (float)lIIllIIlIIlllll, (float)lIIllIIlIIllllI, (float)lIIllIIlIlIIIIl);
        GL11.glBegin((int)9);
        int lIIllIIlIIlllIl = 0;
        while (true) {
            GL11.glVertex2d((double)(lIIllIIlIlIIlIl + Math.sin((double)lIIllIIlIIlllIl * 3.141526 / 180.0) * (double)lIIllIIlIIllIlI), (double)(lIIllIIlIlIIlII + Math.cos((double)lIIllIIlIIlllIl * 3.141526 / 180.0) * (double)lIIllIIlIIllIlI));
            ++lIIllIIlIIlllIl;
        }
    }
}

