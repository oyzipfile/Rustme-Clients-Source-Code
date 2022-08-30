/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Strings
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderItem
 *  net.minecraft.entity.Entity
 *  net.minecraft.item.ItemStack
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$ElementType
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$Text
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.opengl.GL11
 */
package ru.internali.module.HUD;

import com.google.common.base.Strings;
import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;
import ru.internali.utils.BooleanSetting;
import ru.internali.utils.ColorUtils;
import ru.internali.utils.MovementHelper;
import ru.internali.utils.RenderUtil;
import ru.internali.utils.TimerUtils;

public class HUD
extends Module {
    public /* synthetic */ int oYpos;
    /* synthetic */ float animX;
    public /* synthetic */ int oHeight;
    /* synthetic */ float animY;
    public static /* synthetic */ List<String> Modes;
    private static /* synthetic */ RenderItem kappita;
    public /* synthetic */ int oWidth;
    /* synthetic */ TimerUtils timer;
    public /* synthetic */ int width;
    private /* synthetic */ Entity target;
    private static final /* synthetic */ RenderItem itemRender;
    private /* synthetic */ int y;
    public /* synthetic */ int oXpos;
    public /* synthetic */ int height;
    private final /* synthetic */ FontRenderer fr;
    private /* synthetic */ List<Module> modulesSorted;
    /* synthetic */ BooleanSetting info;
    /* synthetic */ String text;
    private /* synthetic */ float anima;
    /* synthetic */ float animYMot;
    private /* synthetic */ int x;
    /* synthetic */ float animXMot;

    public HUD() {
        super("HUD", "modules on screen", Category.HUD);
        HUD lIllIllIIlllIl;
        lIllIllIIlllIl.animX = 0.0f;
        lIllIllIIlllIl.animY = 1.0f;
        lIllIllIIlllIl.animXMot = 1.4f;
        lIllIllIIlllIl.animYMot = 1.4f;
        lIllIllIIlllIl.text = "connecting";
        lIllIllIIlllIl.timer = new TimerUtils();
        lIllIllIIlllIl.fr = Minecraft.getMinecraft().fontRenderer;
        Modes.add("Default");
        Modes.add("Bibr");
        Modes.add("Skeet");
        CatClient.instance.settingsManager.rSetting(new Setting("Mode", lIllIllIIlllIl, "Skeet", (ArrayList)Modes));
        CatClient.instance.settingsManager.rSetting(new Setting("InfoWorld", lIllIllIIlllIl, false));
        CatClient.instance.settingsManager.rSetting(new Setting("Horizontal", lIllIllIIlllIl, 30.0, 0.0, 810.0, true));
        CatClient.instance.settingsManager.rSetting(new Setting("Vertical", lIllIllIIlllIl, 60.0, 0.0, 490.0, true));
    }

    public static void drawRectangleCorrectly(int lIllIlIllIIIIl, int lIllIlIllIIlIl, int lIllIlIlIlllll, int lIllIlIllIIIll, int lIllIlIllIIIlI) {
        GL11.glLineWidth((float)1.0f);
        Gui.drawRect((int)lIllIlIllIIIIl, (int)lIllIlIllIIlIl, (int)(lIllIlIllIIIIl + lIllIlIlIlllll), (int)(lIllIlIllIIlIl + lIllIlIllIIIll), (int)lIllIlIllIIIlI);
    }

    public static int RGBtoHex(int lIllIlIlllllIl, int lIllIlIllllIIl, int lIllIlIllllIll) {
        return lIllIlIlllllIl << 16 | lIllIlIllllIIl << 8 | lIllIlIllllIll;
    }

    private int rainbow(long lIllIIllIIIIIl, float lIllIIllIIIIII) {
        float lIllIIlIllllll = (float)(System.nanoTime() + lIllIIllIIIIIl) / 2.0E10f % 1.0f;
        long lIllIIlIlllllI = Long.parseLong(Integer.toHexString(Color.HSBtoRGB(lIllIIlIllllll + 100000.0f, 1.0f, 1.0f)), 16);
        Color lIllIIlIllllIl = new Color((int)lIllIIlIlllllI);
        return new Color((float)lIllIIlIllllIl.getRed() / 255.0f * lIllIIllIIIIII, (float)lIllIIlIllllIl.getGreen() / 255.0f * lIllIIllIIIIII, (float)lIllIIlIllllIl.getBlue() / 255.0f * lIllIIllIIIIII, (float)lIllIIlIllllIl.getAlpha() / 255.0f).getRGB();
    }

    public static int[] getRainbow(int lIllIllIIIlIIl, float lIllIllIIlIIIl) {
        int lIllIllIIlIIII = 0;
        int lIllIllIIIllll = 0;
        int lIllIllIIIlllI = 0;
        long lIllIllIIIllIl = (System.currentTimeMillis() - (long)Math.round(lIllIllIIlIIIl * 1000.0f)) % (long)(lIllIllIIIlIIl * 1000);
        float lIllIllIIIllII = 6.0f * (float)lIllIllIIIllIl / (float)(lIllIllIIIlIIl * 1000);
        float lIllIllIIIlIll = lIllIllIIIllII - (float)Math.floor(lIllIllIIIllII);
        int lIllIllIIIlIlI = Math.round(255.0f * lIllIllIIIlIll);
        if (lIllIllIIIllII < 1.0f) {
            lIllIllIIlIIII = 255;
            lIllIllIIIllll = lIllIllIIIlIlI;
        } else if (lIllIllIIIllII < 2.0f) {
            lIllIllIIlIIII = 255 - lIllIllIIIlIlI;
            lIllIllIIIllll = 255;
        } else if (lIllIllIIIllII < 3.0f) {
            lIllIllIIIllll = 255;
            lIllIllIIIlllI = lIllIllIIIlIlI;
        } else if (lIllIllIIIllII < 4.0f) {
            lIllIllIIIllll = 255 - lIllIllIIIlIlI;
            lIllIllIIIlllI = 255;
        } else if (lIllIllIIIllII < 5.0f) {
            lIllIllIIlIIII = lIllIllIIIlIlI;
            lIllIllIIIlllI = 255;
        } else if (lIllIllIIIllII < 6.0f) {
            lIllIllIIlIIII = 255;
            lIllIllIIIlllI = 255 - lIllIllIIIlIlI;
        }
        return new int[]{lIllIllIIlIIII, lIllIllIIIllll, lIllIllIIIlllI};
    }

    public void sortList() {
        HUD lIllIIlIlIllII;
        lIllIIlIlIllII.modulesSorted = new ArrayList<Module>(CatClient.instance.moduleManager.getModuleList());
        lIllIIlIlIllII.modulesSorted.sort((lIllIIlIlIlIIl, lIllIIlIlIIllI) -> {
            if (HUD.mc.fontRenderer.getStringWidth(lIllIIlIlIlIIl.getName()) < HUD.mc.fontRenderer.getStringWidth(lIllIIlIlIIllI.getName())) {
                return 1;
            }
            if (HUD.mc.fontRenderer.getStringWidth(lIllIIlIlIlIIl.getName()) > HUD.mc.fontRenderer.getStringWidth(lIllIIlIlIIllI.getName())) {
                return -1;
            }
            return 0;
        });
    }

    @SubscribeEvent
    public void InfoCOMP(RenderGameOverlayEvent.Text lIllIlIlIIIlll) {
        HUD lIllIlIlIIllIl;
        boolean lIllIlIlIIlIll = CatClient.instance.settingsManager.getSettingByName(lIllIlIlIIllIl, "InfoWorld").getValBoolean();
        float lIllIlIlIIlIlI = (float)CatClient.instance.settingsManager.getSettingByName(lIllIlIlIIllIl, "Horizontal").getValDouble();
        float lIllIlIlIIlIIl = (float)CatClient.instance.settingsManager.getSettingByName(lIllIlIlIIllIl, "Vertical").getValDouble();
        if (lIllIlIlIIIlll.getType() == RenderGameOverlayEvent.ElementType.TEXT && lIllIlIlIIlIll) {
            String lIllIlIlIlIIlI = String.format(String.valueOf(new StringBuilder().append("%.2f ").append((Object)ChatFormatting.WHITE).append("blocks/sec")), Float.valueOf(MovementHelper.getSpeed() * 16.0f));
            String lIllIlIlIlIIIl = String.valueOf(new StringBuilder().append("").append(Minecraft.getDebugFPS()));
            String lIllIlIlIlIIII = String.valueOf(new StringBuilder().append("").append(Math.round(HUD.mc.player.field_70165_t)));
            String lIllIlIlIIllll = String.valueOf(new StringBuilder().append("").append(Math.round(HUD.mc.player.field_70163_u)));
            String lIllIlIlIIlllI = String.valueOf(new StringBuilder().append("").append(Math.round(HUD.mc.player.field_70161_v)));
            HUD.mc.fontRenderer.drawStringWithShadow("X: ", lIllIlIlIIlIlI, lIllIlIlIIlIIl, CatClient.getClientColor().getRGB());
            HUD.mc.fontRenderer.drawStringWithShadow(lIllIlIlIlIIII, lIllIlIlIIlIlI + 10.0f, lIllIlIlIIlIIl, -1);
            HUD.mc.fontRenderer.drawStringWithShadow("Y: ", lIllIlIlIIlIlI + 30.0f + (float)HUD.mc.fontRenderer.getStringWidth(lIllIlIlIlIIII) - 17.0f, lIllIlIlIIlIIl, CatClient.getClientColor().getRGB());
            HUD.mc.fontRenderer.drawStringWithShadow(lIllIlIlIIllll, lIllIlIlIIlIlI + 40.0f + (float)HUD.mc.fontRenderer.getStringWidth(lIllIlIlIlIIII) - 17.0f, lIllIlIlIIlIIl, -1);
            HUD.mc.fontRenderer.drawStringWithShadow("Z: ", lIllIlIlIIlIlI + 66.0f + (float)HUD.mc.fontRenderer.getStringWidth(lIllIlIlIlIIII) - 23.0f + (float)HUD.mc.fontRenderer.getStringWidth(lIllIlIlIIllll) - 17.0f, lIllIlIlIIlIIl, CatClient.getClientColor().getRGB());
            HUD.mc.fontRenderer.drawStringWithShadow(lIllIlIlIIlllI, lIllIlIlIIlIlI + 76.0f + (float)HUD.mc.fontRenderer.getStringWidth(lIllIlIlIlIIII) - 23.0f + (float)HUD.mc.fontRenderer.getStringWidth(lIllIlIlIIllll) - 17.0f, lIllIlIlIIlIIl, -1);
            HUD.mc.fontRenderer.drawStringWithShadow("FPS: ", lIllIlIlIIlIlI, lIllIlIlIIlIIl + 11.0f, CatClient.getClientColor().getRGB());
            HUD.mc.fontRenderer.drawStringWithShadow(lIllIlIlIlIIIl, lIllIlIlIIlIlI + 22.0f, lIllIlIlIIlIIl + 11.0f, -1);
            HUD.mc.fontRenderer.drawStringWithShadow(lIllIlIlIlIIlI, lIllIlIlIIlIlI + (float)HUD.mc.fontRenderer.getStringWidth(lIllIlIlIlIIIl) + 25.0f, lIllIlIlIIlIIl + 11.0f, CatClient.getClientColor().getRGB());
        }
    }

    public static int raindbow(int lIllIIllIIlIll) {
        double lIllIIllIIlIlI = Math.ceil((System.currentTimeMillis() + (long)lIllIIllIIlIll) / 20L);
        return Color.getHSBColor((float)((lIllIIllIIlIlI %= 360.0) / 360.0), 0.5f, 1.0f).getRGB();
    }

    @SubscribeEvent
    public void onOverlayRender(RenderGameOverlayEvent.Text lIllIIlllIIlIl) {
        HUD lIllIIlllIIllI;
        String lIllIIlllIIlll = CatClient.instance.settingsManager.getSettingByName(lIllIIlllIIllI, "Mode").getValString();
        if (Objects.equals(lIllIIlllIIlll, "Default")) {
            if (lIllIIlllIIlIl.getType() != RenderGameOverlayEvent.ElementType.TEXT || Minecraft.getMinecraft().gameSettings.showDebugInfo) {
                return;
            }
            int[] lIllIlIIIlllII = HUD.getRainbow(5, 0.1f);
            int lIllIlIIIllIll = HUD.RGBtoHex(lIllIlIIIlllII[0], lIllIlIIIlllII[1], lIllIlIIIlllII[2]);
            int lIllIlIIIllIlI = 2;
            lIllIIlllIIllI.sortList();
            ArrayList<String> lIllIlIIIllIIl = new ArrayList<String>();
            for (Module lIllIlIIlIIlIl : lIllIIlllIIllI.modulesSorted) {
                if (lIllIlIIlIIlIl.getName().equalsIgnoreCase("HUD") || !lIllIlIIlIIlIl.isToggled() || !lIllIlIIlIIlIl.visible) continue;
                lIllIlIIIllIIl.add(lIllIlIIlIIlIl.getName());
            }
            int lIllIlIIIllIII = HUD.mc.fontRenderer.FONT_HEIGHT;
            ScaledResolution lIllIlIIIlIlll = new ScaledResolution(Minecraft.getMinecraft());
            long lIllIlIIIlIllI = 0L;
            int lIllIlIIIlIlIl = 0;
            int lIllIlIIIlIlII = 0;
            int lIllIlIIIlIIll = 0;
            int lIllIlIIIlIIlI = 0;
            ScaledResolution lIllIlIIIlIIIl = new ScaledResolution(mc);
            int[] lIllIlIIIlIIII = new int[]{1};
            int lIllIlIIIIllll = 0;
            for (int lIllIlIIlIIlII = 0; lIllIlIIlIIlII < lIllIlIIIllIIl.size(); ++lIllIlIIlIIlII) {
                lIllIlIIIIllll += HUD.mc.fontRenderer.FONT_HEIGHT + 5;
            }
            for (int lIllIlIIIlllIl = 0; lIllIlIIIlllIl < lIllIlIIIllIIl.size(); ++lIllIlIIIlllIl) {
                String lIllIlIIlIIIll = (String)lIllIlIIIllIIl.get(lIllIlIIIlllIl);
                if (Strings.isNullOrEmpty((String)lIllIlIIlIIIll)) continue;
                int lIllIlIIlIIIlI = HUD.mc.fontRenderer.FONT_HEIGHT;
                int lIllIlIIlIIIIl = HUD.mc.fontRenderer.getStringWidth(lIllIlIIlIIIll);
                int lIllIlIIlIIIII = lIllIlIIIlIIIl.getScaledWidth() - 2 - lIllIlIIlIIIIl;
                int lIllIlIIIlllll = 1 + (lIllIlIIlIIIlI + 2) * lIllIlIIIlllIl;
                int lIllIlIIIllllI = ColorUtils.astolfoColors(lIllIlIIIlIIII[0] * 15, lIllIlIIIIllll);
                CatClient.color = new Color(lIllIlIIIllllI);
                if (lIllIlIIIlllIl == 0) {
                    // empty if block
                }
                Gui.drawRect((int)(lIllIlIIlIIIII + HUD.mc.fontRenderer.getStringWidth(lIllIlIIlIIIll)), (int)(lIllIlIIIlllll - 1), (int)(lIllIlIIlIIIII + HUD.mc.fontRenderer.getStringWidth(lIllIlIIlIIIll) + 1), (int)(lIllIlIIIlllll + 11), (int)lIllIlIIIllllI);
                RenderUtil.drawRect(lIllIlIIlIIIII - 2, lIllIlIIIlllll, lIllIlIIlIIIII + HUD.mc.fontRenderer.getStringWidth(lIllIlIIlIIIll), lIllIlIIIlllll + 11, 0x44000000);
                lIllIlIIIlIIll = HUD.mc.fontRenderer.getStringWidth(lIllIlIIlIIIll);
                lIllIlIIIlIlII = lIllIlIIlIIIII - 2;
                lIllIlIIIlIIlI = lIllIlIIIlllll + 10;
                if (lIllIlIIIlllIl == lIllIIlllIIllI.modulesSorted.size() - 1) {
                    RenderUtil.drawGlow(lIllIlIIlIIIII - 2, lIllIlIIIlllll + 10, lIllIlIIlIIIII + HUD.mc.fontRenderer.getStringWidth(lIllIlIIlIIIll), lIllIlIIIlllll + 11, lIllIlIIIllllI, 1000.0);
                }
                HUD.mc.fontRenderer.drawString(lIllIlIIlIIIll, lIllIlIIlIIIII, lIllIlIIIlllll + 1, lIllIlIIIllllI);
                ++lIllIlIIIlIllI;
                ++lIllIlIIIlIlIl;
                lIllIlIIIlIIII[0] = lIllIlIIIlIIII[0] + 1;
            }
            lIllIIlllIIllI.modulesSorted.clear();
        } else if (Objects.equals(lIllIIlllIIlll, "Bibr")) {
            if (lIllIIlllIIlIl.getType() != RenderGameOverlayEvent.ElementType.TEXT || Minecraft.getMinecraft().gameSettings.showDebugInfo) {
                return;
            }
            lIllIIlllIIllI.sortList();
            ArrayList<String> lIllIlIIIIIlIl = new ArrayList<String>();
            for (Module lIllIlIIIIlllI : lIllIIlllIIllI.modulesSorted) {
                if (lIllIlIIIIlllI.getName().equalsIgnoreCase("HUD") || !lIllIlIIIIlllI.isToggled() || !lIllIlIIIIlllI.visible) continue;
                lIllIlIIIIIlIl.add(lIllIlIIIIlllI.getName());
            }
            int lIllIlIIIIIlII = HUD.mc.fontRenderer.FONT_HEIGHT;
            ScaledResolution lIllIlIIIIIIll = new ScaledResolution(Minecraft.getMinecraft());
            long lIllIlIIIIIIlI = 0L;
            int lIllIlIIIIIIIl = 0;
            int lIllIlIIIIIIII = 0;
            int lIllIIllllllll = 0;
            int lIllIIlllllllI = 0;
            ScaledResolution lIllIIllllllIl = new ScaledResolution(mc);
            int[] lIllIIllllllII = new int[]{1};
            int lIllIIlllllIll = 0;
            for (int lIllIlIIIIllIl = 0; lIllIlIIIIllIl < lIllIlIIIIIlIl.size(); ++lIllIlIIIIllIl) {
                lIllIIlllllIll += HUD.mc.fontRenderer.FONT_HEIGHT + 5;
            }
            for (int lIllIlIIIIIllI = 0; lIllIlIIIIIllI < lIllIlIIIIIlIl.size(); ++lIllIlIIIIIllI) {
                String lIllIlIIIIllII = (String)lIllIlIIIIIlIl.get(lIllIlIIIIIllI);
                if (Strings.isNullOrEmpty((String)lIllIlIIIIllII)) continue;
                int lIllIlIIIIlIll = HUD.mc.fontRenderer.FONT_HEIGHT;
                int lIllIlIIIIlIlI = HUD.mc.fontRenderer.getStringWidth(lIllIlIIIIllII);
                int lIllIlIIIIlIIl = lIllIIllllllIl.getScaledWidth() - 1 - lIllIlIIIIlIlI;
                int lIllIlIIIIlIII = 1 + (lIllIlIIIIlIll + 2) * lIllIlIIIIIllI;
                int lIllIlIIIIIlll = ColorUtils.astolfoColors(lIllIIllllllII[0] * 15, lIllIIlllllIll);
                CatClient.color = new Color(lIllIlIIIIIlll);
                if (lIllIlIIIIIllI == 0) {
                    // empty if block
                }
                Gui.drawRect((int)(lIllIlIIIIlIIl + HUD.mc.fontRenderer.getStringWidth(lIllIlIIIIllII)), (int)(lIllIlIIIIlIII - 1), (int)(lIllIlIIIIlIIl + HUD.mc.fontRenderer.getStringWidth(lIllIlIIIIllII) + 1), (int)(lIllIlIIIIlIII + 11), (int)lIllIlIIIIIlll);
                RenderUtil.drawRect(lIllIlIIIIlIIl - 2, lIllIlIIIIlIII, lIllIlIIIIlIIl + HUD.mc.fontRenderer.getStringWidth(lIllIlIIIIllII), lIllIlIIIIlIII + 11, 0x44000000);
                lIllIIllllllll = HUD.mc.fontRenderer.getStringWidth(lIllIlIIIIllII);
                lIllIlIIIIIIII = lIllIlIIIIlIIl - 2;
                lIllIIlllllllI = lIllIlIIIIlIII + 10;
                if (lIllIlIIIIIllI == lIllIIlllIIllI.modulesSorted.size() - 1) {
                    RenderUtil.drawGlow(lIllIlIIIIlIIl - 2, lIllIlIIIIlIII + 10, lIllIlIIIIlIIl + HUD.mc.fontRenderer.getStringWidth(lIllIlIIIIllII), lIllIlIIIIlIII + 11, lIllIlIIIIIlll, 1000.0);
                }
                HUD.mc.fontRenderer.drawString(lIllIlIIIIllII, lIllIlIIIIlIIl, lIllIlIIIIlIII + 1, lIllIlIIIIIlll);
                ++lIllIlIIIIIIlI;
                ++lIllIlIIIIIIIl;
                lIllIIllllllII[0] = lIllIIllllllII[0] + 1;
            }
            lIllIIlllIIllI.modulesSorted.clear();
        } else if (Objects.equals(lIllIIlllIIlll, "Skeet")) {
            if (lIllIIlllIIlIl.getType() != RenderGameOverlayEvent.ElementType.TEXT || Minecraft.getMinecraft().gameSettings.showDebugInfo) {
                return;
            }
            lIllIIlllIIllI.sortList();
            ArrayList<String> lIllIIllllIIlI = new ArrayList<String>();
            for (Module lIllIIlllllIlI : lIllIIlllIIllI.modulesSorted) {
                if (lIllIIlllllIlI.getName().equalsIgnoreCase("HUD") || !lIllIIlllllIlI.isToggled() || !lIllIIlllllIlI.visible) continue;
                lIllIIllllIIlI.add(lIllIIlllllIlI.getName());
            }
            int lIllIIllllIIIl = HUD.mc.fontRenderer.FONT_HEIGHT;
            ScaledResolution lIllIIllllIIII = new ScaledResolution(Minecraft.getMinecraft());
            long lIllIIlllIllll = 0L;
            int lIllIIlllIlllI = 0;
            int lIllIIlllIllIl = 0;
            int lIllIIlllIllII = 0;
            int lIllIIlllIlIll = 0;
            ScaledResolution lIllIIlllIlIlI = new ScaledResolution(mc);
            for (int lIllIIllllIIll = 0; lIllIIllllIIll < lIllIIllllIIlI.size(); ++lIllIIllllIIll) {
                String lIllIIlllllIIl = (String)lIllIIllllIIlI.get(lIllIIllllIIll);
                if (Strings.isNullOrEmpty((String)lIllIIlllllIIl)) continue;
                int lIllIIlllllIII = HUD.mc.fontRenderer.FONT_HEIGHT;
                int lIllIIllllIlll = HUD.mc.fontRenderer.getStringWidth(lIllIIlllllIIl);
                int lIllIIllllIllI = lIllIIlllIlIlI.getScaledWidth() - 1 - lIllIIllllIlll;
                int lIllIIllllIlIl = 1 + (lIllIIlllllIII + 2) * lIllIIllllIIll;
                int lIllIIllllIlII = HUD.getRainbowChams(6000, -15);
                if (lIllIIllllIIll == 0) {
                    Gui.drawRect((int)(lIllIIllllIllI - 2), (int)(lIllIIllllIlIl - 1), (int)(lIllIIllllIllI + HUD.mc.fontRenderer.getStringWidth(lIllIIlllllIIl)), (int)lIllIIllllIlIl, (int)lIllIIllllIlII);
                }
                Gui.drawRect((int)(lIllIIllllIllI - 2), (int)lIllIIllllIlIl, (int)(lIllIIllllIllI + HUD.mc.fontRenderer.getStringWidth(lIllIIlllllIIl)), (int)(lIllIIllllIlIl + 11), (int)0x44000000);
                Gui.drawRect((int)(lIllIIllllIllI - 3), (int)(lIllIIllllIlIl - 1), (int)(lIllIIllllIllI - 2), (int)(lIllIIllllIlIl + 11), (int)lIllIIllllIlII);
                Gui.drawRect((int)lIllIIlllIllIl, (int)lIllIIlllIlIll, (int)(lIllIIlllIllIl + (lIllIIlllIllII - HUD.mc.fontRenderer.getStringWidth(lIllIIlllllIIl))), (int)(lIllIIlllIlIll + 1), (int)lIllIIllllIlII);
                lIllIIlllIllII = HUD.mc.fontRenderer.getStringWidth(lIllIIlllllIIl);
                lIllIIlllIllIl = lIllIIllllIllI - 2;
                lIllIIlllIlIll = lIllIIllllIlIl + 10;
                Gui.drawRect((int)(lIllIIllllIllI + HUD.mc.fontRenderer.getStringWidth(lIllIIlllllIIl)), (int)(lIllIIllllIlIl - 1), (int)(lIllIIllllIllI + HUD.mc.fontRenderer.getStringWidth(lIllIIlllllIIl) + 1), (int)(lIllIIllllIlIl + 11), (int)lIllIIllllIlII);
                if (lIllIIllllIIll == lIllIIlllIIllI.modulesSorted.size() - 1) {
                    Gui.drawRect((int)(lIllIIllllIllI - 2), (int)(lIllIIllllIlIl + 10), (int)(lIllIIllllIllI + HUD.mc.fontRenderer.getStringWidth(lIllIIlllllIIl)), (int)(lIllIIllllIlIl + 11), (int)lIllIIllllIlII);
                }
                HUD.mc.fontRenderer.drawString(lIllIIlllllIIl, lIllIIllllIllI, lIllIIllllIlIl + 1, lIllIIllllIlII);
                ++lIllIIlllIllll;
                ++lIllIIlllIlllI;
            }
            lIllIIlllIIllI.modulesSorted.clear();
        }
    }

    public static int getRainbowChams(int lIllIIlIllIIIl, int lIllIIlIllIIII) {
        float lIllIIlIllIIlI = (System.currentTimeMillis() * 1L + (long)(lIllIIlIllIIII / 2)) % (long)lIllIIlIllIIIl * 2L;
        return Color.getHSBColor(lIllIIlIllIIlI /= (float)lIllIIlIllIIIl, 1.0f, 1.0f).getRGB();
    }

    public void drawitem(ItemStack lIllIlIllIlllI, int lIllIlIllIllIl, int lIllIlIlllIIII) {
        HUD lIllIlIlllIIll;
        GlStateManager.enableDepth();
        HUD.itemRender.zLevel = 200.0f;
        itemRender.renderItemAndEffectIntoGUI(lIllIlIllIlllI, lIllIlIllIllIl, lIllIlIlllIIII);
        itemRender.renderItemOverlayIntoGUI(HUD.mc.fontRenderer, lIllIlIllIlllI, lIllIlIllIllIl, lIllIlIlllIIII, "");
        GlStateManager.enableTexture2D();
        GlStateManager.disableLighting();
        GlStateManager.disableDepth();
        if (lIllIlIllIlllI.getCount() == 0 || lIllIlIllIlllI.getCount() == 1) {
            lIllIlIlllIIll.fr.drawString("", lIllIlIllIllIl + 13, lIllIlIlllIIII + 10, Color.white.getRGB());
        } else {
            lIllIlIlllIIll.fr.drawString(String.valueOf(new StringBuilder().append("").append(lIllIlIllIlllI.getCount())), lIllIlIllIllIl + 13, lIllIlIlllIIII + 10, Color.white.getRGB());
        }
    }

    static {
        Modes = new ArrayList<String>();
        itemRender = Minecraft.getMinecraft().getRenderItem();
    }
}

