class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        
        for(int i = 0; i < 4; i++) {
            if(isSameMatrix(mat, target)) {
                return true;
            }
            
            if(i < 3) {
                mat = rotateMatrix(mat);
            }
        }
        
        return false;
    }
    
    private boolean isSameMatrix(int[][] mat, int[][] target) {
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private int[][] rotateMatrix(int[][] mat) {
        int[][] rotated = new int[mat.length][mat[0].length];
        int right = mat[0].length - 1;
        int top = 0;
        
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                rotated[top + j][right - i] = mat[i][j]; 
            }
        }
        
        return rotated;
    }
}