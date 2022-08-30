/*
 * Decompiled with CFR 0.150.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.DESConstants;
import com.sun.crypto.provider.SymmetricCipher;
import java.security.InvalidKeyException;

class DESCrypt
extends SymmetricCipher
implements DESConstants {
    private static final int[] s0p = new int[]{0x410100, 65536, 0x40400000, 0x40410100, 0x400000, 0x40010100, 0x40010000, 0x40400000, 0x40010100, 0x410100, 0x410000, 0x40000100, 0x40400100, 0x400000, 0, 0x40010000, 65536, 0x40000000, 0x400100, 65792, 0x40410100, 0x410000, 0x40000100, 0x400100, 0x40000000, 256, 65792, 0x40410000, 256, 0x40400100, 0x40410000, 0, 0, 0x40410100, 0x400100, 0x40010000, 0x410100, 65536, 0x40000100, 0x400100, 0x40410000, 256, 65792, 0x40400000, 0x40010100, 0x40000000, 0x40400000, 0x410000, 0x40410100, 65792, 0x410000, 0x40400100, 0x400000, 0x40000100, 0x40010000, 0, 65536, 0x400000, 0x40400100, 0x410100, 0x40000000, 0x40410000, 256, 0x40010100};
    private static final int[] s1p = new int[]{134352898, 0, 135168, 0x8020000, 0x8000002, 4098, 0x8001000, 135168, 4096, 0x8020002, 2, 0x8001000, 131074, 134352896, 0x8020000, 2, 131072, 134221826, 0x8020002, 4096, 135170, 0x8000000, 0, 131074, 134221826, 135170, 134352896, 0x8000002, 0x8000000, 131072, 4098, 134352898, 131074, 134352896, 0x8001000, 135170, 134352898, 131074, 0x8000002, 0, 0x8000000, 4098, 131072, 0x8020002, 4096, 0x8000000, 135170, 134221826, 134352896, 4096, 0, 0x8000002, 2, 134352898, 135168, 0x8020000, 0x8020002, 131072, 4098, 0x8001000, 134221826, 2, 0x8020000, 135168};
    private static final int[] s2p = new int[]{0x20800000, 0x808020, 32, 0x20800020, 0x20008000, 0x800000, 0x20800020, 32800, 0x800020, 32768, 0x808000, 0x20000000, 0x20808020, 0x20000020, 0x20000000, 0x20808000, 0, 0x20008000, 0x808020, 32, 0x20000020, 0x20808020, 32768, 0x20800000, 0x20808000, 0x800020, 0x20008020, 0x808000, 32800, 0, 0x800000, 0x20008020, 0x808020, 32, 0x20000000, 32768, 0x20000020, 0x20008000, 0x808000, 0x20800020, 0, 0x808020, 32800, 0x20808000, 0x20008000, 0x800000, 0x20808020, 0x20000000, 0x20008020, 0x20800000, 0x800000, 0x20808020, 32768, 0x800020, 0x20800020, 32800, 0x800020, 0, 0x20808000, 0x20000020, 0x20800000, 0x20008020, 32, 0x808000};
    private static final int[] s3p = new int[]{524801, 0x2000200, 1, 34079233, 0, 0x2080000, 0x2000201, 524289, 0x2080200, 0x2000001, 0x2000000, 513, 0x2000001, 524801, 524288, 0x2000000, 34078721, 524800, 512, 1, 524800, 0x2000201, 0x2080000, 512, 513, 0, 524289, 0x2080200, 0x2000200, 34078721, 34079233, 524288, 34078721, 513, 524288, 0x2000001, 524800, 0x2000200, 1, 0x2080000, 0x2000201, 0, 512, 524289, 0, 34078721, 0x2080200, 512, 0x2000000, 34079233, 524801, 524288, 34079233, 1, 0x2000200, 524801, 524289, 524800, 0x2080000, 0x2000201, 513, 0x2000000, 0x2000001, 0x2080200};
    private static final int[] s4p = new int[]{0x1000000, 8192, 128, 16785540, 16785412, 0x1000080, 8324, 0x1002000, 8192, 4, 0x1000004, 8320, 16777348, 16785412, 16785536, 0, 8320, 0x1000000, 8196, 132, 0x1000080, 8324, 0, 0x1000004, 4, 16777348, 16785540, 8196, 0x1002000, 128, 132, 16785536, 16785536, 16777348, 8196, 0x1002000, 8192, 4, 0x1000004, 0x1000080, 0x1000000, 8320, 16785540, 0, 8324, 0x1000000, 128, 8196, 16777348, 128, 0, 16785540, 16785412, 16785536, 132, 8192, 8320, 16785412, 0x1000080, 132, 4, 8324, 0x1002000, 0x1000004};
    private static final int[] s5p = new int[]{0x10000008, 262152, 0, 0x10040400, 262152, 1024, 268436488, 262144, 1032, 268698632, 263168, 0x10000000, 0x10000400, 0x10000008, 0x10040000, 263176, 262144, 268436488, 268697608, 0, 1024, 8, 0x10040400, 268697608, 268698632, 0x10040000, 0x10000000, 1032, 8, 263168, 263176, 0x10000400, 1032, 0x10000000, 0x10000400, 263176, 0x10040400, 262152, 0, 0x10000400, 0x10000000, 1024, 268697608, 262144, 262152, 268698632, 263168, 8, 268698632, 263168, 262144, 268436488, 0x10000008, 0x10040000, 263176, 0, 1024, 0x10000008, 268436488, 0x10040400, 0x10040000, 1032, 8, 268697608};
    private static final int[] s6p = new int[]{2048, 64, 0x200040, -2145386496, -2145384384, -2147481600, 2112, 0, 0x200000, -2145386432, -2147483584, 0x200800, Integer.MIN_VALUE, 2099264, 0x200800, -2147483584, -2145386432, 2048, -2147481600, -2145384384, 0, 0x200040, -2145386496, 2112, -2145384448, -2147481536, 2099264, Integer.MIN_VALUE, -2147481536, -2145384448, 64, 0x200000, -2147481536, 0x200800, -2145384448, -2147483584, 2048, 64, 0x200000, -2145384448, -2145386432, -2147481536, 2112, 0, 64, -2145386496, Integer.MIN_VALUE, 0x200040, 0, -2145386432, 0x200040, 2112, -2147483584, 2048, -2145384384, 0x200000, 2099264, Integer.MIN_VALUE, -2147481600, -2145384384, -2145386496, 2099264, 0x200800, -2147481600};
    private static final int[] s7p = new int[]{0x4100010, 0x4104000, 16400, 0, 0x4004000, 0x100010, 0x4100000, 0x4104010, 16, 0x4000000, 0x104000, 16400, 0x104010, 0x4004010, 0x4000010, 0x4100000, 16384, 0x104010, 0x100010, 0x4004000, 0x4104010, 0x4000010, 0, 0x104000, 0x4000000, 0x100000, 0x4004010, 0x4100010, 0x100000, 16384, 0x4104000, 16, 0x100000, 16384, 0x4000010, 0x4104010, 16400, 0x4000000, 0, 0x104000, 0x4100010, 0x4004010, 0x4004000, 0x100010, 0x4104000, 16, 0x100010, 0x4004000, 0x4104010, 0x100000, 0x4100000, 0x4000010, 0x104000, 16400, 0x4004010, 0x4100000, 16, 0x4104000, 0x104010, 0, 0x4000000, 0x4100010, 16384, 0x104010};
    private static final int[] permRight0 = new int[]{0, 0x40000000, 0x400000, 0x40400000, 16384, 0x40004000, 0x404000, 0x40404000, 64, 0x40000040, 0x400040, 0x40400040, 16448, 0x40004040, 0x404040, 0x40404040};
    private static final int[] permLeft1 = new int[]{0, 0x40000000, 0x400000, 0x40400000, 16384, 0x40004000, 0x404000, 0x40404000, 64, 0x40000040, 0x400040, 0x40400040, 16448, 0x40004040, 0x404040, 0x40404040};
    private static final int[] permRight2 = new int[]{0, 0x10000000, 0x100000, 0x10100000, 4096, 0x10001000, 0x101000, 0x10101000, 16, 0x10000010, 0x100010, 0x10100010, 4112, 0x10001010, 0x101010, 0x10101010};
    private static final int[] permLeft3 = new int[]{0, 0x10000000, 0x100000, 0x10100000, 4096, 0x10001000, 0x101000, 0x10101000, 16, 0x10000010, 0x100010, 0x10100010, 4112, 0x10001010, 0x101010, 0x10101010};
    private static final int[] permRight4 = new int[]{0, 0x4000000, 262144, 0x4040000, 1024, 0x4000400, 263168, 0x4040400, 4, 0x4000004, 262148, 0x4040004, 1028, 0x4000404, 263172, 0x4040404};
    private static final int[] permLeft5 = new int[]{0, 0x4000000, 262144, 0x4040000, 1024, 0x4000400, 263168, 0x4040400, 4, 0x4000004, 262148, 0x4040004, 1028, 0x4000404, 263172, 0x4040404};
    private static final int[] permRight6 = new int[]{0, 0x1000000, 65536, 0x1010000, 256, 0x1000100, 65792, 0x1010100, 1, 0x1000001, 65537, 0x1010001, 257, 0x1000101, 65793, 0x1010101};
    private static final int[] permLeft7 = new int[]{0, 0x1000000, 65536, 0x1010000, 256, 0x1000100, 65792, 0x1010100, 1, 0x1000001, 65537, 0x1010001, 257, 0x1000101, 65793, 0x1010101};
    private static final int[] permRight8 = new int[]{0, Integer.MIN_VALUE, 0x800000, -2139095040, 32768, -2147450880, 0x808000, -2139062272, 128, -2147483520, 0x800080, -2139094912, 32896, -2147450752, 0x808080, -2139062144};
    private static final int[] permLeft9 = new int[]{0, Integer.MIN_VALUE, 0x800000, -2139095040, 32768, -2147450880, 0x808000, -2139062272, 128, -2147483520, 0x800080, -2139094912, 32896, -2147450752, 0x808080, -2139062144};
    private static final int[] permRightA = new int[]{0, 0x20000000, 0x200000, 0x20200000, 8192, 0x20002000, 0x202000, 0x20202000, 32, 0x20000020, 0x200020, 0x20200020, 8224, 0x20002020, 0x202020, 0x20202020};
    private static final int[] permLeftB = new int[]{0, 0x20000000, 0x200000, 0x20200000, 8192, 0x20002000, 0x202000, 0x20202000, 32, 0x20000020, 0x200020, 0x20200020, 8224, 0x20002020, 0x202020, 0x20202020};
    private static final int[] permRightC = new int[]{0, 0x8000000, 524288, 0x8080000, 2048, 0x8000800, 526336, 0x8080800, 8, 0x8000008, 524296, 0x8080008, 2056, 0x8000808, 526344, 0x8080808};
    private static final int[] permLeftD = new int[]{0, 0x8000000, 524288, 0x8080000, 2048, 0x8000800, 526336, 0x8080800, 8, 0x8000008, 524296, 0x8080008, 2056, 0x8000808, 526344, 0x8080808};
    private static final int[] permRightE = new int[]{0, 0x2000000, 131072, 0x2020000, 512, 0x2000200, 131584, 0x2020200, 2, 0x2000002, 131074, 0x2020002, 514, 0x2000202, 131586, 0x2020202};
    private static final int[] permLeftF = new int[]{0, 0x2000000, 131072, 0x2020000, 512, 0x2000200, 131584, 0x2020200, 2, 0x2000002, 131074, 0x2020002, 514, 0x2000202, 131586, 0x2020202};
    private static final int[] initPermLeft0 = new int[]{0, 32768, 0, 32768, 128, 32896, 128, 32896, 0, 32768, 0, 32768, 128, 32896, 128, 32896};
    private static final int[] initPermRight0 = new int[]{0, 0, 32768, 32768, 0, 0, 32768, 32768, 128, 128, 32896, 32896, 128, 128, 32896, 32896};
    private static final int[] initPermLeft1 = new int[]{0, Integer.MIN_VALUE, 0, Integer.MIN_VALUE, 0x800000, -2139095040, 0x800000, -2139095040, 0, Integer.MIN_VALUE, 0, Integer.MIN_VALUE, 0x800000, -2139095040, 0x800000, -2139095040};
    private static final int[] initPermRight1 = new int[]{0, 0, Integer.MIN_VALUE, Integer.MIN_VALUE, 0, 0, Integer.MIN_VALUE, Integer.MIN_VALUE, 0x800000, 0x800000, -2139095040, -2139095040, 0x800000, 0x800000, -2139095040, -2139095040};
    private static final int[] initPermLeft2 = new int[]{0, 16384, 0, 16384, 64, 16448, 64, 16448, 0, 16384, 0, 16384, 64, 16448, 64, 16448};
    private static final int[] initPermRight2 = new int[]{0, 0, 16384, 16384, 0, 0, 16384, 16384, 64, 64, 16448, 16448, 64, 64, 16448, 16448};
    private static final int[] initPermLeft3 = new int[]{0, 0x40000000, 0, 0x40000000, 0x400000, 0x40400000, 0x400000, 0x40400000, 0, 0x40000000, 0, 0x40000000, 0x400000, 0x40400000, 0x400000, 0x40400000};
    private static final int[] initPermRight3 = new int[]{0, 0, 0x40000000, 0x40000000, 0, 0, 0x40000000, 0x40000000, 0x400000, 0x400000, 0x40400000, 0x40400000, 0x400000, 0x400000, 0x40400000, 0x40400000};
    private static final int[] initPermLeft4 = new int[]{0, 8192, 0, 8192, 32, 8224, 32, 8224, 0, 8192, 0, 8192, 32, 8224, 32, 8224};
    private static final int[] initPermRight4 = new int[]{0, 0, 8192, 8192, 0, 0, 8192, 8192, 32, 32, 8224, 8224, 32, 32, 8224, 8224};
    private static final int[] initPermLeft5 = new int[]{0, 0x20000000, 0, 0x20000000, 0x200000, 0x20200000, 0x200000, 0x20200000, 0, 0x20000000, 0, 0x20000000, 0x200000, 0x20200000, 0x200000, 0x20200000};
    private static final int[] initPermRight5 = new int[]{0, 0, 0x20000000, 0x20000000, 0, 0, 0x20000000, 0x20000000, 0x200000, 0x200000, 0x20200000, 0x20200000, 0x200000, 0x200000, 0x20200000, 0x20200000};
    private static final int[] initPermLeft6 = new int[]{0, 4096, 0, 4096, 16, 4112, 16, 4112, 0, 4096, 0, 4096, 16, 4112, 16, 4112};
    private static final int[] initPermRight6 = new int[]{0, 0, 4096, 4096, 0, 0, 4096, 4096, 16, 16, 4112, 4112, 16, 16, 4112, 4112};
    private static final int[] initPermLeft7 = new int[]{0, 0x10000000, 0, 0x10000000, 0x100000, 0x10100000, 0x100000, 0x10100000, 0, 0x10000000, 0, 0x10000000, 0x100000, 0x10100000, 0x100000, 0x10100000};
    private static final int[] initPermRight7 = new int[]{0, 0, 0x10000000, 0x10000000, 0, 0, 0x10000000, 0x10000000, 0x100000, 0x100000, 0x10100000, 0x10100000, 0x100000, 0x100000, 0x10100000, 0x10100000};
    private static final int[] initPermLeft8 = new int[]{0, 2048, 0, 2048, 8, 2056, 8, 2056, 0, 2048, 0, 2048, 8, 2056, 8, 2056};
    private static final int[] initPermRight8 = new int[]{0, 0, 2048, 2048, 0, 0, 2048, 2048, 8, 8, 2056, 2056, 8, 8, 2056, 2056};
    private static final int[] initPermLeft9 = new int[]{0, 0x8000000, 0, 0x8000000, 524288, 0x8080000, 524288, 0x8080000, 0, 0x8000000, 0, 0x8000000, 524288, 0x8080000, 524288, 0x8080000};
    private static final int[] initPermRight9 = new int[]{0, 0, 0x8000000, 0x8000000, 0, 0, 0x8000000, 0x8000000, 524288, 524288, 0x8080000, 0x8080000, 524288, 524288, 0x8080000, 0x8080000};
    private static final int[] initPermLeftA = new int[]{0, 1024, 0, 1024, 4, 1028, 4, 1028, 0, 1024, 0, 1024, 4, 1028, 4, 1028};
    private static final int[] initPermRightA = new int[]{0, 0, 1024, 1024, 0, 0, 1024, 1024, 4, 4, 1028, 1028, 4, 4, 1028, 1028};
    private static final int[] initPermLeftB = new int[]{0, 0x4000000, 0, 0x4000000, 262144, 0x4040000, 262144, 0x4040000, 0, 0x4000000, 0, 0x4000000, 262144, 0x4040000, 262144, 0x4040000};
    private static final int[] initPermRightB = new int[]{0, 0, 0x4000000, 0x4000000, 0, 0, 0x4000000, 0x4000000, 262144, 262144, 0x4040000, 0x4040000, 262144, 262144, 0x4040000, 0x4040000};
    private static final int[] initPermLeftC = new int[]{0, 512, 0, 512, 2, 514, 2, 514, 0, 512, 0, 512, 2, 514, 2, 514};
    private static final int[] initPermRightC = new int[]{0, 0, 512, 512, 0, 0, 512, 512, 2, 2, 514, 514, 2, 2, 514, 514};
    private static final int[] initPermLeftD = new int[]{0, 0x2000000, 0, 0x2000000, 131072, 0x2020000, 131072, 0x2020000, 0, 0x2000000, 0, 0x2000000, 131072, 0x2020000, 131072, 0x2020000};
    private static final int[] initPermRightD = new int[]{0, 0, 0x2000000, 0x2000000, 0, 0, 0x2000000, 0x2000000, 131072, 131072, 0x2020000, 0x2020000, 131072, 131072, 0x2020000, 0x2020000};
    private static final int[] initPermLeftE = new int[]{0, 256, 0, 256, 1, 257, 1, 257, 0, 256, 0, 256, 1, 257, 1, 257};
    private static final int[] initPermRightE = new int[]{0, 0, 256, 256, 0, 0, 256, 256, 1, 1, 257, 257, 1, 1, 257, 257};
    private static final int[] initPermLeftF = new int[]{0, 0x1000000, 0, 0x1000000, 65536, 0x1010000, 65536, 0x1010000, 0, 0x1000000, 0, 0x1000000, 65536, 0x1010000, 65536, 0x1010000};
    private static final int[] initPermRightF = new int[]{0, 0, 0x1000000, 0x1000000, 0, 0, 0x1000000, 0x1000000, 65536, 65536, 0x1010000, 0x1010000, 65536, 65536, 0x1010000, 0x1010000};
    byte[] expandedKey = null;
    boolean decrypting = false;

    DESCrypt() {
    }

    @Override
    int getBlockSize() {
        return 8;
    }

    @Override
    void init(boolean bl, String string, byte[] arrby) throws InvalidKeyException {
        this.decrypting = bl;
        if (!string.equalsIgnoreCase("DES")) {
            throw new InvalidKeyException("Wrong algorithm: DES required");
        }
        if (arrby.length != 8) {
            throw new InvalidKeyException("Wrong key size");
        }
        this.expandKey(arrby);
    }

    @Override
    void encryptBlock(byte[] arrby, int n, byte[] arrby2, int n2) {
        this.cipherBlock(arrby, n, arrby2, n2);
    }

    @Override
    void decryptBlock(byte[] arrby, int n, byte[] arrby2, int n2) {
        this.cipherBlock(arrby, n, arrby2, n2);
    }

    void cipherBlock(byte[] arrby, int n, byte[] arrby2, int n2) {
        int n3;
        int n4;
        int n5;
        int n6 = DESCrypt.initialPermutationLeft(arrby, n);
        int n7 = DESCrypt.initialPermutationRight(arrby, n);
        byte[] arrby3 = this.expandedKey;
        if (this.decrypting) {
            n5 = 8;
            n4 = 120;
        } else {
            n5 = -8;
            n4 = 0;
        }
        for (int i = 0; i < 16; ++i) {
            n3 = n7 << 1 | n7 >> 31 & 1;
            n6 ^= s0p[n3 & 0x3F ^ arrby3[n4 + 0]] ^ s1p[n3 >> 4 & 0x3F ^ arrby3[n4 + 1]] ^ s2p[n3 >> 8 & 0x3F ^ arrby3[n4 + 2]] ^ s3p[n3 >> 12 & 0x3F ^ arrby3[n4 + 3]] ^ s4p[n3 >> 16 & 0x3F ^ arrby3[n4 + 4]] ^ s5p[n3 >> 20 & 0x3F ^ arrby3[n4 + 5]] ^ s6p[n3 >> 24 & 0x3F ^ arrby3[n4 + 6]];
            n3 = (n7 & 1) << 5 | n7 >> 27 & 0x1F;
            n6 ^= s7p[n3 ^ arrby3[n4 + 7]];
            n3 = n6;
            n6 = n7;
            n7 = n3;
            n4 -= n5;
        }
        n3 = n6;
        n6 = n7;
        n7 = n3;
        DESCrypt.perm(n6, n7, arrby2, n2);
    }

    private static void perm(int n, int n2, byte[] arrby, int n3) {
        int n4 = n;
        int n5 = permRight0[n4 & 0xF];
        int n6 = permLeft1[(n4 >>= 4) & 0xF];
        n5 |= permRight2[(n4 >>= 4) & 0xF];
        n6 |= permLeft3[(n4 >>= 4) & 0xF];
        n5 |= permRight4[(n4 >>= 4) & 0xF];
        n6 |= permLeft5[(n4 >>= 4) & 0xF];
        n5 |= permRight6[(n4 >>= 4) & 0xF];
        n6 |= permLeft7[(n4 >>= 4) & 0xF];
        n4 = n2;
        n5 |= permRight8[n4 & 0xF];
        n6 |= permLeft9[(n4 >>= 4) & 0xF];
        n5 |= permRightA[(n4 >>= 4) & 0xF];
        n6 |= permLeftB[(n4 >>= 4) & 0xF];
        n5 |= permRightC[(n4 >>= 4) & 0xF];
        n6 |= permLeftD[(n4 >>= 4) & 0xF];
        arrby[n3 + 0] = (byte)(n6 |= permLeftF[(n4 >>= 4) & 0xF]);
        arrby[n3 + 1] = (byte)(n6 >> 8);
        arrby[n3 + 2] = (byte)(n6 >> 16);
        arrby[n3 + 3] = (byte)(n6 >> 24);
        arrby[n3 + 4] = (byte)(n5 |= permRightE[(n4 >>= 4) & 0xF]);
        arrby[n3 + 5] = (byte)(n5 >> 8);
        arrby[n3 + 6] = (byte)(n5 >> 16);
        arrby[n3 + 7] = (byte)(n5 >> 24);
    }

    private static int initialPermutationLeft(byte[] arrby, int n) {
        int n2 = initPermLeft1[arrby[n] & 0xF];
        n2 |= initPermLeft0[arrby[n] >> 4 & 0xF];
        n2 |= initPermLeft3[arrby[n + 1] & 0xF];
        n2 |= initPermLeft2[arrby[n + 1] >> 4 & 0xF];
        n2 |= initPermLeft5[arrby[n + 2] & 0xF];
        n2 |= initPermLeft4[arrby[n + 2] >> 4 & 0xF];
        n2 |= initPermLeft7[arrby[n + 3] & 0xF];
        n2 |= initPermLeft6[arrby[n + 3] >> 4 & 0xF];
        n2 |= initPermLeft9[arrby[n + 4] & 0xF];
        n2 |= initPermLeft8[arrby[n + 4] >> 4 & 0xF];
        n2 |= initPermLeftB[arrby[n + 5] & 0xF];
        n2 |= initPermLeftA[arrby[n + 5] >> 4 & 0xF];
        n2 |= initPermLeftD[arrby[n + 6] & 0xF];
        n2 |= initPermLeftC[arrby[n + 6] >> 4 & 0xF];
        n2 |= initPermLeftF[arrby[n + 7] & 0xF];
        return n2 |= initPermLeftE[arrby[n + 7] >> 4 & 0xF];
    }

    private static int initialPermutationRight(byte[] arrby, int n) {
        int n2 = initPermRight1[arrby[n] & 0xF];
        n2 |= initPermRight0[arrby[n] >> 4 & 0xF];
        n2 |= initPermRight3[arrby[n + 1] & 0xF];
        n2 |= initPermRight2[arrby[n + 1] >> 4 & 0xF];
        n2 |= initPermRight5[arrby[n + 2] & 0xF];
        n2 |= initPermRight4[arrby[n + 2] >> 4 & 0xF];
        n2 |= initPermRight7[arrby[n + 3] & 0xF];
        n2 |= initPermRight6[arrby[n + 3] >> 4 & 0xF];
        n2 |= initPermRight9[arrby[n + 4] & 0xF];
        n2 |= initPermRight8[arrby[n + 4] >> 4 & 0xF];
        n2 |= initPermRightB[arrby[n + 5] & 0xF];
        n2 |= initPermRightA[arrby[n + 5] >> 4 & 0xF];
        n2 |= initPermRightD[arrby[n + 6] & 0xF];
        n2 |= initPermRightC[arrby[n + 6] >> 4 & 0xF];
        n2 |= initPermRightF[arrby[n + 7] & 0xF];
        return n2 |= initPermRightE[arrby[n + 7] >> 4 & 0xF];
    }

    void expandKey(byte[] arrby) {
        byte[] arrby2 = new byte[128];
        byte by = arrby[0];
        if ((by & 0x80) != 0) {
            arrby2[3] = (byte)(arrby2[3] | 2);
            arrby2[9] = (byte)(arrby2[9] | 8);
            arrby2[18] = (byte)(arrby2[18] | 8);
            arrby2[27] = (byte)(arrby2[27] | 0x20);
            arrby2[33] = (byte)(arrby2[33] | 2);
            arrby2[42] = (byte)(arrby2[42] | 0x10);
            arrby2[48] = (byte)(arrby2[48] | 8);
            arrby2[65] = (byte)(arrby2[65] | 0x10);
            arrby2[74] = (byte)(arrby2[74] | 2);
            arrby2[80] = (byte)(arrby2[80] | 2);
            arrby2[89] = (byte)(arrby2[89] | 4);
            arrby2[99] = (byte)(arrby2[99] | 0x10);
            arrby2[104] = (byte)(arrby2[104] | 4);
            arrby2[122] = (byte)(arrby2[122] | 0x20);
        }
        if ((by & 0x40) != 0) {
            arrby2[1] = (byte)(arrby2[1] | 4);
            arrby2[8] = (byte)(arrby2[8] | 1);
            arrby2[18] = (byte)(arrby2[18] | 4);
            arrby2[25] = (byte)(arrby2[25] | 0x20);
            arrby2[34] = (byte)(arrby2[34] | 0x20);
            arrby2[41] = (byte)(arrby2[41] | 8);
            arrby2[50] = (byte)(arrby2[50] | 8);
            arrby2[59] = (byte)(arrby2[59] | 0x20);
            arrby2[64] = (byte)(arrby2[64] | 0x10);
            arrby2[75] = (byte)(arrby2[75] | 4);
            arrby2[90] = (byte)(arrby2[90] | 1);
            arrby2[97] = (byte)(arrby2[97] | 0x10);
            arrby2[106] = (byte)(arrby2[106] | 2);
            arrby2[112] = (byte)(arrby2[112] | 2);
            arrby2[123] = (byte)(arrby2[123] | 1);
        }
        if ((by & 0x20) != 0) {
            arrby2[2] = (byte)(arrby2[2] | 1);
            arrby2[19] = (byte)(arrby2[19] | 8);
            arrby2[35] = (byte)(arrby2[35] | 1);
            arrby2[40] = (byte)(arrby2[40] | 1);
            arrby2[50] = (byte)(arrby2[50] | 4);
            arrby2[57] = (byte)(arrby2[57] | 0x20);
            arrby2[75] = (byte)(arrby2[75] | 2);
            arrby2[80] = (byte)(arrby2[80] | 0x20);
            arrby2[89] = (byte)(arrby2[89] | 1);
            arrby2[96] = (byte)(arrby2[96] | 0x10);
            arrby2[107] = (byte)(arrby2[107] | 4);
            arrby2[120] = (byte)(arrby2[120] | 8);
        }
        if ((by & 0x10) != 0) {
            arrby2[4] = (byte)(arrby2[4] | 0x20);
            arrby2[20] = (byte)(arrby2[20] | 2);
            arrby2[31] = (byte)(arrby2[31] | 4);
            arrby2[37] = (byte)(arrby2[37] | 0x20);
            arrby2[47] = (byte)(arrby2[47] | 1);
            arrby2[54] = (byte)(arrby2[54] | 1);
            arrby2[63] = (byte)(arrby2[63] | 2);
            arrby2[68] = (byte)(arrby2[68] | 1);
            arrby2[78] = (byte)(arrby2[78] | 4);
            arrby2[84] = (byte)(arrby2[84] | 8);
            arrby2[101] = (byte)(arrby2[101] | 0x10);
            arrby2[108] = (byte)(arrby2[108] | 4);
            arrby2[119] = (byte)(arrby2[119] | 0x10);
            arrby2[126] = (byte)(arrby2[126] | 8);
        }
        if ((by & 8) != 0) {
            arrby2[5] = (byte)(arrby2[5] | 4);
            arrby2[15] = (byte)(arrby2[15] | 4);
            arrby2[21] = (byte)(arrby2[21] | 0x20);
            arrby2[31] = (byte)(arrby2[31] | 1);
            arrby2[38] = (byte)(arrby2[38] | 1);
            arrby2[47] = (byte)(arrby2[47] | 2);
            arrby2[53] = (byte)(arrby2[53] | 2);
            arrby2[68] = (byte)(arrby2[68] | 8);
            arrby2[85] = (byte)(arrby2[85] | 0x10);
            arrby2[92] = (byte)(arrby2[92] | 4);
            arrby2[103] = (byte)(arrby2[103] | 0x10);
            arrby2[108] = (byte)(arrby2[108] | 0x20);
            arrby2[118] = (byte)(arrby2[118] | 0x20);
            arrby2[124] = (byte)(arrby2[124] | 2);
        }
        if ((by & 4) != 0) {
            arrby2[15] = (byte)(arrby2[15] | 2);
            arrby2[21] = (byte)(arrby2[21] | 2);
            arrby2[39] = (byte)(arrby2[39] | 8);
            arrby2[46] = (byte)(arrby2[46] | 0x10);
            arrby2[55] = (byte)(arrby2[55] | 0x20);
            arrby2[61] = (byte)(arrby2[61] | 1);
            arrby2[71] = (byte)(arrby2[71] | 0x10);
            arrby2[76] = (byte)(arrby2[76] | 0x20);
            arrby2[86] = (byte)(arrby2[86] | 0x20);
            arrby2[93] = (byte)(arrby2[93] | 4);
            arrby2[102] = (byte)(arrby2[102] | 2);
            arrby2[108] = (byte)(arrby2[108] | 0x10);
            arrby2[117] = (byte)(arrby2[117] | 8);
            arrby2[126] = (byte)(arrby2[126] | 1);
        }
        if ((by & 2) != 0) {
            arrby2[14] = (byte)(arrby2[14] | 0x10);
            arrby2[23] = (byte)(arrby2[23] | 0x20);
            arrby2[29] = (byte)(arrby2[29] | 1);
            arrby2[38] = (byte)(arrby2[38] | 8);
            arrby2[52] = (byte)(arrby2[52] | 2);
            arrby2[63] = (byte)(arrby2[63] | 4);
            arrby2[70] = (byte)(arrby2[70] | 2);
            arrby2[76] = (byte)(arrby2[76] | 0x10);
            arrby2[85] = (byte)(arrby2[85] | 8);
            arrby2[100] = (byte)(arrby2[100] | 1);
            arrby2[110] = (byte)(arrby2[110] | 4);
            arrby2[116] = (byte)(arrby2[116] | 8);
            arrby2[127] = (byte)(arrby2[127] | 8);
        }
        if (((by = arrby[1]) & 0x80) != 0) {
            arrby2[1] = (byte)(arrby2[1] | 8);
            arrby2[8] = (byte)(arrby2[8] | 0x20);
            arrby2[17] = (byte)(arrby2[17] | 1);
            arrby2[24] = (byte)(arrby2[24] | 0x10);
            arrby2[35] = (byte)(arrby2[35] | 4);
            arrby2[50] = (byte)(arrby2[50] | 1);
            arrby2[57] = (byte)(arrby2[57] | 0x10);
            arrby2[67] = (byte)(arrby2[67] | 8);
            arrby2[83] = (byte)(arrby2[83] | 1);
            arrby2[88] = (byte)(arrby2[88] | 1);
            arrby2[98] = (byte)(arrby2[98] | 4);
            arrby2[105] = (byte)(arrby2[105] | 0x20);
            arrby2[114] = (byte)(arrby2[114] | 0x20);
            arrby2[123] = (byte)(arrby2[123] | 2);
        }
        if ((by & 0x40) != 0) {
            arrby2[0] = (byte)(arrby2[0] | 1);
            arrby2[11] = (byte)(arrby2[11] | 0x10);
            arrby2[16] = (byte)(arrby2[16] | 4);
            arrby2[35] = (byte)(arrby2[35] | 2);
            arrby2[40] = (byte)(arrby2[40] | 0x20);
            arrby2[49] = (byte)(arrby2[49] | 1);
            arrby2[56] = (byte)(arrby2[56] | 0x10);
            arrby2[65] = (byte)(arrby2[65] | 2);
            arrby2[74] = (byte)(arrby2[74] | 0x10);
            arrby2[80] = (byte)(arrby2[80] | 8);
            arrby2[99] = (byte)(arrby2[99] | 8);
            arrby2[115] = (byte)(arrby2[115] | 1);
            arrby2[121] = (byte)(arrby2[121] | 4);
        }
        if ((by & 0x20) != 0) {
            arrby2[9] = (byte)(arrby2[9] | 0x10);
            arrby2[18] = (byte)(arrby2[18] | 2);
            arrby2[24] = (byte)(arrby2[24] | 2);
            arrby2[33] = (byte)(arrby2[33] | 4);
            arrby2[43] = (byte)(arrby2[43] | 0x10);
            arrby2[48] = (byte)(arrby2[48] | 4);
            arrby2[66] = (byte)(arrby2[66] | 0x20);
            arrby2[73] = (byte)(arrby2[73] | 8);
            arrby2[82] = (byte)(arrby2[82] | 8);
            arrby2[91] = (byte)(arrby2[91] | 0x20);
            arrby2[97] = (byte)(arrby2[97] | 2);
            arrby2[106] = (byte)(arrby2[106] | 0x10);
            arrby2[112] = (byte)(arrby2[112] | 8);
            arrby2[122] = (byte)(arrby2[122] | 1);
        }
        if ((by & 0x10) != 0) {
            arrby2[14] = (byte)(arrby2[14] | 0x20);
            arrby2[21] = (byte)(arrby2[21] | 4);
            arrby2[30] = (byte)(arrby2[30] | 2);
            arrby2[36] = (byte)(arrby2[36] | 0x10);
            arrby2[45] = (byte)(arrby2[45] | 8);
            arrby2[60] = (byte)(arrby2[60] | 1);
            arrby2[69] = (byte)(arrby2[69] | 2);
            arrby2[87] = (byte)(arrby2[87] | 8);
            arrby2[94] = (byte)(arrby2[94] | 0x10);
            arrby2[103] = (byte)(arrby2[103] | 0x20);
            arrby2[109] = (byte)(arrby2[109] | 1);
            arrby2[118] = (byte)(arrby2[118] | 8);
            arrby2[124] = (byte)(arrby2[124] | 0x20);
        }
        if ((by & 8) != 0) {
            arrby2[7] = (byte)(arrby2[7] | 4);
            arrby2[14] = (byte)(arrby2[14] | 2);
            arrby2[20] = (byte)(arrby2[20] | 0x10);
            arrby2[29] = (byte)(arrby2[29] | 8);
            arrby2[44] = (byte)(arrby2[44] | 1);
            arrby2[54] = (byte)(arrby2[54] | 4);
            arrby2[60] = (byte)(arrby2[60] | 8);
            arrby2[71] = (byte)(arrby2[71] | 8);
            arrby2[78] = (byte)(arrby2[78] | 0x10);
            arrby2[87] = (byte)(arrby2[87] | 0x20);
            arrby2[93] = (byte)(arrby2[93] | 1);
            arrby2[102] = (byte)(arrby2[102] | 8);
            arrby2[116] = (byte)(arrby2[116] | 2);
            arrby2[125] = (byte)(arrby2[125] | 4);
        }
        if ((by & 4) != 0) {
            arrby2[7] = (byte)(arrby2[7] | 2);
            arrby2[12] = (byte)(arrby2[12] | 1);
            arrby2[22] = (byte)(arrby2[22] | 4);
            arrby2[28] = (byte)(arrby2[28] | 8);
            arrby2[45] = (byte)(arrby2[45] | 0x10);
            arrby2[52] = (byte)(arrby2[52] | 4);
            arrby2[63] = (byte)(arrby2[63] | 0x10);
            arrby2[70] = (byte)(arrby2[70] | 8);
            arrby2[84] = (byte)(arrby2[84] | 2);
            arrby2[95] = (byte)(arrby2[95] | 4);
            arrby2[101] = (byte)(arrby2[101] | 0x20);
            arrby2[111] = (byte)(arrby2[111] | 1);
            arrby2[118] = (byte)(arrby2[118] | 1);
        }
        if ((by & 2) != 0) {
            arrby2[6] = (byte)(arrby2[6] | 0x10);
            arrby2[13] = (byte)(arrby2[13] | 0x10);
            arrby2[20] = (byte)(arrby2[20] | 4);
            arrby2[31] = (byte)(arrby2[31] | 0x10);
            arrby2[36] = (byte)(arrby2[36] | 0x20);
            arrby2[46] = (byte)(arrby2[46] | 0x20);
            arrby2[53] = (byte)(arrby2[53] | 4);
            arrby2[62] = (byte)(arrby2[62] | 2);
            arrby2[69] = (byte)(arrby2[69] | 0x20);
            arrby2[79] = (byte)(arrby2[79] | 1);
            arrby2[86] = (byte)(arrby2[86] | 1);
            arrby2[95] = (byte)(arrby2[95] | 2);
            arrby2[101] = (byte)(arrby2[101] | 2);
            arrby2[119] = (byte)(arrby2[119] | 8);
        }
        if (((by = arrby[2]) & 0x80) != 0) {
            arrby2[0] = (byte)(arrby2[0] | 0x20);
            arrby2[10] = (byte)(arrby2[10] | 8);
            arrby2[19] = (byte)(arrby2[19] | 0x20);
            arrby2[25] = (byte)(arrby2[25] | 2);
            arrby2[34] = (byte)(arrby2[34] | 0x10);
            arrby2[40] = (byte)(arrby2[40] | 8);
            arrby2[59] = (byte)(arrby2[59] | 8);
            arrby2[66] = (byte)(arrby2[66] | 2);
            arrby2[72] = (byte)(arrby2[72] | 2);
            arrby2[81] = (byte)(arrby2[81] | 4);
            arrby2[91] = (byte)(arrby2[91] | 0x10);
            arrby2[96] = (byte)(arrby2[96] | 4);
            arrby2[115] = (byte)(arrby2[115] | 2);
            arrby2[121] = (byte)(arrby2[121] | 8);
        }
        if ((by & 0x40) != 0) {
            arrby2[3] = (byte)(arrby2[3] | 0x10);
            arrby2[10] = (byte)(arrby2[10] | 4);
            arrby2[17] = (byte)(arrby2[17] | 0x20);
            arrby2[26] = (byte)(arrby2[26] | 0x20);
            arrby2[33] = (byte)(arrby2[33] | 8);
            arrby2[42] = (byte)(arrby2[42] | 8);
            arrby2[51] = (byte)(arrby2[51] | 0x20);
            arrby2[57] = (byte)(arrby2[57] | 2);
            arrby2[67] = (byte)(arrby2[67] | 4);
            arrby2[82] = (byte)(arrby2[82] | 1);
            arrby2[89] = (byte)(arrby2[89] | 0x10);
            arrby2[98] = (byte)(arrby2[98] | 2);
            arrby2[104] = (byte)(arrby2[104] | 2);
            arrby2[113] = (byte)(arrby2[113] | 4);
            arrby2[120] = (byte)(arrby2[120] | 1);
        }
        if ((by & 0x20) != 0) {
            arrby2[1] = (byte)(arrby2[1] | 0x10);
            arrby2[11] = (byte)(arrby2[11] | 8);
            arrby2[27] = (byte)(arrby2[27] | 1);
            arrby2[32] = (byte)(arrby2[32] | 1);
            arrby2[42] = (byte)(arrby2[42] | 4);
            arrby2[49] = (byte)(arrby2[49] | 0x20);
            arrby2[58] = (byte)(arrby2[58] | 0x20);
            arrby2[67] = (byte)(arrby2[67] | 2);
            arrby2[72] = (byte)(arrby2[72] | 0x20);
            arrby2[81] = (byte)(arrby2[81] | 1);
            arrby2[88] = (byte)(arrby2[88] | 0x10);
            arrby2[99] = (byte)(arrby2[99] | 4);
            arrby2[114] = (byte)(arrby2[114] | 1);
        }
        if ((by & 0x10) != 0) {
            arrby2[6] = (byte)(arrby2[6] | 0x20);
            arrby2[12] = (byte)(arrby2[12] | 2);
            arrby2[23] = (byte)(arrby2[23] | 4);
            arrby2[29] = (byte)(arrby2[29] | 0x20);
            arrby2[39] = (byte)(arrby2[39] | 1);
            arrby2[46] = (byte)(arrby2[46] | 1);
            arrby2[55] = (byte)(arrby2[55] | 2);
            arrby2[61] = (byte)(arrby2[61] | 2);
            arrby2[70] = (byte)(arrby2[70] | 4);
            arrby2[76] = (byte)(arrby2[76] | 8);
            arrby2[93] = (byte)(arrby2[93] | 0x10);
            arrby2[100] = (byte)(arrby2[100] | 4);
            arrby2[111] = (byte)(arrby2[111] | 0x10);
            arrby2[116] = (byte)(arrby2[116] | 0x20);
        }
        if ((by & 8) != 0) {
            arrby2[6] = (byte)(arrby2[6] | 2);
            arrby2[13] = (byte)(arrby2[13] | 0x20);
            arrby2[23] = (byte)(arrby2[23] | 1);
            arrby2[30] = (byte)(arrby2[30] | 1);
            arrby2[39] = (byte)(arrby2[39] | 2);
            arrby2[45] = (byte)(arrby2[45] | 2);
            arrby2[63] = (byte)(arrby2[63] | 8);
            arrby2[77] = (byte)(arrby2[77] | 0x10);
            arrby2[84] = (byte)(arrby2[84] | 4);
            arrby2[95] = (byte)(arrby2[95] | 0x10);
            arrby2[100] = (byte)(arrby2[100] | 0x20);
            arrby2[110] = (byte)(arrby2[110] | 0x20);
            arrby2[117] = (byte)(arrby2[117] | 4);
            arrby2[127] = (byte)(arrby2[127] | 4);
        }
        if ((by & 4) != 0) {
            arrby2[4] = (byte)(arrby2[4] | 1);
            arrby2[13] = (byte)(arrby2[13] | 2);
            arrby2[31] = (byte)(arrby2[31] | 8);
            arrby2[38] = (byte)(arrby2[38] | 0x10);
            arrby2[47] = (byte)(arrby2[47] | 0x20);
            arrby2[53] = (byte)(arrby2[53] | 1);
            arrby2[62] = (byte)(arrby2[62] | 8);
            arrby2[68] = (byte)(arrby2[68] | 0x20);
            arrby2[78] = (byte)(arrby2[78] | 0x20);
            arrby2[85] = (byte)(arrby2[85] | 4);
            arrby2[94] = (byte)(arrby2[94] | 2);
            arrby2[100] = (byte)(arrby2[100] | 0x10);
            arrby2[109] = (byte)(arrby2[109] | 8);
            arrby2[127] = (byte)(arrby2[127] | 2);
        }
        if ((by & 2) != 0) {
            arrby2[5] = (byte)(arrby2[5] | 0x10);
            arrby2[15] = (byte)(arrby2[15] | 0x20);
            arrby2[21] = (byte)(arrby2[21] | 1);
            arrby2[30] = (byte)(arrby2[30] | 8);
            arrby2[44] = (byte)(arrby2[44] | 2);
            arrby2[55] = (byte)(arrby2[55] | 4);
            arrby2[61] = (byte)(arrby2[61] | 0x20);
            arrby2[68] = (byte)(arrby2[68] | 0x10);
            arrby2[77] = (byte)(arrby2[77] | 8);
            arrby2[92] = (byte)(arrby2[92] | 1);
            arrby2[102] = (byte)(arrby2[102] | 4);
            arrby2[108] = (byte)(arrby2[108] | 8);
            arrby2[126] = (byte)(arrby2[126] | 0x10);
        }
        if (((by = arrby[3]) & 0x80) != 0) {
            arrby2[2] = (byte)(arrby2[2] | 8);
            arrby2[9] = (byte)(arrby2[9] | 1);
            arrby2[16] = (byte)(arrby2[16] | 0x10);
            arrby2[27] = (byte)(arrby2[27] | 4);
            arrby2[42] = (byte)(arrby2[42] | 1);
            arrby2[49] = (byte)(arrby2[49] | 0x10);
            arrby2[58] = (byte)(arrby2[58] | 2);
            arrby2[75] = (byte)(arrby2[75] | 1);
            arrby2[80] = (byte)(arrby2[80] | 1);
            arrby2[90] = (byte)(arrby2[90] | 4);
            arrby2[97] = (byte)(arrby2[97] | 0x20);
            arrby2[106] = (byte)(arrby2[106] | 0x20);
            arrby2[113] = (byte)(arrby2[113] | 8);
            arrby2[120] = (byte)(arrby2[120] | 0x20);
        }
        if ((by & 0x40) != 0) {
            arrby2[2] = (byte)(arrby2[2] | 4);
            arrby2[8] = (byte)(arrby2[8] | 4);
            arrby2[27] = (byte)(arrby2[27] | 2);
            arrby2[32] = (byte)(arrby2[32] | 0x20);
            arrby2[41] = (byte)(arrby2[41] | 1);
            arrby2[48] = (byte)(arrby2[48] | 0x10);
            arrby2[59] = (byte)(arrby2[59] | 4);
            arrby2[66] = (byte)(arrby2[66] | 0x10);
            arrby2[72] = (byte)(arrby2[72] | 8);
            arrby2[91] = (byte)(arrby2[91] | 8);
            arrby2[107] = (byte)(arrby2[107] | 1);
            arrby2[112] = (byte)(arrby2[112] | 1);
            arrby2[123] = (byte)(arrby2[123] | 0x10);
        }
        if ((by & 0x20) != 0) {
            arrby2[3] = (byte)(arrby2[3] | 8);
            arrby2[10] = (byte)(arrby2[10] | 2);
            arrby2[16] = (byte)(arrby2[16] | 2);
            arrby2[25] = (byte)(arrby2[25] | 4);
            arrby2[35] = (byte)(arrby2[35] | 0x10);
            arrby2[40] = (byte)(arrby2[40] | 4);
            arrby2[59] = (byte)(arrby2[59] | 2);
            arrby2[65] = (byte)(arrby2[65] | 8);
            arrby2[74] = (byte)(arrby2[74] | 8);
            arrby2[83] = (byte)(arrby2[83] | 0x20);
            arrby2[89] = (byte)(arrby2[89] | 2);
            arrby2[98] = (byte)(arrby2[98] | 0x10);
            arrby2[104] = (byte)(arrby2[104] | 8);
            arrby2[121] = (byte)(arrby2[121] | 0x10);
        }
        if ((by & 0x10) != 0) {
            arrby2[4] = (byte)(arrby2[4] | 2);
            arrby2[13] = (byte)(arrby2[13] | 4);
            arrby2[22] = (byte)(arrby2[22] | 2);
            arrby2[28] = (byte)(arrby2[28] | 0x10);
            arrby2[37] = (byte)(arrby2[37] | 8);
            arrby2[52] = (byte)(arrby2[52] | 1);
            arrby2[62] = (byte)(arrby2[62] | 4);
            arrby2[79] = (byte)(arrby2[79] | 8);
            arrby2[86] = (byte)(arrby2[86] | 0x10);
            arrby2[95] = (byte)(arrby2[95] | 0x20);
            arrby2[101] = (byte)(arrby2[101] | 1);
            arrby2[110] = (byte)(arrby2[110] | 8);
            arrby2[126] = (byte)(arrby2[126] | 0x20);
        }
        if ((by & 8) != 0) {
            arrby2[5] = (byte)(arrby2[5] | 0x20);
            arrby2[12] = (byte)(arrby2[12] | 0x10);
            arrby2[21] = (byte)(arrby2[21] | 8);
            arrby2[36] = (byte)(arrby2[36] | 1);
            arrby2[46] = (byte)(arrby2[46] | 4);
            arrby2[52] = (byte)(arrby2[52] | 8);
            arrby2[70] = (byte)(arrby2[70] | 0x10);
            arrby2[79] = (byte)(arrby2[79] | 0x20);
            arrby2[85] = (byte)(arrby2[85] | 1);
            arrby2[94] = (byte)(arrby2[94] | 8);
            arrby2[108] = (byte)(arrby2[108] | 2);
            arrby2[119] = (byte)(arrby2[119] | 4);
            arrby2[126] = (byte)(arrby2[126] | 2);
        }
        if ((by & 4) != 0) {
            arrby2[5] = (byte)(arrby2[5] | 2);
            arrby2[14] = (byte)(arrby2[14] | 4);
            arrby2[20] = (byte)(arrby2[20] | 8);
            arrby2[37] = (byte)(arrby2[37] | 0x10);
            arrby2[44] = (byte)(arrby2[44] | 4);
            arrby2[55] = (byte)(arrby2[55] | 0x10);
            arrby2[60] = (byte)(arrby2[60] | 0x20);
            arrby2[76] = (byte)(arrby2[76] | 2);
            arrby2[87] = (byte)(arrby2[87] | 4);
            arrby2[93] = (byte)(arrby2[93] | 0x20);
            arrby2[103] = (byte)(arrby2[103] | 1);
            arrby2[110] = (byte)(arrby2[110] | 1);
            arrby2[119] = (byte)(arrby2[119] | 2);
            arrby2[124] = (byte)(arrby2[124] | 1);
        }
        if ((by & 2) != 0) {
            arrby2[7] = (byte)(arrby2[7] | 0x20);
            arrby2[12] = (byte)(arrby2[12] | 4);
            arrby2[23] = (byte)(arrby2[23] | 0x10);
            arrby2[28] = (byte)(arrby2[28] | 0x20);
            arrby2[38] = (byte)(arrby2[38] | 0x20);
            arrby2[45] = (byte)(arrby2[45] | 4);
            arrby2[54] = (byte)(arrby2[54] | 2);
            arrby2[60] = (byte)(arrby2[60] | 0x10);
            arrby2[71] = (byte)(arrby2[71] | 1);
            arrby2[78] = (byte)(arrby2[78] | 1);
            arrby2[87] = (byte)(arrby2[87] | 2);
            arrby2[93] = (byte)(arrby2[93] | 2);
            arrby2[111] = (byte)(arrby2[111] | 8);
            arrby2[118] = (byte)(arrby2[118] | 0x10);
            arrby2[125] = (byte)(arrby2[125] | 0x10);
        }
        if (((by = arrby[4]) & 0x80) != 0) {
            arrby2[1] = (byte)(arrby2[1] | 1);
            arrby2[11] = (byte)(arrby2[11] | 0x20);
            arrby2[17] = (byte)(arrby2[17] | 2);
            arrby2[26] = (byte)(arrby2[26] | 0x10);
            arrby2[32] = (byte)(arrby2[32] | 8);
            arrby2[51] = (byte)(arrby2[51] | 8);
            arrby2[64] = (byte)(arrby2[64] | 2);
            arrby2[73] = (byte)(arrby2[73] | 4);
            arrby2[83] = (byte)(arrby2[83] | 0x10);
            arrby2[88] = (byte)(arrby2[88] | 4);
            arrby2[107] = (byte)(arrby2[107] | 2);
            arrby2[112] = (byte)(arrby2[112] | 0x20);
            arrby2[122] = (byte)(arrby2[122] | 8);
        }
        if ((by & 0x40) != 0) {
            arrby2[0] = (byte)(arrby2[0] | 4);
            arrby2[9] = (byte)(arrby2[9] | 0x20);
            arrby2[18] = (byte)(arrby2[18] | 0x20);
            arrby2[25] = (byte)(arrby2[25] | 8);
            arrby2[34] = (byte)(arrby2[34] | 8);
            arrby2[43] = (byte)(arrby2[43] | 0x20);
            arrby2[49] = (byte)(arrby2[49] | 2);
            arrby2[58] = (byte)(arrby2[58] | 0x10);
            arrby2[74] = (byte)(arrby2[74] | 1);
            arrby2[81] = (byte)(arrby2[81] | 0x10);
            arrby2[90] = (byte)(arrby2[90] | 2);
            arrby2[96] = (byte)(arrby2[96] | 2);
            arrby2[105] = (byte)(arrby2[105] | 4);
            arrby2[115] = (byte)(arrby2[115] | 0x10);
            arrby2[122] = (byte)(arrby2[122] | 4);
        }
        if ((by & 0x20) != 0) {
            arrby2[2] = (byte)(arrby2[2] | 2);
            arrby2[19] = (byte)(arrby2[19] | 1);
            arrby2[24] = (byte)(arrby2[24] | 1);
            arrby2[34] = (byte)(arrby2[34] | 4);
            arrby2[41] = (byte)(arrby2[41] | 0x20);
            arrby2[50] = (byte)(arrby2[50] | 0x20);
            arrby2[57] = (byte)(arrby2[57] | 8);
            arrby2[64] = (byte)(arrby2[64] | 0x20);
            arrby2[73] = (byte)(arrby2[73] | 1);
            arrby2[80] = (byte)(arrby2[80] | 0x10);
            arrby2[91] = (byte)(arrby2[91] | 4);
            arrby2[106] = (byte)(arrby2[106] | 1);
            arrby2[113] = (byte)(arrby2[113] | 0x10);
            arrby2[123] = (byte)(arrby2[123] | 8);
        }
        if ((by & 0x10) != 0) {
            arrby2[3] = (byte)(arrby2[3] | 4);
            arrby2[10] = (byte)(arrby2[10] | 0x10);
            arrby2[16] = (byte)(arrby2[16] | 8);
            arrby2[35] = (byte)(arrby2[35] | 8);
            arrby2[51] = (byte)(arrby2[51] | 1);
            arrby2[56] = (byte)(arrby2[56] | 1);
            arrby2[67] = (byte)(arrby2[67] | 0x10);
            arrby2[72] = (byte)(arrby2[72] | 4);
            arrby2[91] = (byte)(arrby2[91] | 2);
            arrby2[96] = (byte)(arrby2[96] | 0x20);
            arrby2[105] = (byte)(arrby2[105] | 1);
            arrby2[112] = (byte)(arrby2[112] | 0x10);
            arrby2[121] = (byte)(arrby2[121] | 2);
        }
        if ((by & 8) != 0) {
            arrby2[4] = (byte)(arrby2[4] | 0x10);
            arrby2[15] = (byte)(arrby2[15] | 1);
            arrby2[22] = (byte)(arrby2[22] | 1);
            arrby2[31] = (byte)(arrby2[31] | 2);
            arrby2[37] = (byte)(arrby2[37] | 2);
            arrby2[55] = (byte)(arrby2[55] | 8);
            arrby2[62] = (byte)(arrby2[62] | 0x10);
            arrby2[69] = (byte)(arrby2[69] | 0x10);
            arrby2[76] = (byte)(arrby2[76] | 4);
            arrby2[87] = (byte)(arrby2[87] | 0x10);
            arrby2[92] = (byte)(arrby2[92] | 0x20);
            arrby2[102] = (byte)(arrby2[102] | 0x20);
            arrby2[109] = (byte)(arrby2[109] | 4);
            arrby2[118] = (byte)(arrby2[118] | 2);
            arrby2[125] = (byte)(arrby2[125] | 0x20);
        }
        if ((by & 4) != 0) {
            arrby2[6] = (byte)(arrby2[6] | 4);
            arrby2[23] = (byte)(arrby2[23] | 8);
            arrby2[30] = (byte)(arrby2[30] | 0x10);
            arrby2[39] = (byte)(arrby2[39] | 0x20);
            arrby2[45] = (byte)(arrby2[45] | 1);
            arrby2[54] = (byte)(arrby2[54] | 8);
            arrby2[70] = (byte)(arrby2[70] | 0x20);
            arrby2[77] = (byte)(arrby2[77] | 4);
            arrby2[86] = (byte)(arrby2[86] | 2);
            arrby2[92] = (byte)(arrby2[92] | 0x10);
            arrby2[101] = (byte)(arrby2[101] | 8);
            arrby2[116] = (byte)(arrby2[116] | 1);
            arrby2[125] = (byte)(arrby2[125] | 2);
        }
        if ((by & 2) != 0) {
            arrby2[4] = (byte)(arrby2[4] | 4);
            arrby2[13] = (byte)(arrby2[13] | 1);
            arrby2[22] = (byte)(arrby2[22] | 8);
            arrby2[36] = (byte)(arrby2[36] | 2);
            arrby2[47] = (byte)(arrby2[47] | 4);
            arrby2[53] = (byte)(arrby2[53] | 0x20);
            arrby2[63] = (byte)(arrby2[63] | 1);
            arrby2[69] = (byte)(arrby2[69] | 8);
            arrby2[84] = (byte)(arrby2[84] | 1);
            arrby2[94] = (byte)(arrby2[94] | 4);
            arrby2[100] = (byte)(arrby2[100] | 8);
            arrby2[117] = (byte)(arrby2[117] | 0x10);
            arrby2[127] = (byte)(arrby2[127] | 0x20);
        }
        if (((by = arrby[5]) & 0x80) != 0) {
            arrby2[3] = (byte)(arrby2[3] | 0x20);
            arrby2[8] = (byte)(arrby2[8] | 0x10);
            arrby2[19] = (byte)(arrby2[19] | 4);
            arrby2[34] = (byte)(arrby2[34] | 1);
            arrby2[41] = (byte)(arrby2[41] | 0x10);
            arrby2[50] = (byte)(arrby2[50] | 2);
            arrby2[56] = (byte)(arrby2[56] | 2);
            arrby2[67] = (byte)(arrby2[67] | 1);
            arrby2[72] = (byte)(arrby2[72] | 1);
            arrby2[82] = (byte)(arrby2[82] | 4);
            arrby2[89] = (byte)(arrby2[89] | 0x20);
            arrby2[98] = (byte)(arrby2[98] | 0x20);
            arrby2[105] = (byte)(arrby2[105] | 8);
            arrby2[114] = (byte)(arrby2[114] | 8);
            arrby2[121] = (byte)(arrby2[121] | 1);
        }
        if ((by & 0x40) != 0) {
            arrby2[1] = (byte)(arrby2[1] | 0x20);
            arrby2[19] = (byte)(arrby2[19] | 2);
            arrby2[24] = (byte)(arrby2[24] | 0x20);
            arrby2[33] = (byte)(arrby2[33] | 1);
            arrby2[40] = (byte)(arrby2[40] | 0x10);
            arrby2[51] = (byte)(arrby2[51] | 4);
            arrby2[64] = (byte)(arrby2[64] | 8);
            arrby2[83] = (byte)(arrby2[83] | 8);
            arrby2[99] = (byte)(arrby2[99] | 1);
            arrby2[104] = (byte)(arrby2[104] | 1);
            arrby2[114] = (byte)(arrby2[114] | 4);
            arrby2[120] = (byte)(arrby2[120] | 4);
        }
        if ((by & 0x20) != 0) {
            arrby2[8] = (byte)(arrby2[8] | 2);
            arrby2[17] = (byte)(arrby2[17] | 4);
            arrby2[27] = (byte)(arrby2[27] | 0x10);
            arrby2[32] = (byte)(arrby2[32] | 4);
            arrby2[51] = (byte)(arrby2[51] | 2);
            arrby2[56] = (byte)(arrby2[56] | 0x20);
            arrby2[66] = (byte)(arrby2[66] | 8);
            arrby2[75] = (byte)(arrby2[75] | 0x20);
            arrby2[81] = (byte)(arrby2[81] | 2);
            arrby2[90] = (byte)(arrby2[90] | 0x10);
            arrby2[96] = (byte)(arrby2[96] | 8);
            arrby2[115] = (byte)(arrby2[115] | 8);
            arrby2[122] = (byte)(arrby2[122] | 2);
        }
        if ((by & 0x10) != 0) {
            arrby2[2] = (byte)(arrby2[2] | 0x10);
            arrby2[18] = (byte)(arrby2[18] | 1);
            arrby2[25] = (byte)(arrby2[25] | 0x10);
            arrby2[34] = (byte)(arrby2[34] | 2);
            arrby2[40] = (byte)(arrby2[40] | 2);
            arrby2[49] = (byte)(arrby2[49] | 4);
            arrby2[59] = (byte)(arrby2[59] | 0x10);
            arrby2[66] = (byte)(arrby2[66] | 4);
            arrby2[73] = (byte)(arrby2[73] | 0x20);
            arrby2[82] = (byte)(arrby2[82] | 0x20);
            arrby2[89] = (byte)(arrby2[89] | 8);
            arrby2[98] = (byte)(arrby2[98] | 8);
            arrby2[107] = (byte)(arrby2[107] | 0x20);
            arrby2[113] = (byte)(arrby2[113] | 2);
            arrby2[123] = (byte)(arrby2[123] | 4);
        }
        if ((by & 8) != 0) {
            arrby2[7] = (byte)(arrby2[7] | 1);
            arrby2[13] = (byte)(arrby2[13] | 8);
            arrby2[28] = (byte)(arrby2[28] | 1);
            arrby2[38] = (byte)(arrby2[38] | 4);
            arrby2[44] = (byte)(arrby2[44] | 8);
            arrby2[61] = (byte)(arrby2[61] | 0x10);
            arrby2[71] = (byte)(arrby2[71] | 0x20);
            arrby2[77] = (byte)(arrby2[77] | 1);
            arrby2[86] = (byte)(arrby2[86] | 8);
            arrby2[100] = (byte)(arrby2[100] | 2);
            arrby2[111] = (byte)(arrby2[111] | 4);
            arrby2[117] = (byte)(arrby2[117] | 0x20);
            arrby2[124] = (byte)(arrby2[124] | 0x10);
        }
        if ((by & 4) != 0) {
            arrby2[12] = (byte)(arrby2[12] | 8);
            arrby2[29] = (byte)(arrby2[29] | 0x10);
            arrby2[36] = (byte)(arrby2[36] | 4);
            arrby2[47] = (byte)(arrby2[47] | 0x10);
            arrby2[52] = (byte)(arrby2[52] | 0x20);
            arrby2[62] = (byte)(arrby2[62] | 0x20);
            arrby2[68] = (byte)(arrby2[68] | 2);
            arrby2[79] = (byte)(arrby2[79] | 4);
            arrby2[85] = (byte)(arrby2[85] | 0x20);
            arrby2[95] = (byte)(arrby2[95] | 1);
            arrby2[102] = (byte)(arrby2[102] | 1);
            arrby2[111] = (byte)(arrby2[111] | 2);
            arrby2[117] = (byte)(arrby2[117] | 2);
            arrby2[126] = (byte)(arrby2[126] | 4);
        }
        if ((by & 2) != 0) {
            arrby2[5] = (byte)(arrby2[5] | 1);
            arrby2[15] = (byte)(arrby2[15] | 0x10);
            arrby2[20] = (byte)(arrby2[20] | 0x20);
            arrby2[30] = (byte)(arrby2[30] | 0x20);
            arrby2[37] = (byte)(arrby2[37] | 4);
            arrby2[46] = (byte)(arrby2[46] | 2);
            arrby2[52] = (byte)(arrby2[52] | 0x10);
            arrby2[61] = (byte)(arrby2[61] | 8);
            arrby2[70] = (byte)(arrby2[70] | 1);
            arrby2[79] = (byte)(arrby2[79] | 2);
            arrby2[85] = (byte)(arrby2[85] | 2);
            arrby2[103] = (byte)(arrby2[103] | 8);
            arrby2[110] = (byte)(arrby2[110] | 0x10);
            arrby2[119] = (byte)(arrby2[119] | 0x20);
            arrby2[124] = (byte)(arrby2[124] | 4);
        }
        if (((by = arrby[6]) & 0x80) != 0) {
            arrby2[0] = (byte)(arrby2[0] | 0x10);
            arrby2[9] = (byte)(arrby2[9] | 2);
            arrby2[18] = (byte)(arrby2[18] | 0x10);
            arrby2[24] = (byte)(arrby2[24] | 8);
            arrby2[43] = (byte)(arrby2[43] | 8);
            arrby2[59] = (byte)(arrby2[59] | 1);
            arrby2[65] = (byte)(arrby2[65] | 4);
            arrby2[75] = (byte)(arrby2[75] | 0x10);
            arrby2[80] = (byte)(arrby2[80] | 4);
            arrby2[99] = (byte)(arrby2[99] | 2);
            arrby2[104] = (byte)(arrby2[104] | 0x20);
            arrby2[113] = (byte)(arrby2[113] | 1);
            arrby2[123] = (byte)(arrby2[123] | 0x20);
        }
        if ((by & 0x40) != 0) {
            arrby2[10] = (byte)(arrby2[10] | 0x20);
            arrby2[17] = (byte)(arrby2[17] | 8);
            arrby2[26] = (byte)(arrby2[26] | 8);
            arrby2[35] = (byte)(arrby2[35] | 0x20);
            arrby2[41] = (byte)(arrby2[41] | 2);
            arrby2[50] = (byte)(arrby2[50] | 0x10);
            arrby2[56] = (byte)(arrby2[56] | 8);
            arrby2[66] = (byte)(arrby2[66] | 1);
            arrby2[73] = (byte)(arrby2[73] | 0x10);
            arrby2[82] = (byte)(arrby2[82] | 2);
            arrby2[88] = (byte)(arrby2[88] | 2);
            arrby2[97] = (byte)(arrby2[97] | 4);
            arrby2[107] = (byte)(arrby2[107] | 0x10);
            arrby2[112] = (byte)(arrby2[112] | 4);
            arrby2[121] = (byte)(arrby2[121] | 0x20);
        }
        if ((by & 0x20) != 0) {
            arrby2[0] = (byte)(arrby2[0] | 2);
            arrby2[11] = (byte)(arrby2[11] | 1);
            arrby2[16] = (byte)(arrby2[16] | 1);
            arrby2[26] = (byte)(arrby2[26] | 4);
            arrby2[33] = (byte)(arrby2[33] | 0x20);
            arrby2[42] = (byte)(arrby2[42] | 0x20);
            arrby2[49] = (byte)(arrby2[49] | 8);
            arrby2[58] = (byte)(arrby2[58] | 8);
            arrby2[65] = (byte)(arrby2[65] | 1);
            arrby2[72] = (byte)(arrby2[72] | 0x10);
            arrby2[83] = (byte)(arrby2[83] | 4);
            arrby2[98] = (byte)(arrby2[98] | 1);
            arrby2[105] = (byte)(arrby2[105] | 0x10);
            arrby2[114] = (byte)(arrby2[114] | 2);
        }
        if ((by & 0x10) != 0) {
            arrby2[8] = (byte)(arrby2[8] | 8);
            arrby2[27] = (byte)(arrby2[27] | 8);
            arrby2[43] = (byte)(arrby2[43] | 1);
            arrby2[48] = (byte)(arrby2[48] | 1);
            arrby2[58] = (byte)(arrby2[58] | 4);
            arrby2[64] = (byte)(arrby2[64] | 4);
            arrby2[83] = (byte)(arrby2[83] | 2);
            arrby2[88] = (byte)(arrby2[88] | 0x20);
            arrby2[97] = (byte)(arrby2[97] | 1);
            arrby2[104] = (byte)(arrby2[104] | 0x10);
            arrby2[115] = (byte)(arrby2[115] | 4);
            arrby2[122] = (byte)(arrby2[122] | 0x10);
        }
        if ((by & 8) != 0) {
            arrby2[5] = (byte)(arrby2[5] | 8);
            arrby2[14] = (byte)(arrby2[14] | 1);
            arrby2[23] = (byte)(arrby2[23] | 2);
            arrby2[29] = (byte)(arrby2[29] | 2);
            arrby2[47] = (byte)(arrby2[47] | 8);
            arrby2[54] = (byte)(arrby2[54] | 0x10);
            arrby2[63] = (byte)(arrby2[63] | 0x20);
            arrby2[68] = (byte)(arrby2[68] | 4);
            arrby2[79] = (byte)(arrby2[79] | 0x10);
            arrby2[84] = (byte)(arrby2[84] | 0x20);
            arrby2[94] = (byte)(arrby2[94] | 0x20);
            arrby2[101] = (byte)(arrby2[101] | 4);
            arrby2[110] = (byte)(arrby2[110] | 2);
            arrby2[116] = (byte)(arrby2[116] | 0x10);
            arrby2[127] = (byte)(arrby2[127] | 1);
        }
        if ((by & 4) != 0) {
            arrby2[4] = (byte)(arrby2[4] | 8);
            arrby2[15] = (byte)(arrby2[15] | 8);
            arrby2[22] = (byte)(arrby2[22] | 0x10);
            arrby2[31] = (byte)(arrby2[31] | 0x20);
            arrby2[37] = (byte)(arrby2[37] | 1);
            arrby2[46] = (byte)(arrby2[46] | 8);
            arrby2[60] = (byte)(arrby2[60] | 2);
            arrby2[69] = (byte)(arrby2[69] | 4);
            arrby2[78] = (byte)(arrby2[78] | 2);
            arrby2[84] = (byte)(arrby2[84] | 0x10);
            arrby2[93] = (byte)(arrby2[93] | 8);
            arrby2[108] = (byte)(arrby2[108] | 1);
            arrby2[118] = (byte)(arrby2[118] | 4);
        }
        if ((by & 2) != 0) {
            arrby2[7] = (byte)(arrby2[7] | 0x10);
            arrby2[14] = (byte)(arrby2[14] | 8);
            arrby2[28] = (byte)(arrby2[28] | 2);
            arrby2[39] = (byte)(arrby2[39] | 4);
            arrby2[45] = (byte)(arrby2[45] | 0x20);
            arrby2[55] = (byte)(arrby2[55] | 1);
            arrby2[62] = (byte)(arrby2[62] | 1);
            arrby2[76] = (byte)(arrby2[76] | 1);
            arrby2[86] = (byte)(arrby2[86] | 4);
            arrby2[92] = (byte)(arrby2[92] | 8);
            arrby2[109] = (byte)(arrby2[109] | 0x10);
            arrby2[116] = (byte)(arrby2[116] | 4);
            arrby2[125] = (byte)(arrby2[125] | 1);
        }
        if (((by = arrby[7]) & 0x80) != 0) {
            arrby2[1] = (byte)(arrby2[1] | 2);
            arrby2[11] = (byte)(arrby2[11] | 4);
            arrby2[26] = (byte)(arrby2[26] | 1);
            arrby2[33] = (byte)(arrby2[33] | 0x10);
            arrby2[42] = (byte)(arrby2[42] | 2);
            arrby2[48] = (byte)(arrby2[48] | 2);
            arrby2[57] = (byte)(arrby2[57] | 4);
            arrby2[64] = (byte)(arrby2[64] | 1);
            arrby2[74] = (byte)(arrby2[74] | 4);
            arrby2[81] = (byte)(arrby2[81] | 0x20);
            arrby2[90] = (byte)(arrby2[90] | 0x20);
            arrby2[97] = (byte)(arrby2[97] | 8);
            arrby2[106] = (byte)(arrby2[106] | 8);
            arrby2[115] = (byte)(arrby2[115] | 0x20);
            arrby2[120] = (byte)(arrby2[120] | 0x10);
        }
        if ((by & 0x40) != 0) {
            arrby2[2] = (byte)(arrby2[2] | 0x20);
            arrby2[11] = (byte)(arrby2[11] | 2);
            arrby2[16] = (byte)(arrby2[16] | 0x20);
            arrby2[25] = (byte)(arrby2[25] | 1);
            arrby2[32] = (byte)(arrby2[32] | 0x10);
            arrby2[43] = (byte)(arrby2[43] | 4);
            arrby2[58] = (byte)(arrby2[58] | 1);
            arrby2[75] = (byte)(arrby2[75] | 8);
            arrby2[91] = (byte)(arrby2[91] | 1);
            arrby2[96] = (byte)(arrby2[96] | 1);
            arrby2[106] = (byte)(arrby2[106] | 4);
            arrby2[113] = (byte)(arrby2[113] | 0x20);
        }
        if ((by & 0x20) != 0) {
            arrby2[3] = (byte)(arrby2[3] | 1);
            arrby2[9] = (byte)(arrby2[9] | 4);
            arrby2[19] = (byte)(arrby2[19] | 0x10);
            arrby2[24] = (byte)(arrby2[24] | 4);
            arrby2[43] = (byte)(arrby2[43] | 2);
            arrby2[48] = (byte)(arrby2[48] | 0x20);
            arrby2[57] = (byte)(arrby2[57] | 1);
            arrby2[67] = (byte)(arrby2[67] | 0x20);
            arrby2[73] = (byte)(arrby2[73] | 2);
            arrby2[82] = (byte)(arrby2[82] | 0x10);
            arrby2[88] = (byte)(arrby2[88] | 8);
            arrby2[107] = (byte)(arrby2[107] | 8);
            arrby2[120] = (byte)(arrby2[120] | 2);
        }
        if ((by & 0x10) != 0) {
            arrby2[0] = (byte)(arrby2[0] | 8);
            arrby2[10] = (byte)(arrby2[10] | 1);
            arrby2[17] = (byte)(arrby2[17] | 0x10);
            arrby2[26] = (byte)(arrby2[26] | 2);
            arrby2[32] = (byte)(arrby2[32] | 2);
            arrby2[41] = (byte)(arrby2[41] | 4);
            arrby2[51] = (byte)(arrby2[51] | 0x10);
            arrby2[56] = (byte)(arrby2[56] | 4);
            arrby2[65] = (byte)(arrby2[65] | 0x20);
            arrby2[74] = (byte)(arrby2[74] | 0x20);
            arrby2[81] = (byte)(arrby2[81] | 8);
            arrby2[90] = (byte)(arrby2[90] | 8);
            arrby2[99] = (byte)(arrby2[99] | 0x20);
            arrby2[105] = (byte)(arrby2[105] | 2);
            arrby2[114] = (byte)(arrby2[114] | 0x10);
        }
        if ((by & 8) != 0) {
            arrby2[6] = (byte)(arrby2[6] | 1);
            arrby2[20] = (byte)(arrby2[20] | 1);
            arrby2[30] = (byte)(arrby2[30] | 4);
            arrby2[36] = (byte)(arrby2[36] | 8);
            arrby2[53] = (byte)(arrby2[53] | 0x10);
            arrby2[60] = (byte)(arrby2[60] | 4);
            arrby2[69] = (byte)(arrby2[69] | 1);
            arrby2[78] = (byte)(arrby2[78] | 8);
            arrby2[92] = (byte)(arrby2[92] | 2);
            arrby2[103] = (byte)(arrby2[103] | 4);
            arrby2[109] = (byte)(arrby2[109] | 0x20);
            arrby2[119] = (byte)(arrby2[119] | 1);
            arrby2[125] = (byte)(arrby2[125] | 8);
        }
        if ((by & 4) != 0) {
            arrby2[7] = (byte)(arrby2[7] | 8);
            arrby2[21] = (byte)(arrby2[21] | 0x10);
            arrby2[28] = (byte)(arrby2[28] | 4);
            arrby2[39] = (byte)(arrby2[39] | 0x10);
            arrby2[44] = (byte)(arrby2[44] | 0x20);
            arrby2[54] = (byte)(arrby2[54] | 0x20);
            arrby2[61] = (byte)(arrby2[61] | 4);
            arrby2[71] = (byte)(arrby2[71] | 4);
            arrby2[77] = (byte)(arrby2[77] | 0x20);
            arrby2[87] = (byte)(arrby2[87] | 1);
            arrby2[94] = (byte)(arrby2[94] | 1);
            arrby2[103] = (byte)(arrby2[103] | 2);
            arrby2[109] = (byte)(arrby2[109] | 2);
            arrby2[124] = (byte)(arrby2[124] | 8);
        }
        if ((by & 2) != 0) {
            arrby2[6] = (byte)(arrby2[6] | 8);
            arrby2[12] = (byte)(arrby2[12] | 0x20);
            arrby2[22] = (byte)(arrby2[22] | 0x20);
            arrby2[29] = (byte)(arrby2[29] | 4);
            arrby2[38] = (byte)(arrby2[38] | 2);
            arrby2[44] = (byte)(arrby2[44] | 0x10);
            arrby2[53] = (byte)(arrby2[53] | 8);
            arrby2[71] = (byte)(arrby2[71] | 2);
            arrby2[77] = (byte)(arrby2[77] | 2);
            arrby2[95] = (byte)(arrby2[95] | 8);
            arrby2[102] = (byte)(arrby2[102] | 0x10);
            arrby2[111] = (byte)(arrby2[111] | 0x20);
            arrby2[117] = (byte)(arrby2[117] | 1);
            arrby2[127] = (byte)(arrby2[127] | 0x10);
        }
        this.expandedKey = arrby2;
    }
}

