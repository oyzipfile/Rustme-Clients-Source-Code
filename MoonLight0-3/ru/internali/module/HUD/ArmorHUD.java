/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.RenderItem
 *  net.minecraft.item.ItemStack
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$Text
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package ru.internali.module.HUD;

import net.minecraft.client.renderer.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;
import ru.internali.utils.RenderUtils;

public class ArmorHUD
extends Module {
    private static /* synthetic */ RenderItem itemRender;

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Text llIIlllIIIllIII) {
        ArmorHUD llIIlllIIIlIIll;
        float llIIlllIIIlIlll = (float)CatClient.instance.settingsManager.getSettingByName(llIIlllIIIlIIll, "PosX").getValDouble();
        float llIIlllIIIlIllI = 50.0f;
        RenderUtils.drawShadowRect(llIIlllIIIlIlll, llIIlllIIIlIllI, llIIlllIIIlIlll + 20.0f, llIIlllIIIlIllI + 80.0f, 4);
        int llIIlllIIIlIlIl = llIIlllIIIlIIll.getPosY();
        int llIIlllIIIlIlII = llIIlllIIIlIIll.getPosX();
        for (ItemStack llIIlllIIIllIll : ArmorHUD.mc.player.func_184193_aE()) {
            RenderUtils.renderItem(llIIlllIIIllIll, (int)(llIIlllIIIlIlll + 2.0f), llIIlllIIIlIlIl + 2);
            llIIlllIIIlIlIl -= 15;
        }
    }

    public ArmorHUD() {
        super("ArmorHUD", "ArmorHUD", Category.HUD);
        ArmorHUD llIIlllIIlIIIll;
        CatClient.instance.settingsManager.rSetting(new Setting("PosX", llIIlllIIlIIIll, 50.0, 0.0, 700.0, true));
    }
}

