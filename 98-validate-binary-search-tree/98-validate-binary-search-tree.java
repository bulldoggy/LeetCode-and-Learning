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
    public boolean isValidBST(TreeNode root) {
        return withinBoundary(root.left, Long.MIN_VALUE, (long)root.val) && withinBoundary(root.right, (long)root.val, Long.MAX_VALUE);
    }
    
    private boolean withinBoundary(TreeNode root, long min, long max) {
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return withinBoundary(root.left, min, root.val) && withinBoundary(root.right, root.val, max);
    }
}