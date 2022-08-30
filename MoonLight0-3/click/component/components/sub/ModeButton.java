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
import ru.internali.settings.Setting;

public class ModeButton
extends Component {
    private /* synthetic */ boolean hovered;
    private /* synthetic */ int y;
    private /* synthetic */ Module mod;
    private /* synthetic */ int offset;
    private /* synthetic */ Button parent;
    private /* synthetic */ int modeIndex;
    private /* synthetic */ int x;
    private /* synthetic */ Setting set;

    @Override
    public void renderComponent() {
        ModeButton lIIIlIIIIIllllI;
        Gui.drawRect((int)(lIIIlIIIIIllllI.parent.parent.getX() + 2), (int)(lIIIlIIIIIllllI.parent.parent.getY() + lIIIlIIIIIllllI.offset), (int)(lIIIlIIIIIllllI.parent.parent.getX() + lIIIlIIIIIllllI.parent.parent.getWidth() * 1), (int)(lIIIlIIIIIllllI.parent.parent.getY() + lIIIlIIIIIllllI.offset + 12), (int)(lIIIlIIIIIllllI.hovered ? -14540254 : -15658735));
        Gui.drawRect((int)lIIIlIIIIIllllI.parent.parent.getX(), (int)(lIIIlIIIIIllllI.parent.parent.getY() + lIIIlIIIIIllllI.offset), (int)(lIIIlIIIIIllllI.parent.parent.getX() + 2), (int)(lIIIlIIIIIllllI.parent.parent.getY() + lIIIlIIIIIllllI.offset + 12), (int)-15658735);
        GL11.glPushMatrix();
        GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
        Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(String.valueOf(new StringBuilder().append("Mode: ").append(lIIIlIIIIIllllI.set.getValString())), (float)((lIIIlIIIIIllllI.parent.parent.getX() + 7) * 2), (float)((lIIIlIIIIIllllI.parent.parent.getY() + lIIIlIIIIIllllI.offset + 2) * 2 + 5), -1);
        GL11.glPopMatrix();
    }

    @Override
    public void updateComponent(int lIIIlIIIIIllIII, int lIIIlIIIIIlIlII) {
        ModeButton lIIIlIIIIIlIllI;
        lIIIlIIIIIlIllI.hovered = lIIIlIIIIIlIllI.isMouseOnButton(lIIIlIIIIIllIII, lIIIlIIIIIlIlII);
        lIIIlIIIIIlIllI.y = lIIIlIIIIIlIllI.parent.parent.getY() + lIIIlIIIIIlIllI.offset;
        lIIIlIIIIIlIllI.x = lIIIlIIIIIlIllI.parent.parent.getX();
    }

    @Override
    public void setOff(int lIIIlIIIIlIIIII) {
        lIIIlIIIIlIIIIl.offset = lIIIlIIIIlIIIII;
    }

    public boolean isMouseOnButton(int lIIIlIIIIIIIIII, int lIIIIllllllllII) {
        ModeButton lIIIIlllllllllI;
        return lIIIlIIIIIIIIII > lIIIIlllllllllI.x && lIIIlIIIIIIIIII < lIIIIlllllllllI.x + 88 && lIIIIllllllllII > lIIIIlllllllllI.y && lIIIIllllllllII < lIIIIlllllllllI.y + 12;
    }

    @Override
    public void mouseClicked(int lIIIlIIIIIIllII, int lIIIlIIIIIIIlll, int lIIIlIIIIIIlIlI) {
        ModeButton lIIIlIIIIIIllIl;
        if (lIIIlIIIIIIllIl.isMouseOnButton(lIIIlIIIIIIllII, lIIIlIIIIIIIlll) && lIIIlIIIIIIlIlI == 0 && lIIIlIIIIIIllIl.parent.open) {
            int lIIIlIIIIIIlllI = lIIIlIIIIIIllIl.set.getOptions().size();
            lIIIlIIIIIIllIl.modeIndex = lIIIlIIIIIIllIl.modeIndex + 2 > lIIIlIIIIIIlllI ? 0 : ++lIIIlIIIIIIllIl.modeIndex;
            lIIIlIIIIIIllIl.set.setValString(lIIIlIIIIIIllIl.set.getOptions().get(lIIIlIIIIIIllIl.modeIndex));
        }
    }

    public ModeButton(Setting lIIIlIIIIlIlIIl, Button lIIIlIIIIlIlIII, Module lIIIlIIIIlIllII, int lIIIlIIIIlIlIll) {
        ModeButton lIIIlIIIIlIllll;
        lIIIlIIIIlIllll.set = lIIIlIIIIlIlIIl;
        lIIIlIIIIlIllll.parent = lIIIlIIIIlIlIII;
        lIIIlIIIIlIllll.mod = lIIIlIIIIlIllII;
        lIIIlIIIIlIllll.x = lIIIlIIIIlIlIII.parent.getX() + lIIIlIIIIlIlIII.parent.getWidth();
        lIIIlIIIIlIllll.y = lIIIlIIIIlIlIII.parent.getY() + lIIIlIIIIlIlIII.offset;
        lIIIlIIIIlIllll.offset = lIIIlIIIIlIlIll;
        lIIIlIIIIlIllll.modeIndex = 0;
    }
}

