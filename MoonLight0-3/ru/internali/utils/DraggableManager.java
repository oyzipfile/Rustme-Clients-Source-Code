/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils;

import java.util.ArrayList;
import ru.internali.utils.DraggableModule;
import ru.internali.utils.IndicatorsComponent;

public class DraggableManager {
    public /* synthetic */ ArrayList<DraggableModule> mods;

    public void setMods(ArrayList<DraggableModule> lIIIllllIIIIlI) {
        lIIIllllIIIIIl.mods = lIIIllllIIIIlI;
    }

    public DraggableManager() {
        DraggableManager lIIIllllIIlIlI;
        lIIIllllIIlIlI.mods = new ArrayList();
        lIIIllllIIlIlI.mods.add(new IndicatorsComponent());
    }

    public ArrayList<DraggableModule> getMods() {
        DraggableManager lIIIllllIIIllI;
        return lIIIllllIIIllI.mods;
    }
}

