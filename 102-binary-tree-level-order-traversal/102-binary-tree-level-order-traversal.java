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
        while(!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> currList = new ArrayList<>();
            
            for(int i = 0; i < count; i++) {
                TreeNode treenode = queue.remove();
                currList.add(treenode.val);
                if(treenode.left != null) queue.add(treenode.left);
                if(treenode.right != null) queue.add(treenode.right);
            }
            result.add(currList);
        }
        return result;
    }
}