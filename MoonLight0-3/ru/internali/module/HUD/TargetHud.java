/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderItem
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.text.TextFormatting
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$ElementType
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$Text
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.opengl.GL11
 */
package ru.internali.module.HUD;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.module.combat.AimPistol;
import ru.internali.module.combat.AntiBot;
import ru.internali.settings.Setting;
import ru.internali.utils.RenderUtil;
import ru.internali.utils.friend.FriendManager;

public class TargetHud
extends Module {
    private /* synthetic */ String enemyNickname;
    private /* synthetic */ Entity entity;
    public static /* synthetic */ List<String> Modes;
    private /* synthetic */ double healthBarWidth;
    private /* synthetic */ EntityPlayer entityPlayer;
    private static /* synthetic */ RenderItem itemRender;
    private /* synthetic */ boolean show;
    private /* synthetic */ Entity target;
    private /* synthetic */ double enemyHP;
    private /* synthetic */ double enemyDistance;

    public void drawitem(ItemStack lllIIlIllIIlIl, int lllIIlIllIIlll, int lllIIlIllIIIll) {
        GlStateManager.enableDepth();
        TargetHud.itemRender.zLevel = 200.0f;
        itemRender.renderItemAndEffectIntoGUI(lllIIlIllIIlIl, lllIIlIllIIlll, lllIIlIllIIIll);
        itemRender.renderItemOverlayIntoGUI(TargetHud.mc.fontRenderer, lllIIlIllIIlIl, lllIIlIllIIlll, lllIIlIllIIIll, "");
        GlStateManager.enableTexture2D();
        GlStateManager.disableLighting();
        GlStateManager.disableDepth();
        if (lllIIlIllIIlIl.getCount() == 0 || lllIIlIllIIlIl.getCount() == 1) {
            TargetHud.mc.fontRenderer.drawString("", lllIIlIllIIlll + 13, lllIIlIllIIIll + 10, Color.white.getRGB());
        } else {
            TargetHud.mc.fontRenderer.drawString(String.valueOf(new StringBuilder().append("").append(lllIIlIllIIlIl.getCount())), lllIIlIllIIlll + 13, lllIIlIllIIIll + 10, Color.white.getRGB());
        }
    }

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Text lllIIlIlIllIlI) {
        if (lllIIlIlIllIlI.getType() != RenderGameOverlayEvent.ElementType.TEXT || Minecraft.getMinecraft().gameSettings.showDebugInfo) {
            return;
        }
        try {
            GlStateManager.enableTexture2D();
            for (Entity lllIIlIlIllllI : TargetHud.mc.world.field_72996_f) {
                if (!(lllIIlIlIllllI instanceof EntityPlayer) || !(TargetHud.mc.player.func_70032_d(lllIIlIlIllllI) <= 250.0f) || lllIIlIlIllllI == TargetHud.mc.player || AntiBot.isBot(lllIIlIlIllllI.getName())) continue;
                lllIIlIlIllIIl.target = lllIIlIlIllllI;
            }
            if (AimPistol.target instanceof EntityPlayer) {
                TargetHud lllIIlIlIllIIl;
                EntityPlayer lllIIlIlIlllIl = (EntityPlayer)AimPistol.target;
                lllIIlIlIllIIl.targethud((Entity)lllIIlIlIlllIl);
            }
        }
        catch (Exception lllIIlIlIlllII) {
            lllIIlIlIlllII.printStackTrace();
        }
    }

    static {
        Modes = new ArrayList<String>();
        itemRender = Minecraft.getMinecraft().getRenderItem();
    }

    public void targethud(Entity lllIIlIlllIlII) {
        TargetHud lllIIlIlllIlIl;
        ScaledResolution lllIIlIlllllII = new ScaledResolution(mc);
        float lllIIlIllllIll = (float)CatClient.instance.settingsManager.getSettingByName(lllIIlIlllIlIl, "PosX").getValDouble();
        float lllIIlIllllIlI = (float)CatClient.instance.settingsManager.getSettingByName(lllIIlIlllIlIl, "PosY").getValDouble();
        GL11.glPushMatrix();
        GL11.glTranslated((double)((float)(lllIIlIlllllII.getScaledWidth() / 2 + 10) + lllIIlIllllIll), (double)((float)(lllIIlIlllllII.getScaledHeight() / 2) + lllIIlIllllIlI), (double)(lllIIlIlllllII.getScaledWidth() / 2 + 10));
        Gui.drawRect((int)-6, (int)0, (int)145, (int)45, (int)new Color(36, 36, 40, 47).getRGB());
        if (FriendManager.isFriend(lllIIlIlllIlII.getName())) {
            TargetHud.mc.fontRenderer.drawStringWithShadow(lllIIlIlllIlII.getName(), 28.0f, 4.0f, Color.GREEN.getRGB());
        } else {
            TargetHud.mc.fontRenderer.drawStringWithShadow(lllIIlIlllIlII.getName(), 28.0f, 4.0f, Color.white.getRGB());
        }
        try {
            mc.getTextureManager().bindTexture(Objects.requireNonNull(mc.getConnection()).getPlayerInfo(lllIIlIlllIlII.getUniqueID()).getLocationSkin());
            Gui.drawScaledCustomSizeModalRect((int)2, (int)2, (float)8.0f, (float)8.0f, (int)8, (int)8, (int)22, (int)22, (float)64.0f, (float)64.0f);
        }
        catch (Exception lllIIllIIIIIII) {
            lllIIllIIIIIII.printStackTrace();
        }
        int lllIIlIllllIIl = 8;
        RenderUtil.drawFilledCircle(lllIIlIllllIIl, 35, 10.0f, Color.LIGHT_GRAY);
        RenderUtil.drawFilledCircle(lllIIlIllllIIl, 35, 9.0f, new Color(35, 35, 40, 108));
        ItemStack lllIIlIllllIII = ((EntityPlayer)lllIIlIlllIlII).func_184614_ca();
        lllIIlIlllIlIl.drawitem(lllIIlIllllIII, lllIIlIllllIIl - 8, 27);
        RenderUtil.drawFilledCircle(lllIIlIllllIIl += 24, 35, 10.0f, Color.LIGHT_GRAY);
        RenderUtil.drawFilledCircle(lllIIlIllllIIl, 35, 9.0f, new Color(35, 35, 40, 108));
        lllIIlIllllIII = ((EntityPlayer)lllIIlIlllIlII).func_184592_cb();
        lllIIlIlllIlIl.drawitem(lllIIlIllllIII, lllIIlIllllIIl - 8, 27);
        lllIIlIllllIIl += 24;
        for (ItemStack lllIIlIlllllll : lllIIlIlllIlII.getArmorInventoryList()) {
            RenderUtil.drawFilledCircle(lllIIlIllllIIl, 35, 10.0f, Color.LIGHT_GRAY);
            RenderUtil.drawFilledCircle(lllIIlIllllIIl, 35, 9.0f, new Color(35, 35, 40, 108));
            lllIIlIlllIlIl.drawitem(lllIIlIlllllll, lllIIlIllllIIl - 8, 27);
            lllIIlIllllIIl += 24;
        }
        RenderUtil.drawFilledCircle(130, 13, 11.0f, Color.LIGHT_GRAY);
        RenderUtil.drawFilledCircle(130, 13, ((EntityPlayer)lllIIlIlllIlII).func_110143_aJ() / 2.0f, Color.green);
        if (((EntityPlayer)lllIIlIlllIlII).field_70737_aN > 0) {
            RenderUtil.drawFilledCircle(130, 13, ((EntityPlayer)lllIIlIlllIlII).func_110143_aJ() / 2.0f, Color.red);
        }
        int[] lllIIlIlllIlll = new int[]{1};
        lllIIlIlllIlll[0] = lllIIlIlllIlll[0] + 1;
        int lllIIlIlllIllI = (int)((EntityPlayer)lllIIlIlllIlII).func_110143_aJ();
        if (((EntityPlayer)lllIIlIlllIlII).field_70737_aN > 0) {
            TargetHud.mc.fontRenderer.drawStringWithShadow(String.valueOf(new StringBuilder().append(lllIIlIlllIllI).append("").append((Object)TextFormatting.RED).append(" -").append(((EntityPlayer)lllIIlIlllIlII).field_70737_aN)), 28.0f, (float)(4 + TargetHud.mc.fontRenderer.FONT_HEIGHT), Color.white.getRGB());
        } else {
            TargetHud.mc.fontRenderer.drawStringWithShadow(String.valueOf(new StringBuilder().append(lllIIlIlllIllI).append("")), 28.0f, (float)(4 + TargetHud.mc.fontRenderer.FONT_HEIGHT), Color.white.getRGB());
        }
        GlStateManager.enableDepth();
        GlStateManager.disableLighting();
        GL11.glPopMatrix();
    }

    public TargetHud() {
        super("TargetHud", "TargetHud", Category.HUD);
        TargetHud lllIIllIIIlIll;
        CatClient.instance.settingsManager.rSetting(new Setting("PosX", lllIIllIIIlIll, 30.0, -400.0, 325.0, true));
        CatClient.instance.settingsManager.rSetting(new Setting("PosY", lllIIllIIIlIll, 60.0, -270.0, 225.0, true));
    }
}

