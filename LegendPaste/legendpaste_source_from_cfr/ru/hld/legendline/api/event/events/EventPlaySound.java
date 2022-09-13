/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.SoundCategory
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.BlockPos
 */
package ru.hld.legendline.api.event.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import ru.hld.legendline.api.event.Event;

public class EventPlaySound
extends Event {
    /* synthetic */ SoundCategory category;
    /* synthetic */ EntityPlayer player;
    /* synthetic */ float pitch;
    /* synthetic */ BlockPos pos;
    /* synthetic */ float volume;
    /* synthetic */ SoundEvent soundIn;

    public float getPitch() {
        EventPlaySound llllllllllllllIIIllllIlIIIIlIllI;
        return llllllllllllllIIIllllIlIIIIlIllI.pitch;
    }

    public float getVolume() {
        EventPlaySound llllllllllllllIIIllllIlIIIIIllll;
        return llllllllllllllIIIllllIlIIIIIllll.volume;
    }

    public BlockPos getPos() {
        EventPlaySound llllllllllllllIIIllllIlIIIIllIIl;
        return llllllllllllllIIIllllIlIIIIllIIl.pos;
    }

    public EntityPlayer getPlayer() {
        EventPlaySound llllllllllllllIIIllllIlIIIIlIIll;
        return llllllllllllllIIIllllIlIIIIlIIll.player;
    }

    public SoundEvent getSoundIn() {
        EventPlaySound llllllllllllllIIIllllIlIIIIIlIlI;
        return llllllllllllllIIIllllIlIIIIIlIlI.soundIn;
    }

    public SoundCategory getCategory() {
        EventPlaySound llllllllllllllIIIllllIlIIIIIllII;
        return llllllllllllllIIIllllIlIIIIIllII.category;
    }

    public EventPlaySound(EntityPlayer llllllllllllllIIIllllIlIIIlIIIII, BlockPos llllllllllllllIIIllllIlIIIlIIllI, SoundEvent llllllllllllllIIIllllIlIIIlIIlIl, SoundCategory llllllllllllllIIIllllIlIIIlIIlII, float llllllllllllllIIIllllIlIIIIlllII, float llllllllllllllIIIllllIlIIIIllIll) {
        EventPlaySound llllllllllllllIIIllllIlIIIlIlIII;
        llllllllllllllIIIllllIlIIIlIlIII.player = llllllllllllllIIIllllIlIIIlIIIII;
        llllllllllllllIIIllllIlIIIlIlIII.pos = llllllllllllllIIIllllIlIIIlIIllI;
        llllllllllllllIIIllllIlIIIlIlIII.soundIn = llllllllllllllIIIllllIlIIIlIIlIl;
        llllllllllllllIIIllllIlIIIlIlIII.category = llllllllllllllIIIllllIlIIIlIIlII;
        llllllllllllllIIIllllIlIIIlIlIII.volume = llllllllllllllIIIllllIlIIIIlllII;
        llllllllllllllIIIllllIlIIIlIlIII.pitch = llllllllllllllIIIllllIlIIIIllIll;
    }
}

