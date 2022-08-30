/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package ru.internali.module.combat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;
import ru.internali.utils.GCDCalcHelper;
import ru.internali.utils.MathematicHelper;

public class AntiHuy
extends Module {
    public static /* synthetic */ List<String> antiAimMode;
    public static /* synthetic */ List<String> degreeMode;
    public static /* synthetic */ List<String> antiAim;
    public /* synthetic */ float rot;

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent lIIIIIlllIIIII) {
        AntiHuy lIIIIIllIllIlI;
        String lIIIIIllIlllll = CatClient.instance.settingsManager.getSettingByName(lIIIIIllIllIlI, "antiAimMode").getValString();
        String lIIIIIllIllllI = CatClient.instance.settingsManager.getSettingByName(lIIIIIllIllIlI, "antiAim").getValString();
        String lIIIIIllIlllIl = CatClient.instance.settingsManager.getSettingByName(lIIIIIllIllIlI, "degreeMode").getValString();
        float lIIIIIllIlllII = (float)CatClient.instance.settingsManager.getSettingByName(lIIIIIllIllIlI, "spinSpeed").getValDouble();
        float lIIIIIllIllIll = lIIIIIllIlllII * 10.0f;
        if (Objects.equals(lIIIIIllIlllll, "Down")) {
            AntiHuy.mc.player.field_70759_as = 90.0f;
        } else if (Objects.equals(lIIIIIllIlllll, "Up")) {
            AntiHuy.mc.player.field_70759_as = 90.0f;
        } else if (Objects.equals(lIIIIIllIlllll, "Fake-Down")) {
            AntiHuy.mc.player.field_70759_as = 90.0f;
        } else if (Objects.equals(lIIIIIllIlllll, "Fake-Up")) {
            AntiHuy.mc.player.field_70759_as = -90.0f;
        }
        if (Objects.equals(lIIIIIllIllllI, "Jitter")) {
            float lIIIIIlllIIllI = AntiHuy.mc.player.field_70177_z + 180.0f + (AntiHuy.mc.player.field_70173_aa % 8 < 4 ? MathematicHelper.randomizeFloat(-90.0f, 90.0f) : -MathematicHelper.randomizeFloat(90.0f, -90.0f));
            AntiHuy.mc.player.field_70759_as = GCDCalcHelper.getFixedRotation(lIIIIIlllIIllI);
            AntiHuy.mc.player.field_70761_aq = lIIIIIlllIIllI;
            AntiHuy.mc.player.field_70759_as = lIIIIIlllIIllI;
        } else if (lIIIIIllIllllI.equals("Freestanding")) {
            float lIIIIIlllIIlIl = (float)((double)(AntiHuy.mc.player.field_70177_z + 5.0f) + Math.random() * 175.0);
            AntiHuy.mc.player.field_70759_as = GCDCalcHelper.getFixedRotation(lIIIIIlllIIlIl);
            AntiHuy.mc.player.field_70761_aq = lIIIIIlllIIlIl;
            AntiHuy.mc.player.field_70759_as = lIIIIIlllIIlIl;
        } else if (lIIIIIllIllllI.equalsIgnoreCase("Spin")) {
            float lIIIIIlllIIlII;
            AntiHuy.mc.player.field_70759_as = lIIIIIlllIIlII = GCDCalcHelper.getFixedRotation((float)(Math.floor(lIIIIIllIllIlI.spinAim(lIIIIIllIllIll)) + (double)MathematicHelper.randomizeFloat(-4.0f, 1.0f)));
            AntiHuy.mc.player.field_70761_aq = lIIIIIlllIIlII;
            AntiHuy.mc.player.field_70759_as = lIIIIIlllIIlII;
        }
        if (AntiHuy.mc.player.isSneaking()) {
            if (Objects.equals(lIIIIIllIlllIl, "Spin")) {
                float lIIIIIlllIIIll;
                AntiHuy.mc.player.field_70759_as = lIIIIIlllIIIll = GCDCalcHelper.getFixedRotation((float)(Math.floor(lIIIIIllIllIlI.spinAim(lIIIIIllIllIll)) + (double)MathematicHelper.randomizeFloat(-4.0f, 1.0f)));
                AntiHuy.mc.player.field_70761_aq = lIIIIIlllIIIll;
                AntiHuy.mc.player.field_70759_as = lIIIIIlllIIIll;
            } else if (lIIIIIllIlllIl.equals("Random")) {
                float lIIIIIlllIIIlI;
                AntiHuy.mc.player.field_70759_as = lIIIIIlllIIIlI = (float)((double)AntiHuy.mc.player.field_70177_z + Math.floor(lIIIIIllIllIlI.spinAim(lIIIIIllIllIll) + (AntiHuy.mc.player.field_70173_aa % 8 < 4 ? MathematicHelper.randomizeFloat(33.0f, 22.0f) : -MathematicHelper.randomizeFloat(33.0f, 22.0f))));
                AntiHuy.mc.player.field_70761_aq = lIIIIIlllIIIlI;
                AntiHuy.mc.player.field_70759_as = lIIIIIlllIIIlI;
            }
        }
    }

    public float spinAim(float lIIIIIllIlIIII) {
        AntiHuy lIIIIIllIlIIIl;
        lIIIIIllIlIIIl.rot += lIIIIIllIlIIII;
        return lIIIIIllIlIIIl.rot;
    }

    public AntiHuy() {
        super("AntiHuy", "Prevents you from targetting bots", Category.COMBAT);
        AntiHuy lIIIIIlllIlllI;
        lIIIIIlllIlllI.rot = 0.0f;
        antiAimMode.add("Down");
        antiAimMode.add("Up");
        antiAimMode.add("Fake-Down");
        antiAimMode.add("Fake-Up");
        antiAimMode.add("None");
        CatClient.instance.settingsManager.rSetting(new Setting("antiAimMode", lIIIIIlllIlllI, "2D", (ArrayList)antiAimMode));
        antiAim.add("Jitter");
        antiAim.add("Freestanding");
        antiAim.add("Spin");
        antiAim.add("None");
        CatClient.instance.settingsManager.rSetting(new Setting("antiAim", lIIIIIlllIlllI, "2D", (ArrayList)antiAim));
        degreeMode.add("Spin");
        degreeMode.add("Random");
        degreeMode.add("None");
        CatClient.instance.settingsManager.rSetting(new Setting("degreeMode", lIIIIIlllIlllI, "2D", (ArrayList)degreeMode));
        CatClient.instance.settingsManager.rSetting(new Setting("spinSpeed", lIIIIIlllIlllI, 1.0, 0.0, 10.0, false));
    }

    static {
        antiAimMode = new ArrayList<String>();
        antiAim = new ArrayList<String>();
        degreeMode = new ArrayList<String>();
    }
}

