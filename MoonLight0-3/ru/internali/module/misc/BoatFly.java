/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityBoat
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.MathHelper
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package ru.internali.module.misc;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.module.misc.MovementUtil;
import ru.internali.settings.Setting;

public class BoatFly
extends Module {
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent lIIIlIIlIIIlllI) {
        BoatFly lIIIlIIlIIIllll;
        boolean lIIIlIIlIIIllIl = CatClient.instance.settingsManager.getSettingByName(lIIIlIIlIIIllll, "extraCalc").getValBoolean();
        boolean lIIIlIIlIIIllII = CatClient.instance.settingsManager.getSettingByName(lIIIlIIlIIIllll, "staticY").getValBoolean();
        boolean lIIIlIIlIIIlIll = CatClient.instance.settingsManager.getSettingByName(lIIIlIIlIIIllll, "hover").getValBoolean();
        boolean lIIIlIIlIIIlIlI = CatClient.instance.settingsManager.getSettingByName(lIIIlIIlIIIllll, "bypass").getValBoolean();
        float lIIIlIIlIIIlIIl = (float)CatClient.instance.settingsManager.getSettingByName(lIIIlIIlIIIllll, "speed").getValDouble();
        float lIIIlIIlIIIlIII = (float)CatClient.instance.settingsManager.getSettingByName(lIIIlIIlIIIllll, "verticalSpeed").getValDouble();
        float lIIIlIIlIIIIlll = (float)CatClient.instance.settingsManager.getSettingByName(lIIIlIIlIIIllll, "glideSpeed").getValDouble();
        if (BoatFly.mc.player == null || BoatFly.mc.world == null || BoatFly.mc.player.func_184187_bx() == null) {
            return;
        }
        Entity lIIIlIIlIIIIllI = BoatFly.mc.player.func_184187_bx();
        if (BoatFly.mc.gameSettings.keyBindJump.isKeyDown()) {
            lIIIlIIlIIIIllI.motionY = lIIIlIIlIIIlIII;
        } else if (lIIIlIIlIIIllII) {
            lIIIlIIlIIIIllI.motionY = 0.0;
        } else {
            double d = lIIIlIIlIIIIllI.motionY = lIIIlIIlIIIlIll && BoatFly.mc.player.field_70173_aa % 2 == 0 ? (double)lIIIlIIlIIIIlll : (double)(-lIIIlIIlIIIIlll);
        }
        if (MovementUtil.isMoving()) {
            if (!lIIIlIIlIIIllIl) {
                double[] lIIIlIIlIIlIIIl = MovementUtil.forward(lIIIlIIlIIIlIIl);
                lIIIlIIlIIIIllI.motionX = lIIIlIIlIIlIIIl[0];
                lIIIlIIlIIIIllI.motionZ = lIIIlIIlIIlIIIl[1];
            } else {
                float lIIIlIIlIIlIIII = MovementUtil.getDirection2();
                BoatFly.mc.player.field_70159_w -= (double)(MathHelper.sin((float)lIIIlIIlIIlIIII) * lIIIlIIlIIIlIIl);
                BoatFly.mc.player.field_70179_y += (double)(MathHelper.cos((float)lIIIlIIlIIlIIII) * lIIIlIIlIIIlIIl);
            }
        } else {
            lIIIlIIlIIIIllI.motionX = 0.0;
            lIIIlIIlIIIIllI.motionZ = 0.0;
        }
        if (lIIIlIIlIIIlIlI && BoatFly.mc.player.field_70173_aa % 4 == 0 && BoatFly.mc.player.func_184187_bx() instanceof EntityBoat) {
            BoatFly.mc.playerController.interactWithEntity((EntityPlayer)BoatFly.mc.player, BoatFly.mc.player.func_184187_bx(), EnumHand.MAIN_HAND);
        }
    }

    public BoatFly() {
        super("BoatFly", "BoatFly", Category.OUTHER);
        BoatFly lIIIlIIlIIlllII;
        CatClient.instance.settingsManager.rSetting(new Setting("speed", lIIIlIIlIIlllII, 2.0, 0.0, 10.0, false));
        CatClient.instance.settingsManager.rSetting(new Setting("verticalSpeed", lIIIlIIlIIlllII, 1.0, 0.0, 10.0, false));
        CatClient.instance.settingsManager.rSetting(new Setting("glideSpeed", lIIIlIIlIIlllII, 0.0, -10.0, 10.0, false));
        CatClient.instance.settingsManager.rSetting(new Setting("extraCalc", lIIIlIIlIIlllII, true));
        CatClient.instance.settingsManager.rSetting(new Setting("staticY", lIIIlIIlIIlllII, true));
        CatClient.instance.settingsManager.rSetting(new Setting("hover", lIIIlIIlIIlllII, true));
        CatClient.instance.settingsManager.rSetting(new Setting("bypass", lIIIlIIlIIlllII, true));
    }
}

