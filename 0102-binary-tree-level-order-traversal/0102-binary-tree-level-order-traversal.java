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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        queue.add(root);
         
        int rowCount = 0;
        List<Integer> list = null;
        while(!queue.isEmpty()) {
            rowCount = queue.size();
            list = new ArrayList<>();
            
            for(int i = 0; i < rowCount; i++) {
                TreeNode tn = queue.poll();
                list.add(tn.val);
                if(tn.left != null) queue.add(tn.left);
                if(tn.right != null) queue.add(tn.right);
            }
            
            result.add(list);
        }
        
        return result;
    }
}