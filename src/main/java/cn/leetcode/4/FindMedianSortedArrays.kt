package cn.leetcode.`4`

class FindMedianSortedArrays {

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val m = nums1.size
        val n = nums2.size
        val left = (m + n + 1) / 2
        val right = (m + n + 2) / 2
        return (mid(nums1, 0, nums2, 0, left) + mid(nums1, 0, nums2, 0, right)) / 2.0
    }

    private fun mid(nums1: IntArray, i: Int, nums2: IntArray, j: Int, k: Int): Int {
        if (i >= nums1.size) {
            return nums2[j + k - 1]
        }
        if (j >= nums2.size) {
            return nums1[i + k - 1]
        }
        if (k == 1) {
            return Math.min(nums1[i], nums2[j])
        }
        val mid1 = if (i + k / 2 - 1 < nums1.size) nums1[i + k / 2 - 1] else Int.MAX_VALUE
        val mid2 = if (j + k / 2 - 1 < nums2.size) nums2[j + k / 2 - 1] else Int.MAX_VALUE
        return if (mid1 < mid2) {
            mid(nums1, i + k / 2, nums2, j, k - k / 2)
        } else {
            mid(nums1, i, nums2, j + k / 2, k - k / 2)
        }
    }
}