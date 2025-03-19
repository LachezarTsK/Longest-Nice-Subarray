
import kotlin.math.pow
import kotlin.math.log2
import kotlin.math.max

class Solution {

    private companion object {
        val RANGE_OF_VALUES = intArrayOf(1, (10.0).pow(9).toInt())
        val MAX_BIT_COUNT = 1 + log2(RANGE_OF_VALUES[1].toDouble()).toInt()
    }

    fun longestNiceSubarray(input: IntArray): Int {
        var front = 0
        var back = 0
        var maxSizeSubarray = 0
        var xorBitStampSubarray = 0

        while (front < input.size && maxSizeSubarray < MAX_BIT_COUNT) {
            while (back < front && (xorBitStampSubarray and input[front]) != 0) {
                xorBitStampSubarray = xorBitStampSubarray xor input[back]
                ++back
            }
            xorBitStampSubarray = xorBitStampSubarray xor input[front]
            maxSizeSubarray = max(maxSizeSubarray, front - back + 1)
            ++front
        }
        return maxSizeSubarray
    }
}
