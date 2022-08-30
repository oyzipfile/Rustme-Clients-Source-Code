/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Gui
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.opengl.GL11
 */
package click.component.components.sub;

import click.component.Component;
import click.component.components.Button;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class Keybind
extends Component {
    private /* synthetic */ int x;
    private /* synthetic */ Button parent;
    private /* synthetic */ int y;
    private /* synthetic */ int offset;
    private /* synthetic */ boolean binding;
    private /* synthetic */ boolean hovered;

    @Override
    public void mouseClicked(int lIIlllllIllIIll, int lIIlllllIllIIlI, int lIIlllllIlIllIl) {
        Keybind lIIlllllIllIlII;
        if (lIIlllllIllIlII.isMouseOnButton(lIIlllllIllIIll, lIIlllllIllIIlI) && lIIlllllIlIllIl == 0 && lIIlllllIllIlII.parent.open) {
            lIIlllllIllIlII.binding = !lIIlllllIllIlII.binding;
        }
    }

    public boolean isMouseOnButton(int lIIlllllIlIIIIl, int lIIlllllIlIIIII) {
        Keybind lIIlllllIlIIIlI;
        return lIIlllllIlIIIIl > lIIlllllIlIIIlI.x && lIIlllllIlIIIIl < lIIlllllIlIIIlI.x + 88 && lIIlllllIlIIIII > lIIlllllIlIIIlI.y && lIIlllllIlIIIII < lIIlllllIlIIIlI.y + 12;
    }

    public Keybind(Button lIIllllllIIllII, int lIIllllllIIlllI) {
        Keybind lIIllllllIIllIl;
        lIIllllllIIllIl.parent = lIIllllllIIllII;
        lIIllllllIIllIl.x = lIIllllllIIllII.parent.getX() + lIIllllllIIllII.parent.getWidth();
        lIIllllllIIllIl.y = lIIllllllIIllII.parent.getY() + lIIllllllIIllII.offset;
        lIIllllllIIllIl.offset = lIIllllllIIlllI;
    }

    @Override
    public void setOff(int lIIllllllIIIlll) {
        lIIllllllIIlIII.offset = lIIllllllIIIlll;
    }

    @Override
    public void updateComponent(int lIIlllllIlllIlI, int lIIlllllIlllIIl) {
        Keybind lIIlllllIlllIll;
        lIIlllllIlllIll.hovered = lIIlllllIlllIll.isMouseOnButton(lIIlllllIlllIlI, lIIlllllIlllIIl);
        lIIlllllIlllIll.y = lIIlllllIlllIll.parent.parent.getY() + lIIlllllIlllIll.offset;
        lIIlllllIlllIll.x = lIIlllllIlllIll.parent.parent.getX();
    }

    @Override
    public void renderComponent() {
        Keybind lIIllllllIIIIll;
        Gui.drawRect((int)(lIIllllllIIIIll.parent.parent.getX() + 2), (int)(lIIllllllIIIIll.parent.parent.getY() + lIIllllllIIIIll.offset), (int)(lIIllllllIIIIll.parent.parent.getX() + lIIllllllIIIIll.parent.parent.getWidth() * 1), (int)(lIIllllllIIIIll.parent.parent.getY() + lIIllllllIIIIll.offset + 12), (int)(lIIllllllIIIIll.hovered ? -14540254 : -15658735));
        Gui.drawRect((int)lIIllllllIIIIll.parent.parent.getX(), (int)(lIIllllllIIIIll.parent.parent.getY() + lIIllllllIIIIll.offset), (int)(lIIllllllIIIIll.parent.parent.getX() + 2), (int)(lIIllllllIIIIll.parent.parent.getY() + lIIllllllIIIIll.offset + 12), (int)-15658735);
        GL11.glPushMatrix();
        GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
        Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(lIIllllllIIIIll.binding ? "Press a key..." : String.valueOf(new StringBuilder().append("Key: ").append(Keyboard.getKeyName((int)lIIllllllIIIIll.parent.mod.getKey()))), (float)((lIIllllllIIIIll.parent.parent.getX() + 7) * 2), (float)((lIIllllllIIIIll.parent.parent.getY() + lIIllllllIIIIll.offset + 2) * 2 + 5), -1);
        GL11.glPopMatrix();
    }

    @Override
    public void keyTyped(char lIIlllllIlIlIIl, int lIIlllllIlIlIII) {
        Keybind lIIlllllIlIlIlI;
        if (lIIlllllIlIlIlI.binding) {
            lIIlllllIlIlIlI.parent.mod.setKey(lIIlllllIlIlIII);
            lIIlllllIlIlIlI.binding = false;
        }
    }
}

