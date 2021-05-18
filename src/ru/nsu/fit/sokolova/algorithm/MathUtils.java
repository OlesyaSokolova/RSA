package ru.nsu.fit.sokolova.algorithm;

import java.util.ArrayList;

public class MathUtils
{
    private static final int INITIAL_PRIME_RANGE_VALUE = 2;
    private static final int END_PRIME_RANGE_VALUE = 50;

    private static final int INITIAL_K_RANGE_VALUE = 1;
    private static final double END_K_RANGE_VALUE = 10.0;

    public static int generateRandomPrimeNumber()
    {
        int a = INITIAL_PRIME_RANGE_VALUE;
        int b = END_PRIME_RANGE_VALUE;
        boolean isPrime;
        int randomNumber = 0;
        do{
            isPrime = true;
            randomNumber = a + (int) (Math.random() * b);
            for (int i = 2; i < randomNumber; i++)
            {
                if((randomNumber % i) == 0)
                {
                    isPrime = false;
                }
            }
        }
        while(!isPrime);

        return randomNumber;
    }

    public static int findLessCoprimeNumber(Integer number)
    {
        int testNumber = 2;
        ArrayList<Integer> coprimeNumbers = new ArrayList<>();

        while(testNumber < number)
        {
            if(NOD(testNumber, number) == 1)
            {
                coprimeNumbers.add(testNumber);
            }
            testNumber++;
        }
        int randomIndex = (int) (Math.random() *(coprimeNumbers.size()));
        return coprimeNumbers.get(randomIndex);
    }

    private static int NOD(int a, int b)
    {
        if (a == b)
            return a;
        else
        if (a > b)
            return NOD(a-b, b);
        else
            return NOD(b-a, a);
    }

    public static int EulerFunc(int p, int q)
    {
        return (p-1)*(q-1);
    }

    public static int generateD(int e, int phi)
    {
        int k =  INITIAL_K_RANGE_VALUE + (int) (Math.random() * END_K_RANGE_VALUE);
        while((k*phi + 1) % e != 0)
        {
            k++;
        }
        int d = (k*phi + 1) / e;
        return d;
    }

    public static int calculateMod(int exponent, int t, int base)
    {
        //base^exponent mod t = ?
        int result = 0;
        int[] exponent_2 = digitsOfBinary(exponent);
        int n = exponent_2.length;

        int sequence[] = new int[n];
        sequence[0] = base;
        for(int i = 1; i < n; i++ )
        {
            long tmp = (sequence[i-1] * sequence[i-1]);
            sequence[i] = (int)(tmp%t);
        }
        long sequenceComposition1 = calcComposition(exponent_2, sequence);

        result = (int)(sequenceComposition1%t);
        return result;
    }

    private static long calcComposition(int[] binaryDigits, int[] sequence)
    {
        long result = 1;
        for(int i = 0; i < binaryDigits.length; i++)
        {
            if(binaryDigits[i] == 1)
            {
                result *= sequence[i];
            }
        }
        return result;
    }

    private static int[] digitsOfBinary(int x)
    {
        int arraySize = (int)(Math.log(x)/Math.log(2)) + 1;
        int[] result = new int[arraySize];
        int i = 0;
        while(x >= 1)
        {
            result[i] = x%2;
            x /= 2;
            i++;
        }
        return result;
    }
}
