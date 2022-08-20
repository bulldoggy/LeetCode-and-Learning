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
        if(head.next == null) return;            
        ListNode firsthalf = head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode beforeSlow = null;
        
        while(fast != null) {
            beforeSlow = slow;
            slow = slow.next;
            if(fast.next == null) {
                fast = fast.next;
            } else {
                fast = fast.next.next;
            }
        }
        
        ListNode secondhalf = slow;
        beforeSlow.next = null;
        
        printList(firsthalf, "firsthalf");
        printList(secondhalf, "secondhalf");
        
        secondhalf = reverseList(secondhalf); 
        printList(secondhalf, "after reverseList()");        
        mergeList(firsthalf, secondhalf);
    }
    
    private ListNode reverseList(ListNode currNode) {
        ListNode prevNode = null;
        ListNode nextNode = currNode.next;
        
        while(nextNode != null) {
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
            nextNode = nextNode.next;
        }
        currNode.next = prevNode;
        return currNode;
    }
    
    private void mergeList(ListNode first, ListNode second) {
        ListNode from = first;
        ListNode to = second;
        ListNode next = first.next;
        
        while(next != null) {
            from.next = to;
            from = from.next;
            to = next;
            next = from.next;
        }
        from.next = to;
    }
    
    private void printList(ListNode node, String s) {
        System.out.println(s+": ");
        ListNode temp = node;
        while(temp != null) {
            System.out.print(temp.val+", ");
            temp = temp.next;
        }
        System.out.println();
    }
}