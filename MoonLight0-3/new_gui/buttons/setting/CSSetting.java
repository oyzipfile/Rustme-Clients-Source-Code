/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.FontRenderer
 */
package new_gui.buttons.setting;

import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import ru.internali.module.Module;
import ru.internali.settings.Setting;

public class CSSetting {
    public /* synthetic */ Minecraft mc;
    public /* synthetic */ int height;
    public /* synthetic */ Module mod;
    public /* synthetic */ String displayString;
    public /* synthetic */ Setting set;
    public /* synthetic */ int y;
    public /* synthetic */ int width;
    public /* synthetic */ int x;
    public /* synthetic */ FontRenderer fr;

    public void mouseClicked(int lllIllllIIIIll, int lllIllllIIIIlI, int lllIllllIIIIIl) throws IOException {
    }

    public CSSetting(int lllIllllIlIIll, int lllIllllIlIIlI, int lllIllllIlIIIl, int lllIllllIlIIII, Module lllIllllIlIlIl) {
        CSSetting lllIllllIllIlI;
        lllIllllIllIlI.mc = Minecraft.getMinecraft();
        lllIllllIllIlI.fr = lllIllllIllIlI.mc.fontRenderer;
        lllIllllIllIlI.x = lllIllllIlIIll;
        lllIllllIllIlI.y = lllIllllIlIIlI;
        lllIllllIllIlI.width = lllIllllIlIIIl;
        lllIllllIllIlI.height = lllIllllIlIIII;
        lllIllllIllIlI.mod = lllIllllIlIlIl;
        lllIllllIllIlI.displayString = lllIllllIlIlIl.getName();
    }

    public void keyTyped(char lllIllllIIlIIl, int lllIllllIIlIII) throws IOException {
    }

    public void onKeyPress(int lllIllllIIIllI, int lllIllllIIIlIl) {
    }

    public CSSetting(int lllIlllllIIlIl, int lllIlllllIIlII, int lllIlllllIlIIl, int lllIlllllIlIII, Setting lllIlllllIIlll) {
        CSSetting lllIlllllIllII;
        lllIlllllIllII.mc = Minecraft.getMinecraft();
        lllIlllllIllII.fr = lllIlllllIllII.mc.fontRenderer;
        lllIlllllIllII.x = lllIlllllIIlIl;
        lllIlllllIllII.y = lllIlllllIIlII;
        lllIlllllIllII.width = lllIlllllIlIIl;
        lllIlllllIllII.height = lllIlllllIlIII;
        lllIlllllIllII.set = lllIlllllIIlll;
        lllIlllllIllII.displayString = lllIlllllIIlll.getName();
    }

    public void initButton() {
    }

    public void mouseReleased(int lllIlllIllllll, int lllIlllIlllllI, int lllIlllIllllIl) {
    }

    public void drawScreen(int lllIllllIIllIl, int lllIllllIIllII, float lllIllllIIlIll) {
    }
}

