package ru.nsu.fit.sokolova.algorithm.keys;

public class SecretKey extends Key
{
    public SecretKey(int d, int n)
    {
        super(d, n);
    }

    public int getD()
    {
        return a_;
    }
}
