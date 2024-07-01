class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int consec = 0;
        
        for(int num : arr) {
            if(num % 2 == 0) {
                consec = 0;
            } else {
                consec++;  
                if(consec >= 3) {
                    return true;
                }
            }
        }
        
        return false;
    }
}