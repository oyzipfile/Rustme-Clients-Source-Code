/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Mouse
 */
package ru.internali.utils.HudEditor;

import java.awt.Color;
import java.io.IOException;
import org.lwjgl.input.Mouse;
import ru.internali.module.Module;
import ru.internali.utils.MinecraftHelper;
import ru.internali.utils.RenderUtils;

public class HudComponent {
    /* synthetic */ int dragX;
    /* synthetic */ boolean draging;
    /* synthetic */ Module module;
    /* synthetic */ int dragY;

    public void drawScreen(int lIIllllIlIllIl, int lIIllllIlIllII, float lIIllllIlIlIll) {
        HudComponent lIIllllIlIlllI;
        RenderUtils.drawRect(lIIllllIlIlllI.module.getPosX(), lIIllllIlIlllI.module.getPosY(), lIIllllIlIlllI.module.getPosX() + lIIllllIlIlllI.module.getSizeX(), lIIllllIlIlllI.module.getPosY() + lIIllllIlIlllI.module.getSizeY(), new Color(30, 30, 30, 200).getRGB());
        MinecraftHelper.mc.fontRenderer.drawString(lIIllllIlIlllI.module.getName(), lIIllllIlIlllI.module.getPosX() + lIIllllIlIlllI.module.getSizeX() / 2, lIIllllIlIlllI.module.getPosY() + 2, -1);
        if (lIIllllIlIlllI.draging) {
            lIIllllIlIlllI.module.setPosX(lIIllllIlIllIl - lIIllllIlIlllI.dragX);
            lIIllllIlIlllI.module.setPosY(lIIllllIlIllII - lIIllllIlIlllI.dragY);
        }
        if (!Mouse.isButtonDown((int)0)) {
            lIIllllIlIlllI.draging = false;
        }
    }

    public void mouseClicked(int lIIllllIIllllI, int lIIllllIIlllIl, int lIIllllIlIIIII) throws IOException {
        HudComponent lIIllllIIlllll;
        if (lIIllllIIlllll.ishover(lIIllllIIlllll.module.getPosX(), lIIllllIIlllll.module.getPosY(), lIIllllIIlllll.module.getPosX() + lIIllllIIlllll.module.getSizeX(), lIIllllIIlllll.module.getPosY() + lIIllllIIlllll.module.getSizeY(), lIIllllIIllllI, lIIllllIIlllIl) && lIIllllIlIIIII == 0) {
            lIIllllIIlllll.draging = !lIIllllIIlllll.draging;
            lIIllllIIlllll.dragX = lIIllllIIllllI - lIIllllIIlllll.module.getPosX();
            lIIllllIIlllll.dragY = lIIllllIIlllIl - lIIllllIIlllll.module.getPosY();
        }
    }

    public HudComponent(Module lIIllllIllIlII) {
        HudComponent lIIllllIllIlIl;
        lIIllllIllIlIl.draging = false;
        lIIllllIllIlIl.dragX = 0;
        lIIllllIllIlIl.dragY = 0;
        lIIllllIllIlIl.module = lIIllllIllIlII;
    }

    public boolean ishover(float lIIllllIllllIl, float lIIllllIllllII, float lIIllllIlllIll, float lIIllllIlllIlI, int lIIllllIllllll, int lIIllllIlllIII) {
        return (float)lIIllllIllllll >= lIIllllIllllIl && (float)lIIllllIllllll <= lIIllllIlllIll && (float)lIIllllIlllIII >= lIIllllIllllII && (float)lIIllllIlllIII <= lIIllllIlllIlI;
    }

    public Module getModule() {
        HudComponent lIIlllllIIllII;
        return lIIlllllIIllII.module;
    }
}

