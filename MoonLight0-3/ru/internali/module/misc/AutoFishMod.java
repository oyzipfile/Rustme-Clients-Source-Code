/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraftforge.client.event.sound.PlaySoundEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package ru.internali.module.misc;

import java.util.Timer;
import java.util.TimerTask;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.internali.module.Category;
import ru.internali.module.Module;

public class AutoFishMod
extends Module {
    private transient /* synthetic */ Timer timer;

    public AutoFishMod() {
        super("AutoFish", "AutoFishMod", Category.OUTHER);
        AutoFishMod lIIlIIlllIIlIll;
        lIIlIIlllIIlIll.timer = new Timer();
    }

    @SubscribeEvent
    public void onPlaySound(PlaySoundEvent lIIlIIlllIIIllI) {
        if (Minecraft.getMinecraft().player != null && Minecraft.getMinecraft().player.field_71104_cf != null && lIIlIIlllIIIllI.getName().equals("entity.bobber.splash")) {
            AutoFishMod lIIlIIlllIIIlll;
            lIIlIIlllIIIlll.sheduleUse(500);
            lIIlIIlllIIIlll.sheduleUse(1000);
        }
    }

    private void sheduleUse(int lIIlIIllIlllllI) {
        AutoFishMod lIIlIIlllIIIIIl;
        lIIlIIlllIIIIIl.timer.schedule(new TimerTask(){
            {
                1 lllIIIlIlllIIlI;
            }

            @Override
            public void run() {
                KeyBinding.onTick((int)Minecraft.getMinecraft().gameSettings.keyBindUseItem.getKeyCode());
            }
        }, lIIlIIllIlllllI);
    }
}

