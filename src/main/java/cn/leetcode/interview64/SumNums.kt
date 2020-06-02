package cn.leetcode.interview64

/**
 * @author huangsy
 * @date 2020/6/2 8:43
 */
class SumNums {

    fun sumNums(n: Int): Int {
        var sum = n
        val flag = n > 0 && sumNums(n - 1).let { sum += it; sum } > 0
        return sum
    }
}