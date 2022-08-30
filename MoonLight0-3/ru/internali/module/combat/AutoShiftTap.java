/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package ru.internali.module.combat;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.w3c.dom.css.Counter;
import ru.internali.module.Category;
import ru.internali.module.Module;

public class AutoShiftTap
extends Module {
    public /* synthetic */ int ticks;
    /* synthetic */ Counter counter;

    @SubscribeEvent
    public void OnPlayerTick(TickEvent.PlayerTickEvent lIIIlllIlllIIll) {
        AutoShiftTap lIIIlllIlllIlII;
        if (AutoShiftTap.mc.gameSettings.keyBindAttack.isKeyDown()) {
            KeyBinding.setKeyBindState((int)AutoShiftTap.mc.gameSettings.keyBindSneak.getKeyCode(), (boolean)true);
            lIIIlllIlllIlII.ticks = 0;
        }
        if (lIIIlllIlllIlII.ticks == 2) {
            KeyBinding.setKeyBindState((int)AutoShiftTap.mc.gameSettings.keyBindSneak.getKeyCode(), (boolean)false);
        }
        ++lIIIlllIlllIlII.ticks;
    }

    public AutoShiftTap() {
        super("AutoShiftTap", "AutoShift", Category.COMBAT);
        AutoShiftTap lIIIlllIllllIlI;
        lIIIlllIllllIlI.ticks = 0;
    }

    @Override
    public void onEnable() {
        AutoShiftTap lIIIlllIlllIlll;
        lIIIlllIlllIlll.ticks = 0;
        MinecraftForge.EVENT_BUS.register((Object)lIIIlllIlllIlll);
    }
}

