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
import java.math.BigDecimal;
import java.math.RoundingMode;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import org.lwjgl.opengl.GL11;
import ru.internali.settings.Setting;

public class Slider
extends Component {
    private /* synthetic */ int x;
    private /* synthetic */ Setting set;
    private /* synthetic */ boolean hovered;
    private /* synthetic */ Button parent;
    private /* synthetic */ double renderWidth;
    private /* synthetic */ int y;
    private /* synthetic */ int offset;
    private /* synthetic */ boolean dragging;

    public Slider(Setting lIIIIllIIlIlIll, Button lIIIIllIIlIlIlI, int lIIIIllIIlIllIl) {
        Slider lIIIIllIIlIllII;
        lIIIIllIIlIllII.dragging = false;
        lIIIIllIIlIllII.set = lIIIIllIIlIlIll;
        lIIIIllIIlIllII.parent = lIIIIllIIlIlIlI;
        lIIIIllIIlIllII.x = lIIIIllIIlIlIlI.parent.getX() + lIIIIllIIlIlIlI.parent.getWidth();
        lIIIIllIIlIllII.y = lIIIIllIIlIlIlI.parent.getY() + lIIIIllIIlIlIlI.offset;
        lIIIIllIIlIllII.offset = lIIIIllIIlIllIl;
    }

    @Override
    public void setOff(int lIIIIllIIIlllIl) {
        lIIIIllIIIllllI.offset = lIIIIllIIIlllIl;
    }

    private static double roundToPlace(double lIIIIllIIIIIIIl, int lIIIIllIIIIIIll) {
        if (lIIIIllIIIIIIll < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal lIIIIllIIIIIIlI = new BigDecimal(lIIIIllIIIIIIIl);
        lIIIIllIIIIIIlI = lIIIIllIIIIIIlI.setScale(lIIIIllIIIIIIll, RoundingMode.HALF_UP);
        return lIIIIllIIIIIIlI.doubleValue();
    }

    @Override
    public void renderComponent() {
        Slider lIIIIllIIlIIlII;
        Gui.drawRect((int)(lIIIIllIIlIIlII.parent.parent.getX() + 2), (int)(lIIIIllIIlIIlII.parent.parent.getY() + lIIIIllIIlIIlII.offset), (int)(lIIIIllIIlIIlII.parent.parent.getX() + lIIIIllIIlIIlII.parent.parent.getWidth()), (int)(lIIIIllIIlIIlII.parent.parent.getY() + lIIIIllIIlIIlII.offset + 12), (int)(lIIIIllIIlIIlII.hovered ? -14540254 : -15658735));
        int lIIIIllIIlIIlIl = (int)(lIIIIllIIlIIlII.set.getValDouble() / lIIIIllIIlIIlII.set.getMax() * (double)lIIIIllIIlIIlII.parent.parent.getWidth());
        Gui.drawRect((int)(lIIIIllIIlIIlII.parent.parent.getX() + 2), (int)(lIIIIllIIlIIlII.parent.parent.getY() + lIIIIllIIlIIlII.offset), (int)(lIIIIllIIlIIlII.parent.parent.getX() + (int)lIIIIllIIlIIlII.renderWidth), (int)(lIIIIllIIlIIlII.parent.parent.getY() + lIIIIllIIlIIlII.offset + 12), (int)(lIIIIllIIlIIlII.hovered ? -11184811 : -12303292));
        Gui.drawRect((int)lIIIIllIIlIIlII.parent.parent.getX(), (int)(lIIIIllIIlIIlII.parent.parent.getY() + lIIIIllIIlIIlII.offset), (int)(lIIIIllIIlIIlII.parent.parent.getX() + 2), (int)(lIIIIllIIlIIlII.parent.parent.getY() + lIIIIllIIlIIlII.offset + 12), (int)-15658735);
        GL11.glPushMatrix();
        GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
        Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(String.valueOf(new StringBuilder().append(lIIIIllIIlIIlII.set.getName()).append(": ").append(lIIIIllIIlIIlII.set.getValDouble())), (float)(lIIIIllIIlIIlII.parent.parent.getX() * 2 + 15), (float)((lIIIIllIIlIIlII.parent.parent.getY() + lIIIIllIIlIIlII.offset + 2) * 2 + 5), -1);
        GL11.glPopMatrix();
    }

    public boolean isMouseOnButtonI(int lIIIIlIllIlllll, int lIIIIlIllIllIll) {
        Slider lIIIIlIllIlllIl;
        return lIIIIlIllIlllll > lIIIIlIllIlllIl.x + lIIIIlIllIlllIl.parent.parent.getWidth() / 2 && lIIIIlIllIlllll < lIIIIlIllIlllIl.x + lIIIIlIllIlllIl.parent.parent.getWidth() && lIIIIlIllIllIll > lIIIIlIllIlllIl.y && lIIIIlIllIllIll < lIIIIlIllIlllIl.y + 12;
    }

    @Override
    public void mouseReleased(int lIIIIlIllllIIII, int lIIIIlIlllIllll, int lIIIIlIlllIlllI) {
        lIIIIlIlllIllIl.dragging = false;
    }

    @Override
    public void updateComponent(int lIIIIllIIIlIIll, int lIIIIllIIIlIIlI) {
        Slider lIIIIllIIIIlllI;
        lIIIIllIIIIlllI.hovered = lIIIIllIIIIlllI.isMouseOnButtonD(lIIIIllIIIlIIll, lIIIIllIIIlIIlI) || lIIIIllIIIIlllI.isMouseOnButtonI(lIIIIllIIIlIIll, lIIIIllIIIlIIlI);
        lIIIIllIIIIlllI.y = lIIIIllIIIIlllI.parent.parent.getY() + lIIIIllIIIIlllI.offset;
        lIIIIllIIIIlllI.x = lIIIIllIIIIlllI.parent.parent.getX();
        double lIIIIllIIIlIIIl = Math.min(88, Math.max(0, lIIIIllIIIlIIll - lIIIIllIIIIlllI.x));
        double lIIIIllIIIlIIII = lIIIIllIIIIlllI.set.getMin();
        double lIIIIllIIIIllll = lIIIIllIIIIlllI.set.getMax();
        lIIIIllIIIIlllI.renderWidth = 88.0 * (lIIIIllIIIIlllI.set.getValDouble() - lIIIIllIIIlIIII) / (lIIIIllIIIIllll - lIIIIllIIIlIIII);
        if (lIIIIllIIIIlllI.dragging) {
            if (lIIIIllIIIlIIIl == 0.0) {
                lIIIIllIIIIlllI.set.setValDouble(lIIIIllIIIIlllI.set.getMin());
            } else {
                double lIIIIllIIIlIlIl = Slider.roundToPlace(lIIIIllIIIlIIIl / 88.0 * (lIIIIllIIIIllll - lIIIIllIIIlIIII) + lIIIIllIIIlIIII, 2);
                lIIIIllIIIIlllI.set.setValDouble(lIIIIllIIIlIlIl);
            }
        }
    }

    public boolean isMouseOnButtonD(int lIIIIlIlllIIlIl, int lIIIIlIlllIIlII) {
        Slider lIIIIlIlllIlIIl;
        return lIIIIlIlllIIlIl > lIIIIlIlllIlIIl.x && lIIIIlIlllIIlIl < lIIIIlIlllIlIIl.x + (lIIIIlIlllIlIIl.parent.parent.getWidth() / 2 + 1) && lIIIIlIlllIIlII > lIIIIlIlllIlIIl.y && lIIIIlIlllIIlII < lIIIIlIlllIlIIl.y + 12;
    }

    @Override
    public void mouseClicked(int lIIIIlIlllllIIl, int lIIIIlIlllllIII, int lIIIIlIllllIlll) {
        Slider lIIIIlIllllIllI;
        if (lIIIIlIllllIllI.isMouseOnButtonD(lIIIIlIlllllIIl, lIIIIlIlllllIII) && lIIIIlIllllIlll == 0 && lIIIIlIllllIllI.parent.open) {
            lIIIIlIllllIllI.dragging = true;
        }
        if (lIIIIlIllllIllI.isMouseOnButtonI(lIIIIlIlllllIIl, lIIIIlIlllllIII) && lIIIIlIllllIlll == 0 && lIIIIlIllllIllI.parent.open) {
            lIIIIlIllllIllI.dragging = true;
        }
    }
}

