/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 *  net.minecraftforge.client.event.RenderGameOverlayEvent
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$ElementType
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.opengl.GL11
 */
package ru.internali.module.HUD;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.utils.RenderUtil;
import ru.internali.utils.TimerUtils;

public class GappelHud
extends Module {
    private final /* synthetic */ FontRenderer fr;
    public static /* synthetic */ TimerUtils timer;
    public static /* synthetic */ boolean eat;

    public GappelHud() {
        super("GappelHud", "GappelHud", Category.HUD);
        GappelHud lllllllIlllllll;
        lllllllIlllllll.fr = Minecraft.getMinecraft().fontRenderer;
        timer = new TimerUtils();
    }

    static {
        eat = true;
    }

    @SubscribeEvent
    public void onOverlayRender(RenderGameOverlayEvent lllllllIlllIlll) {
        if (lllllllIlllIlll.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            GappelHud lllllllIllllIlI;
            ScaledResolution lllllllIllllIll = new ScaledResolution(mc);
            if (eat) {
                timer.reset();
            }
            if (timer.isDeley(2500L)) {
                RenderUtil.drawCircle222(lllllllIllllIlI.getPosX() + 25, lllllllIllllIlI.getPosY() + 25, 20.0f, Color.green.getRGB(), 360);
            } else {
                RenderUtil.drawCircle222(lllllllIllllIlI.getPosX() + 25, lllllllIllllIlI.getPosY() + 25, 20.0f, CatClient.getClientColor().getRGB(), (int)(timer.getTime() / 6L));
            }
            GL11.glPushMatrix();
            RenderUtil.customScaledObject2D(lllllllIllllIlI.getPosX(), lllllllIllllIlI.getPosY(), 50.0f, 50.0f, 2.0f);
            RenderUtil.renderItem(new ItemStack(Items.GOLDEN_APPLE), lllllllIllllIlI.getPosX() + 25 - 8, lllllllIllllIlI.getPosY() + 25 - 8);
            lllllllIllllIlI.fr.drawString("", 0, 0, Color.white.getRGB());
            GL11.glPopMatrix();
        }
    }
}

