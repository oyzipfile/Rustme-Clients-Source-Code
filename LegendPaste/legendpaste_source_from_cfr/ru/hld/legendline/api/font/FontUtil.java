/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.StringUtils
 */
package ru.hld.legendline.api.font;

import java.awt.Font;
import net.minecraft.util.StringUtils;
import ru.hld.legendline.api.font.CustomFontRenderer;

public class FontUtil {
    private static /* synthetic */ CustomFontRenderer fontRenderer;

    public static void setupFontUtils() {
        fontRenderer = new CustomFontRenderer(new Font("Arial", 0, 17), true, true);
    }

    public static void drawString(String lllllllllllllllIIIllIlIlIllIIlll, int lllllllllllllllIIIllIlIlIllIIllI, double lllllllllllllllIIIllIlIlIllIIlIl, int lllllllllllllllIIIllIlIlIllIIlII) {
        fontRenderer.drawString(lllllllllllllllIIIllIlIlIllIIlll, lllllllllllllllIIIllIlIlIllIIllI, (int)lllllllllllllllIIIllIlIlIllIIlIl, lllllllllllllllIIIllIlIlIllIIlII);
    }

    public static void drawCenteredString(String lllllllllllllllIIIllIlIlIlIIllll, double lllllllllllllllIIIllIlIlIlIIlIlI, double lllllllllllllllIIIllIlIlIlIIllIl, int lllllllllllllllIIIllIlIlIlIIllII) {
        FontUtil.drawString(lllllllllllllllIIIllIlIlIlIIllll, (int)(lllllllllllllllIIIllIlIlIlIIlIlI - (double)(fontRenderer.getStringWidth(lllllllllllllllIIIllIlIlIlIIllll) / 2)), lllllllllllllllIIIllIlIlIlIIllIl, lllllllllllllllIIIllIlIlIlIIllII);
    }

    public FontUtil() {
        FontUtil lllllllllllllllIIIllIlIlIllIllll;
    }

    public static void drawStringWithShadow(String lllllllllllllllIIIllIlIlIlIllIll, double lllllllllllllllIIIllIlIlIlIllIlI, double lllllllllllllllIIIllIlIlIlIlIlIl, int lllllllllllllllIIIllIlIlIlIlIlII) {
        fontRenderer.drawStringWithShadow(lllllllllllllllIIIllIlIlIlIllIll, (float)lllllllllllllllIIIllIlIlIlIllIlI, (float)lllllllllllllllIIIllIlIlIlIlIlIl, lllllllllllllllIIIllIlIlIlIlIlII);
    }

    public static void drawTotalCenteredStringWithShadow(String lllllllllllllllIIIllIlIlIIlIIlll, double lllllllllllllllIIIllIlIlIIlIlIlI, double lllllllllllllllIIIllIlIlIIlIIlIl, int lllllllllllllllIIIllIlIlIIlIIlII) {
        FontUtil.drawStringWithShadow(lllllllllllllllIIIllIlIlIIlIIlll, lllllllllllllllIIIllIlIlIIlIlIlI - (double)(fontRenderer.getStringWidth(lllllllllllllllIIIllIlIlIIlIIlll) / 2), lllllllllllllllIIIllIlIlIIlIIlIl - (double)((float)fontRenderer.getHeight() / 2.0f), lllllllllllllllIIIllIlIlIIlIIlII);
    }

    public static double getStringWidth(String lllllllllllllllIIIllIlIlIllIllIl) {
        return fontRenderer.getStringWidth(StringUtils.stripControlCodes((String)lllllllllllllllIIIllIlIlIllIllIl));
    }

    public static void drawCenteredStringWithShadow(String lllllllllllllllIIIllIlIlIlIIIIll, double lllllllllllllllIIIllIlIlIIlllllI, double lllllllllllllllIIIllIlIlIlIIIIIl, int lllllllllllllllIIIllIlIlIlIIIIII) {
        FontUtil.drawStringWithShadow(lllllllllllllllIIIllIlIlIlIIIIll, lllllllllllllllIIIllIlIlIIlllllI - (double)(fontRenderer.getStringWidth(lllllllllllllllIIIllIlIlIlIIIIll) / 2), lllllllllllllllIIIllIlIlIlIIIIIl, lllllllllllllllIIIllIlIlIlIIIIII);
    }

    public static void drawTotalCenteredString(String lllllllllllllllIIIllIlIlIIllIlll, double lllllllllllllllIIIllIlIlIIllIIlI, double lllllllllllllllIIIllIlIlIIllIIIl, int lllllllllllllllIIIllIlIlIIllIIII) {
        FontUtil.drawString(lllllllllllllllIIIllIlIlIIllIlll, (int)(lllllllllllllllIIIllIlIlIIllIIlI - (double)(fontRenderer.getStringWidth(lllllllllllllllIIIllIlIlIIllIlll) / 2)), lllllllllllllllIIIllIlIlIIllIIIl - (double)(fontRenderer.getHeight() / 2), lllllllllllllllIIIllIlIlIIllIIII);
    }

    public static int getFontHeight() {
        return fontRenderer.getHeight();
    }
}

