/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.Gui
 *  org.lwjgl.opengl.GL11
 */
package click.component.components;

import click.component.Component;
import click.component.Frame;
import click.component.components.sub.Checkbox;
import click.component.components.sub.Keybind;
import click.component.components.sub.ModeButton;
import click.component.components.sub.Slider;
import click.component.components.sub.VisibleButton;
import java.awt.Color;
import java.util.ArrayList;
import net.minecraft.client.gui.Gui;
import org.lwjgl.opengl.GL11;
import ru.internali.CatClient;
import ru.internali.module.Module;
import ru.internali.settings.Setting;
import ru.internali.utils.MinecraftHelper;

public class Button
extends Component {
    private /* synthetic */ int height;
    public /* synthetic */ Module mod;
    public /* synthetic */ int offset;
    private /* synthetic */ boolean isHovered;
    private /* synthetic */ ArrayList<Component> subcomponents;
    public /* synthetic */ Frame parent;
    public /* synthetic */ boolean open;

    @Override
    public void updateComponent(int lIIllllIlIIIIll, int lIIllllIlIIIIlI) {
        Button lIIllllIlIIIIIl;
        lIIllllIlIIIIIl.isHovered = lIIllllIlIIIIIl.isMouseOnButton(lIIllllIlIIIIll, lIIllllIlIIIIlI);
        if (!lIIllllIlIIIIIl.subcomponents.isEmpty()) {
            for (Component lIIllllIlIIIlIl : lIIllllIlIIIIIl.subcomponents) {
                lIIllllIlIIIlIl.updateComponent(lIIllllIlIIIIll, lIIllllIlIIIIlI);
            }
        }
    }

    @Override
    public void mouseClicked(int lIIllllIIllIlII, int lIIllllIIllIIll, int lIIllllIIllIIlI) {
        Button lIIllllIIllIIIl;
        if (lIIllllIIllIIIl.isMouseOnButton(lIIllllIIllIlII, lIIllllIIllIIll) && lIIllllIIllIIlI == 0) {
            lIIllllIIllIIIl.mod.toggle();
        }
        if (lIIllllIIllIIIl.isMouseOnButton(lIIllllIIllIlII, lIIllllIIllIIll) && lIIllllIIllIIlI == 1) {
            lIIllllIIllIIIl.open = !lIIllllIIllIIIl.open;
            lIIllllIIllIIIl.parent.refresh();
        }
        for (Component lIIllllIIllIllI : lIIllllIIllIIIl.subcomponents) {
            lIIllllIIllIllI.mouseClicked(lIIllllIIllIlII, lIIllllIIllIIll, lIIllllIIllIIlI);
        }
    }

    @Override
    public void setOff(int lIIllllIlIlllII) {
        Button lIIllllIlIlllIl;
        lIIllllIlIlllIl.offset = lIIllllIlIlllII;
        int lIIllllIlIllIll = lIIllllIlIlllIl.offset + 12;
        for (Component lIIllllIlIllllI : lIIllllIlIlllIl.subcomponents) {
            lIIllllIlIllllI.setOff(lIIllllIlIllIll);
            lIIllllIlIllIll += 12;
        }
    }

    @Override
    public int getHeight() {
        Button lIIllllIlIIlIll;
        if (lIIllllIlIIlIll.open) {
            return 12 * (lIIllllIlIIlIll.subcomponents.size() + 1);
        }
        return 12;
    }

    @Override
    public void mouseReleased(int lIIllllIIIlllll, int lIIllllIIlIIIlI, int lIIllllIIIlllIl) {
        Button lIIllllIIlIIlII;
        for (Component lIIllllIIlIIlIl : lIIllllIIlIIlII.subcomponents) {
            lIIllllIIlIIlIl.mouseReleased(lIIllllIIIlllll, lIIllllIIlIIIlI, lIIllllIIIlllIl);
        }
    }

    public boolean isMouseOnButton(int lIIllllIIIIlIII, int lIIllllIIIIIlll) {
        Button lIIllllIIIIlIIl;
        return lIIllllIIIIlIII > lIIllllIIIIlIIl.parent.getX() && lIIllllIIIIlIII < lIIllllIIIIlIIl.parent.getX() + lIIllllIIIIlIIl.parent.getWidth() && lIIllllIIIIIlll > lIIllllIIIIlIIl.parent.getY() + lIIllllIIIIlIIl.offset && lIIllllIIIIIlll < lIIllllIIIIlIIl.parent.getY() + 12 + lIIllllIIIIlIIl.offset;
    }

    public Button(Module lIIllllIllIlIIl, Frame lIIllllIllIlIII, int lIIllllIllIllII) {
        Button lIIllllIllIllll;
        lIIllllIllIllll.mod = lIIllllIllIlIIl;
        lIIllllIllIllll.parent = lIIllllIllIlIII;
        lIIllllIllIllll.offset = lIIllllIllIllII;
        lIIllllIllIllll.subcomponents = new ArrayList();
        lIIllllIllIllll.open = false;
        lIIllllIllIllll.height = 12;
        int lIIllllIllIlIll = lIIllllIllIllII + 12;
        if (CatClient.instance.settingsManager.getSettingsByMod(lIIllllIllIlIIl) != null) {
            for (Setting lIIllllIlllIIII : CatClient.instance.settingsManager.getSettingsByMod(lIIllllIllIlIIl)) {
                if (lIIllllIlllIIII.isCombo()) {
                    lIIllllIllIllll.subcomponents.add(new ModeButton(lIIllllIlllIIII, lIIllllIllIllll, lIIllllIllIlIIl, lIIllllIllIlIll));
                    lIIllllIllIlIll += 12;
                }
                if (lIIllllIlllIIII.isSlider()) {
                    lIIllllIllIllll.subcomponents.add(new Slider(lIIllllIlllIIII, lIIllllIllIllll, lIIllllIllIlIll));
                    lIIllllIllIlIll += 12;
                }
                if (!lIIllllIlllIIII.isCheck()) continue;
                lIIllllIllIllll.subcomponents.add(new Checkbox(lIIllllIlllIIII, lIIllllIllIllll, lIIllllIllIlIll));
                lIIllllIllIlIll += 12;
            }
        }
        lIIllllIllIllll.subcomponents.add(new Keybind(lIIllllIllIllll, lIIllllIllIlIll));
        lIIllllIllIllll.subcomponents.add(new VisibleButton(lIIllllIllIllll, lIIllllIllIlIIl, lIIllllIllIlIll));
    }

    @Override
    public void renderComponent() {
        Button lIIllllIlIlIIII;
        Gui.drawRect((int)lIIllllIlIlIIII.parent.getX(), (int)(lIIllllIlIlIIII.parent.getY() + lIIllllIlIlIIII.offset), (int)(lIIllllIlIlIIII.parent.getX() + lIIllllIlIlIIII.parent.getWidth()), (int)(lIIllllIlIlIIII.parent.getY() + 16 + lIIllllIlIlIIII.offset), (int)(lIIllllIlIlIIII.isHovered ? (lIIllllIlIlIIII.mod.isToggled() ? new Color(-6881025).darker().getRGB() : -6881025) : (lIIllllIlIlIIII.mod.isToggled() ? new Color(14, 14, 14).getRGB() : -15658735)));
        GL11.glPushMatrix();
        GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
        MinecraftHelper.mc.fontRenderer.drawStringWithShadow(lIIllllIlIlIIII.mod.getName(), (float)((lIIllllIlIlIIII.parent.getX() + 2) * 2), (float)((lIIllllIlIlIIII.parent.getY() + lIIllllIlIlIIII.offset + 2) * 2 + 4), lIIllllIlIlIIII.mod.isToggled() ? 12411647 : -1);
        if (lIIllllIlIlIIII.subcomponents.size() > 3) {
            MinecraftHelper.mc.fontRenderer.drawStringWithShadow(lIIllllIlIlIIII.open ? "<" : ">", (float)((lIIllllIlIlIIII.parent.getX() + lIIllllIlIlIIII.parent.getWidth() - 10) * 2), (float)((lIIllllIlIlIIII.parent.getY() + lIIllllIlIlIIII.offset + 2) * 2 + 4), -1);
        }
        GL11.glPopMatrix();
        if (lIIllllIlIlIIII.open && !lIIllllIlIlIIII.subcomponents.isEmpty()) {
            for (Component lIIllllIlIlIIlI : lIIllllIlIlIIII.subcomponents) {
                lIIllllIlIlIIlI.renderComponent();
            }
            Gui.drawRect((int)(lIIllllIlIlIIII.parent.getX() + 2), (int)(lIIllllIlIlIIII.parent.getY() + lIIllllIlIlIIII.offset + 12), (int)(lIIllllIlIlIIII.parent.getX() + 3), (int)(lIIllllIlIlIIII.parent.getY() + lIIllllIlIlIIII.offset + (lIIllllIlIlIIII.subcomponents.size() + 1) * 12), (int)Color.white.getRGB());
        }
    }

    @Override
    public void keyTyped(char lIIllllIIIlIIII, int lIIllllIIIIllll) {
        Button lIIllllIIIlIlII;
        for (Component lIIllllIIIlIlIl : lIIllllIIIlIlII.subcomponents) {
            lIIllllIIIlIlIl.keyTyped(lIIllllIIIlIIII, lIIllllIIIIllll);
        }
    }
}

