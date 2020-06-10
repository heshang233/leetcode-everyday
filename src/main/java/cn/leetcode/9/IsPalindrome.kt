package cn.leetcode.`9`

/**
 * @author huangsy
 * @date 2020/6/10 9:40
 */
class IsPalindrome {

    fun isPalindrome(x: Int): Boolean {
        var x = x
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false
        }
        var m = 0
        while (x > m) {
            m = m * 10 + x % 10
            x = x / 10
        }
        return m == x || m / 10 == x
    }
}