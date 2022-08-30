/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Vec3d
 *  org.lwjgl.opengl.GL11
 */
package ru.internali.utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

public class MathUtils {
    public static final /* synthetic */ float deg2Rad = (float)Math.PI / 180;
    private static final /* synthetic */ Random random;

    public static double[] directionSpeedNoForward(double llIIIIIlllllll) {
        Minecraft llIIIIlIIIIlll = Minecraft.getMinecraft();
        float llIIIIlIIIIllI = 1.0f;
        if (llIIIIlIIIIlll.gameSettings.keyBindLeft.isPressed() || llIIIIlIIIIlll.gameSettings.keyBindRight.isPressed() || llIIIIlIIIIlll.gameSettings.keyBindBack.isPressed() || llIIIIlIIIIlll.gameSettings.keyBindForward.isPressed()) {
            llIIIIlIIIIllI = llIIIIlIIIIlll.player.movementInput.moveForward;
        }
        float llIIIIlIIIIlIl = llIIIIlIIIIlll.player.movementInput.moveStrafe;
        float llIIIIlIIIIlII = llIIIIlIIIIlll.player.field_70126_B + (llIIIIlIIIIlll.player.field_70177_z - llIIIIlIIIIlll.player.field_70126_B) * llIIIIlIIIIlll.getRenderPartialTicks();
        if (llIIIIlIIIIllI != 0.0f) {
            if (llIIIIlIIIIlIl > 0.0f) {
                llIIIIlIIIIlII += (float)(llIIIIlIIIIllI > 0.0f ? -45 : 45);
            } else if (llIIIIlIIIIlIl < 0.0f) {
                llIIIIlIIIIlII += (float)(llIIIIlIIIIllI > 0.0f ? 45 : -45);
            }
            llIIIIlIIIIlIl = 0.0f;
            if (llIIIIlIIIIllI > 0.0f) {
                llIIIIlIIIIllI = 1.0f;
            } else if (llIIIIlIIIIllI < 0.0f) {
                llIIIIlIIIIllI = -1.0f;
            }
        }
        double llIIIIlIIIIIll = Math.sin(Math.toRadians(llIIIIlIIIIlII + 90.0f));
        double llIIIIlIIIIIlI = Math.cos(Math.toRadians(llIIIIlIIIIlII + 90.0f));
        double llIIIIlIIIIIIl = (double)llIIIIlIIIIllI * llIIIIIlllllll * llIIIIlIIIIIlI + (double)llIIIIlIIIIlIl * llIIIIIlllllll * llIIIIlIIIIIll;
        double llIIIIlIIIIIII = (double)llIIIIlIIIIllI * llIIIIIlllllll * llIIIIlIIIIIll - (double)llIIIIlIIIIlIl * llIIIIIlllllll * llIIIIlIIIIIlI;
        return new double[]{llIIIIlIIIIIIl, llIIIIlIIIIIII};
    }

    public static boolean isInteger(Double lIlllllllIlIII) {
        return lIlllllllIlIII == Math.floor(lIlllllllIlIII) && !Double.isInfinite(lIlllllllIlIII);
    }

    public static double roundToPlace(double llIIIIIIIIllIl, int llIIIIIIIIlIIl) {
        if (llIIIIIIIIlIIl < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal llIIIIIIIIlIll = new BigDecimal(llIIIIIIIIllIl);
        llIIIIIIIIlIll = llIIIIIIIIlIll.setScale(llIIIIIIIIlIIl, RoundingMode.HALF_UP);
        return llIIIIIIIIlIll.doubleValue();
    }

    public static double[] directionSpeed(double llIIIIIlIIllll) {
        Minecraft llIIIIIlIlIlll = Minecraft.getMinecraft();
        float llIIIIIlIlIllI = llIIIIIlIlIlll.player.movementInput.moveForward;
        float llIIIIIlIlIlIl = llIIIIIlIlIlll.player.movementInput.moveStrafe;
        float llIIIIIlIlIlII = llIIIIIlIlIlll.player.field_70126_B + (llIIIIIlIlIlll.player.field_70177_z - llIIIIIlIlIlll.player.field_70126_B) * llIIIIIlIlIlll.getRenderPartialTicks();
        if (llIIIIIlIlIllI != 0.0f) {
            if (llIIIIIlIlIlIl > 0.0f) {
                llIIIIIlIlIlII += (float)(llIIIIIlIlIllI > 0.0f ? -45 : 45);
            } else if (llIIIIIlIlIlIl < 0.0f) {
                llIIIIIlIlIlII += (float)(llIIIIIlIlIllI > 0.0f ? 45 : -45);
            }
            llIIIIIlIlIlIl = 0.0f;
            if (llIIIIIlIlIllI > 0.0f) {
                llIIIIIlIlIllI = 1.0f;
            } else if (llIIIIIlIlIllI < 0.0f) {
                llIIIIIlIlIllI = -1.0f;
            }
        }
        double llIIIIIlIlIIll = Math.sin(Math.toRadians(llIIIIIlIlIlII + 90.0f));
        double llIIIIIlIlIIlI = Math.cos(Math.toRadians(llIIIIIlIlIlII + 90.0f));
        double llIIIIIlIlIIIl = (double)llIIIIIlIlIllI * llIIIIIlIIllll * llIIIIIlIlIIlI + (double)llIIIIIlIlIlIl * llIIIIIlIIllll * llIIIIIlIlIIll;
        double llIIIIIlIlIIII = (double)llIIIIIlIlIllI * llIIIIIlIIllll * llIIIIIlIlIIll - (double)llIIIIIlIlIlIl * llIIIIIlIIllll * llIIIIIlIlIIlI;
        return new double[]{llIIIIIlIlIIIl, llIIIIIlIlIIII};
    }

    public static float lerp(float lIllllllIIIIlI, float lIllllllIIIIIl, float lIllllllIIIIII) {
        return lIllllllIIIIlI + lIllllllIIIIII * (lIllllllIIIIIl - lIllllllIIIIlI);
    }

    public static void drawUnfilledCircle(float llIIIIIIlllIll, float llIIIIIIllIIIl, float llIIIIIIllIIII, float llIIIIIIlIllll, int llIIIIIIlIlllI) {
        float llIIIIIIllIllI = (float)(llIIIIIIlIlllI >> 16 & 0xFF) / 255.0f;
        float llIIIIIIllIlIl = (float)(llIIIIIIlIlllI >> 8 & 0xFF) / 255.0f;
        float llIIIIIIllIlII = (float)(llIIIIIIlIlllI & 0xFF) / 255.0f;
        float llIIIIIIllIIll = (float)(llIIIIIIlIlllI >> 24 & 0xFF) / 255.0f;
        GL11.glEnable((int)2848);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDepthMask((boolean)true);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glHint((int)3155, (int)4354);
        GlStateManager.enableBlend();
        GL11.glColor4f((float)llIIIIIIllIllI, (float)llIIIIIIllIlIl, (float)llIIIIIIllIlII, (float)llIIIIIIllIIll);
        GL11.glLineWidth((float)llIIIIIIlIllll);
        GL11.glBegin((int)2);
        for (int llIIIIIIllllII = 0; llIIIIIIllllII <= 360; ++llIIIIIIllllII) {
            GL11.glVertex2d((double)((double)llIIIIIIlllIll + Math.sin((double)llIIIIIIllllII * Math.PI / 180.0) * (double)llIIIIIIllIIII), (double)((double)llIIIIIIllIIIl + Math.cos((double)llIIIIIIllllII * Math.PI / 180.0) * (double)llIIIIIIllIIII));
        }
        GL11.glEnd();
        GL11.glScalef((float)2.0f, (float)2.0f, (float)2.0f);
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glDisable((int)2848);
        GL11.glHint((int)3154, (int)4352);
        GL11.glHint((int)3155, (int)4352);
        GlStateManager.disableBlend();
    }

    public static int getRandomInRange(int llIIIIIIIlIlll, int llIIIIIIIlIlII) {
        return (int)((double)llIIIIIIIlIlII + (double)(llIIIIIIIlIlll - llIIIIIIIlIlII) * random.nextDouble());
    }

    public static BigDecimal round(float llIIIIIIIlllII, double llIIIIIIIllIll) {
        BigDecimal llIIIIIIIlllIl = new BigDecimal(Float.toString(llIIIIIIIlllII));
        llIIIIIIIlllIl = llIIIIIIIlllIl.setScale((int)llIIIIIIIllIll, 4);
        return llIIIIIIIlllIl;
    }

    public static double[] getDirection(float llIIIIIllIIIll) {
        return new double[]{-Math.sin(Math.toRadians(llIIIIIllIIIll)), Math.cos(Math.toRadians(llIIIIIllIIIll))};
    }

    public static double randomize(double lIllllllIlllIl, double lIllllllIlIllI) {
        double d;
        Random lIllllllIllIlI = new Random();
        double lIllllllIllIIl = lIllllllIlIllI - lIllllllIlllIl;
        double lIllllllIllIII = lIllllllIllIlI.nextDouble() * lIllllllIllIIl;
        if (lIllllllIllIII > lIllllllIlIllI) {
            lIllllllIllIII = lIllllllIlIllI;
        }
        double lIllllllIllIll = lIllllllIllIII + lIllllllIlllIl;
        if (d > lIllllllIlIllI) {
            lIllllllIllIll = lIllllllIlIllI;
        }
        return lIllllllIllIll;
    }

    public static int randomize(int lIllllllllIlII, int lIllllllllIIll) {
        return -lIllllllllIIll + (int)(Math.random() * (double)(lIllllllllIlII - -lIllllllllIIll + 1));
    }

    public static double random(double llIIIIlIlIllIl, double llIIIIlIlIllII) {
        return Math.random() * (llIIIIlIlIllII - llIIIIlIlIllIl) + llIIIIlIlIllIl;
    }

    public MathUtils() {
        MathUtils llIIIIlIllIIII;
    }

    public static float sqrt_double(double llIIIIlIIllIII) {
        return (float)Math.sqrt(llIIIIlIIllIII);
    }

    public static double roundToDecimalPlace(double lIllllllIIllIl, double lIllllllIIlIII) {
        double lIllllllIIlIll = lIllllllIIlIII / 2.0;
        double lIllllllIIlIlI = Math.floor(lIllllllIIllIl / lIllllllIIlIII) * lIllllllIIlIII;
        if (lIllllllIIllIl >= lIllllllIIlIlI + lIllllllIIlIll) {
            return new BigDecimal(Math.ceil(lIllllllIIllIl / lIllllllIIlIII) * lIllllllIIlIII, MathContext.DECIMAL64).stripTrailingZeros().doubleValue();
        }
        return new BigDecimal(lIllllllIIlIlI, MathContext.DECIMAL64).stripTrailingZeros().doubleValue();
    }

    public static float clamp(float lIlllllIllIllI, float lIlllllIlllIII, float lIlllllIllIlII) {
        if (lIlllllIllIllI <= lIlllllIlllIII) {
            lIlllllIllIllI = lIlllllIlllIII;
        }
        if (lIlllllIllIllI >= lIlllllIllIlII) {
            lIlllllIllIllI = lIlllllIllIlII;
        }
        return lIlllllIllIllI;
    }

    public static double degToRad(double llIIIIlIIlllII) {
        return llIIIIlIIlllII * 0.01745329238474369;
    }

    public static Vec3d interpolateVec3d(Vec3d llIIIIIlllIIll, Vec3d llIIIIIlllIIlI, float llIIIIIlllIIIl) {
        return llIIIIIlllIIll.subtract(llIIIIIlllIIlI).scale((double)llIIIIIlllIIIl).add(llIIIIIlllIIlI);
    }

    public static double preciseRound(double llIIIIIIIIIlII, double llIIIIIIIIIIII) {
        double llIIIIIIIIIIlI = Math.pow(10.0, llIIIIIIIIIIII);
        return (double)Math.round(llIIIIIIIIIlII * llIIIIIIIIIIlI) / llIIIIIIIIIIlI;
    }

    static {
        random = new Random();
    }

    public static Vec3d direction(float llIIIIlIIlIllI) {
        return new Vec3d(Math.cos(MathUtils.degToRad(llIIIIlIIlIllI + 90.0f)), 0.0, Math.sin(MathUtils.degToRad(llIIIIlIIlIllI + 90.0f)));
    }

    public static double randomNumber(double lIlllllllllIlI, double lIlllllllllIll) {
        return Math.random() * (lIlllllllllIlI - lIlllllllllIll) + lIlllllllllIll;
    }

    public static double getRandomInRange(double llIIIIIIlIIlII, double llIIIIIIlIIlIl) {
        return llIIIIIIlIIlIl + (llIIIIIIlIIlII - llIIIIIIlIIlIl) * random.nextDouble();
    }

    public static double getNormalDouble(double llIIIIIllIIllI) {
        return new BigDecimal(llIIIIIllIIllI).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }

    public static double getNormalDouble(double llIIIIlIIlllll, int llIIIIlIIllllI) {
        return new BigDecimal(llIIIIlIIlllll).setScale(llIIIIlIIllllI, RoundingMode.HALF_EVEN).doubleValue();
    }

    public static boolean isEven(int llIIIIIIIlIIIl) {
        return llIIIIIIIlIIIl % 2 == 0;
    }

    public static float wrapAngleTo180_float(float llIIIIlIIlIIlI) {
        if ((llIIIIlIIlIIlI %= 360.0f) >= 180.0f) {
            llIIIIlIIlIIlI -= 360.0f;
        }
        if (llIIIIlIIlIIlI < -180.0f) {
            llIIIIlIIlIIlI += 360.0f;
        }
        return llIIIIlIIlIIlI;
    }

    public static float random(float llIIIIlIlIIlll, float llIIIIlIlIIllI) {
        return (float)(Math.random() * (double)(llIIIIlIlIIllI - llIIIIlIlIIlll) + (double)llIIIIlIlIIlll);
    }

    public static Vec3d interpolateEntity(Entity llIIIIIllIlIIl) {
        double llIIIIIllIlIlI = Minecraft.getMinecraft().getRenderPartialTicks();
        return new Vec3d(llIIIIIllIlIIl.lastTickPosX + (llIIIIIllIlIIl.posX - llIIIIIllIlIIl.lastTickPosX) * llIIIIIllIlIlI, llIIIIIllIlIIl.lastTickPosY + (llIIIIIllIlIIl.posY - llIIIIIllIlIIl.lastTickPosY) * llIIIIIllIlIlI, llIIIIIllIlIIl.lastTickPosZ + (llIIIIIllIlIIl.posZ - llIIIIIllIlIIl.lastTickPosZ) * llIIIIIllIlIlI);
    }

    public static float[] constrainAngle(float[] lIlllllllIIlIl) {
        lIlllllllIIlIl[0] = lIlllllllIIlIl[0] % 360.0f;
        lIlllllllIIlIl[1] = lIlllllllIIlIl[1] % 360.0f;
        while (lIlllllllIIlIl[0] <= -180.0f) {
            lIlllllllIIlIl[0] = lIlllllllIIlIl[0] + 360.0f;
        }
        while (lIlllllllIIlIl[1] <= -180.0f) {
            lIlllllllIIlIl[1] = lIlllllllIIlIl[1] + 360.0f;
        }
        while (lIlllllllIIlIl[0] > 180.0f) {
            lIlllllllIIlIl[0] = lIlllllllIIlIl[0] - 360.0f;
        }
        while (lIlllllllIIlIl[1] > 180.0f) {
            lIlllllllIIlIl[1] = lIlllllllIIlIl[1] - 360.0f;
        }
        return lIlllllllIIlIl;
    }

    public static double getIncremental(double lIlllllllIllll, double lIlllllllIlllI) {
        double lIlllllllIllIl = 1.0 / lIlllllllIlllI;
        return (double)Math.round(lIlllllllIllll * lIlllllllIllIl) / lIlllllllIllIl;
    }
}

