package cn.leetcode.`1371`

import cn.huangsy.ValidPalindrome
import java.util.*

/**
 * @author huangsy
 * @date 2020/5/20 8:45
 */
class FindTheLongestSubstring {

    fun findTheLongestSubstring(s: String): Int {
        val x = IntArray(128)
        x['a'.toInt()] = 1
        x['e'.toInt()] = 2
        x['i'.toInt()] = 4
        x['o'.toInt()] = 8
        x['u'.toInt()] = 16

        var chars = s.toCharArray()
        val n = IntArray(32)

        var m = 0
        var t = 0
        n[0] = 1

        for (i in 2 .. chars.size + 1) {
            t = t xor x[chars[i-2].toInt()]
            if (n[t] == 0) {
                n[t] = i
            } else {
                m = Math.max(m, i - n[t])
            }
        }
        return m
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val findTheLongestSubstring = FindTheLongestSubstring()
            println(findTheLongestSubstring.findTheLongestSubstring("eleetminicoworoep"))
            println(findTheLongestSubstring.findTheLongestSubstring("leetcodeisgreat"))
            println(findTheLongestSubstring.findTheLongestSubstring("bcbcbc"))
        }
    }
}
