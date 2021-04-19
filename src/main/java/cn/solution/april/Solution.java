package cn.solution.april;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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

    /**
     * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return nums[0] == target;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                ++l;
                --r;
            } else if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }

    /**
     * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int l = 0, r = n - 1;
        while (l < r) {
            int p = l + (r - l) / 2;
            if (nums[p] < nums[r]) {
                r = p;
            } else {
                l = p + 1;
            }
        }
        return nums[l];
    }

    /**
     * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
     * @param nums
     * @return
     */
    public int findMinII(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int l = 0, r = n - 1;
        while (l < r) {
            int p = l + (r - l) / 2;
            if (nums[l] == nums[p] && p != l) {
                ++l;
            } else if (nums[p] == nums[r] && p != r) {
                --r;
            } else if (nums[p] < nums[r]) {
                r = p;
            } else {
                l = p + 1;
            }
        }
        return nums[l];
    }

    Map<String, Boolean> map = new HashMap<>();

    /**
     * https://leetcode-cn.com/problems/scramble-string/
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble(String s1, String s2) {
        String key = s1.concat(s2);
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (s1.equals(s2)) {
            map.put(key, true);
            return true;
        }

        int[] array = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            ++array[s1.charAt(i) - 'a'];
            --array[s2.charAt(i) - 'a'];
        }
        for (int j : array) {
            if (j != 0) {
                return false;
            }
        }

        int n = s1.length();
        for (int i = 1; i < s1.length(); i++) {
            if ((isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) ||
                    (isScramble(s1.substring(0, i), s2.substring(n-i)) && isScramble(s1.substring(i), s2.substring(0, n-i)))) {
                map.put(key, true);
                return true;
            }
        }
        map.put(key, false);
        return false;
    }

    /**
     * https://leetcode-cn.com/problems/remove-element/
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        while (i<=j) {
            if (nums[i] == val) {
                if (nums[j] != val) {
                    nums[i] = nums[j];
                    i++;
                }
                j--;
            } else {
                i++;
            }
        }
        return j+1;
    }

}
