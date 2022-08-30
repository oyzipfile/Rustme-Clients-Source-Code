/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils;

import java.util.ArrayList;
import ru.internali.module.Module;
import ru.internali.settings.Setting;

public class NumberSetting
extends Setting {
    private /* synthetic */ float current;
    private /* synthetic */ float minimum;
    private /* synthetic */ float maximum;
    private /* synthetic */ String desc;
    private /* synthetic */ float increment;

    public float getNumberValue() {
        NumberSetting lllIllIIIlllIII;
        return lllIllIIIlllIII.current;
    }

    public void setMaxValue(float lllIllIIIllllII) {
        lllIllIIIllllIl.maximum = lllIllIIIllllII;
    }

    public float getIncrement() {
        NumberSetting lllIllIIIlIlllI;
        return lllIllIIIlIlllI.increment;
    }

    public void setIncrement(float lllIllIIIlIlIlI) {
        lllIllIIIlIlIIl.increment = lllIllIIIlIlIlI;
    }

    public String getDesc() {
        NumberSetting lllIllIIlIlIIlI;
        return lllIllIIlIlIIlI.desc;
    }

    @Override
    public float getMaxValue() {
        NumberSetting lllIllIIlIIIIIl;
        return lllIllIIlIIIIIl.maximum;
    }

    @Override
    public float getMinValue() {
        NumberSetting lllIllIIlIIlIlI;
        return lllIllIIlIIlIlI.minimum;
    }

    public void setValueNumber(float lllIllIIIllIIll) {
        lllIllIIIllIIlI.current = lllIllIIIllIIll;
    }

    public void setDesc(String lllIllIIlIIlllI) {
        lllIllIIlIIllIl.desc = lllIllIIlIIlllI;
    }

    public void setMinValue(float lllIllIIlIIIlIl) {
        lllIllIIlIIIlII.minimum = lllIllIIlIIIlIl;
    }

    public NumberSetting(String lllIllIIlIllIII, Module lllIllIIlIlllII, String lllIllIIlIlIllI, ArrayList<String> lllIllIIlIlIlIl) {
        super(lllIllIIlIllIII, lllIllIIlIlllII, lllIllIIlIlIllI, lllIllIIlIlIlIl);
        NumberSetting lllIllIIlIllIIl;
    }

    public static enum NumberType {
        MS("Ms"),
        APS("Aps"),
        SIZE("Size"),
        PERCENTAGE("Percentage"),
        DISTANCE("Distance"),
        DEFAULT("");

        /* synthetic */ String name;

        public String getName() {
            NumberType lllIlIlIlIllll;
            return lllIlIlIlIllll.name;
        }

        private NumberType(String lllIlIlIllIIIl) {
            NumberType lllIlIlIllIlII;
            lllIlIlIllIlII.name = lllIlIlIllIIIl;
        }
    }
}

