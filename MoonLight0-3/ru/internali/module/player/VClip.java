/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.util.math.MathHelper
 */
package ru.internali.module.player;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.MathHelper;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;

public class VClip
extends Module {
    @Override
    public void onEnable() {
        EntityPlayerSP llIIIllIllIlIIl;
        VClip llIIIllIlllIIII;
        float llIIIllIllIllll = (float)CatClient.instance.settingsManager.getSettingByName(llIIIllIlllIIII, "FwDistance").getValDouble();
        Minecraft llIIIllIllIlllI = Minecraft.getMinecraft();
        double llIIIllIllIllIl = Double.parseDouble(String.valueOf(llIIIllIllIllll));
        float llIIIllIllIllII = (float)Math.toRadians(Minecraft.getMinecraft().player.field_70177_z);
        double llIIIllIllIlIll = (double)(-MathHelper.sin((float)llIIIllIllIllII)) * llIIIllIllIllIl;
        double llIIIllIllIlIlI = (double)MathHelper.cos((float)llIIIllIllIllII) * llIIIllIllIllIl;
        Object object = llIIIllIllIlIIl = llIIIllIllIlllI.player.func_184218_aH() ? llIIIllIllIlllI.player.func_184187_bx() : llIIIllIllIlllI.player;
        if (llIIIllIllIlIIl != null) {
            ((Entity)llIIIllIllIlIIl).setPosition(((Entity)llIIIllIllIlIIl).posX + llIIIllIllIlIll, ((Entity)llIIIllIllIlIIl).posY, ((Entity)llIIIllIllIlIIl).posZ + llIIIllIllIlIlI);
            llIIIllIllIlllI.player.connection.sendPacket((Packet)new CPacketPlayer.Position(((Entity)llIIIllIllIlIIl).posX + llIIIllIllIlIll, ((Entity)llIIIllIllIlIIl).posY, ((Entity)llIIIllIllIlIIl).posZ + llIIIllIllIlIlI, true));
            llIIIllIllIlllI.player.connection.sendPacket((Packet)new CPacketPlayer.Position(((Entity)llIIIllIllIlIIl).posX + llIIIllIllIlIll, ((Entity)llIIIllIllIlIIl).posY, ((Entity)llIIIllIllIlIIl).posZ + llIIIllIllIlIlI, false));
        }
        llIIIllIlllIIII.setToggled(false);
    }

    public VClip() {
        super("VClip", "VClip", Category.PLAYER);
        VClip llIIIllIllllIIl;
        CatClient.instance.settingsManager.rSetting(new Setting("FwDistance", llIIIllIllllIIl, 1.0, -20.0, 255.0, true));
    }
}

