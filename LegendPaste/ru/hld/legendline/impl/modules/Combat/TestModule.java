/*
 * Decompiled with CFR 0.150.
 */
package ru.hld.legendline.impl.modules.Combat;

import java.util.ArrayList;
import ru.hld.legendline.Client;
import ru.hld.legendline.api.event.EventTarget;
import ru.hld.legendline.api.event.events.EventRender2D;
import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.api.setting.settings.BooleanSetting;
import ru.hld.legendline.api.setting.settings.FloatSetting;
import ru.hld.legendline.api.setting.settings.ModeSetting;

public class TestModule
extends Module {
    /* synthetic */ BooleanSetting check;
    /* synthetic */ ModeSetting mode;
    /* synthetic */ FloatSetting slider;

    public TestModule() {
        super("TestModule", "test module for clickgui", Category.Combat);
        TestModule lllllllllllllllIIlIIlllIIIIIlIlI;
        lllllllllllllllIIlIIlllIIIIIlIlI.check = new BooleanSetting("Check", "test check box", (Module)lllllllllllllllIIlIIlllIIIIIlIlI, true);
        Client.settingManager.add(lllllllllllllllIIlIIlllIIIIIlIlI.check);
        lllllllllllllllIIlIIlllIIIIIlIlI.slider = new FloatSetting("Slider", "test slider", lllllllllllllllIIlIIlllIIIIIlIlI, 0.0f, 16.0f, 8.0f, 0.1f);
        Client.settingManager.add(lllllllllllllllIIlIIlllIIIIIlIlI.slider);
        ArrayList<String> lllllllllllllllIIlIIlllIIIIIlIll = new ArrayList<String>();
        lllllllllllllllIIlIIlllIIIIIlIll.add("Test1");
        lllllllllllllllIIlIIlllIIIIIlIll.add("Test2");
        lllllllllllllllIIlIIlllIIIIIlIll.add("bavarca");
        lllllllllllllllIIlIIlllIIIIIlIlI.mode = new ModeSetting("Mode", "test Mode setting", lllllllllllllllIIlIIlllIIIIIlIlI, lllllllllllllllIIlIIlllIIIIIlIll, "Test1");
        Client.settingManager.add(lllllllllllllllIIlIIlllIIIIIlIlI.mode);
        lllllllllllllllIIlIIlllIIIIIlIlI.toggle();
        lllllllllllllllIIlIIlllIIIIIlIlI.setKey(37);
    }

    @EventTarget
    public void onRender2D(EventRender2D lllllllllllllllIIlIIlllIIIIIIlll) {
    }
}

