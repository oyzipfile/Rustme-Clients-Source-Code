/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.init.Items
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package ru.internali.module.combat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.minecraft.init.Items;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;

public class Airshoot
extends Module {
    public static /* synthetic */ List<String> Modes;

    static {
        Modes = new ArrayList<String>();
    }

    public Airshoot() {
        super("Airshoot", "AntiAim", Category.COMBAT);
        Airshoot lIIlIIIllIllIl;
        Modes.add("Bypass");
        Modes.add("Bypass V2");
        CatClient.instance.settingsManager.rSetting(new Setting("Mode", lIIlIIIllIllIl, "Bypass V2", (ArrayList)Modes));
        CatClient.instance.settingsManager.rSetting(new Setting("slot", lIIlIIIllIllIl, 1.0, 1.0, 9.0, true));
        CatClient.instance.settingsManager.rSetting(new Setting("slot2", lIIlIIIllIllIl, 1.0, 1.0, 9.0, true));
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent lIIlIIIllIIllI) {
        Airshoot lIIlIIIllIIlll;
        String lIIlIIIllIIlIl = CatClient.instance.settingsManager.getSettingByName(lIIlIIIllIIlll, "Mode").getValString();
        float lIIlIIIllIIlII = (float)CatClient.instance.settingsManager.getSettingByName(lIIlIIIllIIlll, "slot").getValDouble();
        float lIIlIIIllIIIll = (float)CatClient.instance.settingsManager.getSettingByName(lIIlIIIllIIlll, "slot2").getValDouble();
        if (Objects.equals(lIIlIIIllIIlIl, "Bypass")) {
            if (Airshoot.mc.player.func_184811_cZ().getCooldown(Items.DIAMOND_PICKAXE, mc.getRenderPartialTicks()) != 1.0f) {
                Airshoot.mc.player.field_71071_by.currentItem = (int)lIIlIIIllIIlII - 1;
            }
            if (Airshoot.mc.player.field_70122_E && !Airshoot.mc.gameSettings.keyBindAttack.isKeyDown()) {
                Airshoot.mc.player.field_71071_by.currentItem = (int)lIIlIIIllIIIll - 1;
            }
        } else if (Objects.equals(lIIlIIIllIIlIl, "Bypass V2") && (!Airshoot.mc.gameSettings.keyBindAttack.isKeyDown() || Airshoot.mc.player.field_70733_aJ > 0.0f)) {
            if (Airshoot.mc.player.func_184811_cZ().getCooldown(Items.DIAMOND_PICKAXE, mc.getRenderPartialTicks()) != 1.0f) {
                Airshoot.mc.player.field_71071_by.currentItem = (int)lIIlIIIllIIlII - 1;
            }
            if (Airshoot.mc.player.field_70122_E && !Airshoot.mc.gameSettings.keyBindAttack.isKeyDown()) {
                Airshoot.mc.player.field_71071_by.currentItem = (int)lIIlIIIllIIIll - 1;
            }
        }
    }
}

