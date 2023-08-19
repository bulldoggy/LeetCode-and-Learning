class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        if(matrix.length == 1 && matrix[0].length == 1) return List.of(matrix[0][0]);
        spiralOrder(result, matrix, 0, 0);
        return(result);
    }
    
    private void spiralOrder(List<Integer> list, int[][] matrix, int x, int y) {   
        if(checkSurroundVisited(matrix, x, y)) return;
        
        boolean nextValid = true;
        
        while(nextValid) {
            if(matrix[x][y] > -1000) list.add(matrix[x][y]);
            matrix[x][y] -= 1101;
            if(y >= matrix[0].length - 1 || matrix[x][y+1] <= -1000) {
                nextValid = false;   
            } else {
                y++;
            }
        } 
        
        nextValid = true;
        
        while(nextValid) {
            if(matrix[x][y] > -1000) list.add(matrix[x][y]);
            matrix[x][y] -= 1101;
            if(x >= matrix.length - 1 || matrix[x+1][y] <= -1000) {
                nextValid = false;
            } else {
                x++;
            }
        }
        
        nextValid = true;
        
        while(nextValid) {
            if(matrix[x][y] > -1000) list.add(matrix[x][y]);
            matrix[x][y] -= 1101;
            if(y <= 0 || matrix[x][y-1] <= -1000) {
                nextValid = false;
            } else {
                y--;
            }
        }
        
        nextValid = true;
        
        while(nextValid) {
            if(matrix[x][y] > -1000) list.add(matrix[x][y]);
            matrix[x][y] -= 1101;
            if(x <= 0 || matrix[x-1][y] <= -1000) {
                nextValid = false;
            } else {
                x--;
            }
        }
        
        spiralOrder(list, matrix, x, y);
    }
    
    private boolean checkSurroundVisited(int[][] matrix, int x, int y) {
        if((x + 1 < matrix.length && matrix[x+1][y] > -1000) ||
           (y + 1 < matrix[0].length && matrix[x][y+1] > -1000) ||
           (x > 0 && matrix[x-1][y] > -1000) ||
           (y > 0 && matrix[x][y-1] > -1000)) {
            return false;
        }
        
        return true;
    }
}