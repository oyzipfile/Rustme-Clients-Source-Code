/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.text.TextFormatting
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$ElementType
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$Text
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package ru.internali.module.HUD;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;

public class Coord
extends Module {
    /* synthetic */ int pingPlayer;
    public /* synthetic */ double speedometerCurrentSpeed;
    public static final /* synthetic */ Coord INSTANCE;
    private final /* synthetic */ Minecraft mc;

    public Coord() {
        super("Coord", "Coord", Category.HUD);
        Coord llIIllIIIIllIll;
        llIIllIIIIllIll.speedometerCurrentSpeed = 0.0;
        llIIllIIIIllIll.mc = Minecraft.getMinecraft();
        CatClient.instance.settingsManager.rSetting(new Setting("Speed", llIIllIIIIllIll, true));
        CatClient.instance.settingsManager.rSetting(new Setting("SpeedKM", llIIllIIIIllIll, true));
        CatClient.instance.settingsManager.rSetting(new Setting("World", llIIllIIIIllIll, true));
    }

    public double turnIntoKpH(double llIIlIllllllIll) {
        return (double)MathHelper.sqrt((double)llIIlIllllllIll) * 71.2729367892;
    }

    static {
        INSTANCE = new Coord();
    }

    public double getSpeedKpH() {
        Coord llIIlIlllllIlll;
        double llIIlIlllllIllI = llIIlIlllllIlll.turnIntoKpH(llIIlIlllllIlll.speedometerCurrentSpeed);
        llIIlIlllllIllI = (double)Math.round(10.0 * llIIlIlllllIllI) / 10.0;
        return llIIlIlllllIllI;
    }

    @SubscribeEvent
    public void onOverlayRender(RenderGameOverlayEvent.Text llIIllIIIIIIlll) {
        if (llIIllIIIIIIlll.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            Coord llIIllIIIIIlIII;
            ScaledResolution llIIllIIIIIllII = new ScaledResolution(llIIllIIIIIlIII.mc);
            boolean llIIllIIIIIlIll = CatClient.instance.settingsManager.getSettingByName(llIIllIIIIIlIII, "Speed").getValBoolean();
            boolean llIIllIIIIIlIlI = CatClient.instance.settingsManager.getSettingByName(llIIllIIIIIlIII, "SpeedKM").getValBoolean();
            boolean llIIllIIIIIlIIl = CatClient.instance.settingsManager.getSettingByName(llIIllIIIIIlIII, "World").getValBoolean();
            if (llIIllIIIIIlIIl) {
                Vec3d llIIllIIIIlIIIl = new Vec3d((double)Math.round(llIIllIIIIIlIII.mc.player.field_70165_t * 100.0) / 100.0, (double)Math.round(llIIllIIIIIlIII.mc.player.field_70163_u * 100.0) / 100.0, (double)Math.round(llIIllIIIIIlIII.mc.player.field_70161_v * 100.0) / 100.0);
                String llIIllIIIIlIIII = String.valueOf(new StringBuilder().append((Object)TextFormatting.GRAY).append("XYZ: ").append((Object)TextFormatting.RESET).append(llIIllIIIIlIIIl.x).append(", ").append(llIIllIIIIlIIIl.y).append(", ").append(llIIllIIIIlIIIl.z));
                llIIllIIIIIlIII.mc.fontRenderer.drawStringWithShadow(llIIllIIIIlIIII, 4.0f, (float)(llIIllIIIIIllII.getScaledHeight() - llIIllIIIIIlIII.mc.fontRenderer.FONT_HEIGHT - 4), 0xFFFFFF);
            }
            if (llIIllIIIIIlIlI) {
                String llIIllIIIIIllll = String.valueOf(new StringBuilder().append((Object)TextFormatting.GRAY).append("Speed: ").append((Object)TextFormatting.RESET).append(llIIllIIIIIlIII.getSpeedKpH()));
                llIIllIIIIIlIII.mc.fontRenderer.drawStringWithShadow(llIIllIIIIIllll, 4.0f, (float)(llIIllIIIIIllII.getScaledHeight() - llIIllIIIIIlIII.mc.fontRenderer.FONT_HEIGHT - 20), 0xFFFFFF);
            }
            if (llIIllIIIIIlIll) {
                double llIIllIIIIIlllI = llIIllIIIIIlIII.mc.player.field_70165_t - llIIllIIIIIlIII.mc.player.field_70169_q;
                double llIIllIIIIIllIl = llIIllIIIIIlIII.mc.player.field_70161_v - llIIllIIIIIlIII.mc.player.field_70166_s;
                llIIllIIIIIlIII.speedometerCurrentSpeed = llIIllIIIIIlllI * llIIllIIIIIlllI + llIIllIIIIIllIl * llIIllIIIIIllIl;
            }
        }
    }
}

