/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 */
package click;

import click.component.Component;
import click.component.Frame;
import java.io.IOException;
import java.util.ArrayList;
import net.minecraft.client.gui.GuiScreen;
import ru.internali.CatClient;
import ru.internali.module.Category;

public class ClickGui
extends GuiScreen {
    public /* synthetic */ int color;
    public /* synthetic */ int height;
    public /* synthetic */ int y;
    public /* synthetic */ int width;
    public /* synthetic */ int x;
    public static /* synthetic */ ArrayList<Frame> frames;

    public boolean doesGuiPauseGame() {
        return true;
    }

    public void drawScreen(int lIlIIIIlllIIlll, int lIlIIIIlllIIllI, float lIlIIIIlllIlIIl) {
        ClickGui lIlIIIIlllIllII;
        lIlIIIIlllIllII.drawDefaultBackground();
        for (Frame lIlIIIIlllIllIl : frames) {
            lIlIIIIlllIllIl.renderFrame(lIlIIIIlllIllII.mc.fontRenderer);
            lIlIIIIlllIllIl.updatePosition(lIlIIIIlllIIlll, lIlIIIIlllIIllI);
            for (Component lIlIIIIlllIlllI : lIlIIIIlllIllIl.getComponents()) {
                lIlIIIIlllIlllI.updateComponent(lIlIIIIlllIIlll, lIlIIIIlllIIllI);
            }
        }
    }

    public void initGui() {
    }

    protected void keyTyped(char lIlIIIIllIIIIll, int lIlIIIIlIllllll) {
        for (Frame lIlIIIIllIIIlIl : frames) {
            if (!lIlIIIIllIIIlIl.isOpen() || lIlIIIIlIllllll == 1 || lIlIIIIllIIIlIl.getComponents().isEmpty()) continue;
            for (Component lIlIIIIllIIIllI : lIlIIIIllIIIlIl.getComponents()) {
                lIlIIIIllIIIllI.keyTyped(lIlIIIIllIIIIll, lIlIIIIlIllllll);
            }
        }
        if (lIlIIIIlIllllll == 1) {
            ClickGui lIlIIIIllIIIIIl;
            lIlIIIIllIIIIIl.mc.displayGuiScreen(null);
        }
    }

    protected void mouseClicked(int lIlIIIIllIlIlII, int lIlIIIIllIlIIll, int lIlIIIIllIlIIlI) throws IOException {
        for (Frame lIlIIIIllIllIIl : frames) {
            if (lIlIIIIllIllIIl.isWithinHeader(lIlIIIIllIlIlII, lIlIIIIllIlIIll) && lIlIIIIllIlIIlI == 0) {
                lIlIIIIllIllIIl.setDrag(true);
                lIlIIIIllIllIIl.dragX = lIlIIIIllIlIlII - lIlIIIIllIllIIl.getX();
                lIlIIIIllIllIIl.dragY = lIlIIIIllIlIIll - lIlIIIIllIllIIl.getY();
            }
            if (lIlIIIIllIllIIl.isWithinHeader(lIlIIIIllIlIlII, lIlIIIIllIlIIll) && lIlIIIIllIlIIlI == 1) {
                lIlIIIIllIllIIl.setOpen(!lIlIIIIllIllIIl.isOpen());
            }
            if (!lIlIIIIllIllIIl.isOpen() || lIlIIIIllIllIIl.getComponents().isEmpty()) continue;
            for (Component lIlIIIIllIllIlI : lIlIIIIllIllIIl.getComponents()) {
                lIlIIIIllIllIlI.mouseClicked(lIlIIIIllIlIlII, lIlIIIIllIlIIll, lIlIIIIllIlIIlI);
            }
        }
    }

    protected void mouseReleased(int lIlIIIIlIlIllII, int lIlIIIIlIlIlllI, int lIlIIIIlIlIlIlI) {
        for (Frame lIlIIIIlIllIIll : frames) {
            lIlIIIIlIllIIll.setDrag(false);
        }
        for (Frame lIlIIIIlIllIIIl : frames) {
            if (!lIlIIIIlIllIIIl.isOpen() || lIlIIIIlIllIIIl.getComponents().isEmpty()) continue;
            for (Component lIlIIIIlIllIIlI : lIlIIIIlIllIIIl.getComponents()) {
                lIlIIIIlIllIIlI.mouseReleased(lIlIIIIlIlIllII, lIlIIIIlIlIlllI, lIlIIIIlIlIlIlI);
            }
        }
    }

    public ClickGui() {
        ClickGui lIlIIIIllllllIl;
        lIlIIIIllllllIl.color = CatClient.getClientColor().getRGB();
        frames = new ArrayList();
        int lIlIIIIlllllllI = 10;
        for (Category lIlIIIlIIIIIIII : Category.values()) {
            Frame lIlIIIlIIIIIIIl = new Frame(lIlIIIlIIIIIIII);
            lIlIIIlIIIIIIIl.setX(lIlIIIIlllllllI);
            frames.add(lIlIIIlIIIIIIIl);
            lIlIIIIlllllllI += lIlIIIlIIIIIIIl.getWidth() + 2;
        }
    }
}

