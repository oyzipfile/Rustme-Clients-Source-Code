/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.GL11
 */
package ru.hld.legendline.api.clickgui.sets;

import java.awt.Color;
import java.io.IOException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import ru.hld.legendline.Client;
import ru.hld.legendline.antiNative.RenderUtils;
import ru.hld.legendline.api.clickgui.Set;
import ru.hld.legendline.api.setting.settings.FloatSetting;
import ru.hld.legendline.api.utils.CFontRenderer;
import ru.hld.legendline.api.utils.Fonts;
import ru.hld.legendline.api.utils.MathUtils;
import ru.hld.legendline.impl.modules.Render.ClickGui;

public class Slider
extends Set {
    /* synthetic */ boolean use;
    /* synthetic */ CFontRenderer fr;
    /* synthetic */ float sliderAnim;

    @Override
    public void mouseClicked(int lllllllllllllllIllIlllIllIlllllI, int lllllllllllllllIllIlllIllIllllIl, int lllllllllllllllIllIlllIlllIIIIll, int lllllllllllllllIllIlllIllIlllIll, int lllllllllllllllIllIlllIllIlllIlI) throws IOException {
        Slider lllllllllllllllIllIlllIllIllllll;
        super.mouseClicked(lllllllllllllllIllIlllIllIlllllI, lllllllllllllllIllIlllIllIllllIl, lllllllllllllllIllIlllIlllIIIIll, lllllllllllllllIllIlllIllIlllIll, lllllllllllllllIllIlllIllIlllIlI);
        int lllllllllllllllIllIlllIlllIIIIII = Client.gui.WIGHT - 115;
        if (lllllllllllllllIllIlllIllIllllll.ishover(lllllllllllllllIllIlllIllIlllllI, lllllllllllllllIllIlllIllIllllIl, lllllllllllllllIllIlllIllIlllllI + lllllllllllllllIllIlllIlllIIIIII, lllllllllllllllIllIlllIllIllllIl + 20, lllllllllllllllIllIlllIlllIIIIll, lllllllllllllllIllIlllIllIlllIll) && lllllllllllllllIllIlllIllIlllIlI == 0) {
            lllllllllllllllIllIlllIllIllllll.use = true;
        }
    }

    @Override
    public float getHeight() {
        return 20.0f;
    }

    @Override
    public void reset() {
        Slider lllllllllllllllIllIlllIllIllIllI;
        super.reset();
        lllllllllllllllIllIlllIllIllIllI.anim = 0.0f;
        lllllllllllllllIllIlllIllIllIllI.sliderAnim = 0.0f;
    }

    @Override
    public void drawScreen(int lllllllllllllllIllIlllIlllIllIII, int lllllllllllllllIllIlllIllllIIIll, int lllllllllllllllIllIlllIlllIlIllI, int lllllllllllllllIllIlllIllllIIIIl, float lllllllllllllllIllIlllIlllIlIlII) {
        Slider lllllllllllllllIllIlllIlllIllIIl;
        super.drawScreen(lllllllllllllllIllIlllIlllIllIII, lllllllllllllllIllIlllIllllIIIll, lllllllllllllllIllIlllIlllIlIllI, lllllllllllllllIllIlllIllllIIIIl, lllllllllllllllIllIlllIlllIlIlII);
        int lllllllllllllllIllIlllIlllIlllll = Client.gui.WIGHT - 115;
        GL11.glPushMatrix();
        FloatSetting lllllllllllllllIllIlllIlllIllllI = (FloatSetting)lllllllllllllllIllIlllIlllIllIIl.getSetting();
        int lllllllllllllllIllIlllIlllIlllIl = lllllllllllllllIllIlllIlllIlllll - 5 - lllllllllllllllIllIlllIlllIllIIl.fr.getStringWidth(String.valueOf(new StringBuilder().append(lllllllllllllllIllIlllIlllIllllI.getVal()).append(""))) - lllllllllllllllIllIlllIlllIllIIl.fr.getStringWidth(lllllllllllllllIllIlllIlllIllllI.getName());
        if (lllllllllllllllIllIlllIlllIllIIl.use) {
            lllllllllllllllIllIlllIlllIllllI.setVal((float)MathUtils.round((float)((double)(lllllllllllllllIllIlllIlllIlIllI - (lllllllllllllllIllIlllIlllIllIII + lllllllllllllllIllIlllIlllIllIIl.fr.getStringWidth(lllllllllllllllIllIlllIlllIllllI.getName()) + 10)) * (double)(lllllllllllllllIllIlllIlllIllllI.getMax() - lllllllllllllllIllIlllIlllIllllI.getMin()) / (double)lllllllllllllllIllIlllIlllIlllIl + (double)lllllllllllllllIllIlllIlllIllllI.getMin()), lllllllllllllllIllIlllIlllIllllI.getIncrement()));
            if (lllllllllllllllIllIlllIlllIllllI.getVal() > lllllllllllllllIllIlllIlllIllllI.getMax()) {
                lllllllllllllllIllIlllIlllIllllI.setVal(lllllllllllllllIllIlllIlllIllllI.getMax());
            } else if (lllllllllllllllIllIlllIlllIllllI.getVal() < lllllllllllllllIllIlllIlllIllllI.getMin()) {
                lllllllllllllllIllIlllIlllIllllI.setVal(lllllllllllllllIllIlllIlllIllllI.getMin());
            }
        }
        lllllllllllllllIllIlllIlllIllIIl.sliderAnim = MathUtils.lerp(lllllllllllllllIllIlllIlllIllIIl.sliderAnim, lllllllllllllllIllIlllIlllIllllI.getVal(), 0.05f);
        double lllllllllllllllIllIlllIlllIlllII = MathUtils.round(lllllllllllllllIllIlllIlllIllllI.getVal(), lllllllllllllllIllIlllIlllIllllI.getIncrement());
        double lllllllllllllllIllIlllIlllIllIll = (double)lllllllllllllllIllIlllIlllIlllIl / (double)(lllllllllllllllIllIlllIlllIllllI.getMax() - lllllllllllllllIllIlllIlllIllllI.getMin());
        double lllllllllllllllIllIlllIlllIllIlI = lllllllllllllllIllIlllIlllIllIll * lllllllllllllllIllIlllIlllIlllII - lllllllllllllllIllIlllIlllIllIll * (double)lllllllllllllllIllIlllIlllIllllI.getMin();
        RenderUtils.customScaledObject2D(lllllllllllllllIllIlllIlllIllIII, lllllllllllllllIllIlllIllllIIIll, lllllllllllllllIllIlllIlllIlllll, 20.0f, lllllllllllllllIllIlllIlllIllIIl.anim, 1.0f);
        if (!ClickGui.shadows.getVal()) {
            RenderUtils.drawSuper(lllllllllllllllIllIlllIlllIllIII + 5, lllllllllllllllIllIlllIllllIIIll, lllllllllllllllIllIlllIlllIllIII + lllllllllllllllIllIlllIlllIlllll, (float)lllllllllllllllIllIlllIllllIIIll + lllllllllllllllIllIlllIlllIllIIl.getHeight(), 2, new Color(30, 30, 30, 200).getRGB());
            RenderUtils.drawGradientRect(lllllllllllllllIllIlllIlllIllIII + (lllllllllllllllIllIlllIlllIllIIl.fr.getStringWidth(lllllllllllllllIllIlllIlllIllIIl.getSetting().getName()) + 10), lllllllllllllllIllIlllIllllIIIll + 9, (double)(lllllllllllllllIllIlllIlllIllIII + (lllllllllllllllIllIlllIlllIllIIl.fr.getStringWidth(lllllllllllllllIllIlllIlllIllIIl.getSetting().getName()) + 10)) + lllllllllllllllIllIlllIlllIllIlI, lllllllllllllllIllIlllIllllIIIll + 11, true, Client.getColor2(), Client.getColor());
        } else {
            RenderUtils.drawShadowRect(lllllllllllllllIllIlllIlllIllIII + 5, lllllllllllllllIllIlllIllllIIIll, lllllllllllllllIllIlllIlllIllIII + lllllllllllllllIllIlllIlllIlllll, (float)lllllllllllllllIllIlllIllllIIIll + lllllllllllllllIllIlllIlllIllIIl.getHeight(), 2, new Color(30, 30, 30, 200).getRGB());
            RenderUtils.drawShadowRect(lllllllllllllllIllIlllIlllIllIII + (lllllllllllllllIllIlllIlllIllIIl.fr.getStringWidth(lllllllllllllllIllIlllIlllIllIIl.getSetting().getName()) + 10), lllllllllllllllIllIlllIllllIIIll + 9, (double)(lllllllllllllllIllIlllIlllIllIII + (lllllllllllllllIllIlllIlllIllIIl.fr.getStringWidth(lllllllllllllllIllIlllIlllIllIIl.getSetting().getName()) + 10)) + lllllllllllllllIllIlllIlllIllIlI, lllllllllllllllIllIlllIllllIIIll + 11, 2, Client.getColor2());
        }
        lllllllllllllllIllIlllIlllIllIIl.fr.drawString(lllllllllllllllIllIlllIlllIllIIl.getSetting().getName(), lllllllllllllllIllIlllIlllIllIII + 7, lllllllllllllllIllIlllIllllIIIll + 10 - lllllllllllllllIllIlllIlllIllIIl.fr.getHeight() / 2, -1);
        lllllllllllllllIllIlllIlllIllIIl.fr.drawString(String.valueOf(new StringBuilder().append(lllllllllllllllIllIlllIlllIllllI.getVal()).append("")), (double)(lllllllllllllllIllIlllIlllIllIII + (lllllllllllllllIllIlllIlllIllIIl.fr.getStringWidth(lllllllllllllllIllIlllIlllIllIIl.getSetting().getName()) + 12)) + lllllllllllllllIllIlllIlllIllIlI, lllllllllllllllIllIlllIllllIIIll + 10 - lllllllllllllllIllIlllIlllIllIIl.fr.getHeight() / 2, lllllllllllllllIllIlllIlllIllIIl.use ? Color.RED.getRGB() : -1);
        if (lllllllllllllllIllIlllIlllIllIIl.ishover(lllllllllllllllIllIlllIlllIllIII, lllllllllllllllIllIlllIllllIIIll, lllllllllllllllIllIlllIlllIllIII + lllllllllllllllIllIlllIlllIlllll, lllllllllllllllIllIlllIllllIIIll + 20, lllllllllllllllIllIlllIlllIlIllI, lllllllllllllllIllIlllIllllIIIIl)) {
            lllllllllllllllIllIlllIlllIllIIl.fr.drawString(lllllllllllllllIllIlllIlllIllllI.getDescriptions(), lllllllllllllllIllIlllIlllIlIllI + 10, lllllllllllllllIllIlllIllllIIIIl - 2 - lllllllllllllllIllIlllIlllIllIIl.fr.getHeight() / 2, -1);
        }
        GL11.glPopMatrix();
        if (!Mouse.isButtonDown((int)0)) {
            lllllllllllllllIllIlllIlllIllIIl.use = false;
        }
    }

    public Slider(FloatSetting lllllllllllllllIllIlllIlllllIIlI) {
        super(lllllllllllllllIllIlllIlllllIIlI);
        Slider lllllllllllllllIllIlllIlllllIlIl;
        lllllllllllllllIllIlllIlllllIlIl.fr = Fonts.mntsb_20;
        lllllllllllllllIllIlllIlllllIlIl.use = false;
        lllllllllllllllIllIlllIlllllIlIl.sliderAnim = 0.0f;
    }
}

