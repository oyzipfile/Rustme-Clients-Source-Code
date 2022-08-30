/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package ru.internali.module.misc;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;

public class Spammer
extends Module {
    /* synthetic */ int delay;

    public Spammer() {
        super("Spammer", "DungannonSpammer", Category.OUTHER);
        Spammer llllIIllIlIllll;
        llllIIllIlIllll.delay = 0;
        CatClient.instance.settingsManager.rSetting(new Setting("delaySetting", llllIIllIlIllll, 340.0, 1.0, 1000.0, true));
    }

    private void doMessage() {
        List<String> llllIIllIlIIIlI = Arrays.asList("> 1000-7 ya umer prosti", "> Far4ik Best Developer", "> MoonLight", "> Kitty lox", "> Kitty OneLove", "> 100rub Soft eblet kupi", "> ty chy ricardo user? znachit syn huyni", "> ne yzay govno, uzay MoonLight");
        Random llllIIllIlIIIIl = new Random();
        int llllIIllIlIIIII = llllIIllIlIIIIl.nextInt(llllIIllIlIIIlI.size());
        String llllIIllIIlllll = llllIIllIlIIIlI.get(llllIIllIlIIIII);
        Spammer.mc.player.sendChatMessage(llllIIllIIlllll);
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent llllIIllIlIlIll) {
        Spammer llllIIllIlIllII;
        float llllIIllIlIlIlI = (float)CatClient.instance.settingsManager.getSettingByName(llllIIllIlIllII, "delaySetting").getValDouble();
        ++llllIIllIlIllII.delay;
        if ((float)llllIIllIlIllII.delay > llllIIllIlIlIlI) {
            llllIIllIlIllII.doMessage();
            llllIIllIlIllII.delay = 0;
        }
    }
}

