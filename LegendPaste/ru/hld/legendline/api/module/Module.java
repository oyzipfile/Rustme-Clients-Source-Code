/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 */
package ru.hld.legendline.api.module;

import net.minecraft.client.Minecraft;
import ru.hld.legendline.Client;
import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.notification.Notification;
import ru.hld.legendline.api.utils.CFontRenderer;
import ru.hld.legendline.api.utils.Fonts;
import ru.hld.legendline.api.utils.PlayerHook;

public class Module {
    /* synthetic */ String descriptions;
    /* synthetic */ int key;
    /* synthetic */ String displayname;
    protected /* synthetic */ Minecraft mc;
    public /* synthetic */ CFontRenderer fr;
    /* synthetic */ Category category;
    /* synthetic */ int posX;
    /* synthetic */ int sizeY;
    /* synthetic */ boolean enabled;
    /* synthetic */ String name;
    /* synthetic */ int sizeX;
    /* synthetic */ int posY;

    public void setDescriptions(String llllllllllllllIlIllllIIllIIIlIII) {
        llllllllllllllIlIllllIIllIIIlIIl.descriptions = llllllllllllllIlIllllIIllIIIlIII;
    }

    public String getDisplayname() {
        Module llllllllllllllIlIllllIIllIIIllll;
        return llllllllllllllIlIllllIIllIIIllll.displayname;
    }

    public void setSizeX(int llllllllllllllIlIllllIIllIlllllI) {
        llllllllllllllIlIllllIIllIllllll.sizeX = llllllllllllllIlIllllIIllIlllllI;
    }

    public String getName() {
        Module llllllllllllllIlIllllIIlIlIIllIl;
        return llllllllllllllIlIllllIIlIlIIllIl.name;
    }

    public int getPosX() {
        Module llllllllllllllIlIllllIIlIlllllII;
        return llllllllllllllIlIllllIIlIlllllII.posX;
    }

    public Category getCategory() {
        Module llllllllllllllIlIllllIIlIlIIlIll;
        return llllllllllllllIlIllllIIlIlIIlIll.category;
    }

    public void toggle() {
        Module llllllllllllllIlIllllIIlIlIlllII;
        llllllllllllllIlIllllIIlIlIlllII.setEnabled(!llllllllllllllIlIllllIIlIlIlllII.isEnabled());
    }

    public void onUpdate(PlayerHook llllllllllllllIlIllllIIlIlIlIIll) {
    }

    public boolean isHud() {
        Module llllllllllllllIlIllllIIllIllllII;
        return llllllllllllllIlIllllIIllIllllII.sizeY != 0 || llllllllllllllIlIllllIIllIllllII.sizeX != 0;
    }

    public void onEnable() {
        Module llllllllllllllIlIllllIIlIlIllIIl;
        Client.eventManager.register(llllllllllllllIlIllllIIlIlIllIIl);
        Client.notificationsManager.add(new Notification(llllllllllllllIlIllllIIlIlIllIIl.name, "K"));
    }

    public void setPosX(int llllllllllllllIlIllllIIlIllllIII) {
        llllllllllllllIlIllllIIlIllllIIl.posX = llllllllllllllIlIllllIIlIllllIII;
    }

    public String getDescriptions() {
        Module llllllllllllllIlIllllIIlIlIlIIIl;
        return llllllllllllllIlIllllIIlIlIlIIIl.descriptions;
    }

    public int getPosY() {
        Module llllllllllllllIlIllllIIllIIIIIII;
        return llllllllllllllIlIllllIIllIIIIIII.posY;
    }

    public boolean isEnabled() {
        Module llllllllllllllIlIllllIIlIllIllIl;
        return llllllllllllllIlIllllIIlIllIllIl.enabled;
    }

    public void onDisable() {
        Module llllllllllllllIlIllllIIlIlIlIlIl;
        Client.eventManager.unregister(llllllllllllllIlIllllIIlIlIlIlIl);
        Client.notificationsManager.add(new Notification(llllllllllllllIlIllllIIlIlIlIlIl.name, "I"));
    }

    public Module(String llllllllllllllIlIllllIIllIlIllll, String llllllllllllllIlIllllIIllIlIlllI, Category llllllllllllllIlIllllIIllIlIlIIl) {
        Module llllllllllllllIlIllllIIllIlIllII;
        llllllllllllllIlIllllIIllIlIllII.key = 0;
        llllllllllllllIlIllllIIllIlIllII.mc = Minecraft.getMinecraft();
        llllllllllllllIlIllllIIllIlIllII.fr = Fonts.mntsb_20;
        llllllllllllllIlIllllIIllIlIllII.category = llllllllllllllIlIllllIIllIlIlIIl;
        llllllllllllllIlIllllIIllIlIllII.name = llllllllllllllIlIllllIIllIlIllll;
        llllllllllllllIlIllllIIllIlIllII.descriptions = llllllllllllllIlIllllIIllIlIlllI;
        llllllllllllllIlIllllIIllIlIllII.displayname = llllllllllllllIlIllllIIllIlIllll;
    }

    public void setEnabled(boolean llllllllllllllIlIllllIIlIllIIIII) {
        Module llllllllllllllIlIllllIIlIlIlllll;
        llllllllllllllIlIllllIIlIlIlllll.displayname = llllllllllllllIlIllllIIlIlIlllll.name;
        llllllllllllllIlIllllIIlIlIlllll.enabled = llllllllllllllIlIllllIIlIllIIIII;
        if (llllllllllllllIlIllllIIlIllIIIII) {
            llllllllllllllIlIllllIIlIlIlllll.onEnable();
        } else {
            llllllllllllllIlIllllIIlIlIlllll.onDisable();
        }
    }

    public Module(String llllllllllllllIlIllllIIllIIlIlll, String llllllllllllllIlIllllIIllIIllllI, Category llllllllllllllIlIllllIIllIIlIlIl, int llllllllllllllIlIllllIIllIIlIlII, int llllllllllllllIlIllllIIllIIlIIll, int llllllllllllllIlIllllIIllIIllIlI, int llllllllllllllIlIllllIIllIIlIIIl) {
        Module llllllllllllllIlIllllIIllIlIIIII;
        llllllllllllllIlIllllIIllIlIIIII.key = 0;
        llllllllllllllIlIllllIIllIlIIIII.mc = Minecraft.getMinecraft();
        llllllllllllllIlIllllIIllIlIIIII.fr = Fonts.mntsb_20;
        llllllllllllllIlIllllIIllIlIIIII.category = llllllllllllllIlIllllIIllIIlIlIl;
        llllllllllllllIlIllllIIllIlIIIII.name = llllllllllllllIlIllllIIllIIlIlll;
        llllllllllllllIlIllllIIllIlIIIII.descriptions = llllllllllllllIlIllllIIllIIllllI;
        llllllllllllllIlIllllIIllIlIIIII.sizeX = llllllllllllllIlIllllIIllIIlIlII;
        llllllllllllllIlIllllIIllIlIIIII.sizeY = llllllllllllllIlIllllIIllIIlIIll;
        llllllllllllllIlIllllIIllIlIIIII.posX = llllllllllllllIlIllllIIllIIllIlI;
        llllllllllllllIlIllllIIllIlIIIII.posY = llllllllllllllIlIllllIIllIIlIIIl;
        llllllllllllllIlIllllIIllIlIIIII.displayname = llllllllllllllIlIllllIIllIIlIlll;
    }

    public void setSizeY(int llllllllllllllIlIllllIIlllIIIllI) {
        llllllllllllllIlIllllIIlllIIIlIl.sizeY = llllllllllllllIlIllllIIlllIIIllI;
    }

    public void setPosY(int llllllllllllllIlIllllIIlIlllIIlI) {
        llllllllllllllIlIllllIIlIlllIIIl.posY = llllllllllllllIlIllllIIlIlllIIlI;
    }

    public int getKey() {
        Module llllllllllllllIlIllllIIlIllIlIll;
        return llllllllllllllIlIllllIIlIllIlIll.key;
    }

    public int getSizeY() {
        Module llllllllllllllIlIllllIIllIIIIlIl;
        return llllllllllllllIlIllllIIllIIIIlIl.sizeY;
    }

    public int getSizeX() {
        Module llllllllllllllIlIllllIIllIIIIIlI;
        return llllllllllllllIlIllllIIllIIIIIlI.sizeX;
    }

    public void setDisplayname(String llllllllllllllIlIllllIIllIllIlIl) {
        llllllllllllllIlIllllIIllIllIllI.displayname = llllllllllllllIlIllllIIllIllIlIl;
    }

    public void setKey(int llllllllllllllIlIllllIIlIllIIlII) {
        llllllllllllllIlIllllIIlIllIIlll.key = llllllllllllllIlIllllIIlIllIIlII;
    }
}

