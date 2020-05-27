package cn.huangsy;

import java.util.HashMap;

/**
 * @author huangsy
 * @date 2020/5/27 14:25
 */
public class SubarraySum {

    /**
     * 前缀和
     * 假设  M = SUM[0,m], N = SUM[0,n] & m>n
     * 则 M - K = N, SUM(n,m] = K
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int max = 0;
        int total = 0;
        for (int i : nums) {
            total += i;
            int key = total - k;
            if (map.containsKey(key)) {
                max += map.get(key);
            }
            map.put(total, map.getOrDefault(total, 0)+1);
        }
        return max;
    }
}
