/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  org.apache.commons.lang3.reflect.FieldUtils
 */
package ru.internali.utils;

import java.lang.reflect.Field;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import org.apache.commons.lang3.reflect.FieldUtils;
import ru.internali.utils.MappingManager;
import ru.internali.utils.Wrapper;

public class ReflectionUtils {
    public static void setSpeedInAir(float lllIIIIllIlllI) {
        try {
            Field lllIIIIlllIIII = EntityPlayer.class.getDeclaredField(MappingManager.fieldSpeedInAir);
            lllIIIIlllIIII.setAccessible(true);
            lllIIIIlllIIII.setFloat((Object)Wrapper.INSTANCE.getLocalPlayer(), lllIIIIllIlllI);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private static Object[] getTimer() {
        Class<Minecraft> lllIIIIllIIIlI = Minecraft.class;
        try {
            Field lllIIIIllIIlll = lllIIIIllIIIlI.getDeclaredField(MappingManager.fieldTimer);
            lllIIIIllIIlll.setAccessible(true);
            FieldUtils.removeFinalModifier((Field)lllIIIIllIIlll);
            Object lllIIIIllIIllI = lllIIIIllIIlll.get((Object)Wrapper.INSTANCE.getMinecraft());
            Class<?> lllIIIIllIIlIl = lllIIIIllIIllI.getClass();
            Field lllIIIIllIIlII = lllIIIIllIIlIl.getDeclaredField(MappingManager.fieldTickLength);
            return new Object[]{lllIIIIllIIlII, lllIIIIllIIllI};
        }
        catch (Exception lllIIIIllIIIll) {
            return null;
        }
    }

    public static void setTimerSpeedF(float lllIIIIlIlIIII) {
        try {
            Object[] lllIIIIlIlIIlI = ReflectionUtils.getTimer();
            Field lllIIIIlIlIIIl = (Field)lllIIIIlIlIIlI[0];
            lllIIIIlIlIIIl.setAccessible(true);
            lllIIIIlIlIIIl.setFloat(lllIIIIlIlIIlI[1], 50.0f / lllIIIIlIlIIII);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public ReflectionUtils() {
        ReflectionUtils lllIIIIlllIlll;
    }

    public static float getTimerSpeed() {
        try {
            Object[] lllIIIIlIllIlI = ReflectionUtils.getTimer();
            Field lllIIIIlIllIIl = (Field)lllIIIIlIllIlI[0];
            lllIIIIlIllIIl.setAccessible(true);
            return lllIIIIlIllIIl.getFloat(lllIIIIlIllIlI[1]);
        }
        catch (Exception lllIIIIlIllIII) {
            return 0.0f;
        }
    }

    public static void setTimerSpeedD(double lllIIIIlIIIllI) {
        try {
            Object[] lllIIIIlIIlIIl = ReflectionUtils.getTimer();
            Field lllIIIIlIIlIII = (Field)lllIIIIlIIlIIl[0];
            lllIIIIlIIlIII.setAccessible(true);
            lllIIIIlIIlIII.setFloat(lllIIIIlIIlIIl[1], (float)(50.0 / lllIIIIlIIIllI));
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static void resetJumpTicks() {
        try {
            Field lllIIIIlllIlII = EntityLivingBase.class.getDeclaredField(MappingManager.fieldJumpTicks);
            lllIIIIlllIlII.setAccessible(true);
            lllIIIIlllIlII.setInt((Object)Wrapper.INSTANCE.getLocalPlayer(), 0);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

