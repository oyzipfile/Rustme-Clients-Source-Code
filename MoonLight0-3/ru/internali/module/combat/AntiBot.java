/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.entity.EntityOtherPlayerMP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.math.BlockPos
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package ru.internali.module.combat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;

public class AntiBot
extends Module {
    public static /* synthetic */ List<String> BOTS;
    public static /* synthetic */ boolean toggle;

    @Override
    public void onDisable() {
        AntiBot lIIllIllllIllII;
        super.onDisable();
        toggle = false;
        BOTS.clear();
    }

    @Override
    public void onEnable() {
        AntiBot lIIllIlllllIIII;
        super.onEnable();
        toggle = true;
    }

    public static IBlockState getState(BlockPos lIIllIllllIIIll) {
        return AntiBot.mc.world.func_180495_p(lIIllIllllIIIll);
    }

    @SubscribeEvent
    public void onTick(TickEvent.PlayerTickEvent lIIllIlllIlllII) {
        AntiBot lIIllIlllIllIlI;
        boolean lIIllIlllIllIll = CatClient.instance.settingsManager.getSettingByName(lIIllIlllIllIlI, "Remove").getValBoolean();
        for (Entity lIIllIlllIllllI : AntiBot.mc.world.field_72996_f) {
            if (lIIllIlllIllllI == AntiBot.mc.player || lIIllIlllIllllI.ticksExisted >= 5 || !(lIIllIlllIllllI instanceof EntityOtherPlayerMP) || !(AntiBot.mc.player.func_70068_e(lIIllIlllIllllI) <= 15.0)) continue;
            if (AntiBot.isBlockMaterial(new BlockPos(lIIllIlllIllllI).down())) {
                BOTS.add(lIIllIlllIllllI.getName());
                if (lIIllIlllIllIll) {
                    AntiBot.mc.world.removeEntity(lIIllIlllIllllI);
                }
            }
            if (!lIIllIlllIllllI.isInvisible()) continue;
            BOTS.add(lIIllIlllIllllI.getName());
            if (!lIIllIlllIllIll) continue;
            AntiBot.mc.world.removeEntity(lIIllIlllIllllI);
        }
    }

    public static Block getBlock(BlockPos lIIllIllllIIllI) {
        return AntiBot.getState(lIIllIllllIIllI).getBlock();
    }

    static {
        BOTS = new ArrayList<String>();
    }

    @SubscribeEvent
    public void onUpdate(RenderWorldLastEvent lIIllIlllIlIIII) {
        AntiBot lIIllIlllIlIIIl;
        boolean lIIllIlllIIllll = CatClient.instance.settingsManager.getSettingByName(lIIllIlllIlIIIl, "TickRemove").getValBoolean();
        for (Entity lIIllIlllIlIIlI : AntiBot.mc.world.field_72996_f) {
            if (!(lIIllIlllIlIIlI instanceof EntityPlayer) || !lIIllIlllIlIIlI.isInvisible() || lIIllIlllIlIIlI == AntiBot.mc.player || !lIIllIlllIIllll) continue;
            AntiBot.mc.world.removeEntity(lIIllIlllIlIIlI);
        }
    }

    public static boolean isBot(String lIIllIlllllIlII) {
        if (toggle) {
            String lIIllIlllllIllI;
            Iterator<String> lIIllIlllllIlll = BOTS.iterator();
            do {
                if (lIIllIlllllIlll.hasNext()) continue;
                return false;
            } while (!(lIIllIlllllIllI = lIIllIlllllIlll.next()).equalsIgnoreCase(lIIllIlllllIlII));
            return true;
        }
        return false;
    }

    public static boolean isBlockMaterial(BlockPos lIIllIllllIlIlI) {
        return AntiBot.getBlock(lIIllIllllIlIlI) == Blocks.AIR;
    }

    public AntiBot() {
        super("AntiBot", "Prevents you from targetting bots", Category.COMBAT);
        AntiBot lIIllIlllllllII;
        CatClient.instance.settingsManager.rSetting(new Setting("Remove", lIIllIlllllllII, true));
        CatClient.instance.settingsManager.rSetting(new Setting("TickRemove", lIIllIlllllllII, true));
    }
}

