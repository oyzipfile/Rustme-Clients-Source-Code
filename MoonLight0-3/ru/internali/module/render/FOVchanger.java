/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.client.event.EntityViewRenderEvent$FOVModifier
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package ru.internali.module.render;

import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;

public class FOVchanger
extends Module {
    @Override
    public void onDisable() {
        FOVchanger llllIllIIIlIl;
        super.onDisable();
    }

    @SubscribeEvent
    public void FOVchanger(EntityViewRenderEvent.FOVModifier llllIllIIlIll) {
        FOVchanger llllIllIIllII;
        float llllIllIIlIlI;
        FOVchanger.mc.gameSettings.fovSetting = llllIllIIlIlI = (float)CatClient.instance.settingsManager.getSettingByName(llllIllIIllII, "FOV").getValDouble();
    }

    public FOVchanger() {
        super("FOVchanger", "FOVchanger", Category.RENDER);
        FOVchanger llllIllIlIIII;
        CatClient.instance.settingsManager.rSetting(new Setting("FOV", llllIllIlIIII, 100.0, 10.0, 150.0, false));
    }
}

