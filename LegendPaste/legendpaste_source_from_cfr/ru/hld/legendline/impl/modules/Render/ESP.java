/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.passive.EntityAnimal
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.text.TextFormatting
 *  org.lwjgl.opengl.GL11
 */
package ru.hld.legendline.impl.modules.Render;

import java.util.ArrayList;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextFormatting;
import org.lwjgl.opengl.GL11;
import ru.hld.legendline.Client;
import ru.hld.legendline.antiNative.RenderUtils;
import ru.hld.legendline.api.event.EventTarget;
import ru.hld.legendline.api.event.events.EventRender3D;
import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.api.setting.settings.BooleanSetting;
import ru.hld.legendline.api.setting.settings.ModeSetting;

public class ESP
extends Module {
    /* synthetic */ BooleanSetting friends;
    /* synthetic */ ModeSetting mode;
    /* synthetic */ BooleanSetting mobs;
    /* synthetic */ BooleanSetting players;
    /* synthetic */ BooleanSetting animals;
    /* synthetic */ float healphAnim;

    public ESP() {
        super("ESP", "draw box on player", Category.Render);
        ESP lllllllllIlI;
        lllllllllIlI.healphAnim = 0.0f;
        ArrayList<String> lllllllllIll = new ArrayList<String>();
        lllllllllIll.add("Borderless");
        lllllllllIll.add("NightMare");
        lllllllllIlI.players = new BooleanSetting("Players", "you can see players throw walls", (Module)lllllllllIlI, true);
        Client.settingManager.add(lllllllllIlI.players);
        lllllllllIlI.mobs = new BooleanSetting("Mobs", "you can see mobs throw walls", (Module)lllllllllIlI, true);
        Client.settingManager.add(lllllllllIlI.mobs);
        lllllllllIlI.animals = new BooleanSetting("Animals", "you can see animals throw walls", (Module)lllllllllIlI, true);
        Client.settingManager.add(lllllllllIlI.animals);
        lllllllllIlI.mode = new ModeSetting("Mode", "modes of ESP", lllllllllIlI, lllllllllIll, "NightMare");
        Client.settingManager.add(lllllllllIlI.mode);
        lllllllllIlI.friends = new BooleanSetting("Friends", "you can see friends throw walls", (Module)lllllllllIlI, true);
        Client.settingManager.add(lllllllllIlI.friends);
    }

    @EventTarget
    public void onRender3D(EventRender3D lllllllIIlll) {
        ESP lllllllIlIII;
        lllllllIlIII.setDisplayname(String.valueOf(new StringBuilder().append(lllllllIlIII.getName()).append(" ").append((Object)TextFormatting.WHITE).append(lllllllIlIII.mode.getVal())));
        for (Entity lllllllIlIIl : lllllllIlIII.mc.world.loadedEntityList) {
            switch (lllllllIlIII.mode.getVal()) {
                case "Borderless": {
                    if (!(lllllllIlIIl instanceof EntityPlayer && lllllllIlIIl != lllllllIlIII.mc.player && lllllllIlIII.players.getVal() || lllllllIlIIl instanceof EntityAnimal && lllllllIlIII.animals.getVal()) && (!(lllllllIlIIl instanceof EntityMob) || !lllllllIlIII.mobs.getVal())) break;
                    double lllllllIllll = lllllllIlIIl.lastTickPosX + (lllllllIlIIl.posX - lllllllIlIIl.lastTickPosX) * (double)lllllllIIlll.getPartialTicks() - lllllllIlIII.mc.getRenderManager().viewerPosX;
                    double lllllllIlllI = lllllllIlIIl.lastTickPosY + (lllllllIlIIl.posY - lllllllIlIIl.lastTickPosY) * (double)lllllllIIlll.getPartialTicks() - lllllllIlIII.mc.getRenderManager().viewerPosY;
                    double lllllllIllIl = lllllllIlIIl.lastTickPosZ + (lllllllIlIIl.posZ - lllllllIlIIl.lastTickPosZ) * (double)lllllllIIlll.getPartialTicks() - lllllllIlIII.mc.getRenderManager().viewerPosZ;
                    GL11.glPushMatrix();
                    GL11.glDisable((int)2929);
                    GL11.glDisable((int)3553);
                    GL11.glTranslatef((float)((float)lllllllIllll), (float)((float)lllllllIlllI), (float)((float)lllllllIllIl));
                    GlStateManager.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
                    GlStateManager.rotate((float)(-lllllllIlIII.mc.getRenderManager().playerViewY), (float)0.0f, (float)1.0f, (float)0.0f);
                    GlStateManager.rotate((float)lllllllIlIII.mc.getRenderManager().playerViewX, (float)1.0f, (float)0.0f, (float)0.0f);
                    GL11.glLineWidth((float)4.0f);
                    GL11.glColor3f((float)0.0f, (float)0.0f, (float)0.0f);
                    GL11.glBegin((int)3);
                    GL11.glVertex3f((float)lllllllIlIIl.width, (float)0.0f, (float)0.0f);
                    GL11.glVertex3f((float)lllllllIlIIl.width, (float)lllllllIlIIl.height, (float)0.0f);
                    GL11.glEnd();
                    GL11.glBegin((int)3);
                    GL11.glVertex3f((float)(-lllllllIlIIl.width), (float)0.0f, (float)0.0f);
                    GL11.glVertex3f((float)(-lllllllIlIIl.width), (float)lllllllIlIIl.height, (float)0.0f);
                    GL11.glEnd();
                    GL11.glBegin((int)3);
                    GL11.glVertex3f((float)(-lllllllIlIIl.width), (float)0.0f, (float)0.0f);
                    GL11.glVertex3f((float)lllllllIlIIl.width, (float)0.0f, (float)0.0f);
                    GL11.glEnd();
                    GL11.glBegin((int)3);
                    GL11.glVertex3f((float)lllllllIlIIl.width, (float)lllllllIlIIl.height, (float)0.0f);
                    GL11.glVertex3f((float)(-lllllllIlIIl.width), (float)lllllllIlIIl.height, (float)0.0f);
                    GL11.glEnd();
                    GL11.glLineWidth((float)6.0f);
                    GL11.glBegin((int)3);
                    GL11.glVertex3f((float)(lllllllIlIIl.width + 0.1f), (float)-0.003f, (float)0.0f);
                    GL11.glVertex3f((float)(lllllllIlIIl.width + 0.1f), (float)(((EntityLivingBase)lllllllIlIIl).getHealth() / ((EntityLivingBase)lllllllIlIIl).getMaxHealth() * lllllllIlIIl.height + 0.003f), (float)0.0f);
                    GL11.glEnd();
                    RenderUtils.setupColor(Client.getColor(), 255.0f);
                    GL11.glLineWidth((float)1.0f);
                    GL11.glBegin((int)3);
                    GL11.glVertex3f((float)lllllllIlIIl.width, (float)0.0f, (float)0.0f);
                    GL11.glVertex3f((float)lllllllIlIIl.width, (float)lllllllIlIIl.height, (float)0.0f);
                    GL11.glEnd();
                    GL11.glBegin((int)3);
                    GL11.glVertex3f((float)(-lllllllIlIIl.width), (float)0.0f, (float)0.0f);
                    GL11.glVertex3f((float)(-lllllllIlIIl.width), (float)lllllllIlIIl.height, (float)0.0f);
                    GL11.glEnd();
                    GL11.glBegin((int)3);
                    GL11.glVertex3f((float)(-lllllllIlIIl.width), (float)0.0f, (float)0.0f);
                    GL11.glVertex3f((float)lllllllIlIIl.width, (float)0.0f, (float)0.0f);
                    GL11.glEnd();
                    GL11.glBegin((int)3);
                    GL11.glVertex3f((float)lllllllIlIIl.width, (float)lllllllIlIIl.height, (float)0.0f);
                    GL11.glVertex3f((float)(-lllllllIlIIl.width), (float)lllllllIlIIl.height, (float)0.0f);
                    GL11.glEnd();
                    GL11.glLineWidth((float)2.0f);
                    GL11.glBegin((int)3);
                    GL11.glVertex3f((float)(lllllllIlIIl.width + 0.1f), (float)0.0f, (float)0.0f);
                    GL11.glVertex3f((float)(lllllllIlIIl.width + 0.1f), (float)(((EntityLivingBase)lllllllIlIIl).getHealth() / ((EntityLivingBase)lllllllIlIIl).getMaxHealth() * lllllllIlIIl.height), (float)0.0f);
                    GL11.glEnd();
                    GL11.glEnable((int)3553);
                    GL11.glEnable((int)2929);
                    GL11.glColor3f((float)255.0f, (float)255.0f, (float)255.0f);
                    GL11.glPopMatrix();
                    break;
                }
                case "NightMare": {
                    if (!(lllllllIlIIl instanceof EntityPlayer && lllllllIlIIl != lllllllIlIII.mc.player && lllllllIlIII.players.getVal() || lllllllIlIIl instanceof EntityAnimal && lllllllIlIII.animals.getVal()) && (!(lllllllIlIIl instanceof EntityMob) || !lllllllIlIII.mobs.getVal())) break;
                    double lllllllIllII = lllllllIlIIl.lastTickPosX + (lllllllIlIIl.posX - lllllllIlIIl.lastTickPosX) * (double)lllllllIIlll.getPartialTicks() - lllllllIlIII.mc.getRenderManager().viewerPosX;
                    double lllllllIlIll = lllllllIlIIl.lastTickPosY + (lllllllIlIIl.posY - lllllllIlIIl.lastTickPosY) * (double)lllllllIIlll.getPartialTicks() - lllllllIlIII.mc.getRenderManager().viewerPosY;
                    double lllllllIlIlI = lllllllIlIIl.lastTickPosZ + (lllllllIlIIl.posZ - lllllllIlIIl.lastTickPosZ) * (double)lllllllIIlll.getPartialTicks() - lllllllIlIII.mc.getRenderManager().viewerPosZ;
                    GL11.glPushMatrix();
                    GL11.glDisable((int)2929);
                    GL11.glDisable((int)3553);
                    GL11.glTranslatef((float)((float)lllllllIllII), (float)((float)lllllllIlIll), (float)((float)lllllllIlIlI));
                    GlStateManager.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
                    GlStateManager.rotate((float)(-lllllllIlIII.mc.getRenderManager().playerViewY), (float)0.0f, (float)1.0f, (float)0.0f);
                    GlStateManager.rotate((float)lllllllIlIII.mc.getRenderManager().playerViewX, (float)1.0f, (float)0.0f, (float)0.0f);
                    GL11.glLineWidth((float)10.0f);
                    GL11.glColor3f((float)0.0f, (float)0.0f, (float)0.0f);
                    GL11.glBegin((int)3);
                    GL11.glVertex3f((float)lllllllIlIIl.width, (float)(lllllllIlIIl.height - 0.5f), (float)0.0f);
                    GL11.glVertex3f((float)(lllllllIlIIl.width - 0.2f), (float)(lllllllIlIIl.height - 0.7f), (float)0.0f);
                    GL11.glEnd();
                    GL11.glBegin((int)3);
                    GL11.glVertex3f((float)lllllllIlIIl.width, (float)(lllllllIlIIl.height - 0.5f), (float)0.0f);
                    GL11.glVertex3f((float)(lllllllIlIIl.width - 0.2f), (float)(lllllllIlIIl.height - 0.3f), (float)0.0f);
                    GL11.glEnd();
                    GL11.glBegin((int)3);
                    GL11.glVertex3f((float)(-lllllllIlIIl.width), (float)(lllllllIlIIl.height - 0.5f), (float)0.0f);
                    GL11.glVertex3f((float)(-lllllllIlIIl.width + 0.2f), (float)(lllllllIlIIl.height - 0.7f), (float)0.0f);
                    GL11.glEnd();
                    GL11.glBegin((int)3);
                    GL11.glVertex3f((float)(-lllllllIlIIl.width), (float)(lllllllIlIIl.height - 0.5f), (float)0.0f);
                    GL11.glVertex3f((float)(-lllllllIlIIl.width + 0.2f), (float)(lllllllIlIIl.height - 0.3f), (float)0.0f);
                    GL11.glEnd();
                    GL11.glBegin((int)3);
                    GL11.glVertex3f((float)(lllllllIlIIl.width - 0.4f), (float)(lllllllIlIIl.height - 0.9f), (float)0.0f);
                    GL11.glVertex3f((float)(lllllllIlIIl.width - 0.6f), (float)(lllllllIlIIl.height - 1.1f), (float)0.0f);
                    GL11.glEnd();
                    GL11.glBegin((int)3);
                    GL11.glVertex3f((float)(-lllllllIlIIl.width + 0.4f), (float)(lllllllIlIIl.height - 0.9f), (float)0.0f);
                    GL11.glVertex3f((float)(-lllllllIlIIl.width + 0.6f), (float)(lllllllIlIIl.height - 1.1f), (float)0.0f);
                    GL11.glEnd();
                    GL11.glBegin((int)3);
                    GL11.glVertex3f((float)(lllllllIlIIl.width - 0.4f), (float)(lllllllIlIIl.height - 0.1f), (float)0.0f);
                    GL11.glVertex3f((float)(lllllllIlIIl.width - 0.6f), (float)(lllllllIlIIl.height + 0.1f), (float)0.0f);
                    GL11.glEnd();
                    GL11.glBegin((int)3);
                    GL11.glVertex3f((float)(-lllllllIlIIl.width + 0.4f), (float)(lllllllIlIIl.height - 0.1f), (float)0.0f);
                    GL11.glVertex3f((float)(-lllllllIlIIl.width + 0.6f), (float)(lllllllIlIIl.height + 0.1f), (float)0.0f);
                    GL11.glEnd();
                    RenderUtils.setupColor(Client.getColor(), 255.0f);
                    GL11.glLineWidth((float)4.0f);
                    GL11.glBegin((int)3);
                    GL11.glVertex3f((float)lllllllIlIIl.width, (float)(lllllllIlIIl.height - 0.5f), (float)0.0f);
                    GL11.glVertex3f((float)(lllllllIlIIl.width - 0.2f), (float)(lllllllIlIIl.height - 0.7f), (float)0.0f);
                    GL11.glEnd();
                    GL11.glBegin((int)3);
                    GL11.glVertex3f((float)lllllllIlIIl.width, (float)(lllllllIlIIl.height - 0.5f), (float)0.0f);
                    GL11.glVertex3f((float)(lllllllIlIIl.width - 0.2f), (float)(lllllllIlIIl.height - 0.3f), (float)0.0f);
                    GL11.glEnd();
                    GL11.glBegin((int)3);
                    GL11.glVertex3f((float)(-lllllllIlIIl.width), (float)(lllllllIlIIl.height - 0.5f), (float)0.0f);
                    GL11.glVertex3f((float)(-lllllllIlIIl.width + 0.2f), (float)(lllllllIlIIl.height - 0.7f), (float)0.0f);
                    GL11.glEnd();
                    GL11.glBegin((int)3);
                    GL11.glVertex3f((float)(-lllllllIlIIl.width), (float)(lllllllIlIIl.height - 0.5f), (float)0.0f);
                    GL11.glVertex3f((float)(-lllllllIlIIl.width + 0.2f), (float)(lllllllIlIIl.height - 0.3f), (float)0.0f);
                    GL11.glEnd();
                    GL11.glBegin((int)3);
                    GL11.glVertex3f((float)(lllllllIlIIl.width - 0.4f), (float)(lllllllIlIIl.height - 0.9f), (float)0.0f);
                    GL11.glVertex3f((float)(lllllllIlIIl.width - 0.6f), (float)(lllllllIlIIl.height - 1.1f), (float)0.0f);
                    GL11.glEnd();
                    GL11.glBegin((int)3);
                    GL11.glVertex3f((float)(-lllllllIlIIl.width + 0.4f), (float)(lllllllIlIIl.height - 0.9f), (float)0.0f);
                    GL11.glVertex3f((float)(-lllllllIlIIl.width + 0.6f), (float)(lllllllIlIIl.height - 1.1f), (float)0.0f);
                    GL11.glEnd();
                    GL11.glBegin((int)3);
                    GL11.glVertex3f((float)(lllllllIlIIl.width - 0.4f), (float)(lllllllIlIIl.height - 0.1f), (float)0.0f);
                    GL11.glVertex3f((float)(lllllllIlIIl.width - 0.6f), (float)(lllllllIlIIl.height + 0.1f), (float)0.0f);
                    GL11.glEnd();
                    GL11.glBegin((int)3);
                    GL11.glVertex3f((float)(-lllllllIlIIl.width + 0.4f), (float)(lllllllIlIIl.height - 0.1f), (float)0.0f);
                    GL11.glVertex3f((float)(-lllllllIlIIl.width + 0.6f), (float)(lllllllIlIIl.height + 0.1f), (float)0.0f);
                    GL11.glEnd();
                    GL11.glEnable((int)3553);
                    GL11.glEnable((int)2929);
                    GL11.glColor3f((float)255.0f, (float)255.0f, (float)255.0f);
                    GL11.glPopMatrix();
                    break;
                }
            }
        }
    }
}

