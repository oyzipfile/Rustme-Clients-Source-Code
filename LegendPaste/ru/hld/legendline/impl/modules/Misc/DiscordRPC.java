/*
 * Decompiled with CFR 0.150.
 */
package ru.hld.legendline.impl.modules.Misc;

import ru.hld.legendline.api.RPC;
import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.module.Module;

public class DiscordRPC
extends Module {
    @Override
    public void onDisable() {
        DiscordRPC lllllllllllllllIlllIIlIIIlIlIIll;
        super.onDisable();
        RPC.stopRPC();
    }

    public DiscordRPC() {
        super("DiscordRPC", "shows in the discord that you are playing with the Ricardo Client", Category.Misc);
        DiscordRPC lllllllllllllllIlllIIlIIIlIllIIl;
    }

    @Override
    public void onEnable() {
        DiscordRPC lllllllllllllllIlllIIlIIIlIlIllI;
        super.onEnable();
        RPC.startRPC();
    }
}

