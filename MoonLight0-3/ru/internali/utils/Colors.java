/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils;

import java.awt.Color;

public class Colors {
    public static int getColor(int lllIlllIlIIIIlI) {
        return Colors.getColor(lllIlllIlIIIIlI, lllIlllIlIIIIlI, lllIlllIlIIIIlI, 255);
    }

    public static int getColor(int lllIlllIIllIlll, int lllIlllIIllIllI, int lllIlllIIllIIlI) {
        return Colors.getColor(lllIlllIIllIlll, lllIlllIIllIllI, lllIlllIIllIIlI, 255);
    }

    public static int getColor(int lllIlllIIlIllII, int lllIlllIIlIIllI, int lllIlllIIlIlIlI, int lllIlllIIlIlIIl) {
        int lllIlllIIlIlIII = 0;
        lllIlllIIlIlIII |= lllIlllIIlIlIIl << 24;
        lllIlllIIlIlIII |= lllIlllIIlIllII << 16;
        lllIlllIIlIlIII |= lllIlllIIlIIllI << 8;
        return lllIlllIIlIlIII |= lllIlllIIlIlIlI;
    }

    public Colors() {
        Colors lllIlllIlIIIlll;
    }

    public static int getColor(int lllIlllIIlllllI, int lllIlllIIllllIl) {
        return Colors.getColor(lllIlllIIlllllI, lllIlllIIlllllI, lllIlllIIlllllI, lllIlllIIllllIl);
    }

    public static int getColor(Color lllIlllIlIIIlIl) {
        return Colors.getColor(lllIlllIlIIIlIl.getRed(), lllIlllIlIIIlIl.getGreen(), lllIlllIlIIIlIl.getBlue(), lllIlllIlIIIlIl.getAlpha());
    }
}

