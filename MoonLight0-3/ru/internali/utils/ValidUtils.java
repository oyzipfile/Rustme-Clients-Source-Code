/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 */
package ru.internali.utils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import ru.internali.utils.Utils;
import ru.internali.utils.Wrapper;

public class ValidUtils {
    public static boolean isLowHealth(EntityLivingBase lllIllIlIlIlIlI, EntityLivingBase lllIllIlIlIlIIl) {
        return lllIllIlIlIlIIl == null || lllIllIlIlIlIlI.getHealth() < lllIllIlIlIlIIl.getHealth();
    }

    public static boolean isInAttackRange(EntityLivingBase lllIllIlIIlIllI, float lllIllIlIIlIlll) {
        return lllIllIlIIlIllI.func_70032_d((Entity)Wrapper.INSTANCE.player()) <= lllIllIlIIlIlll;
    }

    public static boolean isInAttackFOV(EntityLivingBase lllIllIlIIlllII, int lllIllIlIIllIll) {
        return Utils.getDistanceFromMouse(lllIllIlIIlllII) <= lllIllIlIIllIll;
    }

    public static boolean isValidEntity(EntityLivingBase lllIllIlIIlIIll) {
        if (lllIllIlIIlIIll instanceof EntityPlayer) {
            return false;
        }
        return !(lllIllIlIIlIIll instanceof EntityLiving);
    }

    public ValidUtils() {
        ValidUtils lllIllIlIlIlllI;
    }

    public static boolean isClosest(EntityLivingBase lllIllIlIlIIlII, EntityLivingBase lllIllIlIlIIIll) {
        return lllIllIlIlIIIll == null || Wrapper.INSTANCE.player().func_70032_d((Entity)lllIllIlIlIIlII) < Wrapper.INSTANCE.player().func_70032_d((Entity)lllIllIlIlIIIll);
    }
}

