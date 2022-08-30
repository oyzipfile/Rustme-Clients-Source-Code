/*
 * Decompiled with CFR 0.150.
 */
package new_gui.setting;

import java.util.ArrayList;
import ru.internali.module.Module;

public class Setting {
    private /* synthetic */ boolean bval;
    private /* synthetic */ double min;
    private /* synthetic */ boolean onlyint;
    private /* synthetic */ String mode;
    private /* synthetic */ ArrayList<String> options;
    private /* synthetic */ String name;
    public /* synthetic */ double standarddval;
    private /* synthetic */ double max;
    private /* synthetic */ String sval;
    public /* synthetic */ String standardsval;
    public /* synthetic */ String displayName;
    private /* synthetic */ double dval;
    private /* synthetic */ Module parent;
    public /* synthetic */ boolean standardbval;

    public void setValDouble(double lIllIlllIIllll) {
        lIllIlllIlIIII.dval = lIllIlllIIllll;
    }

    public double getMax() {
        Setting lIllIlllIIlIII;
        return lIllIlllIIlIII.max;
    }

    public Setting(String lIlllIIIIlllII, String lIlllIIIIllIll, Module lIlllIIIIllIlI, String lIlllIIIIlllll, ArrayList<String> lIlllIIIIllllI) {
        Setting lIlllIIIlIIIll;
        lIlllIIIlIIIll.onlyint = false;
        lIlllIIIlIIIll.name = lIlllIIIIlllII;
        lIlllIIIlIIIll.displayName = lIlllIIIIllIll;
        lIlllIIIlIIIll.parent = lIlllIIIIllIlI;
        lIlllIIIlIIIll.sval = lIlllIIIIlllll;
        lIlllIIIlIIIll.standardsval = lIlllIIIIlllll;
        lIlllIIIlIIIll.options = lIlllIIIIllllI;
        lIlllIIIlIIIll.mode = "Combo";
    }

    public boolean getValBoolean() {
        Setting lIllIlllIlllIl;
        return lIllIlllIlllIl.bval;
    }

    public Module getParentMod() {
        Setting lIllIllllIlIll;
        return lIllIllllIlIll.parent;
    }

    public boolean isCombo() {
        Setting lIllIlllIIIlII;
        return lIllIlllIIIlII.mode.equalsIgnoreCase("Combo");
    }

    public void setValString(String lIllIllllIIIlI) {
        lIllIllllIIIll.sval = lIllIllllIIIlI;
    }

    public String getValString() {
        Setting lIllIllllIlIIl;
        return lIllIllllIlIIl.sval;
    }

    public Setting(String lIllIlllllIlll, String lIllIlllllIllI, Module lIllIlllllllIl, double lIllIlllllIlII, double lIllIlllllIIll, double lIllIlllllIIlI, boolean lIllIlllllIIIl) {
        Setting lIlllIIIIIIIII;
        lIlllIIIIIIIII.onlyint = false;
        lIlllIIIIIIIII.name = lIllIlllllIlll;
        lIlllIIIIIIIII.displayName = lIllIlllllIllI;
        lIlllIIIIIIIII.parent = lIllIlllllllIl;
        lIlllIIIIIIIII.dval = lIllIlllllIlII;
        lIlllIIIIIIIII.standarddval = lIllIlllllIlII;
        lIlllIIIIIIIII.min = lIllIlllllIIll;
        lIlllIIIIIIIII.max = lIllIlllllIIlI;
        lIlllIIIIIIIII.onlyint = lIllIlllllIIIl;
        lIlllIIIIIIIII.mode = "Slider";
    }

    public double getValDouble() {
        Setting lIllIlllIlIlII;
        if (lIllIlllIlIlII.onlyint) {
            lIllIlllIlIlII.dval = (int)lIllIlllIlIlII.dval;
        }
        return lIllIlllIlIlII.dval;
    }

    public boolean isCheck() {
        Setting lIllIlllIIIIIl;
        return lIllIlllIIIIIl.mode.equalsIgnoreCase("Check");
    }

    public double getMin() {
        Setting lIllIlllIIlIll;
        return lIllIlllIIlIll.min;
    }

    public ArrayList<String> getOptions() {
        Setting lIllIlllIlllll;
        return lIllIlllIlllll.options;
    }

    public boolean onlyInt() {
        Setting lIllIllIlllIll;
        return lIllIllIlllIll.onlyint;
    }

    public Setting(String lIlllIIIIIllII, String lIlllIIIIIlIll, Module lIlllIIIIIlIlI, boolean lIlllIIIIIlIIl) {
        Setting lIlllIIIIIllIl;
        lIlllIIIIIllIl.onlyint = false;
        lIlllIIIIIllIl.name = lIlllIIIIIllII;
        lIlllIIIIIllIl.displayName = lIlllIIIIIlIll;
        lIlllIIIIIllIl.standardbval = lIlllIIIIIlIIl;
        lIlllIIIIIllIl.parent = lIlllIIIIIlIlI;
        lIlllIIIIIllIl.bval = lIlllIIIIIlIIl;
        lIlllIIIIIllIl.mode = "Check";
    }

    public String getName() {
        Setting lIllIllllIlllI;
        return lIllIllllIlllI.name;
    }

    public void setValBoolean(boolean lIllIlllIlIllI) {
        lIllIlllIlIlll.bval = lIllIlllIlIllI;
    }

    public boolean isSlider() {
        Setting lIllIllIlllllI;
        return lIllIllIlllllI.mode.equalsIgnoreCase("Slider");
    }
}

