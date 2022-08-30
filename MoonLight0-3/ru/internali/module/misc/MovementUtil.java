/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.MobEffects
 *  net.minecraft.potion.Potion
 *  net.minecraft.util.math.AxisAlignedBB
 */
package ru.internali.module.misc;

import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.util.math.AxisAlignedBB;

public class MovementUtil {
    public static final /* synthetic */ double WALK_SPEED = 0.221;
    public static /* synthetic */ Minecraft mc;

    public static float getDirection() {
        float llIlIIIlIlllIII = MovementUtil.mc.player.field_70177_z;
        if (MovementUtil.mc.player.field_191988_bg < 0.0f) {
            llIlIIIlIlllIII += 180.0f;
        }
        float llIlIIIlIllIlll = 1.0f;
        if (MovementUtil.mc.player.field_191988_bg < 0.0f) {
            llIlIIIlIllIlll = -0.5f;
        } else if (MovementUtil.mc.player.field_191988_bg > 0.0f) {
            llIlIIIlIllIlll = 0.5f;
        }
        if (MovementUtil.mc.player.field_70702_br > 0.0f) {
            llIlIIIlIlllIII -= 90.0f * llIlIIIlIllIlll;
        }
        if (MovementUtil.mc.player.field_70702_br < 0.0f) {
            llIlIIIlIlllIII += 90.0f * llIlIIIlIllIlll;
        }
        return llIlIIIlIlllIII *= (float)Math.PI / 180;
    }

    public static double getSpeed() {
        return MovementUtil.getSpeed(false, 0.2873);
    }

    static {
        mc = Minecraft.getMinecraft();
    }

    public static float getRoundedStrafing() {
        return MovementUtil.getRoundedMovementInput(MovementUtil.mc.player.movementInput.moveStrafe);
    }

    public static double getMotion(EntityPlayer llIlIIIlllllllI) {
        return Math.abs(llIlIIIlllllllI.field_70159_w) + Math.abs(llIlIIIlllllllI.field_70179_y);
    }

    public MovementUtil() {
        MovementUtil llIlIIlIIIlIlII;
    }

    public static void setMotion(double llIlIIlIIIIlllI) {
        double llIlIIlIIIIllIl = MovementUtil.mc.player.movementInput.moveForward;
        double llIlIIlIIIIllII = MovementUtil.mc.player.movementInput.moveStrafe;
        float llIlIIlIIIIlIll = MovementUtil.mc.player.field_70177_z;
        if (llIlIIlIIIIllIl == 0.0 && llIlIIlIIIIllII == 0.0) {
            MovementUtil.mc.player.field_70159_w = 0.0;
            MovementUtil.mc.player.field_70179_y = 0.0;
        } else {
            if (llIlIIlIIIIllIl != 0.0) {
                if (llIlIIlIIIIllII > 0.0) {
                    llIlIIlIIIIlIll += (float)(llIlIIlIIIIllIl > 0.0 ? -45 : 45);
                } else if (llIlIIlIIIIllII < 0.0) {
                    llIlIIlIIIIlIll += (float)(llIlIIlIIIIllIl > 0.0 ? 45 : -45);
                }
                llIlIIlIIIIllII = 0.0;
                if (llIlIIlIIIIllIl > 0.0) {
                    llIlIIlIIIIllIl = 1.0;
                } else if (llIlIIlIIIIllIl < 0.0) {
                    llIlIIlIIIIllIl = -1.0;
                }
            }
            MovementUtil.mc.player.field_70159_w = llIlIIlIIIIllIl * llIlIIlIIIIlllI * Math.cos(Math.toRadians(llIlIIlIIIIlIll + 90.0f)) + llIlIIlIIIIllII * llIlIIlIIIIlllI * Math.sin(Math.toRadians(llIlIIlIIIIlIll + 90.0f));
            MovementUtil.mc.player.field_70179_y = llIlIIlIIIIllIl * llIlIIlIIIIlllI * Math.sin(Math.toRadians(llIlIIlIIIIlIll + 90.0f)) - llIlIIlIIIIllII * llIlIIlIIIIlllI * Math.cos(Math.toRadians(llIlIIlIIIIlIll + 90.0f));
        }
    }

    public static float calcMoveYaw(float llIlIIIlIIllIIl) {
        float llIlIIIlIlIIIIl = MovementUtil.getRoundedForward();
        float llIlIIIlIlIIIII = MovementUtil.getRoundedStrafing();
        float llIlIIIlIIlllll = llIlIIIlIIllIIl;
        float llIlIIIlIIllllI = 90.0f * llIlIIIlIlIIIII;
        float llIlIIIlIIlllIl = llIlIIIlIIlllll - (llIlIIIlIIllllI *= llIlIIIlIlIIIIl != 0.0f ? llIlIIIlIlIIIIl * 0.5f : 1.0f);
        llIlIIIlIIlllIl -= (float)(llIlIIIlIlIIIIl < 0.0f ? 180 : 0);
        llIlIIIlIIlllIl = (float)Math.toRadians(llIlIIIlIIlllIl);
        float llIlIIIlIIlllII = MovementUtil.mc.gameSettings.mouseSensitivity / 0.005f;
        float llIlIIIlIIllIll = 0.005f * llIlIIIlIIlllII;
        float llIlIIIlIIllIlI = llIlIIIlIIllIll * llIlIIIlIIllIll * llIlIIIlIIllIll * 1.2f;
        llIlIIIlIIlllIl -= llIlIIIlIIlllIl % llIlIIIlIIllIlI;
        return llIlIIIlIIlllIl;
    }

    public static double getJumpSpeed() {
        double llIlIIIllIIllll = 0.0;
        if (MovementUtil.mc.player.func_70644_a(MobEffects.JUMP_BOOST)) {
            int llIlIIIllIlIIII = MovementUtil.mc.player.func_70660_b(MobEffects.JUMP_BOOST).getAmplifier();
            llIlIIIllIIllll += (double)(llIlIIIllIlIIII + 1) * 0.1;
        }
        return llIlIIIllIIllll;
    }

    private static final float getRoundedMovementInput(float llIlIIIlIlIllIl) {
        return llIlIIIlIlIllIl > 0.0f ? 1.0f : (llIlIIIlIlIllIl < 0.0f ? -1.0f : 0.0f);
    }

    public static double getSpeed(boolean llIlIIIllIlIlIl, double llIlIIIllIlIllI) {
        if (MovementUtil.mc.player.func_70644_a(MobEffects.SPEED)) {
            int llIlIIIllIllIIl = Objects.requireNonNull(MovementUtil.mc.player.func_70660_b(MobEffects.SPEED)).getAmplifier();
            llIlIIIllIlIllI *= 1.0 + 0.2 * (double)(llIlIIIllIllIIl + 1);
        }
        if (llIlIIIllIlIlIl && MovementUtil.mc.player.func_70644_a(MobEffects.SLOWNESS)) {
            int llIlIIIllIllIII = Objects.requireNonNull(MovementUtil.mc.player.func_70660_b(MobEffects.SLOWNESS)).getAmplifier();
            llIlIIIllIlIllI /= 1.0 + 0.2 * (double)(llIlIIIllIllIII + 1);
        }
        return llIlIIIllIlIllI;
    }

    public static boolean isBlockAboveHead() {
        AxisAlignedBB llIlIIIlllIIlII = new AxisAlignedBB(MovementUtil.mc.player.field_70165_t - 0.3, MovementUtil.mc.player.field_70163_u + (double)MovementUtil.mc.player.func_70047_e(), MovementUtil.mc.player.field_70161_v + 0.3, MovementUtil.mc.player.field_70165_t + 0.3, MovementUtil.mc.player.field_70163_u + 2.5, MovementUtil.mc.player.field_70161_v - 0.3);
        return !MovementUtil.mc.world.func_184144_a((Entity)MovementUtil.mc.player, llIlIIIlllIIlII).isEmpty();
    }

    public static boolean isMoving() {
        if (MovementUtil.mc.player == null) {
            return false;
        }
        if (MovementUtil.mc.player.movementInput.moveForward != 0.0f) {
            return true;
        }
        return MovementUtil.mc.player.movementInput.moveStrafe != 0.0f;
    }

    public static float getDirection2() {
        float llIlIIlIIIIIlII = MovementUtil.mc.player.field_70177_z;
        if (MovementUtil.mc.player.field_191988_bg < 0.0f) {
            llIlIIlIIIIIlII += 180.0f;
        }
        float llIlIIlIIIIIIll = 1.0f;
        if (MovementUtil.mc.player.field_191988_bg < 0.0f) {
            llIlIIlIIIIIIll = -0.5f;
        } else if (MovementUtil.mc.player.field_191988_bg > 0.0f) {
            llIlIIlIIIIIIll = 0.5f;
        }
        if (MovementUtil.mc.player.field_70702_br > 0.0f) {
            llIlIIlIIIIIlII -= 90.0f * llIlIIlIIIIIIll;
        }
        if (MovementUtil.mc.player.field_70702_br < 0.0f) {
            llIlIIlIIIIIlII += 90.0f * llIlIIlIIIIIIll;
        }
        return llIlIIlIIIIIlII *= (float)Math.PI / 180;
    }

    public static void strafe(float llIlIIIllIIlIII, double llIlIIIllIIIlll) {
        if (!MovementUtil.isMoving()) {
            return;
        }
        MovementUtil.mc.player.field_70159_w = -Math.sin(llIlIIIllIIlIII) * llIlIIIllIIIlll;
        MovementUtil.mc.player.field_70179_y = Math.cos(llIlIIIllIIlIII) * llIlIIIllIIIlll;
    }

    public static double getDistance2D() {
        double llIlIIIllIIIlII = MovementUtil.mc.player.field_70165_t - MovementUtil.mc.player.field_70169_q;
        double llIlIIIllIIIIll = MovementUtil.mc.player.field_70161_v - MovementUtil.mc.player.field_70166_s;
        return Math.sqrt(llIlIIIllIIIlII * llIlIIIllIIIlII + llIlIIIllIIIIll * llIlIIIllIIIIll);
    }

    public static float getRoundedForward() {
        return MovementUtil.getRoundedMovementInput(MovementUtil.mc.player.movementInput.moveForward);
    }

    public static double[] forward(double llIlIIIlllIllIl) {
        float llIlIIIllllIlII = Minecraft.getMinecraft().player.movementInput.moveForward;
        float llIlIIIllllIIll = Minecraft.getMinecraft().player.movementInput.moveStrafe;
        float llIlIIIllllIIlI = Minecraft.getMinecraft().player.field_70126_B + (Minecraft.getMinecraft().player.field_70177_z - Minecraft.getMinecraft().player.field_70126_B) * Minecraft.getMinecraft().getRenderPartialTicks();
        if (llIlIIIllllIlII != 0.0f) {
            if (llIlIIIllllIIll > 0.0f) {
                llIlIIIllllIIlI += (float)(llIlIIIllllIlII > 0.0f ? -45 : 45);
            } else if (llIlIIIllllIIll < 0.0f) {
                llIlIIIllllIIlI += (float)(llIlIIIllllIlII > 0.0f ? 45 : -45);
            }
            llIlIIIllllIIll = 0.0f;
            if (llIlIIIllllIlII > 0.0f) {
                llIlIIIllllIlII = 1.0f;
            } else if (llIlIIIllllIlII < 0.0f) {
                llIlIIIllllIlII = -1.0f;
            }
        }
        double llIlIIIllllIIIl = Math.sin(Math.toRadians(llIlIIIllllIIlI + 90.0f));
        double llIlIIIllllIIII = Math.cos(Math.toRadians(llIlIIIllllIIlI + 90.0f));
        double llIlIIIlllIllll = (double)llIlIIIllllIlII * llIlIIIlllIllIl * llIlIIIllllIIII + (double)llIlIIIllllIIll * llIlIIIlllIllIl * llIlIIIllllIIIl;
        double llIlIIIlllIlllI = (double)llIlIIIllllIlII * llIlIIIlllIllIl * llIlIIIllllIIIl - (double)llIlIIIllllIIll * llIlIIIlllIllIl * llIlIIIllllIIII;
        return new double[]{llIlIIIlllIllll, llIlIIIlllIlllI};
    }

    public static double getBaseMoveSpeed() {
        double llIlIIIllIlllll = 0.2873;
        if (MovementUtil.mc.player != null && MovementUtil.mc.player.func_70644_a(Objects.requireNonNull(Potion.getPotionById((int)1)))) {
            int llIlIIIlllIIIII = Objects.requireNonNull(MovementUtil.mc.player.func_70660_b(Objects.requireNonNull(Potion.getPotionById((int)1)))).getAmplifier();
            llIlIIIllIlllll *= 1.0 + 0.2 * (double)(llIlIIIlllIIIII + 1);
        }
        return llIlIIIllIlllll;
    }

    public static void strafe(float llIlIIIlIllllII) {
        if (!MovementUtil.isMoving()) {
            return;
        }
        double llIlIIIlIllllIl = MovementUtil.getDirection();
        MovementUtil.mc.player.field_70159_w = -Math.sin(llIlIIIlIllllIl) * (double)llIlIIIlIllllII;
        MovementUtil.mc.player.field_70179_y = Math.cos(llIlIIIlIllllIl) * (double)llIlIIIlIllllII;
    }

    public static void hClip(double llIlIIIlIllIIlI) {
        double llIlIIIlIllIIIl = Math.toRadians(MovementUtil.mc.player.field_70177_z);
        MovementUtil.mc.player.func_70107_b(MovementUtil.mc.player.field_70165_t + -Math.sin(llIlIIIlIllIIIl) * llIlIIIlIllIIlI, MovementUtil.mc.player.field_70163_u, MovementUtil.mc.player.field_70161_v + Math.cos(llIlIIIlIllIIIl) * llIlIIIlIllIIlI);
    }
}

