class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int start = 0;
        int end = 0;
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int[] result = new int[nums.length-k+1];
        
        while(end < k) {
            while(!deque.isEmpty() && deque.peekLast() < nums[end]) {
                deque.pollLast();
            }
            
            deque.offerLast(nums[end]);
            end++;
        }
        
        end--;
        result[start] = deque.peekFirst();
        
        while(end+1 < nums.length) {
            end++;
            
            while(!deque.isEmpty() && deque.peekLast() < nums[end]) {
                deque.pollLast();
            }
            
            deque.offerLast(nums[end]);
            
            if(deque.peekFirst() == nums[start]) {
                deque.pollFirst();
            }
            
            start++;
            result[start] = deque.peekFirst();
        }
              
        return result;
    }
}