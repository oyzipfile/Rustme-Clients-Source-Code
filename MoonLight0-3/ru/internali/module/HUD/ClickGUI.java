/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 */
package ru.internali.module.HUD;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiScreen;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;

public class ClickGUI
extends Module {
    public static /* synthetic */ List<String> Modes;

    public ClickGUI() {
        super("ClickGUI", "menu.skeet", Category.HUD);
        ClickGUI llIlIIlllIlIII;
        llIlIIlllIlIII.setKey(54);
    }

    static {
        Modes = new ArrayList<String>();
    }

    @Override
    public void onEnable() {
        ClickGUI llIlIIlllIIlIl;
        super.onEnable();
        mc.displayGuiScreen((GuiScreen)CatClient.guib);
        llIlIIlllIIlIl.setToggled(false);
    }
}

