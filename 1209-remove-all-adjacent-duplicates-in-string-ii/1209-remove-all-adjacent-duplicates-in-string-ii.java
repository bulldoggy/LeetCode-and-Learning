class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        String result = "";
        
        for(int i = 0; i < s.length(); i++) {
            if(stack.empty() || !(s.charAt(i) == stack.peek().c)) {
                stack.push(new Pair(s.charAt(i), 1));
            } else {
                Pair currPair = stack.pop();
                currPair.count++;
                if(currPair.count < k) stack.push(currPair);
            }
        }
        
        while(!stack.empty()) {
            Pair p = stack.pop();
            for(int i = 0; i < p.count; i++) {
                result = p.c + result;
            }
        }
        
        return result;
    }
}

class Pair {
    Character c;
    int count;
    
    public Pair() {}
    
    public Pair(Character c, int count) {
        this.c = c;
        this.count = count;
    }
}