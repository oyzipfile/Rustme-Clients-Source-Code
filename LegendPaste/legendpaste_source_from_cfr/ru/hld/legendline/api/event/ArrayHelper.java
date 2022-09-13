/*
 * Decompiled with CFR 0.150.
 */
package ru.hld.legendline.api.event;

import java.util.Iterator;

public class ArrayHelper<T>
implements Iterable<T> {
    private /* synthetic */ T[] elements;

    public void clear() {
        lllllllllllllllIIIIlIIlIllIllIll.elements = new Object[0];
    }

    public ArrayHelper(T[] lllllllllllllllIIIIlIIllIIlIIIlI) {
        ArrayHelper lllllllllllllllIIIIlIIllIIlIIIIl;
        lllllllllllllllIIIIlIIllIIlIIIIl.elements = lllllllllllllllIIIIlIIllIIlIIIlI;
    }

    @Override
    public Iterator<T> iterator() {
        ArrayHelper lllllllllllllllIIIIlIIlIllIlIllI;
        return new Iterator<T>(){
            private /* synthetic */ int index;

            @Override
            public boolean hasNext() {
                1 llllllllllllllIlIlllllIIIlIlIIII;
                return llllllllllllllIlIlllllIIIlIlIIII.index < llllllllllllllIlIlllllIIIlIlIIII.ArrayHelper.this.size() && llllllllllllllIlIlllllIIIlIlIIII.ArrayHelper.this.get(llllllllllllllIlIlllllIIIlIlIIII.index) != null;
            }

            @Override
            public T next() {
                1 llllllllllllllIlIlllllIIIlIIlllI;
                return llllllllllllllIlIlllllIIIlIIlllI.ArrayHelper.this.get(llllllllllllllIlIlllllIIIlIIlllI.index++);
            }
            {
                1 llllllllllllllIlIlllllIIIlIlIllI;
                llllllllllllllIlIlllllIIIlIlIllI.index = 0;
            }

            @Override
            public void remove() {
                1 llllllllllllllIlIlllllIIIlIIlIll;
                llllllllllllllIlIlllllIIIlIIlIll.ArrayHelper.this.remove(llllllllllllllIlIlllllIIIlIIlIll.ArrayHelper.this.get(llllllllllllllIlIlllllIIIlIIlIll.index));
            }
        };
    }

    public T[] array() {
        ArrayHelper lllllllllllllllIIIIlIIlIlllIlllI;
        return lllllllllllllllIIIIlIIlIlllIlllI.elements;
    }

    public int size() {
        ArrayHelper lllllllllllllllIIIIlIIlIlllIlIll;
        return lllllllllllllllIIIIlIIlIlllIlIll.array().length;
    }

    public void add(T lllllllllllllllIIIIlIIllIIIlIIll) {
        if (lllllllllllllllIIIIlIIllIIIlIIll != null) {
            ArrayHelper lllllllllllllllIIIIlIIllIIIlIlII;
            Object[] lllllllllllllllIIIIlIIllIIIlIlll = new Object[lllllllllllllllIIIIlIIllIIIlIlII.size() + 1];
            for (int lllllllllllllllIIIIlIIllIIIllIII = 0; lllllllllllllllIIIIlIIllIIIllIII < lllllllllllllllIIIIlIIllIIIlIlll.length; ++lllllllllllllllIIIIlIIllIIIllIII) {
                lllllllllllllllIIIIlIIllIIIlIlll[lllllllllllllllIIIIlIIllIIIllIII] = lllllllllllllllIIIIlIIllIIIllIII < lllllllllllllllIIIIlIIllIIIlIlII.size() ? lllllllllllllllIIIIlIIllIIIlIlII.get(lllllllllllllllIIIIlIIllIIIllIII) : lllllllllllllllIIIIlIIllIIIlIIll;
            }
            lllllllllllllllIIIIlIIllIIIlIlII.set(lllllllllllllllIIIIlIIllIIIlIlll);
        }
    }

    public void set(T[] lllllllllllllllIIIIlIIlIlllIIllI) {
        lllllllllllllllIIIIlIIlIlllIIlll.elements = lllllllllllllllIIIIlIIlIlllIIllI;
    }

    public boolean isEmpty() {
        ArrayHelper lllllllllllllllIIIIlIIlIllIllIIl;
        return lllllllllllllllIIIIlIIlIllIllIIl.size() == 0;
    }

    public ArrayHelper() {
        ArrayHelper lllllllllllllllIIIIlIIllIIIlllIl;
        lllllllllllllllIIIIlIIllIIIlllIl.elements = new Object[0];
    }

    public boolean contains(T lllllllllllllllIIIIlIIllIIIIIIll) {
        ArrayHelper lllllllllllllllIIIIlIIllIIIIIlII;
        for (T lllllllllllllllIIIIlIIllIIIIlIlI : lllllllllllllllIIIIlIIllIIIIIlII.array()) {
            if (!lllllllllllllllIIIIlIIllIIIIlIlI.equals(lllllllllllllllIIIIlIIllIIIIIIll)) continue;
            return true;
        }
        return false;
    }

    public T get(int lllllllllllllllIIIIlIIlIllIllllI) {
        ArrayHelper lllllllllllllllIIIIlIIlIlllIIIIl;
        return lllllllllllllllIIIIlIIlIlllIIIIl.array()[lllllllllllllllIIIIlIIlIllIllllI];
    }

    public void remove(T lllllllllllllllIIIIlIIlIllllIlIl) {
        ArrayHelper lllllllllllllllIIIIlIIlIllllIllI;
        if (lllllllllllllllIIIIlIIlIllllIllI.contains(lllllllllllllllIIIIlIIlIllllIlIl)) {
            Object[] lllllllllllllllIIIIlIIlIlllllIII = new Object[lllllllllllllllIIIIlIIlIllllIllI.size() - 1];
            boolean lllllllllllllllIIIIlIIlIllllIlll = true;
            for (int lllllllllllllllIIIIlIIlIlllllIIl = 0; lllllllllllllllIIIIlIIlIlllllIIl < lllllllllllllllIIIIlIIlIllllIllI.size(); ++lllllllllllllllIIIIlIIlIlllllIIl) {
                if (lllllllllllllllIIIIlIIlIllllIlll && lllllllllllllllIIIIlIIlIllllIllI.get(lllllllllllllllIIIIlIIlIlllllIIl).equals(lllllllllllllllIIIIlIIlIllllIlIl)) {
                    lllllllllllllllIIIIlIIlIllllIlll = false;
                    continue;
                }
                lllllllllllllllIIIIlIIlIlllllIII[lllllllllllllllIIIIlIIlIllllIlll ? lllllllllllllllIIIIlIIlIlllllIIl : lllllllllllllllIIIIlIIlIlllllIIl - 1] = lllllllllllllllIIIIlIIlIllllIllI.get(lllllllllllllllIIIIlIIlIlllllIIl);
            }
            lllllllllllllllIIIIlIIlIllllIllI.set(lllllllllllllllIIIIlIIlIlllllIII);
        }
    }
}

