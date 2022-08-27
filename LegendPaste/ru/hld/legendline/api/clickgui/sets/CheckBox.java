/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package ru.hld.legendline.api.clickgui.sets;

import java.awt.Color;
import java.io.IOException;
import org.lwjgl.opengl.GL11;
import ru.hld.legendline.Client;
import ru.hld.legendline.antiNative.RenderUtils;
import ru.hld.legendline.api.clickgui.Set;
import ru.hld.legendline.api.setting.settings.BooleanSetting;
import ru.hld.legendline.api.utils.CFontRenderer;
import ru.hld.legendline.api.utils.ColorUtils;
import ru.hld.legendline.api.utils.Fonts;
import ru.hld.legendline.api.utils.MathUtils;
import ru.hld.legendline.impl.modules.Render.ClickGui;

public class CheckBox
extends Set {
    /* synthetic */ float anim2;
    /* synthetic */ CFontRenderer fr;

    @Override
    public void reset() {
        CheckBox lllllllllllllllIIlIIllIlIlllllIl;
        super.reset();
        lllllllllllllllIIlIIllIlIlllllIl.anim = 0.0f;
    }

    public CheckBox(BooleanSetting lllllllllllllllIIlIIllIllIlIlIll) {
        super(lllllllllllllllIIlIIllIllIlIlIll);
        CheckBox lllllllllllllllIIlIIllIllIlIllII;
        lllllllllllllllIIlIIllIllIlIllII.fr = Fonts.mntsb_20;
        lllllllllllllllIIlIIllIllIlIllII.anim2 = 0.5f;
    }

    @Override
    public void mouseClicked(int lllllllllllllllIIlIIllIllIIIIllI, int lllllllllllllllIIlIIllIllIIIllII, int lllllllllllllllIIlIIllIllIIIIlII, int lllllllllllllllIIlIIllIllIIIIIll, int lllllllllllllllIIlIIllIllIIIIIlI) throws IOException {
        CheckBox lllllllllllllllIIlIIllIllIIIlllI;
        super.mouseClicked(lllllllllllllllIIlIIllIllIIIIllI, lllllllllllllllIIlIIllIllIIIllII, lllllllllllllllIIlIIllIllIIIIlII, lllllllllllllllIIlIIllIllIIIIIll, lllllllllllllllIIlIIllIllIIIIIlI);
        int lllllllllllllllIIlIIllIllIIIlIII = Client.gui.WIGHT - 115;
        if (lllllllllllllllIIlIIllIllIIIlllI.ishover(lllllllllllllllIIlIIllIllIIIIllI, lllllllllllllllIIlIIllIllIIIllII, lllllllllllllllIIlIIllIllIIIIllI + lllllllllllllllIIlIIllIllIIIlIII, lllllllllllllllIIlIIllIllIIIllII + 15, lllllllllllllllIIlIIllIllIIIIlII, lllllllllllllllIIlIIllIllIIIIIll) && lllllllllllllllIIlIIllIllIIIIIlI == 0) {
            ((BooleanSetting)lllllllllllllllIIlIIllIllIIIlllI.getSetting()).setVal(!((BooleanSetting)lllllllllllllllIIlIIllIllIIIlllI.getSetting()).getVal());
        }
    }

    @Override
    public float getHeight() {
        return 15.0f;
    }

    @Override
    public void drawScreen(int lllllllllllllllIIlIIllIllIlIIIlI, int lllllllllllllllIIlIIllIllIlIIIIl, int lllllllllllllllIIlIIllIllIIllIIl, int lllllllllllllllIIlIIllIllIIlllll, float lllllllllllllllIIlIIllIllIIllllI) {
        CheckBox lllllllllllllllIIlIIllIllIIlllII;
        super.drawScreen(lllllllllllllllIIlIIllIllIlIIIlI, lllllllllllllllIIlIIllIllIlIIIIl, lllllllllllllllIIlIIllIllIIllIIl, lllllllllllllllIIlIIllIllIIlllll, lllllllllllllllIIlIIllIllIIllllI);
        int lllllllllllllllIIlIIllIllIIlllIl = Client.gui.WIGHT - 115;
        GL11.glPushMatrix();
        RenderUtils.customScaledObject2D(lllllllllllllllIIlIIllIllIlIIIlI, lllllllllllllllIIlIIllIllIlIIIIl, lllllllllllllllIIlIIllIllIIlllIl, 15.0f, lllllllllllllllIIlIIllIllIIlllII.anim, 1.0f);
        if (ClickGui.shadows.getVal()) {
            RenderUtils.drawShadowRect(lllllllllllllllIIlIIllIllIlIIIlI + 5, lllllllllllllllIIlIIllIllIlIIIIl, lllllllllllllllIIlIIllIllIlIIIlI + lllllllllllllllIIlIIllIllIIlllIl, (float)lllllllllllllllIIlIIllIllIlIIIIl + lllllllllllllllIIlIIllIllIIlllII.getHeight(), 2, new Color(30, 30, 30, 200).getRGB());
        } else {
            RenderUtils.drawSuper(lllllllllllllllIIlIIllIllIlIIIlI + 5, lllllllllllllllIIlIIllIllIlIIIIl, lllllllllllllllIIlIIllIllIlIIIlI + lllllllllllllllIIlIIllIllIIlllIl, (float)lllllllllllllllIIlIIllIllIlIIIIl + lllllllllllllllIIlIIllIllIIlllII.getHeight(), 2, new Color(30, 30, 30, 200).getRGB());
        }
        lllllllllllllllIIlIIllIllIIlllII.anim2 = MathUtils.lerp(lllllllllllllllIIlIIllIllIIlllII.anim2, ((BooleanSetting)lllllllllllllllIIlIIllIllIIlllII.getSetting()).getVal() ? 1.0f : 0.0f, 0.07f);
        if (ClickGui.shadows.getVal()) {
            RenderUtils.drawShadowRect((double)(lllllllllllllllIIlIIllIllIlIIIlI + lllllllllllllllIIlIIllIllIIlllIl) - 20.5, (double)((float)lllllllllllllllIIlIIllIllIlIIIIl + lllllllllllllllIIlIIllIllIIlllII.getHeight()) - 13.5, lllllllllllllllIIlIIllIllIlIIIlI + lllllllllllllllIIlIIllIllIIlllIl - 19 + 17, (double)((float)lllllllllllllllIIlIIllIllIlIIIIl + lllllllllllllllIIlIIllIllIIlllII.getHeight()) - 1.5, 2, Client.getColor());
            RenderUtils.drawShadowRect((float)(lllllllllllllllIIlIIllIllIlIIIlI + lllllllllllllllIIlIIllIllIIlllIl - 19) + 10.0f * lllllllllllllllIIlIIllIllIIlllII.anim2, (float)lllllllllllllllIIlIIllIllIlIIIIl + lllllllllllllllIIlIIllIllIIlllII.getHeight() - 13.0f, (float)(lllllllllllllllIIlIIllIllIlIIIlI + lllllllllllllllIIlIIllIllIIlllIl - 13) + 10.0f * lllllllllllllllIIlIIllIllIIlllII.anim2, (float)lllllllllllllllIIlIIllIllIlIIIIl + lllllllllllllllIIlIIllIllIIlllII.getHeight() - 2.0f, 2, ColorUtils.getColor(255 - (int)(lllllllllllllllIIlIIllIllIIlllII.anim2 * 255.0f), (int)(lllllllllllllllIIlIIllIllIIlllII.anim2 * 255.0f), 0));
        } else {
            RenderUtils.drawSuper((double)(lllllllllllllllIIlIIllIllIlIIIlI + lllllllllllllllIIlIIllIllIIlllIl) - 20.5, (double)((float)lllllllllllllllIIlIIllIllIlIIIIl + lllllllllllllllIIlIIllIllIIlllII.getHeight()) - 13.5, lllllllllllllllIIlIIllIllIlIIIlI + lllllllllllllllIIlIIllIllIIlllIl - 19 + 17, (double)((float)lllllllllllllllIIlIIllIllIlIIIIl + lllllllllllllllIIlIIllIllIIlllII.getHeight()) - 1.5, 2, Client.getColor());
            RenderUtils.drawSuper((float)(lllllllllllllllIIlIIllIllIlIIIlI + lllllllllllllllIIlIIllIllIIlllIl - 19) + 10.0f * lllllllllllllllIIlIIllIllIIlllII.anim2, (float)lllllllllllllllIIlIIllIllIlIIIIl + lllllllllllllllIIlIIllIllIIlllII.getHeight() - 13.0f, (float)(lllllllllllllllIIlIIllIllIlIIIlI + lllllllllllllllIIlIIllIllIIlllIl - 13) + 10.0f * lllllllllllllllIIlIIllIllIIlllII.anim2, (float)lllllllllllllllIIlIIllIllIlIIIIl + lllllllllllllllIIlIIllIllIIlllII.getHeight() - 2.0f, 2, ColorUtils.getColor(255 - (int)(lllllllllllllllIIlIIllIllIIlllII.anim2 * 255.0f), (int)(lllllllllllllllIIlIIllIllIIlllII.anim2 * 255.0f), 0));
        }
        lllllllllllllllIIlIIllIllIIlllII.fr.drawString(lllllllllllllllIIlIIllIllIIlllII.getSetting().getName(), lllllllllllllllIIlIIllIllIlIIIlI + 7, lllllllllllllllIIlIIllIllIlIIIIl + 7 - lllllllllllllllIIlIIllIllIIlllII.fr.getHeight() / 2, -1);
        if (lllllllllllllllIIlIIllIllIIlllII.ishover(lllllllllllllllIIlIIllIllIlIIIlI, lllllllllllllllIIlIIllIllIlIIIIl, lllllllllllllllIIlIIllIllIlIIIlI + lllllllllllllllIIlIIllIllIIlllIl, lllllllllllllllIIlIIllIllIlIIIIl + 15, lllllllllllllllIIlIIllIllIIllIIl, lllllllllllllllIIlIIllIllIIlllll)) {
            lllllllllllllllIIlIIllIllIIlllII.fr.drawString(lllllllllllllllIIlIIllIllIIlllII.getSetting().getDescriptions(), lllllllllllllllIIlIIllIllIIllIIl + 10, lllllllllllllllIIlIIllIllIIlllll - 2 - lllllllllllllllIIlIIllIllIIlllII.fr.getHeight() / 2, -1);
        }
        GL11.glPopMatrix();
    }
}

