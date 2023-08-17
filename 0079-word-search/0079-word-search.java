class Solution {
    boolean result = false;
    
    public boolean exist(char[][] board, String word) {
        Stack<Pair> stack = new Stack<>();
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    stack = new Stack<>();
                    stack.push(new Pair(i, j));
                    find(stack, board, word);
                    
                    if(result) {
                        return result;
                    }
                }
            }
        }
        
        return result;
        
    }
    
    private void find(Stack<Pair> stack, char[][] board, String word) {        
        if(stack.size() == word.length()) {
            result = true;
            return;
        }
        
        if(stack.size() > word.length()) {
            return;
        }
        
        
        Pair pair = stack.peek();
        int x = pair.x;
        int y = pair.y;
        int pos = stack.size();
        
        
        if(x - 1 >= 0) {
            Pair newPair = new Pair(x-1, y);
            
            if(board[x-1][y] == word.charAt(pos) && !stack.contains(newPair)) {
                stack.push(newPair);
                find(stack, board, word);
            }
        }
        
        if(x + 1 < board.length) {
            Pair newPair = new Pair(x+1, y);
            
            if(board[x+1][y] == word.charAt(pos) && !stack.contains(newPair)) {
                stack.push(newPair);
                find(stack, board, word);
            }
        }
        
        if(y - 1 >= 0) {
            Pair newPair = new Pair(x, y-1);
            
            if(board[x][y-1] == word.charAt(pos) && !stack.contains(newPair)) {
                stack.push(newPair);
                find(stack, board, word);
            }
        }
        
        if(y + 1 < board[0].length) {
            Pair newPair = new Pair(x, y+1);
            
            if(board[x][y+1] == word.charAt(pos) && !stack.contains(newPair)) {
                stack.push(newPair);
                find(stack, board, word);
            }
        }
        
        stack.pop();
    }
}

class Pair {
    int x;
    int y;
    
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public boolean equals(Object o) {
        Pair other = (Pair)o;
        
        if(this.x == other.x && this.y == other.y) {
            return true;
        }
        
        return false;
    }
}