/*
 * Decompiled with CFR 0.150.
 */
package ru.hld.legendline.api.setting;

import java.util.ArrayList;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.api.setting.Setting;

public class SettingManager {
    /* synthetic */ ArrayList<Setting> settings;

    public void add(Setting llllllllllllllllIlIIIIIIIlIIlIII) {
        SettingManager llllllllllllllllIlIIIIIIIlIIlIIl;
        llllllllllllllllIlIIIIIIIlIIlIIl.settings.add(llllllllllllllllIlIIIIIIIlIIlIII);
    }

    public SettingManager() {
        SettingManager llllllllllllllllIlIIIIIIIlIIllll;
        llllllllllllllllIlIIIIIIIlIIllll.settings = new ArrayList();
    }

    public ArrayList<Setting> getSettings(Module llllllllllllllllIlIIIIIIIlIIIIII) {
        SettingManager llllllllllllllllIlIIIIIIIIlllllI;
        ArrayList<Setting> llllllllllllllllIlIIIIIIIIllllll = new ArrayList<Setting>();
        for (Setting llllllllllllllllIlIIIIIIIlIIIIlI : llllllllllllllllIlIIIIIIIIlllllI.settings) {
            if (llllllllllllllllIlIIIIIIIlIIIIlI.module != llllllllllllllllIlIIIIIIIlIIIIII) continue;
            llllllllllllllllIlIIIIIIIIllllll.add(llllllllllllllllIlIIIIIIIlIIIIlI);
        }
        return llllllllllllllllIlIIIIIIIIllllll;
    }
}

