/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.ResourceLocation
 */
package ru.hld.legendline.api.utils;

import java.awt.Font;
import java.io.InputStream;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import ru.hld.legendline.api.utils.CFontRenderer;

public class Fonts {
    public static /* synthetic */ CFontRenderer iconnewex_30;
    public static /* synthetic */ CFontRenderer mntsb_25;
    public static /* synthetic */ CFontRenderer mntsb_21;
    public static /* synthetic */ CFontRenderer iconswex_36;
    public static /* synthetic */ CFontRenderer iconnewex_50;
    public static /* synthetic */ CFontRenderer iconswex_40;
    public static /* synthetic */ CFontRenderer iconnewex_60;
    public static /* synthetic */ CFontRenderer mntsb_16;
    public static /* synthetic */ CFontRenderer iconnewex_80;
    public static /* synthetic */ CFontRenderer mntsb_20;
    public static /* synthetic */ CFontRenderer mntsb_18;
    public static /* synthetic */ CFontRenderer iconswex_30;

    static {
        mntsb_16 = new CFontRenderer(Fonts.getFontTTF("aboba", 16), true, true);
        mntsb_18 = new CFontRenderer(Fonts.getFontTTF("aboba", 18), true, true);
        mntsb_20 = new CFontRenderer(Fonts.getFontTTF("aboba", 20), true, true);
        mntsb_21 = new CFontRenderer(Fonts.getFontTTF("aboba", 21), true, true);
        mntsb_25 = new CFontRenderer(Fonts.getFontTTF("aboba", 25), true, true);
        iconswex_30 = new CFontRenderer(Fonts.getFontTTF("wex", 30), true, true);
        iconswex_36 = new CFontRenderer(Fonts.getFontTTF("wex", 36), true, true);
        iconswex_40 = new CFontRenderer(Fonts.getFontTTF("wex", 40), true, true);
        iconnewex_30 = new CFontRenderer(Fonts.getFontTTF("negrfont", 30), true, true);
        iconnewex_50 = new CFontRenderer(Fonts.getFontTTF("negrfont", 50), true, true);
        iconnewex_60 = new CFontRenderer(Fonts.getFontTTF("negrfont", 60), true, true);
        iconnewex_80 = new CFontRenderer(Fonts.getFontTTF("negrfont", 80), true, true);
    }

    public Fonts() {
        Fonts llllllllllllllIIIIllIIllIIIllIll;
    }

    public static float blob(String llllllllllllllIIIIllIIllIIIIlIlI, int llllllllllllllIIIIllIIllIIIlIIIl, String llllllllllllllIIIIllIIllIIIlIIII, float llllllllllllllIIIIllIIllIIIIIlll, float llllllllllllllIIIIllIIllIIIIIllI, int llllllllllllllIIIIllIIllIIIIIlIl, boolean llllllllllllllIIIIllIIllIIIIllII) {
        CFontRenderer llllllllllllllIIIIllIIllIIIIlIll = new CFontRenderer(Fonts.getFontTTF(llllllllllllllIIIIllIIllIIIIlIlI, llllllllllllllIIIIllIIllIIIlIIIl), true, true);
        return llllllllllllllIIIIllIIllIIIIlIll.drawString(llllllllllllllIIIIllIIllIIIlIIII, llllllllllllllIIIIllIIllIIIIIlll, llllllllllllllIIIIllIIllIIIIIllI, llllllllllllllIIIIllIIllIIIIIlIl, llllllllllllllIIIIllIIllIIIIllII);
    }

    public static Font getFontTTF(String llllllllllllllIIIIllIIlIlllllIll, int llllllllllllllIIIIllIIlIllllIlll) {
        Font llllllllllllllIIIIllIIlIlllllIIl;
        try {
            InputStream llllllllllllllIIIIllIIlIlllllllI = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation(String.valueOf(new StringBuilder().append("fonts/").append(llllllllllllllIIIIllIIlIlllllIll).append(".ttf")))).getInputStream();
            Font llllllllllllllIIIIllIIlIllllllIl = Font.createFont(0, llllllllllllllIIIIllIIlIlllllllI);
            llllllllllllllIIIIllIIlIllllllIl = llllllllllllllIIIIllIIlIllllllIl.deriveFont(0, llllllllllllllIIIIllIIlIllllIlll);
        }
        catch (Exception llllllllllllllIIIIllIIlIllllllII) {
            System.out.println("Error loading font");
            llllllllllllllIIIIllIIlIlllllIIl = new Font("default", 0, llllllllllllllIIIIllIIlIllllIlll);
        }
        return llllllllllllllIIIIllIIlIlllllIIl;
    }
}

