/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.MathHelper
 */
package ru.internali.utils;

import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import ru.internali.utils.MathUtils;
import ru.internali.utils.MinecraftHelper;

public class RotationUtils {
    public static float[] getRotationFromPosition(double llllIIIlIIlIlIl, double llllIIIlIIlIlII, double llllIIIlIIlIIll) {
        double llllIIIlIIlIIlI = llllIIIlIIlIlIl - Minecraft.getMinecraft().player.field_70165_t;
        double llllIIIlIIlIIIl = llllIIIlIIlIlII - Minecraft.getMinecraft().player.field_70161_v;
        double llllIIIlIIlIIII = llllIIIlIIlIIll - Minecraft.getMinecraft().player.field_70163_u - 0.6;
        double llllIIIlIIIllll = MathHelper.sqrt((double)(llllIIIlIIlIIlI * llllIIIlIIlIIlI + llllIIIlIIlIIIl * llllIIIlIIlIIIl));
        float llllIIIlIIIlllI = (float)(Math.atan2(llllIIIlIIlIIIl, llllIIIlIIlIIlI) * 180.0 / Math.PI) - 90.0f;
        float llllIIIlIIIllIl = (float)(-(Math.atan2(llllIIIlIIlIIII, llllIIIlIIIllll) * 180.0 / Math.PI));
        return new float[]{llllIIIlIIIlllI, llllIIIlIIIllIl};
    }

    public static float[] getNeededRotations(Entity llllIIIIlllllII) {
        double llllIIIIllllIll = llllIIIIlllllII.posX - Minecraft.getMinecraft().player.field_70165_t;
        double llllIIIIllllIlI = llllIIIIlllllII.posZ - Minecraft.getMinecraft().player.field_70161_v;
        double llllIIIIllllIIl = llllIIIIlllllII.posY + (double)llllIIIIlllllII.getEyeHeight() - (Minecraft.getMinecraft().player.func_174813_aQ().minY + (Minecraft.getMinecraft().player.func_174813_aQ().maxY - Minecraft.getMinecraft().player.func_174813_aQ().minY));
        double llllIIIIllllIII = MathHelper.sqrt((double)(llllIIIIllllIll * llllIIIIllllIll + llllIIIIllllIlI * llllIIIIllllIlI));
        float llllIIIIlllIlll = (float)(MathHelper.atan2((double)llllIIIIllllIlI, (double)llllIIIIllllIll) * 180.0 / Math.PI) - 90.0f;
        float llllIIIIlllIllI = (float)(-(MathHelper.atan2((double)llllIIIIllllIIl, (double)llllIIIIllllIII) * 180.0 / Math.PI));
        return new float[]{llllIIIIlllIlll, llllIIIIlllIllI};
    }

    public RotationUtils() {
        RotationUtils llllIIIllllIIIl;
    }

    public static float[] getRotations(EntityLivingBase llllIIIIlIllIII, String llllIIIIlIlIlll) {
        if (llllIIIIlIlIlll == "Head") {
            double llllIIIIllIlIIl = llllIIIIlIllIII.field_70165_t;
            double llllIIIIllIlIII = llllIIIIlIllIII.field_70161_v;
            double llllIIIIllIIlll = llllIIIIlIllIII.field_70163_u + (double)(llllIIIIlIllIII.func_70047_e() / 2.0f);
            return RotationUtils.getRotationFromPosition(llllIIIIllIlIIl, llllIIIIllIlIII, llllIIIIllIIlll);
        }
        if (llllIIIIlIlIlll == "Chest") {
            double llllIIIIllIIllI = llllIIIIlIllIII.field_70165_t;
            double llllIIIIllIIlIl = llllIIIIlIllIII.field_70161_v;
            double llllIIIIllIIlII = llllIIIIlIllIII.field_70163_u + (double)(llllIIIIlIllIII.func_70047_e() / 2.0f) - 0.75;
            return RotationUtils.getRotationFromPosition(llllIIIIllIIllI, llllIIIIllIIlIl, llllIIIIllIIlII);
        }
        if (llllIIIIlIlIlll == "Dick") {
            double llllIIIIllIIIll = llllIIIIlIllIII.field_70165_t;
            double llllIIIIllIIIlI = llllIIIIlIllIII.field_70161_v;
            double llllIIIIllIIIIl = llllIIIIlIllIII.field_70163_u + (double)(llllIIIIlIllIII.func_70047_e() / 2.0f) - 1.2;
            return RotationUtils.getRotationFromPosition(llllIIIIllIIIll, llllIIIIllIIIlI, llllIIIIllIIIIl);
        }
        if (llllIIIIlIlIlll == "Legs") {
            double llllIIIIllIIIII = llllIIIIlIllIII.field_70165_t;
            double llllIIIIlIlllll = llllIIIIlIllIII.field_70161_v;
            double llllIIIIlIllllI = llllIIIIlIllIII.field_70163_u + (double)(llllIIIIlIllIII.func_70047_e() / 2.0f) - 1.5;
            return RotationUtils.getRotationFromPosition(llllIIIIllIIIII, llllIIIIlIlllll, llllIIIIlIllllI);
        }
        double llllIIIIlIllIll = llllIIIIlIllIII.field_70165_t;
        double llllIIIIlIllIlI = llllIIIIlIllIII.field_70161_v;
        double llllIIIIlIllIIl = llllIIIIlIllIII.field_70163_u + (double)(llllIIIIlIllIII.func_70047_e() / 2.0f) - 0.5;
        return RotationUtils.getRotationFromPosition(llllIIIIlIllIll, llllIIIIlIllIlI, llllIIIIlIllIIl);
    }

    public static float[] getAverageRotations(List llllIIIlllIIllI) {
        double llllIIIlllIIlIl = 0.0;
        double llllIIIlllIIlII = 0.0;
        double llllIIIlllIIIll = 0.0;
        for (Object llllIIIlllIIlll : llllIIIlllIIllI) {
            Entity llllIIIlllIlIII = (Entity)llllIIIlllIIlll;
            llllIIIlllIIlIl += llllIIIlllIlIII.posX;
            llllIIIlllIIlII += llllIIIlllIlIII.getEntityBoundingBox().maxY - 2.0;
            llllIIIlllIIIll += llllIIIlllIlIII.posZ;
        }
        float[] llllIIIlllIIIlI = new float[2];
        boolean llllIIIlllIIIIl = false;
        llllIIIlllIIIlI[0] = RotationUtils.getRotationFromPosition(llllIIIlllIIlIl /= (double)llllIIIlllIIllI.size(), llllIIIlllIIIll /= (double)llllIIIlllIIllI.size(), llllIIIlllIIlII /= (double)llllIIIlllIIllI.size())[0];
        llllIIIlllIIIlI[1] = RotationUtils.getRotationFromPosition(llllIIIlllIIlIl, llllIIIlllIIIll, llllIIIlllIIlII)[1];
        return llllIIIlllIIIlI;
    }

    public static float getNewAngle(float llllIIIIlIlIIIl) {
        float f;
        llllIIIIlIlIIIl %= 360.0f;
        if (f >= 180.0f) {
            llllIIIIlIlIIIl -= 360.0f;
        }
        if (llllIIIIlIlIIIl < -180.0f) {
            llllIIIIlIlIIIl += 360.0f;
        }
        return llllIIIIlIlIIIl;
    }

    public static float changeRotation(float llllIIIlIlllIIl, float llllIIIlIllIlIl) {
        float llllIIIlIllIlll = MathUtils.wrapAngleTo180_float(llllIIIlIllIlIl - llllIIIlIlllIIl);
        if (llllIIIlIllIlll > 1000.0f) {
            llllIIIlIllIlll = 1000.0f;
        }
        if (llllIIIlIllIlll < -1000.0f) {
            llllIIIlIllIlll = -1000.0f;
        }
        return llllIIIlIlllIIl + llllIIIlIllIlll;
    }

    public static float[] getRotations(Entity llllIIIllIIlllI) {
        double llllIIIllIIllIl;
        double llllIIIllIIllII = llllIIIllIIlllI.posX - MinecraftHelper.mc.player.field_70165_t;
        double llllIIIllIIlIll = llllIIIllIIlllI.posZ - MinecraftHelper.mc.player.field_70161_v;
        if (llllIIIllIIlllI instanceof EntityLivingBase) {
            EntityLivingBase llllIIIllIlIIII = (EntityLivingBase)llllIIIllIIlllI;
            double llllIIIllIIllll = llllIIIllIlIIII.field_70163_u + (double)llllIIIllIlIIII.func_70047_e() - MinecraftHelper.mc.player.field_70163_u + (double)MinecraftHelper.mc.player.func_70047_e();
        } else {
            llllIIIllIIllIl = (llllIIIllIIlllI.getEntityBoundingBox().minY + llllIIIllIIlllI.getEntityBoundingBox().maxY) / 2.0 - MinecraftHelper.mc.player.field_70163_u + (double)MinecraftHelper.mc.player.func_70047_e();
        }
        double llllIIIllIIlIlI = MathUtils.sqrt_double(llllIIIllIIllII * llllIIIllIIllII + llllIIIllIIlIll * llllIIIllIIlIll);
        float llllIIIllIIlIIl = (float)(Math.atan2(llllIIIllIIlIll, llllIIIllIIllII) * 180.0 / Math.PI) - 90.0f;
        float llllIIIllIIlIII = (float)(-(Math.atan2(llllIIIllIIllIl - (llllIIIllIIlllI instanceof EntityPlayer ? 0.25 : 0.0), llllIIIllIIlIlI) * 180.0 / Math.PI));
        float llllIIIllIIIlll = RotationUtils.changeRotation(MinecraftHelper.mc.player.field_70125_A, llllIIIllIIlIII);
        float llllIIIllIIIllI = RotationUtils.changeRotation(MinecraftHelper.mc.player.field_70177_z, llllIIIllIIlIIl);
        return new float[]{llllIIIllIIIllI, llllIIIllIIIlll};
    }

    public static float getTrajAngleSolutionLow(float llllIIIlIlIIIlI, float llllIIIlIlIIlIl, float llllIIIlIlIIIII) {
        float llllIIIlIlIIIll = llllIIIlIlIIIII * llllIIIlIlIIIII * llllIIIlIlIIIII * llllIIIlIlIIIII - 0.006f * (0.006f * (llllIIIlIlIIIlI * llllIIIlIlIIIlI) + 2.0f * llllIIIlIlIIlIl * (llllIIIlIlIIIII * llllIIIlIlIIIII));
        return (float)Math.toDegrees(Math.atan(((double)(llllIIIlIlIIIII * llllIIIlIlIIIII) - Math.sqrt(llllIIIlIlIIIll)) / (double)(0.006f * llllIIIlIlIIIlI)));
    }

    public static float getDistanceBetweenAngles(float llllIIIlIllIIII, float llllIIIlIlIllII) {
        float llllIIIlIlIlllI = Math.abs(llllIIIlIllIIII - llllIIIlIlIllII) % 360.0f;
        if (llllIIIlIlIlllI > 180.0f) {
            llllIIIlIlIlllI = 360.0f - llllIIIlIlIlllI;
        }
        return llllIIIlIlIlllI;
    }
}

