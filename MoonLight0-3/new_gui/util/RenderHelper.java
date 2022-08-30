/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package new_gui.util;

import java.awt.Color;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;
import new_gui.util.DrawHelper;
import org.lwjgl.opengl.GL11;

public final class RenderHelper {
    public RenderHelper() {
        RenderHelper lllIllIlIlIllI;
    }

    public static void customScaledObject2D(float lllIllIIIIlllI, float lllIllIIIIllIl, float lllIllIIIIIllI, float lllIllIIIIIlIl, float lllIllIIIIIlII, float lllIllIIIIIIll) {
        GL11.glTranslated((double)(lllIllIIIIIllI / 2.0f), (double)(lllIllIIIIIlIl / 2.0f), (double)1.0);
        GL11.glTranslated((double)(-lllIllIIIIlllI * lllIllIIIIIlII + lllIllIIIIlllI + lllIllIIIIIllI / 2.0f * -lllIllIIIIIlII), (double)(-lllIllIIIIllIl * lllIllIIIIIIll + lllIllIIIIllIl + lllIllIIIIIlIl / 2.0f * -lllIllIIIIIIll), (double)1.0);
        GL11.glScaled((double)lllIllIIIIIlII, (double)lllIllIIIIIIll, (double)0.0);
    }

    public static void enableGL2D() {
        GL11.glDisable((int)2929);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDepthMask((boolean)true);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glHint((int)3155, (int)4354);
    }

    public static void disableGL2D() {
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glEnable((int)2929);
        GL11.glDisable((int)2848);
        GL11.glHint((int)3154, (int)4352);
        GL11.glHint((int)3155, (int)4352);
    }

    public static void drawFullCircle(double lllIllIIlIlllI, double lllIllIIllIllI, double lllIllIIllIlIl, int lllIllIIllIlII) {
        lllIllIIllIlIl *= 2.0;
        lllIllIIlIlllI *= 2.0;
        lllIllIIllIllI *= 2.0;
        float lllIllIIllIIll = (float)(lllIllIIllIlII >> 24 & 0xFF) / 255.0f;
        float lllIllIIllIIlI = (float)(lllIllIIllIlII >> 16 & 0xFF) / 255.0f;
        float lllIllIIllIIIl = (float)(lllIllIIllIlII >> 8 & 0xFF) / 255.0f;
        float lllIllIIllIIII = (float)(lllIllIIllIlII & 0xFF) / 255.0f;
        RenderHelper.enableGL2D();
        GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
        GL11.glColor4f((float)lllIllIIllIIlI, (float)lllIllIIllIIIl, (float)lllIllIIllIIII, (float)lllIllIIllIIll);
        GL11.glBegin((int)6);
        for (int lllIllIIlIllll = 0; lllIllIIlIllll <= 360; ++lllIllIIlIllll) {
            double lllIllIIlllIIl = Math.sin((double)lllIllIIlIllll * Math.PI / 180.0) * lllIllIIllIlIl;
            double lllIllIIlllIII = Math.cos((double)lllIllIIlIllll * Math.PI / 180.0) * lllIllIIllIlIl;
            GL11.glVertex2d((double)(lllIllIIlIlllI + lllIllIIlllIIl), (double)(lllIllIIllIllI + lllIllIIlllIII));
        }
        GL11.glEnd();
        GL11.glScalef((float)2.0f, (float)2.0f, (float)2.0f);
        RenderHelper.disableGL2D();
    }

    public static void customScaledObject2D(float lllIllIIIllIIl, float lllIllIIIllIII, float lllIllIIIlllII, float lllIllIIIllIll, float lllIllIIIllIlI) {
        GL11.glTranslated((double)(lllIllIIIlllII / 2.0f), (double)(lllIllIIIllIll / 2.0f), (double)1.0);
        GL11.glTranslated((double)(-lllIllIIIllIIl * lllIllIIIllIlI + lllIllIIIllIIl + lllIllIIIlllII / 2.0f * -lllIllIIIllIlI), (double)(-lllIllIIIllIII * lllIllIIIllIlI + lllIllIIIllIII + lllIllIIIllIll / 2.0f * -lllIllIIIllIlI), (double)1.0);
        GL11.glScaled((double)lllIllIIIllIlI, (double)lllIllIIIllIlI, (double)0.0);
    }

    public static void drawImage(ResourceLocation lllIllIlIIllll, float lllIllIlIIlllI, float lllIllIlIIlIII, float lllIllIlIIIlll, float lllIllIlIIIllI, Color lllIllIlIIIlIl) {
        GL11.glDisable((int)2929);
        GL11.glEnable((int)3042);
        GL11.glDepthMask((boolean)false);
        OpenGlHelper.glBlendFunc((int)770, (int)771, (int)1, (int)0);
        DrawHelper.setColor(lllIllIlIIIlIl.getRGB());
        Gui.drawModalRectWithCustomSizedTexture((int)((int)lllIllIlIIlllI), (int)((int)lllIllIlIIlIII), (float)0.0f, (float)0.0f, (int)((int)lllIllIlIIIlll), (int)((int)lllIllIlIIIllI), (float)lllIllIlIIIlll, (float)lllIllIlIIIllI);
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)3042);
        GL11.glEnable((int)2929);
    }
}

