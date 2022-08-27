/*
 * Decompiled with CFR 0.150.
 */
package ru.hld.legendline.api.shit;

import java.util.ArrayList;

public class FriendManager {
    public static /* synthetic */ ArrayList<String> friends;

    static {
        friends = new ArrayList();
    }

    public static boolean isFriend(String llllllllllllllIlIlIIIIlIIIllIlII) {
        return friends.contains(llllllllllllllIlIlIIIIlIIIllIlII);
    }

    public FriendManager() {
        FriendManager llllllllllllllIlIlIIIIlIIIlllIlI;
    }

    public static void remove(String llllllllllllllIlIlIIIIlIIIllIIlI) {
        if (friends.contains(llllllllllllllIlIlIIIIlIIIllIIlI)) {
            friends.remove(llllllllllllllIlIlIIIIlIIIllIIlI);
        }
    }

    public static void add(String llllllllllllllIlIlIIIIlIIIllIlll) {
        if (!friends.contains(llllllllllllllIlIlIIIIlIIIllIlll)) {
            friends.add(llllllllllllllIlIlIIIIlIIIllIlll);
        }
    }
}

