/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class WebUtils {
    public static /* synthetic */ String agent2;
    public static /* synthetic */ String agent1;

    static {
        agent1 = "User-Agent";
        agent2 = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36";
    }

    public WebUtils() {
        WebUtils llIllllIIlllllI;
    }

    public static String visitSite(String llIllllIIlIlIlI) {
        ArrayList<String> llIllllIIlIlIIl = new ArrayList<String>();
        String llIllllIIlIIlll = "";
        try {
            String llIllllIIlIllll;
            URL llIllllIIllIlIl = new URL(llIllllIIlIlIlI);
            HttpURLConnection llIllllIIllIIll = (HttpURLConnection)llIllllIIllIlIl.openConnection();
            llIllllIIllIIll.addRequestProperty(agent1, agent2);
            BufferedReader llIllllIIllIIIl = new BufferedReader(new InputStreamReader(llIllllIIllIIll.getInputStream(), "UTF-8"));
            while ((llIllllIIlIllll = llIllllIIllIIIl.readLine()) != null) {
                llIllllIIlIlIIl.add(llIllllIIlIllll);
            }
        }
        catch (Exception llIllllIIllIlIl) {
            // empty catch block
        }
        for (String llIllllIIlIlllI : llIllllIIlIlIIl) {
            llIllllIIlIIlll = String.valueOf(new StringBuilder().append(llIllllIIlIIlll).append(llIllllIIlIlllI));
        }
        return llIllllIIlIIlll;
    }
}

