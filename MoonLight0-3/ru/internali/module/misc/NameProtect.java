/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraftforge.client.event.RenderLivingEvent$Specials$Pre
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.opengl.GL11
 */
package ru.internali.module.misc;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;
import ru.internali.module.Category;
import ru.internali.module.Module;

public class NameProtect
extends Module {
    @SubscribeEvent
    public void onRender(RenderLivingEvent.Specials.Pre lllllIIIIllIll) {
        String lllllIIIIllIlI = "MoonLight";
        EntityLivingBase lllllIIIIllIIl = lllllIIIIllIll.getEntity();
        if (!(lllllIIIIllIIl instanceof EntityPlayer) || lllllIIIIllIIl == NameProtect.mc.player) {
            return;
        }
        if (lllllIIIIllIIl.field_70128_L || lllllIIIIllIIl.getHealth() < 0.0f || lllllIIIIllIIl.func_82150_aj()) {
            return;
        }
        GL11.glPushMatrix();
        GL11.glPopMatrix();
        lllllIIIIllIll.setCanceled(true);
    }

    public NameProtect() {
        super("NameProtect", "NameProtect", Category.OUTHER);
        NameProtect lllllIIIlIIIII;
    }
}

