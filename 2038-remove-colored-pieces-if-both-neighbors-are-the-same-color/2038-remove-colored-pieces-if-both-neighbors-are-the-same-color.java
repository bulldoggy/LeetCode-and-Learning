class Solution {
    public boolean winnerOfGame(String colors) {
        int alicePoints = 0;
        char c = '\0';
        int curr = 0;
        
        for(char piece : colors.toCharArray()) {
            if(piece == c) {
                curr++;
                if(curr > 2) {
                    if(c == 'A') {
                        alicePoints++;
                    } else {
                        alicePoints--;
                    }
                        
                }
            } else {
                c = piece;
                curr = 1;
            }
        }
        
        return alicePoints > 0;
    }
}