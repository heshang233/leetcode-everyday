package cn.leetcode.`287`

/**
 * @author huangsy
 * @date 2020/5/26 8:46
 */
class FindDuplicate {

    fun findDuplicate(nums: IntArray): Int {
        var fast = 0
        var slow = 0
        while (true) {
            fast = nums[nums[fast]]
            slow = nums[slow]
            if (slow == fast) {
                fast = 0
                while (nums[slow] != nums[fast]) {
                    fast = nums[fast]
                    slow = nums[slow]
                }
                return slow
            }
        }
    }
}