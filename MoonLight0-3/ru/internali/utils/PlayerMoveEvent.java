/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.eventhandler.Event
 */
package ru.internali.utils;

import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

@Cancelable
public class PlayerMoveEvent
extends Event {
    public static /* synthetic */ double x;
    public static /* synthetic */ double z;
    public /* synthetic */ double y;

    public PlayerMoveEvent(double lllllllIIllIIII, double lllllllIIlIllll, double lllllllIIllIIlI) {
        PlayerMoveEvent lllllllIIllIIIl;
        x = lllllllIIllIIII;
        lllllllIIllIIIl.y = lllllllIIlIllll;
        z = lllllllIIllIIlI;
    }
}

