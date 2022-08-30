/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.client.GuiIngameForge
 */
package ru.internali.module.render;

import net.minecraftforge.client.GuiIngameForge;
import ru.internali.module.Category;
import ru.internali.module.Module;

public class NoOverlay
extends Module {
    public static final /* synthetic */ NoOverlay INSTANCE;

    @Override
    public void onDisable() {
        NoOverlay llllllIlIlIIIll;
        super.onDisable();
        GuiIngameForge.renderObjective = true;
    }

    @Override
    public void onEnable() {
        NoOverlay llllllIlIlIIlIl;
        super.onEnable();
        GuiIngameForge.renderObjective = false;
    }

    static {
        INSTANCE = new NoOverlay();
    }

    public NoOverlay() {
        super("NoOverlay", "TabOFF", Category.RENDER);
        NoOverlay llllllIlIlIlIII;
    }
}

