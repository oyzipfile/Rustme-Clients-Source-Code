/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketClickWindow
 *  net.minecraft.util.math.BlockPos
 */
package ru.internali.utils;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketClickWindow;
import net.minecraft.util.math.BlockPos;
import ru.internali.utils.MinecraftHelper;

public class PlayerUtil {
    public static void swapInventoryItems(int llIIlIIlllllIl, int llIIlIIlllllII) {
        short llIIlIIllllIll = Minecraft.getMinecraft().player.field_71069_bz.getNextTransactionID(Minecraft.getMinecraft().player.field_71071_by);
        ItemStack llIIlIIllllIlI = Minecraft.getMinecraft().player.field_71069_bz.slotClick(llIIlIIlllllIl, 0, ClickType.PICKUP, (EntityPlayer)Minecraft.getMinecraft().player);
        Minecraft.getMinecraft().player.connection.sendPacket((Packet)new CPacketClickWindow(Minecraft.getMinecraft().player.field_71069_bz.windowId, llIIlIIlllllIl, 0, ClickType.PICKUP, llIIlIIllllIlI, llIIlIIllllIll));
        llIIlIIllllIlI = Minecraft.getMinecraft().player.field_71069_bz.slotClick(llIIlIIlllllII, 0, ClickType.PICKUP, (EntityPlayer)Minecraft.getMinecraft().player);
        Minecraft.getMinecraft().player.connection.sendPacket((Packet)new CPacketClickWindow(Minecraft.getMinecraft().player.field_71069_bz.windowId, llIIlIIlllllII, 0, ClickType.PICKUP, llIIlIIllllIlI, llIIlIIllllIll));
        llIIlIIllllIlI = Minecraft.getMinecraft().player.field_71069_bz.slotClick(llIIlIIlllllIl, 0, ClickType.PICKUP, (EntityPlayer)Minecraft.getMinecraft().player);
        Minecraft.getMinecraft().player.connection.sendPacket((Packet)new CPacketClickWindow(Minecraft.getMinecraft().player.field_71069_bz.windowId, llIIlIIlllllIl, 0, ClickType.PICKUP, llIIlIIllllIlI, llIIlIIllllIll));
        Minecraft.getMinecraft().playerController.updateController();
    }

    public static BlockPos GetLocalPlayerPosFloored() {
        return new BlockPos(Math.floor(MinecraftHelper.mc.player.field_70165_t), Math.floor(MinecraftHelper.mc.player.field_70163_u), Math.floor(MinecraftHelper.mc.player.field_70161_v));
    }

    public PlayerUtil() {
        PlayerUtil llIIlIlIIIlIII;
    }

    public static double[] getPlayerMoveVec() {
        float llIIlIIllIIIII = Minecraft.getMinecraft().player.field_70177_z;
        float llIIlIIlIlllll = Minecraft.getMinecraft().player.field_191988_bg;
        float llIIlIIlIllllI = Minecraft.getMinecraft().player.field_70702_br;
        if (llIIlIIlIlllll == 0.0f && llIIlIIlIllllI == 0.0f) {
            return new double[]{0.0, 0.0};
        }
        if (llIIlIIlIlllll > 0.0f) {
            if (llIIlIIlIllllI > 0.0f) {
                llIIlIIllIIIII -= 45.0f;
            } else if (llIIlIIlIllllI < 0.0f) {
                llIIlIIllIIIII += 45.0f;
            }
        } else if (llIIlIIlIlllll < 0.0f) {
            llIIlIIllIIIII -= 180.0f;
            if (llIIlIIlIllllI > 0.0f) {
                llIIlIIllIIIII += 45.0f;
            } else if (llIIlIIlIllllI < 0.0f) {
                llIIlIIllIIIII -= 45.0f;
            }
        } else if (llIIlIIlIllllI > 0.0f) {
            llIIlIIllIIIII -= 90.0f;
        } else if (llIIlIIlIllllI < 0.0f) {
            llIIlIIllIIIII += 90.0f;
        }
        return new double[]{-Math.sin(Math.toRadians(llIIlIIllIIIII)), Math.cos(Math.toRadians(llIIlIIllIIIII))};
    }

    public static void swapItems(int llIIlIlIIIIlIl, int llIIlIlIIIIlII) {
        Minecraft.getMinecraft().playerController.windowClick(Minecraft.getMinecraft().player.field_71069_bz.windowId, llIIlIlIIIIlIl, 0, ClickType.PICKUP, (EntityPlayer)Minecraft.getMinecraft().player);
        Minecraft.getMinecraft().playerController.windowClick(Minecraft.getMinecraft().player.field_71069_bz.windowId, llIIlIlIIIIlII, 0, ClickType.PICKUP, (EntityPlayer)Minecraft.getMinecraft().player);
        Minecraft.getMinecraft().playerController.windowClick(Minecraft.getMinecraft().player.field_71069_bz.windowId, llIIlIlIIIIlIl, 0, ClickType.PICKUP, (EntityPlayer)Minecraft.getMinecraft().player);
        Minecraft.getMinecraft().playerController.updateController();
    }

    public static boolean isPlayerTrapped() {
        BlockPos[] llIIlIIllIlIll;
        BlockPos llIIlIIllIllII = PlayerUtil.GetLocalPlayerPosFloored();
        for (BlockPos llIIlIIllIllIl : llIIlIIllIlIll = new BlockPos[]{llIIlIIllIllII.down(), llIIlIIllIllII.up().up(), llIIlIIllIllII.north(), llIIlIIllIllII.south(), llIIlIIllIllII.east(), llIIlIIllIllII.west(), llIIlIIllIllII.north().up(), llIIlIIllIllII.south().up(), llIIlIIllIllII.east().up(), llIIlIIllIllII.west().up()}) {
            IBlockState llIIlIIllIlllI = MinecraftHelper.mc.world.func_180495_p(llIIlIIllIllIl);
            if (llIIlIIllIlllI.getBlock() == Blocks.OBSIDIAN || MinecraftHelper.mc.world.func_180495_p(llIIlIIllIllIl).getBlock() == Blocks.BEDROCK) continue;
            return false;
        }
        return true;
    }
}

