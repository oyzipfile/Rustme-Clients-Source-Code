/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 */
package ru.internali.utils;

import net.minecraft.entity.Entity;
import ru.internali.utils.EventCancellable;

public class EventAttackPacket
extends EventCancellable {
    private final /* synthetic */ Entity targetEntity;

    @Override
    public boolean cancel() {
        return false;
    }

    public Entity getTargetEntity() {
        EventAttackPacket lIIlIlIIIIlIlIl;
        return lIIlIlIIIIlIlIl.targetEntity;
    }

    public EventAttackPacket(Entity lIIlIlIIIIllIIl) {
        EventAttackPacket lIIlIlIIIIllIII;
        lIIlIlIIIIllIII.targetEntity = lIIlIlIIIIllIIl;
    }
}

