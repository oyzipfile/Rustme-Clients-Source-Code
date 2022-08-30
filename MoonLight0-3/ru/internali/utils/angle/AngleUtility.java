/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.EntityLivingBase
 */
package ru.internali.utils.angle;

import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import ru.internali.utils.MathUtils;
import ru.internali.utils.angle.Vector2;
import ru.internali.utils.angle.Vector3;

public class AngleUtility {
    private /* synthetic */ Vector3<Float> delta;
    private final /* synthetic */ Random random;
    private static /* synthetic */ Minecraft minecraft;
    private /* synthetic */ float minPitchSmoothing;
    private /* synthetic */ float maxPitchSmoothing;
    private /* synthetic */ float maxYawSmoothing;
    private /* synthetic */ float height;
    private /* synthetic */ float minYawSmoothing;
    private /* synthetic */ Angle smoothedAngle;

    public void setHeight(float lIlIllIIlIIlIIl) {
        lIlIllIIlIIlIlI.height = lIlIllIIlIIlIIl;
    }

    public AngleUtility(float lIlIllIlIlIIlll, float lIlIllIlIlIIIIl, float lIlIllIlIlIIlIl, float lIlIllIlIlIIlII) {
        AngleUtility lIlIllIlIlIIIll;
        lIlIllIlIlIIIll.height = (float)MathUtils.getRandomInRange(1.1f, 1.8f);
        lIlIllIlIlIIIll.minYawSmoothing = lIlIllIlIlIIlll;
        lIlIllIlIlIIIll.maxYawSmoothing = lIlIllIlIlIIIIl;
        lIlIllIlIlIIIll.minPitchSmoothing = lIlIllIlIlIIlIl;
        lIlIllIlIlIIIll.maxPitchSmoothing = lIlIllIlIlIIlII;
        lIlIllIlIlIIIll.random = new Random();
        lIlIllIlIlIIIll.delta = new Vector3<Float>(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(0.0f));
        lIlIllIlIlIIIll.smoothedAngle = new Angle(Float.valueOf(0.0f), Float.valueOf(0.0f));
    }

    static {
        minecraft = Minecraft.getMinecraft();
    }

    public float randomFloat(float lIlIllIIlllIIII, float lIlIllIIlllIIlI) {
        AngleUtility lIlIllIIlllIIIl;
        return lIlIllIIlllIIII + lIlIllIIlllIIIl.random.nextFloat() * (lIlIllIIlllIIlI - lIlIllIIlllIIII);
    }

    public Angle smoothAngle(Angle lIlIllIIlIIIIlI, Angle lIlIllIIIllllII, float lIlIllIIlIIIIII, float lIlIllIIIllllll) {
        AngleUtility lIlIllIIIlllllI;
        return lIlIllIIIlllllI.smoothedAngle.setYaw(Float.valueOf(lIlIllIIIllllII.getYaw().floatValue() - lIlIllIIlIIIIlI.getYaw().floatValue() - (Math.abs(lIlIllIIIllllII.getYaw().floatValue() - lIlIllIIlIIIIlI.getYaw().floatValue()) > 5.0f ? Math.abs(lIlIllIIIllllII.getYaw().floatValue() - lIlIllIIlIIIIlI.getYaw().floatValue()) / Math.abs(lIlIllIIIllllII.getYaw().floatValue() - lIlIllIIlIIIIlI.getYaw().floatValue()) * 2.0f / 2.0f : 0.0f))).setPitch(Float.valueOf(lIlIllIIIllllII.getPitch().floatValue() - lIlIllIIlIIIIlI.getPitch().floatValue())).constrantAngle().setYaw(Float.valueOf(lIlIllIIIllllII.getYaw().floatValue() - lIlIllIIIlllllI.smoothedAngle.getYaw().floatValue() / lIlIllIIIllllll * lIlIllIIIlllllI.randomFloat(lIlIllIIIlllllI.minYawSmoothing, lIlIllIIIlllllI.maxYawSmoothing))).constrantAngle().setPitch(Float.valueOf(lIlIllIIIllllII.getPitch().floatValue() - lIlIllIIIlllllI.smoothedAngle.getPitch().floatValue() / lIlIllIIlIIIIII * lIlIllIIIlllllI.randomFloat(lIlIllIIIlllllI.minPitchSmoothing, lIlIllIIIlllllI.maxPitchSmoothing))).constrantAngle();
    }

    public static float[] getRotations(EntityLivingBase lIlIllIlIIllIlI) {
        double lIlIllIlIIllIIl = lIlIllIlIIllIlI.field_70165_t;
        double lIlIllIlIIllIII = lIlIllIlIIllIlI.field_70161_v;
        double lIlIllIlIIlIlll = lIlIllIlIIllIlI.field_70163_u + (double)(lIlIllIlIIllIlI.func_70047_e() / 2.0f);
        return AngleUtility.getRotationFromPosition(lIlIllIlIIllIIl, lIlIllIlIIllIII, lIlIllIlIIlIlll);
    }

    public Angle calculateAngle(Vector3<Double> lIlIllIIllIIIll, Vector3<Double> lIlIllIIllIIIlI, EntityLivingBase lIlIllIIllIIIIl, int lIlIllIIllIIIII) {
        AngleUtility lIlIllIIllIIlII;
        Angle lIlIllIIlIlllll = new Angle(Float.valueOf(0.0f), Float.valueOf(0.0f));
        lIlIllIIllIIlII.delta.setX(Float.valueOf(((Number)lIlIllIIllIIIll.getX()).floatValue() - ((Number)lIlIllIIllIIIlI.getX()).floatValue())).setY(Float.valueOf(((Number)lIlIllIIllIIIll.getY()).floatValue() + lIlIllIIllIIlII.height - (((Number)lIlIllIIllIIIlI.getY()).floatValue() + lIlIllIIllIIlII.height))).setZ(Float.valueOf(((Number)lIlIllIIllIIIll.getZ()).floatValue() - ((Number)lIlIllIIllIIIlI.getZ()).floatValue()));
        double lIlIllIIlIllllI = Math.hypot(((Number)lIlIllIIllIIlII.delta.getX()).doubleValue(), ((Number)lIlIllIIllIIlII.delta.getZ()).doubleValue());
        float lIlIllIIlIlllIl = (float)Math.atan2(((Number)lIlIllIIllIIlII.delta.getZ()).floatValue(), ((Number)lIlIllIIllIIlII.delta.getX()).floatValue());
        float lIlIllIIlIlllII = (float)Math.atan2(((Number)lIlIllIIllIIlII.delta.getY()).floatValue(), lIlIllIIlIllllI);
        float lIlIllIIlIllIll = 57.29578f;
        float lIlIllIIlIllIlI = lIlIllIIlIlllIl * lIlIllIIlIllIll - 90.0f;
        float lIlIllIIlIllIIl = -(lIlIllIIlIlllII * lIlIllIIlIllIll);
        return lIlIllIIlIlllll.setYaw(Float.valueOf(lIlIllIIlIllIlI)).setPitch(Float.valueOf(lIlIllIIlIllIIl)).constrantAngle();
    }

    public static float[] getRotationFromPosition(double lIlIllIlIIIIIII, double lIlIllIlIIIlIII, double lIlIllIIllllllI) {
        double lIlIllIlIIIIllI = lIlIllIlIIIIIII - Minecraft.getMinecraft().player.field_70165_t;
        double lIlIllIlIIIIlIl = lIlIllIlIIIlIII - Minecraft.getMinecraft().player.field_70161_v;
        double lIlIllIlIIIIlII = lIlIllIIllllllI - Minecraft.getMinecraft().player.field_70163_u - 1.2;
        double lIlIllIlIIIIIll = MathUtils.sqrt_double(lIlIllIlIIIIllI * lIlIllIlIIIIllI + lIlIllIlIIIIlIl * lIlIllIlIIIIlIl);
        float lIlIllIlIIIIIlI = (float)(Math.atan2(lIlIllIlIIIIlIl, lIlIllIlIIIIllI) * 180.0 / Math.PI) - 90.0f;
        float lIlIllIlIIIIIIl = (float)(-(Math.atan2(lIlIllIlIIIIlII, lIlIllIlIIIIIll) * 180.0 / Math.PI));
        return new float[]{lIlIllIlIIIIIlI, lIlIllIlIIIIIIl};
    }

    public static class Angle
    extends Vector2<Float> {
        public /* synthetic */ int calls;
        public /* synthetic */ float lastPitch;
        public /* synthetic */ int requests;

        public Angle setYaw(Float lIlllIIllllllII) {
            Angle lIlllIIllllllIl;
            lIlllIIllllllIl.setX(lIlllIIllllllII);
            return lIlllIIllllllIl;
        }

        public Float getPitch() {
            Angle lIlllIIlllIllll;
            lIlllIIlllIllll.lastPitch = ((Number)lIlllIIlllIllll.getY()).floatValue();
            return Float.valueOf(lIlllIIlllIllll.lastPitch);
        }

        public Angle(Float lIlllIlIIIIIlII, Float lIlllIlIIIIIIII) {
            super(lIlllIlIIIIIlII, lIlllIlIIIIIIII);
            Angle lIlllIlIIIIIlIl;
        }

        public Float getYaw() {
            Angle lIlllIIllllIIlI;
            return Float.valueOf(((Number)lIlllIIllllIIlI.getX()).floatValue());
        }

        public Angle setPitch(Float lIlllIIllllIlII) {
            Angle lIlllIIllllIlIl;
            lIlllIIllllIlIl.setY(lIlllIIllllIlII);
            return lIlllIIllllIlIl;
        }

        public Angle constrantAngle() {
            Angle lIlllIIlllIllII;
            lIlllIIlllIllII.setYaw(Float.valueOf(lIlllIIlllIllII.getYaw().floatValue() % 360.0f));
            lIlllIIlllIllII.setPitch(Float.valueOf(lIlllIIlllIllII.getPitch().floatValue() % 360.0f));
            while (lIlllIIlllIllII.getYaw().floatValue() <= -180.0f) {
                lIlllIIlllIllII.setYaw(Float.valueOf(lIlllIIlllIllII.getYaw().floatValue() + 360.0f));
            }
            while (lIlllIIlllIllII.getPitch().floatValue() <= -180.0f) {
                lIlllIIlllIllII.setPitch(Float.valueOf(lIlllIIlllIllII.getPitch().floatValue() + 360.0f));
            }
            while (lIlllIIlllIllII.getYaw().floatValue() > 180.0f) {
                lIlllIIlllIllII.setYaw(Float.valueOf(lIlllIIlllIllII.getYaw().floatValue() - 360.0f));
            }
            while (lIlllIIlllIllII.getPitch().floatValue() > 180.0f) {
                lIlllIIlllIllII.setPitch(Float.valueOf(lIlllIIlllIllII.getPitch().floatValue() - 360.0f));
            }
            return lIlllIIlllIllII;
        }
    }
}

