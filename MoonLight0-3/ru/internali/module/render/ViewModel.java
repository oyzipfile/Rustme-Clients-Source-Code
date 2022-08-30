/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.EnumHand
 *  net.minecraftforge.client.event.RenderSpecificHandEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.opengl.GL11
 */
package ru.internali.module.render;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.util.EnumHand;
import net.minecraftforge.client.event.RenderSpecificHandEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;

public class ViewModel
extends Module {
    public static /* synthetic */ List<String> listA;

    @Override
    public void onDisable() {
        ViewModel lIlIIllIllIIIlI;
        super.onDisable();
    }

    @SubscribeEvent
    public void onRender(RenderSpecificHandEvent lIlIIllIlIlIlIl) {
        ViewModel lIlIIllIlIIlllI;
        float lIlIIllIlIlIlII = (float)CatClient.instance.settingsManager.getSettingByName(lIlIIllIlIIlllI, "rightPosX").getValDouble();
        float lIlIIllIlIlIIll = (float)CatClient.instance.settingsManager.getSettingByName(lIlIIllIlIIlllI, "rightPosY").getValDouble();
        float lIlIIllIlIlIIlI = (float)CatClient.instance.settingsManager.getSettingByName(lIlIIllIlIIlllI, "rightPosZ").getValDouble();
        float lIlIIllIlIlIIIl = (float)CatClient.instance.settingsManager.getSettingByName(lIlIIllIlIIlllI, "leftPosX").getValDouble();
        float lIlIIllIlIlIIII = (float)CatClient.instance.settingsManager.getSettingByName(lIlIIllIlIIlllI, "leftPosY").getValDouble();
        float lIlIIllIlIIllll = (float)CatClient.instance.settingsManager.getSettingByName(lIlIIllIlIIlllI, "leftPosZ").getValDouble();
        if (lIlIIllIlIlIlIl.getHand() == EnumHand.MAIN_HAND) {
            GL11.glTranslated((double)lIlIIllIlIlIlII, (double)lIlIIllIlIlIIll, (double)lIlIIllIlIlIIlI);
        }
        if (lIlIIllIlIlIlIl.getHand() == EnumHand.OFF_HAND) {
            GL11.glTranslated((double)lIlIIllIlIlIIIl, (double)lIlIIllIlIlIIII, (double)lIlIIllIlIIllll);
        }
    }

    @Override
    public void onEnable() {
        ViewModel lIlIIllIlIlllll;
        super.onEnable();
    }

    static {
        listA = new ArrayList<String>();
    }

    public ViewModel() {
        super("ViewModel", "Show Tracers to players", Category.RENDER);
        ViewModel lIlIIllIllIIlIl;
        CatClient.instance.settingsManager.rSetting(new Setting("rightPosX", lIlIIllIllIIlIl, 0.0, -2.0, 2.0, false));
        CatClient.instance.settingsManager.rSetting(new Setting("rightPosY", lIlIIllIllIIlIl, 0.0, -2.0, 2.0, false));
        CatClient.instance.settingsManager.rSetting(new Setting("rightPosZ", lIlIIllIllIIlIl, 0.0, -2.0, 2.0, false));
        CatClient.instance.settingsManager.rSetting(new Setting("leftPosX", lIlIIllIllIIlIl, 0.0, -2.0, 2.0, false));
        CatClient.instance.settingsManager.rSetting(new Setting("leftPosY", lIlIIllIllIIlIl, 0.0, -2.0, 2.0, false));
        CatClient.instance.settingsManager.rSetting(new Setting("leftPosZ", lIlIIllIllIIlIl, 0.0, -2.0, 2.0, false));
    }
}

