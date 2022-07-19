class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArr = s.toCharArray();
        
        for(char c : charArr) {
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if(stack.empty()) {
                    return false;
                }
                
                if(c == ')') {
                    if(stack.pop() != '(') return false;
                } else if(c == ']') {
                    if(stack.pop() != '[') return false;
                } else if(c == '}') {
                    if(stack.pop() != '{') return false;
                }
            }
        }
        
        return stack.empty() ? true : false;
    }
}