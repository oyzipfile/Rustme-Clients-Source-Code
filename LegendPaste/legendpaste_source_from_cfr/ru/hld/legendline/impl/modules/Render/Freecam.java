/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityOtherPlayerMP
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.MovementInput
 *  net.minecraft.world.GameType
 *  net.minecraft.world.World
 */
package ru.hld.legendline.impl.modules.Render;

import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.util.MovementInput;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import ru.hld.legendline.api.event.EventTarget;
import ru.hld.legendline.api.event.events.EventUpdate;
import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.module.Module;

public class Freecam
extends Module {
    private /* synthetic */ EntityOtherPlayerMP entity;
    private /* synthetic */ GameType prevGameType;

    @Override
    public void onDisable() {
        Freecam llllllllllllllIIIlllIlIIlIIIIIIl;
        super.onDisable();
        llllllllllllllIIIlllIlIIlIIIIIIl.mc.player.posX = llllllllllllllIIIlllIlIIlIIIIIIl.entity.posX;
        llllllllllllllIIIlllIlIIlIIIIIIl.mc.player.posY = llllllllllllllIIIlllIlIIlIIIIIIl.entity.posY;
        llllllllllllllIIIlllIlIIlIIIIIIl.mc.player.posZ = llllllllllllllIIIlllIlIIlIIIIIIl.entity.posZ;
        llllllllllllllIIIlllIlIIlIIIIIIl.mc.player.rotationYaw = llllllllllllllIIIlllIlIIlIIIIIIl.entity.rotationYaw;
        llllllllllllllIIIlllIlIIlIIIIIIl.mc.player.rotationPitch = llllllllllllllIIIlllIlIIlIIIIIIl.entity.rotationPitch;
        llllllllllllllIIIlllIlIIlIIIIIIl.mc.world.removeEntity((Entity)llllllllllllllIIIlllIlIIlIIIIIIl.entity);
        llllllllllllllIIIlllIlIIlIIIIIIl.mc.playerController.setGameType(llllllllllllllIIIlllIlIIlIIIIIIl.prevGameType);
    }

    @EventTarget
    public void onUpdate(EventUpdate llllllllllllllIIIlllIlIIIlllIlII) {
        Freecam llllllllllllllIIIlllIlIIIllllIlI;
        llllllllllllllIIIlllIlIIIlllIlII.setPosX(llllllllllllllIIIlllIlIIIllllIlI.entity.posX);
        llllllllllllllIIIlllIlIIIlllIlII.setPosY(llllllllllllllIIIlllIlIIIllllIlI.entity.posY);
        llllllllllllllIIIlllIlIIIlllIlII.setPosZ(llllllllllllllIIIlllIlIIIllllIlI.entity.posZ);
        llllllllllllllIIIlllIlIIIlllIlII.setRotationYaw(llllllllllllllIIIlllIlIIIllllIlI.entity.rotationYaw);
        llllllllllllllIIIlllIlIIIlllIlII.setRotationPitch(llllllllllllllIIIlllIlIIIllllIlI.entity.rotationPitch);
        llllllllllllllIIIlllIlIIIlllIlII.setOnGround(true);
        double llllllllllllllIIIlllIlIIIllllIII = MovementInput.field_192832_b;
        double llllllllllllllIIIlllIlIIIlllIlll = MovementInput.moveStrafe;
        float llllllllllllllIIIlllIlIIIlllIllI = llllllllllllllIIIlllIlIIIllllIlI.mc.player.rotationYaw;
        if (llllllllllllllIIIlllIlIIIllllIII == 0.0 && llllllllllllllIIIlllIlIIIlllIlll == 0.0) {
            llllllllllllllIIIlllIlIIIllllIlI.mc.player.motionX = 0.0;
            llllllllllllllIIIlllIlIIIllllIlI.mc.player.motionZ = 0.0;
        } else {
            if (llllllllllllllIIIlllIlIIIllllIII != 0.0) {
                if (llllllllllllllIIIlllIlIIIlllIlll > 0.0) {
                    llllllllllllllIIIlllIlIIIlllIllI += (float)(llllllllllllllIIIlllIlIIIllllIII > 0.0 ? -45 : 45);
                } else if (llllllllllllllIIIlllIlIIIlllIlll < 0.0) {
                    llllllllllllllIIIlllIlIIIlllIllI += (float)(llllllllllllllIIIlllIlIIIllllIII > 0.0 ? 45 : -45);
                }
                llllllllllllllIIIlllIlIIIlllIlll = 0.0;
                if (llllllllllllllIIIlllIlIIIllllIII > 0.0) {
                    llllllllllllllIIIlllIlIIIllllIII = 1.0;
                } else if (llllllllllllllIIIlllIlIIIllllIII < 0.0) {
                    llllllllllllllIIIlllIlIIIllllIII = -1.0;
                }
            }
            llllllllllllllIIIlllIlIIIllllIlI.mc.player.setPosition(llllllllllllllIIIlllIlIIIllllIlI.mc.player.posX + llllllllllllllIIIlllIlIIIllllIII * 0.5 * Math.cos(Math.toRadians(llllllllllllllIIIlllIlIIIlllIllI + 90.0f)) + llllllllllllllIIIlllIlIIIlllIlll * 0.5 * Math.sin(Math.toRadians(llllllllllllllIIIlllIlIIIlllIllI + 90.0f)), llllllllllllllIIIlllIlIIIllllIlI.mc.gameSettings.keyBindJump.isKeyDown() ? llllllllllllllIIIlllIlIIIllllIlI.mc.player.posY + 0.5 : (llllllllllllllIIIlllIlIIIllllIlI.mc.player.isSneaking() ? llllllllllllllIIIlllIlIIIllllIlI.mc.player.posY - 0.5 : llllllllllllllIIIlllIlIIIllllIlI.mc.player.posY), llllllllllllllIIIlllIlIIIllllIlI.mc.player.posZ + (llllllllllllllIIIlllIlIIIllllIII * 0.5 * Math.sin(Math.toRadians(llllllllllllllIIIlllIlIIIlllIllI + 90.0f)) - llllllllllllllIIIlllIlIIIlllIlll * 0.5 * Math.cos(Math.toRadians(llllllllllllllIIIlllIlIIIlllIllI + 90.0f))));
        }
    }

    @Override
    public void onEnable() {
        Freecam llllllllllllllIIIlllIlIIlIIIIlIl;
        super.onEnable();
        try {
            llllllllllllllIIIlllIlIIlIIIIlIl.entity = new EntityOtherPlayerMP((World)llllllllllllllIIIlllIlIIlIIIIlIl.mc.world, llllllllllllllIIIlllIlIIlIIIIlIl.mc.player.getGameProfile());
            llllllllllllllIIIlllIlIIlIIIIlIl.entity.posX = llllllllllllllIIIlllIlIIlIIIIlIl.mc.player.posX;
            llllllllllllllIIIlllIlIIlIIIIlIl.entity.posY = llllllllllllllIIIlllIlIIlIIIIlIl.mc.player.posY;
            llllllllllllllIIIlllIlIIlIIIIlIl.entity.posZ = llllllllllllllIIIlllIlIIlIIIIlIl.mc.player.posZ;
            llllllllllllllIIIlllIlIIlIIIIlIl.entity.rotationYaw = llllllllllllllIIIlllIlIIlIIIIlIl.mc.player.rotationYaw;
            llllllllllllllIIIlllIlIIlIIIIlIl.entity.rotationPitch = llllllllllllllIIIlllIlIIlIIIIlIl.mc.player.rotationPitch;
            llllllllllllllIIIlllIlIIlIIIIlIl.mc.world.addEntityToWorld(-1, (Entity)llllllllllllllIIIlllIlIIlIIIIlIl.entity);
            llllllllllllllIIIlllIlIIlIIIIlIl.prevGameType = llllllllllllllIIIlllIlIIlIIIIlIl.mc.playerController.getCurrentGameType();
            llllllllllllllIIIlllIlIIlIIIIlIl.mc.playerController.setGameType(GameType.SPECTATOR);
        }
        catch (NullPointerException llllllllllllllIIIlllIlIIlIIIIIll) {
            // empty catch block
        }
    }

    public Freecam() {
        super("FreeCam", "allow your fly like in gamemode 3", Category.Render);
        Freecam llllllllllllllIIIlllIlIIlIIIlIIl;
    }
}

