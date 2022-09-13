/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.network.play.server.SPacketChat
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.text.TextFormatting
 */
package ru.hld.legendline.impl.modules.Combat;

import java.util.ArrayList;
import java.util.Objects;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import ru.hld.legendline.Client;
import ru.hld.legendline.antiNative.RenderUtil;
import ru.hld.legendline.antiNative.RenderUtils;
import ru.hld.legendline.api.event.EventTarget;
import ru.hld.legendline.api.event.events.EventPacketReceive;
import ru.hld.legendline.api.event.events.EventRender2D;
import ru.hld.legendline.api.event.events.EventUpdate;
import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.api.setting.settings.BooleanSetting;
import ru.hld.legendline.api.setting.settings.FloatSetting;
import ru.hld.legendline.api.setting.settings.ModeSetting;
import ru.hld.legendline.api.utils.CombatUtils;
import ru.hld.legendline.api.utils.MathUtils;
import ru.hld.legendline.api.utils.TimerUtils;

public class AimBot
extends Module {
    public static /* synthetic */ FloatSetting Fov;
    public static /* synthetic */ boolean using;
    /* synthetic */ BooleanSetting mods;
    /* synthetic */ FloatSetting predict;
    /* synthetic */ TimerUtils autoPredictTimer;
    /* synthetic */ FloatSetting minCps;
    /* synthetic */ BooleanSetting selfPredict;
    /* synthetic */ float diff2;
    /* synthetic */ FloatSetting maxCps;
    /* synthetic */ float kal;
    /* synthetic */ BooleanSetting autoPredict;
    /* synthetic */ BooleanSetting AutoShoot;
    /* synthetic */ float diff;
    /* synthetic */ BooleanSetting walls;
    /* synthetic */ BooleanSetting slient;
    /* synthetic */ ModeSetting mode;
    /* synthetic */ TimerUtils timer;

    @EventTarget
    public void onUpdate(EventUpdate lllllllllllllIllIlllIIIIIIIlIIII) {
        AimBot lllllllllllllIllIlllIIIIIIIlIIIl;
        lllllllllllllIllIlllIIIIIIIlIIIl.setDisplayname(String.valueOf(new StringBuilder().append(lllllllllllllIllIlllIIIIIIIlIIIl.getName()).append(" ").append((Object)TextFormatting.WHITE).append(lllllllllllllIllIlllIIIIIIIlIIIl.predict.getVal())));
        if (lllllllllllllIllIlllIIIIIIIlIIIl.autoPredict.getVal()) {
            int lllllllllllllIllIlllIIIIIIIlIlII = (int)MathUtils.clamp(Objects.requireNonNull(lllllllllllllIllIlllIIIIIIIlIIIl.mc.getConnection()).getPlayerInfo(lllllllllllllIllIlllIIIIIIIlIIIl.mc.player.getUniqueID()).getResponseTime(), 1.0f, 300.0f);
            lllllllllllllIllIlllIIIIIIIlIIIl.predict.setVal(MathUtils.clamp((float)lllllllllllllIllIlllIIIIIIIlIlII * 6.5f / 100.0f, 0.0f, 10.0f));
        }
        Entity lllllllllllllIllIlllIIIIIIIIllll = CombatUtils.getTerget(lllllllllllllIllIlllIIIIIIIlIIIl.walls.getVal());
        if (!lllllllllllllIllIlllIIIIIIIlIIIl.mods.getVal()) {
            lllllllllllllIllIlllIIIIIIIIllll = CombatUtils.getTerget(lllllllllllllIllIlllIIIIIIIlIIIl.walls.getVal());
        } else {
            switch (lllllllllllllIllIlllIIIIIIIlIIIl.mode.getVal()) {
                case "Rect": {
                    lllllllllllllIllIlllIIIIIIIIllll = CombatUtils.getTergetBox(lllllllllllllIllIlllIIIIIIIlIIIl.walls.getVal(), Fov.getVal() * 100.0f / 5.0f);
                    break;
                }
                case "Circle": {
                    lllllllllllllIllIlllIIIIIIIIllll = CombatUtils.getTergetCircle(lllllllllllllIllIlllIIIIIIIlIIIl.walls.getVal(), Fov.getVal() * 100.0f / 5.0f);
                    break;
                }
                case "Robot": {
                    lllllllllllllIllIlllIIIIIIIIllll = CombatUtils.getTergetCircle(lllllllllllllIllIlllIIIIIIIlIIIl.walls.getVal(), Fov.getVal() * 100.0f / 5.0f);
                }
            }
        }
        if (lllllllllllllIllIlllIIIIIIIIllll == null) {
            using = false;
            return;
        }
        using = true;
        double lllllllllllllIllIlllIIIIIIIIlllI = lllllllllllllIllIlllIIIIIIIIllll.posX - lllllllllllllIllIlllIIIIIIIIllll.lastTickPosX;
        double lllllllllllllIllIlllIIIIIIIIllIl = lllllllllllllIllIlllIIIIIIIIllll.posY - lllllllllllllIllIlllIIIIIIIIllll.lastTickPosY;
        double lllllllllllllIllIlllIIIIIIIIllII = lllllllllllllIllIlllIIIIIIIIllll.posZ - lllllllllllllIllIlllIIIIIIIIllll.lastTickPosZ;
        double lllllllllllllIllIlllIIIIIIIIlIll = lllllllllllllIllIlllIIIIIIIIllll.lastTickPosX + lllllllllllllIllIlllIIIIIIIIlllI * (double)lllllllllllllIllIlllIIIIIIIlIIIl.predict.getVal();
        double lllllllllllllIllIlllIIIIIIIIlIlI = lllllllllllllIllIlllIIIIIIIIllll.lastTickPosZ + lllllllllllllIllIlllIIIIIIIIllII * (double)lllllllllllllIllIlllIIIIIIIlIIIl.predict.getVal();
        double lllllllllllllIllIlllIIIIIIIIlIIl = lllllllllllllIllIlllIIIIIIIIllll.posY;
        lllllllllllllIllIlllIIIIIIIIlIIl += (double)(lllllllllllllIllIlllIIIIIIIIllll.getEyeHeight() + 0.1f);
        double lllllllllllllIllIlllIIIIIIIIlIII = lllllllllllllIllIlllIIIIIIIlIIIl.mc.player.posX - lllllllllllllIllIlllIIIIIIIlIIIl.mc.player.lastTickPosX;
        double lllllllllllllIllIlllIIIIIIIIIlll = lllllllllllllIllIlllIIIIIIIlIIIl.mc.player.posZ - lllllllllllllIllIlllIIIIIIIlIIIl.mc.player.lastTickPosZ;
        double lllllllllllllIllIlllIIIIIIIIIllI = lllllllllllllIllIlllIIIIIIIlIIIl.mc.player.posX;
        double lllllllllllllIllIlllIIIIIIIIIlIl = lllllllllllllIllIlllIIIIIIIlIIIl.mc.player.posZ;
        if (lllllllllllllIllIlllIIIIIIIlIIIl.selfPredict.getVal()) {
            lllllllllllllIllIlllIIIIIIIIIllI = lllllllllllllIllIlllIIIIIIIlIIIl.mc.player.lastTickPosX + lllllllllllllIllIlllIIIIIIIIlllI * (double)(lllllllllllllIllIlllIIIIIIIlIIIl.predict.getVal() / 4.0f);
            lllllllllllllIllIlllIIIIIIIIIlIl = lllllllllllllIllIlllIIIIIIIlIIIl.mc.player.lastTickPosZ + lllllllllllllIllIlllIIIIIIIIllII * (double)(lllllllllllllIllIlllIIIIIIIlIIIl.predict.getVal() / 4.0f);
        }
        float[] lllllllllllllIllIlllIIIIIIIIIlII = CombatUtils.getNeededRotations((float)lllllllllllllIllIlllIIIIIIIIlIll, (float)lllllllllllllIllIlllIIIIIIIIlIIl, (float)lllllllllllllIllIlllIIIIIIIIlIlI, (float)lllllllllllllIllIlllIIIIIIIIIllI, (float)lllllllllllllIllIlllIIIIIIIlIIIl.mc.player.posY, (float)lllllllllllllIllIlllIIIIIIIIIlIl);
        float lllllllllllllIllIlllIIIIIIIIIIll = lllllllllllllIllIlllIIIIIIIlIIIl.kal = Fov.getVal() * 100.0f;
        if (lllllllllllllIllIlllIIIIIIIlIIIl.slient.getVal()) {
            float lllllllllllllIllIlllIIIIIIIlIIll = lllllllllllllIllIlllIIIIIIIlIIIl.mc.player.lastReportedYaw;
            float lllllllllllllIllIlllIIIIIIIlIIlI = lllllllllllllIllIlllIIIIIIIlIIIl.mc.player.lastReportedPitch;
            lllllllllllllIllIlllIIIIIIIlIIll = MathUtils.lerp(lllllllllllllIllIlllIIIIIIIlIIll, lllllllllllllIllIlllIIIIIIIIIlII[0], 1.0f);
            lllllllllllllIllIlllIIIIIIIlIIlI = MathUtils.lerp(lllllllllllllIllIlllIIIIIIIlIIlI, lllllllllllllIllIlllIIIIIIIIIlII[1], 1.0f);
            lllllllllllllIllIlllIIIIIIIlIIII.setRotationYaw(lllllllllllllIllIlllIIIIIIIlIIll);
            lllllllllllllIllIlllIIIIIIIlIIII.setRotationPitch(lllllllllllllIllIlllIIIIIIIlIIlI);
            lllllllllllllIllIlllIIIIIIIlIIIl.mc.player.renderYawOffset = lllllllllllllIllIlllIIIIIIIlIIll;
            lllllllllllllIllIlllIIIIIIIlIIIl.mc.player.rotationYawHead = lllllllllllllIllIlllIIIIIIIlIIll;
            lllllllllllllIllIlllIIIIIIIlIIIl.mc.player.rotationPitchHead = lllllllllllllIllIlllIIIIIIIlIIlI;
            lllllllllllllIllIlllIIIIIIIlIIIl.diff = Math.abs(lllllllllllllIllIlllIIIIIIIlIIll - lllllllllllllIllIlllIIIIIIIIIlII[0]);
            lllllllllllllIllIlllIIIIIIIlIIIl.diff2 = Math.abs(lllllllllllllIllIlllIIIIIIIlIIlI - lllllllllllllIllIlllIIIIIIIIIlII[1]);
        } else {
            lllllllllllllIllIlllIIIIIIIlIIIl.mc.player.rotationYaw = MathUtils.lerp(lllllllllllllIllIlllIIIIIIIlIIIl.mc.player.rotationYaw, lllllllllllllIllIlllIIIIIIIIIlII[0], 1.0f);
            lllllllllllllIllIlllIIIIIIIlIIIl.mc.player.rotationPitch = MathUtils.lerp(lllllllllllllIllIlllIIIIIIIlIIIl.mc.player.rotationPitch, lllllllllllllIllIlllIIIIIIIIIlII[1], 1.0f);
            lllllllllllllIllIlllIIIIIIIlIIIl.diff = Math.abs(lllllllllllllIllIlllIIIIIIIlIIIl.mc.player.rotationYaw - lllllllllllllIllIlllIIIIIIIIIlII[0]);
            lllllllllllllIllIlllIIIIIIIlIIIl.diff2 = Math.abs(lllllllllllllIllIlllIIIIIIIlIIIl.mc.player.rotationPitch - lllllllllllllIllIlllIIIIIIIIIlII[1]);
        }
        if (lllllllllllllIllIlllIIIIIIIlIIIl.AutoShoot.getVal() && lllllllllllllIllIlllIIIIIIIlIIIl.timer.hasReached((long)MathUtils.getRandomInRange(1000.0f / lllllllllllllIllIlllIIIIIIIlIIIl.maxCps.getVal(), 1000.0f / lllllllllllllIllIlllIIIIIIIlIIIl.minCps.getVal())) && lllllllllllllIllIlllIIIIIIIlIIIl.diff < 1.0f && lllllllllllllIllIlllIIIIIIIlIIIl.diff2 < 1.0f) {
            lllllllllllllIllIlllIIIIIIIlIIIl.mc.player.swingArm(EnumHand.MAIN_HAND);
            if (lllllllllllllIllIlllIIIIIIIlIIIl.mc.player.getDistanceToEntity(lllllllllllllIllIlllIIIIIIIIllll) <= 4.0f) {
                lllllllllllllIllIlllIIIIIIIlIIIl.mc.playerController.attackEntity((EntityPlayer)lllllllllllllIllIlllIIIIIIIlIIIl.mc.player, lllllllllllllIllIlllIIIIIIIIllll);
            }
            lllllllllllllIllIlllIIIIIIIlIIIl.timer.reset();
        }
    }

    public AimBot() {
        super("AimBot", "auto aim on players", Category.Combat);
        AimBot lllllllllllllIllIlllIIIIIIlllIIl;
        lllllllllllllIllIlllIIIIIIlllIIl.diff = 0.0f;
        lllllllllllllIllIlllIIIIIIlllIIl.diff2 = 0.0f;
        ArrayList<String> lllllllllllllIllIlllIIIIIIlllIlI = new ArrayList<String>();
        lllllllllllllIllIlllIIIIIIlllIlI.add("Rect");
        lllllllllllllIllIlllIIIIIIlllIlI.add("Circle");
        lllllllllllllIllIlllIIIIIIlllIlI.add("Robot");
        lllllllllllllIllIlllIIIIIIlllIIl.slient = new BooleanSetting("Silent", "aim with out client rotation", (Module)lllllllllllllIllIlllIIIIIIlllIIl, true);
        Client.settingManager.add(lllllllllllllIllIlllIIIIIIlllIIl.slient);
        lllllllllllllIllIlllIIIIIIlllIIl.predict = new FloatSetting("Predict", "increment of the enemy's new position", lllllllllllllIllIlllIIIIIIlllIIl, 0.0f, 10.0f, 5.1f, 0.1f);
        Client.settingManager.add(lllllllllllllIllIlllIIIIIIlllIIl.predict);
        lllllllllllllIllIlllIIIIIIlllIIl.mods = new BooleanSetting("Fov", "Fov", (Module)lllllllllllllIllIlllIIIIIIlllIIl, true);
        Client.settingManager.add(lllllllllllllIllIlllIIIIIIlllIIl.mods);
        Fov = new FloatSetting("Fov Scale", "Fov", lllllllllllllIllIlllIIIIIIlllIIl, 0.0f, 5.0f, 1.5f, 0.1f, () -> {
            AimBot lllllllllllllIllIllIlllllllIIlIl;
            return lllllllllllllIllIllIlllllllIIlIl.mods.getVal();
        });
        Client.settingManager.add(Fov);
        lllllllllllllIllIlllIIIIIIlllIIl.mode = new ModeSetting("Fov Mode", "Fov", lllllllllllllIllIlllIIIIIIlllIIl, lllllllllllllIllIlllIIIIIIlllIlI, "Rect", () -> {
            AimBot lllllllllllllIllIllIlllllllIlIIl;
            return lllllllllllllIllIllIlllllllIlIIl.mods.getVal();
        });
        Client.settingManager.add(lllllllllllllIllIlllIIIIIIlllIIl.mode);
        lllllllllllllIllIlllIIIIIIlllIIl.autoPredict = new BooleanSetting("AutoPredict", "auto set predict by ping", (Module)lllllllllllllIllIlllIIIIIIlllIIl, false);
        Client.settingManager.add(lllllllllllllIllIlllIIIIIIlllIIl.autoPredict);
        lllllllllllllIllIlllIIIIIIlllIIl.selfPredict = new BooleanSetting("SelfPredict", "youse metod predict for you", (Module)lllllllllllllIllIlllIIIIIIlllIIl, false);
        Client.settingManager.add(lllllllllllllIllIlllIIIIIIlllIIl.selfPredict);
        lllllllllllllIllIlllIIIIIIlllIIl.walls = new BooleanSetting("Walls", "aiming through walls", (Module)lllllllllllllIllIlllIIIIIIlllIIl, false);
        Client.settingManager.add(lllllllllllllIllIlllIIIIIIlllIIl.walls);
        lllllllllllllIllIlllIIIIIIlllIIl.AutoShoot = new BooleanSetting("AutoShoot", "auto shooting if you aimin on target", (Module)lllllllllllllIllIlllIIIIIIlllIIl, true);
        Client.settingManager.add(lllllllllllllIllIlllIIIIIIlllIIl.AutoShoot);
        lllllllllllllIllIlllIIIIIIlllIIl.minCps = new FloatSetting("MinCps", "min Cps to AutoShoot", lllllllllllllIllIlllIIIIIIlllIIl, 0.0f, 20.0f, 16.0f, 1.0f, () -> {
            AimBot lllllllllllllIllIllIlllllllIlIll;
            return lllllllllllllIllIllIlllllllIlIll.AutoShoot.getVal();
        });
        Client.settingManager.add(lllllllllllllIllIlllIIIIIIlllIIl.minCps);
        lllllllllllllIllIlllIIIIIIlllIIl.maxCps = new FloatSetting("MaxCps", "max Cps to AutoShoot", lllllllllllllIllIlllIIIIIIlllIIl, 0.0f, 20.0f, 16.0f, 1.0f, () -> {
            AimBot lllllllllllllIllIllIlllllllIlllI;
            return lllllllllllllIllIllIlllllllIlllI.AutoShoot.getVal();
        });
        Client.settingManager.add(lllllllllllllIllIlllIIIIIIlllIIl.maxCps);
        lllllllllllllIllIlllIIIIIIlllIIl.timer = new TimerUtils();
        lllllllllllllIllIlllIIIIIIlllIIl.autoPredictTimer = new TimerUtils();
    }

    @EventTarget
    public void onUpPacketRecent(EventPacketReceive lllllllllllllIllIlllIIIIIIllIlII) {
        if (lllllllllllllIllIlllIIIIIIllIlII.getPacket() instanceof SPacketChat) {
            SPacketChat lllllllllllllIllIlllIIIIIIllIIlI = (SPacketChat)lllllllllllllIllIlllIIIIIIllIlII.getPacket();
        }
    }

    static {
        using = false;
    }

    @EventTarget
    public void onRender2D(EventRender2D lllllllllllllIllIlllIIIIIIlIllII) {
        AimBot lllllllllllllIllIlllIIIIIIlIlIlI;
        lllllllllllllIllIlllIIIIIIlIlIlI.kal = Fov.getVal() * 90.0f;
        ScaledResolution lllllllllllllIllIlllIIIIIIlIlIll = new ScaledResolution(lllllllllllllIllIlllIIIIIIlIlIlI.mc);
        if (lllllllllllllIllIlllIIIIIIlIlIlI.mods.getVal()) {
            switch (lllllllllllllIllIlllIIIIIIlIlIlI.mode.getVal()) {
                case "Circle": {
                    RenderUtil.drawCircle228(lllllllllllllIllIlllIIIIIIlIlIll.getScaledWidth() / 2, lllllllllllllIllIlllIIIIIIlIlIll.getScaledHeight() / 2, lllllllllllllIllIlllIIIIIIlIlIlI.kal, Client.getColor(), 360);
                    break;
                }
                case "Rect": {
                    RenderUtils.draw2lines(lllllllllllllIllIlllIIIIIIlIlIll.getScaledWidth() / 2, lllllllllllllIllIlllIIIIIIlIlIll.getScaledHeight() / 2, Client.getColor(), lllllllllllllIllIlllIIIIIIlIlIlI.kal);
                    break;
                }
                case "Robot": {
                    RenderUtils.drawRobotgui(lllllllllllllIllIlllIIIIIIlIlIll.getScaledWidth() / 2, lllllllllllllIllIlllIIIIIIlIlIll.getScaledHeight() / 2, Client.getColor(), Client.getColor2(), lllllllllllllIllIlllIIIIIIlIlIlI.kal);
                }
            }
        }
    }
}

