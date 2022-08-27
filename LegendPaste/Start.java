/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.main.Main
 */
import java.util.Arrays;
import net.minecraft.client.main.Main;

public class Start {
    public Start() {
        Start lllllllllllllllllIlIIlIIllIIIIll;
    }

    public static void main(String[] lllllllllllllllllIlIIlIIllIIIIII) {
        Main.main((String[])Start.concat(new String[]{"--version", "mcp", "--accessToken", "0", "--assetsDir", "assets", "--assetIndex", "1.12", "--userProperties", "{}"}, lllllllllllllllllIlIIlIIllIIIIII));
    }

    public static <T> T[] concat(T[] lllllllllllllllllIlIIlIIlIlllIll, T[] lllllllllllllllllIlIIlIIlIllIlll) {
        T[] lllllllllllllllllIlIIlIIlIlllIIl = Arrays.copyOf(lllllllllllllllllIlIIlIIlIlllIll, lllllllllllllllllIlIIlIIlIlllIll.length + lllllllllllllllllIlIIlIIlIllIlll.length);
        System.arraycopy(lllllllllllllllllIlIIlIIlIllIlll, 0, lllllllllllllllllIlIIlIIlIlllIIl, lllllllllllllllllIlIIlIIlIlllIll.length, lllllllllllllllllIlIIlIIlIllIlll.length);
        return lllllllllllllllllIlIIlIIlIlllIIl;
    }
}

