/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.settings;

import java.util.ArrayList;
import ru.internali.module.Module;

public class Setting
extends clickgui.setting.Setting {
    private /* synthetic */ Module parent;
    private /* synthetic */ boolean valueBoolean;
    private /* synthetic */ double min;
    /* synthetic */ Module module;
    private /* synthetic */ String name;
    private /* synthetic */ float valueNumeric;
    private /* synthetic */ String sval;
    private /* synthetic */ String[] values;
    private /* synthetic */ float maxValue;
    private /* synthetic */ float minValue;
    private /* synthetic */ String id;
    private /* synthetic */ boolean bval;
    private /* synthetic */ boolean onlyint;
    private /* synthetic */ ArrayList<String> options;
    private /* synthetic */ double max;
    private /* synthetic */ String valueString;
    private /* synthetic */ double dval;
    /* synthetic */ String descriptions;
    private /* synthetic */ String mode;

    @Override
    public void setValString(String lIlIIlIllIIIIIl) {
        lIlIIlIllIIIIlI.sval = lIlIIlIllIIIIIl;
    }

    @Override
    public Module getParentMod() {
        Setting lIlIIlIllIIlIll;
        return lIlIIlIllIIlIll.parent;
    }

    public float getValueNumeric() {
        Setting lIlIIlIlIlllIIl;
        return lIlIIlIlIlllIIl.valueNumeric;
    }

    public void setValueBoolean(boolean lIlIIlIlIlIIIII) {
        lIlIIlIlIlIIIll.valueBoolean = lIlIIlIlIlIIIII;
    }

    public void setValueNumeric(float lIlIIlIlIlIlllI) {
        lIlIIlIlIlIllll.valueNumeric = lIlIIlIlIlIlllI;
    }

    @Override
    public double getMax() {
        Setting lIlIIlIlIIIlllI;
        return lIlIIlIlIIIlllI.max;
    }

    public float getMaxValue() {
        Setting lIlIIlIIllIIlII;
        return lIlIIlIIllIIlII.maxValue;
    }

    public void setValueString(String lIlIIlIlIllIlII) {
        lIlIIlIlIllIIll.valueString = lIlIIlIlIllIlII;
    }

    public Setting(String lIlIIlIllIllIlI, String lIlIIlIllIllIIl) {
        Setting lIlIIlIllIllIll;
        lIlIIlIllIllIll.onlyint = false;
    }

    public Setting(String lIlIIllIIIIIIIl, Module lIlIIllIIIIIlIl, String lIlIIllIIIIIlII, ArrayList<String> lIlIIllIIIIIIll) {
        Setting lIlIIllIIIIIIlI;
        lIlIIllIIIIIIlI.onlyint = false;
        lIlIIllIIIIIIlI.name = lIlIIllIIIIIIIl;
        lIlIIllIIIIIIlI.parent = lIlIIllIIIIIlIl;
        lIlIIllIIIIIIlI.sval = lIlIIllIIIIIlII;
        lIlIIllIIIIIIlI.options = lIlIIllIIIIIIll;
        lIlIIllIIIIIIlI.mode = "Combo";
    }

    public String getDescriptions() {
        Setting lIlIIlIIlllIlII;
        return lIlIIlIIlllIlII.descriptions;
    }

    public Setting(String lIlIIlIlllllIII, Module lIlIIlIllllIIll, boolean lIlIIlIllllIllI) {
        Setting lIlIIlIlllllIIl;
        lIlIIlIlllllIIl.onlyint = false;
        lIlIIlIlllllIIl.name = lIlIIlIlllllIII;
        lIlIIlIlllllIIl.parent = lIlIIlIllllIIll;
        lIlIIlIlllllIIl.bval = lIlIIlIllllIllI;
        lIlIIlIlllllIIl.mode = "Check";
    }

    public String getId() {
        Setting lIlIIlIIllIIIlI;
        return lIlIIlIIllIIIlI.id;
    }

    public String getValueString() {
        Setting lIlIIlIIllIlIlI;
        return lIlIIlIIllIlIlI.valueString;
    }

    @Override
    public void setValDouble(double lIlIIlIlIIlIllI) {
        lIlIIlIlIIlIlll.dval = lIlIIlIlIIlIllI;
    }

    public float getValFloat() {
        Setting lIlIIlIlIIIIIII;
        if (lIlIIlIlIIIIIII.onlyint) {
            lIlIIlIlIIIIIII.dval = (int)lIlIIlIlIIIIIII.dval;
        }
        return (float)lIlIIlIlIIIIIII.dval;
    }

    @Override
    public boolean getValBoolean() {
        Setting lIlIIlIlIllllII;
        return lIlIIlIlIllllII.bval;
    }

    public Setting(String lIlIIlIlllIIIlI, Module lIlIIlIlllIIIIl, double lIlIIlIlllIIlll, double lIlIIlIllIlllll, double lIlIIlIlllIIlIl, boolean lIlIIlIllIlllIl) {
        Setting lIlIIlIlllIlIlI;
        lIlIIlIlllIlIlI.onlyint = false;
        lIlIIlIlllIlIlI.name = lIlIIlIlllIIIlI;
        lIlIIlIlllIlIlI.parent = lIlIIlIlllIIIIl;
        lIlIIlIlllIlIlI.dval = lIlIIlIlllIIlll;
        lIlIIlIlllIlIlI.min = lIlIIlIllIlllll;
        lIlIIlIlllIlIlI.max = lIlIIlIlllIIlIl;
        lIlIIlIlllIlIlI.onlyint = lIlIIlIllIlllIl;
        lIlIIlIlllIlIlI.mode = "Slider";
    }

    @Override
    public double getMin() {
        Setting lIlIIlIlIIlIIIl;
        return lIlIIlIlIIlIIIl.min;
    }

    public Setting(String lIlIIlIllIlIlIl, Module lIlIIlIllIlIlII, double lIlIIlIllIlIIll, float lIlIIlIllIlIIlI, float lIlIIlIllIlIIIl) {
        Setting lIlIIlIllIlIllI;
        lIlIIlIllIlIllI.onlyint = false;
    }

    public Module getModule() {
        Setting lIlIIlIIlllIlll;
        return lIlIIlIIlllIlll.module;
    }

    public boolean getValueBoolean() {
        Setting lIlIIlIlIIllllI;
        return lIlIIlIlIIllllI.valueBoolean;
    }

    @Override
    public double getValDouble() {
        Setting lIlIIlIlIIllIll;
        if (lIlIIlIlIIllIll.onlyint) {
            lIlIIlIlIIllIll.dval = (int)lIlIIlIlIIllIll.dval;
        }
        return lIlIIlIlIIllIll.dval;
    }

    public void setId(String lIlIIlIIllIllIl) {
        lIlIIlIIllIlllI.id = lIlIIlIIllIllIl;
    }

    @Override
    public boolean isSlider() {
        Setting lIlIIlIlIIIIlIl;
        return lIlIIlIlIIIIlIl.mode.equalsIgnoreCase("Slider");
    }

    @Override
    public String getName() {
        Setting lIlIIlIllIIlllI;
        return lIlIIlIllIIlllI.name;
    }

    @Override
    public void setValBoolean(boolean lIlIIlIlIlIIllI) {
        lIlIIlIlIlIIlll.bval = lIlIIlIlIlIIllI;
    }

    @Override
    public ArrayList<String> getOptions() {
        Setting lIlIIlIlIlllllI;
        return lIlIIlIlIlllllI.options;
    }

    @Override
    public boolean isCheck() {
        Setting lIlIIlIlIIIlIII;
        return lIlIIlIlIIIlIII.mode.equalsIgnoreCase("Check");
    }

    @Override
    public boolean isCombo() {
        Setting lIlIIlIlIIIlIll;
        return lIlIIlIlIIIlIll.mode.equalsIgnoreCase("Combo");
    }

    public float getMinValue() {
        Setting lIlIIlIIllIlIII;
        return lIlIIlIIllIlIII.minValue;
    }

    public void setValFloat(float lIlIIlIIllllIIl) {
        lIlIIlIIlllllII.dval = lIlIIlIIllllIIl;
    }

    @Override
    public String getValString() {
        Setting lIlIIlIllIIIlll;
        return lIlIIlIllIIIlll.sval;
    }

    @Override
    public boolean onlyInt() {
        Setting lIlIIlIlIIIIIlI;
        return lIlIIlIlIIIIIlI.onlyint;
    }
}

