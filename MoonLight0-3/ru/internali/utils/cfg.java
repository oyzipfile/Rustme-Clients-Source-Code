/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  net.minecraft.client.Minecraft
 */
package ru.internali.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.Minecraft;
import ru.internali.CatClient;
import ru.internali.module.Module;
import ru.internali.module.ModuleManager;
import ru.internali.settings.Setting;

public class cfg {
    public static /* synthetic */ File file;
    public static final /* synthetic */ File CONFIG_FOLDER;
    public static final /* synthetic */ File CLIENT_FOLDER;

    public static void init() {
        CLIENT_FOLDER.mkdir();
        CONFIG_FOLDER.mkdir();
    }

    private static boolean contains(Set<Map.Entry<String, JsonElement>> lIlIIIIIIllIIl, String lIlIIIIIIlllIl, JsonElement lIlIIIIIIlllII) {
        Map.Entry<String, JsonElement> lIlIIIIIIllIlI;
        Iterator<Map.Entry<String, JsonElement>> lIlIIIIIIllIll = lIlIIIIIIllIIl.iterator();
        do {
            if (lIlIIIIIIllIll.hasNext()) continue;
            return false;
        } while (!(lIlIIIIIIllIlI = lIlIIIIIIllIll.next()).getKey().equals(lIlIIIIIIlllIl) || !lIlIIIIIIllIlI.getValue().equals((Object)lIlIIIIIIlllII));
        return true;
    }

    /*
     * Exception decompiling
     */
    public static void load() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[DOLOOP]], but top level block is 6[UNCONDITIONALDOLOOP]
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:429)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:478)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:728)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:806)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:258)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:192)
         * org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         * org.benf.cfr.reader.entities.Method.analyse(Method.java:521)
         * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1035)
         * org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:922)
         * org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:253)
         * org.benf.cfr.reader.Driver.doJar(Driver.java:135)
         * org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
         * org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException(Decompilation failed);
    }

    public cfg() {
        cfg lIlIIIlIIIlIIl;
    }

    static {
        CLIENT_FOLDER = new File(Minecraft.getMinecraft().mcDataDir, "None Code");
        CONFIG_FOLDER = new File(CLIENT_FOLDER, "config");
    }

    public static void save() {
        JsonObject lIlIIIIlllIllI = new JsonObject();
        JsonArray lIlIIIIlllIlIl = new JsonArray();
        for (Module lIlIIIIlllllII : ModuleManager.modules) {
            JsonObject lIlIIIIllllIll = new JsonObject();
            lIlIIIIllllIll.addProperty("name", lIlIIIIlllllII.getName());
            lIlIIIIllllIll.addProperty("enabled", Boolean.valueOf(lIlIIIIlllllII.isEnable()));
            lIlIIIIllllIll.addProperty("keybind", (Number)lIlIIIIlllllII.getKey());
            lIlIIIIllllIll.addProperty("PosX", (Number)lIlIIIIlllllII.getPosX());
            lIlIIIIllllIll.addProperty("PosY", (Number)lIlIIIIlllllII.getPosY());
            JsonArray lIlIIIIllllIlI = new JsonArray();
            for (Setting lIlIIIIlllllll : CatClient.instance.settingsManager.getSettings(lIlIIIIlllllII)) {
                JsonObject lIlIIIIllllllI = new JsonObject();
                lIlIIIIllllIlI.add((JsonElement)lIlIIIIllllllI);
            }
            lIlIIIIllllIll.add("settings", (JsonElement)lIlIIIIllllIlI);
            lIlIIIIlllIlIl.add((JsonElement)lIlIIIIllllIll);
        }
        lIlIIIIlllIllI.add("modules", (JsonElement)lIlIIIIlllIlIl);
        try {
            FileWriter lIlIIIIllllIIl = new FileWriter(new File(CONFIG_FOLDER, "default.json"));
            Gson lIlIIIIllllIII = new GsonBuilder().setPrettyPrinting().create();
            lIlIIIIllllIIl.write(lIlIIIIllllIII.toJson((JsonElement)lIlIIIIlllIllI));
            lIlIIIIllllIIl.flush();
        }
        catch (IOException lIlIIIIlllIlll) {
            lIlIIIIlllIlll.printStackTrace();
        }
    }
}

