/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.RenderItem
 *  net.minecraft.entity.Entity
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$Text
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package ru.internali.module.HUD;

import net.minecraft.client.renderer.RenderItem;
import net.minecraft.entity.Entity;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.notifications.notifications;

public class Notifications
extends Module {
    private static /* synthetic */ RenderItem itemRender;
    private /* synthetic */ Entity target;

    public Notifications() {
        super("Notifications", "Notifications", Category.HUD);
        Notifications lIlIIlllIIIIlII;
    }

    @SubscribeEvent
    public void onOverlayRender(RenderGameOverlayEvent.Text lIlIIlllIIIIIlI) {
        notifications.show();
    }
}

