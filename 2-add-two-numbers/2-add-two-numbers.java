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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode total = new ListNode();
        ListNode result = total;
        int carry = 0;
        
        while(l1 != null || l2 != null || carry != 0) {
            int ans = 0;
            
            if(l1 == null && l2 == null) {
                ans = 1;
            } else if(l1 == null) {
                ans = l2.val + carry;    
                l2 = l2.next;
            } else if(l2 == null) {
                ans = l1.val + carry;   
                l1 = l1.next;
            } else {
                ans = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }
            
            if(ans >= 10) {
                total.val = ans%10;
                carry = 1;
            } else {
                total.val = ans;
                carry = 0;
            }
            
            if(l1 != null || l2 != null || carry != 0) {
                total.next = new ListNode();
                total = total.next;
            }
        }
        
        return result;
    }
}