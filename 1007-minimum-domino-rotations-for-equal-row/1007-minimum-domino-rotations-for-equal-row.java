class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        boolean possible = true;
        int topMissing = 0;
        int botMissing = 0;
        
        int i = 0;
        while(possible && i < tops.length) {
            if(tops[i] != tops[0] && bottoms[i] != tops[0]) possible = false;
            if(tops[i] != tops[0]) topMissing++;
            if(bottoms[i] != tops[0]) botMissing++;
            i++;
        }
        
        if(possible) return Math.min(topMissing, botMissing);
        possible = true;
        topMissing = 0;
        botMissing = 0;
        i = 0;
        
        while(possible && i < tops.length) {
            if(tops[i] != bottoms[0] && bottoms[i] != bottoms[0]) possible = false;
            if(tops[i] != bottoms[0]) topMissing++;
            if(bottoms[i] != bottoms[0]) botMissing++;
            i++;
        }
        
        if(possible) return Math.min(topMissing, botMissing);
        return -1;
    }
}