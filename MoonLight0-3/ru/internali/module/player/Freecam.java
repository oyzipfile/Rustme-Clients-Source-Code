/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityOtherPlayerMP
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.util.MovementInput
 *  net.minecraft.util.MovementInputFromOptions
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 *  net.minecraftforge.client.event.InputUpdateEvent
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package ru.internali.module.player;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.MovementInput;
import net.minecraft.util.MovementInputFromOptions;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;
import ru.internali.utils.SendPacketEvent;

public class Freecam
extends Module {
    private /* synthetic */ int lastThirdPerson;
    private final /* synthetic */ Minecraft mc;
    public static final /* synthetic */ Freecam INSTANCE;
    private /* synthetic */ boolean activeThisSession;
    public /* synthetic */ EntityOtherPlayerMP camera;

    @Override
    public void onEnable() {
        Freecam llIIIllIIllllIl;
        super.onEnable();
        MinecraftForge.EVENT_BUS.register((Object)llIIIllIIllllIl);
        llIIIllIIllllIl.activeThisSession = true;
        llIIIllIIllllIl.mc.renderGlobal.loadRenderers();
    }

    @SubscribeEvent
    public void onInput(InputUpdateEvent llIIIllIIlIlIll) {
        Freecam llIIIllIIlIllII;
        float llIIIllIIlIlIlI = (float)CatClient.instance.settingsManager.getSettingByName(llIIIllIIlIllII, "horizontalSpeed").getValDouble();
        float llIIIllIIlIlIIl = (float)CatClient.instance.settingsManager.getSettingByName(llIIIllIIlIllII, "verticalSpeed").getValDouble();
        if (llIIIllIIlIllII.camera == null) {
            return;
        }
        MovementInput llIIIllIIlIlIII = llIIIllIIlIlIll.getMovementInput();
        float llIIIllIIlIIlll = (llIIIllIIlIlIII.forwardKeyDown ? llIIIllIIlIlIlI : 0.0f) - (llIIIllIIlIlIII.backKeyDown ? llIIIllIIlIlIlI : 0.0f);
        float llIIIllIIlIIllI = (llIIIllIIlIlIII.leftKeyDown ? llIIIllIIlIlIlI : 0.0f) - (llIIIllIIlIlIII.rightKeyDown ? llIIIllIIlIlIlI : 0.0f);
        float llIIIllIIlIIlIl = (llIIIllIIlIlIII.jump ? llIIIllIIlIlIIl : 0.0f) - (llIIIllIIlIlIII.sneak ? llIIIllIIlIlIIl : 0.0f);
        Vec3d llIIIllIIlIIlII = new Vec3d((double)llIIIllIIlIIllI, (double)llIIIllIIlIIlIl, (double)llIIIllIIlIIlll).rotateYaw((float)(-Math.toRadians(llIIIllIIlIllII.camera.field_70177_z)));
        llIIIllIIlIllII.camera.setPositionAndRotationDirect(llIIIllIIlIllII.camera.field_70165_t + llIIIllIIlIIlII.x, llIIIllIIlIllII.camera.field_70163_u + llIIIllIIlIIlII.y, llIIIllIIlIllII.camera.field_70161_v + llIIIllIIlIIlII.z, llIIIllIIlIllII.camera.field_70177_z, llIIIllIIlIllII.camera.field_70125_A, 3, false);
        if (llIIIllIIlIlIII instanceof MovementInputFromOptions) {
            llIIIllIIlIllII.mc.player.field_70701_bs = 0.0f;
            llIIIllIIlIllII.mc.player.field_70702_br = 0.0f;
            llIIIllIIlIllII.mc.player.field_191988_bg = 0.0f;
            llIIIllIIlIllII.mc.player.func_70637_d(false);
        }
    }

    static {
        INSTANCE = new Freecam();
    }

    public Freecam() {
        super("Freecam", "Freecam", Category.PLAYER);
        Freecam llIIIllIlIIIIIl;
        llIIIllIlIIIIIl.mc = Minecraft.getMinecraft();
        llIIIllIlIIIIIl.activeThisSession = false;
        CatClient.instance.settingsManager.rSetting(new Setting("verticalspeed", llIIIllIlIIIIIl, 3.5, 1.0, 12.0, false));
        CatClient.instance.settingsManager.rSetting(new Setting("horizontalspeed", llIIIllIlIIIIIl, 3.5, 1.0, 12.0, false));
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent llIIIllIIllIlll) {
        Freecam llIIIllIIllIllI;
        if (llIIIllIIllIllI.mc.world == null || !llIIIllIIllIllI.mc.world.field_72995_K) {
            llIIIllIIllIllI.camera = null;
            return;
        }
        if (llIIIllIIllIllI.camera == null) {
            llIIIllIIllIllI.lastThirdPerson = llIIIllIIllIllI.mc.gameSettings.thirdPersonView;
            llIIIllIIllIllI.camera = new EntityOtherPlayerMP((World)llIIIllIIllIllI.mc.world, llIIIllIIllIllI.mc.getSession().getProfile());
            llIIIllIIllIllI.mc.world.addEntityToWorld(333393333, (Entity)llIIIllIIllIllI.camera);
            llIIIllIIllIllI.camera.func_82149_j((Entity)llIIIllIIllIllI.mc.player);
            llIIIllIIllIllI.mc.setRenderViewEntity((Entity)llIIIllIIllIllI.camera);
            llIIIllIIllIllI.camera.field_70145_X = true;
        }
        llIIIllIIllIllI.mc.gameSettings.thirdPersonView = 0;
        llIIIllIIllIllI.camera.field_71071_by = llIIIllIIllIllI.mc.player.field_71071_by;
        llIIIllIIllIllI.camera.func_70606_j(llIIIllIIllIllI.mc.player.func_110143_aJ());
    }

    @Override
    public void onDisable() {
        Freecam llIIIllIIlllIll;
        super.onDisable();
        MinecraftForge.EVENT_BUS.unregister((Object)llIIIllIIlllIll);
        if (llIIIllIIlllIll.mc.world != null && llIIIllIIlllIll.mc.world.field_72995_K) {
            llIIIllIIlllIll.mc.setRenderViewEntity((Entity)llIIIllIIlllIll.mc.player);
            if (llIIIllIIlllIll.activeThisSession) {
                llIIIllIIlllIll.mc.gameSettings.thirdPersonView = llIIIllIIlllIll.lastThirdPerson;
                llIIIllIIlllIll.mc.world.removeEntity((Entity)llIIIllIIlllIll.camera);
            }
        }
        llIIIllIIlllIll.camera = null;
        llIIIllIIlllIll.activeThisSession = false;
    }

    @SubscribeEvent
    public void onSendPacket(SendPacketEvent llIIIllIIIlIlIl) {
        Freecam llIIIllIIIlIlII;
        CPacketUseEntity llIIIllIIIlIlll;
        if (llIIIllIIIlIlIl.getPacket() instanceof CPacketUseEntity && (llIIIllIIIlIlll = (CPacketUseEntity)llIIIllIIIlIlIl.getPacket()).getEntityFromWorld((World)llIIIllIIIlIlII.mc.world) == llIIIllIIIlIlII.mc.player) {
            llIIIllIIIlIlIl.setCanceled(true);
        }
    }
}

