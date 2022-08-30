/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 *  org.lwjgl.opengl.GL11
 */
package ru.internali.module.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.opengl.GL11;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.module.render.trail;
import ru.internali.settings.Setting;
import ru.internali.utils.RenderUtils;

public class Trails
extends Module {
    public static /* synthetic */ List<String> Modes;
    private /* synthetic */ Color Colorid;
    /* synthetic */ ArrayList<trail> trails;

    public static Color getRainbowChams(int llIIllIIllIlIlI, int llIIllIIllIllII) {
        float llIIllIIllIlIll = (System.currentTimeMillis() * 1L + (long)(llIIllIIllIllII / 2)) % (long)llIIllIIllIlIlI * 2L;
        return Color.getHSBColor(llIIllIIllIlIll /= (float)llIIllIIllIlIlI, 1.0f, 1.0f);
    }

    public Trails() {
        super("Trails", "Trails", Category.RENDER);
        Trails llIIllIIlllIIIl;
        llIIllIIlllIIIl.trails = new ArrayList();
        Modes.add("Rainbow");
        Modes.add("Client");
        CatClient.instance.settingsManager.rSetting(new Setting("Mode", llIIllIIlllIIIl, "Rainbow", (ArrayList)Modes));
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent llIIllIIlIlIlll) {
        Trails llIIllIIlIlIllI;
        llIIllIIlIlIllI.trails.add(new trail(Trails.mc.player.field_70142_S, Trails.mc.player.field_70137_T, Trails.mc.player.field_70136_U));
    }

    static {
        Modes = new ArrayList<String>();
    }

    @SubscribeEvent
    public void Trails(RenderWorldLastEvent llIIllIIlIlllll) {
        Trails llIIllIIlIlllIl;
        String llIIllIIlIllllI = CatClient.instance.settingsManager.getSettingByName(llIIllIIlIlllIl, "Mode").getValString();
        if (Objects.equals(llIIllIIlIllllI, "Rainbow")) {
            GL11.glPushMatrix();
            GlStateManager.disableDepth();
            GlStateManager.enableBlend();
            GL11.glDisable((int)3008);
            GL11.glDisable((int)2884);
            GL11.glDisable((int)3553);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glShadeModel((int)7425);
            GL11.glBegin((int)8);
            llIIllIIlIlllIl.Colorid = Trails.getRainbowChams(6000, -17);
            RenderUtils.glColor(llIIllIIlIlllIl.Colorid, 180.0f);
        } else if (Objects.equals(llIIllIIlIllllI, "Client")) {
            GL11.glPushMatrix();
            GlStateManager.disableDepth();
            GlStateManager.enableBlend();
            GL11.glDisable((int)3008);
            GL11.glDisable((int)2884);
            GL11.glDisable((int)3553);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glShadeModel((int)7425);
            GL11.glBegin((int)8);
            Color llIIllIIllIIIll = Trails.getRainbowChams(6000, -17);
            RenderUtils.glColor(llIIllIIllIIIll, 180.0f);
        }
        for (int llIIllIIllIIIIl = 0; llIIllIIllIIIIl < llIIllIIlIlllIl.trails.size(); ++llIIllIIllIIIIl) {
            trail llIIllIIllIIIlI = llIIllIIlIlllIl.trails.get(llIIllIIllIIIIl);
            if (llIIllIIllIIIlI.getTimer().isDeley(1000L)) {
                llIIllIIlIlllIl.trails.remove(llIIllIIllIIIlI);
            }
            RenderUtils.putVertex3d(RenderUtils.getRenderPos(llIIllIIllIIIlI.getX(), llIIllIIllIIIlI.getY(), llIIllIIllIIIlI.getZ()));
            RenderUtils.putVertex3d(RenderUtils.getRenderPos(llIIllIIllIIIlI.getX(), llIIllIIllIIIlI.getY() + (double)Trails.mc.player.field_70131_O, llIIllIIllIIIlI.getZ()));
        }
        GL11.glEnd();
        GL11.glEnable((int)3553);
        GlStateManager.disableBlend();
        GlStateManager.enableDepth();
        GL11.glEnable((int)3008);
        GL11.glShadeModel((int)7424);
        GL11.glEnable((int)2884);
        GL11.glPopMatrix();
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }
}

