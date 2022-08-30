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
import ru.internali.settings.Setting;

public class Checkbox
extends Component {
    private /* synthetic */ boolean hovered;
    private /* synthetic */ int y;
    private /* synthetic */ int x;
    private /* synthetic */ Button parent;
    private /* synthetic */ int offset;
    private /* synthetic */ Setting op;

    public Checkbox(Setting lllllllIIIIIl, Button lllllllIIIlII, int llllllIllllll) {
        Checkbox lllllllIIIllI;
        lllllllIIIllI.op = lllllllIIIIIl;
        lllllllIIIllI.parent = lllllllIIIlII;
        lllllllIIIllI.x = lllllllIIIlII.parent.getX() + lllllllIIIlII.parent.getWidth();
        lllllllIIIllI.y = lllllllIIIlII.parent.getY() + lllllllIIIlII.offset;
        lllllllIIIllI.offset = llllllIllllll;
    }

    @Override
    public void setOff(int llllllIlllIII) {
        llllllIlllIIl.offset = llllllIlllIII;
    }

    @Override
    public void renderComponent() {
        Checkbox llllllIllllIl;
        Gui.drawRect((int)(llllllIllllIl.parent.parent.getX() + 2), (int)(llllllIllllIl.parent.parent.getY() + llllllIllllIl.offset), (int)(llllllIllllIl.parent.parent.getX() + llllllIllllIl.parent.parent.getWidth() * 1), (int)(llllllIllllIl.parent.parent.getY() + llllllIllllIl.offset + 12), (int)(llllllIllllIl.hovered ? -14540254 : -15658735));
        Gui.drawRect((int)llllllIllllIl.parent.parent.getX(), (int)(llllllIllllIl.parent.parent.getY() + llllllIllllIl.offset), (int)(llllllIllllIl.parent.parent.getX() + 2), (int)(llllllIllllIl.parent.parent.getY() + llllllIllllIl.offset + 12), (int)-15658735);
        GL11.glPushMatrix();
        GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
        Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(llllllIllllIl.op.getName(), (float)((llllllIllllIl.parent.parent.getX() + 10 + 4) * 2 + 5), (float)((llllllIllllIl.parent.parent.getY() + llllllIllllIl.offset + 2) * 2 + 4), -1);
        GL11.glPopMatrix();
        Gui.drawRect((int)(llllllIllllIl.parent.parent.getX() + 3 + 4), (int)(llllllIllllIl.parent.parent.getY() + llllllIllllIl.offset + 3), (int)(llllllIllllIl.parent.parent.getX() + 9 + 4), (int)(llllllIllllIl.parent.parent.getY() + llllllIllllIl.offset + 9), (int)-6710887);
        if (llllllIllllIl.op.getValBoolean()) {
            Gui.drawRect((int)(llllllIllllIl.parent.parent.getX() + 4 + 4), (int)(llllllIllllIl.parent.parent.getY() + llllllIllllIl.offset + 4), (int)(llllllIllllIl.parent.parent.getX() + 8 + 4), (int)(llllllIllllIl.parent.parent.getY() + llllllIllllIl.offset + 8), (int)-10066330);
        }
    }

    @Override
    public void mouseClicked(int llllllIlIIlll, int llllllIlIIllI, int llllllIlIIIIl) {
        Checkbox llllllIlIIlII;
        if (llllllIlIIlII.isMouseOnButton(llllllIlIIlll, llllllIlIIllI) && llllllIlIIIIl == 0 && llllllIlIIlII.parent.open) {
            llllllIlIIlII.op.setValBoolean(!llllllIlIIlII.op.getValBoolean());
        }
    }

    @Override
    public void updateComponent(int llllllIlIlllI, int llllllIlIllIl) {
        Checkbox llllllIlIllll;
        llllllIlIllll.hovered = llllllIlIllll.isMouseOnButton(llllllIlIlllI, llllllIlIllIl);
        llllllIlIllll.y = llllllIlIllll.parent.parent.getY() + llllllIlIllll.offset;
        llllllIlIllll.x = llllllIlIllll.parent.parent.getX();
    }

    public boolean isMouseOnButton(int llllllIIlllII, int llllllIIllIll) {
        Checkbox llllllIIlllIl;
        return llllllIIlllII > llllllIIlllIl.x && llllllIIlllII < llllllIIlllIl.x + 88 && llllllIIllIll > llllllIIlllIl.y && llllllIIllIll < llllllIIlllIl.y + 12;
    }
}

