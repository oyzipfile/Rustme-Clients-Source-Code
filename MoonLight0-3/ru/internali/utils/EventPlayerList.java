/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketPlayerListItem$Action
 *  net.minecraft.network.play.server.SPacketPlayerListItem$AddPlayerData
 */
package ru.internali.utils;

import net.minecraft.network.play.server.SPacketPlayerListItem;
import ru.internali.utils.Event;

public class EventPlayerList
extends Event {
    private static /* synthetic */ SPacketPlayerListItem.Action action;
    private static /* synthetic */ SPacketPlayerListItem.AddPlayerData data;

    public static SPacketPlayerListItem.AddPlayerData getData() {
        return data;
    }

    public static SPacketPlayerListItem.Action getAction() {
        return action;
    }

    public EventPlayerList(SPacketPlayerListItem.Action lIIIlIIIIllIllI, SPacketPlayerListItem.AddPlayerData lIIIlIIIIlllIII) {
        EventPlayerList lIIIlIIIIlllIlI;
        action = lIIIlIIIIllIllI;
        data = lIIIlIIIIlllIII;
    }
}

