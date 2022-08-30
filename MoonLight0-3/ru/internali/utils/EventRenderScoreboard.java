/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils;

import ru.internali.utils.Event;
import ru.internali.utils.EventType;

public class EventRenderScoreboard
extends Event {
    private /* synthetic */ EventType state;

    public boolean isPre() {
        EventRenderScoreboard lIIllIlIllIllI;
        return lIIllIlIllIllI.state == EventType.PRE;
    }

    public EventRenderScoreboard(EventType lIIllIllIIIlII) {
        EventRenderScoreboard lIIllIllIIIlIl;
        lIIllIllIIIlIl.state = lIIllIllIIIlII;
    }

    public void setState(EventType lIIllIlIlllIll) {
        lIIllIlIllllII.state = lIIllIlIlllIll;
    }

    public EventType getState() {
        EventRenderScoreboard lIIllIllIIIIII;
        return lIIllIllIIIIII.state;
    }
}

