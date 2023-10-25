/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if(root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 1;
        
        queue.offer(root);
        
        while(count > 0) {
            int max = Integer.MIN_VALUE;
            
            while(count > 0) {
                TreeNode curr = queue.poll();
                
                if(curr.left != null) {
                    queue.offer(curr.left);
                }
                
                if(curr.right != null) {
                    queue.offer(curr.right);
                }
                
                max = Math.max(max, curr.val);
                count--;
            }
            
            result.add(max);
            count = queue.size();
        }
        
        return result;
    }
}