class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val map = mutableMapOf<Int, Boolean>()

        for (number in 1..nums.size) {
            map[number] = false
        }

        nums.forEach {
            if (map.containsKey(it)) {
                map[it] = true
            }
        }

        return map.filter { !it.value }.keys.toList()
    }
}