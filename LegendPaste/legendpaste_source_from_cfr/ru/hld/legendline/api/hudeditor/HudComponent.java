/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Mouse
 */
package ru.hld.legendline.api.hudeditor;

import java.awt.Color;
import java.io.IOException;
import org.lwjgl.input.Mouse;
import ru.hld.legendline.antiNative.RenderUtils;
import ru.hld.legendline.api.font.FontUtils;
import ru.hld.legendline.api.module.Module;

public class HudComponent {
    /* synthetic */ int dragY;
    /* synthetic */ int dragX;
    /* synthetic */ Module module;
    /* synthetic */ boolean draging;

    public void drawScreen(int llllllllllllllllIlIIlIllIlIllIll, int llllllllllllllllIlIIlIllIlIllIlI, float llllllllllllllllIlIIlIllIlIllIIl) {
        HudComponent llllllllllllllllIlIIlIllIlIllIII;
        if (llllllllllllllllIlIIlIllIlIllIII.draging) {
            if (!Mouse.isButtonDown((int)0)) {
                llllllllllllllllIlIIlIllIlIllIII.draging = false;
            }
            llllllllllllllllIlIIlIllIlIllIII.module.setPosX(llllllllllllllllIlIIlIllIlIllIll - llllllllllllllllIlIIlIllIlIllIII.dragX);
            llllllllllllllllIlIIlIllIlIllIII.module.setPosY(llllllllllllllllIlIIlIllIlIllIlI - llllllllllllllllIlIIlIllIlIllIII.dragY);
        }
        RenderUtils.drawRect(llllllllllllllllIlIIlIllIlIllIII.module.getPosX(), llllllllllllllllIlIIlIllIlIllIII.module.getPosY(), llllllllllllllllIlIIlIllIlIllIII.module.getPosX() + llllllllllllllllIlIIlIllIlIllIII.module.getSizeX(), llllllllllllllllIlIIlIllIlIllIII.module.getPosY() + llllllllllllllllIlIIlIllIlIllIII.module.getSizeY(), new Color(30, 30, 30, 80).getRGB());
        FontUtils.fr.drawCenteredString(llllllllllllllllIlIIlIllIlIllIII.module.getName(), llllllllllllllllIlIIlIllIlIllIII.module.getPosX() + llllllllllllllllIlIIlIllIlIllIII.module.getSizeX() / 2, llllllllllllllllIlIIlIllIlIllIII.module.getPosY() + 1, -1);
    }

    public HudComponent(Module llllllllllllllllIlIIlIlllIIIIIIl) {
        HudComponent llllllllllllllllIlIIlIlllIIIIIII;
        llllllllllllllllIlIIlIlllIIIIIII.draging = false;
        llllllllllllllllIlIIlIlllIIIIIII.module = llllllllllllllllIlIIlIlllIIIIIIl;
    }

    protected void mouseClicked(int llllllllllllllllIlIIlIllIllIIllI, int llllllllllllllllIlIIlIllIllIIIIl, int llllllllllllllllIlIIlIllIllIIlII) throws IOException {
        HudComponent llllllllllllllllIlIIlIllIllIIlll;
        if (llllllllllllllllIlIIlIllIllIIlll.ishover(llllllllllllllllIlIIlIllIllIIlll.module.getPosX(), llllllllllllllllIlIIlIllIllIIlll.module.getPosY(), llllllllllllllllIlIIlIllIllIIlll.module.getPosX() + llllllllllllllllIlIIlIllIllIIlll.module.getSizeX(), llllllllllllllllIlIIlIllIllIIlll.module.getPosY() + llllllllllllllllIlIIlIllIllIIlll.module.getSizeY(), llllllllllllllllIlIIlIllIllIIllI, llllllllllllllllIlIIlIllIllIIIIl) && llllllllllllllllIlIIlIllIllIIlII == 0) {
            llllllllllllllllIlIIlIllIllIIlll.draging = !llllllllllllllllIlIIlIllIllIIlll.draging;
            llllllllllllllllIlIIlIllIllIIlll.dragX = llllllllllllllllIlIIlIllIllIIllI - llllllllllllllllIlIIlIllIllIIlll.module.getPosX();
            llllllllllllllllIlIIlIllIllIIlll.dragY = llllllllllllllllIlIIlIllIllIIIIl - llllllllllllllllIlIIlIllIllIIlll.module.getPosY();
        }
    }

    public boolean ishover(float llllllllllllllllIlIIlIllIlllIlll, float llllllllllllllllIlIIlIllIlllIllI, float llllllllllllllllIlIIlIllIlllIlIl, float llllllllllllllllIlIIlIllIlllIlII, int llllllllllllllllIlIIlIllIllIllIl, int llllllllllllllllIlIIlIllIlllIIlI) {
        return (float)llllllllllllllllIlIIlIllIllIllIl >= llllllllllllllllIlIIlIllIlllIlll && (float)llllllllllllllllIlIIlIllIllIllIl <= llllllllllllllllIlIIlIllIlllIlIl && (float)llllllllllllllllIlIIlIllIlllIIlI >= llllllllllllllllIlIIlIllIlllIllI && (float)llllllllllllllllIlIIlIllIlllIIlI <= llllllllllllllllIlIIlIllIlllIlII;
    }
}

