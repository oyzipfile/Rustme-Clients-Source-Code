/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  akka.util.BoundedBlockingQueue
 *  com.google.common.reflect.ClassPath
 *  com.google.common.reflect.ClassPath$ClassInfo
 *  net.minecraft.util.text.TextFormatting
 */
package ru.internali.utils.friend;

import akka.util.BoundedBlockingQueue;
import com.google.common.reflect.ClassPath;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.util.text.TextFormatting;
import ru.internali.module.Module;
import ru.internali.notifications.Type;
import ru.internali.notifications.notifications;

public class FriendManager {
    public static /* synthetic */ ArrayList<String> friendsList;
    private final /* synthetic */ Module[] modules;
    public static /* synthetic */ BoundedBlockingQueue<Object> friends;
    public static /* synthetic */ List<String> FRIENDS;

    public static void removeFriend(String lIlIIlllllIIlll) {
        if (friendsList.contains(lIlIIlllllIIlll)) {
            friendsList.remove(lIlIIlllllIIlll);
            notifications.add(String.valueOf(new StringBuilder().append((Object)TextFormatting.RED).append(lIlIIlllllIIlll)), "Remove from Friend list", Type.OK);
        }
    }

    public static void remove(String lIlIIlllllIIIll) {
    }

    public static ArrayList<Class<?>> getClasses(String lIlIIllllIlIlll) {
        ArrayList lIlIIllllIllIII = new ArrayList();
        try {
            ClassLoader lIlIIllllIllIll = Thread.currentThread().getContextClassLoader();
            for (ClassPath.ClassInfo lIlIIllllIlllII : ClassPath.from((ClassLoader)lIlIIllllIllIll).getAllClasses()) {
                if (!lIlIIllllIlllII.getName().startsWith(lIlIIllllIlIlll)) continue;
                lIlIIllllIllIII.add(lIlIIllllIlllII.load());
            }
        }
        catch (Exception lIlIIllllIllIlI) {
            lIlIIllllIllIlI.printStackTrace();
        }
        return lIlIIllllIllIII;
    }

    public static void clear() {
        if (!friendsList.isEmpty()) {
            friendsList.clear();
        }
    }

    static {
        FRIENDS = new ArrayList<String>();
        friendsList = new ArrayList();
    }

    public Module getModule(String lIlIIllllIIIlIl) {
        FriendManager lIlIIllllIIIllI;
        for (Module lIlIIllllIIlIIl : lIlIIllllIIIllI.modules) {
            if (!lIlIIllllIIlIIl.getName().equalsIgnoreCase(lIlIIllllIIIlIl)) continue;
            return lIlIIllllIIlIIl;
        }
        return null;
    }

    public static boolean isFriend(String lIlIIlllllIIlII) {
        return FRIENDS.contains(lIlIIlllllIIlII);
    }

    public static void add(String lIlIIlllllIIIlI) {
    }

    public FriendManager(Module[] lIlIIlllllIllIl) {
        FriendManager lIlIIlllllIlllI;
        lIlIIlllllIlllI.modules = lIlIIlllllIllIl;
    }

    public static void addFriend(String lIlIIlllllIlIll) {
        if (!friendsList.contains(lIlIIlllllIlIll)) {
            friendsList.add(lIlIIlllllIlIll);
            notifications.add(String.valueOf(new StringBuilder().append((Object)TextFormatting.GREEN).append(lIlIIlllllIlIll)), "add in Friends list", Type.OK);
        }
    }

    public static void toggleFriend(String lIlIIllllIlIIIl) {
        if (FriendManager.isFriend(lIlIIllllIlIIIl)) {
            FRIENDS.remove(lIlIIllllIlIIIl);
            notifications.add(String.valueOf(new StringBuilder().append((Object)TextFormatting.RED).append(lIlIIllllIlIIIl)), "Remove from Friend list", Type.OK);
        } else {
            FRIENDS.add(lIlIIllllIlIIIl);
            notifications.add(String.valueOf(new StringBuilder().append((Object)TextFormatting.GREEN).append(lIlIIllllIlIIIl)), "add in Friends list", Type.OK);
        }
    }
}

