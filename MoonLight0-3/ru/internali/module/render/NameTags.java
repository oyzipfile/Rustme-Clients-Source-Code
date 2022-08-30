/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.client.renderer.RenderItem
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemAir
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.text.TextFormatting
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.opengl.GL11
 */
package ru.internali.module.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAir;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;
import ru.internali.utils.ColorUtils;
import ru.internali.utils.RenderUtil;
import ru.internali.utils.RenderUtils;
import ru.internali.utils.friend.FriendManager;

public class NameTags
extends Module {
    public static /* synthetic */ List<String> Modes;
    private /* synthetic */ FontRenderer fontRenderer;

    @SubscribeEvent
    public void onRenderWorld(RenderWorldLastEvent lIIIllIlllIlllI) {
        NameTags lIIIllIlllIllll;
        String lIIIllIlllIllIl = CatClient.instance.settingsManager.getSettingByName(lIIIllIlllIllll, "Modes").getValString();
        if (Objects.equals(lIIIllIlllIllIl, "Bobr")) {
            for (Entity lIIIlllIIlIIlll : NameTags.mc.world.field_72996_f) {
                if (!(lIIIlllIIlIIlll instanceof EntityPlayer) || lIIIlllIIlIIlll == NameTags.mc.player) continue;
                double lIIIlllIIlIllII = lIIIlllIIlIIlll.lastTickPosX + (lIIIlllIIlIIlll.posX - lIIIlllIIlIIlll.lastTickPosX) * (double)lIIIllIlllIlllI.getPartialTicks() - NameTags.mc.getRenderManager().viewerPosX;
                double lIIIlllIIlIlIll = lIIIlllIIlIIlll.lastTickPosY + (lIIIlllIIlIIlll.posY - lIIIlllIIlIIlll.lastTickPosY) * (double)lIIIllIlllIlllI.getPartialTicks() - NameTags.mc.getRenderManager().viewerPosY;
                double lIIIlllIIlIlIlI = lIIIlllIIlIIlll.lastTickPosZ + (lIIIlllIIlIIlll.posZ - lIIIlllIIlIIlll.lastTickPosZ) * (double)lIIIllIlllIlllI.getPartialTicks() - NameTags.mc.getRenderManager().viewerPosZ;
                GL11.glPushMatrix();
                GL11.glDisable((int)2929);
                GL11.glDisable((int)3553);
                GL11.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
                GlStateManager.disableLighting();
                GlStateManager.enableBlend();
                float lIIIlllIIlIlIIl = Math.min(Math.max(1.2f * (NameTags.mc.player.func_70032_d(lIIIlllIIlIIlll) * 0.15f), 1.25f), 6.0f) * 0.015f;
                GL11.glTranslatef((float)((float)lIIIlllIIlIllII), (float)((float)lIIIlllIIlIlIll + lIIIlllIIlIIlll.height + 0.7f), (float)((float)lIIIlllIIlIlIlI));
                GlStateManager.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
                GlStateManager.rotate((float)(-NameTags.mc.getRenderManager().playerViewY), (float)0.0f, (float)1.0f, (float)0.0f);
                GlStateManager.rotate((float)NameTags.mc.getRenderManager().playerViewX, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glScalef((float)(-lIIIlllIIlIlIIl), (float)(-lIIIlllIIlIlIIl), (float)(-lIIIlllIIlIlIIl));
                String lIIIlllIIlIlIII = "MoonLight";
                if (FriendManager.friendsList.contains(lIIIlllIIlIIlll.getName())) {
                    int lIIIlllIIllllII = (int)(((EntityPlayer)lIIIlllIIlIIlll).func_110143_aJ() / ((EntityPlayer)lIIIlllIIlIIlll).func_110138_aP() * 100.0f);
                    Gui.drawRect((int)(-NameTags.mc.fontRenderer.getStringWidth(String.valueOf(new StringBuilder().append(lIIIlllIIlIlIII).append(" ").append(lIIIlllIIllllII).append("%"))) / 2 - 2), (int)-2, (int)(NameTags.mc.fontRenderer.getStringWidth(lIIIlllIIlIlIII) / 2 + 16), (int)10, (int)(!FriendManager.friendsList.contains(lIIIlllIIlIIlll.getName()) ? Integer.MIN_VALUE : Color.green.getRGB()));
                    NameTags.mc.fontRenderer.drawString(String.valueOf(new StringBuilder().append(lIIIlllIIlIlIII).append(" ").append((Object)TextFormatting.GREEN).append(lIIIlllIIllllII).append("%")), -lIIIllIlllIllll.center(String.valueOf(new StringBuilder().append(lIIIlllIIlIlIII).append(" ").append((Object)TextFormatting.DARK_GREEN).append(lIIIlllIIllllII).append("%"))), 1, -1);
                    int lIIIlllIIlllIll = -NameTags.mc.fontRenderer.getStringWidth(lIIIlllIIlIIlll.getName()) / 2 - 8;
                    if (Item.getIdFromItem((Item)((EntityPlayer)lIIIlllIIlIIlll).inventory.getCurrentItem().getItem()) != 0) {
                        NameTags.mc.getRenderItem().zLevel = -100.0f;
                        mc.getRenderItem().renderItemIntoGUI(((EntityPlayer)lIIIlllIIlIIlll).inventory.getCurrentItem(), lIIIlllIIlllIll - 2, -20);
                        NameTags.mc.getRenderItem().zLevel = 0.0f;
                        int lIIIlllIlIIIlIl = -30;
                        Map lIIIlllIlIIIlII = EnchantmentHelper.getEnchantments((ItemStack)((EntityPlayer)lIIIlllIIlIIlll).inventory.getCurrentItem());
                        for (Enchantment lIIIlllIlIIlIII : lIIIlllIlIIIlII.keySet()) {
                            int lIIIlllIlIIIlll = EnchantmentHelper.getEnchantmentLevel((Enchantment)lIIIlllIlIIlIII, (ItemStack)((EntityPlayer)lIIIlllIIlIIlll).inventory.getCurrentItem());
                            NameTags.mc.fontRenderer.drawStringWithShadow(String.valueOf(new StringBuilder().append(String.valueOf(lIIIlllIlIIlIII.getName().substring(12).charAt(0)).toUpperCase()).append(lIIIlllIlIIIlll)), (float)(lIIIlllIIlllIll + 6 - lIIIllIlllIllll.center(String.valueOf(new StringBuilder().append(String.valueOf(lIIIlllIlIIlIII.getName().substring(12).charAt(0)).toUpperCase()).append(lIIIlllIlIIIlll)))), (float)lIIIlllIlIIIlIl, -1);
                            lIIIlllIlIIIlIl -= 12;
                        }
                        lIIIlllIIlllIll += 15;
                    }
                    for (ItemStack lIIIlllIlIIIIII : lIIIlllIIlIIlll.getArmorInventoryList()) {
                        NameTags.mc.getRenderItem().zLevel = -100.0f;
                        mc.getRenderItem().renderItemIntoGUI(new ItemStack(lIIIlllIlIIIIII.getItem()), lIIIlllIIlllIll, -20);
                        NameTags.mc.getRenderItem().zLevel = 0.0f;
                        int lIIIlllIIllllll = -30;
                        Map lIIIlllIIlllllI = EnchantmentHelper.getEnchantments((ItemStack)lIIIlllIlIIIIII);
                        for (Enchantment lIIIlllIlIIIIll : lIIIlllIIlllllI.keySet()) {
                            int lIIIlllIlIIIIlI = EnchantmentHelper.getEnchantmentLevel((Enchantment)lIIIlllIlIIIIll, (ItemStack)lIIIlllIlIIIIII);
                            NameTags.mc.fontRenderer.drawStringWithShadow(String.valueOf(new StringBuilder().append(String.valueOf(lIIIlllIlIIIIll.getName().substring(12).charAt(0)).toUpperCase()).append(lIIIlllIlIIIIlI)), (float)(lIIIlllIIlllIll + 9 - lIIIllIlllIllll.center(lIIIlllIlIIIIll.getName().substring(12).charAt(0) + lIIIlllIlIIIIlI)), (float)lIIIlllIIllllll, -1);
                            lIIIlllIIllllll -= 12;
                        }
                        lIIIlllIIlllIll += 17;
                    }
                    GL11.glEnable((int)2929);
                    GL11.glPopMatrix();
                    continue;
                }
                int lIIIlllIIlIlllI = (int)(((EntityPlayer)lIIIlllIIlIIlll).func_110143_aJ() / ((EntityPlayer)lIIIlllIIlIIlll).func_110138_aP() * 100.0f);
                Gui.drawRect((int)(-NameTags.mc.fontRenderer.getStringWidth(String.valueOf(new StringBuilder().append(lIIIlllIIlIIlll.getName()).append(" ").append(lIIIlllIIlIlllI).append("%"))) / 2 - 2), (int)-2, (int)(NameTags.mc.fontRenderer.getStringWidth(lIIIlllIIlIIlll.getName()) / 2 + 16), (int)10, (int)(!FriendManager.friendsList.contains(lIIIlllIIlIIlll.getName()) ? Integer.MIN_VALUE : Color.green.getRGB()));
                NameTags.mc.fontRenderer.drawString(String.valueOf(new StringBuilder().append(lIIIlllIIlIIlll.getName()).append(" ").append((Object)TextFormatting.GREEN).append(lIIIlllIIlIlllI).append("%")), -lIIIllIlllIllll.center(String.valueOf(new StringBuilder().append(lIIIlllIIlIIlll.getName()).append(" ").append((Object)TextFormatting.DARK_GREEN).append(lIIIlllIIlIlllI).append("%"))), 1, -1);
                int lIIIlllIIlIllIl = -NameTags.mc.fontRenderer.getStringWidth(lIIIlllIIlIIlll.getName()) / 2 - 8;
                if (Item.getIdFromItem((Item)((EntityPlayer)lIIIlllIIlIIlll).inventory.getCurrentItem().getItem()) != 0) {
                    NameTags.mc.getRenderItem().zLevel = -100.0f;
                    mc.getRenderItem().renderItemIntoGUI(((EntityPlayer)lIIIlllIIlIIlll).inventory.getCurrentItem(), lIIIlllIIlIllIl - 2, -20);
                    NameTags.mc.getRenderItem().zLevel = 0.0f;
                    int lIIIlllIIllIlll = -30;
                    Map lIIIlllIIllIllI = EnchantmentHelper.getEnchantments((ItemStack)((EntityPlayer)lIIIlllIIlIIlll).inventory.getCurrentItem());
                    for (Enchantment lIIIlllIIlllIlI : lIIIlllIIllIllI.keySet()) {
                        int lIIIlllIIlllIIl = EnchantmentHelper.getEnchantmentLevel((Enchantment)lIIIlllIIlllIlI, (ItemStack)((EntityPlayer)lIIIlllIIlIIlll).inventory.getCurrentItem());
                        NameTags.mc.fontRenderer.drawStringWithShadow(String.valueOf(new StringBuilder().append(String.valueOf(lIIIlllIIlllIlI.getName().substring(12).charAt(0)).toUpperCase()).append(lIIIlllIIlllIIl)), (float)(lIIIlllIIlIllIl + 6 - lIIIllIlllIllll.center(String.valueOf(new StringBuilder().append(String.valueOf(lIIIlllIIlllIlI.getName().substring(12).charAt(0)).toUpperCase()).append(lIIIlllIIlllIIl)))), (float)lIIIlllIIllIlll, -1);
                        lIIIlllIIllIlll -= 12;
                    }
                    lIIIlllIIlIllIl += 15;
                }
                for (ItemStack lIIIlllIIllIIlI : lIIIlllIIlIIlll.getArmorInventoryList()) {
                    NameTags.mc.getRenderItem().zLevel = -100.0f;
                    mc.getRenderItem().renderItemIntoGUI(new ItemStack(lIIIlllIIllIIlI.getItem()), lIIIlllIIlIllIl, -20);
                    NameTags.mc.getRenderItem().zLevel = 0.0f;
                    int lIIIlllIIllIIIl = -30;
                    Map lIIIlllIIllIIII = EnchantmentHelper.getEnchantments((ItemStack)lIIIlllIIllIIlI);
                    for (Enchantment lIIIlllIIllIlIl : lIIIlllIIllIIII.keySet()) {
                        int lIIIlllIIllIlII = EnchantmentHelper.getEnchantmentLevel((Enchantment)lIIIlllIIllIlIl, (ItemStack)lIIIlllIIllIIlI);
                        NameTags.mc.fontRenderer.drawStringWithShadow(String.valueOf(new StringBuilder().append(String.valueOf(lIIIlllIIllIlIl.getName().substring(12).charAt(0)).toUpperCase()).append(lIIIlllIIllIlII)), (float)(lIIIlllIIlIllIl + 9 - lIIIllIlllIllll.center(lIIIlllIIllIlIl.getName().substring(12).charAt(0) + lIIIlllIIllIlII)), (float)lIIIlllIIllIIIl, -1);
                        lIIIlllIIllIIIl -= 12;
                    }
                    lIIIlllIIlIllIl += 17;
                }
                GL11.glEnable((int)2929);
                GL11.glPopMatrix();
            }
        } else if (Objects.equals(lIIIllIlllIllIl, "BobrV1")) {
            for (Entity lIIIlllIIIIlIII : NameTags.mc.world.field_72996_f) {
                if (!(lIIIlllIIIIlIII instanceof EntityPlayer) || lIIIlllIIIIlIII == NameTags.mc.player) continue;
                double lIIIlllIIIIllII = lIIIlllIIIIlIII.lastTickPosX + (lIIIlllIIIIlIII.posX - lIIIlllIIIIlIII.lastTickPosX) * (double)mc.getRenderPartialTicks() - NameTags.mc.getRenderManager().viewerPosX;
                double lIIIlllIIIIlIll = lIIIlllIIIIlIII.lastTickPosY + (lIIIlllIIIIlIII.posY - lIIIlllIIIIlIII.lastTickPosY) * (double)mc.getRenderPartialTicks() - NameTags.mc.getRenderManager().viewerPosY;
                double lIIIlllIIIIlIlI = lIIIlllIIIIlIII.lastTickPosZ + (lIIIlllIIIIlIII.posZ - lIIIlllIIIIlIII.lastTickPosZ) * (double)mc.getRenderPartialTicks() - NameTags.mc.getRenderManager().viewerPosZ;
                GL11.glPushMatrix();
                GL11.glDisable((int)2929);
                GL11.glDisable((int)3553);
                GL11.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
                GlStateManager.disableLighting();
                GlStateManager.enableBlend();
                float lIIIlllIIIIlIIl = Math.min(Math.max(1.2f * (NameTags.mc.player.func_70032_d(lIIIlllIIIIlIII) * 0.15f), 1.25f), 6.0f) * 0.015f;
                GL11.glTranslatef((float)((float)lIIIlllIIIIllII), (float)((float)lIIIlllIIIIlIll + lIIIlllIIIIlIII.height + 0.6f), (float)((float)lIIIlllIIIIlIlI));
                GlStateManager.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
                GlStateManager.rotate((float)(-NameTags.mc.getRenderManager().playerViewY), (float)0.0f, (float)1.0f, (float)0.0f);
                GlStateManager.rotate((float)NameTags.mc.getRenderManager().playerViewX, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glScalef((float)(-lIIIlllIIIIlIIl), (float)(-lIIIlllIIIIlIIl), (float)(-lIIIlllIIIIlIIl));
                if (FriendManager.friendsList.contains(lIIIlllIIIIlIII.getName())) {
                    int lIIIlllIIIlllIl = (int)(((EntityPlayer)lIIIlllIIIIlIII).func_110143_aJ() / ((EntityPlayer)lIIIlllIIIIlIII).func_110138_aP() * 100.0f);
                    int lIIIlllIIIlllII = (int)((float)(NameTags.mc.fontRenderer.getStringWidth(lIIIlllIIIIlIII.getName()) / 2 + 16 - (-NameTags.mc.fontRenderer.getStringWidth(String.valueOf(new StringBuilder().append(lIIIlllIIIIlIII.getName()).append(" ").append(lIIIlllIIIlllIl).append("%"))) / 2 - 2)) / ((EntityPlayer)lIIIlllIIIIlIII).func_110138_aP());
                    RenderUtil.drawSmoothRect(-lIIIllIlllIllll.fontRenderer.getStringWidth(String.valueOf(new StringBuilder().append("Protect ").append(lIIIlllIIIlllIl).append("%"))) / 2 - 2, -2.0f, lIIIllIlllIllll.fontRenderer.getStringWidth("Protect") / 2 + 16, 10.0f, Integer.MIN_VALUE);
                    RenderUtil.drawSmoothRect(-lIIIllIlllIllll.fontRenderer.getStringWidth(String.valueOf(new StringBuilder().append("Protect ").append(lIIIlllIIIlllIl).append("%"))) / 2 - 2, 10.0f, (float)(-lIIIllIlllIllll.fontRenderer.getStringWidth(String.valueOf(new StringBuilder().append("Protect ").append(lIIIlllIIIlllIl).append("%"))) / 2) + (float)lIIIlllIIIlllII * ((EntityPlayer)lIIIlllIIIIlIII).func_110143_aJ(), 12.0f, ColorUtils.getHealthColor((EntityLivingBase)lIIIlllIIIIlIII).getRGB());
                    lIIIllIlllIllll.fontRenderer.drawString(String.valueOf(new StringBuilder().append("Protect ").append((Object)TextFormatting.GREEN).append(lIIIlllIIIlllIl).append("%")), 0 - lIIIllIlllIllll.getcenter(String.valueOf(new StringBuilder().append("Protect ").append((Object)TextFormatting.GREEN).append(lIIIlllIIIlllIl).append("%"))), 1, -1);
                    int lIIIlllIIIllIll = -NameTags.mc.fontRenderer.getStringWidth(lIIIlllIIIIlIII.getName()) / 2 - 8;
                    if (Item.getIdFromItem((Item)((EntityPlayer)lIIIlllIIIIlIII).inventory.getCurrentItem().getItem()) != 0) {
                        NameTags.mc.getRenderItem().zLevel = -100.0f;
                        mc.getRenderItem().renderItemIntoGUI(((EntityPlayer)lIIIlllIIIIlIII).func_184586_b(EnumHand.MAIN_HAND), lIIIlllIIIllIll - 2, -20);
                        NameTags.mc.getRenderItem().zLevel = 0.0f;
                        int lIIIlllIIlIIlII = -30;
                        Map lIIIlllIIlIIIll = EnchantmentHelper.getEnchantments((ItemStack)((EntityPlayer)lIIIlllIIIIlIII).inventory.getCurrentItem());
                        for (Enchantment lIIIlllIIlIIlIl : lIIIlllIIlIIIll.keySet()) {
                            int lIIIlllIIlIIllI = EnchantmentHelper.getEnchantmentLevel((Enchantment)lIIIlllIIlIIlIl, (ItemStack)((EntityPlayer)lIIIlllIIIIlIII).inventory.getCurrentItem());
                            NameTags.mc.fontRenderer.drawStringWithShadow(String.valueOf(new StringBuilder().append(String.valueOf(lIIIlllIIlIIlIl.getName().substring(12).charAt(0)).toUpperCase()).append(lIIIlllIIlIIllI)), (float)(lIIIlllIIIllIll + 6 - lIIIllIlllIllll.getcenter(String.valueOf(new StringBuilder().append(String.valueOf(lIIIlllIIlIIlIl.getName().substring(12).charAt(0)).toUpperCase()).append(lIIIlllIIlIIllI)))), (float)lIIIlllIIlIIlII, -1);
                            lIIIlllIIlIIlII -= 12;
                        }
                        lIIIlllIIIllIll += 15;
                    }
                    for (ItemStack lIIIlllIIIllllI : lIIIlllIIIIlIII.getArmorInventoryList()) {
                        NameTags.mc.getRenderItem().zLevel = -100.0f;
                        mc.getRenderItem().renderItemIntoGUI(lIIIlllIIIllllI, lIIIlllIIIllIll, -20);
                        NameTags.mc.getRenderItem().zLevel = 0.0f;
                        int lIIIlllIIlIIIII = -30;
                        Map lIIIlllIIIlllll = EnchantmentHelper.getEnchantments((ItemStack)lIIIlllIIIllllI);
                        for (Enchantment lIIIlllIIlIIIIl : lIIIlllIIIlllll.keySet()) {
                            int lIIIlllIIlIIIlI = EnchantmentHelper.getEnchantmentLevel((Enchantment)lIIIlllIIlIIIIl, (ItemStack)lIIIlllIIIllllI);
                            NameTags.mc.fontRenderer.drawStringWithShadow(String.valueOf(new StringBuilder().append(String.valueOf(lIIIlllIIlIIIIl.getName().substring(12).charAt(0)).toUpperCase()).append(lIIIlllIIlIIIlI)), (float)(lIIIlllIIIllIll + 9 - lIIIllIlllIllll.getcenter(lIIIlllIIlIIIIl.getName().substring(12).charAt(0) + lIIIlllIIlIIIlI)), (float)lIIIlllIIlIIIII, -1);
                            lIIIlllIIlIIIII -= 12;
                        }
                        lIIIlllIIIllIll += 17;
                    }
                    int lIIIlllIIIllIlI = 0;
                    if (lIIIlllIIIllIlI > 0) {
                        NameTags.mc.getRenderItem().zLevel = -100.0f;
                        mc.getRenderItem().renderItemIntoGUI(new ItemStack(Items.GOLDEN_APPLE), lIIIlllIIIllIll, -20);
                        NameTags.mc.getRenderItem().zLevel = 0.0f;
                        NameTags.mc.fontRenderer.drawStringWithShadow(String.valueOf(lIIIlllIIIllIlI), (float)(lIIIlllIIIllIll + 9 - lIIIllIlllIllll.getcenter(String.valueOf(lIIIlllIIIllIlI))), -30.0f, -1);
                    }
                    GL11.glEnable((int)2929);
                    GL11.glPopMatrix();
                    continue;
                }
                int lIIIlllIIIlIIII = (int)(((EntityPlayer)lIIIlllIIIIlIII).func_110143_aJ() / ((EntityPlayer)lIIIlllIIIIlIII).func_110138_aP() * 100.0f);
                int lIIIlllIIIIllll = (int)((float)(NameTags.mc.fontRenderer.getStringWidth(lIIIlllIIIIlIII.getName()) / 2 + 16 - (-NameTags.mc.fontRenderer.getStringWidth(String.valueOf(new StringBuilder().append(lIIIlllIIIIlIII.getName()).append(" ").append(lIIIlllIIIlIIII).append("%"))) / 2 - 2)) / ((EntityPlayer)lIIIlllIIIIlIII).func_110138_aP());
                RenderUtil.drawSmoothRect(-lIIIllIlllIllll.fontRenderer.getStringWidth(String.valueOf(new StringBuilder().append(lIIIlllIIIIlIII.getName()).append(" ").append(lIIIlllIIIlIIII).append("%"))) / 2 - 2, -2.0f, lIIIllIlllIllll.fontRenderer.getStringWidth(lIIIlllIIIIlIII.getName()) / 2 + 16, 10.0f, Integer.MIN_VALUE);
                RenderUtil.drawSmoothRect(-lIIIllIlllIllll.fontRenderer.getStringWidth(String.valueOf(new StringBuilder().append(lIIIlllIIIIlIII.getName()).append(" ").append(lIIIlllIIIlIIII).append("%"))) / 2 - 2, 10.0f, (float)(-lIIIllIlllIllll.fontRenderer.getStringWidth(String.valueOf(new StringBuilder().append(lIIIlllIIIIlIII.getName()).append(" ").append(lIIIlllIIIlIIII).append("%"))) / 2) + (float)lIIIlllIIIIllll * ((EntityPlayer)lIIIlllIIIIlIII).func_110143_aJ(), 12.0f, ColorUtils.getHealthColor((EntityLivingBase)lIIIlllIIIIlIII).getRGB());
                lIIIllIlllIllll.fontRenderer.drawString(String.valueOf(new StringBuilder().append(lIIIlllIIIIlIII.getName()).append(" ").append((Object)TextFormatting.GREEN).append(lIIIlllIIIlIIII).append("%")), 0 - lIIIllIlllIllll.getcenter(String.valueOf(new StringBuilder().append(lIIIlllIIIIlIII.getName()).append(" ").append((Object)TextFormatting.GREEN).append(lIIIlllIIIlIIII).append("%"))), 1, -1);
                int lIIIlllIIIIlllI = -NameTags.mc.fontRenderer.getStringWidth(lIIIlllIIIIlIII.getName()) / 2 - 8;
                if (Item.getIdFromItem((Item)((EntityPlayer)lIIIlllIIIIlIII).inventory.getCurrentItem().getItem()) != 0) {
                    NameTags.mc.getRenderItem().zLevel = -100.0f;
                    mc.getRenderItem().renderItemIntoGUI(((EntityPlayer)lIIIlllIIIIlIII).func_184586_b(EnumHand.MAIN_HAND), lIIIlllIIIIlllI - 2, -20);
                    NameTags.mc.getRenderItem().zLevel = 0.0f;
                    int lIIIlllIIIlIlll = -30;
                    Map lIIIlllIIIlIllI = EnchantmentHelper.getEnchantments((ItemStack)((EntityPlayer)lIIIlllIIIIlIII).inventory.getCurrentItem());
                    for (Enchantment lIIIlllIIIllIII : lIIIlllIIIlIllI.keySet()) {
                        int lIIIlllIIIllIIl = EnchantmentHelper.getEnchantmentLevel((Enchantment)lIIIlllIIIllIII, (ItemStack)((EntityPlayer)lIIIlllIIIIlIII).inventory.getCurrentItem());
                        NameTags.mc.fontRenderer.drawStringWithShadow(String.valueOf(new StringBuilder().append(String.valueOf(lIIIlllIIIllIII.getName().substring(12).charAt(0)).toUpperCase()).append(lIIIlllIIIllIIl)), (float)(lIIIlllIIIIlllI + 6 - lIIIllIlllIllll.getcenter(String.valueOf(new StringBuilder().append(String.valueOf(lIIIlllIIIllIII.getName().substring(12).charAt(0)).toUpperCase()).append(lIIIlllIIIllIIl)))), (float)lIIIlllIIIlIlll, -1);
                        lIIIlllIIIlIlll -= 12;
                    }
                    lIIIlllIIIIlllI += 15;
                }
                for (ItemStack lIIIlllIIIlIIIl : lIIIlllIIIIlIII.getArmorInventoryList()) {
                    NameTags.mc.getRenderItem().zLevel = -100.0f;
                    mc.getRenderItem().renderItemIntoGUI(lIIIlllIIIlIIIl, lIIIlllIIIIlllI, -20);
                    NameTags.mc.getRenderItem().zLevel = 0.0f;
                    int lIIIlllIIIlIIll = -30;
                    Map lIIIlllIIIlIIlI = EnchantmentHelper.getEnchantments((ItemStack)lIIIlllIIIlIIIl);
                    for (Enchantment lIIIlllIIIlIlII : lIIIlllIIIlIIlI.keySet()) {
                        int lIIIlllIIIlIlIl = EnchantmentHelper.getEnchantmentLevel((Enchantment)lIIIlllIIIlIlII, (ItemStack)lIIIlllIIIlIIIl);
                        NameTags.mc.fontRenderer.drawStringWithShadow(String.valueOf(new StringBuilder().append(String.valueOf(lIIIlllIIIlIlII.getName().substring(12).charAt(0)).toUpperCase()).append(lIIIlllIIIlIlIl)), (float)(lIIIlllIIIIlllI + 9 - lIIIllIlllIllll.getcenter(lIIIlllIIIlIlII.getName().substring(12).charAt(0) + lIIIlllIIIlIlIl)), (float)lIIIlllIIIlIIll, -1);
                        lIIIlllIIIlIIll -= 12;
                    }
                    lIIIlllIIIIlllI += 17;
                }
                int lIIIlllIIIIllIl = 0;
                if (lIIIlllIIIIllIl > 0) {
                    NameTags.mc.getRenderItem().zLevel = -100.0f;
                    mc.getRenderItem().renderItemIntoGUI(new ItemStack(Items.GOLDEN_APPLE), lIIIlllIIIIlllI, -20);
                    NameTags.mc.getRenderItem().zLevel = 0.0f;
                    NameTags.mc.fontRenderer.drawStringWithShadow(String.valueOf(lIIIlllIIIIllIl), (float)(lIIIlllIIIIlllI + 9 - lIIIllIlllIllll.getcenter(String.valueOf(lIIIlllIIIIllIl))), -30.0f, -1);
                }
                GL11.glEnable((int)2929);
                GL11.glPopMatrix();
            }
        } else if (Objects.equals(lIIIllIlllIllIl, "BobrV2")) {
            Iterator lIIIllIllllIIII = NameTags.mc.world.field_72996_f.iterator();
            while (true) {
                if (!lIIIllIllllIIII.hasNext()) {
                    return;
                }
                Entity lIIIllIlllllIIl = (Entity)lIIIllIllllIIII.next();
                if (!(lIIIllIlllllIIl instanceof EntityPlayer)) continue;
                if (lIIIllIlllllIIl == NameTags.mc.player) continue;
                double lIIIllIlllllIII = lIIIllIlllllIIl.lastTickPosX + (lIIIllIlllllIIl.posX - lIIIllIlllllIIl.lastTickPosX) * (double)mc.getRenderPartialTicks() - NameTags.mc.getRenderManager().viewerPosX;
                double lIIIllIllllIlll = lIIIllIlllllIIl.lastTickPosY + (lIIIllIlllllIIl.posY - lIIIllIlllllIIl.lastTickPosY) * (double)mc.getRenderPartialTicks() - NameTags.mc.getRenderManager().viewerPosY;
                double lIIIllIllllIllI = lIIIllIlllllIIl.lastTickPosZ + (lIIIllIlllllIIl.posZ - lIIIllIlllllIIl.lastTickPosZ) * (double)mc.getRenderPartialTicks() - NameTags.mc.getRenderManager().viewerPosZ;
                GL11.glPushMatrix();
                GL11.glDisable((int)2929);
                GL11.glEnable((int)3042);
                GL11.glBlendFunc((int)770, (int)771);
                GL11.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
                float lIIIllIllllIlIl = Math.min(Math.max(1.2f * NameTags.mc.player.func_70032_d(lIIIllIlllllIIl) * 0.15f, 1.25f), 6.0f) * 0.015f;
                GL11.glTranslatef((float)((float)lIIIllIlllllIII), (float)((float)lIIIllIllllIlll + lIIIllIlllllIIl.height + 0.6f), (float)((float)lIIIllIllllIllI));
                GlStateManager.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
                GlStateManager.rotate((float)(-NameTags.mc.getRenderManager().playerViewY), (float)0.0f, (float)1.0f, (float)0.0f);
                GlStateManager.rotate((float)NameTags.mc.getRenderManager().playerViewX, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glScalef((float)(-lIIIllIllllIlIl), (float)(-lIIIllIllllIlIl), (float)(-lIIIllIllllIlIl));
                int lIIIllIllllIlII = (int)(((EntityPlayer)lIIIllIlllllIIl).func_110143_aJ() / ((EntityPlayer)lIIIllIlllllIIl).func_110138_aP() * 100.0f);
                String lIIIllIllllIIll = String.valueOf(new StringBuilder().append(lIIIllIlllllIIl.getDisplayName().getUnformattedText()).append((Object)TextFormatting.GREEN).append(" HP: ").append(lIIIllIllllIlII));
                float lIIIllIllllIIlI = NameTags.mc.fontRenderer.getStringWidth(lIIIllIllllIIll) + 10;
                RenderUtils.drawShadowRect(-(lIIIllIllllIIlI / 2.0f), 0.0, lIIIllIllllIIlI / 2.0f, 15.0, 3);
                RenderUtils.drawRect(-(lIIIllIllllIIlI / 2.0f), 0.0f, lIIIllIllllIIlI / 2.0f, 15.0f, new Color(30, 30, 30).getRGB());
                int lIIIllIllllIIIl = (int)(lIIIllIllllIIlI - 4.0f);
                RenderUtils.drawShadowRect(-(lIIIllIllllIIlI / 2.0f) + 2.0f, 11.0, -(lIIIllIllllIIlI / 2.0f) + 2.0f + (float)lIIIllIllllIIIl / ((EntityPlayer)lIIIllIlllllIIl).func_110138_aP() * ((EntityPlayer)lIIIllIlllllIIl).func_110143_aJ(), 13.0, 1);
                RenderUtils.drawRect(-(lIIIllIllllIIlI / 2.0f) + 2.0f, 11.0f, -(lIIIllIllllIIlI / 2.0f) + 2.0f + (float)lIIIllIllllIIIl / ((EntityPlayer)lIIIllIlllllIIl).func_110138_aP() * ((EntityPlayer)lIIIllIlllllIIl).func_110143_aJ(), 13.0f, CatClient.getColor());
                if (FriendManager.friendsList.contains(lIIIllIlllllIIl.getName())) {
                    lIIIllIlllIllll.fontRenderer.drawString(String.valueOf(new StringBuilder().append("Protect ").append((Object)TextFormatting.GREEN).append(lIIIllIllllIlII).append("%")), 0 - lIIIllIlllIllll.getcenter(String.valueOf(new StringBuilder().append("Protect ").append((Object)TextFormatting.GREEN).append(lIIIllIllllIlII).append("%"))), 1, -1);
                    ArrayList<ItemStack> lIIIlllIIIIIIll = new ArrayList<ItemStack>();
                    if (!(((EntityPlayer)lIIIllIlllllIIl).func_184586_b(EnumHand.MAIN_HAND).getItem() instanceof ItemAir)) {
                        lIIIlllIIIIIIll.add(((EntityPlayer)lIIIllIlllllIIl).func_184586_b(EnumHand.MAIN_HAND));
                    }
                    for (ItemStack lIIIlllIIIIIlll : lIIIllIlllllIIl.getArmorInventoryList()) {
                        if (lIIIlllIIIIIlll.getItem() instanceof ItemAir) continue;
                        lIIIlllIIIIIIll.add(lIIIlllIIIIIlll);
                    }
                    if (!(((EntityPlayer)lIIIllIlllllIIl).func_184586_b(EnumHand.OFF_HAND).getItem() instanceof ItemAir)) {
                        lIIIlllIIIIIIll.add(((EntityPlayer)lIIIllIlllllIIl).func_184586_b(EnumHand.OFF_HAND));
                    }
                    int lIIIlllIIIIIIIl = -(lIIIlllIIIIIIll.size() * 16 / 2);
                    for (ItemStack lIIIlllIIIIIllI : lIIIlllIIIIIIll) {
                        RenderItem lIIIlllIIIIIlIl = mc.getRenderItem();
                        GlStateManager.pushMatrix();
                        GlStateManager.enableBlend();
                        RenderHelper.enableStandardItemLighting();
                        lIIIlllIIIIIlIl.zLevel = -100.0f;
                        lIIIlllIIIIIlIl.renderItemIntoGUI(lIIIlllIIIIIllI, lIIIlllIIIIIIIl, -20);
                        lIIIlllIIIIIlIl.zLevel = 0.0f;
                        RenderHelper.disableStandardItemLighting();
                        GlStateManager.enableAlpha();
                        GlStateManager.disableBlend();
                        GlStateManager.disableLighting();
                        GlStateManager.popMatrix();
                        GlStateManager.pushMatrix();
                        GlStateManager.disableLighting();
                        GlStateManager.disableDepth();
                        GlStateManager.popMatrix();
                        lIIIlllIIIIIIIl += 16;
                    }
                    GL11.glEnable((int)2929);
                    GL11.glColor3f((float)255.0f, (float)255.0f, (float)255.0f);
                    GL11.glEnable((int)2929);
                    GL11.glPopMatrix();
                    continue;
                }
                lIIIllIlllIllll.fontRenderer.drawString(String.valueOf(new StringBuilder().append(lIIIllIlllllIIl.getName()).append(" ").append((Object)TextFormatting.GREEN).append(lIIIllIllllIlII).append("%")), 0 - lIIIllIlllIllll.getcenter(String.valueOf(new StringBuilder().append(lIIIllIlllllIIl.getName()).append(" ").append((Object)TextFormatting.GREEN).append(lIIIllIllllIlII).append("%"))), 1, -1);
                ArrayList<ItemStack> lIIIllIllllllII = new ArrayList<ItemStack>();
                if (!(((EntityPlayer)lIIIllIlllllIIl).func_184586_b(EnumHand.MAIN_HAND).getItem() instanceof ItemAir)) {
                    lIIIllIllllllII.add(((EntityPlayer)lIIIllIlllllIIl).func_184586_b(EnumHand.MAIN_HAND));
                }
                for (ItemStack lIIIlllIIIIIIII : lIIIllIlllllIIl.getArmorInventoryList()) {
                    if (lIIIlllIIIIIIII.getItem() instanceof ItemAir) continue;
                    lIIIllIllllllII.add(lIIIlllIIIIIIII);
                }
                if (!(((EntityPlayer)lIIIllIlllllIIl).func_184586_b(EnumHand.OFF_HAND).getItem() instanceof ItemAir)) {
                    lIIIllIllllllII.add(((EntityPlayer)lIIIllIlllllIIl).func_184586_b(EnumHand.OFF_HAND));
                }
                int lIIIllIlllllIlI = -(lIIIllIllllllII.size() * 16 / 2);
                for (ItemStack lIIIllIllllllll : lIIIllIllllllII) {
                    RenderItem lIIIllIlllllllI = mc.getRenderItem();
                    GlStateManager.pushMatrix();
                    GlStateManager.enableBlend();
                    RenderHelper.enableStandardItemLighting();
                    lIIIllIlllllllI.zLevel = -100.0f;
                    lIIIllIlllllllI.renderItemIntoGUI(lIIIllIllllllll, lIIIllIlllllIlI, -20);
                    lIIIllIlllllllI.zLevel = 0.0f;
                    RenderHelper.disableStandardItemLighting();
                    GlStateManager.enableAlpha();
                    GlStateManager.disableBlend();
                    GlStateManager.disableLighting();
                    GlStateManager.popMatrix();
                    GlStateManager.pushMatrix();
                    GlStateManager.disableLighting();
                    GlStateManager.disableDepth();
                    GlStateManager.popMatrix();
                    lIIIllIlllllIlI += 16;
                }
                GL11.glEnable((int)2929);
                GL11.glColor3f((float)255.0f, (float)255.0f, (float)255.0f);
                GL11.glEnable((int)2929);
                GL11.glPopMatrix();
            }
        }
    }

    public int getcenter(String lIIIllIllIIlllI) {
        return NameTags.mc.fontRenderer.getStringWidth(lIIIllIllIIlllI) / 2;
    }

    public int getcenter(int lIIIllIllIIlIlI) {
        return NameTags.mc.fontRenderer.getStringWidth(String.valueOf(lIIIllIllIIlIlI)) / 2;
    }

    public int center(String lIIIllIllIlIlll) {
        return NameTags.mc.fontRenderer.getStringWidth(lIIIllIllIlIlll) / 2;
    }

    public NameTags() {
        super("NameTags", "Show nick of player", Category.RENDER);
        NameTags lIIIlllIlIlllIl;
        lIIIlllIlIlllIl.fontRenderer = Minecraft.getMinecraft().fontRenderer;
        Modes.add("Bobr");
        Modes.add("BobrV1");
        Modes.add("BobrV2");
        CatClient.instance.settingsManager.rSetting(new Setting("Modes", lIIIlllIlIlllIl, "Bobr", (ArrayList)Modes));
    }

    static {
        Modes = new ArrayList<String>();
    }

    public int center(int lIIIllIllIlIIll) {
        return NameTags.mc.fontRenderer.getStringWidth(String.valueOf(lIIIllIllIlIIll)) / 2;
    }
}

