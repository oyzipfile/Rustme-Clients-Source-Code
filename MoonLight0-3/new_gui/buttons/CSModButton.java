/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.ScaledResolution
 */
package new_gui.buttons;

import java.io.IOException;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import new_gui.buttons.CSButton;
import new_gui.buttons.setting.CSSetting;
import new_gui.buttons.setting.settings.KeyBind;
import ru.internali.CatClient;
import ru.internali.module.Module;
import ru.internali.settings.Setting;

public class CSModButton
extends CSButton {
    public static /* synthetic */ boolean binding;
    public /* synthetic */ ScaledResolution sr;
    public /* synthetic */ Module mod;
    public static /* synthetic */ boolean first;
    public static /* synthetic */ String old_name;
    public /* synthetic */ ArrayList<CSSetting> settings;

    @Override
    public void drawScreen(int lIllIlIlIlllllI, int lIllIlIllIIIIlI, float lIllIlIllIIIIIl) {
        CSModButton lIllIlIlIllllll;
        int lIllIlIllIIIIII;
        int n = lIllIlIllIIIIII = lIllIlIlIllllll.isHovered(lIllIlIlIlllllI, lIllIlIllIIIIlI) ? CatClient.getClientColor().getRGB() : -1;
        if (lIllIlIlIllllll.mod.isToggled()) {
            lIllIlIllIIIIII = CatClient.getClientColor().darker().getRGB();
        }
        if (lIllIlIlIllllll.isCurrentMod()) {
            lIllIlIllIIIIII = CatClient.getClientColor().getRGB();
        }
        lIllIlIlIllllll.fr.drawString(lIllIlIlIllllll.displayString, lIllIlIlIllllll.x, lIllIlIlIllllll.y, lIllIlIllIIIIII);
        for (CSSetting lIllIlIllIIIlIl : lIllIlIlIllllll.settings) {
            if (!lIllIlIlIllllll.isCurrentMod()) continue;
            lIllIlIllIIIlIl.drawScreen(lIllIlIlIlllllI, lIllIlIllIIIIlI, lIllIlIllIIIIIl);
        }
        super.drawScreen(lIllIlIlIlllllI, lIllIlIllIIIIlI, lIllIlIllIIIIIl);
    }

    private boolean isCurrentMod() {
        CSModButton lIllIlIlIIlIIII;
        return CatClient.instance.csgui.currentCategory != null && CatClient.instance.csgui.currentCategory.currentMod != null && CatClient.instance.csgui.currentCategory.currentMod == lIllIlIlIIlIIII;
    }

    public CSModButton(int lIllIlIlllIlIll, int lIllIlIlllIlIlI, int lIllIlIlllIIIIl, int lIllIlIlllIIIII, int lIllIlIlllIIlll, String lIllIlIllIllllI, Module lIllIlIllIlllIl) {
        super(lIllIlIlllIlIll, lIllIlIlllIlIlI, lIllIlIlllIIIIl, lIllIlIlllIIIII, lIllIlIlllIIlll, lIllIlIllIllllI);
        CSModButton lIllIlIlllIllII;
        lIllIlIlllIllII.sr = new ScaledResolution(Minecraft.getMinecraft());
        lIllIlIlllIllII.settings = new ArrayList();
        lIllIlIlllIllII.mod = lIllIlIllIlllIl;
        lIllIlIlllIllII.initSettings();
    }

    @Override
    public void initButton() {
        CSModButton lIllIlIlIIIlllI;
        lIllIlIlIIIlllI.initSettings();
        super.initButton();
    }

    static {
        first = false;
    }

    private void initSettings() {
        CSModButton lIllIlIllIlIIIl;
        int lIllIlIllIlIlII = 70;
        int lIllIlIllIlIIll = lIllIlIllIlIIIl.x + 100;
        for (int lIllIlIllIlIllI = 0; lIllIlIllIlIllI < CatClient.instance.settingsManager.getSettings().size(); ++lIllIlIllIlIllI) {
            Setting lIllIlIllIlIlll = CatClient.instance.settingsManager.getSettings().get(lIllIlIllIlIllI);
            if (lIllIlIllIlIlll.getParentMod() != lIllIlIllIlIIIl.mod || lIllIlIllIlIlII <= 100 + lIllIlIllIlIIIl.sr.getScaledWidth() - 220) continue;
            lIllIlIllIlIlII = 0;
            lIllIlIllIlIIll += lIllIlIllIlIIIl.mc.fontRenderer.getStringWidth(lIllIlIllIlIlll.getName()) + 50;
        }
        KeyBind lIllIlIllIlIIlI = new KeyBind(lIllIlIllIlIIll, lIllIlIllIlIlII, 70, lIllIlIllIlIIIl.mc.fontRenderer.FONT_HEIGHT + 2, lIllIlIllIlIIIl.mod);
        lIllIlIllIlIIIl.settings.add(lIllIlIllIlIIlI);
    }

    public void setBinding(boolean lIllIlIlIllIlIl) {
        binding = lIllIlIlIllIlIl;
    }

    @Override
    public void mouseClicked(int lIllIlIlIlIIllI, int lIllIlIlIlIIlIl, int lIllIlIlIlIlIII) throws IOException {
        CSModButton lIllIlIlIlIIlll;
        if (lIllIlIlIlIIlll.isHovered(lIllIlIlIlIIllI, lIllIlIlIlIIlIl)) {
            if (lIllIlIlIlIlIII == 0 && lIllIlIlIlIIlll.isHovered(lIllIlIlIlIIllI, lIllIlIlIlIIlIl) && CatClient.instance.csgui.currentCategory != null && CatClient.instance.csgui.currentCategory.category == lIllIlIlIlIIlll.mod.getCategory()) {
                lIllIlIlIlIIlll.mod.toggle();
            } else if (lIllIlIlIlIlIII == 2 && lIllIlIlIlIIlll.isHovered(lIllIlIlIlIIllI, lIllIlIlIlIIlIl) && CatClient.instance.csgui.currentCategory != null && CatClient.instance.csgui.currentCategory.category == lIllIlIlIlIIlll.mod.getCategory()) {
                lIllIlIlIlIIlll.setBinding(true);
            } else if (lIllIlIlIlIlIII == 1) {
                // empty if block
            }
        }
        for (CSSetting lIllIlIlIlIllII : lIllIlIlIlIIlll.settings) {
            if (!lIllIlIlIlIIlll.isCurrentMod()) continue;
            lIllIlIlIlIllII.mouseClicked(lIllIlIlIlIIllI, lIllIlIlIlIIlIl, lIllIlIlIlIlIII);
        }
        super.mouseClicked(lIllIlIlIlIIllI, lIllIlIlIlIIlIl, lIllIlIlIlIlIII);
    }

    public boolean isHovered(int lIllIlIlIIllIll, int lIllIlIlIIllIlI) {
        CSModButton lIllIlIlIIlllII;
        boolean lIllIlIlIIllIIl = lIllIlIlIIllIll > lIllIlIlIIlllII.x && lIllIlIlIIllIll < lIllIlIlIIlllII.x + lIllIlIlIIlllII.width;
        boolean lIllIlIlIIllIII = lIllIlIlIIllIlI > lIllIlIlIIlllII.y && lIllIlIlIIllIlI < lIllIlIlIIlllII.y + lIllIlIlIIlllII.height;
        return lIllIlIlIIllIIl && lIllIlIlIIllIII;
    }
}

