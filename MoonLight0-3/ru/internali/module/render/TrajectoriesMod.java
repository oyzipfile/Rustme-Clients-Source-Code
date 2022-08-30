/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBow
 *  net.minecraft.item.ItemEgg
 *  net.minecraft.item.ItemEnderPearl
 *  net.minecraft.item.ItemFishingRod
 *  net.minecraft.item.ItemLingeringPotion
 *  net.minecraft.item.ItemPotion
 *  net.minecraft.item.ItemSnowball
 *  net.minecraft.item.ItemSplashPotion
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.opengl.GL11
 */
package ru.internali.module.render;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemEgg;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemLingeringPotion;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemSnowball;
import net.minecraft.item.ItemSplashPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;
import ru.internali.module.Category;
import ru.internali.module.Module;

public class TrajectoriesMod
extends Module {
    public static /* synthetic */ List<String> listA;
    private transient /* synthetic */ int BOX;

    static {
        listA = new ArrayList<String>();
    }

    public static boolean isCollidable(Block lIllllIlllIlIl) {
        return lIllllIlllIlIl != Blocks.AIR && lIllllIlllIlIl != Blocks.BEETROOTS && lIllllIlllIlIl != Blocks.CARROTS && lIllllIlllIlIl != Blocks.DEADBUSH && lIllllIlllIlIl != Blocks.DOUBLE_PLANT && lIllllIlllIlIl != Blocks.FLOWING_LAVA && lIllllIlllIlIl != Blocks.FLOWING_WATER && lIllllIlllIlIl != Blocks.LAVA && lIllllIlllIlIl != Blocks.MELON_STEM && lIllllIlllIlIl != Blocks.NETHER_WART && lIllllIlllIlIl != Blocks.POTATOES && lIllllIlllIlIl != Blocks.PUMPKIN_STEM && lIllllIlllIlIl != Blocks.RED_FLOWER && lIllllIlllIlIl != Blocks.RED_MUSHROOM && lIllllIlllIlIl != Blocks.REDSTONE_TORCH && lIllllIlllIlIl != Blocks.TALLGRASS && lIllllIlllIlIl != Blocks.TORCH && lIllllIlllIlIl != Blocks.UNLIT_REDSTONE_TORCH && lIllllIlllIlIl != Blocks.YELLOW_FLOWER && lIllllIlllIlIl != Blocks.VINE && lIllllIlllIlIl != Blocks.WATER && lIllllIlllIlIl != Blocks.WEB && lIllllIlllIlIl != Blocks.WHEAT;
    }

    public static void drawSolidBox(AxisAlignedBB lIllllIllllIll) {
        GL11.glBegin((int)7);
        GL11.glVertex3d((double)lIllllIllllIll.minX, (double)lIllllIllllIll.minY, (double)lIllllIllllIll.minZ);
        GL11.glVertex3d((double)lIllllIllllIll.minX, (double)lIllllIllllIll.maxY, (double)lIllllIllllIll.minZ);
        GL11.glVertex3d((double)lIllllIllllIll.maxX, (double)lIllllIllllIll.maxY, (double)lIllllIllllIll.minZ);
        GL11.glVertex3d((double)lIllllIllllIll.maxX, (double)lIllllIllllIll.minY, (double)lIllllIllllIll.minZ);
        GL11.glVertex3d((double)lIllllIllllIll.maxX, (double)lIllllIllllIll.minY, (double)lIllllIllllIll.minZ);
        GL11.glVertex3d((double)lIllllIllllIll.maxX, (double)lIllllIllllIll.maxY, (double)lIllllIllllIll.minZ);
        GL11.glVertex3d((double)lIllllIllllIll.maxX, (double)lIllllIllllIll.maxY, (double)lIllllIllllIll.maxZ);
        GL11.glVertex3d((double)lIllllIllllIll.maxX, (double)lIllllIllllIll.minY, (double)lIllllIllllIll.maxZ);
        GL11.glVertex3d((double)lIllllIllllIll.minX, (double)lIllllIllllIll.minY, (double)lIllllIllllIll.maxZ);
        GL11.glVertex3d((double)lIllllIllllIll.maxX, (double)lIllllIllllIll.minY, (double)lIllllIllllIll.maxZ);
        GL11.glVertex3d((double)lIllllIllllIll.maxX, (double)lIllllIllllIll.maxY, (double)lIllllIllllIll.maxZ);
        GL11.glVertex3d((double)lIllllIllllIll.minX, (double)lIllllIllllIll.maxY, (double)lIllllIllllIll.maxZ);
        GL11.glVertex3d((double)lIllllIllllIll.minX, (double)lIllllIllllIll.minY, (double)lIllllIllllIll.minZ);
        GL11.glVertex3d((double)lIllllIllllIll.minX, (double)lIllllIllllIll.minY, (double)lIllllIllllIll.maxZ);
        GL11.glVertex3d((double)lIllllIllllIll.minX, (double)lIllllIllllIll.maxY, (double)lIllllIllllIll.maxZ);
        GL11.glVertex3d((double)lIllllIllllIll.minX, (double)lIllllIllllIll.maxY, (double)lIllllIllllIll.minZ);
        GL11.glVertex3d((double)lIllllIllllIll.minX, (double)lIllllIllllIll.minY, (double)lIllllIllllIll.minZ);
        GL11.glVertex3d((double)lIllllIllllIll.maxX, (double)lIllllIllllIll.minY, (double)lIllllIllllIll.minZ);
        GL11.glVertex3d((double)lIllllIllllIll.maxX, (double)lIllllIllllIll.minY, (double)lIllllIllllIll.maxZ);
        GL11.glVertex3d((double)lIllllIllllIll.minX, (double)lIllllIllllIll.minY, (double)lIllllIllllIll.maxZ);
        GL11.glVertex3d((double)lIllllIllllIll.minX, (double)lIllllIllllIll.maxY, (double)lIllllIllllIll.minZ);
        GL11.glVertex3d((double)lIllllIllllIll.minX, (double)lIllllIllllIll.maxY, (double)lIllllIllllIll.maxZ);
        GL11.glVertex3d((double)lIllllIllllIll.maxX, (double)lIllllIllllIll.maxY, (double)lIllllIllllIll.maxZ);
        GL11.glVertex3d((double)lIllllIllllIll.maxX, (double)lIllllIllllIll.maxY, (double)lIllllIllllIll.minZ);
        GL11.glEnd();
    }

    public TrajectoriesMod() {
        super("Trajectories", "Show how will fly peral or arrow", Category.RENDER);
        TrajectoriesMod lIlllllIIIIIIl;
        lIlllllIIIIIIl.BOX = 0;
    }

    boolean predictHit(Vec3d lIllllIIIlllll, Vec3d lIllllIIIllllI, Vec3d lIllllIIIlllIl, double lIllllIIIlllII) {
        boolean lIllllIIIllIll = false;
        for (int lIllllIIlIIIIl = 0; lIllllIIlIIIIl < 250; ++lIllllIIlIIIIl) {
            Block lIllllIIlIIIlI;
            lIllllIIIllllI = lIllllIIIllllI.add(lIllllIIIlllIl.scale(0.4));
            lIllllIIIlllIl = new Vec3d(lIllllIIIlllIl.x * 0.996, lIllllIIIlllIl.y * 0.996 - lIllllIIIlllII * 4.0, lIllllIIIlllIl.z * 0.996);
            for (Entity lIllllIIlIIlII : Minecraft.getMinecraft().world.field_72996_f) {
                if (!(lIllllIIlIIlII instanceof EntityLiving) || !lIllllIIlIIlII.getEntityBoundingBox().grow(0.35, 0.35, 0.35).contains(lIllllIIIllllI)) continue;
                lIllllIIIllIll = true;
                break;
            }
            if (lIllllIIIllIll) break;
            for (EntityPlayer lIllllIIlIIIll : Minecraft.getMinecraft().world.field_73010_i) {
                if (lIllllIIlIIIll == Minecraft.getMinecraft().player || !lIllllIIlIIIll.func_174813_aQ().grow(0.35, 0.35, 0.35).contains(lIllllIIIllllI)) continue;
                lIllllIIIllIll = true;
                break;
            }
            if (lIllllIIIllIll || TrajectoriesMod.isCollidable(lIllllIIlIIIlI = Minecraft.getMinecraft().world.func_180495_p(new BlockPos(lIllllIIIllllI)).getBlock())) break;
        }
        return lIllllIIIllIll;
    }

    @Override
    public void onDisable() {
        TrajectoriesMod lIllllIllllllI;
        super.onDisable();
    }

    @SubscribeEvent
    public void onRender(RenderWorldLastEvent lIllllIlIlIllI) {
        TrajectoriesMod lIllllIlIlIlll;
        EntityPlayerSP lIllllIlIlIlIl = Minecraft.getMinecraft().player;
        ItemStack lIllllIlIlIlII = lIllllIlIlIlIl.inventory.getCurrentItem();
        if (lIllllIlIlIlII == null) {
            return;
        }
        Item lIllllIlIlIIll = lIllllIlIlIlII.getItem();
        if (!(lIllllIlIlIIll instanceof ItemBow || lIllllIlIlIIll instanceof ItemSnowball || lIllllIlIlIIll instanceof ItemEgg || lIllllIlIlIIll instanceof ItemEnderPearl || lIllllIlIlIIll instanceof ItemSplashPotion || lIllllIlIlIIll instanceof ItemLingeringPotion || lIllllIlIlIIll instanceof ItemFishingRod)) {
            return;
        }
        boolean lIllllIlIlIIlI = lIllllIlIlIlII.getItem() instanceof ItemBow;
        double lIllllIlIlIIIl = lIllllIlIlIlIl.field_70142_S + (lIllllIlIlIlIl.field_70165_t - lIllllIlIlIlIl.field_70142_S) * (double)mc.getRenderPartialTicks() - Math.cos((float)Math.toRadians(lIllllIlIlIlIl.field_70177_z)) * (double)0.08f;
        double lIllllIlIlIIII = lIllllIlIlIlIl.field_70137_T + (lIllllIlIlIlIl.field_70163_u - lIllllIlIlIlIl.field_70137_T) * (double)mc.getRenderPartialTicks() + (double)lIllllIlIlIlIl.getEyeHeight() - 0.04;
        double lIllllIlIIllll = lIllllIlIlIlIl.field_70136_U + (lIllllIlIlIlIl.field_70161_v - lIllllIlIlIlIl.field_70136_U) * (double)mc.getRenderPartialTicks() - Math.sin((float)Math.toRadians(lIllllIlIlIlIl.field_70177_z)) * (double)0.08f;
        float lIllllIlIIlllI = lIllllIlIlIIlI ? 1.0f : 0.4f;
        float lIllllIlIIllIl = (float)Math.toRadians(lIllllIlIlIlIl.field_70177_z);
        float lIllllIlIIllII = (float)Math.toRadians(lIllllIlIlIlIl.field_70125_A);
        double lIllllIlIIlIll = -Math.sin(lIllllIlIIllIl) * Math.cos(lIllllIlIIllII) * (double)lIllllIlIIlllI;
        double lIllllIlIIlIlI = -Math.sin(lIllllIlIIllII) * (double)lIllllIlIIlllI;
        double lIllllIlIIlIIl = Math.cos(lIllllIlIIllIl) * Math.cos(lIllllIlIIllII) * (double)lIllllIlIIlllI;
        double lIllllIlIIlIII = Math.sqrt(lIllllIlIIlIll * lIllllIlIIlIll + lIllllIlIIlIlI * lIllllIlIIlIlI + lIllllIlIIlIIl * lIllllIlIIlIIl);
        lIllllIlIIlIll /= lIllllIlIIlIII;
        lIllllIlIIlIlI /= lIllllIlIIlIII;
        lIllllIlIIlIIl /= lIllllIlIIlIII;
        if (lIllllIlIlIIlI) {
            float lIllllIlIlllII = (float)(72000 - lIllllIlIlIlIl.func_184605_cv()) / 20.0f;
            if ((lIllllIlIlllII = (lIllllIlIlllII * lIllllIlIlllII + lIllllIlIlllII * 2.0f) / 3.0f) > 1.0f || lIllllIlIlllII <= 0.1f) {
                lIllllIlIlllII = 1.0f;
            }
            lIllllIlIIlIll *= (double)(lIllllIlIlllII *= 3.0f);
            lIllllIlIIlIlI *= (double)lIllllIlIlllII;
            lIllllIlIIlIIl *= (double)lIllllIlIlllII;
        } else {
            lIllllIlIIlIll *= 1.5;
            lIllllIlIIlIlI *= 1.5;
            lIllllIlIIlIIl *= 1.5;
        }
        GL11.glPushAttrib((int)24837);
        GL11.glDisable((int)2896);
        GL11.glDisable((int)3553);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        GL11.glEnable((int)2848);
        GL11.glLineWidth((float)2.0f);
        RenderManager lIllllIlIIIlll = Minecraft.getMinecraft().getRenderManager();
        double lIllllIlIIIllI = lIllllIlIlIIlI ? 0.005 : (lIllllIlIlIIll instanceof ItemPotion ? 0.04 : (lIllllIlIlIIll instanceof ItemFishingRod ? 0.015 : 0.003));
        Vec3d lIllllIlIIIlIl = new Vec3d(lIllllIlIlIlIl.field_70165_t, lIllllIlIlIlIl.field_70163_u + (double)lIllllIlIlIlIl.getEyeHeight(), lIllllIlIlIlIl.field_70161_v);
        boolean lIllllIlIIIlII = false;
        boolean lIllllIlIIIIll = lIllllIlIlIlll.predictHit(lIllllIlIIIlIl, new Vec3d(lIllllIlIlIIIl, lIllllIlIlIIII, lIllllIlIIllll), new Vec3d(lIllllIlIIlIll, lIllllIlIIlIlI, lIllllIlIIlIIl), lIllllIlIIIllI);
        if (lIllllIlIIIIll) {
            GL11.glColor4f((float)0.9f, (float)0.2f, (float)0.1f, (float)0.5f);
        } else {
            GL11.glColor4f((float)0.0f, (float)0.9f, (float)0.8f, (float)0.5f);
        }
        GL11.glBegin((int)3);
        for (int lIllllIlIllIII = 0; lIllllIlIllIII < 1000; ++lIllllIlIllIII) {
            Block lIllllIlIllIIl;
            if (Minecraft.getMinecraft().world.func_72933_a(lIllllIlIIIlIl, new Vec3d(lIllllIlIlIIIl, lIllllIlIlIIII, lIllllIlIIllll)) != null) {
                if (lIllllIlIIIIll) {
                    GL11.glColor4f((float)0.3f, (float)0.1f, (float)0.1f, (float)0.5f);
                } else {
                    GL11.glColor4f((float)0.1f, (float)0.3f, (float)0.3f, (float)0.5f);
                }
            } else if (lIllllIlIIIIll) {
                GL11.glColor4f((float)0.9f, (float)0.2f, (float)0.1f, (float)0.5f);
            } else {
                GL11.glColor4f((float)0.0f, (float)0.9f, (float)0.8f, (float)0.5f);
            }
            GL11.glVertex3d((double)(lIllllIlIlIIIl - lIllllIlIIIlll.viewerPosX), (double)(lIllllIlIlIIII - lIllllIlIIIlll.viewerPosY), (double)(lIllllIlIIllll - lIllllIlIIIlll.viewerPosZ));
            lIllllIlIlIIIl += lIllllIlIIlIll * 0.1;
            lIllllIlIlIIII += lIllllIlIIlIlI * 0.1;
            lIllllIlIIllll += lIllllIlIIlIIl * 0.1;
            lIllllIlIIlIll *= 0.999;
            lIllllIlIIlIlI *= 0.999;
            lIllllIlIIlIIl *= 0.999;
            lIllllIlIIlIlI -= lIllllIlIIIllI;
            for (Entity lIllllIlIllIll : Minecraft.getMinecraft().world.field_72996_f) {
                if (!(lIllllIlIllIll instanceof EntityLiving) || !lIllllIlIllIll.getEntityBoundingBox().grow(0.35, 0.35, 0.35).contains(new Vec3d(lIllllIlIlIIIl, lIllllIlIlIIII, lIllllIlIIllll))) continue;
                lIllllIlIIIlII = true;
                break;
            }
            if (lIllllIlIIIlII) break;
            for (EntityPlayer lIllllIlIllIlI : Minecraft.getMinecraft().world.field_73010_i) {
                if (lIllllIlIllIlI == Minecraft.getMinecraft().player || !lIllllIlIllIlI.func_174813_aQ().grow(0.35, 0.35, 0.35).contains(new Vec3d(lIllllIlIlIIIl, lIllllIlIlIIII, lIllllIlIIllll))) continue;
                lIllllIlIIIlII = true;
                break;
            }
            if (lIllllIlIIIlII || TrajectoriesMod.isCollidable(lIllllIlIllIIl = Minecraft.getMinecraft().world.func_180495_p(new BlockPos(new Vec3d(lIllllIlIlIIIl, lIllllIlIlIIII, lIllllIlIIllll))).getBlock())) break;
        }
        GL11.glEnd();
        GL11.glPushMatrix();
        GL11.glTranslated((double)(lIllllIlIlIIIl - lIllllIlIIIlll.viewerPosX), (double)(lIllllIlIlIIII - lIllllIlIIIlll.viewerPosY), (double)(lIllllIlIIllll - lIllllIlIIIlll.viewerPosZ));
        GL11.glCallList((int)lIllllIlIlIlll.BOX);
        GL11.glPopMatrix();
        GL11.glPopAttrib();
    }

    @Override
    public void onEnable() {
        TrajectoriesMod lIllllIlllIlll;
        super.onEnable();
        lIllllIlllIlll.BOX = GL11.glGenLists((int)1);
        GL11.glNewList((int)lIllllIlllIlll.BOX, (int)4864);
        TrajectoriesMod.drawSolidBox(new AxisAlignedBB(-0.5, -0.5, -0.5, 0.5, 0.5, 0.5));
        GL11.glEndList();
    }
}

