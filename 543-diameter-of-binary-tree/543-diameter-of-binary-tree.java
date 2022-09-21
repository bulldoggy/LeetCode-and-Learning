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
    int maxDiameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int diameter = getDiameter(root);
        if(diameter > maxDiameter) maxDiameter = diameter;
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        
        return maxDiameter;
    }
    
    public int farthestLength(TreeNode root) {
        if(root == null) return -1;
        int maxLeft = 1 + farthestLength(root.left);
        int maxRight = 1 + farthestLength(root.right);
        return Math.max(maxLeft, maxRight);
    }
    
    public int getDiameter(TreeNode root) {
        return farthestLength(root.left) + farthestLength(root.right) + 2;
    }
}