class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0;
        int beams = 0;
        
        for(String s : bank) {
            int curr = 0;
            
            for(char c : s.toCharArray()) {
                if('1' == c) {
                    curr++;
                }
            }
            
            if(curr != 0) {
                beams += curr * prev;
                prev = curr;
            }
        }
        
        return beams;
    }
}