/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.MathHelper
 */
package ru.hld.legendline.api.utils;

import java.util.ArrayList;
import java.util.Comparator;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import ru.hld.legendline.api.shit.FriendManager;
import ru.hld.legendline.impl.modules.Combat.AimBot;

public class CombatUtils {
    public static /* synthetic */ Minecraft mc;

    public static float[] getNeededRotations(double llllllllllllllllllIlIIIIIIllIlll, double llllllllllllllllllIlIIIIIIllIllI, double llllllllllllllllllIlIIIIIIllIlIl, float llllllllllllllllllIlIIIIIIlIIllI, float llllllllllllllllllIlIIIIIIlIIlIl, float llllllllllllllllllIlIIIIIIlIIlII) {
        double llllllllllllllllllIlIIIIIIllIIIl = llllllllllllllllllIlIIIIIIllIlll - (double)llllllllllllllllllIlIIIIIIlIIllI;
        double llllllllllllllllllIlIIIIIIllIIII = llllllllllllllllllIlIIIIIIllIlIl - (double)llllllllllllllllllIlIIIIIIlIIlII;
        double llllllllllllllllllIlIIIIIIlIllll = llllllllllllllllllIlIIIIIIllIllI - (double)(llllllllllllllllllIlIIIIIIlIIlIl + CombatUtils.mc.player.getEyeHeight());
        double llllllllllllllllllIlIIIIIIlIlllI = MathHelper.sqrt((double)(llllllllllllllllllIlIIIIIIllIIIl * llllllllllllllllllIlIIIIIIllIIIl + llllllllllllllllllIlIIIIIIllIIII * llllllllllllllllllIlIIIIIIllIIII));
        float llllllllllllllllllIlIIIIIIlIllIl = (float)(Math.atan2(llllllllllllllllllIlIIIIIIllIIII, llllllllllllllllllIlIIIIIIllIIIl) * 180.0 / Math.PI - 90.0);
        float llllllllllllllllllIlIIIIIIlIllII = (float)(-(Math.atan2(llllllllllllllllllIlIIIIIIlIllll, llllllllllllllllllIlIIIIIIlIlllI) * 180.0 / Math.PI));
        llllllllllllllllllIlIIIIIIlIllII = MathHelper.clamp((float)llllllllllllllllllIlIIIIIIlIllII, (float)-90.0f, (float)90.0f);
        return new float[]{llllllllllllllllllIlIIIIIIlIllIl, llllllllllllllllllIlIIIIIIlIllII};
    }

    public static double pitchDifference(double llllllllllllllllllIIlllllllIIIII, double llllllllllllllllllIIllllllIlllll) {
        float llllllllllllllllllIIlllllllIIIIl = (float)(Math.abs(llllllllllllllllllIIlllllllIIIII - llllllllllllllllllIIllllllIlllll) % 90.0);
        if (llllllllllllllllllIIlllllllIIIIl > 45.0f) {
            llllllllllllllllllIIlllllllIIIIl = 45.0f - llllllllllllllllllIIlllllllIIIIl;
        }
        return llllllllllllllllllIIlllllllIIIIl;
    }

    public static Entity getTergetBox(boolean llllllllllllllllllIIllllllIIIIlI, float llllllllllllllllllIIllllllIIIIII) {
        ArrayList<Entity> llllllllllllllllllIIlllllIlllllI = new ArrayList<Entity>();
        for (Entity llllllllllllllllllIIllllllIIIlII : CombatUtils.mc.world.loadedEntityList) {
            if (!(llllllllllllllllllIIllllllIIIlII instanceof EntityPlayer) || llllllllllllllllllIIllllllIIIlII == CombatUtils.mc.player || FriendManager.isFriend(llllllllllllllllllIIllllllIIIlII.getName()) || llllllllllllllllllIIllllllIIIlII.isInvisible() || !(llllllllllllllllllIIllllllIIIlII.height > 1.0f) || (!CombatUtils.canSeeEntityAtFov(llllllllllllllllllIIllllllIIIlII, AimBot.Fov.getVal() * 100.0f / 5.0f) || !((EntityPlayer)llllllllllllllllllIIllllllIIIlII).canEntityBeSeen((Entity)CombatUtils.mc.player) || llllllllllllllllllIIllllllIIIIlI) && !llllllllllllllllllIIllllllIIIIlI) continue;
            llllllllllllllllllIIlllllIlllllI.add(llllllllllllllllllIIllllllIIIlII);
        }
        llllllllllllllllllIIlllllIlllllI.sort(new Comparator<Entity>(){
            {
                2 llllllllllllllllllIIlIllIllIllIl;
            }

            @Override
            public int compare(Entity llllllllllllllllllIIlIllIllIlIII, Entity llllllllllllllllllIIlIllIllIIlll) {
                return (int)(CombatUtils.mc.player.getDistanceToEntity(llllllllllllllllllIIlIllIllIlIII) - CombatUtils.mc.player.getDistanceToEntity(llllllllllllllllllIIlIllIllIIlll));
            }
        });
        if (llllllllllllllllllIIlllllIlllllI.size() > 0) {
            return (Entity)llllllllllllllllllIIlllllIlllllI.get(0);
        }
        return null;
    }

    public static boolean canSeeEntityAtFov2(Entity llllllllllllllllllIIllllllllIlll, float llllllllllllllllllIIlllllllllllI) {
        double llllllllllllllllllIIllllllllllIl = llllllllllllllllllIIllllllllIlll.posX - CombatUtils.mc.player.posX;
        double llllllllllllllllllIIllllllllllII = llllllllllllllllllIIllllllllIlll.posZ - CombatUtils.mc.player.posZ;
        double llllllllllllllllllIIlllllllllIll = llllllllllllllllllIIllllllllIlll.posY - CombatUtils.mc.player.posY;
        float llllllllllllllllllIIlllllllllIlI = (float)(Math.toDegrees(Math.atan2(llllllllllllllllllIIllllllllllII, llllllllllllllllllIIllllllllllIl)) - 90.0);
        float llllllllllllllllllIIlllllllllIIl = (float)(Math.toDegrees(llllllllllllllllllIIlllllllllIll) * 45.0);
        double llllllllllllllllllIIlllllllllIII = CombatUtils.pitchDifference(llllllllllllllllllIIlllllllllIIl, CombatUtils.mc.player.rotationPitch);
        return llllllllllllllllllIIlllllllllIII <= (double)llllllllllllllllllIIlllllllllllI;
    }

    public static double angleDifference(double llllllllllllllllllIIlllllllIlIIl, double llllllllllllllllllIIlllllllIlIll) {
        float llllllllllllllllllIIlllllllIlIlI = (float)(Math.abs(llllllllllllllllllIIlllllllIlIIl - llllllllllllllllllIIlllllllIlIll) % 360.0);
        if (llllllllllllllllllIIlllllllIlIlI > 180.0f) {
            llllllllllllllllllIIlllllllIlIlI = 360.0f - llllllllllllllllllIIlllllllIlIlI;
        }
        return llllllllllllllllllIIlllllllIlIlI;
    }

    public static boolean canSeeEntityAtFov(Entity llllllllllllllllllIlIIIIIIIIllll, float llllllllllllllllllIlIIIIIIIlIllI) {
        double llllllllllllllllllIlIIIIIIIlIlIl = llllllllllllllllllIlIIIIIIIIllll.posX - CombatUtils.mc.player.posX;
        double llllllllllllllllllIlIIIIIIIlIlII = llllllllllllllllllIlIIIIIIIIllll.posZ - CombatUtils.mc.player.posZ;
        double llllllllllllllllllIlIIIIIIIlIIll = llllllllllllllllllIlIIIIIIIIllll.posY - CombatUtils.mc.player.posY;
        float llllllllllllllllllIlIIIIIIIlIIlI = (float)(Math.toDegrees(Math.atan2(llllllllllllllllllIlIIIIIIIlIlII, llllllllllllllllllIlIIIIIIIlIlIl)) - 90.0);
        float llllllllllllllllllIlIIIIIIIlIIIl = (float)llllllllllllllllllIlIIIIIIIlIIll;
        double llllllllllllllllllIlIIIIIIIlIIII = CombatUtils.angleDifference(llllllllllllllllllIlIIIIIIIlIIlI, CombatUtils.mc.player.rotationYaw);
        return llllllllllllllllllIlIIIIIIIlIIII <= (double)llllllllllllllllllIlIIIIIIIlIllI;
    }

    public static Entity getTerget(boolean llllllllllllllllllIIlllllIIIlllI) {
        ArrayList<Entity> llllllllllllllllllIIlllllIIlIIll = new ArrayList<Entity>();
        for (Entity llllllllllllllllllIIlllllIIlIllI : CombatUtils.mc.world.loadedEntityList) {
            if (!(llllllllllllllllllIIlllllIIlIllI instanceof EntityPlayer) || llllllllllllllllllIIlllllIIlIllI == CombatUtils.mc.player || FriendManager.isFriend(llllllllllllllllllIIlllllIIlIllI.getName()) || llllllllllllllllllIIlllllIIlIllI.isInvisible() || !(llllllllllllllllllIIlllllIIlIllI.height > 1.0f) || (!((EntityPlayer)llllllllllllllllllIIlllllIIlIllI).canEntityBeSeen((Entity)CombatUtils.mc.player) || llllllllllllllllllIIlllllIIIlllI) && !llllllllllllllllllIIlllllIIIlllI) continue;
            llllllllllllllllllIIlllllIIlIIll.add(llllllllllllllllllIIlllllIIlIllI);
        }
        llllllllllllllllllIIlllllIIlIIll.sort(new Comparator<Entity>(){

            @Override
            public int compare(Entity llllllllllllllllllIlIllIlIllllll, Entity llllllllllllllllllIlIllIlIllllII) {
                return (int)(CombatUtils.mc.player.getDistanceToEntity(llllllllllllllllllIlIllIlIllllll) - CombatUtils.mc.player.getDistanceToEntity(llllllllllllllllllIlIllIlIllllII));
            }
            {
                3 llllllllllllllllllIlIllIllIIIlII;
            }
        });
        if (llllllllllllllllllIIlllllIIlIIll.size() > 0) {
            return (Entity)llllllllllllllllllIIlllllIIlIIll.get(0);
        }
        return null;
    }

    static {
        mc = Minecraft.getMinecraft();
    }

    public static Entity getTergetCircle(boolean llllllllllllllllllIIllllllIlIlIl, float llllllllllllllllllIIllllllIlIlll) {
        ArrayList<Entity> llllllllllllllllllIIllllllIlIllI = new ArrayList<Entity>();
        for (Entity llllllllllllllllllIIllllllIllIIl : CombatUtils.mc.world.loadedEntityList) {
            if (!(llllllllllllllllllIIllllllIllIIl instanceof EntityPlayer) || llllllllllllllllllIIllllllIllIIl == CombatUtils.mc.player || FriendManager.isFriend(llllllllllllllllllIIllllllIllIIl.getName()) || llllllllllllllllllIIllllllIllIIl.isInvisible() || !(llllllllllllllllllIIllllllIllIIl.height > 1.0f) || (!CombatUtils.canSeeEntityAtFov2(llllllllllllllllllIIllllllIllIIl, AimBot.Fov.getVal() * 100.0f / 5.0f) || !CombatUtils.canSeeEntityAtFov(llllllllllllllllllIIllllllIllIIl, AimBot.Fov.getVal() * 100.0f / 5.0f) || !((EntityPlayer)llllllllllllllllllIIllllllIllIIl).canEntityBeSeen((Entity)CombatUtils.mc.player) || llllllllllllllllllIIllllllIlIlIl) && !llllllllllllllllllIIllllllIlIlIl) continue;
            llllllllllllllllllIIllllllIlIllI.add(llllllllllllllllllIIllllllIllIIl);
        }
        llllllllllllllllllIIllllllIlIllI.sort(new Comparator<Entity>(){

            @Override
            public int compare(Entity lllllllllllllllIIlllllllIlIllIII, Entity lllllllllllllllIIlllllllIlIlIlll) {
                return (int)(CombatUtils.mc.player.getDistanceToEntity(lllllllllllllllIIlllllllIlIllIII) - CombatUtils.mc.player.getDistanceToEntity(lllllllllllllllIIlllllllIlIlIlll));
            }
            {
                1 lllllllllllllllIIlllllllIlIlllIl;
            }
        });
        if (llllllllllllllllllIIllllllIlIllI.size() > 0) {
            return (Entity)llllllllllllllllllIIllllllIlIllI.get(0);
        }
        return null;
    }

    public CombatUtils() {
        CombatUtils llllllllllllllllllIlIIIIIlIIIlIl;
    }
}

