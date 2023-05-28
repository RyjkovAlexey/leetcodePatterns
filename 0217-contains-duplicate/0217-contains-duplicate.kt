class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val numbers = mutableSetOf<Int>()

        nums.forEach {
            if (numbers.contains(it)) return true
            else numbers.add(it)
        }

        return false
    }
}