/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.gui.inventory.GuiInventory
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.MathHelper
 *  net.minecraftforge.client.event.RenderGameOverlayEvent
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$ElementType
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package ru.internali.module.combat;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;
import ru.internali.utils.ColorUtils;
import ru.internali.utils.Colors;
import ru.internali.utils.RenderUtil;
import ru.internali.utils.RenderUtils;
import ru.internali.utils.RotationHelper;
import ru.internali.utils.TimerUtils;
import ru.internali.utils.friend.FriendManager;

public class AimPistol
extends Module {
    public static /* synthetic */ List<String> AimPredict;
    public static /* synthetic */ List<String> Priority;
    private /* synthetic */ boolean up;
    public /* synthetic */ TimerUtils timer;
    public static /* synthetic */ List<String> Fover;
    public static /* synthetic */ List<String> Rotare;
    public static /* synthetic */ List<String> Sort;
    private /* synthetic */ float[] old_pred;
    public static /* synthetic */ Entity target;
    public /* synthetic */ float[] facing;
    public /* synthetic */ double height;
    public /* synthetic */ double width;
    private /* synthetic */ Entity focusTarget;
    public static /* synthetic */ AimPistol INSTANCE;

    public float updateRotation(float llllIlIllllIll, float llllIlIllllIlI) {
        AimPistol llllIllIIIIIIl;
        float llllIlIllllllI = (float)CatClient.instance.settingsManager.getSettingByName(llllIllIIIIIIl, "Smooth").getValDouble();
        float llllIlIlllllIl = MathHelper.wrapDegrees((float)(llllIlIllllIlI - llllIlIllllIll));
        if (llllIlIlllllIl > llllIlIllllllI) {
            llllIlIlllllIl = llllIlIllllllI;
        }
        if (llllIlIlllllIl < -llllIlIllllllI) {
            llllIlIlllllIl = -llllIlIllllllI;
        }
        return llllIlIllllIll + llllIlIlllllIl;
    }

    public AimPistol() {
        super("AimPistol", "aim to players", Category.COMBAT);
        AimPistol llllIlllIlIIll;
        llllIlllIlIIll.timer = new TimerUtils();
        CatClient.instance.settingsManager.rSetting(new Setting("Range", llllIlllIlIIll, 300.0, 0.0, 300.0, true));
        CatClient.instance.settingsManager.rSetting(new Setting("Predict", llllIlllIlIIll, 3.5, 0.0, 9.0, false));
        CatClient.instance.settingsManager.rSetting(new Setting("Walls", llllIlllIlIIll, false));
        CatClient.instance.settingsManager.rSetting(new Setting("AutoShoot", llllIlllIlIIll, false));
        CatClient.instance.settingsManager.rSetting(new Setting("AutoScope", llllIlllIlIIll, true));
        CatClient.instance.settingsManager.rSetting(new Setting("Fov", llllIlllIlIIll, 40.0, 1.0, 360.0, true));
        CatClient.instance.settingsManager.rSetting(new Setting("players", llllIlllIlIIll, true));
        CatClient.instance.settingsManager.rSetting(new Setting("Nocked", llllIlllIlIIll, false));
        CatClient.instance.settingsManager.rSetting(new Setting("invis", llllIlllIlIIll, false));
        CatClient.instance.settingsManager.rSetting(new Setting("AimOnClick", llllIlllIlIIll, false));
        CatClient.instance.settingsManager.rSetting(new Setting("ShootDeley", llllIlllIlIIll, 200.0, 0.0, 500.0, true));
        Priority.add("Angle");
        Priority.add("HArmor");
        Priority.add("LArmor");
        Priority.add("Health");
        Priority.add("Distance");
        CatClient.instance.settingsManager.rSetting(new Setting("Priority", llllIlllIlIIll, "Angle", (ArrayList)Priority));
        CatClient.instance.settingsManager.rSetting(new Setting("Smooth", llllIlllIlIIll, 1.0, 1.0, 180.0, true));
        Fover.add("Krug");
        Fover.add("Kvadrat");
        CatClient.instance.settingsManager.rSetting(new Setting("FovType", llllIlllIlIIll, "Krug", (ArrayList)Fover));
        CatClient.instance.settingsManager.rSetting(new Setting("FovRender", llllIlllIlIIll, true));
        CatClient.instance.settingsManager.rSetting(new Setting("DYNAMIC", llllIlllIlIIll, false));
        CatClient.instance.settingsManager.rSetting(new Setting("Targethud", llllIlllIlIIll, false));
        CatClient.instance.settingsManager.rSetting(new Setting("Xpos", llllIlllIlIIll, 1.0, 0.0, 650.0, true));
        CatClient.instance.settingsManager.rSetting(new Setting("Ypos", llllIlllIlIIll, 1.0, 0.0, 500.0, true));
    }

    @SubscribeEvent
    public void fovv(RenderGameOverlayEvent llllIllIIlIIll) {
        AimPistol llllIllIIlIlII;
        String llllIllIIlIlll = CatClient.instance.settingsManager.getSettingByName(llllIllIIlIlII, "FovType").getValString();
        float llllIllIIlIllI = (float)CatClient.instance.settingsManager.getSettingByName(llllIllIIlIlII, "Fov").getValDouble();
        boolean llllIllIIlIlIl = CatClient.instance.settingsManager.getSettingByName(llllIllIIlIlII, "FovRender").getValBoolean();
        if (llllIllIIlIIll.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            ScaledResolution llllIllIIllIlI = new ScaledResolution(mc);
            if (llllIllIIlIlIl) {
                if (Objects.equals(llllIllIIlIlll, "Krug")) {
                    RenderUtil.drawCircle222(llllIllIIllIlI.getScaledWidth() / 2, llllIllIIllIlI.getScaledHeight() / 2, (float)((double)llllIllIIlIllI * 3.5), Color.white.getRGB(), 360);
                } else if (Objects.equals(llllIllIIlIlll, "Kvadrat")) {
                    int llllIllIlIIIlI = 255;
                    int llllIllIlIIIIl = 255;
                    int llllIllIlIIIII = 255;
                    int llllIllIIlllll = 255;
                    double llllIllIIllllI = (double)llllIllIIlIllI * 3.5;
                    double llllIllIIlllIl = 60.0;
                    double llllIllIIlllII = 1.75;
                    ScaledResolution llllIllIIllIll = new ScaledResolution(mc);
                    RenderUtil.rectangleBordered((double)(llllIllIIllIll.getScaledWidth() / 2) - llllIllIIllllI - llllIllIIlllII - (double)(llllIllIIlIlII.isMoving() ? 2 : 0) + 0.15, (double)(llllIllIIllIll.getScaledHeight() / 2) - llllIllIIlllIl, (double)(llllIllIIllIll.getScaledWidth() / 2) - llllIllIIllllI - (double)(llllIllIIlIlII.isMoving() ? 2 : 0) + 0.15, (double)((float)(llllIllIIllIll.getScaledHeight() / 2) + 1.0f) + llllIllIIlllIl, 0.5, Colors.getColor(llllIllIlIIIlI, llllIllIlIIIIl, llllIllIlIIIII, llllIllIIlllll), new Color(0, 0, 0, llllIllIIlllll).getRGB());
                    RenderUtil.rectangleBordered((double)(llllIllIIllIll.getScaledWidth() / 2 + 1) + llllIllIIllllI + (double)(llllIllIIlIlII.isMoving() ? 2 : 0), (double)(llllIllIIllIll.getScaledHeight() / 2) - llllIllIIlllIl, (double)(llllIllIIllIll.getScaledWidth() / 2) + llllIllIIlllII + llllIllIIllllI + 1.0 + (double)(llllIllIIlIlII.isMoving() ? 2 : 0), (double)((float)(llllIllIIllIll.getScaledHeight() / 2) + 1.0f) + llllIllIIlllIl, 0.5, Colors.getColor(llllIllIlIIIlI, llllIllIlIIIIl, llllIllIlIIIII, llllIllIIlllll), new Color(0, 0, 0, llllIllIIlllll).getRGB());
                }
            }
        }
    }

    public static boolean canSeeEntityAtFov(Entity llllIIllllllIl, float llllIIllllllII) {
        double llllIlIIIIIIII = llllIIllllllIl.posZ - AimPistol.mc.player.field_70161_v;
        double llllIlIIIIIIIl = llllIIllllllIl.posX - AimPistol.mc.player.field_70165_t;
        float llllIIllllllll = (float)(Math.toDegrees(Math.atan2(llllIlIIIIIIII, llllIlIIIIIIIl)) - 90.0);
        double llllIIlllllllI = AimPistol.angleDifference(llllIIllllllll, AimPistol.mc.player.field_70177_z);
        return llllIIlllllllI <= (double)llllIIllllllII;
    }

    public static void clickMouse(int llllIIllIlllIl) {
        block4: {
            try {
                Robot llllIIllIlllll = new Robot();
                if (llllIIllIlllIl == 0) {
                    llllIIllIlllll.mousePress(16);
                    llllIIllIlllll.mouseRelease(16);
                    break block4;
                }
                if (llllIIllIlllIl == 1) {
                    llllIIllIlllll.mousePress(4096);
                    llllIIllIlllll.mouseRelease(4096);
                    break block4;
                }
                return;
            }
            catch (AWTException llllIIllIllllI) {
                llllIIllIllllI.printStackTrace();
            }
        }
    }

    public float[] faceHead(float llllIlIlIIIlll, float llllIlIlIIIllI, float llllIlIIllIlIl, float llllIlIlIIIlII, float llllIlIlIIIIll) {
        AimPistol llllIlIIlllIII;
        double llllIlIlIIIIlI = (double)llllIlIlIIIlll - Minecraft.getMinecraft().player.field_70165_t;
        double llllIlIlIIIIIl = (double)llllIlIIllIlIl - Minecraft.getMinecraft().player.field_70161_v;
        double llllIlIlIIIIII = (double)llllIlIlIIIllI + (double)1.62f - (Minecraft.getMinecraft().player.field_70163_u + (double)Minecraft.getMinecraft().player.func_70047_e());
        double llllIlIIllllll = MathHelper.sqrt((double)(llllIlIlIIIIlI * llllIlIlIIIIlI + llllIlIlIIIIIl * llllIlIlIIIIIl));
        float llllIlIIlllllI = (float)(Math.atan2(llllIlIlIIIIIl, llllIlIlIIIIlI) * 180.0 / Math.PI) - 90.0f;
        float llllIlIIllllIl = (float)(-(Math.atan2(llllIlIlIIIIII - 0.07, llllIlIIllllll) * 180.0 / Math.PI));
        float llllIlIIllllII = Minecraft.getMinecraft().gameSettings.mouseSensitivity * 0.6f + 0.2f;
        float llllIlIIlllIll = llllIlIIllllII * llllIlIIllllII * llllIlIIllllII * 1.2f;
        float llllIlIIlllIlI = llllIlIIlllIII.updateRotation(Minecraft.getMinecraft().player.field_70125_A, llllIlIIllllIl);
        float llllIlIIlllIIl = llllIlIIlllIII.updateRotation(Minecraft.getMinecraft().player.field_70177_z, llllIlIIlllllI);
        llllIlIIlllIIl -= llllIlIIlllIIl % llllIlIIlllIll;
        llllIlIIlllIlI -= llllIlIIlllIlI % llllIlIIlllIll;
        return new float[]{llllIlIIlllIIl, llllIlIIlllIlI};
    }

    public static double angleDifference(double llllIIllllIIIl, double llllIIllllIIll) {
        float llllIIllllIIlI = (float)(Math.abs(llllIIllllIIIl - llllIIllllIIll) % 360.0);
        if (llllIIllllIIlI > 180.0f) {
            llllIIllllIIlI = 360.0f - llllIIllllIIlI;
        }
        return llllIIllllIIlI;
    }

    public boolean canAssist(EntityLivingBase llllIlIIIIlllI) {
        AimPistol llllIlIIIlIlIl;
        boolean llllIlIIIlIIll = CatClient.instance.settingsManager.getSettingByName(llllIlIIIlIlIl, "Walls").getValBoolean();
        boolean llllIlIIIlIIlI = CatClient.instance.settingsManager.getSettingByName(llllIlIIIlIlIl, "players").getValBoolean();
        boolean llllIlIIIlIIIl = CatClient.instance.settingsManager.getSettingByName(llllIlIIIlIlIl, "invis").getValBoolean();
        boolean llllIlIIIlIIII = CatClient.instance.settingsManager.getSettingByName(llllIlIIIlIlIl, "Nocked").getValBoolean();
        if (llllIlIIIIlllI instanceof EntityPlayer && !llllIlIIIlIIlI) {
            return false;
        }
        if (llllIlIIIIlllI.isPlayerSleeping() && !llllIlIIIlIIII) {
            return false;
        }
        if (llllIlIIIIlllI.func_82150_aj() && !llllIlIIIlIIIl) {
            return false;
        }
        if (!llllIlIIIIlllI.canEntityBeSeen((Entity)AimPistol.mc.player)) {
            return llllIlIIIlIIll;
        }
        return llllIlIIIIlllI != AimPistol.mc.player;
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent llllIIlllIlIIl) {
        AimPistol llllIIlllIIlIl;
        boolean llllIIlllIlIII = CatClient.instance.settingsManager.getSettingByName(llllIIlllIIlIl, "AutoShoot").getValBoolean();
        boolean llllIIlllIIlll = CatClient.instance.settingsManager.getSettingByName(llllIIlllIIlIl, "AutoScope").getValBoolean();
        float llllIIlllIIllI = (float)CatClient.instance.settingsManager.getSettingByName(llllIIlllIIlIl, "ShootDeley").getValDouble();
        if (CatClient.instance.settingsManager.getSettingByName("AimOnClick").getValBoolean() && !AimPistol.mc.gameSettings.keyBindAttack.isKeyDown()) {
            return;
        }
        target = null;
        target = llllIIlllIIlIl.getSortEntities();
        if (target != null) {
            if (!FriendManager.friendsList.contains(target.getName())) {
                if (AimPistol.canSeeEntityAtFov(target, (int)CatClient.instance.settingsManager.getSettingByName(llllIIlllIIlIl, "FOV").getValDouble())) {
                    if (target != null) {
                        llllIIlllIIlIl.facing = llllIIlllIIlIl.getPredict(target);
                        llllIIlllIIlIl.facing = llllIIlllIIlIl.faceHead(llllIIlllIIlIl.facing[0], (float)AimPistol.target.posY, llllIIlllIIlIl.facing[1], 360.0f, 360.0f);
                        AimPistol.mc.player.field_70177_z = llllIIlllIIlIl.facing[0];
                        AimPistol.mc.player.field_70125_A = llllIIlllIIlIl.facing[1];
                        if (llllIIlllIlIII) {
                            if (AimPistol.mc.player.func_70685_l(target)) {
                                if (llllIIlllIIlIl.timer.isDelay((long)llllIIlllIIllI)) {
                                    if (llllIIlllIIlll) {
                                        AimPistol.clickMouse(1);
                                    }
                                    AimPistol.mc.player.swingArm(EnumHand.MAIN_HAND);
                                    if (llllIIlllIIlll) {
                                        AimPistol.clickMouse(1);
                                    }
                                }
                                llllIIlllIIlIl.timer.setLastMS();
                            }
                        }
                    } else {
                        llllIIlllIIlIl.timer.setLastMS();
                    }
                }
            }
        }
    }

    public boolean isMoving() {
        return false;
    }

    public Entity getSortEntities() {
        AimPistol llllIlIIlIIlII;
        float llllIlIIlIIIll = (float)CatClient.instance.settingsManager.getSettingByName(llllIlIIlIIlII, "range").getValDouble();
        ArrayList<EntityLivingBase> llllIlIIlIIIlI = new ArrayList<EntityLivingBase>();
        for (EntityLivingBase llllIlIIlIIlIl : AimPistol.mc.world.field_73010_i) {
            if (llllIlIIlIIlIl == null || !(AimPistol.mc.player.func_70032_d((Entity)llllIlIIlIIlIl) < llllIlIIlIIIll) || !llllIlIIlIIlII.canAssist(llllIlIIlIIlIl)) continue;
            if (llllIlIIlIIlIl.getHealth() > 0.0f) {
                llllIlIIlIIIlI.add(llllIlIIlIIlIl);
                continue;
            }
            llllIlIIlIIIlI.remove((Object)llllIlIIlIIlIl);
        }
        String llllIlIIlIIIIl = CatClient.instance.settingsManager.getSettingByName(llllIlIIlIIlII, "Priority").getValString();
        if (llllIlIIlIIIIl.equalsIgnoreCase("Angle")) {
            llllIlIIlIIIlI.sort((llllIIllIlIIII, llllIIllIlIIIl) -> (int)(Math.abs(RotationHelper.getAngleEntity((Entity)llllIIllIlIIII) - AimPistol.mc.player.field_70177_z) - Math.abs(RotationHelper.getAngleEntity((Entity)llllIIllIlIIIl) - AimPistol.mc.player.field_70177_z)));
        } else if (llllIlIIlIIIIl.equalsIgnoreCase("HArmor")) {
            llllIlIIlIIIlI.sort(Comparator.comparing(EntityLivingBase::getTotalArmorValue).reversed());
        } else if (llllIlIIlIIIIl.equalsIgnoreCase("LArmor")) {
            llllIlIIlIIIlI.sort(Comparator.comparing(EntityLivingBase::getTotalArmorValue));
        } else if (llllIlIIlIIIIl.equalsIgnoreCase("Health")) {
            llllIlIIlIIIlI.sort((llllIIllIlIllI, llllIIllIlIlIl) -> (int)(llllIIllIlIllI.getHealth() - llllIIllIlIlIl.getHealth()));
        } else if (llllIlIIlIIIIl.equalsIgnoreCase("Distance")) {
            llllIlIIlIIIlI.sort(Comparator.comparingDouble(((EntityPlayerSP)AimPistol.mc.player)::getDistance));
        }
        if (llllIlIIlIIIlI.isEmpty()) {
            return null;
        }
        return (Entity)llllIlIIlIIIlI.get(0);
    }

    @SubscribeEvent
    public void targethud(RenderGameOverlayEvent llllIllIlllIll) {
        AimPistol llllIllIllllII;
        boolean llllIllIllllll = CatClient.instance.settingsManager.getSettingByName(llllIllIllllII, "Targethud").getValBoolean();
        float llllIllIlllllI = (float)CatClient.instance.settingsManager.getSettingByName(llllIllIllllII, "Xpos").getValDouble();
        float llllIllIllllIl = (float)CatClient.instance.settingsManager.getSettingByName(llllIllIllllII, "Ypos").getValDouble();
        if (llllIllIlllIll.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            if (!llllIllIllllll) {
                return;
            }
            if (target == null) {
                return;
            }
            Color llllIlllIIIlIl = new Color(30, 30, 30, 150);
            RenderUtils.drawShadowRect(llllIllIlllllI, llllIllIllllIl, llllIllIlllllI + 150.0f, llllIllIllllIl + 30.0f, 3);
            try {
                GuiInventory.drawEntityOnScreen((int)((int)(llllIllIlllllI + 8.0f)), (int)((int)(llllIllIllllIl + 30.0f)), (int)15, (float)0.0f, (float)0.0f, (EntityLivingBase)((EntityLivingBase)target));
            }
            catch (Exception llllIlllIIIlll) {
                llllIlllIIIlll.printStackTrace();
            }
            RenderUtil.drawSmoothRect(llllIllIlllllI + 29.0f, llllIllIllllIl + 1.0f, llllIllIlllllI + 29.0f + (float)AimPistol.mc.fontRenderer.getStringWidth(target.getName()), llllIllIllllIl + (float)AimPistol.mc.fontRenderer.FONT_HEIGHT + 4.0f, llllIlllIIIlIl.getRGB());
            AimPistol.mc.fontRenderer.drawString(target.getName(), (int)(llllIllIlllllI + 30.0f), (int)(llllIllIllllIl + 3.0f), Color.white.getRGB());
            int llllIlllIIIlII = (int)(((EntityPlayer)target).func_110143_aJ() / ((EntityPlayer)target).func_110138_aP() * 100.0f);
            int llllIlllIIIIll = (int)(((EntityPlayer)target).func_110143_aJ() / ((EntityPlayer)target).func_110138_aP() * 360.0f);
            RenderUtil.drawCircle228(llllIllIlllllI + 135.0f, llllIllIllllIl + 15.0f, 14.0f, ColorUtils.getHealthColor((EntityLivingBase)target).getRGB(), llllIlllIIIIll);
            AimPistol.mc.fontRenderer.drawString(String.valueOf(new StringBuilder().append(llllIlllIIIlII).append("")), (int)(llllIllIlllllI + 135.0f - (float)(AimPistol.mc.fontRenderer.getStringWidth(String.valueOf(new StringBuilder().append(llllIlllIIIlII).append(""))) / 2)), (int)(llllIllIllllIl + 15.0f - (float)(AimPistol.mc.fontRenderer.FONT_HEIGHT / 2)), ColorUtils.getHealthColor((EntityLivingBase)target).getRGB());
            int llllIlllIIIIlI = (int)(llllIllIlllllI + 30.0f);
            RenderUtil.renderItem(((EntityPlayer)target).func_184586_b(EnumHand.MAIN_HAND), llllIlllIIIIlI, (int)llllIllIllllIl + 14);
            llllIlllIIIIlI += 16;
            for (ItemStack llllIlllIIIllI : ((EntityPlayer)target).getArmorInventoryList()) {
                RenderUtil.renderItem(llllIlllIIIllI, llllIlllIIIIlI, (int)llllIllIllllIl + 14);
                llllIlllIIIIlI += 16;
            }
        }
    }

    static {
        Sort = new ArrayList<String>();
        Priority = new ArrayList<String>();
        AimPredict = new ArrayList<String>();
        Fover = new ArrayList<String>();
        Rotare = new ArrayList<String>();
    }

    public float[] getPredict(Entity llllIlIllIIIII) {
        AimPistol llllIlIllIIIIl;
        float llllIlIllIlIlI = (float)CatClient.instance.settingsManager.getSettingByName(llllIlIllIIIIl, "Predict").getValDouble();
        float llllIlIllIlIIl = (float)CatClient.instance.settingsManager.getSettingByName(llllIlIllIIIIl, "Range").getValDouble();
        double llllIlIllIlIII = llllIlIllIIIII.posX - llllIlIllIIIII.lastTickPosX;
        double llllIlIllIIlll = llllIlIllIIIII.posZ - llllIlIllIIIII.lastTickPosZ;
        double llllIlIllIIllI = llllIlIllIIIII.posY - llllIlIllIIIII.lastTickPosY;
        float llllIlIllIIlIl = llllIlIllIlIlI + AimPistol.mc.player.func_70032_d(llllIlIllIIIII) / llllIlIllIlIIl;
        double llllIlIllIIlII = llllIlIllIIIII.posX + llllIlIllIlIII * (double)llllIlIllIIlIl;
        double llllIlIllIIIll = llllIlIllIIIII.posZ + llllIlIllIIlll * (double)llllIlIllIIlIl;
        double llllIlIllIIIlI = llllIlIllIIIII.posY + llllIlIllIIllI * (double)llllIlIllIIlIl;
        if (llllIlIllIIllI * (double)llllIlIllIIlIl > 1.1) {
            llllIlIllIIIlI = llllIlIllIIIII.posY;
        }
        return new float[]{(float)llllIlIllIIlII, (float)llllIlIllIIIll, (float)llllIlIllIIIlI};
    }
}

