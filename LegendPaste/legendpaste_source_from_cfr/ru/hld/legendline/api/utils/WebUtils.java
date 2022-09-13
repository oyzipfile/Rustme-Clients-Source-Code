/*
 * Decompiled with CFR 0.150.
 */
package ru.hld.legendline.api.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class WebUtils {
    public static /* synthetic */ String agent1;
    public static /* synthetic */ String agent2;

    public static String visitSite(String lllllllllllllllIllllIllIIIlIIllI) {
        ArrayList<String> lllllllllllllllIllllIllIIIlIlIII = new ArrayList<String>();
        String lllllllllllllllIllllIllIIIlIIlll = "";
        try {
            String lllllllllllllllIllllIllIIIlIlllI;
            URL lllllllllllllllIllllIllIIIlIlIll = new URL(lllllllllllllllIllllIllIIIlIIllI);
            HttpURLConnection lllllllllllllllIllllIllIIIlIllIl = (HttpURLConnection)lllllllllllllllIllllIllIIIlIlIll.openConnection();
            lllllllllllllllIllllIllIIIlIllIl.addRequestProperty(agent1, agent2);
            BufferedReader lllllllllllllllIllllIllIIIlIllII = new BufferedReader(new InputStreamReader(lllllllllllllllIllllIllIIIlIllIl.getInputStream(), "UTF-8"));
            while ((lllllllllllllllIllllIllIIIlIlllI = lllllllllllllllIllllIllIIIlIllII.readLine()) != null) {
                lllllllllllllllIllllIllIIIlIlIII.add(lllllllllllllllIllllIllIIIlIlllI);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        for (String lllllllllllllllIllllIllIIIlIlIlI : lllllllllllllllIllllIllIIIlIlIII) {
            lllllllllllllllIllllIllIIIlIIlll = String.valueOf(new StringBuilder().append(lllllllllllllllIllllIllIIIlIIlll).append(lllllllllllllllIllllIllIIIlIlIlI));
        }
        return lllllllllllllllIllllIllIIIlIIlll;
    }

    public WebUtils() {
        WebUtils lllllllllllllllIllllIllIIIllIllI;
    }

    static {
        agent1 = "User-Agent";
        agent2 = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36";
    }
}

