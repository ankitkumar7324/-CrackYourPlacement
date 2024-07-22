/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
        {
            return true;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid= slow;
        ListNode prev = null;
        ListNode curr = mid;
        ListNode front;

        while(curr != null)
        {
            front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }

        ListNode right = prev;
        ListNode left = head;

        while(right != null)
        {
            if(left.val != right.val)
            {
                return false;
            }
            left= left.next;
            right = right.next;
        }
        return true;
    }
}