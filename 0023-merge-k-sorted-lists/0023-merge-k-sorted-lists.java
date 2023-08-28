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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode start = new ListNode();
        ListNode pointer = start;
        List<ListNode> all = new ArrayList<>();
        
        start.val = 10001;
        
        for(ListNode l : lists) {
            all.add(l);
        }
        
        while(all.size() > 0) {
            int pos = 0;
            int max = all.size();
            int lowestPos = 0;
            
            while(pos < max) {
                ListNode curr = all.get(pos); 
                
                if(curr != null) {
                    if(curr.val < all.get(lowestPos).val) {
                        lowestPos = pos;
                    }
                    pos++;
                } else {
                    all.remove(pos);
                    max = all.size();  
                }
            }
            
            if(lowestPos < all.size()) {
                ListNode chosen = all.get(lowestPos);
                pointer.next = chosen;
                pointer = pointer.next;
                all.set(lowestPos, chosen.next);
            }
        }
        
        return start.next;
    }
}