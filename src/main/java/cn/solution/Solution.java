package cn.solution;

import java.util.Stack;

/**
 * @author huangsy
 * @date 2021/3/24 8:42
 */
public class Solution {

    /**
     * https://leetcode-cn.com/problems/132-pattern/
     *  when i<j<k then Ai<Ak<Aj.
     * @param nums
     * @return
     */
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int latest = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >=0; i--) {
            if (nums[i] < latest) {
                return true;
            }

            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                latest = stack.pop();
            }

            stack.push(nums[i]);
        }
        return false;
    }

}
