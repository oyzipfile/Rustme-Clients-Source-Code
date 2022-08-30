/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils;

import java.util.Iterator;

public class ArrayHelper<T>
implements Iterable<T> {
    private /* synthetic */ T[] elements;

    public void remove(T lllllIlIIIlIIII) {
        ArrayHelper lllllIlIIIlIIll;
        if (lllllIlIIIlIIll.contains(lllllIlIIIlIIII)) {
            Object[] lllllIlIIIlIlIl = new Object[lllllIlIIIlIIll.size() - 1];
            boolean lllllIlIIIlIlII = true;
            for (int lllllIlIIIlIllI = 0; lllllIlIIIlIllI < lllllIlIIIlIIll.size(); ++lllllIlIIIlIllI) {
                if (lllllIlIIIlIlII && lllllIlIIIlIIll.get(lllllIlIIIlIllI).equals(lllllIlIIIlIIII)) {
                    lllllIlIIIlIlII = false;
                    continue;
                }
                lllllIlIIIlIlIl[lllllIlIIIlIlII ? lllllIlIIIlIllI : lllllIlIIIlIllI - 1] = lllllIlIIIlIIll.get(lllllIlIIIlIllI);
            }
            lllllIlIIIlIIll.set(lllllIlIIIlIlIl);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    public T get(int lllllIIlllllIll) {
        ArrayHelper lllllIIlllllllI;
        return lllllIIlllllllI.array()[lllllIIlllllIll];
    }

    public int size() {
        ArrayHelper lllllIlIIIIIlll;
        return lllllIlIIIIIlll.array().length;
    }

    public void clear() {
        lllllIIlllllIIl.elements = new Object[0];
    }

    public boolean contains(T lllllIlIIlIIlII) {
        ArrayHelper lllllIlIIlIIlIl;
        for (T lllllIlIIlIIlll : lllllIlIIlIIlIl.array()) {
            if (!lllllIlIIlIIlll.equals(lllllIlIIlIIlII)) continue;
            return true;
        }
        return false;
    }

    public void set(T[] lllllIlIIIIIIll) {
        lllllIlIIIIIIlI.elements = lllllIlIIIIIIll;
    }

    public ArrayHelper() {
        ArrayHelper lllllIlIIlllIlI;
        lllllIlIIlllIlI.elements = new Object[0];
    }

    public void add(T lllllIlIIllIIII) {
        if (lllllIlIIllIIII != null) {
            ArrayHelper lllllIlIIllIIll;
            Object[] lllllIlIIllIlII = new Object[lllllIlIIllIIll.size() + 1];
            for (int lllllIlIIllIlIl = 0; lllllIlIIllIlIl < lllllIlIIllIlII.length; ++lllllIlIIllIlIl) {
                lllllIlIIllIlII[lllllIlIIllIlIl] = lllllIlIIllIlIl < lllllIlIIllIIll.size() ? lllllIlIIllIIll.get(lllllIlIIllIlIl) : lllllIlIIllIIII;
            }
            lllllIlIIllIIll.set(lllllIlIIllIlII);
        }
    }

    public boolean isEmpty() {
        ArrayHelper lllllIIllllIlIl;
        return lllllIIllllIlIl.size() == 0;
    }

    public ArrayHelper(T[] lllllIlIIllllIl) {
        ArrayHelper lllllIlIlIIIIII;
        lllllIlIlIIIIII.elements = lllllIlIIllllIl;
    }

    public T[] array() {
        ArrayHelper lllllIlIIIIlIll;
        return lllllIlIIIIlIll.elements;
    }
}

