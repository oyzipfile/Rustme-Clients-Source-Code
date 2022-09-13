/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.ResourceLocation
 */
package ru.hld.legendline.api.font;

import java.awt.Font;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import ru.hld.legendline.api.utils.CFontRenderer;
import ru.hld.legendline.api.utils.Fonts;

public final class FontUtils {
    public static /* synthetic */ CFontRenderer fr;

    public static Font getFontFromTTF(ResourceLocation llllllllllllllIllIIIIIIllIIlIIll, float llllllllllllllIllIIIIIIllIIIllll, int llllllllllllllIllIIIIIIllIIIlllI) {
        try {
            Font llllllllllllllIllIIIIIIllIIlIlIl = Font.createFont(llllllllllllllIllIIIIIIllIIIlllI, Minecraft.getMinecraft().getResourceManager().getResource(llllllllllllllIllIIIIIIllIIlIIll).getInputStream());
            llllllllllllllIllIIIIIIllIIlIlIl = llllllllllllllIllIIIIIIllIIlIlIl.deriveFont(llllllllllllllIllIIIIIIllIIIllll);
            return llllllllllllllIllIIIIIIllIIlIlIl;
        }
        catch (Exception llllllllllllllIllIIIIIIllIIlIlII) {
            return null;
        }
    }

    static {
        fr = Fonts.mntsb_20;
    }

    public FontUtils() {
        FontUtils llllllllllllllIllIIIIIIllIIllIlI;
    }
}

