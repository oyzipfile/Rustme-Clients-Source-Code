/*
 * Decompiled with CFR 0.150.
 */
package ru.hld.legendline.impl.modules.Config;

import ru.hld.legendline.Client;
import ru.hld.legendline.api.event.EventTarget;
import ru.hld.legendline.api.event.events.EventUpdate;
import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.impl.modules.Render.ClickGui;
import ru.hld.legendline.impl.modules.Render.Freecam;

public class Panic
extends Module {
    public Panic() {
        super("Panic", "Ghosted client", Category.Config);
        Panic lllllllllllllllllIllIlIlllIlIlIl;
    }

    @Override
    public void onEnable() {
        Panic lllllllllllllllllIllIlIlllIIlIlI;
        lllllllllllllllllIllIlIlllIIlIlI.toggle();
        for (Module lllllllllllllllllIllIlIlllIIllll : Client.moduleManager.getModules(Category.Render)) {
            if (!(lllllllllllllllllIllIlIlllIIllll instanceof ClickGui) && !(lllllllllllllllllIllIlIlllIIllll instanceof Freecam)) continue;
            lllllllllllllllllIllIlIlllIIllll.setEnabled(lllllllllllllllllIllIlIlllIIlIlI.isEnabled());
        }
        for (Module lllllllllllllllllIllIlIlllIIlllI : Client.moduleManager.getModules(Category.Combat)) {
            lllllllllllllllllIllIlIlllIIlllI.setEnabled(lllllllllllllllllIllIlIlllIIlIlI.isEnabled());
        }
        for (Module lllllllllllllllllIllIlIlllIIllIl : Client.moduleManager.getModules(Category.Misc)) {
            lllllllllllllllllIllIlIlllIIllIl.setEnabled(lllllllllllllllllIllIlIlllIIlIlI.isEnabled());
        }
        for (Module lllllllllllllllllIllIlIlllIIllII : Client.moduleManager.getModules(Category.Movement)) {
            lllllllllllllllllIllIlIlllIIllII.setEnabled(lllllllllllllllllIllIlIlllIIlIlI.isEnabled());
        }
        for (Module lllllllllllllllllIllIlIlllIIlIll : Client.moduleManager.getModules(Category.Player)) {
            lllllllllllllllllIllIlIlllIIlIll.setEnabled(lllllllllllllllllIllIlIlllIIlIlI.isEnabled());
        }
        lllllllllllllllllIllIlIlllIIlIlI.mc.player.rotationYaw = 0.0f;
        lllllllllllllllllIllIlIlllIIlIlI.mc.player.rotationPitch = 0.0f;
    }

    @EventTarget
    public void onUpdate(EventUpdate lllllllllllllllllIllIlIlllIlIIll) {
    }
}

