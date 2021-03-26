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
}
