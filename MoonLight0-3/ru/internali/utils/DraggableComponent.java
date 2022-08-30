/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.Gui
 *  org.lwjgl.input.Mouse
 */
package ru.internali.utils;

import java.util.ArrayList;
import net.minecraft.client.gui.Gui;
import org.lwjgl.input.Mouse;
import ru.internali.utils.DraggableModule;

public class DraggableComponent {
    private final /* synthetic */ int height;
    private /* synthetic */ int x;
    private /* synthetic */ int lastX;
    private /* synthetic */ int color;
    private /* synthetic */ int lastY;
    private /* synthetic */ boolean canRender;
    private final /* synthetic */ int width;
    public static /* synthetic */ ArrayList<DraggableModule> draggableModules;
    private /* synthetic */ int y;
    private /* synthetic */ boolean dragging;

    public DraggableComponent(int lllIlllllIlIlll, int lllIlllllIlllII, int lllIlllllIllIll, int lllIlllllIllIlI, int lllIlllllIllIIl) {
        DraggableComponent lllIlllllIllllI;
        lllIlllllIllllI.canRender = true;
        lllIlllllIllllI.width = lllIlllllIllIll;
        lllIlllllIllllI.height = lllIlllllIllIlI;
        lllIlllllIllllI.x = lllIlllllIlIlll;
        lllIlllllIllllI.y = lllIlllllIlllII;
        lllIlllllIllllI.color = lllIlllllIllIIl;
    }

    static {
        draggableModules = new ArrayList();
    }

    private void draggingFix(int lllIllllIIIIllI, int lllIllllIIIIlIl) {
        DraggableComponent lllIllllIIIIlll;
        if (lllIllllIIIIlll.dragging) {
            lllIllllIIIIlll.x = lllIllllIIIIllI + lllIllllIIIIlll.lastX;
            lllIllllIIIIlll.y = lllIllllIIIIlIl + lllIllllIIIIlll.lastY;
            if (!Mouse.isButtonDown((int)0)) {
                lllIllllIIIIlll.dragging = false;
            }
        }
    }

    public void draw(int lllIllllIIlIIlI, int lllIllllIIIlllI) {
        DraggableComponent lllIllllIIlIIll;
        if (lllIllllIIlIIll.canRender) {
            lllIllllIIlIIll.draggingFix(lllIllllIIlIIlI, lllIllllIIIlllI);
            Gui.drawRect((int)lllIllllIIlIIll.getXPosition(), (int)(lllIllllIIlIIll.getYPosition() - lllIllllIIlIIll.getHeight() / 4), (int)(lllIllllIIlIIll.getXPosition() + lllIllllIIlIIll.getWidth()), (int)(lllIllllIIlIIll.getYPosition() + lllIllllIIlIIll.getHeight()), (int)lllIllllIIlIIll.getColor());
            boolean lllIllllIIlIlIl = lllIllllIIlIIlI >= lllIllllIIlIIll.getXPosition() && lllIllllIIlIIlI <= lllIllllIIlIIll.getXPosition() + lllIllllIIlIIll.getWidth();
            boolean lllIllllIIlIllI = lllIllllIIIlllI >= lllIllllIIlIIll.getYPosition() - lllIllllIIlIIll.getHeight() / 4 && lllIllllIIIlllI <= lllIllllIIlIIll.getYPosition() - lllIllllIIlIIll.getHeight() / 4 + lllIllllIIlIIll.getHeight();
            boolean lllIllllIIlIlII = lllIllllIIlIllI;
            if (lllIllllIIlIlIl && lllIllllIIlIllI) {
                if (Mouse.isButtonDown((int)0)) {
                    if (!lllIllllIIlIIll.dragging && draggableModules.size() <= 1) {
                        lllIllllIIlIIll.lastX = lllIllllIIlIIll.x - lllIllllIIlIIlI;
                        lllIllllIIlIIll.lastY = lllIllllIIlIIll.y - lllIllllIIIlllI;
                        lllIllllIIlIIll.dragging = true;
                    }
                } else {
                    draggableModules.clear();
                }
            }
        }
    }

    public int getColor() {
        DraggableComponent lllIllllIlIllIl;
        return lllIllllIlIllIl.color;
    }

    public void setXPosition(int lllIlllllIIIIII) {
        lllIllllIllllll.x = lllIlllllIIIIII;
    }

    public void setColor(int lllIllllIlIlIII) {
        lllIllllIlIIlll.color = lllIllllIlIlIII;
    }

    public boolean isCanRender() {
        DraggableComponent lllIlllllIIlllI;
        return lllIlllllIIlllI.canRender;
    }

    public int getWidth() {
        DraggableComponent lllIllllIlIllll;
        return lllIllllIlIllll.width;
    }

    public int getHeight() {
        DraggableComponent lllIllllIllIIll;
        return lllIllllIllIIll.height;
    }

    public int getYPosition() {
        DraggableComponent lllIllllIlllIll;
        return lllIllllIlllIll.y;
    }

    public void setYPosition(int lllIllllIllIlIl) {
        lllIllllIlllIII.y = lllIllllIllIlIl;
    }

    public boolean isDragging() {
        DraggableComponent lllIlllllIlIIIl;
        return lllIlllllIlIIIl.dragging;
    }

    public void setCanRender(boolean lllIlllllIIlIIl) {
        lllIlllllIIlIII.canRender = lllIlllllIIlIIl;
    }

    public boolean isHovered(int lllIllllIlIIIIl, int lllIllllIIlllIl) {
        DraggableComponent lllIllllIIlllll;
        return lllIllllIlIIIIl >= lllIllllIIlllll.getXPosition() && lllIllllIlIIIIl <= lllIllllIIlllll.getXPosition() + lllIllllIIlllll.getWidth() && lllIllllIIlllIl >= lllIllllIIlllll.getYPosition() - lllIllllIIlllll.getHeight() / 4 && lllIllllIIlllIl <= lllIllllIIlllll.getYPosition() - lllIllllIIlllll.getHeight() / 4 + lllIllllIIlllll.getHeight();
    }

    public int getXPosition() {
        DraggableComponent lllIlllllIIIlIl;
        return lllIlllllIIIlIl.x;
    }
}

