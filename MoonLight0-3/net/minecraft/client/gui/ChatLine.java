/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.text.ITextComponent
 */
package net.minecraft.client.gui;

import net.minecraft.util.text.ITextComponent;

public class ChatLine {
    private final int updateCounterCreated;
    private final ITextComponent lineString;
    private final int chatLineID;

    public ChatLine(int n, ITextComponent iTextComponent, int n2) {
        this.lineString = iTextComponent;
        this.updateCounterCreated = n;
        this.chatLineID = n2;
    }

    public ITextComponent getChatComponent() {
        return this.lineString;
    }

    public int getUpdatedCounter() {
        return this.updateCounterCreated;
    }

    public int getChatLineID() {
        return this.chatLineID;
    }
}

