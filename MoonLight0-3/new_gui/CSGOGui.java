/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.ScaledResolution
 *  org.lwjgl.input.Mouse
 */
package new_gui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import new_gui.buttons.CSCategoryButton;
import new_gui.util.RenderHelper;
import org.lwjgl.input.Mouse;
import ru.internali.CatClient;
import ru.internali.module.Category;
import ru.internali.module.HUD.HUD;
import ru.internali.utils.MathUtils;
import ru.internali.utils.RenderUtil;
import ru.internali.utils.friend.FriendManager;

public class CSGOGui
extends GuiScreen {
    public /* synthetic */ CSCategoryButton currentCategory;
    public /* synthetic */ int x;
    public /* synthetic */ int height;
    private /* synthetic */ float curAlpha;
    private /* synthetic */ float anim;
    public /* synthetic */ int width;
    public /* synthetic */ int y;
    public /* synthetic */ ScaledResolution sr;
    public /* synthetic */ ArrayList<CSCategoryButton> buttons;

    public void drawScreen(int lIIIIllIIIllIl, int lIIIIllIIIllII, float lIIIIllIIIlIll) {
        CSGOGui lIIIIllIIlIllI;
        lIIIIllIIlIllI.drawDefaultBackground();
        float lIIIIllIIlIIlI = 150.0f;
        int lIIIIllIIlIIIl = (int)(lIIIIllIIlIIlI / 150.0f);
        if (lIIIIllIIlIllI.curAlpha < lIIIIllIIlIIlI - (float)lIIIIllIIlIIIl) {
            lIIIIllIIlIllI.curAlpha += (float)lIIIIllIIlIIIl;
        } else if (lIIIIllIIlIllI.curAlpha > lIIIIllIIlIIlI - (float)lIIIIllIIlIIIl && lIIIIllIIlIllI.curAlpha != lIIIIllIIlIIlI) {
            lIIIIllIIlIllI.curAlpha = (int)lIIIIllIIlIIlI;
        } else if (lIIIIllIIlIllI.curAlpha != lIIIIllIIlIIlI) {
            lIIIIllIIlIllI.curAlpha = (int)lIIIIllIIlIIlI;
        }
        Color lIIIIllIIlIIII = new Color(CatClient.getClientColor().getRed(), CatClient.getClientColor().getGreen(), CatClient.getClientColor().getBlue(), (int)lIIIIllIIlIllI.curAlpha);
        Color lIIIIllIIIllll = new Color(0, 0, 0, 0);
        lIIIIllIIlIllI.func_73733_a(0, 0, lIIIIllIIlIllI.getScaledRes().getScaledWidth(), lIIIIllIIlIllI.getScaledRes().getScaledHeight(), lIIIIllIIIllll.getRGB(), HUD.getRainbowChams(6000, -17));
        lIIIIllIIlIllI.anim = MathUtils.lerp(lIIIIllIIlIllI.anim, 1.0f, 0.1f);
        RenderHelper.customScaledObject2D(lIIIIllIIlIllI.x, lIIIIllIIlIllI.y, lIIIIllIIlIllI.width, 15.0f, lIIIIllIIlIllI.anim, 1.0f);
        RenderUtil.drawNewRect(lIIIIllIIlIllI.x, lIIIIllIIlIllI.height, lIIIIllIIlIllI.width, (double)lIIIIllIIlIllI.height + 0.5, HUD.getRainbowChams(6000, -17));
        RenderUtil.drawNewRect(lIIIIllIIlIllI.width, lIIIIllIIlIllI.y - lIIIIllIIlIllI.fontRenderer.FONT_HEIGHT * 2, (double)lIIIIllIIlIllI.width + 0.5, lIIIIllIIlIllI.height, CatClient.getClientColor().getRGB());
        Gui.drawRect((int)lIIIIllIIlIllI.x, (int)(lIIIIllIIlIllI.y - lIIIIllIIlIllI.fontRenderer.FONT_HEIGHT * 2), (int)lIIIIllIIlIllI.width, (int)lIIIIllIIlIllI.height, (int)new Color(0, 0, 0, 150).getRGB());
        for (CSCategoryButton lIIIIllIIlIlll : lIIIIllIIlIllI.buttons) {
            lIIIIllIIlIlll.drawScreen(lIIIIllIIIllIl, lIIIIllIIIllII, lIIIIllIIIlIll);
        }
        Gui.drawRect((int)(lIIIIllIIlIllI.x + 65), (int)lIIIIllIIlIllI.y, (int)(lIIIIllIIlIllI.x + 67), (int)lIIIIllIIlIllI.height, (int)CatClient.getClientColor().getRGB());
        Gui.drawRect((int)(lIIIIllIIlIllI.x + 165), (int)lIIIIllIIlIllI.y, (int)(lIIIIllIIlIllI.x + 167), (int)lIIIIllIIlIllI.height, (int)CatClient.getClientColor().getRGB());
        lIIIIllIIlIllI.drawinfo(lIIIIllIIIllIl, lIIIIllIIIllII);
        super.drawScreen(lIIIIllIIIllIl, lIIIIllIIIllII, lIIIIllIIIlIll);
    }

    protected void keyTyped(char lIIIIlIllllIIl, int lIIIIlIllllIII) throws IOException {
        CSGOGui lIIIIlIlllllIl;
        for (CSCategoryButton lIIIIlIllllllI : lIIIIlIlllllIl.buttons) {
            lIIIIlIllllllI.keyTyped(lIIIIlIllllIIl, lIIIIlIllllIII);
        }
        super.keyTyped(lIIIIlIllllIIl, lIIIIlIllllIII);
    }

    public CSGOGui() {
        CSGOGui lIIIIllIlllIll;
        lIIIIllIlllIll.buttons = new ArrayList();
        lIIIIllIlllIll.sr = new ScaledResolution(Minecraft.getMinecraft());
        lIIIIllIlllIll.x = 100;
        lIIIIllIlllIll.y = 70;
        lIIIIllIlllIll.width = lIIIIllIlllIll.sr.getScaledWidth() - 140;
        lIIIIllIlllIll.height = lIIIIllIlllIll.sr.getScaledHeight() - 140;
        lIIIIllIlllIll.x = 100;
        lIIIIllIlllIll.y = 70;
        lIIIIllIlllIll.width = lIIIIllIlllIll.sr.getScaledWidth() - 140;
        lIIIIllIlllIll.height = lIIIIllIlllIll.sr.getScaledHeight() - 140;
    }

    public boolean doesGuiPauseGame() {
        return false;
    }

    protected void mouseReleased(int lIIIIlIIllIIlI, int lIIIIlIIllIIIl, int lIIIIlIIllIlII) {
        CSGOGui lIIIIlIIllIIll;
        for (CSCategoryButton lIIIIlIIlllIII : lIIIIlIIllIIll.buttons) {
            lIIIIlIIlllIII.mouseReleased(lIIIIlIIllIIlI, lIIIIlIIllIIIl, lIIIIlIIllIlII);
        }
        super.mouseReleased(lIIIIlIIllIIlI, lIIIIlIIllIIIl, lIIIIlIIllIlII);
    }

    public void initGui() {
        CSGOGui lIIIIlIIlIlIIl;
        lIIIIlIIlIlIIl.initButtons();
        lIIIIlIIlIlIIl.anim = 0.0f;
        lIIIIlIIlIlIIl.x = 100;
        lIIIIlIIlIlIIl.y = 70;
        lIIIIlIIlIlIIl.width = 355;
        lIIIIlIIlIlIIl.height = 320;
        for (CSCategoryButton lIIIIlIIlIlIlI : lIIIIlIIlIlIIl.buttons) {
            lIIIIlIIlIlIlI.initButton();
        }
        super.initGui();
    }

    private void initButtons() {
        CSGOGui lIIIIllIlIlIll;
        lIIIIllIlIlIll.buttons.clear();
        int lIIIIllIlIllIl = 110;
        int lIIIIllIlIllII = 70;
        for (Category lIIIIllIlIllll : Category.values()) {
            String lIIIIllIllIIIl = String.valueOf(new StringBuilder().append(lIIIIllIlIllll.name().substring(0, 1).toUpperCase()).append(lIIIIllIlIllll.name().substring(1, lIIIIllIlIllll.name().length()).toLowerCase()));
            CSCategoryButton lIIIIllIllIIII = new CSCategoryButton(lIIIIllIlIllIl, lIIIIllIlIllII, lIIIIllIlIlIll.mc.fontRenderer.getStringWidth(lIIIIllIllIIIl), lIIIIllIlIlIll.mc.fontRenderer.FONT_HEIGHT, -1, lIIIIllIllIIIl, lIIIIllIlIllll);
            lIIIIllIlIlIll.buttons.add(lIIIIllIllIIII);
            lIIIIllIlIllII += 15;
        }
    }

    protected void mouseClicked(int lIIIIlIlIIlIIl, int lIIIIlIlIIlIII, int lIIIIlIlIIIlll) throws IOException {
        CSGOGui lIIIIlIlIIIlIl;
        boolean lIIIIlIlIIIllI = true;
        for (CSCategoryButton lIIIIlIlIIlIll : lIIIIlIlIIIlIl.buttons) {
            if (lIIIIlIlIIlIll.isHovered(lIIIIlIlIIlIIl, lIIIIlIlIIlIII) && lIIIIlIlIIIlll == 0) {
                lIIIIlIlIIIllI = true;
                lIIIIlIlIIIlIl.currentCategory = lIIIIlIlIIlIll;
            }
            lIIIIlIlIIlIll.mouseClicked(lIIIIlIlIIlIIl, lIIIIlIlIIlIII, lIIIIlIlIIIlll);
        }
        super.mouseClicked(lIIIIlIlIIlIIl, lIIIIlIlIIlIII, lIIIIlIlIIIlll);
    }

    public void drawinfo(int lIIIIlIlIlllIl, int lIIIIlIllIIIlI) {
        CSGOGui lIIIIlIllIIlII;
        int lIIIIlIllIIIIl = 600;
        int lIIIIlIllIIIII = 100;
        int lIIIIlIlIlllll = 0;
        lIIIIlIllIIlII.fontRenderer.drawStringWithShadow("Friends", (float)(lIIIIlIllIIIIl + lIIIIlIllIIlII.fontRenderer.getStringWidth("Friends") / 2), (float)(lIIIIlIllIIIII - lIIIIlIllIIlII.fontRenderer.FONT_HEIGHT), CatClient.getClientColor().getRGB());
        RenderUtil.drawRect(lIIIIlIllIIIIl, lIIIIlIllIIIII, lIIIIlIllIIIIl + 100, lIIIIlIllIIIII + FriendManager.FRIENDS.size() * lIIIIlIllIIlII.fontRenderer.FONT_HEIGHT, new Color(50, 50, 50, 190).getRGB());
        RenderUtil.drawNewRect(lIIIIlIllIIIIl - 1, lIIIIlIllIIIII, lIIIIlIllIIIIl, lIIIIlIllIIIII + FriendManager.FRIENDS.size() * lIIIIlIllIIlII.fontRenderer.FONT_HEIGHT, CatClient.getClientColor().getRGB());
        RenderUtil.drawNewRect(lIIIIlIllIIIIl + 100 - 1, lIIIIlIllIIIII, lIIIIlIllIIIIl + 100, lIIIIlIllIIIII + FriendManager.FRIENDS.size() * lIIIIlIllIIlII.fontRenderer.FONT_HEIGHT, CatClient.getClientColor().getRGB());
        RenderUtil.drawGlow(lIIIIlIllIIIIl, lIIIIlIllIIIII - 1, lIIIIlIllIIIIl + 100, lIIIIlIllIIIII, CatClient.getClientColor().getRGB(), 250.0);
        RenderUtil.drawGlow(lIIIIlIllIIIIl, lIIIIlIllIIIII + FriendManager.FRIENDS.size() * lIIIIlIllIIlII.fontRenderer.FONT_HEIGHT - 1, lIIIIlIllIIIIl + 100, lIIIIlIllIIIII + FriendManager.FRIENDS.size() * lIIIIlIllIIlII.fontRenderer.FONT_HEIGHT, CatClient.getClientColor().getRGB(), 250.0);
        for (String lIIIIlIllIIlIl : FriendManager.friendsList) {
            int lIIIIlIllIlIIl = lIIIIlIllIIIIl;
            int lIIIIlIllIlIII = 100 + lIIIIlIllIIIIl;
            int lIIIIlIllIIlll = lIIIIlIlIlllll + lIIIIlIllIIIII;
            int lIIIIlIllIIllI = lIIIIlIlIlllll + lIIIIlIllIIlII.fontRenderer.FONT_HEIGHT + lIIIIlIllIIIII;
            if (lIIIIlIlIlllIl > lIIIIlIllIlIIl && lIIIIlIlIlllIl < lIIIIlIllIlIII && lIIIIlIllIIIlI > lIIIIlIllIIlll && lIIIIlIllIIIlI < lIIIIlIllIIllI) {
                lIIIIlIllIIlII.fontRenderer.drawString(lIIIIlIllIIlIl, lIIIIlIllIIIIl + 50 - lIIIIlIllIIlII.fontRenderer.getStringWidth(lIIIIlIllIIlIl) / 2, lIIIIlIlIlllll + lIIIIlIllIIIII, CatClient.getClientColor().getRGB());
                if (Mouse.isButtonDown((int)1)) {
                    FriendManager.removeFriend(lIIIIlIllIIlIl);
                    return;
                }
            } else {
                lIIIIlIllIIlII.fontRenderer.drawString(lIIIIlIllIIlIl, lIIIIlIllIIIIl + 50 - lIIIIlIllIIlII.fontRenderer.getStringWidth(lIIIIlIllIIlIl) / 2, lIIIIlIlIlllll + lIIIIlIllIIIII, Color.white.getRGB());
            }
            lIIIIlIlIlllll += lIIIIlIllIIlII.fontRenderer.FONT_HEIGHT;
        }
    }

    public ScaledResolution getScaledRes() {
        return new ScaledResolution(Minecraft.getMinecraft());
    }
}

