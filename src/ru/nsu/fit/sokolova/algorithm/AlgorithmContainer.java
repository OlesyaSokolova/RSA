package ru.nsu.fit.sokolova.algorithm;

import ru.nsu.fit.sokolova.algorithm.keys.OpenKey;

public class AlgorithmContainer
{
    private Receiver receiver_;
    private Sender sender_;

    private int originalMessage_;
    private int decryptedMessage_;

    public AlgorithmContainer()
    {
        receiver_ = new Receiver();
    }
    public void perform(int originalMessage)
    {
        originalMessage_ = originalMessage;
        sender_ = new Sender(originalMessage);
        int encryptedMessage = sender_.encryptMessage(receiver_.getOpenKey());
        decryptedMessage_ = receiver_.decryptMessage(encryptedMessage);
    }

    public OpenKey getOpenKey()
    {
        return receiver_.getOpenKey();
    }

    public int getDecryptedMessage()
    {
        return decryptedMessage_;
    }

    public int getOriginalMessage()
    {
        return originalMessage_;
    }
}
