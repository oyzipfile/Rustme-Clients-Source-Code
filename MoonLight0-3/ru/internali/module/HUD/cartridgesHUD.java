/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderItem
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.Slot
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$Text
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.opengl.GL11
 */
package ru.internali.module.HUD;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.init.Items;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;
import ru.internali.utils.RenderUtils;

public class cartridgesHUD
extends Module {
    private /* synthetic */ int RABBIT_HIDE;
    private /* synthetic */ int SHULKER_SHELL;
    private /* synthetic */ int PRISMARINE_CRYSTALS;
    private /* synthetic */ int PRISMARINE_SHARD;
    private /* synthetic */ ItemStack BRICK2;
    private /* synthetic */ int STICK;
    private /* synthetic */ ItemStack STICK2;
    /* synthetic */ ScaledResolution sr;
    private /* synthetic */ ItemStack RABBIT_HIDE2;
    private /* synthetic */ int ARROW;
    private final /* synthetic */ FontRenderer fr;
    private static /* synthetic */ RenderItem kappita;
    private /* synthetic */ ItemStack SHULKER_SHELL2;
    private /* synthetic */ int GUNPOWDER;
    private static final /* synthetic */ RenderItem itemRender;
    private /* synthetic */ ItemStack ARROW2;
    private /* synthetic */ ItemStack PRISMARINE_SHARD2;
    private /* synthetic */ int BRICK;
    private /* synthetic */ ItemStack PRISMARINE_CRYSTALS2;
    private /* synthetic */ ItemStack GUNPOWDER2;

    public cartridgesHUD() {
        super("CartridgesHUD", "show Cartiges", Category.HUD);
        cartridgesHUD lIIlIllllIIlll;
        lIIlIllllIIlll.fr = Minecraft.getMinecraft().fontRenderer;
        lIIlIllllIIlll.sr = new ScaledResolution(mc);
        lIIlIllllIIlll.STICK = 0;
        lIIlIllllIIlll.BRICK = 0;
        lIIlIllllIIlll.PRISMARINE_CRYSTALS = 0;
        lIIlIllllIIlll.PRISMARINE_SHARD = 0;
        lIIlIllllIIlll.SHULKER_SHELL = 0;
        lIIlIllllIIlll.RABBIT_HIDE = 0;
        lIIlIllllIIlll.GUNPOWDER = 0;
        lIIlIllllIIlll.ARROW = 0;
        CatClient.instance.settingsManager.rSetting(new Setting("PosX", lIIlIllllIIlll, 50.0, 0.0, 200.0, true));
        CatClient.instance.settingsManager.rSetting(new Setting("PosY", lIIlIllllIIlll, 50.0, 0.0, 500.0, true));
    }

    public void drawitem(ItemStack lIIlIlllIllIll, int lIIlIlllIllIlI, int lIIlIlllIllIIl, int lIIlIlllIllIII) {
        cartridgesHUD lIIlIllllIIIIl;
        cartridgesHUD.itemRender.zLevel = 1.0f;
        lIIlIllllIIIIl.fr.drawString("", 0, 0, Color.white.getRGB());
        RenderUtils.drawShadowRect(lIIlIlllIllIlI, lIIlIlllIllIIl, lIIlIlllIllIlI + 19, lIIlIlllIllIIl + 20, 2);
        GlStateManager.resetColor();
        itemRender.renderItemAndEffectIntoGUI(lIIlIlllIllIll, lIIlIlllIllIlI, lIIlIlllIllIIl);
        itemRender.renderItemOverlayIntoGUI(cartridgesHUD.mc.fontRenderer, lIIlIlllIllIll, lIIlIlllIllIlI, lIIlIlllIllIIl, String.valueOf(new StringBuilder().append("").append(lIIlIlllIllIII)));
        GlStateManager.enableTexture2D();
        GlStateManager.disableLighting();
        GlStateManager.disableDepth();
    }

    public void drawcard() {
        cartridgesHUD lIIlIlllIIllII;
        if (Minecraft.getMinecraft().world == null || !Minecraft.getMinecraft().world.field_72995_K) {
            return;
        }
        float lIIlIlllIIlIll = (float)CatClient.instance.settingsManager.getSettingByName(lIIlIlllIIllII, "PosX").getValDouble();
        float lIIlIlllIIlIlI = (float)CatClient.instance.settingsManager.getSettingByName(lIIlIlllIIllII, "PosY").getValDouble();
        try {
            GlStateManager.enableTexture2D();
            GL11.glPushMatrix();
            GL11.glTranslated((double)lIIlIlllIIlIll, (double)lIIlIlllIIlIlI, (double)0.0);
            for (int lIIlIlllIIllll = 0; lIIlIlllIIllll < Minecraft.getMinecraft().player.field_71069_bz.inventorySlots.size(); ++lIIlIlllIIllll) {
                Item lIIlIlllIlIIIl = ((Slot)Minecraft.getMinecraft().player.field_71069_bz.inventorySlots.get(lIIlIlllIIllll)).getStack().getItem();
                ItemStack lIIlIlllIlIIII = ((Slot)Minecraft.getMinecraft().player.field_71069_bz.inventorySlots.get(lIIlIlllIIllll)).getStack();
                if (lIIlIlllIlIIIl == Items.STICK) {
                    lIIlIlllIIllII.STICK += lIIlIlllIlIIII.getCount();
                    lIIlIlllIIllII.STICK2 = lIIlIlllIlIIII;
                    continue;
                }
                if (lIIlIlllIlIIIl == Items.BRICK) {
                    lIIlIlllIIllII.BRICK += lIIlIlllIlIIII.getCount();
                    lIIlIlllIIllII.BRICK2 = lIIlIlllIlIIII;
                    continue;
                }
                if (lIIlIlllIlIIIl == Items.PRISMARINE_CRYSTALS) {
                    lIIlIlllIIllII.PRISMARINE_CRYSTALS += lIIlIlllIlIIII.getCount();
                    lIIlIlllIIllII.PRISMARINE_CRYSTALS2 = lIIlIlllIlIIII;
                    continue;
                }
                if (lIIlIlllIlIIIl == Items.PRISMARINE_SHARD) {
                    lIIlIlllIIllII.PRISMARINE_SHARD += lIIlIlllIlIIII.getCount();
                    lIIlIlllIIllII.PRISMARINE_SHARD2 = lIIlIlllIlIIII;
                    continue;
                }
                if (lIIlIlllIlIIIl == Items.SHULKER_SHELL) {
                    lIIlIlllIIllII.SHULKER_SHELL += lIIlIlllIlIIII.getCount();
                    lIIlIlllIIllII.SHULKER_SHELL2 = lIIlIlllIlIIII;
                    continue;
                }
                if (lIIlIlllIlIIIl == Items.RABBIT_HIDE) {
                    lIIlIlllIIllII.RABBIT_HIDE += lIIlIlllIlIIII.getCount();
                    lIIlIlllIIllII.RABBIT_HIDE2 = lIIlIlllIlIIII;
                    continue;
                }
                if (lIIlIlllIlIIIl == Items.GUNPOWDER) {
                    lIIlIlllIIllII.GUNPOWDER += lIIlIlllIlIIII.getCount();
                    lIIlIlllIIllII.GUNPOWDER2 = lIIlIlllIlIIII;
                    continue;
                }
                if (lIIlIlllIlIIIl != Items.ARROW) continue;
                lIIlIlllIIllII.ARROW += lIIlIlllIlIIII.getCount();
                lIIlIlllIIllII.ARROW2 = lIIlIlllIlIIII;
            }
            int lIIlIlllIIlllI = 0;
            if (lIIlIlllIIllII.STICK != 0) {
                lIIlIlllIIllII.drawitem(lIIlIlllIIllII.STICK2, 0, lIIlIlllIIlllI * 25, lIIlIlllIIllII.STICK);
                ++lIIlIlllIIlllI;
            }
            if (lIIlIlllIIllII.BRICK != 0) {
                lIIlIlllIIllII.drawitem(lIIlIlllIIllII.BRICK2, 0, lIIlIlllIIlllI * 25, lIIlIlllIIllII.BRICK);
                ++lIIlIlllIIlllI;
            }
            if (lIIlIlllIIllII.PRISMARINE_CRYSTALS != 0) {
                lIIlIlllIIllII.drawitem(lIIlIlllIIllII.PRISMARINE_CRYSTALS2, 0, lIIlIlllIIlllI * 25, lIIlIlllIIllII.PRISMARINE_CRYSTALS);
                ++lIIlIlllIIlllI;
            }
            if (lIIlIlllIIllII.PRISMARINE_SHARD != 0) {
                lIIlIlllIIllII.drawitem(lIIlIlllIIllII.PRISMARINE_SHARD2, 0, lIIlIlllIIlllI * 25, lIIlIlllIIllII.PRISMARINE_SHARD);
                ++lIIlIlllIIlllI;
            }
            if (lIIlIlllIIllII.SHULKER_SHELL != 0) {
                lIIlIlllIIllII.drawitem(lIIlIlllIIllII.SHULKER_SHELL2, 0, lIIlIlllIIlllI * 25, lIIlIlllIIllII.SHULKER_SHELL);
                ++lIIlIlllIIlllI;
            }
            if (lIIlIlllIIllII.RABBIT_HIDE != 0) {
                lIIlIlllIIllII.drawitem(lIIlIlllIIllII.RABBIT_HIDE2, 0, lIIlIlllIIlllI * 25, lIIlIlllIIllII.RABBIT_HIDE);
                ++lIIlIlllIIlllI;
            }
            if (lIIlIlllIIllII.GUNPOWDER != 0) {
                lIIlIlllIIllII.drawitem(lIIlIlllIIllII.GUNPOWDER2, 0, lIIlIlllIIlllI * 25, lIIlIlllIIllII.GUNPOWDER);
                ++lIIlIlllIIlllI;
            }
            if (lIIlIlllIIllII.ARROW != 0) {
                lIIlIlllIIllII.drawitem(lIIlIlllIIllII.ARROW2, 0, lIIlIlllIIlllI * 25, lIIlIlllIIllII.ARROW);
                ++lIIlIlllIIlllI;
            }
            lIIlIlllIIllII.STICK = 0;
            lIIlIlllIIllII.BRICK = 0;
            lIIlIlllIIllII.PRISMARINE_CRYSTALS = 0;
            lIIlIlllIIllII.PRISMARINE_SHARD = 0;
            lIIlIlllIIllII.SHULKER_SHELL = 0;
            lIIlIlllIIllII.RABBIT_HIDE = 0;
            lIIlIlllIIllII.GUNPOWDER = 0;
            lIIlIlllIIllII.ARROW = 0;
            GlStateManager.enableDepth();
            GlStateManager.disableLighting();
            GL11.glPopMatrix();
        }
        catch (Exception lIIlIlllIIllIl) {
            lIIlIlllIIllIl.printStackTrace();
        }
    }

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Text lIIlIlllIIIIIl) {
        cartridgesHUD lIIlIlllIIIIII;
        lIIlIlllIIIIII.drawcard();
    }

    static {
        itemRender = Minecraft.getMinecraft().getRenderItem();
    }
}

