/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.Gui
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$ElementType
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$Text
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package ru.internali.module.HUD;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;
import ru.internali.utils.ColorUtils;
import ru.internali.utils.RenderUtil;

public class Watermark
extends Module {
    public static /* synthetic */ List<String> Modes;
    private final /* synthetic */ FontRenderer fr;

    static {
        Modes = new ArrayList<String>();
    }

    @SubscribeEvent
    public void onOverlayRender(RenderGameOverlayEvent.Text lIIlIlllIIllIIl) {
        Watermark lIIlIlllIIllIlI;
        String lIIlIlllIIllIII = CatClient.instance.settingsManager.getSettingByName(lIIlIlllIIllIlI, "Mode").getValString();
        if (lIIlIlllIIllIIl.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            if (Objects.equals(lIIlIlllIIllIII, "Anim")) {
                int[] lIIlIlllIllIllI = Watermark.getRainbow(5, 0.1f);
                int lIIlIlllIllIlIl = Watermark.RGBtoHex(lIIlIlllIllIllI[0], lIIlIlllIllIllI[1], lIIlIlllIllIllI[2]);
                int lIIlIlllIllIlII = 2;
                String lIIlIlllIllIIll = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
                String lIIlIlllIllIIlI = "MoonLight";
                switch ((int)(System.currentTimeMillis() / 700L % 42L)) {
                    case 1: {
                        lIIlIlllIllIIlI = "  ";
                        break;
                    }
                    case 2: {
                        lIIlIlllIllIIlI = " | ";
                        break;
                    }
                    case 3: {
                        lIIlIlllIllIIlI = " |/ ";
                        break;
                    }
                    case 4: {
                        lIIlIlllIllIIlI = " |// ";
                        break;
                    }
                    case 5: {
                        lIIlIlllIllIIlI = "M ";
                        break;
                    }
                    case 6: {
                        lIIlIlllIllIIlI = "M3 ";
                        break;
                    }
                    case 7: {
                        lIIlIlllIllIIlI = "Mo ";
                        break;
                    }
                    case 8: {
                        lIIlIlllIllIIlI = "Moo\\ ";
                        break;
                    }
                    case 9: {
                        lIIlIlllIllIIlI = "Moo\\/ ";
                        break;
                    }
                    case 10: {
                        lIIlIlllIllIIlI = "Moon ";
                        break;
                    }
                    case 11: {
                        lIIlIlllIllIIlI = "Moon3 ";
                        break;
                    }
                    case 12: {
                        lIIlIlllIllIIlI = "Moonl| ";
                        break;
                    }
                    case 13: {
                        lIIlIlllIllIIlI = "Moonl|2 ";
                        break;
                    }
                    case 14: {
                        lIIlIlllIllIIlI = "Moonl|_ ";
                        break;
                    }
                    case 15: {
                        lIIlIlllIllIIlI = "Moonli ";
                        break;
                    }
                    case 16: {
                        lIIlIlllIllIIlI = "Moonli/ ";
                        break;
                    }
                    case 17: {
                        lIIlIlllIllIIlI = "Moonlig ";
                        break;
                    }
                    case 18: {
                        lIIlIlllIllIIlI = "Moonlig@# ";
                        break;
                    }
                    case 19: {
                        lIIlIlllIllIIlI = "Moonligh ";
                        break;
                    }
                    case 20: {
                        lIIlIlllIllIIlI = "Moonligh|/ ";
                        break;
                    }
                    case 21: {
                        lIIlIlllIllIIlI = "Moonlight ";
                        break;
                    }
                    case 22: {
                        lIIlIlllIllIIlI = "Moonligh|/ ";
                        break;
                    }
                    case 23: {
                        lIIlIlllIllIIlI = "Moonligh ";
                        break;
                    }
                    case 24: {
                        lIIlIlllIllIIlI = "Moonlig@# ";
                        break;
                    }
                    case 25: {
                        lIIlIlllIllIIlI = "Moonlig ";
                        break;
                    }
                    case 26: {
                        lIIlIlllIllIIlI = "Moonli/ ";
                        break;
                    }
                    case 27: {
                        lIIlIlllIllIIlI = "Moonli ";
                        break;
                    }
                    case 28: {
                        lIIlIlllIllIIlI = "Moonl|_ ";
                        break;
                    }
                    case 29: {
                        lIIlIlllIllIIlI = "Moonl|2 ";
                        break;
                    }
                    case 30: {
                        lIIlIlllIllIIlI = "Moonl| ";
                        break;
                    }
                    case 31: {
                        lIIlIlllIllIIlI = "Moon3 ";
                        break;
                    }
                    case 32: {
                        lIIlIlllIllIIlI = "Moon ";
                        break;
                    }
                    case 33: {
                        lIIlIlllIllIIlI = "Moo\\/ ";
                        break;
                    }
                    case 34: {
                        lIIlIlllIllIIlI = "Moo\\ ";
                        break;
                    }
                    case 35: {
                        lIIlIlllIllIIlI = "Mo ";
                        break;
                    }
                    case 36: {
                        lIIlIlllIllIIlI = "M3 ";
                        break;
                    }
                    case 37: {
                        lIIlIlllIllIIlI = "M ";
                        break;
                    }
                    case 38: {
                        lIIlIlllIllIIlI = " |// ";
                        break;
                    }
                    case 39: {
                        lIIlIlllIllIIlI = " |/ ";
                        break;
                    }
                    case 40: {
                        lIIlIlllIllIIlI = " | ";
                        break;
                    }
                    case 41: {
                        lIIlIlllIllIIlI = "   ";
                    }
                }
                String lIIlIlllIllIIIl = String.valueOf(new StringBuilder().append(lIIlIlllIllIIlI).append(" | ").append(lIIlIlllIllIIll).append(" |  Fps ").append(Minecraft.getDebugFPS()));
                Gui.drawRect((int)5, (int)5, (int)(lIIlIlllIIllIlI.fr.getStringWidth(lIIlIlllIllIIIl) + 25), (int)21, (int)new Color(37, 37, 37, 255).getRGB());
                Gui.drawRect((int)6, (int)6, (int)(lIIlIlllIIllIlI.fr.getStringWidth(lIIlIlllIllIIIl) + 24), (int)8, (int)CatClient.getClientColor().getRGB());
                Gui.drawRect((int)5, (int)9, (int)(lIIlIlllIIllIlI.fr.getStringWidth(lIIlIlllIllIIIl) + 25), (int)9, (int)new Color(20, 20, 20, 100).getRGB());
                lIIlIlllIIllIlI.fr.drawStringWithShadow(lIIlIlllIllIIIl, 8.0f, 11.0f, -1);
            } else if (Objects.equals(lIIlIlllIIllIII, "Static")) {
                String lIIlIlllIlIlIlI;
                int[] lIIlIlllIlIllll = Watermark.getRainbow(5, 0.1f);
                int lIIlIlllIlIlllI = Watermark.RGBtoHex(lIIlIlllIlIllll[0], lIIlIlllIlIllll[1], lIIlIlllIlIllll[2]);
                int lIIlIlllIlIllIl = 2;
                String lIIlIlllIlIllII = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
                String lIIlIlllIlIlIll = "MoonLight";
                switch ((int)(System.currentTimeMillis() / 700L % 15L)) {
                    case 1: {
                        lIIlIlllIlIlIll = "MoonLight";
                    }
                }
                if (mc.isSingleplayer()) {
                    String lIIlIlllIllIIII = "localhost";
                } else {
                    lIIlIlllIlIlIlI = Watermark.mc.getCurrentServerData().serverIP.toLowerCase();
                }
                String lIIlIlllIlIlIIl = String.valueOf(new StringBuilder().append(lIIlIlllIlIlIll).append(" | ").append(lIIlIlllIlIllII).append(" |  Fps ").append(Minecraft.getDebugFPS()).append("  | ").append(lIIlIlllIlIlIlI));
                Gui.drawRect((int)5, (int)5, (int)(lIIlIlllIIllIlI.fr.getStringWidth(lIIlIlllIlIlIIl) + 21), (int)21, (int)new Color(37, 37, 37, 255).getRGB());
                Gui.drawRect((int)5, (int)9, (int)(lIIlIlllIIllIlI.fr.getStringWidth(lIIlIlllIlIlIIl) + 21), (int)9, (int)new Color(20, 20, 20, 100).getRGB());
                Gui.drawRect((int)6, (int)17, (int)(lIIlIlllIIllIlI.fr.getStringWidth(lIIlIlllIlIlIIl) + 20), (int)20, (int)CatClient.getClientColor().getRGB());
                lIIlIlllIIllIlI.fr.drawStringWithShadow(lIIlIlllIlIlIIl, 8.0f, 8.0f, -1);
            } else if (Objects.equals(lIIlIlllIIllIII, "Skeet")) {
                int[] lIIlIlllIlIlIII = Watermark.getRainbow(5, 0.1f);
                int lIIlIlllIlIIlll = Watermark.RGBtoHex(lIIlIlllIlIlIII[0], lIIlIlllIlIlIII[1], lIIlIlllIlIlIII[2]);
                int lIIlIlllIlIIllI = 2;
                String lIIlIlllIlIIlIl = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
                String lIIlIlllIlIIlII = mc.isSingleplayer() ? "localhost" : Watermark.mc.getCurrentServerData().serverIP.toLowerCase();
                StringBuilder lIIlIlllIlIIIll = new StringBuilder(String.valueOf(new StringBuilder().append((Object)new StringBuilder(String.valueOf(new StringBuilder().append((Object)new StringBuilder(String.valueOf(new StringBuilder().append((Object)new StringBuilder().append("MoonLight").append(" ").append("Beta")).append(" | ").append(lIIlIlllIlIIlIl).append(" | Fps ").append(Minecraft.getDebugFPS())))).append(" | ").append(lIIlIlllIlIIlII)))).append("  ")));
                Minecraft lIIlIlllIlIIIlI = mc;
                String lIIlIlllIlIIIIl = String.valueOf(lIIlIlllIlIIIll);
                float lIIlIlllIlIIIII = Minecraft.getMinecraft().fontRenderer.getStringWidth(lIIlIlllIlIIIIl) + 6;
                int lIIlIlllIIlllll = 20;
                int lIIlIlllIIllllI = 2;
                int lIIlIlllIIlllIl = 2;
                RenderUtil.drawRect(lIIlIlllIIllllI, lIIlIlllIIlllIl, (float)lIIlIlllIIllllI + lIIlIlllIlIIIII + 2.0f, lIIlIlllIIlllIl + lIIlIlllIIlllll, new Color(5, 5, 5, 255).getRGB());
                RenderUtil.drawBorderedRect((double)lIIlIlllIIllllI + 0.5, (double)lIIlIlllIIlllIl + 0.5, (double)((float)lIIlIlllIIllllI + lIIlIlllIlIIIII) + 1.5, (double)(lIIlIlllIIlllIl + lIIlIlllIIlllll) - 0.5, 0.5, new Color(40, 40, 40, 255).getRGB(), new Color(60, 60, 60, 255).getRGB(), true);
                RenderUtil.drawBorderedRect(lIIlIlllIIllllI + 2, lIIlIlllIIlllIl + 2, (float)lIIlIlllIIllllI + lIIlIlllIlIIIII, lIIlIlllIIlllIl + lIIlIlllIIlllll - 2, 0.5, new Color(22, 22, 22, 255).getRGB(), new Color(60, 60, 60, 255).getRGB(), true);
                RenderUtil.drawRect((double)lIIlIlllIIllllI + 2.5, (double)lIIlIlllIIlllIl + 2.5, (double)((float)lIIlIlllIIllllI + lIIlIlllIlIIIII) - 0.5, (double)lIIlIlllIIlllIl + 4.5, new Color(9, 9, 9, 255).getRGB());
                RenderUtil.drawGradientSideways(4.0, lIIlIlllIIlllIl + 3, 4.0f + lIIlIlllIlIIIII / 3.0f, lIIlIlllIIlllIl + 4, new Color(81, 149, 219, 255).getRGB(), new Color(180, 49, 218, 255).getRGB());
                RenderUtil.drawGradientSideways(4.0f + lIIlIlllIlIIIII / 3.0f, lIIlIlllIIlllIl + 3, 4.0f + lIIlIlllIlIIIII / 3.0f * 2.0f, lIIlIlllIIlllIl + 4, new Color(180, 49, 218, 255).getRGB(), new Color(236, 93, 128, 255).getRGB());
                RenderUtil.drawGradientSideways(4.0f + lIIlIlllIlIIIII / 3.0f * 2.0f, lIIlIlllIIlllIl + 3, lIIlIlllIlIIIII / 3.0f * 3.0f + 1.0f, lIIlIlllIIlllIl + 4, new Color(236, 93, 128, 255).getRGB(), new Color(235, 255, 0, 255).getRGB());
                Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(lIIlIlllIlIIIIl, (float)(4 + lIIlIlllIIllllI), (float)(7 + lIIlIlllIIlllIl), -1);
            } else if (Objects.equals(lIIlIlllIIllIII, "OnetapOLD")) {
                String lIIlIlllIIlllII = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
                String lIIlIlllIIllIll = String.valueOf(new StringBuilder().append("MoonLight | ").append(lIIlIlllIIlllII).append(" |  Fps ").append(Minecraft.getDebugFPS()));
                Gui.drawRect((int)5, (int)7, (int)(lIIlIlllIIllIlI.fr.getStringWidth(lIIlIlllIIllIll) + 25), (int)19, (int)new Color(37, 37, 37, 111).getRGB());
                Gui.drawRect((int)5, (int)6, (int)(lIIlIlllIIllIlI.fr.getStringWidth(lIIlIlllIIllIll) + 25), (int)8, (int)ColorUtils.astolfoColors((int)((double)Math.abs(System.currentTimeMillis() / 50L) / 100.0 + 0.16999999999999998), 5));
                Gui.drawRect((int)5, (int)9, (int)(lIIlIlllIIllIlI.fr.getStringWidth(lIIlIlllIIllIll) + 25), (int)9, (int)new Color(20, 20, 20, 87).getRGB());
                lIIlIlllIIllIlI.fr.drawStringWithShadow(lIIlIlllIIllIll, 8.0f, 9.1f, -1);
            }
        }
    }

    public static int RGBtoHex(int lIIlIllllIIlIII, int lIIlIllllIIlIlI, int lIIlIllllIIlIIl) {
        return lIIlIllllIIlIII << 16 | lIIlIllllIIlIlI << 8 | lIIlIllllIIlIIl;
    }

    public Watermark() {
        super("Watermark", "Watermark", Category.HUD);
        Watermark lIIlIlllllIlIll;
        lIIlIlllllIlIll.fr = Minecraft.getMinecraft().fontRenderer;
        Modes.add("Anim");
        Modes.add("Static");
        Modes.add("Skeet");
        Modes.add("OnetapOLD");
        CatClient.instance.settingsManager.rSetting(new Setting("Mode", lIIlIlllllIlIll, "Skeet", (ArrayList)Modes));
    }

    public static int[] getRainbow(int lIIlIllllIlIlll, float lIIlIllllIlIllI) {
        int lIIlIllllIllllI = 0;
        int lIIlIllllIlllIl = 0;
        int lIIlIllllIlllII = 0;
        long lIIlIllllIllIll = (System.currentTimeMillis() - (long)Math.round(lIIlIllllIlIllI * 1000.0f)) % (long)(lIIlIllllIlIlll * 1000);
        float lIIlIllllIllIlI = 6.0f * (float)lIIlIllllIllIll / (float)(lIIlIllllIlIlll * 1000);
        float lIIlIllllIllIIl = lIIlIllllIllIlI - (float)Math.floor(lIIlIllllIllIlI);
        int lIIlIllllIllIII = Math.round(255.0f * lIIlIllllIllIIl);
        if (lIIlIllllIllIlI < 1.0f) {
            lIIlIllllIllllI = 255;
            lIIlIllllIlllIl = lIIlIllllIllIII;
        } else if (lIIlIllllIllIlI < 2.0f) {
            lIIlIllllIllllI = 255 - lIIlIllllIllIII;
            lIIlIllllIlllIl = 255;
        } else if (lIIlIllllIllIlI < 3.0f) {
            lIIlIllllIlllIl = 255;
            lIIlIllllIlllII = lIIlIllllIllIII;
        } else if (lIIlIllllIllIlI < 4.0f) {
            lIIlIllllIlllIl = 255 - lIIlIllllIllIII;
            lIIlIllllIlllII = 255;
        } else if (lIIlIllllIllIlI < 5.0f) {
            lIIlIllllIllllI = lIIlIllllIllIII;
            lIIlIllllIlllII = 255;
        } else if (lIIlIllllIllIlI < 6.0f) {
            lIIlIllllIllllI = 255;
            lIIlIllllIlllII = 255 - lIIlIllllIllIII;
        }
        return new int[]{lIIlIllllIllllI, lIIlIllllIlllIl, lIIlIllllIlllII};
    }
}

