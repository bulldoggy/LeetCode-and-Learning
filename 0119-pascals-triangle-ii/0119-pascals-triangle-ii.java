class Solution {
    public List<Integer> getRow(int rowIndex) {
        LinkedList<Integer> result = new LinkedList<>();
        result.add(1);
        
        for(int i = 0; i < rowIndex; i++) {
            LinkedList<Integer> temp = new LinkedList<>();
            result.addFirst(0);
            result.addLast(0);
            
            for(int j = 1; j < result.size(); j++) {
                temp.add(result.get(j - 1) + result.get(j));
            }
            
            result = temp;
        }
        
        return result;
    }
}