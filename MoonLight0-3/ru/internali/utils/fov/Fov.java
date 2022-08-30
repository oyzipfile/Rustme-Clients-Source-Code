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
import ru.internali.utils.fov.UtilsForFov;

public class Fov {
    public static boolean isInAttackFOV(Entity lIlIIIIIIIlIlII, int lIlIIIIIIIlIIll) {
        return UtilsForFov.getDistanceFromMouse(lIlIIIIIIIlIlII) <= lIlIIIIIIIlIIll;
    }

    public static float[] getNeededRotations(Entity lIlIIIIIIIIIIII) {
        Vec3d lIlIIIIIIIIIlll = UtilsForFov.getEyesPos();
        double lIlIIIIIIIIIllI = lIlIIIIIIIIIIII.posX - lIlIIIIIIIIIlll.x;
        double lIlIIIIIIIIIlIl = lIlIIIIIIIIIIII.posY - lIlIIIIIIIIIlll.y;
        double lIlIIIIIIIIIlII = lIlIIIIIIIIIIII.posZ - lIlIIIIIIIIIlll.z;
        double lIlIIIIIIIIIIll = Math.sqrt(lIlIIIIIIIIIllI * lIlIIIIIIIIIllI + lIlIIIIIIIIIlII * lIlIIIIIIIIIlII);
        float lIlIIIIIIIIIIlI = (float)Math.toDegrees(Math.atan2(lIlIIIIIIIIIlII, lIlIIIIIIIIIllI)) - 90.0f;
        float lIlIIIIIIIIIIIl = (float)(-Math.toDegrees(Math.atan2(lIlIIIIIIIIIlIl, lIlIIIIIIIIIIll)));
        return new float[]{Minecraft.getMinecraft().player.field_70177_z + MathHelper.wrapDegrees((float)(lIlIIIIIIIIIIlI - Minecraft.getMinecraft().player.field_70177_z)), Minecraft.getMinecraft().player.field_70125_A + MathHelper.wrapDegrees((float)(lIlIIIIIIIIIIIl - Minecraft.getMinecraft().player.field_70125_A))};
    }

    public Fov() {
        Fov lIlIIIIIIIllIII;
    }

    public static String getPlayerName(EntityPlayer lIIlllllllIlIII) {
        return lIIlllllllIlIII.getGameProfile() != null ? lIIlllllllIlIII.getGameProfile().getName() : "null";
    }

    public static int getDistanceFromMouse(Entity lIIlllllllIlllI) {
        float[] lIIlllllllIllll = UtilsForFov.getNeededRotations(lIIlllllllIlllI);
        if (lIIlllllllIllll != null) {
            float lIIllllllllIIll = Minecraft.getMinecraft().player.field_70177_z - lIIlllllllIllll[0];
            float lIIllllllllIIlI = Minecraft.getMinecraft().player.field_70125_A - lIIlllllllIllll[1];
            float lIIllllllllIIIl = MathHelper.sqrt((float)(lIIllllllllIIll * lIIllllllllIIll + lIIllllllllIIlI * lIIllllllllIIlI * 2.0f));
            return (int)lIIllllllllIIIl;
        }
        return -1;
    }
}

