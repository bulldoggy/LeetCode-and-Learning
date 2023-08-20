class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        
        char[][] arr = new char[numRows][((s.length() / (2*numRows-2)) + 1) * (numRows-1)];
        int x = 0;
        int y = 0;
        boolean goDown = true;
        
        for(char c : s.toCharArray()) {
            arr[x][y] = c;
            
            if(x + 1 >= arr.length) {
                goDown = false;
            } else if(x - 1 < 0) {
                goDown = true;
            }
            
            if(goDown) {
                x++;
            } else {
                x--;
                y++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] != '\u0000') {
                    sb.append(arr[i][j]);
                }
            }
        }
        
        return sb.toString();
    }
}