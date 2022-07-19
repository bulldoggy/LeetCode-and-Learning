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
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return head;
        }
        
        ListNode nextNode = head.next;
        while(nextNode != null) {
            ListNode prevNode = head;
            head = nextNode;
            nextNode = nextNode.next;
            head.next = prevNode;
            
            if(prevNode.next == head) {
                prevNode.next = null;
            }
        }
        
        return head;
    }
}