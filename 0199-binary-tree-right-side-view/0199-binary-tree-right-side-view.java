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
    public List<Integer> rightSideView(TreeNode root) {        
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 1;
        
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            TreeNode tn = queue.poll();
            count--;
            
            if(tn.left != null) {
                queue.offer(tn.left);
            }
            
            if(tn.right != null) {
                queue.offer(tn.right);
            }
            
            if(count == 0) {
                result.add(tn.val);
                count = queue.size();
            }
        }
        
        return result;
    }
}