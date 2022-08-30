/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityEgg
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemArmor
 *  net.minecraft.item.ItemArmor$ArmorMaterial
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 */
package ru.internali.utils;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Random;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import ru.internali.utils.Wrapper;

public class Utils {
    private static final /* synthetic */ Random RANDOM;
    public static /* synthetic */ float[] rotationsToBlock;
    public static /* synthetic */ boolean lookChanged;

    private static float[] getDirectionToEntity(Entity llIllIIIIIIIll) {
        return new float[]{Utils.getYaw(llIllIIIIIIIll) + Wrapper.INSTANCE.player().field_70177_z, Utils.getPitch(llIllIIIIIIIll) + Wrapper.INSTANCE.player().field_70125_A};
    }

    public static EntityLivingBase getWorldEntityByName(String llIllIIIIllIIl) {
        EntityLivingBase llIllIIIIllIlI = null;
        for (Entity llIllIIIIlllII : Utils.getEntityList()) {
            EntityLivingBase llIllIIIIlllIl;
            if (!(llIllIIIIlllII instanceof EntityLivingBase) || !(llIllIIIIlllIl = (EntityLivingBase)llIllIIIIlllII).func_70005_c_().contains(llIllIIIIllIIl)) continue;
            llIllIIIIllIlI = llIllIIIIlllIl;
        }
        return llIllIIIIllIlI;
    }

    public static void assistFaceEntity(Entity llIlIllIlIIIII, float llIlIllIIlIllI, float llIlIllIIllllI) {
        double llIlIllIIllIll;
        if (llIlIllIlIIIII == null) {
            return;
        }
        double llIlIllIIlllIl = llIlIllIlIIIII.posX - Wrapper.INSTANCE.player().field_70165_t;
        double llIlIllIIlllII = llIlIllIlIIIII.posZ - Wrapper.INSTANCE.player().field_70161_v;
        if (llIlIllIlIIIII instanceof EntityLivingBase) {
            EntityLivingBase llIlIllIlIIIlI = (EntityLivingBase)llIlIllIlIIIII;
            double llIlIllIlIIIIl = llIlIllIlIIIlI.field_70163_u + (double)llIlIllIlIIIlI.func_70047_e() - (Wrapper.INSTANCE.player().field_70163_u + (double)Wrapper.INSTANCE.player().func_70047_e());
        } else {
            llIlIllIIllIll = (llIlIllIlIIIII.getEntityBoundingBox().minY + llIlIllIlIIIII.getEntityBoundingBox().maxY) / 2.0 - (Wrapper.INSTANCE.player().field_70163_u + (double)Wrapper.INSTANCE.player().func_70047_e());
        }
        double llIlIllIIllIlI = MathHelper.sqrt((double)(llIlIllIIlllIl * llIlIllIIlllIl + llIlIllIIlllII * llIlIllIIlllII));
        float llIlIllIIllIIl = (float)(Math.atan2(llIlIllIIlllII, llIlIllIIlllIl) * 180.0 / Math.PI) - 90.0f;
        float llIlIllIIllIII = (float)(-(Math.atan2(llIlIllIIllIll, llIlIllIIllIlI) * 180.0 / Math.PI));
        if (llIlIllIIlIllI > 0.0f) {
            Wrapper.INSTANCE.player().field_70177_z = Utils.updateRotation(Wrapper.INSTANCE.player().field_70177_z, llIlIllIIllIIl, llIlIllIIlIllI / 4.0f);
        }
        if (llIlIllIIllllI > 0.0f) {
            Wrapper.INSTANCE.player().field_70125_A = Utils.updateRotation(Wrapper.INSTANCE.player().field_70125_A, llIlIllIIllIII, llIlIllIIllllI / 4.0f);
        }
    }

    static {
        rotationsToBlock = null;
        RANDOM = new Random();
    }

    public static boolean screenCheck() {
        return !(Wrapper.INSTANCE.mc().currentScreen instanceof GuiScreen);
    }

    public static List<Entity> getEntityList() {
        return Wrapper.INSTANCE.world().func_72910_y();
    }

    public static boolean checkEnemyColor(EntityPlayer llIllIIIllIlII) {
        int llIllIIIllllII = Utils.getPlayerArmorColor(llIllIIIllIlII, llIllIIIllIlII.inventory.armorItemInSlot(0));
        int llIllIIIlllIll = Utils.getPlayerArmorColor(llIllIIIllIlII, llIllIIIllIlII.inventory.armorItemInSlot(1));
        int llIllIIIlllIlI = Utils.getPlayerArmorColor(llIllIIIllIlII, llIllIIIllIlII.inventory.armorItemInSlot(2));
        int llIllIIIlllIIl = Utils.getPlayerArmorColor(llIllIIIllIlII, llIllIIIllIlII.inventory.armorItemInSlot(3));
        int llIllIIIlllIII = Utils.getPlayerArmorColor((EntityPlayer)Wrapper.INSTANCE.player(), Wrapper.INSTANCE.inventory().armorItemInSlot(0));
        int llIllIIIllIlll = Utils.getPlayerArmorColor((EntityPlayer)Wrapper.INSTANCE.player(), Wrapper.INSTANCE.inventory().armorItemInSlot(1));
        int llIllIIIllIllI = Utils.getPlayerArmorColor((EntityPlayer)Wrapper.INSTANCE.player(), Wrapper.INSTANCE.inventory().armorItemInSlot(2));
        int llIllIIIllIlIl = Utils.getPlayerArmorColor((EntityPlayer)Wrapper.INSTANCE.player(), Wrapper.INSTANCE.inventory().armorItemInSlot(3));
        return !(llIllIIIllllII == llIllIIIlllIII && llIllIIIlllIII != -1 && llIllIIIllllII != 1 || llIllIIIlllIll == llIllIIIllIlll && llIllIIIllIlll != -1 && llIllIIIlllIll != 1 || llIllIIIlllIlI == llIllIIIllIllI && llIllIIIllIllI != -1 && llIllIIIlllIlI != 1) && (llIllIIIlllIIl != llIllIIIllIlIl || llIllIIIllIlIl == -1 || llIllIIIlllIIl == 1);
    }

    public static float[] getRotationsNeeded(Entity llIlIlIlIIIlIl) {
        double llIlIlIlIIlIIl;
        if (llIlIlIlIIIlIl == null) {
            return null;
        }
        double llIlIlIlIIlIll = llIlIlIlIIIlIl.posX - Wrapper.INSTANCE.mc().player.field_70165_t;
        double llIlIlIlIIlIlI = llIlIlIlIIIlIl.posZ - Wrapper.INSTANCE.mc().player.field_70161_v;
        if (llIlIlIlIIIlIl instanceof EntityLivingBase) {
            EntityLivingBase llIlIlIlIIlllI = (EntityLivingBase)llIlIlIlIIIlIl;
            double llIlIlIlIIllIl = llIlIlIlIIlllI.field_70163_u + (double)llIlIlIlIIlllI.func_70047_e() - (Wrapper.INSTANCE.mc().player.field_70163_u + (double)Wrapper.INSTANCE.mc().player.func_70047_e());
        } else {
            llIlIlIlIIlIIl = (llIlIlIlIIIlIl.getEntityBoundingBox().minY + llIlIlIlIIIlIl.getEntityBoundingBox().maxY) / 2.0 - (Wrapper.INSTANCE.mc().player.field_70163_u + (double)Wrapper.INSTANCE.mc().player.func_70047_e());
        }
        double llIlIlIlIIlIII = MathHelper.sqrt((double)(llIlIlIlIIlIll * llIlIlIlIIlIll + llIlIlIlIIlIlI * llIlIlIlIIlIlI));
        float llIlIlIlIIIlll = (float)(Math.atan2(llIlIlIlIIlIlI, llIlIlIlIIlIll) * 180.0 / Math.PI) - 90.0f;
        float llIlIlIlIIIllI = (float)(-(Math.atan2(llIlIlIlIIlIIl, llIlIlIlIIlIII) * 180.0 / Math.PI));
        return new float[]{Wrapper.INSTANCE.mc().player.field_70177_z + MathHelper.wrapDegrees((float)(llIlIlIlIIIlll - Wrapper.INSTANCE.mc().player.field_70177_z)), Wrapper.INSTANCE.mc().player.field_70125_A + MathHelper.wrapDegrees((float)(llIlIlIlIIIllI - Wrapper.INSTANCE.mc().player.field_70125_A))};
    }

    public static void faceVectorPacketInstant(Vec3d llIllIllIIllIl) {
        rotationsToBlock = Utils.getNeededRotations(llIllIllIIllIl);
    }

    public static float[] getNeededRotations(Vec3d llIlIlllIlllII) {
        Vec3d llIlIlllIllIll = Utils.getEyesPos();
        double llIlIlllIllIlI = llIlIlllIlllII.x - llIlIlllIllIll.x;
        double llIlIlllIllIIl = llIlIlllIlllII.y - llIlIlllIllIll.y;
        double llIlIlllIllIII = llIlIlllIlllII.z - llIlIlllIllIll.z;
        double llIlIlllIlIlll = Math.sqrt(llIlIlllIllIlI * llIlIlllIllIlI + llIlIlllIllIII * llIlIlllIllIII);
        float llIlIlllIlIllI = (float)Math.toDegrees(Math.atan2(llIlIlllIllIII, llIlIlllIllIlI)) - 90.0f;
        float llIlIlllIlIlIl = (float)(-Math.toDegrees(Math.atan2(llIlIlllIllIIl, llIlIlllIlIlll)));
        return new float[]{Wrapper.INSTANCE.player().field_70177_z + MathHelper.wrapDegrees((float)(llIlIlllIlIllI - Wrapper.INSTANCE.player().field_70177_z)), Wrapper.INSTANCE.player().field_70125_A + MathHelper.wrapDegrees((float)(llIlIlllIlIlIl - Wrapper.INSTANCE.player().field_70125_A))};
    }

    public static boolean checkEnemyNameColor(EntityLivingBase llIllIIlIllIIl) {
        String llIllIIlIllIII = llIllIIlIllIIl.func_145748_c_().getFormattedText();
        return !Utils.getEntityNameColor((EntityLivingBase)Wrapper.INSTANCE.player()).equals(Utils.getEntityNameColor(llIllIIlIllIIl));
    }

    public static void copy(String llIllIllIlllIl) {
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(llIllIllIlllIl), null);
    }

    public static int getDistanceFromMouse(EntityLivingBase llIlIlIllllIlI) {
        float[] llIlIlIllllIIl = Utils.getRotationsNeeded((Entity)llIlIlIllllIlI);
        if (llIlIlIllllIIl != null) {
            float llIlIlIlllllIl = Wrapper.INSTANCE.player().field_70177_z - llIlIlIllllIIl[0];
            float llIlIlIlllllII = Wrapper.INSTANCE.player().field_70125_A - llIlIlIllllIIl[1];
            float llIlIlIllllIll = MathHelper.sqrt((float)(llIlIlIlllllIl * llIlIlIlllllIl + llIlIlIlllllII * llIlIlIlllllII * 2.0f));
            return (int)llIlIlIllllIll;
        }
        return -1;
    }

    public static float getYaw(Entity llIlIllllIlllI) {
        double llIlIllllIllIl = llIlIllllIlllI.posX - Wrapper.INSTANCE.player().field_70165_t;
        double llIlIllllIllII = llIlIllllIlllI.posY - Wrapper.INSTANCE.player().field_70163_u;
        double llIlIllllIlIll = llIlIllllIlllI.posZ - Wrapper.INSTANCE.player().field_70161_v;
        double llIlIllllIlIlI = Math.atan2(llIlIllllIllIl, llIlIllllIlIll) * 57.29577951308232;
        llIlIllllIlIlI = -llIlIllllIlIlI;
        return (float)llIlIllllIlIlI;
    }

    public Utils() {
        Utils llIllIllIlllll;
    }

    public static Vec3d getRandomCenter(AxisAlignedBB llIllIllIlIlII) {
        return new Vec3d(llIllIllIlIlII.minX + (llIllIllIlIlII.maxX - llIllIllIlIlII.minX) * 0.8 * Math.random(), llIllIllIlIlII.minY + (llIllIllIlIlII.maxY - llIllIllIlIlII.minY) * Math.random() + 0.1 * Math.random(), llIllIllIlIlII.minZ + (llIllIllIlIlII.maxZ - llIllIllIlIlII.minZ) * 0.8 * Math.random());
    }

    public static Vec3d getEyesPos() {
        return new Vec3d(Wrapper.INSTANCE.player().field_70165_t, Wrapper.INSTANCE.player().field_70163_u + (double)Wrapper.INSTANCE.player().func_70047_e(), Wrapper.INSTANCE.player().field_70161_v);
    }

    public static float[] getSmoothNeededRotations(Vec3d llIlIlIllIlIIl, float llIlIlIlIllllI, float llIlIlIlIlllIl) {
        Vec3d llIlIlIllIIllI = Utils.getEyesPos();
        double llIlIlIllIIlIl = llIlIlIllIlIIl.x - llIlIlIllIIllI.x;
        double llIlIlIllIIlII = llIlIlIllIlIIl.y - llIlIlIllIIllI.y;
        double llIlIlIllIIIll = llIlIlIllIlIIl.z - llIlIlIllIIllI.z;
        double llIlIlIllIIIlI = Math.sqrt(llIlIlIllIIlIl * llIlIlIllIIlIl + llIlIlIllIIIll * llIlIlIllIIIll);
        float llIlIlIllIIIIl = (float)Math.toDegrees(Math.atan2(llIlIlIllIIIll, llIlIlIllIIlIl)) - 90.0f;
        float llIlIlIllIIIII = (float)(-Math.toDegrees(Math.atan2(llIlIlIllIIlII, llIlIlIllIIIlI)));
        return new float[]{Utils.updateRotation(Wrapper.INSTANCE.player().field_70177_z, llIlIlIllIIIIl, llIlIlIlIllllI / 4.0f), Utils.updateRotation(Wrapper.INSTANCE.player().field_70125_A, llIlIlIllIIIII, llIlIlIlIlllIl / 4.0f)};
    }

    public static void attack(Entity llIllIlIllllII) {
        Wrapper.INSTANCE.controller().attackEntity((EntityPlayer)Wrapper.INSTANCE.player(), llIllIlIllllII);
    }

    public static List<EntityPlayer> getPlayersList() {
        return Wrapper.INSTANCE.world().field_73010_i;
    }

    public static void removeEffect(int llIllIlIllIIII) {
        Wrapper.INSTANCE.player().func_184589_d(Potion.getPotionById((int)llIllIlIllIIII));
    }

    public static boolean isBlockEdge(EntityLivingBase llIlIlllIIIlIl) {
        return Wrapper.INSTANCE.world().func_184144_a((Entity)llIlIlllIIIlIl, llIlIlllIIIlIl.func_174813_aQ().offset(0.0, -0.5, 0.0).expand(0.001, 0.0, 0.001)).isEmpty() && llIlIlllIIIlIl.field_70122_E;
    }

    public static boolean isPlayer(Entity llIllIIlIlllll) {
        String llIllIIllIIIIl;
        EntityPlayer llIllIIllIIIll;
        String llIllIIllIIIlI;
        return llIllIIlIlllll instanceof EntityPlayer && (llIllIIllIIIlI = Utils.getPlayerName(llIllIIllIIIll = (EntityPlayer)llIllIIlIlllll)).equals(llIllIIllIIIIl = Utils.getPlayerName((EntityPlayer)Wrapper.INSTANCE.player()));
    }

    public static int getPlayerArmorColor(EntityPlayer llIllIIlIIllII, ItemStack llIllIIlIIlIll) {
        if (llIllIIlIIllII == null || llIllIIlIIlIll == null || llIllIIlIIlIll.getItem() == null || !(llIllIIlIIlIll.getItem() instanceof ItemArmor)) {
            return -1;
        }
        ItemArmor llIllIIlIIlIlI = (ItemArmor)llIllIIlIIlIll.getItem();
        if (llIllIIlIIlIlI == null || llIllIIlIIlIlI.getArmorMaterial() != ItemArmor.ArmorMaterial.LEATHER) {
            return -1;
        }
        return llIllIIlIIlIlI.getColor(llIllIIlIIlIll);
    }

    public static void swingMainHand() {
        Wrapper.INSTANCE.player().swingArm(EnumHand.MAIN_HAND);
    }

    public static double[] teleportToPosition(double[] llIllIlIIlIIlI, double[] llIllIlIIlIIIl, double llIllIlIIlIIII, double llIllIlIIIllll, boolean llIllIIlllllll, boolean llIllIlIIIllIl) {
        boolean llIllIlIIIllII = false;
        if (Wrapper.INSTANCE.player().isSneaking()) {
            llIllIlIIIllII = true;
        }
        double llIllIlIIIlIll = llIllIlIIlIIlI[0];
        double llIllIlIIIlIlI = llIllIlIIlIIlI[1];
        double llIllIlIIIlIIl = llIllIlIIlIIlI[2];
        double llIllIlIIIlIII = llIllIlIIlIIIl[0];
        double llIllIlIIIIlll = llIllIlIIlIIIl[1];
        double llIllIlIIIIllI = llIllIlIIlIIIl[2];
        double llIllIlIIIIlIl = Math.abs(llIllIlIIIlIll - llIllIlIIIlIlI) + Math.abs(llIllIlIIIlIlI - llIllIlIIIIlll) + Math.abs(llIllIlIIIlIIl - llIllIlIIIIllI);
        int llIllIlIIIIlII = 0;
        while (llIllIlIIIIlIl > llIllIlIIIllll) {
            llIllIlIIIIlIl = Math.abs(llIllIlIIIlIll - llIllIlIIIlIII) + Math.abs(llIllIlIIIlIlI - llIllIlIIIIlll) + Math.abs(llIllIlIIIlIIl - llIllIlIIIIllI);
            if (llIllIlIIIIlII > 120) break;
            double llIllIlIIlIllI = llIllIIlllllll && (llIllIlIIIIlII & 1) == 0 ? llIllIlIIlIIII + 0.15 : llIllIlIIlIIII;
            double llIllIlIIlIlIl = llIllIlIIIlIll - llIllIlIIIlIII;
            double llIllIlIIlIlII = llIllIlIIIlIlI - llIllIlIIIIlll;
            double llIllIlIIlIIll = llIllIlIIIlIIl - llIllIlIIIIllI;
            if (llIllIlIIlIlIl < 0.0) {
                llIllIlIIIlIll = Math.abs(llIllIlIIlIlIl) > llIllIlIIlIllI ? (llIllIlIIIlIll += llIllIlIIlIllI) : (llIllIlIIIlIll += Math.abs(llIllIlIIlIlIl));
            }
            if (llIllIlIIlIlIl > 0.0) {
                llIllIlIIIlIll = Math.abs(llIllIlIIlIlIl) > llIllIlIIlIllI ? (llIllIlIIIlIll -= llIllIlIIlIllI) : (llIllIlIIIlIll -= Math.abs(llIllIlIIlIlIl));
            }
            if (llIllIlIIlIlII < 0.0) {
                llIllIlIIIlIlI = Math.abs(llIllIlIIlIlII) > llIllIlIIlIllI ? (llIllIlIIIlIlI += llIllIlIIlIllI) : (llIllIlIIIlIlI += Math.abs(llIllIlIIlIlII));
            }
            if (llIllIlIIlIlII > 0.0) {
                llIllIlIIIlIlI = Math.abs(llIllIlIIlIlII) > llIllIlIIlIllI ? (llIllIlIIIlIlI -= llIllIlIIlIllI) : (llIllIlIIIlIlI -= Math.abs(llIllIlIIlIlII));
            }
            if (llIllIlIIlIIll < 0.0) {
                llIllIlIIIlIIl = Math.abs(llIllIlIIlIIll) > llIllIlIIlIllI ? (llIllIlIIIlIIl += llIllIlIIlIllI) : (llIllIlIIIlIIl += Math.abs(llIllIlIIlIIll));
            }
            if (llIllIlIIlIIll > 0.0) {
                llIllIlIIIlIIl = Math.abs(llIllIlIIlIIll) > llIllIlIIlIllI ? (llIllIlIIIlIIl -= llIllIlIIlIllI) : (llIllIlIIIlIIl -= Math.abs(llIllIlIIlIIll));
            }
            if (llIllIlIIIllII) {
                Wrapper.INSTANCE.sendPacket((Packet)new CPacketEntityAction((Entity)Wrapper.INSTANCE.player(), CPacketEntityAction.Action.STOP_SNEAKING));
            }
            Wrapper.INSTANCE.mc().getConnection().getNetworkManager().sendPacket((Packet)new CPacketPlayer.Position(llIllIlIIIlIll, llIllIlIIIlIlI, llIllIlIIIlIIl, llIllIlIIIllIl));
            ++llIllIlIIIIlII;
        }
        if (llIllIlIIIllII) {
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketEntityAction((Entity)Wrapper.INSTANCE.player(), CPacketEntityAction.Action.START_SNEAKING));
        }
        return new double[]{llIllIlIIIlIll, llIllIlIIIlIlI, llIllIlIIIlIIl};
    }

    public static void selfDamage(double llIllIIllIllII) {
        if (!Wrapper.INSTANCE.player().field_70122_E) {
            return;
        }
        int llIllIIllIlllI = 0;
        while ((double)llIllIIllIlllI <= 64.0) {
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayer.Position(Wrapper.INSTANCE.player().field_70165_t, Wrapper.INSTANCE.player().field_70163_u + llIllIIllIllII, Wrapper.INSTANCE.player().field_70161_v, false));
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayer.Position(Wrapper.INSTANCE.player().field_70165_t, Wrapper.INSTANCE.player().field_70163_u, Wrapper.INSTANCE.player().field_70161_v, (double)llIllIIllIlllI == 64.0));
            ++llIllIIllIlllI;
        }
        Wrapper.INSTANCE.player().field_70159_w *= 0.2;
        Wrapper.INSTANCE.player().field_70179_y *= 0.2;
        Utils.swingMainHand();
    }

    public static String getEntityNameColor(EntityLivingBase llIllIIlIlIIIl) {
        String llIllIIlIlIIlI = llIllIIlIlIIIl.func_145748_c_().getFormattedText();
        if (llIllIIlIlIIlI.contains("\u00a7")) {
            if (llIllIIlIlIIlI.contains("\u00a71")) {
                return "\u00a71";
            }
            if (llIllIIlIlIIlI.contains("\u00a72")) {
                return "\u00a72";
            }
            if (llIllIIlIlIIlI.contains("\u00a73")) {
                return "\u00a73";
            }
            if (llIllIIlIlIIlI.contains("\u00a74")) {
                return "\u00a74";
            }
            if (llIllIIlIlIIlI.contains("\u00a75")) {
                return "\u00a75";
            }
            if (llIllIIlIlIIlI.contains("\u00a76")) {
                return "\u00a76";
            }
            if (llIllIIlIlIIlI.contains("\u00a77")) {
                return "\u00a77";
            }
            if (llIllIIlIlIIlI.contains("\u00a78")) {
                return "\u00a78";
            }
            if (llIllIIlIlIIlI.contains("\u00a79")) {
                return "\u00a79";
            }
            if (llIllIIlIlIIlI.contains("\u00a70")) {
                return "\u00a70";
            }
            if (llIllIIlIlIIlI.contains("\u00a7e")) {
                return "\u00a7e";
            }
            if (llIllIIlIlIIlI.contains("\u00a7d")) {
                return "\u00a7d";
            }
            if (llIllIIlIlIIlI.contains("\u00a7a")) {
                return "\u00a7a";
            }
            if (llIllIIlIlIIlI.contains("\u00a7b")) {
                return "\u00a7b";
            }
            if (llIllIIlIlIIlI.contains("\u00a7c")) {
                return "\u00a7c";
            }
            if (llIllIIlIlIIlI.contains("\u00a7f")) {
                return "\u00a7f";
            }
        }
        return "null";
    }

    public static void clearEffects() {
        for (PotionEffect llIllIlIlIllII : Wrapper.INSTANCE.player().func_70651_bq()) {
            Wrapper.INSTANCE.player().func_184589_d(llIllIlIlIllII.getPotion());
        }
    }

    public static int random(int llIllIllIlIlll, int llIllIllIllIII) {
        return RANDOM.nextInt(llIllIllIllIII - llIllIllIlIlll) + llIllIllIlIlll;
    }

    public static float[] getDirectionToBlock(int llIllIIIIIlIlI, int llIllIIIIIlIIl, int llIllIIIIIllIl, EnumFacing llIllIIIIIllII) {
        EntityEgg llIllIIIIIlIll = new EntityEgg((World)Wrapper.INSTANCE.world());
        llIllIIIIIlIll.field_70165_t = (double)llIllIIIIIlIlI + 0.5;
        llIllIIIIIlIll.field_70163_u = (double)llIllIIIIIlIIl + 0.5;
        llIllIIIIIlIll.field_70161_v = (double)llIllIIIIIllIl + 0.5;
        llIllIIIIIlIll.field_70165_t += (double)llIllIIIIIllII.getDirectionVec().getX() * 0.25;
        llIllIIIIIlIll.field_70163_u += (double)llIllIIIIIllII.getDirectionVec().getY() * 0.25;
        llIllIIIIIlIll.field_70161_v += (double)llIllIIIIIllII.getDirectionVec().getZ() * 0.25;
        return Utils.getDirectionToEntity((Entity)llIllIIIIIlIll);
    }

    public static void addEffect(int llIllIlIllIlll, int llIllIlIllIIll, int llIllIlIllIlIl) {
        Wrapper.INSTANCE.player().func_70690_d(new PotionEffect(Potion.getPotionById((int)llIllIlIllIlll), llIllIlIllIIll, llIllIlIllIlIl));
    }

    public static boolean nullCheck() {
        return Wrapper.INSTANCE.player() == null || Wrapper.INSTANCE.world() == null;
    }

    public static double round(double llIllIIIlIIlIl, int llIllIIIlIIlll) {
        if (llIllIIIlIIlll < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal llIllIIIlIIllI = new BigDecimal(llIllIIIlIIlIl);
        llIllIIIlIIllI = llIllIIIlIIllI.setScale(llIllIIIlIIlll, RoundingMode.HALF_UP);
        return llIllIIIlIIllI.doubleValue();
    }

    public static String getPlayerName(EntityPlayer llIllIIllIlIIl) {
        return llIllIIllIlIIl.getGameProfile() != null ? llIllIIllIlIIl.getGameProfile().getName() : "null";
    }

    public static float getPitch(Entity llIlIlllllllIl) {
        double llIlIlllllllII = llIlIlllllllIl.posX - Wrapper.INSTANCE.player().field_70165_t;
        double llIlIllllllIll = llIlIlllllllIl.posY - Wrapper.INSTANCE.player().field_70163_u;
        double llIlIllllllIlI = llIlIlllllllIl.posZ - Wrapper.INSTANCE.player().field_70161_v;
        double llIlIllllllIIl = Math.asin(llIlIllllllIll /= (double)Wrapper.INSTANCE.player().func_70032_d(llIlIlllllllIl)) * 57.29577951308232;
        llIlIllllllIIl = -llIlIllllllIIl;
        return (float)llIlIllllllIIl;
    }

    public static boolean isNullOrEmptyStack(ItemStack llIllIllIIlIll) {
        return llIllIllIIlIll == null || llIllIllIIlIll.isEmpty();
    }

    public static float updateRotation(float llIlIllIIIIllI, float llIlIllIIIIlIl, float llIlIllIIIlIII) {
        float llIlIllIIIIlll = MathHelper.wrapDegrees((float)(llIlIllIIIIlIl - llIlIllIIIIllI));
        if (llIlIllIIIIlll > llIlIllIIIlIII) {
            llIlIllIIIIlll = llIlIllIIIlIII;
        }
        if (llIlIllIIIIlll < -llIlIllIIIlIII) {
            llIlIllIIIIlll = -llIlIllIIIlIII;
        }
        return llIlIllIIIIllI + llIlIllIIIIlll;
    }

    public static float getDirection() {
        float llIlIlllIIlIlI = Wrapper.INSTANCE.player().field_70177_z;
        if (Wrapper.INSTANCE.player().field_191988_bg < 0.0f) {
            llIlIlllIIlIlI += 180.0f;
        }
        float llIlIlllIIlIIl = 1.0f;
        if (Wrapper.INSTANCE.player().field_191988_bg < 0.0f) {
            llIlIlllIIlIIl = -0.5f;
        } else if (Wrapper.INSTANCE.player().field_191988_bg > 0.0f) {
            llIlIlllIIlIIl = 0.5f;
        }
        if (Wrapper.INSTANCE.player().field_70702_br > 0.0f) {
            llIlIlllIIlIlI -= 90.0f * llIlIlllIIlIIl;
        }
        if (Wrapper.INSTANCE.player().field_70702_br < 0.0f) {
            llIlIlllIIlIlI += 90.0f * llIlIlllIIlIIl;
        }
        return llIlIlllIIlIlI *= (float)Math.PI / 180;
    }

    public static boolean isMoving(Entity llIllIllIlIIII) {
        return llIllIllIlIIII.motionX != 0.0 && llIllIllIlIIII.motionZ != 0.0 && (llIllIllIlIIII.motionY != 0.0 || llIllIllIlIIII.motionY > 0.0);
    }

    public static void windowClick(int llIllIllIIIlIl, int llIllIllIIIIII, int llIllIllIIIIll, ClickType llIllIllIIIIlI) {
        Wrapper.INSTANCE.controller().windowClick(llIllIllIIIlIl, llIllIllIIIIII, llIllIllIIIIll, llIllIllIIIIlI, (EntityPlayer)Wrapper.INSTANCE.player());
    }

    public static void faceEntity(EntityLivingBase llIlIllIlllIll) {
        if (llIlIllIlllIll == null) {
            return;
        }
        double llIlIllIlllIlI = llIlIllIlllIll.field_70165_t - Wrapper.INSTANCE.player().field_70165_t;
        double llIlIllIlllIIl = llIlIllIlllIll.field_70163_u - Wrapper.INSTANCE.player().field_70163_u;
        double llIlIllIlllIII = llIlIllIlllIll.field_70161_v - Wrapper.INSTANCE.player().field_70161_v;
        double llIlIllIllIlll = Wrapper.INSTANCE.player().field_70163_u + (double)Wrapper.INSTANCE.player().func_70047_e() - (llIlIllIlllIll.field_70163_u + (double)llIlIllIlllIll.func_70047_e());
        double llIlIllIllIllI = MathHelper.sqrt((double)(llIlIllIlllIlI * llIlIllIlllIlI + llIlIllIlllIII * llIlIllIlllIII));
        float llIlIllIllIlIl = (float)(Math.atan2(llIlIllIlllIII, llIlIllIlllIlI) * 180.0 / Math.PI) - 90.0f;
        float llIlIllIllIlII = (float)(-(Math.atan2(llIlIllIllIlll, llIlIllIllIllI) * 180.0 / Math.PI));
        Wrapper.INSTANCE.player().field_70177_z = llIlIllIllIlIl;
        Wrapper.INSTANCE.player().field_70125_A = llIlIllIllIlII;
    }
}

