/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 */
package ru.internali.utils.HudEditor;

import java.io.IOException;
import java.util.ArrayList;
import net.minecraft.client.gui.GuiScreen;
import ru.internali.module.Module;
import ru.internali.module.ModuleManager;
import ru.internali.utils.HudEditor.HudComponent;

public class HudEditor
extends GuiScreen {
    /* synthetic */ ArrayList<HudComponent> hudComponents;

    protected void mouseClicked(int llIIlllllIIlIlI, int llIIlllllIIlllI, int llIIlllllIIllIl) throws IOException {
        HudEditor llIIlllllIIlIll;
        super.mouseClicked(llIIlllllIIlIlI, llIIlllllIIlllI, llIIlllllIIllIl);
        for (HudComponent llIIlllllIlIIIl : llIIlllllIIlIll.hudComponents) {
            if (!llIIlllllIlIIIl.module.isEnable()) continue;
            llIIlllllIlIIIl.mouseClicked(llIIlllllIIlIlI, llIIlllllIIlllI, llIIlllllIIllIl);
        }
    }

    public HudEditor() {
        HudEditor llIIllllllIlllI;
        llIIllllllIlllI.hudComponents = new ArrayList();
        for (Module llIIllllllIllll : ModuleManager.modules) {
            if (!llIIllllllIllll.isHud()) continue;
            llIIllllllIlllI.hudComponents.add(new HudComponent(llIIllllllIllll));
        }
    }

    public void drawScreen(int llIIlllllIlllII, int llIIlllllIllIll, float llIIlllllIlllll) {
        HudEditor llIIlllllIlllIl;
        super.drawScreen(llIIlllllIlllII, llIIlllllIllIll, llIIlllllIlllll);
        for (HudComponent llIIllllllIIIll : llIIlllllIlllIl.hudComponents) {
            if (!llIIllllllIIIll.module.isEnable()) continue;
            llIIllllllIIIll.drawScreen(llIIlllllIlllII, llIIlllllIllIll, llIIlllllIlllll);
        }
    }
}

