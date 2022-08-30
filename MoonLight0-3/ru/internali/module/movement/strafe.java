/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package ru.internali.module.movement;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import ru.internali.module.Category;
import ru.internali.module.Module;

public class strafe
extends Module {
    public static boolean isMoving() {
        return strafe.mc.player != null && (strafe.mc.player.movementInput.moveForward != 0.0f || strafe.mc.player.movementInput.moveStrafe != 0.0f);
    }

    public strafe() {
        super("Strafe", "strafing", Category.MOVEMENT);
        strafe lllIIIIlIlllI;
    }

    public static void strafe() {
        strafe.strafe(strafe.getSpeed());
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent lllIIIIlIIlII) {
        strafe.strafe();
    }

    public static double getDirection() {
        float lllIIIIlIlIlI = strafe.mc.player.field_70177_z;
        if (strafe.mc.player.field_191988_bg < 0.0f) {
            lllIIIIlIlIlI += 180.0f;
        }
        float lllIIIIlIlIIl = 1.0f;
        if (strafe.mc.player.field_191988_bg < 0.0f) {
            lllIIIIlIlIIl = -0.5f;
        } else if (strafe.mc.player.field_191988_bg > 0.0f) {
            lllIIIIlIlIIl = 0.5f;
        }
        if (strafe.mc.player.field_70702_br > 0.0f) {
            lllIIIIlIlIlI -= 90.0f * lllIIIIlIlIIl;
        }
        if (strafe.mc.player.field_70702_br < 0.0f) {
            lllIIIIlIlIlI += 90.0f * lllIIIIlIlIIl;
        }
        return Math.toRadians(lllIIIIlIlIlI);
    }

    public static void strafe(float lllIIIIllIIIl) {
        if (!strafe.isMoving()) {
            return;
        }
        double lllIIIIllIIlI = strafe.getDirection();
        strafe.mc.player.field_70159_w = -Math.sin(lllIIIIllIIlI) * (double)lllIIIIllIIIl;
        strafe.mc.player.field_70179_y = Math.cos(lllIIIIllIIlI) * (double)lllIIIIllIIIl;
    }

    public static float getSpeed() {
        return (float)Math.sqrt(strafe.mc.player.field_70159_w * strafe.mc.player.field_70159_w + strafe.mc.player.field_70179_y * strafe.mc.player.field_70179_y);
    }
}

