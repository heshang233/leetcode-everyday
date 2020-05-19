package cn.huangsy;

/**
 * @author huangsy
 * @date 2020/5/18 9:12
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {

        int[][] dp = new int[nums.length][2];

        dp[0][1] = nums[0];
        dp[0][0] = nums[0];

        int max = dp[0][1];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                dp[i][0] = Math.min(nums[i], nums[i]*dp[i-1][0]);
                dp[i][1] = Math.max(nums[i], nums[i]*dp[i-1][1]);
            } else {
                dp[i][0] = Math.min(nums[i], nums[i]*dp[i-1][1]);
                dp[i][1] = Math.max(nums[i], nums[i]*dp[i-1][0]);
            }
            max = Math.max(max, dp[i][1]);
        }

        return max;
    }

    public static void main(String[] args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        int[] nums = new int[]{1, -9, 2, 3, 4, 5, 6, 7, -2, -3};
        System.out.println(maximumProductSubarray.maxProduct(nums));
    }
}
