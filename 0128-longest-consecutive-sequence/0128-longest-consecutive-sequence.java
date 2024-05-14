class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest = 0;
        
        for(int num : nums) {
            set.add(num);
        }
        
        int count = 0;
        int curr = 0;
        for(int num : nums) { 
            if(set.contains(num)) {
                count = 1;

                curr = num;
                while(set.contains(curr + 1)) {
                    curr++;
                    count++;
                    set.remove(curr);
                }

                curr = num;
                while(set.contains(curr - 1)) {
                    curr--;
                    count++;
                    set.remove(curr);
                }
                
                longest = count > longest ? count : longest;
            }
        }
        
        return longest;
    }
}