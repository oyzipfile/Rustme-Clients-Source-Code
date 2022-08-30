/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 */
package ru.internali.module.RUSTME;

import net.minecraft.entity.Entity;
import ru.internali.module.RUSTME.IEventCancelable;
import ru.internali.utils.Event;

public class EventRenderModelEntity
extends Event
implements IEventCancelable {
    private /* synthetic */ Type type;
    private /* synthetic */ boolean canceled;
    private /* synthetic */ Entity entity;

    public Type getType() {
        EventRenderModelEntity llIlllIIllllI;
        return llIlllIIllllI.type;
    }

    public Entity getEntity() {
        EventRenderModelEntity llIlllIIllIll;
        return llIlllIIllIll.entity;
    }

    public void setEntity(Entity llIlllIIlIlll) {
        llIlllIIllIII.entity = llIlllIIlIlll;
    }

    @Override
    public void setCanceled() {
        llIlllIIlIIlI.canceled = true;
    }

    @Override
    public boolean isCanceled() {
        EventRenderModelEntity llIlllIIlIIII;
        return llIlllIIlIIII.canceled;
    }

    public EventRenderModelEntity(Entity llIlllIlIIIlI, Type llIlllIlIIIIl) {
        EventRenderModelEntity llIlllIlIIllI;
        llIlllIlIIllI.entity = llIlllIlIIIlI;
        llIlllIlIIllI.type = llIlllIlIIIIl;
    }

    public static enum Type {
        PRE,
        POST;


        private Type() {
            Type lllIllIIIlIIIIl;
        }
    }
}

