/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils;

import akka.actor.Cancellable;
import ru.internali.utils.Event;

public abstract class EventCancellable
extends Event
implements Cancellable {
    private /* synthetic */ boolean cancelled;

    public EventCancellable() {
        EventCancellable lIIIIIlIIlIlII;
    }

    @Override
    public boolean isCancelled() {
        EventCancellable lIIIIIlIIlIIIl;
        return lIIIIIlIIlIIIl.cancelled;
    }

    @Override
    public void setCancelled(boolean lIIIIIlIIIllII) {
        lIIIIIlIIIllIl.cancelled = lIIIIIlIIIllII;
    }
}

