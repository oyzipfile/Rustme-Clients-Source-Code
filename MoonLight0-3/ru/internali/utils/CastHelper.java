/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.monster.EntityGolem
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.passive.EntityAnimal
 *  net.minecraft.entity.passive.EntityVillager
 *  net.minecraft.entity.player.EntityPlayer
 */
package ru.internali.utils;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import ru.internali.utils.friend.FriendManager;

public class CastHelper {
    private final /* synthetic */ List<EntityType> casts;

    public CastHelper() {
        CastHelper lIIllIIIIlIIll;
        lIIllIIIIlIIll.casts = new ArrayList<EntityType>();
    }

    public CastHelper apply(EntityType lIIlIlllllllIl) {
        CastHelper lIIlIllllllllI;
        lIIlIllllllllI.casts.add(lIIlIlllllllIl);
        return lIIlIllllllllI;
    }

    public static EntityType isInstanceof(Entity lIIllIIIIIlIlI, EntityType ... lIIllIIIIIlIIl) {
        for (EntityType lIIllIIIIIlIll : lIIllIIIIIlIIl) {
            if (lIIllIIIIIlIlI == Minecraft.getMinecraft().player && lIIllIIIIIlIll == EntityType.SELF) {
                return lIIllIIIIIlIll;
            }
            if (lIIllIIIIIlIll == EntityType.VILLAGERS && lIIllIIIIIlIlI instanceof EntityVillager) {
                return lIIllIIIIIlIll;
            }
            if (lIIllIIIIIlIll == EntityType.FRIENDS && lIIllIIIIIlIlI instanceof EntityPlayer && FriendManager.isFriend(lIIllIIIIIlIlI.getName())) {
                return lIIllIIIIIlIll;
            }
            if (lIIllIIIIIlIll == EntityType.PLAYERS && lIIllIIIIIlIlI instanceof EntityPlayer && lIIllIIIIIlIlI != Minecraft.getMinecraft().player && !FriendManager.isFriend(lIIllIIIIIlIlI.getName())) {
                return lIIllIIIIIlIll;
            }
            if (lIIllIIIIIlIll == EntityType.MOBS && lIIllIIIIIlIlI instanceof EntityMob) {
                return lIIllIIIIIlIll;
            }
            if (lIIllIIIIIlIll != EntityType.ANIMALS || !(lIIllIIIIIlIlI instanceof EntityAnimal) && !(lIIllIIIIIlIlI instanceof EntityGolem)) continue;
            return lIIllIIIIIlIll;
        }
        return null;
    }

    public EntityType[] build() {
        CastHelper lIIlIllllllIll;
        return lIIlIllllllIll.casts.toArray((T[])new EntityType[0]);
    }

    public static enum EntityType {
        PLAYERS,
        MOBS,
        ANIMALS,
        VILLAGERS,
        FRIENDS,
        SELF;


        private EntityType() {
            EntityType lIIllIllIIIIIII;
        }
    }
}

