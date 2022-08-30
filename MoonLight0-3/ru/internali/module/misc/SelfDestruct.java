/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.module.misc;

import java.util.Objects;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;

public class SelfDestruct
extends Module {
    public static /* synthetic */ boolean self;

    public SelfDestruct() {
        super("SelfDestruct", "clouse client", Category.OUTHER);
        SelfDestruct llllIIIlllllIl;
    }

    @Override
    public void onEnable() {
        SelfDestruct llllIIIlllIllI;
        super.onEnable();
        mc.displayGuiScreen(null);
        for (Module llllIIIllllIII : CatClient.instance.moduleManager.getModuleList()) {
            if (Objects.equals(llllIIIllllIII.getName(), "SelfDestruct")) continue;
            llllIIIllllIII.setToggled(false);
        }
        self = true;
        SelfDestruct.mc.player.field_70177_z = 0.0f;
        SelfDestruct.mc.player.field_70125_A = 0.0f;
    }

    static {
        self = false;
    }
}

