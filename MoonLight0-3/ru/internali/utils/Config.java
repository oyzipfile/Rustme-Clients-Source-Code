/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 */
package ru.internali.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import ru.internali.CatClient;
import ru.internali.module.Module;
import ru.internali.module.ModuleManager;
import ru.internali.settings.Setting;
import ru.internali.settings.SettingsManager;

public class Config {
    public /* synthetic */ File configs;
    public /* synthetic */ File dir;
    public /* synthetic */ File dataFile;

    public void save() throws FileNotFoundException {
        Config lIIlIllIIllIIll;
        ArrayList<String> lIIlIllIIllIIlI = new ArrayList<String>();
        for (Module lIIlIllIIllIlll : ModuleManager.getModules()) {
            lIIlIllIIllIIlI.add(String.valueOf(new StringBuilder().append("module:").append(lIIlIllIIllIlll.getName()).append(":").append(lIIlIllIIllIlll.isToggler()).append(":").append(lIIlIllIIllIlll.getKey())));
        }
        SettingsManager lIIlIllIIllIIII = CatClient.instance.settingsManager;
        for (Setting lIIlIllIIllIllI : CatClient.instance.settingsManager.getSettings()) {
            if (lIIlIllIIllIllI.isCheck()) {
                lIIlIllIIllIIlI.add(String.valueOf(new StringBuilder().append("Setting:").append(lIIlIllIIllIllI.getName()).append(":").append(lIIlIllIIllIllI.getParentMod().getName()).append(":").append(lIIlIllIIllIllI.getValBoolean())));
            }
            if (lIIlIllIIllIllI.isCombo()) {
                lIIlIllIIllIIlI.add(String.valueOf(new StringBuilder().append("Setting:").append(lIIlIllIIllIllI.getName()).append(":").append(lIIlIllIIllIllI.getParentMod().getName()).append(":").append(lIIlIllIIllIllI.getValString())));
            }
            if (!lIIlIllIIllIllI.isSlider()) continue;
            lIIlIllIIllIIlI.add(String.valueOf(new StringBuilder().append("Setting:").append(lIIlIllIIllIllI.getName()).append(":").append(lIIlIllIIllIllI.getParentMod().getName()).append(":").append(lIIlIllIIllIllI.getValFloat())));
        }
        PrintWriter lIIlIllIIlIlllI = new PrintWriter(lIIlIllIIllIIll.dataFile);
        Iterator lIIlIllIIlIllIl = lIIlIllIIllIIlI.iterator();
        while (true) {
            Iterator lIIlIllIIllIlIl;
            if (!(lIIlIllIIllIlIl = lIIlIllIIlIllIl).hasNext()) break;
            String lIIlIllIIllIlII = (String)lIIlIllIIlIllIl.next();
            lIIlIllIIlIlllI.println(lIIlIllIIllIlII);
        }
        lIIlIllIIlIlllI.close();
    }

    public void load() throws IOException {
        ArrayList<String> lIIlIllIIIIllll;
        block10: {
            Exception lIIlIllIIIlIllI;
            block9: {
                Config lIIlIllIIIlIIII;
                lIIlIllIIIIllll = new ArrayList<String>();
                BufferedReader lIIlIllIIIIlllI = new BufferedReader(new FileReader(lIIlIllIIIlIIII.dataFile));
                String lIIlIllIIIIllIl = lIIlIllIIIIlllI.readLine();
                while (lIIlIllIIIIllIl != null) {
                    lIIlIllIIIIllll.add(lIIlIllIIIIllIl);
                    BufferedReader lIIlIllIIIllIlI = lIIlIllIIIIlllI;
                    try {
                        lIIlIllIIIIllIl = lIIlIllIIIllIlI.readLine();
                    }
                    catch (Exception lIIlIllIIIllIll) {
                        Exception lIIlIllIIIllIIl = lIIlIllIIIllIll;
                        boolean lIIlIllIIIllIII = false;
                        break block9;
                    }
                }
                try {
                    lIIlIllIIIIlllI.close();
                    break block10;
                }
                catch (Exception lIIlIllIIIlIlll) {
                    lIIlIllIIIlIllI = lIIlIllIIIlIlll;
                    boolean lIIlIllIIIlIlIl = false;
                }
            }
            Exception lIIlIllIIIlIlII = lIIlIllIIIlIllI;
            lIIlIllIIIlIlII.printStackTrace();
        }
        for (String lIIlIllIIIIllIl : lIIlIllIIIIllll) {
            Setting lIIlIllIIIlIIlI;
            String[] lIIlIllIIIlIIIl = lIIlIllIIIIllIl.split(":");
            if (lIIlIllIIIIllIl.toLowerCase().startsWith("module:")) {
                Module lIIlIllIIIlIIll = CatClient.instance.moduleManager.getModule(lIIlIllIIIlIIIl[1]);
                if (lIIlIllIIIlIIll == null) continue;
                lIIlIllIIIlIIll.setEnabled(Boolean.parseBoolean(lIIlIllIIIlIIIl[2]));
                lIIlIllIIIlIIll.setKey(Integer.parseInt(lIIlIllIIIlIIIl[3]));
                continue;
            }
            if (!lIIlIllIIIIllIl.toLowerCase().startsWith("setting:") || CatClient.instance.moduleManager.getModule(lIIlIllIIIlIIIl[2]) == null || (lIIlIllIIIlIIlI = CatClient.instance.settingsManager.getSettingByName(lIIlIllIIIlIIIl[1])) == null) continue;
            if (lIIlIllIIIlIIlI.isCheck()) {
                lIIlIllIIIlIIlI.setValBoolean(Boolean.parseBoolean(lIIlIllIIIlIIIl[3]));
            }
            if (lIIlIllIIIlIIlI.isCombo()) {
                lIIlIllIIIlIIlI.setValString(lIIlIllIIIlIIIl[3]);
            }
            if (!lIIlIllIIIlIIlI.isSlider()) continue;
            lIIlIllIIIlIIlI.setValDouble(Double.parseDouble(lIIlIllIIIlIIIl[3]));
            lIIlIllIIIlIIlI.setValFloat(Float.parseFloat(lIIlIllIIIlIIIl[3]));
        }
    }

    public Config() {
        Config lIIlIllIlIIIIll;
        lIIlIllIlIIIIll.dir = new File(Minecraft.getMinecraft().mcDataDir, "config");
        if (!lIIlIllIlIIIIll.dir.exists()) {
            lIIlIllIlIIIIll.dir.mkdir();
        }
        lIIlIllIlIIIIll.dataFile = new File(lIIlIllIlIIIIll.dir, "KeybindingsMod.json");
        if (!lIIlIllIlIIIIll.dataFile.exists()) {
            Config lIIlIllIlIIIllI = lIIlIllIlIIIIll;
            try {
                lIIlIllIlIIIllI.dataFile.createNewFile();
            }
            catch (IOException lIIlIllIlIIIlll) {
                lIIlIllIlIIIlll.printStackTrace();
            }
        }
        try {
            lIIlIllIlIIIIll.load();
        }
        catch (IOException lIIlIllIlIIIlIl) {
            throw new RuntimeException(lIIlIllIlIIIlIl);
        }
    }
}

