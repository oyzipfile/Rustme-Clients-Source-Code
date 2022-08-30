/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 */
package ru.internali.utils.fov;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class UtilsForFov {
    /* synthetic */ Minecraft mc;

    public static Vec3d getEyesPos() {
        return new Vec3d(Minecraft.getMinecraft().player.field_70165_t, Minecraft.getMinecraft().player.field_70163_u + (double)Minecraft.getMinecraft().player.func_70047_e(), Minecraft.getMinecraft().player.field_70161_v);
    }

    public static float[] getNeededRotations(Entity lllIIlIlIlIIIIl) {
        Vec3d lllIIlIlIlIlIII = UtilsForFov.getEyesPos();
        double lllIIlIlIlIIlll = lllIIlIlIlIIIIl.posX - lllIIlIlIlIlIII.x;
        double lllIIlIlIlIIllI = lllIIlIlIlIIIIl.posY - lllIIlIlIlIlIII.y;
        double lllIIlIlIlIIlIl = lllIIlIlIlIIIIl.posZ - lllIIlIlIlIlIII.z;
        double lllIIlIlIlIIlII = Math.sqrt(lllIIlIlIlIIlll * lllIIlIlIlIIlll + lllIIlIlIlIIlIl * lllIIlIlIlIIlIl);
        float lllIIlIlIlIIIll = (float)Math.toDegrees(Math.atan2(lllIIlIlIlIIlIl, lllIIlIlIlIIlll)) - 90.0f;
        float lllIIlIlIlIIIlI = (float)(-Math.toDegrees(Math.atan2(lllIIlIlIlIIllI, lllIIlIlIlIIlII)));
        return new float[]{Minecraft.getMinecraft().player.field_70177_z + MathHelper.wrapDegrees((float)(lllIIlIlIlIIIll - Minecraft.getMinecraft().player.field_70177_z)), Minecraft.getMinecraft().player.field_70125_A + MathHelper.wrapDegrees((float)(lllIIlIlIlIIIlI - Minecraft.getMinecraft().player.field_70125_A))};
    }

    public static int getDistanceFromMouse(Entity lllIIlIlIIIllll) {
        float[] lllIIlIlIIlIIII = UtilsForFov.getNeededRotations(lllIIlIlIIIllll);
        if (lllIIlIlIIlIIII != null) {
            float lllIIlIlIIlIlII = Minecraft.getMinecraft().player.field_70177_z - lllIIlIlIIlIIII[0];
            float lllIIlIlIIlIIll = Minecraft.getMinecraft().player.field_70125_A - lllIIlIlIIlIIII[1];
            float lllIIlIlIIlIIlI = MathHelper.sqrt((float)(lllIIlIlIIlIlII * lllIIlIlIIlIlII + lllIIlIlIIlIIll * lllIIlIlIIlIIll * 2.0f));
            return (int)lllIIlIlIIlIIlI;
        }
        return -1;
    }

    public static String getPlayerName(EntityPlayer lllIIlIlIIIlIIl) {
        return lllIIlIlIIIlIIl.getGameProfile() != null ? lllIIlIlIIIlIIl.getGameProfile().getName() : "null";
    }

    public UtilsForFov() {
        UtilsForFov lllIIlIlIllIIlI;
        lllIIlIlIllIIlI.mc = Minecraft.getMinecraft();
    }
}

