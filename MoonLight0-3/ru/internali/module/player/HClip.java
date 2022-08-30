/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 */
package ru.internali.module.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.minecraft.network.play.client.CPacketPlayer;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.module.player.Clip;
import ru.internali.settings.Setting;
import ru.internali.utils.MathUtils;

public class HClip
extends Module {
    public static /* synthetic */ List<String> Modess;

    static {
        Modess = new ArrayList<String>();
    }

    @Override
    public void onEnable() {
        HClip lIlIIllIlIllIl;
        String lIlIIllIllIIII = CatClient.instance.settingsManager.getSettingByName(lIlIIllIlIllIl, "Mode").getValString();
        float lIlIIllIlIllll = (float)CatClient.instance.settingsManager.getSettingByName(lIlIIllIlIllIl, "CLIP").getValDouble();
        float lIlIIllIlIlllI = (float)CatClient.instance.settingsManager.getSettingByName(lIlIIllIlIllIl, "FwDistance").getValDouble();
        if (Objects.equals(lIlIIllIllIIII, "UP")) {
            Clip.mc.player.func_70107_b(Clip.mc.player.field_70165_t, Clip.mc.player.field_70163_u + (double)lIlIIllIlIllll, Clip.mc.player.field_70161_v);
            new CPacketPlayer.Position();
        } else if (Objects.equals(lIlIIllIllIIII, "DOWN")) {
            Clip.mc.player.func_70107_b(Clip.mc.player.field_70165_t, Clip.mc.player.field_70163_u - (double)lIlIIllIlIllll, Clip.mc.player.field_70161_v);
            new CPacketPlayer.Position();
        } else if (Objects.equals(lIlIIllIllIIII, "Forward")) {
            double lIlIIllIllIIll = Double.parseDouble(String.valueOf(lIlIIllIlIlllI));
            double[] lIlIIllIllIIlI = MathUtils.getDirection(HClip.mc.player.field_70177_z);
            Clip.mc.player.func_70107_b(Clip.mc.player.field_70165_t + lIlIIllIllIIlI[0] * lIlIIllIllIIll, Clip.mc.player.field_70163_u, Clip.mc.player.field_70161_v + lIlIIllIllIIlI[1] * lIlIIllIllIIll);
        }
        lIlIIllIlIllIl.setToggled(false);
    }

    @Override
    public void onDisable() {
        HClip lIlIIllIlIIllI;
        super.onDisable();
    }

    public HClip() {
        super("HClip", "Dont use horse", Category.PLAYER);
        HClip lIlIIllIlllIll;
        CatClient.instance.settingsManager.rSetting(new Setting("CLIP", lIlIIllIlllIll, 90.0, 1.0, 255.0, true));
        Modess.add("UP");
        Modess.add("DOWN");
        Modess.add("Forward");
        CatClient.instance.settingsManager.rSetting(new Setting("Mode", lIlIIllIlllIll, "DOWN", (ArrayList)Modess));
        CatClient.instance.settingsManager.rSetting(new Setting("FwDistance", lIlIIllIlllIll, 1.0, -20.0, 255.0, true));
    }
}

