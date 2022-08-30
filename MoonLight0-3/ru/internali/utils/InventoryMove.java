/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiChat
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.util.math.MathHelper
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 *  org.lwjgl.input.Keyboard
 */
package ru.internali.utils;

import java.lang.reflect.Field;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.utils.TimerUtil;

public class InventoryMove
extends Module {
    /* synthetic */ TimerUtil timerUtil;

    public static float getDirection() {
        float lIIlIIIlIlIIIIl = InventoryMove.mc.player.field_70177_z;
        if (InventoryMove.mc.player.field_191988_bg < 0.0f) {
            lIIlIIIlIlIIIIl += 180.0f;
        }
        float lIIlIIIlIlIIIII = 1.0f;
        if (InventoryMove.mc.player.field_191988_bg < 0.0f) {
            lIIlIIIlIlIIIII = -0.5f;
        } else if (InventoryMove.mc.player.field_191988_bg > 0.0f) {
            lIIlIIIlIlIIIII = 0.5f;
        }
        if (InventoryMove.mc.player.field_70702_br > 0.0f) {
            lIIlIIIlIlIIIIl -= 90.0f * lIIlIIIlIlIIIII;
        }
        if (InventoryMove.mc.player.field_70702_br < 0.0f) {
            lIIlIIIlIlIIIIl += 90.0f * lIIlIIIlIlIIIII;
        }
        return lIIlIIIlIlIIIIl *= (float)Math.PI / 180;
    }

    void handleRight(double lIIlIIIIllIlIlI) {
        InventoryMove lIIlIIIIllIlIll;
        lIIlIIIIllIlIlI = 0.046;
        if (!Keyboard.isKeyDown((int)InventoryMove.mc.gameSettings.keyBindRight.getKeyCode())) {
            return;
        }
        lIIlIIIIllIlIll.moveRight(lIIlIIIIllIlIlI);
    }

    void moveLeft(double lIIlIIIlIIllIIl) {
        lIIlIIIlIIllIIl = 0.046;
        float lIIlIIIlIIllIII = InventoryMove.getDirection();
        InventoryMove.mc.player.field_70179_y += (double)MathHelper.sin((float)lIIlIIIlIIllIII) * lIIlIIIlIIllIIl;
        InventoryMove.mc.player.field_70159_w += (double)MathHelper.cos((float)lIIlIIIlIIllIII) * lIIlIIIlIIllIIl;
    }

    void moveBack(double lIIlIIIlIIIIIll) {
        lIIlIIIlIIIIIll = 0.046;
        float lIIlIIIlIIIIlII = InventoryMove.getDirection();
        InventoryMove.mc.player.field_70159_w += (double)MathHelper.sin((float)lIIlIIIlIIIIlII) * lIIlIIIlIIIIIll;
        InventoryMove.mc.player.field_70179_y -= (double)MathHelper.cos((float)lIIlIIIlIIIIlII) * lIIlIIIlIIIIIll;
    }

    void handleLeft(double lIIlIIIIllIIIlI) {
        InventoryMove lIIlIIIIllIIIll;
        lIIlIIIIllIIIlI = 0.046;
        if (!Keyboard.isKeyDown((int)InventoryMove.mc.gameSettings.keyBindLeft.getKeyCode())) {
            return;
        }
        lIIlIIIIllIIIll.moveLeft(lIIlIIIIllIIIlI);
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent lIIlIIIIlllIIIl) {
        InventoryMove lIIlIIIIllIllll;
        if (InventoryMove.mc.currentScreen == null || InventoryMove.mc.currentScreen instanceof GuiChat || InventoryMove.mc.player == null || InventoryMove.mc.world == null) {
            return;
        }
        lIIlIIIIllIllll.timerUtil.reset();
        double lIIlIIIIlllIIII = 0.046;
        if (!InventoryMove.mc.player.field_70122_E) {
            lIIlIIIIlllIIII /= 4.0;
        }
        lIIlIIIIllIllll.handleJump();
        lIIlIIIIllIllll.handleForward(lIIlIIIIlllIIII);
        if (!InventoryMove.mc.player.field_70122_E) {
            lIIlIIIIlllIIII /= 2.0;
        }
        lIIlIIIIllIllll.handleBack(lIIlIIIIlllIIII);
        lIIlIIIIllIllll.handleLeft(lIIlIIIIlllIIII);
        lIIlIIIIllIllll.handleRight(lIIlIIIIlllIIII);
    }

    void handleForward(double lIIlIIIlIIIlIll) {
        InventoryMove lIIlIIIlIIIllII;
        lIIlIIIlIIIlIll = 0.046;
        if (!Keyboard.isKeyDown((int)InventoryMove.mc.gameSettings.keyBindForward.getKeyCode())) {
            return;
        }
        lIIlIIIlIIIllII.moveForward(lIIlIIIlIIIlIll);
    }

    void handleJump() {
        if (InventoryMove.mc.player.field_70122_E && Keyboard.isKeyDown((int)InventoryMove.mc.gameSettings.keyBindJump.getKeyCode())) {
            InventoryMove.mc.player.func_70664_aZ();
        }
    }

    public static void setPressed(KeyBinding lIIlIIIIlllIllI, boolean lIIlIIIIlllIlll) {
        try {
            Field lIIlIIIIlllIlIl = lIIlIIIIlllIllI.getClass().getDeclaredField("pressed");
        }
        catch (NoSuchFieldException lIIlIIIIllllIIl) {
            throw new RuntimeException(lIIlIIIIllllIIl);
        }
    }

    void moveForward(double lIIlIIIIlIlllII) {
        lIIlIIIIlIlllII = 0.046;
        float lIIlIIIIlIlllIl = InventoryMove.getDirection();
        InventoryMove.mc.player.setSprinting(true);
        InventoryMove.mc.player.field_70159_w -= (double)MathHelper.sin((float)lIIlIIIIlIlllIl) * lIIlIIIIlIlllII;
        InventoryMove.mc.player.field_70179_y += (double)MathHelper.cos((float)lIIlIIIIlIlllIl) * lIIlIIIIlIlllII;
    }

    void moveRight(double lIIlIIIlIIlIIlI) {
        lIIlIIIlIIlIIlI = 0.046;
        float lIIlIIIlIIlIIIl = InventoryMove.getDirection();
        InventoryMove.mc.player.field_70179_y -= (double)MathHelper.sin((float)lIIlIIIlIIlIIIl) * lIIlIIIlIIlIIlI;
        InventoryMove.mc.player.field_70159_w -= (double)MathHelper.cos((float)lIIlIIIlIIlIIIl) * lIIlIIIlIIlIIlI;
    }

    void handleBack(double lIIlIIIIllllllI) {
        InventoryMove lIIlIIIIlllllIl;
        lIIlIIIIllllllI = 0.046;
        if (!Keyboard.isKeyDown((int)InventoryMove.mc.gameSettings.keyBindBack.getKeyCode())) {
            return;
        }
        lIIlIIIIlllllIl.moveBack(lIIlIIIIllllllI);
    }

    public InventoryMove(String lIIlIIIlIlIlIlI, String lIIlIIIlIlIlIIl, Category lIIlIIIlIlIlIII) {
        super(lIIlIIIlIlIlIlI, lIIlIIIlIlIlIIl, lIIlIIIlIlIlIII);
        InventoryMove lIIlIIIlIlIIlll;
        lIIlIIIlIlIIlll.timerUtil = new TimerUtil();
    }
}

