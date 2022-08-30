/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$Post
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package ru.internali.module.render;

import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.utils.RenderUtils;

public class PlayerEntity
extends Module {
    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Post lIlllIIlIIIlIl) {
        switch (lIlllIIlIIIlIl.getType()) {
            case TEXT: {
                RenderUtils.renderEntity((EntityLivingBase)PlayerEntity.mc.player, 30, 40, 100);
                break;
            }
        }
    }

    public PlayerEntity() {
        super("PlayerEntity", "PlayerEntity", Category.RENDER);
        PlayerEntity lIlllIIlIIlIII;
    }
}

