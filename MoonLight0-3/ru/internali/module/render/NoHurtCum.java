/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package ru.internali.module.render;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import ru.internali.module.Category;
import ru.internali.module.Module;

public class NoHurtCum
extends Module {
    public NoHurtCum() {
        super("NoHurtCum", "disables hurt effect", Category.RENDER);
        NoHurtCum llIlIIIIlllllII;
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent llIlIIIIllllIlI) {
        NoHurtCum.mc.player.field_70737_aN = 0;
        NoHurtCum.mc.player.field_70172_ad = 0;
        NoHurtCum.mc.player.field_70771_an = 0;
        NoHurtCum.mc.player.field_70738_aO = 0;
    }
}

