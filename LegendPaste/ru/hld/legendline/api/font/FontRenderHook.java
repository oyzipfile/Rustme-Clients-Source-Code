/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.util.ResourceLocation
 */
package ru.hld.legendline.api.font;

import java.awt.Font;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import ru.hld.legendline.api.font.CustomFontRenderer;

public final class FontRenderHook
extends FontRenderer {
    private final /* synthetic */ CustomFontRenderer fontRenderer;

    public FontRenderHook(Font lllllllllllllllllIIlIIIllllllIll, boolean lllllllllllllllllIIlIIIllllllIlI, boolean lllllllllllllllllIIlIIIllllllIIl) {
        super(Minecraft.getMinecraft().gameSettings, new ResourceLocation("textures/font/ascii.png"), Minecraft.getMinecraft().getTextureManager(), false);
        FontRenderHook lllllllllllllllllIIlIIlIIIIIIIII;
        lllllllllllllllllIIlIIlIIIIIIIII.fontRenderer = new CustomFontRenderer(lllllllllllllllllIIlIIIllllllIll, lllllllllllllllllIIlIIIllllllIlI, lllllllllllllllllIIlIIIllllllIIl);
    }

    public int getStringWidth(String lllllllllllllllllIIlIIIllIIllIIl) {
        FontRenderHook lllllllllllllllllIIlIIIllIIlIlll;
        return lllllllllllllllllIIlIIIllIIlIlll.fontRenderer.getStringWidth(lllllllllllllllllIIlIIIllIIllIIl);
    }

    public int renderString(String lllllllllllllllllIIlIIIllIlIlIll, float lllllllllllllllllIIlIIIllIlllIlI, float lllllllllllllllllIIlIIIllIlllIII, int lllllllllllllllllIIlIIIllIllIIII, boolean lllllllllllllllllIIlIIIllIlIIIll) {
        FontRenderHook lllllllllllllllllIIlIIIllIlIllIl;
        if (lllllllllllllllllIIlIIIllIlIlIll == null) {
            return 0;
        }
        if (lllllllllllllllllIIlIIIllIlIllIl.bidiFlag) {
            lllllllllllllllllIIlIIIllIlIlIll = lllllllllllllllllIIlIIIllIlIllIl.bidiReorder(lllllllllllllllllIIlIIIllIlIlIll);
        }
        if ((lllllllllllllllllIIlIIIllIllIIII & 0xFC000000) == 0) {
            lllllllllllllllllIIlIIIllIllIIII |= 0xFF000000;
        }
        if (lllllllllllllllllIIlIIIllIlIIIll) {
            lllllllllllllllllIIlIIIllIllIIII = (lllllllllllllllllIIlIIIllIllIIII & 0xFCFCFC) >> 2 | lllllllllllllllllIIlIIIllIllIIII & 0xFF000000;
        }
        lllllllllllllllllIIlIIIllIlIllIl.red = (float)(lllllllllllllllllIIlIIIllIllIIII >> 16 & 0xFF) / 255.0f;
        lllllllllllllllllIIlIIIllIlIllIl.blue = (float)(lllllllllllllllllIIlIIIllIllIIII >> 8 & 0xFF) / 255.0f;
        lllllllllllllllllIIlIIIllIlIllIl.green = (float)(lllllllllllllllllIIlIIIllIllIIII & 0xFF) / 255.0f;
        lllllllllllllllllIIlIIIllIlIllIl.alpha = (float)(lllllllllllllllllIIlIIIllIllIIII >> 24 & 0xFF) / 255.0f;
        GlStateManager.color((float)lllllllllllllllllIIlIIIllIlIllIl.red, (float)lllllllllllllllllIIlIIIllIlIllIl.blue, (float)lllllllllllllllllIIlIIIllIlIllIl.green, (float)lllllllllllllllllIIlIIIllIlIllIl.alpha);
        lllllllllllllllllIIlIIIllIlIllIl.posX = lllllllllllllllllIIlIIIllIlllIlI;
        lllllllllllllllllIIlIIIllIlIllIl.posY = lllllllllllllllllIIlIIIllIlllIII;
        lllllllllllllllllIIlIIIllIlIllIl.fontRenderer.drawString(lllllllllllllllllIIlIIIllIlIlIll, lllllllllllllllllIIlIIIllIlllIlI, lllllllllllllllllIIlIIIllIlllIII, lllllllllllllllllIIlIIIllIllIIII, lllllllllllllllllIIlIIIllIlIIIll);
        return (int)lllllllllllllllllIIlIIIllIlIllIl.posX;
    }
}

