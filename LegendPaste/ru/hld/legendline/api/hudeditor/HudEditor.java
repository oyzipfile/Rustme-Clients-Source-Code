/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 */
package ru.hld.legendline.api.hudeditor;

import java.io.IOException;
import java.util.ArrayList;
import net.minecraft.client.gui.GuiScreen;
import ru.hld.legendline.Client;
import ru.hld.legendline.api.hudeditor.HudComponent;
import ru.hld.legendline.api.module.Module;

public class HudEditor
extends GuiScreen {
    /* synthetic */ ArrayList<HudComponent> hudComponents;

    protected void mouseClicked(int llllllllllllllIIlIlIllIIIIlIllIl, int llllllllllllllIIlIlIllIIIIlIllII, int llllllllllllllIIlIlIllIIIIlIlIll) throws IOException {
        HudEditor llllllllllllllIIlIlIllIIIIlIlllI;
        super.mouseClicked(llllllllllllllIIlIlIllIIIIlIllIl, llllllllllllllIIlIlIllIIIIlIllII, llllllllllllllIIlIlIllIIIIlIlIll);
        for (HudComponent llllllllllllllIIlIlIllIIIIlIllll : llllllllllllllIIlIlIllIIIIlIlllI.hudComponents) {
            llllllllllllllIIlIlIllIIIIlIllll.mouseClicked(llllllllllllllIIlIlIllIIIIlIllIl, llllllllllllllIIlIlIllIIIIlIllII, llllllllllllllIIlIlIllIIIIlIlIll);
        }
    }

    public HudEditor() {
        HudEditor llllllllllllllIIlIlIllIIIIlllIIl;
        llllllllllllllIIlIlIllIIIIlllIIl.hudComponents = new ArrayList();
        for (Module llllllllllllllIIlIlIllIIIIlllIlI : Client.moduleManager.modules) {
            if (!llllllllllllllIIlIlIllIIIIlllIlI.isHud()) continue;
            llllllllllllllIIlIlIllIIIIlllIIl.hudComponents.add(new HudComponent(llllllllllllllIIlIlIllIIIIlllIlI));
        }
    }

    public void drawScreen(int llllllllllllllIIlIlIllIIIIIllIII, int llllllllllllllIIlIlIllIIIIIllIll, float llllllllllllllIIlIlIllIIIIIllIlI) {
        HudEditor llllllllllllllIIlIlIllIIIIIlllIl;
        super.drawScreen(llllllllllllllIIlIlIllIIIIIllIII, llllllllllllllIIlIlIllIIIIIllIll, llllllllllllllIIlIlIllIIIIIllIlI);
        for (HudComponent llllllllllllllIIlIlIllIIIIIllllI : llllllllllllllIIlIlIllIIIIIlllIl.hudComponents) {
            llllllllllllllIIlIlIllIIIIIllllI.drawScreen(llllllllllllllIIlIlIllIIIIIllIII, llllllllllllllIIlIlIllIIIIIllIll, llllllllllllllIIlIlIllIIIIIllIlI);
        }
    }
}

