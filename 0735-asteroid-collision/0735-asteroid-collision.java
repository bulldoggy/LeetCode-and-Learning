class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for(int a : asteroids) {
            if(a >= 0) {
                stack.push(a);
            } else {
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(a)) {
                    stack.pop();
                }
                
                if(stack.isEmpty() || stack.peek() < 0) {
                    stack.push(a);
                } else {
                    if(stack.peek() > 0 && stack.peek() == Math.abs(a)) {
                        stack.pop();
                    }
                }
            }
        }
        
        int[] result = new int[stack.size()];
        
        for(int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}