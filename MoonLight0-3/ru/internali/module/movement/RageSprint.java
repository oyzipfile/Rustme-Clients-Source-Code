/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package ru.internali.module.movement;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.module.movement.Sprint;
import ru.internali.utils.MovementHelper;

public class RageSprint
extends Module {
    public static /* synthetic */ Sprint instance;

    @Override
    public void onDisable() {
        RageSprint lIIlIIlIIllIlIl;
        super.onDisable();
        RageSprint.mc.player.setSprinting(false);
    }

    public RageSprint() {
        super("RageSprint", "i like sprinting", Category.MOVEMENT);
        RageSprint lIIlIIlIIlllIIl;
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent lIIlIIlIIllIlll) {
        RageSprint.mc.player.setSprinting(MovementHelper.isMoving());
    }
}

