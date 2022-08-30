/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.Vec3d
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.opengl.GL11
 */
package ru.internali.module.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;
import ru.internali.utils.RenderUtils;
import ru.internali.utils.friend.FriendManager;

public class Tracers
extends Module {
    public static /* synthetic */ List<String> Modes;
    public static /* synthetic */ List<String> listA;

    static {
        listA = new ArrayList<String>();
        Modes = new ArrayList<String>();
    }

    @Override
    public void onDisable() {
        Tracers lIllIIlIIlIlIIl;
        super.onDisable();
    }

    @Override
    public void onEnable() {
        Tracers lIllIIlIIlIIllI;
        super.onEnable();
    }

    @SubscribeEvent
    public void onRender(RenderWorldLastEvent lIllIIlIIIIIlIl) {
        Tracers lIllIIlIIIIIIll;
        String lIllIIlIIIIIlII = CatClient.instance.settingsManager.getSettingByName(lIllIIlIIIIIIll, "Mode").getValString();
        if (Objects.equals(lIllIIlIIIIIlII, "Def")) {
            if (Minecraft.getMinecraft().player != null && Minecraft.getMinecraft().world != null) {
                boolean lIllIIlIIIlIIII = Tracers.mc.gameSettings.viewBobbing;
                Tracers.mc.gameSettings.viewBobbing = false;
                Tracers.mc.gameSettings.viewBobbing = lIllIIlIIIlIIII;
                GL11.glPushMatrix();
                GL11.glEnable((int)2848);
                GL11.glDisable((int)2929);
                GL11.glDisable((int)3553);
                GL11.glDisable((int)2896);
                GL11.glDepthMask((boolean)false);
                GL11.glBlendFunc((int)770, (int)771);
                GL11.glEnable((int)3042);
                GL11.glLineWidth((float)1.5f);
                for (Entity lIllIIlIIIlIIIl : Tracers.mc.world.field_72996_f) {
                    if (lIllIIlIIIlIIIl == Tracers.mc.player || !(lIllIIlIIIlIIIl instanceof EntityPlayer)) continue;
                    assert (mc.getRenderViewEntity() != null);
                    Tracers.mc.player.func_70032_d(lIllIIlIIIlIIIl);
                    double lIllIIlIIIlIllI = lIllIIlIIIlIIIl.lastTickPosX + (lIllIIlIIIlIIIl.posX - lIllIIlIIIlIIIl.lastTickPosX) - Tracers.mc.getRenderManager().viewerPosX;
                    double lIllIIlIIIlIlIl = lIllIIlIIIlIIIl.lastTickPosY + (lIllIIlIIIlIIIl.posY - lIllIIlIIIlIIIl.lastTickPosY) - Tracers.mc.getRenderManager().viewerPosY;
                    double lIllIIlIIIlIlII = lIllIIlIIIlIIIl.lastTickPosZ + (lIllIIlIIIlIIIl.posZ - lIllIIlIIIlIIIl.lastTickPosZ) - Tracers.mc.getRenderManager().viewerPosZ;
                    if (FriendManager.friendsList.contains(lIllIIlIIIlIIIl.getName())) {
                        GL11.glColor4f((float)0.0f, (float)255.0f, (float)0.0f, (float)255.0f);
                    } else {
                        GL11.glColor4f((float)255.0f, (float)255.0f, (float)255.0f, (float)255.0f);
                    }
                    Vec3d lIllIIlIIIlIIll = new Vec3d(0.0, 0.0, 1.0);
                    lIllIIlIIIlIIll = lIllIIlIIIlIIll.rotatePitch(-((float)Math.toRadians(Tracers.mc.player.field_70125_A)));
                    Vec3d lIllIIlIIIlIIlI = lIllIIlIIIlIIll.rotateYaw(-((float)Math.toRadians(Tracers.mc.player.field_70177_z)));
                    GL11.glBegin((int)2);
                    GL11.glVertex3d((double)lIllIIlIIIlIIlI.x, (double)((double)Tracers.mc.player.func_70047_e() + lIllIIlIIIlIIlI.y), (double)lIllIIlIIIlIIlI.z);
                    GL11.glVertex3d((double)lIllIIlIIIlIllI, (double)(lIllIIlIIIlIlIl + 1.1), (double)lIllIIlIIIlIlII);
                    GL11.glEnd();
                }
                GL11.glDisable((int)3042);
                GL11.glDepthMask((boolean)true);
                GL11.glEnable((int)3553);
                GL11.glEnable((int)2929);
                GL11.glDisable((int)2848);
                GL11.glPopMatrix();
            }
        } else if (Objects.equals(lIllIIlIIIIIlII, "Tusk")) {
            Tracers.mc.gameSettings.viewBobbing = false;
            GL11.glPushMatrix();
            GL11.glEnable((int)2848);
            GL11.glDisable((int)2929);
            GL11.glDisable((int)3553);
            GL11.glDisable((int)2896);
            GL11.glDepthMask((boolean)false);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glEnable((int)2848);
            GL11.glEnable((int)3042);
            GL11.glLineWidth((float)2.0E-6f);
            for (Entity lIllIIlIIIIlIIl : Tracers.mc.world.field_72996_f) {
                Minecraft lIllIIlIIIIlIII = mc;
                if (lIllIIlIIIIlIIl == Tracers.mc.player || !(lIllIIlIIIIlIIl instanceof EntityPlayer)) continue;
                assert (mc.getRenderViewEntity() != null);
                Minecraft lIllIIlIIIIllll = mc;
                Tracers.mc.player.func_70032_d(lIllIIlIIIIlIIl);
                double lIllIIlIIIIlllI = lIllIIlIIIIlIIl.lastTickPosX + (lIllIIlIIIIlIIl.posX - lIllIIlIIIIlIIl.lastTickPosX) - Tracers.mc.getRenderManager().viewerPosX;
                double lIllIIlIIIIllIl = lIllIIlIIIIlIIl.lastTickPosY + (lIllIIlIIIIlIIl.posY - lIllIIlIIIIlIIl.lastTickPosY) - Tracers.mc.getRenderManager().viewerPosY;
                double lIllIIlIIIIllII = lIllIIlIIIIlIIl.lastTickPosZ + (lIllIIlIIIIlIIl.posZ - lIllIIlIIIIlIIl.lastTickPosZ) - Tracers.mc.getRenderManager().viewerPosZ;
                Vec3d lIllIIlIIIIlIll = new Vec3d(0.0, 0.0, 1.0);
                lIllIIlIIIIlIII = mc;
                lIllIIlIIIIlIll = lIllIIlIIIIlIll.rotatePitch(-((float)Math.toRadians(Tracers.mc.player.field_70125_A)));
                lIllIIlIIIIlIII = mc;
                Vec3d lIllIIlIIIIlIlI = lIllIIlIIIIlIll.rotateYaw(-((float)Math.toRadians(Tracers.mc.player.field_70177_z)));
                GL11.glBegin((int)2);
                if (FriendManager.isFriend(lIllIIlIIIIlIIl.getName())) {
                    RenderUtils.setColor(CatClient.getClientColor());
                } else {
                    RenderUtils.setColor(Color.white);
                }
                lIllIIlIIIIlIII = mc;
                GL11.glVertex3d((double)lIllIIlIIIIlIlI.x, (double)((double)Tracers.mc.player.func_70047_e() + lIllIIlIIIIlIlI.y), (double)lIllIIlIIIIlIlI.z);
                GL11.glVertex3d((double)lIllIIlIIIIlllI, (double)(lIllIIlIIIIllIl + 1.1), (double)lIllIIlIIIIllII);
                GL11.glEnd();
            }
            GL11.glDisable((int)3042);
            GL11.glDepthMask((boolean)true);
            GL11.glDisable((int)2848);
            GL11.glEnable((int)3553);
            GL11.glEnable((int)2929);
            GL11.glDisable((int)2848);
            GL11.glPopMatrix();
        }
    }

    public Tracers() {
        super("Tracers", "Show Tracers to players", Category.RENDER);
        Tracers lIllIIlIIlIlIll;
        Modes.add("Def");
        Modes.add("Tusk");
        CatClient.instance.settingsManager.rSetting(new Setting("Mode", lIllIIlIIlIlIll, "Def", (ArrayList)Modes));
    }
}

