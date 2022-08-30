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
 *  net.minecraftforge.client.event.ClientChatEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package ru.internali.module.HUD;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.utils.fov.UtilsForFov;
import ru.internali.utils.friend.FriendManager;

public class Command
extends Module {
    public static /* synthetic */ List<String> Modes;

    static {
        Modes = new ArrayList<String>();
    }

    @SubscribeEvent
    public void FriendModule(ClientChatEvent lIIllIlIlIIIll) {
        Entity lIIllIlIlIIlIl;
        RayTraceResult lIIllIlIlIIIlI = Minecraft.getMinecraft().objectMouseOver;
        if (lIIllIlIlIIIlI == null) {
            return;
        }
        if (lIIllIlIlIIIlI.typeOfHit == RayTraceResult.Type.ENTITY && (lIIllIlIlIIlIl = lIIllIlIlIIIlI.entityHit) instanceof EntityPlayer && !(lIIllIlIlIIlIl instanceof EntityArmorStand) && !Minecraft.getMinecraft().player.field_70128_L && Minecraft.getMinecraft().player.func_70685_l(lIIllIlIlIIlIl)) {
            EntityPlayer lIIllIlIlIlIII = (EntityPlayer)lIIllIlIlIIlIl;
            String lIIllIlIlIIlll = UtilsForFov.getPlayerName(lIIllIlIlIlIII);
            String lIIllIlIlIIllI = lIIllIlIlIIIll.getMessage();
            if (Objects.equals(lIIllIlIlIIllI, String.valueOf(new StringBuilder().append(".Friend add").append(lIIllIlIlIIlll)))) {
                FriendManager.addFriend(lIIllIlIlIIlll);
            } else if (Objects.equals(lIIllIlIlIIllI, String.valueOf(new StringBuilder().append(".Friend remove").append(lIIllIlIlIIlll)))) {
                FriendManager.removeFriend(lIIllIlIlIIlll);
            }
        }
    }

    public Command() {
        super("Command", "Command", Category.HUD);
        Command lIIllIlIlIllll;
    }
}

