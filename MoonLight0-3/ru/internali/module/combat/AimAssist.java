/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.passive.EntityAnimal
 *  net.minecraft.entity.passive.EntityVillager
 *  net.minecraft.entity.passive.EntityWaterMob
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.MathHelper
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package ru.internali.module.combat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;
import ru.internali.utils.EntityHelper;
import ru.internali.utils.GCDCalcHelper;
import ru.internali.utils.MathematicHelper;
import ru.internali.utils.RotationHelper;

public class AimAssist
extends Module {
    public static /* synthetic */ List<String> Priority;
    public static /* synthetic */ List<String> Pos;

    public static EntityLivingBase getSortEntities() {
        float lIIIllIIIIIllII = (float)CatClient.instance.settingsManager.getSettingByName("Range").getValDouble();
        String lIIIllIIIIIlIll = CatClient.instance.settingsManager.getSettingByName("Priority").getValString();
        ArrayList<EntityLivingBase> lIIIllIIIIIlIlI = new ArrayList<EntityLivingBase>();
        for (Entity lIIIllIIIIIllIl : AimAssist.mc.world.field_72996_f) {
            EntityLivingBase entityLivingBase;
            if (!(lIIIllIIIIIllIl instanceof EntityLivingBase)) continue;
            EntityLivingBase lIIIllIIIIIlllI = (EntityLivingBase)lIIIllIIIIIllIl;
            if (!(AimAssist.mc.player.func_70032_d((Entity)entityLivingBase) < lIIIllIIIIIllII) || !AimAssist.canAssist(lIIIllIIIIIlllI)) continue;
            if (lIIIllIIIIIlllI.getHealth() > 0.0f) {
                lIIIllIIIIIlIlI.add(lIIIllIIIIIlllI);
                continue;
            }
            lIIIllIIIIIlIlI.remove((Object)lIIIllIIIIIlllI);
        }
        if (lIIIllIIIIIlIll.equalsIgnoreCase("Angle")) {
            lIIIllIIIIIlIlI.sort((lIIIlIllIIlIIIl, lIIIlIllIIIlllI) -> (int)(Math.abs(RotationHelper.getAngleEntity((Entity)lIIIlIllIIlIIIl) - AimAssist.mc.player.field_70177_z) - Math.abs(RotationHelper.getAngleEntity((Entity)lIIIlIllIIIlllI) - AimAssist.mc.player.field_70177_z)));
        } else if (lIIIllIIIIIlIll.equalsIgnoreCase("HArmor")) {
            lIIIllIIIIIlIlI.sort(Comparator.comparing(EntityLivingBase::getTotalArmorValue).reversed());
        } else if (lIIIllIIIIIlIll.equalsIgnoreCase("LArmor")) {
            lIIIllIIIIIlIlI.sort(Comparator.comparing(EntityLivingBase::getTotalArmorValue));
        } else if (lIIIllIIIIIlIll.equalsIgnoreCase("Health")) {
            lIIIllIIIIIlIlI.sort((lIIIlIllIIlIlll, lIIIlIllIIlIllI) -> (int)(lIIIlIllIIlIlll.getHealth() - lIIIlIllIIlIllI.getHealth()));
        } else if (lIIIllIIIIIlIll.equalsIgnoreCase("Distance")) {
            lIIIllIIIIIlIlI.sort(Comparator.comparingDouble(((EntityPlayerSP)AimAssist.mc.player)::getDistance));
        }
        if (lIIIllIIIIIlIlI.isEmpty()) {
            return null;
        }
        return (EntityLivingBase)lIIIllIIIIIlIlI.get(0);
    }

    private float[] getRotation(Entity lIIIlIllIlIIlIl, float lIIIlIllIlIIlII) {
        AimAssist lIIIlIllIlIIllI;
        float lIIIlIllIllIIII = (float)CatClient.instance.settingsManager.getSettingByName("rotYawRandom").getValDouble();
        float lIIIlIllIlIllll = (float)CatClient.instance.settingsManager.getSettingByName("rotPitchRandom").getValDouble();
        String lIIIlIllIlIlllI = CatClient.instance.settingsManager.getSettingByName(lIIIlIllIlIIllI, "Pos").getValString();
        float lIIIlIllIlIllIl = 0.0f;
        if (lIIIlIllIlIlllI.equalsIgnoreCase("Head")) {
            lIIIlIllIlIllIl = 0.0f;
        } else if (lIIIlIllIlIlllI.equalsIgnoreCase("Chest")) {
            lIIIlIllIlIllIl = 0.5f;
        } else if (lIIIlIllIlIlllI.equalsIgnoreCase("Leggings")) {
            lIIIlIllIlIllIl = 0.9f;
        } else if (lIIIlIllIlIlllI.equalsIgnoreCase("Boots")) {
            lIIIlIllIlIllIl = 1.3f;
        }
        double lIIIlIllIlIllII = lIIIlIllIlIIlIl.posX + (lIIIlIllIlIIlIl.posX - lIIIlIllIlIIlIl.prevPosX) * (double)lIIIlIllIlIIlII - AimAssist.mc.player.field_70165_t - AimAssist.mc.player.field_70159_w * (double)lIIIlIllIlIIlII;
        double lIIIlIllIlIlIll = lIIIlIllIlIIlIl.posZ + (lIIIlIllIlIIlIl.posZ - lIIIlIllIlIIlIl.prevPosZ) * (double)lIIIlIllIlIIlII - AimAssist.mc.player.field_70161_v - AimAssist.mc.player.field_70179_y * (double)lIIIlIllIlIIlII;
        double lIIIlIllIlIlIlI = lIIIlIllIlIIlIl.posY + (double)lIIIlIllIlIIlIl.getEyeHeight() - (AimAssist.mc.player.field_70163_u + (double)AimAssist.mc.player.func_70047_e() + (double)lIIIlIllIlIllIl);
        double lIIIlIllIlIlIIl = MathHelper.sqrt((double)(lIIIlIllIlIllII * lIIIlIllIlIllII + lIIIlIllIlIlIll * lIIIlIllIlIlIll));
        float lIIIlIllIlIlIII = (float)(MathHelper.atan2((double)lIIIlIllIlIlIll, (double)lIIIlIllIlIllII) * 180.0 / Math.PI - 90.0) + MathematicHelper.randomizeFloat(-lIIIlIllIllIIII, lIIIlIllIllIIII);
        float lIIIlIllIlIIlll = (float)(-(MathHelper.atan2((double)lIIIlIllIlIlIlI, (double)lIIIlIllIlIlIIl) * 180.0 / Math.PI)) + MathematicHelper.randomizeFloat(-lIIIlIllIlIllll, lIIIlIllIlIllll);
        lIIIlIllIlIlIII = AimAssist.mc.player.field_70177_z + GCDCalcHelper.getFixedRotation(MathHelper.wrapDegrees((float)(lIIIlIllIlIlIII - AimAssist.mc.player.field_70177_z)));
        lIIIlIllIlIIlll = AimAssist.mc.player.field_70125_A + GCDCalcHelper.getFixedRotation(MathHelper.wrapDegrees((float)(lIIIlIllIlIIlll - AimAssist.mc.player.field_70125_A)));
        lIIIlIllIlIIlll = MathHelper.clamp((float)lIIIlIllIlIIlll, (float)-90.0f, (float)90.0f);
        return new float[]{lIIIlIllIlIlIII, lIIIlIllIlIIlll};
    }

    static {
        Pos = new ArrayList<String>();
        Priority = new ArrayList<String>();
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent lIIIlIllllIIlII) {
        AimAssist lIIIlIllllIIlIl;
        boolean lIIIlIllllIIIll = CatClient.instance.settingsManager.getSettingByName(lIIIlIllllIIlIl, "click").getValBoolean();
        float lIIIlIllllIIIlI = (float)CatClient.instance.settingsManager.getSettingByName("Range").getValDouble();
        EntityLivingBase lIIIlIllllIIIIl = AimAssist.getSortEntities();
        if (lIIIlIllllIIIIl != null && AimAssist.mc.player.func_70032_d((Entity)lIIIlIllllIIIIl) <= lIIIlIllllIIIlI && lIIIlIllllIIIIl != AimAssist.mc.player) {
            float[] lIIIlIllllIIllI = lIIIlIllllIIlIl.getRotationsForAssist(lIIIlIllllIIIIl);
            if (lIIIlIllllIIIll && !AimAssist.mc.gameSettings.keyBindAttack.isKeyDown()) {
                return;
            }
            if (AimAssist.canAssist(lIIIlIllllIIIIl) && lIIIlIllllIIIIl.getHealth() > 0.0f) {
                AimAssist.mc.player.field_70177_z = lIIIlIllllIIllI[0];
                AimAssist.mc.player.field_70125_A = lIIIlIllllIIllI[1];
            }
        }
    }

    public AimAssist() {
        super("AimAssist", "aim to players", Category.COMBAT);
        AimAssist lIIIllIIIllIIII;
        CatClient.instance.settingsManager.rSetting(new Setting("Range", lIIIllIIIllIIII, 300.0, 0.0, 300.0, true));
        CatClient.instance.settingsManager.rSetting(new Setting("predict", lIIIllIIIllIIII, 3.5, 0.0, 15.0, false));
        CatClient.instance.settingsManager.rSetting(new Setting("mobs", lIIIllIIIllIIII, false));
        CatClient.instance.settingsManager.rSetting(new Setting("players", lIIIllIIIllIIII, true));
        CatClient.instance.settingsManager.rSetting(new Setting("Nocked", lIIIllIIIllIIII, false));
        CatClient.instance.settingsManager.rSetting(new Setting("invis", lIIIllIIIllIIII, false));
        CatClient.instance.settingsManager.rSetting(new Setting("team", lIIIllIIIllIIII, false));
        CatClient.instance.settingsManager.rSetting(new Setting("Walls", lIIIllIIIllIIII, false));
        CatClient.instance.settingsManager.rSetting(new Setting("Fov", lIIIllIIIllIIII, 40.0, 1.0, 360.0, true));
        CatClient.instance.settingsManager.rSetting(new Setting("click", lIIIllIIIllIIII, false));
        CatClient.instance.settingsManager.rSetting(new Setting("rotYawRandom", lIIIllIIIllIIII, 1.0, 0.0, 3.0, false));
        CatClient.instance.settingsManager.rSetting(new Setting("rotPitchRandom", lIIIllIIIllIIII, 1.0, 0.0, 3.0, false));
        CatClient.instance.settingsManager.rSetting(new Setting("rotYawSpeed", lIIIllIIIllIIII, 1.0, 0.1, 5.0, false));
        CatClient.instance.settingsManager.rSetting(new Setting("rotPitchSpeed", lIIIllIIIllIIII, 1.0, 0.1, 5.0, false));
        Priority.add("Angle");
        Priority.add("HArmor");
        Priority.add("LArmor");
        Priority.add("Health");
        Priority.add("Distance");
        CatClient.instance.settingsManager.rSetting(new Setting("Priority", lIIIllIIIllIIII, "Angle", (ArrayList)Priority));
        Pos.add("Head");
        Pos.add("Chest");
        Pos.add("Leggings");
        Pos.add("Boots");
        CatClient.instance.settingsManager.rSetting(new Setting("Pos", lIIIllIIIllIIII, "Head", (ArrayList)Pos));
    }

    public static double angleDifference(double lIIIllIIIIllIlI, double lIIIllIIIIlIllI) {
        float lIIIllIIIIllIII = (float)(Math.abs(lIIIllIIIIllIlI - lIIIllIIIIlIllI) % 360.0);
        if (lIIIllIIIIllIII > 180.0f) {
            lIIIllIIIIllIII = 360.0f - lIIIllIIIIllIII;
        }
        return lIIIllIIIIllIII;
    }

    public static boolean canAssist(EntityLivingBase lIIIlIlllllIIll) {
        boolean lIIIlIllllllIlI = CatClient.instance.settingsManager.getSettingByName("mobs").getValBoolean();
        boolean lIIIlIllllllIIl = CatClient.instance.settingsManager.getSettingByName("players").getValBoolean();
        boolean lIIIlIllllllIII = CatClient.instance.settingsManager.getSettingByName("Nocked").getValBoolean();
        boolean lIIIlIlllllIlll = CatClient.instance.settingsManager.getSettingByName("invis").getValBoolean();
        boolean lIIIlIlllllIllI = CatClient.instance.settingsManager.getSettingByName("team").getValBoolean();
        boolean lIIIlIlllllIlIl = CatClient.instance.settingsManager.getSettingByName("walls").getValBoolean();
        float lIIIlIlllllIlII = (float)CatClient.instance.settingsManager.getSettingByName("Fov").getValDouble();
        if (lIIIlIlllllIIll instanceof EntityPlayer || lIIIlIlllllIIll instanceof EntityAnimal || lIIIlIlllllIIll instanceof EntityMob || lIIIlIlllllIIll instanceof EntityWaterMob || lIIIlIlllllIIll instanceof EntityVillager) {
            if (lIIIlIlllllIIll instanceof EntityPlayer && !lIIIlIllllllIIl) {
                return false;
            }
            if (lIIIlIlllllIIll instanceof EntityAnimal && !lIIIlIllllllIlI) {
                return false;
            }
            if (lIIIlIlllllIIll instanceof EntityWaterMob && !lIIIlIllllllIlI) {
                return false;
            }
            if (lIIIlIlllllIIll instanceof EntityMob && !lIIIlIllllllIlI) {
                return false;
            }
            if (lIIIlIlllllIIll instanceof EntityVillager && !lIIIlIllllllIlI) {
                return false;
            }
        }
        if (lIIIlIllllllIII && lIIIlIlllllIIll instanceof EntityPlayer && EntityHelper.checkArmor((Entity)lIIIlIlllllIIll)) {
            return false;
        }
        if (lIIIlIlllllIIll.func_82150_aj() && !lIIIlIlllllIlll) {
            return false;
        }
        if (lIIIlIllllllIII && EntityHelper.checkArmor((Entity)lIIIlIlllllIIll)) {
            return false;
        }
        if (!AimAssist.canSeeEntityAtFov((Entity)lIIIlIlllllIIll, lIIIlIlllllIlII * 2.0f)) {
            return false;
        }
        if (lIIIlIlllllIllI && EntityHelper.isTeamWithYou(lIIIlIlllllIIll)) {
            return false;
        }
        if (!lIIIlIlllllIIll.canEntityBeSeen((Entity)AimAssist.mc.player)) {
            return lIIIlIlllllIlIl;
        }
        return lIIIlIlllllIIll != AimAssist.mc.player;
    }

    public static boolean canSeeEntityAtFov(Entity lIIIllIIIlIlIIl, float lIIIllIIIlIlIII) {
        double lIIIllIIIlIIlll = lIIIllIIIlIlIIl.posZ - AimAssist.mc.player.field_70161_v;
        double lIIIllIIIlIIllI = lIIIllIIIlIlIIl.posX - AimAssist.mc.player.field_70165_t;
        float lIIIllIIIlIIlIl = (float)(Math.toDegrees(Math.atan2(lIIIllIIIlIIlll, lIIIllIIIlIIllI)) - 90.0);
        double lIIIllIIIlIIlII = AimAssist.angleDifference(lIIIllIIIlIIlIl, AimAssist.mc.player.field_70177_z);
        return lIIIllIIIlIIlII <= (double)lIIIllIIIlIlIII;
    }

    private float[] getRotationsForAssist(EntityLivingBase lIIIlIlllIlIIIl) {
        AimAssist lIIIlIlllIIlIIl;
        float lIIIlIlllIlIIII = (float)CatClient.instance.settingsManager.getSettingByName("rotYawRandom").getValDouble();
        float lIIIlIlllIIllll = (float)CatClient.instance.settingsManager.getSettingByName("rotPitchRandom").getValDouble();
        float lIIIlIlllIIlllI = (float)CatClient.instance.settingsManager.getSettingByName("predict").getValDouble();
        float lIIIlIlllIIllIl = (float)CatClient.instance.settingsManager.getSettingByName("rotYawSpeed").getValDouble();
        float lIIIlIlllIIllII = (float)CatClient.instance.settingsManager.getSettingByName("rotPitchSpeed").getValDouble();
        float lIIIlIlllIIlIll = RotationHelper.updateRotation(GCDCalcHelper.getFixedRotation(AimAssist.mc.player.field_70177_z + MathematicHelper.randomizeFloat(-lIIIlIlllIlIIII, lIIIlIlllIlIIII)), lIIIlIlllIIlIIl.getRotation((Entity)lIIIlIlllIlIIIl, lIIIlIlllIIlllI)[0], lIIIlIlllIIllIl * 10.0f);
        float lIIIlIlllIIlIlI = RotationHelper.updateRotation(GCDCalcHelper.getFixedRotation(AimAssist.mc.player.field_70125_A + MathematicHelper.randomizeFloat(-lIIIlIlllIIllll, lIIIlIlllIIllll)), lIIIlIlllIIlIIl.getRotation((Entity)lIIIlIlllIlIIIl, lIIIlIlllIIlllI)[1], lIIIlIlllIIllII * 10.0f);
        return new float[]{lIIIlIlllIIlIll, lIIIlIlllIIlIlI};
    }
}

