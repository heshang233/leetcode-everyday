package cn.leetcode.interview46

/**
 * @author huangsy
 * @date 2020/6/9 9:11
 */
class TranslateNum {
    fun translateNum(num: Int): Int {
        if (num <= 9) {
            return 1
        }
        val x = num % 100
        return if (x <= 9 || x >= 26) {
            translateNum(num / 10)
        } else {
            translateNum(num / 10) + translateNum(num / 100)
        }
    }
}