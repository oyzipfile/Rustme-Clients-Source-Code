/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityLivingBase
 */
package ru.internali.utils;

import net.minecraft.entity.EntityLivingBase;
import ru.internali.utils.Event;

public class EventNameTag
extends Event {
    private /* synthetic */ String renderedName;
    private final /* synthetic */ EntityLivingBase entity;

    public EntityLivingBase getEntity() {
        EventNameTag llIllllIIllIIl;
        return llIllllIIllIIl.entity;
    }

    public EventNameTag(EntityLivingBase llIllllIIlllIl, String llIllllIIlllII) {
        EventNameTag llIllllIlIIIIl;
        llIllllIlIIIIl.entity = llIllllIIlllIl;
    }

    public static void setRenderedName(String llIllllIIlIIll) {
    }

    public String getRenderedName() {
        EventNameTag llIllllIIlIlll;
        return llIllllIIlIlll.renderedName;
    }
}

