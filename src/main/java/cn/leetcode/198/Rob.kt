package cn.leetcode.`198`

/**
 * @author huangsy
 * @date 2020/5/29 8:38
 */
class Rob {

    fun rob(nums: IntArray): Int {
        if (nums.size == 0) {
            return 0
        }
        if (nums.size == 1) {
            return nums[0]
        }
        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        dp[1] = Math.max(dp[1], dp[0])
        var max = dp[1]
        for (i in 2 until nums.size) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1])
            max = Math.max(max, dp[i])
        }
        return max
    }
}