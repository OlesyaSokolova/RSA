package ru.nsu.fit.sokolova.algorithm.keys;

public class Key
{
    protected int a_;
    protected int b_;

    public Key(int a, int b)
    {
        a_ = a;
        b_ = b;
    }

    @Override
    public String toString()
    {
        return "{ " + a_ + ", " + b_ + " }";
    }

    public int getN()
    {
        return b_;
    }

}
