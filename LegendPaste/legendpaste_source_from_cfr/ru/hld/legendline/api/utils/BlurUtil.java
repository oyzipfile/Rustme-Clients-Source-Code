/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.shader.Framebuffer
 *  net.minecraft.client.shader.Shader
 *  net.minecraft.client.shader.ShaderGroup
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package ru.hld.legendline.api.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.client.shader.Shader;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import ru.hld.legendline.antiNative.RenderUtils;

public class BlurUtil {
    private /* synthetic */ ShaderGroup shaderGroup;
    protected static /* synthetic */ Minecraft mc;
    private /* synthetic */ int lastHeight;
    private /* synthetic */ int lastWidth;
    private /* synthetic */ Framebuffer framebuffer;
    private /* synthetic */ int lastFactor;
    private final /* synthetic */ ResourceLocation resourceLocation;

    private boolean sizeHasChanged(int lIIlIIlIllllIII, int lIIlIIlIlllIIll, int lIIlIIlIlllIllI) {
        BlurUtil lIIlIIlIlllIlIl;
        return lIIlIIlIlllIlIl.lastFactor != lIIlIIlIllllIII || lIIlIIlIlllIlIl.lastWidth != lIIlIIlIlllIIll || lIIlIIlIlllIlIl.lastHeight != lIIlIIlIlllIllI;
    }

    public void init() {
        try {
            BlurUtil lIIlIIllIlIIIIl;
            lIIlIIllIlIIIIl.shaderGroup = new ShaderGroup(mc.getTextureManager(), mc.getResourceManager(), mc.getFramebuffer(), lIIlIIllIlIIIIl.resourceLocation);
            lIIlIIllIlIIIIl.shaderGroup.createBindFramebuffers(BlurUtil.mc.displayWidth, BlurUtil.mc.displayHeight);
            lIIlIIllIlIIIIl.framebuffer = lIIlIIllIlIIIIl.shaderGroup.mainFramebuffer;
        }
        catch (Exception lIIlIIllIIlllll) {
            // empty catch block
        }
    }

    public BlurUtil() {
        BlurUtil lIIlIIllIlIIlII;
        lIIlIIllIlIIlII.resourceLocation = new ResourceLocation("blur.json");
    }

    static {
        mc = Minecraft.getMinecraft();
    }

    public void blur(float lIIlIIllIIlIIIl, float lIIlIIllIIIIllI, float lIIlIIllIIIllll, float lIIlIIllIIIlllI, int lIIlIIllIIIIIll) {
        int lIIlIIllIIIlIIl;
        int lIIlIIllIIIlIlI;
        BlurUtil lIIlIIllIIlIIlI;
        ScaledResolution lIIlIIllIIIllII = new ScaledResolution(mc);
        int lIIlIIllIIIlIll = lIIlIIllIIIllII.getScaleFactor();
        if (lIIlIIllIIlIIlI.sizeHasChanged(lIIlIIllIIIlIll, lIIlIIllIIIlIlI = lIIlIIllIIIllII.getScaledWidth(), lIIlIIllIIIlIIl = lIIlIIllIIIllII.getScaledHeight()) || lIIlIIllIIlIIlI.framebuffer == null || lIIlIIllIIlIIlI.shaderGroup == null) {
            lIIlIIllIIlIIlI.init();
        }
        lIIlIIllIIlIIlI.lastFactor = lIIlIIllIIIlIll;
        lIIlIIllIIlIIlI.lastWidth = lIIlIIllIIIlIlI;
        lIIlIIllIIlIIlI.lastHeight = lIIlIIllIIIlIIl;
        GL11.glPushMatrix();
        GL11.glEnable((int)3089);
        RenderUtils.scissorRect(lIIlIIllIIlIIIl, lIIlIIllIIIIllI, lIIlIIllIIIllll, lIIlIIllIIIlllI);
        lIIlIIllIIlIIlI.framebuffer.bindFramebuffer(true);
        lIIlIIllIIlIIlI.shaderGroup.loadShaderGroup(mc.getRenderPartialTicks());
        for (int lIIlIIllIIlIIll = 0; lIIlIIllIIlIIll < 3; ++lIIlIIllIIlIIll) {
            ((Shader)lIIlIIllIIlIIlI.shaderGroup.getListShaders().get(lIIlIIllIIlIIll)).getShaderManager().getShaderUniform("Radius").set((float)lIIlIIllIIIIIll);
        }
        mc.getFramebuffer().bindFramebuffer(false);
        GL11.glDisable((int)3089);
        GL11.glPopMatrix();
    }
}

