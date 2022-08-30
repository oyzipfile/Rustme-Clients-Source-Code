/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.event.entity.living.LivingEvent$LivingUpdateEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package ru.internali.module.render;

import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.internali.module.Category;
import ru.internali.module.Module;

public class FullBright
extends Module {
    public static final /* synthetic */ FullBright INSTANCE;
    public /* synthetic */ float oldgamma;

    @Override
    public void onDisable() {
        FullBright lIllIllIIlIllIl;
        super.onDisable();
        FullBright.mc.gameSettings.gammaSetting = lIllIllIIlIllIl.oldgamma;
    }

    static {
        INSTANCE = new FullBright();
    }

    @SubscribeEvent
    public void onLivingUpdate(LivingEvent.LivingUpdateEvent lIllIllIIlIlIlI) {
    }

    public FullBright() {
        super("FullBright", "AAAAA, light", Category.RENDER);
        FullBright lIllIllIIllIIlI;
    }

    @Override
    public void onEnable() {
        FullBright lIllIllIIllIIII;
        super.onEnable();
        lIllIllIIllIIII.oldgamma = FullBright.mc.gameSettings.gammaSetting;
        FullBright.mc.gameSettings.gammaSetting = 100000.0f;
    }
}

