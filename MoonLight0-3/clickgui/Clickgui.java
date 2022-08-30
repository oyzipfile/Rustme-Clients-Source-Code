/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.entity.EntityLivingBase
 *  org.lwjgl.input.Mouse
 */
package clickgui;

import clickgui.comp.CheckBox;
import clickgui.comp.Combo;
import clickgui.comp.Comp;
import clickgui.comp.Slider;
import clickgui.setting.Setting;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.EntityLivingBase;
import new_gui.util.RenderHelper;
import org.lwjgl.input.Mouse;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.HUD.HUD;
import ru.internali.module.Module;
import ru.internali.module.render.Chams;
import ru.internali.utils.MathUtils;
import ru.internali.utils.RenderUtil;
import ru.internali.utils.RenderUtils;
import ru.internali.utils.friend.FriendManager;

public class Clickgui
extends GuiScreen {
    private /* synthetic */ float curAlpha;
    public /* synthetic */ Category selectedCategory;
    public /* synthetic */ double width;
    public /* synthetic */ ArrayList<Comp> comps;
    /* synthetic */ float anim;
    public /* synthetic */ int modeIndex;
    public /* synthetic */ double dragX;
    public /* synthetic */ double x;
    public /* synthetic */ double posX;
    public /* synthetic */ double posY;
    public /* synthetic */ double height;
    public /* synthetic */ double dragY;
    public /* synthetic */ boolean dragging;
    public /* synthetic */ double y;
    private /* synthetic */ boolean editing;
    private /* synthetic */ boolean binding;
    private /* synthetic */ Module selectedModule;

    public void setBinding(boolean lIlllIllIIlIIll) {
        lIlllIllIIlIllI.binding = lIlllIllIIlIIll;
    }

    protected void mouseClicked(int lIlllIllIIIIIlI, int lIlllIlIlllllII, int lIlllIllIIIIIII) throws IOException {
        Clickgui lIlllIlIllllllI;
        super.mouseClicked(lIlllIllIIIIIlI, lIlllIlIlllllII, lIlllIllIIIIIII);
        if (lIlllIlIllllllI.isInside(lIlllIllIIIIIlI, lIlllIlIlllllII, lIlllIlIllllllI.posX, lIlllIlIllllllI.posY - 10.0, lIlllIlIllllllI.width, lIlllIlIllllllI.posY) && lIlllIllIIIIIII == 0) {
            lIlllIlIllllllI.dragging = true;
            lIlllIlIllllllI.dragX = (double)lIlllIllIIIIIlI - lIlllIlIllllllI.posX;
            lIlllIlIllllllI.dragY = (double)lIlllIlIlllllII - lIlllIlIllllllI.posY;
        }
        int lIlllIlIlllllll = 0;
        for (Category lIlllIllIIIlIII : Category.values()) {
            if (lIlllIlIllllllI.isInside(lIlllIllIIIIIlI, lIlllIlIlllllII, lIlllIlIllllllI.posX, lIlllIlIllllllI.posY + 1.0 + (double)lIlllIlIlllllll, lIlllIlIllllllI.posX + 60.0, lIlllIlIllllllI.posY + 15.0 + (double)lIlllIlIlllllll) && lIlllIllIIIIIII == 0) {
                lIlllIlIllllllI.selectedCategory = lIlllIllIIIlIII;
            }
            lIlllIlIlllllll += 15;
        }
        lIlllIlIlllllll = 0;
        for (Module lIlllIllIIIIlIl : CatClient.instance.moduleManager.getModules(lIlllIlIllllllI.selectedCategory)) {
            if (lIlllIlIllllllI.isInside(lIlllIllIIIIIlI, lIlllIlIlllllII, lIlllIlIllllllI.posX + 65.0, lIlllIlIllllllI.posY + 1.0 + (double)lIlllIlIlllllll, lIlllIlIllllllI.posX + 125.0, lIlllIlIllllllI.posY + 15.0 + (double)lIlllIlIlllllll)) {
                if (lIlllIllIIIIIII == 0) {
                    lIlllIllIIIIlIl.toggle();
                }
                if (lIlllIllIIIIIII == 1) {
                    int lIlllIllIIIIllI = 3;
                    lIlllIlIllllllI.comps.clear();
                    if (CatClient.instance.settingsManager.getSettingsByMod(lIlllIllIIIIlIl) != null) {
                        for (Setting setting : CatClient.instance.settingsManager.getSettingsByMod(lIlllIllIIIIlIl)) {
                            lIlllIlIllllllI.selectedModule = lIlllIllIIIIlIl;
                            if (setting.isCombo()) {
                                lIlllIlIllllllI.comps.add(new Combo(275.0, lIlllIllIIIIllI, lIlllIlIllllllI, lIlllIlIllllllI.selectedModule, setting));
                                lIlllIllIIIIllI += 15;
                            }
                            if (setting.isCheck()) {
                                lIlllIlIllllllI.comps.add(new CheckBox(275.0, lIlllIllIIIIllI, lIlllIlIllllllI, lIlllIlIllllllI.selectedModule, setting));
                                lIlllIllIIIIllI += 13;
                            }
                            if (!setting.isSlider()) continue;
                            lIlllIlIllllllI.comps.add(new Slider(275.0, lIlllIllIIIIllI, lIlllIlIllllllI, lIlllIlIllllllI.selectedModule, setting));
                            lIlllIllIIIIllI += 18;
                        }
                    }
                }
            }
            lIlllIlIlllllll += 15;
        }
        for (Comp lIlllIllIIIIlII : lIlllIlIllllllI.comps) {
            lIlllIllIIIIlII.mouseClicked(lIlllIllIIIIIlI, lIlllIlIlllllII, lIlllIllIIIIIII);
        }
    }

    public boolean isInside(int lIlllIlIlIIlIlI, int lIlllIlIlIIllll, double lIlllIlIlIIlllI, double lIlllIlIlIIIlll, double lIlllIlIlIIIllI, double lIlllIlIlIIlIll) {
        return (double)lIlllIlIlIIlIlI > lIlllIlIlIIlllI && (double)lIlllIlIlIIlIlI < lIlllIlIlIIIllI && (double)lIlllIlIlIIllll > lIlllIlIlIIIlll && (double)lIlllIlIlIIllll < lIlllIlIlIIlIll;
    }

    public void initGui() {
        Clickgui lIlllIlIlIllIIl;
        super.initGui();
        lIlllIlIlIllIIl.anim = 0.0f;
        lIlllIlIlIllIIl.dragging = false;
    }

    public void setEditing(boolean lIlllIlIlIllIll) {
        lIlllIlIlIlllII.editing = lIlllIlIlIllIll;
    }

    public void drawScreen(int lIlllIlllIllIll, int lIlllIlllIllIlI, float lIlllIlllIllIIl) {
        Clickgui lIlllIllllIIllI;
        super.drawScreen(lIlllIlllIllIll, lIlllIlllIllIlI, lIlllIlllIllIIl);
        if (lIlllIllllIIllI.dragging) {
            lIlllIllllIIllI.posX = (double)lIlllIlllIllIll - lIlllIllllIIllI.dragX;
            lIlllIllllIIllI.posY = (double)lIlllIlllIllIlI - lIlllIllllIIllI.dragY;
        }
        lIlllIllllIIllI.width = lIlllIllllIIllI.posX + 456.0;
        lIlllIllllIIllI.height = lIlllIllllIIllI.posY + 380.0;
        float lIlllIllllIIIlI = 255.0f;
        int lIlllIllllIIIIl = (int)(lIlllIllllIIIlI / 255.0f);
        if (lIlllIllllIIllI.curAlpha < lIlllIllllIIIlI - (float)lIlllIllllIIIIl) {
            lIlllIllllIIllI.curAlpha += (float)lIlllIllllIIIIl;
        } else if (lIlllIllllIIllI.curAlpha > lIlllIllllIIIlI - (float)lIlllIllllIIIIl && lIlllIllllIIllI.curAlpha != lIlllIllllIIIlI) {
            lIlllIllllIIllI.curAlpha = (int)lIlllIllllIIIlI;
        } else if (lIlllIllllIIllI.curAlpha != lIlllIllllIIIlI) {
            lIlllIllllIIllI.curAlpha = (int)lIlllIllllIIIlI;
        }
        Color lIlllIllllIIIII = new Color(CatClient.getClientColor().getRed(), CatClient.getClientColor().getGreen(), CatClient.getClientColor().getBlue(), (int)lIlllIllllIIllI.curAlpha);
        Color lIlllIlllIlllll = new Color(0, 0, 0, 0);
        lIlllIllllIIllI.func_73733_a(0, 0, lIlllIllllIIllI.getScaledRes().getScaledWidth(), lIlllIllllIIllI.getScaledRes().getScaledHeight(), lIlllIlllIlllll.getRGB(), HUD.getRainbowChams(6000, -17));
        lIlllIllllIIllI.anim = MathUtils.lerp(lIlllIllllIIllI.anim, 1.0f, 0.13f);
        RenderHelper.customScaledObject2D((float)lIlllIllllIIllI.x, (float)lIlllIllllIIllI.y, (float)lIlllIllllIIllI.width, 15.0f, lIlllIllllIIllI.anim, 1.0f);
        RenderUtil.drawRect(lIlllIllllIIllI.posX, lIlllIllllIIllI.posY - 6.0, lIlllIllllIIllI.width, lIlllIllllIIllI.posY, HUD.getRainbowChams(6000, -15));
        RenderUtil.drawRect(lIlllIllllIIllI.posX, lIlllIllllIIllI.posY, lIlllIllllIIllI.width, lIlllIllllIIllI.height, new Color(45, 45, 45, 249).getRGB());
        int lIlllIlllIllllI = 0;
        for (Category lIlllIllllIlIlI : Category.values()) {
            RenderUtil.drawRect(lIlllIllllIIllI.posX, lIlllIllllIIllI.posY + 1.0 + (double)lIlllIlllIllllI, lIlllIllllIIllI.posX + 60.0, lIlllIllllIIllI.posY + 15.0 + (double)lIlllIlllIllllI, lIlllIllllIlIlI.equals((Object)lIlllIllllIIllI.selectedCategory) ? new Color(46, 85, 243, 156).getRGB() : new Color(28, 28, 28, 250).getRGB());
            lIlllIllllIIllI.fontRenderer.drawString(lIlllIllllIlIlI.name(), (int)lIlllIllllIIllI.posX + 2, (int)(lIlllIllllIIllI.posY + 5.0) + lIlllIlllIllllI, new Color(170, 170, 170).getRGB());
            lIlllIlllIllllI += 15;
        }
        lIlllIlllIllllI = 0;
        for (Module lIlllIllllIlIIl : CatClient.instance.moduleManager.getModules(lIlllIllllIIllI.selectedCategory)) {
            RenderUtil.drawRect(lIlllIllllIIllI.posX + 65.0, lIlllIllllIIllI.posY + 1.0 + (double)lIlllIlllIllllI, lIlllIllllIIllI.posX + 150.0, lIlllIllllIIllI.posY + 15.0 + (double)lIlllIlllIllllI, lIlllIllllIlIIl.isToggled() ? new Color(46, 85, 234, 155).getRGB() : new Color(28, 28, 28, 249).getRGB());
            lIlllIllllIIllI.fontRenderer.drawString(lIlllIllllIlIIl.getName(), (int)lIlllIllllIIllI.posX + 67, (int)(lIlllIllllIIllI.posY + 5.0) + lIlllIlllIllllI, new Color(170, 170, 170).getRGB());
            lIlllIlllIllllI += 15;
        }
        Gui.drawRect((int)((int)(lIlllIllllIIllI.posX + 455.0)), (int)((int)(lIlllIllllIIllI.posY + 360.0)), (int)((int)(lIlllIllllIIllI.posX + 323.0)), (int)((int)(lIlllIllllIIllI.posY + 320.5)), (int)new Color(31, 31, 31, 250).getRGB());
        lIlllIllllIIllI.mc.fontRenderer.drawStringWithShadow("MoonLight", (float)(lIlllIllllIIllI.posX + 353.0), (float)(lIlllIllllIIllI.posY + 327.0), Chams.getRainbowChams(8000, -17));
        Gui.drawRect((int)((int)(lIlllIllllIIllI.posX + 300.0)), (int)((int)(lIlllIllllIIllI.posY + 370.0)), (int)((int)(lIlllIllllIIllI.posX + 200.0)), (int)((int)(lIlllIllllIIllI.posY + 2.0)), (int)new Color(31, 31, 31, 250).getRGB());
        lIlllIllllIIllI.mc.fontRenderer.drawStringWithShadow(CatClient.UID(), (float)(lIlllIllllIIllI.posX + 353.0), (float)(lIlllIllllIIllI.posY + 337.5), Color.white.getRGB());
        String lIlllIlllIlllIl = "Beta";
        lIlllIllllIIllI.mc.fontRenderer.drawStringWithShadow(String.valueOf(new StringBuilder().append("Status: ").append(lIlllIlllIlllIl)), (float)(lIlllIllllIIllI.posX + 353.0), (float)(lIlllIllllIIllI.posY + 347.5), Color.white.getRGB());
        lIlllIllllIIllI.mc.fontRenderer.drawStringWithShadow("Build: 0.3", (float)(lIlllIllllIIllI.posX + 410.0), (float)(lIlllIllllIIllI.posY + 370.0), Color.white.getRGB());
        try {
            lIlllIllllIIllI.mc.getTextureManager().bindTexture(Objects.requireNonNull(lIlllIllllIIllI.mc.getConnection()).getPlayerInfo(lIlllIllllIIllI.mc.player.func_110124_au()).getLocationSkin());
            Gui.drawScaledCustomSizeModalRect((int)((int)(lIlllIllllIIllI.posX + 328.0)), (int)((int)(lIlllIllllIIllI.posY + 330.0)), (float)8.0f, (float)8.0f, (int)8, (int)8, (int)22, (int)22, (float)64.0f, (float)64.0f);
        }
        catch (Exception lIlllIllllIlIII) {
            lIlllIllllIlIII.printStackTrace();
        }
        for (Comp lIlllIllllIIlll : lIlllIllllIIllI.comps) {
            lIlllIllllIIlll.drawScreen(lIlllIlllIllIll, lIlllIlllIllIlI);
        }
        lIlllIllllIIllI.drawinfo(lIlllIlllIllIll, lIlllIlllIllIlI);
        lIlllIllllIIllI.player();
    }

    public ScaledResolution getScaledRes() {
        return new ScaledResolution(Minecraft.getMinecraft());
    }

    public boolean isEditing() {
        Clickgui lIlllIlIllIIIIl;
        return lIlllIlIllIIIIl.editing;
    }

    public void player() {
        try {
            Clickgui lIlllIlllIIlIll;
            lIlllIlllIIlIll.mc.getTextureManager().bindTexture(Objects.requireNonNull(lIlllIlllIIlIll.mc.getConnection()).getPlayerInfo(lIlllIlllIIlIll.mc.player.func_110124_au()).getLocationSkin());
            RenderUtils.renderEntity((EntityLivingBase)lIlllIlllIIlIll.mc.player, 70, (int)(lIlllIlllIIlIll.posX + 375.0), (int)(lIlllIlllIIlIll.posY + 230.0));
        }
        catch (Exception lIlllIlllIIllIl) {
            lIlllIlllIIllIl.printStackTrace();
        }
    }

    protected void mouseReleased(int lIlllIlIllIllII, int lIlllIlIllIlIll, int lIlllIlIllIlIlI) {
        Clickgui lIlllIlIllIllIl;
        super.mouseReleased(lIlllIlIllIllII, lIlllIlIllIlIll, lIlllIlIllIlIlI);
        lIlllIlIllIllIl.dragging = false;
        for (Comp lIlllIlIllIlllI : lIlllIlIllIllIl.comps) {
            lIlllIlIllIlllI.mouseReleased(lIlllIlIllIllII, lIlllIlIllIlIll, lIlllIlIllIlIlI);
        }
    }

    protected void keyTyped(char lIlllIllIIlllll, int lIlllIllIIllIll) throws IOException {
        Clickgui lIlllIllIlIIIII;
        super.keyTyped(lIlllIllIIlllll, lIlllIllIIllIll);
        for (Comp lIlllIllIlIIIIl : lIlllIllIlIIIII.comps) {
            lIlllIllIlIIIIl.keyTyped(lIlllIllIIlllll, lIlllIllIIllIll);
        }
    }

    public Clickgui() {
        Clickgui lIlllIllllllIIl;
        lIlllIllllllIIl.anim = 0.0f;
        lIlllIllllllIIl.comps = new ArrayList();
        lIlllIllllllIIl.dragging = false;
        lIlllIllllllIIl.posX = lIlllIllllllIIl.getScaledRes().getScaledWidth() / 2 - 150;
        lIlllIllllllIIl.posY = lIlllIllllllIIl.getScaledRes().getScaledHeight() / 2 - 100;
        lIlllIllllllIIl.width = lIlllIllllllIIl.posX + 456.0;
        lIlllIllllllIIl.height += 380.0;
        lIlllIllllllIIl.selectedCategory = Category.COMBAT;
        lIlllIllllllIIl.x = 100.0;
        lIlllIllllllIIl.y = 200.0;
    }

    public void drawinfo(int lIlllIllIllIIIl, int lIlllIllIllIllI) {
        Clickgui lIlllIllIlllIII;
        int lIlllIllIllIlIl = 800;
        int lIlllIllIllIlII = 100;
        int lIlllIllIllIIll = 0;
        lIlllIllIlllIII.fontRenderer.drawStringWithShadow("Friends", (float)(lIlllIllIllIlIl + lIlllIllIlllIII.fontRenderer.getStringWidth("Friends") / 2), (float)(lIlllIllIllIlII - lIlllIllIlllIII.fontRenderer.FONT_HEIGHT), CatClient.getClientColor().getRGB());
        RenderUtil.drawRect(lIlllIllIllIlIl, lIlllIllIllIlII, lIlllIllIllIlIl + 100, lIlllIllIllIlII + FriendManager.FRIENDS.size() * lIlllIllIlllIII.fontRenderer.FONT_HEIGHT, new Color(50, 50, 50, 190).getRGB());
        RenderUtil.drawNewRect(lIlllIllIllIlIl - 1, lIlllIllIllIlII, lIlllIllIllIlIl, lIlllIllIllIlII + FriendManager.FRIENDS.size() * lIlllIllIlllIII.fontRenderer.FONT_HEIGHT, CatClient.getClientColor().getRGB());
        RenderUtil.drawNewRect(lIlllIllIllIlIl + 100 - 1, lIlllIllIllIlII, lIlllIllIllIlIl + 100, lIlllIllIllIlII + FriendManager.FRIENDS.size() * lIlllIllIlllIII.fontRenderer.FONT_HEIGHT, CatClient.getClientColor().getRGB());
        RenderUtil.drawGlow(lIlllIllIllIlIl, lIlllIllIllIlII - 1, lIlllIllIllIlIl + 100, lIlllIllIllIlII, CatClient.getClientColor().getRGB(), 250.0);
        RenderUtil.drawGlow(lIlllIllIllIlIl, lIlllIllIllIlII + FriendManager.FRIENDS.size() * lIlllIllIlllIII.fontRenderer.FONT_HEIGHT - 1, lIlllIllIllIlIl + 100, lIlllIllIllIlII + FriendManager.FRIENDS.size() * lIlllIllIlllIII.fontRenderer.FONT_HEIGHT, CatClient.getClientColor().getRGB(), 250.0);
        for (String lIlllIllIlllIIl : FriendManager.friendsList) {
            int lIlllIllIllllIl = lIlllIllIllIlIl;
            int lIlllIllIllllII = 100 + lIlllIllIllIlIl;
            int lIlllIllIlllIll = lIlllIllIllIIll + lIlllIllIllIlII;
            int lIlllIllIlllIlI = lIlllIllIllIIll + lIlllIllIlllIII.fontRenderer.FONT_HEIGHT + lIlllIllIllIlII;
            if (lIlllIllIllIIIl > lIlllIllIllllIl && lIlllIllIllIIIl < lIlllIllIllllII && lIlllIllIllIllI > lIlllIllIlllIll && lIlllIllIllIllI < lIlllIllIlllIlI) {
                lIlllIllIlllIII.fontRenderer.drawString(lIlllIllIlllIIl, lIlllIllIllIlIl + 50 - lIlllIllIlllIII.fontRenderer.getStringWidth(lIlllIllIlllIIl) / 2, lIlllIllIllIIll + lIlllIllIllIlII, CatClient.getClientColor().getRGB());
                if (Mouse.isButtonDown((int)1)) {
                    FriendManager.removeFriend(lIlllIllIlllIIl);
                    return;
                }
            } else {
                lIlllIllIlllIII.fontRenderer.drawString(lIlllIllIlllIIl, lIlllIllIllIlIl + 50 - lIlllIllIlllIII.fontRenderer.getStringWidth(lIlllIllIlllIIl) / 2, lIlllIllIllIIll + lIlllIllIllIlII, Color.white.getRGB());
            }
            lIlllIllIllIIll += lIlllIllIlllIII.fontRenderer.FONT_HEIGHT;
        }
    }
}

