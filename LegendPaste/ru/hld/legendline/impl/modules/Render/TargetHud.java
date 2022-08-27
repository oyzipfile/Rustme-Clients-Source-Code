/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.inventory.GuiInventory
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.ItemAir
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.EnumHand
 *  org.lwjgl.opengl.GL11
 */
package ru.hld.legendline.impl.modules.Render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Objects;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAir;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import org.lwjgl.opengl.GL11;
import ru.hld.legendline.Client;
import ru.hld.legendline.antiNative.RenderUtil;
import ru.hld.legendline.antiNative.RenderUtils;
import ru.hld.legendline.api.event.EventTarget;
import ru.hld.legendline.api.event.events.EventRender2D;
import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.api.setting.settings.ModeSetting;
import ru.hld.legendline.api.utils.CFontRenderer;
import ru.hld.legendline.api.utils.ColorUtils;
import ru.hld.legendline.api.utils.CombatUtils;
import ru.hld.legendline.api.utils.Fonts;
import ru.hld.legendline.api.utils.MathUtils;

public class TargetHud
extends Module {
    /* synthetic */ float anim;
    /* synthetic */ ModeSetting mode;
    /* synthetic */ ModeSetting color;
    /* synthetic */ float healphAnim;
    /* synthetic */ int kal;

    public TargetHud() {
        super("TargetHud", "show info about player on screen", Category.Render, 155, 35, 500, 20);
        TargetHud lllllllllllllIllllIIllIIlIIlIIlI;
        lllllllllllllIllllIIllIIlIIlIIlI.anim = 0.8f;
        lllllllllllllIllllIIllIIlIIlIIlI.healphAnim = 0.0f;
        ArrayList<String> lllllllllllllIllllIIllIIlIIlIIIl = new ArrayList<String>();
        ArrayList<String> lllllllllllllIllllIIllIIlIIlIIII = new ArrayList<String>();
        lllllllllllllIllllIIllIIlIIlIIIl.add("Circle");
        lllllllllllllIllllIIllIIlIIlIIIl.add("Line");
        lllllllllllllIllllIIllIIlIIlIIII.add("Astolfo");
        lllllllllllllIllllIIllIIlIIlIIII.add("Client");
        lllllllllllllIllllIIllIIlIIlIIlI.mode = new ModeSetting("Mode", "modes of TargetHud", lllllllllllllIllllIIllIIlIIlIIlI, lllllllllllllIllllIIllIIlIIlIIIl, "Circle");
        Client.settingManager.add(lllllllllllllIllllIIllIIlIIlIIlI.mode);
        lllllllllllllIllllIIllIIlIIlIIlI.color = new ModeSetting("Color", "Colors of TargetHud", lllllllllllllIllllIIllIIlIIlIIlI, lllllllllllllIllllIIllIIlIIlIIII, "Astolfo");
        Client.settingManager.add(lllllllllllllIllllIIllIIlIIlIIlI.color);
    }

    @EventTarget
    public void onRender2D(EventRender2D lllllllllllllIllllIIllIIIIllllII) {
        TargetHud lllllllllllllIllllIIllIIIIllllIl;
        CFontRenderer lllllllllllllIllllIIllIIIIlllIll = Fonts.mntsb_20;
        EntityPlayer lllllllllllllIllllIIllIIIIlllIlI = (EntityPlayer)CombatUtils.getTerget(false);
        ArrayList<ItemStack> lllllllllllllIllllIIllIIIIllIllI = new ArrayList<ItemStack>();
        int lllllllllllllIllllIIllIIIIllIlII = lllllllllllllIllllIIllIIIIllllIl.getPosX();
        int lllllllllllllIllllIIllIIIIllIIII = lllllllllllllIllllIIllIIIIllllIl.getPosY();
        int lllllllllllllIllllIIllIIIIlIlllI = 0;
        boolean lllllllllllllIllllIIllIIIIlIllIl = false;
        String lllllllllllllIllllIIllIIIIlIllII = lllllllllllllIllllIIllIIIIlllIlI.getDisplayName().getUnformattedText();
        String lllllllllllllIllllIIllIIIIlIlIll = "huitopytutyuu5u5yuytj";
        int lllllllllllllIllllIIllIIIIlIlIlI = lllllllllllllIllllIIllIIIIlllIll.getStringWidth(lllllllllllllIllllIIllIIIIlIllII) + 10;
        int lllllllllllllIllllIIllIIIIlIlIIl = lllllllllllllIllllIIllIIIIlllIll.getStringWidth(lllllllllllllIllllIIllIIIIlIlIll);
        int lllllllllllllIllllIIllIIIIlIlIII = lllllllllllllIllllIIllIIIIlIlIlI - 4;
        switch (lllllllllllllIllllIIllIIIIllllIl.color.getVal()) {
            case "Astolfo": {
                lllllllllllllIllllIIllIIIIlIlllI = lllllllllllllIllllIIllIIIIlllIlI.hurtTime < 1 ? ColorUtils.astolfoColorsCool(80, 80) : ColorUtils.getColor(255, 30, 40, lllllllllllllIllllIIllIIIIllllIl.mc.player.hurtTime * 8);
                break;
            }
            case "Client": {
                lllllllllllllIllllIIllIIIIlIlllI = lllllllllllllIllllIIllIIIIlllIlI.hurtTime < 1 ? Client.getColor() : ColorUtils.getColor(255, 30, 40, lllllllllllllIllllIIllIIIIllllIl.mc.player.hurtTime * 8);
            }
        }
        switch (lllllllllllllIllllIIllIIIIllllIl.mode.getVal()) {
            case "Circle": {
                if (lllllllllllllIllllIIllIIIIlllIlI != null) {
                    lllllllllllllIllllIIllIIIIllllIl.anim = 0.5f;
                    return;
                }
                lllllllllllllIllllIIllIIIIllllIl.anim = MathUtils.lerp(lllllllllllllIllllIIllIIIIllllIl.anim, 1.0f, 0.3f);
                GL11.glPushMatrix();
                RenderUtils.customScaledObject2D(lllllllllllllIllllIIllIIIIllIlII, lllllllllllllIllllIIllIIIIllIIII, lllllllllllllIllllIIllIIIIllllIl.getSizeX(), lllllllllllllIllllIIllIIIIllllIl.getSizeY(), lllllllllllllIllllIIllIIIIllllIl.anim, lllllllllllllIllllIIllIIIIllllIl.anim);
                RenderUtils.drawShadowRect(lllllllllllllIllllIIllIIIIllIlII, lllllllllllllIllllIIllIIIIllIIII, lllllllllllllIllllIIllIIIIllIlII + lllllllllllllIllllIIllIIIIllllIl.getSizeX(), lllllllllllllIllllIIllIIIIllIIII + lllllllllllllIllllIIllIIIIllllIl.getSizeY(), 3, new Color(30, 30, 30, 200).getRGB());
                RenderUtils.drawGradientRect(lllllllllllllIllllIIllIIIIllIlII, lllllllllllllIllllIIllIIIIllIIII, lllllllllllllIllllIIllIIIIllIlII + lllllllllllllIllllIIllIIIIllllIl.getSizeX(), lllllllllllllIllllIIllIIIIllIIII + lllllllllllllIllllIIllIIIIllllIl.getSizeY(), true, lllllllllllllIllllIIllIIIIlIlllI, lllllllllllllIllllIIllIIIIlIlllI);
                GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                try {
                    GuiInventory.drawEntityOnScreen((int)(lllllllllllllIllllIIllIIIIllIlII + 10), (int)(lllllllllllllIllllIIllIIIIllIIII + 32), (int)15, (float)100.0f, (float)0.0f, (EntityLivingBase)lllllllllllllIllllIIllIIIIlllIlI);
                }
                catch (Exception lllllllllllllIllllIIllIIIlIlIIlI) {
                    lllllllllllllIllllIIllIIIlIlIIlI.printStackTrace();
                }
                if (!(lllllllllllllIllllIIllIIIIlllIlI.getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof ItemAir)) {
                    lllllllllllllIllllIIllIIIIllIllI.add(lllllllllllllIllllIIllIIIIlllIlI.getHeldItem(EnumHand.MAIN_HAND));
                }
                for (Object lllllllllllllIllllIIllIIIlIIlIlI : lllllllllllllIllllIIllIIIIlllIlI.getArmorInventoryList()) {
                    if (lllllllllllllIllllIIllIIIlIIlIlI.getItem() instanceof ItemAir) continue;
                    lllllllllllllIllllIIllIIIIllIllI.add((ItemStack)lllllllllllllIllllIIllIIIlIIlIlI);
                }
                if (!(lllllllllllllIllllIIllIIIIlllIlI.getHeldItem(EnumHand.OFF_HAND).getItem() instanceof ItemAir)) {
                    lllllllllllllIllllIIllIIIIllIllI.add(lllllllllllllIllllIIllIIIIlllIlI.getHeldItem(EnumHand.OFF_HAND));
                }
                int lllllllllllllIllllIIllIIIlIIIlII = 20;
                for (ItemStack lllllllllllllIllllIIllIIIlIIlIII : lllllllllllllIllllIIllIIIIllIllI) {
                    RenderUtils.renderItem(lllllllllllllIllllIIllIIIlIIlIII, lllllllllllllIllllIIllIIIIllIlII + lllllllllllllIllllIIllIIIlIIIlII, lllllllllllllIllllIIllIIIIllIIII + 16);
                    lllllllllllllIllllIIllIIIlIIIlII += 16;
                }
                lllllllllllllIllllIIllIIIIlllIll.drawString(lllllllllllllIllllIIllIIIIlIllII, lllllllllllllIllllIIllIIIIllIlII + 23, lllllllllllllIllllIIllIIIIllIIII + 2, -1);
                lllllllllllllIllllIIllIIIIllllIl.healphAnim = MathUtils.lerp(lllllllllllllIllllIIllIIIIllllIl.healphAnim, lllllllllllllIllllIIllIIIIlllIlI.getHealth(), 0.4f);
                RenderUtil.drawCircle228(lllllllllllllIllllIIllIIIIllIlII + 138, lllllllllllllIllllIIllIIIIllIIII + 17, 12.0f, -1, (int)lllllllllllllIllllIIllIIIIllllIl.mc.player.getMaxHealth() * (int)lllllllllllllIllllIIllIIIIlllIlI.getHealth());
                lllllllllllllIllllIIllIIIIlllIll.drawCenteredString(String.valueOf(new StringBuilder().append((int)lllllllllllllIllllIIllIIIIlllIlI.getHealth()).append("")), lllllllllllllIllllIIllIIIIllIlII + 138, lllllllllllllIllllIIllIIIIllIIII + 14, -1);
                GL11.glPopMatrix();
                break;
            }
            case "Line": {
                if (lllllllllllllIllllIIllIIIIlllIlI == null) {
                    lllllllllllllIllllIIllIIIIllllIl.anim = 0.5f;
                    return;
                }
                lllllllllllllIllllIIllIIIIllllIl.anim = MathUtils.lerp(lllllllllllllIllllIIllIIIIllllIl.anim, 1.0f, 0.1f);
                GL11.glPushMatrix();
                RenderUtils.customScaledObject2D(lllllllllllllIllllIIllIIIIllIlII, lllllllllllllIllllIIllIIIIllIIII, lllllllllllllIllllIIllIIIIllllIl.getSizeX(), lllllllllllllIllllIIllIIIIllllIl.getSizeY(), lllllllllllllIllllIIllIIIIllllIl.anim, lllllllllllllIllllIIllIIIIllllIl.anim);
                if (lllllllllllllIllllIIllIIIIlIlIlI >= 120) {
                    RenderUtils.drawShadowRect(lllllllllllllIllllIIllIIIIllIlII, lllllllllllllIllllIIllIIIIllIIII, (double)(lllllllllllllIllllIIllIIIIllIlII + 10) + (double)(lllllllllllllIllllIIllIIIIlIlIlI / 2) * 2.3, lllllllllllllIllllIIllIIIIllIIII + lllllllllllllIllllIIllIIIIllllIl.getSizeY() + 5, 3, new Color(30, 30, 30, 100).getRGB());
                    RenderUtils.drawShadowRect(lllllllllllllIllllIIllIIIIllIlII, lllllllllllllIllllIIllIIIIllIIII + lllllllllllllIllllIIllIIIIllllIl.getSizeY(), (double)(lllllllllllllIllllIIllIIIIllIlII + 10) + (double)(lllllllllllllIllllIIllIIIIlIlIlI / 2) * 2.3, lllllllllllllIllllIIllIIIIllIIII + lllllllllllllIllllIIllIIIIllllIl.getSizeY() + 5, 3, ColorUtils.swapAlpha(lllllllllllllIllllIIllIIIIlIlllI, 255.0f));
                    RenderUtils.drawShadowRect(lllllllllllllIllllIIllIIIIllIlII, lllllllllllllIllllIIllIIIIllIIII + lllllllllllllIllllIIllIIIIllllIl.getSizeY(), lllllllllllllIllllIIllIIIIllIlII + lllllllllllllIllllIIllIIIIllllIl.getSizeX(), lllllllllllllIllllIIllIIIIllIIII + lllllllllllllIllllIIllIIIIllllIl.getSizeY() + 5, 3, new Color(100, 100, 100, 50).getRGB());
                    lllllllllllllIllllIIllIIIIlllIll.drawCenteredString(String.valueOf(new StringBuilder().append((int)lllllllllllllIllllIIllIIIIlllIlI.getHealth()).append("")), (float)(lllllllllllllIllllIIllIIIIllIlII + 3) + (float)(lllllllllllllIllllIIllIIIIlIlIlI + 20) / lllllllllllllIllllIIllIIIIlllIlI.getMaxHealth() * lllllllllllllIllllIIllIIIIllllIl.healphAnim, lllllllllllllIllllIIllIIIIllIIII + lllllllllllllIllllIIllIIIIllllIl.getSizeY() + 8, -1);
                } else {
                    RenderUtils.drawShadowRect(lllllllllllllIllllIIllIIIIllIlII, lllllllllllllIllllIIllIIIIllIIII, lllllllllllllIllllIIllIIIIllIlII + lllllllllllllIllllIIllIIIIllllIl.getSizeX(), lllllllllllllIllllIIllIIIIllIIII + lllllllllllllIllllIIllIIIIllllIl.getSizeY() + 5, 3, new Color(30, 30, 30, 100).getRGB());
                    RenderUtils.drawShadowRect(lllllllllllllIllllIIllIIIIllIlII, lllllllllllllIllllIIllIIIIllIIII + lllllllllllllIllllIIllIIIIllllIl.getSizeY(), (double)lllllllllllllIllllIIllIIIIllIlII + 6.4 + (double)((float)(lllllllllllllIllllIIllIIIIllllIl.getSizeX() - 6) / lllllllllllllIllllIIllIIIIlllIlI.getMaxHealth() * lllllllllllllIllllIIllIIIIllllIl.healphAnim), lllllllllllllIllllIIllIIIIllIIII + lllllllllllllIllllIIllIIIIllllIl.getSizeY() + 5, 2, ColorUtils.swapAlpha(lllllllllllllIllllIIllIIIIlIlllI, 255.0f));
                    RenderUtils.drawShadowRect(lllllllllllllIllllIIllIIIIllIlII, lllllllllllllIllllIIllIIIIllIIII + lllllllllllllIllllIIllIIIIllllIl.getSizeY(), lllllllllllllIllllIIllIIIIllIlII + lllllllllllllIllllIIllIIIIllllIl.getSizeX(), lllllllllllllIllllIIllIIIIllIIII + lllllllllllllIllllIIllIIIIllllIl.getSizeY() + 5, 3, new Color(100, 100, 100, 50).getRGB());
                    lllllllllllllIllllIIllIIIIlllIll.drawCenteredString(String.valueOf(new StringBuilder().append((int)lllllllllllllIllllIIllIIIIlllIlI.getHealth()).append("")), (float)(lllllllllllllIllllIIllIIIIllIlII + 3) + (float)(lllllllllllllIllllIIllIIIIllllIl.getSizeX() - 6) / lllllllllllllIllllIIllIIIIlllIlI.getMaxHealth() * lllllllllllllIllllIIllIIIIllllIl.healphAnim, lllllllllllllIllllIIllIIIIllIIII + lllllllllllllIllllIIllIIIIllllIl.getSizeY() + 8, -1);
                }
                GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                try {
                    RenderUtil.drawHead(Objects.requireNonNull(lllllllllllllIllllIIllIIIIllllIl.mc.getConnection()).getPlayerInfo(lllllllllllllIllllIIllIIIIlllIlI.getUniqueID()).getLocationSkin(), lllllllllllllIllllIIllIIIIllIlII + 2, lllllllllllllIllllIIllIIIIllIIII + 2, 28, 28);
                    if (lllllllllllllIllllIIllIIIIllllIl.mc.player.hurtTime > 0) {
                        RenderUtils.drawRect(lllllllllllllIllllIIllIIIIllIlII + 2, lllllllllllllIllllIIllIIIIllIIII + 2, lllllllllllllIllllIIllIIIIllIlII + 30, lllllllllllllIllllIIllIIIIllIIII + 30, ColorUtils.getColor(255, 0, 0, lllllllllllllIllllIIllIIIIllllIl.mc.player.hurtTime * 20));
                    }
                }
                catch (Exception lllllllllllllIllllIIllIIIlIIIIlI) {
                    lllllllllllllIllllIIllIIIlIIIIlI.printStackTrace();
                }
                if (!(lllllllllllllIllllIIllIIIIlllIlI.getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof ItemAir)) {
                    lllllllllllllIllllIIllIIIIllIllI.add(lllllllllllllIllllIIllIIIIlllIlI.getHeldItem(EnumHand.MAIN_HAND));
                }
                for (ItemStack lllllllllllllIllllIIllIIIlIIIIIl : lllllllllllllIllllIIllIIIIlllIlI.getArmorInventoryList()) {
                    if (lllllllllllllIllllIIllIIIlIIIIIl.getItem() instanceof ItemAir) continue;
                    lllllllllllllIllllIIllIIIIllIllI.add(lllllllllllllIllllIIllIIIlIIIIIl);
                }
                if (!(lllllllllllllIllllIIllIIIIlllIlI.getHeldItem(EnumHand.OFF_HAND).getItem() instanceof ItemAir)) {
                    lllllllllllllIllllIIllIIIIllIllI.add(lllllllllllllIllllIIllIIIIlllIlI.getHeldItem(EnumHand.OFF_HAND));
                }
                int lllllllllllllIllllIIllIIIIllllll = 20;
                for (ItemStack lllllllllllllIllllIIllIIIlIIIIII : lllllllllllllIllllIIllIIIIllIllI) {
                    RenderUtils.renderItem(lllllllllllllIllllIIllIIIlIIIIII, lllllllllllllIllllIIllIIIIllIlII + lllllllllllllIllllIIllIIIIllllll + 13, lllllllllllllIllllIIllIIIIllIIII + 13);
                    lllllllllllllIllllIIllIIIIllllll += 16;
                }
                lllllllllllllIllllIIllIIIIlllIll.drawString(lllllllllllllIllllIIllIIIIlllIlI.getDisplayName().getUnformattedText(), lllllllllllllIllllIIllIIIIllIlII + 33, lllllllllllllIllllIIllIIIIllIIII + 2, -1);
                lllllllllllllIllllIIllIIIIllllIl.healphAnim = MathUtils.lerp(lllllllllllllIllllIIllIIIIllllIl.healphAnim, lllllllllllllIllllIIllIIIIlllIlI.getHealth(), 1.0f);
                GL11.glPopMatrix();
            }
        }
    }

    @Override
    public void onEnable() {
        TargetHud lllllllllllllIllllIIllIIlIIIlIll;
        super.onEnable();
    }
}

