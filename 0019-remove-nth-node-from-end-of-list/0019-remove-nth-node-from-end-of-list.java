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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        int fastCount = 0;
        int slowCount = 0;
        
        while(fast.next != null) {
            prev = slow;
            slow = slow.next;
            slowCount++;
            fast = fast.next;
            fastCount++;
            if(fast.next != null) {
                fast = fast.next;
                fastCount++;
            }
        }
        
        if(fastCount - n > slowCount - 1) {
            while(fastCount - n > slowCount - 1) {
                prev = slow;
                slow = slow.next;
                slowCount++;
            }
        } else if(fastCount - n < slowCount - 1) {
            prev = null;
            ListNode curr = head;
            int currCount = 0; 
            
            while(fastCount - n + 1 > currCount) {
                prev = curr;
                curr = curr.next;
                currCount++;
            }
            slow = curr;
        }
        
        if(prev == null) {
            return head.next;
        }
        
        prev.next = slow.next;
        return head;
    }
}