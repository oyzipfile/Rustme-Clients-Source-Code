/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$ElementType
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$Text
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package ru.internali.module.HUD;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.internali.module.Category;
import ru.internali.module.Module;
import ru.internali.module.combat.AntiBot;
import ru.internali.utils.friend.FriendManager;

public class PlayerRadar
extends Module {
    private /* synthetic */ int x;
    private /* synthetic */ int y;
    private /* synthetic */ Entity focusTarget;
    public /* synthetic */ Minecraft mc;
    private /* synthetic */ boolean checks;
    private /* synthetic */ String enter;
    private /* synthetic */ String hef;
    private final /* synthetic */ FontRenderer fr;
    public static final /* synthetic */ PlayerRadar INSTANCE;
    private /* synthetic */ boolean old;
    private /* synthetic */ Entity target;

    public PlayerRadar() {
        super("PlayerRadar", "PlayerRadar", Category.HUD);
        PlayerRadar llIIllIllIlIIlI;
        llIIllIllIlIIlI.mc = Minecraft.getMinecraft();
        llIIllIllIlIIlI.checks = false;
        llIIllIllIlIIlI.old = false;
        llIIllIllIlIIlI.fr = Minecraft.getMinecraft().fontRenderer;
    }

    @SubscribeEvent
    public void onOverlayRender(RenderGameOverlayEvent.Text llIIllIlIllllll) {
        PlayerRadar llIIllIllIIIIII;
        ScaledResolution llIIllIllIIIIIl = new ScaledResolution(llIIllIllIIIIII.mc);
        if (llIIllIlIllllll.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            llIIllIllIIIIII.target = null;
            if (Minecraft.getMinecraft().world == null || !Minecraft.getMinecraft().world.field_72995_K) {
                return;
            }
            int llIIllIllIIIlII = 0;
            for (Entity llIIllIllIIIlIl : Minecraft.getMinecraft().world.field_72996_f) {
                if (!(llIIllIllIIIlIl instanceof EntityPlayer) || llIIllIllIIIlIl == Minecraft.getMinecraft().player) continue;
                String llIIllIllIIlIII = llIIllIllIIIlIl.getName();
                String llIIllIllIIIlll = "Protected";
                int llIIllIllIIIllI = Color.WHITE.getRGB();
                if (AntiBot.isBot(llIIllIllIIIlIl.getName())) {
                    llIIllIllIIIllI = Color.RED.getRGB();
                } else if (FriendManager.isFriend(llIIllIllIIIlIl.getName())) {
                    llIIllIllIIIllI = Color.GREEN.getRGB();
                }
                llIIllIllIIlIII = String.valueOf(new StringBuilder().append(llIIllIllIIlIII).append(" [").append(((EntityPlayer)llIIllIllIIIlIl).func_110143_aJ()).append("/").append(((EntityPlayer)llIIllIllIIIlIl).func_110138_aP()).append("] [").append((int)Minecraft.getMinecraft().player.func_70032_d(llIIllIllIIIlIl)).append(']'));
                llIIllIllIIIIII.fr.drawStringWithShadow(llIIllIllIIlIII, 0.0f, (float)(30 + llIIllIllIIIlII * llIIllIllIIIIII.fr.FONT_HEIGHT), llIIllIllIIIllI);
                ++llIIllIllIIIlII;
            }
        }
    }

    static {
        INSTANCE = new PlayerRadar();
    }
}

