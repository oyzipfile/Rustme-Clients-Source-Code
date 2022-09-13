/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Mouse
 */
package ru.hld.legendline.api.clickgui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import org.lwjgl.input.Mouse;
import ru.hld.legendline.Client;
import ru.hld.legendline.antiNative.RenderUtils;
import ru.hld.legendline.api.clickgui.Comp;
import ru.hld.legendline.api.clickgui.Mod;
import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.api.utils.CFontRenderer;
import ru.hld.legendline.api.utils.Fonts;
import ru.hld.legendline.api.utils.MathUtils;
import ru.hld.legendline.impl.modules.Render.ClickGui;

public class Panel
extends Comp {
    /* synthetic */ float scroll;
    /* synthetic */ int color;
    /* synthetic */ int scrollTo;
    /* synthetic */ CFontRenderer fr;
    /* synthetic */ ArrayList<Mod> mods;
    /* synthetic */ Category category;

    public void drawMods(int llllllllllllllllIIIllIIIlIllIIII, int llllllllllllllllIIIllIIIlIllIllI, int llllllllllllllllIIIllIIIlIllIlIl, int llllllllllllllllIIIllIIIlIllIlII, float llllllllllllllllIIIllIIIlIllIIll) {
        Panel llllllllllllllllIIIllIIIlIlllIII;
        if (llllllllllllllllIIIllIIIlIlllIII.ishover(llllllllllllllllIIIllIIIlIllIIII, llllllllllllllllIIIllIIIlIllIllI, Client.gui.WIGHT + llllllllllllllllIIIllIIIlIllIIII, Client.gui.HEIGHT + llllllllllllllllIIIllIIIlIllIllI, llllllllllllllllIIIllIIIlIllIlIl, llllllllllllllllIIIllIIIlIllIlII)) {
            int llllllllllllllllIIIllIIIlIlllIlI = Mouse.getDWheel();
            if (llllllllllllllllIIIllIIIlIlllIlI > 0) {
                llllllllllllllllIIIllIIIlIlllIII.scrollTo += 8;
            } else if (llllllllllllllllIIIllIIIlIlllIlI < 0) {
                llllllllllllllllIIIllIIIlIlllIII.scrollTo -= 8;
            }
        }
        llllllllllllllllIIIllIIIlIlllIII.scroll = MathUtils.lerp(llllllllllllllllIIIllIIIlIlllIII.scroll, llllllllllllllllIIIllIIIlIlllIII.scrollTo, 0.1f);
        int llllllllllllllllIIIllIIIlIllIIlI = (int)(5.0f + llllllllllllllllIIIllIIIlIlllIII.scroll);
        for (Mod llllllllllllllllIIIllIIIlIlllIIl : llllllllllllllllIIIllIIIlIlllIII.mods) {
            llllllllllllllllIIIllIIIlIlllIIl.drawScreen(llllllllllllllllIIIllIIIlIllIIII + 105, llllllllllllllllIIIllIIIlIllIllI + llllllllllllllllIIIllIIIlIllIIlI, llllllllllllllllIIIllIIIlIllIlIl, llllllllllllllllIIIllIIIlIllIlII, llllllllllllllllIIIllIIIlIllIIll);
            llllllllllllllllIIIllIIIlIllIIlI = (int)((float)llllllllllllllllIIIllIIIlIllIIlI + (llllllllllllllllIIIllIIIlIlllIIl.getHeight() + 2.0f));
        }
    }

    @Override
    public void drawScreen(int llllllllllllllllIIIllIIIlIIllIll, int llllllllllllllllIIIllIIIlIIlIIlI, int llllllllllllllllIIIllIIIlIIllIIl, int llllllllllllllllIIIllIIIlIIllIII, float llllllllllllllllIIIllIIIlIIlIlll) {
        block15: {
            Panel llllllllllllllllIIIllIIIlIIlIlII;
            block14: {
                CFontRenderer llllllllllllllllIIIllIIIlIIlIllI = Fonts.iconswex_36;
                super.drawScreen(llllllllllllllllIIIllIIIlIIllIll, llllllllllllllllIIIllIIIlIIlIIlI, llllllllllllllllIIIllIIIlIIllIIl, llllllllllllllllIIIllIIIlIIllIII, llllllllllllllllIIIllIIIlIIlIlll);
                if (Client.gui.currentPanel == llllllllllllllllIIIllIIIlIIlIlII) {
                    if (ClickGui.shadows.getVal()) {
                        RenderUtils.drawShadowRect(llllllllllllllllIIIllIIIlIIllIll, llllllllllllllllIIIllIIIlIIlIIlI + 23, llllllllllllllllIIIllIIIlIIllIll + 103, llllllllllllllllIIIllIIIlIIlIIlI + 37, 3, Client.getColor2());
                    } else {
                        RenderUtils.drawSuper(llllllllllllllllIIIllIIIlIIllIll, llllllllllllllllIIIllIIIlIIlIIlI + 23, llllllllllllllllIIIllIIIlIIllIll + 103, llllllllllllllllIIIllIIIlIIlIIlI + 37, 3, Client.getColor2());
                    }
                } else if (ClickGui.shadows.getVal()) {
                    RenderUtils.drawShadowRect(llllllllllllllllIIIllIIIlIIllIll, llllllllllllllllIIIllIIIlIIlIIlI + 21, llllllllllllllllIIIllIIIlIIllIll + 103, llllllllllllllllIIIllIIIlIIlIIlI + 39, 3, new Color(30, 30, 30, 200).getRGB());
                } else {
                    RenderUtils.drawSuper(llllllllllllllllIIIllIIIlIIllIll, llllllllllllllllIIIllIIIlIIlIIlI + 23, llllllllllllllllIIIllIIIlIIllIll + 103, llllllllllllllllIIIllIIIlIIlIIlI + 37, 3, new Color(30, 30, 30, 200).getRGB());
                }
                boolean llllllllllllllllIIIllIIIlIIlIlIl = llllllllllllllllIIIllIIIlIIlIlII.ishover(llllllllllllllllIIIllIIIlIIllIll, llllllllllllllllIIIllIIIlIIlIIlI + 20, llllllllllllllllIIIllIIIlIIllIll + 100, llllllllllllllllIIIllIIIlIIlIIlI + 40, llllllllllllllllIIIllIIIlIIllIIl, llllllllllllllllIIIllIIIlIIllIII);
                if (llllllllllllllllIIIllIIIlIIlIlII.category == Category.Movement) {
                    llllllllllllllllIIIllIIIlIIlIllI.drawString("d", llllllllllllllllIIIllIIIlIIllIll + 2, llllllllllllllllIIIllIIIlIIlIIlI + 30 - llllllllllllllllIIIllIIIlIIlIlII.fr.getHeight() / 2 - (llllllllllllllllIIIllIIIlIIlIlIl ? 1 : 0), -1);
                }
                if (llllllllllllllllIIIllIIIlIIlIlII.category == Category.Combat) {
                    llllllllllllllllIIIllIIIlIIlIllI.drawString("e", llllllllllllllllIIIllIIIlIIllIll + 2, llllllllllllllllIIIllIIIlIIlIIlI + 30 - llllllllllllllllIIIllIIIlIIlIlII.fr.getHeight() / 2 - (llllllllllllllllIIIllIIIlIIlIlIl ? 1 : 0), -1);
                }
                if (llllllllllllllllIIIllIIIlIIlIlII.category == Category.Player) {
                    llllllllllllllllIIIllIIIlIIlIllI.drawString("b", llllllllllllllllIIIllIIIlIIllIll + 2, llllllllllllllllIIIllIIIlIIlIIlI + 30 - llllllllllllllllIIIllIIIlIIlIlII.fr.getHeight() / 2 - (llllllllllllllllIIIllIIIlIIlIlIl ? 1 : 0), -1);
                }
                if (llllllllllllllllIIIllIIIlIIlIlII.category == Category.Render) {
                    llllllllllllllllIIIllIIIlIIlIllI.drawString("f", llllllllllllllllIIIllIIIlIIllIll + 2, llllllllllllllllIIIllIIIlIIlIIlI + 30 - llllllllllllllllIIIllIIIlIIlIlII.fr.getHeight() / 2 - (llllllllllllllllIIIllIIIlIIlIlIl ? 1 : 0), -1);
                }
                if (llllllllllllllllIIIllIIIlIIlIlII.category == Category.Misc) {
                    llllllllllllllllIIIllIIIlIIlIllI.drawString("h", llllllllllllllllIIIllIIIlIIllIll + 3, llllllllllllllllIIIllIIIlIIlIIlI + 30 - llllllllllllllllIIIllIIIlIIlIlII.fr.getHeight() / 2 - (llllllllllllllllIIIllIIIlIIlIlIl ? 1 : 0), -1);
                }
                if (llllllllllllllllIIIllIIIlIIlIlII.category == Category.Config) {
                    llllllllllllllllIIIllIIIlIIlIllI.drawString("j", llllllllllllllllIIIllIIIlIIllIll + 3, llllllllllllllllIIIllIIIlIIlIIlI + 30 - llllllllllllllllIIIllIIIlIIlIlII.fr.getHeight() / 2 - (llllllllllllllllIIIllIIIlIIlIlIl ? 1 : 0), -1);
                }
                llllllllllllllllIIIllIIIlIIlIlII.fr.drawCenteredString(llllllllllllllllIIIllIIIlIIlIlII.category.name(), llllllllllllllllIIIllIIIlIIllIll + 50, llllllllllllllllIIIllIIIlIIlIIlI + 30 - llllllllllllllllIIIllIIIlIIlIlII.fr.getHeight() / 2 - (llllllllllllllllIIIllIIIlIIlIlIl ? 1 : 0), -1);
                if (Client.gui.currentPanel != llllllllllllllllIIIllIIIlIIlIlII) break block14;
                if (llllllllllllllllIIIllIIIlIIlIlII.mods.size() <= 0) break block15;
                llllllllllllllllIIIllIIIlIIlIlII.mods.get((int)0).anim = MathUtils.lerp(llllllllllllllllIIIllIIIlIIlIlII.mods.get((int)0).anim, 1.0f, 0.3f);
                for (int llllllllllllllllIIIllIIIlIIllllI = 0; llllllllllllllllIIIllIIIlIIllllI < llllllllllllllllIIIllIIIlIIlIlII.mods.size() - 1; ++llllllllllllllllIIIllIIIlIIllllI) {
                    if (!(llllllllllllllllIIIllIIIlIIlIlII.mods.get((int)llllllllllllllllIIIllIIIlIIllllI).anim > 0.98f)) continue;
                    llllllllllllllllIIIllIIIlIIlIlII.mods.get((int)(llllllllllllllllIIIllIIIlIIllllI + 1)).anim = MathUtils.lerp(llllllllllllllllIIIllIIIlIIlIlII.mods.get((int)(llllllllllllllllIIIllIIIlIIllllI + 1)).anim, 1.0f, 0.3f);
                }
                break block15;
            }
            for (Mod llllllllllllllllIIIllIIIlIIlllIl : llllllllllllllllIIIllIIIlIIlIlII.mods) {
                llllllllllllllllIIIllIIIlIIlllIl.reset();
            }
        }
    }

    public Panel(Category llllllllllllllllIIIllIIIllIIlIll) {
        Panel llllllllllllllllIIIllIIIllIIlIlI;
        llllllllllllllllIIIllIIIllIIlIlI.fr = Fonts.mntsb_20;
        llllllllllllllllIIIllIIIllIIlIlI.scroll = 0.0f;
        llllllllllllllllIIIllIIIllIIlIlI.scrollTo = 0;
        llllllllllllllllIIIllIIIllIIlIlI.color = -1;
        llllllllllllllllIIIllIIIllIIlIlI.mods = new ArrayList();
        llllllllllllllllIIIllIIIllIIlIlI.category = llllllllllllllllIIIllIIIllIIlIll;
        for (Module llllllllllllllllIIIllIIIllIIllIl : Client.moduleManager.getModules(llllllllllllllllIIIllIIIllIIlIll)) {
            llllllllllllllllIIIllIIIllIIlIlI.mods.add(new Mod(llllllllllllllllIIIllIIIllIIllIl));
        }
    }

    @Override
    public void mouseClicked(int llllllllllllllllIIIllIIIlIIIIIll, int llllllllllllllllIIIllIIIIlllllII, int llllllllllllllllIIIllIIIlIIIIIIl, int llllllllllllllllIIIllIIIlIIIIIII, int llllllllllllllllIIIllIIIIlllllll) throws IOException {
        Panel llllllllllllllllIIIllIIIlIIIIlII;
        super.mouseClicked(llllllllllllllllIIIllIIIlIIIIIll, llllllllllllllllIIIllIIIIlllllII, llllllllllllllllIIIllIIIlIIIIIIl, llllllllllllllllIIIllIIIlIIIIIII, llllllllllllllllIIIllIIIIlllllll);
        if (llllllllllllllllIIIllIIIlIIIIlII.ishover(llllllllllllllllIIIllIIIlIIIIIll, llllllllllllllllIIIllIIIIlllllII + 20, llllllllllllllllIIIllIIIlIIIIIll + 100, llllllllllllllllIIIllIIIIlllllII + 40, llllllllllllllllIIIllIIIlIIIIIIl, llllllllllllllllIIIllIIIlIIIIIII)) {
            Client.gui.currentPanel = llllllllllllllllIIIllIIIlIIIIlII;
        }
    }

    public void mouseClickedOpen(int llllllllllllllllIIIllIIIIllIIllI, int llllllllllllllllIIIllIIIIllIllII, int llllllllllllllllIIIllIIIIllIIlII, int llllllllllllllllIIIllIIIIllIlIlI, int llllllllllllllllIIIllIIIIllIIIlI) throws IOException {
        Panel llllllllllllllllIIIllIIIIllIlllI;
        super.mouseClicked(llllllllllllllllIIIllIIIIllIIllI, llllllllllllllllIIIllIIIIllIllII, llllllllllllllllIIIllIIIIllIIlII, llllllllllllllllIIIllIIIIllIlIlI, llllllllllllllllIIIllIIIIllIIIlI);
        int llllllllllllllllIIIllIIIIllIlIII = (int)(5.0f + llllllllllllllllIIIllIIIIllIlllI.scroll);
        for (Mod llllllllllllllllIIIllIIIIllIllll : llllllllllllllllIIIllIIIIllIlllI.mods) {
            llllllllllllllllIIIllIIIIllIllll.mouseClicked(llllllllllllllllIIIllIIIIllIIllI + 105, llllllllllllllllIIIllIIIIllIllII + llllllllllllllllIIIllIIIIllIlIII, llllllllllllllllIIIllIIIIllIIlII, llllllllllllllllIIIllIIIIllIlIlI, llllllllllllllllIIIllIIIIllIIIlI);
            llllllllllllllllIIIllIIIIllIlIII = (int)((float)llllllllllllllllIIIllIIIIllIlIII + (llllllllllllllllIIIllIIIIllIllll.getHeight() + 2.0f));
        }
    }

    public Category getCategory() {
        Panel llllllllllllllllIIIllIIIllIIIlIl;
        return llllllllllllllllIIIllIIIllIIIlIl.category;
    }

    @Override
    public void initGui() {
        Panel llllllllllllllllIIIllIIIIlIlllII;
        super.initGui();
        llllllllllllllllIIIllIIIIlIlllII.color = -1;
    }
}

