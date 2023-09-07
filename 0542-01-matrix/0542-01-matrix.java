class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<String> queue = new LinkedList<>();
        HashSet<String> hs = new HashSet<>();
        
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 0) {
                    String s = getStringPos(i, j);
                    queue.offer(s);
                    hs.add(s);
                }
            }
        }
        
        while(!queue.isEmpty()) {
            int[] arrPos = getIntArrPos(queue.poll());
            int x = arrPos[0];
            int y = arrPos[1];
            String up = getStringPos(x - 1, y);
            String down = getStringPos(x + 1, y);
            String left = getStringPos(x, y - 1);
            String right = getStringPos(x, y + 1);
            
            
            if(x > 0 && !hs.contains(up)) {
                mat[x - 1][y] = mat[x][y] + 1;
                queue.offer(up);
                hs.add(up);
            }
            if(x < mat.length - 1 && !hs.contains(down)) {
                mat[x + 1][y] = mat[x][y] + 1;
                queue.offer(down);
                hs.add(down);
            }
            if(y > 0 && !hs.contains(left)) {
                mat[x][y - 1] = mat[x][y] + 1;
                queue.offer(left);
                hs.add(left);
            }
            if(y < mat[0].length - 1 && !hs.contains(right)) {
                mat[x][y + 1] = mat[x][y] + 1;
                queue.offer(right);
                hs.add(right);
            }
        }
        
        return mat;
    }
    
    private String getStringPos(int x, int y) {
        return String.valueOf(x) + "|" + String.valueOf(y);
    }
    
    private int[] getIntArrPos(String s) {
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        boolean isSecond = false;
        for(char c : s.toCharArray()) {
            if(c == '|') {
                isSecond = true;
            } else if(isSecond) {
                second.append(c);
            } else {
                first.append(c);
            }
        }
        return new int[]{Integer.valueOf(first.toString()), Integer.valueOf(second.toString())};
    }
}

/*
0 1 2 2 3 4
1 2 2 1 2 3
2 2 1 0 1 2

*/