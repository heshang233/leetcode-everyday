package cn.leetcode.`394`

import cn.huangsy.ValidPalindrome

/**
 * @author huangsy
 * @date 2020/5/28 10:08
 */
class DecodeString {
    val start = '['
    val end = ']'
    var i = 0

    fun decodeString(s: String): String? {
        return decode(s.toCharArray())
    }

    private fun decode(chars: CharArray): String {
        var x = ""
        while (true && i < chars.size) {
            if (chars[i] <= 47.toChar() || chars[i] >= 58.toChar()) {
                if (chars[i] == start) {
                    val n = getNumber(chars, i - 1)
                    i++
                    val m = decode(chars)
                    for (j in 0 until n) {
                        x = x + m
                    }
                } else if (chars[i] == end) {
                    break
                } else {
                    x = x + Character.toString(chars[i])
                }
            }
            i++
        }
        return x
    }

    private fun getNumber(chars: CharArray, i: Int): Int {
        var i = i
        var n = 0
        var w:Int = 1
        while (i >= 0 && chars[i] > 47.toChar() && chars[i] < 58.toChar()) {
            n += ((chars[i] - 48).toInt() * w)
            i--
            w *= 10
        }
        return n
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val decodeString = DecodeString()
            println(decodeString.decodeString("2[abc]3[cd]ef"))
        }
    }
}
