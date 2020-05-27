package cn.leetcode.`560`

import java.util.HashMap

/**
 * @author huangsy
 * @date 2020/5/27 14:24
 */
class SubarraySum {

    fun subarraySum(nums: IntArray, k: Int): Int {
        val map = HashMap<Int, Int>()
        map[0] = 1
        var max = 0
        var total = 0
        for (i in nums) {
            total += i
            val key = total - k
            if (map.containsKey(key)) {
                max += map[key]!!
            }
            map[total] = map.getOrDefault(total, 0) + 1
        }
        return max
    }
}