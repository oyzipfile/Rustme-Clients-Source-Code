/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.util.text.TextFormatting
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.GL11
 */
package ru.hld.legendline.api.clickgui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.text.TextFormatting;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import ru.hld.legendline.Client;
import ru.hld.legendline.antiNative.RenderUtil;
import ru.hld.legendline.antiNative.RenderUtils;
import ru.hld.legendline.api.clickgui.HudButton;
import ru.hld.legendline.api.clickgui.Panel;
import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.utils.CFontRenderer;
import ru.hld.legendline.api.utils.Fonts;
import ru.hld.legendline.api.utils.MathUtils;
import ru.hld.legendline.impl.modules.Render.ClickGui;

public class ClickGuiScreen
extends GuiScreen {
    public /* synthetic */ Panel currentPanel;
    public /* synthetic */ int HEIGHT;
    /* synthetic */ float anim;
    /* synthetic */ int dragY;
    /* synthetic */ int posX;
    /* synthetic */ HudButton hudButton;
    /* synthetic */ boolean sizing;
    public /* synthetic */ int WIGHT;
    /* synthetic */ int dragX;
    /* synthetic */ int posY;
    /* synthetic */ ArrayList<Panel> panels;
    /* synthetic */ float animMotion;
    /* synthetic */ boolean draging;

    public void initGui() {
        ClickGuiScreen lllllllllllllllllIIIlIIlIIllllll;
        super.initGui();
        lllllllllllllllllIIIlIIlIIllllll.anim = 0.7f;
        lllllllllllllllllIIIlIIlIIllllll.animMotion = 1.3f;
        for (Panel lllllllllllllllllIIIlIIlIlIIIIII : lllllllllllllllllIIIlIIlIIllllll.panels) {
            lllllllllllllllllIIIlIIlIlIIIIII.initGui();
        }
    }

    protected void mouseClicked(int lllllllllllllllllIIIlIIlIlIIlIIl, int lllllllllllllllllIIIlIIlIlIIlIII, int lllllllllllllllllIIIlIIlIlIIIlll) throws IOException {
        ClickGuiScreen lllllllllllllllllIIIlIIlIlIIllll;
        super.mouseClicked(lllllllllllllllllIIIlIIlIlIIlIIl, lllllllllllllllllIIIlIIlIlIIlIII, lllllllllllllllllIIIlIIlIlIIIlll);
        if (lllllllllllllllllIIIlIIlIlIIllll.ishover(lllllllllllllllllIIIlIIlIlIIllll.posX, lllllllllllllllllIIIlIIlIlIIllll.posY, lllllllllllllllllIIIlIIlIlIIllll.posX + 100, lllllllllllllllllIIIlIIlIlIIllll.posY + 40, lllllllllllllllllIIIlIIlIlIIlIIl, lllllllllllllllllIIIlIIlIlIIlIII) && lllllllllllllllllIIIlIIlIlIIIlll == 0) {
            lllllllllllllllllIIIlIIlIlIIllll.draging = true;
            lllllllllllllllllIIIlIIlIlIIllll.dragX = lllllllllllllllllIIIlIIlIlIIlIIl - lllllllllllllllllIIIlIIlIlIIllll.posX;
            lllllllllllllllllIIIlIIlIlIIllll.dragY = lllllllllllllllllIIIlIIlIlIIlIII - lllllllllllllllllIIIlIIlIlIIllll.posY;
        }
        if (lllllllllllllllllIIIlIIlIlIIllll.ishover(lllllllllllllllllIIIlIIlIlIIllll.posX + lllllllllllllllllIIIlIIlIlIIllll.WIGHT - 10, lllllllllllllllllIIIlIIlIlIIllll.posY + lllllllllllllllllIIIlIIlIlIIllll.HEIGHT - 10, lllllllllllllllllIIIlIIlIlIIllll.posX + lllllllllllllllllIIIlIIlIlIIllll.WIGHT, lllllllllllllllllIIIlIIlIlIIllll.posY + lllllllllllllllllIIIlIIlIlIIllll.HEIGHT, lllllllllllllllllIIIlIIlIlIIlIIl, lllllllllllllllllIIIlIIlIlIIlIII) && lllllllllllllllllIIIlIIlIlIIIlll == 0) {
            lllllllllllllllllIIIlIIlIlIIllll.sizing = true;
            lllllllllllllllllIIIlIIlIlIIllll.dragX = lllllllllllllllllIIIlIIlIlIIlIIl - lllllllllllllllllIIIlIIlIlIIllll.posX;
            lllllllllllllllllIIIlIIlIlIIllll.dragY = lllllllllllllllllIIIlIIlIlIIlIII - lllllllllllllllllIIIlIIlIlIIllll.posY;
        }
        int lllllllllllllllllIIIlIIlIlIIlIll = 0;
        for (Panel lllllllllllllllllIIIlIIlIlIlIIII : lllllllllllllllllIIIlIIlIlIIllll.panels) {
            lllllllllllllllllIIIlIIlIlIlIIII.mouseClicked(lllllllllllllllllIIIlIIlIlIIllll.posX + 2, lllllllllllllllllIIIlIIlIlIIllll.posY + 20 + lllllllllllllllllIIIlIIlIlIIlIll, lllllllllllllllllIIIlIIlIlIIlIIl, lllllllllllllllllIIIlIIlIlIIlIII, lllllllllllllllllIIIlIIlIlIIIlll);
            lllllllllllllllllIIIlIIlIlIIlIll += 23;
        }
        if (lllllllllllllllllIIIlIIlIlIIllll.currentPanel != null) {
            lllllllllllllllllIIIlIIlIlIIllll.currentPanel.mouseClicked(lllllllllllllllllIIIlIIlIlIIllll.posX, lllllllllllllllllIIIlIIlIlIIllll.posY, lllllllllllllllllIIIlIIlIlIIlIIl, lllllllllllllllllIIIlIIlIlIIlIII, lllllllllllllllllIIIlIIlIlIIIlll);
        }
        if (lllllllllllllllllIIIlIIlIlIIllll.currentPanel != null) {
            lllllllllllllllllIIIlIIlIlIIllll.currentPanel.mouseClickedOpen(lllllllllllllllllIIIlIIlIlIIllll.posX, lllllllllllllllllIIIlIIlIlIIllll.posY, lllllllllllllllllIIIlIIlIlIIlIIl, lllllllllllllllllIIIlIIlIlIIlIII, lllllllllllllllllIIIlIIlIlIIIlll);
        }
        lllllllllllllllllIIIlIIlIlIIllll.hudButton.mouseClicked(lllllllllllllllllIIIlIIlIlIIllll.posX + 3, lllllllllllllllllIIIlIIlIlIIllll.posY + lllllllllllllllllIIIlIIlIlIIllll.HEIGHT - 19, lllllllllllllllllIIIlIIlIlIIlIIl, lllllllllllllllllIIIlIIlIlIIlIII, lllllllllllllllllIIIlIIlIlIIIlll);
    }

    public ClickGuiScreen() {
        ClickGuiScreen lllllllllllllllllIIIlIIlIlllllIl;
        lllllllllllllllllIIIlIIlIlllllIl.anim = 0.7f;
        lllllllllllllllllIIIlIIlIlllllIl.animMotion = 1.1f;
        lllllllllllllllllIIIlIIlIlllllIl.WIGHT = 400;
        lllllllllllllllllIIIlIIlIlllllIl.HEIGHT = 300;
        lllllllllllllllllIIIlIIlIlllllIl.draging = false;
        lllllllllllllllllIIIlIIlIlllllIl.sizing = false;
        lllllllllllllllllIIIlIIlIlllllIl.panels = new ArrayList();
        lllllllllllllllllIIIlIIlIlllllIl.currentPanel = null;
        for (Category lllllllllllllllllIIIlIIlIllllllI : Category.values()) {
            lllllllllllllllllIIIlIIlIlllllIl.panels.add(new Panel(lllllllllllllllllIIIlIIlIllllllI));
        }
        lllllllllllllllllIIIlIIlIlllllIl.hudButton = new HudButton();
    }

    public void drawScreen(int lllllllllllllllllIIIlIIlIllIIIIl, int lllllllllllllllllIIIlIIlIllIlIIl, float lllllllllllllllllIIIlIIlIlIlllll) {
        ClickGuiScreen lllllllllllllllllIIIlIIlIllIIIlI;
        CFontRenderer lllllllllllllllllIIIlIIlIllIIlll = Fonts.mntsb_21;
        CFontRenderer lllllllllllllllllIIIlIIlIllIIllI = Fonts.iconnewex_80;
        super.drawScreen(lllllllllllllllllIIIlIIlIllIIIIl, lllllllllllllllllIIIlIIlIllIlIIl, lllllllllllllllllIIIlIIlIlIlllll);
        if (lllllllllllllllllIIIlIIlIllIIIlI.draging) {
            if (!Mouse.isButtonDown((int)0)) {
                lllllllllllllllllIIIlIIlIllIIIlI.draging = false;
            }
            lllllllllllllllllIIIlIIlIllIIIlI.posX = lllllllllllllllllIIIlIIlIllIIIIl - lllllllllllllllllIIIlIIlIllIIIlI.dragX;
            lllllllllllllllllIIIlIIlIllIIIlI.posY = lllllllllllllllllIIIlIIlIllIlIIl - lllllllllllllllllIIIlIIlIllIIIlI.dragY;
        }
        lllllllllllllllllIIIlIIlIllIIIlI.anim = MathUtils.lerp(lllllllllllllllllIIIlIIlIllIIIlI.anim, lllllllllllllllllIIIlIIlIllIIIlI.animMotion, 0.3f);
        GL11.glPushMatrix();
        if (!ClickGui.shadows.getVal()) {
            RenderUtils.drawSuper(lllllllllllllllllIIIlIIlIllIIIlI.posX, lllllllllllllllllIIIlIIlIllIIIlI.posY, lllllllllllllllllIIIlIIlIllIIIlI.posX + lllllllllllllllllIIIlIIlIllIIIlI.WIGHT, lllllllllllllllllIIIlIIlIllIIIlI.posY + lllllllllllllllllIIIlIIlIllIIIlI.HEIGHT, 10, Client.getColor());
            RenderUtils.drawSuper(lllllllllllllllllIIIlIIlIllIIIlI.posX + 2, lllllllllllllllllIIIlIIlIllIIIlI.posY + 6, lllllllllllllllllIIIlIIlIllIIIlI.posX + 105, lllllllllllllllllIIIlIIlIllIIIlI.posY + 34, 3, new Color(30, 30, 30, 200).getRGB());
        } else {
            RenderUtils.drawShadowRect(lllllllllllllllllIIIlIIlIllIIIlI.posX, lllllllllllllllllIIIlIIlIllIIIlI.posY, lllllllllllllllllIIIlIIlIllIIIlI.posX + lllllllllllllllllIIIlIIlIllIIIlI.WIGHT, lllllllllllllllllIIIlIIlIllIIIlI.posY + lllllllllllllllllIIIlIIlIllIIIlI.HEIGHT, 10, Client.getColor());
            RenderUtils.drawShadowRect(lllllllllllllllllIIIlIIlIllIIIlI.posX + 2, lllllllllllllllllIIIlIIlIllIIIlI.posY + 6, lllllllllllllllllIIIlIIlIllIIIlI.posX + 105, lllllllllllllllllIIIlIIlIllIIIlI.posY + 34, 3, new Color(30, 30, 30, 200).getRGB());
        }
        String lllllllllllllllllIIIlIIlIllIIlIl = "LEGENDLINE";
        String lllllllllllllllllIIIlIIlIllIIlII = String.valueOf(new StringBuilder().append((Object)TextFormatting.WHITE).append(" FREE  |  v 2.0"));
        RenderUtil.drawHead(Objects.requireNonNull(lllllllllllllllllIIIlIIlIllIIIlI.mc.getConnection()).getPlayerInfo(lllllllllllllllllIIIlIIlIllIIIlI.mc.player.getUniqueID()).getLocationSkin(), lllllllllllllllllIIIlIIlIllIIIlI.posX + 3, lllllllllllllllllIIIlIIlIllIIIlI.posY + 7, 26, 26);
        lllllllllllllllllIIIlIIlIllIIlll.drawString(lllllllllllllllllIIIlIIlIllIIlIl, (double)lllllllllllllllllIIIlIIlIllIIIlI.posX + 30.5, lllllllllllllllllIIIlIIlIllIIIlI.posY + 8, Client.getColor());
        lllllllllllllllllIIIlIIlIllIIlll.drawString(lllllllllllllllllIIIlIIlIllIIlII, lllllllllllllllllIIIlIIlIllIIIlI.posX + 28, lllllllllllllllllIIIlIIlIllIIIlI.posY + 24, Client.getColor());
        int lllllllllllllllllIIIlIIlIllIIIll = 0;
        for (Panel lllllllllllllllllIIIlIIlIllIllII : lllllllllllllllllIIIlIIlIllIIIlI.panels) {
            lllllllllllllllllIIIlIIlIllIllII.drawScreen(lllllllllllllllllIIIlIIlIllIIIlI.posX + 2, lllllllllllllllllIIIlIIlIllIIIlI.posY + 20 + lllllllllllllllllIIIlIIlIllIIIll, lllllllllllllllllIIIlIIlIllIIIIl, lllllllllllllllllIIIlIIlIllIlIIl, lllllllllllllllllIIIlIIlIlIlllll);
            lllllllllllllllllIIIlIIlIllIIIll += 23;
        }
        GL11.glEnable((int)3089);
        RenderUtils.scissorRect(lllllllllllllllllIIIlIIlIllIIIlI.posX + 100, lllllllllllllllllIIIlIIlIllIIIlI.posY + 5, lllllllllllllllllIIIlIIlIllIIIlI.posX + lllllllllllllllllIIIlIIlIllIIIlI.WIGHT, lllllllllllllllllIIIlIIlIllIIIlI.posY - 5 + lllllllllllllllllIIIlIIlIllIIIlI.HEIGHT);
        if (lllllllllllllllllIIIlIIlIllIIIlI.currentPanel != null) {
            lllllllllllllllllIIIlIIlIllIIIlI.currentPanel.drawMods(lllllllllllllllllIIIlIIlIllIIIlI.posX, lllllllllllllllllIIIlIIlIllIIIlI.posY, lllllllllllllllllIIIlIIlIllIIIIl, lllllllllllllllllIIIlIIlIllIlIIl, lllllllllllllllllIIIlIIlIlIlllll);
        }
        GL11.glDisable((int)3089);
        if (lllllllllllllllllIIIlIIlIllIIIlI.sizing) {
            if (!Mouse.isButtonDown((int)0)) {
                lllllllllllllllllIIIlIIlIllIIIlI.sizing = false;
            }
            if (lllllllllllllllllIIIlIIlIllIIIIl - lllllllllllllllllIIIlIIlIllIIIlI.posX > 300) {
                lllllllllllllllllIIIlIIlIllIIIlI.WIGHT = lllllllllllllllllIIIlIIlIllIIIIl - lllllllllllllllllIIIlIIlIllIIIlI.posX;
            }
            if (lllllllllllllllllIIIlIIlIllIlIIl - lllllllllllllllllIIIlIIlIllIIIlI.posY > 200) {
                lllllllllllllllllIIIlIIlIllIIIlI.HEIGHT = lllllllllllllllllIIIlIIlIllIlIIl - lllllllllllllllllIIIlIIlIllIIIlI.posY;
            }
        }
        RenderUtils.drawRect(lllllllllllllllllIIIlIIlIllIIIlI.posX + lllllllllllllllllIIIlIIlIllIIIlI.WIGHT - 1, lllllllllllllllllIIIlIIlIllIIIlI.posY + lllllllllllllllllIIIlIIlIllIIIlI.HEIGHT - 10, lllllllllllllllllIIIlIIlIllIIIlI.posX + lllllllllllllllllIIIlIIlIllIIIlI.WIGHT, lllllllllllllllllIIIlIIlIllIIIlI.posY + lllllllllllllllllIIIlIIlIllIIIlI.HEIGHT, Client.getColor2());
        RenderUtils.drawRect(lllllllllllllllllIIIlIIlIllIIIlI.posX + lllllllllllllllllIIIlIIlIllIIIlI.WIGHT - 10, lllllllllllllllllIIIlIIlIllIIIlI.posY + lllllllllllllllllIIIlIIlIllIIIlI.HEIGHT - 1, lllllllllllllllllIIIlIIlIllIIIlI.posX + lllllllllllllllllIIIlIIlIllIIIlI.WIGHT, lllllllllllllllllIIIlIIlIllIIIlI.posY + lllllllllllllllllIIIlIIlIllIIIlI.HEIGHT, Client.getColor2());
        RenderUtils.drawRect(lllllllllllllllllIIIlIIlIllIIIlI.posX + lllllllllllllllllIIIlIIlIllIIIlI.WIGHT - 3, lllllllllllllllllIIIlIIlIllIIIlI.posY + lllllllllllllllllIIIlIIlIllIIIlI.HEIGHT - 8, lllllllllllllllllIIIlIIlIllIIIlI.posX + lllllllllllllllllIIIlIIlIllIIIlI.WIGHT - 2, lllllllllllllllllIIIlIIlIllIIIlI.posY + lllllllllllllllllIIIlIIlIllIIIlI.HEIGHT - 2, Client.getColor2());
        RenderUtils.drawRect(lllllllllllllllllIIIlIIlIllIIIlI.posX + lllllllllllllllllIIIlIIlIllIIIlI.WIGHT - 8, lllllllllllllllllIIIlIIlIllIIIlI.posY + lllllllllllllllllIIIlIIlIllIIIlI.HEIGHT - 3, lllllllllllllllllIIIlIIlIllIIIlI.posX + lllllllllllllllllIIIlIIlIllIIIlI.WIGHT - 2, lllllllllllllllllIIIlIIlIllIIIlI.posY + lllllllllllllllllIIIlIIlIllIIIlI.HEIGHT - 2, Client.getColor2());
        RenderUtils.drawRect(lllllllllllllllllIIIlIIlIllIIIlI.posX + lllllllllllllllllIIIlIIlIllIIIlI.WIGHT - 5, lllllllllllllllllIIIlIIlIllIIIlI.posY + lllllllllllllllllIIIlIIlIllIIIlI.HEIGHT - 6, lllllllllllllllllIIIlIIlIllIIIlI.posX + lllllllllllllllllIIIlIIlIllIIIlI.WIGHT - 4, lllllllllllllllllIIIlIIlIllIIIlI.posY + lllllllllllllllllIIIlIIlIllIIIlI.HEIGHT - 4, Client.getColor2());
        RenderUtils.drawRect(lllllllllllllllllIIIlIIlIllIIIlI.posX + lllllllllllllllllIIIlIIlIllIIIlI.WIGHT - 6, lllllllllllllllllIIIlIIlIllIIIlI.posY + lllllllllllllllllIIIlIIlIllIIIlI.HEIGHT - 5, lllllllllllllllllIIIlIIlIllIIIlI.posX + lllllllllllllllllIIIlIIlIllIIIlI.WIGHT - 4, lllllllllllllllllIIIlIIlIllIIIlI.posY + lllllllllllllllllIIIlIIlIllIIIlI.HEIGHT - 4, Client.getColor2());
        lllllllllllllllllIIIlIIlIllIIIlI.hudButton.drawScreen(lllllllllllllllllIIIlIIlIllIIIlI.posX + 3, lllllllllllllllllIIIlIIlIllIIIlI.posY + lllllllllllllllllIIIlIIlIllIIIlI.HEIGHT - 19, lllllllllllllllllIIIlIIlIllIIIIl, lllllllllllllllllIIIlIIlIllIlIIl, lllllllllllllllllIIIlIIlIlIlllll);
        GL11.glPopMatrix();
    }

    public boolean ishover(float lllllllllllllllllIIIlIIlIIllIlII, float lllllllllllllllllIIIlIIlIIllIIll, float lllllllllllllllllIIIlIIlIIlIllII, float lllllllllllllllllIIIlIIlIIllIIIl, int lllllllllllllllllIIIlIIlIIllIIII, int lllllllllllllllllIIIlIIlIIlIlIIl) {
        return (float)lllllllllllllllllIIIlIIlIIllIIII >= lllllllllllllllllIIIlIIlIIllIlII && (float)lllllllllllllllllIIIlIIlIIllIIII <= lllllllllllllllllIIIlIIlIIlIllII && (float)lllllllllllllllllIIIlIIlIIlIlIIl >= lllllllllllllllllIIIlIIlIIllIIll && (float)lllllllllllllllllIIIlIIlIIlIlIIl <= lllllllllllllllllIIIlIIlIIllIIIl;
    }
}

