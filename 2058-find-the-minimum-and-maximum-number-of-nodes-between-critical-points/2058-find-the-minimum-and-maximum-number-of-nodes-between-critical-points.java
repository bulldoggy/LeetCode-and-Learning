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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = new int[]{-1, -1};
        ListNode prev = head;
        int firstCrit = -1; 
        int lastCrit = -1;
        int prevCrit = -1;
        int currPos = 1;
        
        head = head.next;
        
        while(head.next != null) {
            if(isCritical(prev, head)) {       
                if(prevCrit != -1){
                    if(result[0] == -1 || currPos - prevCrit < result[0]) {
                        result[0] = currPos - prevCrit;
                    }    
                    prevCrit = currPos;
                } else {
                    prevCrit = currPos;
                    firstCrit = currPos;
                }
                
                lastCrit = currPos;
            }
            
            prev = head;
            head = head.next;
            currPos++;
        }
        
        if(result[0] != -1) {
            result[1] = lastCrit - firstCrit;
        }
        
        return result;
    }
    
    private boolean isCritical(ListNode prev, ListNode head) {
        ListNode next = head.next;
        
        if(prev.val < head.val && head.val > next.val) {
           return true;
        } 
        
        if(prev.val > head.val && head.val < next.val) {
            return true;
        }
        
        return false;
    }
}