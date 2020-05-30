package cn.leetcode.`84`

class LargestRectangleArea {

    fun largestRectangleArea(heights: IntArray): Int {
        if (heights.isEmpty()) {
            return 0
        }
        if (heights.size == 1) {
            return heights[0]
        }
        // 0 代表left , 1 代表right
        val dp = Array(heights.size) { IntArray(2) }
        dp[heights.size - 1][1] = heights.size - 1
        var l = 1
        var r = heights.size - 2
        while (l < heights.size) {
            dp[l][0] = l
            var ml = l - 1
            while (ml >= 0 && heights[l] <= heights[ml]) {
                dp[l][0] = dp[ml][0]
                ml = dp[ml][0] - 1
            }
            dp[r][1] = r
            var mr = r + 1
            while (mr < heights.size && heights[r] <= heights[mr]) {
                dp[r][1] = dp[mr][1]
                mr = dp[mr][1] + 1
            }
            l++
            r--
        }
        var max = 0
        for (i in heights.indices) {
            max = Math.max(heights[i] * (dp[i][1] - dp[i][0] + 1), max)
        }
        return max
    }
}