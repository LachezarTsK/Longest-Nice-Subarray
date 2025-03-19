
/**
 * @param {number[]} input
 * @return {number}
 */
var longestNiceSubarray = function (input) {
    const RANGE_OF_VALUES = [1, Math.pow(10, 9)];
    const MAX_BIT_COUNT = 1 + Math.floor(Math.log2(RANGE_OF_VALUES[1]));

    let front = 0;
    let back = 0;
    let maxSizeSubarray = 0;
    let xorBitStampSubarray = 0;

    while (front < input.length && maxSizeSubarray < MAX_BIT_COUNT) {
        while (back < front && (xorBitStampSubarray & input[front]) !== 0) {
            xorBitStampSubarray ^= input[back];
            ++back;
        }
        xorBitStampSubarray ^= input[front];
        maxSizeSubarray = Math.max(maxSizeSubarray, front - back + 1);
        ++front;
    }
    return maxSizeSubarray;
};
