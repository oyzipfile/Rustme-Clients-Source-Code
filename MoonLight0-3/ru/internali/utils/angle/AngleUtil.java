/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils.angle;

import java.util.Random;
import ru.internali.utils.angle.Angle;
import ru.internali.utils.angle.Vector3;

public class AngleUtil {
    private static /* synthetic */ Angle smoothedAngle;
    private static /* synthetic */ float maxYawSmoothing;
    private static /* synthetic */ float maxPitchSmoothing;
    private static /* synthetic */ float minPitchSmoothing;
    private static /* synthetic */ Random random;
    private static /* synthetic */ float minYawSmoothing;
    private static /* synthetic */ Vector3<Float> delta;

    public AngleUtil(float lIlllIIlIlIllII, float lIlllIIlIlIlIll, float lIlllIIlIlIlIlI, float lIlllIIlIlIlllI) {
        AngleUtil lIlllIIlIllIIlI;
        minYawSmoothing = lIlllIIlIlIllII;
        maxYawSmoothing = lIlllIIlIlIlIll;
        minPitchSmoothing = lIlllIIlIlIlIlI;
        maxPitchSmoothing = lIlllIIlIlIlllI;
        random = new Random();
        delta = new Vector3<Float>(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(0.0f));
        smoothedAngle = new Angle(Float.valueOf(0.0f), Float.valueOf(0.0f));
    }

    public static float randomFloat(float lIlllIIlIlIIlII, float lIlllIIlIlIIlIl) {
        return lIlllIIlIlIIlII + random.nextFloat() * (lIlllIIlIlIIlIl - lIlllIIlIlIIlII);
    }

    public static Angle calculateAngle(Vector3<Double> lIlllIIlIIllIII, Vector3<Double> lIlllIIlIIlIlll) {
        Angle lIlllIIlIIlIllI = new Angle(Float.valueOf(0.0f), Float.valueOf(0.0f));
        float lIlllIIlIIlIlIl = 1.5f;
        delta.setX(Float.valueOf(((Number)lIlllIIlIIllIII.getX()).floatValue() - ((Number)lIlllIIlIIlIlll.getX()).floatValue())).setY(Float.valueOf(((Number)lIlllIIlIIllIII.getY()).floatValue() + lIlllIIlIIlIlIl - (((Number)lIlllIIlIIlIlll.getY()).floatValue() + lIlllIIlIIlIlIl))).setZ(Float.valueOf(((Number)lIlllIIlIIllIII.getZ()).floatValue() - ((Number)lIlllIIlIIlIlll.getZ()).floatValue()));
        double lIlllIIlIIlIlII = Math.hypot(((Number)delta.getX()).doubleValue(), ((Number)delta.getZ()).doubleValue());
        float lIlllIIlIIlIIll = (float)Math.atan2(((Number)delta.getZ()).floatValue(), ((Number)delta.getX()).floatValue());
        float lIlllIIlIIlIIlI = (float)Math.atan2(((Number)delta.getY()).floatValue(), lIlllIIlIIlIlII);
        float lIlllIIlIIlIIIl = 57.29578f;
        float lIlllIIlIIlIIII = lIlllIIlIIlIIll * lIlllIIlIIlIIIl - 90.0f;
        float lIlllIIlIIIllll = -(lIlllIIlIIlIIlI * lIlllIIlIIlIIIl);
        return lIlllIIlIIlIllI.setYaw(Float.valueOf(lIlllIIlIIlIIII)).setPitch(Float.valueOf(lIlllIIlIIIllll)).constrantAngle();
    }

    public static Angle smoothAngle(Angle lIlllIIlIIIIIlI, Angle lIlllIIlIIIIIIl, float lIlllIIlIIIIIII, float lIlllIIIlllllll) {
        return smoothedAngle.setYaw(Float.valueOf(lIlllIIlIIIIIIl.getYaw().floatValue() - lIlllIIlIIIIIlI.getYaw().floatValue())).setPitch(Float.valueOf(lIlllIIlIIIIIIl.getPitch().floatValue() - lIlllIIlIIIIIlI.getPitch().floatValue())).constrantAngle().setYaw(Float.valueOf(lIlllIIlIIIIIIl.getYaw().floatValue() - smoothedAngle.getYaw().floatValue() / 100.0f * AngleUtil.randomFloat(minYawSmoothing, maxYawSmoothing))).setPitch(Float.valueOf(lIlllIIlIIIIIIl.getPitch().floatValue() - smoothedAngle.getPitch().floatValue() / 100.0f * AngleUtil.randomFloat(minPitchSmoothing, maxPitchSmoothing))).constrantAngle();
    }
}

