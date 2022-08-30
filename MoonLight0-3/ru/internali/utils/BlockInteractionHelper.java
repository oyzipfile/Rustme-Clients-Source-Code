/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockSlab
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.PlayerControllerMP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 */
package ru.internali.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

public class BlockInteractionHelper {
    private static final /* synthetic */ Minecraft mc;
    public static final /* synthetic */ List<Block> blackList;
    public static final /* synthetic */ List<Item> blackList2;

    public static float[] getRotationsForPosition(double llIIllllllIII, double llIIlllllIlll, double llIIlllllIllI, double llIIlllllIlIl, double llIIllllIIlII, double llIIlllllIIll) {
        double llIIllllIllll;
        double llIIlllllIIlI = llIIllllllIII - llIIlllllIlIl;
        double llIIlllllIIIl = llIIlllllIlll - llIIllllIIlII;
        double llIIlllllIIII = llIIlllllIllI - llIIlllllIIll;
        if (llIIlllllIIII < 0.0 && llIIlllllIIlI < 0.0) {
            double llIIllllllIlI = 90.0 + Math.toDegrees(Math.atan(llIIlllllIIII / llIIlllllIIlI));
        } else if (llIIlllllIIII < 0.0 && llIIlllllIIlI > 0.0) {
            double llIIllllllIIl = -90.0 + Math.toDegrees(Math.atan(llIIlllllIIII / llIIlllllIIlI));
        } else {
            llIIllllIllll = Math.toDegrees(-Math.atan(llIIlllllIIlI / llIIlllllIIII));
        }
        double llIIllllIlllI = Math.sqrt(llIIlllllIIlI * llIIlllllIIlI + llIIlllllIIII * llIIlllllIIII);
        double llIIllllIllIl = -Math.toDegrees(Math.atan(llIIlllllIIIl / llIIllllIlllI));
        llIIllllIllll = BlockInteractionHelper.wrapAngleTo180((float)llIIllllIllll);
        llIIllllIllIl = BlockInteractionHelper.wrapAngleTo180((float)llIIllllIllIl);
        llIIllllIllll = Double.isNaN(llIIllllIllll) ? 0.0 : llIIllllIllll;
        llIIllllIllIl = Double.isNaN(llIIllllIllIl) ? 0.0 : llIIllllIllIl;
        return new float[]{(float)llIIllllIllll, (float)llIIllllIllIl};
    }

    public static ValidResult valid(BlockPos llIIllIllIIll, boolean llIIllIllIIlI) {
        if (BlockInteractionHelper.mc.world == null) {
            return ValidResult.NoEntityCollision;
        }
        if (!BlockInteractionHelper.mc.world.func_72855_b(new AxisAlignedBB(llIIllIllIIll)) && !llIIllIllIIlI) {
            return ValidResult.NoEntityCollision;
        }
        if (!BlockInteractionHelper.checkForNeighbours(llIIllIllIIll)) {
            return ValidResult.NoNeighbors;
        }
        IBlockState llIIllIllIIIl = BlockInteractionHelper.mc.world.func_180495_p(llIIllIllIIll);
        if (llIIllIllIIIl.getBlock() == Blocks.AIR) {
            BlockPos[] llIIllIllIlII;
            for (BlockPos llIIllIllIlIl : llIIllIllIlII = new BlockPos[]{llIIllIllIIll.north(), llIIllIllIIll.south(), llIIllIllIIll.east(), llIIllIllIIll.west(), llIIllIllIIll.up(), llIIllIllIIll.down()}) {
                IBlockState llIIllIllIllI = BlockInteractionHelper.mc.world.func_180495_p(llIIllIllIlIl);
                if (llIIllIllIllI.getBlock() == Blocks.AIR) continue;
                for (EnumFacing llIIllIllIlll : EnumFacing.values()) {
                    BlockPos llIIllIlllIII = llIIllIllIIll.offset(llIIllIllIlll);
                    if (!BlockInteractionHelper.mc.world.func_180495_p(llIIllIlllIII).getBlock().canCollideCheck(BlockInteractionHelper.mc.world.func_180495_p(llIIllIlllIII), false)) continue;
                    return ValidResult.Ok;
                }
            }
            return ValidResult.NoNeighbors;
        }
        return ValidResult.AlreadyBlockThere;
    }

    private static Vec3d getEyesPos() {
        return new Vec3d(Minecraft.getMinecraft().player.field_70165_t, Minecraft.getMinecraft().player.field_70163_u + (double)Minecraft.getMinecraft().player.func_70047_e(), Minecraft.getMinecraft().player.field_70161_v);
    }

    public static float[] getFacingRotations(int llIlIIIlIIllI, int llIlIIIlIIlIl, int llIlIIIlIIIII, EnumFacing llIlIIIlIIIll) {
        return BlockInteractionHelper.getFacingRotations(llIlIIIlIIllI, llIlIIIlIIlIl, llIlIIIlIIIII, llIlIIIlIIIll, 1.0);
    }

    public static boolean IsLiquidOrAir(BlockPos llIlIIIlIlllI) {
        IBlockState llIlIIIlIllIl = BlockInteractionHelper.mc.world.func_180495_p(llIlIIIlIlllI);
        return llIlIIIlIllIl.getBlock() == Blocks.WATER || llIlIIIlIllIl.getBlock() == Blocks.LAVA || llIlIIIlIllIl.getBlock() == Blocks.AIR;
    }

    public static float[] getFacingRotations(int llIlIIIIllIIl, int llIlIIIIlIIll, int llIlIIIIlIIlI, EnumFacing llIlIIIIlIIIl, double llIlIIIIlIIII) {
        return BlockInteractionHelper.getRotationsForPosition((double)llIlIIIIllIIl + 0.5 + (double)llIlIIIIlIIIl.getDirectionVec().getX() * llIlIIIIlIIII / 2.0, (double)llIlIIIIlIIll + 0.5 + (double)llIlIIIIlIIIl.getDirectionVec().getY() * llIlIIIIlIIII / 2.0, (double)llIlIIIIlIIlI + 0.5 + (double)llIlIIIIlIIIl.getDirectionVec().getZ() * llIlIIIIlIIII / 2.0);
    }

    public static float[] getRotationsForPosition(double llIlIIIIIllII, double llIlIIIIIlIII, double llIlIIIIIIlll) {
        return BlockInteractionHelper.getRotationsForPosition(llIlIIIIIllII, llIlIIIIIlIII, llIlIIIIIIlll, BlockInteractionHelper.mc.player.field_70165_t, BlockInteractionHelper.mc.player.field_70163_u + (double)BlockInteractionHelper.mc.player.func_70047_e(), BlockInteractionHelper.mc.player.field_70161_v);
    }

    public static ValidResult valid(BlockPos llIlIIlllIlII) {
        return BlockInteractionHelper.valid(llIlIIlllIlII, false);
    }

    public static float wrapAngleTo180(float llIIlllIlllII) {
        llIIlllIlllII %= 360.0f;
        while (llIIlllIlllII >= 180.0f) {
            llIIlllIlllII -= 360.0f;
        }
        while (llIIlllIlllII < -180.0f) {
            llIIlllIlllII += 360.0f;
        }
        return llIIlllIlllII;
    }

    private static PlayerControllerMP getPlayerController() {
        return Minecraft.getMinecraft().playerController;
    }

    public static PlaceResult place(BlockPos llIlIIllIlIll, float llIlIIllIlllI, boolean llIlIIllIlIIl, boolean llIlIIllIlIII) {
        return BlockInteractionHelper.place(llIlIIllIlIll, llIlIIllIlllI, llIlIIllIlIIl, llIlIIllIlIII, false);
    }

    private static IBlockState getState(BlockPos llIlIllIIIIII) {
        return Minecraft.getMinecraft().world.func_180495_p(llIlIllIIIIII);
    }

    public BlockInteractionHelper() {
        BlockInteractionHelper llIlIllllIIII;
    }

    public static float[] getLegitRotations(Vec3d llIlIllIllllI) {
        Vec3d llIlIlllIIlIl = BlockInteractionHelper.getEyesPos();
        double llIlIlllIIlII = llIlIllIllllI.x - llIlIlllIIlIl.x;
        double llIlIlllIIIll = llIlIllIllllI.y - llIlIlllIIlIl.y;
        double llIlIlllIIIlI = llIlIllIllllI.z - llIlIlllIIlIl.z;
        double llIlIlllIIIIl = Math.sqrt(llIlIlllIIlII * llIlIlllIIlII + llIlIlllIIIlI * llIlIlllIIIlI);
        float llIlIlllIIIII = (float)Math.toDegrees(Math.atan2(llIlIlllIIIlI, llIlIlllIIlII)) - 90.0f;
        float llIlIllIlllll = (float)(-Math.toDegrees(Math.atan2(llIlIlllIIIll, llIlIlllIIIIl)));
        return new float[]{Minecraft.getMinecraft().player.field_70177_z + MathHelper.wrapDegrees((float)(llIlIlllIIIII - Minecraft.getMinecraft().player.field_70177_z)), Minecraft.getMinecraft().player.field_70125_A + MathHelper.wrapDegrees((float)(llIlIllIlllll - Minecraft.getMinecraft().player.field_70125_A))};
    }

    static {
        blackList = Arrays.asList(new Block[]{Blocks.ENDER_CHEST, Blocks.CHEST, Blocks.TRAPPED_CHEST, Blocks.CRAFTING_TABLE, Blocks.ANVIL, Blocks.BREWING_STAND, Blocks.HOPPER, Blocks.DROPPER, Blocks.DISPENSER, Blocks.TRAPDOOR, Blocks.ENCHANTING_TABLE});
        blackList2 = Arrays.asList(new Item[]{Items.SLIME_BALL});
        mc = Minecraft.getMinecraft();
    }

    private static void processRightClickBlock(BlockPos llIlIllIIlIlI, EnumFacing llIlIllIIllII, Vec3d llIlIllIIlIII) {
        BlockInteractionHelper.getPlayerController().processRightClickBlock(Minecraft.getMinecraft().player, BlockInteractionHelper.mc.world, llIlIllIIlIlI, llIlIllIIllII, llIlIllIIlIII, EnumHand.MAIN_HAND);
    }

    public static List<BlockPos> getSphere(BlockPos llIlIlIIIlllI, float llIlIlIIIIIll, int llIlIlIIIllII, boolean llIlIlIIIIIIl, boolean llIlIlIIIIIII, int llIlIIlllllll) {
        ArrayList<BlockPos> llIlIlIIIlIII = new ArrayList<BlockPos>();
        int llIlIlIIIIlll = llIlIlIIIlllI.func_177958_n();
        int llIlIlIIIIllI = llIlIlIIIlllI.func_177956_o();
        int llIlIlIIIIlIl = llIlIlIIIlllI.func_177952_p();
        int llIlIlIIIllll = llIlIlIIIIlll - (int)llIlIlIIIIIll;
        while ((float)llIlIlIIIllll <= (float)llIlIlIIIIlll + llIlIlIIIIIll) {
            int llIlIlIIlIIII = llIlIlIIIIlIl - (int)llIlIlIIIIIll;
            while ((float)llIlIlIIlIIII <= (float)llIlIlIIIIlIl + llIlIlIIIIIll) {
                int llIlIlIIlIIIl = llIlIlIIIIIII ? llIlIlIIIIllI - (int)llIlIlIIIIIll : llIlIlIIIIllI;
                while (true) {
                    float f = llIlIlIIlIIIl;
                    float f2 = llIlIlIIIIIII ? (float)llIlIlIIIIllI + llIlIlIIIIIll : (float)(llIlIlIIIIllI + llIlIlIIIllII);
                    if (!(f < f2)) break;
                    double llIlIlIIlIIlI = (llIlIlIIIIlll - llIlIlIIIllll) * (llIlIlIIIIlll - llIlIlIIIllll) + (llIlIlIIIIlIl - llIlIlIIlIIII) * (llIlIlIIIIlIl - llIlIlIIlIIII) + (llIlIlIIIIIII ? (llIlIlIIIIllI - llIlIlIIlIIIl) * (llIlIlIIIIllI - llIlIlIIlIIIl) : 0);
                    if (!(!(llIlIlIIlIIlI < (double)(llIlIlIIIIIll * llIlIlIIIIIll)) || llIlIlIIIIIIl && llIlIlIIlIIlI < (double)((llIlIlIIIIIll - 1.0f) * (llIlIlIIIIIll - 1.0f)))) {
                        llIlIlIIIlIII.add(new BlockPos(llIlIlIIIllll, llIlIlIIlIIIl + llIlIIlllllll, llIlIlIIlIIII));
                    }
                    ++llIlIlIIlIIIl;
                }
                ++llIlIlIIlIIII;
            }
            ++llIlIlIIIllll;
        }
        return llIlIlIIIlIII;
    }

    public static PlaceResult place(BlockPos llIlIIlIIIIll, float llIlIIlIIlIll, boolean llIlIIlIIIIIl, boolean llIlIIlIIIIII, boolean llIlIIIllllll) {
        ValidResult llIlIIlIlIlII;
        IBlockState llIlIIlIIIlll = BlockInteractionHelper.mc.world.func_180495_p(llIlIIlIIIIll);
        boolean llIlIIlIIIllI = llIlIIlIIIlll.func_185904_a().isReplaceable();
        boolean llIlIIlIIIlIl = llIlIIlIIIlll.getBlock() instanceof BlockSlab;
        if (!llIlIIlIIIllI && !llIlIIlIIIlIl) {
            return PlaceResult.NotReplaceable;
        }
        if (!BlockInteractionHelper.checkForNeighbours(llIlIIlIIIIll)) {
            return PlaceResult.Neighbors;
        }
        if (!llIlIIlIIIlIl && (llIlIIlIlIlII = BlockInteractionHelper.valid(llIlIIlIIIIll)) != ValidResult.Ok && !llIlIIlIIIllI) {
            return PlaceResult.CantPlace;
        }
        if (llIlIIlIIIIII && llIlIIlIIIlIl && !llIlIIlIIIlll.func_185917_h()) {
            return PlaceResult.CantPlace;
        }
        Vec3d llIlIIlIIIlII = new Vec3d(BlockInteractionHelper.mc.player.field_70165_t, BlockInteractionHelper.mc.player.field_70163_u + (double)BlockInteractionHelper.mc.player.func_70047_e(), BlockInteractionHelper.mc.player.field_70161_v);
        for (EnumFacing llIlIIlIIllIl : EnumFacing.values()) {
            EnumActionResult llIlIIlIlIIIl;
            Vec3d llIlIIlIlIIII;
            BlockPos llIlIIlIIllll = llIlIIlIIIIll.offset(llIlIIlIIllIl);
            EnumFacing llIlIIlIIlllI = llIlIIlIIllIl.getOpposite();
            if (!BlockInteractionHelper.mc.world.func_180495_p(llIlIIlIIllll).getBlock().canCollideCheck(BlockInteractionHelper.mc.world.func_180495_p(llIlIIlIIllll), false) || !(llIlIIlIIIlII.distanceTo(llIlIIlIlIIII = new Vec3d((Vec3i)llIlIIlIIllll).addVector(0.5, 0.5, 0.5).add(new Vec3d(llIlIIlIIlllI.getDirectionVec()).scale(0.5))) <= (double)llIlIIlIIlIll)) continue;
            Block llIlIIlIlIIll = BlockInteractionHelper.mc.world.func_180495_p(llIlIIlIIllll).getBlock();
            boolean llIlIIlIlIIlI = llIlIIlIlIIll.onBlockActivated((World)BlockInteractionHelper.mc.world, llIlIIlIIIIll, BlockInteractionHelper.mc.world.func_180495_p(llIlIIlIIIIll), (EntityPlayer)BlockInteractionHelper.mc.player, EnumHand.MAIN_HAND, llIlIIlIIllIl, 0.0f, 0.0f, 0.0f);
            if (blackList.contains((Object)llIlIIlIlIIll) || llIlIIlIlIIlI) {
                BlockInteractionHelper.mc.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)BlockInteractionHelper.mc.player, CPacketEntityAction.Action.START_SNEAKING));
            }
            if (llIlIIlIIIIIl) {
                BlockInteractionHelper.faceVectorPacketInstant(llIlIIlIlIIII);
            }
            if ((llIlIIlIlIIIl = BlockInteractionHelper.mc.playerController.processRightClickBlock(BlockInteractionHelper.mc.player, BlockInteractionHelper.mc.world, llIlIIlIIllll, llIlIIlIIlllI, llIlIIlIlIIII, EnumHand.MAIN_HAND)) == EnumActionResult.FAIL) continue;
            if (llIlIIIllllll) {
                BlockInteractionHelper.mc.player.connection.sendPacket((Packet)new CPacketAnimation(EnumHand.MAIN_HAND));
            } else {
                BlockInteractionHelper.mc.player.swingArm(EnumHand.MAIN_HAND);
            }
            if (llIlIIlIlIIlI) {
                BlockInteractionHelper.mc.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)BlockInteractionHelper.mc.player, CPacketEntityAction.Action.STOP_SNEAKING));
            }
            return PlaceResult.Placed;
        }
        return PlaceResult.CantPlace;
    }

    public static boolean hasNeighbour(BlockPos llIlIlIlIIlll) {
        for (EnumFacing llIlIlIlIlIII : EnumFacing.values()) {
            BlockPos llIlIlIlIlIIl = llIlIlIlIIlll.offset(llIlIlIlIlIII);
            if (Minecraft.getMinecraft().world.func_180495_p(llIlIlIlIlIIl).func_185904_a().isReplaceable()) continue;
            return true;
        }
        return false;
    }

    private static Block getBlock(BlockPos llIlIllIIIIll) {
        return BlockInteractionHelper.getState(llIlIllIIIIll).getBlock();
    }

    public static boolean canBeClicked(BlockPos llIlIllIIIllI) {
        return BlockInteractionHelper.getBlock(llIlIllIIIllI).canCollideCheck(BlockInteractionHelper.getState(llIlIllIIIllI), false);
    }

    public static void faceVectorPacketInstant(Vec3d llIlIllIlIIlI) {
        float[] llIlIllIlIIll = BlockInteractionHelper.getLegitRotations(llIlIllIlIIlI);
        Minecraft.getMinecraft().player.connection.sendPacket((Packet)new CPacketPlayer.Rotation(llIlIllIlIIll[0], llIlIllIlIIll[1], Minecraft.getMinecraft().player.field_70122_E));
    }

    public static boolean checkForNeighbours(BlockPos llIlIlIllIlIl) {
        if (!BlockInteractionHelper.hasNeighbour(llIlIlIllIlIl)) {
            for (EnumFacing llIlIlIllIlll : EnumFacing.values()) {
                BlockPos llIlIlIlllIII = llIlIlIllIlIl.offset(llIlIlIllIlll);
                if (!BlockInteractionHelper.hasNeighbour(llIlIlIlllIII)) continue;
                return true;
            }
            return false;
        }
        return true;
    }

    public static enum PlaceResult {
        NotReplaceable,
        Neighbors,
        CantPlace,
        Placed;


        private PlaceResult() {
            PlaceResult lIIlIlIlIIIIIIl;
        }
    }

    public static enum ValidResult {
        NoEntityCollision,
        AlreadyBlockThere,
        NoNeighbors,
        Ok;


        private ValidResult() {
            ValidResult llIIIlIIllIIl;
        }
    }
}

