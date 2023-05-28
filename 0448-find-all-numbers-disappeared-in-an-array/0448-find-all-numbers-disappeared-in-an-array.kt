class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
       val set = nums.toSet()
       return (1..nums.size).filter { !set.contains(it) }
    }
}