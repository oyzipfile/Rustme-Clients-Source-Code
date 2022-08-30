/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 */
package ru.internali.utils;

import net.minecraft.item.ItemStack;
import ru.internali.utils.Event;

public class RenderToolTipEvent
extends Event {
    private /* synthetic */ int y;
    private /* synthetic */ int x;
    private /* synthetic */ ItemStack stack;

    public int getY() {
        RenderToolTipEvent llIIllllIllIIlI;
        return llIIllllIllIIlI.y;
    }

    public int getX() {
        RenderToolTipEvent llIIllllIllIlIl;
        return llIIllllIllIlIl.x;
    }

    public ItemStack getStack() {
        RenderToolTipEvent llIIllllIlIllll;
        return llIIllllIlIllll.stack;
    }

    public RenderToolTipEvent(ItemStack llIIllllIlllIlI, int llIIllllIllllIl, int llIIllllIllllII) {
        RenderToolTipEvent llIIllllIllllll;
        llIIllllIllllll.stack = llIIllllIlllIlI;
        llIIllllIllllll.x = llIIllllIllllIl;
        llIIllllIllllll.y = llIIllllIllllII;
    }
}

