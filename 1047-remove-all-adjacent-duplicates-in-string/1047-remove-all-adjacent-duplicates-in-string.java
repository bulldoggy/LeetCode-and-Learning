class Solution { 
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        String result = "";
        
        for(Character c : s.toCharArray()) {
            if(!stack.empty() && c.equals(stack.peek())) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        while(!stack.empty()) {
            result = stack.pop() + result;
        }
        return result;
    }
}