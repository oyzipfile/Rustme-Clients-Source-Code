/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.client.renderer.InventoryEffectRenderer
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.init.Enchantments
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.inventory.EntityEquipmentSlot
 *  net.minecraft.item.ItemArmor
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.DamageSource
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package ru.internali.module.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.utils.TimerUtils;

public class AutoArmor
extends Module {
    public /* synthetic */ TimerUtils timer;

    public AutoArmor() {
        super("AutoArmor", "AutoArmor", Category.OUTHER);
        AutoArmor lIIIllllllIlIII;
        lIIIllllllIlIII.timer = new TimerUtils();
    }

    public static boolean isNullOrEmpty(ItemStack lIIIllllIIlllII) {
        return lIIIllllIIlllII == null;
    }

    @SubscribeEvent
    public void onClientTickEvent(TickEvent.ClientTickEvent lIIIlllllIIlIll) {
        block11: {
            block10: {
                if (!(AutoArmor.mc.currentScreen instanceof GuiContainer)) break block10;
                if (!(AutoArmor.mc.currentScreen instanceof InventoryEffectRenderer)) break block11;
            }
            InventoryPlayer lIIIlllllIIllIl = AutoArmor.mc.player.field_71071_by;
            if (AutoArmor.mc.player.movementInput.moveStrafe == 0.0f) {
                if (AutoArmor.mc.player.movementInput.moveStrafe == 0.0f) {
                    AutoArmor lIIIlllllIIllII;
                    int lIIIlllllIlIIIl;
                    int[] lIIIlllllIlIIll = new int[4];
                    int[] lIIIlllllIlIIlI = new int[4];
                    for (lIIIlllllIlIIIl = 0; lIIIlllllIlIIIl < 4; ++lIIIlllllIlIIIl) {
                        lIIIlllllIlIIll[lIIIlllllIlIIIl] = -1;
                        ItemStack lIIIlllllIllIlI = lIIIlllllIIllIl.armorItemInSlot(lIIIlllllIlIIIl);
                        if (AutoArmor.isNullOrEmpty(lIIIlllllIllIlI) || !(lIIIlllllIllIlI.getItem() instanceof ItemArmor)) continue;
                        ItemArmor lIIIlllllIllIll = (ItemArmor)lIIIlllllIllIlI.getItem();
                        lIIIlllllIlIIlI[lIIIlllllIlIIIl] = lIIIlllllIIllII.getArmorValue(lIIIlllllIllIll, lIIIlllllIllIlI);
                    }
                    for (lIIIlllllIlIIIl = 0; lIIIlllllIlIIIl < 36; ++lIIIlllllIlIIIl) {
                        ItemStack lIIIlllllIlIllI = lIIIlllllIIllIl.getStackInSlot(lIIIlllllIlIIIl);
                        if (AutoArmor.isNullOrEmpty(lIIIlllllIlIllI) || !(lIIIlllllIlIllI.getItem() instanceof ItemArmor)) continue;
                        ItemArmor lIIIlllllIllIII = (ItemArmor)lIIIlllllIlIllI.getItem();
                        int lIIIlllllIllIIl = lIIIlllllIllIII.armorType.getIndex();
                        int lIIIlllllIlIlll = lIIIlllllIIllII.getArmorValue(lIIIlllllIllIII, lIIIlllllIlIllI);
                        if (lIIIlllllIlIlll <= lIIIlllllIlIIlI[lIIIlllllIllIIl]) continue;
                        lIIIlllllIlIIll[lIIIlllllIllIIl] = lIIIlllllIlIIIl;
                        lIIIlllllIlIIlI[lIIIlllllIllIIl] = lIIIlllllIlIlll;
                    }
                    ArrayList<Integer> lIIIlllllIIllll = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3));
                    Collections.shuffle(lIIIlllllIIllll);
                    for (int lIIIlllllIlIIII : lIIIlllllIIllll) {
                        ItemStack lIIIlllllIlIlII;
                        int lIIIlllllIlIlIl = lIIIlllllIlIIll[lIIIlllllIlIIII];
                        if (lIIIlllllIlIlIl == -1 || !AutoArmor.isNullOrEmpty(lIIIlllllIlIlII = lIIIlllllIIllIl.armorItemInSlot(lIIIlllllIlIIII)) && lIIIlllllIIllIl.getFirstEmptyStack() == -1) continue;
                        if (lIIIlllllIlIlIl < 9) {
                            lIIIlllllIlIlIl += 36;
                        }
                        if (!AutoArmor.isNullOrEmpty(lIIIlllllIlIlII)) {
                            AutoArmor.mc.playerController.windowClick(0, 8 - lIIIlllllIlIIII, 0, ClickType.QUICK_MOVE, (EntityPlayer)AutoArmor.mc.player);
                        }
                        AutoArmor.mc.playerController.windowClick(0, lIIIlllllIlIlIl, 0, ClickType.QUICK_MOVE, (EntityPlayer)AutoArmor.mc.player);
                        break;
                    }
                }
            }
        }
    }

    int getArmorValue(ItemArmor lIIIllllIllIIlI, ItemStack lIIIllllIlIIllI) {
        int lIIIllllIllIIII = lIIIllllIllIIlI.damageReduceAmount;
        int lIIIllllIlIllll = (int)lIIIllllIllIIlI.toughness;
        int lIIIllllIlIlllI = lIIIllllIllIIlI.getArmorMaterial().getDamageReductionAmount(EntityEquipmentSlot.LEGS);
        Enchantment lIIIllllIlIllIl = Enchantments.PROTECTION;
        int lIIIllllIlIllII = EnchantmentHelper.getEnchantmentLevel((Enchantment)lIIIllllIlIllIl, (ItemStack)lIIIllllIlIIllI);
        EntityPlayerSP lIIIllllIlIlIll = AutoArmor.mc.player;
        DamageSource lIIIllllIlIlIlI = DamageSource.causePlayerDamage((EntityPlayer)lIIIllllIlIlIll);
        int lIIIllllIlIlIIl = lIIIllllIlIllIl.calcModifierDamage(lIIIllllIlIllII, lIIIllllIlIlIlI);
        return lIIIllllIllIIII * 5 + lIIIllllIlIlIIl * 3 + lIIIllllIlIllll + lIIIllllIlIlllI;
    }
}

