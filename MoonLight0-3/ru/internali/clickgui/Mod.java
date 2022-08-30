/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package ru.internali.clickgui;

import java.awt.Color;
import java.io.IOException;
import org.lwjgl.opengl.GL11;
import ru.internali.clickgui.Component;
import ru.internali.module.Module;
import ru.internali.utils.RenderUtil;
import ru.internali.utils.RenderUtils;

public class Mod
extends Component {
    /* synthetic */ Module module;

    @Override
    public void reset() {
        Mod llllIlllIlllI;
        super.reset();
    }

    @Override
    public void drawScreen(int lllllIIIIlIlI, int lllllIIIIllll, int lllllIIIIlllI, int lllllIIIIIlll, float lllllIIIIllII) {
        Mod lllllIIIIlIll;
        super.drawScreen(lllllIIIIlIlI, lllllIIIIllll, lllllIIIIlllI, lllllIIIIIlll, lllllIIIIllII);
        GL11.glPushMatrix();
        RenderUtils.customScaledObject2D(lllllIIIIlIlI, lllllIIIIllll, lllllIIIIlIll.getWidth(), lllllIIIIlIll.getHeight(), lllllIIIIlIll.anim, lllllIIIIlIll.anim);
        RenderUtil.drawSmoothRect(lllllIIIIlIlI, lllllIIIIllll, (float)lllllIIIIlIlI + lllllIIIIlIll.getWidth(), (float)lllllIIIIllll + lllllIIIIlIll.getHeight(), new Color(45, 45, 45).getRGB());
        lllllIIIIlIll.fr.drawString(lllllIIIIlIll.module.getName(), lllllIIIIlIlI + 1, (int)((float)lllllIIIIllll + lllllIIIIlIll.getHeight() / 2.0f - (float)(lllllIIIIlIll.fr.FONT_HEIGHT / 2)), lllllIIIIlIll.module.isToggled() ? -1 : new Color(200, 200, 200).getRGB());
        GL11.glPopMatrix();
    }

    @Override
    public void mouseClicked(int llllIlllllIII, int llllIllllIlll, int llllIllllllII, int llllIllllIlIl, int llllIllllIlII) throws IOException {
        Mod llllIllllllll;
        super.mouseClicked(llllIlllllIII, llllIllllIlll, llllIllllllII, llllIllllIlIl, llllIllllIlII);
        if (llllIllllllll.ishover(llllIlllllIII, llllIllllIlll, (float)llllIlllllIII + llllIllllllll.getWidth(), (float)llllIllllIlll + llllIllllllll.getHeight(), llllIllllllII, llllIllllIlIl)) {
            switch (llllIllllIlII) {
                case 0: {
                    llllIllllllll.module.toggle();
                    return;
                }
            }
        }
    }

    public Mod(Module lllllIIIllIII) {
        Mod lllllIIIllIIl;
        lllllIIIllIIl.module = lllllIIIllIII;
    }

    @Override
    public float getHeight() {
        return 15.0f;
    }

    @Override
    public float getWidth() {
        Mod llllIllllIIlI;
        return llllIllllIIlI.fr.getStringWidth(llllIllllIIlI.module.getName()) + 2;
    }
}

