/*
 * Decompiled with CFR 0.150.
 */
package clickgui.setting;

import clickgui.setting.Setting;
import java.util.ArrayList;
import ru.internali.module.Module;

public class SettingsManager {
    private /* synthetic */ ArrayList<Setting> settings;

    public SettingsManager() {
        SettingsManager lIIllllIIlIIlI;
        lIIllllIIlIIlI.settings = new ArrayList();
    }

    public ArrayList<Setting> getSettings() {
        SettingsManager lIIllllIIIlIIl;
        return lIIllllIIIlIIl.settings;
    }

    public void rSetting(Setting lIIllllIIIlIll) {
        SettingsManager lIIllllIIIllII;
        lIIllllIIIllII.settings.add(lIIllllIIIlIll);
    }

    public ArrayList<Setting> getSettingsByMod(Module lIIllllIIIIlIl) {
        ArrayList<Setting> lIIllllIIIIlII = new ArrayList<Setting>();
        if (lIIllllIIIIlII.isEmpty()) {
            return null;
        }
        return lIIllllIIIIlII;
    }

    public Setting getSettingByName(String lIIlllIllllIlI) {
        SettingsManager lIIlllIllllIll;
        for (Setting lIIlllIllllllI : lIIlllIllllIll.getSettings()) {
            if (!lIIlllIllllllI.getName().equalsIgnoreCase(lIIlllIllllIlI)) continue;
            return lIIlllIllllllI;
        }
        System.err.println(String.valueOf(new StringBuilder().append("Error Setting NOT found: '").append(lIIlllIllllIlI).append("'!")));
        return null;
    }
}

