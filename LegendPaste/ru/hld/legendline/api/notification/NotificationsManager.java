/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 */
package ru.hld.legendline.api.notification;

import java.util.ArrayList;
import net.minecraft.client.gui.GuiScreen;
import ru.hld.legendline.api.notification.Notification;

public class NotificationsManager {
    /* synthetic */ ArrayList<Notification> notifications;

    public void add(Notification llllIlllIIIllIl) {
        NotificationsManager llllIlllIIlIIII;
        llllIlllIIlIIII.notifications.add(llllIlllIIIllIl);
    }

    public void render() {
        NotificationsManager llllIlllIIIlIII;
        int llllIlllIIIIlll = GuiScreen.height - 25;
        for (int llllIlllIIIlIIl = 0; llllIlllIIIlIIl < llllIlllIIIlIII.notifications.size(); ++llllIlllIIIlIIl) {
            llllIlllIIIlIII.notifications.get(llllIlllIIIlIIl).render((int)((float)GuiScreen.width - llllIlllIIIlIII.notifications.get(llllIlllIIIlIIl).getWidth() - 10.0f), llllIlllIIIIlll);
            llllIlllIIIIlll = (int)((float)llllIlllIIIIlll - (llllIlllIIIlIII.notifications.get(llllIlllIIIlIIl).getHeight() + 4.0f));
            if (!llllIlllIIIlIII.notifications.get(llllIlllIIIlIIl).isTimeOut()) continue;
            llllIlllIIIlIII.notifications.remove(llllIlllIIIlIIl);
        }
    }

    public NotificationsManager() {
        NotificationsManager llllIlllIIlIIll;
        llllIlllIIlIIll.notifications = new ArrayList();
    }
}

