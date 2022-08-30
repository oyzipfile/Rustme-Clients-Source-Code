/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 */
package ru.internali.module.HUD;

import net.minecraft.client.gui.GuiScreen;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;

public class HudEditor
extends Module {
    public HudEditor() {
        super("HudEditor", "HudEditor", Category.HUD);
        HudEditor lIIlIlIIIlIllIl;
    }

    @Override
    public void onEnable() {
        HudEditor lIIlIlIIIlIlIlI;
        super.onEnable();
        mc.displayGuiScreen((GuiScreen)CatClient.hudEditor);
        lIIlIlIIIlIlIlI.setToggled(false);
    }
}

