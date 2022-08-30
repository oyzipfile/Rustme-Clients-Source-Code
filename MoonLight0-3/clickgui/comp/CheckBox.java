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
import net.minecraft.client.Minecraft;
import ru.internali.module.Module;
import ru.internali.utils.RenderUtil;

public class CheckBox
extends Comp {
    @Override
    public void mouseClicked(int lllIIIllIlIIIIl, int lllIIIllIIlllII, int lllIIIllIIllIll) {
        CheckBox lllIIIllIIllllI;
        super.mouseClicked(lllIIIllIlIIIIl, lllIIIllIIlllII, lllIIIllIIllIll);
        if (lllIIIllIIllllI.isInside(lllIIIllIlIIIIl, lllIIIllIIlllII, lllIIIllIIllllI.parent.posX + lllIIIllIIllllI.x - 70.0, lllIIIllIIllllI.parent.posY + lllIIIllIIllllI.y, lllIIIllIIllllI.parent.posX + lllIIIllIIllllI.x + 10.0 - 70.0, lllIIIllIIllllI.parent.posY + lllIIIllIIllllI.y + 8.5) && lllIIIllIIllIll == 0) {
            lllIIIllIIllllI.setting.setValBoolean(!lllIIIllIIllllI.setting.getValBoolean());
        }
    }

    public CheckBox(double lllIIIllIllIlII, double lllIIIllIllIIll, Clickgui lllIIIllIlllIII, Module lllIIIllIllIIIl, Setting lllIIIllIllIllI) {
        CheckBox lllIIIllIlllIll;
        lllIIIllIlllIll.x = lllIIIllIllIlII;
        lllIIIllIlllIll.y = lllIIIllIllIIll;
        lllIIIllIlllIll.parent = lllIIIllIlllIII;
        lllIIIllIlllIll.module = lllIIIllIllIIIl;
        lllIIIllIlllIll.setting = lllIIIllIllIllI;
    }

    @Override
    public void drawScreen(int lllIIIllIlIlIII, int lllIIIllIlIIlll) {
        CheckBox lllIIIllIlIllII;
        super.drawScreen(lllIIIllIlIlIII, lllIIIllIlIIlll);
        RenderUtil.drawRect(lllIIIllIlIllII.parent.posX + lllIIIllIlIllII.x - 70.0, lllIIIllIlIllII.parent.posY + lllIIIllIlIllII.y, lllIIIllIlIllII.parent.posX + lllIIIllIlIllII.x + 10.0 - 70.0, lllIIIllIlIllII.parent.posY + lllIIIllIlIllII.y + 8.5, lllIIIllIlIllII.setting.getValBoolean() ? new Color(10, 179, 230).getRGB() : new Color(61, 61, 61).getRGB());
        Minecraft.getMinecraft().fontRenderer.drawString(lllIIIllIlIllII.setting.getName(), (int)(lllIIIllIlIllII.parent.posX + lllIIIllIlIllII.x - 55.0), (int)(lllIIIllIlIllII.parent.posY + lllIIIllIlIllII.y + 0.5), new Color(200, 200, 200).getRGB());
    }
}

