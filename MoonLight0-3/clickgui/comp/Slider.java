/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 */
package clickgui.comp;

import clickgui.Clickgui;
import clickgui.comp.Comp;
import clickgui.setting.Setting;
import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;
import net.minecraft.client.Minecraft;
import ru.internali.module.Module;
import ru.internali.utils.RenderUtil;

public class Slider
extends Comp {
    private /* synthetic */ double renderWidth;
    private /* synthetic */ double renderWidth2;
    private /* synthetic */ boolean dragging;

    private double roundToPlace(double lllIllIllIIII, int lllIllIlIllll) {
        if (lllIllIlIllll < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal lllIllIllIIIl = new BigDecimal(lllIllIllIIII);
        lllIllIllIIIl = lllIllIllIIIl.setScale(lllIllIlIllll, RoundingMode.HALF_UP);
        return lllIllIllIIIl.doubleValue();
    }

    @Override
    public void mouseClicked(int lllIllllIIIlI, int lllIllllIIIIl, int lllIllllIIIII) {
        Slider lllIlllIlllll;
        super.mouseClicked(lllIllllIIIlI, lllIllllIIIIl, lllIllllIIIII);
        if (lllIlllIlllll.isInside(lllIllllIIIlI, lllIllllIIIIl, lllIlllIlllll.parent.posX + lllIlllIlllll.x - 70.0, lllIlllIlllll.parent.posY + lllIlllIlllll.y + 10.0, lllIlllIlllll.parent.posX + lllIlllIlllll.x - 70.0 + lllIlllIlllll.renderWidth2, lllIlllIlllll.parent.posY + lllIlllIlllll.y + 16.0) && lllIllllIIIII == 0) {
            lllIlllIlllll.dragging = true;
        }
    }

    @Override
    public void drawScreen(int lllIlllIIIlIl, int lllIllIllllIl) {
        Slider lllIlllIIIllI;
        super.drawScreen(lllIlllIIIlIl, lllIllIllllIl);
        double lllIlllIIIIll = lllIlllIIIllI.setting.getMin();
        double lllIlllIIIIlI = lllIlllIIIllI.setting.getMax();
        double lllIlllIIIIIl = 90.0;
        lllIlllIIIllI.renderWidth = lllIlllIIIIIl * (lllIlllIIIllI.setting.getValDouble() - lllIlllIIIIll) / (lllIlllIIIIlI - lllIlllIIIIll);
        lllIlllIIIllI.renderWidth2 = lllIlllIIIIIl * (lllIlllIIIllI.setting.getMax() - lllIlllIIIIll) / (lllIlllIIIIlI - lllIlllIIIIll);
        double lllIlllIIIIII = Math.min(lllIlllIIIIIl, Math.max(0.0, (double)lllIlllIIIlIl - (lllIlllIIIllI.parent.posX + lllIlllIIIllI.x - 70.0)));
        if (lllIlllIIIllI.dragging) {
            if (lllIlllIIIIII == 0.0) {
                lllIlllIIIllI.setting.setValDouble(lllIlllIIIllI.setting.getMin());
            } else {
                double lllIlllIIIlll = lllIlllIIIllI.roundToPlace(lllIlllIIIIII / lllIlllIIIIIl * (lllIlllIIIIlI - lllIlllIIIIll) + lllIlllIIIIll, 1);
                lllIlllIIIllI.setting.setValDouble(lllIlllIIIlll);
            }
        }
        RenderUtil.drawRect(lllIlllIIIllI.parent.posX + lllIlllIIIllI.x - 70.0, lllIlllIIIllI.parent.posY + lllIlllIIIllI.y + 10.0, lllIlllIIIllI.parent.posX + lllIlllIIIllI.x - 70.0 + lllIlllIIIllI.renderWidth2, lllIlllIIIllI.parent.posY + lllIlllIIIllI.y + 16.0, new Color(10, 131, 230).darker().getRGB());
        RenderUtil.drawRect(lllIlllIIIllI.parent.posX + lllIlllIIIllI.x - 70.0, lllIlllIIIllI.parent.posY + lllIlllIIIllI.y + 10.0, lllIlllIIIllI.parent.posX + lllIlllIIIllI.x - 70.0 + lllIlllIIIllI.renderWidth, lllIlllIIIllI.parent.posY + lllIlllIIIllI.y + 16.0, new Color(10, 164, 230).getRGB());
        Minecraft.getMinecraft().fontRenderer.drawString(String.valueOf(new StringBuilder().append(lllIlllIIIllI.setting.getName()).append(": ").append(lllIlllIIIllI.setting.getValDouble())), (int)(lllIlllIIIllI.parent.posX + lllIlllIIIllI.x - 70.0), (int)(lllIlllIIIllI.parent.posY + lllIlllIIIllI.y), -1);
    }

    @Override
    public void mouseReleased(int lllIlllIlIIlI, int lllIlllIlIlIl, int lllIlllIlIlII) {
        Slider lllIlllIlIlll;
        super.mouseReleased(lllIlllIlIIlI, lllIlllIlIlIl, lllIlllIlIlII);
        lllIlllIlIlll.dragging = false;
    }

    public Slider(double lllIlllllIIlI, double lllIllllIlIll, Clickgui lllIlllllIIII, Module lllIllllIlIIl, Setting lllIllllIlllI) {
        Slider lllIlllllIIll;
        lllIlllllIIll.dragging = false;
        lllIlllllIIll.x = lllIlllllIIlI;
        lllIlllllIIll.y = lllIllllIlIll;
        lllIlllllIIll.parent = lllIlllllIIII;
        lllIlllllIIll.module = lllIllllIlIIl;
        lllIlllllIIll.setting = lllIllllIlllI;
    }
}

