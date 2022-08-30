/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityAgeable
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.monster.EntityGolem
 *  net.minecraft.entity.monster.EntityIronGolem
 *  net.minecraft.entity.passive.EntityAmbientCreature
 *  net.minecraft.entity.passive.EntityAnimal
 *  net.minecraft.entity.passive.EntitySquid
 *  net.minecraft.entity.passive.EntityTameable
 *  net.minecraft.entity.passive.EntityWaterMob
 *  net.minecraft.entity.passive.EntityWolf
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 */
package ru.internali.utils;

import java.awt.Color;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import ru.internali.utils.MathUtils;
import ru.internali.utils.MinecraftHelper;
import ru.internali.utils.friend.FriendManager;

public class EntityUtil {
    public static Color getColor(Entity llIIlIIIlIlllII, int llIIlIIIlIlIlII, int llIIlIIIlIlIIll, int llIIlIIIlIllIIl, int llIIlIIIlIllIII, boolean llIIlIIIlIlIIII) {
        Color llIIlIIIlIlIllI = new Color((float)llIIlIIIlIlIlII / 255.0f, (float)llIIlIIIlIlIIll / 255.0f, (float)llIIlIIIlIllIIl / 255.0f, (float)llIIlIIIlIllIII / 255.0f);
        if (llIIlIIIlIlllII instanceof EntityPlayer && llIIlIIIlIlIIII && FriendManager.isFriend(String.valueOf((Object)((EntityPlayer)llIIlIIIlIlllII)))) {
            llIIlIIIlIlIllI = new Color(0.33333334f, 1.0f, 1.0f, (float)llIIlIIIlIllIII / 255.0f);
        }
        return llIIlIIIlIlIllI;
    }

    public static float[] calculateLookAt(double llIIlIIIIlIllll, double llIIlIIIIlIIIll, double llIIlIIIIlIIIlI, EntityPlayer llIIlIIIIlIIIIl) {
        double llIIlIIIIlIlIll = llIIlIIIIlIIIIl.field_70165_t - llIIlIIIIlIllll;
        double llIIlIIIIlIlIlI = llIIlIIIIlIIIIl.field_70163_u - llIIlIIIIlIIIll;
        double llIIlIIIIlIlIIl = llIIlIIIIlIIIIl.field_70161_v - llIIlIIIIlIIIlI;
        double llIIlIIIIlIlIII = Math.sqrt(llIIlIIIIlIlIll * llIIlIIIIlIlIll + llIIlIIIIlIlIlI * llIIlIIIIlIlIlI + llIIlIIIIlIlIIl * llIIlIIIIlIlIIl);
        double llIIlIIIIlIIlll = Math.asin(llIIlIIIIlIlIlI /= llIIlIIIIlIlIII);
        double llIIlIIIIlIIllI = Math.atan2(llIIlIIIIlIlIIl /= llIIlIIIIlIlIII, llIIlIIIIlIlIll /= llIIlIIIIlIlIII);
        llIIlIIIIlIIlll = llIIlIIIIlIIlll * 180.0 / Math.PI;
        llIIlIIIIlIIllI = llIIlIIIIlIIllI * 180.0 / Math.PI;
        return new float[]{(float)(llIIlIIIIlIIllI += 90.0), (float)llIIlIIIIlIIlll};
    }

    public static boolean isPassive(Entity llIIIllllllllll) {
        return (!(llIIIllllllllll instanceof EntityWolf) || !((EntityWolf)llIIIllllllllll).isAngry()) && (llIIIllllllllll instanceof EntityAnimal || llIIIllllllllll instanceof EntityAgeable || llIIIllllllllll instanceof EntityTameable || llIIIllllllllll instanceof EntityAmbientCreature || llIIIllllllllll instanceof EntitySquid || llIIIllllllllll instanceof EntityIronGolem && ((EntityIronGolem)llIIIllllllllll).func_70643_av() == null);
    }

    public static Vec3d getInterpolatedRenderPos(Entity llIIlIIIlIIIlll, float llIIlIIIlIIIllI) {
        return EntityUtil.getInterpolatedPos(llIIlIIIlIIIlll, llIIlIIIlIIIllI).subtract(MinecraftHelper.mc.getRenderManager().viewerPosX, MinecraftHelper.mc.getRenderManager().viewerPosY, MinecraftHelper.mc.getRenderManager().viewerPosZ);
    }

    public static Vec3d getInterpolatedRenderPos(Vec3d llIIlIIIlIIIlII) {
        return new Vec3d(llIIlIIIlIIIlII.x, llIIlIIIlIIIlII.y, llIIlIIIlIIIlII.z).subtract(MinecraftHelper.mc.getRenderManager().viewerPosX, MinecraftHelper.mc.getRenderManager().viewerPosY, MinecraftHelper.mc.getRenderManager().viewerPosZ);
    }

    public static Vec3d getInterpolatedAmount(Entity llIIIllllllIIlI, double llIIIllllllIIIl, double llIIIllllllIlII, double llIIIllllllIIll) {
        return new Vec3d((llIIIllllllIIlI.posX - llIIIllllllIIlI.lastTickPosX) * llIIIllllllIIIl, (llIIIllllllIIlI.posY - llIIIllllllIIlI.lastTickPosY) * llIIIllllllIlII, (llIIIllllllIIlI.posZ - llIIIllllllIIlI.lastTickPosZ) * llIIIllllllIIll);
    }

    public EntityUtil() {
        EntityUtil llIIlIIIllIlIlI;
    }

    public static double GetDistanceOfEntityToBlock(Entity llIIlIIIlIIIIII, BlockPos llIIlIIIIllllIl) {
        return EntityUtil.GetDistance(llIIlIIIlIIIIII.posX, llIIlIIIlIIIIII.posY, llIIlIIIlIIIIII.posZ, llIIlIIIIllllIl.func_177958_n(), llIIlIIIIllllIl.func_177956_o(), llIIlIIIIllllIl.func_177952_p());
    }

    public static boolean isLiving(Entity llIIIlllllllIll) {
        return llIIIlllllllIll instanceof EntityLivingBase;
    }

    public static boolean stopSneaking(boolean llIIlIIIIlllIll) {
        if (llIIlIIIIlllIll && MinecraftHelper.mc.player != null) {
            MinecraftHelper.mc.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)MinecraftHelper.mc.player, CPacketEntityAction.Action.STOP_SNEAKING));
        }
        return false;
    }

    public static boolean isAnimal(Entity llIIlIIIlIIllIl) {
        return llIIlIIIlIIllIl instanceof EntityAgeable || llIIlIIIlIIllIl instanceof EntityAmbientCreature || llIIlIIIlIIllIl instanceof EntityWaterMob || llIIlIIIlIIllIl instanceof EntityGolem;
    }

    public static Vec3d getInterpolatedAmount(Entity llIIIlllllIlIlI, Vec3d llIIIlllllIlIll) {
        return EntityUtil.getInterpolatedAmount(llIIIlllllIlIlI, llIIIlllllIlIll.x, llIIIlllllIlIll.y, llIIIlllllIlIll.z);
    }

    public static Vec3d getInterpolatedAmount(Entity llIIIlllllIIllI, double llIIIlllllIIIll) {
        return EntityUtil.getInterpolatedAmount(llIIIlllllIIllI, llIIIlllllIIIll, llIIIlllllIIIll, llIIIlllllIIIll);
    }

    public static Vec3d getInterpolatedPos(Entity llIIlIIIllIIlll, float llIIlIIIllIIllI) {
        return MathUtils.interpolateVec3d(llIIlIIIllIIlll.getPositionVector(), new Vec3d(llIIlIIIllIIlll.lastTickPosX, llIIlIIIllIIlll.lastTickPosY, llIIlIIIllIIlll.lastTickPosZ), llIIlIIIllIIllI);
    }

    public static double GetDistance(double llIIlIIIIIIlIIl, double llIIlIIIIIIIlll, double llIIlIIIIIlIIII, double llIIlIIIIIIIlIl, double llIIlIIIIIIlllI, double llIIlIIIIIIIIll) {
        double llIIlIIIIIIllII = llIIlIIIIIIlIIl - llIIlIIIIIIIlIl;
        double llIIlIIIIIIlIll = llIIlIIIIIIIlll - llIIlIIIIIIlllI;
        double llIIlIIIIIIlIlI = llIIlIIIIIlIIII - llIIlIIIIIIIIll;
        return MathHelper.sqrt((double)(llIIlIIIIIIllII * llIIlIIIIIIllII + llIIlIIIIIIlIll * llIIlIIIIIIlIll + llIIlIIIIIIlIlI * llIIlIIIIIIlIlI));
    }
}

