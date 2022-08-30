/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.MathHelper
 *  net.minecraftforge.client.event.RenderGameOverlayEvent
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$ElementType
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.opengl.GL11
 */
package ru.internali.module.HUD;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;
import ru.internali.utils.MovementHelper;
import ru.internali.utils.RectHelper;

public class Indicators
extends Module {
    private /* synthetic */ boolean show;
    private /* synthetic */ double enemyDistance;
    private /* synthetic */ double healthBarWidth;
    private /* synthetic */ float hurtAnim;
    private /* synthetic */ double enemyHP;
    private /* synthetic */ EntityPlayer entityPlayer;
    private /* synthetic */ float cooldownAnim;
    private /* synthetic */ String enemyNickname;
    private /* synthetic */ Entity entity;

    @SubscribeEvent
    public void Indicators(RenderGameOverlayEvent llIIlIIIIlllll) {
        block7: {
            float llIIlIIIIllIll;
            float llIIlIIIIlllII;
            float llIIlIIIIlllIl;
            float llIIlIIIIllllI;
            Indicators llIIlIIIIllIlI;
            block9: {
                block8: {
                    llIIlIIIIllllI = (float)CatClient.instance.settingsManager.getSettingByName(llIIlIIIIllIlI, "IndGetX").getValDouble();
                    llIIlIIIIlllIl = (float)CatClient.instance.settingsManager.getSettingByName(llIIlIIIIllIlI, "IndGetY").getValDouble();
                    llIIlIIIIlllII = (float)CatClient.instance.settingsManager.getSettingByName(llIIlIIIIllIlI, "HpGetX").getValDouble();
                    llIIlIIIIllIll = (float)CatClient.instance.settingsManager.getSettingByName(llIIlIIIIllIlI, "HpGetY").getValDouble();
                    if (llIIlIIIIlllll.getType() != RenderGameOverlayEvent.ElementType.TEXT) break block7;
                    if (Indicators.mc.player == null) break block8;
                    if (Indicators.mc.world != null) break block9;
                }
                return;
            }
            if (Indicators.mc.gameSettings.showDebugInfo) {
                return;
            }
            float llIIlIIIllIIIl = llIIlIIIIllllI;
            float llIIlIIIllIIII = llIIlIIIIlllIl;
            float llIIlIIIlIllll = llIIlIIIllIIIl;
            float llIIlIIIlIlllI = llIIlIIIllIIII;
            float llIIlIIIlIllIl = llIIlIIIlIllll + 48.0f + 70.0f;
            float llIIlIIIlIllII = llIIlIIIlIlllI + 74.0f;
            GlStateManager.pushMatrix();
            RectHelper.drawRect(llIIlIIIlIllll, llIIlIIIlIlllI, llIIlIIIlIllIl, llIIlIIIlIllII, new Color(5, 5, 5, 158).getRGB());
            RectHelper.drawSmoothRect(llIIlIIIllIIIl, llIIlIIIllIIII, llIIlIIIlIllIl, llIIlIIIllIIII - 1.0f, CatClient.getClientColor().getRGB());
            RectHelper.drawRect(llIIlIIIllIIIl + 3.0f, llIIlIIIllIIII + 14.0f, llIIlIIIlIllIl - 3.0f, (double)llIIlIIIllIIII + 14.5, new Color(205, 205, 205).getRGB());
            Indicators.mc.fontRenderer.drawStringWithShadow("Indicators", llIIlIIIllIIIl + 33.0f, llIIlIIIllIIII + 5.0f, -1);
            if (Minecraft.getDebugFPS() > 5) {
                float llIIlIIIIIlllI = Minecraft.getDebugFPS() < 10 ? 0.25f : 6.0f / (float)Minecraft.getDebugFPS();
            }
            String llIIlIIIlIlIll = String.valueOf(new StringBuilder().append("").append(Indicators.mc.player.func_110143_aJ() / Indicators.mc.player.func_110138_aP() * 100.0f));
            String llIIlIIIlIlIlI = String.format(String.valueOf(new StringBuilder().append("%.2f ").append((Object)ChatFormatting.WHITE).append("b/s")), Float.valueOf(MovementHelper.getSpeed() * 16.0f));
            String llIIlIIIlIlIIl = String.valueOf(new StringBuilder().append("").append(Minecraft.getDebugFPS()));
            String llIIlIIIlIlIII = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
            String llIIlIIIlIIlll = String.valueOf(new StringBuilder().append("").append(Indicators.mc.player.func_110143_aJ()));
            Indicators.mc.fontRenderer.drawStringWithShadow(String.valueOf(new StringBuilder().append("FPS: ").append(llIIlIIIlIlIIl)), llIIlIIIlIllll + 3.0f, llIIlIIIlIlllI + 20.0f, -1);
            Indicators.mc.fontRenderer.drawStringWithShadow(String.valueOf(new StringBuilder().append("Speed: ").append(llIIlIIIlIlIlI)), llIIlIIIlIllll + 3.0f, llIIlIIIlIlllI + 31.0f, -1);
            Indicators.mc.fontRenderer.drawStringWithShadow(String.valueOf(new StringBuilder().append("Time: ").append(llIIlIIIlIlIII)), llIIlIIIlIllll + 3.0f, llIIlIIIlIlllI + 42.0f, -1);
            Indicators.mc.fontRenderer.drawStringWithShadow(String.valueOf(new StringBuilder().append("Health: ").append(llIIlIIIlIIlll).append(" / ").append(llIIlIIIlIlIll)), llIIlIIIlIllll + 3.0f, llIIlIIIlIlllI + 53.0f, -1);
            float llIIlIIIlIIllI = llIIlIIIIlllII;
            float llIIlIIIlIIlIl = llIIlIIIIllIll;
            llIIlIIIIllIlI.enemyHP = Indicators.mc.player.func_110143_aJ();
            llIIlIIIIllIlI.enemyNickname = Indicators.mc.player.func_70005_c_();
            llIIlIIIIllIlI.entityPlayer = (EntityPlayer)llIIlIIIIllIlI.entity;
            float llIIlIIIlIIlII = Math.round(llIIlIIIIllIlI.enemyHP);
            double llIIlIIIlIIIll = llIIlIIIlIIlII / 20.0f;
            llIIlIIIlIIIll = MathHelper.clamp((double)llIIlIIIlIIIll, (double)0.0, (double)1.0);
            double llIIlIIIlIIIlI = 97.0 * llIIlIIIlIIIll;
            String llIIlIIIlIIIIl = String.valueOf(Math.round(llIIlIIIIllIlI.enemyHP));
            Gui.drawRect((int)((int)((double)llIIlIIIlIIllI + 125.5)), (int)((int)((double)llIIlIIIlIIlIl - 9.5)), (int)((int)(llIIlIIIlIIllI + 265.0f)), (int)((int)(llIIlIIIlIIlIl + 30.5f)), (int)new Color(31, 31, 31, 255).getRGB());
            Gui.drawRect((int)((int)(llIIlIIIlIIllI + 166.0f)), (int)((int)(llIIlIIIlIIlIl + 6.0f)), (int)((int)(llIIlIIIlIIllI + 263.0f)), (int)((int)(llIIlIIIlIIlIl + 15.0f)), (int)new Color(40, 40, 40, 255).getRGB());
            Gui.drawRect((int)((int)(llIIlIIIlIIllI + 166.0f)), (int)((int)(llIIlIIIlIIlIl + 6.0f)), (int)((int)((double)(llIIlIIIlIIllI + 166.0f) + llIIlIIIIllIlI.healthBarWidth)), (int)((int)(llIIlIIIlIIlIl + 15.0f)), (int)new Color(2816512).getRGB());
            Gui.drawRect((int)((int)(llIIlIIIlIIllI + 166.0f)), (int)((int)(llIIlIIIlIIlIl + 6.0f)), (int)((int)((double)(llIIlIIIlIIllI + 166.0f) + llIIlIIIlIIIlI)), (int)((int)(llIIlIIIlIIlIl + 15.0f)), (int)new Color(2816512).getRGB());
            try {
                llIIlIIIIllIlI.drawHead(Objects.requireNonNull(mc.getConnection()).getPlayerInfo(Indicators.mc.player.func_110124_au()).getLocationSkin(), (int)(llIIlIIIlIIllI + 127.0f), (int)(llIIlIIIlIIlIl - 8.0f));
            }
            catch (Exception llIIlIIIIIIIll) {
                // empty catch block
            }
            Indicators.mc.fontRenderer.drawStringWithShadow(llIIlIIIlIIIIl, llIIlIIIlIIllI + 128.0f + 46.0f - (float)Indicators.mc.fontRenderer.getStringWidth(llIIlIIIlIIIIl) / 2.0f, llIIlIIIlIIlIl + 19.5f, -1);
            Indicators.mc.fontRenderer.drawStringWithShadow("\u2764", llIIlIIIlIIllI + 128.0f + 46.0f + (float)Indicators.mc.fontRenderer.getStringWidth(llIIlIIIlIIIIl), llIIlIIIlIIlIl + 19.5f, new Color(2816512).getRGB());
            Indicators.mc.fontRenderer.drawStringWithShadow(Indicators.mc.player.func_70005_c_(), llIIlIIIlIIllI + 167.0f, llIIlIIIlIIlIl - 5.0f, -1);
            Indicators.mc.fontRenderer.drawStringWithShadow(String.valueOf(new StringBuilder().append("Ground: ").append(Indicators.mc.player.field_70122_E)), llIIlIIIlIllll + 3.0f, llIIlIIIlIlllI + 64.0f, -1);
            GlStateManager.popMatrix();
        }
    }

    public Indicators() {
        super("Indicators", "Coord", Category.HUD);
        Indicators llIIlIIlIIlIll;
        CatClient.instance.settingsManager.rSetting(new Setting("IndGetX", llIIlIIlIIlIll, 0.0, 0.0, 897.0, true));
        CatClient.instance.settingsManager.rSetting(new Setting("IndGetY", llIIlIIlIIlIll, 268.0, 0.0, 340.0, true));
        CatClient.instance.settingsManager.rSetting(new Setting("HpGetX", llIIlIIlIIlIll, 701.0, -120.0, 701.0, true));
        CatClient.instance.settingsManager.rSetting(new Setting("HpGetY", llIIlIIlIIlIll, 508.0, 5.0, 508.0, true));
    }

    public void drawHead(ResourceLocation llIIIllllllllI, int llIIIllllllIlI, int llIIIlllllllII) {
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        mc.getTextureManager().bindTexture(llIIIllllllllI);
        Gui.drawScaledCustomSizeModalRect((int)llIIIllllllIlI, (int)llIIIlllllllII, (float)8.0f, (float)8.0f, (int)8, (int)8, (int)37, (int)37, (float)64.0f, (float)64.0f);
    }
}

