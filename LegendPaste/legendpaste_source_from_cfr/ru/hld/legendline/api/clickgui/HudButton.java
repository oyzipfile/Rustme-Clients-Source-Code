/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiScreen
 *  org.lwjgl.opengl.GL11
 */
package ru.hld.legendline.api.clickgui;

import java.awt.Color;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.opengl.GL11;
import ru.hld.legendline.Client;
import ru.hld.legendline.antiNative.RenderUtils;
import ru.hld.legendline.api.clickgui.Comp;
import ru.hld.legendline.api.utils.CFontRenderer;
import ru.hld.legendline.api.utils.Fonts;
import ru.hld.legendline.api.utils.MathUtils;
import ru.hld.legendline.impl.modules.Render.ClickGui;

public class HudButton
extends Comp {
    /* synthetic */ CFontRenderer fr;
    /* synthetic */ CFontRenderer icons;
    /* synthetic */ float anim;

    @Override
    public void drawScreen(int llllllllllllllIllllIlIlllIllIIIl, int llllllllllllllIllllIlIlllIlIlIlI, int llllllllllllllIllllIlIlllIlIllll, int llllllllllllllIllllIlIlllIlIlIII, float llllllllllllllIllllIlIlllIlIIlll) {
        HudButton llllllllllllllIllllIlIlllIlIllII;
        super.drawScreen(llllllllllllllIllllIlIlllIllIIIl, llllllllllllllIllllIlIlllIlIlIlI, llllllllllllllIllllIlIlllIlIllll, llllllllllllllIllllIlIlllIlIlIII, llllllllllllllIllllIlIlllIlIIlll);
        if (ClickGui.shadows.getVal()) {
            RenderUtils.drawShadowRect(llllllllllllllIllllIlIlllIllIIIl, llllllllllllllIllllIlIlllIlIlIlI, llllllllllllllIllllIlIlllIllIIIl + 24 + llllllllllllllIllllIlIlllIlIllII.fr.getStringWidth(" HudEditor"), llllllllllllllIllllIlIlllIlIlIlI + 16, 3, new Color(30, 30, 30, 200).getRGB());
        } else {
            RenderUtils.drawSuper(llllllllllllllIllllIlIlllIllIIIl, llllllllllllllIllllIlIlllIlIlIlI, llllllllllllllIllllIlIlllIllIIIl + 24 + llllllllllllllIllllIlIlllIlIllII.fr.getStringWidth(" HudEditor"), llllllllllllllIllllIlIlllIlIlIlI + 16, 3, new Color(30, 30, 30, 200).getRGB());
        }
        llllllllllllllIllllIlIlllIlIllII.anim = llllllllllllllIllllIlIlllIlIllII.ishover(llllllllllllllIllllIlIlllIllIIIl, llllllllllllllIllllIlIlllIlIlIlI, llllllllllllllIllllIlIlllIllIIIl + 24, llllllllllllllIllllIlIlllIlIlIlI + 16, llllllllllllllIllllIlIlllIlIllll, llllllllllllllIllllIlIlllIlIlIII) ? MathUtils.lerp(llllllllllllllIllllIlIlllIlIllII.anim, 1.2f, 0.01f) : MathUtils.lerp(llllllllllllllIllllIlIlllIlIllII.anim, 1.0f, 0.1f);
        GL11.glPushMatrix();
        RenderUtils.customScaledObject2D(llllllllllllllIllllIlIlllIllIIIl, llllllllllllllIllllIlIlllIlIlIlI, 16.0f, 16.0f, llllllllllllllIllllIlIlllIlIllII.anim);
        llllllllllllllIllllIlIlllIlIllII.icons.drawCenteredString("g", llllllllllllllIllllIlIlllIllIIIl + 8, llllllllllllllIllllIlIlllIlIlIlI + 8 - llllllllllllllIllllIlIlllIlIllII.icons.getHeight() / 2, Client.getColor());
        GL11.glPopMatrix();
        llllllllllllllIllllIlIlllIlIllII.fr.drawString("HudEditor", llllllllllllllIllllIlIlllIllIIIl + 16, llllllllllllllIllllIlIlllIlIlIlI + 8 - llllllllllllllIllllIlIlllIlIllII.fr.getHeight() / 2, -1);
    }

    public HudButton() {
        HudButton llllllllllllllIllllIlIllllIIlIll;
        llllllllllllllIllllIlIllllIIlIll.fr = Fonts.mntsb_20;
        llllllllllllllIllllIlIllllIIlIll.icons = Fonts.iconswex_30;
        llllllllllllllIllllIlIllllIIlIll.anim = 0.0f;
    }

    @Override
    public void mouseClicked(int llllllllllllllIllllIlIllllIIIIll, int llllllllllllllIllllIlIllllIIIIlI, int llllllllllllllIllllIlIlllIlllIll, int llllllllllllllIllllIlIllllIIIIII, int llllllllllllllIllllIlIlllIlllIIl) throws IOException {
        HudButton llllllllllllllIllllIlIlllIlllllI;
        super.mouseClicked(llllllllllllllIllllIlIllllIIIIll, llllllllllllllIllllIlIllllIIIIlI, llllllllllllllIllllIlIlllIlllIll, llllllllllllllIllllIlIllllIIIIII, llllllllllllllIllllIlIlllIlllIIl);
        if (llllllllllllllIllllIlIlllIlllllI.ishover(llllllllllllllIllllIlIllllIIIIll, llllllllllllllIllllIlIllllIIIIlI, llllllllllllllIllllIlIllllIIIIll + 24 + llllllllllllllIllllIlIlllIlllllI.fr.getStringWidth(" HudEditor"), llllllllllllllIllllIlIllllIIIIlI + 16, llllllllllllllIllllIlIlllIlllIll, llllllllllllllIllllIlIllllIIIIII) && llllllllllllllIllllIlIlllIlllIIl == 0) {
            Minecraft.getMinecraft().displayGuiScreen((GuiScreen)Client.hudEditor);
        }
    }
}

