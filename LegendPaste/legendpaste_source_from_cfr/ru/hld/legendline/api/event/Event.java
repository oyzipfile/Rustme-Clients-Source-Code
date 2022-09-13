/*
 * Decompiled with CFR 0.150.
 */
package ru.hld.legendline.api.event;

import java.lang.reflect.InvocationTargetException;
import ru.hld.legendline.api.event.ArrayHelper;
import ru.hld.legendline.api.event.Data;
import ru.hld.legendline.api.event.EventManager;

public abstract class Event {
    private /* synthetic */ boolean cancelled;

    public Event() {
        Event lllllllllllllIlllIIlIIlIllllIIII;
    }

    private static void call(Event lllllllllllllIlllIIlIIlIllIllIlI) {
        ArrayHelper<Data> lllllllllllllIlllIIlIIlIllIllIIl = EventManager.get(lllllllllllllIlllIIlIIlIllIllIlI.getClass());
        if (lllllllllllllIlllIIlIIlIllIllIIl != null) {
            for (Data lllllllllllllIlllIIlIIlIllIllIll : lllllllllllllIlllIIlIIlIllIllIIl) {
                try {
                    lllllllllllllIlllIIlIIlIllIllIll.target.invoke(lllllllllllllIlllIIlIIlIllIllIll.source, lllllllllllllIlllIIlIIlIllIllIlI);
                }
                catch (IllegalAccessException lllllllllllllIlllIIlIIlIllIlllIl) {
                    lllllllllllllIlllIIlIIlIllIlllIl.printStackTrace();
                }
                catch (InvocationTargetException lllllllllllllIlllIIlIIlIllIlllII) {
                    lllllllllllllIlllIIlIIlIllIlllII.printStackTrace();
                }
            }
        }
    }

    public void setCancelled(boolean lllllllllllllIlllIIlIIlIlllIIIll) {
        lllllllllllllIlllIIlIIlIlllIIllI.cancelled = lllllllllllllIlllIIlIIlIlllIIIll;
    }

    public boolean isCancelled() {
        Event lllllllllllllIlllIIlIIlIlllIlIlI;
        return lllllllllllllIlllIIlIIlIlllIlIlI.cancelled;
    }

    public Event call() {
        Event lllllllllllllIlllIIlIIlIlllIllII;
        lllllllllllllIlllIIlIIlIlllIllII.cancelled = false;
        Event.call(lllllllllllllIlllIIlIIlIlllIllII);
        return lllllllllllllIlllIIlIIlIlllIllII;
    }
}

