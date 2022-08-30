/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraftforge.event.entity.player.AttackEntityEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package ru.internali.module.render;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;

public class HitParticles
extends Module {
    private final /* synthetic */ Random random;
    public static /* synthetic */ List<String> Modes;

    static {
        Modes = new ArrayList<String>();
    }

    public HitParticles() {
        super("HitParticles", "HitParticles", Category.RENDER);
        HitParticles lIIlllIlIIIIll;
        lIIlllIlIIIIll.random = new Random();
        Modes.add("Redstone");
        Modes.add("Heart");
        Modes.add("Flame");
        Modes.add("Cloud");
        Modes.add("HappyVillager");
        Modes.add("AngryVillager");
        Modes.add("Spell");
        Modes.add("Portal");
        Modes.add("Enchant");
        Modes.add("Criticals");
        CatClient.instance.settingsManager.rSetting(new Setting("Mode", lIIlllIlIIIIll, "Redstone", (ArrayList)Modes));
        CatClient.instance.settingsManager.rSetting(new Setting("particleMultiplier", lIIlllIlIIIIll, 5.0, 1.0, 15.0, false));
    }

    @SubscribeEvent
    public void onAttack(AttackEntityEvent lIIlllIIIIlIlI) {
        block19: {
            float lIIlllIIIIlIII;
            String lIIlllIIIIlIIl;
            block27: {
                block26: {
                    HitParticles lIIlllIIIIlIll;
                    block25: {
                        block24: {
                            block23: {
                                block22: {
                                    block21: {
                                        block20: {
                                            block18: {
                                                lIIlllIIIIlIIl = CatClient.instance.settingsManager.getSettingByName(lIIlllIIIIlIll, "Mode").getValString();
                                                lIIlllIIIIlIII = (float)CatClient.instance.settingsManager.getSettingByName(lIIlllIIIIlIll, "particleMultiplier").getValDouble();
                                                if (!lIIlllIIIIlIIl.equalsIgnoreCase("Redstone")) break block18;
                                                for (float lIIlllIIIlllII = 0.0f; lIIlllIIIlllII < lIIlllIIIIlIlI.getTarget().height; lIIlllIIIlllII += 0.2f) {
                                                    int lIIlllIIIlllIl = 0;
                                                    while ((float)lIIlllIIIlllIl < lIIlllIIIIlIII) {
                                                        HitParticles.mc.effectRenderer.spawnEffectParticle(37, lIIlllIIIIlIlI.getTarget().posX, lIIlllIIIIlIlI.getTarget().posY + (double)lIIlllIIIlllII, lIIlllIIIIlIlI.getTarget().posZ, (double)((float)(lIIlllIIIIlIll.random.nextInt(6) - 3) / 5.0f), 0.1, (double)((float)(lIIlllIIIIlIll.random.nextInt(6) - 3) / 5.0f), new int[]{Block.getIdFromBlock((Block)Blocks.REDSTONE_BLOCK)});
                                                        ++lIIlllIIIlllIl;
                                                    }
                                                }
                                                break block19;
                                            }
                                            if (!lIIlllIIIIlIIl.equalsIgnoreCase("Heart")) break block20;
                                            for (float lIIlllIIIllIlI = 0.0f; lIIlllIIIllIlI < lIIlllIIIIlIlI.getTarget().height; lIIlllIIIllIlI += 0.2f) {
                                                int lIIlllIIIllIll = 0;
                                                while ((float)lIIlllIIIllIll < lIIlllIIIIlIII) {
                                                    HitParticles.mc.world.func_175688_a(EnumParticleTypes.HEART, lIIlllIIIIlIlI.getTarget().posX, lIIlllIIIIlIlI.getTarget().posY + (double)lIIlllIIIllIlI, lIIlllIIIIlIlI.getTarget().posZ, (double)((float)(lIIlllIIIIlIll.random.nextInt(6) - 3) / 5.0f), 0.1, (double)((float)(lIIlllIIIIlIll.random.nextInt(6) - 3) / 5.0f), new int[0]);
                                                    ++lIIlllIIIllIll;
                                                }
                                            }
                                            break block19;
                                        }
                                        if (!lIIlllIIIIlIIl.equalsIgnoreCase("Flame")) break block21;
                                        for (float lIIlllIIIllIII = 0.0f; lIIlllIIIllIII < lIIlllIIIIlIlI.getTarget().height; lIIlllIIIllIII += 0.2f) {
                                            int lIIlllIIIllIIl = 0;
                                            while ((float)lIIlllIIIllIIl < lIIlllIIIIlIII) {
                                                HitParticles.mc.world.func_175688_a(EnumParticleTypes.FLAME, lIIlllIIIIlIlI.getTarget().posX, lIIlllIIIIlIlI.getTarget().posY + (double)lIIlllIIIllIII, lIIlllIIIIlIlI.getTarget().posZ, (double)((float)(lIIlllIIIIlIll.random.nextInt(6) - 3) / 5.0f), 0.1, (double)((float)(lIIlllIIIIlIll.random.nextInt(6) - 3) / 5.0f), new int[0]);
                                                ++lIIlllIIIllIIl;
                                            }
                                        }
                                        break block19;
                                    }
                                    if (!lIIlllIIIIlIIl.equalsIgnoreCase("Cloud")) break block22;
                                    for (float lIIlllIIIlIllI = 0.0f; lIIlllIIIlIllI < lIIlllIIIIlIlI.getTarget().height; lIIlllIIIlIllI += 0.2f) {
                                        int lIIlllIIIlIlll = 0;
                                        while ((float)lIIlllIIIlIlll < lIIlllIIIIlIII) {
                                            HitParticles.mc.world.func_175688_a(EnumParticleTypes.CLOUD, lIIlllIIIIlIlI.getTarget().posX, lIIlllIIIIlIlI.getTarget().posY + (double)lIIlllIIIlIllI, lIIlllIIIIlIlI.getTarget().posZ, (double)((float)(lIIlllIIIIlIll.random.nextInt(6) - 3) / 5.0f), 0.1, (double)((float)(lIIlllIIIIlIll.random.nextInt(6) - 3) / 5.0f), new int[0]);
                                            ++lIIlllIIIlIlll;
                                        }
                                    }
                                    break block19;
                                }
                                if (!lIIlllIIIIlIIl.equalsIgnoreCase("HappyVillager")) break block23;
                                for (float lIIlllIIIlIlII = 0.0f; lIIlllIIIlIlII < lIIlllIIIIlIlI.getTarget().height; lIIlllIIIlIlII += 0.2f) {
                                    int lIIlllIIIlIlIl = 0;
                                    while ((float)lIIlllIIIlIlIl < lIIlllIIIIlIII) {
                                        HitParticles.mc.world.func_175688_a(EnumParticleTypes.VILLAGER_HAPPY, lIIlllIIIIlIlI.getTarget().posX, lIIlllIIIIlIlI.getTarget().posY + (double)lIIlllIIIlIlII, lIIlllIIIIlIlI.getTarget().posZ, (double)((float)(lIIlllIIIIlIll.random.nextInt(6) - 3) / 5.0f), 0.1, (double)((float)(lIIlllIIIIlIll.random.nextInt(6) - 3) / 5.0f), new int[0]);
                                        ++lIIlllIIIlIlIl;
                                    }
                                }
                                break block19;
                            }
                            if (!lIIlllIIIIlIIl.equalsIgnoreCase("AngryVillager")) break block24;
                            for (float lIIlllIIIlIIlI = 0.0f; lIIlllIIIlIIlI < lIIlllIIIIlIlI.getTarget().height; lIIlllIIIlIIlI += 0.2f) {
                                int lIIlllIIIlIIll = 0;
                                while ((float)lIIlllIIIlIIll < lIIlllIIIIlIII) {
                                    HitParticles.mc.world.func_175688_a(EnumParticleTypes.VILLAGER_ANGRY, lIIlllIIIIlIlI.getTarget().posX, lIIlllIIIIlIlI.getTarget().posY + (double)lIIlllIIIlIIlI, lIIlllIIIIlIlI.getTarget().posZ, (double)((float)(lIIlllIIIIlIll.random.nextInt(6) - 3) / 5.0f), 0.1, (double)((float)(lIIlllIIIIlIll.random.nextInt(6) - 3) / 5.0f), new int[0]);
                                    ++lIIlllIIIlIIll;
                                }
                            }
                            break block19;
                        }
                        if (!lIIlllIIIIlIIl.equalsIgnoreCase("Spell")) break block25;
                        for (float lIIlllIIIlIIII = 0.0f; lIIlllIIIlIIII < lIIlllIIIIlIlI.getTarget().height; lIIlllIIIlIIII += 0.2f) {
                            int lIIlllIIIlIIIl = 0;
                            while ((float)lIIlllIIIlIIIl < lIIlllIIIIlIII) {
                                HitParticles.mc.world.func_175688_a(EnumParticleTypes.SPELL_WITCH, lIIlllIIIIlIlI.getTarget().posX, lIIlllIIIIlIlI.getTarget().posY + (double)lIIlllIIIlIIII, lIIlllIIIIlIlI.getTarget().posZ, (double)((float)(lIIlllIIIIlIll.random.nextInt(6) - 3) / 5.0f), 0.1, (double)((float)(lIIlllIIIIlIll.random.nextInt(6) - 3) / 5.0f), new int[0]);
                                ++lIIlllIIIlIIIl;
                            }
                        }
                        break block19;
                    }
                    if (!lIIlllIIIIlIIl.equalsIgnoreCase("Portal")) break block26;
                    for (float lIIlllIIIIlllI = 0.0f; lIIlllIIIIlllI < lIIlllIIIIlIlI.getTarget().height; lIIlllIIIIlllI += 0.2f) {
                        int lIIlllIIIIllll = 0;
                        while ((float)lIIlllIIIIllll < lIIlllIIIIlIII) {
                            HitParticles.mc.world.func_175688_a(EnumParticleTypes.PORTAL, lIIlllIIIIlIlI.getTarget().posX, lIIlllIIIIlIlI.getTarget().posY + (double)lIIlllIIIIlllI, lIIlllIIIIlIlI.getTarget().posZ, (double)((float)(lIIlllIIIIlIll.random.nextInt(6) - 3) / 5.0f), 0.1, (double)((float)(lIIlllIIIIlIll.random.nextInt(6) - 3) / 5.0f), new int[0]);
                            ++lIIlllIIIIllll;
                        }
                    }
                    break block19;
                }
                if (!lIIlllIIIIlIIl.equalsIgnoreCase("Enchant")) break block27;
                int lIIlllIIIIllIl = 0;
                while ((float)lIIlllIIIIllIl < lIIlllIIIIlIII) {
                    HitParticles.mc.player.onEnchantmentCritical(lIIlllIIIIlIlI.getTarget());
                    ++lIIlllIIIIllIl;
                }
                break block19;
            }
            if (!lIIlllIIIIlIIl.equalsIgnoreCase("Criticals")) break block19;
            int lIIlllIIIIllII = 0;
            while ((float)lIIlllIIIIllII < lIIlllIIIIlIII) {
                HitParticles.mc.player.onCriticalHit(lIIlllIIIIlIlI.getTarget());
                ++lIIlllIIIIllII;
            }
        }
    }
}

