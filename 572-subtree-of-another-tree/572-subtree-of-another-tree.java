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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root.val == subRoot.val) {
            if(isSameTree(root, subRoot)) return true;
        }
        boolean leftSub = root.left == null ? false : isSubtree(root.left, subRoot);
        boolean rightSub = root.right == null ? false : isSubtree(root.right, subRoot);
        return leftSub || rightSub;
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q) {      
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        if(p.val != q.val) {
            return false;
        }
        boolean leftSame = isSameTree(p.left, q.left);
        boolean rightSame = isSameTree(p.right, q.right);
        return leftSame && rightSame;
    }
}