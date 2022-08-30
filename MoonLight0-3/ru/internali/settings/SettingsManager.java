/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.settings;

import java.util.ArrayList;
import ru.internali.module.Module;
import ru.internali.settings.Setting;

public class SettingsManager {
    private /* synthetic */ ArrayList<Setting> settings;

    public ArrayList<Setting> getSettings() {
        SettingsManager lIIIIlIIlIIlIll;
        return lIIIIlIIlIIlIll.settings;
    }

    public Setting getSettingByName(Module lIIIIlIIIIlllll, String lIIIIlIIIIllllI) {
        SettingsManager lIIIIlIIIlIIIII;
        for (Setting lIIIIlIIIlIIIIl : lIIIIlIIIlIIIII.getSettings()) {
            if (!lIIIIlIIIlIIIIl.getName().equalsIgnoreCase(lIIIIlIIIIllllI) || lIIIIlIIIlIIIIl.getParentMod() != lIIIIlIIIIlllll) continue;
            return lIIIIlIIIlIIIIl;
        }
        System.err.println(String.valueOf(new StringBuilder().append("[Tutorial] Error Setting NOT found: '").append(lIIIIlIIIIllllI).append("'!")));
        return null;
    }

    public ArrayList<Setting> getSettings(Module lIIIIlIIIIIlIll) {
        SettingsManager lIIIIlIIIIIllII;
        ArrayList<Setting> lIIIIlIIIIIlIlI = new ArrayList<Setting>();
        for (Setting lIIIIlIIIIIllIl : lIIIIlIIIIIllII.settings) {
            if (lIIIIlIIIIIllIl.module != lIIIIlIIIIIlIll) continue;
            lIIIIlIIIIIlIlI.add(lIIIIlIIIIIllIl);
        }
        return lIIIIlIIIIIlIlI;
    }

    public SettingsManager() {
        SettingsManager lIIIIlIIlIlIlIl;
        lIIIIlIIlIlIlIl.settings = new ArrayList();
    }

    public void add(Setting lIIIIlIIIIlIIll) {
        SettingsManager lIIIIlIIIIlIllI;
        lIIIIlIIIIlIllI.settings.add(lIIIIlIIIIlIIll);
    }

    public ArrayList<Setting> getSettingsByMod(Module lIIIIlIIlIIIIll) {
        SettingsManager lIIIIlIIlIIIIIl;
        ArrayList<Setting> lIIIIlIIlIIIIlI = new ArrayList<Setting>();
        for (Setting lIIIIlIIlIIIlIl : lIIIIlIIlIIIIIl.getSettings()) {
            if (!lIIIIlIIlIIIlIl.getParentMod().equals(lIIIIlIIlIIIIll)) continue;
            lIIIIlIIlIIIIlI.add(lIIIIlIIlIIIlIl);
        }
        if (lIIIIlIIlIIIIlI.isEmpty()) {
            return null;
        }
        return lIIIIlIIlIIIIlI;
    }

    public Setting getSettingById(String lIIIIlIIIllIllI) {
        SettingsManager lIIIIlIIIllIlIl;
        for (Setting lIIIIlIIIlllIII : lIIIIlIIIllIlIl.settings) {
            if (!lIIIIlIIIlllIII.getId().equalsIgnoreCase(lIIIIlIIIllIllI)) continue;
            return lIIIIlIIIlllIII;
        }
        return null;
    }

    public Setting getSettingByName(String lIIIIlIIIlIlIll) {
        SettingsManager lIIIIlIIIlIllII;
        for (Setting lIIIIlIIIlIllIl : lIIIIlIIIlIllII.getSettings()) {
            if (!lIIIIlIIIlIllIl.getName().equalsIgnoreCase(lIIIIlIIIlIlIll)) continue;
            return lIIIIlIIIlIllIl;
        }
        System.out.println(String.valueOf(new StringBuilder().append("Setting not found! (").append(lIIIIlIIIlIlIll).append(").")));
        return null;
    }

    public void rSetting(Setting lIIIIlIIlIlIIII) {
        SettingsManager lIIIIlIIlIlIIIl;
        lIIIIlIIlIlIIIl.settings.add(lIIIIlIIlIlIIII);
    }
}

