/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.math.BlockPos
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package ru.internali.module.render;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.module.render.BlockUtils;
import ru.internali.settings.Setting;
import ru.internali.utils.NordTessellator;

public class Xray
extends Module {
    private /* synthetic */ long max;
    private /* synthetic */ BlockPos current;
    private /* synthetic */ List<BlockPos> blocks;
    public static /* synthetic */ List<String> Modes;
    private final /* synthetic */ List<BlockPos> DETECTED_BLOCKS;

    static {
        Modes = new ArrayList<String>();
    }

    public Xray() {
        super("Xray", "Xray", Category.RENDER);
        Xray lIlIlllIIIIIIll;
        lIlIlllIIIIIIll.blocks = new ArrayList<BlockPos>();
        lIlIlllIIIIIIll.DETECTED_BLOCKS = new ArrayList<BlockPos>();
        Modes.add("RustMe");
        CatClient.instance.settingsManager.rSetting(new Setting("Mode", lIlIlllIIIIIIll, "RustMe", (ArrayList)Modes));
        CatClient.instance.settingsManager.rSetting(new Setting("Range", lIlIlllIIIIIIll, 15.0, 5.0, 75.0, false));
    }

    private boolean RustmeBlock(Block lIlIllIlllIllIl) {
        return lIlIllIlllIllIl == Blocks.STAINED_HARDENED_CLAY;
    }

    @SubscribeEvent
    public void onRenderWorld(RenderWorldLastEvent lIlIllIlllllIII) {
        Xray lIlIllIlllllIIl;
        String lIlIllIllllIlll = CatClient.instance.settingsManager.getSettingByName(lIlIllIlllllIIl, "Mode").getValString();
        float lIlIllIllllIllI = (float)CatClient.instance.settingsManager.getSettingByName(lIlIllIlllllIIl, "Range").getValDouble();
        if (Objects.equals(lIlIllIllllIlll, "RustMe")) {
            for (BlockPos lIlIllIlllllIlI : BlockUtils.getBlocksInDistance(lIlIllIllllIllI)) {
                Block lIlIllIlllllIll = Xray.mc.world.func_180495_p(lIlIllIlllllIlI).getBlock();
                if (!lIlIllIlllllIIl.RustmeBlock(lIlIllIlllllIll)) continue;
                NordTessellator.drawBoundingBoxChestBlockPos(lIlIllIlllllIlI, 1.0f, 255, 150, 60, 255);
            }
        }
    }
}

