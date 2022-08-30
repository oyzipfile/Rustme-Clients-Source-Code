/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.settings;

import ru.internali.settings.Setting;

public class EnumSetting
extends Setting {
    private /* synthetic */ Enum<?> currentValue;
    private final /* synthetic */ Enum<?>[] values;

    public String getCurrentValueName() {
        EnumSetting lllIIIllIIlIII;
        return lllIIIllIIlIII.currentValue.toString();
    }

    public boolean setValueFromName(String lllIIIllIlIIII) {
        EnumSetting lllIIIllIlIIIl;
        for (Enum<?> lllIIIllIlIIlI : lllIIIllIlIIIl.values) {
            if (!lllIIIllIlIIII.equalsIgnoreCase(lllIIIllIlIIlI.toString())) continue;
            lllIIIllIlIIIl.setCurrentValue(lllIIIllIlIIlI);
            return true;
        }
        return false;
    }

    public void setCurrentValue(Enum<?> lllIIIllIllIIl) {
        lllIIIllIlllII.currentValue = lllIIIllIllIIl;
    }

    public EnumSetting(String lllIIIlllIllIl, String lllIIIlllIIlll, Enum<?>[] lllIIIlllIlIll, Enum<?> lllIIIlllIIlIl) {
        super(lllIIIlllIllIl, lllIIIlllIIlll);
        EnumSetting lllIIIlllIlllI;
        lllIIIlllIlllI.values = lllIIIlllIlIll;
        lllIIIlllIlllI.currentValue = lllIIIlllIIlIl;
    }

    public Enum<?>[] getValues() {
        EnumSetting lllIIIlllIIIlI;
        return lllIIIlllIIIlI.values;
    }

    public Enum<?> getCurrentValue() {
        EnumSetting lllIIIllIlllll;
        return lllIIIllIlllll.currentValue;
    }
}

