class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        LinkedList<String> result = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        
        for(List<String> ticket : tickets) {
            if(!graph.containsKey(ticket.get(0))) {
                graph.put(ticket.get(0), new PriorityQueue<>((a, b) -> a.compareTo(b)));
            }
            graph.get(ticket.get(0)).add(ticket.get(1));
        }

        stack.push("JFK");

        while(!stack.isEmpty()) {
            String nextDest = stack.peek();
            
            if(!graph.getOrDefault(nextDest, new PriorityQueue<>()).isEmpty()) {
                stack.push(graph.get(nextDest).poll());
            } else {
                result.addFirst(stack.pop());
            }
        }
        
        return result;
    }
}