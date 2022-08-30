/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.MobEffects
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.MathHelper
 */
package ru.internali.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.init.MobEffects;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import ru.internali.utils.EventMove;
import ru.internali.utils.EventStrafe;
import ru.internali.utils.Helper;
import ru.internali.utils.MinecraftHelper;

public class MovementHelper
implements Helper {
    public static float getSpeed() {
        return (float)Math.sqrt(MinecraftHelper.mc.player.field_70159_w * MinecraftHelper.mc.player.field_70159_w + MinecraftHelper.mc.player.field_70179_y * MinecraftHelper.mc.player.field_70179_y);
    }

    public static boolean isBlockAboveHead() {
        AxisAlignedBB lIIlIIllIIlIlI = new AxisAlignedBB(MinecraftHelper.mc.player.field_70165_t - 0.3, MinecraftHelper.mc.player.field_70163_u + (double)MinecraftHelper.mc.player.func_70047_e(), MinecraftHelper.mc.player.field_70161_v + 0.3, MinecraftHelper.mc.player.field_70165_t + 0.3, MinecraftHelper.mc.player.field_70163_u + (!MinecraftHelper.mc.player.field_70122_E ? 1.5 : 2.5), MinecraftHelper.mc.player.field_70161_v - 0.3);
        return MinecraftHelper.mc.world.func_184144_a((Entity)MinecraftHelper.mc.player, lIIlIIllIIlIlI).isEmpty();
    }

    public static void calculateSilentMove(EventStrafe lIIlIIlIlllIll, float lIIlIIlIllIIIl) {
        float lIIlIIlIllIIll;
        float lIIlIIlIlllIIl = lIIlIIlIlllIll.getStrafe();
        float lIIlIIlIlllIII = lIIlIIlIlllIll.getForward();
        float lIIlIIlIllIlll = lIIlIIlIlllIll.getFriction();
        int lIIlIIlIllIllI = (int)((MathHelper.wrapDegrees((float)(MinecraftHelper.mc.player.field_70177_z - lIIlIIlIllIIIl - 23.5f - 135.0f)) + 180.0f) / 45.0f);
        float lIIlIIlIllIlIl = 0.0f;
        float lIIlIIlIllIlII = 0.0f;
        switch (lIIlIIlIllIllI) {
            case 0: {
                lIIlIIlIllIlIl = lIIlIIlIlllIII;
                lIIlIIlIllIlII = lIIlIIlIlllIIl;
                break;
            }
            case 1: {
                lIIlIIlIllIlIl += lIIlIIlIlllIII;
                lIIlIIlIllIlII -= lIIlIIlIlllIII;
                lIIlIIlIllIlIl += lIIlIIlIlllIIl;
                lIIlIIlIllIlII += lIIlIIlIlllIIl;
                break;
            }
            case 2: {
                lIIlIIlIllIlIl = lIIlIIlIlllIIl;
                lIIlIIlIllIlII = -lIIlIIlIlllIII;
                break;
            }
            case 3: {
                lIIlIIlIllIlIl -= lIIlIIlIlllIII;
                lIIlIIlIllIlII -= lIIlIIlIlllIII;
                lIIlIIlIllIlIl += lIIlIIlIlllIIl;
                lIIlIIlIllIlII -= lIIlIIlIlllIIl;
                break;
            }
            case 4: {
                lIIlIIlIllIlIl = -lIIlIIlIlllIII;
                lIIlIIlIllIlII = -lIIlIIlIlllIIl;
                break;
            }
            case 5: {
                lIIlIIlIllIlIl -= lIIlIIlIlllIII;
                lIIlIIlIllIlII += lIIlIIlIlllIII;
                lIIlIIlIllIlIl -= lIIlIIlIlllIIl;
                lIIlIIlIllIlII -= lIIlIIlIlllIIl;
                break;
            }
            case 6: {
                lIIlIIlIllIlIl = -lIIlIIlIlllIIl;
                lIIlIIlIllIlII = lIIlIIlIlllIII;
                break;
            }
            case 7: {
                lIIlIIlIllIlIl += lIIlIIlIlllIII;
                lIIlIIlIllIlII += lIIlIIlIlllIII;
                lIIlIIlIllIlIl -= lIIlIIlIlllIIl;
                lIIlIIlIllIlII += lIIlIIlIlllIIl;
            }
        }
        if (lIIlIIlIllIlIl > 1.0f || lIIlIIlIllIlIl < 0.9f && lIIlIIlIllIlIl > 0.3f || lIIlIIlIllIlIl < -1.0f || lIIlIIlIllIlIl > -0.9f && lIIlIIlIllIlIl < -0.3f) {
            lIIlIIlIllIlIl *= 0.5f;
        }
        if (lIIlIIlIllIlII > 1.0f || lIIlIIlIllIlII < 0.9f && lIIlIIlIllIlII > 0.3f || lIIlIIlIllIlII < -1.0f || lIIlIIlIllIlII > -0.9f && lIIlIIlIllIlII < -0.3f) {
            lIIlIIlIllIlII *= 0.5f;
        }
        if ((lIIlIIlIllIIll = lIIlIIlIllIlII * lIIlIIlIllIlII + lIIlIIlIllIlIl * lIIlIIlIllIlIl) >= 1.0E-4f) {
            lIIlIIlIllIIll = (float)((double)lIIlIIlIllIlll / Math.max(1.0, Math.sqrt(lIIlIIlIllIIll)));
            float lIIlIIlIllllIl = MathHelper.sin((float)((float)((double)lIIlIIlIllIIIl * Math.PI / 180.0)));
            float lIIlIIlIllllII = MathHelper.cos((float)((float)((double)lIIlIIlIllIIIl * Math.PI / 180.0)));
            MinecraftHelper.mc.player.field_70159_w += (double)((lIIlIIlIllIlII *= lIIlIIlIllIIll) * lIIlIIlIllllII - (lIIlIIlIllIlIl *= lIIlIIlIllIIll) * lIIlIIlIllllIl);
            MinecraftHelper.mc.player.field_70179_y += (double)(lIIlIIlIllIlIl * lIIlIIlIllllII + lIIlIIlIllIlII * lIIlIIlIllllIl);
        }
    }

    public static int getSpeedEffect() {
        if (MinecraftHelper.mc.player.func_70644_a(MobEffects.SPEED)) {
            return MinecraftHelper.mc.player.func_70660_b(MobEffects.SPEED).getAmplifier() + 1;
        }
        return 0;
    }

    public static double getDirectionAll() {
        float lIIlIIlIIIlIlI = MinecraftHelper.mc.player.field_70177_z;
        float lIIlIIlIIIlIIl = 1.0f;
        if (MinecraftHelper.mc.player.field_191988_bg < 0.0f) {
            lIIlIIlIIIlIlI += 180.0f;
        }
        if (MinecraftHelper.mc.player.field_191988_bg < 0.0f) {
            lIIlIIlIIIlIIl = -0.5f;
        } else if (MinecraftHelper.mc.player.field_191988_bg > 0.0f) {
            lIIlIIlIIIlIIl = 0.5f;
        }
        if (MinecraftHelper.mc.player.field_70702_br > 0.0f) {
            lIIlIIlIIIlIlI -= 90.0f * lIIlIIlIIIlIIl;
        }
        if (MinecraftHelper.mc.player.field_70702_br < 0.0f) {
            lIIlIIlIIIlIlI += 90.0f * lIIlIIlIIIlIIl;
        }
        return Math.toRadians(lIIlIIlIIIlIlI);
    }

    public static boolean isMoving() {
        return MinecraftHelper.mc.player.movementInput.moveForward != 0.0f || MinecraftHelper.mc.player.movementInput.moveStrafe != 0.0f;
    }

    public MovementHelper() {
        MovementHelper lIIlIIllIllIll;
    }

    public static void setEventSpeed(EventMove lIIlIIlIIlllIl, double lIIlIIlIIlllII) {
        double lIIlIIlIlIIIII = MinecraftHelper.mc.player.movementInput.moveForward;
        double lIIlIIlIIlllll = MinecraftHelper.mc.player.movementInput.moveStrafe;
        float lIIlIIlIIllllI = MinecraftHelper.mc.player.field_70177_z;
        if (lIIlIIlIlIIIII == 0.0 && lIIlIIlIIlllll == 0.0) {
            lIIlIIlIIlllIl.setX(0.0);
            lIIlIIlIIlllIl.setZ(0.0);
        } else {
            if (lIIlIIlIlIIIII != 0.0) {
                if (lIIlIIlIIlllll > 0.0) {
                    lIIlIIlIIllllI += (float)(lIIlIIlIlIIIII > 0.0 ? -45 : 45);
                } else if (lIIlIIlIIlllll < 0.0) {
                    lIIlIIlIIllllI += (float)(lIIlIIlIlIIIII > 0.0 ? 45 : -45);
                }
                lIIlIIlIIlllll = 0.0;
                if (lIIlIIlIlIIIII > 0.0) {
                    lIIlIIlIlIIIII = 1.0;
                } else if (lIIlIIlIlIIIII < 0.0) {
                    lIIlIIlIlIIIII = -1.0;
                }
            }
            lIIlIIlIIlllIl.setX(lIIlIIlIlIIIII * lIIlIIlIIlllII * Math.cos(Math.toRadians(lIIlIIlIIllllI + 90.0f)) + lIIlIIlIIlllll * lIIlIIlIIlllII * Math.sin(Math.toRadians(lIIlIIlIIllllI + 90.0f)));
            lIIlIIlIIlllIl.setZ(lIIlIIlIlIIIII * lIIlIIlIIlllII * Math.sin(Math.toRadians(lIIlIIlIIllllI + 90.0f)) - lIIlIIlIIlllll * lIIlIIlIIlllII * Math.cos(Math.toRadians(lIIlIIlIIllllI + 90.0f)));
        }
    }

    @Override
    public Minecraft mc() {
        return null;
    }

    public static float getMoveDirection() {
        double lIIlIIllIlIIIl = MinecraftHelper.mc.player.field_70159_w;
        double lIIlIIllIlIIII = MinecraftHelper.mc.player.field_70179_y;
        float lIIlIIllIIllll = (float)(Math.atan2(lIIlIIllIlIIIl, lIIlIIllIlIIII) / Math.PI * 180.0);
        return -lIIlIIllIIllll;
    }

    public static void setSpeed(float lIIlIIlIIlIIII) {
        float lIIlIIlIIlIIll = MinecraftHelper.mc.player.field_70177_z;
        float lIIlIIlIIlIIlI = MinecraftHelper.mc.player.movementInput.moveForward;
        float lIIlIIlIIlIIIl = MinecraftHelper.mc.player.movementInput.moveStrafe;
        if (lIIlIIlIIlIIlI != 0.0f) {
            if (lIIlIIlIIlIIIl > 0.0f) {
                lIIlIIlIIlIIll += (float)(lIIlIIlIIlIIlI > 0.0f ? -45 : 45);
            } else if (lIIlIIlIIlIIIl < 0.0f) {
                lIIlIIlIIlIIll += (float)(lIIlIIlIIlIIlI > 0.0f ? 45 : -45);
            }
            lIIlIIlIIlIIIl = 0.0f;
            if (lIIlIIlIIlIIlI > 0.0f) {
                lIIlIIlIIlIIlI = 1.0f;
            } else if (lIIlIIlIIlIIlI < 0.0f) {
                lIIlIIlIIlIIlI = -1.0f;
            }
        }
        MinecraftHelper.mc.player.field_70159_w = (double)(lIIlIIlIIlIIlI * lIIlIIlIIlIIII) * Math.cos(Math.toRadians(lIIlIIlIIlIIll + 90.0f)) + (double)(lIIlIIlIIlIIIl * lIIlIIlIIlIIII) * Math.sin(Math.toRadians(lIIlIIlIIlIIll + 90.0f));
        MinecraftHelper.mc.player.field_70179_y = (double)(lIIlIIlIIlIIlI * lIIlIIlIIlIIII) * Math.sin(Math.toRadians(lIIlIIlIIlIIll + 90.0f)) - (double)(lIIlIIlIIlIIIl * lIIlIIlIIlIIII) * Math.cos(Math.toRadians(lIIlIIlIIlIIll + 90.0f));
    }

    public static float getBaseMoveSpeed() {
        float lIIlIIllIlIlll = 0.2873f;
        if (MinecraftHelper.mc.player != null && MinecraftHelper.mc.player.func_70644_a(MobEffects.SPEED)) {
            int lIIlIIllIllIII = MinecraftHelper.mc.player.func_70660_b(MobEffects.SPEED).getAmplifier();
            lIIlIIllIlIlll = (float)((double)lIIlIIllIlIlll * (1.0 + 0.2 * (double)(lIIlIIllIllIII + 1)));
        }
        return lIIlIIllIlIlll;
    }

    public static void strafePlayer(float lIIlIIlIIIIIII) {
        double lIIlIIlIIIIIlI = MovementHelper.getDirectionAll();
        float lIIlIIlIIIIIIl = lIIlIIlIIIIIII == 0.0f ? MovementHelper.getSpeed() : lIIlIIlIIIIIII;
        MinecraftHelper.mc.player.field_70159_w = -Math.sin(lIIlIIlIIIIIlI) * (double)lIIlIIlIIIIIIl;
        MinecraftHelper.mc.player.field_70179_y = Math.cos(lIIlIIlIIIIIlI) * (double)lIIlIIlIIIIIIl;
    }
}

