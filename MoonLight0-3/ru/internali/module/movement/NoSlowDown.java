/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.potion.Potion
 *  net.minecraft.util.MovementInput
 *  net.minecraftforge.client.event.InputUpdateEvent
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package ru.internali.module.movement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.MovementInput;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;
import ru.internali.utils.MoveUtils;

public class NoSlowDown
extends Module {
    public static /* synthetic */ List<String> Modes;

    @Override
    public void onEnable() {
        NoSlowDown lIIlIIIIIllllI;
        super.onEnable();
        MinecraftForge.EVENT_BUS.register((Object)lIIlIIIIIllllI);
    }

    @SubscribeEvent
    public void onInput(InputUpdateEvent lIIlIIIIIIllll) {
        NoSlowDown lIIlIIIIIIllII;
        boolean lIIlIIIIIIlllI = CatClient.instance.settingsManager.getSettingByName(lIIlIIIIIIllII, "Item").getValBoolean();
        boolean lIIlIIIIIIllIl = CatClient.instance.settingsManager.getSettingByName(lIIlIIIIIIllII, "Sneak").getValBoolean();
        if (Minecraft.getMinecraft().world != null && Minecraft.getMinecraft().player != null) {
            if (lIIlIIIIIIlllI && Minecraft.getMinecraft().player.isHandActive() && !Minecraft.getMinecraft().player.func_184218_aH()) {
                MovementInput lIIlIIIIIlIIlI = Minecraft.getMinecraft().player.movementInput;
                lIIlIIIIIlIIlI.moveStrafe /= 0.2f;
                MovementInput lIIlIIIIIlIIIl = Minecraft.getMinecraft().player.movementInput;
                lIIlIIIIIlIIIl.moveForward /= 0.2f;
            }
            if (lIIlIIIIIIllIl && Minecraft.getMinecraft().player.isSneaking()) {
                Minecraft.getMinecraft().player.movementInput.moveStrafe /= 0.3f;
                Minecraft.getMinecraft().player.movementInput.moveForward /= 0.3f;
            }
        }
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent lIIlIIIIIllIII) {
        if (NoSlowDown.mc.player.func_70644_a(Objects.requireNonNull(Potion.getPotionById((int)2)))) {
            MoveUtils.setSpeed(0.23f);
        }
    }

    static {
        Modes = new ArrayList<String>();
    }

    public NoSlowDown() {
        super("NoSlowDown", "NoSlowDown", Category.MOVEMENT);
        NoSlowDown lIIlIIIIlIIIII;
        CatClient.instance.settingsManager.rSetting(new Setting("Item", lIIlIIIIlIIIII, false));
        CatClient.instance.settingsManager.rSetting(new Setting("Sneak", lIIlIIIIlIIIII, false));
    }

    @Override
    public void onDisable() {
        NoSlowDown lIIlIIIIIllIlI;
        super.onDisable();
        MinecraftForge.EVENT_BUS.unregister((Object)lIIlIIIIIllIlI);
    }
}

