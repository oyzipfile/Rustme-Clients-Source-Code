/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package ru.internali.clickgui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import org.lwjgl.opengl.GL11;
import ru.internali.CatClient;
import ru.internali.clickgui.Component;
import ru.internali.clickgui.Mod;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.utils.MathUtils;
import ru.internali.utils.RenderUtil;
import ru.internali.utils.RenderUtils;

public class Panel
extends Component {
    public /* synthetic */ Category category;
    public /* synthetic */ ArrayList<Mod> mods;

    @Override
    public float getHeight() {
        return 15.0f;
    }

    public Category getCategory() {
        Panel lIllIlllIllllll;
        return lIllIlllIllllll.category;
    }

    public Panel(Category lIllIlllllIllll) {
        Panel lIllIllllllIIII;
        lIllIllllllIIII.mods = new ArrayList();
        lIllIllllllIIII.category = lIllIlllllIllll;
        for (Module lIllIllllllIIll : CatClient.instance.moduleManager.getModules(lIllIlllllIllll)) {
            lIllIllllllIIII.mods.add(new Mod(lIllIllllllIIll));
        }
    }

    @Override
    public void mouseClicked(int lIllIllllIlIIll, int lIllIllllIlIIlI, int lIllIllllIlIIIl, int lIllIllllIIlIlI, int lIllIllllIIlIIl) throws IOException {
        Panel lIllIllllIIlllI;
        super.mouseClicked(lIllIllllIlIIll, lIllIllllIlIIlI, lIllIllllIlIIIl, lIllIllllIIlIlI, lIllIllllIIlIIl);
        if (lIllIllllIIlllI.ishover(lIllIllllIlIIll, lIllIllllIlIIlI, (float)lIllIllllIlIIll + lIllIllllIIlllI.getWidth(), (float)lIllIllllIlIIlI + lIllIllllIIlllI.getHeight(), lIllIllllIlIIIl, lIllIllllIIlIlI)) {
            CatClient.instance.clickGui.currentPanel = lIllIllllIIlllI;
            CatClient.instance.clickGui.modScroll = 0.0f;
        }
    }

    @Override
    public float getWidth() {
        Panel lIllIlllIllllII;
        return lIllIlllIllllII.fr.getStringWidth(lIllIlllIllllII.category.name()) + 2;
    }

    @Override
    public void drawScreen(int lIllIllllIlllll, int lIllIllllIllllI, int lIllIllllIlllIl, int lIllIllllIlllII, float lIllIlllllIIIIl) {
        Panel lIllIlllllIIIII;
        super.drawScreen(lIllIllllIlllll, lIllIllllIllllI, lIllIllllIlllIl, lIllIllllIlllII, lIllIlllllIIIIl);
        GL11.glPushMatrix();
        lIllIlllllIIIII.anim = CatClient.instance.clickGui.currentPanel == lIllIlllllIIIII ? MathUtils.lerp(lIllIlllllIIIII.anim, 1.1f, 0.1f) : MathUtils.lerp(lIllIlllllIIIII.anim, 1.0f, 0.1f);
        RenderUtils.customScaledObject2D(lIllIllllIlllll, lIllIllllIllllI, lIllIlllllIIIII.getWidth(), lIllIlllllIIIII.getHeight(), lIllIlllllIIIII.anim);
        RenderUtil.drawSmoothRect(lIllIllllIlllll, lIllIllllIllllI, (float)lIllIllllIlllll + lIllIlllllIIIII.getWidth(), (float)lIllIllllIllllI + lIllIlllllIIIII.getHeight(), new Color(45, 45, 45).getRGB());
        lIllIlllllIIIII.fr.drawString(lIllIlllllIIIII.category.name(), lIllIllllIlllll + 1, (int)((float)lIllIllllIllllI + lIllIlllllIIIII.getHeight() / 2.0f - (float)(lIllIlllllIIIII.fr.FONT_HEIGHT / 2)), CatClient.instance.clickGui.currentPanel == lIllIlllllIIIII ? -1 : new Color(200, 200, 200).getRGB());
        GL11.glPopMatrix();
    }

    @Override
    public void initGui() {
        Panel lIllIllllIIIIll;
        super.initGui();
    }

    @Override
    public void reset() {
        Panel lIllIllllIIIllI;
        super.reset();
    }
}

