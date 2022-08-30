/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityArmorStand
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package ru.internali.module.World;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.internali.module.Category;
import ru.internali.module.Module;

public class DeleteArmorStands
extends Module {
    public DeleteArmorStands() {
        super("RemArmSts", "DeleteArmorStands", Category.WORLD);
        DeleteArmorStands llIlIIlIIllIIlI;
    }

    @SubscribeEvent
    public void onUpdate(RenderWorldLastEvent llIlIIlIIlIllIl) {
        if (DeleteArmorStands.mc.player == null || DeleteArmorStands.mc.world == null) {
            return;
        }
        for (Entity llIlIIlIIlIllll : DeleteArmorStands.mc.world.field_72996_f) {
            if (llIlIIlIIlIllll == null || !(llIlIIlIIlIllll instanceof EntityArmorStand)) continue;
            DeleteArmorStands.mc.world.removeEntity(llIlIIlIIlIllll);
        }
    }
}

