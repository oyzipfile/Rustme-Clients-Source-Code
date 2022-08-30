/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils;

import java.lang.reflect.InvocationTargetException;
import ru.internali.CatClient;
import ru.internali.utils.ArrayHelper;
import ru.internali.utils.Data;
import ru.internali.utils.EventManager;

public abstract class Event {
    private /* synthetic */ boolean cancelled;

    public void setCancelled(boolean llllllllIIlllll) {
        llllllllIlIIIlI.cancelled = llllllllIIlllll;
    }

    public Event call() {
        Event llllllllIlIlIIl;
        llllllllIlIlIIl.cancelled = false;
        Event.call(llllllllIlIlIIl);
        return llllllllIlIlIIl;
    }

    public boolean isCancelled() {
        Event llllllllIlIIllI;
        return llllllllIlIIllI.cancelled;
    }

    public Event() {
        Event llllllllIlIllII;
    }

    private static void call(Event llllllllIIlIIIl) {
        EventManager llllllllIIlIIll = CatClient.eventManager;
        ArrayHelper<Data> llllllllIIlIIlI = EventManager.get(llllllllIIlIIIl.getClass());
        if (llllllllIIlIIlI != null) {
            for (Data llllllllIIlIllI : llllllllIIlIIlI) {
                try {
                    llllllllIIlIllI.target.invoke(llllllllIIlIllI.source, llllllllIIlIIIl);
                }
                catch (IllegalAccessException llllllllIIllIII) {
                    llllllllIIllIII.printStackTrace();
                }
                catch (InvocationTargetException llllllllIIlIlll) {
                    llllllllIIlIlll.printStackTrace();
                }
            }
        }
    }
}

