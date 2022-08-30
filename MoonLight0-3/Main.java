/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.Mod
 *  net.minecraftforge.fml.common.Mod$EventHandler
 *  net.minecraftforge.fml.common.event.FMLInitializationEvent
 */
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import ru.internali.CatClient;

@Mod(modid="optifune", version="Beta", name="MoonLight")
public class Main {
    public Main() {
        Main lllIIIlIlllllI;
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent lllIIIlIllIlIl) throws Exception {
        CatClient.instance = new CatClient();
        CatClient.instance.init();
    }

    private static boolean lIIIIlIIllI(int n) {
        return n == 0;
    }
}

