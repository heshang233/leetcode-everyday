package cn.leetcode.`76`

class MinWindow {

    fun minWindow(s: String, t: String): String? {
        val tArray = IntArray(64)
        val sArray = IntArray(64)
        for (i in 0 until t.length) {
            tArray[t[i] - 'A']++
        }
        var left = 0
        var right = -1
        val minArray = intArrayOf(-1, s.length + 1)
        while (left <= s.length - t.length) {
            var flag = 0
            while (flag < 64) {
                if (sArray[flag] < tArray[flag]) {
                    break
                }
                flag++
            }
            if (right - left + 1 < t.length) {
                if (right < s.length) {
                    sArray[s[++right] - 'A']++
                }
            } else if (right - left + 1 == t.length) {
                if (flag == 64) {
                    if (right - left < minArray[1] - minArray[0]) {
                        minArray[0] = left
                        minArray[1] = right
                    }
                    break
                } else {
                    if (right + 1 < s.length) {
                        sArray[s[++right] - 'A']++
                    } else {
                        sArray[s[left++] - 'A']--
                    }
                }
            } else {
                if (flag == 64) {
                    if (right - left < minArray[1] - minArray[0]) {
                        minArray[0] = left
                        minArray[1] = right
                    }
                    sArray[s[left++] - 'A']--
                } else {
                    if (right + 1 < s.length) {
                        sArray[s[++right] - 'A']++
                    } else {
                        sArray[s[left++] - 'A']--
                    }
                }
            }
        }
        return if (minArray[0] == -1) "" else s.substring(minArray[0], minArray[1] + 1)
    }
}