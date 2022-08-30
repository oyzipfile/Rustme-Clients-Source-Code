/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.renderer.RenderItem
 */
package ru.internali.module.MANAGER;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderItem;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;

public class Binding
extends Module {
    private static /* synthetic */ RenderItem itemRender;

    @Override
    public void onEnable() {
        Binding lIlIlIIlIllIIII;
        super.onEnable();
        mc.displayGuiScreen((GuiScreen)CatClient.instance.csgui);
        lIlIlIIlIllIIII.setToggled(false);
    }

    public Binding() {
        super("Binding", "ArmorHUD", Category.MANAGER);
        Binding lIlIlIIlIllIlII;
    }
}

