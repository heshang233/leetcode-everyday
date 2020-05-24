package cn.huangsy;

public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (mid(nums1, 0, nums2, 0, left) + mid(nums1, 0, nums2, 0, right))/2.0;
    }

    private int mid(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i>=nums1.length) {
            return nums2[j+k-1];
        }
        if (j>=nums2.length) {
            return nums1[i+k-1];
        }
        if (k==1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int mid1 = i+k/2-1<nums1.length?nums1[i+k/2-1]:Integer.MAX_VALUE;
        int mid2 = j+k/2-1<nums2.length?nums2[j+k/2-1]:Integer.MAX_VALUE;
        if (mid1 < mid2) {
            return mid(nums1, i+k/2, nums2, j, k-k/2);
        } else {
            return mid(nums1, i, nums2, j+k/2, k-k/2);
        }
    }

    public static void main(String[] args) {
        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
        System.out.println(findMedianSortedArrays.findMedianSortedArrays(new int[]{3}, new int[]{1, 2, 4}));
    }
}
