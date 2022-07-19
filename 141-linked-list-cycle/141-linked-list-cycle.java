/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        
        ListNode first = head;
        ListNode second = head;
        
        while(first.next != null && second.next != null) {
            first = first.next;
            second = second.next.next;
            if(first == second) return true;
            if(second == null) return false;
        }
        return false;
    }
}