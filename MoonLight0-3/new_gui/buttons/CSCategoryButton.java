/*
 * Decompiled with CFR 0.150.
 */
package new_gui.buttons;

import java.io.IOException;
import java.util.ArrayList;
import new_gui.buttons.CSButton;
import new_gui.buttons.CSModButton;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.module.ModuleManager;

public class CSCategoryButton
extends CSButton {
    public /* synthetic */ CSModButton currentMod;
    public /* synthetic */ ArrayList<CSModButton> buttons;
    public /* synthetic */ Category category;
    public static /* synthetic */ boolean binding;

    @Override
    public void initButton() {
        CSCategoryButton lIIIlIllIIIIIl;
        lIIIlIllIIIIIl.buttons.clear();
        int lIIIlIllIIIIII = lIIIlIllIIIIIl.x + 65;
        int lIIIlIlIllllll = 70;
        int lIIIlIllIIIIlI = 0;
        while (true) {
            if (lIIIlIllIIIIlI >= ModuleManager.modules.size()) break;
            Module lIIIlIllIIIIll = ModuleManager.modules.get(lIIIlIllIIIIlI);
            if (lIIIlIllIIIIll.getCategory() == lIIIlIllIIIIIl.category) {
                CSModButton lIIIlIllIIIlII = new CSModButton(lIIIlIllIIIIII, lIIIlIlIllllll, lIIIlIllIIIIIl.fr.getStringWidth(lIIIlIllIIIIll.getName()), lIIIlIllIIIIIl.fr.FONT_HEIGHT, -1, lIIIlIllIIIIll.getName(), lIIIlIllIIIIll);
                lIIIlIllIIIIIl.buttons.add(lIIIlIllIIIlII);
                lIIIlIlIllllll += 10;
            }
            ++lIIIlIllIIIIlI;
        }
        super.initButton();
    }

    public boolean isHovered(int lIIIlIlllIIlIl, int lIIIlIlllIIlII) {
        CSCategoryButton lIIIlIlllIlIll;
        boolean lIIIlIlllIlIII = lIIIlIlllIIlIl > lIIIlIlllIlIll.x && lIIIlIlllIIlIl < lIIIlIlllIlIll.x + lIIIlIlllIlIll.width;
        boolean lIIIlIlllIIlll = lIIIlIlllIIlII > lIIIlIlllIlIll.y && lIIIlIlllIIlII < lIIIlIlllIlIll.y + lIIIlIlllIlIll.height;
        return lIIIlIlllIlIII && lIIIlIlllIIlll;
    }

    @Override
    public void mouseClicked(int lIIIlIllIlIIll, int lIIIlIllIIlllI, int lIIIlIllIlIIIl) throws IOException {
        CSCategoryButton lIIIlIllIlIlII;
        for (CSModButton lIIIlIllIlIlIl : lIIIlIllIlIlII.buttons) {
            lIIIlIllIlIlIl.mouseClicked(lIIIlIllIlIIll, lIIIlIllIIlllI, lIIIlIllIlIIIl);
            if (lIIIlIllIlIIIl == 1 && lIIIlIllIlIlIl.isHovered(lIIIlIllIlIIll, lIIIlIllIIlllI)) {
                lIIIlIllIlIlII.currentMod = lIIIlIllIlIlIl;
            }
            if (lIIIlIllIlIIIl != 2 || !lIIIlIllIlIlIl.isHovered(lIIIlIllIlIIll, lIIIlIllIIlllI)) continue;
            lIIIlIllIlIlII.setBinding(true);
        }
        super.mouseClicked(lIIIlIllIlIIll, lIIIlIllIIlllI, lIIIlIllIlIIIl);
    }

    @Override
    public void drawScreen(int lIIIlIlllllllI, int lIIIlIlllllIII, float lIIIlIllllIlll) {
        CSCategoryButton lIIIlIllllllll;
        int lIIIlIlllllIll = lIIIlIllllllll.isHovered(lIIIlIlllllllI, lIIIlIlllllIII) || CatClient.instance.csgui.currentCategory == lIIIlIllllllll ? CatClient.getClientColor().getRGB() : lIIIlIllllllll.color;
        lIIIlIllllllll.fr.drawString(lIIIlIllllllll.displayString, lIIIlIllllllll.x, lIIIlIllllllll.y, lIIIlIlllllIll);
        for (CSModButton lIIIllIIIIIIII : lIIIlIllllllll.buttons) {
            if (CatClient.instance.csgui.currentCategory != lIIIlIllllllll) continue;
            lIIIllIIIIIIII.drawScreen(lIIIlIlllllllI, lIIIlIlllllIII, lIIIlIllllIlll);
        }
        super.drawScreen(lIIIlIlllllllI, lIIIlIlllllIII, lIIIlIllllIlll);
    }

    public void setBinding(boolean lIIIlIllIllllI) {
        binding = lIIIlIllIllllI;
    }

    public CSCategoryButton(int lIIIllIIIlIllI, int lIIIllIIIlIlIl, int lIIIllIIIlIlII, int lIIIllIIIIlIll, int lIIIllIIIIlIlI, String lIIIllIIIIlIIl, Category lIIIllIIIIlIII) {
        super(lIIIllIIIlIllI, lIIIllIIIlIlIl, lIIIllIIIlIlII, lIIIllIIIIlIll, lIIIllIIIIlIlI, lIIIllIIIIlIIl);
        CSCategoryButton lIIIllIIIIllll;
        lIIIllIIIIllll.buttons = new ArrayList();
        lIIIllIIIIllll.category = lIIIllIIIIlIII;
    }

    private boolean isCurrentPanel() {
        CSCategoryButton lIIIlIlIllIllI;
        return CatClient.instance.csgui.currentCategory == lIIIlIlIllIllI;
    }

    @Override
    public void onKeyPress(int lIIIlIllllIIlI, int lIIIlIllllIIIl) {
    }
}

