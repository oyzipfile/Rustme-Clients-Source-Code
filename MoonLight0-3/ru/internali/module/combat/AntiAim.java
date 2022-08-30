/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 *  org.lwjgl.input.Mouse
 */
package ru.internali.module.combat;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Mouse;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.utils.MathUtils;

public class AntiAim
extends Module {
    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent llllllIIIllIllI) {
        if (!(Mouse.isButtonDown((int)0) || Mouse.isButtonDown((int)1) || Mouse.isButtonDown((int)2))) {
            float llllllIIIlllIII;
            float llllllIIIlllIIl = 90.0f;
            AntiAim.mc.player.field_70759_as = llllllIIIlllIII = (float)((double)AntiAim.mc.player.field_70177_z + MathUtils.getRandomInRange(25.0, -25.0));
            AntiAim.mc.player.field_70761_aq = llllllIIIlllIII;
        }
    }

    public AntiAim() {
        super("AntiAim", "AntiAim", Category.COMBAT);
        AntiAim llllllIIIllllIl;
    }
}

