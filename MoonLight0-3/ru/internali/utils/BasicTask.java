/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils;

import ru.internali.utils.Task;

public abstract class BasicTask
implements Task {
    private /* synthetic */ String name;
    private /* synthetic */ int priority;
    private /* synthetic */ boolean online;

    public void setPriority(int lIllIIIIlIIllI) {
        lIllIIIIlIIlll.priority = lIllIIIIlIIllI;
    }

    @Override
    public void setOnline(boolean lIllIIIIllIllI) {
        lIllIIIIlllIIl.online = lIllIIIIllIllI;
    }

    public void setName(String lIllIIIIlIllll) {
        lIllIIIIllIIII.name = lIllIIIIlIllll;
    }

    public BasicTask(String lIllIIIlIIIIII, int lIllIIIlIIIIlI) {
        BasicTask lIllIIIlIIIlII;
        lIllIIIlIIIlII.name = lIllIIIlIIIIII;
        lIllIIIlIIIlII.priority = lIllIIIlIIIIlI;
    }

    @Override
    public boolean isOnline() {
        BasicTask lIllIIIIllllIl;
        return lIllIIIIllllIl.online;
    }

    public String getName() {
        BasicTask lIllIIIIllIlII;
        return lIllIIIIllIlII.name;
    }

    public int getPriority() {
        BasicTask lIllIIIIlIlIll;
        return lIllIIIIlIlIll.priority;
    }
}

