/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  com.google.gson.JsonPrimitive
 *  net.minecraft.client.Minecraft
 */
package ru.hld.legendline.api.shit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.Minecraft;
import ru.hld.legendline.Client;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.api.setting.Setting;
import ru.hld.legendline.api.setting.settings.BooleanSetting;
import ru.hld.legendline.api.setting.settings.FloatSetting;
import ru.hld.legendline.api.setting.settings.ModeSetting;

public class cfg {
    public static /* synthetic */ File file;
    public static final /* synthetic */ File CONFIG_FOLDER;
    public static final /* synthetic */ File CLIENT_FOLDER;

    private static boolean contains(Set<Map.Entry<String, JsonElement>> lllllllllllllllIllIlIlIllIIlIIll, String lllllllllllllllIllIlIlIllIIIllll, JsonElement lllllllllllllllIllIlIlIllIIIlllI) {
        for (Map.Entry<String, JsonElement> lllllllllllllllIllIlIlIllIIlIlII : lllllllllllllllIllIlIlIllIIlIIll) {
            if (!lllllllllllllllIllIlIlIllIIlIlII.getKey().equals(lllllllllllllllIllIlIlIllIIIllll) || !lllllllllllllllIllIlIlIllIIlIlII.getValue().equals((Object)lllllllllllllllIllIlIlIllIIIlllI)) continue;
            return true;
        }
        return false;
    }

    public static void init() {
        CLIENT_FOLDER.mkdir();
        CONFIG_FOLDER.mkdir();
    }

    static {
        CLIENT_FOLDER = new File(Minecraft.getMinecraft().mcDataDir, "LegendLine");
        CONFIG_FOLDER = new File(CLIENT_FOLDER, "config");
    }

    public static void load() {
        JsonParser lllllllllllllllIllIlIlIllIllIIlI = new JsonParser();
        try {
            JsonObject lllllllllllllllIllIlIlIllIllIllI = lllllllllllllllIllIlIlIllIllIIlI.parse((Reader)new FileReader(new File(CONFIG_FOLDER, "default.json"))).getAsJsonObject();
            JsonElement lllllllllllllllIllIlIlIllIllIlIl = lllllllllllllllIllIlIlIllIllIllI.get("auto save");
            JsonArray lllllllllllllllIllIlIlIllIllIlII = lllllllllllllllIllIlIlIllIllIllI.getAsJsonArray("modules");
            for (JsonElement lllllllllllllllIllIlIlIllIllIlll : lllllllllllllllIllIlIlIllIllIlII) {
                if (!(lllllllllllllllIllIlIlIllIllIlll instanceof JsonObject)) continue;
                JsonObject lllllllllllllllIllIlIlIllIlllIIl = (JsonObject)lllllllllllllllIllIlIlIllIllIlll;
                Set lllllllllllllllIllIlIlIllIlllIII = lllllllllllllllIllIlIlIllIlllIIl.entrySet();
                for (Module lllllllllllllllIllIlIlIllIlllIlI : Client.moduleManager.modules) {
                    if (!cfg.contains(lllllllllllllllIllIlIlIllIlllIII, "name", (JsonElement)new JsonPrimitive(lllllllllllllllIllIlIlIllIlllIlI.getName()))) continue;
                    for (Map.Entry lllllllllllllllIllIlIlIllIlllIll : lllllllllllllllIllIlIlIllIlllIII) {
                        String lllllllllllllllIllIlIlIllIllllIl = (String)lllllllllllllllIllIlIlIllIlllIll.getKey();
                        JsonElement lllllllllllllllIllIlIlIllIllllII = (JsonElement)lllllllllllllllIllIlIlIllIlllIll.getValue();
                        try {
                            if (lllllllllllllllIllIlIlIllIllllIl.equals("enabled")) {
                                lllllllllllllllIllIlIlIllIlllIlI.setEnabled(lllllllllllllllIllIlIlIllIllllII.getAsBoolean());
                                continue;
                            }
                        }
                        catch (Exception lllllllllllllllIllIlIlIlllIIIlIl) {
                            lllllllllllllllIllIlIlIlllIIIlIl.printStackTrace();
                        }
                        if (lllllllllllllllIllIlIlIllIllllIl.equals("keybind")) {
                            lllllllllllllllIllIlIlIllIlllIlI.setKey(lllllllllllllllIllIlIlIllIllllII.getAsInt());
                            continue;
                        }
                        if (lllllllllllllllIllIlIlIllIllllIl.equals("PosX")) {
                            lllllllllllllllIllIlIlIllIlllIlI.setPosX(lllllllllllllllIllIlIlIllIllllII.getAsInt());
                            continue;
                        }
                        if (lllllllllllllllIllIlIlIllIllllIl.equals("PosY")) {
                            lllllllllllllllIllIlIlIllIlllIlI.setPosY(lllllllllllllllIllIlIlIllIllllII.getAsInt());
                            continue;
                        }
                        if (!lllllllllllllllIllIlIlIllIllllIl.equals("settings")) continue;
                        for (JsonElement lllllllllllllllIllIlIlIllIlllllI : lllllllllllllllIllIlIlIllIllllII.getAsJsonArray()) {
                            if (!(lllllllllllllllIllIlIlIllIlllllI instanceof JsonObject)) continue;
                            JsonObject lllllllllllllllIllIlIlIlllIIIIII = (JsonObject)lllllllllllllllIllIlIlIllIlllllI;
                            Set lllllllllllllllIllIlIlIllIllllll = lllllllllllllllIllIlIlIlllIIIIII.entrySet();
                            for (Setting lllllllllllllllIllIlIlIlllIIIIIl : Client.settingManager.getSettings(lllllllllllllllIllIlIlIllIlllIlI)) {
                                for (Map.Entry lllllllllllllllIllIlIlIlllIIIIlI : lllllllllllllllIllIlIlIllIllllll) {
                                    String lllllllllllllllIllIlIlIlllIIIlII = (String)lllllllllllllllIllIlIlIlllIIIIlI.getKey();
                                    JsonElement lllllllllllllllIllIlIlIlllIIIIll = (JsonElement)lllllllllllllllIllIlIlIlllIIIIlI.getValue();
                                    if (lllllllllllllllIllIlIlIlllIIIIIl instanceof BooleanSetting) {
                                        if (!lllllllllllllllIllIlIlIlllIIIlII.equals(lllllllllllllllIllIlIlIlllIIIIIl.getName())) continue;
                                        ((BooleanSetting)lllllllllllllllIllIlIlIlllIIIIIl).setVal(lllllllllllllllIllIlIlIlllIIIIll.getAsBoolean());
                                        continue;
                                    }
                                    if (lllllllllllllllIllIlIlIlllIIIIIl instanceof ModeSetting) {
                                        if (!lllllllllllllllIllIlIlIlllIIIlII.equals(lllllllllllllllIllIlIlIlllIIIIIl.getName())) continue;
                                        ((ModeSetting)lllllllllllllllIllIlIlIlllIIIIIl).setVal(lllllllllllllllIllIlIlIlllIIIIll.getAsString());
                                        continue;
                                    }
                                    if (!(lllllllllllllllIllIlIlIlllIIIIIl instanceof FloatSetting) || !lllllllllllllllIllIlIlIlllIIIlII.equals(lllllllllllllllIllIlIlIlllIIIIIl.getName())) continue;
                                    ((FloatSetting)lllllllllllllllIllIlIlIlllIIIIIl).setVal(lllllllllllllllIllIlIlIlllIIIIll.getAsFloat());
                                }
                            }
                        }
                    }
                }
            }
        }
        catch (FileNotFoundException lllllllllllllllIllIlIlIllIllIIll) {
            lllllllllllllllIllIlIlIllIllIIll.printStackTrace();
        }
    }

    public static void save() {
        JsonObject lllllllllllllllIllIlIlIllllIlIII = new JsonObject();
        JsonArray lllllllllllllllIllIlIlIllllIIlll = new JsonArray();
        for (Module lllllllllllllllIllIlIlIllllIllII : Client.moduleManager.modules) {
            JsonObject lllllllllllllllIllIlIlIllllIlllI = new JsonObject();
            lllllllllllllllIllIlIlIllllIlllI.addProperty("name", lllllllllllllllIllIlIlIllllIllII.getName());
            lllllllllllllllIllIlIlIllllIlllI.addProperty("enabled", Boolean.valueOf(lllllllllllllllIllIlIlIllllIllII.isEnabled()));
            lllllllllllllllIllIlIlIllllIlllI.addProperty("keybind", (Number)lllllllllllllllIllIlIlIllllIllII.getKey());
            lllllllllllllllIllIlIlIllllIlllI.addProperty("PosX", (Number)lllllllllllllllIllIlIlIllllIllII.getPosX());
            lllllllllllllllIllIlIlIllllIlllI.addProperty("PosY", (Number)lllllllllllllllIllIlIlIllllIllII.getPosY());
            JsonArray lllllllllllllllIllIlIlIllllIllIl = new JsonArray();
            for (Setting lllllllllllllllIllIlIlIllllIllll : Client.settingManager.getSettings(lllllllllllllllIllIlIlIllllIllII)) {
                JsonObject lllllllllllllllIllIlIlIlllllIIII = new JsonObject();
                if (lllllllllllllllIllIlIlIllllIllll instanceof BooleanSetting) {
                    lllllllllllllllIllIlIlIlllllIIII.addProperty(lllllllllllllllIllIlIlIllllIllll.getName(), Boolean.valueOf(((BooleanSetting)lllllllllllllllIllIlIlIllllIllll).getVal()));
                } else if (lllllllllllllllIllIlIlIllllIllll instanceof ModeSetting) {
                    lllllllllllllllIllIlIlIlllllIIII.addProperty(lllllllllllllllIllIlIlIllllIllll.getName(), ((ModeSetting)lllllllllllllllIllIlIlIllllIllll).getVal());
                } else if (lllllllllllllllIllIlIlIllllIllll instanceof FloatSetting) {
                    lllllllllllllllIllIlIlIlllllIIII.addProperty(lllllllllllllllIllIlIlIllllIllll.getName(), (Number)Float.valueOf(((FloatSetting)lllllllllllllllIllIlIlIllllIllll).getVal()));
                }
                lllllllllllllllIllIlIlIllllIllIl.add((JsonElement)lllllllllllllllIllIlIlIlllllIIII);
            }
            lllllllllllllllIllIlIlIllllIlllI.add("settings", (JsonElement)lllllllllllllllIllIlIlIllllIllIl);
            lllllllllllllllIllIlIlIllllIIlll.add((JsonElement)lllllllllllllllIllIlIlIllllIlllI);
        }
        lllllllllllllllIllIlIlIllllIlIII.add("modules", (JsonElement)lllllllllllllllIllIlIlIllllIIlll);
        try {
            FileWriter lllllllllllllllIllIlIlIllllIlIll = new FileWriter(new File(CONFIG_FOLDER, "default.json"));
            Gson lllllllllllllllIllIlIlIllllIlIlI = new GsonBuilder().setPrettyPrinting().create();
            lllllllllllllllIllIlIlIllllIlIll.write(lllllllllllllllIllIlIlIllllIlIlI.toJson((JsonElement)lllllllllllllllIllIlIlIllllIlIII));
            lllllllllllllllIllIlIlIllllIlIll.flush();
        }
        catch (IOException lllllllllllllllIllIlIlIllllIlIIl) {
            lllllllllllllllIllIlIlIllllIlIIl.printStackTrace();
        }
    }

    public cfg() {
        cfg lllllllllllllllIllIlIlIllllllIlI;
    }
}

