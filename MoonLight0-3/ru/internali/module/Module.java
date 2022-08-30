/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.text.TextFormatting
 *  net.minecraftforge.client.event.EntityViewRenderEvent$CameraSetup
 *  net.minecraftforge.common.MinecraftForge
 */
package ru.internali.module;

import java.io.IOException;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.common.MinecraftForge;
import ru.internali.module.Category;
import ru.internali.module.misc.SelfDestruct;
import ru.internali.notifications.Type;
import ru.internali.notifications.notifications;
import ru.internali.settings.Setting;
import ru.internali.utils.BooleanSetting;
import ru.internali.utils.EventManager;
import ru.internali.utils.PlayerHook;

public abstract class Module {
    private /* synthetic */ int key;
    public final /* synthetic */ BooleanSetting drawOnHud;
    public /* synthetic */ boolean visible;
    private /* synthetic */ String name;
    /* synthetic */ float PosX;
    public /* synthetic */ boolean enable;
    private /* synthetic */ List<Setting> settings;
    protected static /* synthetic */ Minecraft mc;
    private /* synthetic */ boolean toggled;
    /* synthetic */ int posX;
    /* synthetic */ int posY;
    private /* synthetic */ Category category;
    private /* synthetic */ String description;
    /* synthetic */ float sizeY;
    /* synthetic */ float PosY;
    /* synthetic */ float sizeX;

    public String getDescription() {
        Module lIllIlIIllIIllI;
        return lIllIlIIllIIllI.description;
    }

    public void setToggled(boolean lIllIlIIIIlllII) {
        lIllIlIIIIlllIl.toggled = lIllIlIIIIlllII;
        if (!SelfDestruct.self) {
            Module lIllIlIIIIlllIl;
            if (lIllIlIIIIlllIl.toggled) {
                lIllIlIIIIlllIl.onEnable();
            } else {
                lIllIlIIIIlllIl.onDisable();
            }
        }
    }

    public void onDisable() {
        Module lIllIIllllllIII;
        MinecraftForge.EVENT_BUS.unregister((Object)lIllIIllllllIII);
        notifications.add(lIllIIllllllIII.name, String.valueOf(new StringBuilder().append((Object)TextFormatting.RED).append("Disable!")), Type.Red);
    }

    public int getPosX() {
        Module lIllIlIIlIIllII;
        return lIllIlIIlIIllII.posX;
    }

    public Category getCategory() {
        Module lIllIIlllllIIlI;
        return lIllIIlllllIIlI.category;
    }

    public void setPosY(int lIllIlIIIlIlIlI) {
        lIllIlIIIlIlIll.posY = lIllIlIIIlIlIlI;
    }

    public void setPosX(int lIllIlIIIllIIII) {
        lIllIlIIIllIIIl.posX = lIllIlIIIllIIII;
    }

    public Module(String lIllIlIIllIllIl, String lIllIlIIlllIIII, Category lIllIlIIllIlIll) {
        Module lIllIlIIlllIIlI;
        lIllIlIIlllIIlI.posX = 100;
        lIllIlIIlllIIlI.posY = 100;
        lIllIlIIlllIIlI.visible = true;
        lIllIlIIlllIIlI.name = lIllIlIIllIllIl;
        lIllIlIIlllIIlI.description = lIllIlIIlllIIII;
        lIllIlIIlllIIlI.key = 0;
        lIllIlIIlllIIlI.category = lIllIlIIllIlIll;
        lIllIlIIlllIIlI.toggled = false;
        lIllIlIIlllIIlI.enable = false;
        lIllIlIIlllIIlI.drawOnHud = new BooleanSetting("Draw on Hud", "drawonhud", true);
    }

    public void onEnableA() throws IOException {
        Module lIllIlIIIIIlIII;
        EventManager.register(lIllIlIIIIIlIII);
    }

    public void setSizeY(int lIllIlIIIlllIll) {
        lIllIlIIIlllIlI.sizeY = lIllIlIIIlllIll;
    }

    public int getSizeX() {
        Module lIllIlIIlIIIlIl;
        return (int)lIllIlIIlIIIlIl.sizeX;
    }

    public String getName() {
        Module lIllIIlllllIlIl;
        return lIllIIlllllIlIl.name;
    }

    public void onDisableA() {
        Module lIllIlIIIIIIlII;
        EventManager.unregister(lIllIlIIIIIIlII);
    }

    public void setEnable(boolean lIllIlIIIlIIIll) {
        Module lIllIlIIIlIIIlI;
        lIllIlIIIlIIIlI.enable = lIllIlIIIlIIIll;
        if (lIllIlIIIlIIIll) {
            lIllIlIIIlIIIlI.onEnable();
        } else {
            lIllIlIIIlIIIlI.onDisable();
        }
    }

    public int getPosY() {
        Module lIllIlIIlIIlIII;
        return lIllIlIIlIIlIII.posY;
    }

    public void toggle() {
        Module lIllIlIIIIlIIIl;
        boolean bl = lIllIlIIIIlIIIl.toggled = !lIllIlIIIIlIIIl.toggled;
        if (!SelfDestruct.self) {
            if (lIllIlIIIIlIIIl.toggled) {
                lIllIlIIIIlIIIl.onEnableR();
            } else {
                lIllIlIIIIlIIIl.onDisableR();
                lIllIlIIIIlIIIl.onDisable();
            }
        }
    }

    public void toggler() {
        Module lIllIlIIIIlIlll;
        lIllIlIIIIlIlll.toggled = !lIllIlIIIIlIlll.toggled;
        lIllIlIIIIlIlll.onToggle();
        if (lIllIlIIIIlIlll.toggled) {
            lIllIlIIIIlIlll.onEnable();
        } else {
            lIllIlIIIIlIlll.onDisable();
        }
    }

    public void setSizeX(int lIllIlIIlIIIIIl) {
        lIllIlIIlIIIIII.sizeX = lIllIlIIlIIIIIl;
    }

    public void onRender3D() {
    }

    public void setDescription(String lIllIlIIllIIIIl) {
        lIllIlIIllIIIII.description = lIllIlIIllIIIIl;
    }

    public void onEnable() {
        Module lIllIlIIIIIIIIl;
        MinecraftForge.EVENT_BUS.register((Object)lIllIlIIIIIIIIl);
        notifications.add(lIllIlIIIIIIIIl.name, String.valueOf(new StringBuilder().append((Object)TextFormatting.GREEN).append("Enable!")), Type.Green);
    }

    public boolean isToggled() {
        Module lIllIlIIlIlIlII;
        return lIllIlIIlIlIlII.toggled;
    }

    protected void onCameraSetup(EntityViewRenderEvent.CameraSetup lIllIIlllllIIII) {
    }

    public static double deltaTime() {
        double d;
        Minecraft.getMinecraft();
        if (Minecraft.getDebugFPS() > 0) {
            Minecraft.getMinecraft();
            d = 1.0 / (double)Minecraft.getDebugFPS();
        } else {
            d = 1.0;
        }
        return d;
    }

    public int getKey() {
        Module lIllIlIIlIlllII;
        return lIllIlIIlIlllII.key;
    }

    public int getSizeY() {
        Module lIllIlIIIllIlll;
        return (int)lIllIlIIIllIlll.sizeY;
    }

    public void setKey(int lIllIlIIlIlIllI) {
        lIllIlIIlIllIIl.key = lIllIlIIlIlIllI;
    }

    public void setEnabled(boolean lIllIlIIIIIllII) {
        Module lIllIlIIIIIllIl;
        if (lIllIlIIIIIllII) {
            EventManager.register(lIllIlIIIIIllIl);
        } else {
            EventManager.unregister(lIllIlIIIIIllIl);
        }
        lIllIlIIIIIllIl.toggled = lIllIlIIIIIllII;
    }

    public boolean isHud() {
        Module lIllIlIIlIIlllI;
        return lIllIlIIlIIlllI.sizeY != 0.0f || lIllIlIIlIIlllI.sizeX != 0.0f;
    }

    public void onUpdate(PlayerHook lIllIlIIlIlIIIl) {
    }

    public boolean isEnable() {
        Module lIllIlIIIlIlIII;
        return lIllIlIIIlIlIII.enable;
    }

    public void onToggle() {
    }

    public void onDisableR() {
        Module lIllIIllllllIll;
        lIllIIllllllIll.onDisable();
    }

    static {
        mc = Minecraft.getMinecraft();
    }

    public List<Setting> getSettings() {
        Module lIllIlIIllIlIII;
        return lIllIlIIllIlIII.settings;
    }

    public void onEnableR() {
        Module lIllIIlllllllll;
        lIllIIlllllllll.onEnable();
    }

    public boolean isToggler() {
        Module lIllIlIIIIlIlII;
        return lIllIlIIIIlIlII.toggled;
    }
}

