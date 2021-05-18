package ru.nsu.fit.sokolova.algorithm;

import ru.nsu.fit.sokolova.algorithm.keys.OpenKey;

public class Sender
{
    private Integer originalMessage_;

    public Sender(int originalMessage)
    {
        originalMessage_ = originalMessage;
    }

    public int encryptMessage(OpenKey key)
    {
        return MathUtils.calculateMod(key.getE(), key.getN(), originalMessage_);
    }
}
