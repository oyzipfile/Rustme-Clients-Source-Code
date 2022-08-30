/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package ru.internali.module.misc;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import ru.internali.module.Category;
import ru.internali.module.Module;

public class AntiInvis
extends Module {
    private final /* synthetic */ List<Entity> e;

    @SubscribeEvent
    public void OnPlayerTick(TickEvent.PlayerTickEvent llIlllIllIllIl) {
        for (Entity llIlllIllIllll : AntiInvis.mc.world.field_72996_f) {
            AntiInvis llIlllIllIllII;
            if (!llIlllIllIllll.isInvisible() || !(llIlllIllIllll instanceof EntityPlayer)) continue;
            llIlllIllIllll.setInvisible(false);
            llIlllIllIllII.e.add(llIlllIllIllll);
        }
    }

    @Override
    public void onEnable() {
        AntiInvis llIlllIlllIlIl;
        for (Entity llIlllIlllIlll : llIlllIlllIlIl.e) {
            llIlllIlllIlll.setInvisible(true);
        }
        llIlllIlllIlIl.e.clear();
        super.onEnable();
    }

    public AntiInvis() {
        super("AntiInvis", "AntiInvis", Category.OUTHER);
        AntiInvis llIlllIllllIll;
        llIlllIllllIll.e = new ArrayList<Entity>();
    }
}

