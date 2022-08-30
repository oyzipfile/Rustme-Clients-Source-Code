/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Gui
 *  org.lwjgl.opengl.GL11
 */
package click.component.components.sub;

import click.component.Component;
import click.component.components.Button;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import org.lwjgl.opengl.GL11;
import ru.internali.module.Module;

public class VisibleButton
extends Component {
    private /* synthetic */ int y;
    private /* synthetic */ Module mod;
    private /* synthetic */ boolean hovered;
    private /* synthetic */ Button parent;
    private /* synthetic */ int offset;
    private /* synthetic */ int x;

    public boolean isMouseOnButton(int lIlIlIIlllIIlll, int lIlIlIIlllIIllI) {
        VisibleButton lIlIlIIlllIlIll;
        return lIlIlIIlllIIlll > lIlIlIIlllIlIll.x && lIlIlIIlllIIlll < lIlIlIIlllIlIll.x + 88 && lIlIlIIlllIIllI > lIlIlIIlllIlIll.y && lIlIlIIlllIIllI < lIlIlIIlllIlIll.y + 12;
    }

    public VisibleButton(Button lIlIlIlIIIlIIll, Module lIlIlIlIIIlIIlI, int lIlIlIlIIIIllIl) {
        VisibleButton lIlIlIlIIIlIIII;
        lIlIlIlIIIlIIII.parent = lIlIlIlIIIlIIll;
        lIlIlIlIIIlIIII.mod = lIlIlIlIIIlIIlI;
        lIlIlIlIIIlIIII.x = lIlIlIlIIIlIIll.parent.getX() + lIlIlIlIIIlIIll.parent.getWidth();
        lIlIlIlIIIlIIII.y = lIlIlIlIIIlIIll.parent.getY() + lIlIlIlIIIlIIll.offset;
        lIlIlIlIIIlIIII.offset = lIlIlIlIIIIllIl;
    }

    @Override
    public void mouseClicked(int lIlIlIIllllIIIl, int lIlIlIIllllIIII, int lIlIlIIlllIllll) {
        VisibleButton lIlIlIIllllIIlI;
        if (lIlIlIIllllIIlI.isMouseOnButton(lIlIlIIllllIIIl, lIlIlIIllllIIII) && lIlIlIIlllIllll == 0 && lIlIlIIllllIIlI.parent.open) {
            lIlIlIIllllIIlI.mod.visible = !lIlIlIIllllIIlI.mod.visible;
        }
    }

    @Override
    public void renderComponent() {
        VisibleButton lIlIlIlIIIIIlIl;
        Gui.drawRect((int)(lIlIlIlIIIIIlIl.parent.parent.getX() + 2), (int)(lIlIlIlIIIIIlIl.parent.parent.getY() + lIlIlIlIIIIIlIl.offset), (int)(lIlIlIlIIIIIlIl.parent.parent.getX() + lIlIlIlIIIIIlIl.parent.parent.getWidth() * 1), (int)(lIlIlIlIIIIIlIl.parent.parent.getY() + lIlIlIlIIIIIlIl.offset + 12), (int)(lIlIlIlIIIIIlIl.hovered ? -14540254 : -15658735));
        Gui.drawRect((int)lIlIlIlIIIIIlIl.parent.parent.getX(), (int)(lIlIlIlIIIIIlIl.parent.parent.getY() + lIlIlIlIIIIIlIl.offset), (int)(lIlIlIlIIIIIlIl.parent.parent.getX() + 2), (int)(lIlIlIlIIIIIlIl.parent.parent.getY() + lIlIlIlIIIIIlIl.offset + 12), (int)-15658735);
        GL11.glPushMatrix();
        GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
        Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(String.valueOf(new StringBuilder().append("Visible: ").append(lIlIlIlIIIIIlIl.mod.visible)), (float)((lIlIlIlIIIIIlIl.parent.parent.getX() + 7) * 2), (float)((lIlIlIlIIIIIlIl.parent.parent.getY() + lIlIlIlIIIIIlIl.offset + 2) * 2 + 5), -1);
        GL11.glPopMatrix();
    }

    @Override
    public void setOff(int lIlIlIlIIIIlIIl) {
        lIlIlIlIIIIlIlI.offset = lIlIlIlIIIIlIIl;
    }

    @Override
    public void updateComponent(int lIlIlIIllllllll, int lIlIlIIlllllllI) {
        VisibleButton lIlIlIIllllllIl;
        lIlIlIIllllllIl.hovered = lIlIlIIllllllIl.isMouseOnButton(lIlIlIIllllllll, lIlIlIIlllllllI);
        lIlIlIIllllllIl.y = lIlIlIIllllllIl.parent.parent.getY() + lIlIlIIllllllIl.offset;
        lIlIlIIllllllIl.x = lIlIlIIllllllIl.parent.parent.getX();
    }
}

