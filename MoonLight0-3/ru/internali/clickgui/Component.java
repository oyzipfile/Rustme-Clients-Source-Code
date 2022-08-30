/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.FontRenderer
 */
package ru.internali.clickgui;

import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import ru.internali.module.Module;
import ru.internali.settings.Setting;

public class Component {
    public /* synthetic */ Minecraft mc;
    public /* synthetic */ int width;
    /* synthetic */ float anim;
    public /* synthetic */ String displayString;
    protected /* synthetic */ FontRenderer fr;
    public /* synthetic */ int height;
    public /* synthetic */ int x;
    public /* synthetic */ Setting set;
    public /* synthetic */ int y;
    public /* synthetic */ Module mod;

    public void initGui() {
    }

    public void drawScreen(int lIIIlIIlIlIlllI, int lIIIlIIlIlIllIl, int lIIIlIIlIlIllII, int lIIIlIIlIlIlIll, float lIIIlIIlIlIlIlI) {
    }

    public Component() {
        Component lIIIlIIlIllIIll;
        lIIIlIIlIllIIll.anim = 0.0f;
        lIIIlIIlIllIIll.mc = Minecraft.getMinecraft();
        lIIIlIIlIllIIll.fr = Minecraft.getMinecraft().fontRenderer;
    }

    public float getWidth() {
        return 100.0f;
    }

    public void mouseClicked(int lIIIlIIlIlIlIII, int lIIIlIIlIlIIlll, int lIIIlIIlIlIIllI, int lIIIlIIlIlIIlIl, int lIIIlIIlIlIIlII) throws IOException {
    }

    public void reset() {
        lIIIlIIlIllIIII.anim = 0.0f;
    }

    public boolean ishover(float lIIIlIIllIIIIll, float lIIIlIIllIIIIlI, float lIIIlIIllIIIIIl, float lIIIlIIlIlllIlI, int lIIIlIIlIlllIIl, int lIIIlIIlIlllIII) {
        return (float)lIIIlIIlIlllIIl >= lIIIlIIllIIIIll && (float)lIIIlIIlIlllIIl <= lIIIlIIllIIIIIl && (float)lIIIlIIlIlllIII >= lIIIlIIllIIIIlI && (float)lIIIlIIlIlllIII <= lIIIlIIlIlllIlI;
    }

    public float getHeight() {
        return 10.0f;
    }
}

