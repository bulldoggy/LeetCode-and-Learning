class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> ast = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '*') {
                ast.push(i);
            } else if(s.charAt(i) == '(') {
                open.push(i);
            } else {
                if(!open.isEmpty()) {
                    open.pop();
                } else if(!ast.isEmpty()) {
                    ast.pop();
                } else {
                    return false;
                }
            }
        }
        
        while(!(open.isEmpty() || ast.isEmpty())) {
            if(open.pop() > ast.pop()) return false;
        }
        
        return open.isEmpty();
    }
}