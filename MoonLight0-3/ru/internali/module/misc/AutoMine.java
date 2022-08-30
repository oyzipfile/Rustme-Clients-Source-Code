/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityArmorStand
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.MathHelper
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package ru.internali.module.misc;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.module.misc.Rotation;
import ru.internali.utils.TimerUtils;

public class AutoMine
extends Module {
    private /* synthetic */ TimerUtils timer;

    public static float[] getNeededRotations(Entity lIllIllIlIllIII) {
        double lIllIllIlIllllI = lIllIllIlIllIII.posX - Minecraft.getMinecraft().player.field_70165_t;
        double lIllIllIlIlllIl = lIllIllIlIllIII.posZ - Minecraft.getMinecraft().player.field_70161_v;
        double lIllIllIlIlllII = lIllIllIlIllIII.posY + (double)lIllIllIlIllIII.getEyeHeight() - (Minecraft.getMinecraft().player.func_174813_aQ().minY + (Minecraft.getMinecraft().player.func_174813_aQ().maxY - Minecraft.getMinecraft().player.func_174813_aQ().minY));
        double lIllIllIlIllIll = MathHelper.sqrt((double)(lIllIllIlIllllI * lIllIllIlIllllI + lIllIllIlIlllIl * lIllIllIlIlllIl));
        float lIllIllIlIllIlI = (float)(MathHelper.atan2((double)lIllIllIlIlllIl, (double)lIllIllIlIllllI) * 180.0 / Math.PI) - 90.0f;
        float lIllIllIlIllIIl = (float)(-(MathHelper.atan2((double)lIllIllIlIlllII, (double)lIllIllIlIllIll) * 180.0 / Math.PI));
        return new float[]{lIllIllIlIllIlI, lIllIllIlIllIIl};
    }

    public Entity getMetka() {
        for (Entity lIllIllIllIlIlI : AutoMine.mc.world.field_72996_f) {
            if (!(lIllIllIllIlIlI instanceof EntityArmorStand) || !((double)AutoMine.mc.player.func_70032_d(lIllIllIllIlIlI) <= 3.3)) continue;
            return lIllIllIllIlIlI;
        }
        return null;
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent lIllIllIlIIllII) {
        AutoMine lIllIllIlIIllIl;
        Entity lIllIllIlIIlIll = lIllIllIlIIllIl.getMetka();
        if (lIllIllIlIIlIll == null) {
            return;
        }
        if (lIllIllIlIIllIl.timer.hasReached(250.0f)) {
            float[] lIllIllIlIIlllI = AutoMine.getNeededRotations(lIllIllIlIIlIll);
            Rotation.setYaw(lIllIllIlIIlllI[0]);
            Rotation.setPitch(lIllIllIlIIlllI[1]);
            AutoMine.mc.playerController.attackEntity((EntityPlayer)AutoMine.mc.player, lIllIllIlIIlIll);
            AutoMine.mc.player.swingArm(EnumHand.MAIN_HAND);
            lIllIllIlIIllIl.timer.reset();
        }
    }

    public AutoMine() {
        super("AutoMine", "AutoMine", Category.OUTHER);
        AutoMine lIllIllIllIllIl;
        lIllIllIllIllIl.timer = new TimerUtils();
    }
}

