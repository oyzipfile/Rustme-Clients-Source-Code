/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityLivingBase
 *  org.lwjgl.input.Mouse
 */
package ru.hld.legendline.impl.modules.Misc;

import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.input.Mouse;
import ru.hld.legendline.api.event.EventTarget;
import ru.hld.legendline.api.event.events.EventUpdate;
import ru.hld.legendline.api.module.Category;
import ru.hld.legendline.api.module.Module;
import ru.hld.legendline.api.shit.FriendManager;

public class MCF
extends Module {
    public /* synthetic */ boolean onFriend;

    @EventTarget
    public void onUpdate(EventUpdate lllllllllllllIlllllllIIIIIIllllI) {
        MCF lllllllllllllIlllllllIIIIIIlllIl;
        if (Mouse.isButtonDown((int)2) && lllllllllllllIlllllllIIIIIIlllIl.mc.pointedEntity != null && lllllllllllllIlllllllIIIIIIlllIl.mc.pointedEntity instanceof EntityLivingBase && lllllllllllllIlllllllIIIIIIlllIl.onFriend) {
            lllllllllllllIlllllllIIIIIIlllIl.onFriend = false;
            if (FriendManager.isFriend(lllllllllllllIlllllllIIIIIIlllIl.mc.objectMouseOver.entityHit.getName())) {
                FriendManager.remove(lllllllllllllIlllllllIIIIIIlllIl.mc.objectMouseOver.entityHit.getName());
            } else {
                FriendManager.add(lllllllllllllIlllllllIIIIIIlllIl.mc.objectMouseOver.entityHit.getName());
            }
        }
        if (!Mouse.isButtonDown((int)2)) {
            lllllllllllllIlllllllIIIIIIlllIl.onFriend = true;
        }
    }

    public MCF() {
        super("MCF", "add or remove player over your srosshair on Midddle Click on mouse", Category.Misc);
        MCF lllllllllllllIlllllllIIIIIlIIIlI;
        lllllllllllllIlllllllIIIIIlIIIlI.onFriend = true;
    }
}

