/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 *  org.lwjgl.opengl.GL11
 */
package ru.internali.notifications;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;
import ru.internali.CatClient;
import ru.internali.notifications.Type;
import ru.internali.utils.RenderUtil;

public class notifications {
    public static /* synthetic */ List<String> Tests;
    public static /* synthetic */ List<String> Names;
    private static /* synthetic */ float height;
    public static /* synthetic */ List<Type> Types;
    public static /* synthetic */ List<Integer> Times;
    private static /* synthetic */ float width;

    public static void show() {
        for (int lllIlIllIllIlI = 0; lllIlIllIllIlI < Names.size(); ++lllIlIllIllIlI) {
            if (Times.get(lllIlIllIllIlI) != 120) {
                Times.set(lllIlIllIllIlI, Times.get(lllIlIllIllIlI) + 1);
                continue;
            }
            Names.remove(lllIlIllIllIlI);
            Tests.remove(lllIlIllIllIlI);
            Types.remove(lllIlIllIllIlI);
            Times.remove(lllIlIllIllIlI);
        }
        height = 22.0f;
        for (int lllIlIllIlIlIl = 0; lllIlIllIlIlIl < Names.size(); ++lllIlIllIlIlIl) {
            String lllIlIllIllIIl = Names.get(lllIlIllIlIlIl);
            String lllIlIllIllIII = Tests.get(lllIlIllIlIlIl);
            Type lllIlIllIlIlll = Types.get(lllIlIllIlIlIl);
            int lllIlIllIlIllI = Times.get(lllIlIllIlIlIl);
            notifications.drawnotif(lllIlIllIlIlIl, lllIlIllIllIIl, lllIlIllIllIII, lllIlIllIlIlll, lllIlIllIlIllI);
        }
    }

    public static void drawnotif(int lllIlIlllIllII, String lllIlIlllIlIll, String lllIlIlllIlIlI, Type lllIlIlllIIIll, int lllIlIlllIIIlI) {
        GlStateManager.enableTexture2D();
        ScaledResolution lllIlIlllIIlll = new ScaledResolution(Minecraft.getMinecraft());
        GL11.glPushMatrix();
        GL11.glTranslated((double)(width / 100.0f + 0.0f), (double)(lllIlIlllIIlll.getScaledHeight() / 100 + 0), (double)0.0);
        if (lllIlIlllIIIlI >= 10) {
            GL11.glTranslated((double)(lllIlIlllIIlll.getScaledWidth() - 110), (double)((double)lllIlIlllIIlll.getScaledHeight() - (double)lllIlIlllIIIlI * 1.2 + 7.0), (double)0.0);
        } else {
            GL11.glTranslated((double)(lllIlIlllIIlll.getScaledWidth() - lllIlIlllIIIlI), (double)((double)lllIlIlllIIlll.getScaledHeight() - (double)lllIlIlllIIIlI * 1.2 + 7.0), (double)0.0);
        }
        int lllIlIlllIIllI = 190 - (lllIlIlllIIIlI - 1);
        if (lllIlIlllIIllI >= 0) {
            if (lllIlIlllIIIll == Type.Green) {
                RenderUtil.drawSmoothRect(0.0f, 0.0f, width, height, new Color(35, 35, 40, lllIlIlllIIllI).getRGB());
                RenderUtil.drawSmoothRect(0.0f, 0.0f, 7.0f, height, new Color(51, 255, 0, lllIlIlllIIllI).getRGB());
                Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(lllIlIlllIlIll, 10.0f, 2.0f, CatClient.getClientColor().getRGB());
                Minecraft.getMinecraft().fontRenderer.drawString(lllIlIlllIlIlI, 10, 4 + Minecraft.getMinecraft().fontRenderer.FONT_HEIGHT, new Color(255, 255, 255, lllIlIlllIIllI).getRGB());
            } else if (lllIlIlllIIIll == Type.Red) {
                RenderUtil.drawSmoothRect(0.0f, 0.0f, width, height, new Color(35, 35, 40, lllIlIlllIIllI).getRGB());
                RenderUtil.drawSmoothRect(0.0f, 0.0f, 7.0f, height, new Color(255, 0, 0, lllIlIlllIIllI).getRGB());
                Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(lllIlIlllIlIll, 10.0f, 2.0f, CatClient.getClientColor().getRGB());
                Minecraft.getMinecraft().fontRenderer.drawString(lllIlIlllIlIlI, 10, 4 + Minecraft.getMinecraft().fontRenderer.FONT_HEIGHT, new Color(255, 255, 255, lllIlIlllIIllI).getRGB());
            } else if (lllIlIlllIIIll == Type.OK) {
                RenderUtil.drawSmoothRect(0.0f, 0.0f, width, height, new Color(35, 35, 40, lllIlIlllIIllI).getRGB());
                RenderUtil.drawSmoothRect(0.0f, 0.0f, 7.0f, height, new Color(51, 255, 0, lllIlIlllIIllI).getRGB());
                Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(lllIlIlllIlIll, 10.0f, 2.0f, CatClient.getClientColor().getRGB());
                Minecraft.getMinecraft().fontRenderer.drawString(lllIlIlllIlIlI, 10, 4 + Minecraft.getMinecraft().fontRenderer.FONT_HEIGHT, new Color(255, 255, 255, lllIlIlllIIllI).getRGB());
            }
        }
        GL11.glPopMatrix();
        GlStateManager.disableTexture2D();
    }

    public notifications() {
        notifications lllIlIllllllII;
    }

    static {
        Names = new ArrayList<String>();
        Tests = new ArrayList<String>();
        Types = new ArrayList<Type>();
        Times = new ArrayList<Integer>();
        height = 30.0f;
        width = 100.0f;
    }

    public static void add(String lllIlIlllllIII, String lllIlIllllIlII, Type lllIlIllllIllI) {
        Names.add(lllIlIlllllIII);
        Tests.add(lllIlIllllIlII);
        Types.add(lllIlIllllIllI);
        Times.add(0);
    }
}

