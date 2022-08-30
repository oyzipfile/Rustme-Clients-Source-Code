/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.client.event.EntityViewRenderEvent$FogDensity
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package ru.internali.module.World;

import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;

public class AntiFog
extends Module {
    public AntiFog() {
        super("AntiFog", "AntiFog", Category.WORLD);
        AntiFog lIIlllIllIIllI;
        CatClient.instance.settingsManager.rSetting(new Setting("Density", lIIlllIllIIllI, 1.0, 0.0, 100.0, true));
    }

    @SubscribeEvent
    public void fogDensity(EntityViewRenderEvent.FogDensity lIIlllIllIIIIl) {
        AntiFog lIIlllIlIlllll;
        int lIIlllIllIIIII = (int)CatClient.instance.settingsManager.getSettingByName(lIIlllIlIlllll, "Density").getValDouble();
        lIIlllIllIIIIl.setDensity((float)lIIlllIllIIIII);
        lIIlllIllIIIIl.setCanceled(true);
    }
}

