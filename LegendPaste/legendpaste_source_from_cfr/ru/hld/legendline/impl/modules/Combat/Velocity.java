/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketEntityVelocity
 *  net.minecraft.network.play.server.SPacketExplosion
 */
package ru.hld.legendline.impl.modules.Combat;

import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketExplosion;
import ru.hld.legendline.api.event.EventTarget;
import ru.hld.legendline.api.event.events.EventPacketReceive;
import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.module.Module;

public class Velocity
extends Module {
    public Velocity() {
        super("Velocity", "zalupa", Category.Combat);
        Velocity lllllllllllllllIIIlIIIIIlIIlIIlI;
    }

    @EventTarget
    public void onUpdate(EventPacketReceive lllllllllllllllIIIlIIIIIlIIIllIl) {
        Velocity lllllllllllllllIIIlIIIIIlIIIllII;
        if ((lllllllllllllllIIIlIIIIIlIIIllIl.getPacket() instanceof SPacketEntityVelocity || lllllllllllllllIIIlIIIIIlIIIllIl.getPacket() instanceof SPacketExplosion) && ((SPacketEntityVelocity)lllllllllllllllIIIlIIIIIlIIIllIl.getPacket()).getEntityID() == lllllllllllllllIIIlIIIIIlIIIllII.mc.player.getEntityId()) {
            lllllllllllllllIIIlIIIIIlIIIllIl.setCancelled(true);
        }
    }
}

