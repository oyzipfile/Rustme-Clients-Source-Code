/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 */
package ru.internali.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import ru.internali.utils.EventPlayerState;
import ru.internali.utils.EventSendPacket;
import ru.internali.utils.EventTarget;
import ru.internali.utils.GCDCalcHelper;
import ru.internali.utils.Helper;
import ru.internali.utils.MathematicHelper;
import ru.internali.utils.MinecraftHelper;
import ru.internali.utils.MovementHelper;

public class RotationHelper
implements Helper {
    public static float[] getRotationVector(Vec3d lIlIIlIIIllIlI, boolean lIlIIlIIIllIIl, float lIlIIlIIIllIII, float lIlIIlIIIlIlll, float lIlIIlIIIlIllI) {
        Vec3d lIlIIlIIIlIlIl = RotationHelper.getEyesPos();
        double lIlIIlIIIlIlII = lIlIIlIIIllIlI.x - lIlIIlIIIlIlIl.x;
        double lIlIIlIIIlIIll = lIlIIlIIIllIlI.y - (MinecraftHelper.mc.player.field_70163_u + (double)MinecraftHelper.mc.player.func_70047_e() + 0.5);
        double lIlIIlIIIlIIlI = lIlIIlIIIllIlI.z - lIlIIlIIIlIlIl.z;
        double lIlIIlIIIlIIIl = Math.sqrt(lIlIIlIIIlIlII * lIlIIlIIIlIlII + lIlIIlIIIlIIlI * lIlIIlIIIlIIlI);
        float lIlIIlIIIlIIII = 0.0f;
        if (lIlIIlIIIllIIl) {
            lIlIIlIIIlIIII = MathematicHelper.randomizeFloat(-lIlIIlIIIllIII, lIlIIlIIIllIII);
        }
        float lIlIIlIIIIllll = 0.0f;
        if (lIlIIlIIIllIIl) {
            lIlIIlIIIIllll = MathematicHelper.randomizeFloat(-lIlIIlIIIlIlll, lIlIIlIIIlIlll);
        }
        float lIlIIlIIIIlllI = (float)(Math.toDegrees(Math.atan2(lIlIIlIIIlIIlI, lIlIIlIIIlIlII)) - 90.0) + lIlIIlIIIlIIII;
        float lIlIIlIIIIllIl = (float)(-Math.toDegrees(Math.atan2(lIlIIlIIIlIIll, lIlIIlIIIlIIIl))) + lIlIIlIIIIllll;
        lIlIIlIIIIlllI = MinecraftHelper.mc.player.field_70177_z + GCDCalcHelper.getFixedRotation(MathHelper.wrapDegrees((float)(lIlIIlIIIIlllI - MinecraftHelper.mc.player.field_70177_z)));
        lIlIIlIIIIllIl = MinecraftHelper.mc.player.field_70125_A + GCDCalcHelper.getFixedRotation(MathHelper.wrapDegrees((float)(lIlIIlIIIIllIl - MinecraftHelper.mc.player.field_70125_A)));
        lIlIIlIIIIllIl = MathHelper.clamp((float)lIlIIlIIIIllIl, (float)-90.0f, (float)90.0f);
        lIlIIlIIIIlllI = RotationHelper.updateRotation(MinecraftHelper.mc.player.field_70177_z, lIlIIlIIIIlllI, lIlIIlIIIlIllI);
        lIlIIlIIIIllIl = RotationHelper.updateRotation(MinecraftHelper.mc.player.field_70125_A, lIlIIlIIIIllIl, lIlIIlIIIlIllI);
        return new float[]{lIlIIlIIIIlllI, lIlIIlIIIIllIl};
    }

    public static float getAngleEntity(Entity lIlIIIlllllIIl) {
        float lIlIIIlllllIII = MinecraftHelper.mc.player.field_70177_z;
        double lIlIIIllllIlll = lIlIIIlllllIIl.posX - MinecraftHelper.mc.player.field_70165_t;
        double lIlIIIllllIllI = lIlIIIlllllIIl.posZ - MinecraftHelper.mc.player.field_70161_v;
        float lIlIIIllllIlIl = (float)(Math.atan2(lIlIIIllllIllI, lIlIIIllllIlll) * 180.0 / Math.PI - 90.0);
        return lIlIIIlllllIII + MathHelper.wrapDegrees((float)(lIlIIIllllIlIl - lIlIIIlllllIII));
    }

    public static float[] getFacePosRemote(EntityLivingBase lIlIIIlllIIIlI, Entity lIlIIIlllIIIIl, boolean lIlIIIlllIIIII) {
        Vec3d lIlIIIllIlllll = new Vec3d(lIlIIIlllIIIlI.field_70165_t, lIlIIIlllIIIlI.field_70163_u, lIlIIIlllIIIlI.field_70161_v);
        Vec3d lIlIIIllIllllI = new Vec3d(lIlIIIlllIIIIl.posX, lIlIIIlllIIIIl.posY, lIlIIIlllIIIIl.posZ);
        double lIlIIIllIlllIl = lIlIIIllIllllI.x - lIlIIIllIlllll.x;
        double lIlIIIllIlllII = lIlIIIllIllllI.y - lIlIIIllIlllll.y;
        double lIlIIIllIllIll = lIlIIIllIllllI.z - lIlIIIllIlllll.z;
        float lIlIIIllIllIlI = 0.0f;
        if (lIlIIIlllIIIII) {
            lIlIIIllIllIlI = MathematicHelper.randomizeFloat(-2.0f, 2.0f);
        }
        float lIlIIIllIllIIl = 0.0f;
        if (lIlIIIlllIIIII) {
            lIlIIIllIllIIl = MathematicHelper.randomizeFloat(-2.0f, 2.0f);
        }
        double lIlIIIllIllIII = MathHelper.sqrt((double)(lIlIIIllIlllIl * lIlIIIllIlllIl + lIlIIIllIllIll * lIlIIIllIllIll));
        float lIlIIIllIlIlll = (float)(Math.atan2(lIlIIIllIllIll, lIlIIIllIlllIl) * 180.0 / Math.PI) - 90.0f + lIlIIIllIllIlI;
        float lIlIIIllIlIllI = (float)(-(Math.atan2(lIlIIIllIlllII, lIlIIIllIllIII) * 180.0 / Math.PI)) + lIlIIIllIllIIl;
        return new float[]{MathHelper.wrapDegrees((float)lIlIIIllIlIlll), MathHelper.wrapDegrees((float)lIlIIIllIlIllI)};
    }

    public RotationHelper() {
        RotationHelper lIlIIlIIlIlIlI;
    }

    @Override
    public Minecraft mc() {
        return null;
    }

    public static Vec3d getEyesPos() {
        return new Vec3d(MinecraftHelper.mc.player.field_70165_t, MinecraftHelper.mc.player.func_174813_aQ().minY + (double)MinecraftHelper.mc.player.func_70047_e(), MinecraftHelper.mc.player.field_70161_v);
    }

    public static float updateRotation(float lIlIIIllIIIIII, float lIlIIIllIIIIll, float lIlIIIllIIIIlI) {
        float lIlIIIllIIIIIl = MathHelper.wrapDegrees((float)(lIlIIIllIIIIll - lIlIIIllIIIIII));
        if (lIlIIIllIIIIIl > lIlIIIllIIIIlI) {
            lIlIIIllIIIIIl = lIlIIIllIIIIlI;
        }
        if (lIlIIIllIIIIIl < -lIlIIIllIIIIlI) {
            lIlIIIllIIIIIl = -lIlIIIllIIIIlI;
        }
        return lIlIIIllIIIIII + lIlIIIllIIIIIl;
    }

    public static class Rotation {
        public static /* synthetic */ float lastRenderPacketYaw;
        public static /* synthetic */ float lastPacketPitch;
        public static /* synthetic */ float renderPacketYaw;
        public static /* synthetic */ int rotationCounter;
        public static /* synthetic */ boolean isAiming;
        public static /* synthetic */ boolean isReady;
        public static /* synthetic */ float packetPitch;
        public static /* synthetic */ float lastBodyYaw;
        public static /* synthetic */ float bodyYaw;
        public static /* synthetic */ float lastPacketYaw;
        public static /* synthetic */ float packetYaw;

        static {
            isReady = false;
        }

        public Rotation() {
            Rotation lIIIIlIIllIllII;
        }

        public static double calcMove() {
            double lIIIIlIIllIlIII = MinecraftHelper.mc.player.field_70165_t - MinecraftHelper.mc.player.field_70169_q;
            double lIIIIlIIllIIlll = MinecraftHelper.mc.player.field_70161_v - MinecraftHelper.mc.player.field_70166_s;
            return Math.hypot(lIIIIlIIllIlIII, lIIIIlIIllIIlll);
        }

        public static boolean isAiming() {
            return !isAiming;
        }

        @EventTarget
        public void onSendPacket(EventSendPacket lIIIIlIIlIllllI) {
            if (lIIIIlIIlIllllI.getPacket() instanceof CPacketAnimation) {
                rotationCounter = 10;
            }
        }

        @EventTarget
        public void onPlayerState(EventPlayerState lIIIIlIIllIIIlI) {
            if (Rotation.isAiming() && lIIIIlIIllIIIlI.isPre()) {
                isReady = true;
            } else if (Rotation.isAiming() && isReady && lIIIIlIIllIIIlI.isPost()) {
                packetPitch = MinecraftHelper.mc.player.field_70125_A;
                packetYaw = MinecraftHelper.mc.player.field_70177_z;
                lastPacketPitch = MinecraftHelper.mc.player.field_70125_A;
                lastPacketYaw = MinecraftHelper.mc.player.field_70177_z;
                bodyYaw = MinecraftHelper.mc.player.field_70761_aq;
                isReady = false;
            } else {
                isReady = false;
            }
            if (lIIIIlIIllIIIlI.isPre()) {
                lastBodyYaw = bodyYaw;
                lastPacketPitch = packetPitch;
                lastPacketYaw = packetYaw;
                bodyYaw = MathematicHelper.clamp(bodyYaw, packetYaw, 50.0f);
                if (Rotation.calcMove() > 2.500000277905201E-7) {
                    bodyYaw = MathematicHelper.clamp(MovementHelper.getMoveDirection(), packetYaw, 50.0f);
                    rotationCounter = 0;
                } else if (rotationCounter > 0) {
                    --rotationCounter;
                    bodyYaw = MathematicHelper.checkAngle(packetYaw, bodyYaw, 10.0f);
                }
                lastRenderPacketYaw = renderPacketYaw;
                renderPacketYaw = packetYaw;
            }
        }
    }
}

