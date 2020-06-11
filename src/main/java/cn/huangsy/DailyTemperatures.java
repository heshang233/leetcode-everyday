package cn.huangsy;

/**
 * @author huangsy
 * @date 2020/6/11 9:10
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        int[] dp = new int[101];
        for (int i = T.length - 2; i >= 0; i--) {
            int right = i + 1;
            if (T[right] > T[i]) {
                result[i] = 1;
            } else {
                do {
                    result[i] += dp[T[right]];
                    right += dp[T[right]];
                } while (right < T.length && T[right] <= T[i] && dp[T[right]]!=0);
                if (result[i] != 0) {
                    result[i] += 1;
                }
                if (dp[T[right]]==0 && T[right] <= T[i]) {
                    result[i] = 0;
                }
            }
            dp[T[i]] = result[i];
        }
        return result;
    }

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        System.out.println(dailyTemperatures.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
        System.out.println(dailyTemperatures.dailyTemperatures(new int[]{55,38,53,81,61,93,97,32,43,78}));
    }
}
