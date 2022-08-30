/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Vec3d
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 *  org.lwjgl.opengl.GL11
 */
package ru.internali.module.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.opengl.GL11;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.module.render.Circle;

public class JumpCircles
extends Module {
    static /* synthetic */ float pt;
    static /* synthetic */ Color jumpCircleColor;
    static /* synthetic */ List<Circle> circles;
    static final /* synthetic */ int TYPE;
    static final /* synthetic */ byte MAX_JC_TIME;

    static {
        MAX_JC_TIME = (byte)20;
        TYPE = 0;
        jumpCircleColor = CatClient.getClientColor();
        circles = new ArrayList<Circle>();
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent lIlllIIIlIlIIII) {
        if (JumpCircles.mc.player.field_70181_x == 0.33319999363422365) {
            JumpCircles.handleEntityJump((Entity)JumpCircles.mc.player);
        }
        JumpCircles.onLocalPlayerUpdate(JumpCircles.mc.player);
    }

    public JumpCircles() {
        super("JumpCircles", "JumpCircles", Category.RENDER);
        JumpCircles lIlllIIIlIlIIlI;
    }

    public static void handleEntityJump(Entity lIlllIIIIIllllI) {
        int lIlllIIIIlIIIlI = (int)((float)(jumpCircleColor.getRed() >> 16 & 0xFF) / 100.0f);
        int lIlllIIIIlIIIIl = (int)((float)(jumpCircleColor.getGreen() >> 8 & 0xFF) / 100.0f);
        int lIlllIIIIlIIIII = (int)((float)(jumpCircleColor.getBlue() & 0xFF) / 100.0f);
        Vec3d lIlllIIIIIlllll = new Vec3d((double)lIlllIIIIlIIIlI, (double)lIlllIIIIlIIIIl, (double)lIlllIIIIlIIIII);
        circles.add(new Circle(lIlllIIIIIllllI.getPositionVector(), lIlllIIIIIlllll));
    }

    public static void onLocalPlayerUpdate(EntityPlayerSP lIlllIIIIlIlIIl) {
        circles.removeIf(Circle::update);
    }

    @SubscribeEvent
    public void JumpCircles(RenderWorldLastEvent lIlllIIIIlllIlI) {
        EntityPlayerSP lIlllIIIIlllIIl = JumpCircles.mc.player;
        double lIlllIIIIlllIII = -(lIlllIIIIlllIIl.field_70142_S + (lIlllIIIIlllIIl.field_70165_t - lIlllIIIIlllIIl.field_70142_S) * (double)mc.getRenderPartialTicks());
        double lIlllIIIIllIlll = -(lIlllIIIIlllIIl.field_70137_T + (lIlllIIIIlllIIl.field_70163_u - lIlllIIIIlllIIl.field_70137_T) * (double)mc.getRenderPartialTicks());
        double lIlllIIIIllIllI = -(lIlllIIIIlllIIl.field_70136_U + (lIlllIIIIlllIIl.field_70161_v - lIlllIIIIlllIIl.field_70136_U) * (double)mc.getRenderPartialTicks());
        GL11.glPushMatrix();
        GL11.glTranslated((double)lIlllIIIIlllIII, (double)lIlllIIIIllIlll, (double)lIlllIIIIllIllI);
        GL11.glDisable((int)2884);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)3008);
        GL11.glDisable((int)2929);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDisable((int)2896);
        GL11.glShadeModel((int)7425);
        Collections.reverse(circles);
        try {
            for (Circle lIlllIIIlIIIIlI : circles) {
                float lIlllIIIlIIIIIl = (float)lIlllIIIlIIIIlI.existed / 20.0f;
                double lIlllIIIlIIIIII = lIlllIIIlIIIIlI.position().x;
                double lIlllIIIIllllll = lIlllIIIlIIIIlI.position().y - (double)lIlllIIIlIIIIIl * 0.5;
                double lIlllIIIIlllllI = lIlllIIIlIIIIlI.position().z;
                float lIlllIIIIllllIl = lIlllIIIlIIIIIl + 1.0f - lIlllIIIlIIIIIl;
                GL11.glBegin((int)8);
                for (int lIlllIIIlIIIIll = 0; lIlllIIIlIIIIll <= 360; lIlllIIIlIIIIll += 5) {
                    GL11.glColor4f((float)((float)lIlllIIIlIIIIlI.color().x), (float)((float)lIlllIIIlIIIIlI.color().y), (float)((float)lIlllIIIlIIIIlI.color().z), (float)(0.2f * (1.0f - (float)lIlllIIIlIIIIlI.existed / 20.0f)));
                    GL11.glVertex3d((double)(lIlllIIIlIIIIII + Math.cos(Math.toRadians(lIlllIIIlIIIIll * 4)) * (double)lIlllIIIlIIIIIl), (double)lIlllIIIIllllll, (double)(lIlllIIIIlllllI + Math.sin(Math.toRadians(lIlllIIIlIIIIll * 4)) * (double)lIlllIIIlIIIIIl));
                    GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.01f * (1.0f - (float)lIlllIIIlIIIIlI.existed / 20.0f)));
                    GL11.glVertex3d((double)(lIlllIIIlIIIIII + Math.cos(Math.toRadians(lIlllIIIlIIIIll)) * (double)lIlllIIIIllllIl), (double)(lIlllIIIIllllll + Math.sin(lIlllIIIlIIIIIl * 8.0f) * 0.5), (double)(lIlllIIIIlllllI + Math.sin(Math.toRadians(lIlllIIIlIIIIll) * (double)lIlllIIIIllllIl)));
                }
                GL11.glEnd();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        Collections.reverse(circles);
        GL11.glEnable((int)2896);
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glShadeModel((int)7424);
        GL11.glEnable((int)2884);
        GL11.glEnable((int)2929);
        GL11.glEnable((int)3008);
        GL11.glPopMatrix();
    }
}

