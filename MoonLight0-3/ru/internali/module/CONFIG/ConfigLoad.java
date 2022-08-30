/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.module.CONFIG;

import java.io.IOException;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.utils.Config;

public class ConfigLoad
extends Module {
    public ConfigLoad() {
        super("ConfigLoad", "ConfigLoad", Category.CONFIG);
        ConfigLoad lIIllIIlllIllI;
    }

    @Override
    public void onEnable() {
        ConfigLoad lIIllIIllIlllI;
        super.onEnable();
        Config lIIllIIllIllll = new Config();
        try {
            lIIllIIllIllll.load();
        }
        catch (IOException lIIllIIlllIIIl) {
            throw new RuntimeException(lIIllIIlllIIIl);
        }
        CatClient.instance.moduleManager.getModule("ConfigLoad").setEnable(false);
        lIIllIIllIlllI.setToggled(false);
    }
}

