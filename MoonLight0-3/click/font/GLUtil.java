/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  org.lwjgl.opengl.GL11
 */
package click.font;

import java.awt.Color;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.opengl.GL11;

public class GLUtil {
    public static void setColor(Color lIlIIllllIllII) {
        GL11.glColor4f((float)((float)lIlIIllllIllII.getRed() / 255.0f), (float)((float)lIlIIllllIllII.getGreen() / 255.0f), (float)((float)lIlIIllllIllII.getBlue() / 255.0f), (float)((float)lIlIIllllIllII.getAlpha() / 255.0f));
    }

    public static int toRGBA(Color lIlIIlllIIIlII) {
        return lIlIIlllIIIlII.getRed() | lIlIIlllIIIlII.getGreen() << 8 | lIlIIlllIIIlII.getBlue() << 16 | lIlIIlllIIIlII.getAlpha() << 24;
    }

    public static void drawRect(int lIlIlIIIIIIllI, double lIlIlIIIIIIlIl, double lIlIIlllllIlll, double lIlIIlllllIllI, double lIlIIlllllIlIl, int lIlIlIIIIIIIIl) {
        if (lIlIlIIIIIIlIl < lIlIIlllllIllI) {
            double lIlIlIIIIIlIII = lIlIlIIIIIIlIl;
            lIlIlIIIIIIlIl = lIlIIlllllIllI;
            lIlIIlllllIllI = lIlIlIIIIIlIII;
        }
        if (lIlIIlllllIlll < lIlIIlllllIlIl) {
            double lIlIlIIIIIIlll = lIlIIlllllIlll;
            lIlIIlllllIlll = lIlIIlllllIlIl;
            lIlIIlllllIlIl = lIlIlIIIIIIlll;
        }
        float lIlIlIIIIIIIII = (float)(lIlIlIIIIIIIIl >> 24 & 0xFF) / 255.0f;
        float lIlIIlllllllll = (float)(lIlIlIIIIIIIIl >> 16 & 0xFF) / 255.0f;
        float lIlIIllllllllI = (float)(lIlIlIIIIIIIIl >> 8 & 0xFF) / 255.0f;
        float lIlIIlllllllIl = (float)(lIlIlIIIIIIIIl & 0xFF) / 255.0f;
        Tessellator lIlIIlllllllII = Tessellator.getInstance();
        BufferBuilder lIlIIllllllIll = lIlIIlllllllII.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.color((float)lIlIIlllllllll, (float)lIlIIllllllllI, (float)lIlIIlllllllIl, (float)lIlIlIIIIIIIII);
        lIlIIllllllIll.begin(7, DefaultVertexFormats.POSITION);
        lIlIIllllllIll.pos(lIlIlIIIIIIlIl, lIlIIlllllIlIl, 0.0).endVertex();
        lIlIIllllllIll.pos(lIlIIlllllIllI, lIlIIlllllIlIl, 0.0).endVertex();
        lIlIIllllllIll.pos(lIlIIlllllIllI, lIlIIlllllIlll, 0.0).endVertex();
        lIlIIllllllIll.pos(lIlIlIIIIIIlIl, lIlIIlllllIlll, 0.0).endVertex();
        lIlIIlllllllII.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void setColor(int lIlIlIIIIllllI) {
        int lIlIlIIIIlllIl = lIlIlIIIIllllI & 0xFF;
        int lIlIlIIIIlllII = lIlIlIIIIllllI >> 8 & 0xFF;
        int lIlIlIIIIllIll = lIlIlIIIIllllI >> 16 & 0xFF;
        int lIlIlIIIIllIlI = lIlIlIIIIllllI >> 24 & 0xFF;
        GL11.glColor4b((byte)((byte)lIlIlIIIIlllIl), (byte)((byte)lIlIlIIIIlllII), (byte)((byte)lIlIlIIIIllIll), (byte)((byte)lIlIlIIIIllIlI));
    }

    public GLUtil() {
        GLUtil lIlIlIIIlIIlII;
    }

    public static void drawRect(int lIlIIlllIlllIl, int lIlIIlllIlIIIl, int lIlIIlllIllIll, int lIlIIlllIIllll, int lIlIIlllIIlllI, int lIlIIlllIllIII) {
        if (lIlIIlllIlIIIl < lIlIIlllIIllll) {
            int lIlIIlllIlllll = lIlIIlllIlIIIl;
            lIlIIlllIlIIIl = lIlIIlllIIllll;
            lIlIIlllIIllll = lIlIIlllIlllll;
        }
        if (lIlIIlllIllIll < lIlIIlllIIlllI) {
            int lIlIIlllIllllI = lIlIIlllIllIll;
            lIlIIlllIllIll = lIlIIlllIIlllI;
            lIlIIlllIIlllI = lIlIIlllIllllI;
        }
        float lIlIIlllIlIlll = (float)(lIlIIlllIllIII >> 24 & 0xFF) / 255.0f;
        float lIlIIlllIlIllI = (float)(lIlIIlllIllIII >> 16 & 0xFF) / 255.0f;
        float lIlIIlllIlIlIl = (float)(lIlIIlllIllIII >> 8 & 0xFF) / 255.0f;
        float lIlIIlllIlIlII = (float)(lIlIIlllIllIII & 0xFF) / 255.0f;
        Tessellator lIlIIlllIlIIll = Tessellator.getInstance();
        BufferBuilder lIlIIlllIlIIlI = lIlIIlllIlIIll.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.color((float)lIlIIlllIlIllI, (float)lIlIIlllIlIlIl, (float)lIlIIlllIlIlII, (float)lIlIIlllIlIlll);
        lIlIIlllIlIIlI.begin(7, DefaultVertexFormats.POSITION);
        lIlIIlllIlIIlI.pos((double)lIlIIlllIlIIIl, (double)lIlIIlllIIlllI, 0.0).endVertex();
        lIlIIlllIlIIlI.pos((double)lIlIIlllIIllll, (double)lIlIIlllIIlllI, 0.0).endVertex();
        lIlIIlllIlIIlI.pos((double)lIlIIlllIIllll, (double)lIlIIlllIllIll, 0.0).endVertex();
        lIlIIlllIlIIlI.pos((double)lIlIIlllIlIIIl, (double)lIlIIlllIllIll, 0.0).endVertex();
        lIlIIlllIlIIll.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }
}

