/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.GL11
 */
package ru.internali.clickgui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import ru.internali.CatClient;
import ru.internali.clickgui.Component;
import ru.internali.clickgui.Mod;
import ru.internali.clickgui.Panel;
import ru.internali.module.Category;
import ru.internali.utils.MathUtils;
import ru.internali.utils.RenderUtil;
import ru.internali.utils.RenderUtils;

public class ClickGuiScreen
extends GuiScreen {
    /* synthetic */ int posX;
    /* synthetic */ int dragY;
    /* synthetic */ int HEIGHT;
    /* synthetic */ float modScroll;
    public /* synthetic */ Mod currentMod;
    /* synthetic */ ArrayList<Panel> panels;
    /* synthetic */ int posY;
    public /* synthetic */ Panel currentPanel;
    /* synthetic */ int dragX;
    /* synthetic */ boolean draging;
    /* synthetic */ int WIGHT;

    public void initGui() {
        ClickGuiScreen llIIIlIlllIIIl;
        super.initGui();
    }

    public ClickGuiScreen() {
        ClickGuiScreen llIIIllIlIllIl;
        llIIIllIlIllIl.modScroll = 0.0f;
        llIIIllIlIllIl.panels = new ArrayList();
        llIIIllIlIllIl.WIGHT = 300;
        llIIIllIlIllIl.HEIGHT = 200;
        llIIIllIlIllIl.draging = false;
        for (Category llIIIllIlIllll : Category.values()) {
            llIIIllIlIllIl.panels.add(new Panel(llIIIllIlIllll));
        }
    }

    public boolean ishover(float llIIIlIllIIIll, float llIIIlIllIIIlI, float llIIIlIllIIIIl, float llIIIlIllIIIII, int llIIIlIllIIlIl, int llIIIlIllIIlII) {
        return (float)llIIIlIllIIlIl >= llIIIlIllIIIll && (float)llIIIlIllIIlIl <= llIIIlIllIIIIl && (float)llIIIlIllIIlII >= llIIIlIllIIIlI && (float)llIIIlIllIIlII <= llIIIlIllIIIII;
    }

    protected void mouseClicked(int llIIIlIllllIlI, int llIIIlIllllIIl, int llIIIlIllllIII) throws IOException {
        ClickGuiScreen llIIIlIllllIll;
        super.mouseClicked(llIIIlIllllIlI, llIIIlIllllIIl, llIIIlIllllIII);
        Component llIIIlIlllllIl = new Component();
        if (llIIIlIlllllIl.ishover(llIIIlIllllIll.posX, llIIIlIllllIll.posY, llIIIlIllllIll.posX + llIIIlIllllIll.WIGHT, llIIIlIllllIll.posY + 6, llIIIlIllllIlI, llIIIlIllllIIl) && llIIIlIllllIII == 0) {
            llIIIlIllllIll.draging = true;
            llIIIlIllllIll.dragX = llIIIlIllllIlI - llIIIlIllllIll.posX;
            llIIIlIllllIll.dragY = llIIIlIllllIIl - llIIIlIllllIll.posY;
        }
        int llIIIlIlllllII = 3;
        for (Panel llIIIllIIIIIll : llIIIlIllllIll.panels) {
            llIIIllIIIIIll.mouseClicked(llIIIlIllllIll.posX + llIIIlIlllllII, llIIIlIllllIll.posY + 7, llIIIlIllllIlI, llIIIlIllllIIl, llIIIlIllllIII);
            llIIIlIlllllII = (int)((float)llIIIlIlllllII + (llIIIllIIIIIll.getWidth() + 5.0f));
        }
        if (llIIIlIllllIll.currentPanel != null) {
            llIIIlIlllllII = (int)(25.0f + llIIIlIllllIll.modScroll);
            for (Mod llIIIllIIIIIlI : llIIIlIllllIll.currentPanel.mods) {
                llIIIllIIIIIlI.mouseClicked(llIIIlIllllIll.posX + 3, llIIIlIllllIll.posY + llIIIlIlllllII, llIIIlIllllIlI, llIIIlIllllIIl, llIIIlIllllIII);
                llIIIlIlllllII = (int)((float)llIIIlIlllllII + (llIIIllIIIIIlI.getHeight() + 3.0f));
            }
        }
    }

    public void drawScreen(int llIIIllIIllIII, int llIIIllIIlIlll, float llIIIllIIlIIIl) {
        ClickGuiScreen llIIIllIIllIIl;
        super.drawScreen(llIIIllIIllIII, llIIIllIIlIlll, llIIIllIIlIIIl);
        if (llIIIllIIllIIl.draging) {
            if (!Mouse.isButtonDown((int)0)) {
                llIIIllIIllIIl.draging = false;
            }
            llIIIllIIllIIl.posX = llIIIllIIllIII - llIIIllIIllIIl.dragX;
            llIIIllIIllIIl.posY = llIIIllIIlIlll - llIIIllIIllIIl.dragY;
        }
        RenderUtil.drawSmoothRect(llIIIllIIllIIl.posX, llIIIllIIllIIl.posY, llIIIllIIllIIl.posX + llIIIllIIllIIl.WIGHT, llIIIllIIllIIl.posY + llIIIllIIllIIl.HEIGHT, new Color(30, 30, 30).getRGB());
        RenderUtil.drawSmoothRect(llIIIllIIllIIl.posX, llIIIllIIllIIl.posY, llIIIllIIllIIl.posX + llIIIllIIllIIl.WIGHT, llIIIllIIllIIl.posY + 2, CatClient.getColor());
        int llIIIllIIlIlIl = 3;
        for (Panel llIIIllIIlllll : llIIIllIIllIIl.panels) {
            llIIIllIIlllll.drawScreen(llIIIllIIllIIl.posX + llIIIllIIlIlIl, llIIIllIIllIIl.posY + 7, llIIIllIIllIII, llIIIllIIlIlll, llIIIllIIlIIIl);
            llIIIllIIlIlIl = (int)((float)llIIIllIIlIlIl + (llIIIllIIlllll.getWidth() + 5.0f));
        }
        RenderUtil.drawSmoothRect(llIIIllIIllIIl.posX, llIIIllIIllIIl.posY + 25, llIIIllIIllIIl.posX + 80, llIIIllIIllIIl.posY + llIIIllIIllIIl.HEIGHT, new Color(35, 35, 35).getRGB());
        GL11.glEnable((int)3089);
        RenderUtils.scissorRect(llIIIllIIllIIl.posX, llIIIllIIllIIl.posY + 25, llIIIllIIllIIl.posX + 80, llIIIllIIllIIl.posY + llIIIllIIllIIl.HEIGHT);
        llIIIllIIllIIl.WIGHT = llIIIllIIlIlIl;
        for (Panel llIIIllIIlllIl : llIIIllIIllIIl.panels) {
            if (llIIIllIIlllIl == llIIIllIIllIIl.currentPanel) continue;
            for (Mod llIIIllIIllllI : llIIIllIIlllIl.mods) {
                llIIIllIIllllI.reset();
            }
        }
        if (llIIIllIIllIIl.ishover(llIIIllIIllIIl.posX, llIIIllIIllIIl.posY, llIIIllIIllIIl.posX + llIIIllIIllIIl.WIGHT - 80, llIIIllIIllIIl.posY + llIIIllIIllIIl.HEIGHT, llIIIllIIllIII, llIIIllIIlIlll)) {
            int llIIIllIIlllII = Mouse.getDWheel();
            if (llIIIllIIlllII > 0) {
                llIIIllIIllIIl.modScroll += 3.0f;
            } else if (llIIIllIIlllII < 0) {
                llIIIllIIllIIl.modScroll -= 3.0f;
            }
        }
        if (llIIIllIIllIIl.currentPanel != null) {
            llIIIllIIllIIl.currentPanel.mods.get((int)0).anim = MathUtils.lerp(llIIIllIIllIIl.currentPanel.mods.get((int)0).anim, 1.0f, 0.3f);
            for (int llIIIllIIllIll = 0; llIIIllIIllIll < llIIIllIIllIIl.currentPanel.mods.size() - 1; ++llIIIllIIllIll) {
                if (!((double)llIIIllIIllIIl.currentPanel.mods.get((int)llIIIllIIllIll).anim > 0.95)) continue;
                llIIIllIIllIIl.currentPanel.mods.get((int)(llIIIllIIllIll + 1)).anim = MathUtils.lerp(llIIIllIIllIIl.currentPanel.mods.get((int)(llIIIllIIllIll + 1)).anim, 1.0f, 0.3f);
            }
            llIIIllIIlIlIl = (int)(25.0f + llIIIllIIllIIl.modScroll);
            for (Mod llIIIllIIllIlI : llIIIllIIllIIl.currentPanel.mods) {
                llIIIllIIllIlI.drawScreen(llIIIllIIllIIl.posX + 3, llIIIllIIllIIl.posY + llIIIllIIlIlIl, llIIIllIIllIII, llIIIllIIlIlll, llIIIllIIlIIIl);
                llIIIllIIlIlIl = (int)((float)llIIIllIIlIlIl + (llIIIllIIllIlI.getHeight() + 3.0f));
            }
        }
        GL11.glDisable((int)3089);
    }
}

