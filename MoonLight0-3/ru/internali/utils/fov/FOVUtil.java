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

public class FOVUtil {
    public static int getDistanceFromMouse(Entity lllIlIIlllIlIlI) {
        float[] lllIlIIlllIlIIl = UtilsForFov.getNeededRotations(lllIlIIlllIlIlI);
        float lllIlIIlllIlIII = Minecraft.getMinecraft().player.field_70177_z - lllIlIIlllIlIIl[0];
        float lllIlIIlllIIlll = Minecraft.getMinecraft().player.field_70125_A - lllIlIIlllIlIIl[1];
        float lllIlIIlllIIllI = MathHelper.sqrt((float)(lllIlIIlllIlIII * lllIlIIlllIlIII + lllIlIIlllIIlll * lllIlIIlllIIlll * 2.0f));
        return (int)lllIlIIlllIIllI;
    }

    public FOVUtil() {
        FOVUtil lllIlIlIIIIllll;
    }

    public static String getPlayerName(EntityPlayer lllIlIIllIlllll) {
        return lllIlIIllIlllll.getGameProfile() != null ? lllIlIIllIlllll.getGameProfile().getName() : "null";
    }

    public static boolean isInAttackFOV(Entity lllIlIlIIIIlIll, int lllIlIlIIIIlIlI) {
        return UtilsForFov.getDistanceFromMouse(lllIlIlIIIIlIll) <= lllIlIlIIIIlIlI;
    }

    public static float[] getNeededRotations(Entity lllIlIIllllIlll) {
        Vec3d lllIlIIlllllllI = UtilsForFov.getEyesPos();
        double lllIlIIllllllIl = lllIlIIllllIlll.posX - lllIlIIlllllllI.x;
        double lllIlIIllllllII = lllIlIIllllIlll.posY - lllIlIIlllllllI.y;
        double lllIlIIlllllIll = lllIlIIllllIlll.posZ - lllIlIIlllllllI.z;
        double lllIlIIlllllIlI = Math.sqrt(lllIlIIllllllIl * lllIlIIllllllIl + lllIlIIlllllIll * lllIlIIlllllIll);
        float lllIlIIlllllIIl = (float)Math.toDegrees(Math.atan2(lllIlIIlllllIll, lllIlIIllllllIl)) - 90.0f;
        float lllIlIIlllllIII = (float)(-Math.toDegrees(Math.atan2(lllIlIIllllllII, lllIlIIlllllIlI)));
        return new float[]{Minecraft.getMinecraft().player.field_70177_z + MathHelper.wrapDegrees((float)(lllIlIIlllllIIl - Minecraft.getMinecraft().player.field_70177_z)), Minecraft.getMinecraft().player.field_70125_A + MathHelper.wrapDegrees((float)(lllIlIIlllllIII - Minecraft.getMinecraft().player.field_70125_A))};
    }
}

