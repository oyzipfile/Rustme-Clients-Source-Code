/*
 * Decompiled with CFR 0.150.
 */
package ru.hld.legendline;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import ru.hld.legendline.api.clickgui.ClickGuiScreen;
import ru.hld.legendline.api.event.EventManager;
import ru.hld.legendline.api.event.EventTarget;
import ru.hld.legendline.api.event.PlayerHook;
import ru.hld.legendline.api.event.events.EventKeyBoard;
import ru.hld.legendline.api.hudeditor.HudEditor;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.api.module.ModuleManager;
import ru.hld.legendline.api.notification.NotificationsManager;
import ru.hld.legendline.api.setting.SettingManager;
import ru.hld.legendline.api.shit.cfg;
import ru.hld.legendline.api.utils.BlurUtil;
import ru.hld.legendline.api.utils.ColorUtils;
import ru.hld.legendline.impl.modules.Render.ClickGui;
import ru.hld.legendline.impl.modules.Render.ModuleList;

public class Client {
    public static /* synthetic */ cfg conf;
    public static /* synthetic */ PlayerHook playerHook;
    public static /* synthetic */ ModuleManager moduleManager;
    public static /* synthetic */ HudEditor hudEditor;
    public static /* synthetic */ NotificationsManager notificationsManager;
    public static /* synthetic */ BlurUtil blurUtil;
    public static /* synthetic */ SettingManager settingManager;
    public static /* synthetic */ EventManager eventManager;
    public static /* synthetic */ ClickGuiScreen gui;

    public static String requestURLSRC(String llllllllllllllIIIlIlIIlllllIlIlI) throws IOException {
        URL llllllllllllllIIIlIlIIlllllIlIIl = new URL(llllllllllllllIIIlIlIIlllllIlIlI);
        URLConnection llllllllllllllIIIlIlIIlllllIlIII = llllllllllllllIIIlIlIIlllllIlIIl.openConnection();
        llllllllllllllIIIlIlIIlllllIlIII.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        return Client.AP2iKAwcS2gFL8cX8z944ZiJp2zS54T68Tp39nr2rJAwh(llllllllllllllIIIlIlIIlllllIlIII.getInputStream());
    }

    public Client() {
        Client llllllllllllllIIIlIlIlIIIIllIIll;
    }

    public static int getBackArray() {
        Color llllllllllllllIIIlIlIIllllllIIIl = new Color((int)ModuleList.Red2.getVal(), (int)ModuleList.Green2.getVal(), (int)ModuleList.Blue2.getVal(), (int)ModuleList.AlfaA.getVal());
        Color llllllllllllllIIIlIlIIllllllIIII = new Color((int)ModuleList.Red.getVal(), (int)ModuleList.Green.getVal(), (int)ModuleList.Blue.getVal(), (int)ModuleList.AlfaA.getVal());
        return ColorUtils.TwoColoreffect(llllllllllllllIIIlIlIIllllllIIII, llllllllllllllIIIlIlIIllllllIIIl, (double)Math.abs(System.currentTimeMillis() / 10L) / 100.0 + 0.16999999999999998).getRGB();
    }

    public static String getHWID() {
        try {
            byte[] llllllllllllllIIIlIlIlIIIIIllIIl;
            String llllllllllllllIIIlIlIlIIIIIlllII = String.valueOf(new StringBuilder().append(System.getenv("COMPUTERNAME")).append(System.getProperty("user.name")).append(System.getenv("PROCESSOR_IDENTIFIER")).append(System.getenv("PROCESSOR_LEVEL")));
            MessageDigest llllllllllllllIIIlIlIlIIIIIllIll = MessageDigest.getInstance("MD5");
            llllllllllllllIIIlIlIlIIIIIllIll.update(llllllllllllllIIIlIlIlIIIIIlllII.getBytes());
            StringBuffer llllllllllllllIIIlIlIlIIIIIllIlI = new StringBuffer();
            for (byte llllllllllllllIIIlIlIlIIIIIlllIl : llllllllllllllIIIlIlIlIIIIIllIIl = llllllllllllllIIIlIlIlIIIIIllIll.digest()) {
                String llllllllllllllIIIlIlIlIIIIIllllI = Integer.toHexString(0xFF & llllllllllllllIIIlIlIlIIIIIlllIl);
                if (llllllllllllllIIIlIlIlIIIIIllllI.length() == 1) {
                    llllllllllllllIIIlIlIlIIIIIllIlI.append('0');
                }
                llllllllllllllIIIlIlIlIIIIIllIlI.append(llllllllllllllIIIlIlIlIIIIIllllI);
            }
            return llllllllllllllIIIlIlIlIIIIIllIlI.toString();
        }
        catch (Exception llllllllllllllIIIlIlIlIIIIIllIII) {
            llllllllllllllIIIlIlIlIIIIIllIII.printStackTrace();
            return "Error";
        }
    }

    public static int getColor2() {
        Color llllllllllllllIIIlIlIIllllllllIl = new Color((int)ClickGui.RedFirst.getVal(), (int)ClickGui.GreenFirst.getVal(), (int)ClickGui.BlueFirst.getVal());
        Color llllllllllllllIIIlIlIIllllllllII = new Color((int)ClickGui.RedSecond.getVal(), (int)ClickGui.GreenSecond.getVal(), (int)ClickGui.BlueSecond.getVal());
        return ColorUtils.TwoColoreffect(llllllllllllllIIIlIlIIllllllllII, llllllllllllllIIIlIlIIllllllllIl, (double)Math.abs(System.currentTimeMillis() / 10L) / 100.0 + 0.16999999999999998).getRGB();
    }

    @EventTarget
    public void onKey(EventKeyBoard llllllllllllllIIIlIlIlIIIIIIlIII) {
        for (Module llllllllllllllIIIlIlIlIIIIIIlIll : Client.moduleManager.modules) {
            if (llllllllllllllIIIlIlIlIIIIIIlIll.getKey() != llllllllllllllIIIlIlIlIIIIIIlIII.getKey()) continue;
            llllllllllllllIIIlIlIlIIIIIIlIll.toggle();
        }
    }

    public static int getColor() {
        Color llllllllllllllIIIlIlIlIIIIIIIIll = new Color((int)ClickGui.RedFirst.getVal(), (int)ClickGui.GreenFirst.getVal(), (int)ClickGui.BlueFirst.getVal());
        Color llllllllllllllIIIlIlIlIIIIIIIIlI = new Color((int)ClickGui.RedSecond.getVal(), (int)ClickGui.GreenSecond.getVal(), (int)ClickGui.BlueSecond.getVal());
        return ColorUtils.TwoColoreffect(llllllllllllllIIIlIlIlIIIIIIIIll, llllllllllllllIIIlIlIlIIIIIIIIlI, (double)Math.abs(System.currentTimeMillis() / 10L) / 100.0 + 0.16999999999999998).getRGB();
    }

    /*
     * WARNING - void declaration
     */
    public void init() {
        void llllllllllllllIIIlIlIlIIIIlIlIll;
        try {
            String llllllllllllllIIIlIlIlIIIIlIlllI = Client.requestURLSRC("https://docs.google.com/document/d/1h1bi7MNn_AfPlcSCtak_DYBmz3aT_EFwAOpm7mlblLw/edit?usp=sharing");
        }
        catch (IOException llllllllllllllIIIlIlIlIIIIlIllIl) {
            throw new RuntimeException(llllllllllllllIIIlIlIlIIIIlIllIl);
        }
        System.out.println((String)llllllllllllllIIIlIlIlIIIIlIlIll);
        if (llllllllllllllIIIlIlIlIIIIlIlIll.contains("enable: true")) {
            Client llllllllllllllIIIlIlIlIIIIlIlIlI;
            eventManager = new EventManager();
            settingManager = new SettingManager();
            moduleManager = new ModuleManager();
            eventManager.register(llllllllllllllIIIlIlIlIIIIlIlIlI);
            gui = new ClickGuiScreen();
            hudEditor = new HudEditor();
            notificationsManager = new NotificationsManager();
            blurUtil = new BlurUtil();
            conf = new cfg();
            cfg.init();
            blurUtil.init();
        }
    }

    private static String AP2iKAwcS2gFL8cX8z944ZiJp2zS54T68Tp39nr2rJAwh(InputStream llllllllllllllIIIlIlIIllllIlIIII) throws IOException {
        try (BufferedReader llllllllllllllIIIlIlIIllllIlIIIl = new BufferedReader(new InputStreamReader(llllllllllllllIIIlIlIIllllIlIIII, StandardCharsets.UTF_8));){
            String llllllllllllllIIIlIlIIllllIlIlll;
            String llllllllllllllIIIlIlIIllllIlIIlI;
            String llllllllllllllIIIlIlIIllllIlIllI;
            String llllllllllllllIIIlIlIIllllIlIlIl;
            StringBuilder llllllllllllllIIIlIlIIllllIlIlII = new StringBuilder();
            while ((llllllllllllllIIIlIlIIllllIlIlIl = llllllllllllllIIIlIlIIllllIlIIIl.readLine()) != null) {
                llllllllllllllIIIlIlIIllllIlIlII.append(llllllllllllllIIIlIlIIllllIlIlIl);
            }
            String llllllllllllllIIIlIlIIllllIlIIll = llllllllllllllIIIlIlIIllllIlIllI = String.valueOf(llllllllllllllIIIlIlIIllllIlIlII);
            String llllllllllllllIIIlIlIIllllIIIllI = llllllllllllllIIIlIlIIllllIlIIlI = (llllllllllllllIIIlIlIIllllIlIlll = llllllllllllllIIIlIlIIllllIlIllI);
            return llllllllllllllIIIlIlIIllllIIIllI;
        }
    }

    public static int getArray() {
        Color llllllllllllllIIIlIlIIllllllIlll = new Color((int)ModuleList.textred2.getVal(), (int)ModuleList.textgreen2.getVal(), (int)ModuleList.textblue2.getVal());
        Color llllllllllllllIIIlIlIIllllllIllI = new Color((int)ModuleList.textred.getVal(), (int)ModuleList.textgreen.getVal(), (int)ModuleList.textblue.getVal());
        return ColorUtils.TwoColoreffect(llllllllllllllIIIlIlIIllllllIllI, llllllllllllllIIIlIlIIllllllIlll, (double)Math.abs(System.currentTimeMillis() / 10L) / 100.0 + 0.16999999999999998).getRGB();
    }
}

