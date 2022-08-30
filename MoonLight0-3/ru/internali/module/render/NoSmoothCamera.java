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

public class NoSmoothCamera
extends Module {
    @SubscribeEvent
    public void onUpdate(TickEvent.PlayerTickEvent llllllIlIIIIIIl) {
        NoSmoothCamera.mc.gameSettings.smoothCamera = false;
    }

    public NoSmoothCamera() {
        super("NoSmoothCamera", "NoSmoothCamera", Category.RENDER);
        NoSmoothCamera llllllIlIIIIIll;
    }
}

