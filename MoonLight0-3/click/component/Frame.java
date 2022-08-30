/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.Gui
 *  org.lwjgl.opengl.GL11
 */
package click.component;

import click.component.Component;
import click.component.components.Button;
import java.awt.Color;
import java.util.ArrayList;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import org.lwjgl.opengl.GL11;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;

public class Frame {
    public /* synthetic */ int dragY;
    public /* synthetic */ int dragX;
    private /* synthetic */ boolean isDragging;
    public /* synthetic */ ArrayList<Component> components;
    private /* synthetic */ boolean open;
    public /* synthetic */ Category category;
    private /* synthetic */ int x;
    private /* synthetic */ int barHeight;
    private /* synthetic */ int width;
    private /* synthetic */ int y;

    public boolean isOpen() {
        Frame lIllIIllIIIlIll;
        return lIllIIllIIIlIll.open;
    }

    public void setY(int lIllIIllIIlIlII) {
        lIllIIllIIlIlll.y = lIllIIllIIlIlII;
    }

    public Frame(Category lIllIIllIlIlIlI) {
        Frame lIllIIllIlIlIll;
        lIllIIllIlIlIll.components = new ArrayList();
        lIllIIllIlIlIll.category = lIllIIllIlIlIlI;
        lIllIIllIlIlIll.width = 95;
        lIllIIllIlIlIll.x = 5;
        lIllIIllIlIlIll.y = 5;
        lIllIIllIlIlIll.barHeight = 15;
        lIllIIllIlIlIll.dragX = 0;
        lIllIIllIlIlIll.open = false;
        lIllIIllIlIlIll.isDragging = false;
        int lIllIIllIlIlIIl = lIllIIllIlIlIll.barHeight;
        for (Module lIllIIllIlIllII : CatClient.instance.moduleManager.getModulesInCategory(lIllIIllIlIlIll.category)) {
            Button lIllIIllIlIllIl = new Button(lIllIIllIlIllII, lIllIIllIlIlIll, lIllIIllIlIlIIl);
            lIllIIllIlIlIll.components.add(lIllIIllIlIllIl);
            lIllIIllIlIlIIl += 12;
        }
    }

    public void setOpen(boolean lIllIIllIIIIlll) {
        lIllIIllIIIIllI.open = lIllIIllIIIIlll;
    }

    public void renderFrame(FontRenderer lIllIIlIlllllII) {
        Frame lIllIIlIlllllIl;
        Gui.drawRect((int)lIllIIlIlllllIl.x, (int)lIllIIlIlllllIl.y, (int)(lIllIIlIlllllIl.x + lIllIIlIlllllIl.width), (int)(lIllIIlIlllllIl.y + lIllIIlIlllllIl.barHeight), (int)Color.DARK_GRAY.getRGB());
        GL11.glPushMatrix();
        GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
        lIllIIlIlllllII.drawStringWithShadow(lIllIIlIlllllIl.category.name(), (float)((lIllIIlIlllllIl.x + 2) * 2 + 5), ((float)lIllIIlIlllllIl.y + 2.5f) * 2.0f + 5.0f, 15252223);
        lIllIIlIlllllII.drawStringWithShadow(lIllIIlIlllllIl.open ? "-" : "+", (float)((lIllIIlIlllllIl.x + lIllIIlIlllllIl.width - 10) * 2 + 5), ((float)lIllIIlIlllllIl.y + 2.5f) * 2.0f + 5.0f, -1);
        GL11.glPopMatrix();
        if (lIllIIlIlllllIl.open && !lIllIIlIlllllIl.components.isEmpty()) {
            Gui.drawRect((int)lIllIIlIlllllIl.x, (int)(lIllIIlIlllllIl.y + lIllIIlIlllllIl.barHeight), (int)(lIllIIlIlllllIl.x + 1), (int)(lIllIIlIlllllIl.y + lIllIIlIlllllIl.barHeight + 12 * lIllIIlIlllllIl.components.size()), (int)new Color(200, 0, 0, 150).getRGB());
            Gui.drawRect((int)lIllIIlIlllllIl.x, (int)(lIllIIlIlllllIl.y + lIllIIlIlllllIl.barHeight + 12 * lIllIIlIlllllIl.components.size()), (int)(lIllIIlIlllllIl.x + lIllIIlIlllllIl.width), (int)(lIllIIlIlllllIl.y + lIllIIlIlllllIl.barHeight + 12 * lIllIIlIlllllIl.components.size() + 1), (int)new Color(200, 0, 0, 150).getRGB());
            Gui.drawRect((int)(lIllIIlIlllllIl.x + lIllIIlIlllllIl.width), (int)(lIllIIlIlllllIl.y + lIllIIlIlllllIl.barHeight), (int)(lIllIIlIlllllIl.x + lIllIIlIlllllIl.width - 1), (int)(lIllIIlIlllllIl.y + lIllIIlIlllllIl.barHeight + 12 * lIllIIlIlllllIl.components.size()), (int)new Color(200, 0, 0, 150).getRGB());
            for (Component lIllIIllIIIIIII : lIllIIlIlllllIl.components) {
                lIllIIllIIIIIII.renderComponent();
            }
        }
    }

    public void updatePosition(int lIllIIlIllIIIIl, int lIllIIlIlIlllIl) {
        Frame lIllIIlIlIlllll;
        if (lIllIIlIlIlllll.isDragging) {
            lIllIIlIlIlllll.setX(lIllIIlIllIIIIl - lIllIIlIlIlllll.dragX);
            lIllIIlIlIlllll.setY(lIllIIlIlIlllIl - lIllIIlIlIlllll.dragY);
        }
    }

    public int getY() {
        Frame lIllIIlIllIlIIl;
        return lIllIIlIllIlIIl.y;
    }

    public void refresh() {
        Frame lIllIIlIlllIIlI;
        int lIllIIlIlllIIll = lIllIIlIlllIIlI.barHeight;
        for (Component lIllIIlIlllIlIl : lIllIIlIlllIIlI.components) {
            lIllIIlIlllIlIl.setOff(lIllIIlIlllIIll);
            lIllIIlIlllIIll += lIllIIlIlllIlIl.getHeight();
        }
    }

    public int getWidth() {
        Frame lIllIIlIllIIllI;
        return lIllIIlIllIIllI.width;
    }

    public ArrayList<Component> getComponents() {
        Frame lIllIIllIlIIIII;
        return lIllIIllIlIIIII.components;
    }

    public int getX() {
        Frame lIllIIlIllIllIl;
        return lIllIIlIllIllIl.x;
    }

    public boolean isWithinHeader(int lIllIIlIlIlIlIl, int lIllIIlIlIlIlll) {
        Frame lIllIIlIlIllIIl;
        return lIllIIlIlIlIlIl >= lIllIIlIlIllIIl.x && lIllIIlIlIlIlIl <= lIllIIlIlIllIIl.x + lIllIIlIlIllIIl.width && lIllIIlIlIlIlll >= lIllIIlIlIllIIl.y && lIllIIlIlIlIlll <= lIllIIlIlIllIIl.y + lIllIIlIlIllIIl.barHeight;
    }

    public void setDrag(boolean lIllIIllIIlIIII) {
        lIllIIllIIIllll.isDragging = lIllIIllIIlIIII;
    }

    public void setX(int lIllIIllIIllIlI) {
        lIllIIllIIlllIl.x = lIllIIllIIllIlI;
    }
}

