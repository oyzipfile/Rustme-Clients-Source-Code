/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.math.MathHelper
 */
package ru.internali.utils.event;

import net.minecraft.client.Minecraft;
import net.minecraft.util.math.MathHelper;
import ru.internali.utils.GCDFix;

public class CombatUtils {
    public static /* synthetic */ Minecraft mc;

    static {
        mc = Minecraft.getMinecraft();
    }

    public CombatUtils() {
        CombatUtils lllIlIIlllIlIl;
    }

    public static float[] getRotationFromPosition(double lllIlIIllIlIll, double lllIlIIllIIIIl, double lllIlIIllIlIIl) {
        double lllIlIIllIlIII = lllIlIIllIlIll - CombatUtils.mc.player.field_70165_t;
        double lllIlIIllIIlll = lllIlIIllIIIIl - Minecraft.getMinecraft().player.field_70161_v;
        double lllIlIIllIIllI = lllIlIIllIlIIl - Minecraft.getMinecraft().player.field_70163_u - 0.6;
        double lllIlIIllIIlIl = MathHelper.sqrt((double)(lllIlIIllIlIII * lllIlIIllIlIII + lllIlIIllIIlll * lllIlIIllIIlll));
        float lllIlIIllIIlII = (float)(Math.atan2(lllIlIIllIIlll, lllIlIIllIlIII) * 180.0 / Math.PI) - 90.0f;
        float lllIlIIllIIIll = (float)(-(Math.atan2(lllIlIIllIIllI, lllIlIIllIIlIl) * 180.0 / Math.PI));
        return new float[]{lllIlIIllIIlII, lllIlIIllIIIll};
    }

    public static float[] getRotations(float lllIIlllIllIlI, float lllIIlllIllIIl, float lllIIlllIIlllI, float lllIIlllIIllIl, float lllIIlllIlIllI, float lllIIlllIlIlIl, String lllIIlllIIlIlI) {
        if (lllIIlllIIlIlI == "Head") {
            double lllIIllllIIllI = lllIIlllIllIlI;
            double lllIIllllIIlIl = lllIIlllIIlllI;
            double lllIIllllIIlII = lllIIlllIllIIl - 0.1f + CombatUtils.mc.player.func_70047_e() / 2.0f;
            return CombatUtils.getRotationFromPosition(lllIIllllIIllI, lllIIllllIIlIl, lllIIllllIIlII, lllIIlllIIllIl, lllIIlllIlIllI, lllIIlllIlIlIl);
        }
        if (lllIIlllIIlIlI == "Chest") {
            double lllIIllllIIIll = lllIIlllIllIlI;
            double lllIIllllIIIlI = lllIIlllIIlllI;
            double lllIIllllIIIIl = (double)(lllIIlllIllIIl + CombatUtils.mc.player.func_70047_e() / 2.0f) - 0.75;
            return CombatUtils.getRotationFromPosition(lllIIllllIIIll, lllIIllllIIIlI, lllIIllllIIIIl, lllIIlllIIllIl, lllIIlllIlIllI, lllIIlllIlIlIl);
        }
        if (lllIIlllIIlIlI == "PenisOfBavarca") {
            double lllIIllllIIIII = lllIIlllIllIlI;
            double lllIIlllIlllll = lllIIlllIIlllI;
            double lllIIlllIllllI = (double)(lllIIlllIllIIl + CombatUtils.mc.player.func_70047_e() / 2.0f) - 1.2;
            return CombatUtils.getRotationFromPosition(lllIIllllIIIII, lllIIlllIlllll, lllIIlllIllllI, lllIIlllIIllIl, lllIIlllIlIllI, lllIIlllIlIlIl);
        }
        if (lllIIlllIIlIlI == "Legs") {
            double lllIIlllIlllIl = lllIIlllIllIlI;
            double lllIIlllIlllII = lllIIlllIIlllI;
            double lllIIlllIllIll = (double)(lllIIlllIllIIl + CombatUtils.mc.player.func_70047_e() / 2.0f) - 1.5;
            return CombatUtils.getRotationFromPosition(lllIIlllIlllIl, lllIIlllIlllII, lllIIlllIllIll, lllIIlllIIllIl, lllIIlllIlIllI, lllIIlllIlIlIl);
        }
        double lllIIlllIlIIll = lllIIlllIllIlI;
        double lllIIlllIlIIlI = lllIIlllIIlllI;
        double lllIIlllIlIIIl = (double)(lllIIlllIllIIl + CombatUtils.mc.player.func_70047_e() / 2.0f) - 0.5;
        return CombatUtils.getRotationFromPosition(lllIIlllIlIIll, lllIIlllIlIIlI, lllIIlllIlIIIl, lllIIlllIIllIl, lllIIlllIlIllI, lllIIlllIlIlIl);
    }

    public static float[] getRotationFromPosition(double lllIlIIlIIIIIl, double lllIlIIIllllll, double lllIlIIIllllIl, float lllIlIIIllllII, float lllIlIIlIIlIIl, float lllIlIIIlllIlI) {
        double lllIlIIlIIIlll = lllIlIIlIIIIIl - (double)lllIlIIIllllII;
        double lllIlIIlIIIllI = lllIlIIIllllll - (double)lllIlIIIlllIlI;
        double lllIlIIlIIIlIl = lllIlIIIllllIl - (double)lllIlIIlIIlIIl - 0.6;
        double lllIlIIlIIIlII = MathHelper.sqrt((double)(lllIlIIlIIIlll * lllIlIIlIIIlll + lllIlIIlIIIllI * lllIlIIlIIIllI));
        float lllIlIIlIIIIll = (float)(Math.atan2(lllIlIIlIIIllI, lllIlIIlIIIlll) * 180.0 / Math.PI) - 90.0f;
        float lllIlIIlIIIIlI = (float)(-(Math.atan2(lllIlIIlIIIlIl, lllIlIIlIIIlII) * 180.0 / Math.PI));
        return new float[]{lllIlIIlIIIIll, lllIlIIlIIIIlI};
    }

    public static float[] getNeededRotations(double lllIlIIIIlllIl, double lllIlIIIlIlIII, double lllIlIIIlIIlll, float lllIlIIIIllIII, float lllIlIIIlIIlIl, float lllIlIIIlIIlII) {
        double lllIlIIIlIIIll = lllIlIIIIlllIl - (double)lllIlIIIIllIII;
        double lllIlIIIlIIIlI = lllIlIIIlIIlll - (double)lllIlIIIlIIlII;
        double lllIlIIIlIIIIl = lllIlIIIlIlIII - (double)(lllIlIIIlIIlIl + CombatUtils.mc.player.func_70047_e());
        double lllIlIIIlIIIII = MathHelper.sqrt((double)(lllIlIIIlIIIll * lllIlIIIlIIIll + lllIlIIIlIIIlI * lllIlIIIlIIIlI));
        float lllIlIIIIlllll = (float)(Math.atan2(lllIlIIIlIIIlI, lllIlIIIlIIIll) * 180.0 / Math.PI - 90.0);
        float lllIlIIIIllllI = (float)(-(Math.atan2(lllIlIIIlIIIIl, lllIlIIIlIIIII) * 180.0 / Math.PI));
        lllIlIIIIlllll = CombatUtils.mc.player.field_70177_z + GCDFix.getFixedRotation(MathHelper.wrapDegrees((float)(lllIlIIIIlllll - CombatUtils.mc.player.field_70177_z)));
        lllIlIIIIllllI = CombatUtils.mc.player.field_70125_A + GCDFix.getFixedRotation(MathHelper.wrapDegrees((float)(lllIlIIIIllllI - CombatUtils.mc.player.field_70125_A)));
        lllIlIIIIllllI = MathHelper.clamp((float)lllIlIIIIllllI, (float)-90.0f, (float)90.0f);
        return new float[]{lllIlIIIIlllll, lllIlIIIIllllI};
    }

    public static float[] getRotations(float lllIIlllllIlll, float lllIIlllllIllI, float lllIIlllllllII, String lllIIllllllIll) {
        if (lllIIllllllIll == "Head") {
            double lllIlIIIIIlIlI = lllIIlllllIlll;
            double lllIlIIIIIlIIl = lllIIlllllllII;
            double lllIlIIIIIlIII = lllIIlllllIllI - 0.1f + CombatUtils.mc.player.func_70047_e() / 2.0f;
            return CombatUtils.getRotationFromPosition(lllIlIIIIIlIlI, lllIlIIIIIlIIl, lllIlIIIIIlIII);
        }
        if (lllIIllllllIll == "Chest") {
            double lllIlIIIIIIlll = lllIIlllllIlll;
            double lllIlIIIIIIllI = lllIIlllllllII;
            double lllIlIIIIIIlIl = (double)(lllIIlllllIllI + CombatUtils.mc.player.func_70047_e() / 2.0f) - 0.75;
            return CombatUtils.getRotationFromPosition(lllIlIIIIIIlll, lllIlIIIIIIllI, lllIlIIIIIIlIl);
        }
        if (lllIIllllllIll == "PenisOfBavarca") {
            double lllIlIIIIIIlII = lllIIlllllIlll;
            double lllIlIIIIIIIll = lllIIlllllllII;
            double lllIlIIIIIIIlI = (double)(lllIIlllllIllI + CombatUtils.mc.player.func_70047_e() / 2.0f) - 1.2;
            return CombatUtils.getRotationFromPosition(lllIlIIIIIIlII, lllIlIIIIIIIll, lllIlIIIIIIIlI);
        }
        if (lllIIllllllIll == "Legs") {
            double lllIlIIIIIIIIl = lllIIlllllIlll;
            double lllIlIIIIIIIII = lllIIlllllllII;
            double lllIIlllllllll = (double)(lllIIlllllIllI + CombatUtils.mc.player.func_70047_e() / 2.0f) - 1.5;
            return CombatUtils.getRotationFromPosition(lllIlIIIIIIIIl, lllIlIIIIIIIII, lllIIlllllllll);
        }
        double lllIIllllllIlI = lllIIlllllIlll;
        double lllIIllllllIIl = lllIIlllllllII;
        double lllIIllllllIII = (double)(lllIIlllllIllI + CombatUtils.mc.player.func_70047_e() / 2.0f) - 0.5;
        return CombatUtils.getRotationFromPosition(lllIIllllllIlI, lllIIllllllIIl, lllIIllllllIII);
    }
}

