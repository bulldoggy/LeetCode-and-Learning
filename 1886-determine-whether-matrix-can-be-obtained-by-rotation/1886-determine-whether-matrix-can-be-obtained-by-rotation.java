class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        
        for(int i = 0; i < 4; i++) {
            if(isSameMatrix(mat, target)) {
                return true;
            }
            
            if(i < 3) {
                rotateMatrix(mat);
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
    
    private void rotateMatrix(int[][] mat) {
        int top = 0;
        int bottom = mat.length - 1;
        
        while(top < bottom) {
            int left = top;
            int right = bottom;
            
            for(int i = 0; i < bottom - top; i++) {
                int topLeft = mat[top][left + i];
                
                mat[top][left + i] = mat[bottom - i][left];
                mat[bottom - i][left] = mat[bottom][right - i];
                mat[bottom][right - i] = mat[top + i][right];
                mat[top + i][right] = topLeft;
            }
            
            top++;
            bottom--;
        }
    }
}