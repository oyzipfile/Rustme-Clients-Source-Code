/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.monster.EntityGolem
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.passive.EntityAnimal
 *  net.minecraft.entity.passive.EntitySquid
 *  net.minecraft.entity.passive.EntityVillager
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.MathHelper
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$ElementType
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$Text
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.opengl.GL11
 */
package ru.internali.module.HUD;

import java.awt.Color;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.module.combat.AntiBot;
import ru.internali.settings.Setting;
import ru.internali.utils.MathUtils;
import ru.internali.utils.RenderUtils;
import ru.internali.utils.RotationUtils;

public class Radar
extends Module {
    /* synthetic */ float partialTicks;

    public float getTicks() {
        Radar llllIlIIIlIIl;
        return llllIlIIIlIIl.partialTicks;
    }

    public double[] getLookVector(float llllIIlIlIlll) {
        return new double[]{-MathHelper.sin((float)(llllIIlIlIlll *= (float)Math.PI / 180)), MathHelper.cos((float)llllIIlIlIlll)};
    }

    public Radar() {
        super("Radar", "Radar", Category.HUD);
        Radar llllIlIIIllII;
        CatClient.instance.settingsManager.rSetting(new Setting("x", llllIlIIIllII, 2.0, 0.0, 897.0, true));
        CatClient.instance.settingsManager.rSetting(new Setting("y", llllIlIIIllII, 27.0, 0.0, 340.0, true));
        CatClient.instance.settingsManager.rSetting(new Setting("size", llllIlIIIllII, 70.0, 25.0, 200.0, true));
        CatClient.instance.settingsManager.rSetting(new Setting("players", llllIlIIIllII, false));
        CatClient.instance.settingsManager.rSetting(new Setting("monsters", llllIlIIIllII, false));
        CatClient.instance.settingsManager.rSetting(new Setting("animals", llllIlIIIllII, false));
        CatClient.instance.settingsManager.rSetting(new Setting("passives", llllIlIIIllII, false));
        CatClient.instance.settingsManager.rSetting(new Setting("invisibles", llllIlIIIllII, false));
        CatClient.instance.settingsManager.rSetting(new Setting("items", llllIlIIIllII, false));
    }

    private boolean qualifies(Entity llllIIlIIllII) {
        Radar llllIIlIIllIl;
        boolean llllIIlIIlIll = CatClient.instance.settingsManager.getSettingByName(llllIIlIIllIl, "players").getValBoolean();
        boolean llllIIlIIlIlI = CatClient.instance.settingsManager.getSettingByName(llllIIlIIllIl, "monsters").getValBoolean();
        boolean llllIIlIIlIIl = CatClient.instance.settingsManager.getSettingByName(llllIIlIIllIl, "items").getValBoolean();
        boolean llllIIlIIlIII = CatClient.instance.settingsManager.getSettingByName(llllIIlIIllIl, "invisibles").getValBoolean();
        boolean llllIIlIIIlll = CatClient.instance.settingsManager.getSettingByName(llllIIlIIllIl, "animals").getValBoolean();
        boolean llllIIlIIIllI = CatClient.instance.settingsManager.getSettingByName(llllIIlIIllIl, "passives").getValBoolean();
        return (llllIIlIIllII instanceof EntityPlayer && llllIIlIIlIll && !AntiBot.isBot(String.valueOf((Object)((EntityPlayer)llllIIlIIllII))) || llllIIlIIllII instanceof EntityMob && llllIIlIIlIlI || (llllIIlIIllII instanceof EntityAnimal || llllIIlIIllII instanceof EntitySquid) && llllIIlIIIlll || (llllIIlIIllII instanceof EntityVillager || llllIIlIIllII instanceof EntityGolem) && llllIIlIIIllI || llllIIlIIllII instanceof EntityItem && llllIIlIIlIIl) && (!llllIIlIIllII.isInvisible() || llllIIlIIlIII) && llllIIlIIllII != Radar.mc.player;
    }

    @SubscribeEvent
    public void onOverlayRender(RenderGameOverlayEvent.Text llllIIllIlIII) {
        Radar llllIIllIlIIl;
        float llllIIllIllII = (float)CatClient.instance.settingsManager.getSettingByName(llllIIllIlIIl, "x").getValDouble();
        float llllIIllIlIll = (float)CatClient.instance.settingsManager.getSettingByName(llllIIllIlIIl, "y").getValDouble();
        float llllIIllIlIlI = (float)CatClient.instance.settingsManager.getSettingByName(llllIIllIlIIl, "size").getValDouble();
        if (llllIIllIlIII.getType() == RenderGameOverlayEvent.ElementType.TEXT && !Radar.mc.gameSettings.showDebugInfo) {
            GL11.glPushMatrix();
            int llllIIlllIIll = (int)llllIIllIlIlI;
            int llllIIlllIIlI = (int)llllIIllIlIlI;
            float llllIIlllIIIl = llllIIllIllII + (float)llllIIlllIIll / 2.0f;
            float llllIIlllIIII = llllIIllIlIll + (float)llllIIlllIIlI / 2.0f;
            RenderUtils.drawBorderedRect(llllIIllIllII, llllIIllIlIll, llllIIllIllII + (float)llllIIlllIIll, llllIIllIlIll + (float)llllIIlllIIlI, 1.0f, -12303292, -14540254);
            RenderUtils.drawRectSized(llllIIllIllII + (float)llllIIlllIIll / 2.0f - 0.5f, llllIIllIlIll, 1.0f, llllIIlllIIlI, -12303292);
            RenderUtils.drawRectSized(llllIIllIllII, llllIIllIlIll + (float)llllIIlllIIlI / 2.0f - 0.5f, llllIIlllIIll, 1.0f, -12303292);
            RenderUtils.drawRectSized(llllIIlllIIIl - 1.0f, llllIIlllIIII - 1.0f, 2.0f, 2.0f, -256);
            int llllIIllIllll = (int)(llllIIllIlIlI / 2.0f);
            for (Entity llllIIlllIlII : Radar.mc.world.field_72996_f) {
                double llllIIlllIlIl;
                double llllIIlllIllI;
                if (!llllIIllIlIIl.qualifies(llllIIlllIlII) || !((llllIIlllIllI = RenderUtils.lerp(llllIIlllIlII.prevPosX, llllIIlllIlII.posX, llllIIllIlIIl.getTicks()) - RenderUtils.lerp(Radar.mc.player.field_70169_q, Radar.mc.player.field_70165_t, llllIIllIlIIl.getTicks())) * llllIIlllIllI + (llllIIlllIlIl = RenderUtils.lerp(llllIIlllIlII.prevPosZ, llllIIlllIlII.posZ, llllIIllIlIIl.getTicks()) - RenderUtils.lerp(Radar.mc.player.field_70166_s, Radar.mc.player.field_70161_v, llllIIllIlIIl.getTicks())) * llllIIlllIlIl <= (double)(llllIIllIllll * llllIIllIllll))) continue;
                float llllIIllllIII = MathUtils.sqrt_double(llllIIlllIllI * llllIIlllIllI + llllIIlllIlIl * llllIIlllIlIl);
                double[] llllIIlllIlll = llllIIllIlIIl.getLookVector(RotationUtils.getRotations(llllIIlllIlII)[0] - (float)RenderUtils.lerp(Radar.mc.player.field_70758_at, Radar.mc.player.field_70759_as, llllIIllIlIIl.getTicks()));
                if (llllIIlllIlII instanceof EntityMob) {
                    RenderUtils.drawRectSized(llllIIlllIIIl - 1.0f - (float)llllIIlllIlll[0] * llllIIllllIII, llllIIlllIIII - 1.0f - (float)llllIIlllIlll[1] * llllIIllllIII, 2.0f, 2.0f, new Color(0, 252, 103).getRGB());
                    continue;
                }
                if (llllIIlllIlII instanceof EntityPlayer) {
                    RenderUtils.drawRectSized(llllIIlllIIIl - 1.0f - (float)llllIIlllIlll[0] * llllIIllllIII, llllIIlllIIII - 1.0f - (float)llllIIlllIlll[1] * llllIIllllIII, 2.0f, 2.0f, new Color(248, 0, 0).getRGB());
                    continue;
                }
                if (llllIIlllIlII instanceof EntityAnimal || llllIIlllIlII instanceof EntitySquid || llllIIlllIlII instanceof EntityVillager || llllIIlllIlII instanceof EntityGolem) {
                    RenderUtils.drawRectSized(llllIIlllIIIl - 1.0f - (float)llllIIlllIlll[0] * llllIIllllIII, llllIIlllIIII - 1.0f - (float)llllIIlllIlll[1] * llllIIllllIII, 2.0f, 2.0f, new Color(248, 178, 0).getRGB());
                    continue;
                }
                if (!(llllIIlllIlII instanceof EntityItem)) continue;
                RenderUtils.drawRectSized(llllIIlllIIIl - 1.0f - (float)llllIIlllIlll[0] * llllIIllllIII, llllIIlllIIII - 1.0f - (float)llllIIlllIlll[1] * llllIIllllIII, 2.0f, 2.0f, new Color(0, 147, 241).getRGB());
            }
        }
        GL11.glPopMatrix();
    }
}

