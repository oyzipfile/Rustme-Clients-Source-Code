/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityArmorStand
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 *  org.lwjgl.input.Mouse
 */
package ru.internali.module.misc;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Mouse;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.utils.fov.UtilsForFov;
import ru.internali.utils.friend.FriendManager;

public class MCF
extends Module {
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent lIIIlIlIIllllII) {
        Entity lIIIlIlIIlllllI;
        RayTraceResult lIIIlIlIIlllIll = Minecraft.getMinecraft().objectMouseOver;
        if (lIIIlIlIIlllIll == null) {
            return;
        }
        if (lIIIlIlIIlllIll.typeOfHit == RayTraceResult.Type.ENTITY && (lIIIlIlIIlllllI = lIIIlIlIIlllIll.entityHit) instanceof EntityPlayer && !(lIIIlIlIIlllllI instanceof EntityArmorStand) && !Minecraft.getMinecraft().player.field_70128_L && Minecraft.getMinecraft().player.func_70685_l(lIIIlIlIIlllllI)) {
            EntityPlayer lIIIlIlIlIIIIII = (EntityPlayer)lIIIlIlIIlllllI;
            String lIIIlIlIIllllll = UtilsForFov.getPlayerName(lIIIlIlIlIIIIII);
            if (Mouse.isButtonDown((int)2) && Minecraft.getMinecraft().currentScreen == null) {
                FriendManager.addFriend(lIIIlIlIIllllll);
            } else if (Mouse.isButtonDown((int)1) && Minecraft.getMinecraft().currentScreen == null) {
                FriendManager.removeFriend(lIIIlIlIIllllll);
            }
        }
    }

    public MCF() {
        super("MCF", "MCF", Category.OUTHER);
        MCF lIIIlIlIlIIIllI;
    }

    @Override
    public void onEnable() {
        MCF lIIIlIlIIllIlII;
        super.onEnable();
    }
}

