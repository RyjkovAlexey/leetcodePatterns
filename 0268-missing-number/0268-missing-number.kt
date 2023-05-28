class Solution {
    fun missingNumber(nums: IntArray): Int {
        val map = mutableMapOf<Int, Boolean>()

        for (i in nums) {
            map[i] = true
        }

        for (i in 0..nums.size)
            if (!map.containsKey(i)) return i

        return -1
    }
}