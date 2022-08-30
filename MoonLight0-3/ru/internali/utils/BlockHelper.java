/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockStainedHardenedClay
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.math.BlockPos
 */
package ru.internali.utils;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStainedHardenedClay;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;

public class BlockHelper {
    static /* synthetic */ Minecraft mc;

    public static boolean IsValidBlockPoss(BlockPos lllIllIllIIIlII) {
        IBlockState lllIllIllIIIlIl = BlockHelper.mc.world.func_180495_p(lllIllIllIIIlII);
        if (lllIllIllIIIlIl.getBlock() instanceof BlockStainedHardenedClay) {
            return BlockHelper.mc.world.func_180495_p(lllIllIllIIIlII.up()).getBlock() == Blocks.AIR;
        }
        return false;
    }

    public static ArrayList getBlocks(int lllIllIlllIIlIl, int lllIllIlllIIlII, int lllIllIlllIIIll) {
        BlockPos lllIllIlllIIlll = new BlockPos(BlockHelper.mc.player.field_70165_t - (double)lllIllIlllIIlIl, BlockHelper.mc.player.field_70163_u - (double)lllIllIlllIIlII, BlockHelper.mc.player.field_70161_v - (double)lllIllIlllIIIll);
        BlockPos lllIllIlllIIllI = new BlockPos(BlockHelper.mc.player.field_70165_t + (double)lllIllIlllIIlIl, BlockHelper.mc.player.field_70163_u + (double)lllIllIlllIIlII, BlockHelper.mc.player.field_70161_v + (double)lllIllIlllIIIll);
        return BlockHelper.getAllInBox(lllIllIlllIIlll, lllIllIlllIIllI);
    }

    public static List getSphere(BlockPos lllIlllIIIIIlll, float lllIllIllllllIl, int lllIllIllllllII, boolean lllIlllIIIIIlII, boolean lllIllIlllllIlI) {
        ArrayList<BlockPos> lllIlllIIIIIIlI = new ArrayList<BlockPos>();
        int lllIlllIIIIIIIl = lllIlllIIIIIlll.func_177958_n();
        int lllIlllIIIIIIII = lllIlllIIIIIlll.func_177956_o();
        int lllIllIllllllll = lllIlllIIIIIlll.func_177952_p();
        for (float lllIlllIIIIlIII = (float)lllIlllIIIIIIIl - lllIllIllllllIl; lllIlllIIIIlIII <= (float)lllIlllIIIIIIIl + lllIllIllllllIl; lllIlllIIIIlIII += 1.0f) {
            for (float lllIlllIIIIlIIl = (float)lllIllIllllllll - lllIllIllllllIl; lllIlllIIIIlIIl <= (float)lllIllIllllllll + lllIllIllllllIl; lllIlllIIIIlIIl += 1.0f) {
                float lllIlllIIIIlIlI;
                float lllIlllIIIIlIll = lllIllIlllllIlI ? (float)lllIlllIIIIIIII - lllIllIllllllIl : (float)lllIlllIIIIIIII;
                float f = lllIlllIIIIlIlI = lllIllIlllllIlI ? (float)lllIlllIIIIIIII + lllIllIllllllIl : (float)(lllIlllIIIIIIII + lllIllIllllllII);
                if (!(lllIlllIIIIlIll < lllIlllIIIIlIlI)) continue;
                float lllIlllIIIIllII = ((float)lllIlllIIIIIIIl - lllIlllIIIIlIII) * ((float)lllIlllIIIIIIIl - lllIlllIIIIlIII) + ((float)lllIllIllllllll - lllIlllIIIIlIIl) * ((float)lllIllIllllllll - lllIlllIIIIlIIl) + (lllIllIlllllIlI ? ((float)lllIlllIIIIIIII - lllIlllIIIIlIll) * ((float)lllIlllIIIIIIII - lllIlllIIIIlIll) : 0.0f);
                if (!(!(lllIlllIIIIllII < lllIllIllllllIl * lllIllIllllllIl) || lllIlllIIIIIlII && lllIlllIIIIllII < lllIllIllllllIl - 2.0f * (lllIllIllllllIl - 2.0f))) {
                    BlockPos lllIlllIIIIllIl = new BlockPos((double)lllIlllIIIIlIII, (double)lllIlllIIIIlIll, (double)lllIlllIIIIlIIl);
                    lllIlllIIIIIIlI.add(lllIlllIIIIllIl);
                }
                lllIlllIIIIlIll += 1.0f;
            }
        }
        return lllIlllIIIIIIlI;
    }

    static {
        mc = Minecraft.getMinecraft();
    }

    public static Block getBlock(BlockPos lllIlllIIIlllIl) {
        return BlockHelper.mc.world.func_180495_p(lllIlllIIIlllIl).getBlock();
    }

    public static boolean IsValidBlockPos(Object lllIllIllIIIIIl) {
        return BlockHelper.IsValidBlockPoss((BlockPos)lllIllIllIIIIIl);
    }

    public BlockHelper() {
        BlockHelper lllIlllIIlIIIII;
    }

    public static ArrayList getAllInBox(BlockPos lllIllIllIlIIII, BlockPos lllIllIllIlIlII) {
        ArrayList<BlockPos> lllIllIllIlIIll = new ArrayList<BlockPos>();
        BlockPos lllIllIllIlIIlI = new BlockPos(Math.min(lllIllIllIlIIII.func_177958_n(), lllIllIllIlIlII.func_177958_n()), Math.min(lllIllIllIlIIII.func_177956_o(), lllIllIllIlIlII.func_177956_o()), Math.min(lllIllIllIlIIII.func_177952_p(), lllIllIllIlIlII.func_177952_p()));
        BlockPos lllIllIllIlIIIl = new BlockPos(Math.max(lllIllIllIlIIII.func_177958_n(), lllIllIllIlIlII.func_177958_n()), Math.max(lllIllIllIlIIII.func_177956_o(), lllIllIllIlIlII.func_177956_o()), Math.max(lllIllIllIlIIII.func_177952_p(), lllIllIllIlIlII.func_177952_p()));
        for (int lllIllIllIlIllI = lllIllIllIlIIlI.func_177958_n(); lllIllIllIlIllI <= lllIllIllIlIIIl.func_177958_n(); ++lllIllIllIlIllI) {
            for (int lllIllIllIlIlll = lllIllIllIlIIlI.func_177956_o(); lllIllIllIlIlll <= lllIllIllIlIIIl.func_177956_o(); ++lllIllIllIlIlll) {
                for (int lllIllIllIllIII = lllIllIllIlIIlI.func_177952_p(); lllIllIllIllIII <= lllIllIllIlIIIl.func_177952_p(); ++lllIllIllIllIII) {
                    lllIllIllIlIIll.add(new BlockPos(lllIllIllIlIllI, lllIllIllIlIlll, lllIllIllIllIII));
                }
            }
        }
        return lllIllIllIlIIll;
    }

    public static BlockPos getPlayerPos() {
        return new BlockPos(BlockHelper.mc.player.field_70165_t, BlockHelper.mc.player.field_70163_u, BlockHelper.mc.player.field_70161_v);
    }
}

