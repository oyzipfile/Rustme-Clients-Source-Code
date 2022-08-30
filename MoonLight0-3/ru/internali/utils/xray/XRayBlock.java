/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.BlockPos
 */
package ru.internali.utils.xray;

import net.minecraft.util.math.BlockPos;
import ru.internali.utils.xray.XRayData;

public class XRayBlock {
    private /* synthetic */ XRayData xRayData;
    private /* synthetic */ BlockPos blockPos;

    public XRayData getxRayData() {
        XRayBlock llllllIllIlIIlI;
        return llllllIllIlIIlI.xRayData;
    }

    public XRayBlock(BlockPos llllllIllIllIIl, XRayData llllllIllIllIII) {
        XRayBlock llllllIllIlllIl;
        llllllIllIlllIl.blockPos = llllllIllIllIIl;
        llllllIllIlllIl.xRayData = llllllIllIllIII;
    }

    public BlockPos getBlockPos() {
        XRayBlock llllllIllIlIlIl;
        return llllllIllIlIlIl.blockPos;
    }
}

