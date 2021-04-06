package cn.solution.april;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author huangsy
 * @date 2021/4/1 8:37
 */
public class Solution {

    /**
     * https://leetcode-cn.com/problems/clumsy-factorial/
     * @param N
     * @return
     */
    public int clumsy(int N) {

        int[] X = {1,2,2,-1};
        return N>4?N+X[N%4]:(N>2?N+3:N);
//        if (N==1) {
//            return 1;
//        }
//        if (N<=3) {
//            return N*(N-1);
//        }
//
//        return N*(N-1)/(N-2) + clumsy(N - 3, '-');
    }

    private int clumsy(int n, char symbol) {
        switch (symbol) {
            case '+':
                if (n<=1) {
                    return -n;
                }
                if (n>=3) {
                    return - n*(n-1)/(n-2) + clumsy(n-3, '-');
                }
                return - n*(n-1);
            default:
                if (n<=1) {
                    return n;
                }
                return n + clumsy(n-1, '+');
        }
    }

    /**
     * https://leetcode-cn.com/problems/volume-of-histogram-lcci/
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int trap = 0;
        int i = 0;
        Deque<Integer> deque = new LinkedList<>();
        while (i < height.length) {
            while (!deque.isEmpty() && height[i] > height[deque.peek()]) {
                int j = deque.pop();
                if (deque.isEmpty()) {
                    break;
                }

                int n = deque.peek();
                trap += (i - n - 1) * (Math.min(height[i], height[n]) - height[j]);
            }
            deque.push(i++);
        }
        return trap;

//        int res = 0;
//        int l=0,r=height.length-1;
//        if (r<0) {
//            return 0;
//        }
//        int lMax=height[l],rMax=height[r];
//        while (l<r) {
//            if (height[l]>height[r]) {
//                if (height[r]<rMax) {
//                    res += (rMax-height[r]);
//                } else {
//                    rMax = height[r];
//                }
//                r--;
//            } else {
//                if (height[l]<lMax) {
//                    res += (lMax-height[l]);
//                } else {
//                    lMax = height[l];
//                }
//                l++;
//            }
//        }
//        return res;
    }

    /**
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
//        int x = nums.length;
//        for (int i = nums.length - 1; i >= 2; i--) {
//            if (nums[i] == nums[i-1] && nums[i-1] == nums[i-2]) {
//                int a = i;
//                x--;
//                while (a < x) {
//                    int tmp = nums[a];
//                    nums[a] = nums[a+1];
//                    nums[a+1] = tmp;
//                    a++;
//                }
//            }
//        }
//        return x;
        if(nums.length<2) {
            return nums.length;
        }
        int x = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[x-2] != nums[i]) {
                nums[x++] = nums[i];
            }
        }
        return x;
    }


}
