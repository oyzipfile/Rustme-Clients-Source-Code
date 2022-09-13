/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 */
package ru.hld.legendline.impl.modules.Render;

import java.util.ArrayList;
import java.util.Calendar;
import net.minecraft.client.Minecraft;
import ru.hld.legendline.Client;
import ru.hld.legendline.antiNative.RenderUtils;
import ru.hld.legendline.api.event.EventTarget;
import ru.hld.legendline.api.event.events.EventRender2D;
import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.api.setting.settings.ModeSetting;
import ru.hld.legendline.api.utils.CFontRenderer;
import ru.hld.legendline.api.utils.ColorUtils;
import ru.hld.legendline.api.utils.Fonts;
import ru.hld.legendline.api.utils.MathUtils;
import ru.hld.legendline.api.utils.TimerUtils;

public class WaterMark
extends Module {
    /* synthetic */ int col2;
    /* synthetic */ float animXMot;
    /* synthetic */ int col;
    /* synthetic */ int pos;
    /* synthetic */ TimerUtils timer;
    /* synthetic */ ModeSetting modec;
    /* synthetic */ float animY;
    /* synthetic */ float animX;
    /* synthetic */ float animYMot;
    /* synthetic */ ModeSetting mode;

    public WaterMark() {
        super("WaterMark", "show name of client on screen", Category.Render, 170, 30, 770, 7);
        WaterMark lllllllllllllllIIlIIIIlIIIIllIlI;
        lllllllllllllllIIlIIIIlIIIIllIlI.animX = 0.0f;
        lllllllllllllllIIlIIIIlIIIIllIlI.animY = 1.0f;
        lllllllllllllllIIlIIIIlIIIIllIlI.animXMot = 1.4f;
        lllllllllllllllIIlIIIIlIIIIllIlI.animYMot = 1.4f;
        lllllllllllllllIIlIIIIlIIIIllIlI.pos = 0;
        lllllllllllllllIIlIIIIlIIIIllIlI.col = 0;
        lllllllllllllllIIlIIIIlIIIIllIlI.col2 = 0;
        lllllllllllllllIIlIIIIlIIIIllIlI.timer = new TimerUtils();
        ArrayList<String> lllllllllllllllIIlIIIIlIIIIllIIl = new ArrayList<String>();
        ArrayList<String> lllllllllllllllIIlIIIIlIIIIllIII = new ArrayList<String>();
        lllllllllllllllIIlIIIIlIIIIllIIl.add("LegendLine");
        lllllllllllllllIIlIIIIlIIIIllIIl.add("Onetap");
        lllllllllllllllIIlIIIIlIIIIllIII.add("Client");
        lllllllllllllllIIlIIIIlIIIIllIII.add("Astolfo");
        lllllllllllllllIIlIIIIlIIIIllIlI.mode = new ModeSetting("Mode", "modes of Watermark", lllllllllllllllIIlIIIIlIIIIllIlI, lllllllllllllllIIlIIIIlIIIIllIIl, "LegendLine");
        Client.settingManager.add(lllllllllllllllIIlIIIIlIIIIllIlI.mode);
        lllllllllllllllIIlIIIIlIIIIllIlI.modec = new ModeSetting("Color", "colors of Watermark", lllllllllllllllIIlIIIIlIIIIllIlI, lllllllllllllllIIlIIIIlIIIIllIII, "Client");
        Client.settingManager.add(lllllllllllllllIIlIIIIlIIIIllIlI.modec);
    }

    @EventTarget
    public void onRender2D(EventRender2D lllllllllllllllIIlIIIIIlllIlIlIl) {
        WaterMark lllllllllllllllIIlIIIIIlllIlIllI;
        int lllllllllllllllIIlIIIIIlllIlIlII = lllllllllllllllIIlIIIIIlllIlIllI.getPosX();
        int lllllllllllllllIIlIIIIIlllIlIIlI = lllllllllllllllIIlIIIIIlllIlIllI.getPosY();
        float lllllllllllllllIIlIIIIIlllIlIIIl = (float)Math.sqrt(lllllllllllllllIIlIIIIIlllIlIllI.mc.player.motionX * lllllllllllllllIIlIIIIIlllIlIllI.mc.player.motionX + lllllllllllllllIIlIIIIIlllIlIllI.mc.player.motionY * lllllllllllllllIIlIIIIIlllIlIllI.mc.player.motionY + lllllllllllllllIIlIIIIIlllIlIllI.mc.player.motionZ * lllllllllllllllIIlIIIIIlllIlIllI.mc.player.motionZ);
        lllllllllllllllIIlIIIIIlllIlIIIl = MathUtils.clamp(lllllllllllllllIIlIIIIIlllIlIIIl, 0.0f, 0.3f);
        lllllllllllllllIIlIIIIIlllIlIllI.animX = MathUtils.lerp(lllllllllllllllIIlIIIIIlllIlIllI.animX, lllllllllllllllIIlIIIIIlllIlIllI.animXMot, lllllllllllllllIIlIIIIIlllIlIIIl);
        lllllllllllllllIIlIIIIIlllIlIllI.animY = MathUtils.lerp(lllllllllllllllIIlIIIIIlllIlIllI.animY, lllllllllllllllIIlIIIIIlllIlIllI.animYMot, lllllllllllllllIIlIIIIIlllIlIIIl);
        if (lllllllllllllllIIlIIIIIlllIlIllI.animX > 1.3f) {
            lllllllllllllllIIlIIIIIlllIlIllI.animXMot = 0.7f;
        } else if (lllllllllllllllIIlIIIIIlllIlIllI.animX < 0.8f) {
            lllllllllllllllIIlIIIIIlllIlIllI.animXMot = 1.4f;
        }
        if (lllllllllllllllIIlIIIIIlllIlIllI.animY > 1.3f) {
            lllllllllllllllIIlIIIIIlllIlIllI.animYMot = 0.7f;
        } else if (lllllllllllllllIIlIIIIIlllIlIllI.animY < 0.8f) {
            lllllllllllllllIIlIIIIIlllIlIllI.animYMot = 1.4f;
        }
        CFontRenderer lllllllllllllllIIlIIIIIlllIIllll = Fonts.mntsb_16;
        String lllllllllllllllIIlIIIIIlllIIllIl = String.valueOf(new StringBuilder().append(Calendar.getInstance().getTime().getHours()).append(":").append(Calendar.getInstance().getTime().getMinutes()).append(":").append(Calendar.getInstance().getTime().getSeconds()));
        String lllllllllllllllIIlIIIIIlllIIllII = "";
        String lllllllllllllllIIlIIIIIlllIIlIlI = "";
        String lllllllllllllllIIlIIIIIlllIIlIII = "";
        String lllllllllllllllIIlIIIIIlllIIIllI = "";
        switch (lllllllllllllllIIlIIIIIlllIlIllI.modec.getVal()) {
            case "Astolfo": {
                lllllllllllllllIIlIIIIIlllIlIllI.col = ColorUtils.astolfoColorsCool(1, 80);
                break;
            }
            case "Client": {
                lllllllllllllllIIlIIIIIlllIlIllI.col = Client.getColor();
            }
        }
        switch (lllllllllllllllIIlIIIIIlllIlIllI.mode.getVal()) {
            case "Onetap": {
                lllllllllllllllIIlIIIIIlllIIIllI = Calendar.getInstance().getTime().getHours() <= 15 && Calendar.getInstance().getTime().getHours() >= 0 ? "" : "";
                if (Calendar.getInstance().getTime().getHours() <= 9) {
                    lllllllllllllllIIlIIIIIlllIIllII = "0";
                }
                if (Calendar.getInstance().getTime().getMinutes() <= 9) {
                    lllllllllllllllIIlIIIIIlllIIlIlI = "0";
                }
                if (Calendar.getInstance().getTime().getSeconds() <= 9) {
                    lllllllllllllllIIlIIIIIlllIIlIII = "0";
                }
                if (Calendar.getInstance().getTime().getHours() <= 9 || Calendar.getInstance().getTime().getMinutes() <= 9 || Calendar.getInstance().getTime().getSeconds() <= 9) {
                    lllllllllllllllIIlIIIIIlllIIllIl = String.valueOf(new StringBuilder().append(lllllllllllllllIIlIIIIIlllIIllII).append(Calendar.getInstance().getTime().getHours()).append(":").append(lllllllllllllllIIlIIIIIlllIIlIlI).append(Calendar.getInstance().getTime().getMinutes()).append(":").append(lllllllllllllllIIlIIIIIlllIIlIII).append(Calendar.getInstance().getTime().getSeconds()).append(" ").append(lllllllllllllllIIlIIIIIlllIIIllI));
                }
                String lllllllllllllllIIlIIIIIlllIlllII = String.valueOf(new StringBuilder().append("LEGENDLINE | v2.0 | ").append(Minecraft.getDebugFPS()).append("fps | ").append(lllllllllllllllIIlIIIIIlllIIllIl));
                int lllllllllllllllIIlIIIIIlllIllIlI = lllllllllllllllIIlIIIIIlllIIllll.getStringWidth(lllllllllllllllIIlIIIIIlllIlllII);
                for (int lllllllllllllllIIlIIIIIlllIllllI = 0; lllllllllllllllIIlIIIIIlllIllllI < lllllllllllllllIIlIIIIIlllIllIlI + 8; ++lllllllllllllllIIlIIIIIlllIllllI) {
                    RenderUtils.drawRect(lllllllllllllllIIlIIIIIlllIlIlII + 4 + lllllllllllllllIIlIIIIIlllIllllI, (float)lllllllllllllllIIlIIIIIlllIlIIlI + 5.5f, (float)lllllllllllllllIIlIIIIIlllIlIlII + 5.0f + (float)lllllllllllllllIIlIIIIIlllIllllI, lllllllllllllllIIlIIIIIlllIlIIlI + 7, ColorUtils.astolfoColorsCool(1, 80 + lllllllllllllllIIlIIIIIlllIllllI / 2));
                }
                RenderUtils.drawRect(lllllllllllllllIIlIIIIIlllIlIlII + 4, lllllllllllllllIIlIIIIIlllIlIIlI + 7, lllllllllllllllIIlIIIIIlllIlIlII + 12 + lllllllllllllllIIlIIIIIlllIllIlI, lllllllllllllllIIlIIIIIlllIlIIlI + 21, ColorUtils.getColor(0, 0, 0, 190));
                lllllllllllllllIIlIIIIIlllIIllll.drawStringWithShadow(lllllllllllllllIIlIIIIIlllIlllII, lllllllllllllllIIlIIIIIlllIlIlII + 8, lllllllllllllllIIlIIIIIlllIlIIlI + 12, -1);
                break;
            }
            case "LegendLine": {
                lllllllllllllllIIlIIIIIlllIIIllI = Calendar.getInstance().getTime().getHours() <= 15 && Calendar.getInstance().getTime().getHours() >= 0 ? "" : "";
                if (Calendar.getInstance().getTime().getHours() <= 9) {
                    lllllllllllllllIIlIIIIIlllIIllII = "0";
                }
                if (Calendar.getInstance().getTime().getMinutes() <= 9) {
                    lllllllllllllllIIlIIIIIlllIIlIlI = "0";
                }
                if (Calendar.getInstance().getTime().getSeconds() <= 9) {
                    lllllllllllllllIIlIIIIIlllIIlIII = "0";
                }
                if (Calendar.getInstance().getTime().getHours() <= 9 || Calendar.getInstance().getTime().getMinutes() <= 9 || Calendar.getInstance().getTime().getSeconds() <= 9) {
                    lllllllllllllllIIlIIIIIlllIIllIl = String.valueOf(new StringBuilder().append(lllllllllllllllIIlIIIIIlllIIllII).append(Calendar.getInstance().getTime().getHours()).append(":").append(lllllllllllllllIIlIIIIIlllIIlIlI).append(Calendar.getInstance().getTime().getMinutes()).append(":").append(lllllllllllllllIIlIIIIIlllIIlIII).append(Calendar.getInstance().getTime().getSeconds()).append(" ").append(lllllllllllllllIIlIIIIIlllIIIllI));
                }
                String lllllllllllllllIIlIIIIIlllIllIII = String.valueOf(new StringBuilder().append("LEGENDLINE | v2.0 | ").append(Minecraft.getDebugFPS()).append("fps | ").append(lllllllllllllllIIlIIIIIlllIIllIl));
                int lllllllllllllllIIlIIIIIlllIlIlll = lllllllllllllllIIlIIIIIlllIIllll.getStringWidth(lllllllllllllllIIlIIIIIlllIllIII);
                RenderUtils.drawShadowRect(lllllllllllllllIIlIIIIIlllIlIlII + 4, lllllllllllllllIIlIIIIIlllIlIIlI + 7, lllllllllllllllIIlIIIIIlllIlIlII + 12 + lllllllllllllllIIlIIIIIlllIlIlll, lllllllllllllllIIlIIIIIlllIlIIlI + 21, 6, lllllllllllllllIIlIIIIIlllIlIllI.col);
                lllllllllllllllIIlIIIIIlllIIllll.drawStringWithShadow(lllllllllllllllIIlIIIIIlllIllIII, lllllllllllllllIIlIIIIIlllIlIlII + 8, lllllllllllllllIIlIIIIIlllIlIIlI + 12, -1);
            }
        }
    }
}

