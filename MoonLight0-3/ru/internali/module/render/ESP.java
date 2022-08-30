/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderGlobal
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.ItemAir
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.Vec3d
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.opengl.GL11
 */
package ru.internali.module.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAir;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;
import ru.internali.utils.friend.FriendManager;

public class ESP
extends Module {
    public static /* synthetic */ List<String> listA;
    public static /* synthetic */ List<String> Heal;
    public static /* synthetic */ List<String> Modes;

    public static void renderEntityBoundingBox(Entity lllIlIlIllIllII, float lllIlIlIllIIIll, float lllIlIlIllIlIlI, float lllIlIlIllIlIIl, float lllIlIlIllIIIII) {
        RenderManager lllIlIlIllIIlll = Minecraft.getMinecraft().getRenderManager();
        Vec3d lllIlIlIllIIllI = ESP.interpolateEntity(lllIlIlIllIllII);
        GlStateManager.glLineWidth((float)5.0f);
        AxisAlignedBB lllIlIlIllIIlIl = new AxisAlignedBB(lllIlIlIllIIllI.x - (double)(lllIlIlIllIllII.width / 2.0f), lllIlIlIllIIllI.y, lllIlIlIllIIllI.z - (double)(lllIlIlIllIllII.width / 2.0f), lllIlIlIllIIllI.x + (double)(lllIlIlIllIllII.width / 2.0f), lllIlIlIllIIllI.y + (double)lllIlIlIllIllII.height, lllIlIlIllIIllI.z + (double)(lllIlIlIllIllII.width / 2.0f)).offset(-lllIlIlIllIIlll.viewerPosX, -lllIlIlIllIIlll.viewerPosY, -lllIlIlIllIIlll.viewerPosZ);
        RenderGlobal.drawSelectionBoundingBox((AxisAlignedBB)lllIlIlIllIIlIl, (float)lllIlIlIllIIIll, (float)lllIlIlIllIlIlI, (float)lllIlIlIllIlIIl, (float)lllIlIlIllIIIII);
        GlStateManager.glLineWidth((float)1.0f);
    }

    @Override
    public void onDisable() {
        ESP lllIlIllllIllIl;
        super.onDisable();
        for (Entity lllIlIllllIlllI : ESP.mc.world.field_72996_f) {
            if (!(lllIlIllllIlllI instanceof EntityPlayer) || !lllIlIllllIlllI.isGlowing()) continue;
            lllIlIllllIlllI.setGlowing(false);
        }
    }

    public static void renderEntityFilledBoundingBox(Entity lllIlIllIIIlIlI, float lllIlIllIIIlIIl, float lllIlIllIIIIIII, float lllIlIlIlllllll, float lllIlIlIllllllI) {
        RenderManager lllIlIllIIIIlIl = Minecraft.getMinecraft().getRenderManager();
        Vec3d lllIlIllIIIIlII = ESP.interpolateEntity(lllIlIllIIIlIlI);
        AxisAlignedBB lllIlIllIIIIIll = new AxisAlignedBB(lllIlIllIIIIlII.x - (double)(lllIlIllIIIlIlI.width / 2.0f), lllIlIllIIIIlII.y, lllIlIllIIIIlII.z - (double)(lllIlIllIIIlIlI.width / 2.0f), lllIlIllIIIIlII.x + (double)(lllIlIllIIIlIlI.width / 2.0f), lllIlIllIIIIlII.y + (double)lllIlIllIIIlIlI.height, lllIlIllIIIIlII.z + (double)(lllIlIllIIIlIlI.width / 2.0f)).offset(-lllIlIllIIIIlIl.viewerPosX, -lllIlIllIIIIlIl.viewerPosY, -lllIlIllIIIIlIl.viewerPosZ);
        RenderGlobal.renderFilledBox((AxisAlignedBB)lllIlIllIIIIIll, (float)lllIlIllIIIlIIl, (float)lllIlIllIIIIIII, (float)lllIlIlIlllllll, (float)lllIlIlIllllllI);
    }

    @Override
    public void onEnable() {
        ESP lllIlIllllIIlll;
        super.onEnable();
    }

    public static Vec3d interpolateEntity(Entity lllIlIlIllllIII) {
        double lllIlIlIlllIlll = Minecraft.getMinecraft().getRenderPartialTicks();
        return new Vec3d(lllIlIlIllllIII.lastTickPosX + (lllIlIlIllllIII.posX - lllIlIlIllllIII.lastTickPosX) * lllIlIlIlllIlll, lllIlIlIllllIII.lastTickPosY + (lllIlIlIllllIII.posY - lllIlIlIllllIII.lastTickPosY) * lllIlIlIlllIlll, lllIlIlIllllIII.lastTickPosZ + (lllIlIlIllllIII.posZ - lllIlIlIllllIII.lastTickPosZ) * lllIlIlIlllIlll);
    }

    static {
        listA = new ArrayList<String>();
        Modes = new ArrayList<String>();
        Heal = new ArrayList<String>();
    }

    public ESP() {
        super("ESP", "Show players", Category.RENDER);
        ESP lllIlIlllllIIll;
        Modes.add("3D");
        Modes.add("2D");
        Modes.add("NoneCode");
        Modes.add("Glowing");
        Modes.add("Corners");
        Modes.add("OnHeal");
        CatClient.instance.settingsManager.rSetting(new Setting("Mode", lllIlIlllllIIll, "2D", (ArrayList)Modes));
        CatClient.instance.settingsManager.rSetting(new Setting("Health[2D]", lllIlIlllllIIll, true));
        CatClient.instance.settingsManager.rSetting(new Setting("healthValue[2D]", lllIlIlllllIIll, true));
        CatClient.instance.settingsManager.rSetting(new Setting("Box[2D]", lllIlIlllllIIll, true));
        CatClient.instance.settingsManager.rSetting(new Setting("Tag[2D]", lllIlIlllllIIll, true));
        CatClient.instance.settingsManager.rSetting(new Setting("Show item[2D]", lllIlIlllllIIll, false));
        CatClient.instance.settingsManager.rSetting(new Setting("3DAlpha[3D]", lllIlIlllllIIll, 0.7, 0.0, 1.0, false));
        Heal.add("Right");
        Heal.add("Left");
        CatClient.instance.settingsManager.rSetting(new Setting("PosHp[2D]", lllIlIlllllIIll, "Right", (ArrayList)Heal));
        CatClient.instance.settingsManager.rSetting(new Setting("redBox[2D]", lllIlIlllllIIll, 0.8, 0.1, 255.0, false));
        CatClient.instance.settingsManager.rSetting(new Setting("greenBox[2D]", lllIlIlllllIIll, 0.8, 0.1, 255.0, false));
        CatClient.instance.settingsManager.rSetting(new Setting("blueBox[2D]", lllIlIlllllIIll, 0.8, 0.1, 255.0, false));
    }

    @SubscribeEvent
    public void onRenderWorld(RenderWorldLastEvent lllIlIllIllIlIl) {
        block32: {
            String lllIlIllIllIIll;
            block35: {
                block34: {
                    float lllIlIllIlIllIl;
                    block33: {
                        block31: {
                            ESP lllIlIllIllIllI;
                            String lllIlIllIllIlII = CatClient.instance.settingsManager.getSettingByName(lllIlIllIllIllI, "PosHp[2D]").getValString();
                            lllIlIllIllIIll = CatClient.instance.settingsManager.getSettingByName(lllIlIllIllIllI, "Mode").getValString();
                            boolean lllIlIllIllIIlI = CatClient.instance.settingsManager.getSettingByName(lllIlIllIllIllI, "Health[2D]").getValBoolean();
                            boolean lllIlIllIllIIIl = CatClient.instance.settingsManager.getSettingByName(lllIlIllIllIllI, "healthValue[2D]").getValBoolean();
                            boolean lllIlIllIllIIII = CatClient.instance.settingsManager.getSettingByName(lllIlIllIllIllI, "Box[2D]").getValBoolean();
                            boolean lllIlIllIlIllll = CatClient.instance.settingsManager.getSettingByName(lllIlIllIllIllI, "Tag[2D]").getValBoolean();
                            boolean lllIlIllIlIlllI = CatClient.instance.settingsManager.getSettingByName(lllIlIllIllIllI, "Show item[2D]").getValBoolean();
                            lllIlIllIlIllIl = (float)CatClient.instance.settingsManager.getSettingByName(lllIlIllIllIllI, "3DAlpha[3D]").getValDouble();
                            float lllIlIllIlIllII = (float)CatClient.instance.settingsManager.getSettingByName(lllIlIllIllIllI, "redBox[2D]").getValDouble();
                            float lllIlIllIlIlIll = (float)CatClient.instance.settingsManager.getSettingByName(lllIlIllIllIllI, "greenBox[2D]").getValDouble();
                            float lllIlIllIlIlIlI = (float)CatClient.instance.settingsManager.getSettingByName(lllIlIllIllIllI, "blueBox[2D]").getValDouble();
                            if (!Objects.equals(lllIlIllIllIIll, "2D")) break block31;
                            Iterator lllIlIllIIllIlI = ESP.mc.world.field_72996_f.iterator();
                            if (lllIlIllIIllIlI.hasNext()) {
                                Entity lllIlIlllIIlIIl = (Entity)lllIlIllIIllIlI.next();
                                Iterator lllIlIlllIIlIII = ESP.mc.world.field_72996_f.iterator();
                                while (true) {
                                    if (!lllIlIlllIIlIII.hasNext()) {
                                        return;
                                    }
                                    Entity lllIlIlllIIIlll = (Entity)lllIlIlllIIlIII.next();
                                    if (!(lllIlIlllIIIlll instanceof EntityPlayer) || lllIlIlllIIIlll == ESP.mc.world.field_72996_f) continue;
                                    double lllIlIlllIIllIl = lllIlIlllIIIlll.lastTickPosX + (lllIlIlllIIIlll.posX - lllIlIlllIIIlll.lastTickPosX) * (double)lllIlIllIllIlIl.getPartialTicks() - ESP.mc.getRenderManager().viewerPosX;
                                    double lllIlIlllIIllII = lllIlIlllIIIlll.lastTickPosY + (lllIlIlllIIIlll.posY - lllIlIlllIIIlll.lastTickPosY) * (double)lllIlIllIllIlIl.getPartialTicks() - ESP.mc.getRenderManager().viewerPosY;
                                    double lllIlIlllIIlIll = lllIlIlllIIIlll.lastTickPosZ + (lllIlIlllIIIlll.posZ - lllIlIlllIIIlll.lastTickPosZ) * (double)lllIlIllIllIlIl.getPartialTicks() - ESP.mc.getRenderManager().viewerPosZ;
                                    GL11.glPushMatrix();
                                    GL11.glLineWidth((float)1.5f);
                                    GL11.glTranslated((double)lllIlIlllIIllIl, (double)lllIlIlllIIllII, (double)lllIlIlllIIlIll);
                                    GL11.glDisable((int)3553);
                                    GL11.glDisable((int)2929);
                                    GL11.glRotated((double)(-ESP.mc.getRenderManager().playerViewY), (double)0.0, (double)1.0, (double)0.0);
                                    if (lllIlIllIllIIII) {
                                        if (FriendManager.friendsList.contains(lllIlIlllIIIlll.getName())) {
                                            GL11.glColor4d((double)0.0, (double)255.0, (double)0.0, (double)255.0);
                                            GL11.glBegin((int)3);
                                            GL11.glVertex3d((double)0.55, (double)-0.2, (double)0.0);
                                            GL11.glVertex3d((double)0.55, (double)((double)lllIlIlllIIIlll.height + 0.2), (double)0.0);
                                            GL11.glVertex3d((double)((double)lllIlIlllIIIlll.width - 1.15), (double)((double)lllIlIlllIIIlll.height + 0.2), (double)0.0);
                                            GL11.glVertex3d((double)((double)lllIlIlllIIIlll.width - 1.15), (double)-0.2, (double)0.0);
                                            GL11.glVertex3d((double)0.55, (double)-0.2, (double)0.0);
                                            GL11.glEnd();
                                        } else {
                                            GL11.glColor4d((double)lllIlIllIlIllII, (double)lllIlIllIlIlIll, (double)lllIlIllIlIlIlI, (double)255.0);
                                            GL11.glBegin((int)3);
                                            GL11.glVertex3d((double)0.55, (double)-0.2, (double)0.0);
                                            GL11.glVertex3d((double)0.55, (double)((double)lllIlIlllIIIlll.height + 0.2), (double)0.0);
                                            GL11.glVertex3d((double)((double)lllIlIlllIIIlll.width - 1.15), (double)((double)lllIlIlllIIIlll.height + 0.2), (double)0.0);
                                            GL11.glVertex3d((double)((double)lllIlIlllIIIlll.width - 1.15), (double)-0.2, (double)0.0);
                                            GL11.glVertex3d((double)0.55, (double)-0.2, (double)0.0);
                                            GL11.glEnd();
                                        }
                                    }
                                    if (lllIlIllIllIIlI) {
                                        if (Objects.equals(lllIlIllIllIlII, "Right")) {
                                            Color lllIlIlllIIllll = Color.GREEN.darker();
                                            if (((EntityPlayer)lllIlIlllIIIlll).func_110143_aJ() >= 16.0f) {
                                                lllIlIlllIIllll = Color.GREEN.darker();
                                            } else if (((EntityPlayer)lllIlIlllIIIlll).func_110143_aJ() >= 8.0f && ((EntityPlayer)lllIlIlllIIIlll).func_110143_aJ() <= 16.0f) {
                                                lllIlIlllIIllll = Color.YELLOW;
                                            } else if (((EntityPlayer)lllIlIlllIIIlll).func_110143_aJ() > 0.0f && ((EntityPlayer)lllIlIlllIIIlll).func_110143_aJ() <= 8.0f) {
                                                lllIlIlllIIllll = Color.RED;
                                            }
                                            GL11.glLineWidth((float)6.0f);
                                            GL11.glBegin((int)3);
                                            GL11.glColor4d((double)1.0, (double)1.0, (double)1.0, (double)1.0);
                                            GL11.glVertex3d((double)-0.7, (double)-0.2, (double)0.0);
                                            GL11.glVertex3d((double)-0.7, (double)((double)lllIlIlllIIIlll.height + 0.2), (double)0.0);
                                            GL11.glEnd();
                                            GL11.glBegin((int)3);
                                            GL11.glColor4d((double)((float)lllIlIlllIIllll.getRed() / 255.0f), (double)((float)lllIlIlllIIllll.getGreen() / 255.0f), (double)((float)lllIlIlllIIllll.getBlue() / 255.0f), (double)((float)lllIlIlllIIllll.getAlpha() / 255.0f));
                                            GL11.glVertex3d((double)-0.7, (double)-0.2, (double)0.0);
                                            GL11.glVertex3d((double)-0.7, (double)((double)(((EntityLivingBase)lllIlIlllIIIlll).getHealth() / ((EntityLivingBase)lllIlIlllIIIlll).getMaxHealth()) * ((double)lllIlIlllIIIlll.height + 0.2)), (double)0.0);
                                            GL11.glVertex3d((double)-0.7, (double)-0.2, (double)0.0);
                                            GL11.glLineWidth((float)2.0f);
                                            GL11.glEnd();
                                        } else if (Objects.equals(lllIlIllIllIlII, "Left")) {
                                            Color lllIlIlllIIlllI = Color.GREEN.darker();
                                            if (((EntityPlayer)lllIlIlllIIIlll).func_110143_aJ() >= 16.0f) {
                                                lllIlIlllIIlllI = Color.GREEN.darker();
                                            } else if (((EntityPlayer)lllIlIlllIIIlll).func_110143_aJ() >= 8.0f && ((EntityPlayer)lllIlIlllIIIlll).func_110143_aJ() <= 16.0f) {
                                                lllIlIlllIIlllI = Color.YELLOW;
                                            } else if (((EntityPlayer)lllIlIlllIIIlll).func_110143_aJ() > 0.0f && ((EntityPlayer)lllIlIlllIIIlll).func_110143_aJ() <= 8.0f) {
                                                lllIlIlllIIlllI = Color.RED;
                                            }
                                            GL11.glLineWidth((float)6.0f);
                                            GL11.glBegin((int)3);
                                            GL11.glColor4d((double)1.0, (double)1.0, (double)1.0, (double)1.0);
                                            GL11.glVertex3d((double)0.7, (double)-0.2, (double)0.0);
                                            GL11.glVertex3d((double)0.7, (double)((double)lllIlIlllIIIlll.height + 0.2), (double)0.0);
                                            GL11.glEnd();
                                            GL11.glBegin((int)3);
                                            GL11.glColor4d((double)((float)lllIlIlllIIlllI.getRed() / 255.0f), (double)((float)lllIlIlllIIlllI.getGreen() / 255.0f), (double)((float)lllIlIlllIIlllI.getBlue() / 255.0f), (double)((float)lllIlIlllIIlllI.getAlpha() / 255.0f));
                                            GL11.glVertex3d((double)0.7, (double)-0.2, (double)0.0);
                                            GL11.glVertex3d((double)0.7, (double)((double)(((EntityLivingBase)lllIlIlllIIIlll).getHealth() / ((EntityLivingBase)lllIlIlllIIIlll).getMaxHealth()) * ((double)lllIlIlllIIIlll.height + 0.2)), (double)0.0);
                                            GL11.glVertex3d((double)0.7, (double)-0.2, (double)0.0);
                                            GL11.glLineWidth((float)2.0f);
                                            GL11.glEnd();
                                        }
                                    }
                                    float lllIlIlllIIlIlI = 0.013f;
                                    GL11.glScaled((double)-0.013f, (double)-0.013f, (double)-0.013f);
                                    if (lllIlIllIlIllll) {
                                        GL11.glEnable((int)3553);
                                        ESP.mc.fontRenderer.drawStringWithShadow(lllIlIlllIIIlll.getName(), (float)(1 - ESP.mc.fontRenderer.getStringWidth(lllIlIlllIIIlll.getName()) / 2), -170.0f, -1);
                                        GL11.glDisable((int)3553);
                                    }
                                    if (lllIlIllIllIIIl && lllIlIllIllIIlI) {
                                        GL11.glEnable((int)3553);
                                        ESP.mc.fontRenderer.drawStringWithShadow(String.valueOf((int)(((EntityPlayer)lllIlIlllIIIlll).func_110143_aJ() / ((EntityPlayer)lllIlIlllIIIlll).func_110138_aP() * 100.0f)), (float)(-50 - ESP.mc.fontRenderer.getStringWidth(String.valueOf((int)(((EntityPlayer)lllIlIlllIIIlll).func_110143_aJ() / ((EntityPlayer)lllIlIlllIIIlll).func_110138_aP() * 100.0f)))), (float)((int)((double)(((EntityLivingBase)lllIlIlllIIIlll).getHealth() / ((EntityLivingBase)lllIlIlllIIIlll).getMaxHealth()) * ((double)lllIlIlllIIIlll.height + 0.2))), -1);
                                        GL11.glDisable((int)3553);
                                    }
                                    if (lllIlIllIlIlllI && !(((EntityPlayer)lllIlIlllIIIlll).func_184586_b(EnumHand.MAIN_HAND).getItem() instanceof ItemBlock) && !(((EntityPlayer)lllIlIlllIIIlll).func_184586_b(EnumHand.MAIN_HAND).getItem() instanceof ItemAir)) {
                                        GL11.glEnable((int)3553);
                                        ESP.mc.fontRenderer.drawStringWithShadow(((EntityPlayer)lllIlIlllIIIlll).func_184586_b(EnumHand.MAIN_HAND).getDisplayName(), (float)(1 - ESP.mc.fontRenderer.getStringWidth(((EntityPlayer)lllIlIlllIIIlll).func_184586_b(EnumHand.MAIN_HAND).getDisplayName()) / 2), 20.0f, -1);
                                        GL11.glDisable((int)3553);
                                    }
                                    GL11.glEnable((int)2929);
                                    GL11.glEnable((int)3553);
                                    GL11.glPopMatrix();
                                }
                            }
                            break block32;
                        }
                        if (!Objects.equals(lllIlIllIllIIll, "Glowing")) break block33;
                        for (Entity lllIlIlllIIIllI : ESP.mc.world.field_72996_f) {
                            if (!(lllIlIlllIIIllI instanceof EntityPlayer) || lllIlIlllIIIllI == ESP.mc.player || lllIlIlllIIIllI.isGlowing()) continue;
                            lllIlIlllIIIllI.setGlowing(true);
                        }
                        break block32;
                    }
                    if (!Objects.equals(lllIlIllIllIIll, "3D")) break block34;
                    GlStateManager.pushMatrix();
                    GlStateManager.disableTexture2D();
                    GlStateManager.disableAlpha();
                    GlStateManager.enableBlend();
                    GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
                    GlStateManager.disableDepth();
                    for (Entity lllIlIlllIIIlIl : ESP.mc.world.field_72996_f) {
                        if (!(lllIlIlllIIIlIl instanceof EntityPlayer) || lllIlIlllIIIlIl == ESP.mc.player) continue;
                        ESP.renderEntityBoundingBox(lllIlIlllIIIlIl, (float)Color.RED.getRed() / 255.0f, (float)Color.RED.getGreen() / 255.0f, (float)Color.RED.getBlue() / 255.0f, lllIlIllIlIllIl);
                    }
                    GlStateManager.enableDepth();
                    GlStateManager.disableBlend();
                    GlStateManager.enableTexture2D();
                    GlStateManager.enableAlpha();
                    GlStateManager.popMatrix();
                    break block32;
                }
                if (Objects.equals(lllIlIllIllIIll, "NoneCode")) {
                    Iterator lllIlIlllIIIIIl = ESP.mc.world.field_72996_f.iterator();
                    while (true) {
                        if (!lllIlIlllIIIIIl.hasNext()) {
                            return;
                        }
                        Entity lllIlIlllIIIIII = (Entity)lllIlIlllIIIIIl.next();
                        if (!(lllIlIlllIIIIII instanceof EntityPlayer)) continue;
                        if (lllIlIlllIIIIII == ESP.mc.player) {
                            if (ESP.mc.gameSettings.thirdPersonView != 1) continue;
                        }
                        double lllIlIlllIIIlII = lllIlIlllIIIIII.lastTickPosX + (lllIlIlllIIIIII.posX - lllIlIlllIIIIII.lastTickPosX) * (double)mc.getRenderPartialTicks() - ESP.mc.getRenderManager().viewerPosX;
                        double lllIlIlllIIIIll = lllIlIlllIIIIII.lastTickPosY + (lllIlIlllIIIIII.posY - lllIlIlllIIIIII.lastTickPosY) * (double)mc.getRenderPartialTicks() - ESP.mc.getRenderManager().viewerPosY;
                        double lllIlIlllIIIIlI = lllIlIlllIIIIII.lastTickPosZ + (lllIlIlllIIIIII.posZ - lllIlIlllIIIIII.lastTickPosZ) * (double)mc.getRenderPartialTicks() - ESP.mc.getRenderManager().viewerPosZ;
                        GL11.glPushMatrix();
                        GL11.glDisable((int)2929);
                        GL11.glDisable((int)3553);
                        GL11.glTranslatef((float)((float)lllIlIlllIIIlII), (float)((float)lllIlIlllIIIIll), (float)((float)lllIlIlllIIIIlI));
                        GL11.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
                        GL11.glRotatef((float)(-ESP.mc.getRenderManager().playerViewY), (float)0.0f, (float)1.0f, (float)0.0f);
                        GL11.glRotatef((float)ESP.mc.getRenderManager().playerViewX, (float)1.0f, (float)0.0f, (float)0.0f);
                        GL11.glLineWidth((float)3.0f);
                        GL11.glColor3f((float)0.0f, (float)0.0f, (float)0.0f);
                        GL11.glBegin((int)3);
                        GL11.glVertex3d((double)((double)lllIlIlllIIIIII.width + 0.1), (double)-0.4, (double)0.0);
                        GL11.glVertex3d((double)((double)lllIlIlllIIIIII.width + 0.1), (double)((double)lllIlIlllIIIIII.height + 0.4), (double)0.0);
                        GL11.glVertex3d((double)((double)(-lllIlIlllIIIIII.width) - 0.1), (double)((double)lllIlIlllIIIIII.height + 0.4), (double)0.0);
                        GL11.glVertex3d((double)((double)(-lllIlIlllIIIIII.width) - 0.1), (double)-0.4, (double)0.0);
                        GL11.glVertex3d((double)((double)lllIlIlllIIIIII.width + 0.1), (double)-0.4, (double)0.0);
                        GL11.glEnd();
                        GL11.glLineWidth((float)0.7f);
                        GL11.glColor3f((float)255.0f, (float)255.0f, (float)255.0f);
                        GL11.glBegin((int)3);
                        GL11.glVertex3d((double)((double)lllIlIlllIIIIII.width + 0.1), (double)-0.4, (double)0.0);
                        GL11.glVertex3d((double)((double)lllIlIlllIIIIII.width + 0.1), (double)((double)lllIlIlllIIIIII.height + 0.4), (double)0.0);
                        GL11.glVertex3d((double)((double)(-lllIlIlllIIIIII.width) - 0.1), (double)((double)lllIlIlllIIIIII.height + 0.4), (double)0.0);
                        GL11.glVertex3d((double)((double)(-lllIlIlllIIIIII.width) - 0.1), (double)-0.4, (double)0.0);
                        GL11.glVertex3d((double)((double)lllIlIlllIIIIII.width + 0.1), (double)-0.4, (double)0.0);
                        GL11.glEnd();
                        GL11.glColor3f((float)0.0f, (float)0.0f, (float)0.0f);
                        GL11.glLineWidth((float)3.0f);
                        GL11.glBegin((int)3);
                        GL11.glVertex3d((double)((double)lllIlIlllIIIIII.width + 0.4), (double)-0.4, (double)0.0);
                        GL11.glVertex3d((double)((double)lllIlIlllIIIIII.width + 0.4), (double)((double)lllIlIlllIIIIII.height + 0.4), (double)0.0);
                        GL11.glEnd();
                        GL11.glColor3f((float)Color.GRAY.getRed(), (float)Color.GRAY.getGreen(), (float)Color.GRAY.getBlue());
                        GL11.glLineWidth((float)0.7f);
                        GL11.glBegin((int)3);
                        GL11.glVertex3d((double)((double)lllIlIlllIIIIII.width + 0.4), (double)-0.4, (double)0.0);
                        GL11.glVertex3d((double)((double)lllIlIlllIIIIII.width + 0.4), (double)((double)lllIlIlllIIIIII.height + 0.4), (double)0.0);
                        GL11.glEnd();
                        GL11.glColor3f((float)0.0f, (float)255.0f, (float)0.0f);
                        GL11.glBegin((int)3);
                        GL11.glVertex3d((double)((double)lllIlIlllIIIIII.width + 0.4), (double)-0.4, (double)0.0);
                        GL11.glVertex3d((double)((double)lllIlIlllIIIIII.width + 0.4), (double)((double)(((EntityPlayer)lllIlIlllIIIIII).func_110143_aJ() / ((EntityPlayer)lllIlIlllIIIIII).func_110138_aP()) * ((double)lllIlIlllIIIIII.height + 0.4)), (double)0.0);
                        GL11.glEnd();
                        GL11.glBegin((int)3);
                        GL11.glEnd();
                        GL11.glEnable((int)2929);
                        GL11.glEnable((int)3553);
                        GL11.glColor3f((float)255.0f, (float)255.0f, (float)255.0f);
                        GL11.glPopMatrix();
                    }
                }
                if (!Objects.equals(lllIlIllIllIIll, "Corners")) break block35;
                for (Entity lllIlIllIllllII : ESP.mc.world.field_72996_f) {
                    if (!(lllIlIllIllllII instanceof EntityPlayer)) continue;
                    if (lllIlIllIllllII == ESP.mc.player) continue;
                    double lllIlIllIllllll = lllIlIllIllllII.lastTickPosX + (lllIlIllIllllII.posX - lllIlIllIllllII.lastTickPosX) * (double)lllIlIllIllIlIl.getPartialTicks() - ESP.mc.getRenderManager().viewerPosX;
                    double lllIlIllIlllllI = lllIlIllIllllII.lastTickPosY + (lllIlIllIllllII.posY - lllIlIllIllllII.lastTickPosY) * (double)lllIlIllIllIlIl.getPartialTicks() - ESP.mc.getRenderManager().viewerPosY;
                    double lllIlIllIllllIl = lllIlIllIllllII.lastTickPosZ + (lllIlIllIllllII.posZ - lllIlIllIllllII.lastTickPosZ) * (double)lllIlIllIllIlIl.getPartialTicks() - ESP.mc.getRenderManager().viewerPosZ;
                    GL11.glPushMatrix();
                    GL11.glDisable((int)2929);
                    GL11.glDisable((int)3553);
                    GL11.glTranslated((double)lllIlIllIllllll, (double)lllIlIllIlllllI, (double)lllIlIllIllllIl);
                    GL11.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
                    GL11.glRotatef((float)(-ESP.mc.getRenderManager().playerViewY), (float)0.0f, (float)1.0f, (float)0.0f);
                    GL11.glLineWidth((float)3.0f);
                    GL11.glColor3f((float)0.0f, (float)0.0f, (float)0.0f);
                    GL11.glBegin((int)3);
                    GL11.glVertex3d((double)lllIlIllIllllII.width, (double)0.2, (double)0.0);
                    GL11.glVertex3d((double)lllIlIllIllllII.width, (double)-0.3, (double)0.0);
                    GL11.glVertex3d((double)0.15, (double)-0.3, (double)0.0);
                    GL11.glEnd();
                    GL11.glBegin((int)3);
                    GL11.glVertex3d((double)(-lllIlIllIllllII.width), (double)0.2, (double)0.0);
                    GL11.glVertex3d((double)(-lllIlIllIllllII.width), (double)-0.3, (double)0.0);
                    GL11.glVertex3d((double)-0.15, (double)-0.3, (double)0.0);
                    GL11.glEnd();
                    GL11.glBegin((int)3);
                    GL11.glVertex3d((double)0.15, (double)((double)lllIlIllIllllII.height + 0.3), (double)0.0);
                    GL11.glVertex3d((double)lllIlIllIllllII.width, (double)((double)lllIlIllIllllII.height + 0.3), (double)0.0);
                    GL11.glVertex3d((double)lllIlIllIllllII.width, (double)((double)lllIlIllIllllII.height - 0.3), (double)0.0);
                    GL11.glEnd();
                    GL11.glBegin((int)3);
                    GL11.glVertex3d((double)-0.15, (double)((double)lllIlIllIllllII.height + 0.3), (double)0.0);
                    GL11.glVertex3d((double)(-lllIlIllIllllII.width), (double)((double)lllIlIllIllllII.height + 0.3), (double)0.0);
                    GL11.glVertex3d((double)(-lllIlIllIllllII.width), (double)((double)lllIlIllIllllII.height - 0.3), (double)0.0);
                    GL11.glEnd();
                    GL11.glLineWidth((float)1.0f);
                    GL11.glColor3f((float)Color.CYAN.darker().getRed(), (float)Color.CYAN.darker().getGreen(), (float)Color.CYAN.darker().getBlue());
                    GL11.glBegin((int)3);
                    GL11.glVertex3d((double)lllIlIllIllllII.width, (double)0.2, (double)0.0);
                    GL11.glVertex3d((double)lllIlIllIllllII.width, (double)-0.3, (double)0.0);
                    GL11.glVertex3d((double)0.15, (double)-0.3, (double)0.0);
                    GL11.glEnd();
                    GL11.glBegin((int)3);
                    GL11.glVertex3d((double)(-lllIlIllIllllII.width), (double)0.2, (double)0.0);
                    GL11.glVertex3d((double)(-lllIlIllIllllII.width), (double)-0.3, (double)0.0);
                    GL11.glVertex3d((double)-0.15, (double)-0.3, (double)0.0);
                    GL11.glEnd();
                    GL11.glBegin((int)3);
                    GL11.glVertex3d((double)0.15, (double)((double)lllIlIllIllllII.height + 0.3), (double)0.0);
                    GL11.glVertex3d((double)lllIlIllIllllII.width, (double)((double)lllIlIllIllllII.height + 0.3), (double)0.0);
                    GL11.glVertex3d((double)lllIlIllIllllII.width, (double)((double)lllIlIllIllllII.height - 0.3), (double)0.0);
                    GL11.glEnd();
                    GL11.glBegin((int)3);
                    GL11.glVertex3d((double)-0.15, (double)((double)lllIlIllIllllII.height + 0.3), (double)0.0);
                    GL11.glVertex3d((double)(-lllIlIllIllllII.width), (double)((double)lllIlIllIllllII.height + 0.3), (double)0.0);
                    GL11.glVertex3d((double)(-lllIlIllIllllII.width), (double)((double)lllIlIllIllllII.height - 0.3), (double)0.0);
                    GL11.glEnd();
                    GL11.glColor3f((float)0.0f, (float)0.0f, (float)0.0f);
                    GL11.glLineWidth((float)3.0f);
                    GL11.glBegin((int)3);
                    GL11.glVertex3d((double)((double)lllIlIllIllllII.width + 0.2), (double)((double)lllIlIllIllllII.height + 0.3), (double)0.0);
                    GL11.glVertex3d((double)((double)lllIlIllIllllII.width + 0.2), (double)-0.3, (double)0.0);
                    GL11.glEnd();
                    GL11.glColor3f((float)255.0f, (float)255.0f, (float)255.0f);
                    GL11.glLineWidth((float)1.0f);
                    GL11.glBegin((int)3);
                    GL11.glVertex3d((double)((double)lllIlIllIllllII.width + 0.2), (double)((double)lllIlIllIllllII.height + 0.3), (double)0.0);
                    GL11.glVertex3d((double)((double)lllIlIllIllllII.width + 0.2), (double)-0.3, (double)0.0);
                    GL11.glEnd();
                    GL11.glColor3f((float)0.0f, (float)255.0f, (float)0.0f);
                    GL11.glLineWidth((float)1.0f);
                    GL11.glBegin((int)3);
                    GL11.glVertex3d((double)((double)lllIlIllIllllII.width + 0.2), (double)((double)(((EntityPlayer)lllIlIllIllllII).func_110143_aJ() / ((EntityPlayer)lllIlIllIllllII).func_110138_aP()) * ((double)lllIlIllIllllII.height + 0.3)), (double)0.0);
                    GL11.glVertex3d((double)((double)lllIlIllIllllII.width + 0.2), (double)-0.3, (double)0.0);
                    GL11.glEnd();
                    GL11.glColor3f((float)1.0f, (float)1.0f, (float)1.0f);
                    GL11.glDisable((int)2960);
                    GL11.glEnable((int)2929);
                    GL11.glEnable((int)3553);
                    GL11.glPopMatrix();
                }
                break block32;
            }
            if (!Objects.equals(lllIlIllIllIIll, "OnHeal")) break block32;
            for (Entity lllIlIllIlllIII : ESP.mc.world.field_72996_f) {
                if (!(lllIlIllIlllIII instanceof EntityPlayer)) continue;
                if (lllIlIllIlllIII == ESP.mc.player) continue;
                double lllIlIllIlllIll = lllIlIllIlllIII.lastTickPosX + (lllIlIllIlllIII.posX - lllIlIllIlllIII.lastTickPosX) * (double)lllIlIllIllIlIl.getPartialTicks() - ESP.mc.getRenderManager().viewerPosX;
                double lllIlIllIlllIlI = lllIlIllIlllIII.lastTickPosY + (lllIlIllIlllIII.posY - lllIlIllIlllIII.lastTickPosY) * (double)lllIlIllIllIlIl.getPartialTicks() - ESP.mc.getRenderManager().viewerPosY;
                double lllIlIllIlllIIl = lllIlIllIlllIII.lastTickPosZ + (lllIlIllIlllIII.posZ - lllIlIllIlllIII.lastTickPosZ) * (double)lllIlIllIllIlIl.getPartialTicks() - ESP.mc.getRenderManager().viewerPosZ;
                GL11.glPushMatrix();
                GL11.glDisable((int)2929);
                GL11.glDisable((int)3553);
                GL11.glTranslatef((float)((float)lllIlIllIlllIll), (float)((float)lllIlIllIlllIlI), (float)((float)lllIlIllIlllIIl));
                GlStateManager.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
                GlStateManager.rotate((float)(-ESP.mc.getRenderManager().playerViewY), (float)0.0f, (float)1.0f, (float)0.0f);
                GlStateManager.rotate((float)ESP.mc.getRenderManager().playerViewX, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glLineWidth((float)4.7f);
                GL11.glColor3f((float)0.0f, (float)0.0f, (float)0.0f);
                GL11.glBegin((int)3);
                GL11.glVertex3f((float)0.4f, (float)0.0f, (float)0.0f);
                GL11.glVertex3f((float)0.4f, (float)lllIlIllIlllIII.height, (float)0.0f);
                GL11.glEnd();
                GL11.glColor3f((float)0.0f, (float)255.0f, (float)0.0f);
                GL11.glLineWidth((float)0.8f);
                GL11.glColor3f((float)255.0f, (float)255.0f, (float)255.0f);
                GL11.glBegin((int)3);
                GL11.glVertex3f((float)0.4f, (float)0.0f, (float)0.0f);
                GL11.glVertex3f((float)0.4f, (float)lllIlIllIlllIII.height, (float)0.0f);
                GL11.glColor3f((float)0.0f, (float)255.0f, (float)0.0f);
                GL11.glEnd();
                GL11.glBegin((int)3);
                GL11.glVertex3f((float)0.4f, (float)0.0f, (float)0.0f);
                GL11.glVertex3f((float)0.4f, (float)(((EntityPlayer)lllIlIllIlllIII).func_110143_aJ() / ((EntityPlayer)lllIlIllIlllIII).func_110138_aP() * lllIlIllIlllIII.height), (float)0.0f);
                GL11.glEnd();
                GL11.glEnable((int)3553);
                GL11.glEnable((int)2929);
                GL11.glColor3f((float)255.0f, (float)255.0f, (float)255.0f);
                GL11.glPopMatrix();
            }
        }
    }
}

