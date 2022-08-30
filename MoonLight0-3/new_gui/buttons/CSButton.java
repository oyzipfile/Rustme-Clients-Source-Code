/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.Gui
 */
package new_gui.buttons;

import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

public abstract class CSButton
extends Gui {
    public /* synthetic */ int width;
    public /* synthetic */ int x;
    public /* synthetic */ int y;
    public /* synthetic */ int color;
    public /* synthetic */ String displayString;
    public /* synthetic */ Minecraft mc;
    public /* synthetic */ int height;
    public /* synthetic */ FontRenderer fr;

    public void initButton() {
    }

    public void keyTyped(char lIIIIllIlIIIIlI, int lIIIIllIlIIIIIl) throws IOException {
    }

    public void mouseClicked(int lIIIIllIIllllII, int lIIIIllIIlllIll, int lIIIIllIIlllIlI) throws IOException {
    }

    public CSButton(int lIIIIllIlIlIlII, int lIIIIllIlIlIIll, int lIIIIllIlIlIIlI, int lIIIIllIlIIlIlI, int lIIIIllIlIIlIIl, String lIIIIllIlIIllll) {
        CSButton lIIIIllIlIlIlIl;
        lIIIIllIlIlIlIl.mc = Minecraft.getMinecraft();
        lIIIIllIlIlIlIl.fr = lIIIIllIlIlIlIl.mc.fontRenderer;
        lIIIIllIlIlIlIl.x = lIIIIllIlIlIlII;
        lIIIIllIlIlIlIl.y = lIIIIllIlIlIIll;
        lIIIIllIlIlIlIl.width = lIIIIllIlIlIIlI;
        lIIIIllIlIlIlIl.height = lIIIIllIlIIlIlI;
        lIIIIllIlIlIlIl.color = lIIIIllIlIIlIIl;
        lIIIIllIlIlIlIl.displayString = lIIIIllIlIIllll;
    }

    public void drawScreen(int lIIIIllIlIIIllI, int lIIIIllIlIIIlIl, float lIIIIllIlIIIlII) {
    }

    public void onKeyPress(int lIIIIllIIllllll, int lIIIIllIIlllllI) {
    }

    public void mouseReleased(int lIIIIllIIlllIII, int lIIIIllIIllIlll, int lIIIIllIIllIllI) {
    }
}

