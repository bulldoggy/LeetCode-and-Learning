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
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode holder = head;
        
        while(holder != null) {
            holder = holder.next;
            count++;
        }
        int middle = count / 2 + 1;
        for(int i = 1; i < middle; i++) {
            head = head.next;
        }
        return head;
    }
}