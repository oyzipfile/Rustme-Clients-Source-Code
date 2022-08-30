/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.module.CONFIG;

import java.io.FileNotFoundException;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.utils.Config;

public class ConfigSave
extends Module {
    public ConfigSave() {
        super("ConfigSave", "ConfigSave", Category.CONFIG);
        ConfigSave llIIIllIlIIll;
    }

    @Override
    public void onEnable() {
        ConfigSave llIIIllIIllII;
        super.onEnable();
        Config llIIIllIIllIl = new Config();
        try {
            llIIIllIIllIl.save();
        }
        catch (FileNotFoundException llIIIllIIllll) {
            throw new RuntimeException(llIIIllIIllll);
        }
        CatClient.instance.moduleManager.getModule("ConfigSave").setEnabled(false);
        llIIIllIIllII.setToggled(false);
    }
}

