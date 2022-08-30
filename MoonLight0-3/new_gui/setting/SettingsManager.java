/*
 * Decompiled with CFR 0.150.
 */
package new_gui.setting;

import java.util.ArrayList;
import new_gui.setting.Setting;
import ru.internali.module.Module;

public class SettingsManager {
    private /* synthetic */ ArrayList<Setting> settings;

    public ArrayList<Setting> getSettings() {
        SettingsManager lllIlIIIIlllIlI;
        return lllIlIIIIlllIlI.settings;
    }

    public void rSetting(Setting lllIlIIIIllllIl) {
        SettingsManager lllIlIIIIlllllI;
        lllIlIIIIlllllI.settings.add(lllIlIIIIllllIl);
    }

    public Setting getSettingByName(String lllIlIIIIlIIlIl) {
        SettingsManager lllIlIIIIlIIllI;
        for (Setting lllIlIIIIlIIlll : lllIlIIIIlIIllI.getSettings()) {
            if (!lllIlIIIIlIIlll.getName().equalsIgnoreCase(lllIlIIIIlIIlIl)) continue;
            return lllIlIIIIlIIlll;
        }
        return null;
    }

    public SettingsManager() {
        SettingsManager lllIlIIIlIIIIll;
        lllIlIIIlIIIIll.settings = new ArrayList();
    }

    public ArrayList<Setting> getSettingsByMod(Module lllIlIIIIlIllll) {
        SettingsManager lllIlIIIIllIIll;
        ArrayList<Setting> lllIlIIIIllIIIl = new ArrayList<Setting>();
        for (Setting lllIlIIIIllIlII : lllIlIIIIllIIll.getSettings()) {
            if (!lllIlIIIIllIlII.getParentMod().equals(lllIlIIIIlIllll)) continue;
            lllIlIIIIllIIIl.add(lllIlIIIIllIlII);
        }
        if (lllIlIIIIllIIIl.isEmpty()) {
            return null;
        }
        return lllIlIIIIllIIIl;
    }
}

