/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 */
package ru.internali.module.combat;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import ru.internali.utils.GCDCalcHelper;
import ru.internali.utils.MathematicHelper;

public class RotationHelperA {
    static /* synthetic */ Minecraft mc;

    public static boolean canSeeEntityAtFov(Entity lIlIllllllIIllI, float lIlIllllllIllII) {
        double lIlIllllllIlIlI = lIlIllllllIIllI.posZ - RotationHelperA.mc.player.field_70161_v;
        double lIlIllllllIlIll = lIlIllllllIIllI.posX - RotationHelperA.mc.player.field_70165_t;
        float lIlIllllllIlIIl = (float)(Math.toDegrees(Math.atan2(lIlIllllllIlIlI, lIlIllllllIlIll)) - 90.0);
        double lIlIllllllIlIII = lIlIllllllIlIIl;
        double lIlIllllllIIlll = RotationHelperA.angleDifference(lIlIllllllIlIII, RotationHelperA.mc.player.field_70177_z);
        return lIlIllllllIIlll <= (double)lIlIllllllIllII;
    }

    public RotationHelperA() {
        RotationHelperA lIllIIIlIlIIIll;
    }

    public static float[] faceBody(float lIllIIIIIlIIIIl, float lIllIIIIIlIIIII, float lIllIIIIIIlllll, float lIllIIIIIIllllI, float lIllIIIIIlIllII) {
        double lIllIIIIIlIlIll = (double)lIllIIIIIlIIIIl - Minecraft.getMinecraft().player.field_70165_t;
        double lIllIIIIIlIlIlI = (double)lIllIIIIIIlllll - Minecraft.getMinecraft().player.field_70161_v;
        double lIllIIIIIlIlIIl = (double)lIllIIIIIlIIIII + 1.66 - (Minecraft.getMinecraft().player.field_70163_u + (double)Minecraft.getMinecraft().player.func_70047_e());
        double lIllIIIIIlIlIII = MathHelper.sqrt((double)(lIllIIIIIlIlIll * lIllIIIIIlIlIll + lIllIIIIIlIlIlI * lIllIIIIIlIlIlI));
        float lIllIIIIIlIIlll = (float)(Math.atan2(lIllIIIIIlIlIlI, lIllIIIIIlIlIll) * 180.0 / Math.PI) - 90.0f;
        float lIllIIIIIlIIllI = (float)(-(Math.atan2(lIllIIIIIlIlIIl - 0.55, lIllIIIIIlIlIII) * 180.0 / Math.PI));
        float lIllIIIIIlIIlIl = Minecraft.getMinecraft().gameSettings.mouseSensitivity * 0.6f + 0.2f;
        float lIllIIIIIlIIlII = lIllIIIIIlIIlIl * lIllIIIIIlIIlIl * lIllIIIIIlIIlIl * 1.2f;
        float lIllIIIIIlIIIll = RotationHelperA.updateRotation(Minecraft.getMinecraft().player.field_70125_A, lIllIIIIIlIIllI, lIllIIIIIlIllII);
        float lIllIIIIIlIIIlI = RotationHelperA.updateRotation(Minecraft.getMinecraft().player.field_70177_z, lIllIIIIIlIIlll, lIllIIIIIIllllI);
        lIllIIIIIlIIIlI -= lIllIIIIIlIIIlI % lIllIIIIIlIIlII;
        lIllIIIIIlIIIll -= lIllIIIIIlIIIll % lIllIIIIIlIIlII;
        return new float[]{lIllIIIIIlIIIlI, lIllIIIIIlIIIll};
    }

    public static float[] getNeededRotations(BlockPos lIllIIIIIIIIlII) {
        double lIllIIIIIIIlIlI = (double)lIllIIIIIIIIlII.func_177958_n() - Minecraft.getMinecraft().player.field_70165_t;
        double lIllIIIIIIIlIIl = (double)lIllIIIIIIIIlII.func_177952_p() - Minecraft.getMinecraft().player.field_70161_v;
        double lIllIIIIIIIlIII = (double)lIllIIIIIIIIlII.func_177956_o() - Minecraft.getMinecraft().player.field_70163_u;
        double lIllIIIIIIIIlll = MathHelper.sqrt((double)(lIllIIIIIIIlIlI * lIllIIIIIIIlIlI + lIllIIIIIIIlIIl * lIllIIIIIIIlIIl));
        float lIllIIIIIIIIllI = (float)(MathHelper.atan2((double)lIllIIIIIIIlIIl, (double)lIllIIIIIIIlIlI) * 180.0 / Math.PI) - 90.0f;
        float lIllIIIIIIIIlIl = (float)(-(MathHelper.atan2((double)lIllIIIIIIIlIII, (double)lIllIIIIIIIIlll) * 180.0 / Math.PI));
        return new float[]{lIllIIIIIIIIllI, lIllIIIIIIIIlIl};
    }

    public static double angleDifference(double lIlIlllllllIlll, double lIlIllllllllIIl) {
        float lIlIllllllllIII = (float)(Math.abs(lIlIlllllllIlll - lIlIllllllllIIl) % 360.0);
        if (lIlIllllllllIII > 180.0f) {
            lIlIllllllllIII = 360.0f - lIlIllllllllIII;
        }
        return lIlIllllllllIII;
    }

    public static float updateRotation(float lIllIIIIlllIlII, float lIllIIIIlllIIll, float lIllIIIIllIlllI) {
        float lIllIIIIlllIIIl = MathHelper.wrapDegrees((float)(lIllIIIIlllIIll - lIllIIIIlllIlII));
        if (lIllIIIIlllIIIl > lIllIIIIllIlllI) {
            lIllIIIIlllIIIl = lIllIIIIllIlllI;
        }
        if (lIllIIIIlllIIIl < -lIllIIIIllIlllI) {
            lIllIIIIlllIIIl = -lIllIIIIllIlllI;
        }
        return lIllIIIIlllIlII + lIllIIIIlllIIIl;
    }

    public static Vec3d getEyesPos() {
        return new Vec3d(RotationHelperA.mc.player.field_70165_t, RotationHelperA.mc.player.func_174813_aQ().minY + (double)RotationHelperA.mc.player.func_70047_e(), RotationHelperA.mc.player.field_70161_v);
    }

    static {
        mc = Minecraft.getMinecraft();
    }

    public static float[] faceHead(float lIllIIIIlIlllIl, float lIllIIIIlIIllIl, float lIllIIIIlIllIll, float lIllIIIIlIllIlI, float lIllIIIIlIIlIlI) {
        double lIllIIIIlIllIII = (double)lIllIIIIlIlllIl - Minecraft.getMinecraft().player.field_70165_t;
        double lIllIIIIlIlIlll = (double)lIllIIIIlIllIll - Minecraft.getMinecraft().player.field_70161_v;
        double lIllIIIIlIlIllI = (double)lIllIIIIlIIllIl + 1.66 - (Minecraft.getMinecraft().player.field_70163_u + (double)Minecraft.getMinecraft().player.func_70047_e());
        double lIllIIIIlIlIlIl = MathHelper.sqrt((double)(lIllIIIIlIllIII * lIllIIIIlIllIII + lIllIIIIlIlIlll * lIllIIIIlIlIlll));
        float lIllIIIIlIlIlII = (float)(Math.atan2(lIllIIIIlIlIlll, lIllIIIIlIllIII) * 180.0 / Math.PI) - 90.0f;
        float lIllIIIIlIlIIll = (float)(-(Math.atan2(lIllIIIIlIlIllI - 0.1, lIllIIIIlIlIlIl) * 180.0 / Math.PI));
        float lIllIIIIlIlIIlI = Minecraft.getMinecraft().gameSettings.mouseSensitivity * 0.6f + 0.2f;
        float lIllIIIIlIlIIIl = lIllIIIIlIlIIlI * lIllIIIIlIlIIlI * lIllIIIIlIlIIlI * 1.2f;
        float lIllIIIIlIlIIII = RotationHelperA.updateRotation(Minecraft.getMinecraft().player.field_70125_A, lIllIIIIlIlIIll, lIllIIIIlIIlIlI);
        float lIllIIIIlIIllll = RotationHelperA.updateRotation(Minecraft.getMinecraft().player.field_70177_z, lIllIIIIlIlIlII, lIllIIIIlIllIlI);
        lIllIIIIlIIllll -= lIllIIIIlIIllll % lIllIIIIlIlIIIl;
        lIllIIIIlIlIIII -= lIllIIIIlIlIIII % lIllIIIIlIlIIIl;
        return new float[]{lIllIIIIlIIllll, lIllIIIIlIlIIII};
    }

    public static float[] getRotationVector(Vec3d lIllIIIlIIlIlII, boolean lIllIIIlIIIIlIl, float lIllIIIlIIIIlII, float lIllIIIlIIIIIll, float lIllIIIlIIIIIlI) {
        Vec3d lIllIIIlIIIllll = RotationHelperA.getEyesPos();
        double lIllIIIlIIIlllI = lIllIIIlIIlIlII.x - lIllIIIlIIIllll.x;
        double lIllIIIlIIIllIl = lIllIIIlIIlIlII.y - (RotationHelperA.mc.player.field_70163_u + (double)RotationHelperA.mc.player.func_70047_e() + 0.5);
        double lIllIIIlIIIllII = lIllIIIlIIlIlII.z - lIllIIIlIIIllll.z;
        double lIllIIIlIIIlIll = Math.sqrt(lIllIIIlIIIlllI * lIllIIIlIIIlllI + lIllIIIlIIIllII * lIllIIIlIIIllII);
        float lIllIIIlIIIlIlI = 0.0f;
        if (lIllIIIlIIIIlIl) {
            lIllIIIlIIIlIlI = MathematicHelper.randomizeFloat(-lIllIIIlIIIIlII, lIllIIIlIIIIlII);
        }
        float lIllIIIlIIIlIIl = 0.0f;
        if (lIllIIIlIIIIlIl) {
            lIllIIIlIIIlIIl = MathematicHelper.randomizeFloat(-lIllIIIlIIIIIll, lIllIIIlIIIIIll);
        }
        float lIllIIIlIIIlIII = (float)(Math.toDegrees(Math.atan2(lIllIIIlIIIllII, lIllIIIlIIIlllI)) - 90.0) + lIllIIIlIIIlIlI;
        float lIllIIIlIIIIlll = (float)(-Math.toDegrees(Math.atan2(lIllIIIlIIIllIl, lIllIIIlIIIlIll))) + lIllIIIlIIIlIIl;
        lIllIIIlIIIlIII = RotationHelperA.mc.player.field_70177_z + GCDCalcHelper.getFixedRotation(MathHelper.wrapDegrees((float)(lIllIIIlIIIlIII - RotationHelperA.mc.player.field_70177_z)));
        lIllIIIlIIIIlll = RotationHelperA.mc.player.field_70125_A + GCDCalcHelper.getFixedRotation(MathHelper.wrapDegrees((float)(lIllIIIlIIIIlll - RotationHelperA.mc.player.field_70125_A)));
        lIllIIIlIIIIlll = MathHelper.clamp((float)lIllIIIlIIIIlll, (float)-90.0f, (float)90.0f);
        lIllIIIlIIIlIII = RotationHelperA.updateRotation(RotationHelperA.mc.player.field_70177_z, lIllIIIlIIIlIII, lIllIIIlIIIIIlI);
        lIllIIIlIIIIlll = RotationHelperA.updateRotation(RotationHelperA.mc.player.field_70125_A, lIllIIIlIIIIlll, lIllIIIlIIIIIlI);
        return new float[]{lIllIIIlIIIlIII, lIllIIIlIIIIlll};
    }

    public static class Rotation {
        public static /* synthetic */ float renderPacketYaw;
        public static /* synthetic */ boolean isReady;
        public static /* synthetic */ float packetYaw;
        public static /* synthetic */ float lastPacketYaw;
        public static /* synthetic */ float lastBodyYaw;
        public static /* synthetic */ float lastPacketPitch;
        public static /* synthetic */ float bodyYaw;
        public static /* synthetic */ float packetPitch;
        public static /* synthetic */ int rotationCounter;
        public static /* synthetic */ float lastRenderPacketYaw;
        public static /* synthetic */ boolean isAiming;

        public Rotation() {
            Rotation llIlllIlIlIll;
        }

        static {
            isReady = false;
        }
    }
}

