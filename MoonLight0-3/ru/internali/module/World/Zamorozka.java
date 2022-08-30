/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.math.BlockPos
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package ru.internali.module.World;

import net.minecraft.init.Blocks;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.internali.module.Category;
import ru.internali.module.Module;

public class Zamorozka
extends Module {
    @SubscribeEvent
    public void onRenderWorld(RenderWorldLastEvent lIlllIIIlllIlIl) {
        for (int lIlllIIIlllIlll = 1; lIlllIIIlllIlll < 8; ++lIlllIIIlllIlll) {
            Zamorozka.mc.world.func_175688_a(EnumParticleTypes.SPIT, Zamorozka.mc.player.field_70165_t + Math.sin(lIlllIIIlllIlll) * 0.6, Zamorozka.mc.player.field_70163_u + 0.2, Zamorozka.mc.player.field_70161_v + Math.cos(lIlllIIIlllIlll) * 0.3, 0.0, 0.0, 0.0, new int[0]);
            Zamorozka.mc.world.func_180501_a(new BlockPos(Zamorozka.mc.player.field_70165_t, Zamorozka.mc.player.field_70163_u - 1.0, Zamorozka.mc.player.field_70161_v), Blocks.SNOW.getDefaultState(), 2);
            Zamorozka.mc.world.func_180501_a(new BlockPos(Zamorozka.mc.player.field_70165_t + 1.0, Zamorozka.mc.player.field_70163_u - 1.0, Zamorozka.mc.player.field_70161_v), Blocks.ICE.getDefaultState(), 5);
        }
    }

    public Zamorozka() {
        super("Zamorozka", "Zamorozka", Category.WORLD);
        Zamorozka lIlllIIIllllIlI;
    }
}

