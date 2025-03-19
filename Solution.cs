
using System;

public class Solution
{
    private static readonly int[] RANGE_OF_VALUES = { 1, (int)Math.Pow(10, 9) };
    private static readonly int MAX_BIT_COUNT = 1 + (int)(Math.Log2(RANGE_OF_VALUES[1]));

    public int LongestNiceSubarray(int[] input)
    {
        int front = 0;
        int back = 0;
        int maxSizeSubarray = 0;
        int xorBitStampSubarray = 0;

        while (front < input.Length && maxSizeSubarray < MAX_BIT_COUNT)
        {
            while (back < front && (xorBitStampSubarray & input[front]) != 0)
            {
                xorBitStampSubarray ^= input[back];
                ++back;
            }
            xorBitStampSubarray ^= input[front];
            maxSizeSubarray = Math.Max(maxSizeSubarray, front - back + 1);
            ++front;
        }
        return maxSizeSubarray;
    }
}
