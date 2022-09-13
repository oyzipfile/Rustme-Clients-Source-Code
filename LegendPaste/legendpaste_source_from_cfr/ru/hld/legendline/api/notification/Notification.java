/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package ru.hld.legendline.api.notification;

import java.awt.Color;
import org.lwjgl.opengl.GL11;
import ru.hld.legendline.Client;
import ru.hld.legendline.antiNative.RenderUtils;
import ru.hld.legendline.api.font.FontUtils;
import ru.hld.legendline.api.utils.CFontRenderer;
import ru.hld.legendline.api.utils.Fonts;
import ru.hld.legendline.api.utils.MathUtils;
import ru.hld.legendline.api.utils.TimerUtils;
import ru.hld.legendline.impl.modules.Render.Notifications;

public class Notification {
    /* synthetic */ float anim;
    /* synthetic */ float animMotion;
    /* synthetic */ TimerUtils timer;
    /* synthetic */ String name;
    /* synthetic */ String message;

    public Notification(String llllllllllllllIIIlIIllIllIIIlIll, String llllllllllllllIIIlIIllIllIIIlIlI) {
        Notification llllllllllllllIIIlIIllIllIIIllll;
        llllllllllllllIIIlIIllIllIIIllll.anim = 0.0f;
        llllllllllllllIIIlIIllIllIIIllll.animMotion = 1.2f;
        llllllllllllllIIIlIIllIllIIIllll.message = llllllllllllllIIIlIIllIllIIIlIlI;
        llllllllllllllIIIlIIllIllIIIllll.name = llllllllllllllIIIlIIllIllIIIlIll;
        llllllllllllllIIIlIIllIllIIIllll.timer = new TimerUtils();
        llllllllllllllIIIlIIllIllIIIllll.anim = 0.8f;
    }

    public float getWidth() {
        Notification llllllllllllllIIIlIIllIllIIIIIll;
        return FontUtils.fr.getStringWidth(llllllllllllllIIIlIIllIllIIIIIll.name) + 100;
    }

    public void render(int llllllllllllllIIIlIIllIlIlllIlll, int llllllllllllllIIIlIIllIlIllllIll) {
        Notification llllllllllllllIIIlIIllIlIllllIII;
        if (llllllllllllllIIIlIIllIlIllllIII.anim > 1.18f) {
            llllllllllllllIIIlIIllIlIllllIII.animMotion = 1.0f;
        }
        if (llllllllllllllIIIlIIllIlIllllIII.timer.hasReached(900L)) {
            llllllllllllllIIIlIIllIlIllllIII.animMotion = 0.7f;
        }
        llllllllllllllIIIlIIllIlIllllIII.anim = MathUtils.lerp(llllllllllllllIIIlIIllIlIllllIII.anim, llllllllllllllIIIlIIllIlIllllIII.animMotion, 0.1f);
        GL11.glPushMatrix();
        RenderUtils.customScaledObject2D(llllllllllllllIIIlIIllIlIlllIlll, llllllllllllllIIIlIIllIlIllllIll, llllllllllllllIIIlIIllIlIllllIII.getWidth(), llllllllllllllIIIlIIllIlIllllIII.getHeight(), llllllllllllllIIIlIIllIlIllllIII.anim);
        RenderUtils.drawShadowRect(llllllllllllllIIIlIIllIlIlllIlll, llllllllllllllIIIlIIllIlIllllIll, (float)llllllllllllllIIIlIIllIlIlllIlll + llllllllllllllIIIlIIllIlIllllIII.getWidth(), (float)llllllllllllllIIIlIIllIlIllllIll + llllllllllllllIIIlIIllIlIllllIII.getHeight(), 4, Client.getColor());
        CFontRenderer llllllllllllllIIIlIIllIlIllllIlI = Fonts.mntsb_25;
        CFontRenderer llllllllllllllIIIlIIllIlIllllIIl = Fonts.iconswex_40;
        llllllllllllllIIIlIIllIlIllllIlI.drawCenteredString(llllllllllllllIIIlIIllIlIllllIII.name, (float)llllllllllllllIIIlIIllIlIlllIlll + llllllllllllllIIIlIIllIlIllllIII.getWidth() / 2.0f + 10.0f, llllllllllllllIIIlIIllIlIllllIll, -1);
        if (Notifications.colored.getVal()) {
            llllllllllllllIIIlIIllIlIllllIIl.drawCenteredString(llllllllllllllIIIlIIllIlIllllIII.message, llllllllllllllIIIlIIllIlIlllIlll + 9, (float)llllllllllllllIIIlIIllIlIllllIll + llllllllllllllIIIlIIllIlIllllIII.getHeight() - (float)llllllllllllllIIIlIIllIlIllllIlI.getHeight() + 2.0f, llllllllllllllIIIlIIllIlIllllIII.message == "I" ? Client.getColor2() : Client.getColor2());
        } else {
            llllllllllllllIIIlIIllIlIllllIIl.drawCenteredString(llllllllllllllIIIlIIllIlIllllIII.message, llllllllllllllIIIlIIllIlIlllIlll + 9, (float)llllllllllllllIIIlIIllIlIllllIll + llllllllllllllIIIlIIllIlIllllIII.getHeight() - (float)llllllllllllllIIIlIIllIlIllllIlI.getHeight() + 2.0f, llllllllllllllIIIlIIllIlIllllIII.message == "I" ? new Color(255, 0, 0, 255).getRGB() : new Color(0, 255, 0, 255).getRGB());
        }
        GL11.glPopMatrix();
    }

    public float getHeight() {
        return 12.0f;
    }

    public boolean isTimeOut() {
        Notification llllllllllllllIIIlIIllIllIIIlIII;
        return llllllllllllllIIIlIIllIllIIIlIII.timer.hasReached(1000L);
    }
}

