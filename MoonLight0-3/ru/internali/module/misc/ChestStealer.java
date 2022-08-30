/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.inventory.Container
 *  net.minecraft.inventory.ContainerChest
 *  net.minecraft.item.Item
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package ru.internali.module.misc;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.settings.Setting;
import ru.internali.utils.TimerUtils;

public class ChestStealer
extends Module {
    public /* synthetic */ TimerUtils timer;

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent llllllIIIIIIllI) {
        ChestStealer llllllIIIIIIlII;
        float llllllIIIIIIlIl = (float)CatClient.instance.settingsManager.getSettingByName(llllllIIIIIIlII, "Speed").getValDouble();
        if (ChestStealer.mc.player.field_71070_bA != null) {
            if (ChestStealer.mc.player.field_71070_bA instanceof ContainerChest) {
                ContainerChest llllllIIIIIlIlI = (ContainerChest)ChestStealer.mc.player.field_71070_bA;
                for (int llllllIIIIIllII = 0; llllllIIIIIllII < llllllIIIIIlIlI.field_75151_b.size(); ++llllllIIIIIllII) {
                    if (llllllIIIIIlIlI.getLowerChestInventory().getStackInSlot(llllllIIIIIllII).getItem() != Item.getItemById((int)0) && llllllIIIIIIlII.timer.isDeley((long)llllllIIIIIIlIl)) {
                        ChestStealer.mc.playerController.windowClick(llllllIIIIIlIlI.field_75152_c, llllllIIIIIllII, 0, ClickType.QUICK_MOVE, (EntityPlayer)ChestStealer.mc.player);
                        llllllIIIIIIlII.timer.reset();
                        continue;
                    }
                    if (!llllllIIIIIIlII.empty((Container)llllllIIIIIlIlI)) continue;
                    ChestStealer.mc.player.closeScreen();
                }
            }
        }
    }

    public boolean empty(Container lllllIllllIllII) {
        boolean lllllIllllIlllI = true;
        int lllllIllllIllIl = lllllIllllIllII.inventorySlots.size() == 90 ? 54 : 27;
        for (int lllllIlllllIIIl = 0; lllllIlllllIIIl < lllllIllllIllIl; ++lllllIlllllIIIl) {
            if (!lllllIllllIllII.getSlot(lllllIlllllIIIl).getHasStack()) continue;
            lllllIllllIlllI = false;
        }
        return lllllIllllIlllI;
    }

    public ChestStealer() {
        super("ChestStealer", "ChestStealer", Category.OUTHER);
        ChestStealer llllllIIIIlllll;
        llllllIIIIlllll.timer = new TimerUtils();
        CatClient.instance.settingsManager.rSetting(new Setting("Speed", llllllIIIIlllll, 40.0, 1.0, 1000.0, true));
    }
}

