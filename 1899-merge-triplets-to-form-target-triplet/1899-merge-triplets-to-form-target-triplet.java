class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] bool = new boolean[3];
        
        for(int[] triplet : triplets) {
            if(triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                if(triplet[0] == target[0]) {
                    bool[0] = true;
                }
                if(triplet[1] == target[1]) {
                    bool[1] = true;
                }
                if(triplet[2] == target[2]) {
                    bool[2] = true;
                }
            }
        }
        
        return bool[0] && bool[1] & bool[2];
    }
}