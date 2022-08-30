/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderItem
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$Text
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.GL11
 */
package ru.internali.module.HUD;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;
import ru.internali.utils.InventoryUtil;

public class AmmoGun
extends Module {
    public /* synthetic */ String held;
    public static /* synthetic */ boolean canMove;

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Text lIIIIIIIlIIIlI) {
        AmmoGun lIIIIIIIIllllI;
        if (Mouse.isButtonDown((int)0)) {
            lIIIIIIIIllllI.mouseClicked(Mouse.getX(), Mouse.getY(), 0);
        }
        RenderItem lIIIIIIIlIIIIl = Minecraft.getMinecraft().getRenderItem();
        ItemStack lIIIIIIIlIIIII = new ItemStack(Items.END_CRYSTAL, 1);
        GL11.glPushMatrix();
        GlStateManager.enableTexture2D();
        GlStateManager.enableDepth();
        mc.getRenderItem().renderItemAndEffectIntoGUI(lIIIIIIIlIIIII, lIIIIIIIIllllI.getPosX() / 2 - 5, lIIIIIIIIllllI.getPosY() / -2 + 530);
        int lIIIIIIIIlllll = InventoryUtil.getItems(Items.END_CRYSTAL);
        mc.getRenderItem().renderItemOverlayIntoGUI(AmmoGun.mc.fontRenderer, lIIIIIIIlIIIII, lIIIIIIIIllllI.getPosX() / 2 - 5, lIIIIIIIIllllI.getPosY() / -2 + 530, String.valueOf(new StringBuilder().append((Object)lIIIIIIIIllllI.colorchoice()).append(String.valueOf(lIIIIIIIIlllll))));
        GlStateManager.enableTexture2D();
        GlStateManager.disableLighting();
        GlStateManager.disableDepth();
        GlStateManager.enableDepth();
        GlStateManager.disableLighting();
        GL11.glPopMatrix();
    }

    private ChatFormatting colorchoice() {
        AmmoGun lIIIIIIIIlIlII;
        String lIIIIIIIIlIlIl;
        switch (lIIIIIIIIlIlIl = CatClient.instance.settingsManager.getSettingByName(lIIIIIIIIlIlII, "Mode").getValString()) {
            case "BLACK": {
                return ChatFormatting.BLACK;
            }
            case "RED": {
                return ChatFormatting.RED;
            }
            case "AQUA": {
                return ChatFormatting.AQUA;
            }
            case "BLUE": {
                return ChatFormatting.BLUE;
            }
            case "GOLD": {
                return ChatFormatting.GOLD;
            }
            case "GRAY": {
                return ChatFormatting.GRAY;
            }
            case "WHITE": {
                return ChatFormatting.WHITE;
            }
            case "GREEN": {
                return ChatFormatting.GREEN;
            }
            case "YELLOW": {
                return ChatFormatting.YELLOW;
            }
            case "DARK_RED": {
                return ChatFormatting.DARK_RED;
            }
            case "DARK_AQUA": {
                return ChatFormatting.DARK_AQUA;
            }
            case "DARK_BLUE": {
                return ChatFormatting.DARK_BLUE;
            }
            case "DARK_GRAY": {
                return ChatFormatting.DARK_GRAY;
            }
            case "DARK_GREEN": {
                return ChatFormatting.DARK_GREEN;
            }
            case "DARK_PURPLE": {
                return ChatFormatting.LIGHT_PURPLE;
            }
            case "LIGHT_PURPLE": {
                return ChatFormatting.DARK_PURPLE;
            }
        }
        return ChatFormatting.WHITE;
    }

    public AmmoGun() {
        super("AmmoGun", "AmmoGun", Category.HUD);
        AmmoGun lIIIIIIlIIIlIl;
        lIIIIIIlIIIlIl.held = "Waiting";
        ArrayList<String> lIIIIIIlIIIllI = new ArrayList<String>();
        lIIIIIIlIIIllI.add("BLACK");
        lIIIIIIlIIIllI.add("RED");
        lIIIIIIlIIIllI.add("AQUA");
        lIIIIIIlIIIllI.add("BLUE");
        lIIIIIIlIIIllI.add("GOLD");
        lIIIIIIlIIIllI.add("GRAY");
        lIIIIIIlIIIllI.add("WHITE");
        lIIIIIIlIIIllI.add("GREEN");
        lIIIIIIlIIIllI.add("YELLOW");
        lIIIIIIlIIIllI.add("DARK_RED");
        lIIIIIIlIIIllI.add("DARK_AQUA");
        lIIIIIIlIIIllI.add("DARK_BLUE");
        lIIIIIIlIIIllI.add("DARK_GRAY");
        lIIIIIIlIIIllI.add("DARK_GREEN");
        lIIIIIIlIIIllI.add("DARK_PURPLE");
        lIIIIIIlIIIllI.add("LIGHT_PURPLE");
        CatClient.instance.settingsManager.rSetting(new Setting("Mode", lIIIIIIlIIIlIl, "AQUA", lIIIIIIlIIIllI));
    }

    public void mouseClicked(int lIIIIIIIllIIll, int lIIIIIIIllIllI, int lIIIIIIIllIIIl) {
        AmmoGun lIIIIIIIllIlII;
        canMove = true;
        if (lIIIIIIIllIIIl == 0) {
            lIIIIIIIllIlII.setHeld(lIIIIIIIllIlII.getName());
            if (lIIIIIIIllIlII.isMouseOnButton(lIIIIIIIllIIll, lIIIIIIIllIllI) && canMove) {
                lIIIIIIIllIlII.setPosX(lIIIIIIIllIIll);
                lIIIIIIIllIlII.setPosY(lIIIIIIIllIllI);
            }
        }
        if (!lIIIIIIIllIlII.isMouseOnButton(lIIIIIIIllIIll, lIIIIIIIllIllI) || lIIIIIIIllIIIl == 1) {
            // empty if block
        }
    }

    public boolean isMouseOnButton(int lIIIIIIIlIlIIl, int lIIIIIIIlIlIll) {
        AmmoGun lIIIIIIIlIlIlI;
        return lIIIIIIIlIlIIl >= lIIIIIIIlIlIlI.getPosX() - 20 && lIIIIIIIlIlIIl <= lIIIIIIIlIlIlI.getPosX() + 20 && lIIIIIIIlIlIll >= lIIIIIIIlIlIlI.getPosY() - 15 && lIIIIIIIlIlIll <= lIIIIIIIlIlIlI.getPosY() + 20;
    }

    public void setHeld(String lIIIIIIlIIIIIl) {
        AmmoGun lIIIIIIlIIIIlI;
        lIIIIIIlIIIIlI.held = lIIIIIIlIIIIlI.getName();
    }

    static {
        canMove = false;
    }

    public String getHeld() {
        AmmoGun lIIIIIIIlllllI;
        return lIIIIIIIlllllI.held;
    }

    private static enum color {
        BLACK,
        DARK_BLUE,
        DARK_GREEN,
        DARK_AQUA,
        DARK_RED,
        DARK_PURPLE,
        GOLD,
        GRAY,
        DARK_GRAY,
        BLUE,
        GREEN,
        AQUA,
        RED,
        LIGHT_PURPLE,
        YELLOW,
        WHITE;


        private color() {
            color lIIlIlIllIIIIII;
        }
    }
}

