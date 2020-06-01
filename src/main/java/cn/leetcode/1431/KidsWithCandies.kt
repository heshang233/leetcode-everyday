package cn.leetcode.`1431`

import java.util.*

/**
 * @author huangsy
 * @date 2020/6/1 8:36
 */
class KidsWithCandies {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean>? {
        val result: MutableList<Boolean> = ArrayList()
        var max = 0
        for (candy in candies) {
            max = Math.max(candy, max)
        }
        for (candy in candies) {
            if (candy + extraCandies >= extraCandies) {
                result.add(true)
            } else {
                result.add(false)
            }
        }
        return result
    }

}