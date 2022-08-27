/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package ru.hld.legendline.impl.modules.Render;

import org.lwjgl.opengl.GL11;
import ru.hld.legendline.Client;
import ru.hld.legendline.antiNative.RenderUtils;
import ru.hld.legendline.api.event.EventTarget;
import ru.hld.legendline.api.event.events.EventRender2D;
import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.api.utils.ColorUtils;

public class DamageColor
extends Module {
    /* synthetic */ float gh;
    /* synthetic */ float gh2;

    @EventTarget
    public void onRender2D(EventRender2D llllllllllllllIIIlllIIIIlIllllll) {
        DamageColor llllllllllllllIIIlllIIIIlIllllII;
        int llllllllllllllIIIlllIIIIlIlllllI = llllllllllllllIIIlllIIIIlIllllII.getPosX();
        int llllllllllllllIIIlllIIIIlIllllIl = llllllllllllllIIIlllIIIIlIllllII.getPosY();
        GL11.glPushMatrix();
        llllllllllllllIIIlllIIIIlIllllII.gh = llllllllllllllIIIlllIIIIlIllllII.mc.player.getHealth();
        if (llllllllllllllIIIlllIIIIlIllllII.mc.player.hurtTime > 0) {
            llllllllllllllIIIlllIIIIlIllllII.fr.drawString(String.valueOf(new StringBuilder().append("-").append((int)(llllllllllllllIIIlllIIIIlIllllII.gh2 - llllllllllllllIIIlllIIIIlIllllII.gh))), llllllllllllllIIIlllIIIIlIlllllI + 2, llllllllllllllIIIlllIIIIlIllllIl + 2, Client.getColor());
            RenderUtils.drawRect(0.0f, 0.0f, 1000.0f, 1000.0f, ColorUtils.getColor(255, 30, 40, llllllllllllllIIIlllIIIIlIllllII.mc.player.hurtTime * 8));
        } else {
            llllllllllllllIIIlllIIIIlIllllII.gh2 = llllllllllllllIIIlllIIIIlIllllII.gh;
        }
        GL11.glPopMatrix();
    }

    public DamageColor() {
        super("DamageColor", "show you damage", Category.Render, 50, 20, 100, 100);
        DamageColor llllllllllllllIIIlllIIIIllIIIlII;
    }
}

