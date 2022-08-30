/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockStainedHardenedClay
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package ru.internali.module.misc;

import java.util.ArrayList;
import java.util.Comparator;
import net.minecraft.block.BlockStainedHardenedClay;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;
import ru.internali.utils.BlockHelper;
import ru.internali.utils.EntityHelper;
import ru.internali.utils.EventUpdate;
import ru.internali.utils.RenderUtils;
import ru.internali.utils.RotationHelper;
import ru.internali.utils.TimerHelper;

public class AutoFarm
extends Module {
    /* synthetic */ ArrayList posgoto;
    /* synthetic */ TimerHelper timerHelper;

    private static Double lambdaonRender1(BlockPos llIIIlllIllIlll) {
        return EntityHelper.getDistanceOfEntityToBlock((Entity)AutoFarm.mc.player, llIIIlllIllIlll);
    }

    @SubscribeEvent
    public void onRenderWorld(RenderWorldLastEvent llIIIlllIllllIl) {
        float llIIIlllIllllII = (float)CatClient.instance.settingsManager.getSettingByName("Radius").getValDouble();
        BlockPos llIIIlllIlllIll = BlockHelper.getSphere(BlockHelper.getPlayerPos(), llIIIlllIllllII, (int)llIIIlllIllllII, true, false).stream().filter(BlockHelper::IsValidBlockPos).min(Comparator.comparing(AutoFarm::lambdaonRender1)).orElse(null);
        if (llIIIlllIlllIll != null) {
            RenderUtils.blockEspFrame(llIIIlllIlllIll, 148.0f, 0.0f, 211.0f);
        }
    }

    private boolean IsValidBlockPos(BlockPos llIIIllllIlIIlI) {
        IBlockState llIIIllllIlIIll = AutoFarm.mc.world.func_180495_p(llIIIllllIlIIlI);
        if (llIIIllllIlIIll.getBlock() instanceof BlockStainedHardenedClay) {
            return AutoFarm.mc.world.func_180495_p(llIIIllllIlIIlI).getBlock() == Blocks.AIR;
        }
        return false;
    }

    private static Double lambdaonUpdate0(BlockPos llIIIlllIllIlII) {
        return EntityHelper.getDistanceOfEntityToBlock((Entity)AutoFarm.mc.player, llIIIlllIllIlII);
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent llIIIllllIIlIII) {
        float llIIIllllIIIlll = (float)CatClient.instance.settingsManager.getSettingByName("Radius").getValDouble();
        BlockPos llIIIllllIIIllI = BlockHelper.getSphere(BlockHelper.getPlayerPos(), llIIIllllIIIlll, (int)llIIIllllIIIlll, true, false).stream().filter(BlockHelper::IsValidBlockPos).min(Comparator.comparing(AutoFarm::lambdaonUpdate0)).orElse(null);
        if (llIIIllllIIIllI == null) {
            if (AutoFarm.mc.player.field_70173_aa % 100 == 0) {
                // empty if block
            }
            if (AutoFarm.mc.player.field_70173_aa % 25 == 0) {
                // empty if block
            }
            if (AutoFarm.mc.player.field_70123_F && AutoFarm.mc.player.field_70122_E) {
                AutoFarm.mc.player.func_70664_aZ();
            }
        }
        if (llIIIllllIIIllI != null) {
            float[] llIIIllllIIlIlI = RotationHelper.getRotationVector(new Vec3d((double)((float)llIIIllllIIIllI.func_177958_n() + 0.5f), (double)((float)llIIIllllIIIllI.func_177956_o() + 0.85f), (double)((float)llIIIllllIIIllI.func_177952_p() + 0.5f)), false, 2.0f, 2.0f, 360.0f);
            AutoFarm.mc.player.field_70177_z = llIIIllllIIlIlI[0];
            AutoFarm.mc.player.setSprinting(false);
            if (AutoFarm.mc.player.field_70123_F && AutoFarm.mc.player.field_70122_E) {
                AutoFarm.mc.player.func_70664_aZ();
            }
            if (EntityHelper.getDistanceOfEntityToBlock((Entity)AutoFarm.mc.player, llIIIllllIIIllI) < 4.0) {
                AutoFarm llIIIllllIIIlIl;
                float[] llIIIllllIIlIll = RotationHelper.getRotationVector(new Vec3d((double)((float)llIIIllllIIIllI.func_177958_n() + 0.5f), (double)((float)llIIIllllIIIllI.func_177956_o() + 0.85f), (double)((float)llIIIllllIIIllI.func_177952_p() + 0.5f)), false, 2.0f, 2.0f, 360.0f);
                EventUpdate.setYaw(llIIIllllIIlIll[0]);
                EventUpdate.setPitch(llIIIllllIIlIll[1]);
                AutoFarm.mc.player.field_70177_z = llIIIllllIIlIll[0];
                AutoFarm.mc.player.field_70125_A = llIIIllllIIlIll[1];
                if (llIIIllllIIIlIl.timerHelper.hasReached(50.0f)) {
                    AutoFarm.mc.playerController.clickBlock(llIIIllllIIIllI, EnumFacing.UP);
                    llIIIllllIIIlIl.timerHelper.reset();
                }
            }
        }
    }

    public AutoFarm() {
        super("AutoFarm", "AutoFarm", Category.OUTHER);
        AutoFarm llIIIllllIllIII;
        llIIIllllIllIII.timerHelper = new TimerHelper();
        llIIIllllIllIII.posgoto = new ArrayList();
        CatClient.instance.settingsManager.rSetting(new Setting("Radius", llIIIllllIllIII, 100.0, 10.0, 300.0, true));
    }
}

