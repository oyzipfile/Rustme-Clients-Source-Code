/*
 * Decompiled with CFR 0.150.
 */
package ru.internali.utils;

import java.util.ArrayList;

public class EnemyManager {
    public static /* synthetic */ ArrayList<String> enemysList;
    public static /* synthetic */ ArrayList<String> detects;
    public static /* synthetic */ ArrayList<String> murders;

    public static void removeEnemy(String lIlIlIllIIIIIIl) {
        if (enemysList.contains(lIlIlIllIIIIIIl)) {
            enemysList.remove(lIlIlIllIIIIIIl);
        }
    }

    static {
        enemysList = new ArrayList();
        murders = new ArrayList();
        detects = new ArrayList();
    }

    public EnemyManager() {
        EnemyManager lIlIlIllIIIlIII;
    }

    public static void addEnemy(String lIlIlIllIIIIlIl) {
        if (!enemysList.contains(lIlIlIllIIIIlIl)) {
            enemysList.add(lIlIlIllIIIIlIl);
        }
    }

    public static void clear() {
        if (!enemysList.isEmpty()) {
            enemysList.clear();
        }
    }
}

