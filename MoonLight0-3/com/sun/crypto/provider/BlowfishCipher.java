/*
 * Decompiled with CFR 0.150.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.BlowfishCrypt;
import com.sun.crypto.provider.CipherCore;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;

public final class BlowfishCipher
extends CipherSpi {
    private CipherCore core = new CipherCore(new BlowfishCrypt(), 8);

    @Override
    protected void engineSetMode(String string) throws NoSuchAlgorithmException {
        this.core.setMode(string);
    }

    @Override
    protected void engineSetPadding(String string) throws NoSuchPaddingException {
        this.core.setPadding(string);
    }

    @Override
    protected int engineGetBlockSize() {
        return 8;
    }

    @Override
    protected int engineGetOutputSize(int n) {
        return this.core.getOutputSize(n);
    }

    @Override
    protected byte[] engineGetIV() {
        return this.core.getIV();
    }

    @Override
    protected AlgorithmParameters engineGetParameters() {
        return this.core.getParameters("Blowfish");
    }

    @Override
    protected void engineInit(int n, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        this.core.init(n, key, secureRandom);
    }

    @Override
    protected void engineInit(int n, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.core.init(n, key, algorithmParameterSpec, secureRandom);
    }

    @Override
    protected void engineInit(int n, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.core.init(n, key, algorithmParameters, secureRandom);
    }

    @Override
    protected byte[] engineUpdate(byte[] arrby, int n, int n2) {
        return this.core.update(arrby, n, n2);
    }

    @Override
    protected int engineUpdate(byte[] arrby, int n, int n2, byte[] arrby2, int n3) throws ShortBufferException {
        return this.core.update(arrby, n, n2, arrby2, n3);
    }

    @Override
    protected byte[] engineDoFinal(byte[] arrby, int n, int n2) throws IllegalBlockSizeException, BadPaddingException {
        return this.core.doFinal(arrby, n, n2);
    }

    @Override
    protected int engineDoFinal(byte[] arrby, int n, int n2, byte[] arrby2, int n3) throws IllegalBlockSizeException, ShortBufferException, BadPaddingException {
        return this.core.doFinal(arrby, n, n2, arrby2, n3);
    }

    @Override
    protected int engineGetKeySize(Key key) throws InvalidKeyException {
        return key.getEncoded().length * 8;
    }

    @Override
    protected byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        return this.core.wrap(key);
    }

    @Override
    protected Key engineUnwrap(byte[] arrby, String string, int n) throws InvalidKeyException, NoSuchAlgorithmException {
        return this.core.unwrap(arrby, string, n);
    }
}

