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
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        boolean leafFound = false;
        int size = 0;
        int result = 0;
        
        if(root == null) return result;
        queue.add(root);
        while(!leafFound) {
            size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode treenode = queue.remove();
                if(treenode.left == null && treenode.right == null) leafFound = true;
                if(treenode.left != null) queue.add(treenode.left);
                if(treenode.right != null) queue.add(treenode.right);
            }
            result++;
        }
        return result;
    }
}