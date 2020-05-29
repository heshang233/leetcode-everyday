package cn.huangsy;

/**
 * @author huangsy
 * @date 2020/5/29 8:37
 */
public class Rob {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        dp[1][0] = nums[1];
        dp[1][1] = Math.max(dp[1][0], dp[0][1]);
        int max = Math.max(dp[1][0], dp[0][1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i][0] = dp[i-2][1] + nums[i];
            dp[i][1] = Math.max(dp[i][0], dp[i-1][1]);
            max = Math.max(max, Math.max(dp[i][0], dp[i-1][1]));
        }
        return max;
    }

    public static void main(String[] args) {
        Rob rob = new Rob();
        System.out.println(rob.rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob.rob(new int[]{2,7,9,3,1}));
        System.out.println(rob.rob(new int[]{1,3,1,3,100}));
    }

}
