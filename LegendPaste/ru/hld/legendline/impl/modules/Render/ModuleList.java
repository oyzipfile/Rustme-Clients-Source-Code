/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 *  org.lwjgl.opengl.GL11
 */
package ru.hld.legendline.impl.modules.Render;

import java.util.ArrayList;
import java.util.Comparator;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.opengl.GL11;
import ru.hld.legendline.Client;
import ru.hld.legendline.antiNative.RenderUtils;
import ru.hld.legendline.api.event.EventTarget;
import ru.hld.legendline.api.event.events.EventRender2D;
import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.api.setting.settings.BooleanSetting;
import ru.hld.legendline.api.setting.settings.FloatSetting;
import ru.hld.legendline.api.setting.settings.ModeSetting;
import ru.hld.legendline.api.utils.CFontRenderer;
import ru.hld.legendline.api.utils.ColorUtils;
import ru.hld.legendline.api.utils.Fonts;
import ru.hld.legendline.api.utils.MathUtils;

public class ModuleList
extends Module {
    public static /* synthetic */ FloatSetting textred2;
    /* synthetic */ BooleanSetting texts;
    public static /* synthetic */ FloatSetting textgreen2;
    /* synthetic */ ArrayList<SubModule> modules;
    public static /* synthetic */ FloatSetting AlfaA;
    public static /* synthetic */ FloatSetting Blue;
    public static /* synthetic */ FloatSetting textred;
    public static /* synthetic */ FloatSetting Red;
    public static /* synthetic */ FloatSetting textblue2;
    public static /* synthetic */ FloatSetting Red2;
    public static /* synthetic */ FloatSetting Green;
    public static /* synthetic */ FloatSetting textblue;
    /* synthetic */ BooleanSetting shadow;
    /* synthetic */ ModeSetting mode;
    public static /* synthetic */ FloatSetting Green2;
    public static /* synthetic */ FloatSetting textgreen;
    public static /* synthetic */ FloatSetting Blue2;

    public ModuleList() {
        super("ArrayList", "diplay all enabled modules on screen", Category.Render);
        ModuleList lllllllllllllIllIIlllIIlIIIIIlII;
        lllllllllllllIllIIlllIIlIIIIIlII.modules = new ArrayList();
        ArrayList<String> lllllllllllllIllIIlllIIlIIIIIlll = new ArrayList<String>();
        lllllllllllllIllIIlllIIlIIIIIlll.add("Astolfo");
        lllllllllllllIllIIlllIIlIIIIIlll.add("Custom");
        lllllllllllllIllIIlllIIlIIIIIlII.mode = new ModeSetting("Mode", "modes of ArrayList", lllllllllllllIllIIlllIIlIIIIIlII, lllllllllllllIllIIlllIIlIIIIIlll, "Custom");
        Client.settingManager.add(lllllllllllllIllIIlllIIlIIIIIlII.mode);
        textred = new FloatSetting("TextRedFirst", "red color", lllllllllllllIllIIlllIIlIIIIIlII, 0.0f, 255.0f, 255.0f, 1.0f);
        Client.settingManager.add(textred);
        textgreen = new FloatSetting("TextGreenFirst", "red color", lllllllllllllIllIIlllIIlIIIIIlII, 0.0f, 255.0f, 180.0f, 1.0f);
        Client.settingManager.add(textgreen);
        textblue = new FloatSetting("TextBlueFirst", "blue color", lllllllllllllIllIIlllIIlIIIIIlII, 0.0f, 255.0f, 150.0f, 1.0f);
        Client.settingManager.add(textblue);
        textred2 = new FloatSetting("TextRedSecond", "red color", lllllllllllllIllIIlllIIlIIIIIlII, 0.0f, 255.0f, 180.0f, 1.0f);
        Client.settingManager.add(textred2);
        textgreen2 = new FloatSetting("TextGreenSecond", "green color", lllllllllllllIllIIlllIIlIIIIIlII, 0.0f, 255.0f, 140.0f, 1.0f);
        Client.settingManager.add(textgreen2);
        textblue2 = new FloatSetting("TextBlueSecond", "blue color", lllllllllllllIllIIlllIIlIIIIIlII, 0.0f, 255.0f, 255.0f, 1.0f);
        Client.settingManager.add(textblue2);
        lllllllllllllIllIIlllIIlIIIIIlII.shadow = new BooleanSetting("Shadow", "shadow", (Module)lllllllllllllIllIIlllIIlIIIIIlII, true);
        Client.settingManager.add(lllllllllllllIllIIlllIIlIIIIIlII.shadow);
        Red = new FloatSetting("Red", "red color", lllllllllllllIllIIlllIIlIIIIIlII, 0.0f, 255.0f, 255.0f, 1.0f, () -> {
            ModuleList lllllllllllllIllIIlllIIIlIlIIlIl;
            return lllllllllllllIllIIlllIIIlIlIIlIl.shadow.getVal();
        });
        Client.settingManager.add(Red);
        Green = new FloatSetting("Green", "green color", lllllllllllllIllIIlllIIlIIIIIlII, 0.0f, 255.0f, 180.0f, 1.0f, () -> {
            ModuleList lllllllllllllIllIIlllIIIlIlIIlll;
            return lllllllllllllIllIIlllIIIlIlIIlll.shadow.getVal();
        });
        Client.settingManager.add(Green);
        Blue = new FloatSetting("Blue", "blue color", lllllllllllllIllIIlllIIlIIIIIlII, 0.0f, 255.0f, 150.0f, 1.0f, () -> {
            ModuleList lllllllllllllIllIIlllIIIlIlIlIlI;
            return lllllllllllllIllIIlllIIIlIlIlIlI.shadow.getVal();
        });
        Client.settingManager.add(Blue);
        Red2 = new FloatSetting("Red2", "red color", lllllllllllllIllIIlllIIlIIIIIlII, 0.0f, 255.0f, 180.0f, 1.0f, () -> {
            ModuleList lllllllllllllIllIIlllIIIlIlIlllI;
            return lllllllllllllIllIIlllIIIlIlIlllI.shadow.getVal();
        });
        Client.settingManager.add(Red2);
        Green2 = new FloatSetting("Green2", "green color", lllllllllllllIllIIlllIIlIIIIIlII, 0.0f, 255.0f, 140.0f, 1.0f, () -> {
            ModuleList lllllllllllllIllIIlllIIIlIllIIIl;
            return lllllllllllllIllIIlllIIIlIllIIIl.shadow.getVal();
        });
        Client.settingManager.add(Green2);
        Blue2 = new FloatSetting("Blue2", "blue color", lllllllllllllIllIIlllIIlIIIIIlII, 0.0f, 255.0f, 255.0f, 1.0f, () -> {
            ModuleList lllllllllllllIllIIlllIIIlIllIIll;
            return lllllllllllllIllIIlllIIIlIllIIll.shadow.getVal();
        });
        Client.settingManager.add(Blue2);
        AlfaA = new FloatSetting("Alpha", "alfa", lllllllllllllIllIIlllIIlIIIIIlII, 0.0f, 255.0f, 150.0f, 1.0f, () -> {
            ModuleList lllllllllllllIllIIlllIIIlIllIllI;
            return lllllllllllllIllIIlllIIIlIllIllI.shadow.getVal();
        });
        Client.settingManager.add(AlfaA);
    }

    /*
     * WARNING - void declaration
     */
    @EventTarget
    public void onRender2D(EventRender2D lllllllllllllIllIIlllIIIllIlIlll) {
        ModuleList lllllllllllllIllIIlllIIIllIlIIIl;
        final CFontRenderer lllllllllllllIllIIlllIIIllIlIllI = Fonts.mntsb_18;
        int lllllllllllllIllIIlllIIIllIlIlIl = GuiScreen.width - 8;
        int lllllllllllllIllIIlllIIIllIlIlII = 8;
        for (SubModule subModule : lllllllllllllIllIIlllIIIllIlIIIl.modules) {
            if (subModule.getModule().isEnabled()) {
                subModule.setAnim(MathUtils.lerp(subModule.getAnim(), 1.0f, 0.1f));
                subModule.setY((int)MathUtils.lerp(subModule.getY(), lllllllllllllIllIIlllIIIllIlIllI.getHeight() + 10, 0.1f));
                continue;
            }
            subModule.setAnim(MathUtils.lerp(subModule.getAnim(), 0.0f, 0.1f));
            subModule.setY((int)MathUtils.lerp(subModule.getY(), 0.0f, 0.1f));
        }
        lllllllllllllIllIIlllIIIllIlIIIl.modules.sort(new Comparator<SubModule>(){

            @Override
            public int compare(SubModule lllllllllllllIlllIIIIllIIIIIlllI, SubModule lllllllllllllIlllIIIIllIIIIIllIl) {
                1 lllllllllllllIlllIIIIllIIIIIllll;
                return lllllllllllllIlllIIIIllIIIIIllll.lllllllllllllIllIIlllIIIllIlIllI.getStringWidth(lllllllllllllIlllIIIIllIIIIIllIl.getModule().getDisplayname()) - lllllllllllllIlllIIIIllIIIIIllll.lllllllllllllIllIIlllIIIllIlIllI.getStringWidth(lllllllllllllIlllIIIIllIIIIIlllI.getModule().getDisplayname());
            }
            {
                1 lllllllllllllIlllIIIIllIIIIlIlIl;
            }
        });
        int lllllllllllllIllIIlllIIIllIlIIll = 0;
        for (Module lllllllllllllIllIIlllIIIllIllllI : Client.moduleManager.modules) {
            if (!lllllllllllllIllIIlllIIIllIllllI.isEnabled()) continue;
            ++lllllllllllllIllIIlllIIIllIlIIll;
        }
        boolean bl = false;
        for (SubModule lllllllllllllIllIIlllIIIllIllIIl : lllllllllllllIllIIlllIIIllIlIIIl.modules) {
            void var6_10;
            GL11.glPushMatrix();
            float lllllllllllllIllIIlllIIIllIlllIl = lllllllllllllIllIIlllIIIllIlIlIl - lllllllllllllIllIIlllIIIllIlIllI.getStringWidth(lllllllllllllIllIIlllIIIllIllIIl.getModule().getDisplayname());
            float lllllllllllllIllIIlllIIIllIlllII = lllllllllllllIllIIlllIIIllIlIlII + var6_10;
            float lllllllllllllIllIIlllIIIllIllIll = lllllllllllllIllIIlllIIIllIlIllI.getStringWidth(lllllllllllllIllIIlllIIIllIllIIl.getModule().getDisplayname());
            float lllllllllllllIllIIlllIIIllIllIlI = 10.0f;
            GL11.glTranslated((double)lllllllllllllIllIIlllIIIllIllIll, (double)lllllllllllllIllIIlllIIIllIllIlI, (double)1.0);
            GL11.glTranslated((double)(-lllllllllllllIllIIlllIIIllIlllIl * lllllllllllllIllIIlllIIIllIllIIl.getAnim() + lllllllllllllIllIIlllIIIllIlllIl + lllllllllllllIllIIlllIIIllIllIll * -lllllllllllllIllIIlllIIIllIllIIl.getAnim()), (double)(-lllllllllllllIllIIlllIIIllIlllII * 1.0f + lllllllllllllIllIIlllIIIllIlllII + lllllllllllllIllIIlllIIIllIllIlI * 1.0f), (double)1.0);
            GL11.glScaled((double)lllllllllllllIllIIlllIIIllIllIIl.getAnim(), (double)1.0, (double)0.0);
            switch (lllllllllllllIllIIlllIIIllIlIIIl.mode.getVal()) {
                case "Astolfo": {
                    if (lllllllllllllIllIIlllIIIllIlIIIl.shadow.getVal()) {
                        RenderUtils.drawShadow(lllllllllllllIllIIlllIIIllIlIlIl - lllllllllllllIllIIlllIIIllIlIllI.getStringWidth(lllllllllllllIllIIlllIIIllIllIIl.getModule().getDisplayname()) + 1, lllllllllllllIllIIlllIIIllIlIlII + var6_10 + 4, lllllllllllllIllIIlllIIIllIlIlIl, lllllllllllllIllIIlllIIIllIlIlII + var6_10 + 4, 9, Client.getBackArray());
                    }
                    lllllllllllllIllIIlllIIIllIlIllI.drawStringWithShadow(lllllllllllllIllIIlllIIIllIllIIl.getModule().getDisplayname(), lllllllllllllIllIIlllIIIllIlIlIl - lllllllllllllIllIIlllIIIllIlIllI.getStringWidth(lllllllllllllIllIIlllIIIllIllIIl.getModule().getDisplayname()), lllllllllllllIllIIlllIIIllIlIlII + var6_10 + 2, ColorUtils.astolfoColorsCool(1, 80 + var6_10 / 3));
                    break;
                }
                case "Custom": {
                    if (lllllllllllllIllIIlllIIIllIlIIIl.shadow.getVal()) {
                        RenderUtils.drawShadow(lllllllllllllIllIIlllIIIllIlIlIl - lllllllllllllIllIIlllIIIllIlIllI.getStringWidth(lllllllllllllIllIIlllIIIllIllIIl.getModule().getDisplayname()) + 1, lllllllllllllIllIIlllIIIllIlIlII + var6_10 + 4, lllllllllllllIllIIlllIIIllIlIlIl, lllllllllllllIllIIlllIIIllIlIlII + var6_10 + 4, 8, Client.getBackArray());
                    }
                    lllllllllllllIllIIlllIIIllIlIllI.drawStringWithShadow(lllllllllllllIllIIlllIIIllIllIIl.getModule().getDisplayname(), lllllllllllllIllIIlllIIIllIlIlIl - lllllllllllllIllIIlllIIIllIlIllI.getStringWidth(lllllllllllllIllIIlllIIIllIllIIl.getModule().getDisplayname()), lllllllllllllIllIIlllIIIllIlIlII + var6_10 + 2, Client.getArray());
                }
            }
            GL11.glPopMatrix();
            var6_10 += lllllllllllllIllIIlllIIIllIllIIl.getY();
        }
    }

    @Override
    public void onEnable() {
        ModuleList lllllllllllllIllIIlllIIIlIllllII;
        super.onEnable();
        int lllllllllllllIllIIlllIIIlIllllIl = GuiScreen.width - 3;
        lllllllllllllIllIIlllIIIlIllllII.modules.clear();
        for (Module lllllllllllllIllIIlllIIIlIllllll : Client.moduleManager.modules) {
            lllllllllllllIllIIlllIIIlIllllII.modules.add(new SubModule(lllllllllllllIllIIlllIIIlIllllll));
        }
    }

    static class SubModule {
        /* synthetic */ float anim;
        /* synthetic */ Module module;
        /* synthetic */ int y;

        public void setY(int lllllllllllllllIlIllllllIIIIlIII) {
            lllllllllllllllIlIllllllIIIIIlll.y = lllllllllllllllIlIllllllIIIIlIII;
        }

        public int getY() {
            SubModule lllllllllllllllIlIllllllIIIIllII;
            return lllllllllllllllIlIllllllIIIIllII.y;
        }

        public Module getModule() {
            SubModule lllllllllllllllIlIllllllIIIIllll;
            return lllllllllllllllIlIllllllIIIIllll.module;
        }

        public SubModule(Module lllllllllllllllIlIllllllIIIllIll) {
            SubModule lllllllllllllllIlIllllllIIIlllII;
            lllllllllllllllIlIllllllIIIlllII.y = 0;
            lllllllllllllllIlIllllllIIIlllII.anim = 0.0f;
            lllllllllllllllIlIllllllIIIlllII.module = lllllllllllllllIlIllllllIIIllIll;
        }

        public void setAnim(float lllllllllllllllIlIllllllIIIlIIlI) {
            lllllllllllllllIlIllllllIIIlIIll.anim = lllllllllllllllIlIllllllIIIlIIlI;
        }

        public float getAnim() {
            SubModule lllllllllllllllIlIllllllIIIllIIl;
            return lllllllllllllllIlIllllllIIIllIIl.anim;
        }
    }
}

