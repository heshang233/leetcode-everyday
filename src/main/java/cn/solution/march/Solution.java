package cn.solution.march;

import java.util.List;
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


    /**
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesII(ListNode head) {
//        return getNext(head, null);

        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        if (head.val == next.val) {

            while (next != null && head.val == next.val) {
                next = next.next;
            }
            head = deleteDuplicatesII(next);
        } else {
            head.next = deleteDuplicatesII(next);
        }
        return head;
    }

    private ListNode getNext(ListNode node, Integer duplicate) {
        if (node == null) {
            return null;
        }

        if (duplicate !=null && duplicate == node.val) {
            return getNext(node.next, duplicate);
        }

        if (node.next!=null && node.next.val == node.val) {
            duplicate = node.val;
            return getNext(node.next, duplicate);
        }
        return new ListNode(node.val, getNext(node.next, duplicate));
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    /**
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesI(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        if (head.val == next.val) {

            while (next != null && head.val == next.val) {
                next = next.next;
            }
        }
        head.next = deleteDuplicatesI(next);
        return head;
    }


    /**
     * https://leetcode-cn.com/problems/reverse-bits/
     * @param n
     * @return
     */
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        return Integer.reverse(n);
    }

    /**
     * https://leetcode-cn.com/problems/search-a-2d-matrix/
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (target > matrix[m - 1][n - 1] || target < matrix[0][0]) {
            return false;
        }

        int mm = recursionBinarySearchM(matrix, 0, m - 1, target);

        if (mm == -1) {
            return false;
        }

        int nm = recursionBinarySearchN(matrix[mm], 0, n - 1, target);

        return nm >= 0;
    }


    private int recursionBinarySearchM(int[][] arr, int low, int high, int target){

        if (target >= arr[low][0] && target <= arr[low][arr[low].length - 1]) {
            return low;
        }

        if (target >= arr[high][0] && target <= arr[high][arr[high].length - 1]) {
            return high;
        }

        if (low > high) {
            return -1;
        }

        int middle = (low + high) / 2;          //初始中间位置
        if(arr[middle][0] > target){
            //比关键字大则关键字在左区域
            return recursionBinarySearchM(arr, low, middle-1, target);
        }else if(arr[middle][0] < target){
            //比关键字小则关键字在右区域
            return recursionBinarySearchM(arr, middle+1, high, target);
        }else {
            return middle;
        }
    }

    private int recursionBinarySearchN(int[] arr, int low, int high, int target){

        if(target < arr[low] || target > arr[high] || low > high){
            return -1;
        }

        int middle = (low + high) / 2;          //初始中间位置
        if(arr[middle] > target){
            //比关键字大则关键字在左区域
            return recursionBinarySearchN(arr, low, middle-1, target);
        }else if(arr[middle] < target){
            //比关键字小则关键字在右区域
            return recursionBinarySearchN(arr, middle+1, high, target);
        }else {
            return middle;
        }
    }

    /**
     * https://leetcode-cn.com/problems/subsets-ii/
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        return null;
    }
}
