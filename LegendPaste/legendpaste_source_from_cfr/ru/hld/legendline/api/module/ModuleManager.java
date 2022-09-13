/*
 * Decompiled with CFR 0.150.
 */
package ru.hld.legendline.api.module;

import java.util.ArrayList;
import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.impl.modules.Combat.AimBot;
import ru.hld.legendline.impl.modules.Combat.AntiBot;
import ru.hld.legendline.impl.modules.Combat.Velocity;
import ru.hld.legendline.impl.modules.Config.LoadConfig;
import ru.hld.legendline.impl.modules.Config.SaveConfig;
import ru.hld.legendline.impl.modules.Misc.DiscordRPC;
import ru.hld.legendline.impl.modules.Misc.MCF;
import ru.hld.legendline.impl.modules.Player.AutoSprint;
import ru.hld.legendline.impl.modules.Render.CameraClip;
import ru.hld.legendline.impl.modules.Render.ClickGui;
import ru.hld.legendline.impl.modules.Render.DamageColor;
import ru.hld.legendline.impl.modules.Render.ESP;
import ru.hld.legendline.impl.modules.Render.Freecam;
import ru.hld.legendline.impl.modules.Render.FullBright;
import ru.hld.legendline.impl.modules.Render.ItemPhysics;
import ru.hld.legendline.impl.modules.Render.ModuleList;
import ru.hld.legendline.impl.modules.Render.NameTags;
import ru.hld.legendline.impl.modules.Render.NoHurtCam;
import ru.hld.legendline.impl.modules.Render.Notifications;
import ru.hld.legendline.impl.modules.Render.StorageESP;
import ru.hld.legendline.impl.modules.Render.TargetHud;
import ru.hld.legendline.impl.modules.Render.Tracers;
import ru.hld.legendline.impl.modules.Render.WallHack;
import ru.hld.legendline.impl.modules.Render.WaterMark;
import ru.hld.legendline.impl.modules.movment.GuiWalk;
import ru.hld.legendline.impl.modules.movment.Jesus;
import ru.hld.legendline.impl.modules.movment.NoSlowDown;
import ru.hld.legendline.impl.modules.movment.Strafe;
import ru.hld.legendline.impl.modules.movment.WaterUp;

public class ModuleManager {
    public /* synthetic */ ArrayList<Module> modules;

    public ArrayList<Module> getModules(Category llllllllllllllllllIIIlIIIlllllIl) {
        ModuleManager llllllllllllllllllIIIlIIlIIIIIIl;
        ArrayList<Module> llllllllllllllllllIIIlIIIlllllll = new ArrayList<Module>();
        for (Module llllllllllllllllllIIIlIIlIIIIIlI : llllllllllllllllllIIIlIIlIIIIIIl.modules) {
            if (llllllllllllllllllIIIlIIlIIIIIlI.getCategory() != llllllllllllllllllIIIlIIIlllllIl) continue;
            llllllllllllllllllIIIlIIIlllllll.add(llllllllllllllllllIIIlIIlIIIIIlI);
        }
        return llllllllllllllllllIIIlIIIlllllll;
    }

    public ModuleManager() {
        ModuleManager llllllllllllllllllIIIlIIlIIIlIII;
        llllllllllllllllllIIIlIIlIIIlIII.modules = new ArrayList();
        llllllllllllllllllIIIlIIlIIIlIII.modules.add(new ClickGui());
        llllllllllllllllllIIIlIIlIIIlIII.modules.add(new AntiBot());
        llllllllllllllllllIIIlIIlIIIlIII.modules.add(new WaterMark());
        llllllllllllllllllIIIlIIlIIIlIII.modules.add(new ModuleList());
        llllllllllllllllllIIIlIIlIIIlIII.modules.add(new AutoSprint());
        llllllllllllllllllIIIlIIlIIIlIII.modules.add(new NameTags());
        llllllllllllllllllIIIlIIlIIIlIII.modules.add(new ESP());
        llllllllllllllllllIIIlIIlIIIlIII.modules.add(new Tracers());
        llllllllllllllllllIIIlIIlIIIlIII.modules.add(new AimBot());
        llllllllllllllllllIIIlIIlIIIlIII.modules.add(new TargetHud());
        llllllllllllllllllIIIlIIlIIIlIII.modules.add(new MCF());
        llllllllllllllllllIIIlIIlIIIlIII.modules.add(new WallHack());
        llllllllllllllllllIIIlIIlIIIlIII.modules.add(new NoHurtCam());
        llllllllllllllllllIIIlIIlIIIlIII.modules.add(new FullBright());
        llllllllllllllllllIIIlIIlIIIlIII.modules.add(new GuiWalk());
        llllllllllllllllllIIIlIIlIIIlIII.modules.add(new NoSlowDown());
        llllllllllllllllllIIIlIIlIIIlIII.modules.add(new StorageESP());
        llllllllllllllllllIIIlIIlIIIlIII.modules.add(new CameraClip());
        llllllllllllllllllIIIlIIlIIIlIII.modules.add(new ItemPhysics());
        llllllllllllllllllIIIlIIlIIIlIII.modules.add(new Freecam());
        llllllllllllllllllIIIlIIlIIIlIII.modules.add(new DiscordRPC());
        llllllllllllllllllIIIlIIlIIIlIII.modules.add(new Notifications());
        llllllllllllllllllIIIlIIlIIIlIII.modules.add(new Strafe());
        llllllllllllllllllIIIlIIlIIIlIII.modules.add(new Jesus());
        llllllllllllllllllIIIlIIlIIIlIII.modules.add(new DamageColor());
        llllllllllllllllllIIIlIIlIIIlIII.modules.add(new Velocity());
        llllllllllllllllllIIIlIIlIIIlIII.modules.add(new SaveConfig());
        llllllllllllllllllIIIlIIlIIIlIII.modules.add(new LoadConfig());
        llllllllllllllllllIIIlIIlIIIlIII.modules.add(new WaterUp());
    }

    public Module getModule(String llllllllllllllllllIIIlIIIlllIIIl) {
        ModuleManager llllllllllllllllllIIIlIIIlllIIlI;
        for (Module llllllllllllllllllIIIlIIIlllIlIl : llllllllllllllllllIIIlIIIlllIIlI.modules) {
            if (!llllllllllllllllllIIIlIIIlllIlIl.getName().equalsIgnoreCase(llllllllllllllllllIIIlIIIlllIIIl)) continue;
            return llllllllllllllllllIIIlIIIlllIlIl;
        }
        return null;
    }
}

