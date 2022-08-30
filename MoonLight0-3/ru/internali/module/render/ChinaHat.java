/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.util.glu.Cylinder
 */
package ru.internali.module.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Cylinder;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;
import ru.internali.utils.RenderUtils;

public class ChinaHat
extends Module {
    public static /* synthetic */ List<String> Modes;

    public ChinaHat() {
        super("ChinaHat", "ChinaHat", Category.RENDER);
        ChinaHat lllIlIIlIllll;
        Modes.add("V2");
        Modes.add("V1");
        CatClient.instance.settingsManager.rSetting(new Setting("Mode", lllIlIIlIllll, "V2", (ArrayList)Modes));
    }

    @SubscribeEvent
    public void onWorldRender(RenderWorldLastEvent lllIlIIlIIIII) {
        block7: {
            String lllIlIIIlllll;
            block5: {
                double lllIlIIlIIlII;
                block6: {
                    ChinaHat lllIlIIIllllI;
                    lllIlIIIlllll = CatClient.instance.settingsManager.getSettingByName(lllIlIIIllllI, "Mode").getValString();
                    if (!Objects.equals(lllIlIIIlllll, "V2")) break block5;
                    lllIlIIlIIlII = ChinaHat.mc.player.isSneaking() ? -0.1 : 0.12;
                    if (ChinaHat.mc.gameSettings.thirdPersonView == 1) break block6;
                    if (ChinaHat.mc.gameSettings.thirdPersonView != 2) break block7;
                }
                GlStateManager.pushMatrix();
                GL11.glBlendFunc((int)770, (int)771);
                GlStateManager.disableDepth();
                GlStateManager.disableTexture2D();
                RenderUtils.enableSmoothLine(2.5f);
                GL11.glShadeModel((int)7425);
                GL11.glDisable((int)2884);
                GL11.glEnable((int)3042);
                GL11.glEnable((int)2929);
                GL11.glTranslatef((float)0.0f, (float)((float)((double)ChinaHat.mc.player.field_70131_O + lllIlIIlIIlII)), (float)0.0f);
                GL11.glRotatef((float)(-ChinaHat.mc.player.field_70177_z), (float)0.0f, (float)1.0f, (float)0.0f);
                Color lllIlIIlIIllI = Color.WHITE;
                lllIlIIlIIllI = new Color(105, 55, 255);
                GL11.glBegin((int)6);
                RenderUtils.glColor(lllIlIIlIIllI, 255.0f);
                GL11.glVertex3d((double)0.0, (double)0.3, (double)0.0);
                float lllIlIIlIIlIl = 0.0f;
                while ((double)lllIlIIlIIlIl < 360.5) {
                    Color lllIlIIlIlIII = CatClient.getClientColor();
                    RenderUtils.glColor(lllIlIIlIlIII, 255.0f);
                    GL11.glVertex3d((double)(Math.cos((double)lllIlIIlIIlIl * Math.PI / 180.0) * 0.66), (double)0.0, (double)(Math.sin((double)lllIlIIlIIlIl * Math.PI / 180.0) * 0.66));
                    lllIlIIlIIlIl += 1.0f;
                }
                GL11.glVertex3d((double)0.0, (double)0.3, (double)0.0);
                GL11.glEnd();
                GL11.glBegin((int)2);
                lllIlIIlIIlIl = 0.0f;
                while ((double)lllIlIIlIIlIl < 360.5) {
                    Color lllIlIIlIIlll = CatClient.getClientColor();
                    RenderUtils.glColor(lllIlIIlIIlll, 255.0f);
                    GL11.glVertex3d((double)(Math.cos((double)lllIlIIlIIlIl * Math.PI / 180.0) * 0.66), (double)0.0, (double)(Math.sin((double)lllIlIIlIIlIl * Math.PI / 180.0) * 0.66));
                    lllIlIIlIIlIl += 1.0f;
                }
                GL11.glEnd();
                GlStateManager.enableAlpha();
                RenderUtils.disableSmoothLine();
                GL11.glShadeModel((int)7424);
                GL11.glEnable((int)2884);
                GL11.glDisable((int)3042);
                GlStateManager.enableTexture2D();
                GlStateManager.enableDepth();
                GlStateManager.resetColor();
                GlStateManager.popMatrix();
                break block7;
            }
            if (Objects.equals(lllIlIIIlllll, "V1")) {
                double lllIlIIlIIIll = ChinaHat.mc.player.isSneaking() ? -0.18 : 0.04;
                GL11.glPushMatrix();
                GL11.glBlendFunc((int)770, (int)771);
                GL11.glEnable((int)3042);
                GL11.glDisable((int)3553);
                GL11.glDepthMask((boolean)false);
                GL11.glColor4f((float)((float)Color.magenta.getRed() / 255.0f), (float)((float)Color.magenta.getGreen() / 255.0f), (float)((float)Color.magenta.getBlue() / 255.0f), (float)0.49019608f);
                GL11.glTranslatef((float)0.0f, (float)((float)((double)((float)((double)ChinaHat.mc.player.field_70131_O + 0.36)) + lllIlIIlIIIll)), (float)0.0f);
                GL11.glRotatef((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                Cylinder lllIlIIlIIIlI = new Cylinder();
                lllIlIIlIIIlI.setDrawStyle(100000);
                lllIlIIlIIIlI.setDrawStyle(100011);
                lllIlIIlIIIlI.draw(0.0f, 0.55f, 0.3f, 150, 100);
                GL11.glEnable((int)3553);
                GL11.glDepthMask((boolean)true);
                GL11.glDisable((int)3042);
                GL11.glPopMatrix();
            }
        }
    }

    static {
        Modes = new ArrayList<String>();
    }
}

