/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils;

import ru.internali.settings.Setting;

public class FloatSetting
extends Setting {
    private /* synthetic */ float value;
    private final /* synthetic */ float min;
    private final /* synthetic */ float max;
    private final /* synthetic */ float step;

    public FloatSetting(String lIlIllIIIIllIll, String lIlIllIIIIllIlI, float lIlIllIIIIllIIl, float lIlIllIIIIlIIlI, float lIlIllIIIIlIlll) {
        lIlIllIIIIlllII(lIlIllIIIIllIll, lIlIllIIIIllIlI, lIlIllIIIIllIIl, lIlIllIIIIlIIlI, lIlIllIIIIlIlll, 0.1f);
        FloatSetting lIlIllIIIIlllII;
    }

    public FloatSetting(String lIlIllIIIIIlIll, String lIlIllIIIIIIllI, float lIlIllIIIIIlIIl) {
        lIlIllIIIIIlIII(lIlIllIIIIIlIll, lIlIllIIIIIIllI, lIlIllIIIIIlIIl, 0.0f, 10.0f, 0.1f);
        FloatSetting lIlIllIIIIIlIII;
    }

    public float getValue() {
        FloatSetting lIlIllIIIIIIIll;
        return lIlIllIIIIIIIll.value;
    }

    public float getStep() {
        FloatSetting lIlIlIllllIllIl;
        return lIlIlIllllIllIl.step;
    }

    @Override
    public double getMax() {
        FloatSetting lIlIlIlllllIIII;
        return lIlIlIlllllIIII.max;
    }

    public FloatSetting(String lIlIllIIIlIllll, String lIlIllIIIlIIlll, float lIlIllIIIlIIllI, float lIlIllIIIlIllII, float lIlIllIIIlIlIll, float lIlIllIIIlIlIlI) {
        super(lIlIllIIIlIllll, lIlIllIIIlIIlll);
        FloatSetting lIlIllIIIllIIII;
        lIlIllIIIllIIII.value = lIlIllIIIlIIllI;
        lIlIllIIIllIIII.min = lIlIllIIIlIllII;
        lIlIllIIIllIIII.max = lIlIllIIIlIlIll;
        lIlIllIIIllIIII.step = lIlIllIIIlIlIlI;
    }

    @Override
    public double getMin() {
        FloatSetting lIlIlIlllllIlII;
        return lIlIlIlllllIlII.min;
    }

    public boolean setValueWithStep(float lIlIlIllllllIII) {
        FloatSetting lIlIlIllllllIIl;
        return lIlIlIllllllIIl.setValue(lIlIlIllllllIIl.step * (float)Math.round(lIlIlIllllllIII / lIlIlIllllllIIl.step));
    }

    public boolean setValue(float lIlIlIlllllllII) {
        FloatSetting lIlIlIlllllllIl;
        if (lIlIlIlllllllII >= lIlIlIlllllllIl.min && lIlIlIlllllllII <= lIlIlIlllllllIl.max) {
            lIlIlIlllllllIl.value = lIlIlIlllllllII;
            return true;
        }
        return false;
    }
}

