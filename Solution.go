
package main
import "math"

var RANGE_OF_VALUES = [2]int{1, int(math.Pow(10.0, 9.0))}
var MAX_BIT_COUNT = 1 + int(math.Log2(float64(RANGE_OF_VALUES[1])))

func longestNiceSubarray(input []int) int {
    front := 0
    back := 0
    maxSizeSubarray := 0
    xorBitStampSubarray := 0

    for front < len(input) && maxSizeSubarray < MAX_BIT_COUNT {
        for back < front && (xorBitStampSubarray & input[front]) != 0 {
            xorBitStampSubarray = xorBitStampSubarray ^ input[back]
            back++
        }
        xorBitStampSubarray = xorBitStampSubarray ^ input[front]
        maxSizeSubarray = max(maxSizeSubarray, front - back + 1)
        front++
    }
    return maxSizeSubarray
}
