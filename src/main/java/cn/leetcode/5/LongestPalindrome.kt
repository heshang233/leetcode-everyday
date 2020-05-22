package cn.leetcode.`5`

/**
 * @author huangsy
 * @date 2020/5/21 8:34
 */
class LongestPalindrome {
    fun longestPalindrome(s : String): String {
        if (s.length < 2) {
            return s
        }
        val chars = s.toCharArray()

        var maxlength = 1
        var maxstart = 0
        for (i in 1 until chars.size - 1) {
            var m = i - 1
            var n = i + 1
            while (m >= 0 && n < chars.size && chars[m] == chars[n]) {
                maxlength = Math.max(maxlength, n - m + 1)
                m--
                n++
            }
            if (m != i - 1 && n != i + 1 && maxlength <= n - m - 1) {
                maxstart = m + 1
            }
            m = i
            n = i + 1
            while (m >= 0 && n < chars.size && chars[m] == chars[n]) {
                maxlength = Math.max(maxlength, n - m + 1)
                m--
                n++
            }
            if (m != i && n != i + 1 && maxlength <= n - m - 1) {
                maxstart = m + 1
            }
        }

        return s.substring(maxstart, maxstart + maxlength)
    }
}