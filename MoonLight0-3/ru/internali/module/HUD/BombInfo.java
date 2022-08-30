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

public class BombInfo
extends Module {
    private /* synthetic */ ItemStack BOOK2;
    private /* synthetic */ int SPECKLED_MELON;
    private /* synthetic */ int FLINT;
    private final /* synthetic */ FontRenderer fr;
    private /* synthetic */ ItemStack SLIME_BALL2;
    private /* synthetic */ int ARROW;
    private /* synthetic */ ItemStack SPECTRAL_ARROW2;
    private /* synthetic */ ItemStack FLINT2;
    private /* synthetic */ int PRISMARINE_SHARD;
    private static final /* synthetic */ RenderItem itemRender;
    private /* synthetic */ int SHULKER_SHELL;
    private static /* synthetic */ RenderItem kappita;
    private /* synthetic */ int BOOK;
    /* synthetic */ ScaledResolution sr;
    private /* synthetic */ ItemStack ARROW2;
    private /* synthetic */ ItemStack PRISMARINE_SHARD2;
    private /* synthetic */ int SPECTRAL_ARROW;
    private /* synthetic */ ItemStack SPECKLED_MELON2;
    private /* synthetic */ int SLIME_BALL;
    private /* synthetic */ ItemStack SHULKER_SHELL2;

    static {
        itemRender = Minecraft.getMinecraft().getRenderItem();
    }

    public void drawcard() {
        BombInfo llIlIIIIIllllll;
        if (Minecraft.getMinecraft().world == null || !Minecraft.getMinecraft().world.field_72995_K) {
            return;
        }
        float llIlIIIIIlllllI = (float)CatClient.instance.settingsManager.getSettingByName(llIlIIIIIllllll, "PosX").getValDouble();
        float llIlIIIIIllllIl = (float)CatClient.instance.settingsManager.getSettingByName(llIlIIIIIllllll, "PosY").getValDouble();
        try {
            GlStateManager.enableTexture2D();
            GL11.glPushMatrix();
            GL11.glTranslated((double)llIlIIIIIlllllI, (double)llIlIIIIIllllIl, (double)0.0);
            for (int llIlIIIIlIIIIlI = 0; llIlIIIIlIIIIlI < Minecraft.getMinecraft().player.field_71069_bz.inventorySlots.size(); ++llIlIIIIlIIIIlI) {
                Item llIlIIIIlIIIlII = ((Slot)Minecraft.getMinecraft().player.field_71069_bz.inventorySlots.get(llIlIIIIlIIIIlI)).getStack().getItem();
                ItemStack llIlIIIIlIIIIll = ((Slot)Minecraft.getMinecraft().player.field_71069_bz.inventorySlots.get(llIlIIIIlIIIIlI)).getStack();
                if (llIlIIIIlIIIlII == Items.BOOK) {
                    llIlIIIIIllllll.BOOK += llIlIIIIlIIIIll.getCount();
                    llIlIIIIIllllll.BOOK2 = llIlIIIIlIIIIll;
                    continue;
                }
                if (llIlIIIIlIIIlII == Items.SPECKLED_MELON) {
                    llIlIIIIIllllll.SPECKLED_MELON += llIlIIIIlIIIIll.getCount();
                    llIlIIIIIllllll.SPECKLED_MELON2 = llIlIIIIlIIIIll;
                    continue;
                }
                if (llIlIIIIlIIIlII == Items.SLIME_BALL) {
                    llIlIIIIIllllll.SLIME_BALL += llIlIIIIlIIIIll.getCount();
                    llIlIIIIIllllll.SLIME_BALL2 = llIlIIIIlIIIIll;
                    continue;
                }
                if (llIlIIIIlIIIlII == Items.FLINT) {
                    llIlIIIIIllllll.FLINT += llIlIIIIlIIIIll.getCount();
                    llIlIIIIIllllll.FLINT2 = llIlIIIIlIIIIll;
                    continue;
                }
                if (llIlIIIIlIIIlII == Items.PRISMARINE_SHARD) {
                    llIlIIIIIllllll.PRISMARINE_SHARD += llIlIIIIlIIIIll.getCount();
                    llIlIIIIIllllll.PRISMARINE_SHARD2 = llIlIIIIlIIIIll;
                    continue;
                }
                if (llIlIIIIlIIIlII == Items.SHULKER_SHELL) {
                    llIlIIIIIllllll.SHULKER_SHELL += llIlIIIIlIIIIll.getCount();
                    llIlIIIIIllllll.SHULKER_SHELL2 = llIlIIIIlIIIIll;
                    continue;
                }
                if (llIlIIIIlIIIlII == Items.SPECTRAL_ARROW) {
                    llIlIIIIIllllll.SPECTRAL_ARROW += llIlIIIIlIIIIll.getCount();
                    llIlIIIIIllllll.SPECTRAL_ARROW2 = llIlIIIIlIIIIll;
                    continue;
                }
                if (llIlIIIIlIIIlII != Items.ARROW) continue;
                llIlIIIIIllllll.ARROW += llIlIIIIlIIIIll.getCount();
                llIlIIIIIllllll.ARROW2 = llIlIIIIlIIIIll;
            }
            int llIlIIIIlIIIIIl = 0;
            if (llIlIIIIIllllll.BOOK != 0) {
                llIlIIIIIllllll.drawitem(llIlIIIIIllllll.BOOK2, 0, llIlIIIIlIIIIIl * 25, llIlIIIIIllllll.BOOK);
                ++llIlIIIIlIIIIIl;
            }
            if (llIlIIIIIllllll.SPECKLED_MELON != 0) {
                llIlIIIIIllllll.drawitem(llIlIIIIIllllll.SPECKLED_MELON2, 0, llIlIIIIlIIIIIl * 25, llIlIIIIIllllll.SPECKLED_MELON);
                ++llIlIIIIlIIIIIl;
            }
            if (llIlIIIIIllllll.SLIME_BALL != 0) {
                llIlIIIIIllllll.drawitem(llIlIIIIIllllll.SLIME_BALL2, 0, llIlIIIIlIIIIIl * 25, llIlIIIIIllllll.SLIME_BALL);
                ++llIlIIIIlIIIIIl;
            }
            if (llIlIIIIIllllll.FLINT != 0) {
                llIlIIIIIllllll.drawitem(llIlIIIIIllllll.FLINT2, 0, llIlIIIIlIIIIIl * 25, llIlIIIIIllllll.FLINT);
                ++llIlIIIIlIIIIIl;
            }
            if (llIlIIIIIllllll.PRISMARINE_SHARD != 0) {
                llIlIIIIIllllll.drawitem(llIlIIIIIllllll.PRISMARINE_SHARD2, 0, llIlIIIIlIIIIIl * 25, llIlIIIIIllllll.PRISMARINE_SHARD);
                ++llIlIIIIlIIIIIl;
            }
            if (llIlIIIIIllllll.SHULKER_SHELL != 0) {
                llIlIIIIIllllll.drawitem(llIlIIIIIllllll.SHULKER_SHELL2, 0, llIlIIIIlIIIIIl * 25, llIlIIIIIllllll.SHULKER_SHELL);
                ++llIlIIIIlIIIIIl;
            }
            if (llIlIIIIIllllll.SPECTRAL_ARROW != 0) {
                llIlIIIIIllllll.drawitem(llIlIIIIIllllll.SPECTRAL_ARROW2, 0, llIlIIIIlIIIIIl * 25, llIlIIIIIllllll.SPECTRAL_ARROW);
                ++llIlIIIIlIIIIIl;
            }
            if (llIlIIIIIllllll.ARROW != 0) {
                llIlIIIIIllllll.drawitem(llIlIIIIIllllll.ARROW2, 0, llIlIIIIlIIIIIl * 25, llIlIIIIIllllll.ARROW);
                ++llIlIIIIlIIIIIl;
            }
            llIlIIIIIllllll.BOOK = 0;
            llIlIIIIIllllll.SPECKLED_MELON = 0;
            llIlIIIIIllllll.SLIME_BALL = 0;
            llIlIIIIIllllll.FLINT = 0;
            llIlIIIIIllllll.PRISMARINE_SHARD = 0;
            llIlIIIIIllllll.SHULKER_SHELL = 0;
            llIlIIIIIllllll.SPECTRAL_ARROW = 0;
            llIlIIIIIllllll.ARROW = 0;
            GlStateManager.enableDepth();
            GlStateManager.disableLighting();
            GL11.glPopMatrix();
        }
        catch (Exception llIlIIIIlIIIIII) {
            llIlIIIIlIIIIII.printStackTrace();
        }
    }

    public BombInfo() {
        super("BombInfo", "show Cartiges", Category.HUD);
        BombInfo llIlIIIIlIllIll;
        llIlIIIIlIllIll.fr = Minecraft.getMinecraft().fontRenderer;
        llIlIIIIlIllIll.sr = new ScaledResolution(mc);
        llIlIIIIlIllIll.BOOK = 0;
        llIlIIIIlIllIll.SPECKLED_MELON = 0;
        llIlIIIIlIllIll.SLIME_BALL = 0;
        llIlIIIIlIllIll.FLINT = 0;
        llIlIIIIlIllIll.PRISMARINE_SHARD = 0;
        llIlIIIIlIllIll.SHULKER_SHELL = 0;
        llIlIIIIlIllIll.SPECTRAL_ARROW = 0;
        llIlIIIIlIllIll.ARROW = 0;
        CatClient.instance.settingsManager.rSetting(new Setting("PosX", llIlIIIIlIllIll, 0.0, 0.0, 300.0, true));
        CatClient.instance.settingsManager.rSetting(new Setting("PosY", llIlIIIIlIllIll, 50.0, 0.0, 280.0, true));
    }

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Text llIlIIIIIllIlII) {
        BombInfo llIlIIIIIllIIll;
        llIlIIIIIllIIll.drawcard();
    }

    public void drawitem(ItemStack llIlIIIIlIIlllI, int llIlIIIIlIIllIl, int llIlIIIIlIlIIIl, int llIlIIIIlIIlIll) {
        BombInfo llIlIIIIlIlIlII;
        BombInfo.itemRender.zLevel = 1.0f;
        llIlIIIIlIlIlII.fr.drawString("", 0, 0, Color.white.getRGB());
        RenderUtils.drawShadowRect(llIlIIIIlIIllIl, llIlIIIIlIlIIIl, llIlIIIIlIIllIl + 19, llIlIIIIlIlIIIl + 20, 2);
        GlStateManager.resetColor();
        itemRender.renderItemAndEffectIntoGUI(llIlIIIIlIIlllI, llIlIIIIlIIllIl, llIlIIIIlIlIIIl);
        itemRender.renderItemOverlayIntoGUI(BombInfo.mc.fontRenderer, llIlIIIIlIIlllI, llIlIIIIlIIllIl, llIlIIIIlIlIIIl, String.valueOf(new StringBuilder().append("").append(llIlIIIIlIIlIll)));
        GlStateManager.enableTexture2D();
        GlStateManager.disableLighting();
        GlStateManager.disableDepth();
    }
}

