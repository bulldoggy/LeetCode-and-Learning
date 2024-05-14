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
    public void reorderList(ListNode head) {
        ListNode beforeSlow = null;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null) {
            beforeSlow = slow;
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
        }
        beforeSlow.next = null;
        
        ListNode first = head;
        ListNode second = reverseList(slow);
        
        combineLists(first, second);
    }
    
    private ListNode reverseList(ListNode head) {
        if(head == null) return head;
        
        ListNode back = head;
        ListNode front = head.next;
        ListNode temp = null;
        
        back.next = null;
        while(front != null) {
            temp = front.next;
            front.next = back;
            back = front;
            front = temp;
        }
        
        return back;
    }
    
    private ListNode combineLists(ListNode first, ListNode second) {
        ListNode head = first;
        ListNode firstAhead = null;
        ListNode secondAhead = null;
        
        while(second != null) {
            firstAhead = first.next;
            secondAhead = second == null ? null : second.next;
            
            first.next = second;
            second.next = firstAhead;
            first = firstAhead;
            second = secondAhead;
        }
            
        return head;
    }
}