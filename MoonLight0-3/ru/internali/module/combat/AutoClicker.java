/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  io.netty.util.internal.ThreadLocalRandom
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$RenderTickEvent
 *  org.lwjgl.input.Mouse
 */
package ru.internali.module.combat;

import io.netty.util.internal.ThreadLocalRandom;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Mouse;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;

public class AutoClicker
extends Module {
    private /* synthetic */ double holdLength;
    private /* synthetic */ double min;
    private /* synthetic */ long hold;
    private /* synthetic */ double max;
    private /* synthetic */ double speed;
    private /* synthetic */ long lastClick;

    @Override
    public void onEnable() {
        AutoClicker lIIIlllIllIlII;
        super.onEnable();
        lIIIlllIllIlII.updateVals();
    }

    public AutoClicker() {
        super("AutoClicker", "clicks automatically", Category.COMBAT);
        AutoClicker lIIIlllIlllllI;
        CatClient.instance.settingsManager.rSetting(new Setting("MinCPS", lIIIlllIlllllI, 8.0, 1.0, 20.0, false));
        CatClient.instance.settingsManager.rSetting(new Setting("MaxCPS", lIIIlllIlllllI, 12.0, 1.0, 20.0, false));
    }

    private void updateVals() {
        AutoClicker lIIIlllIllIIII;
        lIIIlllIllIIII.min = CatClient.instance.settingsManager.getSettingByName(lIIIlllIllIIII, "MinCPS").getValDouble();
        lIIIlllIllIIII.max = CatClient.instance.settingsManager.getSettingByName(lIIIlllIllIIII, "MaxCPS").getValDouble();
        if (lIIIlllIllIIII.min >= lIIIlllIllIIII.max) {
            lIIIlllIllIIII.max = lIIIlllIllIIII.min + 1.0;
        }
        lIIIlllIllIIII.speed = 1.0 / ThreadLocalRandom.current().nextDouble(lIIIlllIllIIII.min - 0.2, lIIIlllIllIIII.max);
        lIIIlllIllIIII.holdLength = lIIIlllIllIIII.speed / ThreadLocalRandom.current().nextDouble(lIIIlllIllIIII.min, lIIIlllIllIIII.max);
    }

    @SubscribeEvent
    public void onTick(TickEvent.RenderTickEvent lIIIlllIlllIII) {
        if (Mouse.isButtonDown((int)0)) {
            AutoClicker lIIIlllIlllIIl;
            if ((double)(System.currentTimeMillis() - lIIIlllIlllIIl.lastClick) > lIIIlllIlllIIl.speed * 1000.0) {
                lIIIlllIlllIIl.lastClick = System.currentTimeMillis();
                if (lIIIlllIlllIIl.hold < lIIIlllIlllIIl.lastClick) {
                    lIIIlllIlllIIl.hold = lIIIlllIlllIIl.lastClick;
                }
                int lIIIlllIlllIlI = AutoClicker.mc.gameSettings.keyBindAttack.getKeyCode();
                KeyBinding.setKeyBindState((int)lIIIlllIlllIlI, (boolean)true);
                KeyBinding.onTick((int)lIIIlllIlllIlI);
                lIIIlllIlllIIl.updateVals();
            } else if ((double)(System.currentTimeMillis() - lIIIlllIlllIIl.hold) > lIIIlllIlllIIl.holdLength * 1000.0) {
                KeyBinding.setKeyBindState((int)AutoClicker.mc.gameSettings.keyBindAttack.getKeyCode(), (boolean)false);
                lIIIlllIlllIIl.updateVals();
            }
        }
    }
}

