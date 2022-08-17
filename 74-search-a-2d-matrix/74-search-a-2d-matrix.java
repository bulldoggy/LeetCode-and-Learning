class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int rowPos = -1;
        
        while(rowStart <= rowEnd) {
            int rowCurr = (rowStart+rowEnd) / 2;
            
            if(target < matrix[rowCurr][0]) {
                rowEnd = rowCurr - 1;
            } else if(target > matrix[rowCurr][matrix[0].length - 1]) {
                rowStart = rowCurr + 1;
            } else {
                rowPos = rowCurr;
                rowEnd = -1;
            }
        }
        if(rowPos == -1) return false;
        
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        
        while(colStart <= colEnd) {
            int colCurr = (colStart + colEnd) / 2;
            
            if(matrix[rowPos][colCurr] == target) return true; 
            if(target < matrix[rowPos][colCurr]) {
                colEnd = colCurr - 1;
            } else {
                colStart = colCurr + 1;
            }
        }
        return false;
    }
}