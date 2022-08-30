/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 */
package ru.internali.utils;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import ru.internali.utils.DraggableComponent;

public class DraggableModule {
    public /* synthetic */ DraggableComponent drag;
    public /* synthetic */ int x;
    protected /* synthetic */ Minecraft mc;
    public /* synthetic */ String name;
    public /* synthetic */ int y;

    public String getName() {
        DraggableModule lllIlIIlIlIlIlI;
        return lllIlIIlIlIlIlI.name;
    }

    public void setX2(int lllIlIIlIIlIIIl) {
        DraggableModule lllIlIIlIIlIIlI;
        lllIlIIlIIlIIlI.drag.setXPosition(lllIlIIlIIlIIIl);
    }

    public int getX2() {
        DraggableModule lllIlIIlIIllIII;
        return lllIlIIlIIllIII.x;
    }

    public DraggableModule(String lllIlIIllIIIlIl, int lllIlIIllIIIIII, int lllIlIIlIllllll) {
        DraggableModule lllIlIIllIIIIlI;
        lllIlIIllIIIIlI.mc = Minecraft.getMinecraft();
        lllIlIIllIIIIlI.name = lllIlIIllIIIlIl;
        lllIlIIllIIIIlI.x = lllIlIIllIIIIII;
        lllIlIIllIIIIlI.y = lllIlIIlIllllll;
        lllIlIIllIIIIlI.drag = new DraggableComponent(lllIlIIllIIIIlI.x, lllIlIIllIIIIlI.y, lllIlIIllIIIIlI.getWidth(), lllIlIIllIIIIlI.getHeight(), new Color(255, 255, 255, 0).getRGB());
    }

    public int getX() {
        DraggableModule lllIlIIlIllIIll;
        return lllIlIIlIllIIll.drag.getXPosition();
    }

    public void render(int lllIlIIlIllIllI, int lllIlIIlIlllIII) {
        DraggableModule lllIlIIlIllIlll;
        lllIlIIlIllIlll.drag.draw(lllIlIIlIllIllI, lllIlIIlIlllIII);
    }

    public int getY() {
        DraggableModule lllIlIIlIlIIIII;
        return lllIlIIlIlIIIII.drag.getYPosition();
    }

    public void draw() {
    }

    public int getHeight() {
        return 50;
    }

    public void setY(int lllIlIIlIIllIlI) {
        lllIlIIlIIlllIl.y = lllIlIIlIIllIlI;
    }

    public int getY2() {
        DraggableModule lllIlIIlIIIlllI;
        return lllIlIIlIIIlllI.y;
    }

    public void setY2(int lllIlIIlIIIlIII) {
        DraggableModule lllIlIIlIIIlIll;
        lllIlIIlIIIlIll.drag.setYPosition(lllIlIIlIIIlIII);
    }

    public void setX(int lllIlIIlIlIlllI) {
        lllIlIIlIlIllll.x = lllIlIIlIlIlllI;
    }

    public void setName(String lllIlIIlIlIIlIl) {
        lllIlIIlIlIIlII.name = lllIlIIlIlIIlIl;
    }

    public int getWidth() {
        return 50;
    }
}

