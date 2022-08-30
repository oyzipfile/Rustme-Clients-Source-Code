/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils;

import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;

public class notification {
    public static void main(String lIlllIIllllIIl) throws Exception {
        if (SystemTray.isSupported()) {
            SystemTray lIlllIIlllllIl = SystemTray.getSystemTray();
            Image lIlllIIlllllII = Toolkit.getDefaultToolkit().getImage("images/bor.png");
            TrayIcon lIlllIIllllIll = new TrayIcon(lIlllIIlllllII);
            lIlllIIlllllIl.add(lIlllIIllllIll);
            lIlllIIllllIll.displayMessage("MoonLight", lIlllIIllllIIl, TrayIcon.MessageType.INFO);
        }
    }

    public notification() {
        notification lIlllIlIIIIIlI;
    }
}

