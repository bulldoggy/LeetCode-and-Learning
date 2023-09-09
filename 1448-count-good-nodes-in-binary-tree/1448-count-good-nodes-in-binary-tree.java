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
    public int goodNodes(TreeNode root) {
        return 1 + traverse(root.left, root.val) + traverse(root.right, root.val);
    }
    
    private int traverse(TreeNode root, int max) {
        if(root == null) {
            return 0;
        }
        
        if(root.val >= max) {
            return 1 + traverse(root.left, root.val) + traverse(root.right, root.val);
        }
        return traverse(root.left, max) + traverse(root.right, max);
    }
}