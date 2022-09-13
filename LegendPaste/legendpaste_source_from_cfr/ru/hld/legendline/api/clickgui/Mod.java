/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.opengl.GL11
 */
package ru.hld.legendline.api.clickgui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import ru.hld.legendline.Client;
import ru.hld.legendline.antiNative.RenderUtils;
import ru.hld.legendline.api.clickgui.Comp;
import ru.hld.legendline.api.clickgui.Set;
import ru.hld.legendline.api.clickgui.sets.CheckBox;
import ru.hld.legendline.api.clickgui.sets.Mode;
import ru.hld.legendline.api.clickgui.sets.Slider;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.api.setting.Setting;
import ru.hld.legendline.api.setting.settings.BooleanSetting;
import ru.hld.legendline.api.setting.settings.FloatSetting;
import ru.hld.legendline.api.setting.settings.ModeSetting;
import ru.hld.legendline.api.utils.CFontRenderer;
import ru.hld.legendline.api.utils.ColorUtils;
import ru.hld.legendline.api.utils.Fonts;
import ru.hld.legendline.api.utils.MathUtils;
import ru.hld.legendline.impl.modules.Render.ClickGui;

public class Mod
extends Comp {
    public /* synthetic */ float anim;
    /* synthetic */ float anim2;
    /* synthetic */ boolean open;
    /* synthetic */ boolean binding;
    /* synthetic */ CFontRenderer fr;
    /* synthetic */ Module module;
    /* synthetic */ ArrayList<Set> sets;

    @Override
    public void reset() {
        Mod lllllllllllllIlllIlIIlIllllIIlII;
        super.reset();
        lllllllllllllIlllIlIIlIllllIIlII.anim = 0.0f;
        for (Set lllllllllllllIlllIlIIlIllllIIllI : lllllllllllllIlllIlIIlIllllIIlII.sets) {
            lllllllllllllIlllIlIIlIllllIIllI.reset();
        }
    }

    @Override
    public float getHeight() {
        Mod lllllllllllllIlllIlIIlIlllIllIlI;
        int lllllllllllllIlllIlIIlIlllIllIll = 15;
        if (lllllllllllllIlllIlIIlIlllIllIlI.open) {
            for (Set lllllllllllllIlllIlIIlIlllIlllIl : lllllllllllllIlllIlIIlIlllIllIlI.sets) {
                if (!lllllllllllllIlllIlIIlIlllIlllIl.getSetting().isVisible()) continue;
                lllllllllllllIlllIlIIlIlllIllIll = (int)((float)lllllllllllllIlllIlIIlIlllIllIll + (lllllllllllllIlllIlIIlIlllIlllIl.getHeight() + 3.0f));
            }
        }
        return lllllllllllllIlllIlIIlIlllIllIll;
    }

    public Mod(Module lllllllllllllIlllIlIIlIllllIllll) {
        Mod lllllllllllllIlllIlIIlIlllllIIlI;
        lllllllllllllIlllIlIIlIlllllIIlI.fr = Fonts.mntsb_20;
        lllllllllllllIlllIlIIlIlllllIIlI.binding = false;
        lllllllllllllIlllIlIIlIlllllIIlI.sets = new ArrayList();
        lllllllllllllIlllIlIIlIlllllIIlI.open = false;
        lllllllllllllIlllIlIIlIlllllIIlI.anim = 0.0f;
        lllllllllllllIlllIlIIlIlllllIIlI.anim2 = 0.5f;
        lllllllllllllIlllIlIIlIlllllIIlI.module = lllllllllllllIlllIlIIlIllllIllll;
        for (Setting lllllllllllllIlllIlIIlIlllllIIll : Client.settingManager.getSettings(lllllllllllllIlllIlIIlIllllIllll)) {
            if (lllllllllllllIlllIlIIlIlllllIIll instanceof BooleanSetting) {
                lllllllllllllIlllIlIIlIlllllIIlI.sets.add(new CheckBox((BooleanSetting)lllllllllllllIlllIlIIlIlllllIIll));
            }
            if (lllllllllllllIlllIlIIlIlllllIIll instanceof FloatSetting) {
                lllllllllllllIlllIlIIlIlllllIIlI.sets.add(new Slider((FloatSetting)lllllllllllllIlllIlIIlIlllllIIll));
            }
            if (!(lllllllllllllIlllIlIIlIlllllIIll instanceof ModeSetting)) continue;
            lllllllllllllIlllIlIIlIlllllIIlI.sets.add(new Mode((ModeSetting)lllllllllllllIlllIlIIlIlllllIIll));
        }
    }

    @Override
    public void mouseClicked(int lllllllllllllIlllIIlIIlIlIIIllIl, int lllllllllllllIlllIIlIIlIlIIIllII, int lllllllllllllIlllIIlIIlIlIIIlIll, int lllllllllllllIlllIIlIIlIlIIIIIll, int lllllllllllllIlllIIlIIlIlIIIlIIl) throws IOException {
        Mod lllllllllllllIlllIIlIIlIlIIIlllI;
        super.mouseClicked(lllllllllllllIlllIIlIIlIlIIIllIl, lllllllllllllIlllIIlIIlIlIIIllII, lllllllllllllIlllIIlIIlIlIIIlIll, lllllllllllllIlllIIlIIlIlIIIIIll, lllllllllllllIlllIIlIIlIlIIIlIIl);
        int lllllllllllllIlllIIlIIlIlIIIlIII = Client.gui.WIGHT - 110;
        if (lllllllllllllIlllIIlIIlIlIIIlllI.ishover(lllllllllllllIlllIIlIIlIlIIIllIl, lllllllllllllIlllIIlIIlIlIIIllII, lllllllllllllIlllIIlIIlIlIIIllIl + lllllllllllllIlllIIlIIlIlIIIlIII, lllllllllllllIlllIIlIIlIlIIIllII + 15, lllllllllllllIlllIIlIIlIlIIIlIll, lllllllllllllIlllIIlIIlIlIIIIIll)) {
            if (lllllllllllllIlllIIlIIlIlIIIlIIl == 0) {
                lllllllllllllIlllIIlIIlIlIIIlllI.module.toggle();
            }
            if (lllllllllllllIlllIIlIIlIlIIIlIIl == 1 && lllllllllllllIlllIIlIIlIlIIIlllI.sets.size() > 0) {
                boolean bl = lllllllllllllIlllIIlIIlIlIIIlllI.open = !lllllllllllllIlllIIlIIlIlIIIlllI.open;
            }
            if (lllllllllllllIlllIIlIIlIlIIIlIIl == 2) {
                boolean bl = lllllllllllllIlllIIlIIlIlIIIlllI.binding = !lllllllllllllIlllIIlIIlIlIIIlllI.binding;
            }
        }
        if (lllllllllllllIlllIIlIIlIlIIIlllI.open) {
            int lllllllllllllIlllIIlIIlIlIIIllll = 17;
            for (Set lllllllllllllIlllIIlIIlIlIIlIIII : lllllllllllllIlllIIlIIlIlIIIlllI.sets) {
                if (!lllllllllllllIlllIIlIIlIlIIlIIII.getSetting().isVisible()) continue;
                lllllllllllllIlllIIlIIlIlIIlIIII.mouseClicked(lllllllllllllIlllIIlIIlIlIIIllIl + 2, lllllllllllllIlllIIlIIlIlIIIllII + lllllllllllllIlllIIlIIlIlIIIllll, lllllllllllllIlllIIlIIlIlIIIlIll, lllllllllllllIlllIIlIIlIlIIIIIll, lllllllllllllIlllIIlIIlIlIIIlIIl);
                lllllllllllllIlllIIlIIlIlIIIllll = (int)((float)lllllllllllllIlllIIlIIlIlIIIllll + (lllllllllllllIlllIIlIIlIlIIlIIII.getHeight() + 2.0f));
            }
        }
    }

    public Module getModule() {
        Mod lllllllllllllIlllIlIIlIllllIlIlI;
        return lllllllllllllIlllIlIIlIllllIlIlI.module;
    }

    @Override
    public void drawScreen(int lllllllllllllIlllIlIIlIlllIIIlII, int lllllllllllllIlllIlIIlIllIllllII, int lllllllllllllIlllIlIIlIllIlllIll, int lllllllllllllIlllIlIIlIllIlllIlI, float lllllllllllllIlllIlIIlIllIlllIIl) {
        Mod lllllllllllllIlllIlIIlIllIlllllI;
        super.drawScreen(lllllllllllllIlllIlIIlIlllIIIlII, lllllllllllllIlllIlIIlIllIllllII, lllllllllllllIlllIlIIlIllIlllIll, lllllllllllllIlllIlIIlIllIlllIlI, lllllllllllllIlllIlIIlIllIlllIIl);
        if (lllllllllllllIlllIlIIlIllIlllllI.binding && Keyboard.isKeyDown((int)Keyboard.getEventKey())) {
            if (Keyboard.getEventKey() == 211) {
                lllllllllllllIlllIlIIlIllIlllllI.module.setKey(0);
            } else {
                lllllllllllllIlllIlIIlIllIlllllI.module.setKey(Keyboard.getEventKey());
            }
            lllllllllllllIlllIlIIlIllIlllllI.binding = false;
        }
        int lllllllllllllIlllIlIIlIllIllllll = Client.gui.WIGHT - 110;
        GL11.glPushMatrix();
        RenderUtils.customScaledObject2D(lllllllllllllIlllIlIIlIlllIIIlII, lllllllllllllIlllIlIIlIllIllllII, lllllllllllllIlllIlIIlIllIllllll, 15.0f, lllllllllllllIlllIlIIlIllIlllllI.anim, 1.0f);
        lllllllllllllIlllIlIIlIllIlllllI.anim2 = MathUtils.lerp(lllllllllllllIlllIlIIlIllIlllllI.anim2, lllllllllllllIlllIlIIlIllIlllllI.module.isEnabled() ? 1.0f : 0.0f, 0.07f);
        if (ClickGui.shadows.getVal()) {
            RenderUtils.drawShadowRect(lllllllllllllIlllIlIIlIlllIIIlII + 5, lllllllllllllIlllIlIIlIllIllllII, lllllllllllllIlllIlIIlIlllIIIlII + lllllllllllllIlllIlIIlIllIllllll, lllllllllllllIlllIlIIlIllIllllII + 15, 2, new Color(30, 30, 30, 200).getRGB());
            RenderUtils.drawShadowRect(lllllllllllllIlllIlIIlIlllIIIlII + lllllllllllllIlllIlIIlIllIllllll - 20, (double)(lllllllllllllIlllIlIIlIllIllllII + 7 - lllllllllllllIlllIlIIlIllIlllllI.fr.getHeight() / 2) - 1.5, lllllllllllllIlllIlIIlIlllIIIlII + lllllllllllllIlllIlIIlIllIllllll - 19 + 17, (double)(lllllllllllllIlllIlIIlIllIllllII + 7 - lllllllllllllIlllIlIIlIllIlllllI.fr.getHeight() / 2) + 10.5, 1, Client.getColor());
            RenderUtils.drawShadowRect((float)(lllllllllllllIlllIlIIlIlllIIIlII + lllllllllllllIlllIlIIlIllIllllll - 19) + 10.0f * lllllllllllllIlllIlIIlIllIlllllI.anim2, lllllllllllllIlllIlIIlIllIllllII + 7 - lllllllllllllIlllIlIIlIllIlllllI.fr.getHeight() / 2 - 1, (float)(lllllllllllllIlllIlIIlIlllIIIlII + lllllllllllllIlllIlIIlIllIllllll - 13) + 10.0f * lllllllllllllIlllIlIIlIllIlllllI.anim2, lllllllllllllIlllIlIIlIllIllllII + 7 - lllllllllllllIlllIlIIlIllIlllllI.fr.getHeight() / 2 + 10, 2, ColorUtils.getColor(255 - (int)(lllllllllllllIlllIlIIlIllIlllllI.anim2 * 255.0f), (int)(lllllllllllllIlllIlIIlIllIlllllI.anim2 * 255.0f), 0));
        } else {
            RenderUtils.drawSuper(lllllllllllllIlllIlIIlIlllIIIlII + 5, lllllllllllllIlllIlIIlIllIllllII, lllllllllllllIlllIlIIlIlllIIIlII + lllllllllllllIlllIlIIlIllIllllll, lllllllllllllIlllIlIIlIllIllllII + 15, 2, new Color(30, 30, 30, 200).getRGB());
            RenderUtils.drawSuper(lllllllllllllIlllIlIIlIlllIIIlII + lllllllllllllIlllIlIIlIllIllllll - 20, (double)(lllllllllllllIlllIlIIlIllIllllII + 7 - lllllllllllllIlllIlIIlIllIlllllI.fr.getHeight() / 2) - 1.5, lllllllllllllIlllIlIIlIlllIIIlII + lllllllllllllIlllIlIIlIllIllllll - 19 + 17, (double)(lllllllllllllIlllIlIIlIllIllllII + 7 - lllllllllllllIlllIlIIlIllIlllllI.fr.getHeight() / 2) + 10.5, 1, Client.getColor());
            RenderUtils.drawSuper((float)(lllllllllllllIlllIlIIlIlllIIIlII + lllllllllllllIlllIlIIlIllIllllll - 19) + 10.0f * lllllllllllllIlllIlIIlIllIlllllI.anim2, lllllllllllllIlllIlIIlIllIllllII + 7 - lllllllllllllIlllIlIIlIllIlllllI.fr.getHeight() / 2 - 1, (float)(lllllllllllllIlllIlIIlIlllIIIlII + lllllllllllllIlllIlIIlIllIllllll - 13) + 10.0f * lllllllllllllIlllIlIIlIllIlllllI.anim2, lllllllllllllIlllIlIIlIllIllllII + 7 - lllllllllllllIlllIlIIlIllIlllllI.fr.getHeight() / 2 + 10, 2, ColorUtils.getColor(255 - (int)(lllllllllllllIlllIlIIlIllIlllllI.anim2 * 255.0f), (int)(lllllllllllllIlllIlIIlIllIlllllI.anim2 * 255.0f), 0));
        }
        lllllllllllllIlllIlIIlIllIlllllI.fr.drawString(lllllllllllllIlllIlIIlIllIlllllI.binding ? "Binding..." : lllllllllllllIlllIlIIlIllIlllllI.module.getName(), lllllllllllllIlllIlIIlIlllIIIlII + 8, lllllllllllllIlllIlIIlIllIllllII + 7 - lllllllllllllIlllIlIIlIllIlllllI.fr.getHeight() / 2 + 1, -1);
        if (lllllllllllllIlllIlIIlIllIlllllI.ishover(lllllllllllllIlllIlIIlIlllIIIlII, lllllllllllllIlllIlIIlIllIllllII, lllllllllllllIlllIlIIlIlllIIIlII + lllllllllllllIlllIlIIlIllIllllll, lllllllllllllIlllIlIIlIllIllllII + 15, lllllllllllllIlllIlIIlIllIlllIll, lllllllllllllIlllIlIIlIllIlllIlI)) {
            lllllllllllllIlllIlIIlIllIlllllI.fr.drawString(lllllllllllllIlllIlIIlIllIlllllI.module.getDescriptions(), lllllllllllllIlllIlIIlIllIlllIll + 10, lllllllllllllIlllIlIIlIllIlllIlI - 2 - lllllllllllllIlllIlIIlIllIlllllI.fr.getHeight() / 2, -1);
        }
        GL11.glPopMatrix();
        if (lllllllllllllIlllIlIIlIllIlllllI.open) {
            if (lllllllllllllIlllIlIIlIllIlllllI.sets.size() > 0) {
                lllllllllllllIlllIlIIlIllIlllllI.sets.get((int)0).anim = MathUtils.lerp(lllllllllllllIlllIlIIlIllIlllllI.sets.get((int)0).anim, 1.0f, 0.3f);
                for (int lllllllllllllIlllIlIIlIlllIIlIll = 0; lllllllllllllIlllIlIIlIlllIIlIll < lllllllllllllIlllIlIIlIllIlllllI.sets.size() - 1; ++lllllllllllllIlllIlIIlIlllIIlIll) {
                    if (!(lllllllllllllIlllIlIIlIllIlllllI.sets.get((int)lllllllllllllIlllIlIIlIlllIIlIll).anim > 0.98f)) continue;
                    lllllllllllllIlllIlIIlIllIlllllI.sets.get((int)(lllllllllllllIlllIlIIlIlllIIlIll + 1)).anim = MathUtils.lerp(lllllllllllllIlllIlIIlIllIlllllI.sets.get((int)(lllllllllllllIlllIlIIlIlllIIlIll + 1)).anim, 1.0f, 0.3f);
                }
            }
            int lllllllllllllIlllIlIIlIlllIIlIII = 15;
            if (lllllllllllllIlllIlIIlIllIlllllI.open) {
                for (Set lllllllllllllIlllIlIIlIlllIIlIlI : lllllllllllllIlllIlIIlIllIlllllI.sets) {
                    if (!lllllllllllllIlllIlIIlIlllIIlIlI.getSetting().isVisible()) continue;
                    lllllllllllllIlllIlIIlIlllIIlIII = (int)((float)lllllllllllllIlllIlIIlIlllIIlIII + lllllllllllllIlllIlIIlIlllIIlIlI.getHeight());
                }
            }
            int lllllllllllllIlllIlIIlIlllIIIlll = 17;
            for (Set lllllllllllllIlllIlIIlIlllIIlIIl : lllllllllllllIlllIlIIlIllIlllllI.sets) {
                if (lllllllllllllIlllIlIIlIlllIIlIIl.getSetting().isVisible()) {
                    lllllllllllllIlllIlIIlIlllIIlIIl.drawScreen(lllllllllllllIlllIlIIlIlllIIIlII + 2, lllllllllllllIlllIlIIlIllIllllII + lllllllllllllIlllIlIIlIlllIIIlll, lllllllllllllIlllIlIIlIllIlllIll, lllllllllllllIlllIlIIlIllIlllIlI, lllllllllllllIlllIlIIlIllIlllIIl);
                    lllllllllllllIlllIlIIlIlllIIIlll = (int)((float)lllllllllllllIlllIlIIlIlllIIIlll + (lllllllllllllIlllIlIIlIlllIIlIIl.getHeight() + 2.0f));
                    continue;
                }
                lllllllllllllIlllIlIIlIlllIIlIIl.reset();
            }
        } else {
            for (Set lllllllllllllIlllIlIIlIlllIIIllI : lllllllllllllIlllIlIIlIllIlllllI.sets) {
                lllllllllllllIlllIlIIlIlllIIIllI.reset();
            }
        }
    }
}

