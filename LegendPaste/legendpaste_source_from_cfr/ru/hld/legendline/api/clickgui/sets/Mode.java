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
import ru.hld.legendline.api.setting.settings.ModeSetting;
import ru.hld.legendline.api.utils.CFontRenderer;
import ru.hld.legendline.api.utils.Fonts;
import ru.hld.legendline.impl.modules.Render.ClickGui;

public class Mode
extends Set {
    /* synthetic */ CFontRenderer fr;
    /* synthetic */ boolean open;

    @Override
    public void reset() {
        Mode llllllllllllllIllIIIIIIlIIllIIll;
        super.reset();
        llllllllllllllIllIIIIIIlIIllIIll.anim = 0.0f;
    }

    @Override
    public float getHeight() {
        Mode llllllllllllllIllIIIIIIllIIIIIll;
        int llllllllllllllIllIIIIIIllIIIIIlI = 15;
        ModeSetting llllllllllllllIllIIIIIIllIIIIIIl = (ModeSetting)llllllllllllllIllIIIIIIllIIIIIll.getSetting();
        if (llllllllllllllIllIIIIIIllIIIIIll.open) {
            llllllllllllllIllIIIIIIllIIIIIlI += llllllllllllllIllIIIIIIllIIIIIIl.getModes().size() * 12;
            llllllllllllllIllIIIIIIllIIIIIlI -= 12;
        }
        return llllllllllllllIllIIIIIIllIIIIIlI;
    }

    @Override
    public void drawScreen(int llllllllllllllIllIIIIIIlIllIllIl, int llllllllllllllIllIIIIIIlIllIllII, int llllllllllllllIllIIIIIIlIllIIIlI, int llllllllllllllIllIIIIIIlIllIIIIl, float llllllllllllllIllIIIIIIlIllIlIIl) {
        Mode llllllllllllllIllIIIIIIlIllIIlIl;
        super.drawScreen(llllllllllllllIllIIIIIIlIllIllIl, llllllllllllllIllIIIIIIlIllIllII, llllllllllllllIllIIIIIIlIllIIIlI, llllllllllllllIllIIIIIIlIllIIIIl, llllllllllllllIllIIIIIIlIllIlIIl);
        int llllllllllllllIllIIIIIIlIllIlIII = Client.gui.WIGHT - 115;
        ModeSetting llllllllllllllIllIIIIIIlIllIIlll = (ModeSetting)llllllllllllllIllIIIIIIlIllIIlIl.getSetting();
        GL11.glPushMatrix();
        RenderUtils.customScaledObject2D(llllllllllllllIllIIIIIIlIllIllIl, llllllllllllllIllIIIIIIlIllIllII, llllllllllllllIllIIIIIIlIllIlIII, 15.0f, llllllllllllllIllIIIIIIlIllIIlIl.anim, 1.0f);
        if (ClickGui.shadows.getVal()) {
            RenderUtils.drawShadowRect(llllllllllllllIllIIIIIIlIllIllIl + 5, llllllllllllllIllIIIIIIlIllIllII, llllllllllllllIllIIIIIIlIllIllIl + llllllllllllllIllIIIIIIlIllIlIII, (float)llllllllllllllIllIIIIIIlIllIllII + llllllllllllllIllIIIIIIlIllIIlIl.getHeight(), 2, new Color(30, 30, 30, 200).getRGB());
        } else {
            RenderUtils.drawSuper(llllllllllllllIllIIIIIIlIllIllIl + 5, llllllllllllllIllIIIIIIlIllIllII, llllllllllllllIllIIIIIIlIllIllIl + llllllllllllllIllIIIIIIlIllIlIII, (float)llllllllllllllIllIIIIIIlIllIllII + llllllllllllllIllIIIIIIlIllIIlIl.getHeight(), 2, new Color(30, 30, 30, 200).getRGB());
        }
        int llllllllllllllIllIIIIIIlIllIIllI = 0;
        for (String llllllllllllllIllIIIIIIlIlllIIIl : llllllllllllllIllIIIIIIlIllIIlll.getModes()) {
            if (llllllllllllllIllIIIIIIlIllIIlIl.fr.getStringWidth(llllllllllllllIllIIIIIIlIlllIIIl) <= llllllllllllllIllIIIIIIlIllIIllI) continue;
            llllllllllllllIllIIIIIIlIllIIllI = llllllllllllllIllIIIIIIlIllIIlIl.fr.getStringWidth(llllllllllllllIllIIIIIIlIlllIIIl);
        }
        if (llllllllllllllIllIIIIIIlIllIIlIl.open) {
            int llllllllllllllIllIIIIIIlIllIllll = 15;
            for (String llllllllllllllIllIIIIIIlIlllIIII : llllllllllllllIllIIIIIIlIllIIlll.getModes()) {
                if (llllllllllllllIllIIIIIIlIllIIlll.getVal().equalsIgnoreCase(llllllllllllllIllIIIIIIlIlllIIII)) continue;
                llllllllllllllIllIIIIIIlIllIIlIl.fr.drawString(llllllllllllllIllIIIIIIlIlllIIII, llllllllllllllIllIIIIIIlIllIllIl + llllllllllllllIllIIIIIIlIllIlIII - llllllllllllllIllIIIIIIlIllIIlIl.fr.getStringWidth(llllllllllllllIllIIIIIIlIlllIIII) - 4, llllllllllllllIllIIIIIIlIllIllII + llllllllllllllIllIIIIIIlIllIllll + (6 - llllllllllllllIllIIIIIIlIllIIlIl.fr.getHeight() / 2), -1);
                llllllllllllllIllIIIIIIlIllIllll += 12;
            }
        }
        llllllllllllllIllIIIIIIlIllIIlIl.fr.drawString(llllllllllllllIllIIIIIIlIllIIlIl.getSetting().getName(), llllllllllllllIllIIIIIIlIllIllIl + 7, llllllllllllllIllIIIIIIlIllIllII + 7 - llllllllllllllIllIIIIIIlIllIIlIl.fr.getHeight() / 2, -1);
        llllllllllllllIllIIIIIIlIllIIlIl.fr.drawString(llllllllllllllIllIIIIIIlIllIIlll.getVal(), llllllllllllllIllIIIIIIlIllIllIl - 4 + llllllllllllllIllIIIIIIlIllIlIII - llllllllllllllIllIIIIIIlIllIIlIl.fr.getStringWidth(llllllllllllllIllIIIIIIlIllIIlll.getVal()), llllllllllllllIllIIIIIIlIllIllII + 7 - llllllllllllllIllIIIIIIlIllIIlIl.fr.getHeight() / 2, Client.getColor());
        if (llllllllllllllIllIIIIIIlIllIIlIl.ishover(llllllllllllllIllIIIIIIlIllIllIl, llllllllllllllIllIIIIIIlIllIllII, llllllllllllllIllIIIIIIlIllIllIl + llllllllllllllIllIIIIIIlIllIlIII, llllllllllllllIllIIIIIIlIllIllII + 15, llllllllllllllIllIIIIIIlIllIIIlI, llllllllllllllIllIIIIIIlIllIIIIl)) {
            llllllllllllllIllIIIIIIlIllIIlIl.fr.drawString(llllllllllllllIllIIIIIIlIllIIlll.getDescriptions(), llllllllllllllIllIIIIIIlIllIIIlI + 10, llllllllllllllIllIIIIIIlIllIIIIl - 2 - llllllllllllllIllIIIIIIlIllIIlIl.fr.getHeight() / 2, -1);
        }
        GL11.glPopMatrix();
    }

    public Mode(ModeSetting llllllllllllllIllIIIIIIllIIIIlll) {
        super(llllllllllllllIllIIIIIIllIIIIlll);
        Mode llllllllllllllIllIIIIIIllIIIlIII;
        llllllllllllllIllIIIIIIllIIIlIII.fr = Fonts.mntsb_20;
        llllllllllllllIllIIIIIIllIIIlIII.open = false;
    }

    @Override
    public void mouseClicked(int llllllllllllllIllIIIIIIlIlIIIIII, int llllllllllllllIllIIIIIIlIIllllll, int llllllllllllllIllIIIIIIlIIlllllI, int llllllllllllllIllIIIIIIlIlIIIllI, int llllllllllllllIllIIIIIIlIIllllII) throws IOException {
        Mode llllllllllllllIllIIIIIIlIlIIlIlI;
        super.mouseClicked(llllllllllllllIllIIIIIIlIlIIIIII, llllllllllllllIllIIIIIIlIIllllll, llllllllllllllIllIIIIIIlIIlllllI, llllllllllllllIllIIIIIIlIlIIIllI, llllllllllllllIllIIIIIIlIIllllII);
        int llllllllllllllIllIIIIIIlIlIIIlII = Client.gui.WIGHT - 115;
        ModeSetting llllllllllllllIllIIIIIIlIlIIIIll = (ModeSetting)llllllllllllllIllIIIIIIlIlIIlIlI.getSetting();
        if (llllllllllllllIllIIIIIIlIlIIlIlI.ishover(llllllllllllllIllIIIIIIlIlIIIIII, llllllllllllllIllIIIIIIlIIllllll, llllllllllllllIllIIIIIIlIlIIIIII + llllllllllllllIllIIIIIIlIlIIIlII, llllllllllllllIllIIIIIIlIIllllll + 15, llllllllllllllIllIIIIIIlIIlllllI, llllllllllllllIllIIIIIIlIlIIIllI) && llllllllllllllIllIIIIIIlIIllllII == 1) {
            llllllllllllllIllIIIIIIlIlIIlIlI.open = !llllllllllllllIllIIIIIIlIlIIlIlI.open;
        }
        int llllllllllllllIllIIIIIIlIlIIIIlI = 0;
        for (String llllllllllllllIllIIIIIIlIlIIllIl : llllllllllllllIllIIIIIIlIlIIIIll.getModes()) {
            if (llllllllllllllIllIIIIIIlIlIIlIlI.fr.getStringWidth(llllllllllllllIllIIIIIIlIlIIllIl) <= llllllllllllllIllIIIIIIlIlIIIIlI) continue;
            llllllllllllllIllIIIIIIlIlIIIIlI = llllllllllllllIllIIIIIIlIlIIlIlI.fr.getStringWidth(llllllllllllllIllIIIIIIlIlIIllIl);
        }
        if (llllllllllllllIllIIIIIIlIlIIlIlI.open) {
            int llllllllllllllIllIIIIIIlIlIIlIll = 15;
            for (String llllllllllllllIllIIIIIIlIlIIllII : llllllllllllllIllIIIIIIlIlIIIIll.getModes()) {
                if (llllllllllllllIllIIIIIIlIlIIIIll.getVal().equalsIgnoreCase(llllllllllllllIllIIIIIIlIlIIllII)) continue;
                if (llllllllllllllIllIIIIIIlIlIIlIlI.ishover(llllllllllllllIllIIIIIIlIlIIIIII + llllllllllllllIllIIIIIIlIlIIIlII - llllllllllllllIllIIIIIIlIlIIIIlI, llllllllllllllIllIIIIIIlIIllllll + llllllllllllllIllIIIIIIlIlIIlIll, llllllllllllllIllIIIIIIlIlIIIIII + llllllllllllllIllIIIIIIlIlIIIlII, llllllllllllllIllIIIIIIlIIllllll + llllllllllllllIllIIIIIIlIlIIlIll + 12, llllllllllllllIllIIIIIIlIIlllllI, llllllllllllllIllIIIIIIlIlIIIllI) && llllllllllllllIllIIIIIIlIIllllII == 0) {
                    llllllllllllllIllIIIIIIlIlIIIIll.setVal(llllllllllllllIllIIIIIIlIlIIllII);
                }
                llllllllllllllIllIIIIIIlIlIIlIll += 12;
            }
        }
    }
}

