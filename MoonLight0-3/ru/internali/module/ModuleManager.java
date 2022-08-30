/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.common.reflect.ClassPath
 *  com.google.common.reflect.ClassPath$ClassInfo
 */
package ru.internali.module;

import com.google.common.reflect.ClassPath;
import java.util.ArrayList;
import java.util.Iterator;
import ru.internali.module.CHAT.DonkeyAlert;
import ru.internali.module.CHAT.Exp;
import ru.internali.module.CHAT.PlayerFinder;
import ru.internali.module.CONFIG.ConfigLoad;
import ru.internali.module.CONFIG.ConfigSave;
import ru.internali.module.Category;
import ru.internali.module.HUD.AmmoGun;
import ru.internali.module.HUD.ArmorHUD;
import ru.internali.module.HUD.BombInfo;
import ru.internali.module.HUD.ClickGUI;
import ru.internali.module.HUD.Command;
import ru.internali.module.HUD.Coord;
import ru.internali.module.HUD.ExpInfo;
import ru.internali.module.HUD.GappelHud;
import ru.internali.module.HUD.HUD;
import ru.internali.module.HUD.HudEditor;
import ru.internali.module.HUD.Indicators;
import ru.internali.module.HUD.InvViewer;
import ru.internali.module.HUD.Keystrokes;
import ru.internali.module.HUD.Notifications;
import ru.internali.module.HUD.PlayerRadar;
import ru.internali.module.HUD.Radar;
import ru.internali.module.HUD.TargetHud;
import ru.internali.module.HUD.Watermark;
import ru.internali.module.HUD.cartridgesHUD;
import ru.internali.module.MANAGER.Binding;
import ru.internali.module.Module;
import ru.internali.module.World.AntiFog;
import ru.internali.module.World.DeleteArmorStands;
import ru.internali.module.World.FogColor;
import ru.internali.module.World.Zamorozka;
import ru.internali.module.combat.AimAssist;
import ru.internali.module.combat.AimPistol;
import ru.internali.module.combat.Airshoot;
import ru.internali.module.combat.AntiAim;
import ru.internali.module.combat.AntiBot;
import ru.internali.module.combat.AntiHuy;
import ru.internali.module.combat.AutoClicker;
import ru.internali.module.combat.AutoHeal;
import ru.internali.module.combat.AutoShiftTap;
import ru.internali.module.combat.HitBoxMod;
import ru.internali.module.misc.AntiInvis;
import ru.internali.module.misc.AutoArmor;
import ru.internali.module.misc.AutoFarm;
import ru.internali.module.misc.AutoFishMod;
import ru.internali.module.misc.AutoMine;
import ru.internali.module.misc.BoatFly;
import ru.internali.module.misc.ChestStealer;
import ru.internali.module.misc.DeathCoords;
import ru.internali.module.misc.MCF;
import ru.internali.module.misc.NameProtect;
import ru.internali.module.misc.SelfDestruct;
import ru.internali.module.misc.Spammer;
import ru.internali.module.movement.Blink;
import ru.internali.module.movement.GuiWalk;
import ru.internali.module.movement.NoFall;
import ru.internali.module.movement.NoSlowDown;
import ru.internali.module.movement.RageSprint;
import ru.internali.module.movement.Speed;
import ru.internali.module.movement.Sprint;
import ru.internali.module.movement.WaterFast;
import ru.internali.module.movement.strafe;
import ru.internali.module.player.AntiAFK;
import ru.internali.module.player.BackTP;
import ru.internali.module.player.Clip;
import ru.internali.module.player.Freecam;
import ru.internali.module.player.HClip;
import ru.internali.module.player.NoPush;
import ru.internali.module.player.Timer;
import ru.internali.module.player.VClip;
import ru.internali.module.render.Chams;
import ru.internali.module.render.ChinaHat;
import ru.internali.module.render.Crosshair;
import ru.internali.module.render.ESP;
import ru.internali.module.render.FOVchanger;
import ru.internali.module.render.FullBright;
import ru.internali.module.render.HitParticles;
import ru.internali.module.render.ItemsESP;
import ru.internali.module.render.JumpCircles;
import ru.internali.module.render.NameTags;
import ru.internali.module.render.NoHurtCum;
import ru.internali.module.render.NoOverlay;
import ru.internali.module.render.NoSmoothCamera;
import ru.internali.module.render.PenisESP;
import ru.internali.module.render.PlayerEntity;
import ru.internali.module.render.ShkafRender;
import ru.internali.module.render.Tracers;
import ru.internali.module.render.Trails;
import ru.internali.module.render.ViewModel;
import ru.internali.module.render.WallHack;
import ru.internali.module.render.Xray;

public class ModuleManager {
    public static /* synthetic */ ArrayList<Module> modules;

    public Module getModule(String lIIIllIIllIIlll) {
        for (Module lIIIllIIllIlIll : modules) {
            if (!lIIIllIIllIlIll.getName().equalsIgnoreCase(lIIIllIIllIIlll)) continue;
            return lIIIllIIllIlIll;
        }
        return null;
    }

    public static ArrayList getModules() {
        return modules;
    }

    public static ArrayList<Class<?>> getClasses(String lIIIllIIlllIlII) {
        ArrayList lIIIllIIlllIlIl = new ArrayList();
        try {
            ClassLoader lIIIllIIllllIII = Thread.currentThread().getContextClassLoader();
            for (ClassPath.ClassInfo lIIIllIIllllIIl : ClassPath.from((ClassLoader)lIIIllIIllllIII).getAllClasses()) {
                if (!lIIIllIIllllIIl.getName().startsWith(lIIIllIIlllIlII)) continue;
                lIIIllIIlllIlIl.add(lIIIllIIllllIIl.load());
            }
        }
        catch (Exception lIIIllIIlllIlll) {
            lIIIllIIlllIlll.printStackTrace();
        }
        return lIIIllIIlllIlIl;
    }

    public ArrayList<Module> getModulesInCategory(Category lIIIllIIlIllIlI) {
        ArrayList<Module> lIIIllIIlIllIIl = new ArrayList<Module>();
        for (Module lIIIllIIlIlllII : modules) {
            if (lIIIllIIlIlllII.getCategory() != lIIIllIIlIllIlI) continue;
            lIIIllIIlIllIIl.add(lIIIllIIlIlllII);
        }
        return lIIIllIIlIllIIl;
    }

    public ArrayList<Module> getModuleList() {
        return modules;
    }

    public ModuleManager() {
        ModuleManager lIIIllIlIIIIIlI;
        modules = new ArrayList();
        modules.clear();
        modules.add(new ClickGUI());
        modules.add(new HUD());
        modules.add(new Watermark());
        modules.add(new Sprint());
        modules.add(new ESP());
        modules.add(new Tracers());
        modules.add(new GuiWalk());
        modules.add(new FullBright());
        modules.add(new NameTags());
        modules.add(new HitBoxMod());
        modules.add(new SelfDestruct());
        modules.add(new strafe());
        modules.add(new NoHurtCum());
        modules.add(new ArmorHUD());
        modules.add(new cartridgesHUD());
        modules.add(new MCF());
        modules.add(new ShkafRender());
        modules.add(new AimPistol());
        modules.add(new ViewModel());
        modules.add(new AutoClicker());
        modules.add(new NoOverlay());
        modules.add(new AntiAim());
        modules.add(new TargetHud());
        modules.add(new Notifications());
        modules.add(new Clip());
        modules.add(new ChinaHat());
        modules.add(new PlayerEntity());
        modules.add(new Coord());
        modules.add(new PlayerRadar());
        modules.add(new AntiAFK());
        modules.add(new AntiBot());
        modules.add(new AutoShiftTap());
        modules.add(new Freecam());
        modules.add(new NoSlowDown());
        modules.add(new HClip());
        modules.add(new NoPush());
        modules.add(new NoFall());
        modules.add(new ItemsESP());
        modules.add(new BombInfo());
        modules.add(new GappelHud());
        modules.add(new AutoArmor());
        modules.add(new JumpCircles());
        modules.add(new ChestStealer());
        modules.add(new Trails());
        modules.add(new DeleteArmorStands());
        modules.add(new HitParticles());
        modules.add(new Zamorozka());
        modules.add(new InvViewer());
        modules.add(new AutoFishMod());
        modules.add(new FogColor());
        modules.add(new Xray());
        modules.add(new BoatFly());
        modules.add(new PlayerFinder());
        modules.add(new Spammer());
        modules.add(new Blink());
        modules.add(new DonkeyAlert());
        modules.add(new FOVchanger());
        modules.add(new PenisESP());
        modules.add(new AntiHuy());
        modules.add(new DeathCoords());
        modules.add(new NameProtect());
        modules.add(new Keystrokes());
        modules.add(new Radar());
        modules.add(new Chams());
        modules.add(new NoSmoothCamera());
        modules.add(new Airshoot());
        modules.add(new Crosshair());
        modules.add(new AntiFog());
        modules.add(new Indicators());
        modules.add(new HudEditor());
        modules.add(new AmmoGun());
        modules.add(new Timer());
        modules.add(new Exp());
        modules.add(new Binding());
        modules.add(new AntiInvis());
        modules.add(new AutoMine());
        modules.add(new WallHack());
        modules.add(new BackTP());
        modules.add(new Command());
        modules.add(new ExpInfo());
        modules.add(new ConfigLoad());
        modules.add(new ConfigSave());
        modules.add(new AutoHeal());
        modules.add(new AutoFarm());
        modules.add(new Speed());
        modules.add(new WaterFast());
        modules.add(new VClip());
        modules.add(new AimAssist());
        modules.add(new RageSprint());
        for (Module lIIIllIIlllllll : modules) {
        }
    }

    public ArrayList<Module> getModules(Category lIIIllIIlIIIIlI) {
        ArrayList<Module> lIIIllIIlIIIIIl = new ArrayList<Module>();
        for (Module lIIIllIIlIIIlII : modules) {
            if (lIIIllIIlIIIlII.getCategory() != lIIIllIIlIIIIlI) continue;
            lIIIllIIlIIIIIl.add(lIIIllIIlIIIlII);
        }
        return lIIIllIIlIIIIIl;
    }

    public Module getModule(Class lIIIllIIlIIllII) {
        Module lIIIllIIlIIllIl;
        Iterator<Module> lIIIllIIlIIlllI = modules.iterator();
        do {
            if (lIIIllIIlIIlllI.hasNext()) continue;
            return null;
        } while ((lIIIllIIlIIllIl = lIIIllIIlIIlllI.next()).getClass() != lIIIllIIlIIllII);
        return lIIIllIIlIIllIl;
    }
}

