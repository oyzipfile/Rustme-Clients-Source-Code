/*
 * Decompiled with CFR 0.150.
 */
package clickgui.setting;

import java.util.ArrayList;
import ru.internali.module.Module;

public class Setting {
    private /* synthetic */ String mode;
    private /* synthetic */ double min;
    private /* synthetic */ String sval;
    private /* synthetic */ double dval;
    private /* synthetic */ boolean bval;
    private /* synthetic */ double max;
    private /* synthetic */ ArrayList<String> options;
    private /* synthetic */ Module parent;
    private /* synthetic */ String name;
    private /* synthetic */ boolean onlyint;

    public double getValDouble() {
        Setting lllIIlIIIIlll;
        if (lllIIlIIIIlll.onlyint) {
            lllIIlIIIIlll.dval = (int)lllIIlIIIIlll.dval;
        }
        return lllIIlIIIIlll.dval;
    }

    public double getMin() {
        Setting lllIIIllllllI;
        return lllIIIllllllI.min;
    }

    public String getValString() {
        Setting lllIIlIIlllII;
        return lllIIlIIlllII.sval;
    }

    public boolean isSlider() {
        Setting lllIIIlllIIIl;
        return lllIIIlllIIIl.mode.equalsIgnoreCase("Slider");
    }

    public boolean isCombo() {
        Setting lllIIIlllIlll;
        return lllIIIlllIlll.mode.equalsIgnoreCase("Combo");
    }

    public String getName() {
        Setting lllIIlIlIIIlI;
        return lllIIlIlIIIlI.name;
    }

    public Setting(String lllIIllIIIIlI, Module lllIIlIllllIl, boolean lllIIllIIIIII) {
        Setting lllIIlIllllll;
        lllIIlIllllll.onlyint = false;
        lllIIlIllllll.name = lllIIllIIIIlI;
        lllIIlIllllll.parent = lllIIlIllllIl;
        lllIIlIllllll.bval = lllIIllIIIIII;
        lllIIlIllllll.mode = "Check";
    }

    public boolean isCheck() {
        Setting lllIIIlllIlII;
        return lllIIIlllIlII.mode.equalsIgnoreCase("Check");
    }

    public ArrayList<String> getOptions() {
        Setting lllIIlIIlIIll;
        return lllIIlIIlIIll.options;
    }

    public Setting(String lllIIlIllIIll, Module lllIIlIllIIlI, double lllIIlIlIlIlI, double lllIIlIlIlIIl, double lllIIlIlIlIII, boolean lllIIlIlIIlll) {
        Setting lllIIlIlIllIl;
        lllIIlIlIllIl.onlyint = false;
        lllIIlIlIllIl.name = lllIIlIllIIll;
        lllIIlIlIllIl.parent = lllIIlIllIIlI;
        lllIIlIlIllIl.dval = lllIIlIlIlIlI;
        lllIIlIlIllIl.min = lllIIlIlIlIIl;
        lllIIlIlIllIl.max = lllIIlIlIlIII;
        lllIIlIlIllIl.onlyint = lllIIlIlIIlll;
        lllIIlIlIllIl.mode = "Slider";
    }

    public boolean getValBoolean() {
        Setting lllIIlIIlIIII;
        return lllIIlIIlIIII.bval;
    }

    public Module getParentMod() {
        Setting lllIIlIIllllI;
        return lllIIlIIllllI.parent;
    }

    public void setValString(String lllIIlIIlIlIl) {
        lllIIlIIllIII.sval = lllIIlIIlIlIl;
    }

    public Setting() {
        Setting lllIIlIlIIlII;
        lllIIlIlIIlII.onlyint = false;
    }

    public void setValBoolean(boolean lllIIlIIIlIll) {
        lllIIlIIIllII.bval = lllIIlIIIlIll;
    }

    public Setting(String lllIIllIlIIII, Module lllIIllIIllll, String lllIIllIIlIIl, ArrayList<String> lllIIllIIllIl) {
        Setting lllIIllIIllII;
        lllIIllIIllII.onlyint = false;
        lllIIllIIllII.name = lllIIllIlIIII;
        lllIIllIIllII.parent = lllIIllIIllll;
        lllIIllIIllII.sval = lllIIllIIlIIl;
        lllIIllIIllII.options = lllIIllIIllIl;
        lllIIllIIllII.mode = "Combo";
    }

    public double getMax() {
        Setting lllIIIllllIll;
        return lllIIIllllIll.max;
    }

    public void setValDouble(double lllIIlIIIIIlI) {
        lllIIlIIIIIll.dval = lllIIlIIIIIlI;
    }

    public boolean onlyInt() {
        Setting lllIIIllIllll;
        return lllIIIllIllll.onlyint;
    }
}

