package cn.leetcode.`152`

/**
 * @author huangsy
 * @date 2020/5/18 9:07
 */
class MaximumProductSubarray {
    fun maxProduct(nums: IntArray): Int {
        var a = 1
        var max = nums[0]

        for (num in nums) {
            a = a * num
            if (max < a) max = a
            if (num == 0) a = 1
        }
        a = 1
        for (i in nums.size - 1 downTo 0) {
            a = a * nums[i]
            if (max < a) max = a
            if (nums[i] === 0) a = 1
        }
        return max
    }
}