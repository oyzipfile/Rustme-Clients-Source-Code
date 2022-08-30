/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 */
package ru.internali.utils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import net.minecraft.client.Minecraft;
import ru.internali.utils.Helper;

public class SoundHelper
implements Helper {
    @Override
    public Minecraft mc() {
        return null;
    }

    public SoundHelper() {
        SoundHelper lllIIIIlIIIIlI;
    }

    public static synchronized void playSound(String lllIIIIIlllIlI, float lllIIIIIllllII, boolean lllIIIIIlllIII) {
        new Thread(() -> {
            try {
                Clip lllIIIIIlIlllI = AudioSystem.getClip();
                InputStream lllIIIIIlIllIl = SoundHelper.class.getResourceAsStream(String.valueOf(new StringBuilder().append("sound/").append(lllIIIIIlllIlI)));
                BufferedInputStream lllIIIIIlIllII = new BufferedInputStream(lllIIIIIlIllIl);
                AudioInputStream lllIIIIIlIlIll = AudioSystem.getAudioInputStream(lllIIIIIlIllII);
                lllIIIIIlIlllI.open(lllIIIIIlIlIll);
                FloatControl lllIIIIIlIlIlI = (FloatControl)lllIIIIIlIlllI.getControl(FloatControl.Type.MASTER_GAIN);
                lllIIIIIlIlIlI.setValue(lllIIIIIllllII);
                lllIIIIIlIlllI.start();
                if (lllIIIIIlllIII) {
                    lllIIIIIlIlllI.stop();
                }
            }
            catch (Exception lllIIIIIlIlIIl) {
                lllIIIIIlIlIIl.printStackTrace();
            }
        }).start();
    }
}

