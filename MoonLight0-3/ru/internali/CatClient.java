/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.InputEvent$KeyInputEvent
 *  org.lwjgl.input.Keyboard
 */
package ru.internali;

import click.ClickGui;
import clickgui.Clickgui;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import new_gui.CSGOGui;
import org.lwjgl.input.Keyboard;
import ru.internali.clickgui.ClickGuiScreen;
import ru.internali.module.Module;
import ru.internali.module.ModuleManager;
import ru.internali.settings.SettingsManager;
import ru.internali.utils.ColorUtils;
import ru.internali.utils.Config;
import ru.internali.utils.DraggableManager;
import ru.internali.utils.EventManager;
import ru.internali.utils.HudEditor.HudEditor;

public class CatClient {
    public /* synthetic */ DraggableManager draggableManager;
    public static /* synthetic */ Color color;
    public /* synthetic */ ModuleManager moduleManager;
    public /* synthetic */ ClickGuiScreen clickGui;
    public static /* synthetic */ EventManager eventManager;
    public /* synthetic */ SettingsManager settingsManager;
    public static /* synthetic */ HudEditor hudEditor;
    public static /* synthetic */ CatClient instance;
    private static /* synthetic */ CatClient gate;
    public /* synthetic */ ClickGui guiw;
    public static /* synthetic */ Config config;
    public /* synthetic */ CSGOGui csgui;
    public static final /* synthetic */ EventManager EVENT_MANAGER;
    public static /* synthetic */ Clickgui guib;

    public static Color setColor() {
        try {
            return new Color(ColorUtils.astolfoColors((int)((double)Math.abs(System.currentTimeMillis() / 10L) / 100.0 + 0.16999999999999998), 5));
        }
        catch (Exception lIIIlIIlIIIIll) {
            lIIIlIIlIIIIll.printStackTrace();
            return new Color(30, 30, 30, 150);
        }
    }

    public static String requestURLSRC(String lIIIlIIlllIllI) throws IOException {
        URL lIIIlIIllllIII = new URL(lIIIlIIlllIllI);
        URLConnection lIIIlIIlllIlll = lIIIlIIllllIII.openConnection();
        lIIIlIIlllIlll.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        return CatClient.AP2iKAwcS2gFL8cX8z944ZiJp2zS54T68Tp39nr2rJAwh(lIIIlIIlllIlll.getInputStream());
    }

    static {
        color = Color.red;
        color = Color.red;
        EVENT_MANAGER = new EventManager();
    }

    public static String UID() {
        return "UID: PlutoSolutions";
    }

    public static int getColor() {
        return ColorUtils.TwoColoreffect(Color.blue, Color.MAGENTA, (double)Math.abs(System.currentTimeMillis() / 10L) / 100.0 + 0.16999999999999998).getRGB();
    }

    @SubscribeEvent
    public void key(InputEvent.KeyInputEvent lIIIlIIlIIlIIl) {
        if (Minecraft.getMinecraft().world == null || Minecraft.getMinecraft().player == null) {
            return;
        }
        try {
            if (Keyboard.isCreated() && Keyboard.getEventKeyState()) {
                int lIIIlIIlIIllII = Keyboard.getEventKey();
                if (lIIIlIIlIIllII <= 0) {
                    return;
                }
                for (Module lIIIlIIlIIllIl : ModuleManager.modules) {
                    if (lIIIlIIlIIllIl.getKey() != lIIIlIIlIIllII || lIIIlIIlIIllII <= 0) continue;
                    lIIIlIIlIIllIl.toggle();
                }
            }
        }
        catch (Exception lIIIlIIlIIlIll) {
            lIIIlIIlIIlIll.printStackTrace();
        }
    }

    public static CatClient getGate() {
        return gate;
    }

    public CatClient() {
        CatClient lIIIlIlIlIIIII;
    }

    public static Color getClientColor() {
        return color;
    }

    public static String getHWID() {
        try {
            byte[] lIIIlIlIIIlIlI;
            String lIIIlIlIIIllIl = String.valueOf(new StringBuilder().append(System.getenv("COMPUTERNAME")).append(System.getProperty("user.name")).append(System.getenv("PROCESSOR_IDENTIFIER")).append(System.getenv("PROCESSOR_LEVEL")));
            MessageDigest lIIIlIlIIIllII = MessageDigest.getInstance("MD5");
            lIIIlIlIIIllII.update(lIIIlIlIIIllIl.getBytes());
            StringBuffer lIIIlIlIIIlIll = new StringBuffer();
            for (byte lIIIlIlIIIlllI : lIIIlIlIIIlIlI = lIIIlIlIIIllII.digest()) {
                String lIIIlIlIIIllll = Integer.toHexString(0xFF & lIIIlIlIIIlllI);
                if (lIIIlIlIIIllll.length() == 1) {
                    lIIIlIlIIIlIll.append('0');
                }
                lIIIlIlIIIlIll.append(lIIIlIlIIIllll);
            }
            return lIIIlIlIIIlIll.toString();
        }
        catch (Exception lIIIlIlIIIlIIl) {
            lIIIlIlIIIlIIl.printStackTrace();
            return "Error";
        }
    }

    public void init() throws Exception {
        MinecraftForge.EVENT_BUS.register((Object)this);
        this.settingsManager = new SettingsManager();
        this.moduleManager = new ModuleManager();
        this.clickGui = new ClickGuiScreen();
        this.csgui = new CSGOGui();
        this.guiw = new ClickGui();
        this.draggableManager = new DraggableManager();
        hudEditor = new HudEditor();
        guib = new Clickgui();
        config = new Config();
    }

    private static String AP2iKAwcS2gFL8cX8z944ZiJp2zS54T68Tp39nr2rJAwh(InputStream lIIIlIIlIlllll) throws IOException {
        try (BufferedReader lIIIlIIllIIIII = new BufferedReader(new InputStreamReader(lIIIlIIlIlllll, StandardCharsets.UTF_8));){
            String lIIIlIIllIIllI;
            String lIIIlIIllIIIIl;
            String lIIIlIIllIIlIl;
            String lIIIlIIllIIlII;
            StringBuilder lIIIlIIllIIIll = new StringBuilder();
            while ((lIIIlIIllIIlII = lIIIlIIllIIIII.readLine()) != null) {
                lIIIlIIllIIIll.append(lIIIlIIllIIlII);
            }
            String lIIIlIIllIIIlI = lIIIlIIllIIlIl = String.valueOf(lIIIlIIllIIIll);
            String lIIIlIIlIlIlIl = lIIIlIIllIIIIl = (lIIIlIIllIIllI = lIIIlIIllIIlIl);
            return lIIIlIIlIlIlIl;
        }
    }
}

