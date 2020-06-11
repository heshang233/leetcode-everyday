package cn.leetcode.`739`

/**
 * @author huangsy
 * @date 2020/6/11 10:32
 */
class DailyTemperatures {

    fun dailyTemperatures(T: IntArray): IntArray {
        val result = IntArray(T.size)
        for (i in T.size - 2 downTo 0) {
            var right = i + 1
            if (T[right] > T[i]) {
                result[i] = 1
            } else {
                while (true) {
                    if (T[right] > T[i]) {
                        result[i] = right - i;
                        break;
                    } else if (result[right] == 0) {
                        result[i] = 0;
                        break;
                    }
                    right += result[right];
                }
            }
        }
        return result
    }
}