/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.BlockPos
 */
package ru.internali.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

public class EntityHelper {
    static /* synthetic */ Minecraft mc;

    public static int getPing(EntityPlayer lIlIIIllllIlIlI) {
        return EntityHelper.mc.player.connection.getPlayerInfo(lIlIIIllllIlIlI.func_110124_au()).getResponseTime();
    }

    public static boolean checkArmor(Entity lIlIIIllllIllIl) {
        return ((EntityLivingBase)lIlIIIllllIllIl).getTotalArmorValue() < 6;
    }

    static {
        mc = Minecraft.getMinecraft();
    }

    public static boolean isTeamWithYou(EntityLivingBase lIlIIIlllllIIll) {
        if (EntityHelper.mc.player != null && lIlIIIlllllIIll != null && EntityHelper.mc.player.func_145748_c_() != null && lIlIIIlllllIIll.func_145748_c_() != null) {
            if (EntityHelper.mc.player.func_96124_cp() != null && lIlIIIlllllIIll.func_96124_cp() != null && EntityHelper.mc.player.func_96124_cp().isSameTeam(lIlIIIlllllIIll.func_96124_cp())) {
                return true;
            }
            String lIlIIIlllllIlIl = lIlIIIlllllIIll.func_145748_c_().getFormattedText().replace("\u0412\u00a7r", "");
            String lIlIIIlllllIlII = EntityHelper.mc.player.func_145748_c_().getFormattedText().replace("\u0412\u00a7r", "");
            return lIlIIIlllllIlIl.startsWith(String.valueOf(new StringBuilder().append("\u0412\u00a7").append(lIlIIIlllllIlII.charAt(1))));
        }
        return false;
    }

    public static double getDistance(double lIlIIlIIIIlllII, double lIlIIlIIIIlIIIl, double lIlIIlIIIIllIlI, double lIlIIlIIIIllIIl, double lIlIIlIIIIIlllI, double lIlIIlIIIIIllIl) {
        double lIlIIlIIIIlIllI = lIlIIlIIIIlllII - lIlIIlIIIIllIIl;
        double lIlIIlIIIIlIlIl = lIlIIlIIIIlIIIl - lIlIIlIIIIIlllI;
        double lIlIIlIIIIlIlII = lIlIIlIIIIllIlI - lIlIIlIIIIIllIl;
        return Math.sqrt(lIlIIlIIIIlIllI * lIlIIlIIIIlIllI + lIlIIlIIIIlIlIl * lIlIIlIIIIlIlIl + lIlIIlIIIIlIlII * lIlIIlIIIIlIlII);
    }

    public static double getDistanceOfEntityToBlock(Entity lIlIIIllllIIlll, BlockPos lIlIIIllllIIllI) {
        return EntityHelper.getDistance(lIlIIIllllIIlll.posX, lIlIIIllllIIlll.posY, lIlIIIllllIIlll.posZ, lIlIIIllllIIllI.func_177958_n(), lIlIIIllllIIllI.func_177956_o(), lIlIIIllllIIllI.func_177952_p());
    }

    public static double getDistance(double lIlIIIllllllllI, double lIlIIlIIIIIIIll, double lIlIIlIIIIIIIlI, double lIlIIlIIIIIIIIl) {
        double lIlIIlIIIIIIIII = lIlIIIllllllllI - lIlIIlIIIIIIIlI;
        double lIlIIIlllllllll = lIlIIlIIIIIIIll - lIlIIlIIIIIIIIl;
        return Math.hypot(lIlIIlIIIIIIIII, lIlIIIlllllllll);
    }

    public EntityHelper() {
        EntityHelper lIlIIlIIIlIIllI;
    }
}

