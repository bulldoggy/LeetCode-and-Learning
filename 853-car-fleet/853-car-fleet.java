class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();
        int[][] combined = new int[position.length][2];
         
        for(int i = 0; i < position.length; i++) {
            combined[i][0] = position[i];
            combined[i][1] = speed[i];
        }
        Arrays.sort(combined, Comparator.comparingInt(o -> o[0]));
        
        for(int i = combined.length-1; i >= 0; i--) {
            double time = (target - combined[i][0]) / (double)combined[i][1];

            if(stack.isEmpty() || time > stack.peek()) stack.push(time);
        }
        return stack.size();
    }
}