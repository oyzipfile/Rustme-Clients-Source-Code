/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import ru.internali.utils.ArrayHelper;
import ru.internali.utils.Data;
import ru.internali.utils.Event;
import ru.internali.utils.EventTarget;

public class EventManager {
    private static final /* synthetic */ Map<Class<? extends Event>, ArrayHelper<Data>> REGISTRY_MAP;

    public void unregister(Object lIlIlllIlllIIlI, Class<? extends Event> lIlIlllIlllIIIl) {
        if (REGISTRY_MAP.containsKey(lIlIlllIlllIIIl)) {
            for (Data lIlIlllIllllIII : REGISTRY_MAP.get(lIlIlllIlllIIIl)) {
                if (!lIlIlllIllllIII.source.equals(lIlIlllIlllIIlI)) continue;
                REGISTRY_MAP.get(lIlIlllIlllIIIl).remove(lIlIlllIllllIII);
            }
            EventManager.cleanMap(true);
        }
    }

    public static ArrayHelper<Data> get(Class<? extends Event> lIlIlllIlIlIlll) {
        return REGISTRY_MAP.get(lIlIlllIlIlIlll);
    }

    public static void shutdown() {
        REGISTRY_MAP.clear();
    }

    public void removeEnty(Class<? extends Event> lIlIlllIllIIIll) {
        Iterator<Map.Entry<Class<? extends Event>, ArrayHelper<Data>>> lIlIlllIllIIlII = REGISTRY_MAP.entrySet().iterator();
        while (lIlIlllIllIIlII.hasNext()) {
            if (!lIlIlllIllIIlII.next().getKey().equals(lIlIlllIllIIIll)) continue;
            lIlIlllIllIIlII.remove();
            break;
        }
    }

    private static boolean isMethodBad(Method lIlIlllIlIlllll) {
        return lIlIlllIlIlllll.getParameterTypes().length != 1 || !lIlIlllIlIlllll.isAnnotationPresent(EventTarget.class);
    }

    public static void unregister(Object lIlIllllIIIIlII) {
        for (ArrayHelper<Data> lIlIllllIIIIllI : REGISTRY_MAP.values()) {
            for (Data lIlIllllIIIIlll : lIlIllllIIIIllI) {
                if (!lIlIllllIIIIlll.source.equals(lIlIllllIIIIlII)) continue;
                lIlIllllIIIIllI.remove(lIlIllllIIIIlll);
            }
        }
        EventManager.cleanMap(true);
    }

    public static void cleanMap(boolean lIlIlllIllIllII) {
        Iterator<Map.Entry<Class<? extends Event>, ArrayHelper<Data>>> lIlIlllIllIlIll = REGISTRY_MAP.entrySet().iterator();
        while (lIlIlllIllIlIll.hasNext()) {
            if (lIlIlllIllIllII && !lIlIlllIllIlIll.next().getValue().isEmpty()) continue;
            lIlIlllIllIlIll.remove();
        }
        return;
    }

    private static boolean isMethodBad(Method lIlIlllIlIlllII, Class<? extends Event> lIlIlllIlIllIll) {
        return EventManager.isMethodBad(lIlIlllIlIlllII) || lIlIlllIlIlllII.getParameterTypes()[0].equals(lIlIlllIlIllIll);
    }

    public static void register(Object lIlIllllIIlIIlI, Class<? extends Event> lIlIllllIIlIIIl) {
        for (Method lIlIllllIIllIII : lIlIllllIIlIIlI.getClass().getDeclaredMethods()) {
            if (EventManager.isMethodBad(lIlIllllIIllIII, lIlIllllIIlIIIl)) continue;
            EventManager.register(lIlIllllIIllIII, (Class)lIlIllllIIlIIlI);
        }
    }

    public EventManager() {
        EventManager lIlIllllIlIllll;
    }

    public static void register(Object lIlIllllIlIIllI) {
        for (Method lIlIllllIlIlIII : lIlIllllIlIIllI.getClass().getDeclaredMethods()) {
            if (EventManager.isMethodBad(lIlIllllIlIlIII)) continue;
            EventManager.register(lIlIllllIlIlIII, (Class)lIlIllllIlIIllI);
        }
    }

    static {
        REGISTRY_MAP = new HashMap<Class<? extends Event>, ArrayHelper<Data>>();
    }
}

