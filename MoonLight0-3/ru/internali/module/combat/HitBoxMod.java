/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraftforge.event.entity.living.LivingEvent$LivingUpdateEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package ru.internali.module.combat;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.module.combat.AntiBot;
import ru.internali.settings.Setting;
import ru.internali.utils.friend.FriendManager;

public class HitBoxMod
extends Module {
    public HitBox createHitBox(Entity llIIlllIllIlIlI) {
        return new HitBox(0.6f, 1.8f);
    }

    public void changeEntityHitBox(Entity llIIlllIllIIIII, float llIIlllIllIIIll, float llIIlllIllIIIlI) {
        llIIlllIllIIIII.width = llIIlllIllIIIll;
        llIIlllIllIIIII.height = llIIlllIllIIIlI;
        double llIIlllIllIIIIl = (double)llIIlllIllIIIll / 2.0;
        llIIlllIllIIIII.setEntityBoundingBox(new AxisAlignedBB(llIIlllIllIIIII.posX - llIIlllIllIIIIl, llIIlllIllIIIII.posY, llIIlllIllIIIII.posZ - llIIlllIllIIIIl, llIIlllIllIIIII.posX + llIIlllIllIIIIl, llIIlllIllIIIII.posY + (double)llIIlllIllIIIII.height, llIIlllIllIIIIl + llIIlllIllIIIII.posZ));
    }

    @SubscribeEvent
    public void onLivingUpdate(LivingEvent.LivingUpdateEvent llIIlllIlIlIIlI) {
        HitBoxMod llIIlllIlIlIIll;
        float llIIlllIlIlIIIl = (float)CatClient.instance.settingsManager.getSettingByName(llIIlllIlIlIIll, "Horizontal").getValDouble();
        float llIIlllIlIlIIII = (float)CatClient.instance.settingsManager.getSettingByName(llIIlllIlIlIIll, "Vertical").getValDouble();
        if (Minecraft.getMinecraft().player != null && Minecraft.getMinecraft().world != null) {
            for (Entity llIIlllIlIlIlIl : Minecraft.getMinecraft().world.field_72996_f) {
                if (llIIlllIlIlIlIl == null || llIIlllIlIlIlIl == Minecraft.getMinecraft().player || !(llIIlllIlIlIlIl instanceof EntityPlayer) || AntiBot.isBot(llIIlllIlIlIlIl.getName()) || FriendManager.isFriend(llIIlllIlIlIlIl.getName())) continue;
                HitBox llIIlllIlIlIllI = llIIlllIlIlIIll.createHitBox(llIIlllIlIlIlIl);
                llIIlllIlIlIIll.changeEntityHitBox(llIIlllIlIlIlIl, llIIlllIlIlIllI.width + llIIlllIlIlIIIl, llIIlllIlIlIllI.height + llIIlllIlIlIIII);
            }
        }
    }

    public HitBoxMod() {
        super("HitBoxMod", "big hitbox", Category.COMBAT);
        HitBoxMod llIIlllIllIllIl;
        CatClient.instance.settingsManager.rSetting(new Setting("Horizontal", llIIlllIllIllIl, 0.1, 0.0, 3.0, false));
        CatClient.instance.settingsManager.rSetting(new Setting("Vertical", llIIlllIllIllIl, 0.1, 0.0, 3.0, false));
    }

    private static class HitBox {
        public /* synthetic */ float width;
        public /* synthetic */ float height;

        public HitBox(float lllIlIIIIIlIlll, float lllIlIIIIIllIIl) {
            HitBox lllIlIIIIIllIll;
            lllIlIIIIIllIll.width = lllIlIIIIIlIlll;
            lllIlIIIIIllIll.height = lllIlIIIIIllIIl;
        }
    }
}

