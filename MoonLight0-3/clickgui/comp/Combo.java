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

public class Combo
extends Comp {
    public Combo(double lIlIlIIlIllllI, double lIlIlIIlIlllIl, Clickgui lIlIlIIlIlllII, Module lIlIlIIlIllIll, Setting lIlIlIIlIlIlII) {
        Combo lIlIlIIlIlllll;
        lIlIlIIlIlllll.x = lIlIlIIlIllllI;
        lIlIlIIlIlllll.y = lIlIlIIlIlllIl;
        lIlIlIIlIlllll.parent = lIlIlIIlIlllII;
        lIlIlIIlIlllll.module = lIlIlIIlIllIll;
        lIlIlIIlIlllll.setting = lIlIlIIlIlIlII;
    }

    @Override
    public void drawScreen(int lIlIlIIIllllIl, int lIlIlIIIllllll) {
        Combo lIlIlIIIlllllI;
        super.drawScreen(lIlIlIIIllllIl, lIlIlIIIllllll);
        RenderUtil.drawRect(lIlIlIIIlllllI.parent.posX + lIlIlIIIlllllI.x - 70.0, lIlIlIIIlllllI.parent.posY + lIlIlIIIlllllI.y, lIlIlIIIlllllI.parent.posX + lIlIlIIIlllllI.x + 20.0, lIlIlIIIlllllI.parent.posY + lIlIlIIIlllllI.y + 10.0, lIlIlIIIlllllI.setting.getValBoolean() ? new Color(230, 10, 230).getRGB() : new Color(59, 59, 59).getRGB());
        Minecraft.getMinecraft().fontRenderer.drawString(String.valueOf(new StringBuilder().append(lIlIlIIIlllllI.setting.getName()).append(": ").append(lIlIlIIIlllllI.setting.getValString())), (int)(lIlIlIIIlllllI.parent.posX + lIlIlIIIlllllI.x - 69.0), (int)(lIlIlIIIlllllI.parent.posY + lIlIlIIIlllllI.y + 1.0), new Color(200, 200, 200).getRGB());
    }

    @Override
    public void mouseClicked(int lIlIlIIlIIllII, int lIlIlIIlIIIlll, int lIlIlIIlIIlIlI) {
        Combo lIlIlIIlIIllIl;
        super.mouseClicked(lIlIlIIlIIllII, lIlIlIIlIIIlll, lIlIlIIlIIlIlI);
        if (lIlIlIIlIIllIl.isInside(lIlIlIIlIIllII, lIlIlIIlIIIlll, lIlIlIIlIIllIl.parent.posX + lIlIlIIlIIllIl.x - 70.0, lIlIlIIlIIllIl.parent.posY + lIlIlIIlIIllIl.y, lIlIlIIlIIllIl.parent.posX + lIlIlIIlIIllIl.x + 20.0, lIlIlIIlIIllIl.parent.posY + lIlIlIIlIIllIl.y + 10.0) && lIlIlIIlIIlIlI == 0) {
            int lIlIlIIlIIlllI = lIlIlIIlIIllIl.setting.getOptions().size();
            lIlIlIIlIIllIl.parent.modeIndex = lIlIlIIlIIllIl.parent.modeIndex + 1 >= lIlIlIIlIIlllI ? 0 : ++lIlIlIIlIIllIl.parent.modeIndex;
            lIlIlIIlIIllIl.setting.setValString(lIlIlIIlIIllIl.setting.getOptions().get(lIlIlIIlIIllIl.parent.modeIndex));
        }
    }
}

