/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.client.event.sound.PlaySoundEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package ru.internali.module.CHAT;

import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.module.movement.Command;

public class Exp
extends Module {
    public Exp() {
        super("SoundInfo", "SoundInfo", Category.CHAT);
        Exp lIllIlllIllIlII;
    }

    @SubscribeEvent
    public void Exp(PlaySoundEvent lIllIlllIlIlIIl) {
        float lIllIlllIlIllII = lIllIlllIlIlIIl.getSound().getXPosF();
        float lIllIlllIlIlIll = lIllIlllIlIlIIl.getSound().getYPosF();
        float lIllIlllIlIlIlI = lIllIlllIlIlIIl.getSound().getZPosF();
        lIllIlllIlIlIIl.getName().equals("entity.bobber.splash");
        Command.sendClientSideMessage(String.valueOf(new StringBuilder().append("Found Sound X:").append((int)lIllIlllIlIllII).append(" Z:").append((int)lIllIlllIlIlIll).append(" Y:").append((int)lIllIlllIlIlIlI)));
    }
}

