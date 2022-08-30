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
import ru.internali.settings.Setting;
import ru.internali.utils.MathUtils;

public class Clip
extends Module {
    public static /* synthetic */ List<String> Modess;

    static {
        Modess = new ArrayList<String>();
    }

    @Override
    public void onEnable() {
        Clip lIIIIlIlIllIIII;
        String lIIIIlIlIllIIll = CatClient.instance.settingsManager.getSettingByName(lIIIIlIlIllIIII, "Mode").getValString();
        float lIIIIlIlIllIIlI = (float)CatClient.instance.settingsManager.getSettingByName(lIIIIlIlIllIIII, "FwDistance").getValDouble();
        float lIIIIlIlIllIIIl = (float)CatClient.instance.settingsManager.getSettingByName(lIIIIlIlIllIIII, "CLIP").getValDouble();
        if (Clip.mc.player.func_184187_bx() != null) {
            if (Objects.equals(lIIIIlIlIllIIll, "UP")) {
                new CPacketPlayer.Position();
                Objects.requireNonNull(Clip.mc.player.func_184187_bx()).setPosition(Clip.mc.player.func_184187_bx().posX, Clip.mc.player.func_184187_bx().posY + (double)lIIIIlIlIllIIIl, Clip.mc.player.func_184187_bx().posZ);
            } else if (Objects.equals(lIIIIlIlIllIIll, "DOWN")) {
                new CPacketPlayer.Position();
                Objects.requireNonNull(Clip.mc.player.func_184187_bx()).setPosition(Clip.mc.player.func_184187_bx().posX, Clip.mc.player.func_184187_bx().posY - (double)lIIIIlIlIllIIIl, Clip.mc.player.func_184187_bx().posZ);
            } else if (Objects.equals(lIIIIlIlIllIIll, "Forward")) {
                new CPacketPlayer.Position();
                Objects.requireNonNull(Clip.mc.player.func_184187_bx()).setPosition(Clip.mc.player.func_184187_bx().posX, Clip.mc.player.func_184187_bx().posY - (double)lIIIIlIlIllIIIl, Clip.mc.player.func_184187_bx().posZ);
                double lIIIIlIlIllIllI = Double.parseDouble(String.valueOf(lIIIIlIlIllIIlI));
                double[] lIIIIlIlIllIlIl = MathUtils.getDirection(Clip.mc.player.field_70177_z);
                Objects.requireNonNull(Clip.mc.player.func_184187_bx()).setPosition(Clip.mc.player.func_184187_bx().posX + lIIIIlIlIllIlIl[0] * lIIIIlIlIllIllI, Clip.mc.player.func_184187_bx().posY, Clip.mc.player.func_184187_bx().posZ + lIIIIlIlIllIlIl[1] * lIIIIlIlIllIllI);
            }
        }
        lIIIIlIlIllIIII.setToggled(false);
    }

    @Override
    public void onDisable() {
        Clip lIIIIlIlIlIlIII;
        super.onDisable();
    }

    public Clip() {
        super("Clip", "Clip", Category.PLAYER);
        Clip lIIIIlIlIllllIl;
        CatClient.instance.settingsManager.rSetting(new Setting("CLIP", lIIIIlIlIllllIl, 90.0, 1.0, 255.0, true));
        Modess.add("UP");
        Modess.add("DOWN");
        Modess.add("Forward");
        CatClient.instance.settingsManager.rSetting(new Setting("Mode", lIIIIlIlIllllIl, "DOWN", (ArrayList)Modess));
        CatClient.instance.settingsManager.rSetting(new Setting("FwDistance", lIIIIlIlIllllIl, 1.0, -20.0, 255.0, true));
    }
}

