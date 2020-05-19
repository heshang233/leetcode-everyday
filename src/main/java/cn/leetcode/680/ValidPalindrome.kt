package cn.leetcode.`680`

import cn.huangsy.ValidPalindrome

/**
 * @author huangsy
 * @date 2020/5/19 8:33
 */
class ValidPalindrome {

    fun validPalindrome(s: String): Boolean {
        val chars = s.toCharArray()
        var i = 0
        var j = chars.size - 1
        while (i < j) {
            if (chars[i] != chars[j]) {
                return isValid(chars, i, j-1) || isValid(chars, i+1, j)
            }
            i++
            j--
        }
        return chars[i + 1] != chars[j - 2] || chars[i + 2] != chars[j - 1]
    }

    private fun isValid(chars: CharArray, i: Int, j: Int): Boolean {
        var i = i
        var j = j
        while (i < j) {
            if (chars[i] != chars[j]) {
                return false
            }
            i++
            j--

        }
        return true
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val validPalindrome = ValidPalindrome()
            println(validPalindrome.validPalindrome("eeccccbebaeeabebccceea"))
            println(validPalindrome.validPalindrome("ebcbbececabbacecbbcbe"))
            println(validPalindrome.validPalindrome("deeee"))
            println(validPalindrome.validPalindrome("abca"))
        }
    }
}