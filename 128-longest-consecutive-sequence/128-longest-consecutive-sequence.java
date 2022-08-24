class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int result = 0;
        
        for(int num : nums) {
            hs.add(num);
        }
        
        for(int num : nums) {
            int curr = num;
            int consec = 1;
            if(!hs.contains(curr-1)) {
                while(hs.contains(curr+1)) {
                    curr++;
                    consec++;
                }
                if(consec > result) result = consec;
            }
        }
        return result;
    }
}