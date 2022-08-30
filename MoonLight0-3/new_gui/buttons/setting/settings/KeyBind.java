/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 */
package new_gui.buttons.setting.settings;

import java.io.IOException;
import new_gui.buttons.setting.CSSetting;
import org.lwjgl.input.Keyboard;
import ru.internali.module.Module;

public class KeyBind
extends CSSetting {
    private /* synthetic */ boolean binding;

    @Override
    public void drawScreen(int lIlIlIIIlllIlII, int lIlIlIIIlllIIll, float lIlIlIIIlllIIlI) {
        KeyBind lIlIlIIIllllIll;
        String lIlIlIIIlllIlll = String.valueOf(new StringBuilder().append("KeyBind: ").append(Keyboard.getKeyName((int)lIlIlIIIllllIll.mod.getKey())));
        if (lIlIlIIIllllIll.binding) {
            lIlIlIIIlllIlll = "Listen... ";
            lIlIlIIIllllIll.fr.drawString(lIlIlIIIlllIlll, lIlIlIIIllllIll.x, lIlIlIIIllllIll.y, Integer.MAX_VALUE);
        }
        lIlIlIIIllllIll.fr.drawString(lIlIlIIIlllIlll, lIlIlIIIllllIll.x, lIlIlIIIllllIll.y, Integer.MAX_VALUE);
        int lIlIlIIIlllIllI = lIlIlIIIllllIll.fr.getStringWidth(lIlIlIIIlllIlll);
        if (lIlIlIIIllllIll.binding && Keyboard.getEventKey() != 0 && Keyboard.getEventKeyState()) {
            lIlIlIIIllllIll.mod.setKey(Keyboard.getEventKey());
            lIlIlIIIllllIll.binding = false;
        }
        super.drawScreen(lIlIlIIIlllIlII, lIlIlIIIlllIIll, lIlIlIIIlllIIlI);
    }

    public void setBinding(boolean lIlIlIIlIIIIIlI) {
        lIlIlIIlIIIIlIl.binding = lIlIlIIlIIIIIlI;
    }

    public KeyBind(int lIlIlIIlIIlIlIl, int lIlIlIIlIIllIlI, int lIlIlIIlIIlIIll, int lIlIlIIlIIlIIlI, Module lIlIlIIlIIlIlll) {
        super(lIlIlIIlIIlIlIl, lIlIlIIlIIllIlI, lIlIlIIlIIlIIll, lIlIlIIlIIlIIlI, lIlIlIIlIIlIlll);
        KeyBind lIlIlIIlIIlIllI;
    }

    @Override
    public void mouseClicked(int lIlIlIIIllIIllI, int lIlIlIIIllIIlIl, int lIlIlIIIllIlIII) throws IOException {
        KeyBind lIlIlIIIllIlIll;
        if (lIlIlIIIllIlIll.isHovered(lIlIlIIIllIIllI, lIlIlIIIllIIlIl) && lIlIlIIIllIlIII == 0) {
            lIlIlIIIllIlIll.setBinding(true);
        }
        super.mouseClicked(lIlIlIIIllIIllI, lIlIlIIIllIIlIl, lIlIlIIIllIlIII);
    }

    private boolean isHovered(int lIlIlIIIlIlllII, int lIlIlIIIlIlIlIl) {
        KeyBind lIlIlIIIlIlllIl;
        int lIlIlIIIlIllIlI = lIlIlIIIlIlllIl.fr.getStringWidth(lIlIlIIIlIlllIl.displayString);
        boolean lIlIlIIIlIllIIl = lIlIlIIIlIlllII > lIlIlIIIlIlllIl.x + 15 && lIlIlIIIlIlllII < lIlIlIIIlIlllIl.x + lIlIlIIIlIllIlI + 35;
        boolean lIlIlIIIlIllIII = lIlIlIIIlIlIlIl > lIlIlIIIlIlllIl.y && lIlIlIIIlIlIlIl < lIlIlIIIlIlllIl.y + 10;
        return lIlIlIIIlIllIIl && lIlIlIIIlIllIII;
    }

    @Override
    public void keyTyped(char lIlIlIIlIIIlIIl, int lIlIlIIlIIIlIll) throws IOException {
        KeyBind lIlIlIIlIIIlIlI;
        super.keyTyped(lIlIlIIlIIIlIIl, lIlIlIIlIIIlIll);
    }
}

