/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.entity.Entity
 *  net.minecraftforge.client.event.RenderGameOverlayEvent
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$ElementType
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.opengl.GL11
 */
package ru.internali.module.render;

import java.awt.Color;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;
import ru.internali.utils.CastHelper;

public class Chams
extends Module {
    public static int getRainbowChams(int lllIIllIlllIlll, int lllIIllIlllIllI) {
        float lllIIllIlllIlIl = (System.currentTimeMillis() * 1L + (long)(lllIIllIlllIllI / 2)) % (long)lllIIllIlllIlll * 2L;
        return Color.getHSBColor(lllIIllIlllIlIl /= (float)lllIIllIlllIlll, 1.0f, 1.0f).getRGB();
    }

    public Chams() {
        super("Chams", "ChinaHat", Category.RENDER);
        Chams lllIIlllIIlIlll;
        CatClient.instance.settingsManager.rSetting(new Setting("red", lllIIlllIIlIlll, 255.0, 1.0, 255.0, true));
        CatClient.instance.settingsManager.rSetting(new Setting("green", lllIIlllIIlIlll, 255.0, 1.0, 255.0, true));
        CatClient.instance.settingsManager.rSetting(new Setting("blue", lllIIlllIIlIlll, 255.0, 1.0, 255.0, true));
    }

    @SubscribeEvent
    public void onRenderWorld(RenderGameOverlayEvent lllIIlllIIIIIll) {
        if (lllIIlllIIIIIll.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            for (Entity lllIIlllIIIIllI : Chams.mc.world.field_72996_f) {
                CastHelper lllIIlllIIIlIII = new CastHelper();
                lllIIlllIIIlIII.apply(CastHelper.EntityType.PLAYERS);
                CastHelper.EntityType lllIIlllIIIIlll = CastHelper.isInstanceof(lllIIlllIIIIllI, lllIIlllIIIlIII.build());
                if (lllIIlllIIIIlll == null) continue;
                float lllIIlllIIIllII = 255.0f;
                float lllIIlllIIIlIll = 255.0f;
                float lllIIlllIIIlIlI = 255.0f;
                float lllIIlllIIIlIIl = 255.0f;
                GL11.glPushMatrix();
                GlStateManager.disableBlend();
                OpenGlHelper.setLightmapTextureCoords((int)OpenGlHelper.lightmapTexUnit, (float)240.0f, (float)240.0f);
                GL11.glEnable((int)3042);
                GL11.glDisable((int)3553);
                GL11.glBlendFunc((int)770, (int)771);
                GlStateManager.color((float)lllIIlllIIIllII, (float)lllIIlllIIIlIll, (float)lllIIlllIIIlIlI, (float)lllIIlllIIIlIIl);
            }
        }
    }
}

