/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package ru.internali.module.render;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.utils.RenderUtils;
import ru.internali.utils.Utils;

public class ItemsESP
extends Module {
    /* synthetic */ AxisAlignedBB box;

    public ItemsESP() {
        super("ItemsESP", "AAAAA, light", Category.RENDER);
        ItemsESP lIlllIIlllIIlIl;
    }

    @SubscribeEvent
    public void onRenderWorldLast(RenderWorldLastEvent lIlllIIllIlllII) {
        for (Entity lIlllIIllIllllI : Utils.getEntityList()) {
            if (!(lIlllIIllIllllI instanceof EntityItem) && !(lIlllIIllIllllI instanceof EntityArrow)) continue;
            Entity lIlllIIllIlllll = lIlllIIllIllllI;
            RenderUtils.drawESP(lIlllIIllIlllll, 1.0f, 1.0f, 1.0f, 1.0f, lIlllIIllIlllII.getPartialTicks());
        }
    }
}

