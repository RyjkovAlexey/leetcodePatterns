class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        return (1..nums.size).filter { !nums.contains(it) }
    }
}