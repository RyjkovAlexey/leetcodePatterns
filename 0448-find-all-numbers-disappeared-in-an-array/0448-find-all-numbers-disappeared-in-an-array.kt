class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val result = mutableListOf<Int>()
        val n = nums.size
        for (i in 0 until n) {
            val index = Math.abs(nums[i]) - 1
            if (nums[index] > 0) {
                nums[index] = -nums[index]
            }
        }
        for (i in 0 until n) {
            if (nums[i] > 0) {
                result.add(i + 1)
            }
        }
        return result
    }
}