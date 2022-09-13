/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 */
package ru.hld.legendline.impl.modules.Render;

import net.minecraft.client.gui.GuiScreen;
import ru.hld.legendline.Client;
import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.api.setting.settings.BooleanSetting;
import ru.hld.legendline.api.setting.settings.FloatSetting;

public class ClickGui
extends Module {
    public static /* synthetic */ BooleanSetting shadows;
    public static /* synthetic */ FloatSetting GreenSecond;
    public static /* synthetic */ FloatSetting BlueFirst;
    public static /* synthetic */ FloatSetting BlueSecond;
    public static /* synthetic */ FloatSetting RedFirst;
    public static /* synthetic */ FloatSetting RedSecond;
    public static /* synthetic */ FloatSetting GreenFirst;

    public ClickGui() {
        super("ClickGui", "Main menu", Category.Render);
        ClickGui llllllllllllllllllIlIIIlllIlIIII;
        llllllllllllllllllIlIIIlllIlIIII.setKey(54);
        RedFirst = new FloatSetting("RedFirst", "red color", llllllllllllllllllIlIIIlllIlIIII, 0.0f, 255.0f, 255.0f, 1.0f);
        Client.settingManager.add(RedFirst);
        GreenFirst = new FloatSetting("GreenFirst", "green color", llllllllllllllllllIlIIIlllIlIIII, 0.0f, 255.0f, 180.0f, 1.0f);
        Client.settingManager.add(GreenFirst);
        BlueFirst = new FloatSetting("BlueFirst", "blue color", llllllllllllllllllIlIIIlllIlIIII, 0.0f, 255.0f, 145.0f, 1.0f);
        Client.settingManager.add(BlueFirst);
        RedSecond = new FloatSetting("RedSecond", "red color", llllllllllllllllllIlIIIlllIlIIII, 0.0f, 255.0f, 180.0f, 1.0f);
        Client.settingManager.add(RedSecond);
        GreenSecond = new FloatSetting("GreenSecond", "green color", llllllllllllllllllIlIIIlllIlIIII, 0.0f, 255.0f, 140.0f, 1.0f);
        Client.settingManager.add(GreenSecond);
        BlueSecond = new FloatSetting("BlueSecond", "blue color", llllllllllllllllllIlIIIlllIlIIII, 0.0f, 255.0f, 255.0f, 1.0f);
        Client.settingManager.add(BlueSecond);
        shadows = new BooleanSetting("Shadow", "", (Module)llllllllllllllllllIlIIIlllIlIIII, true);
        Client.settingManager.add(shadows);
    }

    @Override
    public void onEnable() {
        ClickGui llllllllllllllllllIlIIIlllIIllIl;
        super.onEnable();
        llllllllllllllllllIlIIIlllIIllIl.mc.displayGuiScreen((GuiScreen)Client.gui);
        llllllllllllllllllIlIIIlllIIllIl.toggle();
    }
}

