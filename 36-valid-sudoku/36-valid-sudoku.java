class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> hsRow = new HashSet<>();
        HashSet<Character> hsCol = new HashSet<>();

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(hsRow.contains(board[i][j])) System.out.println("Row: " + i + ", " + j + "> " + hsRow.contains(board[i][j]));
                if(hsRow.contains(board[i][j])) return false;
                if(board[i][j] != '.') hsRow.add(board[i][j]);
            }
            
            for(int j = 0; j < 9; j++) {
                if(hsCol.contains(board[j][i])) System.out.println("Col: " + j + ", " + i + "> " + hsCol.contains(board[j][i]));
                if(hsCol.contains(board[j][i])) return false;
                if(board[j][i] != '.') hsCol.add(board[j][i]);
            }
            hsRow = new HashSet<>();
            hsCol = new HashSet<>();
        }
        
        for(int i = 0; i <= 6; i+=3) {
            for(int j = 0; j <= 6; j+=3) {
                if(!checkGrid(board, i, j)) return false;
            }
        }
        return true;
    }
    
    private boolean checkGrid(char[][] board, int row, int col) {
        HashSet<Character> hsGrid = new HashSet<>();
        
        for(int i = row; i < row+3; i++) {
            for(int j = col; j < col+3; j++) {
                if(hsGrid.contains(board[i][j])) System.out.println("Grid: " + i + ", " + j + "> " + hsGrid.contains(board[i][j]));
                if(hsGrid.contains(board[i][j])) return false;
                if(board[i][j] != '.') hsGrid.add(board[i][j]);
            }
        }
        return true;
    }
}