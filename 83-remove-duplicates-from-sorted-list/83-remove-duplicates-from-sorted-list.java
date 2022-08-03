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
    public ListNode deleteDuplicates(ListNode head) {
        int currVal = -101;
        ListNode prevNode = null;
        ListNode currNode = head;
        
        while(currNode != null) {
            if(currVal != currNode.val) {
                currVal = currNode.val;
                prevNode = currNode;
            } else {
                prevNode.next = currNode.next;
            }
            currNode = currNode.next;
        }
        return head;
    }
}