/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.init.Blocks
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketSteerBoat
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.TextFormatting
 */
package ru.hld.legendline.impl.modules.movment;

import java.util.ArrayList;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketSteerBoat;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import ru.hld.legendline.Client;
import ru.hld.legendline.api.event.EventTarget;
import ru.hld.legendline.api.event.events.EventUpdate;
import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.api.setting.settings.FloatSetting;
import ru.hld.legendline.api.setting.settings.ModeSetting;
import ru.hld.legendline.api.utils.MoveUtils;

public class Jesus
extends Module {
    public /* synthetic */ int o;
    /* synthetic */ FloatSetting speed;
    /* synthetic */ FloatSetting jumps;
    /* synthetic */ ModeSetting mode;

    @Override
    public void onEnable() {
        Jesus llllllllllllllIIIIIlllIlIIIlIIIl;
        super.onEnable();
        llllllllllllllIIIIIlllIlIIIlIIIl.o = 0;
    }

    @EventTarget
    public void onUpdate(EventUpdate llllllllllllllIIIIIlllIlIIIIIllI) {
        Jesus llllllllllllllIIIIIlllIlIIIIIlll;
        llllllllllllllIIIIIlllIlIIIIIlll.setDisplayname(String.valueOf(new StringBuilder().append(llllllllllllllIIIIIlllIlIIIIIlll.getName()).append(" ").append((Object)TextFormatting.WHITE).append(llllllllllllllIIIIIlllIlIIIIIlll.mode.getVal())));
        switch (llllllllllllllIIIIIlllIlIIIIIlll.mode.getVal()) {
            case "MiniJump": {
                if (llllllllllllllIIIIIlllIlIIIIIlll.mc.player.isSneaking()) {
                    return;
                }
                if (llllllllllllllIIIIIlllIlIIIIIlll.mc.world.getBlockState(new BlockPos(llllllllllllllIIIIIlllIlIIIIIlll.mc.player.posX, llllllllllllllIIIIIlllIlIIIIIlll.mc.player.posY + 0.03, llllllllllllllIIIIIlllIlIIIIIlll.mc.player.posZ)).getBlock() == Blocks.WATER) {
                    llllllllllllllIIIIIlllIlIIIIIlll.mc.getConnection().sendPacket((Packet)new CPacketSteerBoat());
                    llllllllllllllIIIIIlllIlIIIIIlll.mc.player.motionY = 0.15f;
                    MoveUtils.setSpeed(llllllllllllllIIIIIlllIlIIIIIlll.speed.getVal() / 100.0f);
                    break;
                }
            }
            case "LongJump": {
                if (llllllllllllllIIIIIlllIlIIIIIlll.mc.player.isInWater()) {
                    if (llllllllllllllIIIIIlllIlIIIIIlll.mc.player.isSneaking()) {
                        return;
                    }
                    if (!((float)llllllllllllllIIIIIlllIlIIIIIlll.o < llllllllllllllIIIIIlllIlIIIIIlll.jumps.getVal() * 3.0f)) break;
                    llllllllllllllIIIIIlllIlIIIIIlll.mc.player.motionY = 0.15f;
                    llllllllllllllIIIIIlllIlIIIIIlll.mc.player.jumpMovementFactor = 0.5f;
                    ++llllllllllllllIIIIIlllIlIIIIIlll.o;
                    break;
                }
                if (llllllllllllllIIIIIlllIlIIIIIlll.mc.world.getBlockState(new BlockPos(llllllllllllllIIIIIlllIlIIIIIlll.mc.player.posX, llllllllllllllIIIIIlllIlIIIIIlll.mc.player.posY + 0.03, llllllllllllllIIIIIlllIlIIIIIlll.mc.player.posZ)).getBlock() != Blocks.WATER || !((float)llllllllllllllIIIIIlllIlIIIIIlll.o > llllllllllllllIIIIIlllIlIIIIIlll.jumps.getVal() * 3.0f - 1.0f)) break;
                llllllllllllllIIIIIlllIlIIIIIlll.mc.player.motionY = 0.15f;
                MoveUtils.setSpeed(llllllllllllllIIIIIlllIlIIIIIlll.speed.getVal() / 100.0f);
            }
        }
    }

    public Jesus() {
        super("Jesus", "you can run in water", Category.Movement);
        Jesus llllllllllllllIIIIIlllIlIIIIllII;
        ArrayList<String> llllllllllllllIIIIIlllIlIIIIllIl = new ArrayList<String>();
        llllllllllllllIIIIIlllIlIIIIllIl.add("MiniJump");
        llllllllllllllIIIIIlllIlIIIIllIl.add("LongJump");
        llllllllllllllIIIIIlllIlIIIIllII.mode = new ModeSetting("Mode", "modes of Jesus", llllllllllllllIIIIIlllIlIIIIllII, llllllllllllllIIIIIlllIlIIIIllIl, "MiniJump");
        Client.settingManager.add(llllllllllllllIIIIIlllIlIIIIllII.mode);
        llllllllllllllIIIIIlllIlIIIIllII.jumps = new FloatSetting("Jumps", "count of jumps", llllllllllllllIIIIIlllIlIIIIllII, 1.0f, 10.0f, 3.0f, 1.0f);
        Client.settingManager.add(llllllllllllllIIIIIlllIlIIIIllII.jumps);
        llllllllllllllIIIIIlllIlIIIIllII.speed = new FloatSetting("Speed", "Speed of mini jumps", llllllllllllllIIIIIlllIlIIIIllII, 1.0f, 25.0f, 13.0f, 1.0f);
        Client.settingManager.add(llllllllllllllIIIIIlllIlIIIIllII.speed);
    }
}

