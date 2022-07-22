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
    public TreeNode invertTree(TreeNode root) {
        traverseDFS(root);
        return root;
    }
    
    public void traverseDFS(TreeNode curr) {
        if(curr == null) {
            return;
        }
        swapChild(curr);
        traverseDFS(curr.left);        
        traverseDFS(curr.right);
    }
    
    public void swapChild(TreeNode curr) {
        TreeNode temp = curr.left;
        curr.left = curr.right;
        curr.right = temp;
    }
}