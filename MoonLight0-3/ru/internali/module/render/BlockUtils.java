/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 */
package ru.internali.module.render;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import ru.internali.utils.Wrapper;

public class BlockUtils {
    private static /* synthetic */ Minecraft mc;

    public BlockUtils() {
        BlockUtils lllIIllIIIIIIlI;
    }

    public static List<BlockPos> getBlocksInDistance(float lllIIlIllllllIl) {
        ArrayList<BlockPos> lllIIlIlllllllI = new ArrayList<BlockPos>();
        BlockPos.getAllInBox((BlockPos)new BlockPos(BlockUtils.mc.player.field_70165_t - (double)lllIIlIllllllIl, BlockUtils.mc.player.field_70163_u - (double)lllIIlIllllllIl, BlockUtils.mc.player.field_70161_v - (double)lllIIlIllllllIl), (BlockPos)new BlockPos(BlockUtils.mc.player.field_70165_t + (double)lllIIlIllllllIl, BlockUtils.mc.player.field_70163_u + (double)lllIIlIllllllIl, BlockUtils.mc.player.field_70161_v + (double)lllIIlIllllllIl)).forEach(lllIIlIlllllllI::add);
        return lllIIlIlllllllI;
    }

    public static LinkedList<BlockPos> findBlocksNearEntity(EntityLivingBase lllIIlIllIlIIIl, int lllIIlIllIlIIII, int lllIIlIllIIllll, int lllIIlIllIIlIlI) {
        LinkedList<BlockPos> lllIIlIllIIllIl = new LinkedList<BlockPos>();
        for (int lllIIlIllIlIIlI = (int)Wrapper.INSTANCE.player().field_70165_t - lllIIlIllIIlIlI; lllIIlIllIlIIlI <= (int)Wrapper.INSTANCE.player().field_70165_t + lllIIlIllIIlIlI; ++lllIIlIllIlIIlI) {
            for (int lllIIlIllIlIIll = (int)Wrapper.INSTANCE.player().field_70161_v - lllIIlIllIIlIlI; lllIIlIllIlIIll <= (int)Wrapper.INSTANCE.player().field_70161_v + lllIIlIllIIlIlI; ++lllIIlIllIlIIll) {
                int lllIIlIllIlIlII = Wrapper.INSTANCE.world().func_189649_b(lllIIlIllIlIIlI, lllIIlIllIlIIll);
                for (int lllIIlIllIlIlIl = 0; lllIIlIllIlIlIl <= lllIIlIllIlIlII; ++lllIIlIllIlIlIl) {
                    BlockPos lllIIlIllIllIIl = new BlockPos(lllIIlIllIlIIlI, lllIIlIllIlIlIl, lllIIlIllIlIIll);
                    IBlockState lllIIlIllIllIII = Wrapper.INSTANCE.world().func_180495_p(lllIIlIllIllIIl);
                    if (lllIIlIllIlIIII == -1 || lllIIlIllIIllll == -1) {
                        lllIIlIllIIllIl.add(lllIIlIllIllIIl);
                        continue;
                    }
                    int lllIIlIllIlIlll = Block.getIdFromBlock((Block)lllIIlIllIllIII.getBlock());
                    int lllIIlIllIlIllI = lllIIlIllIllIII.getBlock().getMetaFromState(lllIIlIllIllIII);
                    if (lllIIlIllIlIlll != lllIIlIllIlIIII || lllIIlIllIlIllI != lllIIlIllIIllll) continue;
                    lllIIlIllIIllIl.add(lllIIlIllIllIIl);
                }
            }
        }
        return lllIIlIllIIllIl;
    }

    public float[] getRotations(BlockPos lllIIlIlllIllII) {
        double lllIIlIllllIIlI = (double)lllIIlIlllIllII.func_177958_n() - BlockUtils.mc.player.field_70165_t;
        double lllIIlIllllIIIl = (double)lllIIlIlllIllII.func_177952_p() - BlockUtils.mc.player.field_70161_v;
        double lllIIlIllllIIII = (double)lllIIlIlllIllII.func_177956_o() - (BlockUtils.mc.player.field_70163_u + (double)BlockUtils.mc.player.func_70047_e());
        double lllIIlIlllIllll = MathHelper.sqrt((double)(lllIIlIllllIIlI * lllIIlIllllIIlI + lllIIlIllllIIIl * lllIIlIllllIIIl));
        float lllIIlIlllIlllI = (float)(Math.atan2(lllIIlIllllIIIl, lllIIlIllllIIlI) * 180.0 / Math.PI);
        float lllIIlIlllIllIl = (float)(-(Math.atan2(lllIIlIlllIlllI, lllIIlIlllIllll) * 180.0 / Math.PI));
        return new float[]{lllIIlIlllIlllI, lllIIlIlllIllIl};
    }

    static {
        mc = Minecraft.getMinecraft();
    }
}

