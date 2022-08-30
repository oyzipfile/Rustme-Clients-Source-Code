/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.entity.Entity
 */
package ru.internali.utils;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import ru.internali.utils.EventStage;

@Cancelable
public class RenderEntityModelEvent
extends EventStage {
    public /* synthetic */ Entity entity;
    public /* synthetic */ float scale;
    public /* synthetic */ ModelBase modelBase;
    public /* synthetic */ float limbSwingAmount;
    public /* synthetic */ float headYaw;
    public /* synthetic */ float limbSwing;
    public /* synthetic */ float age;
    public /* synthetic */ float headPitch;

    public RenderEntityModelEvent(int lllIllllllllIIl, ModelBase llllIIIIIIIIIlI, Entity llllIIIIIIIIIIl, float lllIlllllllIllI, float lllIlllllllIlIl, float lllIllllllllllI, float lllIlllllllllIl, float lllIlllllllIIlI, float lllIllllllllIll) {
        super(lllIllllllllIIl);
        RenderEntityModelEvent lllIllllllllIlI;
        lllIllllllllIlI.modelBase = llllIIIIIIIIIlI;
        lllIllllllllIlI.entity = llllIIIIIIIIIIl;
        lllIllllllllIlI.limbSwing = lllIlllllllIllI;
        lllIllllllllIlI.limbSwingAmount = lllIlllllllIlIl;
        lllIllllllllIlI.age = lllIllllllllllI;
        lllIllllllllIlI.headYaw = lllIlllllllllIl;
        lllIllllllllIlI.headPitch = lllIlllllllIIlI;
        lllIllllllllIlI.scale = lllIllllllllIll;
    }
}

