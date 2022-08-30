/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketCustomSound
 *  net.minecraftforge.client.event.sound.PlaySoundEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package ru.internali.module.HUD;

import java.util.ArrayList;
import net.minecraft.network.play.server.SPacketCustomSound;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.internali.module.Category;
import ru.internali.module.HUD.Exploid;
import ru.internali.module.Module;
import ru.internali.module.movement.Command;

public class ExpInfo
extends Module {
    /* synthetic */ ArrayList<Exploid> exploids;

    public ExpInfo() {
        super("ExpInfo", "ExpInfo", Category.HUD);
        ExpInfo lllIIlIIIIIIllI;
        lllIIlIIIIIIllI.exploids = new ArrayList();
    }

    @SubscribeEvent
    public void onPacket(PlaySoundEvent lllIIIlllllllIl) {
        if (lllIIIlllllllIl.getSound() instanceof SPacketCustomSound) {
            SPacketCustomSound lllIIlIIIIIIIII = (SPacketCustomSound)lllIIIlllllllIl.getSound();
            switch (lllIIlIIIIIIIII.getSoundName()) {
                case "timed_explosive_charge.explosion.1.3p": 
                case "timed_explosive_charge.explosion.2.far.3p": 
                case "timed_explosive_charge.explosion.2.3p": 
                case "timed_explosive_charge.explosion.1.far.3p": {
                    Command.sendClientSideMessage(String.valueOf(new StringBuilder().append("Found Sound X:").append((int)lllIIlIIIIIIIII.getX()).append(" Z:").append((int)lllIIlIIIIIIIII.getY()).append(" Y:").append((int)lllIIlIIIIIIIII.getZ())));
                }
            }
        }
    }
}

