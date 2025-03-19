
#include <cmath>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {

    inline static array<int, 2> RANGE_OF_VALUES = { 1, static_cast<int>(pow(10, 9)) };
    inline static int MAX_BIT_COUNT = 1 + static_cast<int>(log2(RANGE_OF_VALUES[1]));

public:
    int longestNiceSubarray(const vector<int>& input) const {
        int front = 0;
        int back = 0;
        int maxSizeSubarray = 0;
        int xorBitStampSubarray = 0;

        while (front < input.size() && maxSizeSubarray < MAX_BIT_COUNT) {
            while (back < front && (xorBitStampSubarray & input[front]) != 0) {
                xorBitStampSubarray ^= input[back];
                ++back;
            }
            xorBitStampSubarray ^= input[front];
            maxSizeSubarray = max(maxSizeSubarray, front - back + 1);
            ++front;
        }
        return maxSizeSubarray;
    }
};
