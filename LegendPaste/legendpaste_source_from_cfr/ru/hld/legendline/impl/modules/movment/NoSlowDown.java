/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.potion.Potion
 */
package ru.hld.legendline.impl.modules.movment;

import net.minecraft.potion.Potion;
import ru.hld.legendline.api.event.EventTarget;
import ru.hld.legendline.api.event.events.EventUpdate;
import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.api.utils.MoveUtils;

public class NoSlowDown
extends Module {
    public NoSlowDown() {
        super("NoSlowDown", "you can aiming and go fast", Category.Movement);
        NoSlowDown llllllllllllllIlIlIlllIIIIlllIll;
    }

    @EventTarget
    public void onUpdate(EventUpdate llllllllllllllIlIlIlllIIIIlllIII) {
        NoSlowDown llllllllllllllIlIlIlllIIIIllIlll;
        if (llllllllllllllIlIlIlllIIIIllIlll.mc.player.isPotionActive(Potion.getPotionById((int)2))) {
            if (llllllllllllllIlIlIlllIIIIllIlll.mc.player.onGround) {
                MoveUtils.setSpeed(0.22f);
            } else {
                MoveUtils.setSpeed(0.25);
            }
        }
    }
}

