/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 */
package ru.internali.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import ru.internali.utils.InterpolationUtil;

public class AngleUtil {
    private static /* synthetic */ Minecraft mc;

    public static float[] calculateAngles(Entity lllllllIIlIlIII) {
        return AngleUtil.calculateAngle(InterpolationUtil.interpolateEntityTime((Entity)AngleUtil.mc.player, mc.getRenderPartialTicks()), InterpolationUtil.interpolateEntityTime(lllllllIIlIlIII, mc.getRenderPartialTicks()));
    }

    public static float calculateAngleDifference(float lllllllIIIlIIII, float lllllllIIIlIIll, double lllllllIIIlIIlI, int lllllllIIIlIIIl) {
        return (float)((double)lllllllIIIlIIII - (double)lllllllIIIlIIll / (lllllllIIIlIIlI * (double)lllllllIIIlIIIl));
    }

    public static float calculateAngleDifference(float lllllllIIIIIllI, float lllllllIIIIIlIl) {
        float lllllllIIIIIlll = Math.abs(lllllllIIIIIlIl - lllllllIIIIIllI) % 360.0f;
        return lllllllIIIIIlll > 180.0f ? 360.0f - lllllllIIIIIlll : lllllllIIIIIlll;
    }

    public static float[] calculateAngle(Vec3d lllllllIIIlllII, Vec3d lllllllIIIllIll) {
        return new float[]{(float)MathHelper.wrapDegrees((double)(Math.toDegrees(Math.atan2(lllllllIIIllIll.z - lllllllIIIlllII.z, lllllllIIIllIll.x - lllllllIIIlllII.x)) - 90.0)), (float)MathHelper.wrapDegrees((double)Math.toDegrees(Math.atan2((lllllllIIIllIll.y - lllllllIIIlllII.y) * -1.0, MathHelper.sqrt((double)(Math.pow(lllllllIIIllIll.x - lllllllIIIlllII.x, 2.0) + Math.pow(lllllllIIIllIll.z - lllllllIIIlllII.z, 2.0))))))};
    }

    public AngleUtil() {
        AngleUtil lllllllIIlIlIll;
    }

    public static float[] calculateAngles(BlockPos lllllllIIlIIlIl) {
        return AngleUtil.calculateAngle(InterpolationUtil.interpolateEntityTime((Entity)AngleUtil.mc.player, mc.getRenderPartialTicks()), new Vec3d((Vec3i)lllllllIIlIIlIl));
    }

    static {
        mc = Minecraft.getMinecraft();
    }

    public static float[] calculateCenter(BlockPos lllllllIIIlllll) {
        return AngleUtil.calculateAngle(InterpolationUtil.interpolateEntityTime((Entity)AngleUtil.mc.player, mc.getRenderPartialTicks()), new Vec3d((Vec3i)lllllllIIIlllll).add(new Vec3d(0.5, 0.0, 0.5)));
    }

    public static float[] calculateCenter(Entity lllllllIIlIIIlI) {
        return AngleUtil.calculateAngle(InterpolationUtil.interpolateEntityTime((Entity)AngleUtil.mc.player, mc.getRenderPartialTicks()), InterpolationUtil.interpolateEntityTime(lllllllIIlIIIlI, mc.getRenderPartialTicks()).add(new Vec3d((double)(lllllllIIlIIIlI.width / 2.0f), (double)(lllllllIIlIIIlI.getEyeHeight() / 2.0f), (double)(lllllllIIlIIIlI.width / 2.0f))));
    }
}

