package ru.nsu.fit.sokolova.algorithm;

import ru.nsu.fit.sokolova.algorithm.keys.OpenKey;
import ru.nsu.fit.sokolova.algorithm.keys.SecretKey;

import java.math.BigInteger;

public class Receiver
{
    private OpenKey openKey_;
    private SecretKey secretKey_;

    public Receiver()
    {
        generateKeys();
    }

    private void generateKeys()
    {
        int p = MathUtils.generateRandomPrimeNumber();
        int q = MathUtils.generateRandomPrimeNumber();
        int phi = MathUtils.EulerFunc(p, q);

        int e = MathUtils.findLessCoprimeNumber(phi);
        int n = p*q;

        openKey_ = new OpenKey(e, n);

        int d = MathUtils.generateD(e, phi);
        secretKey_ = new SecretKey(d, n);
    }

    public OpenKey getOpenKey()
    {
        return openKey_;
    }

    public int decryptMessage(Integer encryptedMessage)
    {
        return MathUtils.calculateMod(secretKey_.getD(), secretKey_.getN(), encryptedMessage);
    }

}
