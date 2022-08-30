/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.client.Minecraft
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 */
package ru.internali.utils;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class InventoryUtil {
    private static final /* synthetic */ Minecraft mc;

    public InventoryUtil() {
        InventoryUtil llIIIlIlIIIllI;
    }

    public static int getBlocks(Block llIIIlIIIIllll) {
        return InventoryUtil.getItems(Item.getItemFromBlock((Block)llIIIlIIIIllll));
    }

    public static int getItems(Item llIIIlIIIlIIll) {
        return InventoryUtil.mc.player.field_71071_by.mainInventory.stream().filter(llIIIlIIIIIIll -> llIIIlIIIIIIll.getItem() == llIIIlIIIlIIll).mapToInt(ItemStack::getCount).sum() + InventoryUtil.mc.player.field_71071_by.offHandInventory.stream().filter(llIIIlIIIIlIIl -> llIIIlIIIIlIIl.getItem() == llIIIlIIIlIIll).mapToInt(ItemStack::getCount).sum();
    }

    static {
        mc = Minecraft.getMinecraft();
    }

    public static int findItemInHotbar(Item llIIIlIIIllIll) {
        int llIIIlIIIllIlI = -1;
        for (int llIIIlIIIlllII = 0; llIIIlIIIlllII < 9; ++llIIIlIIIlllII) {
            Item llIIIlIIIlllIl;
            ItemStack llIIIlIIIllllI = InventoryUtil.mc.player.field_71071_by.getStackInSlot(llIIIlIIIlllII);
            if (llIIIlIIIllllI == ItemStack.EMPTY || !(llIIIlIIIllllI.getItem() instanceof Item) || !(llIIIlIIIlllIl = llIIIlIIIllllI.getItem()).equals((Object)llIIIlIIIllIll)) continue;
            llIIIlIIIllIlI = llIIIlIIIlllII;
            break;
        }
        return llIIIlIIIllIlI;
    }

    public static int findBlockInHotbarObiEchestRandom() {
        int llIIIlIIlIlIII = -1;
        for (int llIIIlIIlIllll = 0; llIIIlIIlIllll < 9; ++llIIIlIIlIllll) {
            Block llIIIlIIllIIII;
            ItemStack llIIIlIIllIIIl = InventoryUtil.mc.player.field_71071_by.getStackInSlot(llIIIlIIlIllll);
            if (llIIIlIIllIIIl == ItemStack.EMPTY || !(llIIIlIIllIIIl.getItem() instanceof ItemBlock) || !(llIIIlIIllIIII = ((ItemBlock)llIIIlIIllIIIl.getItem()).getBlock()).equals((Object)Blocks.OBSIDIAN)) continue;
            return llIIIlIIlIllll;
        }
        for (int llIIIlIIlIllII = 0; llIIIlIIlIllII < 9; ++llIIIlIIlIllII) {
            Block llIIIlIIlIllIl;
            ItemStack llIIIlIIlIlllI = InventoryUtil.mc.player.field_71071_by.getStackInSlot(llIIIlIIlIllII);
            if (llIIIlIIlIlllI == ItemStack.EMPTY || !(llIIIlIIlIlllI.getItem() instanceof ItemBlock) || !(llIIIlIIlIllIl = ((ItemBlock)llIIIlIIlIlllI.getItem()).getBlock()).equals((Object)Blocks.ENDER_CHEST)) continue;
            return llIIIlIIlIllII;
        }
        for (int llIIIlIIlIlIIl = 0; llIIIlIIlIlIIl < 9; ++llIIIlIIlIlIIl) {
            ItemStack llIIIlIIlIlIll = InventoryUtil.mc.player.field_71071_by.getStackInSlot(llIIIlIIlIlIIl);
            if (llIIIlIIlIlIll == ItemStack.EMPTY || !(llIIIlIIlIlIll.getItem() instanceof ItemBlock)) continue;
            Block llIIIlIIlIlIlI = ((ItemBlock)llIIIlIIlIlIll.getItem()).getBlock();
            return llIIIlIIlIlIIl;
        }
        return llIIIlIIlIlIII;
    }

    public static int findBlockInHotbar(Block llIIIlIIllllII) {
        int llIIIlIIlllIll = -1;
        for (int llIIIlIIllllIl = 0; llIIIlIIllllIl < 9; ++llIIIlIIllllIl) {
            Block llIIIlIIlllllI;
            ItemStack llIIIlIIllllll = InventoryUtil.mc.player.field_71071_by.getStackInSlot(llIIIlIIllllIl);
            if (llIIIlIIllllll == ItemStack.EMPTY || !(llIIIlIIllllll.getItem() instanceof ItemBlock) || !(llIIIlIIlllllI = ((ItemBlock)llIIIlIIllllll.getItem()).getBlock()).equals((Object)llIIIlIIllllII)) continue;
            llIIIlIIlllIll = llIIIlIIllllIl;
            break;
        }
        return llIIIlIIlllIll;
    }
}

