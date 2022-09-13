/*
 * Decompiled with CFR 0.150.
 */
package ru.hld.legendline.api.event;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import ru.hld.legendline.api.event.ArrayHelper;
import ru.hld.legendline.api.event.Data;
import ru.hld.legendline.api.event.Event;
import ru.hld.legendline.api.event.EventTarget;
import ru.hld.legendline.api.event.Priority;

public class EventManager {
    private static final /* synthetic */ Map<Class<? extends Event>, ArrayHelper<Data>> REGISTRY_MAP;

    private static boolean isMethodBad(Method llllllllllllllllIlIllIlllIIllIlI, Class<? extends Event> llllllllllllllllIlIllIlllIIllIIl) {
        return EventManager.isMethodBad(llllllllllllllllIlIllIlllIIllIlI) || llllllllllllllllIlIllIlllIIllIlI.getParameterTypes()[0].equals(llllllllllllllllIlIllIlllIIllIIl);
    }

    public static void shutdown() {
        REGISTRY_MAP.clear();
    }

    public void unregister(Object llllllllllllllllIlIllIllllIlIlll) {
        EventManager llllllllllllllllIlIllIllllIllIlI;
        for (ArrayHelper<Data> llllllllllllllllIlIllIllllIllIll : REGISTRY_MAP.values()) {
            for (Data llllllllllllllllIlIllIllllIlllII : llllllllllllllllIlIllIllllIllIll) {
                if (!llllllllllllllllIlIllIllllIlllII.source.equals(llllllllllllllllIlIllIllllIlIlll)) continue;
                llllllllllllllllIlIllIllllIllIll.remove(llllllllllllllllIlIllIllllIlllII);
            }
        }
        llllllllllllllllIlIllIllllIllIlI.cleanMap(true);
    }

    static {
        REGISTRY_MAP = new HashMap<Class<? extends Event>, ArrayHelper<Data>>();
    }

    public void removeEnty(Class<? extends Event> llllllllllllllllIlIllIlllIlllIlI) {
        Iterator<Map.Entry<Class<? extends Event>, ArrayHelper<Data>>> llllllllllllllllIlIllIlllIlllIIl = REGISTRY_MAP.entrySet().iterator();
        while (llllllllllllllllIlIllIlllIlllIIl.hasNext()) {
            if (!llllllllllllllllIlIllIlllIlllIIl.next().getKey().equals(llllllllllllllllIlIllIlllIlllIlI)) continue;
            llllllllllllllllIlIllIlllIlllIIl.remove();
            break;
        }
    }

    private void register(Method llllllllllllllllIlIllIlllllIlIll, Object llllllllllllllllIlIllIlllllIIlIl) {
        EventManager llllllllllllllllIlIllIlllllIllII;
        Class<?> llllllllllllllllIlIllIlllllIlIIl = llllllllllllllllIlIllIlllllIlIll.getParameterTypes()[0];
        final Data llllllllllllllllIlIllIlllllIlIII = new Data(llllllllllllllllIlIllIlllllIIlIl, llllllllllllllllIlIllIlllllIlIll, llllllllllllllllIlIllIlllllIlIll.getAnnotation(EventTarget.class).value());
        if (!llllllllllllllllIlIllIlllllIlIII.target.isAccessible()) {
            llllllllllllllllIlIllIlllllIlIII.target.setAccessible(true);
        }
        if (REGISTRY_MAP.containsKey(llllllllllllllllIlIllIlllllIlIIl)) {
            if (!REGISTRY_MAP.get(llllllllllllllllIlIllIlllllIlIIl).contains(llllllllllllllllIlIllIlllllIlIII)) {
                REGISTRY_MAP.get(llllllllllllllllIlIllIlllllIlIIl).add(llllllllllllllllIlIllIlllllIlIII);
                llllllllllllllllIlIllIlllllIllII.sortListValue(llllllllllllllllIlIllIlllllIlIIl);
            }
        } else {
            REGISTRY_MAP.put(llllllllllllllllIlIllIlllllIlIIl, new ArrayHelper<Data>(){
                {
                    1 llllllllllllllIIIIIIlIlIllIIIlII;
                    llllllllllllllIIIIIIlIlIllIIIlII.add(llllllllllllllIIIIIIlIlIllIIIlII.llllllllllllllllIlIllIlllllIlIII);
                }
            });
        }
    }

    private static boolean isMethodBad(Method llllllllllllllllIlIllIlllIIlllll) {
        return llllllllllllllllIlIllIlllIIlllll.getParameterTypes().length != 1 || !llllllllllllllllIlIllIlllIIlllll.isAnnotationPresent(EventTarget.class);
    }

    public void register(Object llllllllllllllllIlIlllIIIIIIlIII) {
        for (Method llllllllllllllllIlIlllIIIIIIllII : llllllllllllllllIlIlllIIIIIIlIII.getClass().getDeclaredMethods()) {
            EventManager llllllllllllllllIlIlllIIIIIIlIll;
            if (EventManager.isMethodBad(llllllllllllllllIlIlllIIIIIIllII)) continue;
            llllllllllllllllIlIlllIIIIIIlIll.register(llllllllllllllllIlIlllIIIIIIllII, llllllllllllllllIlIlllIIIIIIlIII);
        }
    }

    public void unregister(Object llllllllllllllllIlIllIllllIIlIll, Class<? extends Event> llllllllllllllllIlIllIllllIIIlll) {
        if (REGISTRY_MAP.containsKey(llllllllllllllllIlIllIllllIIIlll)) {
            EventManager llllllllllllllllIlIllIllllIIlIIl;
            for (Data llllllllllllllllIlIllIllllIIllIl : REGISTRY_MAP.get(llllllllllllllllIlIllIllllIIIlll)) {
                if (!llllllllllllllllIlIllIllllIIllIl.source.equals(llllllllllllllllIlIllIllllIIlIll)) continue;
                REGISTRY_MAP.get(llllllllllllllllIlIllIllllIIIlll).remove(llllllllllllllllIlIllIllllIIllIl);
            }
            llllllllllllllllIlIllIllllIIlIIl.cleanMap(true);
        }
    }

    public void register(Object llllllllllllllllIlIllIlllllllIlI, Class<? extends Event> llllllllllllllllIlIllIllllllIllI) {
        for (Method llllllllllllllllIlIllIllllllllII : llllllllllllllllIlIllIlllllllIlI.getClass().getDeclaredMethods()) {
            EventManager llllllllllllllllIlIllIlllllllIll;
            if (EventManager.isMethodBad(llllllllllllllllIlIllIllllllllII, llllllllllllllllIlIllIllllllIllI)) continue;
            llllllllllllllllIlIllIlllllllIll.register(llllllllllllllllIlIllIllllllllII, llllllllllllllllIlIllIlllllllIlI);
        }
    }

    public EventManager() {
        EventManager llllllllllllllllIlIlllIIIIIlIlII;
    }

    public static ArrayHelper<Data> get(Class<? extends Event> llllllllllllllllIlIllIlllIIlIlll) {
        return REGISTRY_MAP.get(llllllllllllllllIlIllIlllIIlIlll);
    }

    private void sortListValue(Class<? extends Event> llllllllllllllllIlIllIlllIlIlIll) {
        ArrayHelper<Data> llllllllllllllllIlIllIlllIlIlIlI = new ArrayHelper<Data>();
        for (byte llllllllllllllllIlIllIlllIlIllIl : Priority.VALUE_ARRAY) {
            for (Data llllllllllllllllIlIllIlllIlIlllI : REGISTRY_MAP.get(llllllllllllllllIlIllIlllIlIlIll)) {
                if (llllllllllllllllIlIllIlllIlIlllI.priority != llllllllllllllllIlIllIlllIlIllIl) continue;
                llllllllllllllllIlIllIlllIlIlIlI.add(llllllllllllllllIlIllIlllIlIlllI);
            }
        }
        REGISTRY_MAP.put(llllllllllllllllIlIllIlllIlIlIll, llllllllllllllllIlIllIlllIlIlIlI);
    }

    public void cleanMap(boolean llllllllllllllllIlIllIlllIllllll) {
        Iterator<Map.Entry<Class<? extends Event>, ArrayHelper<Data>>> llllllllllllllllIlIllIllllIIIIII = REGISTRY_MAP.entrySet().iterator();
        while (llllllllllllllllIlIllIllllIIIIII.hasNext()) {
            if (llllllllllllllllIlIllIlllIllllll && !llllllllllllllllIlIllIllllIIIIII.next().getValue().isEmpty()) continue;
            llllllllllllllllIlIllIllllIIIIII.remove();
        }
    }
}

