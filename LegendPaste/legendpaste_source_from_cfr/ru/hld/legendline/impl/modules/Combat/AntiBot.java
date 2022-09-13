/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 */
package ru.hld.legendline.impl.modules.Combat;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import ru.hld.legendline.api.event.EventTarget;
import ru.hld.legendline.api.event.events.EventUpdate;
import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.module.Module;

public class AntiBot
extends Module {
    public AntiBot() {
        super("AntiBot", "remove bots form anticheat", Category.Combat);
        AntiBot llllllllllllllllIlIIIIlllIIllIII;
    }

    @EventTarget
    public void onUpdate(EventUpdate llllllllllllllllIlIIIIlllIIlIIlI) {
        AntiBot llllllllllllllllIlIIIIlllIIlIIll;
        for (Entity llllllllllllllllIlIIIIlllIIlIlII : llllllllllllllllIlIIIIlllIIlIIll.mc.world.loadedEntityList) {
            if (!(llllllllllllllllIlIIIIlllIIlIlII instanceof EntityPlayer) || !llllllllllllllllIlIIIIlllIIlIlII.isInvisible() || llllllllllllllllIlIIIIlllIIlIlII == llllllllllllllllIlIIIIlllIIlIIll.mc.player) continue;
            llllllllllllllllIlIIIIlllIIlIIll.mc.world.removeEntity(llllllllllllllllIlIIIIlllIIlIlII);
        }
    }
}

