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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        
        if (l2 == null) {
            return l1;
        }
        
        ListNode head = new ListNode();
        if(l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        
        ListNode curr = head;
        while(true) {
            if(l1 == null && l2 == null) {
                return head;
            } else if(l1 != null && l2 == null) {
                curr.next = l1;
                l1 = l1.next;
            } else if(l1 == null && l2 != null) {
                curr.next = l2;
                l2 = l2.next;
            } else {
                if(l1.val <= l2.val) {
                    curr.next = l1;
                    l1 = l1.next;
                } else {
                    curr.next = l2;
                    l2 = l2.next;
                }
            }
            curr = curr.next;
        }
    }
}