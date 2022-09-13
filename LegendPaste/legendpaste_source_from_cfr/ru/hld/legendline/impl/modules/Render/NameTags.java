/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.client.renderer.RenderItem
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.ItemAir
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.text.TextFormatting
 *  org.lwjgl.opengl.GL11
 */
package ru.hld.legendline.impl.modules.Render;

import java.util.ArrayList;
import java.util.Map;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAir;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import org.lwjgl.opengl.GL11;
import ru.hld.legendline.Client;
import ru.hld.legendline.antiNative.RenderUtils;
import ru.hld.legendline.api.event.EventTarget;
import ru.hld.legendline.api.event.events.EventRender3D;
import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.api.setting.settings.BooleanSetting;
import ru.hld.legendline.api.setting.settings.ModeSetting;
import ru.hld.legendline.api.utils.CFontRenderer;
import ru.hld.legendline.api.utils.Fonts;

public class NameTags
extends Module {
    public static /* synthetic */ ModeSetting mode;
    public static /* synthetic */ BooleanSetting shadow;

    public void renderEnchant(ItemStack lllllllllllllllllIIlIIIllIIIlIlI, float lllllllllllllllllIIlIIIllIIIIIll, int lllllllllllllllllIIlIIIllIIIlIII) {
        CFontRenderer lllllllllllllllllIIlIIIllIIIIlll = Fonts.mntsb_20;
        int lllllllllllllllllIIlIIIllIIIIllI = lllllllllllllllllIIlIIIllIIIlIII + 5;
        Map lllllllllllllllllIIlIIIllIIIIlIl = EnchantmentHelper.getEnchantments((ItemStack)lllllllllllllllllIIlIIIllIIIlIlI);
        for (Enchantment lllllllllllllllllIIlIIIllIIIllII : lllllllllllllllllIIlIIIllIIIIlIl.keySet()) {
            int lllllllllllllllllIIlIIIllIIIllIl = EnchantmentHelper.getEnchantmentLevel((Enchantment)lllllllllllllllllIIlIIIllIIIllII, (ItemStack)lllllllllllllllllIIlIIIllIIIlIlI);
            lllllllllllllllllIIlIIIllIIIIlll.drawStringWithShadow(String.valueOf(new StringBuilder().append(String.valueOf(lllllllllllllllllIIlIIIllIIIllII.getName().substring(12).charAt(0)).toUpperCase()).append(lllllllllllllllllIIlIIIllIIIllIl)), lllllllllllllllllIIlIIIllIIIIIll, lllllllllllllllllIIlIIIllIIIIllI, 0xFFFFFF);
            lllllllllllllllllIIlIIIllIIIIllI -= 12;
        }
    }

    @EventTarget
    public void onRender3D(EventRender3D lllllllllllllllllIIlIIIlllIIlIll) {
        NameTags lllllllllllllllllIIlIIIlllIIlIlI;
        for (Entity lllllllllllllllllIIlIIIlllIIlllI : lllllllllllllllllIIlIIIlllIIlIlI.mc.world.loadedEntityList) {
            CFontRenderer lllllllllllllllllIIlIIIlllIIllll = Fonts.mntsb_20;
            if (lllllllllllllllllIIlIIIlllIIlllI == null || lllllllllllllllllIIlIIIlllIIlllI.isDead || !(lllllllllllllllllIIlIIIlllIIlllI instanceof EntityPlayer) || lllllllllllllllllIIlIIIlllIIlllI == lllllllllllllllllIIlIIIlllIIlIlI.mc.player) continue;
            String lllllllllllllllllIIlIIIlllIlllII = String.valueOf((Object)TextFormatting.GREEN);
            double lllllllllllllllllIIlIIIlllIllIll = lllllllllllllllllIIlIIIlllIIlllI.lastTickPosX + (lllllllllllllllllIIlIIIlllIIlllI.posX - lllllllllllllllllIIlIIIlllIIlllI.lastTickPosX) * (double)lllllllllllllllllIIlIIIlllIIlIll.getPartialTicks() - lllllllllllllllllIIlIIIlllIIlIlI.mc.getRenderManager().viewerPosX;
            double lllllllllllllllllIIlIIIlllIllIlI = lllllllllllllllllIIlIIIlllIIlllI.lastTickPosY + (lllllllllllllllllIIlIIIlllIIlllI.posY - lllllllllllllllllIIlIIIlllIIlllI.lastTickPosY) * (double)lllllllllllllllllIIlIIIlllIIlIll.getPartialTicks() - lllllllllllllllllIIlIIIlllIIlIlI.mc.getRenderManager().viewerPosY;
            double lllllllllllllllllIIlIIIlllIllIIl = lllllllllllllllllIIlIIIlllIIlllI.lastTickPosZ + (lllllllllllllllllIIlIIIlllIIlllI.posZ - lllllllllllllllllIIlIIIlllIIlllI.lastTickPosZ) * (double)lllllllllllllllllIIlIIIlllIIlIll.getPartialTicks() - lllllllllllllllllIIlIIIlllIIlIlI.mc.getRenderManager().viewerPosZ;
            GL11.glPushMatrix();
            GL11.glDisable((int)2929);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
            float lllllllllllllllllIIlIIIlllIllIII = Math.min(Math.max(1.2f * (lllllllllllllllllIIlIIIlllIIlIlI.mc.player.getDistanceToEntity(lllllllllllllllllIIlIIIlllIIlllI) * 0.15f), 1.25f), 6.0f) * 0.015f;
            GL11.glTranslatef((float)((float)lllllllllllllllllIIlIIIlllIllIll), (float)((float)lllllllllllllllllIIlIIIlllIllIlI + lllllllllllllllllIIlIIIlllIIlllI.height + 0.6f), (float)((float)lllllllllllllllllIIlIIIlllIllIIl));
            GlStateManager.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
            GlStateManager.rotate((float)(-lllllllllllllllllIIlIIIlllIIlIlI.mc.getRenderManager().playerViewY), (float)0.0f, (float)1.0f, (float)0.0f);
            GlStateManager.rotate((float)lllllllllllllllllIIlIIIlllIIlIlI.mc.getRenderManager().playerViewX, (float)1.0f, (float)0.0f, (float)0.0f);
            GL11.glScalef((float)(-lllllllllllllllllIIlIIIlllIllIII), (float)(-lllllllllllllllllIIlIIIlllIllIII), (float)(-lllllllllllllllllIIlIIIlllIllIII));
            int lllllllllllllllllIIlIIIlllIlIllI = (int)(((EntityPlayer)lllllllllllllllllIIlIIIlllIIlllI).getHealth() / ((EntityPlayer)lllllllllllllllllIIlIIIlllIIlllI).getMaxHealth() * 100.0f);
            if (((EntityLivingBase)lllllllllllllllllIIlIIIlllIIlllI).getHealth() <= ((EntityLivingBase)lllllllllllllllllIIlIIIlllIIlllI).getMaxHealth() || ((EntityLivingBase)lllllllllllllllllIIlIIIlllIIlllI).getHealth() >= ((EntityLivingBase)lllllllllllllllllIIlIIIlllIIlllI).getMaxHealth()) {
                lllllllllllllllllIIlIIIlllIlllII = String.valueOf((Object)TextFormatting.GREEN);
            }
            if (((EntityLivingBase)lllllllllllllllllIIlIIIlllIIlllI).getHealth() <= ((EntityLivingBase)lllllllllllllllllIIlIIIlllIIlllI).getMaxHealth() * 65.0f / 100.0f) {
                lllllllllllllllllIIlIIIlllIlllII = String.valueOf((Object)TextFormatting.YELLOW);
            }
            if (((EntityLivingBase)lllllllllllllllllIIlIIIlllIIlllI).getHealth() <= ((EntityLivingBase)lllllllllllllllllIIlIIIlllIIlllI).getMaxHealth() * 40.0f / 100.0f) {
                lllllllllllllllllIIlIIIlllIlllII = String.valueOf((Object)TextFormatting.RED);
            }
            String lllllllllllllllllIIlIIIlllIlIlIl = String.valueOf(new StringBuilder().append(lllllllllllllllllIIlIIIlllIIlllI.getDisplayName().getUnformattedText()).append(lllllllllllllllllIIlIIIlllIlllII).append(" & ").append((int)((EntityPlayer)lllllllllllllllllIIlIIIlllIIlllI).getHealth()));
            float lllllllllllllllllIIlIIIlllIlIlII = lllllllllllllllllIIlIIIlllIIllll.getStringWidth(lllllllllllllllllIIlIIIlllIlIlIl) + 10;
            int lllllllllllllllllIIlIIIlllIlIIll = (int)(lllllllllllllllllIIlIIIlllIlIlII - 4.0f);
            if (shadow.getVal()) {
                RenderUtils.drawShadowRect(-(lllllllllllllllllIIlIIIlllIlIlII / 2.0f), 0.0, lllllllllllllllllIIlIIIlllIlIlII / 2.0f, 15.0, 3, Client.getColor2());
                RenderUtils.drawShadowRect(-(lllllllllllllllllIIlIIIlllIlIlII / 2.0f) + 2.0f, 11.0, -(lllllllllllllllllIIlIIIlllIlIlII / 2.0f) + 2.0f + (float)lllllllllllllllllIIlIIIlllIlIIll / ((EntityPlayer)lllllllllllllllllIIlIIIlllIIlllI).getMaxHealth() * ((EntityPlayer)lllllllllllllllllIIlIIIlllIIlllI).getHealth(), 13.0, 2, Client.getColor());
            } else {
                RenderUtils.drawSuper(-(lllllllllllllllllIIlIIIlllIlIlII / 2.0f), 0.0, lllllllllllllllllIIlIIIlllIlIlII / 2.0f, 15.0, 2, Client.getColor());
                RenderUtils.drawSuper(-(lllllllllllllllllIIlIIIlllIlIlII / 2.0f) + 2.0f, 11.0, -(lllllllllllllllllIIlIIIlllIlIlII / 2.0f) + 2.0f + (float)lllllllllllllllllIIlIIIlllIlIIll / ((EntityPlayer)lllllllllllllllllIIlIIIlllIIlllI).getMaxHealth() * ((EntityPlayer)lllllllllllllllllIIlIIIlllIIlllI).getHealth(), 13.0, 1, Client.getColor());
            }
            lllllllllllllllllIIlIIIlllIIllll.drawCenteredString(lllllllllllllllllIIlIIIlllIlIlIl, 0.0, 5 - lllllllllllllllllIIlIIIlllIIllll.getHeight() / 2, -1);
            ArrayList<ItemStack> lllllllllllllllllIIlIIIlllIlIIlI = new ArrayList<ItemStack>();
            if (!(((EntityPlayer)lllllllllllllllllIIlIIIlllIIlllI).getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof ItemAir)) {
                lllllllllllllllllIIlIIIlllIlIIlI.add(((EntityPlayer)lllllllllllllllllIIlIIIlllIIlllI).getHeldItem(EnumHand.MAIN_HAND));
            }
            for (ItemStack lllllllllllllllllIIlIIIlllIlllll : lllllllllllllllllIIlIIIlllIIlllI.getArmorInventoryList()) {
                if (lllllllllllllllllIIlIIIlllIlllll.getItem() instanceof ItemAir) continue;
                lllllllllllllllllIIlIIIlllIlIIlI.add(lllllllllllllllllIIlIIIlllIlllll);
            }
            if (!(((EntityPlayer)lllllllllllllllllIIlIIIlllIIlllI).getHeldItem(EnumHand.OFF_HAND).getItem() instanceof ItemAir)) {
                lllllllllllllllllIIlIIIlllIlIIlI.add(((EntityPlayer)lllllllllllllllllIIlIIIlllIIlllI).getHeldItem(EnumHand.OFF_HAND));
            }
            int lllllllllllllllllIIlIIIlllIlIIIl = -(lllllllllllllllllIIlIIIlllIlIIlI.size() * 16 / 2);
            for (ItemStack lllllllllllllllllIIlIIIlllIlllIl : lllllllllllllllllIIlIIIlllIlIIlI) {
                RenderItem lllllllllllllllllIIlIIIlllIllllI = lllllllllllllllllIIlIIIlllIIlIlI.mc.getRenderItem();
                GlStateManager.pushMatrix();
                GlStateManager.enableBlend();
                RenderHelper.enableStandardItemLighting();
                lllllllllllllllllIIlIIIlllIllllI.zLevel = -100.0f;
                lllllllllllllllllIIlIIIlllIIlIlI.renderEnchant(lllllllllllllllllIIlIIIlllIlllIl, lllllllllllllllllIIlIIIlllIlIIIl, -35);
                lllllllllllllllllIIlIIIlllIllllI.renderItemIntoGUI(lllllllllllllllllIIlIIIlllIlllIl, lllllllllllllllllIIlIIIlllIlIIIl, -20);
                lllllllllllllllllIIlIIIlllIllllI.zLevel = 0.0f;
                RenderHelper.disableStandardItemLighting();
                GlStateManager.enableAlpha();
                GlStateManager.disableBlend();
                GlStateManager.disableLighting();
                GlStateManager.popMatrix();
                GlStateManager.pushMatrix();
                GlStateManager.disableLighting();
                GlStateManager.disableDepth();
                GlStateManager.popMatrix();
                lllllllllllllllllIIlIIIlllIlIIIl += 16;
            }
            GL11.glEnable((int)2929);
            GL11.glColor3f((float)255.0f, (float)255.0f, (float)255.0f);
            GL11.glEnable((int)2929);
            GL11.glPopMatrix();
        }
    }

    public NameTags() {
        super("NameTags", "show player info", Category.Render);
        NameTags lllllllllllllllllIIlIIIlllllIllI;
        ArrayList<String> lllllllllllllllllIIlIIIlllllIlIl = new ArrayList<String>();
        lllllllllllllllllIIlIIIlllllIlIl.add("LegendLine");
        mode = new ModeSetting("Mode", "modes of NameTags", lllllllllllllllllIIlIIIlllllIllI, lllllllllllllllllIIlIIIlllllIlIl, "LegendLine");
        Client.settingManager.add(mode);
        shadow = new BooleanSetting("Shadow", "", (Module)lllllllllllllllllIIlIIIlllllIllI, true);
        Client.settingManager.add(shadow);
    }

    public int getcenter(int lllllllllllllllllIIlIIIllIIlllIl) {
        NameTags lllllllllllllllllIIlIIIllIlIIIII;
        return lllllllllllllllllIIlIIIllIlIIIII.mc.fontRendererObj.getStringWidth(String.valueOf(lllllllllllllllllIIlIIIllIIlllIl)) / 2;
    }

    public int getcenter(String lllllllllllllllllIIlIIIllIlIlIIl) {
        NameTags lllllllllllllllllIIlIIIllIlIIlll;
        return lllllllllllllllllIIlIIIllIlIIlll.mc.fontRendererObj.getStringWidth(lllllllllllllllllIIlIIIllIlIlIIl) / 2;
    }
}

