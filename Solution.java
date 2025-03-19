
public class Solution {

    private static final int[] RANGE_OF_VALUES = {1, (int) Math.pow(10, 9)};
    private static final int MAX_BIT_COUNT = 1 + (int) (Math.log(RANGE_OF_VALUES[1]) / Math.log(2));

    public int longestNiceSubarray(int[] input) {
        int front = 0;
        int back = 0;
        int maxSizeSubarray = 0;
        int xorBitStampSubarray = 0;

        while (front < input.length && maxSizeSubarray < MAX_BIT_COUNT) {
            while (back < front && (xorBitStampSubarray & input[front]) != 0) {
                xorBitStampSubarray ^= input[back];
                ++back;
            }
            xorBitStampSubarray ^= input[front];
            maxSizeSubarray = Math.max(maxSizeSubarray, front - back + 1);
            ++front;
        }
        return maxSizeSubarray;
    }
}
