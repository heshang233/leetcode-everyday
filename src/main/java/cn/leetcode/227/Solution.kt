package cn.leetcode.`227`

import java.util.*

/**
 * @author huangsy
 * @date 2021/3/11 14:01
 */
class Solution {

    val space = 32.toChar()
    val add = 43.toChar()
    val sub = 45.toChar()
    val mul = 42.toChar()
    val div = 47.toChar()

    fun calculate(s: String): Int {
        val stack = Stack<String>()
        var number = ""
        val chars = s.trim { it <= ' ' }.toCharArray()
        var i = 0
        while (i < chars.size) {
            val c = chars[i]
            if (c == space) {
                i++
                continue
            }
            if (c == add || c == sub) {
                if (!stack.isEmpty()) {
                    number = stack.pop() + number
                }
                stack.push(number)
                number = ""
                stack.push(c.toString())
            } else if (c == mul || c == div) {
                var nextNumber = ""
                var j = i + 1
                while (j < chars.size) {
                    val next = chars[j]
                    if (next == space) {
                        j++
                        continue
                    }
                    nextNumber = if (next == add || next == sub || next == mul || next == div) {
                        break
                    } else {
                        nextNumber + next.toString()
                    }
                    j++
                }
                number = if (c == mul) {
                    (Integer.valueOf(number) * Integer.valueOf(nextNumber)).toString()
                } else {
                    (Integer.valueOf(number) / Integer.valueOf(nextNumber)).toString()
                }
                i = j - 1
            } else {
                number = number + c.toString()
            }
            if (i == chars.size - 1) {
                if (!stack.isEmpty()) {
                    number = stack.pop() + number
                }
                stack.push(number)
            }
            i++
        }
        if (stack.empty()) {
            return Integer.valueOf(number)
        }
        var sum = 0
        while (!stack.empty()) {
            sum += stack.pop().toInt()
        }
        return sum
    }
}